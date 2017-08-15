package com.bms.order.bean.entity;
import org.springframework.beans.BeanUtils;public class BsStockpileSplitDetailHistoryEntity extends BsStockpileSplitDetailEntity {
private static final long serialVersionUID = 1L;
/** 履历ID */
private Long historyId;
public Long getHistoryId() {
return this.historyId;}
public void setHistoryId(Long historyId) {
this.historyId=historyId;}
public BsStockpileSplitDetailHistoryEntity() {
}
public BsStockpileSplitDetailHistoryEntity(BsStockpileSplitDetailEntity entity) {
BeanUtils.copyProperties(entity, this);
}
}
