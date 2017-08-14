package com.bms.bymt.rest;

import com.bms.bymt.bean.BaseRequest;
import com.bms.bymt.bean.entity.BymtTerminalMarketTarget;
import com.bms.bymt.bean.param.BaseBean;
import com.bms.bymt.bean.param.TerminalMarketTargetRsParam;
import com.bms.bymt.bean.result.BasePageResult;
import com.bms.bymt.services.BymtTerminalMarketTargetService;
import com.bms.bymt.utils.RestCommUtil;
import com.bms.bymt.validator.TerminalMarketTargetAddValidator;
import com.bms.bymt.validator.TerminalMarketTargetUpdateValidator;
import com.framework.base.consts.NumberConst;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseRestController;
import com.framework.core.db.DbUtils;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.StringUtils;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by tao_zhifa on 2016/12/15.
 */
@RestController
@Api(value = "bms-bymt-api", description = "批发市场目标买家汇总信息", position = 1, tags = "TerminalMarketTargetRestController")
public class TerminalMarketTargetRestController extends BaseRestController {
    @Autowired
    private BymtTerminalMarketTargetService bymtTerminalMarketTargetService;

    @ApiOperation(value = "批发市场目标买家汇总新增", notes = "批发市场目标买家汇总新增", position = 5)
    @RequestMapping(value = "/buyerMarket/terminalModule/target/buyer/_add", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = TerminalMarketTargetAddValidator.class)
    public Integer addBuyerMarketTerminalModule(@RequestBody List<TerminalMarketTargetRsParam> marketTargetRsParams) {
        BeanUtils.toBean(marketTargetRsParams, BymtTerminalMarketTarget.class);
        BymtTerminalMarketTarget bymtTerminalMarketTarget;
        List<BymtTerminalMarketTarget> list = new ArrayList<>();
        Date currentDate = DateUtils.getCurrent();
        String loginUserId = this.bymtTerminalMarketTargetService.getLoginUserId();
        for (int i = 0, sizes = marketTargetRsParams.size(); i < sizes; i++) {
            int proNameCount = bymtTerminalMarketTargetService.getCount(marketTargetRsParams.get(i));
            if (proNameCount != NumberConst.IntDef.INT_ZERO) {
                return NumberConst.IntDef.INT_N_ONE;
            }
            bymtTerminalMarketTarget = BeanUtils.toBean(marketTargetRsParams.get(i), BymtTerminalMarketTarget.class);
            Long maxId = bymtTerminalMarketTargetService.maxId("BYMT_TERMINAL_MARKET_TARGET");
            bymtTerminalMarketTarget.setTargetId(maxId);
            bymtTerminalMarketTarget.setCrtTime(currentDate);
            bymtTerminalMarketTarget.setUpdTime(currentDate);
            bymtTerminalMarketTarget.setCrtId(loginUserId);
            bymtTerminalMarketTarget.setUpdId(loginUserId);
            list.add(bymtTerminalMarketTarget);
        }
        List<List<BymtTerminalMarketTarget>> groupList = RestCommUtil.insertRanking(list);
        int count = bymtTerminalMarketTargetService.executeInsert(groupList);
        return count;
    }


    @ApiOperation(value = "批发市场目标买家汇总修改", notes = "批发市场目标买家汇总修改", position = 5)
    @RequestMapping(value = "/buyerMarket/terminalModule/target/buyer/_modify", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = TerminalMarketTargetUpdateValidator.class)
    public Integer modifyBuyerMarketTerminalModule(@RequestBody List<BaseBean<TerminalMarketTargetRsParam, TerminalMarketTargetRsParam>> baseBeans) {
        int beansSize = baseBeans.size();
        List<BaseBean<BymtTerminalMarketTarget, BymtTerminalMarketTarget>> baseBeanList = new ArrayList<>();
        String loginUserId = this.bymtTerminalMarketTargetService.getLoginUserId();
        for (int i = 0; i < beansSize; i++) {
            BymtTerminalMarketTarget filter = BeanUtils.toBean(baseBeans.get(i).getFilter(), BymtTerminalMarketTarget.class);
            BymtTerminalMarketTarget target = BeanUtils.toBean(baseBeans.get(i).getTarget(), BymtTerminalMarketTarget.class);
            Date currentDate = DateUtils.getCurrent();
            target.setUpdId(loginUserId);
            target.setUpdTime(currentDate);
            BaseRequest<BaseBean<BymtTerminalMarketTarget, BymtTerminalMarketTarget>> param = new BaseRequest<>();
            BaseBean<BymtTerminalMarketTarget, BymtTerminalMarketTarget> bean = new BaseBean<>();
            bean.setFilter(filter);
            bean.setTarget(target);
            param.setBean(bean);
            baseBeanList.add(bean);
        }
        int result = bymtTerminalMarketTargetService.executeModify(baseBeanList);
        return result;
    }


    @ApiOperation(value = "批发市场目标买家汇总查询", notes = "批发市场目标买家汇总查询", position = 5)
    @RequestMapping(value = "/buyerMarket/terminalModule/target/buyer/_search", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public BasePageResult<BymtTerminalMarketTarget> searchBuyerMarketTerminalModule(@RequestBody TerminalMarketTargetRsParam param) {
        if (StringUtils.isNotEmpty(param.getBuyerName())) {
            param.setBuyerName(DbUtils.buildLikeCondition(param.getBuyerName(), DbUtils.LikeMode.PARTIAL));
        }
        if (StringUtils.isNotEmpty(param.getProName())) {
            param.setProName(DbUtils.buildLikeCondition(param.getProName(), DbUtils.LikeMode.PARTIAL));
        }
        BasePageResult<BymtTerminalMarketTarget> basePageResult = new BasePageResult<>();
        BaseRestPaginationResult<BymtTerminalMarketTarget> list = bymtTerminalMarketTargetService.findPageList(param);
        TerminalMarketTargetRsParam marketTargetRsParam = bymtTerminalMarketTargetService.findSum(param);
        if (list != null) {
            basePageResult.setData(list.getData());
            if (marketTargetRsParam != null) {
                if (StringUtils.isNotEmpty(StringUtils.toString(marketTargetRsParam.getSumBuyerNum()))) {
                    basePageResult.setBuyerNumCount(marketTargetRsParam.getSumBuyerNum());
                } else {
                    basePageResult.setBuyerNumCount(StringUtils.toString(NumberConst.IntDef.INT_ZERO));
                }
                if (StringUtils.isNotEmpty(StringUtils.toString(marketTargetRsParam.getSumTradeAmount()))) {
                    basePageResult.setTradeAmountCount(marketTargetRsParam.getSumTradeAmount());
                } else {
                    basePageResult.setTradeAmountCount(BigDecimal.ZERO);
                }
            } else {
                basePageResult.setBuyerNumCount(StringUtils.toString(NumberConst.IntDef.INT_ZERO));
                basePageResult.setTradeAmountCount(BigDecimal.ZERO);
            }
            basePageResult.setTotal(list.getTotal());
        }
        return basePageResult;
    }

}
