package com.bms.order.archive.impl.list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import com.bms.order.archive.AbstractArchive;
import com.bms.order.archive.Completable;
import com.bms.order.archive.Createable;
import com.bms.order.archive.Deletable;
import com.bms.order.archive.Linkable;
import com.bms.order.archive.Modifiable;
import com.bms.order.archive.impl.BuyerSellerDetail;
import com.bms.order.bean.Blackboard;
import com.bms.order.constant.i18n.ErrorCode;
import com.bms.order.constant.i18n.ModuleCode;
import com.bms.order.bean.entity.BuyerSellerDetailEntity;
import com.bms.order.dao.BuyerSellerDetailDao;
import com.bms.order.util.LinkHelper;
import com.framework.exception.BusinessException;
import com.bms.order.archive.impl.BuyerBatchOrderDetail;
import com.bms.order.bean.entity.BuyerBatchOrderDetailEntity;

/**
 *
 * 记录买家订单明细的供货人及供货要求信息列表辅助类

 * @author li_huiqian

 */
public class BuyerSellerDetailList extends AbstractArchive implements Completable, Createable, Linkable, Modifiable, Deletable {

    private static Logger logger = LoggerFactory.getLogger(BuyerSellerDetailList.class);

    private static final String TABLE_NAME = "ORDR_BUYER_SELLER_DETAIL";

    /** 买家分批订单供货信息表Entity */
    private List<BuyerSellerDetailEntity> entities;


    /** 记录买家订单明细的供货人及供货要求信息列表辅助类 */
    private List<BuyerSellerDetail> archives;

    public List<BuyerSellerDetail> getArchives() {
        logger.info(this + "#getArchives");
        return archives;
    }

    /** 订单明细表，订单的原始信息，与客户提交的订单保持一致 */
    private List<BuyerBatchOrderDetail> buyerBatchOrderDetails;


    private List<Long> ids;


    /**
     * 构造函数
     *
     */
    @Deprecated
    public  BuyerSellerDetailList(Long[] ids) {
        logger.info(this + "#BuyerSellerDetailList");
        Assert.notEmpty(ids);
        this.ids = new ArrayList<>();
        for (Long id : ids)
            this.ids.add(id);
    }

    /**
     * 构造函数
     *
     */
    @Deprecated
    public  BuyerSellerDetailList(List<BuyerSellerDetailEntity> entities) {
        logger.info(this + "#BuyerSellerDetailList");
        Assert.notEmpty(entities);
        this.entities = entities;
        setDataSynced(false);
    }

    /**
     * 构造函数
     *
     */
    @Deprecated
    public  BuyerSellerDetailList(BuyerSellerDetail[] archives) {
        logger.info(this + "#BuyerSellerDetailList");
        Assert.notEmpty(archives);
        for (BuyerSellerDetail archive : archives) {
            Assert.notNull(archive.getEntity());
        }

        this.archives = new ArrayList<>();
        this.entities = new ArrayList<>();
        for (BuyerSellerDetail archive : archives) {
            this.archives.add(archive);
            this.entities.add(archive.getEntity());
        }

        setDataSynced(false);
    }

    /**
     * 构造函数
     *
     */
    @Deprecated
    public  BuyerSellerDetailList(BuyerBatchOrderDetail linkedArchive) {
        logger.info(this + "#BuyerSellerDetailList");
        Assert.notNull(linkedArchive);
        Assert.notNull(linkedArchive.getEntity());
        Assert.notNull(linkedArchive.getEntity().getBuyerBatchOrderDetailId());
        this.buyerBatchOrderDetails = new ArrayList<>();
        this.buyerBatchOrderDetails.add(linkedArchive);
    }

    /**
     * 构造函数
     *
     */
    @Deprecated
    public  BuyerSellerDetailList(BuyerBatchOrderDetail[] linkedArchives) {
        logger.info(this + "#BuyerSellerDetailList");
        Assert.notEmpty(linkedArchives);
        this.buyerBatchOrderDetails = new ArrayList<>();
        for (BuyerBatchOrderDetail linkedArchive : linkedArchives) {
            Assert.notNull(linkedArchive.getEntity());
            Assert.notNull(linkedArchive.getEntity().getBuyerBatchOrderDetailId());
            this.buyerBatchOrderDetails.add(linkedArchive);
        }
    }


