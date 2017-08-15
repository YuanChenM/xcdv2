package com.bms.order.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bms.order.archive.impl.Operator;
import com.bms.order.bean.param.ORDR0601IBeanParam;
import com.bms.order.bean.param.ORDR0604IBeanParam;
import com.bms.order.common.rest.BusinessRestParam;
import com.bms.order.common.rest.BusinessRestResult;
import com.bms.order.common.rest.result.RestFailedData;
import com.bms.order.common.rest.result.RestSucceedData;
import com.bms.order.constant.OrderConst;
import com.bms.order.constant.enumeration.OperatorType;
import com.bms.order.services.ORDR0601IService;
import com.bms.order.services.ORDR0604IService;
import com.bms.order.validator.ORDR0601IRestValidator;
import com.framework.boot.base.BaseRestController;
import com.framework.exception.BusinessException;
import com.framework.exception.bean.BusinessExceptionMessage;
import com.framework.validator.annotation.Validator;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 买手订单创建接口Controller
 *
 * @author li_huiqian
 */
@RestController
@Api(tags = { "ORDR0601IRestController" }, description = "买手订单创建接口")
public class ORDR0601IRestController extends BaseRestController {

    @Autowired
    private ORDR0601IService service;

    @Autowired
    private ORDR0604IService ordr0604IService;// 买手订单确认

    /**
     * 买手囤实物订单和买手囤货权订单创建
     *
     * @param param
     *            BusinessRestParam
     * @return BusinessRestResult
     */
    @ApiOperation(value = "买手订单创建接口", notes = "买手囤实物订单和买手囤货权订单创建")
    @Validator(validatorClass = ORDR0601IRestValidator.class)
    @RequestMapping(value = "/order/bs/_create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BusinessRestResult execute(@RequestBody BusinessRestParam<ORDR0601IBeanParam> param) {
        List<ORDR0601IBeanParam> beans = param.getBeans();
        Operator operator = Operator.Builder.build(param.getOperator());
        BusinessRestResult result = new BusinessRestResult();

        int processedCount = 0; // 处理条数
        int succeedCount = 0; // 处理成功条数
        int failedCount = 0; // 处理失败条数
        List<RestSucceedData> succeedDatas = new ArrayList<>();
        for (int i = 0; i < beans.size(); i++) {
            ORDR0601IBeanParam bean = beans.get(i);
            Long bsOrderId = null;
            try {
                bsOrderId = service.execute(operator, bean);

                ORDR0604IBeanParam ordr0604IBeanParam = new ORDR0604IBeanParam();// 订单创建后 需要调用 自动确认功能
                ordr0604IBeanParam.setBsOrderId(bsOrderId);
                Operator newOperator = new Operator();
                newOperator.setOperatorType(OperatorType.MANAGER.getCode());
                newOperator.setOperatorId(OrderConst.PLATFORM_ID);
                this.ordr0604IService.execute(newOperator, ordr0604IBeanParam);
                RestSucceedData restSucceedData = new RestSucceedData();
                restSucceedData.setIndex(i);
                restSucceedData.setSucceedId(bsOrderId);
                succeedDatas.add(restSucceedData);
                result.putSucceedData(restSucceedData);
                succeedCount++;
            } catch (BusinessException e) {
                e.printStackTrace();
                BusinessExceptionMessage bem = e.getBusinessExceptionMessages().get(0); // 没有多message的Exception
                RestFailedData failedData = new RestFailedData();
                failedData.setFailedDataId(bsOrderId);
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
