package com.bms.issue.rest;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.bms.issue.archive.impl.Operator;
import com.bms.issue.bean.param.ISSU0204IBean;
import com.bms.issue.common.rest.BusinessRestParam;
import com.bms.issue.common.rest.BusinessRestResult;
import com.bms.issue.common.rest.result.RestFailedData;
import com.bms.issue.service.ISSU0204IService;
import com.bms.issue.validator.ISSU0204IRestValidator;
import com.framework.boot.base.BaseRestController;
import com.framework.exception.BusinessException;
import com.framework.exception.bean.BusinessExceptionMessage;
import com.framework.i18n.util.MessageManager;
import com.framework.validator.annotation.Validator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 问题附件保存接口Controller
 *
 * @author li_huiqian
 */
@RestController
@Api( tags = {"ISSU0204IRestController"}, description = "问题附件保存接口")
public class ISSU0204IRestController extends BaseRestController {

    @Autowired
    private ISSU0204IService service;

    /**
     * 接收问题的附件信息，保存问题附件
     *
     * @param param BusinessRestParam
     * @return BusinessRestResult
     */
    @ApiOperation(value = "问题附件保存接口", notes = "接收问题的附件信息，保存问题附件")
    @Validator(validatorClass = ISSU0204IRestValidator.class)
    @RequestMapping(value = "/issue/question/accessory/_add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BusinessRestResult execute(@RequestBody BusinessRestParam<ISSU0204IBean> param) {
        List<ISSU0204IBean> beans = param.getBeans();
        Operator operator = Operator.Builder.build(param.getOperator());
        BusinessRestResult result = new BusinessRestResult();

        int processedCount = 0; // 处理条数
        int succeedCount = 0; // 处理成功条数
        int failedCount = 0; // 处理失败条数

        for (int i = 0; i < beans.size(); i++) {
            ISSU0204IBean bean = beans.get(i);
            try {
                service.execute(operator, bean);
                succeedCount ++;
            } catch (BusinessException e) {
                e.printStackTrace();

                BusinessExceptionMessage bem = e.getBusinessExceptionMessages().get(0); // 没有多message的Exception
                RestFailedData failedData = new RestFailedData();
                failedData.setFailedDataId(null/*TODO 设置ID*/);
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
