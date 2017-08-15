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
import com.bms.order.archive.impl.BsOrder;
import com.bms.order.archive.impl.BsOrderDetail;
import com.bms.order.bean.Blackboard;
import com.bms.order.bean.entity.BsOrderAttachedEntity;
import com.bms.order.bean.entity.BsOrderAttachedHistoryEntity;
import com.bms.order.bean.entity.BsOrderEntity;
import com.bms.order.bean.entity.BsOrderHistoryEntity;
import com.bms.order.constant.i18n.ErrorCode;
import com.bms.order.constant.i18n.ModuleCode;
import com.bms.order.dao.BsOrderAttachedDao;
import com.bms.order.dao.BsOrderDao;
import com.bms.order.util.LinkHelper;
import com.framework.exception.BusinessException;

/**
 *
 * 买手订单主表列表辅助类

 * @author li_huiqian

 */
public class BsOrderList extends AbstractArchive implements Completable, Createable, Linkable, Modifiable, Deletable {

    private static Logger logger = LoggerFactory.getLogger(BsOrderList.class);

    private static final String TABLE_NAME = "ORDR_BS_ORDER";

    private static final String HISTORY_TABLE_NAME = "ORDR_BS_ORDER_HISTORY";

    /** 买手订单Entity */
    private List<BsOrderEntity> entities;

    /** 买手订单附表Entity */
    private List<BsOrderAttachedEntity> attachedEntities;


    /** 买手订单主表列表辅助类 */
    private List<BsOrder> archives;

    public List<BsOrder> getArchives() {
        logger.info(this + "#getArchives");
        return archives;
    }


    private List<Long> ids;

    private List<String> codes;


    /**
     * 构造函数
     *
     */
    public  BsOrderList(Long[] ids) {
        logger.info(this + "#BsOrderList");
        Assert.notEmpty(ids);
        this.ids = new ArrayList<>();
        for (Long id : ids)
            this.ids.add(id);
    }

    /**
     * 构造函数
     *
     */
    public  BsOrderList(String[] codes) {
        logger.info(this + "#BsOrderList");
        Assert.notEmpty(codes);
        this.codes = new ArrayList<>();
        for (String code : codes)
            this.codes.add(code);
    }

    /**
     * 构造函数
     *
     */
    public  BsOrderList(List<BsOrderEntity> entities, List<BsOrderAttachedEntity> attachedEntities) {
        logger.info(this + "#BsOrderList");
        Assert.notEmpty(entities);
        Assert.notEmpty(attachedEntities);
        Assert.isTrue(entities.size() == attachedEntities.size());
        this.entities = entities;
        this.attachedEntities = attachedEntities;
        setDataSynced(false);
    }

    /**
     * 构造函数
     *
     */
    public  BsOrderList(BsOrder[] archives) {
        logger.info(this + "#BsOrderList");
        Assert.notEmpty(archives);
        for (BsOrder archive : archives) {
            Assert.notNull(archive.getEntity());
            Assert.notNull(archive.getAttachedEntity());
        }

        this.archives = new ArrayList<>();
        this.entities = new ArrayList<>();
        this.attachedEntities = new ArrayList<>();
        for (BsOrder archive : archives) {
            this.archives.add(archive);
            this.entities.add(archive.getEntity());
            this.attachedEntities.add(archive.getAttachedEntity());
        }

        setDataSynced(false);
    }


