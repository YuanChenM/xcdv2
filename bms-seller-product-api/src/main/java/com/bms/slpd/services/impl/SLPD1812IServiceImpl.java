package com.bms.slpd.services.impl;

import com.bms.slpd.bean.param.SLPD1812IParam;
import com.bms.slpd.bean.result.field.SLPD1812IProductResult;
import com.bms.slpd.constant.CodeMasterConstant;
import com.bms.slpd.dao.SLPD1812IDao;
import com.bms.slpd.services.SLPD1812IService;
import com.bms.slpd.utils.CodeMasterUtils;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SLPD1812IServiceImpl extends BaseServiceImpl implements SLPD1812IService {

    @Autowired
    private CodeMasterUtils codeMasterUtils;
    @Autowired
    private SLPD1812IDao slpd1812iDao;

    @Override
    public BaseDao getBaseDao() {
        return this.slpd1812iDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BaseRestPaginationResult<SLPD1812IProductResult> findProducts(SLPD1812IParam slpd1812iParam) {
        BaseRestPaginationResult<SLPD1812IProductResult> restResult = super.findPageList(slpd1812iParam);
        this.fillSpecifiedFields(restResult.getData());
        return restResult;
    }

    /**
     * 补充指定数据
     */
    private void fillSpecifiedFields(List<SLPD1812IProductResult> products) {
        if (CollectionUtils.isNotEmpty(products)) {
            this.fillCodeMasters(products);
        }
    }

    /**
     * 产品添加中文常量
     */
    private void fillCodeMasters(List<SLPD1812IProductResult> products) {
        Map<String, String> qualityGradeTypeMap = this.codeMasterUtils.getCodeMaster(CodeMasterConstant.QualityGradeType.NODE);
        Map<String, String> auditStuMap = this.codeMasterUtils.getCodeMaster(CodeMasterConstant.AuditStu.NODE);
        Map<String, String> productSourceTypeMap = this.codeMasterUtils.getCodeMaster(CodeMasterConstant.ProductSourceType.NODE);
        Map<String, String> brandTypeMap = this.codeMasterUtils.getCodeMaster(CodeMasterConstant.BrandType.NODE);

        for (SLPD1812IProductResult product : products) {
            product.setQualityGradeTypeStr(qualityGradeTypeMap.get(product.getQualityGradeType()));
            product.setAuditStuStr(auditStuMap.get(product.getAuditStu()));

            product.setSourceTypeStr(productSourceTypeMap.get(product.getSourceType()));
            product.setBrandTypeStr(brandTypeMap.get(product.getBrandType()));
        }
    }

}