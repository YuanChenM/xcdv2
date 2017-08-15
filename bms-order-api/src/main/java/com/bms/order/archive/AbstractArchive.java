package com.bms.order.archive;

import java.util.Date;

import org.springframework.util.Assert;

import com.bms.order.archive.impl.Operator;
import com.bms.order.bean.Blackboard;
import com.framework.base.rest.entity.BaseEntity;
import com.framework.boot.base.BaseDao;

/**
 * 抽象档案类
 * 
 * @author li_huiqian
 *
 */
public abstract class AbstractArchive {

    /**
     * 黑板
     */
    private Blackboard blackboard;

    /**
     * 是否同步。当数据是从数据库获得，且不是旧数据时，设为true；当数据不是从数据库获得，或者是旧数据时，设为false
     */
    private boolean dataSynced = false;

    public void setBlackboard(Blackboard blackboard) {
        this.blackboard = blackboard;
    }

    public Blackboard getBlackboard() {
        Assert.notNull(blackboard, "Please set blackboard to " + this);
        return blackboard;
    }

    /**
     * 获取Dao
     * 
     * @param <T>
     * 
     * @return
     */
    protected <T extends BaseDao> T getDao(Class<T> clazz) {
        Assert.notNull(blackboard, "Please set blackboard to " + this);
        T dao = blackboard.getDao(clazz);
        Assert.notNull(dao, "Please auto wire " + clazz.getName());
        return dao;
    }

    /**
     * 获取操作者
     * 
     * @return
     */
    protected Operator getOperator() {
        Assert.notNull(blackboard, "Please set blackboard to " + this);
        return blackboard.getOperator();
    }

    public boolean isDataSynced() {
        return dataSynced;
    }

    public void setDataSynced(boolean dataSynced) {
        this.dataSynced = dataSynced;
    }

    public void insertCommon(BaseEntity entity) {
        Assert.notNull(entity);
        Assert.notNull(blackboard, "Please set blackboard to " + this);
        Assert.notNull(blackboard.getOperator());
        entity.setDelFlg(false);
        entity.setCrtId(getOperator().getOperatorId());
        entity.setCrtTime(new Date());
        entity.setUpdId(getOperator().getOperatorId());
        entity.setUpdTime(new Date());
        entity.setVersion(1);
    }

    public void updateCommon(BaseEntity entity) {
        Assert.notNull(entity);
        Assert.notNull(blackboard, "Please set blackboard to " + this);
        Assert.notNull(blackboard.getOperator());
        entity.setDelFlg(false);
        entity.setUpdId(getOperator().getOperatorId());
        entity.setUpdTime(new Date());
        entity.setVersion(entity.getVersion() + 1);
    }

    public void deleteCommon(BaseEntity entity) {
        Assert.notNull(entity);
        Assert.notNull(blackboard, "Please set blackboard to " + this);
        Assert.notNull(blackboard.getOperator());
        entity.setDelFlg(true);
        entity.setUpdId(getOperator().getOperatorId());
        entity.setUpdTime(new Date());
        entity.setVersion(entity.getVersion() + 1);
    }

}
