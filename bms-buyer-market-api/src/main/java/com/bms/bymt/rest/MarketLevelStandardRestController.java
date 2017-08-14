package com.bms.bymt.rest;

import com.bms.bymt.bean.entity.BymtLevelStandard;
import com.bms.bymt.bean.param.BaseBean;
import com.bms.bymt.bean.param.MarketLevelStandardRsParam;
import com.bms.bymt.bean.param.TermGradeResultParam;
import com.bms.bymt.services.BymtLevelStandardService;
import com.bms.bymt.services.BymtTermGradeResultService;
import com.bms.bymt.validator.MarketLevelStandardModifyValidator;
import com.bms.bymt.validator.MarketLevelStandardSaveValidator;
import com.framework.base.consts.NumberConst;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseRestController;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.StringUtils;
import com.framework.validator.annotation.Validator;
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

import java.util.List;

/**
 * Created by yuan_zhifei on 2016/12/15.
 */
@RestController
@Api(value = "bms-bymt-api",
        description = "批发市场级别信息",
        position = 1,
        tags = "MarketLevelStandardRestController")
public class MarketLevelStandardRestController extends BaseRestController {
    Logger logger = LoggerFactory.getLogger(MarketLevelStandardRestController.class);
    @Autowired
    private BymtLevelStandardService levelStandardService;

    @Autowired
    private BymtTermGradeResultService bymtTermGradeResultService;

    @ApiOperation(value = "批发市场级别标准查询", notes = "批发市场级别标准查询")
    @RequestMapping(value = "/buyerMarket/terminalModule/standard/_search",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public BaseRestPaginationResult<MarketLevelStandardRsParam> searchBuyerMarketStandard(@RequestBody MarketLevelStandardRsParam paramRequest) {
        return this.levelStandardService.findPageList(paramRequest);
    }

    @ApiOperation(value = "批发市场级别标准新增", notes = "批发市场级别标准新增")
    @RequestMapping(value = "/buyerMarket/terminalModule/standard/_add",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = MarketLevelStandardSaveValidator.class)
    public Integer addBuyerMarketStandard(@RequestBody MarketLevelStandardRsParam paramRequest) {
        BymtLevelStandard levelStandard = BeanUtils.toBean(paramRequest, BymtLevelStandard.class);
        List<BymtLevelStandard> list = this.levelStandardService.findList(levelStandard);
        if (CollectionUtils.isNotEmpty(list)) {
            return -1;
        } else {
            return this.levelStandardService.saveLevelStandard(levelStandard);
        }

    }

    @ApiOperation(value = "批发市场级别标准修改|删除", notes = "批发市场级别标准修改|删除")
    @RequestMapping(value = "/buyerMarket/terminalModule/standard/_update",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = MarketLevelStandardModifyValidator.class)
    public Integer updateBuyerMarketStandard(@RequestBody BaseBean<MarketLevelStandardRsParam, MarketLevelStandardRsParam> paramRequest) {
        int result = NumberConst.IntDef.INT_ZERO;
        BymtLevelStandard standardTarget = BeanUtils.toBean(paramRequest.getTarget(), BymtLevelStandard.class);
        BymtLevelStandard standardFilter = BeanUtils.toBean(paramRequest.getFilter(), BymtLevelStandard.class);

        BaseBean<BymtLevelStandard, BymtLevelStandard> standardBaseBean = new BaseBean<>();
        standardBaseBean.setFilter(standardFilter);
        standardBaseBean.setTarget(standardTarget);
        int regCount = NumberConst.IntDef.INT_ZERO;
        List<BymtLevelStandard> list = null;
        if(standardTarget.getDelFlg() == true && StringUtils.isNotEmpty(standardTarget.getStandardLevel())){
            // 校验批发市场定性定级结果处是否有该级别信息
            TermGradeResultParam termGradeResultParam = new TermGradeResultParam();
            termGradeResultParam.setTermMarketLevel(standardTarget.getStandardLevel());
            int count = bymtTermGradeResultService.getCount(termGradeResultParam);
            if(count > 0){
                logger.info("该市场级别信息在批发市场结果信息中存在，不可删除!");
                return -1;
            }
        }
        logger.info("判断级别标准编码和级别标准级别名称是否存在");
        if (StringUtils.isNotEmpty(standardTarget.getStandardCode()) || StringUtils.isNotEmpty(standardTarget.getStandardLevel())) {
            list = this.levelStandardService.findList(standardTarget);
        }
        if (CollectionUtils.isNotEmpty(list)) {
            int listSize = list.size();
            for (int i = NumberConst.IntDef.INT_ZERO; i < listSize; i++) {
                BymtLevelStandard marketStandard = list.get(i);
                if (!marketStandard.getStandardId().equals(standardFilter.getStandardId())) {//不是自身
                    regCount = 1;
                    break;
                } else {
                    continue;
                }
            }
        }
        if (regCount == 0) {
            logger.info("批发市场级别标准修改开始");
            result = levelStandardService.modifyLevelStandard(standardBaseBean);
        }
        return result;
    }
}