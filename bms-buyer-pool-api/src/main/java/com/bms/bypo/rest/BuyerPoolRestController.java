package com.bms.bypo.rest;

import com.bms.bypo.bean.param.BaseBean;
import com.bms.bypo.bean.param.BuyerPoolRsParam;
import com.bms.bypo.bean.result.BuyerPoolRsResult;
import com.bms.bypo.services.BypoBuyerPoolService;
import com.bms.bypo.validator.BuyerPoolAddValidator;
import com.bms.bypo.validator.BuyerPoolUpdateValidator;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseRestController;
import com.framework.core.db.DbUtils;
import com.framework.core.utils.StringUtils;
import com.framework.exception.BusinessException;
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

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zhou_yajun
 * @version 1.0
 */
@RestController
@Api(value = "bms-bypo-api", description = "物流区分类买家池管理", position = 1, tags = "BuyerPoolRestController")
public class BuyerPoolRestController extends BaseRestController {

    Logger logger = LoggerFactory.getLogger(BuyerPoolRestController.class);

    @Autowired
    private BypoBuyerPoolService bypoBuyerPoolService;

    @ApiOperation(value = "物流区分类买家池查询", notes = "物流区分类买家池查询")
    @RequestMapping(value = "/buyerPool/_search", method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public BaseRestPaginationResult<BuyerPoolRsParam> search(@RequestBody BuyerPoolRsParam param) {
        param.setBuyerPoolName(DbUtils.buildLikeCondition(param.getBuyerPoolName(), DbUtils.LikeMode.PARTIAL));
        param.setBuyerPoolCode(DbUtils.buildLikeCondition(param.getBuyerPoolCode(), DbUtils.LikeMode.PARTIAL));
        BaseRestPaginationResult<BuyerPoolRsParam> searchResult = bypoBuyerPoolService.findPageList(param);
        return searchResult;
    }

    @ApiOperation(value = "物流区分类买家池新增", notes = "物流区分类买家池新增")
    @RequestMapping(value = "/buyerPool/_add", method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = BuyerPoolAddValidator.class)
    public BuyerPoolRsResult add(@RequestBody List<BuyerPoolRsParam> param) {
        //传入参数校验
        insertBuyerPoolCheck(param);
        insertBuyerPoolCheckWithDb(param);
        //批量插入DB(每100条插入)
        BuyerPoolRsResult buyerPoolRsResult = this.bypoBuyerPoolService.insertBuyerPool(param);
        return buyerPoolRsResult;
    }

    @ApiOperation(value = "物流区分类买家池更新", notes = "物流区分类买家池更新")
    @RequestMapping(value = "/buyerPool/_update", method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = BuyerPoolUpdateValidator.class)
    public BuyerPoolRsResult update(@RequestBody List<BaseBean<BuyerPoolRsParam, BuyerPoolRsParam>> param) {
        //传入参数校验
        updateBuyerPoolCheck(param);
        updateBuyerPoolCheckWithDb(param);
        //更新DB
        BuyerPoolRsResult buyerPoolRsResult = this.bypoBuyerPoolService.modifyBuyerPool(param);
        return buyerPoolRsResult;
    }


    /**
     * 验证插入参数分类买家池编码是否重复
     *
     * @param inParamList
     * @return
     */
    public void insertBuyerPoolCheck(List<BuyerPoolRsParam> inParamList) {
        Set<String> inParamSet = new HashSet<>();
        for (int i = 0; i < inParamList.size(); i++) {
            BuyerPoolRsParam buyerPoolRsParam = inParamList.get(i);
            if (inParamSet.contains(buyerPoolRsParam.getBuyerPoolCode())) {
                throw new BusinessException("bypo", "BYPO.E00004");
            } else {
                inParamSet.add(buyerPoolRsParam.getBuyerPoolCode());
            }
        }
    }

    /**
     * 验证更新参数分类买家池编码是否重复
     *
     * @param updateParamList
     * @return
     */
    public void updateBuyerPoolCheck(List<BaseBean<BuyerPoolRsParam, BuyerPoolRsParam>> updateParamList) {
        Set<String> updateParamSet = new HashSet<>();
        for (int i = 0; i < updateParamList.size(); i++) {
            BuyerPoolRsParam target = updateParamList.get(i).getTarget();
            if (!StringUtils.isEmpty(target.getBuyerPoolCode())) {
                if (updateParamSet.contains(target.getBuyerPoolCode())) {
                    throw new BusinessException("bypo", "BYPO.E00004");
                } else {
                    updateParamSet.add(target.getBuyerPoolCode());
                }
            }
        }
    }

    /**
     * 验证插入参数和DB数据是否重复
     *
     * @param inParamList
     */
    public void insertBuyerPoolCheckWithDb(List<BuyerPoolRsParam> inParamList) {
        for (int i = 0; i < inParamList.size(); i++) {
            BuyerPoolRsParam buyerPoolRsParam = inParamList.get(i);
            BuyerPoolRsParam buyerPoolDb = this.bypoBuyerPoolService.findOne(buyerPoolRsParam);
            if (buyerPoolDb != null) {
                throw new BusinessException("bypo", "BYPO.E00005");
            }
        }
    }

    /**
     * 验证更新参数和DB数据是否重复
     *
     * @param updateParamList
     */
    public void updateBuyerPoolCheckWithDb(List<BaseBean<BuyerPoolRsParam, BuyerPoolRsParam>> updateParamList) {
        for (int i = 0; i < updateParamList.size(); i++) {
            //BuyerPoolRsParam filter = updateParamList.get(i).getFilter();
            BuyerPoolRsParam target = updateParamList.get(i).getTarget();
            BuyerPoolRsParam buyerPoolRsParam = new BuyerPoolRsParam();
            buyerPoolRsParam.setBuyerPoolId(null);
            buyerPoolRsParam.setLgcsAreaId(target.getLgcsAreaId());
            buyerPoolRsParam.setBuyerPoolCode(target.getBuyerPoolCode());
            BuyerPoolRsParam buyerPoolDbByFilter = this.bypoBuyerPoolService.findOne(buyerPoolRsParam);
            if (buyerPoolDbByFilter != null && !buyerPoolDbByFilter.getBuyerPoolId().equals(target.getBuyerPoolId())) {
                throw new BusinessException("bypo", "BYPO.E00005");
            }
            /*if (!StringUtils.isEmpty(target.getBuyerPoolCode()) && !target.getBuyerPoolCode().equals(buyerPoolDbByFilter.getBuyerPoolCode())) {
                BuyerPoolRsParam buyerPoolDbByTarget = this.bypoBuyerPoolService.findOne(target);
                if (buyerPoolDbByTarget != null) {
                    throw new BusinessException("bypo", "BYPO.E00005");
                }
            }*/
        }
    }
}
