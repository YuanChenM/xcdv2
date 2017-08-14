package com.bms.byim.rest;

import com.bms.byim.bean.entity.ByimMarketingStatus;
import com.bms.byim.bean.param.BaseBean;
import com.bms.byim.bean.param.MarketingStatusRsParam;
import com.bms.byim.bean.result.MarketingStatusTreeRsResult;
import com.bms.byim.constant.MessageDef;
import com.bms.byim.services.ByimMarketingStatusService;
import com.bms.byim.validator.MarketingStatusModifyValidator;
import com.bms.byim.validator.MarketingStatusSaveValidator;
import com.framework.base.consts.NumberConst;
import com.framework.boot.base.BaseRestController;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.StringUtils;
import com.framework.exception.BusinessException;
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

import java.util.*;

/**
 * Created by yuan_zhifei on 2016/12/1.
 */
@RestController
@Api(value = "bms-byim-api",
        description = "买家上线状态信息",
        position = 1,
        tags = "MarketingStatusRestController")
public class MarketingStatusRestController extends BaseRestController {
    @Autowired
    private ByimMarketingStatusService marketingStatusService;

    @ApiOperation(value = "查询列表结构买家上线状态", notes = "查询列表结构买家上线状态")
    @RequestMapping(value = "/buyers/marketingStatus/list/_search",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public MarketingStatusTreeRsResult searchMarketingStatusList(@RequestBody MarketingStatusRsParam statusRsParam) {
        MarketingStatusTreeRsResult statusResult = this.marketingStatusService.findItemList(statusRsParam);
        return statusResult;
    }

    @ApiOperation(value = "查询树状结构买家上线状态", notes = "查询树状结构买家上线状态")
    @RequestMapping(value = "/buyers/marketingStatus/tree/_search",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    //@Validator(validatorClass = MarketingStatusSearchValidator.class)
    public MarketingStatusTreeRsResult searchMarketingStatusTree(@RequestBody MarketingStatusRsParam statusRsParam) {
        MarketingStatusTreeRsResult statusTreeRsResult = this.marketingStatusService.findItemTree(statusRsParam);
        return statusTreeRsResult;
    }

    @ApiOperation(value = "买家上线状态新增", notes = "买家上线状态新增")
    @RequestMapping(value = "/buyers/marketingStatus/_add",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = MarketingStatusSaveValidator.class)
    public Integer addMarketingStatus(@RequestBody List<MarketingStatusRsParam> statusRsParamList) {
        List<MarketingStatusRsParam> statusParamList = statusRsParamList;
        List<ByimMarketingStatus> statusList = new ArrayList<>();
        MarketingStatusRsParam statusParam = null;
        ByimMarketingStatus buyerMarketingStatus = null;
        Date currentDate = DateUtils.getCurrent();
        int result = NumberConst.IntDef.INT_ZERO;
        String[] returnMessage = checkStatusParams(statusParamList);
        if (StringUtils.isEmpty(returnMessage[NumberConst.IntDef.INT_ZERO])) {
            returnMessage = checkStatusParamList(statusParamList);
            //传入参数正确
            if (StringUtils.isEmpty(returnMessage[NumberConst.IntDef.INT_ZERO])) {
                String loginUserId = this.marketingStatusService.getLoginUserId();
                int listSize = statusParamList.size();
                for (int i = NumberConst.IntDef.INT_ZERO; i < listSize; i++) {
                    statusParam = statusRsParamList.get(i);
                    buyerMarketingStatus = BeanUtils.toBean(statusParam, ByimMarketingStatus.class);
                    Long marketingStatusId = this.marketingStatusService.maxId("BYIM_MARKETING_STATUS");
                    if (buyerMarketingStatus.getParentId() != NumberConst.IntDef.INT_ZERO) {//父节点不是一级节点
                        //查询父节点是否存在
                        ByimMarketingStatus marketingStatus = this.marketingStatusService.findOne(buyerMarketingStatus);
                        //父节点存在
                        buyerMarketingStatus.setNodePath(marketingStatus.getNodePath() + ',' + marketingStatusId);
                    } else {//父节点为一级节点
                        buyerMarketingStatus.setNodePath(StringUtils.toString(marketingStatusId));
                    }
                    buyerMarketingStatus.setMarketingStatusId(marketingStatusId);
                    buyerMarketingStatus.setCrtId(loginUserId);
                    buyerMarketingStatus.setCrtTime(currentDate);
                    buyerMarketingStatus.setUpdId(loginUserId);
                    buyerMarketingStatus.setUpdTime(currentDate);
                    buyerMarketingStatus.setDelFlg(false);
                    buyerMarketingStatus.setVersion(NumberConst.IntDef.INT_ONE);
                    statusList.add(buyerMarketingStatus);
                }
                result = this.marketingStatusService.saveStatusParamList(statusList);
            }
        }
        return result;
    }

    /**
     * 验证传入参数是否正确
     *
     * @param statusParamList
     * @return
     */
    private String[] checkStatusParamList(List<MarketingStatusRsParam> statusParamList) {
        String[] args = null;
        String[] returnMessage = null;
        String message = null;
        MarketingStatusRsParam statusParam = null;
        ByimMarketingStatus byimMarketingStatus = null;
        if (CollectionUtils.isNotEmpty(statusParamList)) {
            int listSize = statusParamList.size();
            Set set = new HashSet();
            returnMessage = new String[NumberConst.IntDef.INT_ONE];
            for (int i = NumberConst.IntDef.INT_ZERO; i < listSize; i++) {
                statusParam = statusParamList.get(i);
                ByimMarketingStatus filter = BeanUtils.toBean(statusParam, ByimMarketingStatus.class);
                //判断父节点是否存在
                if (filter.getParentId() != NumberConst.IntDef.INT_ZERO) {//不是一级节点
                    //查询父节点是否存在
                    ByimMarketingStatus marketingStatus = this.marketingStatusService.findOne(filter);
                    if (marketingStatus == null) {
                        args = new String[]{MessageManager.getMessage(StringUtils.toString(filter.getParentId()), StringUtils.toString(i + NumberConst.IntDef.INT_ONE))};
                        message = MessageManager.getMessage(MessageDef.Error.E00002, args);
                        returnMessage[NumberConst.IntDef.INT_ZERO] = message;
                        break;
                    }
                }
                //查询同级下面的上线状态编码是否相同
                List<ByimMarketingStatus> byimMarketingStatusList = this.marketingStatusService.findMarketingStatusListByParentId(filter);
                if (CollectionUtils.isNotEmpty(byimMarketingStatusList)) {
                    for (int j = NumberConst.IntDef.INT_ZERO; j < byimMarketingStatusList.size(); j++) {
                        byimMarketingStatus = byimMarketingStatusList.get(j);
                        if (statusParam.getMarketingStatusCode().equals(byimMarketingStatus.getMarketingStatusCode())) {
                            /*args = new String[]{MessageManager.getMessage(statusParam.getMarketingStatusCode(), StringUtils.toString(i + NumberConst.IntDef.INT_ONE))};
                            message = MessageManager.getMessage(MessageDef.Error.E00001, args);
                            returnMessage[NumberConst.IntDef.INT_ZERO] = message;
                            break;*/
                            throw new BusinessException("BY", "BYIM.E00018");
                        } else {
                            continue;
                        }
                    }
                }
            }
        }
        return returnMessage;
    }

    /**
     * 新增时验证传入参数之间是否有重复的
     *
     * @param statusParamList
     * @return
     */
    private String[] checkStatusParams(List<MarketingStatusRsParam> statusParamList) {
        String[] returnMessage = null;
        if (CollectionUtils.isNotEmpty(statusParamList)) {
            MarketingStatusRsParam statusParam = null;
            int listSize = statusParamList.size();
            Set set = new HashSet();
            String[] args = null;
            String message = null;
            returnMessage = new String[NumberConst.IntDef.INT_ONE];
            for (int i = NumberConst.IntDef.INT_ZERO; i < listSize; i++) {
                statusParam = statusParamList.get(i);
                if (!StringUtils.isEmpty(statusParam.getMarketingStatusCode())){
                    if (set.contains(statusParam.getMarketingStatusCode())) {
                    /*args = new String[]{MessageManager.getMessage(statusParam.getMarketingStatusCode(), StringUtils.toString(i + NumberConst.IntDef.INT_ONE))};
                    message = MessageManager.getMessage(MessageDef.Error.E00001, args);
                    returnMessage[NumberConst.IntDef.INT_ZERO] = message;*/
                        throw new BusinessException("BY", "BYIM.E00019");
                    } else {
                        set.add(statusParam.getMarketingStatusCode());
                    }
                }

            }
        }
        return returnMessage;
    }

    @ApiOperation(value = "买家上线状态修改", notes = "买家上线状态修改")
    @RequestMapping(value = "/buyers/marketingStatus/_modify",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = MarketingStatusModifyValidator.class)
    public Integer modifyMarketingStatus(@RequestBody List<BaseBean<MarketingStatusRsParam, MarketingStatusRsParam>> baseBeanList) {
        ByimMarketingStatus status = null;
        int listSize = baseBeanList.size();
        String[] args = null;
        String[] returnMessage = new String[NumberConst.IntDef.INT_ONE];
        String message = null;
        int result = NumberConst.IntDef.INT_ZERO;
        if (listSize > NumberConst.IntDef.INT_ZERO) {
            List<BaseBean<MarketingStatusRsParam, MarketingStatusRsParam>> statusRsParamList = new ArrayList<>();
            for (int i = NumberConst.IntDef.INT_ZERO; i < listSize; i++) {
                BaseBean<MarketingStatusRsParam, MarketingStatusRsParam> baseBean = baseBeanList.get(i);
                MarketingStatusRsParam statusRsParam = baseBean.getFilter();
                //通过买家上线状态ID查询修改之前的买家上线状态编码
                ByimMarketingStatus marketingStatus = this.marketingStatusService.findMarketingStatusById(statusRsParam);
                if ((("01".equals(marketingStatus.getMarketingStatusCode())) && "预注册买家".equals(marketingStatus.getMarketingStatusName()))
                        || (("02".equals(marketingStatus.getMarketingStatusCode())) && "未营销成功买家".equals(marketingStatus.getMarketingStatusName()))) {
                    result = NumberConst.IntDef.INT_N_ONE;
                    break;
                }
                statusRsParam.setMarketingStatusCode(marketingStatus.getMarketingStatusCode());
                statusRsParam.setMarketingStatusName(marketingStatus.getMarketingStatusName());
                baseBean.setFilter(statusRsParam);
                statusRsParamList.add(baseBean);
            }
            if(result != NumberConst.IntDef.INT_N_ONE){
                result = this.marketingStatusService.findMarketingStatus(statusRsParamList);
                if (result > NumberConst.IntDef.INT_ZERO) {//上线状态已被使用
                    result = NumberConst.IntDef.INT_N_ONE;
                } else {
                    Set set = new HashSet();
                    for (int i = NumberConst.IntDef.INT_ZERO; i < listSize; i++) {
                        MarketingStatusRsParam filter = baseBeanList.get(i).getFilter();
                        MarketingStatusRsParam target = baseBeanList.get(i).getTarget();
                        if (StringUtils.isNotEmpty(target.getMarketingStatusCode())) {
                            if (set.contains(target.getMarketingStatusCode())) {
                                args = new String[]{MessageManager.getMessage(target.getMarketingStatusCode(), StringUtils.toString(i + NumberConst.IntDef.INT_ONE))};
                                message = MessageManager.getMessage(MessageDef.Error.E00001, args);
                                returnMessage[NumberConst.IntDef.INT_ZERO] = message;
                                break;
                            } else {
                                set.add(target.getMarketingStatusCode());
                            }
                        }
                        if (StringUtils.isEmpty(returnMessage[NumberConst.IntDef.INT_ZERO])) {
                            //修改上线状态编码
                            if (StringUtils.isNotEmpty(target.getMarketingStatusCode())) {
                                ByimMarketingStatus marketingStatus = this.marketingStatusService.findMarketingStatusById(filter);
                                if (marketingStatus != null) {
                                    List<ByimMarketingStatus> statusList = this.marketingStatusService.findMarketingStatusListByParentId(marketingStatus);
                                    if (CollectionUtils.isNotEmpty(statusList)) {
                                        for (int j = NumberConst.IntDef.INT_ZERO; j < statusList.size(); j++) {
                                            status = statusList.get(j);
                                            if (target.getMarketingStatusCode().equals(status.getMarketingStatusCode())) {
                                                if (!filter.getMarketingStatusId().equals(status.getMarketingStatusId())) {//修改自身
                                                    args = new String[]{MessageManager.getMessage(target.getMarketingStatusCode(), StringUtils.toString(i + NumberConst.IntDef.INT_ONE))};
                                                    message = MessageManager.getMessage(MessageDef.Error.E00001, args);
                                                    returnMessage[NumberConst.IntDef.INT_ZERO] = message;
                                                    break;
                                                }
                                            } else {
                                                continue;
                                            }
                                        }
                                    }
                                } else {
                                    args = new String[]{MessageManager.getMessage(MessageDef.Label.L00007)};
                                    message = MessageManager.getMessage(MessageDef.Error.E00007, args);
                                    returnMessage[NumberConst.IntDef.INT_ZERO] = message;
                                }
                            }
                        }
                    }
                    if (StringUtils.isEmpty(returnMessage[NumberConst.IntDef.INT_ZERO])) {
                        result = this.marketingStatusService.modifyMarketingstatusList(baseBeanList);
                    }
                }
            }
        }
        return result;
    }
}
