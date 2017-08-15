package com.bms.slpd.services.impl;

import com.alibaba.fastjson.TypeReference;
import com.bms.common.rest.apiclient.RestApiClientFactory;
import com.bms.slpd.bean.entity.SlpdManufacturerProduct;
import com.bms.slpd.bean.param.SLPD1808IManufacturerParam;
import com.bms.slpd.bean.param.SLPD1808IParam;
import com.bms.slpd.bean.result.SLPD1808IResult;
import com.bms.slpd.constant.ApiUrlConstant;
import com.bms.slpd.constant.MessageConstant;
import com.bms.slpd.dao.SLPD1808IDao;
import com.bms.slpd.services.SLPD1808IService;
import com.bms.slpd.utils.RestApiUtils;
import com.framework.base.consts.NumberConst;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.DateUtils;
import com.framework.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SLPD1808IServiceImpl extends BaseServiceImpl implements SLPD1808IService {

    @Autowired
    private RestApiClientFactory restApiClientFactory;

    @Autowired
    private SLPD1808IDao slpd1808IDao;

    @Override
    public BaseDao getBaseDao() {
        return slpd1808IDao;
    }

    @Override
    public SLPD1808IResult deleteManufacturerProducts(SLPD1808IParam slpd1808iParam) {
        final String userId = this.getLoginUserId();
        final Date time = DateUtils.getCurrent();
        int total = NumberConst.IntDef.INT_ZERO;
        List<SLPD1808IManufacturerParam> params = slpd1808iParam.getManufacturerParams();
        // 查询制造商产品id是否被代理商产品使用
        List<Long> usedManufacturerIds = this.slpd1808IDao.findUsedManufacturerProducts(params);

        SlpdManufacturerProduct manufacturerProduct = null;
        List<Long> manufacturerIds = new ArrayList<>();
        for (SLPD1808IManufacturerParam manufacturerParam : params) {
            if (CollectionUtils.isNotEmpty(usedManufacturerIds)) {
                if (usedManufacturerIds.contains(manufacturerParam.getManufacturerProductId())){
                    throw new BusinessException(MessageConstant.MODULE_NAME_EN, "制造商产品已生成代理商产品，请先删除代理商产品");
                }
            } else {

                // 根据制造商产品id查询制造商产品sku
                String manuPdSku = slpd1808IDao.findManufacturerProductSku(manufacturerParam.getManufacturerProductId());

                HashMap<String,Object> loadLinvParamMap = new HashMap<>();
                List<String> skuCode = new ArrayList<>();
                skuCode.add(manuPdSku);

                loadLinvParamMap.put("skuCode",skuCode);
                loadLinvParamMap.put("pagination",null);

                String linvUrl = RestApiUtils.getUrl(ApiUrlConstant.LINV.CONTEXT_PATH,ApiUrlConstant.LINV.API0102,ApiUrlConstant.LINV.LOCAL_FLAG,ApiUrlConstant.LINV.LOCALHOST);
                TypeReference<HashMap<String, Object>> typeReference = new TypeReference<HashMap<String, Object>>() {};
                Map<String, Object> linvResultMap = this.restApiClientFactory.newApiRestClient().post(linvUrl, loadLinvParamMap, typeReference);
                if(NumberConst.IntDef.INT_ZERO < (Integer) linvResultMap.get("total")){
                    throw new BusinessException(MessageConstant.MODULE_NAME_EN, "该制造商产品已存在对应的产品库存，无法删除该制造商产品");
                } else {
                    manufacturerProduct = BeanUtils.toBean(manufacturerParam, SlpdManufacturerProduct.class);
                    manufacturerProduct.setUpdId(userId);
                    manufacturerProduct.setUpdTime(time);

                    int count = this.slpd1808IDao.updateManufacturerProducts(manufacturerProduct);
                    if (NumberConst.IntDef.INT_ZERO == count)
                        throw new BusinessException(MessageConstant.MODULE_NAME_EN, "删除制造商产品失败,请刷新页面重试");
                    total++;
                    manufacturerIds.add(manufacturerParam.getManufacturerProductId());
                }
            }
        }
        SLPD1808IResult result = new SLPD1808IResult();
        result.setCount(total);
        result.setManufacturerProductIds(manufacturerIds);
        result.setMessage(new String[]{MessageConstant.SUCCESS});
        return result;
    }


}
