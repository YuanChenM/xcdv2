package com.bms.order.rest;

import java.util.List;

import com.bms.order.bean.param.ORDR1001IBeanParam;
import com.bms.order.services.ORDR1001IService;
import com.bms.order.services.impl.ORDR0101IServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bms.order.archive.impl.Operator;
import com.bms.order.bean.param.ORDR0101IBeanParam;
import com.bms.order.bean.param.ORDR0104IBeanParam;
import com.bms.order.common.rest.BusinessRestParam;
import com.bms.order.common.rest.BusinessRestResult;
import com.bms.order.common.rest.result.RestFailedData;
import com.bms.order.common.rest.result.RestSucceedData;
import com.bms.order.constant.OrderConst;
import com.bms.order.constant.enumeration.OperatorType;
import com.bms.order.services.ORDR0101IService;
import com.bms.order.services.ORDR0104IService;
import com.bms.order.validator.ORDR0101IRestValidator;
import com.framework.boot.base.BaseRestController;
import com.framework.exception.BusinessException;
import com.framework.exception.bean.BusinessExceptionMessage;
import com.framework.i18n.util.MessageManager;
import com.framework.validator.annotation.Validator;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 买家订单创建接口Controller
 *
 * @author li_huiqian
 */
@RestController
@Api(tags = { "ORDR0101IRestController" }, description = "买家订单创建接口")
public class ORDR0101IRestController extends BaseRestController {

    public static final Logger logger = LoggerFactory.getLogger(ORDR0101IRestController.class);
    @Autowired
    private ORDR0101IService service;

    @Autowired
    private ORDR0104IService confirmService;

    /**
     * A类、B类的标准订单和分批订单创建
     *
     * @param param
     *            BusinessRestParam
     * @return BusinessRestResult
     */
    @ApiOperation(value = "买家订单创建接口", notes = "A类、B类的标准订单和分批订单创建")
    @Validator(validatorClass = ORDR0101IRestValidator.class)
    @RequestMapping(value = "/order/by/_create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BusinessRestResult execute(@RequestBody BusinessRestParam<ORDR0101IBeanParam> param) {
        List<ORDR0101IBeanParam> beans = param.getBeans();
        Operator operator = Operator.Builder.build(param.getOperator());
        BusinessRestResult result = new BusinessRestResult();

        int processedCount = 0; // 处理条数
        int succeedCount = 0; // 处理成功条数
        int failedCount = 0; // 处理失败条数

        for (int i = 0; i < beans.size(); i++) {
            ORDR0101IBeanParam bean = beans.get(i);
            try {
                // 创建订单
                Long orderId = service.execute(operator, bean);

                // 确认订单
                ORDR0104IBeanParam confirmBean = new ORDR0104IBeanParam();
                confirmBean.setBuyerOrderId(orderId);
                Operator confirmOperator = Operator.Builder.build(param.getOperator());
                confirmOperator.setOperatorId(OrderConst.PLATFORM_ID);
                confirmOperator.setOperatorType(OperatorType.MANAGER.getCode());
                try {
                    confirmService.execute(confirmOperator, confirmBean);

                } catch (Exception e){
                    logger.debug(e.getMessage());
                }

                // 成功
                RestSucceedData succeedData = new RestSucceedData();
                succeedData.setSucceedId(orderId);
                succeedData.setIndex(i);
                result.putSucceedData(succeedData);

                succeedCount++;
            } catch (BusinessException e) {
                e.printStackTrace();

                BusinessExceptionMessage bem = e.getBusinessExceptionMessages().get(0); // 没有多message的Exception
                RestFailedData failedData = new RestFailedData();
                failedData.setFailedDataId(null);
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
