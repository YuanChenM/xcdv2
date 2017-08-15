package com.bms.slpd.dao;

import com.bms.slpd.bean.param.SLPD0104IParam;
import com.bms.slpd.bean.result.wrapper.SlpdMachiningResult;
import com.framework.boot.base.BaseDao;

import java.util.List;


public interface SLPD0104IDao extends BaseDao {
    /**
     * 查询产品二级分类
     */
    List<SlpdMachiningResult> findMachinings(SLPD0104IParam slpd0104IParam);
}
