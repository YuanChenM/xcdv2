package com.bms.order.rest;

import com.bms.order.archive.impl.Operator;
import com.bms.order.bean.param.ORDR0808IBean;
import com.bms.order.common.rest.BusinessRestParam;
import com.bms.order.common.rest.BusinessRestResult;
import com.bms.order.common.rest.result.RestFailedData;
import com.bms.order.common.rest.result.RestSucceedData;
import com.bms.order.services.ORDR0808IService;
import com.bms.order.validator.ORDR0802IRestValidator;
import com.bms.order.validator.ORDR0808IRestValidator;
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
 * Created by Administrator on 2017/3/6.
 */
@RestController
@Api( tags = {"ORDR0808IRestController"}, description = "买家退货单确认取消接口")
public class ORDR0808IRestController extends BaseRestController {

    @Autowired
    private ORDR0808IService service;

    @ApiOperation(value = "买家退货单确认取消接口", notes = "接收买家平台退货的确认取消信息，更改退货单状态")
    @Validator(validatorClass = ORDR0808IRestValidator.class)
    @RequestMapping(value = "/order/buyer/return/confirm/_cancel", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BusinessRestResult execute(@RequestBody BusinessRestParam<ORDR0808IBean> param) {
        List<ORDR0808IBean> beans = param.getBeans();
        Operator operator = Operator.Builder.build(param.getOperator());
        BusinessRestResult result = new BusinessRestResult();

        int processedCount = 0; // 处理条数
        int succeedCount = 0; // 处理成功条数
        int failedCount = 0; // 处理失败条数

        for (int i = 0; i < beans.size(); i++) {
            ORDR0808IBean bean = beans.get(i);
            try {
                service.execute(operator, bean);
                RestSucceedData succeedData = new RestSucceedData();
                succeedData.setSucceedId(bean.getReturnId());
                succeedData.setIndex(i);
                result.putSucceedData(succeedData);
                succeedCount ++;
            } catch (BusinessException e) {
                e.printStackTrace();

                BusinessExceptionMessage bem = e.getBusinessExceptionMessages().get(0); // 没有多message的Exception
                RestFailedData failedData = new RestFailedData();
                failedData.setFailedDataId(bean.getReturnId());
                failedData.setIndex(i);
                failedData.setErrorParams(bem.getMessageParams());
                failedData.setModuleName(bem.getModuleName());
                failedData.setErrorCode(bem.getMessageCode());
                failedData.setErrorMessage(MessageManager.getMessage(bem.getMessageCode(), bem.getMessageParams()));
                result.putFailedData(failedData);

                failedCount ++;
            } finally {
                processedCount ++;
            }
        }

        result.setProcessedCount(processedCount);
        result.setSucceedCount(succeedCount);
        result.setFailedCount(failedCount);
        return result;
    }
}
