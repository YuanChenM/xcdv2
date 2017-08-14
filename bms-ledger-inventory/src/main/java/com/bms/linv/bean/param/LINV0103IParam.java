package com.bms.linv.bean.param;

import com.bms.linv.bean.entity.InvmLoadAlocDealDetail;
import com.bms.linv.bean.entity.InvmLoadAlocInventory;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by zheng_xu on 2017/4/14.
 */
@ApiModel(value = "LINV0103IParam",
        description = "产品库存占用")
public class LINV0103IParam implements Serializable {
    public static String TRANSACTION_TYPE = "103";

    @ApiModelProperty(value = "source")
    private LINV0103ISourceParam source;

    @ApiModelProperty(value = "allocation")
    private LINV0103IAllocationParam allocation;

    public LINV0103ISourceParam getSource() {
        return source;
    }

    public void setSource(LINV0103ISourceParam source) {
        this.source = source;
    }

    public LINV0103IAllocationParam getAllocation() {
        return allocation;
    }

    public void setAllocation(LINV0103IAllocationParam allocation) {
        this.allocation = allocation;
    }

    /**
     * 处理SKU占用汇总表查询对象
     * 
     * @return
     */
    public InvmLoadAlocInventory searchLoadAlocParam(){
        InvmLoadAlocInventory loadAlocParam = new InvmLoadAlocInventory();
        loadAlocParam.setLaId(this.getSource().getLogicAreaId());
        loadAlocParam.setSplatCode(this.getSource().getSalePlatform());
        loadAlocParam.setOwnerId(this.getSource().getOwnerId());
        loadAlocParam.setOwnerCode(this.getSource().getOwnerCode());
        loadAlocParam.setOwnerType(this.getSource().getOwnerType());
        loadAlocParam.setSkuCode(this.getSource().getSkuCode());
        loadAlocParam.setLotNo(this.getSource().getLotNo());
        loadAlocParam.setIvType(this.getSource().getIvType());
        loadAlocParam.setAlocQty(this.getAllocation().getAlocQty());
        loadAlocParam.setSaleStatusId(this.getSource().getSaleStatusId());
        loadAlocParam.setUom(this.getSource().getUom());
        loadAlocParam.setTgtId(this.getAllocation().getTargetId());
        loadAlocParam.setTgtCode(this.getAllocation().getTargetCode());
        loadAlocParam.setTgtType(this.getAllocation().getTargetType());
        loadAlocParam.setBizType(this.getAllocation().getBizType());
        return loadAlocParam;
    }

    /**
     * 处理SKU占用交易表保存对象
     * 
     * @return
     */
    public InvmLoadAlocDealDetail saveLoadAlocDetailParam(String sign,Date time){
        InvmLoadAlocDealDetail dealDetail = new InvmLoadAlocDealDetail();
        dealDetail.setTransactionId(this.getAllocation().getTransactionId());
        dealDetail.setTransactionNo(this.getAllocation().getTransactionNo());
        dealDetail.setTransactionDetailId(this.getAllocation().getTransactionDetailId());
        dealDetail.setTransactionSequence(this.getAllocation().getTransactionSequence());
        dealDetail.setTransactionSource(this.getAllocation().getTransactionSource());
        dealDetail.setTransactionType(LINV0103IParam.TRANSACTION_TYPE);
        dealDetail.setTransactionTime(time);
        dealDetail.setRefNo(this.getAllocation().getRefNo());
        dealDetail.setBizType(this.getAllocation().getBizType());
        dealDetail.setAlocQty(this.getAllocation().getAlocQty());
        dealDetail.setTgtId(this.getAllocation().getTargetId());
        dealDetail.setTgtCode(this.getAllocation().getTargetCode());
        dealDetail.setTgtType(this.getAllocation().getTargetType());
        return dealDetail;
    }
}
