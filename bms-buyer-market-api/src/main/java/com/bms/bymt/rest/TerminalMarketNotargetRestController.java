package com.bms.bymt.rest;

import com.bms.bymt.bean.entity.BymtTerminalMarketNotarget;
import com.bms.bymt.bean.param.BaseBean;
import com.bms.bymt.bean.param.TerminalMarketNotargetRsParam;
import com.bms.bymt.bean.result.BasePageResult;
import com.bms.bymt.constant.MessageDef;
import com.bms.bymt.services.BymtTerminalMarketNotargetService;
import com.bms.bymt.validator.TerminalMarketNotargetModifyValidator;
import com.bms.bymt.validator.TerminalMarketNotargetSaveValidator;
import com.framework.base.consts.NumberConst;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseRestController;
import com.framework.core.db.DbUtils;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.StringUtils;
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

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by yuan_zhifei on 2016/12/16.
 */
@RestController
@Api(value = "bms-bymt-api",
        description = "批发市场非目标买家汇总",
        position = 1,
        tags = "TerminalMarketNotargetRestController")
public class TerminalMarketNotargetRestController extends BaseRestController {
    @Autowired
    private BymtTerminalMarketNotargetService terminalMarketNotargetService;

    @ApiOperation(value = "批发市场非目标买家汇总查询", notes = "批发市场非目标买家汇总查询")
    @RequestMapping(value = "/buyerMarket/nonTarget/buyer/_search",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public BasePageResult<BymtTerminalMarketNotarget> searchBuyerMarketNonTargetBuyer(@RequestBody TerminalMarketNotargetRsParam marketNotargetRsParam) {
        if (StringUtils.isNotEmpty(marketNotargetRsParam.getNobuyerName())) {
            marketNotargetRsParam.setNobuyerName(DbUtils.buildLikeCondition(marketNotargetRsParam.getNobuyerName(), DbUtils.LikeMode.PARTIAL));
        }
        BasePageResult<BymtTerminalMarketNotarget> basePageResult = new BasePageResult<>();
        BaseRestPaginationResult<BymtTerminalMarketNotarget> pageList = this.terminalMarketNotargetService.findPageList(marketNotargetRsParam);
        TerminalMarketNotargetRsParam marketNotargetParam = this.terminalMarketNotargetService.findSum(marketNotargetRsParam);
        if (pageList != null) {
            basePageResult.setData(pageList.getData());
            if (marketNotargetParam != null) {
                if (StringUtils.isNotEmpty(StringUtils.toString(marketNotargetParam.getSumNoBuyerNum()))) {
                    basePageResult.setBuyerNumCount(marketNotargetParam.getSumNoBuyerNum());
                } else {
                    basePageResult.setBuyerNumCount(StringUtils.toString(NumberConst.IntDef.INT_ZERO));
                }
                if (StringUtils.isNotEmpty(StringUtils.toString(marketNotargetParam.getSumTradeAmount()))) {
                    basePageResult.setTradeAmountCount(marketNotargetParam.getSumTradeAmount());
                } else {
                    basePageResult.setTradeAmountCount(BigDecimal.ZERO);
                }
            } else {
                basePageResult.setBuyerNumCount(StringUtils.toString(NumberConst.IntDef.INT_ZERO));
                basePageResult.setTradeAmountCount(BigDecimal.ZERO);
            }
            basePageResult.setTotal(pageList.getTotal());
        }
        return basePageResult;
    }

    @ApiOperation(value = "批发市场非目标买家汇总信息新增", notes = "批发市场非目标买家汇总信息新增")
    @RequestMapping(value = "/buyerMarket/nonTarget/buyer/_add",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = TerminalMarketNotargetSaveValidator.class)
    public Integer addBuyerMarketNonTargetBuyer(@RequestBody List<TerminalMarketNotargetRsParam> notargetRsParams) {
        List<TerminalMarketNotargetRsParam> marketNotargetList = notargetRsParams;
        List<BymtTerminalMarketNotarget> marketNotargetEntityList = new ArrayList<>();
        TerminalMarketNotargetRsParam marketNotargetParam = null;
        BymtTerminalMarketNotarget terminalMarketNotarget = null;
        int result = NumberConst.IntDef.INT_ZERO;
        String[] returnMessage = this.checkMarketNotargetParams(marketNotargetList);
        if (StringUtils.isEmpty(returnMessage[NumberConst.IntDef.INT_ZERO])) {
            returnMessage = this.checkMarketNotargetParamList(marketNotargetList);
            Date currentDate = DateUtils.getCurrent();
            if (StringUtils.isEmpty(returnMessage[NumberConst.IntDef.INT_ZERO])) {
                int listSize = marketNotargetList.size();
                String loginUserId = this.terminalMarketNotargetService.getLoginUserId();
                for (int i = NumberConst.IntDef.INT_ZERO; i < listSize; i++) {
                    marketNotargetParam = marketNotargetList.get(i);
                    terminalMarketNotarget = BeanUtils.toBean(marketNotargetParam, BymtTerminalMarketNotarget.class);
                    Long notargetId = this.terminalMarketNotargetService.maxId("BYMT_TERMINAL_MARKET_NOTARGET");
                    terminalMarketNotarget.setNotargetId(notargetId);
                    terminalMarketNotarget.setDelFlg(false);
                    terminalMarketNotarget.setUpdId(loginUserId);
                    terminalMarketNotarget.setUpdTime(currentDate);
                    terminalMarketNotarget.setCrtId(loginUserId);
                    terminalMarketNotarget.setCrtTime(currentDate);
                    terminalMarketNotarget.setVersion(NumberConst.IntDef.INT_ONE);
                    marketNotargetEntityList.add(terminalMarketNotarget);
                }
                result = this.terminalMarketNotargetService.saveMarketNotargetList(marketNotargetEntityList);
            }
        }
        return result;
    }

    /**
     * 验证传入参数是否正确
     *
     * @param marketNotargetParamList
     * @return
     */
    private String[] checkMarketNotargetParamList(List<TerminalMarketNotargetRsParam> marketNotargetParamList) {
        TerminalMarketNotargetRsParam marketNotargetParam = null;
        BymtTerminalMarketNotarget terminalMarketNotarget = null;
        String[] args = null;
        String[] returnMessage = new String[NumberConst.IntDef.INT_ONE];
        String message = null;
        int listSize = marketNotargetParamList.size();
        for (int i = NumberConst.IntDef.INT_ZERO; i < listSize; i++) {
            marketNotargetParam = marketNotargetParamList.get(i);
            terminalMarketNotarget = BeanUtils.toBean(marketNotargetParam, BymtTerminalMarketNotarget.class);
            BymtTerminalMarketNotarget marketNotarget = this.terminalMarketNotargetService.findOne(terminalMarketNotarget);
            if (marketNotarget != null) {//非目标买家类型名称是否存在
                args = new String[]{MessageManager.getMessage(marketNotargetParam.getNobuyerName(), StringUtils.toString(i + NumberConst.IntDef.INT_ONE))};
                message = MessageManager.getMessage(MessageDef.Error.E00002, args);
                returnMessage[NumberConst.IntDef.INT_ZERO] = message;
                break;
            } else {
                continue;
            }
        }
        return returnMessage;
    }

    /**
     * 验证传入参数是否重复
     *
     * @param marketNotargetParamList
     * @return
     */
    private String[] checkMarketNotargetParams(List<TerminalMarketNotargetRsParam> marketNotargetParamList) {
        TerminalMarketNotargetRsParam param = null;
        String[] args = null;
        String[] returnMessage = new String[NumberConst.IntDef.INT_ONE];
        String message = null;
        int listSize = marketNotargetParamList.size();
        Set set = new HashSet();
        for (int i = NumberConst.IntDef.INT_ZERO; i < listSize; i++) {
            param = marketNotargetParamList.get(i);
            if (set.contains(param.getNobuyerName())) {
                args = new String[]{MessageManager.getMessage(param.getNobuyerName(), StringUtils.toString(i + NumberConst.IntDef.INT_ONE))};
                message = MessageManager.getMessage(MessageDef.Error.E00001, args);
                returnMessage[NumberConst.IntDef.INT_ZERO] = message;
            } else {
                set.add(param.getNobuyerName());
            }
        }
        return returnMessage;
    }

    @ApiOperation(value = "批发市场非目标买家汇总信息修改", notes = "批发市场非目标买家汇总信息修改")
    @RequestMapping(value = "/buyerMarket/nonTarget/buyer/_modify",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = TerminalMarketNotargetModifyValidator.class)
    public Integer modifyBuyerMarketNonTargetBuyer(@RequestBody List<BaseBean<TerminalMarketNotargetRsParam, TerminalMarketNotargetRsParam>> baseBeans) {
        int result = this.terminalMarketNotargetService.modifyMarketNoTargetBuyerList(baseBeans);
        return result;
    }
}
