package com.bms.order.external.archive;

import com.alibaba.fastjson.TypeReference;
import com.bms.order.constant.UrlConst;
import com.bms.order.constant.enumeration.IvType;
import com.bms.order.constant.enumeration.LinvUom;
import com.bms.order.constant.enumeration.OwnerType;
import com.bms.order.constant.enumeration.SalePlatformType;
import com.bms.order.constant.i18n.ErrorCode;
import com.bms.order.constant.i18n.ModuleCode;
import com.bms.order.external.bean.entity.StockEntity;
import com.bms.order.external.bean.param.*;
import com.bms.order.external.bean.result.*;
import com.bms.order.util.ApplicationContextHelper;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.plugin.configserver.ConfigServerPropertyLoad;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.DecimalUtils;
import com.framework.core.utils.NumberUtils;
import com.framework.core.utils.StringUtils;
import com.framework.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.*;

/**
 * 库存 Created by ni_shaotang on 2017/3/2.
 */
//@Component
public class Ydp extends AbstractExternalArchive {

    public static final Logger logger = LoggerFactory.getLogger(Ydp.class);

//    @Value("${ydp01}")
//    private static String ydpUrl;

    private Ydp() {
    }

    /**
     * 通知云冻品收货
     *
     * @param omsOrderIds
     * @return
     */
    public static void pushMsg(List<Long> omsOrderIds) {
        Assert.isTrue(omsOrderIds.size() > 0);
        YDPRestParam params = new YDPRestParam();
        params.setOmsOrderIds(omsOrderIds);
        String url = ApplicationContextHelper.getApplicationContext().getEnvironment().getProperty("ydp01");
//        String url="http://test.yundongpin.com/boss/delivery.htm";
        TypeReference<YDPRestResult> typeReference = new TypeReference<YDPRestResult>() {
        };
        Ydp stock = new Ydp();
        YDPRestResult result = stock.getRestClient().post(url, params, typeReference);

        logger.debug("YDP返回信息：", result.getMessage());

    }

}