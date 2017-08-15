package com.bms.order.bean.entity;
import org.springframework.beans.BeanUtils;public class BsOrderHistoryEntity extends BsOrderEntity {
private static final long serialVersionUID = 1L;
/** 履历ID */
private Long historyId;
public Long getHistoryId() {
return this.historyId;}
public void setHistoryId(Long historyId) {
this.historyId=historyId;}
public BsOrderHistoryEntity() {
}
public BsOrderHistoryEntity(BsOrderEntity entity) {
BeanUtils.copyProperties(entity, this);
}
}
