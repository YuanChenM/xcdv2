package com.bms.puch.rest;

import com.bms.puch.bean.param.PuchReceivePageParam;
import com.bms.puch.bean.param.PuchReceiveParam;
import com.bms.puch.bean.result.PuchReceiveRestResult;
import com.bms.puch.service.PuchDetailService;
import com.bms.puch.service.PuchReceiveService;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseRestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by guan_zhongheng on 2017/3/17.
 */
@RestController
@Api(value = "采购入库单查询接口",
        description = "查询采购入库相关信息",
        position = 1,
        tags = "PUCH0102IRestController")
public class PUCH0102IRestController extends BaseRestController{

    @Autowired
    private PuchReceiveService puchReceiveService;

    /**
     * 区域信息查询
     *
     * @param param
     * @return
     */
    @ApiOperation(value = "采购订单信息查询",
            notes = "采购订单信息查询")
    @RequestMapping(value = "/purchase/receive/_search",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public BaseRestPaginationResult<PuchReceiveRestResult> searchPuchReceiveInfo(@RequestBody PuchReceivePageParam param) {
          return puchReceiveService.findPageList(param);
    }
}
