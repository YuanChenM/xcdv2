package com.bms.order.archive.impl;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import com.bms.order.archive.AbstractArchive;
import com.bms.order.archive.Completable;
import com.bms.order.archive.Createable;
import com.bms.order.archive.Deletable;
import com.bms.order.archive.Linkable;
import com.bms.order.archive.Modifiable;
import com.bms.order.bean.Blackboard;
import com.bms.order.constant.i18n.ErrorCode;
import com.bms.order.constant.i18n.ModuleCode;
import com.bms.order.bean.entity.ReturnReasonEntity;
import com.bms.order.dao.ReturnReasonDao;
import com.bms.order.util.LinkHelper;
import com.framework.exception.BusinessException;
import com.bms.order.archive.impl.BuyerReturnDetail;

/**
 *
 * 退货原因表

 * @author li_huiqian

 */
public class ReturnReason extends AbstractArchive implements Completable, Createable, Linkable, Modifiable, Deletable {

    private static Logger logger = LoggerFactory.getLogger(ReturnReason.class);

    private static final String TABLE_NAME = "ORDR_RETURN_REASON";

    /** 退货原因信息表Entity */
    private ReturnReasonEntity entity;

    public ReturnReasonEntity getEntity() {
        logger.info(this + "#getEntity");
        return entity;
    }


    /** 买家退货订单明细信息 */
    private BuyerReturnDetail buyerReturnDetail;

    private boolean isBuyerReturnDetailComplete = false;

    /**
     * 关联完毕后调用
     *
     */
    public void buyerReturnDetailLinked() {
        logger.info(this + "#buyerReturnDetailLinked");
        isBuyerReturnDetailComplete = true;
    }

    /**
     * 重新取数据时用
     *
     */
    public void buyerReturnDetailUnlink() {
        logger.info(this + "#buyerReturnDetailUnlink");
        isBuyerReturnDetailComplete = false;
    }

    public BuyerReturnDetail getBuyerReturnDetail() {
        logger.info(this + "#getBuyerReturnDetail");
        if (!isDataSynced())
            return buyerReturnDetail;

        if (buyerReturnDetail == null || !isBuyerReturnDetailComplete) {
            BuyerReturnDetail buyerReturnDetail = new BuyerReturnDetail(this);
            buyerReturnDetail.setBlackboard(getBlackboard());
            buyerReturnDetail.complete(false);
            isBuyerReturnDetailComplete = true;
            this.buyerReturnDetail = null;
            if(buyerReturnDetail.isDataSynced())
                link(buyerReturnDetail);
            buyerReturnDetail.returnReasonLinked();
        }

        return buyerReturnDetail;
    }
    /** 买手退货明细表 */
    private BsReturnDetail bsReturnDetail;

    private boolean isBsReturnDetailComplete = false;

    /**
     * 关联完毕后调用
     *
     */
    public void bsReturnDetailLinked() {
        logger.info(this + "#bsReturnDetailLinked");
        isBsReturnDetailComplete = true;
    }

    /**
     * 重新取数据时用
     *
     */
    public void bsReturnDetailUnlink() {
        logger.info(this + "#bsReturnDetailUnlink");
        isBsReturnDetailComplete = false;
    }

    public BsReturnDetail getBsReturnDetail() {
        logger.info(this + "#getBsReturnDetail");
        if (!isDataSynced())
            return bsReturnDetail;

        if (bsReturnDetail == null || !isBsReturnDetailComplete) {
            BsReturnDetail bsReturnDetail = new BsReturnDetail(this);
            bsReturnDetail.setBlackboard(getBlackboard());
            bsReturnDetail.complete(false);
            isBsReturnDetailComplete = true;
            this.bsReturnDetail = null;
            if(bsReturnDetail.isDataSynced())
                link(bsReturnDetail);
            bsReturnDetail.returnReasonLinked();
        }

        return bsReturnDetail;
    }

    /**
     * 构造函数，已过时，请使用ReturnReason.build(blackboard).forComplete(id)
     *
     */
    
    public  ReturnReason(Long id) {
        logger.info(this + "#ReturnReason");
        Assert.notNull(id);
        entity = new ReturnReasonEntity();
        entity.setReasonId(id);
    }

