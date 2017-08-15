package com.bms.order.rest;

import java.util.List;

import com.bms.order.common.rest.RestRequest;
import com.bms.order.common.rest.param.RestOperator;
import com.bms.order.constant.enumeration.OperatorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bms.order.archive.impl.Operator;
import com.bms.order.bean.param.ORDR0304IBeanParam;
import com.bms.order.common.rest.BusinessRestParam;
import com.bms.order.common.rest.BusinessRestResult;
import com.bms.order.common.rest.result.RestFailedData;
import com.bms.order.services.ORDR0304IService;
import com.bms.order.validator.ORDR0304IRestValidator;
import com.framework.boot.base.BaseRestController;
import com.framework.exception.BusinessException;
import com.framework.exception.bean.BusinessExceptionMessage;
import com.framework.i18n.util.MessageManager;
import com.framework.validator.annotation.Validator;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 买手订单修改接口Controller
 *
 * @author wu_honglei
 */
@RestController
@Api(tags = { "ORDR0304IRestController" }, description = "配送通知单取消回传接口")
public class ORDR0304IRestController extends BaseRestController {

    @Autowired
    private ORDR0304IService service;

    /**
     * 配送通知单取消
     *
     * @param request
     *            BusinessRestParam
     * @return BusinessRestResult
     */
    @ApiOperation(value = "配送通知单取消回传接口", notes = "配送通知单取消通知WMS后收到的是否成功的回传信息")
    @Validator(validatorClass = ORDR0304IRestValidator.class)
    @RequestMapping(value = "/order/delivery/notification/cancel/_inform", method = RequestMethod.POST, produces = {
            MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_XML_VALUE })
    public BusinessRestResult execute(@RequestBody RestRequest<ORDR0304IBeanParam> request) {
        RestOperator restOperator = new RestOperator();
        restOperator.setOperatorId(request.getLoginId());
        restOperator.setOperatorType(OperatorType.MADE_4_NET.getCode());

        Operator operator = Operator.Builder.build(restOperator);
        BusinessRestResult result = new BusinessRestResult();

        int processedCount = 0; // 处理条数
        int succeedCount = 0; // 处理成功条数
        int failedCount = 0; // 处理失败条数

            ORDR0304IBeanParam bean = request.getParam();
            try {
                service.execute(operator, bean);
                succeedCount++;
            } catch (BusinessException e) {
                e.printStackTrace();

                BusinessExceptionMessage bem = e.getBusinessExceptionMessages().get(0); // 没有多message的Exception
                RestFailedData failedData = new RestFailedData();
                failedData.setFailedDataId(bean.getShipId());
                failedData.setIndex(0);
                failedData.setErrorParams(bem.getMessageParams());
                failedData.setModuleName(bem.getModuleName());
                failedData.setErrorCode(bem.getMessageCode());
                failedData.setErrorMessage(MessageManager.getMessage(bem.getMessageCode(), bem.getMessageParams()));
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
