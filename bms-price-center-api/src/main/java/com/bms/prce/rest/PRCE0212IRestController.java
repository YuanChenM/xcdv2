package com.bms.prce.rest;

import com.bms.prce.bean.param.PRCE0212IParam;
import com.bms.prce.service.PrceProductInfoService;
import com.framework.boot.base.BaseRestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 商品同步接口
 *
 * @author zhou_ling
 * @version 1.0
 *
 */
@RestController
@Api(description = "商品同步",
        tags = "PRCE0212IRestController", value = "PRCE0212I", position = 0)
public class PRCE0212IRestController extends BaseRestController {

    @Autowired
    private PrceProductInfoService prceProductInfoService;

    /**
     * 商品同步接口
     * @Param prce0212IParam
     * @return  修改结果
     *
     */
    @ApiOperation(value = "商品同步", notes = "同步商品修改数据")
    @RequestMapping(value = "/prce/goods/_sync", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public int prceGoodsSync() {
        // 商品同步
       return prceProductInfoService.prceGoodsSync();
    }
}
