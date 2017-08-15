package com.bms.order.rest;

import java.util.List;

import com.bms.order.bean.param.ORDR0501IRestParam;
import com.bms.order.bean.result.ORDR0501IRestResult;
import com.bms.order.common.rest.MeiDefoeRestParam;
import com.bms.order.common.rest.MeiDefoeRestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bms.order.archive.impl.Operator;
import com.bms.order.bean.param.ORDR0501IBeanParam;
import com.bms.order.common.rest.BusinessRestParam;
import com.bms.order.common.rest.BusinessRestResult;
import com.bms.order.common.rest.result.RestFailedData;
import com.bms.order.services.ORDR0501IService;
import com.bms.order.validator.ORDR0501IRestValidator;
import com.framework.boot.base.BaseRestController;
import com.framework.exception.BusinessException;
import com.framework.exception.bean.BusinessExceptionMessage;
import com.framework.validator.annotation.Validator;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 收货通知回传接口Controller
 *
 * @author li_huiqian
 */
@RestController
@Api(tags = { "ORDR0501IRestController" }, description = "收货通知回传接口")
public class ORDR0501IRestController extends BaseRestController {

    @Autowired
    private ORDR0501IService service;

    /**
     * WMS系统发送收货通知单，通知订单系统进行系统内收货、拒收退货、迟收退货
     *
     * @param param
     *            BusinessRestParam
     * @return BusinessRestResult
     */
    @ApiOperation(value = "收货通知回传接口", notes = "WMS系统发送收货通知单，通知订单系统进行系统内收货、拒收退货、迟收退货")
    @Validator(validatorClass = ORDR0501IRestValidator.class)
    @RequestMapping(value = "/order/wms/_receipt", method = RequestMethod.POST, produces = { MediaType.APPLICATION_XML_VALUE },consumes = { MediaType.APPLICATION_XML_VALUE })
    public MeiDefoeRestResult<ORDR0501IRestResult> execute(@RequestBody MeiDefoeRestParam<ORDR0501IRestParam> param) {
        ORDR0501IRestParam beans = param.getBeans();
        Operator operator = Operator.Builder.build(param.getOperator());
        ORDR0501IRestResult restResult = service.execute(operator,beans);
        MeiDefoeRestResult<ORDR0501IRestResult> result = new MeiDefoeRestResult();
        result.setResult(restResult);
        return result;
    }
}
