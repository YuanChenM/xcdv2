package com.bms.order.rest;

import java.util.List;

import com.bms.order.common.rest.result.RestSucceedData;
import com.bms.order.constant.enumeration.BsReturnType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.bms.order.archive.impl.Operator;
import com.bms.order.bean.param.ORDR0901IBean;
import com.bms.order.common.rest.BusinessRestParam;
import com.bms.order.common.rest.BusinessRestResult;
import com.bms.order.common.rest.result.RestFailedData;
import com.bms.order.services.ORDR0901IService;
import com.bms.order.validator.ORDR0901IRestValidator;
import com.framework.boot.base.BaseRestController;
import com.framework.exception.BusinessException;
import com.framework.exception.bean.BusinessExceptionMessage;
import com.framework.i18n.util.MessageManager;
import com.framework.validator.annotation.Validator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 买手退货单创建接口Controller
 *
 * @author li_huiqian
 */
@RestController
@Api( tags = {"ORDR0901IRestController"}, description = "买手退货单创建接口")
public class ORDR0901IRestController extends BaseRestController {

    @Autowired
    private ORDR0901IService service;

    /**
     * 接收买手退货信息，创建买手退货订单
     *
     * @param param BusinessRestParam
     * @return BusinessRestResult
     */
    @ApiOperation(value = "买手退货单创建接口", notes = "接收买手退货信息，创建买手退货订单")
    @Validator(validatorClass = ORDR0901IRestValidator.class)
    @RequestMapping(value = "/order/bs/return/_create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BusinessRestResult execute(@RequestBody BusinessRestParam<ORDR0901IBean> param) {
        List<ORDR0901IBean> beans = param.getBeans();
        Operator operator = Operator.Builder.build(param.getOperator());
        BusinessRestResult result = new BusinessRestResult();

        int processedCount = 0; // 处理条数
        int succeedCount = 0; // 处理成功条数
        int failedCount = 0; // 处理失败条数

        for (int i = 0; i < beans.size(); i++) {
            ORDR0901IBean bean = beans.get(i);
            try {
                RestSucceedData succeedData = new RestSucceedData();
                Long id = service.execute(operator, bean, BsReturnType.ACTIVE.getCode());
                succeedData.setSucceedId(id);
                succeedData.setIndex(i);
                result.putSucceedData(succeedData);
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
