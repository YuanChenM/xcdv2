package com.bms.slim.dao;

import com.bms.slim.bean.BaseTarget;
import com.bms.slim.bean.UpdateEntity;
import com.bms.slim.bean.entity.SlimIsoManagementSystemCertification;
import com.framework.boot.base.BaseDao;

public interface SLIM0221IDao extends BaseDao {

    /**
     * 修改生产商生产资质-管理体系认证证书
     */
    int updateIsoManagementSystemCertification(UpdateEntity<SlimIsoManagementSystemCertification, BaseTarget> updateEntity);

}
