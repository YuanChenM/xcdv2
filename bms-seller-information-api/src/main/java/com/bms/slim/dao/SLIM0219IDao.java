package com.bms.slim.dao;

import com.bms.slim.bean.entity.SlimIsoManagementSystemCertification;
import com.framework.boot.base.BaseDao;

import java.util.List;

public interface SLIM0219IDao extends BaseDao {

    /**
     * 新增生产商生产资质-管理体系认证证书
     */
    int saveIsoManagementSystemCertification(List<SlimIsoManagementSystemCertification> slimIsoManagementSystemCertifications);

}
