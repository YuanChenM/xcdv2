package com.bms.order.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bms.order.archive.impl.Operator;
import com.bms.order.bean.param.ORDR0804IBean;
import com.bms.order.common.rest.BusinessRestParam;
import com.bms.order.common.rest.BusinessRestResult;
import com.bms.order.common.rest.result.RestFailedData;
import com.bms.order.common.rest.result.RestSucceedData;
import com.bms.order.services.ORDR0804IService;
import com.bms.order.validator.ORDR0804IRestValidator;
import com.framework.boot.base.BaseRestController;
import com.framework.exception.BusinessException;
import com.framework.exception.bean.BusinessExceptionMessage;
import com.framework.i18n.util.MessageManager;
import com.framework.validator.annotation.Validator;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 买家现场退货数据接收接口Controller
 *
 * @author li_huiqian
 */
@RestController
@Api(tags = {"ORDR0804IRestController"}, description = "买家现场退货数据接收接口")
public class ORDR0804IRestController extends BaseRestController {

    @Autowired
    private ORDR0804IService service;

    /**
     * 接收配送PDA系统的现场拒收退货信息，创建退货单，创建完成的退货即为已确认状态，由于是在现场发起的退货，即认为是已经确认的退货
     *
     * @param param BusinessRestParam
     * @return BusinessRestResult
     */
    @ApiOperation(value = "买家现场退货数据接收接口", notes = "接收配送PDA系统的现场拒收退货信息，创建退货单，创建完成的退货即为已确认状态，由于是在现场发起的退货，即认为是已经确认的退货")
    @Validator(validatorClass = ORDR0804IRestValidator.class)
    @RequestMapping(value = "/order/buyer/reutrn/_reject", method = RequestMethod.POST, produces = {
            MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_XML_VALUE })
    public BusinessRestResult execute(@RequestBody BusinessRestParam<ORDR0804IBean> param) {
        List<ORDR0804IBean> beans = param.getBeans();
        Operator operator = Operator.Builder.build(param.getOperator());
        BusinessRestResult result = new BusinessRestResult();

        int processedCount = 0; // 处理条数
        int succeedCount = 0; // 处理成功条数
        int failedCount = 0; // 处理失败条数
        for (int i = 0; i < beans.size(); i++) {
            Long returnId = null;
            ORDR0804IBean bean = beans.get(i);
            try {
                returnId = service.execute(operator, bean);
                RestSucceedData succeedData = new RestSucceedData();
                succeedData.setSucceedId(returnId);
                succeedData.setIndex(i);
                result.putSucceedData(succeedData);
                succeedCount ++;
            } catch (BusinessException e) {
                e.printStackTrace();
                BusinessExceptionMessage bem = e.getBusinessExceptionMessages().get(0); // 没有多message的Exception
                RestFailedData failedData = new RestFailedData();
                failedData.setFailedDataId(returnId);
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
