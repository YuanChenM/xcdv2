package com.bms.como.service.impl;

import com.bms.como.bean.entity.ComoProductInfo;
import com.bms.como.bean.param.BaseBean;
import com.bms.como.bean.param.ProductInfoCreateRsParam;
import com.bms.como.bean.param.ProductInfoRsParam;
import com.bms.como.bean.result.ComoProductInfoResult;
import com.bms.como.bean.result.ProductInfoResult;
import com.bms.como.constant.MessageConstant;
import com.bms.como.constant.TableConstant;
import com.bms.como.dao.ComoProductInfoDao;
import com.bms.como.service.ComoProductInfoService;
import com.framework.base.consts.NumberConst;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.DateUtils;
import com.framework.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by wang_haichun on 2017/3/29.
 */
@Service
public class ComoProductInfoServiceImpl extends BaseServiceImpl implements ComoProductInfoService {

    @Autowired
    private ComoProductInfoDao comoProductInfoDao;


    @Override
    public BaseDao getBaseDao() {
        return comoProductInfoDao;
    }

    @Override
    public BaseRestPaginationResult<ProductInfoResult> searchProductInfo(ProductInfoRsParam productInfoRsParam) {
        return super.findPageList(productInfoRsParam);
    }

    @Override
    public ComoProductInfoResult createProductInfo(ProductInfoCreateRsParam productInfoCreateRsParam) {
        //排他
        Set<String> productIds = new HashSet<>();
        for(ComoProductInfo productInfo : productInfoCreateRsParam.getProductInfos()){
            productIds.add(productInfo.getProductId());
        }

        ProductInfoRsParam productInfoRsParam = new ProductInfoRsParam();
        productInfoRsParam.setPagination(null);
        productInfoRsParam.setProductIds(new ArrayList<>(productIds));

        BaseRestPaginationResult<ProductInfoResult> existProducts = this.searchProductInfo(productInfoRsParam);
        if(null != existProducts && CollectionUtils.isNotEmpty(existProducts.getData())){
            throw new BusinessException(MessageConstant.MODULE_NAME_ZH, "产品ID已经存在");
        }


        ComoProductInfoResult result = new ComoProductInfoResult();
        List<Long> productPids = new ArrayList<>();
        int count = NumberConst.IntDef.INT_ZERO;
        if(productInfoCreateRsParam != null && CollectionUtils.isNotEmpty(productInfoCreateRsParam.getProductInfos())){
            String userId = super.getLoginUserId();
            Date date = DateUtils.getCurrent();
            for(ComoProductInfo productInfo : productInfoCreateRsParam.getProductInfos()){
                Long maxId = this.maxId(TableConstant.Name.COMO_PRODUCT_INFO);

                productInfo.setProductPid(maxId);
                productInfo.setCrtId(userId);
                productInfo.setCrtTime(date);
                productInfo.setUpdId(userId);
                productInfo.setUpdTime(date);

                productPids.add(maxId);
            }
            count = super.batchSave(productInfoCreateRsParam.getProductInfos());
            result.setMessage(MessageConstant.SUCCESS);
        }else {
            result.setMessage(MessageConstant.FAILURE);
        }
        result.setCount(count);
        result.setProductPids(productPids);
        return result;
    }

    @Override
    public ComoProductInfoResult modityProductInfo(BaseBean<ComoProductInfo, ComoProductInfo> comoProductInfoBean) {
        ComoProductInfoResult result = new ComoProductInfoResult();

        ComoProductInfo comoProductInfoFilter = comoProductInfoBean.getFilter();
        ComoProductInfo comoProductInfoTarget = comoProductInfoBean.getTarget();
        BaseBean<ComoProductInfo, ComoProductInfo> baseBean = new BaseBean<>();
        baseBean.setFilter(comoProductInfoFilter);


        comoProductInfoTarget.setUpdId(super.getLoginUserId());
        comoProductInfoTarget.setUpdTime(DateUtils.getCurrent());

        baseBean.setTarget(comoProductInfoTarget);

        List<Long> productPids = new ArrayList<>();
        int count = comoProductInfoDao.modify(baseBean);
        if(count == NumberConst.IntDef.INT_ZERO){
            result.setMessage("修改失败,请刷新重试");
        }else {
            result.setMessage(MessageConstant.SUCCESS);
        }
        productPids.add(comoProductInfoTarget.getProductPid());
        result.setCount(count);
        result.setProductPids(productPids);
        return result;
    }
}
