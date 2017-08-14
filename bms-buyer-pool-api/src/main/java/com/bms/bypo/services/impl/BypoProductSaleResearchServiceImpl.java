/*
 * 2016/12/20 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.bypo.services.impl;

import com.bms.bypo.bean.entity.BypoProductSaleResearch;
import com.bms.bypo.bean.param.BaseBean;
import com.bms.bypo.bean.param.ProductSaleResearchRsParam;
import com.bms.bypo.dao.BypoProductSaleResearchDao;
import com.bms.bypo.services.BypoProductSaleResearchService;
import com.framework.base.consts.NumberConst;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>BypoProductSaleResearchService接口实现类。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
@Service
public class BypoProductSaleResearchServiceImpl extends BaseServiceImpl implements BypoProductSaleResearchService {

    @Autowired
    private BypoProductSaleResearchDao bypoProductSaleResearchDao;

    @Override
    public BaseDao getBaseDao() {
        return bypoProductSaleResearchDao;
    }

    @Override
    public Integer insert(ProductSaleResearchRsParam param) {
        BypoProductSaleResearch productSaleResearch = BeanUtils.toBean(param, BypoProductSaleResearch.class);
        Date curTime = DateUtils.getCurrent();
        Long researchId = this.maxId("BYPO_PRODUCT_SALE_RESEARCH");
        productSaleResearch.setResearchId(researchId);
        productSaleResearch.setUpdTime(curTime);
        productSaleResearch.setUpdId(getLoginUserId());
        productSaleResearch.setCrtTime(curTime);
        productSaleResearch.setCrtId(getLoginUserId());
        productSaleResearch.setDelFlg(false);
        productSaleResearch.setVersion(NumberConst.IntDef.INT_ONE);
        return this.save(productSaleResearch);
    }

    @Override
    public Integer update(BaseBean<ProductSaleResearchRsParam, ProductSaleResearchRsParam> param) {
        Date curTime = DateUtils.getCurrent();
        BaseBean<BypoProductSaleResearch, BypoProductSaleResearch> beanEntity;
        beanEntity = new BaseBean<>();
        BypoProductSaleResearch filterEntity = BeanUtils.toBean(param.getFilter(), BypoProductSaleResearch.class);
        BypoProductSaleResearch targetEntity = BeanUtils.toBean(param.getTarget(), BypoProductSaleResearch.class);
        targetEntity.setUpdId(getLoginUserId());
        targetEntity.setUpdTime(curTime);
        beanEntity.setFilter(filterEntity);
        beanEntity.setTarget(targetEntity);
        int line = bypoProductSaleResearchDao.modify(beanEntity);
        return line;
    }
}