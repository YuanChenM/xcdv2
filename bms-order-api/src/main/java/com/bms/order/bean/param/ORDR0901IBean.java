package com.bms.order.bean.param;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;

import com.bms.order.archive.impl.BsOrder;
import com.bms.order.archive.impl.BsReturn;
import com.bms.order.archive.impl.BsReturnDetail;
import com.bms.order.bean.entity.BsReturnEntity;
import com.bms.order.common.rest.param.RestBean;
import com.framework.core.utils.DateUtils;

/**
 * 买手退货单创建接口Param
 *
 * @author li_huiqian
 */
public class ORDR0901IBean extends RestBean {
    private static final long serialVersionUID = 1L;

    /**
     * 	订单ID
     */
    private Long orderId;
    /**
     * 	退货订单买手ID，需要和订单中买手信息一致
     */
    private String bsId;
    /**
     * 	退货单来源，Master数据
     */
    private String returnSource;
    /**
     * 	买手退货原因ID
     */
    private Long returnReasonId;
    /**
     * 	申请人身份类型,Master数据
     */
    private String applyUserType;
    /**
     * 申请人ID
     */
    private String applyUid;
    /**
     * 	申请人名称
     */
    private String applyUname;
    /**
     * 	申请时间
     */
    private String applyTime;
    /**
     * 申请备注
     */
    private String applyRemark;

    /**
     * 退货明细
     */
    private List<ORDR0901IDetailBean> details;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getBsId() {
        return bsId;
    }

    public void setBsId(String bsId) {
        this.bsId = bsId;
    }

    public String getReturnSource() {
        return returnSource;
    }

    public void setReturnSource(String returnSource) {
        this.returnSource = returnSource;
    }

    public Long getReturnReasonId() {
        return returnReasonId;
    }

    public void setReturnReasonId(Long returnReasonId) {
        this.returnReasonId = returnReasonId;
    }

    public String getApplyUserType() {
        return applyUserType;
    }

    public void setApplyUserType(String applyUserType) {
        this.applyUserType = applyUserType;
    }

    public String getApplyUid() {
        return applyUid;
    }

    public void setApplyUid(String applyUid) {
        this.applyUid = applyUid;
    }

    public String getApplyUname() {
        return applyUname;
    }

    public void setApplyUname(String applyUname) {
        this.applyUname = applyUname;
    }

    public String getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(String applyTime) {
        this.applyTime = applyTime;
    }

    public String getApplyRemark() {
        return applyRemark;
    }

    public void setApplyRemark(String applyRemark) {
        this.applyRemark = applyRemark;
    }

    public List<ORDR0901IDetailBean> getDetails() {
        return details;
    }

    public void setDetails(List<ORDR0901IDetailBean> details) {
        this.details = details;
    }

    public BsReturn generateBsReturn(){
        //退货明细
        List<BsReturnDetail> detailBeans = new ArrayList<>();
        BsReturnEntity entity = new BsReturnEntity();
        entity.setOrderId(orderId);
        entity.setBsId(bsId);
        entity.setBsReturnSource(returnSource);
        entity.setReturnReasonId(returnReasonId);
        entity.setBsApplyUserType(applyUserType);
        entity.setApplyUid(applyUid);
        entity.setApplyUname(applyUname);
        entity.setApplyTime(DateUtils.parse("yyyy-MM-dd HH:mm:ss",applyTime));
        entity.setApplyRemark(applyRemark);
        if(!CollectionUtils.isEmpty(details)){
            for(ORDR0901IDetailBean detailBean : details){
                detailBeans.add(detailBean.generateBsReturnDetail());
            }
        }
        BsReturn bsReturn = BsReturn.build(null).forCreate(entity);
        bsReturn.link(detailBeans);
        return bsReturn;
    }

    public BsOrder findBsOrderById(){
        BsOrder bsOrder = BsOrder.build(null).forComplete(orderId);
        return bsOrder;
    }
}