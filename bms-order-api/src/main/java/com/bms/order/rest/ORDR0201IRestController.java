package com.bms.order.rest;

import java.math.BigDecimal;
import java.util.List;

import com.bms.order.archive.impl.BuyerBatchOrderDetail;
import com.bms.order.archive.impl.BuyerForcastDeliverDetail;
import com.bms.order.bean.entity.BuyerOrderEntity;
import com.bms.order.common.rest.result.RestSucceedData;
import com.bms.order.constant.i18n.ErrorCode;
import com.bms.order.constant.i18n.ModuleCode;
import com.framework.core.utils.DecimalUtils;
import com.framework.i18n.util.MessageManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bms.order.archive.impl.Operator;
import com.bms.order.bean.param.ORDR0201IBeanParam;
import com.bms.order.common.rest.BusinessRestParam;
import com.bms.order.common.rest.BusinessRestResult;
import com.bms.order.common.rest.result.RestFailedData;
import com.bms.order.services.ORDR0201IService;
import com.bms.order.validator.ORDR0201IRestValidator;
import com.framework.boot.base.BaseRestController;
import com.framework.exception.BusinessException;
import com.framework.exception.bean.BusinessExceptionMessage;
import com.framework.validator.annotation.Validator;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 订单分拆单创建接口Controller
 *
 * @author li_huiqian
 */
@RestController
@Api(tags = {"ORDR0201IRestController"}, description = "订单分拆单创建接口")
public class ORDR0201IRestController extends BaseRestController {

    @Autowired
    private ORDR0201IService service;

    /**
     * 订单系统/平台订单人员对已确认的订单的分批订单进行分拆
     *
     * @param param BusinessRestParam
     * @return BusinessRestResult
     */
    @ApiOperation(value = "订单分拆单创建接口", notes = "订单系统/平台订单人员对已确认的订单的分批订单进行分拆")
    @Validator(validatorClass = ORDR0201IRestValidator.class)
    @RequestMapping(value = "/order/split/_create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BusinessRestResult execute(@RequestBody BusinessRestParam<ORDR0201IBeanParam> param) {
        List<ORDR0201IBeanParam> beans = param.getBeans();
        Operator operator = Operator.Builder.build(param.getOperator());
        BusinessRestResult result = new BusinessRestResult();
        int processedCount = 0; // 处理条数
        int succeedCount = 0; // 处理成功条数
        int failedCount = 0; // 处理失败条数

        for (int i = 0; i < beans.size(); i++) {
            ORDR0201IBeanParam bean = beans.get(i);
            try {
                List<Long>list = service.execute(operator, bean);
                RestSucceedData restSucceedData = new RestSucceedData();
                restSucceedData.setSucceedId(list.toString());
                restSucceedData.setIndex(i);
                result.putSucceedData(restSucceedData);
                succeedCount++;
            } catch (BusinessException e) {
                e.printStackTrace();
                BusinessExceptionMessage bem = e.getBusinessExceptionMessages().get(0); // 没有多message的Exception
                RestFailedData failedData = new RestFailedData();
                failedData.setFailedDataId(bean.getSpiltDetails().get(0).getBuyerBatchOrderDetailId());
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
