package com.bms.common.service.impl;

import com.bms.common.dao.CommonDao;
import com.bms.common.param.VersionValidatorParam;
import com.bms.common.service.CommonService;
import com.framework.exception.BusinessException;
import com.framework.exception.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by mao_yejun on 2016/12/1.
 */
@Service
public class CommonServiceImpl implements CommonService {
    @Autowired
    private CommonDao commonDao;

    @Override
    public void updateVersion(String tableName, String[] primaryKey, Object[] primaryKeyValue, int version) {
        VersionValidatorParam param = new VersionValidatorParam();
        if (primaryKey == null || primaryKeyValue == null) {
            throw new SystemException("传入数据格式错误,primaryKey或者primaryKeyValue为空");
        }
        int primaryKeyLength = primaryKey.length;
        int primaryKeyValueLength = primaryKeyValue.length;
        if (primaryKeyLength != primaryKeyValueLength) {
            throw new SystemException("传入数据格式错误,primaryKey和primaryKeyValue 长度不一致");
        }

        StringBuffer condition = new StringBuffer();
        for (int i = 0; i < primaryKeyLength; i++) {
            String key = primaryKey[i];
            Object value = primaryKeyValue[i];
            condition.append(" AND " + key + " = '" + value + "'");
        }

        param.setFilterObject("tableName", tableName);
        param.setFilterObject("condition", condition);
        param.setFilterObject("version", version);

        int rs = commonDao.updateVersion(param);
        if (rs == 0) {
            throw new BusinessException("COMMON", "101");
        }

    }
}
