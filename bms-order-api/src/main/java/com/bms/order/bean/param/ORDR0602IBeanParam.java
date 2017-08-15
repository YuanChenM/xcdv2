package com.bms.order.bean.param;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.bms.order.archive.impl.BsOrder;
import com.bms.order.archive.impl.BsOrderDetail;
import com.bms.order.bean.entity.BsOrderAttachedEntity;
import com.bms.order.bean.entity.BsOrderDetailAttachedEntity;
import com.bms.order.bean.entity.BsOrderDetailEntity;
import com.bms.order.bean.entity.BsOrderEntity;
import com.bms.order.common.rest.param.RestBean;

/**
 * 买手订单修改接口Param
 * 
 * @author li_huiqian
 *
 */
public class ORDR0602IBeanParam extends RestBean {

    /**
     * 
     */
    private static final long serialVersionUID = 7587739776851257898L;

    private Long bsOrderId;//订单id
    private String backNo;//订单：参考号
    private BigDecimal preferentialAmount;//优惠金额
    private BigDecimal earnestAmount;// 定金应付金额
    private BigDecimal advancePaymentAmount;//预付应付金额
    private Integer ver;//版本号

    private List<ORDR060201IBeanParam> products;//买手订单明细合集

    public BsOrder generateBSOrder() {
        // 绑定买手订单
        BsOrderEntity bsOrderEntity = new BsOrderEntity();
        BsOrderAttachedEntity attachedEntity = new BsOrderAttachedEntity();

        bsOrderEntity.setBsOrderId(bsOrderId);
        attachedEntity.setBsOrderId(bsOrderId);
        bsOrderEntity.setBackNo(backNo);
        bsOrderEntity.setPreferentialAmount(preferentialAmount);
        bsOrderEntity.setEarnestAmount(earnestAmount);
        bsOrderEntity.setAdvancePaymentAmount(advancePaymentAmount);
        bsOrderEntity.setVersion(ver);
        attachedEntity.setVersion(ver);

//        BsOrder bsOrder = new BsOrder(bsOrderEntity, attachedEntity);
        BsOrder bsOrder = BsOrder.build(null).forCreate(bsOrderEntity, attachedEntity);

        // 绑定买手订单明细
        List<BsOrderDetail> bsOrderDetailList = new ArrayList<>();
        if(CollectionUtils.isNotEmpty(products)){
            for (ORDR060201IBeanParam detail : products) {
                BsOrderDetailEntity bsOrderDetailEntity = new BsOrderDetailEntity();
                BsOrderDetailAttachedEntity bsOrderDetailAttachedEntity = new BsOrderDetailAttachedEntity();

                bsOrderDetailEntity.setBsOrderDetailId(detail.getBsOrderDetailId());
                bsOrderDetailEntity.setBsOrderId(bsOrderId);
//            bsOrderDetailAttachedEntity.setBsOrderDetailId(detail.getBsOrderDetailId());
                bsOrderDetailEntity.setGoodsQuantity(detail.getGoodsQuantity());
                bsOrderDetailEntity.setGoodsUnit(detail.getGoodsUnit());
                bsOrderDetailEntity.setGoodsId(detail.getGoodsId());
                bsOrderDetailEntity.setVersion(detail.getVer());

                BsOrderDetail bsOrderDetail = BsOrderDetail.build(null).forCreate(bsOrderDetailEntity, bsOrderDetailAttachedEntity);
                bsOrderDetailList.add(bsOrderDetail);
                bsOrder.link(bsOrderDetail);
            }
            bsOrder.bsOrderDetailsLinked();
        }

        return bsOrder;
    }

    public Long getBsOrderId() {
        return bsOrderId;
    }

    public void setBsOrderId(Long bsOrderId) {
        this.bsOrderId = bsOrderId;
    }

    public String getBackNo() {
        return backNo;
    }

    public void setBackNo(String backNo) {
        this.backNo = backNo;
    }

    public BigDecimal getPreferentialAmount() {
        return preferentialAmount;
    }

    public void setPreferentialAmount(BigDecimal preferentialAmount) {
        this.preferentialAmount = preferentialAmount;
    }

    public BigDecimal getEarnestAmount() {
        return earnestAmount;
    }

    public void setEarnestAmount(BigDecimal earnestAmount) {
        this.earnestAmount = earnestAmount;
    }

    public BigDecimal getAdvancePaymentAmount() {
        return advancePaymentAmount;
    }

    public void setAdvancePaymentAmount(BigDecimal advancePaymentAmount) {
        this.advancePaymentAmount = advancePaymentAmount;
    }

    public Integer getVer() {
        return ver;
    }

    public void setVer(Integer ver) {
        this.ver = ver;
    }

    public List<ORDR060201IBeanParam> getProducts() {
        return products;
    }

    public void setProducts(List<ORDR060201IBeanParam> products) {
        this.products = products;
    }
}
