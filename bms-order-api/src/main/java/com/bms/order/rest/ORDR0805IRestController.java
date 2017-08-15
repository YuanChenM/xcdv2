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
import com.bms.order.bean.param.ORDR0805IBeanParam;
import com.bms.order.common.rest.BusinessRestParam;
import com.bms.order.common.rest.BusinessRestResult;
import com.bms.order.common.rest.result.RestFailedData;
import com.bms.order.services.ORDR0805IService;
import com.bms.order.validator.ORDR0805IRestValidator;
import com.framework.boot.base.BaseRestController;
import com.framework.exception.BusinessException;
import com.framework.exception.bean.BusinessExceptionMessage;
import com.framework.i18n.util.MessageManager;
import com.framework.validator.annotation.Validator;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 买家退货入库数据接收接口Controller
 *
 * @author ni_shaotang
 */
@RestController
@Api(tags = { "ORDR0805IRestController" }, description = "买家退货入库数据接收接口")
public class ORDR0805IRestController extends BaseRestController {

    @Autowired
    private ORDR0805IService service;

    /**
     * 接收WMS系统退货入库信息，系统内仓库待处理库存增加
     *
     * @param request
     *            BusinessRestParam
     * @return BusinessRestResult
     */
    @ApiOperation(value = "买家退货入库数据接收接口", notes = "接收WMS系统退货入库信息，系统内仓库待处理库存增加")
    @Validator(validatorClass = ORDR0805IRestValidator.class)
    @RequestMapping(value = "/order/buyer/return/_inbound", method = RequestMethod.POST, produces = {
            MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_XML_VALUE })
    public BusinessRestResult execute(@RequestBody RestRequest<ORDR0805IBeanParam> request) {
        RestOperator restOperator = new RestOperator();
        restOperator.setOperatorId(request.getLoginId());
        restOperator.setOperatorType(OperatorType.MADE_4_NET.getCode());
        Operator operator = Operator.Builder.build(restOperator);

        BusinessRestResult result = new BusinessRestResult();

        int processedCount = 0; // 处理条数
        int succeedCount = 0; // 处理成功条数
        int failedCount = 0; // 处理失败条数

            ORDR0805IBeanParam bean = request.getParam();
            try {
                service.execute(operator, bean);
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
