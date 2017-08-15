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
import com.bms.order.archive.impl.BsVirtualPerformDetail;
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
 * 买手囤货订单行权单明细表列表辅助类

 * @author li_huiqian

 */
public class BsVirtualPerformDetailList extends AbstractArchive implements Completable, Createable, Linkable, Modifiable, Deletable {

    private static Logger logger = LoggerFactory.getLogger(BsVirtualPerformDetailList.class);

    private static final String TABLE_NAME = "ORDR_BS_VIRTUAL_PERFORM_DETAIL";

    /** 买手囤货订单行权单明细表Entity */
    private List<BsVirtualPerformDetailEntity> entities;


    /** 买手囤货订单行权单明细表列表辅助类 */
    private List<BsVirtualPerformDetail> archives;

    public List<BsVirtualPerformDetail> getArchives() {
        logger.info(this + "#getArchives");
        return archives;
    }

    /** 记录买手货权囤货行权信息 */
    private List<BsVirtualPerform> bsVirtualPerforms;


    private List<Long> ids;


    /**
     * 构造函数
     *
     */
    @Deprecated
    public  BsVirtualPerformDetailList(Long[] ids) {
        logger.info(this + "#BsVirtualPerformDetailList");
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
    public  BsVirtualPerformDetailList(List<BsVirtualPerformDetailEntity> entities) {
        logger.info(this + "#BsVirtualPerformDetailList");
        Assert.notEmpty(entities);
        this.entities = entities;
        setDataSynced(false);
    }

    /**
     * 构造函数
     *
     */
    @Deprecated
    public  BsVirtualPerformDetailList(BsVirtualPerformDetail[] archives) {
        logger.info(this + "#BsVirtualPerformDetailList");
        Assert.notEmpty(archives);
        for (BsVirtualPerformDetail archive : archives) {
            Assert.notNull(archive.getEntity());
        }

        this.archives = new ArrayList<>();
        this.entities = new ArrayList<>();
        for (BsVirtualPerformDetail archive : archives) {
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
    public  BsVirtualPerformDetailList(BsVirtualPerform linkedArchive) {
        logger.info(this + "#BsVirtualPerformDetailList");
        Assert.notNull(linkedArchive);
        Assert.notNull(linkedArchive.getEntity());
        Assert.notNull(linkedArchive.getEntity().getPerformId());
        this.bsVirtualPerforms = new ArrayList<>();
        this.bsVirtualPerforms.add(linkedArchive);
    }

    /**
     * 构造函数
     *
     */
    @Deprecated
    public  BsVirtualPerformDetailList(BsVirtualPerform[] linkedArchives) {
        logger.info(this + "#BsVirtualPerformDetailList");
        Assert.notEmpty(linkedArchives);
        this.bsVirtualPerforms = new ArrayList<>();
        for (BsVirtualPerform linkedArchive : linkedArchives) {
            Assert.notNull(linkedArchive.getEntity());
            Assert.notNull(linkedArchive.getEntity().getPerformId());
            this.bsVirtualPerforms.add(linkedArchive);
        }
    }


    @Override
    public void link(Linkable target) {
        logger.info(this + "#link");
        if (target == null)
            return;

        if (target instanceof BsVirtualPerform) {
            LinkHelper.link(this.archives, target, "entity.performId");
        
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
            LinkHelper.link(this.archives, targets, "entity.performId");
        
        }
    }

    @Override
    public void complete(boolean allowDelete) {
        logger.info(this + "#complete");
        Map<String, Object> map = new HashMap<>();

        if (ids != null && ids.size() != 0)
            map.put("ids", ids);
        else if (bsVirtualPerforms != null && bsVirtualPerforms.size() != 0)
            map.put("bsVirtualPerforms", bsVirtualPerforms);
        // 设置允许DEL_FLG=true
        if (allowDelete)
            map.put("delFlg", true);
        else
            map.put("delFlg", false);

        // 查询数据库
        BsVirtualPerformDetailDao dao = getDao(BsVirtualPerformDetailDao.class);
        List<BsVirtualPerformDetailEntity> entities = dao.findAll(map);
        if (entities == null || entities.isEmpty())
            return;

        for (BsVirtualPerformDetailEntity entity : entities) {
            BsVirtualPerformDetail archive = BsVirtualPerformDetail.build(getBlackboard()).forCreate(entity);
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
        BsVirtualPerformDetailDao dao = getDao(BsVirtualPerformDetailDao.class);

        // 一意制约检测

        // 获取ID
        Long id = getBlackboard().maxId(TABLE_NAME, entities.size());
        // 设置ID
        for (int i = 0; i < entities.size(); i++) {
            BsVirtualPerformDetailEntity entity = entities.get(i);
            entity.setPerformDetailId(id);
            id += 1;
        }

        // 设置待插入字段
        // TODO 对entity中待插入字段进行补全

        // 设置共通字段
        for (int i = 0; i < entities.size(); i++) {
            BsVirtualPerformDetailEntity entity = entities.get(i);
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
        BsVirtualPerformDetailDao dao = getDao(BsVirtualPerformDetailDao.class);

        // 设置待修改字段
        // TODO 对entity中待插入字段进行补全

        // 设置共通字段
        for (int i = 0; i < entities.size(); i++) {
            BsVirtualPerformDetailEntity entity = entities.get(i);
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
        BsVirtualPerformDetailDao dao = getDao(BsVirtualPerformDetailDao.class);

        // 设置共通字段
        for (int i = 0; i < entities.size(); i++) {
            BsVirtualPerformDetailEntity entity = entities.get(i);
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
            for (BsVirtualPerformDetail archive : archives)
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
    public BsVirtualPerformDetailList forComplete(Long[] ids) {
        logger.info(this + "#forComplete");
        BsVirtualPerformDetailList build = new BsVirtualPerformDetailList(ids);
        build.setBlackboard(blackboard);
        return build;
    }

    /**
     * 创建对象列表，用于插入数据库，此对象列表必须使用create方法插入数据库
     *
     */
    public BsVirtualPerformDetailList forCreate(BsVirtualPerformDetail[] archives) {
        logger.info(this + "#forCreate");
        BsVirtualPerformDetailList build = new BsVirtualPerformDetailList(archives);
        build.setBlackboard(blackboard);

        return build;
    }

    /**
     * 创建对象列表，用于修改/删除数据，此对象列表必须使用modify/delete方法
     *
     */
    public BsVirtualPerformDetailList forUpdate(BsVirtualPerformDetail[] archives) {
        logger.info(this + "#forUpdate");
        BsVirtualPerformDetailList build = new BsVirtualPerformDetailList(archives);
        build.setBlackboard(blackboard);
        build.setDataSynced(true);

        return build;
    }

    /**
     * 创建对象，用于根据entity.performId查询数据，此对象必须使用complete方法补全
     *
     */
    public BsVirtualPerformDetailList forComplete(BsVirtualPerform linkedArchive) {
        logger.info(this + "#forComplete");
        BsVirtualPerformDetailList build = new BsVirtualPerformDetailList(linkedArchive);
        build.setBlackboard(blackboard);
        return build;
    }

    }


}