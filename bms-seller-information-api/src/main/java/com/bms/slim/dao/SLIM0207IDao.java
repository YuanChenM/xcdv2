package com.bms.slim.dao;

import com.bms.slim.bean.entity.SlimDesignatSlaughterPermit;
import com.framework.boot.base.BaseDao;

import java.util.List;

public interface SLIM0207IDao extends BaseDao {

    /**
     * 新增生产商生产资质-定点屠宰许可证
     */
    int saveDesignatSlaughterPermits(List<SlimDesignatSlaughterPermit> slimDesignatSlaughterPermits);

}
