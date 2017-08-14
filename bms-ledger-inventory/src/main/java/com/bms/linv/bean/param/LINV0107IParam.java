package com.bms.linv.bean.param;

import com.bms.linv.bean.entity.InvmComoAlocDealDetail;
import com.bms.linv.bean.entity.InvmComoAlocInventory;
import com.bms.linv.bean.entity.InvmComoInventory;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by zheng_xu on 2017/4/17.
 */
@ApiModel(value = "LINV0107IParam",
        description = "货权人商品占用")
public class LINV0107IParam implements Serializable {
    public static String TRANSACTION_TYPE = "107";

    @ApiModelProperty(value = "source")
    private LINV0107ISourceParam source;

    @ApiModelProperty(value = "allocation")
    private LINV0107IAllocationParam allocation;

    public LINV0107ISourceParam getSource() {
        return source;
    }

    public void setSource(LINV0107ISourceParam source) {
        this.source = source;
    }

    public LINV0107IAllocationParam getAllocation() {
        return allocation;
    }

    public void setAllocation(LINV0107IAllocationParam allocation) {
        this.allocation = allocation;
    }

    /**
     * 处理货权人商品占用库存查询对象
     * @return
     */
    public InvmComoAlocInventory searchCommAloc(){
        InvmComoAlocInventory comoAlocInv = new InvmComoAlocInventory();
        comoAlocInv.setLaId(this.getSource().getLogicAreaId());
        comoAlocInv.setSplatCode(this.getSource().getSalePlatform());
        comoAlocInv.setOwnerId(this.getSource().getOwnerId());
        comoAlocInv.setOwnerCode(this.getSource().getOwnerCode());
        comoAlocInv.setOwnerType(this.getSource().getOwnerType());
        comoAlocInv.setCommodityId(this.getSource().getCommodityId());
        comoAlocInv.setAlocQty(this.getAllocation().getAlocQty());
        comoAlocInv.setUom(this.getSource().getUom());
        comoAlocInv.setIvType(this.getSource().getIvType());
        comoAlocInv.setComoIvType(this.getSource().getComoIvType());
        comoAlocInv.setBizType(this.getAllocation().getBizType());
        comoAlocInv.setTgtId(this.getAllocation().getTargetId());
        comoAlocInv.setTgtCode(this.getAllocation().getTargetCode());
        comoAlocInv.setTgtType(this.getAllocation().getTargetType());
        return comoAlocInv;
    }

    /**
     * 处理货权人商品占用明细保存对象
     * @return
     */
    public InvmComoAlocDealDetail saveComAlocDetail(String sign,Date time){
        InvmComoAlocDealDetail dealDetail = new InvmComoAlocDealDetail();
        dealDetail.setTransactionId(this.getAllocation().getTransactionId());
        dealDetail.setTransactionNo(this.getAllocation().getTransactionNo());
        dealDetail.setTransactionDetailId(this.getAllocation().getTransactionDetailId());
        dealDetail.setTransactionSequence(this.getAllocation().getTransactionSequence());
        dealDetail.setTransactionSource(this.getAllocation().getTransactionSource());
        dealDetail.setTransactionType(LINV0107IParam.TRANSACTION_TYPE);
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
