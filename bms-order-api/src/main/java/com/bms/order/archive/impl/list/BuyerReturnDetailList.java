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
import com.bms.order.archive.impl.BuyerReturn;
import com.bms.order.archive.impl.BuyerReturnDetail;
import com.bms.order.archive.impl.ReceiveNotificationDetail;
import com.bms.order.archive.impl.ReturnReason;
import com.bms.order.bean.Blackboard;
import com.bms.order.bean.entity.BuyerReturnDetailEntity;
import com.bms.order.constant.i18n.ErrorCode;
import com.bms.order.constant.i18n.ModuleCode;
import com.bms.order.dao.BuyerReturnDetailDao;
import com.bms.order.util.LinkHelper;
import com.framework.exception.BusinessException;

/**
 *
 * 买家退货订单明细信息列表辅助类

 * @author li_huiqian

 */
public class BuyerReturnDetailList extends AbstractArchive implements Completable, Createable, Linkable, Modifiable, Deletable {

    private static Logger logger = LoggerFactory.getLogger(BuyerReturnDetailList.class);

    private static final String TABLE_NAME = "ORDR_BUYER_RETURN_DETAIL";

    /** 买家退货订单明细Entity */
    private List<BuyerReturnDetailEntity> entities;


    /** 买家退货订单明细信息列表辅助类 */
    private List<BuyerReturnDetail> archives;

    public List<BuyerReturnDetail> getArchives() {
        logger.info(this + "#getArchives");
        return archives;
    }

    /** 收货通知单明细 */
    private List<ReceiveNotificationDetail> receiveNotificationDetails;

    /** 买家退货主表 */
    private List<BuyerReturn> buyerReturns;


    private List<Long> ids;


    /**
     * 构造函数
     *
     */
    public  BuyerReturnDetailList(Long[] ids) {
        logger.info(this + "#BuyerReturnDetailList");
        Assert.notEmpty(ids);
        this.ids = new ArrayList<>();
        for (Long id : ids)
            this.ids.add(id);
    }

    /**
     * 构造函数
     *
     */
    public  BuyerReturnDetailList(List<BuyerReturnDetailEntity> entities) {
        logger.info(this + "#BuyerReturnDetailList");
        Assert.notEmpty(entities);
        this.entities = entities;
        setDataSynced(false);
    }

    /**
     * 构造函数
     *
     */
    public  BuyerReturnDetailList(BuyerReturnDetail[] archives) {
        logger.info(this + "#BuyerReturnDetailList");
        Assert.notEmpty(archives);
        for (BuyerReturnDetail archive : archives) {
            Assert.notNull(archive.getEntity());
        }

        this.archives = new ArrayList<>();
        this.entities = new ArrayList<>();
        for (BuyerReturnDetail archive : archives) {
            this.archives.add(archive);
            this.entities.add(archive.getEntity());
        }

        setDataSynced(false);
    }

    /**
     * 构造函数
     *
     */
    public  BuyerReturnDetailList(ReceiveNotificationDetail linkedArchive) {
        logger.info(this + "#BuyerReturnDetailList");
        Assert.notNull(linkedArchive);
        Assert.notNull(linkedArchive.getEntity());
        Assert.notNull(linkedArchive.getEntity().getReceiveNotificationDetailId());
        this.receiveNotificationDetails = new ArrayList<>();
        this.receiveNotificationDetails.add(linkedArchive);
    }

    /**
     * 构造函数
     *
     */
    public  BuyerReturnDetailList(ReceiveNotificationDetail[] linkedArchives) {
        logger.info(this + "#BuyerReturnDetailList");
        Assert.notEmpty(linkedArchives);
        this.receiveNotificationDetails = new ArrayList<>();
        for (ReceiveNotificationDetail linkedArchive : linkedArchives) {
            Assert.notNull(linkedArchive.getEntity());
            Assert.notNull(linkedArchive.getEntity().getReceiveNotificationDetailId());
            this.receiveNotificationDetails.add(linkedArchive);
        }
    }

    /**
     * 构造函数
     *
     */
    public  BuyerReturnDetailList(BuyerReturn linkedArchive) {
        logger.info(this + "#BuyerReturnDetailList");
        Assert.notNull(linkedArchive);
        Assert.notNull(linkedArchive.getEntity());
        Assert.notNull(linkedArchive.getEntity().getReturnId());
        this.buyerReturns = new ArrayList<>();
        this.buyerReturns.add(linkedArchive);
    }

    /**
     * 构造函数
     *
     */
    public  BuyerReturnDetailList(BuyerReturn[] linkedArchives) {
        logger.info(this + "#BuyerReturnDetailList");
        Assert.notEmpty(linkedArchives);
        this.buyerReturns = new ArrayList<>();
        for (BuyerReturn linkedArchive : linkedArchives) {
            Assert.notNull(linkedArchive.getEntity());
            Assert.notNull(linkedArchive.getEntity().getReturnId());
            this.buyerReturns.add(linkedArchive);
        }
    }


