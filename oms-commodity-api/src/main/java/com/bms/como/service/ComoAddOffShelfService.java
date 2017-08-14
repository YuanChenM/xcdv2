package com.bms.como.service;

import com.bms.como.bean.param.*;
import com.bms.como.bean.result.ComoShelfListRsResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by zhang_jian4 on 2017/3/31.
 */
public interface ComoAddOffShelfService extends BaseService {

    /**
     * 新增商品上下架操作记录
     */
    @Transactional
    int saveShelfListRecord(ComoAddOffShelfRsParam addOffShelfRsParam, Date addTime, Date offTime);

//    /**
//     * 批量新增商品上架
//     */
//    @Transactional
//    int saveAddShelfList(ComoShelfListRsParam shelfListRsParam, ComoAddOffShelfRsParam addOffShelfRsParam);

    /**
     * 修改物流区商品的上下架状态
     */
    @Transactional
    int modifyShelfList(ComoShelfListRsParam shelfListRsParam, ComoAddOffShelfRsParam addOffShelfRsParam);


    /**
     * 查询商品ID和物流区
     */
    @Transactional(readOnly = true)
    List<ComoShelfListRsParam> searchCommodityIdAndLgcsAreaId(ComoAddOffShelfRsParam addOffShelfRsParam);


    /**
     * 商品销售上下架管理
     */
    @Transactional(readOnly = true)
    ComoShelfListRsResult handleCommodityAddOffShelf(ComoAddOffShelfRsParam addOffShelfRsParam);

}
