package com.bms.order.rest;


import com.bms.order.archive.impl.Operator;
import com.bms.order.bean.param.ORDR0607IFilterParam;
import com.bms.order.common.rest.BusinessRestParam;
import com.bms.order.common.rest.BusinessRestResult;
import com.bms.order.common.rest.result.RestFailedData;
import com.bms.order.services.ORDR0607IService;
import com.bms.order.validator.ORDR0607IRestValidator;
import com.framework.boot.base.BaseRestController;
import com.framework.exception.BusinessException;
import com.framework.exception.bean.BusinessExceptionMessage;
import com.framework.i18n.util.MessageManager;
import com.framework.validator.annotation.Validator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 买手订单囤货接口Controller
 *
 * @author li_huiqian
 */
@RestController
@Api(tags = { "ORDR0607IRestController" }, description = "买手订单囤货接口")
public class ORDR0607IRestController extends BaseRestController {

    @Autowired
    private ORDR0607IService service;

    /**
     * 买手囤货
     *ORDR0607IFilterParam
     * @return BusinessRestResult
     */
    @ApiOperation(value = "买手订单囤货接口", notes = "买手订单囤货")
    @RequestMapping(value = "/order/bs/stockpile/_update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Validator(validatorClass = ORDR0607IRestValidator.class)
    public BusinessRestResult execute(@RequestBody BusinessRestParam<ORDR0607IFilterParam> param) {
        List<ORDR0607IFilterParam> beans = param.getBeans();
        Operator operator = Operator.Builder.build(param.getOperator());
        BusinessRestResult result = new BusinessRestResult();
        int processedCount = 0; // 处理条数
        int succeedCount = 0; // 处理成功条数
        int failedCount = 0; // 处理失败条数

        for (int i = 0; i < beans.size(); i++) {
            ORDR0607IFilterParam bean = beans.get(i);
            try {
                service.execute(operator, bean);
                succeedCount++;
            } catch (BusinessException e) {
                e.printStackTrace();

                BusinessExceptionMessage bem = e.getBusinessExceptionMessages().get(0); // 没有多message的Exception
                RestFailedData failedData = new RestFailedData();
                failedData.setFailedDataId(null/* TODO 设置ID */);
                failedData.setIndex(i);
                failedData.setErrorParams(bem.getMessageParams());
                failedData.setModuleName(bem.getModuleName());
                failedData.setErrorCode(bem.getMessageCode());
                failedData.setErrorMessage(MessageManager.getMessage(bem.getMessageCode(), bem.getMessageParams()));
                result.putFailedData(failedData);

                failedCount++;
            } finally {
                processedCount++;
            }
        }

        result.setProcessedCount(processedCount);
        result.setSucceedCount(succeedCount);
        result.setFailedCount(failedCount);
        return result;
    }



}
