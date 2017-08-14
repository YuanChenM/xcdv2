package com.bms.linv.rest;

import com.bms.linv.bean.param.LINV0119IParam;
import com.bms.linv.business.LinvAdjustBusinessService;
import com.framework.boot.base.BaseRestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zheng_xu on 2017/5/03.
 */
@RestController
@Api(description = "商品库存调整",
    tags = "LINV0119IRestController",
    value = "LINV0119IRestController")
public class LINV0119IRestController extends BaseRestController {
    @Autowired
    private LinvAdjustBusinessService linvAdjustBusinessService;

    @ApiOperation(value = "商品库存调整",
        notes = "商品库存调整")
    @RequestMapping(value = "/linv/comoInv/_adjust",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public String adjustComoInv(@RequestBody LINV0119IParam param) {
        String message = "";
        try {
            linvAdjustBusinessService.adjustComoInv(param);
            message = "SUCCESS";
        } catch (Exception e) {
            e.printStackTrace();
            message = "ERROR";
        }
        return message;
    }
}
