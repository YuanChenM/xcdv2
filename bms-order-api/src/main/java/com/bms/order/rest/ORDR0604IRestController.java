package com.bms.order.rest;

import java.util.List;

import com.bms.order.common.rest.result.RestSucceedData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bms.order.archive.impl.Operator;
import com.bms.order.bean.param.ORDR0604IBeanParam;
import com.bms.order.common.rest.BusinessRestParam;
import com.bms.order.common.rest.BusinessRestResult;
import com.bms.order.common.rest.result.RestFailedData;
import com.bms.order.services.ORDR0604IService;
import com.bms.order.validator.ORDR0604IRestValidator;
import com.framework.boot.base.BaseRestController;
import com.framework.exception.BusinessException;
import com.framework.exception.bean.BusinessExceptionMessage;
import com.framework.validator.annotation.Validator;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 买手订单确认接口Controller
 *
 * @author li_huiqian
 */
@RestController
@Api(tags = { "ORDR0604IRestController" }, description = "买手订单确认接口")
public class ORDR0604IRestController extends BaseRestController {

    @Autowired
    private ORDR0604IService service;

    /**
     * 订单系统/平台订单人员确认买手订单，占用库存，生成记账凭证
     *
     * @param param
     *            BusinessRestParam
     * @return BusinessRestResult
     */
    @ApiOperation(value = "买手订单确认接口", notes = "订单系统/平台订单人员确认买手订单，占用库存，生成记账凭证")
    @Validator(validatorClass = ORDR0604IRestValidator.class)
    @RequestMapping(value = "/order/bs/_confirm", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BusinessRestResult execute(@RequestBody BusinessRestParam<ORDR0604IBeanParam> param) {
        List<ORDR0604IBeanParam> beans = param.getBeans();
        Operator operator = Operator.Builder.build(param.getOperator());
        BusinessRestResult result = new BusinessRestResult();

        int processedCount = 0; // 处理条数
        int succeedCount = 0; // 处理成功条数
        int failedCount = 0; // 处理失败条数

        for (int i = 0; i < beans.size(); i++) {
            ORDR0604IBeanParam bean = beans.get(i);
            try {
                service.execute(operator, bean);
                succeedCount++;
                RestSucceedData succeedData = new RestSucceedData();
                succeedData.setIndex(i);
                succeedData.setSucceedId(bean.getBsOrderId());
                result.putSucceedData(succeedData);
            } catch (BusinessException e) {
                e.printStackTrace();

                BusinessExceptionMessage bem = e.getBusinessExceptionMessages().get(0); // 没有多message的Exception
                RestFailedData failedData = new RestFailedData();
                failedData.setFailedDataId(bean.getBsOrderId());
                failedData.setIndex(i);
                failedData.setErrorParams(bem.getMessageParams());
                failedData.setModuleName(bem.getModuleName());
                failedData.setErrorCode(bem.getMessageCode());
                failedData.setErrorMessage(e.toString());
                failedData.setFailedDataId(bean.getBsOrderId());
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
