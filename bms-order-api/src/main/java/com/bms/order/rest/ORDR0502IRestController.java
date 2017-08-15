package com.bms.order.rest;

import com.bms.order.archive.impl.Operator;
import com.bms.order.bean.param.ORDR0502IFilterParam;
import com.bms.order.bean.result.ORDR0502IRestResult;
import com.bms.order.common.rest.SearchRestParam;
import com.bms.order.common.rest.SearchRestResult;
import com.bms.order.services.ORDR0502IService;
import com.bms.order.validator.ORDR0502IRestValidator;
import com.framework.boot.base.BaseRestController;
import com.framework.validator.annotation.Validator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wang_jianzhou on 2017/1/18.
 */
@RestController
@Api(tags = { "ORDR0502IRestController" }, description = "收货单查询")
public class ORDR0502IRestController extends BaseRestController {

    @Autowired
    private ORDR0502IService service;

    @ApiOperation(value = "收货单查询", notes = "收货单查询")
    @Validator(validatorClass = ORDR0502IRestValidator.class)
    @RequestMapping(value = "/orders/receiveNotifiction/_search", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public SearchRestResult<ORDR0502IRestResult> execute(@RequestBody SearchRestParam<ORDR0502IFilterParam> param) {
        Operator operator = Operator.Builder.build(param.getOperator());
        if(null != param.getPagination()){
            int startPos = (param.getPagination().getStartPos() - 1)*param.getPagination().getPageSize();
            param.getPagination().setStartPos(startPos);
        }

        SearchRestResult<ORDR0502IRestResult> result = service.search(operator, param);

        return result;
    }
}