    @Override
    public void link(Linkable target) {
        logger.info(this + "#link");
        if (target == null)
            return;

        if (target instanceof ReceiveNotificationDetail) {
            LinkHelper.link(this.archives, target, "entity.receiveNotificationDetailId");
        
        } else if (target instanceof BuyerReturn) {
            LinkHelper.link(this.archives, target, "entity.returnId");
        
        } else if (target instanceof ReturnReason) {
            LinkHelper.link(this.archives, target, "entity.reasonId");
        
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

        if (item0 instanceof ReceiveNotificationDetail) {
            LinkHelper.link(this.archives, targets, "entity.receiveNotificationDetailId");
        
        } else if (item0 instanceof BuyerReturn) {
            LinkHelper.link(this.archives, targets, "entity.returnId");
        
        } else if (item0 instanceof ReturnReason) {
            LinkHelper.link(this.archives, targets, "entity.reasonId");
        
        }
    }

    @Override
    public void complete(boolean allowDelete) {
        logger.info(this + "#complete");
        Map<String, Object> map = new HashMap<>();

        if (ids != null && ids.size() != 0)
            map.put("ids", ids);
        else if (receiveNotificationDetails != null && receiveNotificationDetails.size() != 0)
            map.put("receiveNotificationDetails", receiveNotificationDetails);
        else if (buyerReturns != null && buyerReturns.size() != 0)
            map.put("buyerReturns", buyerReturns);
        // 设置允许DEL_FLG=true
        if (allowDelete)
            map.put("delFlg", true);
        else
            map.put("delFlg", false);

        // 查询数据库
        BuyerReturnDetailDao dao = getDao(BuyerReturnDetailDao.class);
        List<BuyerReturnDetailEntity> entities = dao.findAll(map);
        if (entities == null || entities.isEmpty())
            return;

        for (BuyerReturnDetailEntity entity : entities) {
            BuyerReturnDetail archive = BuyerReturnDetail.build(getBlackboard()).forCreate(entity);
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
        BuyerReturnDetailDao dao = getDao(BuyerReturnDetailDao.class);

        // 一意制约检测

        // 获取ID
        Long id = getBlackboard().maxId(TABLE_NAME, entities.size());
        // 设置ID
        for (int i = 0; i < entities.size(); i++) {
            BuyerReturnDetailEntity entity = entities.get(i);
            entity.setDetailId(id);
            id += 1;
        }

        // 设置共通字段
        for (int i = 0; i < entities.size(); i++) {
            BuyerReturnDetailEntity entity = entities.get(i);
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
        BuyerReturnDetailDao dao = getDao(BuyerReturnDetailDao.class);

        // 设置共通字段
        for (int i = 0; i < entities.size(); i++) {
            BuyerReturnDetailEntity entity = entities.get(i);
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
        BuyerReturnDetailDao dao = getDao(BuyerReturnDetailDao.class);

        // 设置共通字段
        for (int i = 0; i < entities.size(); i++) {
            BuyerReturnDetailEntity entity = entities.get(i);
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
            for (BuyerReturnDetail archive : archives)
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
    public BuyerReturnDetailList forComplete(Long[] ids) {
        logger.info(this + "#forComplete");
        BuyerReturnDetailList build = new BuyerReturnDetailList(ids);
        build.setBlackboard(blackboard);
        return build;
    }

    /**
     * 创建对象列表，用于插入数据库，此对象列表必须使用create方法插入数据库
     *
     */
    public BuyerReturnDetailList forCreate(BuyerReturnDetail[] archives) {
        logger.info(this + "#forCreate");
        BuyerReturnDetailList build = new BuyerReturnDetailList(archives);
        build.setBlackboard(blackboard);

        return build;
    }

    /**
     * 创建对象列表，用于修改/删除数据，此对象列表必须使用modify/delete方法
     *
     */
    public BuyerReturnDetailList forUpdate(BuyerReturnDetail[] archives) {
        logger.info(this + "#forUpdate");
        BuyerReturnDetailList build = new BuyerReturnDetailList(archives);
        build.setBlackboard(blackboard);
        build.setDataSynced(true);

        return build;
    }

    /**
     * 创建对象，用于根据entity.receiveNotificationDetailId查询数据，此对象必须使用complete方法补全
     *
     */
    public BuyerReturnDetailList forComplete(ReceiveNotificationDetail linkedArchive) {
        logger.info(this + "#forComplete");
        BuyerReturnDetailList build = new BuyerReturnDetailList(linkedArchive);
        build.setBlackboard(blackboard);
        return build;
    }

    /**
     * 创建对象，用于根据entity.returnId查询数据，此对象必须使用complete方法补全
     *
     */
    public BuyerReturnDetailList forComplete(BuyerReturn linkedArchive) {
        logger.info(this + "#forComplete");
        BuyerReturnDetailList build = new BuyerReturnDetailList(linkedArchive);
        build.setBlackboard(blackboard);
        return build;
    }

    }


}