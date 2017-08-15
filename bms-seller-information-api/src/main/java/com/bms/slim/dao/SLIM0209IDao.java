package com.bms.slim.dao;

import com.bms.slim.bean.BaseTarget;
import com.bms.slim.bean.UpdateEntity;
import com.bms.slim.bean.entity.SlimDesignatSlaughterPermit;
import com.framework.boot.base.BaseDao;

public interface SLIM0209IDao extends BaseDao {

    /**
     * 修改生产商生产资质-定点屠宰许可证
     */
    int updateDesignatSlaughterPermit(UpdateEntity<SlimDesignatSlaughterPermit, BaseTarget> updateEntity);

}