    @Override
    public void link(Linkable target) {
        logger.info(this + "#link");
        if (target == null)
            return;

        if (target instanceof BuyerBatchOrderDetail) {
            LinkHelper.link(this.archives, target, "entity.buyerBatchOrderDetailId");
        
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

        if (item0 instanceof BuyerBatchOrderDetail) {
            LinkHelper.link(this.archives, targets, "entity.buyerBatchOrderDetailId");
        
        }
    }

    @Override
    public void complete(boolean allowDelete) {
        logger.info(this + "#complete");
        Map<String, Object> map = new HashMap<>();

        if (ids != null && ids.size() != 0)
            map.put("ids", ids);
        else if (buyerBatchOrderDetails != null && buyerBatchOrderDetails.size() != 0)
            map.put("buyerBatchOrderDetails", buyerBatchOrderDetails);
        // 设置允许DEL_FLG=true
        if (allowDelete)
            map.put("delFlg", true);
        else
            map.put("delFlg", false);

        // 查询数据库
        BuyerSellerDetailDao dao = getDao(BuyerSellerDetailDao.class);
        List<BuyerSellerDetailEntity> entities = dao.findAll(map);
        if (entities == null || entities.isEmpty())
            return;

        for (BuyerSellerDetailEntity entity : entities) {
            BuyerSellerDetail archive = BuyerSellerDetail.build(getBlackboard()).forCreate(entity);
            archive.setDataSynced(true);

            if (archives == null)
                archives = new ArrayList<>();
            archives.add(archive);
        }

        setDataSynced(true);

    }

    @Override
    public void create() {
        logger.info(this + "#create");
        Assert.notEmpty(entities);

        // 获取Dao
        BuyerSellerDetailDao dao = getDao(BuyerSellerDetailDao.class);

        // 一意制约检测

        // 获取ID
        Long id = getBlackboard().maxId(TABLE_NAME, entities.size());
        // 设置ID
        for (int i = 0; i < entities.size(); i++) {
            BuyerSellerDetailEntity entity = entities.get(i);
            entity.setSellerDetailId(id);
            id += 1;
        }

        // 设置待插入字段
        // TODO 对entity中待插入字段进行补全

        // 设置共通字段
        for (int i = 0; i < entities.size(); i++) {
            BuyerSellerDetailEntity entity = entities.get(i);
            insertCommon(entity);
        }

        // 插入数据库
        int count = dao.batchSave(entities);
        if (count != entities.size())
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000005);

        setDataSynced(true);

    }


    @Override
    public void modify() {
        logger.info(this + "#modify");
        Assert.notEmpty(entities);

        // 获取Dao
        BuyerSellerDetailDao dao = getDao(BuyerSellerDetailDao.class);

        // 设置待修改字段
        // TODO 对entity中待插入字段进行补全

        // 设置共通字段
        for (int i = 0; i < entities.size(); i++) {
            BuyerSellerDetailEntity entity = entities.get(i);
            updateCommon(entity);
        }

        // 更新数据库带排他检测
        int count = dao.batchModify(entities);
        if (count != 1)
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000007);

    }

    @Override
    public void delete() {
        logger.info(this + "#delete");
        Assert.notEmpty(entities);

        // 获取Dao
        BuyerSellerDetailDao dao = getDao(BuyerSellerDetailDao.class);

        // 设置共通字段
        for (int i = 0; i < entities.size(); i++) {
            BuyerSellerDetailEntity entity = entities.get(i);
            deleteCommon(entity);
        }

        // 更新数据库带排他检测
        int count = dao.batchDelete(entities);
        if (count != 1)
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000009);

    }


    @Override
    public String toString() {
        return this.getClass().getName();
    }

    @Override
    public void setDataSynced(boolean dataSynced) {
        logger.info(this + "#setDataSynced");
        if (archives != null)
            for (BuyerSellerDetail archive : archives)
                archive.setDataSynced(dataSynced);
        super.setDataSynced(dataSynced);
    }

    public static Builder build(Blackboard blackboard) {
        return new Builder(blackboard);
    }

    public static class Builder{

    private Blackboard blackboard;

    public  Builder(Blackboard blackboard) {
        logger.info(this + "#Builder");
        this.blackboard = blackboard;
    }

    /**
     * 创建对象列表，用于根据id查询数据，此对象列表必须使用complete方法补全
     *
     */
    public BuyerSellerDetailList forComplete(Long[] ids) {
        logger.info(this + "#forComplete");
        BuyerSellerDetailList build = new BuyerSellerDetailList(ids);
        build.setBlackboard(blackboard);
        return build;
    }

    /**
     * 创建对象列表，用于插入数据库，此对象列表必须使用create方法插入数据库
     *
     */
    public BuyerSellerDetailList forCreate(BuyerSellerDetail[] archives) {
        logger.info(this + "#forCreate");
        BuyerSellerDetailList build = new BuyerSellerDetailList(archives);
        build.setBlackboard(blackboard);

        return build;
    }

    /**
     * 创建对象列表，用于修改/删除数据，此对象列表必须使用modify/delete方法
     *
     */
    public BuyerSellerDetailList forUpdate(BuyerSellerDetail[] archives) {
        logger.info(this + "#forUpdate");
        BuyerSellerDetailList build = new BuyerSellerDetailList(archives);
        build.setBlackboard(blackboard);
        build.setDataSynced(true);

        return build;
    }

    /**
     * 创建对象，用于根据entity.buyerBatchOrderDetailId查询数据，此对象必须使用complete方法补全
     *
     */
    public BuyerSellerDetailList forComplete(BuyerBatchOrderDetail linkedArchive) {
        logger.info(this + "#forComplete");
        BuyerSellerDetailList build = new BuyerSellerDetailList(linkedArchive);
        build.setBlackboard(blackboard);
        return build;
    }

    }


}