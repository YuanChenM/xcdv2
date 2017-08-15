package com.bms.order.rest;

import com.bms.order.archive.impl.Operator;
import com.bms.order.bean.param.ORDR0401IBeanParam;
import com.bms.order.common.rest.BusinessRestResult;
import com.bms.order.common.rest.RestRequest;
import com.bms.order.common.rest.param.RestOperator;
import com.bms.order.common.rest.result.RestFailedData;
import com.bms.order.constant.enumeration.OperatorType;
import com.bms.order.services.ORDR0401IService;
import com.bms.order.validator.ORDR0401IRestValidator;
import com.framework.boot.base.BaseRestController;
import com.framework.exception.BusinessException;
import com.framework.exception.bean.BusinessExceptionMessage;
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
 * 发货通知回传接口Controller
 *
 * @author li_huiqian
 */
@RestController
@Api(tags = { "ORDR0401IRestController" }, description = "发货通知回传接口")
public class ORDR0401IRestController extends BaseRestController {

    @Autowired
    private ORDR0401IService service;

    /**
     * WMS系统发送发货通知单，通知订单系统进行系统内发货
     *
     * @param request
     *            BusinessRestParam
     * @return BusinessRestResult
     */
    @ApiOperation(value = "发货通知回传接口", notes = "WMS系统发送发货通知单，通知订单系统进行系统内发货")
    @Validator(validatorClass = ORDR0401IRestValidator.class)
    @RequestMapping(value = "/order/wms/_deliver", method = RequestMethod.POST, produces = {
            MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_XML_VALUE })
    public BusinessRestResult execute(@RequestBody RestRequest<ORDR0401IBeanParam> request) {
        RestOperator restOperator = new RestOperator();
        restOperator.setOperatorId(request.getLoginId());
        restOperator.setOperatorType(OperatorType.MADE_4_NET.getCode());
        Operator operator = Operator.Builder.build(restOperator);
        BusinessRestResult result = new BusinessRestResult();


        int processedCount = 0; // 处理条数
        int succeedCount = 0; // 处理成功条数
        int failedCount = 0; // 处理失败条数
        try {
            service.execute(operator, request.getParam());
            succeedCount++;
        } catch (BusinessException e) {
            e.printStackTrace();

            BusinessExceptionMessage bem = e.getBusinessExceptionMessages().get(0); // 没有多message的Exception
            RestFailedData failedData = new RestFailedData();
            failedData.setFailedDataId(null/* TODO 设置ID */);
            failedData.setIndex(0);
            failedData.setErrorParams(bem.getMessageParams());
            failedData.setModuleName(bem.getModuleName());
            failedData.setErrorCode(bem.getMessageCode());
            failedData.setErrorMessage(e.toString());
            result.putFailedData(failedData);

            failedCount++;
        } finally {
            processedCount++;
        }

        result.setProcessedCount(processedCount);
        result.setSucceedCount(succeedCount);
        result.setFailedCount(failedCount);
        return result;
    }
}
