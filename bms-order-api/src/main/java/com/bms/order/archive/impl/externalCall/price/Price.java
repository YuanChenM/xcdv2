package com.bms.order.archive.impl.externalCall.price;

import com.bms.order.archive.impl.BsOrderDetail;
import com.bms.order.archive.impl.BuyerBatchOrderDetail;
import com.bms.order.archive.impl.list.BsOrderDetailList;
import com.bms.order.archive.impl.list.BuyerBatchOrderDetailList;
import com.bms.order.bean.externalCall.price.entity.PriceChannelQueryEntity;
import com.bms.order.bean.externalCall.price.entity.PriceEntity;
import com.bms.order.bean.externalCall.price.param.PriceChannelQueryParam;
import com.bms.order.bean.externalCall.price.param.PriceListRestParam;
import com.bms.order.bean.externalCall.price.param.PriceRestParam;
import com.bms.order.bean.externalCall.price.result.PriceListRestResult;
import com.bms.order.bean.externalCall.price.result.PriceRestResult;
import com.bms.order.util.ExternalCallUtil;
import com.framework.core.utils.DecimalUtils;
import com.framework.exception.BusinessException;
import org.junit.Test;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by zhang_qiang1 on 2017/1/4.
 */
public class Price {


    /**
     * 买家  通过价盘 查询商品单价
     *
     * @param params
     * @return
     */
    public List<PriceChannelQueryEntity> getPriceChannelDetailList(List<PriceChannelQueryParam> params) {
        List<PriceChannelQueryEntity> list = new ArrayList<>();
        if (CollectionUtils.isEmpty(params)) {
            throw new BusinessException("", "");
        } else {
            for (PriceChannelQueryParam param : params) {
                PriceChannelQueryEntity priceChannelQueryEntity = (PriceChannelQueryEntity) ExternalCallUtil.setEntityParam(PriceChannelQueryEntity.class, 10);
                priceChannelQueryEntity.setGoodsId(param.getGoodsId());
                for (PriceChannelQueryEntity.PriceChannelResult priceChannelResult : priceChannelQueryEntity.getPriceChannelResultList()) {
                    priceChannelResult.setGoodsId(param.getGoodsId());
                    priceChannelResult.setGoodsQuantity(param.getGoodsQuantity());
                }
                list.add(priceChannelQueryEntity);
            }
        }
        return list;
    }


    /**
     * 买手  通过价盘 查询商品单价
     *
     * @return
     */
    public List<PriceEntity> findGoodsPriceByPriceWay(BsOrderDetailList bsOrderDetailList) {
        List<PriceRestParam> paramList = this.getPriceParamList(bsOrderDetailList, null);
        List<PriceEntity> list = new ArrayList<>();
        List<BsOrderDetail> bsOrderDetails = bsOrderDetailList.getArchives();
        for (BsOrderDetail bsOrderDetail : bsOrderDetails) {
            PriceEntity priceEntity = new PriceEntity();
            priceEntity.setGoodsPrice(new BigDecimal(new Random().nextInt(100) + 1));
            priceEntity.setGoodsId(bsOrderDetail.getEntity().getGoodsId().toString());
            list.add(priceEntity);
        }
        return list;
    }


    /**
     * 买手  通过价盘 查询商品单价
     *
     * @param bsOrderDetails
     * @return
     */
    public Map<String, BigDecimal> findGoodsPriceByPriceWay(List<BsOrderDetail> bsOrderDetails) {
        Map<String, BigDecimal> map = new HashMap<>();
        for (BsOrderDetail bsOrderDetail : bsOrderDetails) {
            map.put(bsOrderDetail.getEntity().getGoodsId().toString(), new BigDecimal(new Random().nextInt(100) + 1));
        }
        return map;
    }

