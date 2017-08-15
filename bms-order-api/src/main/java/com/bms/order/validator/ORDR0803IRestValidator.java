package com.bms.order.validator;

import com.bms.order.bean.param.ORDR0803IBean;
import com.bms.order.bean.param.ORDR0803ProductBean;
import com.bms.order.bean.param.ORDR0803ShipIBean;
import com.bms.order.common.rest.BusinessRestParam;
import com.bms.order.common.rest.param.RestOperator;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.DateUtils;
import com.framework.validator.utils.NumberValidator;

import java.math.BigDecimal;
import java.util.List;

/**
 * 买家迟收退货数据接收接口Validator
 *
 * @author li_huiqian
 */
public class ORDR0803IRestValidator extends OrderValidator<BusinessRestParam<ORDR0803IBean>> {
    @Override
    public void validator(BusinessRestParam<ORDR0803IBean> param) {
        RestOperator operator = param.getOperator();
        this.validateOperator(operator);
        List<ORDR0803IBean> beans = param.getBeans();
        this.validateBeans(beans);
        if (CollectionUtils.isNotEmpty(beans)) {
            for (ORDR0803IBean bean : beans) {
                /**
                 * 配送通知单ID，对应配送通知XML中的ORDERID
                 */

                this.validatorRequired("shipId",bean.getShipId());
                /**
                 * 迟收再发送日期(yyyy-MM-dd)
                 */
                this.validatorStrDate("receiptDate", bean.getReceiptDate(), true, DateUtils.FORMAT_YYYY_MM_DD);
                /**
                 * 迟收模式：1-全部，整单发货单SHIPID全部迟收，无需关注ShipList部分【2016/10/11】，2-部分
                 */

                this.validatorInteger("returnMode", bean.getReturnMode(), true, null, null, NumberValidator.POSITIVE);
                /**
                 * 申请人名称
                 */
                this.validateApplyUname(bean.getApplyMan(), true);
                /**
                 *申请时间(yyyy-MM-dd HH:mm:ss)
                 */
                this.validateApplyTime(bean.getApplyTime(), true);
                /**
                 * 申请备注
                 */
                this.validateApplyRemark(bean.getApplyRemark(), false);
                /**
                 * 退货退货原因ID，退货原因查询接口提供原因标准信息，根据实际的情况选择原因，在此处提交给OMS系统
                 */
                this.validateReturnReasonId(bean.getReturnReasonID(), true);
                /**
                 * 迟收原因名称
                 */
                this.validateReasonName(bean.getReturnReasonName(), true);
                /**
                 * 迟收原因照片1文件ID（调用方上传文件到文件服务器得到文件服务器返回的文件ID，调用方将文件文件ID传入OMS）
                 */
                this.validateImage1(bean.getImage1(), false);
                /**
                 * 迟收原因照片2文件
                 */
                this.validateImage2(bean.getImage2(), false);
                this.validateImage3(bean.getImage3(), false);
                this.validateImage4(bean.getImage4(), false);
                this.validateImage5(bean.getImage5(), false);
                /**
                 * 买家ID，发货XML中BUYERSID
                 */
                this.validateBuyerId(bean.getBuyerId(), true);
                /**
                 * 买家编码，发货XML中CONSIGNEE
                 */
                this.validateBuyerCode(bean.getBuyerCode(), true);
                /**
                 *isPaid
                 */
                this.validatorRequired("isPaid", bean.getIsPaid());


                List<ORDR0803ShipIBean> shipList = bean.getShipList();// 发货单
                this.validatorRequired("shipList", shipList);
                if (CollectionUtils.isNotEmpty(shipList)) {
                    for (ORDR0803ShipIBean shipIBean : shipList) {
                        List<ORDR0803ProductBean> productList = shipIBean.getProductList();
                        this.validatorRequired("productList", productList);
                        this.validatorRequired("deliverCode", shipIBean.getDeliverCode());
                        if (CollectionUtils.isNotEmpty(productList)) {
                            for (ORDR0803ProductBean productBean : productList) {
                                Long shipDetailId = productBean.getShipDetailId();
                                this.validatorRequired("shipDetailId", shipDetailId);
                                String skuCode = productBean.getSkuCode();// sku
                                this.validatorRequired("skuCode", skuCode);
                                BigDecimal returnQty = productBean.getReturnQty();
                                this.validatorRequired("returnQty", returnQty);
                                Long detailReasonId = productBean.getDetailReasonID();

                                String detailReasonName = productBean.getDetailReasonName();
                            }
                        }
                    }
                }
            }
        }
    }
}
