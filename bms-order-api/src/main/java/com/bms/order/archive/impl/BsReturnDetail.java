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
import com.bms.order.bean.entity.BsReturnDetailEntity;
import com.bms.order.constant.i18n.ErrorCode;
import com.bms.order.constant.i18n.ModuleCode;
import com.bms.order.dao.BsReturnDetailDao;
import com.bms.order.util.LinkHelper;
import com.framework.exception.BusinessException;

/**
 *
 * 买手退货明细表

 * @author li_huiqian

 */
public class BsReturnDetail extends AbstractArchive implements Completable, Createable, Linkable, Modifiable, Deletable {

    private static Logger logger = LoggerFactory.getLogger(BsReturnDetail.class);

    private static final String TABLE_NAME = "ORDR_BS_RETURN_DETAIL";

    /** 买手退货明细表Entity */
    private BsReturnDetailEntity entity;

    public BsReturnDetailEntity getEntity() {
        logger.info(this + "#getEntity");
        return entity;
    }


    /** 退货原因表 */
    private ReturnReason returnReason;

    private boolean isReturnReasonComplete = false;

    /**
     * 关联完毕后调用
     *
     */
    public void returnReasonLinked() {
        logger.info(this + "#returnReasonLinked");
        isReturnReasonComplete = true;
    }

    /**
     * 重新取数据时用
     *
     */
    public void returnReasonUnlink() {
        logger.info(this + "#returnReasonUnlink");
        isReturnReasonComplete = false;
    }

    public ReturnReason getReturnReason() {
        logger.info(this + "#getReturnReason");
        if (!isDataSynced())
            return returnReason;

        if (returnReason == null || !isReturnReasonComplete) {
            ReturnReason returnReason = new ReturnReason(entity.getReasonId());
            returnReason.setBlackboard(getBlackboard());
            returnReason.complete(false);
            isReturnReasonComplete = true;
            this.returnReason = null;
            if(returnReason.isDataSynced())
                link(returnReason);
            returnReason.bsReturnDetailLinked();
        }

        return returnReason;
    }
    /** 买手退货主表 */
    private BsReturn bsReturn;

    private boolean isBsReturnComplete = false;

    /**
     * 关联完毕后调用
     *
     */
    public void bsReturnLinked() {
        logger.info(this + "#bsReturnLinked");
        isBsReturnComplete = true;
    }

    /**
     * 重新取数据时用
     *
     */
    public void bsReturnUnlink() {
        logger.info(this + "#bsReturnUnlink");
        isBsReturnComplete = false;
    }

    public BsReturn getBsReturn() {
        logger.info(this + "#getBsReturn");
        if (!isDataSynced())
            return bsReturn;

        if (bsReturn == null || !isBsReturnComplete) {
            BsReturn bsReturn = new BsReturn(entity.getReturnId());
            bsReturn.setBlackboard(getBlackboard());
            bsReturn.complete(false);
            isBsReturnComplete = true;
            this.bsReturn = null;
            if(bsReturn.isDataSynced())
                link(bsReturn);
        }

        return bsReturn;
    }

    /**
     * 构造函数，已过时，请使用BsReturnDetail.build(blackboard).forComplete(id)
     *
     */
    public  BsReturnDetail(Long id) {
        logger.info(this + "#BsReturnDetail");
        Assert.notNull(id);
        entity = new BsReturnDetailEntity();
        entity.setDetailId(id);
    }

    /**
     * 构造函数，已过时，请使用BsReturnDetail.build(blackboard).forCreate(entity,)
     *
     */
    public  BsReturnDetail(BsReturnDetailEntity entity) {
        logger.info(this + "#BsReturnDetail");
        Assert.notNull(entity);
        this.entity = entity;
        setDataSynced(false);
    }

