package com.bms.order.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bms.order.archive.impl.Operator;
import com.bms.order.bean.param.ORDR0302IBeanParam;
import com.bms.order.common.rest.BusinessRestParam;
import com.bms.order.common.rest.BusinessRestResult;
import com.bms.order.common.rest.result.RestFailedData;
import com.bms.order.common.rest.result.RestSucceedData;
import com.bms.order.services.ORDR0302IService;
import com.bms.order.validator.ORDR0302IRestValidator;
import com.framework.boot.base.BaseRestController;
import com.framework.exception.BusinessException;
import com.framework.exception.bean.BusinessExceptionMessage;
import com.framework.validator.annotation.Validator;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 配送通知单取消接口Controller
 *
 * @author li_huiqian
 */
@RestController
@Api(tags = { "ORDR0302IRestController" }, description = "配送通知单取消接口")
public class ORDR0302IRestController extends BaseRestController {

    @Autowired
    private ORDR0302IService service;

    /**
     * 平台订单人员对未交付的配送单进行取消发货操作
     *
     * @param param
     *            BusinessRestParam
     * @return BusinessRestResult
     */
    @ApiOperation(value = "配送通知单取消接口", notes = "平台订单人员对未交付的配送单进行取消发货操作")
    @Validator(validatorClass = ORDR0302IRestValidator.class)
    @RequestMapping(value = "/order/delivery/notification/_cancel", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BusinessRestResult execute(@RequestBody BusinessRestParam<ORDR0302IBeanParam> param) {
        List<ORDR0302IBeanParam> beans = param.getBeans();
        Operator operator = Operator.Builder.build(param.getOperator());
        BusinessRestResult result = new BusinessRestResult();

        int processedCount = 0; // 处理条数
        int succeedCount = 0; // 处理成功条数
        int failedCount = 0; // 处理失败条数

        for (int i = 0; i < beans.size(); i++) {
            ORDR0302IBeanParam bean = beans.get(i);
            try {
                service.execute(operator, bean);
                succeedCount++;
                RestSucceedData succeedData = new RestSucceedData();
                succeedData.setIndex(i);
                succeedData.setSucceedId(bean.getDistributionNotificationId());
                result.putSucceedData(succeedData);
            } catch (BusinessException e) {
                e.printStackTrace();

                BusinessExceptionMessage bem = e.getBusinessExceptionMessages().get(0); // 没有多message的Exception
                RestFailedData failedData = new RestFailedData();
                failedData.setFailedDataId(null/* TODO 设置ID */);
                failedData.setIndex(i);
                failedData.setErrorParams(bem.getMessageParams());
                failedData.setModuleName(bem.getModuleName());
                failedData.setErrorCode(bem.getMessageCode());
                failedData.setErrorMessage(e.toString());
                failedData.setFailedDataId(bean.getDistributionNotificationId());
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