    /**
     * 买家  通过价盘 查询商品单价
     *
     * @param buyerBatchOrderDetailList
     * @return
     */
    public List<PriceEntity> findGoodsPriceByPriceWay(BuyerBatchOrderDetailList buyerBatchOrderDetailList) {
        List<PriceRestParam> paramList = this.getPriceParamList(null, buyerBatchOrderDetailList);
        List<PriceEntity> list = new ArrayList<>();
        List<BuyerBatchOrderDetail> buyerBatchOrderDetails = buyerBatchOrderDetailList.getArchives();
        for (BuyerBatchOrderDetail buyerBatchOrderDetail : buyerBatchOrderDetails) {
            PriceEntity priceEntity = new PriceEntity();
            priceEntity.setGoodsPrice(new BigDecimal(new Random().nextInt(100) + 1));
            priceEntity.setGoodsId(buyerBatchOrderDetail.getEntity().getGoodsId().toString());
            list.add(priceEntity);
        }
        return list;
    }


    /**
     * 封装成 List<PriceRestParam>
     *
     * @param bsOrderDetailList
     * @param buyerBatchOrderDetailList
     * @return
     */
    private List<PriceRestParam> getPriceParamList(BsOrderDetailList bsOrderDetailList, BuyerBatchOrderDetailList buyerBatchOrderDetailList) {
        List<PriceRestParam> paramList = new ArrayList<>();
        if (bsOrderDetailList != null) {
            List<BsOrderDetail> bsOrderDetails = bsOrderDetailList.getArchives();
            for (BsOrderDetail bsOrderDetail : bsOrderDetails) {
                PriceRestParam param = new PriceRestParam();
                paramList.add(param);
            }
        } else if (buyerBatchOrderDetailList != null) {
            List<BuyerBatchOrderDetail> buyerBatchOrderDetails = buyerBatchOrderDetailList.getArchives();
            for (BuyerBatchOrderDetail buyerBatchOrderDetail : buyerBatchOrderDetails) {
                PriceRestParam param = new PriceRestParam();
                paramList.add(param);
            }
        } else {
            throw new BusinessException("", "");
        }
        return paramList;
    }


    /**
     * 封装成 List<PriceEntity>
     *
     * @param restResultList
     * @return
     */
    private List<PriceEntity> getPriceEntityList(List<PriceRestResult> restResultList) {
        List<PriceEntity> priceEntityList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(restResultList)) {

        } else {
            throw new BusinessException("", "");
        }
        return priceEntityList;
    }


    //=====================================================================================================================

    /**
     * 刘涛用
     *
     * @param priceListRestParam
     * @return
     */
    public PriceListRestResult getPriceListRestResult(PriceListRestParam priceListRestParam) {
        PriceListRestResult restResult = new PriceListRestResult();
        List<PriceRestResult> priceRestResults = new ArrayList<>();
        if (priceListRestParam == null) {
            throw new BusinessException("", "");
        }
        List<PriceRestParam> paramList = priceListRestParam.getParamList();
        if (CollectionUtils.isEmpty(paramList)) {
            throw new BusinessException("", "");
        }

        for (PriceRestParam param : paramList) {
            PriceRestResult result = new PriceRestResult();
            result.setGoodsId(param.getGoodsId());
            result.setGoodsPrice(new BigDecimal(new Random().nextInt(100) + 10));
            result.setCountRange(this.getCountRange(DecimalUtils.getBigDecimal(param.getGoodsQuantity())));
            priceRestResults.add(result);
        }
        restResult.setPriceRestResults(priceRestResults);
        return restResult;
    }


    public Integer getCountRange(BigDecimal qty) {
        Integer countInteger = 0;
        if(DecimalUtils.ge(qty,new BigDecimal(500))){
            countInteger=1;
        }

        return countInteger;
    }


    @Test
    public void test() {
        List<PriceChannelQueryParam> priceChannelQueryParams = new ArrayList<>();
        PriceChannelQueryParam param = new PriceChannelQueryParam();
        param.setGoodsId("1");
        param.setGoodsQuantity(new BigDecimal(2));

        priceChannelQueryParams.add(param);

        System.out.println(this.getPriceChannelDetailList(priceChannelQueryParams));
    }


}
