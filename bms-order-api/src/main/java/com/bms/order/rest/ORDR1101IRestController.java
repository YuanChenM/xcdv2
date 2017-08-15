package com.bms.order.rest;

import com.bms.order.archive.impl.Operator;
import com.bms.order.bean.param.ORDR110102IBeanParam;
import com.bms.order.bean.param.ORDR1101IBeanParam;
import com.bms.order.common.rest.BusinessRestResult;
import com.bms.order.common.rest.result.RestFailedData;
import com.bms.order.common.rest.result.RestSucceedData;
import com.bms.order.fms.common.FmsCommon;
import com.bms.order.services.ORDR1101IService;
import com.framework.boot.base.BaseRestController;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.CollectionUtils;
import com.framework.exception.BusinessException;
import com.framework.exception.bean.BusinessExceptionMessage;
import com.framework.i18n.util.MessageManager;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by guan_zhongheng on 2017/4/26.
 * 沽货订单入库
 */
@RestController
@Api(tags = {"ORDR1101IRestController"}, description = "沽货订单创建接口")
public class ORDR1101IRestController extends BaseRestController {

    public static final Logger logger = LoggerFactory.getLogger(ORDR1101IRestController.class);
    @Autowired
    private ORDR1101IService ordr0110IService;

    @Autowired
    private FmsCommon fmsCommon;


    /**
     * 接收沽货订单（交割）信息创建沽货订单
     *
     * @param param BusinessRestParam
     * @return BusinessRestResult
     */
    @ApiOperation(value = "沽货订单创建接口", notes = "接收沽货订单（交割）信息创建沽货订单")
//    @Validator(validatorClass = ORDR0101IRestValidator.class)
    @RequestMapping(value = "/order/bs/short/selling/_create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BusinessRestResult execute(@RequestBody ORDR110102IBeanParam param) {
        List<ORDR1101IBeanParam> beans = param.getBeans();
        if (CollectionUtils.isEmpty(beans)) {
            throw new BusinessException("ORDR", "参数不能为空");
        }
        BusinessRestResult restResult = new BusinessRestResult();
        Operator operator = Operator.Builder.build(param.getOperator());
        int processedCount = 0; // 处理条数
        int succeedCount = 0; // 处理成功条数
        int failedCount = 0; // 处理失败条数
        for (int i = 0; i < beans.size(); i++) {
            ORDR1101IBeanParam beanParam = beans.get(i);
            try {
                // 修改金额精度信息
                ORDR1101IBeanParam beanParamNew = BeanUtils.toBean(beanParam,ORDR1101IBeanParam.class);
                beanParamNew.setBuyerDelMoney(divide(beanParam.getBuyerDelMoney()));
                beanParamNew.setSellerFeeMoney(divide(beanParam.getSellerFeeMoney()));
                beanParamNew.setSellerDepositMoney(divide(beanParam.getSellerDepositMoney()));
                beanParamNew.setSellerDelMoney(divide(beanParam.getSellerDelMoney()));
                beanParamNew.setBuyerFeeMoney(divide(beanParam.getBuyerFeeMoney()));
                beanParamNew.setBuyerDepositMoney(divide(beanParam.getBuyerDepositMoney()));
                beanParamNew.setTotalPrice(divide(beanParam.getTotalPrice()));

                long orderId = ordr0110IService.execute(beanParamNew,operator);
                RestSucceedData succeedData = new RestSucceedData();
                succeedData.setSucceedId(orderId);
                succeedData.setIndex(i);
                restResult.putSucceedData(succeedData);
                succeedCount++;
                // fms信息推送调用
                fmsCommon.pushShortSellOrder(orderId);
            }catch (BusinessException e){
                BusinessExceptionMessage bem = e.getBusinessExceptionMessages().get(0); // 没有多message的Exception
                RestFailedData failedData = new RestFailedData();
                failedData.setFailedDataId(null);
                failedData.setErrorParams(bem.getMessageParams());
                failedData.setModuleName(bem.getModuleName());
                failedData.setErrorCode(bem.getMessageCode());
                failedData.setErrorMessage(MessageManager.getMessage(bem.getMessageCode(), bem.getMessageParams()));
                restResult.putFailedData(failedData);
                failedCount ++;
            }finally {
                processedCount++;
            }
        }
        restResult.setProcessedCount(processedCount);
        restResult.setSucceedCount(succeedCount);
        restResult.setFailedCount(failedCount);
        return restResult;
    }

    private static BigDecimal divide(BigDecimal source){
        BigDecimal b1 = new BigDecimal("100");
        BigDecimal b3 = source.divide(b1,2,BigDecimal.ROUND_HALF_EVEN);
        return b3;
    }
}
