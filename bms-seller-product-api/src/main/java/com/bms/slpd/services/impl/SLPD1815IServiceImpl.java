package com.bms.slpd.services.impl;

import com.bms.slpd.bean.param.SLPD1815IParam;
import com.bms.slpd.bean.result.field.SLPD1815IItemPropertyResult;
import com.bms.slpd.constant.CodeMasterConstant;
import com.bms.slpd.dao.SLPD1815IDao;
import com.bms.slpd.services.SLPD1815IService;
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
public class SLPD1815IServiceImpl extends BaseServiceImpl implements SLPD1815IService {

    @Autowired
    private CodeMasterUtils codeMasterUtils;
    @Autowired
    private SLPD1815IDao slpd1815iDao;

    @Override
    public BaseDao getBaseDao() {
        return this.slpd1815iDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BaseRestPaginationResult<SLPD1815IItemPropertyResult> findItemProperties(SLPD1815IParam slpd1815iParam) {
        BaseRestPaginationResult<SLPD1815IItemPropertyResult> restResult = super.findPageList(slpd1815iParam);
        this.fillSpecifiedFields(restResult.getData());
        return restResult;
    }

    /**
     * 补充指定数据
     */
    private void fillSpecifiedFields(List<SLPD1815IItemPropertyResult> itemProperties) {
        if (CollectionUtils.isNotEmpty(itemProperties)) {
            this.fillCodeMasters(itemProperties);
        }
    }

    /**
     * 产品添加中文常量
     */
    private void fillCodeMasters(List<SLPD1815IItemPropertyResult> itemProperties) {
        Map<String, String> auditStuMap = this.codeMasterUtils.getCodeMaster(CodeMasterConstant.AuditStu.NODE);
        Map<String, String> productSourceTypeMap = this.codeMasterUtils.getCodeMaster(CodeMasterConstant.ProductSourceType.NODE);

        for (SLPD1815IItemPropertyResult itemProperty : itemProperties) {
            itemProperty.setAuditStuStr(auditStuMap.get(itemProperty.getAuditStu()));
            itemProperty.setSourceTypeStr(productSourceTypeMap.get(itemProperty.getSourceType()));
        }
    }

}