package com.bms.linv.rest;

import com.bms.linv.bean.param.LINV0118IParam;
import com.bms.linv.bean.param.RestRequest;
import com.bms.linv.bean.result.LINV0118IFailedParam;
import com.bms.linv.bean.result.LINV0118IResult;
import com.bms.linv.bean.result.LINV0118ISucceedParam;
import com.bms.linv.business.LinvAdjustBusinessService;
import com.framework.boot.base.BaseRestController;
import com.framework.exception.BusinessException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zheng_xu on 2017/5/03.
 */
@RestController
@Api(description = "库存调整",
    tags = "LINV0118IRestController",
    value = "LINV0118IRestController",
    position = 0)
public class LINV0118IRestController extends BaseRestController {
    @Autowired
    private LinvAdjustBusinessService linvAdjustBusinessService;

    @ApiOperation(value = "库存调整",
        notes = "库存调整")
    @RequestMapping(value = "/linv/_syncLotInv",
            consumes = {
                    MediaType.APPLICATION_XML_VALUE},
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public LINV0118IResult adjustLoads(@RequestBody RestRequest<LINV0118IParam> request) {
        LINV0118IResult result = new LINV0118IResult();
        try {
            linvAdjustBusinessService.adjustLoads(request.getParam());
            LINV0118ISucceedParam succee = new LINV0118ISucceedParam();
            succee.setSucceedId(request.getParam().getAdjustCode());
            result.setResultCode("1");
            result.setSucceedDatas(succee);
        } catch (BusinessException be) {
            LINV0118IFailedParam faile = new LINV0118IFailedParam();
            faile.setErrorCode(request.getParam().getAdjustCode());
            faile.setErrorMessage(be.getMessage());
            result.setResultCode("0");
            result.setFailedDatas(faile);
        } catch (Exception e) {
            e.printStackTrace();
            result.setResultCode("系统异常，请联系管理员！");
        }
        return result;
    }
}
