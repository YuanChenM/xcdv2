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
import com.bms.order.bean.entity.BsVirtualPerformEntity;
import com.bms.order.dao.BsVirtualPerformDao;
import com.bms.order.util.LinkHelper;
import com.framework.exception.BusinessException;
import com.bms.order.archive.impl.BsVirtualPerformDetail;
import com.bms.order.archive.impl.list.BsVirtualPerformDetailList;

/**
 *
 * 记录买手货权囤货行权信息

 * @author li_huiqian

 */
public class BsVirtualPerform extends AbstractArchive implements Completable, Createable, Linkable, Modifiable, Deletable {

    private static Logger logger = LoggerFactory.getLogger(BsVirtualPerform.class);

    private static final String TABLE_NAME = "ORDR_BS_VIRTUAL_PERFORM";

    /** 买手囤货行权单主表Entity */
    private BsVirtualPerformEntity entity;

    public BsVirtualPerformEntity getEntity() {
        logger.info(this + "#getEntity");
        return entity;
    }


    /** 买手囤货订单行权单明细表 */
    private List<BsVirtualPerformDetail> bsVirtualPerformDetails;

    private boolean isBsVirtualPerformDetailsComplete = false;

    /**
     * 关联完毕后调用
     *
     */
    public void bsVirtualPerformDetailsLinked() {
        logger.info(this + "#bsVirtualPerformDetailsLinked");
        isBsVirtualPerformDetailsComplete = true;
    }

    /**
     * 重新取数据时用
     *
     */
    public void bsVirtualPerformDetailsUnlink() {
        logger.info(this + "#bsVirtualPerformDetailsUnlink");
        isBsVirtualPerformDetailsComplete = false;
    }

    public List<BsVirtualPerformDetail> getBsVirtualPerformDetails() {
        logger.info(this + "#getBsVirtualPerformDetails");
        if (!isDataSynced())
            return bsVirtualPerformDetails;

        if (bsVirtualPerformDetails == null || !isBsVirtualPerformDetailsComplete) {
            BsVirtualPerformDetailList list = new BsVirtualPerformDetailList(this);
            list.setBlackboard(getBlackboard());
            list.complete(false);
            isBsVirtualPerformDetailsComplete = true;
            bsVirtualPerformDetails = null;
            if(list.isDataSynced()) {
                link(list.getArchives());
                for (BsVirtualPerformDetail item : bsVirtualPerformDetails)
                    item.bsVirtualPerformLinked();
            }
        }

        return bsVirtualPerformDetails;
    }

    /**
     * 构造函数，已过时，请使用BsVirtualPerform..forComplete(id)
     *
     */
    @Deprecated
    public  BsVirtualPerform(Long id) {
        logger.info(this + "#BsVirtualPerform");
        Assert.notNull(id);
        entity = new BsVirtualPerformEntity();
        entity.setPerformId(id);
    }

    /**
     * 构造函数，已过时，请使用BsVirtualPerform..forComplete(code)
     *
     */
    @Deprecated
    public  BsVirtualPerform(String code) {
        logger.info(this + "#BsVirtualPerform");
        Assert.notNull(code);
        entity = new BsVirtualPerformEntity();
        entity.setPerformCode(code);
    }

    /**
     * 构造函数，已过时，请使用BsVirtualPerform..forCreate(entity,)
     *
     */
    @Deprecated
    public  BsVirtualPerform(BsVirtualPerformEntity entity) {
        logger.info(this + "#BsVirtualPerform");
        Assert.notNull(entity);
        this.entity = entity;
        setDataSynced(false);
    }


    @Override
    public void link(Linkable target) {
        logger.info(this + "#link");
        if (target == null)
            return;

        if (target instanceof BsVirtualPerformDetail) {
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

        if (item0 instanceof BsVirtualPerformDetail) {
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

        if (entity.getPerformId() != null) {
            BsVirtualPerformEntity entity = new BsVirtualPerformEntity();
            entity.setPerformId(this.entity.getPerformId());
            this.entity = entity;
        } else if (entity.getPerformCode() != null) {
            BsVirtualPerformEntity entity = new BsVirtualPerformEntity();
            entity.setPerformCode(this.entity.getPerformCode());
            this.entity = entity;
        }

        // 设置允许DEL_FLG=true
        if (allowDelete)
            this.entity.setDelFlg(true);
        else
            this.entity.setDelFlg(false);

        // 查询数据库
        BsVirtualPerformDao dao = getDao(BsVirtualPerformDao.class);
        BsVirtualPerformEntity entity = dao.findOne(this.entity);
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
        BsVirtualPerformDao dao = getDao(BsVirtualPerformDao.class);

        // 一意制约检测
        BsVirtualPerform unique = new BsVirtualPerform(entity.getPerformCode());
        unique.setBlackboard(getBlackboard());
        unique.complete(false);
        if (unique.isDataSynced())
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000004);
        // 获取ID
        Long id = getBlackboard().maxId(TABLE_NAME);
        // 设置ID
        this.entity.setPerformId(id);

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
        BsVirtualPerformDao dao = getDao(BsVirtualPerformDao.class);

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
        BsVirtualPerformDao dao = getDao(BsVirtualPerformDao.class);

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
            return this.getClass().getName() + this.entity.getPerformId();
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
    public BsVirtualPerform forComplete(Long id) {
        logger.info(this + "#forComplete");
        BsVirtualPerform build = new BsVirtualPerform(id);
        build.setBlackboard(blackboard);
        return build;
    }

    /**
     * 创建对象，用于根据code查询数据，此对象必须使用complete方法补全
     *
     */
    public BsVirtualPerform forComplete(String code) {
        logger.info(this + "#forComplete");
        BsVirtualPerform build = new BsVirtualPerform(code);
        build.setBlackboard(blackboard);
        return build;
    }

    /**
     * 创建对象，用于插入数据库，此对象必须使用create方法插入数据库
     *
     */
    public BsVirtualPerform forCreate(BsVirtualPerformEntity entity) {
        logger.info(this + "#forCreate");
        BsVirtualPerform build = new BsVirtualPerform(entity);
        build.setBlackboard(blackboard);
        return build;
    }

    }


}