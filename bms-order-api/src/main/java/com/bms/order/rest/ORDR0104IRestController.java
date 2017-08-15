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
import com.bms.order.bean.param.ORDR0104IBeanParam;
import com.bms.order.common.rest.BusinessRestParam;
import com.bms.order.common.rest.BusinessRestResult;
import com.bms.order.common.rest.result.RestFailedData;
import com.bms.order.services.ORDR0104IService;
import com.bms.order.validator.ORDR0104IRestValidator;
import com.framework.boot.base.BaseRestController;
import com.framework.exception.BusinessException;
import com.framework.exception.bean.BusinessExceptionMessage;
import com.framework.validator.annotation.Validator;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 买家订单确认接口Controller
 *
 * @author li_huiqian
 */
@RestController
@Api(tags = {"ORDR0104IRestController"}, description = "买家订单确认接口")
public class ORDR0104IRestController extends BaseRestController {

    @Autowired
    private ORDR0104IService service;

    /**
     * 订单系统/平台订单人员确认买家订单，占用库存，生成记账凭证
     *
     * @param param BusinessRestParam
     * @return BusinessRestResult
     */
    @ApiOperation(value = "买家订单确认接口", notes = "订单系统/平台订单人员确认买家订单，占用库存，生成记账凭证")
    @Validator(validatorClass = ORDR0104IRestValidator.class)
    @RequestMapping(value = "/order/by/_confirm", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BusinessRestResult execute(@RequestBody BusinessRestParam<ORDR0104IBeanParam> param) {
        List<ORDR0104IBeanParam> beans = param.getBeans();
        Operator operator = Operator.Builder.build(param.getOperator());
        BusinessRestResult result = new BusinessRestResult();

        int processedCount = 0; // 处理条数
        int succeedCount = 0; // 处理成功条数
        int failedCount = 0; // 处理失败条数

        for (int i = 0; i < beans.size(); i++) {
            ORDR0104IBeanParam bean = beans.get(i);
            try {
                Long buyerOrderId = service.execute(operator, bean);
                RestSucceedData restSucceedData=new RestSucceedData();
                restSucceedData.setSucceedId(buyerOrderId);
                restSucceedData.setIndex(i);
                result.putSucceedData(restSucceedData);
                succeedCount++;
            } catch (BusinessException e) {
                e.printStackTrace();
                BusinessExceptionMessage bem = e.getBusinessExceptionMessages().get(0); // 没有多message的Exception
                RestFailedData failedData = new RestFailedData();
                failedData.setFailedDataId(bean.getBuyerOrderId());
                failedData.setIndex(i);
                failedData.setErrorParams(bem.getMessageParams());
                failedData.setModuleName(bem.getModuleName());
                failedData.setErrorCode(bem.getMessageCode());
                failedData.setErrorMessage(e.toString());
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
