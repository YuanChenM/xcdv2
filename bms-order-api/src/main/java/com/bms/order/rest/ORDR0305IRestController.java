package com.bms.order.rest;

import com.bms.order.archive.impl.Operator;
import com.bms.order.bean.param.ORDR0305IBeanParam;
import com.bms.order.common.rest.BusinessRestParam;
import com.bms.order.common.rest.BusinessRestResult;
import com.bms.order.common.rest.result.RestFailedData;
import com.bms.order.common.rest.result.RestSucceedData;
import com.bms.order.services.ORDR0305IService;
import com.bms.order.validator.ORDR0305IRestValidator;
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
 * 买手订单修改接口Controller
 *
 * @author wu_honglei
 */
@RestController
@Api(tags = { "ORDR0305IRestController" }, description = "配送通知单修改接口")
public class ORDR0305IRestController extends BaseRestController {

    @Autowired
    private ORDR0305IService service;

    /**
     * 配送通知单修改
     *
     * @param param
     *            BusinessRestParam
     * @return BusinessRestResult
     */
    @ApiOperation(value = "配送通知单修改接口", notes = "修改预定配送仓库")
    @Validator(validatorClass = ORDR0305IRestValidator.class)
    @RequestMapping(value = "/order/delivery/notification/_modify",  method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BusinessRestResult execute(@RequestBody BusinessRestParam<ORDR0305IBeanParam> param) {
        List<ORDR0305IBeanParam> beans = param.getBeans();
        Operator operator = Operator.Builder.build(param.getOperator());
        BusinessRestResult result = new BusinessRestResult();

        int processedCount = 0; // 处理条数
        int succeedCount = 0; // 处理成功条数
        int failedCount = 0; // 处理失败条数

        for (int i = 0; i < beans.size(); i++) {
            ORDR0305IBeanParam bean = beans.get(i);
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
                failedData.setFailedDataId(bean.getDistributionNotificationId());
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
