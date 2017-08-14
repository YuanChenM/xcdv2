package com.bms.como.dao;

import com.bms.como.bean.entity.ComoCommodityInfo;
import com.bms.como.bean.entity.ComoSaleStatus;
import com.bms.como.bean.param.ComoDefaultRsParam;
import com.bms.como.bean.param.ComoInfoRsParam;
import com.framework.boot.base.BaseDao;
import org.apache.ibatis.annotations.Param;

/**
 * Created by wang_haichun on 2017/3/28.
 */
public interface ComoInfoDao extends BaseDao {

    /**
     * 查询默认销售状态
     */
    ComoSaleStatus findDefaultSaleStatu();

    /**
     * 根据产品SKU + 年月 查询数量
     */
    int findComoCodeCount(@Param("commodityCode") String commodityCode);

    /**
     * 修改产品下的默认商品为非默认
     */
    int modifyComoDefault(ComoCommodityInfo comoCommodityInfo);

    /**
     * 查询产品下是否有默认商品
     */
    int findComoDefaultCount(ComoDefaultRsParam param);

    /**
     * 查询商品数据中是否已存在
     */
    int checkComoInfoRsParam(ComoInfoRsParam comoInfoRsParam);

    /**
     * 根据商品名称查询商品信息
     */
    int findComoInfoByName(ComoInfoRsParam comoInfoRsParam);
}
