package com.bms.slpd.services.impl;

import com.bms.slpd.bean.param.SLPD1202IParam;
import com.bms.slpd.bean.result.field.SLPD1202ILgcsAreaCommodityResult;
import com.bms.slpd.constant.CodeMasterConstant;
import com.bms.slpd.dao.SLPD1202IDao;
import com.bms.slpd.services.SLPD1202IService;
import com.bms.slpd.utils.CodeMasterUtils;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SLPD1202IServiceImpl extends BaseServiceImpl implements SLPD1202IService {

    @Autowired
    private SLPD1202IDao slpd1202IDao;
    @Autowired
    private CodeMasterUtils codeMasterUtils;

    @Override
    public BaseDao getBaseDao() {
        return slpd1202IDao;
    }

    @Override
    public BaseRestPaginationResult<SLPD1202ILgcsAreaCommodityResult> findLgcsCommodities(SLPD1202IParam param) {
        BaseRestPaginationResult<SLPD1202ILgcsAreaCommodityResult> result = super.findPageList(param);
        this.fillCodeMasters(result.getData());
        return result;
    }

    /**
     * 上下架添加中文常量
     */
    private void fillCodeMasters(List<SLPD1202ILgcsAreaCommodityResult> list) {
        Map<String, String> shelfStuStrMap = this.codeMasterUtils.getCodeMaster(CodeMasterConstant.ShelfStu.NODE);
        Map<String, String> demandStrMap = this.codeMasterUtils.getCodeMaster(CodeMasterConstant.ProductDemandGrade.NODE);
        Map<String, String> gradeStrMap = this.codeMasterUtils.getCodeMaster(CodeMasterConstant.QualityGradeType.NODE);

        String demandGrade = null;
        for (SLPD1202ILgcsAreaCommodityResult result : list) {
            demandGrade = result.getProductDemandGrade();
            result.setShelfStuStr(shelfStuStrMap.get(result.getShelfStu()));
            result.setQualityGradeTypeStr(gradeStrMap.get(result.getQualityGradeType()));
            if ("0".equals(demandGrade) || StringUtils.isEmpty(demandGrade)) {
                result.setProductDemandGradeStr("暂未分类");
            } else {
                result.setProductDemandGradeStr(demandStrMap.get(result.getProductDemandGrade()));
            }
        }
    }
}
