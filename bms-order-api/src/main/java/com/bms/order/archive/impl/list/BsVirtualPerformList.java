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
import com.bms.order.archive.impl.BsVirtualPerform;
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
 * 记录买手货权囤货行权信息列表辅助类

 * @author li_huiqian

 */
public class BsVirtualPerformList extends AbstractArchive implements Completable, Createable, Linkable, Modifiable, Deletable {

    private static Logger logger = LoggerFactory.getLogger(BsVirtualPerformList.class);

    private static final String TABLE_NAME = "ORDR_BS_VIRTUAL_PERFORM";

    /** 买手囤货行权单主表Entity */
    private List<BsVirtualPerformEntity> entities;


    /** 记录买手货权囤货行权信息列表辅助类 */
    private List<BsVirtualPerform> archives;

    public List<BsVirtualPerform> getArchives() {
        logger.info(this + "#getArchives");
        return archives;
    }


    private List<Long> ids;

    private List<String> codes;


    /**
     * 构造函数
     *
     */
    @Deprecated
    public  BsVirtualPerformList(Long[] ids) {
        logger.info(this + "#BsVirtualPerformList");
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
    public  BsVirtualPerformList(String[] codes) {
        logger.info(this + "#BsVirtualPerformList");
        Assert.notEmpty(codes);
        this.codes = new ArrayList<>();
        for (String code : codes)
            this.codes.add(code);
    }

    /**
     * 构造函数
     *
     */
    @Deprecated
    public  BsVirtualPerformList(List<BsVirtualPerformEntity> entities) {
        logger.info(this + "#BsVirtualPerformList");
        Assert.notEmpty(entities);
        this.entities = entities;
        setDataSynced(false);
    }

    /**
     * 构造函数
     *
     */
    @Deprecated
    public  BsVirtualPerformList(BsVirtualPerform[] archives) {
        logger.info(this + "#BsVirtualPerformList");
        Assert.notEmpty(archives);
        for (BsVirtualPerform archive : archives) {
            Assert.notNull(archive.getEntity());
        }

        this.archives = new ArrayList<>();
        this.entities = new ArrayList<>();
        for (BsVirtualPerform archive : archives) {
            this.archives.add(archive);
            this.entities.add(archive.getEntity());
        }

        setDataSynced(false);
    }


    @Override
    public void link(Linkable target) {
        logger.info(this + "#link");
        if (target == null)
            return;

        if (target instanceof BsVirtualPerformDetail) {
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

        if (item0 instanceof BsVirtualPerformDetail) {
            LinkHelper.link(this.archives, targets, "entity.performId");
        
        }
    }

    @Override
    public void complete(boolean allowDelete) {
        logger.info(this + "#complete");
        Map<String, Object> map = new HashMap<>();

        if (ids != null && ids.size() != 0)
            map.put("ids", ids);
        else if (codes != null && codes.size() != 0)
            map.put("codes", codes);
        // 设置允许DEL_FLG=true
        if (allowDelete)
            map.put("delFlg", true);
        else
            map.put("delFlg", false);

        // 查询数据库
        BsVirtualPerformDao dao = getDao(BsVirtualPerformDao.class);
        List<BsVirtualPerformEntity> entities = dao.findAll(map);
        if (entities == null || entities.isEmpty())
            return;

        for (BsVirtualPerformEntity entity : entities) {
            BsVirtualPerform archive = BsVirtualPerform.build(getBlackboard()).forCreate(entity);
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
        BsVirtualPerformDao dao = getDao(BsVirtualPerformDao.class);

        // 一意制约检测
        String[] codes = new String[entities.size()];
        for (int i = 0; i < entities.size(); i++) {
            codes[i] = entities.get(i).getPerformCode();
        }
        
        
        BsVirtualPerformList unique = new BsVirtualPerformList(codes);
        unique.setBlackboard(getBlackboard());
        unique.complete(false);
        if (unique.isDataSynced())
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000004);

        // 获取ID
        Long id = getBlackboard().maxId(TABLE_NAME, entities.size());
        // 设置ID
        for (int i = 0; i < entities.size(); i++) {
            BsVirtualPerformEntity entity = entities.get(i);
            entity.setPerformId(id);
            id += 1;
        }

        // 设置待插入字段
        // TODO 对entity中待插入字段进行补全

        // 设置共通字段
        for (int i = 0; i < entities.size(); i++) {
            BsVirtualPerformEntity entity = entities.get(i);
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
        BsVirtualPerformDao dao = getDao(BsVirtualPerformDao.class);

        // 设置待修改字段
        // TODO 对entity中待插入字段进行补全

        // 设置共通字段
        for (int i = 0; i < entities.size(); i++) {
            BsVirtualPerformEntity entity = entities.get(i);
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
        BsVirtualPerformDao dao = getDao(BsVirtualPerformDao.class);

        // 设置共通字段
        for (int i = 0; i < entities.size(); i++) {
            BsVirtualPerformEntity entity = entities.get(i);
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
            for (BsVirtualPerform archive : archives)
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
    public BsVirtualPerformList forComplete(Long[] ids) {
        logger.info(this + "#forComplete");
        BsVirtualPerformList build = new BsVirtualPerformList(ids);
        build.setBlackboard(blackboard);
        return build;
    }

    /**
     * 创建对象列表，用于根据code查询数据，此对象列表必须使用complete方法补全
     *
     */
    public BsVirtualPerformList forComplete(String[] codes) {
        logger.info(this + "#forComplete");
        BsVirtualPerformList build = new BsVirtualPerformList(codes);
        build.setBlackboard(blackboard);
        return build;
    }

    /**
     * 创建对象列表，用于插入数据库，此对象列表必须使用create方法插入数据库
     *
     */
    public BsVirtualPerformList forCreate(BsVirtualPerform[] archives) {
        logger.info(this + "#forCreate");
        BsVirtualPerformList build = new BsVirtualPerformList(archives);
        build.setBlackboard(blackboard);

        return build;
    }

    /**
     * 创建对象列表，用于修改/删除数据，此对象列表必须使用modify/delete方法
     *
     */
    public BsVirtualPerformList forUpdate(BsVirtualPerform[] archives) {
        logger.info(this + "#forUpdate");
        BsVirtualPerformList build = new BsVirtualPerformList(archives);
        build.setBlackboard(blackboard);
        build.setDataSynced(true);

        return build;
    }

    }


}