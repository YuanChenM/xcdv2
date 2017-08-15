package com.bms.order.rest;

import java.util.ArrayList;
import java.util.List;

import com.bms.order.common.rest.result.RestSucceedData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.bms.order.archive.impl.Operator;
import com.bms.order.bean.param.ORDR0902IBean;
import com.bms.order.common.rest.BusinessRestParam;
import com.bms.order.common.rest.BusinessRestResult;
import com.bms.order.common.rest.result.RestFailedData;
import com.bms.order.services.ORDR0902IService;
import com.bms.order.validator.ORDR0902IRestValidator;
import com.framework.boot.base.BaseRestController;
import com.framework.exception.BusinessException;
import com.framework.exception.bean.BusinessExceptionMessage;
import com.framework.i18n.util.MessageManager;
import com.framework.validator.annotation.Validator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 买手退货单确认接口Controller
 *
 * @author li_huiqian
 */
@RestController
@Api( tags = {"ORDR0902IRestController"}, description = "买手退货单确认接口")
public class ORDR0902IRestController extends BaseRestController {

    @Autowired
    private ORDR0902IService service;

    /**
     * 接收买手退回确认信息，更改退货状态
     *
     * @param param BusinessRestParam
     * @return BusinessRestResult
     */
    @ApiOperation(value = "买手退货单确认接口", notes = "接收买手退回确认信息，更改退货状态")
    @Validator(validatorClass = ORDR0902IRestValidator.class)
    @RequestMapping(value = "/order/bs/return/_confirm", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BusinessRestResult execute(@RequestBody BusinessRestParam<ORDR0902IBean> param) {
        List<ORDR0902IBean> beans = param.getBeans();
        Operator operator = Operator.Builder.build(param.getOperator());
        BusinessRestResult result = new BusinessRestResult();

        int processedCount = 0; // 处理条数
        int succeedCount = 0; // 处理成功条数
        int failedCount = 0; // 处理失败条数

        for (int i = 0; i < beans.size(); i++) {
            ORDR0902IBean bean = beans.get(i);
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
