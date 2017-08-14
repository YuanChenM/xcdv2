package com.bms.issue.rest;

import java.util.ArrayList;
import java.util.List;

import com.bms.issue.common.rest.result.RestSucceedData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.bms.issue.archive.impl.Operator;
import com.bms.issue.bean.param.ISSU0103IBean;
import com.bms.issue.common.rest.BusinessRestParam;
import com.bms.issue.common.rest.BusinessRestResult;
import com.bms.issue.common.rest.result.RestFailedData;
import com.bms.issue.service.ISSU0103IService;
import com.bms.issue.validator.ISSU0103IRestValidator;
import com.framework.boot.base.BaseRestController;
import com.framework.exception.BusinessException;
import com.framework.exception.bean.BusinessExceptionMessage;
import com.framework.i18n.util.MessageManager;
import com.framework.validator.annotation.Validator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 问题订单结案提交接口Controller
 *
 * @author li_huiqian
 */
@RestController
@Api( tags = {"ISSU0103IRestController"}, description = "问题订单结案提交接口")
public class ISSU0103IRestController extends BaseRestController {

    @Autowired
    private ISSU0103IService service;

    /**
     * 接收问题订单结案信息，问题订单结案
     *
     * @param param BusinessRestParam
     * @return BusinessRestResult
     */
    @ApiOperation(value = "问题订单结案提交接口", notes = "接收问题订单结案信息，问题订单结案")
    @Validator(validatorClass = ISSU0103IRestValidator.class)
    @RequestMapping(value = "/issue/_close", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BusinessRestResult execute(@RequestBody BusinessRestParam<ISSU0103IBean> param) {
        List<ISSU0103IBean> beans = param.getBeans();
        Operator operator = Operator.Builder.build(param.getOperator());
        BusinessRestResult result = new BusinessRestResult();

        int processedCount = 0; // 处理条数
        int succeedCount = 0; // 处理成功条数
        int failedCount = 0; // 处理失败条数

        for (int i = 0; i < beans.size(); i++) {
            ISSU0103IBean bean = beans.get(i);
            try {
                service.execute(operator, bean);
                RestSucceedData restSucceedData = new RestSucceedData();
                restSucceedData.setSucceedId(bean.getIssueId());
                restSucceedData.setIndex(i);
                result.putSucceedData(restSucceedData);
                succeedCount ++;
            } catch (BusinessException e) {
                e.printStackTrace();
                BusinessExceptionMessage bem = e.getBusinessExceptionMessages().get(0);
                RestFailedData failedData = new RestFailedData();
                failedData.setFailedDataId(bean.getIssueId());
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