    /**
     * 构造函数，已过时，请使用ReturnReason.build(blackboard).forCreate(entity,)
     *
     */
    
    public  ReturnReason(ReturnReasonEntity entity) {
        logger.info(this + "#ReturnReason");
        Assert.notNull(entity);
        this.entity = entity;
        setDataSynced(false);
    }


    @Override
    public void link(Linkable target) {
        logger.info(this + "#link");
        if (target == null)
            return;

        if (target instanceof BuyerReturnDetail) {
            LinkHelper.link(this, target, "entity.reasonId");
        
        } else if (target instanceof BsReturnDetail) {
            LinkHelper.link(this, target, "entity.reasonId");
        
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

        if (item0 instanceof BuyerReturnDetail) {
            LinkHelper.link(this, targets, "entity.reasonId");
        
        } else if (item0 instanceof BsReturnDetail) {
            LinkHelper.link(this, targets, "entity.reasonId");
        
        }
    }

    @Override
    public void complete(boolean allowDelete) {
        logger.info(this + "#complete");
        // 判断是否是最新
        if (isDataSynced()) {
            return;
        }

        if (entity.getReasonId() != null) {
            ReturnReasonEntity entity = new ReturnReasonEntity();
            entity.setReasonId(this.entity.getReasonId());
            this.entity = entity;
        }

        // 设置允许DEL_FLG=true
        if (allowDelete)
            this.entity.setDelFlg(true);
        else
            this.entity.setDelFlg(false);

        // 查询数据库
        ReturnReasonDao dao = getDao(ReturnReasonDao.class);
        ReturnReasonEntity entity = dao.findOne(this.entity);
        if (entity == null)
            return;
        this.entity = entity;

        setDataSynced(true);

    }

    @Override
    public void create() {
        logger.info(this + "#create");
        Assert.notNull(entity);

        // 判断是否需要创建
        if (isDataSynced())
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000003);

        // 获取Dao
        ReturnReasonDao dao = getDao(ReturnReasonDao.class);

        // 一意制约检测
        // 获取ID
        Long id = getBlackboard().maxId(TABLE_NAME);
        // 设置ID
        this.entity.setReasonId(id);

        // 设置共通字段
        insertCommon(this.entity);

        // 插入数据库
        int count = dao.save(this.entity);
        if (count != 1)
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000005);

        setDataSynced(true);

    }


    @Override
    public void modify() {
        logger.info(this + "#modify");
        Assert.notNull(entity);

        // 判断是否需要修改
        if (!isDataSynced())
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000006);

        // 获取Dao
        ReturnReasonDao dao = getDao(ReturnReasonDao.class);

        // 设置共通字段
        updateCommon(this.entity);

        // 更新数据库带排他检测
        int count = dao.modify(this.entity);
        if (count != 1)
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000007);

    }

    @Override
    public void delete() {
        logger.info(this + "#delete");
        Assert.notNull(entity);

        // 判断是否需要删除
        if (!isDataSynced())
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000008);

        // 获取Dao
        ReturnReasonDao dao = getDao(ReturnReasonDao.class);

        // 设置共通字段
        deleteCommon(this.entity);

        // 删除数据库带排他检测
        int count = dao.delete(this.entity);
        if (count != 1)
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000009);

    }


    @Override
    public String toString() {
        if (entity != null)
            return this.getClass().getName() + this.entity.getReasonId();
        else
            return this.getClass().getName();
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
     * 创建对象，用于根据id查询数据，此对象必须使用complete方法补全
     *
     */
    public ReturnReason forComplete(Long id) {
        logger.info(this + "#forComplete");
        ReturnReason build = new ReturnReason(id);
        build.setBlackboard(blackboard);
        return build;
    }

    /**
     * 创建对象，用于插入数据库，此对象必须使用create方法插入数据库
     *
     */
    public ReturnReason forCreate(ReturnReasonEntity entity) {
        logger.info(this + "#forCreate");
        ReturnReason build = new ReturnReason(entity);
        build.setBlackboard(blackboard);
        return build;
    }

    }


}