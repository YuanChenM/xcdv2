package com.batch.order.bean.entity;
import org.springframework.beans.BeanUtils;

public class BsStockpileSaleDetailHistoryEntity extends BsStockpileSaleDetailEntity {
private static final long serialVersionUID = 1L;
/** 履历ID */
private Long historyId;
public Long getHistoryId() {
return this.historyId;}
public void setHistoryId(Long historyId) {
this.historyId=historyId;}
public BsStockpileSaleDetailHistoryEntity() {
}
public BsStockpileSaleDetailHistoryEntity(BsStockpileSaleDetailEntity entity) {
BeanUtils.copyProperties(entity, this);
}
}
