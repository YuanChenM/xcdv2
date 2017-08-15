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
import com.bms.order.bean.entity.BsVirtualPerformDetailEntity;
import com.bms.order.dao.BsVirtualPerformDetailDao;
import com.bms.order.util.LinkHelper;
import com.framework.exception.BusinessException;
import com.bms.order.archive.impl.BsVirtualPerform;
import com.bms.order.bean.entity.BsVirtualPerformEntity;

/**
 *
 * 买手囤货订单行权单明细表

 * @author li_huiqian

 */
public class BsVirtualPerformDetail extends AbstractArchive implements Completable, Createable, Linkable, Modifiable, Deletable {

    private static Logger logger = LoggerFactory.getLogger(BsVirtualPerformDetail.class);

    private static final String TABLE_NAME = "ORDR_BS_VIRTUAL_PERFORM_DETAIL";

    /** 买手囤货订单行权单明细表Entity */
    private BsVirtualPerformDetailEntity entity;

    public BsVirtualPerformDetailEntity getEntity() {
        logger.info(this + "#getEntity");
        return entity;
    }


    /** 记录买手货权囤货行权信息 */
    private BsVirtualPerform bsVirtualPerform;

    private boolean isBsVirtualPerformComplete = false;

    /**
     * 关联完毕后调用
     *
     */
    public void bsVirtualPerformLinked() {
        logger.info(this + "#bsVirtualPerformLinked");
        isBsVirtualPerformComplete = true;
    }

    /**
     * 重新取数据时用
     *
     */
    public void bsVirtualPerformUnlink() {
        logger.info(this + "#bsVirtualPerformUnlink");
        isBsVirtualPerformComplete = false;
    }

    public BsVirtualPerform getBsVirtualPerform() {
        logger.info(this + "#getBsVirtualPerform");
        if (!isDataSynced())
            return bsVirtualPerform;

        if (bsVirtualPerform == null || !isBsVirtualPerformComplete) {
            BsVirtualPerform bsVirtualPerform = new BsVirtualPerform(entity.getPerformId());
            bsVirtualPerform.setBlackboard(getBlackboard());
            bsVirtualPerform.complete(false);
            isBsVirtualPerformComplete = true;
            this.bsVirtualPerform = null;
            if(bsVirtualPerform.isDataSynced())
                link(bsVirtualPerform);
        }

        return bsVirtualPerform;
    }

    /**
     * 构造函数，已过时，请使用BsVirtualPerformDetail..forComplete(id)
     *
     */
    @Deprecated
    public  BsVirtualPerformDetail(Long id) {
        logger.info(this + "#BsVirtualPerformDetail");
        Assert.notNull(id);
        entity = new BsVirtualPerformDetailEntity();
        entity.setPerformDetailId(id);
    }

    /**
     * 构造函数，已过时，请使用BsVirtualPerformDetail..forCreate(entity,)
     *
     */
    @Deprecated
    public  BsVirtualPerformDetail(BsVirtualPerformDetailEntity entity) {
        logger.info(this + "#BsVirtualPerformDetail");
        Assert.notNull(entity);
        this.entity = entity;
        setDataSynced(false);
    }

    /**
     * 构造函数，已过时，请使用BsVirtualPerformDetail..forComplete(linkedArchive)
     *
     */
    @Deprecated
    public  BsVirtualPerformDetail(BsVirtualPerform linkedArchive) {
        logger.info(this + "#BsVirtualPerformDetail");
        Assert.notNull(linkedArchive);
        Assert.notNull(linkedArchive.getEntity());
        Assert.notNull(linkedArchive.getEntity().getPerformId());
        entity = new BsVirtualPerformDetailEntity();
        entity.setPerformId(linkedArchive.getEntity().getPerformId());
    }

    @Override
    public void link(Linkable target) {
        logger.info(this + "#link");
        if (target == null)
            return;

        if (target instanceof BsVirtualPerform) {
            LinkHelper.link(this, target, "entity.performId");
        
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

        if (item0 instanceof BsVirtualPerform) {
            LinkHelper.link(this, targets, "entity.performId");
        
        }
    }

    @Override
    public void complete(boolean allowDelete) {
        logger.info(this + "#complete");
        // 判断是否是最新
        if (isDataSynced()) {
            return;
        }

        if (entity.getPerformDetailId() != null) {
            BsVirtualPerformDetailEntity entity = new BsVirtualPerformDetailEntity();
            entity.setPerformDetailId(this.entity.getPerformDetailId());
            this.entity = entity;
        } else if (entity.getPerformId() != null) {
            BsVirtualPerformDetailEntity entity = new BsVirtualPerformDetailEntity();
            entity.setPerformId(this.entity.getPerformId());
            this.entity = entity;
        }

        // 设置允许DEL_FLG=true
        if (allowDelete)
            this.entity.setDelFlg(true);
        else
            this.entity.setDelFlg(false);

        // 查询数据库
        BsVirtualPerformDetailDao dao = getDao(BsVirtualPerformDetailDao.class);
        BsVirtualPerformDetailEntity entity = dao.findOne(this.entity);
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
        BsVirtualPerformDetailDao dao = getDao(BsVirtualPerformDetailDao.class);

        // 一意制约检测
        // 获取ID
        Long id = getBlackboard().maxId(TABLE_NAME);
        // 设置ID
        this.entity.setPerformDetailId(id);

        // 设置待插入字段
        // TODO 对entity中待插入字段进行补全

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
        BsVirtualPerformDetailDao dao = getDao(BsVirtualPerformDetailDao.class);

        // 设置待修改字段
        // TODO 对entity中待插入字段进行补全

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
        BsVirtualPerformDetailDao dao = getDao(BsVirtualPerformDetailDao.class);

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
            return this.getClass().getName() + this.entity.getPerformDetailId();
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
    public BsVirtualPerformDetail forComplete(Long id) {
        logger.info(this + "#forComplete");
        BsVirtualPerformDetail build = new BsVirtualPerformDetail(id);
        build.setBlackboard(blackboard);
        return build;
    }

    /**
     * 创建对象，用于插入数据库，此对象必须使用create方法插入数据库
     *
     */
    public BsVirtualPerformDetail forCreate(BsVirtualPerformDetailEntity entity) {
        logger.info(this + "#forCreate");
        BsVirtualPerformDetail build = new BsVirtualPerformDetail(entity);
        build.setBlackboard(blackboard);
        return build;
    }

    /**
     * 创建对象，用于根据entity.performId查询数据，此对象必须使用complete方法补全
     *
     */
    public BsVirtualPerformDetail forComplete(BsVirtualPerform linkedArchive) {
        logger.info(this + "#forComplete");
        BsVirtualPerformDetail build = new BsVirtualPerformDetail(linkedArchive);
        build.setBlackboard(blackboard);
        return build;
    }

    }


}