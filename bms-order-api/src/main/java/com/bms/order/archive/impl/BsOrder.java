package com.bms.order.archive.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import com.bms.order.archive.AbstractArchive;
import com.bms.order.archive.Codeable;
import com.bms.order.archive.Completable;
import com.bms.order.archive.Createable;
import com.bms.order.archive.Deletable;
import com.bms.order.archive.Linkable;
import com.bms.order.archive.Modifiable;
import com.bms.order.archive.impl.list.BsOrderDetailList;
import com.bms.order.bean.Blackboard;
import com.bms.order.bean.entity.BsOrderAttachedEntity;
import com.bms.order.bean.entity.BsOrderAttachedHistoryEntity;
import com.bms.order.bean.entity.BsOrderEntity;
import com.bms.order.bean.entity.BsOrderHistoryEntity;
import com.bms.order.constant.enumeration.PriceReturnType;
import com.bms.order.constant.enumeration.PriceUserType;
import com.bms.order.constant.i18n.ErrorCode;
import com.bms.order.constant.i18n.ModuleCode;
import com.bms.order.dao.BsOrderAttachedDao;
import com.bms.order.dao.BsOrderDao;
import com.bms.order.external.archive.Price;
import com.bms.order.external.bean.entity.PriceEntity;
import com.bms.order.external.bean.param.PriceRestParam;
import com.bms.order.util.CodeRule;
import com.bms.order.util.LinkHelper;
import com.framework.core.utils.DecimalUtils;
import com.framework.exception.BusinessException;

/**
 * 买手订单主表
 *
 * @author li_huiqian
 */
