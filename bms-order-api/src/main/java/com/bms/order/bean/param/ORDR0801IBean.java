package com.bms.order.bean.param;

import java.util.ArrayList;
import java.util.List;

import com.bms.order.archive.impl.BuyerOrder;
import com.bms.order.archive.impl.BuyerReturn;
import com.bms.order.archive.impl.BuyerReturnDetail;
import com.bms.order.archive.impl.ReturnReason;
import com.bms.order.bean.entity.BuyerReturnEntity;
import com.bms.order.common.rest.param.RestBean;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.DateUtils;

/**
 * 买家退货单创建接口Param
 *
 * @author li_huiqian
 */
public class ORDR0801IBean extends RestBean {

    private static final long serialVersionUID = 1L;

    /**
     * 	订单ID
     */
    private Long orderId;
    /**
     * 	退货订单买家ID，需要和订单中买家信息一致
     */
    private String buyerId;
    /**
     * 	退货单来源，Master数据
     */
    private String returnSource;
    /**
     * 	退货原因ID
     */
    private Long returnReasonId;
    /**
     * 	申请人类型，001-买家，002-管家，003-平台订单员
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
     * 退货原因照片1文件ID
     */
    private String image1;
    /**
     * 退货原因照片2文件ID
     */
    private String image2;
    /**
     * 退货原因照片3文件ID
     */
    private String image3;
    /**
     * 退货原因照片4文件ID
     */
    private String image4;
    /**
     * 退货原因照片5文件ID
     */
    private String image5;

    private List<ORDR0801IDetailBean> details;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
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

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    public String getImage4() {
        return image4;
    }

    public void setImage4(String image4) {
        this.image4 = image4;
    }

    public String getImage5() {
        return image5;
    }

    public void setImage5(String image5) {
        this.image5 = image5;
    }

    public List<ORDR0801IDetailBean> getDetails() {
        return details;
    }

    public void setDetails(List<ORDR0801IDetailBean> details) {
        this.details = details;
    }

    /**
     * 查询买家订单
     * @return
     */
    public BuyerOrder findBuyerOrder(){
        BuyerOrder buyerOrder =BuyerOrder.build(null).forComplete(orderId);
        return buyerOrder;
    }

    /**
     * 查询退货原因
     * @return
     */
    public ReturnReason findReturnReason(){
        ReturnReason returnReason = ReturnReason.build(null).forComplete(returnReasonId);
        return returnReason;
    }

    /**
     * 创建退货单
     * @return
     */
    public BuyerReturn generateBuyerReturn(){
        List<BuyerReturnDetail> detailList = new ArrayList<>();
        BuyerReturnEntity entity = new BuyerReturnEntity();
        entity.setOrderId(orderId);
        entity.setBuyerId(buyerId);
        entity.setBuyerReturnSource(returnSource);
        entity.setReturnReasonId(returnReasonId);
        entity.setBuyerApplyUserType(applyUserType);
        entity.setApplyUid(applyUid);
        entity.setApplyUname(applyUname);
        entity.setApplyTime(DateUtils.parse("yyyy-MM-dd HH:mm:ss",applyTime));
        entity.setApplyRemark(applyRemark);
        entity.setImage1(image1);
        entity.setImage2(image2);
        entity.setImage3(image3);
        entity.setImage4(image4);
        entity.setImage5(image5);
        if(!CollectionUtils.isEmpty(details)){
            for(ORDR0801IDetailBean detailBean : details){
                detailList.add(detailBean.generateBuyerReturnDetail());
            }
        }
        BuyerReturn buyerReturn = BuyerReturn.build(null).forCreate(entity);
        buyerReturn.link(detailList);
        return buyerReturn;
    }

}
