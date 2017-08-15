package com.bms.order.rest;

import com.bms.order.archive.impl.Operator;
import com.bms.order.bean.param.ORDR0403IFilterParam;
import com.bms.order.bean.result.ORDR0403IRestResult;
import com.bms.order.common.rest.SearchRestParam;
import com.bms.order.common.rest.SearchRestResult;
import com.bms.order.services.ORDR0403IService;
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
 * Created by wang_jianzhou on 2017/1/17.
 */

@RestController
@Api(tags = { "ORDR0403IRestController" }, description = "发货单查询")
public class ORDR0403IRestController extends BaseRestController {

    @Autowired
    private ORDR0403IService service;


    @ApiOperation(value = "发货单查询", notes = "发货单查询")
    @RequestMapping(value = "/orders/sendNotifiction/_search", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)

    public SearchRestResult<ORDR0403IRestResult> execute(@RequestBody SearchRestParam<ORDR0403IFilterParam> param) {
        Operator operator = Operator.Builder.build(param.getOperator());
        if(null != param.getPagination()){
            int startPos = (param.getPagination().getStartPos() - 1)*param.getPagination().getPageSize();
            param.getPagination().setStartPos(startPos);
        }

        SearchRestResult<ORDR0403IRestResult> result = service.search(operator, param);

        return result;
    }
}