public class BsOrder extends AbstractArchive
        implements Completable, Createable, Linkable, Modifiable, Deletable, Codeable {

    private static Logger logger = LoggerFactory.getLogger(BsOrder.class);

    private static final String TABLE_NAME = "ORDR_BS_ORDER";
    private static final String HISTORY_TABLE_NAME = "ORDR_BS_ORDER_HISTORY";

    /**
     * 买手订单Entity
     */
    private BsOrderEntity entity;

    public BsOrderEntity getEntity() {
        logger.info(this + "#getEntity");
        return entity;
    }

    /**
     * 买手订单附表Entity
     */
    /**
     * 买手订单履历表Entity
     */
    private BsOrderHistoryEntity historyEntity;

    public BsOrderHistoryEntity getHistoryEntity() {
        logger.info(this + "#getHistoryEntity");
        return historyEntity;
    }

    /**
     * 买手订单附表Entity
     */
    private BsOrderAttachedEntity attachedEntity;

    public BsOrderAttachedEntity getAttachedEntity() {
        logger.info(this + "#getAttachedEntity");
        return attachedEntity;
    }

    /**
     * 买手订单明细
     */
    /**
     * 买手订单附表履历表Entity
     */
    private BsOrderAttachedHistoryEntity attachedHistoryEntity;

    public BsOrderAttachedHistoryEntity getAttachedHistoryEntity() {
        logger.info(this + "#getAttachedHistoryEntity");
        return attachedHistoryEntity;
    }

    /**
     * 买手订单明细
     */
    private List<BsOrderDetail> bsOrderDetails;

    private boolean isBsOrderDetailsComplete = false;

    /**
     * 关联完毕后调用
     */
    public void bsOrderDetailsLinked() {
        logger.info(this + "#bsOrderDetailsLinked");
        isBsOrderDetailsComplete = true;
    }

    /**
     * 重新取数据时用
     */
    public void bsOrderDetailsUnlink() {
        logger.info(this + "#bsOrderDetailsUnlink");
        isBsOrderDetailsComplete = false;
    }

    public List<BsOrderDetail> getBsOrderDetails() {
        logger.info(this + "#getBsOrderDetails");
        if (!isDataSynced())
            return bsOrderDetails;

        if (bsOrderDetails == null || !isBsOrderDetailsComplete) {
            BsOrderDetailList list = new BsOrderDetailList(this);
            list.setBlackboard(getBlackboard());
            list.complete(false);
            isBsOrderDetailsComplete = true;
            bsOrderDetails = null;
            if (list.isDataSynced()) {
                link(list.getArchives());
                for (BsOrderDetail item : bsOrderDetails)
                    item.bsOrderLinked();
            }
        }

        return bsOrderDetails;
    }

    /**
     * 构造函数，已过时，请使用BsOrder.build(blackboard).forComplete(id)
     */
    public BsOrder(Long id) {
        logger.info(this + "#BsOrder");
        Assert.notNull(id);
        entity = new BsOrderEntity();
        entity.setBsOrderId(id);
    }

    /**
     * 构造函数，已过时，请使用BsOrder.build(blackboard).forComplete(code)
     */
    public BsOrder(String code) {
        logger.info(this + "#BsOrder");
        Assert.notNull(code);
        entity = new BsOrderEntity();
        entity.setBsOrderCode(code);
    }

    /**
     * 构造函数，已过时，请使用BsOrder.build(blackboard).forCreate(entity,,BsOrderAttachedEntity)
     */
    public BsOrder(BsOrderEntity entity, BsOrderAttachedEntity attachedEntity) {
        logger.info(this + "#BsOrder");
        Assert.notNull(entity);
        Assert.notNull(attachedEntity);
        this.entity = entity;
        this.attachedEntity = attachedEntity;
        setDataSynced(false);
    }

    @Override
    public void link(Linkable target) {
        logger.info(this + "#link");
        if (target == null)
            return;

        if (target instanceof BsOrderDetail) {
            LinkHelper.link(this, target, "entity.bsOrderId");

        }
    }

    @Override
    public void link(List<?> targets) {
        logger.info(this + "#link");
        if (targets == null || targets.size() == 0)
            return;

        Object obj0 = targets.get(0);
        if (!(obj0 instanceof Linkable))
            return;
        Linkable item0 = (Linkable) obj0;

        if (item0 instanceof BsOrderDetail) {
            LinkHelper.link(this, targets, "entity.bsOrderId");

        }
    }

    @Override
    public void complete(boolean allowDelete) {
        logger.info(this + "#complete");
        // 判断是否是最新
        if (isDataSynced()) {
            return;
        }

        if (entity.getBsOrderId() != null) {
            BsOrderEntity entity = new BsOrderEntity();
            entity.setBsOrderId(this.entity.getBsOrderId());
            this.entity = entity;
        } else if (entity.getBsOrderCode() != null) {
            BsOrderEntity entity = new BsOrderEntity();
            entity.setBsOrderCode(this.entity.getBsOrderCode());
            this.entity = entity;
        } else if(entity.getBackNo() != null){
            BsOrderEntity entity = new BsOrderEntity();
            entity.setBackNo(this.entity.getBackNo());
            this.entity = entity;
        }

        // 设置允许DEL_FLG=true
        if (allowDelete)
            this.entity.setDelFlg(true);
        else
            this.entity.setDelFlg(false);

        // 查询数据库
        BsOrderDao dao = getDao(BsOrderDao.class);
        BsOrderEntity entity = dao.findOne(this.entity);
        if (entity == null)
            return;
        this.entity = entity;

        BsOrderAttachedDao attachedDao = getDao(BsOrderAttachedDao.class);
        BsOrderAttachedEntity attachedEntity = attachedDao.findOne(this.entity);
        if (attachedEntity == null)
            return;
        this.attachedEntity = attachedEntity;

        setDataSynced(true);

        // 设置历史数据
        setHistory();
    }

    @Override
    public void create() {
        logger.info(this + "#create");
        Assert.notNull(entity);
        Assert.notNull(attachedEntity);

        // 判断是否需要创建
        if (isDataSynced())
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000003);

        // 获取Dao
        BsOrderDao dao = getDao(BsOrderDao.class);
        BsOrderAttachedDao attachedDao = getDao(BsOrderAttachedDao.class);

        // 设置编码
        generateCode();

        // 一意制约检测
        BsOrder unique = new BsOrder(entity.getBsOrderCode());
        unique.setBlackboard(getBlackboard());
        unique.complete(false);
        if (unique.isDataSynced())
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000004);
        // 获取ID
        Long id = getBlackboard().maxId(TABLE_NAME);
        // 设置ID
        this.entity.setBsOrderId(id);
        this.attachedEntity.setBsOrderId(id);

        // 设置共通字段
        insertCommon(this.entity);
        insertCommon(this.attachedEntity);

        // 插入数据库
        int count = dao.save(this.entity);
        if (count != 1)
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000005);
        count = attachedDao.save(this.attachedEntity);
        if (count != 1)
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000005);

        setDataSynced(true);

        // 设置历史数据
        setHistory();
    }

    /**
     * 为以此时的entity建立历史Entity，此时的数据必须从数据库查出来，这一步不插入数据库
     */
    public void setHistory() {
        logger.info(this + "#setHistory");
        Assert.isTrue(isDataSynced(), "must create or complete before set history.");
        Assert.notNull(entity);
        Assert.notNull(attachedEntity);
        historyEntity = new BsOrderHistoryEntity(entity);
        attachedHistoryEntity = new BsOrderAttachedHistoryEntity(attachedEntity);
    }

    @Override
    public void modify() {
        logger.info(this + "#modify");
        Assert.notNull(entity);
        Assert.notNull(attachedEntity);

        // 判断是否需要修改
        if (!isDataSynced())
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000006);

        // 获取Dao
        BsOrderDao dao = getDao(BsOrderDao.class);
        BsOrderAttachedDao attachedDao = getDao(BsOrderAttachedDao.class);

        // 设置待修改字段

        // 设置共通字段
        updateCommon(this.entity);
        updateCommon(this.attachedEntity);

        // 更新数据库带排他检测
        int count = dao.modify(this.entity);
        if (count != 1)
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000007);
        count = attachedDao.modify(this.attachedEntity);
        if (count != 1)
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000007);

        // 插入历史数据
        saveHistory();
        // 设置历史数据
        setHistory();
    }

    @Override
    public void delete() {
        logger.info(this + "#delete");
        Assert.notNull(entity);
        Assert.notNull(attachedEntity);

        // 判断是否需要删除
        if (!isDataSynced())
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000008);

        // 获取Dao
        BsOrderDao dao = getDao(BsOrderDao.class);
        BsOrderAttachedDao attachedDao = getDao(BsOrderAttachedDao.class);

        // 设置共通字段
        deleteCommon(this.entity);
        deleteCommon(this.attachedEntity);

        // 删除数据库带排他检测
        int count = dao.delete(this.entity);
        if (count != 1)
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000009);
        count = attachedDao.modify(this.attachedEntity);
        if (count != 1)
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000009);

        // 插入历史数据
        saveHistory();
        // 设置历史数据
        setHistory();
    }

    /**
     * 保存历史数据，在修改或删除之后调用
     */
    private void saveHistory() {
        logger.info(this + "#saveHistory");
        Assert.notNull(historyEntity, "no history entity found.");
        Assert.notNull(attachedHistoryEntity, "no attached history entity found.");
        // 获取Dao
        BsOrderDao dao = getDao(BsOrderDao.class);
        BsOrderAttachedDao attachedDao = getDao(BsOrderAttachedDao.class);

        // 获取Id
        Long historyId = getBlackboard().maxId(HISTORY_TABLE_NAME);
        historyEntity.setHistoryId(historyId);
        int count = dao.saveHistory(historyEntity);
        if (count != 1)
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000010);
        attachedHistoryEntity.setHistoryId(historyId);
        count = attachedDao.saveHistory(attachedHistoryEntity);
        if (count != 1)
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000010);
    }

    @Override
    public String toString() {
        if (entity != null)
            return this.getClass().getName() + this.entity.getBsOrderId();
        else
            return this.getClass().getName();
    }

    public static Builder build(Blackboard blackboard) {
        return new Builder(blackboard);
    }

    public static class Builder {

        private Blackboard blackboard;

        public Builder(Blackboard blackboard) {
            logger.info(this + "#Builder");
            this.blackboard = blackboard;
        }

        /**
         * 创建对象，用于根据id查询数据，此对象必须使用complete方法补全
         */
        public BsOrder forComplete(Long id) {
            logger.info(this + "#forComplete");
            BsOrder build = new BsOrder(id);
            build.setBlackboard(blackboard);
            return build;
        }

        /**
         * 创建对象，用于根据code查询数据，此对象必须使用complete方法补全
         */
        public BsOrder forComplete(String code) {
            logger.info(this + "#forComplete");
            BsOrder build = new BsOrder(code);
            build.setBlackboard(blackboard);
            return build;
        }


        /**
         * 创建对象，用于插入数据库，此对象必须使用create方法插入数据库
         */
        public BsOrder forCreate(BsOrderEntity entity, BsOrderAttachedEntity attachedEntity) {
            logger.info(this + "#forCreate");
            BsOrder build = new BsOrder(entity, attachedEntity);
            build.setBlackboard(blackboard);
            return build;
        }

    }

    /**
     * 生成买手订单编码
     *
     * @return
     */
    @Override
    public void generateCode() {
        // 买手编码主码
        String bsCode = attachedEntity.getBsCode();
        entity.setBsOrderCode(CodeRule.orderRule("MSDD", bsCode));
    }

    /**
     * 更新所有商品价格信息
     */
    public void updateGoodsPrice() {
        List<BsOrderDetail> details = this.getBsOrderDetails();

        // 调用获取单价
        String lgcsAreaCode = this.getAttachedEntity().getLogisticsZoneCode();

        // 按照商品集计商品数量
        Map<String, PriceRestParam> goodsQtyMap = new HashMap<>();
        ArrayList<PriceRestParam> paramList = new ArrayList<>();
        for (BsOrderDetail detail : details) {

            if (goodsQtyMap.containsKey(detail.getEntity().getGoodsId())) {
                PriceRestParam param = goodsQtyMap.get(detail.getEntity().getGoodsId());
                // 下单数量-取消数量
                BigDecimal goodsQty = DecimalUtils.subtract(detail.getEntity().getGoodsQuantity(),
                        detail.getEntity().getCancelQuantity());
                BigDecimal qty = DecimalUtils.add(param.getQty(), goodsQty);
                param.setQty(qty);
            } else {
                PriceRestParam param = new PriceRestParam();
                // 区域
                param.setLgcsAreaCode(lgcsAreaCode);
                // 商品ID
                param.setGoodId(detail.getEntity().getGoodsId());
                param.setUserType(PriceUserType.BS_USER.getCode());
                param.setCompareTimeOne(detail.getEntity().getPriceCreateTime());
                // 下单数量-取消数量
                BigDecimal goodsQty = DecimalUtils.subtract(detail.getEntity().getGoodsQuantity(),
                        detail.getEntity().getCancelQuantity());
                // 数量
                param.setQty(goodsQty);
                // 返回类型
                param.setReturnType(PriceReturnType.ALL_PRICE.getCode());
                goodsQtyMap.put(detail.getEntity().getGoodsId(), param);
                paramList.add(param);
            }
        }

        List<PriceEntity> priceList = Price.queryPricePlate(paramList);
        Map<String, PriceEntity> goodsPriceMap = new HashMap<>();
        if (null != priceList && priceList.size() > 0) {
            for (PriceEntity priceEntity : priceList) {
                goodsPriceMap.put(priceEntity.getGoodId(), priceEntity);
            }
        }

        for (BsOrderDetail detail : details) {
            if (goodsPriceMap.get(detail.getEntity().getGoodsId()) == null) {
                throw new BusinessException(ModuleCode.ORDR, ErrorCode.E060109, detail.getEntity().getGoodsId());
            }
            BigDecimal unitPrice = goodsPriceMap.get(detail.getEntity().getGoodsId()).getUnitPrice();
            detail.getEntity().setRealUnitPrice(unitPrice);
            BigDecimal kgPrice = goodsPriceMap.get(detail.getEntity().getGoodsId()).getPrice();
            detail.getEntity().setRealKgPrice(kgPrice);
            String priceWay = goodsPriceMap.get(detail.getEntity().getGoodsId()).getWayDesc();
            detail.getEntity().setPriceWay(priceWay);
        }
    }

    /**
     * 计算订单金额（不更新字段）
     *
     * @return
     */
    public BigDecimal calculateOrderAmount() {
        BigDecimal orderAmount = BigDecimal.ZERO;
        List<BsOrderDetail> details = this.getBsOrderDetails();
        if (details != null && details.size() != 0) {
            for (BsOrderDetail detail : details) {
                orderAmount = DecimalUtils.add(orderAmount, DecimalUtils.multiply(detail.getEntity().getGoodsQuantity(),
                        detail.getEntity().getRealUnitPrice()));
            }
        }
        return orderAmount;
    }

}