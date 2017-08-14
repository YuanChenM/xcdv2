package com.batch.order.bean.entity;
import org.springframework.beans.BeanUtils;

public class BsOrderAttachedHistoryEntity extends BsOrderAttachedEntity {
private static final long serialVersionUID = 1L;
/** 履历ID */
private Long historyId;
public Long getHistoryId() {
return this.historyId;}
public void setHistoryId(Long historyId) {
this.historyId=historyId;}
public BsOrderAttachedHistoryEntity() {
}
public BsOrderAttachedHistoryEntity(BsOrderAttachedEntity entity) {
BeanUtils.copyProperties(entity, this);
}
}
