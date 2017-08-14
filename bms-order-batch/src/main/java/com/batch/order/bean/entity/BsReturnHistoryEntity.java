package com.batch.order.bean.entity;
import org.springframework.beans.BeanUtils;

public class BsReturnHistoryEntity extends BsReturnEntity {
private static final long serialVersionUID = 1L;
/** 履历ID */
private Long historyId;
public Long getHistoryId() {
return this.historyId;}
public void setHistoryId(Long historyId) {
this.historyId=historyId;}
public BsReturnHistoryEntity() {
}
public BsReturnHistoryEntity(BsReturnEntity entity) {
BeanUtils.copyProperties(entity, this);
}
}
