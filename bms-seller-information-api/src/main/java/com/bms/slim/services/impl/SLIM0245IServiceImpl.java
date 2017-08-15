package com.bms.slim.services.impl;

import com.bms.slim.bean.param.SLIM0245IParam;
import com.bms.slim.bean.result.field.SLIM0245IContactResult;
import com.bms.slim.constant.CodeMasterConstant;
import com.bms.slim.dao.SLIM0245IDao;
import com.bms.slim.services.SLIM0245IService;
import com.bms.slim.utils.CodeMasterUtils;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SLIM0245IServiceImpl extends BaseServiceImpl implements SLIM0245IService {

    @Autowired
    private SLIM0245IDao slim0245IDao;
    @Autowired
    private CodeMasterUtils codeMasterUtils;

    @Override
    public BaseDao getBaseDao() {
        return slim0245IDao;
    }


    @Override
    public BaseRestPaginationResult<SLIM0245IContactResult> findContacts(SLIM0245IParam param) {
        BaseRestPaginationResult<SLIM0245IContactResult> restResult = this.findPageList(param);
        this.fillCodeMasterStr(restResult.getData());
        return restResult;
    }

    /**
     * 联系人类型,工作单位类型,添加中文常量
     */
    private void fillCodeMasterStr(List<SLIM0245IContactResult> contactList) {
        Map<String, String> workunitTypeMap = this.codeMasterUtils.getCodeMaster(CodeMasterConstant.WorkunitType.NODE);
        Map<String, String> contactTypeMap = this.codeMasterUtils.getCodeMaster(CodeMasterConstant.ContactType.NODE);
        for (SLIM0245IContactResult contactResult : contactList) {
            contactResult.setWorkunitTypeStr(workunitTypeMap.get(contactResult.getWorkunitType()));
            if (StringUtils.isNotEmpty(contactResult.getContactType()))
            contactResult.setContactTypeStr(contactTypeMap.get(contactResult.getContactType()));
        }

    }
}