    /**
     * 构造函数，已过时，请使用BsReturnDetail.build(blackboard).forComplete(linkedArchive)
     *
     */
    public  BsReturnDetail(ReturnReason linkedArchive) {
        logger.info(this + "#BsReturnDetail");
        Assert.notNull(linkedArchive);
        Assert.notNull(linkedArchive.getEntity());
        Assert.notNull(linkedArchive.getEntity().getReasonId());
        entity = new BsReturnDetailEntity();
        entity.setReasonId(linkedArchive.getEntity().getReasonId());
    }
    /**
     * 构造函数，已过时，请使用BsReturnDetail.build(blackboard).forComplete(linkedArchive)
     *
     */
    public  BsReturnDetail(BsReturn linkedArchive) {
        logger.info(this + "#BsReturnDetail");
        Assert.notNull(linkedArchive);
        Assert.notNull(linkedArchive.getEntity());
        Assert.notNull(linkedArchive.getEntity().getReturnId());
        entity = new BsReturnDetailEntity();
        entity.setReturnId(linkedArchive.getEntity().getReturnId());
    }

    @Override
    public void link(Linkable target) {
        logger.info(this + "#link");
        if (target == null)
            return;

        if (target instanceof ReturnReason) {
            LinkHelper.link(this, target, "entity.reasonId");
        
        } else if (target instanceof BsReturn) {
            LinkHelper.link(this, target, "entity.returnId");
        
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

        if (item0 instanceof ReturnReason) {
            LinkHelper.link(this, targets, "entity.reasonId");
        
        } else if (item0 instanceof BsReturn) {
            LinkHelper.link(this, targets, "entity.returnId");
        
        }
    }

    @Override
    public void complete(boolean allowDelete) {
        logger.info(this + "#complete");
        // 判断是否是最新
        if (isDataSynced()) {
            return;
        }

        if (entity.getDetailId() != null) {
            BsReturnDetailEntity entity = new BsReturnDetailEntity();
            entity.setDetailId(this.entity.getDetailId());
            this.entity = entity;
        } else if (entity.getReasonId() != null) {
            BsReturnDetailEntity entity = new BsReturnDetailEntity();
            entity.setReasonId(this.entity.getReasonId());
            this.entity = entity;
        } else if (entity.getReturnId() != null) {
            BsReturnDetailEntity entity = new BsReturnDetailEntity();
            entity.setReturnId(this.entity.getReturnId());
            this.entity = entity;
        }

        // 设置允许DEL_FLG=true
        if (allowDelete)
            this.entity.setDelFlg(true);
        else
            this.entity.setDelFlg(false);

        // 查询数据库
        BsReturnDetailDao dao = getDao(BsReturnDetailDao.class);
        BsReturnDetailEntity entity = dao.findOne(this.entity);
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
        BsReturnDetailDao dao = getDao(BsReturnDetailDao.class);

        // 一意制约检测
        // 获取ID
        Long id = getBlackboard().maxId(TABLE_NAME);
        // 设置ID
        this.entity.setDetailId(id);

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
        BsReturnDetailDao dao = getDao(BsReturnDetailDao.class);

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
        BsReturnDetailDao dao = getDao(BsReturnDetailDao.class);

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
            return this.getClass().getName() + this.entity.getDetailId();
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
    public BsReturnDetail forComplete(Long id) {
        logger.info(this + "#forComplete");
        BsReturnDetail build = new BsReturnDetail(id);
        build.setBlackboard(blackboard);
        return build;
    }

    /**
     * 创建对象，用于插入数据库，此对象必须使用create方法插入数据库
     *
     */
    public BsReturnDetail forCreate(BsReturnDetailEntity entity) {
        logger.info(this + "#forCreate");
        BsReturnDetail build = new BsReturnDetail(entity);
        build.setBlackboard(blackboard);
        return build;
    }

    /**
     * 创建对象，用于根据entity.reasonId查询数据，此对象必须使用complete方法补全
     *
     */
    public BsReturnDetail forComplete(ReturnReason linkedArchive) {
        logger.info(this + "#forComplete");
        BsReturnDetail build = new BsReturnDetail(linkedArchive);
        build.setBlackboard(blackboard);
        return build;
    }

    /**
     * 创建对象，用于根据entity.returnId查询数据，此对象必须使用complete方法补全
     *
     */
    public BsReturnDetail forComplete(BsReturn linkedArchive) {
        logger.info(this + "#forComplete");
        BsReturnDetail build = new BsReturnDetail(linkedArchive);
        build.setBlackboard(blackboard);
        return build;
    }

    }


}