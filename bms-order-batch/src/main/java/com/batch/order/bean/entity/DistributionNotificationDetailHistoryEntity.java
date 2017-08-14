package com.batch.order.bean.entity;
import org.springframework.beans.BeanUtils;

public class DistributionNotificationDetailHistoryEntity extends DistributionNotificationDetailEntity {
private static final long serialVersionUID = 1L;
/** 履历ID */
private Long historyId;
public Long getHistoryId() {
return this.historyId;}
public void setHistoryId(Long historyId) {
this.historyId=historyId;}
public DistributionNotificationDetailHistoryEntity() {
}
public DistributionNotificationDetailHistoryEntity(DistributionNotificationDetailEntity entity) {
BeanUtils.copyProperties(entity, this);
}
}
