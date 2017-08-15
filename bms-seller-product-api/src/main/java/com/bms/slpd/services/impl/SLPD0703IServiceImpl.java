package com.bms.slpd.services.impl;

import com.bms.slpd.bean.UpdateEntity;
import com.bms.slpd.bean.entity.SlpdProducerProduct;
import com.bms.slpd.bean.entity.target.SlpdProducerProductTarget;
import com.bms.slpd.bean.param.SLPD0703IParam;
import com.bms.slpd.bean.param.SLPD1806IParam;
import com.bms.slpd.bean.param.field.SLPD0703IProducerProductParam;
import com.bms.slpd.bean.result.SLPD0703IResult;
import com.bms.slpd.bean.result.field.SLPD1806IManufacturerProducerProductResult;
import com.bms.slpd.constant.MessageConstant;
import com.bms.slpd.dao.SLPD0703IDao;
import com.bms.slpd.services.SLPD0703IService;
import com.bms.slpd.services.SLPD1806IService;
import com.framework.base.consts.NumberConst;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.DateUtils;
import com.framework.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SLPD0703IServiceImpl extends BaseServiceImpl implements SLPD0703IService {

    @Autowired
    private SLPD0703IDao slpd0703IDao;
    @Autowired
    private SLPD1806IService slpd1806IService;

    @Override
    public BaseDao getBaseDao() {
        return slpd0703IDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SLPD0703IResult updateProducerProducts(SLPD0703IParam requestParam) {
        SLPD0703IResult result = new SLPD0703IResult();

        List<Long> producerProductIds = new ArrayList<>();
        List<SLPD0703IProducerProductParam> productList = requestParam.getProducerProductParams();
        for (SLPD0703IProducerProductParam param : productList) {
            producerProductIds.add(param.getProducerProductId());
        }

        //查询生产商产品是否已经生成制造商产品
        SLPD1806IParam slpd1806iParam = new SLPD1806IParam();
        slpd1806iParam.setProducerProductIds(producerProductIds);
        slpd1806iParam.setDelFlg(false);
        BaseRestPaginationResult<SLPD1806IManufacturerProducerProductResult> manufacturerProduct = slpd1806IService.findManufacturerProducts(slpd1806iParam);
        if(NumberConst.IntDef.INT_ZERO < manufacturerProduct.getTotal()){
            result.setMessages(new String[]{"F", ("生产商产品已生成制造商产品,请先删除制造商产品.").toString()});
            return result;
        }

        String userId = super.getLoginUserId();
        Date updTime = DateUtils.getCurrent();

        List<SLPD0703IProducerProductParam> producerProductList = requestParam.getProducerProductParams();
        SlpdProducerProductTarget target = setTarget(requestParam);
        List<UpdateEntity<SlpdProducerProduct, SlpdProducerProductTarget>> updateList = new ArrayList<>();
        SlpdProducerProduct producerProduct = null;

        for (SLPD0703IProducerProductParam param : producerProductList) {
            UpdateEntity<SlpdProducerProduct, SlpdProducerProductTarget> updateEntity = new UpdateEntity<>();
            producerProduct = BeanUtils.toBean(param, SlpdProducerProduct.class);
            producerProduct.setUpdId(userId);
            producerProduct.setUpdTime(updTime);
            updateEntity.setEntity(producerProduct);
            updateEntity.setTarget(target);
            updateList.add(updateEntity);
        }

        int count = NumberConst.IntDef.INT_ZERO;
        for (UpdateEntity<SlpdProducerProduct, SlpdProducerProductTarget> updateEntity : updateList) {
            int producerCount = slpd0703IDao.updateProducerProduct(updateEntity);
            if (NumberConst.IntDef.INT_ZERO < producerCount) {
                count += producerCount;
                producerProductIds = new ArrayList<>();
                producerProductIds.add(updateEntity.getEntity().getProducerProductId());
            } else {
                throw new BusinessException(MessageConstant.MODULE_NAME_ZH,"producerProductId:" + updateEntity.getEntity().getProducerProductId()+"不存在");
            }
        }

        result.setCount(count);
        result.setProducerProductIds(producerProductIds);
        return result;
    }

    /**
     * 设置target
     */
    public SlpdProducerProductTarget setTarget(SLPD0703IParam requestParam) {
        String[] targets = requestParam.getTargets();
        StringBuilder builder = new StringBuilder();
        SlpdProducerProductTarget producerProductTarget = new SlpdProducerProductTarget();

        for (String str : targets) {
            if ("producerName".equals(str)) {
                producerProductTarget.setProducerNameFlg(true);
            } else if ("delFlg".equals(str)) {
                producerProductTarget.setDelFlgFlg(true);
            } else {
                builder.append(str).append(",");
            }
        }
        if (!ObjectUtils.isEmpty(builder)) {
            throw new BusinessException(MessageConstant.MODULE_NAME_ZH, builder.append("指定的target有误").toString());
        }

        return producerProductTarget;
    }
}