    @Override
    public void link(Linkable target) {
        logger.info(this + "#link");
        if (target == null)
            return;

        if (target instanceof BsOrderDetail) {
            LinkHelper.link(this.archives, target, "entity.bsOrderId");
        
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
            LinkHelper.link(this.archives, targets, "entity.bsOrderId");
        
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
        BsOrderDao dao = getDao(BsOrderDao.class);
        List<BsOrderEntity> entities = dao.findAll(map);
        if (entities == null || entities.isEmpty())
            return;

        // 设置查询条件
        map.clear();
        List<Long> ids = new ArrayList<>();
        for (BsOrderEntity entity : entities) 
            ids.add(entity.getBsOrderId());
        map.put("ids", ids);

        // 设置允许DEL_FLG=true
        if (allowDelete)
            map.put("delFlg", true);
        else
            map.put("delFlg", false);

        BsOrderAttachedDao attachedDao = getDao(BsOrderAttachedDao.class);
        List<BsOrderAttachedEntity> attachedEntities = attachedDao.findAll(map);
        if (attachedEntities == null || attachedEntities.isEmpty())
            return;

        for (BsOrderEntity entity : entities) {
            for (BsOrderAttachedEntity attachedEntity : attachedEntities) {
                if (entity.getBsOrderId().equals(attachedEntity.getBsOrderId())) {
                    BsOrder archive = BsOrder.build(getBlackboard()).forCreate(entity, attachedEntity);
                    archive.setDataSynced(true);
                    archive.setHistory();

                    if (archives == null)
                        archives = new ArrayList<>();
                    archives.add(archive);
                    break;
                }
            }
        }

        setDataSynced(true);

        // 设置历史数据
        setHistory();
    }

    @Override
    public void create() {
        logger.info(this + "#create");
        Assert.notEmpty(entities);
        Assert.notEmpty(attachedEntities);

        // 获取Dao
        BsOrderDao dao = getDao(BsOrderDao.class);
        BsOrderAttachedDao attachedDao = getDao(BsOrderAttachedDao.class);

        // 生成编码
        for (BsOrder archive : archives)
            archive.generateCode();

        // 一意制约检测
        String[] codes = new String[entities.size()];
        for (int i = 0; i < entities.size(); i++) {
            codes[i] = entities.get(i).getBsOrderCode();
        }
        
        
        BsOrderList unique = new BsOrderList(codes);
        unique.setBlackboard(getBlackboard());
        unique.complete(false);
        if (unique.isDataSynced())
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000004);

        // 获取ID
        Long id = getBlackboard().maxId(TABLE_NAME, entities.size());
        // 设置ID
        for (int i = 0; i < entities.size(); i++) {
            BsOrderEntity entity = entities.get(i);
            entity.setBsOrderId(id);
            BsOrderAttachedEntity attachedEntity = attachedEntities.get(i);
            attachedEntity.setBsOrderId(id);
            id += 1;
        }

        // 设置共通字段
        for (int i = 0; i < entities.size(); i++) {
            BsOrderEntity entity = entities.get(i);
            insertCommon(entity);
            BsOrderAttachedEntity attachedEntity = attachedEntities.get(i);
            insertCommon(attachedEntity);
        }

        // 插入数据库
        int count = dao.batchSave(entities);
        if (count != entities.size())
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000005);
        count = attachedDao.batchSave(attachedEntities);
        if (count != attachedEntities.size())
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000005);

        setDataSynced(true);

        // 设置历史数据
        setHistory();
    }

    /**
     * 为以此时的entity建立历史Entity，此时的数据必须从数据库查出来，这一步不插入数据库
     *
     */
    public void setHistory() {
        logger.info(this + "#setHistory");
        Assert.notEmpty(archives, "must create or complete first");
        for (BsOrder archive : archives)
            archive.setHistory();
    }

    @Override
    public void modify() {
        logger.info(this + "#modify");
        Assert.notEmpty(entities);
        Assert.notEmpty(attachedEntities);

        // 获取Dao
        BsOrderDao dao = getDao(BsOrderDao.class);
        BsOrderAttachedDao attachedDao = getDao(BsOrderAttachedDao.class);

        // 设置共通字段
        for (int i = 0; i < entities.size(); i++) {
            BsOrderEntity entity = entities.get(i);
            updateCommon(entity);
            BsOrderAttachedEntity attachedEntity = attachedEntities.get(i);
            updateCommon(attachedEntity);
        }

        // 更新数据库带排他检测
        int count = dao.batchModify(entities);
        if (count != 1)
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000007);
        count = attachedDao.batchModify(attachedEntities);
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
        Assert.notEmpty(entities);
        Assert.notEmpty(attachedEntities);

        // 获取Dao
        BsOrderDao dao = getDao(BsOrderDao.class);
        BsOrderAttachedDao attachedDao = getDao(BsOrderAttachedDao.class);

        // 设置共通字段
        for (int i = 0; i < entities.size(); i++) {
            BsOrderEntity entity = entities.get(i);
            deleteCommon(entity);
            BsOrderAttachedEntity attachedEntity = attachedEntities.get(i);
            deleteCommon(attachedEntity);
        }

        // 更新数据库带排他检测
        int count = dao.batchDelete(entities);
        if (count != 1)
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000009);
        count = attachedDao.batchDelete(attachedEntities);
        if (count != 1)
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000009);

        // 插入历史数据
        saveHistory();
        // 设置历史数据
        setHistory();
    }

    /**
     * 保存历史数据，在修改或删除之后调用
     *
     */
    private void saveHistory() {
        logger.info(this + "#saveHistory");
        Assert.notEmpty(archives, "must modify or delete first");
        // 获取历史Entity
        List<BsOrderHistoryEntity> historyEntities = new ArrayList<>();
        List<BsOrderAttachedHistoryEntity> attachedHistoryEntities = new ArrayList<>();
        for (BsOrder archive : archives) {
            historyEntities.add(archive.getHistoryEntity());
            attachedHistoryEntities.add(archive.getAttachedHistoryEntity());
        }
        // 获取Dao
        BsOrderDao dao = getDao(BsOrderDao.class);
        BsOrderAttachedDao attachedDao = getDao(BsOrderAttachedDao.class);

        // 获取Id
        Long historyId = getBlackboard().maxId(HISTORY_TABLE_NAME, archives.size());
        for (BsOrder archive : archives) {
            archive.getHistoryEntity().setHistoryId(historyId);
            archive.getAttachedHistoryEntity().setHistoryId(historyId);
            historyId ++;
        }

        // 插入数据库
        int count = dao.batchSaveHistory(historyEntities);
        if (count != archives.size())
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000010);
        count = attachedDao.batchSaveHistory(attachedHistoryEntities);
        if (count != archives.size())
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000010);
    }

    @Override
    public String toString() {
        return this.getClass().getName();
    }

    @Override
    public void setDataSynced(boolean dataSynced) {
        logger.info(this + "#setDataSynced");
        if (archives != null)
            for (BsOrder archive : archives)
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
    public BsOrderList forComplete(Long[] ids) {
        logger.info(this + "#forComplete");
        BsOrderList build = new BsOrderList(ids);
        build.setBlackboard(blackboard);
        return build;
    }

    /**
     * 创建对象列表，用于根据code查询数据，此对象列表必须使用complete方法补全
     *
     */
    public BsOrderList forComplete(String[] codes) {
        logger.info(this + "#forComplete");
        BsOrderList build = new BsOrderList(codes);
        build.setBlackboard(blackboard);
        return build;
    }

    /**
     * 创建对象列表，用于插入数据库，此对象列表必须使用create方法插入数据库
     *
     */
    public BsOrderList forCreate(BsOrder[] archives) {
        logger.info(this + "#forCreate");
        BsOrderList build = new BsOrderList(archives);
        build.setBlackboard(blackboard);
        return build;
    }

    /**
     * 创建对象列表，用于修改/删除数据，此对象列表必须使用modify/delete方法
     *
     */
    public BsOrderList forUpdate(BsOrder[] archives) {
        logger.info(this + "#forUpdate");
        BsOrderList build = new BsOrderList(archives);
        build.setBlackboard(blackboard);
        build.setDataSynced(true);

        return build;
    }

    }


}