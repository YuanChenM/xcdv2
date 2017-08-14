package com.bms.byim.rest;

import com.bms.byim.bean.entity.ByimBuyerPoolRelationShip;
import com.bms.byim.bean.param.BaseBean;
import com.bms.byim.bean.param.BuyerAccountRsParam;
import com.bms.byim.bean.param.BuyerPoolBuyersRsParam;
import com.bms.byim.bean.param.BuyerPoolRelationShipRsParam;
import com.bms.byim.services.ByimBuyerPoolRelationShipService;
import com.bms.byim.services.ByimBuyerService;
import com.bms.byim.utils.RestCommUtil;
import com.bms.byim.validator.BuyerPoolBuyersSearchValidator;
import com.bms.byim.validator.BuyerPoolRelationShipAddValidator;
import com.bms.byim.validator.BuyerPoolRelationShipSearchValidator;
import com.bms.byim.validator.BuyerPoolRelationShipUpdateValidator;
import com.framework.base.consts.NumberConst;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseRestController;
import com.framework.core.db.DbUtils;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.DateUtils;
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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by tao_zhifa on 2016/12/30.
 */

@RestController
@Api(value = "bms-byim-api", description = "买家所属买家池", position = 1, tags = "BuyerPoolRelationShipRestController")
public class BuyerPoolRelationShipRestController extends BaseRestController {

    Logger logger = LoggerFactory.getLogger(CateGoryRestController.class);
    @Autowired
    private ByimBuyerPoolRelationShipService byimBuyerPoolRelationShipService;
    @Autowired
    private ByimBuyerService byimBuyerService;

    @ApiOperation(value = "买家所属买家池新增", notes = "买家所属买家池新增", position = 5)
    @RequestMapping(value = "/buyers/buyerpool/_add", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = BuyerPoolRelationShipAddValidator.class)
    public Integer addBuyerPool(@RequestBody List<BuyerPoolRelationShipRsParam> paramList) {
        logger.info("买家所属买家池新增");
        List<ByimBuyerPoolRelationShip> list = new ArrayList<>();
        for (int i = 0, sizes = paramList.size(); i < sizes; i++) {
            int count = byimBuyerPoolRelationShipService.getCount(paramList.get(i));
            if (count != NumberConst.IntDef.INT_ZERO) {
                throw new BusinessException("BYIM", "BYIM.E00022");
            }
            ByimBuyerPoolRelationShip bean = BeanUtils.toBean(paramList.get(i), ByimBuyerPoolRelationShip.class);
            Date currentDate = DateUtils.getCurrent();
            Long maxId = byimBuyerPoolRelationShipService.maxId("BYIM_BUYER_POOL_RELATION_SHIP");
            String loginUserId = this.byimBuyerPoolRelationShipService.getLoginUserId();
            bean.setUpdId(loginUserId);
            bean.setCrtId(loginUserId);
            bean.setUpdTime(currentDate);
            bean.setCrtTime(currentDate);
            bean.setRelationShipId(maxId);
            list.add(bean);
        }
        List<List<ByimBuyerPoolRelationShip>> insertList = RestCommUtil.insertRanking(list);
        int count;
        count = byimBuyerPoolRelationShipService.executeBatchSave(insertList);
        return count;
    }

    @ApiOperation(value = "买家所属买家池更新", notes = "买家所属买家池更新", position = 5)
    @RequestMapping(value = "/buyers/buyerpool/_modify", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = BuyerPoolRelationShipUpdateValidator.class)
    public Integer modifyBuyerPool(@RequestBody List<BaseBean<BuyerPoolRelationShipRsParam, BuyerPoolRelationShipRsParam>> baseList) {
        logger.info("买家所属买家池更新");
        List<BaseBean<ByimBuyerPoolRelationShip, ByimBuyerPoolRelationShip>> baseBeanList = new ArrayList<>();
        String loginUserId = this.byimBuyerPoolRelationShipService.getLoginUserId();
        for (int i = 0, beansSize = baseList.size(); i < beansSize; i++) {
            BaseBean<ByimBuyerPoolRelationShip, ByimBuyerPoolRelationShip> bean = new BaseBean<>();
            Date currentDate = DateUtils.getCurrent();
            ByimBuyerPoolRelationShip filter = BeanUtils.toBean(baseList.get(i).getFilter(), ByimBuyerPoolRelationShip.class);
            ByimBuyerPoolRelationShip target = BeanUtils.toBean(baseList.get(i).getTarget(), ByimBuyerPoolRelationShip.class);
            target.setUpdId(loginUserId);
            target.setUpdTime(currentDate);
            bean.setFilter(filter);
            bean.setTarget(target);
            baseBeanList.add(bean);
        }
        int count;
        count = byimBuyerPoolRelationShipService.executeUpdate(baseBeanList);
        return count;
    }


    @ApiOperation(value = "买家所属买家池查询", notes = "买家所属买家池查询", position = 5)
    @RequestMapping(value = "/buyers/buyerpool/_search", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = BuyerPoolRelationShipSearchValidator.class)
    public List<BuyerPoolRelationShipRsParam> modifyBuyerPool(@RequestBody BuyerPoolRelationShipRsParam param) {
        logger.info("买家所属买家池查询");
        if (!StringUtils.isEmpty(param.getBuyerPoolName())) {
            //param.setBuyerPoolName("%" + param.getBuyerPoolName() + "%");
            param.setBuyerPoolName(DbUtils.buildLikeCondition(param.getBuyerPoolName(), DbUtils.LikeMode.PARTIAL));
        }
        if (StringUtils.isEmpty(param.getBuyerId()) && StringUtils.isNotEmpty(param.getBuyerCode())) {
            String buyerId = this.findBuyerId(param.getBuyerCode());
            param.setBuyerId(buyerId);
        }
        List<BuyerPoolRelationShipRsParam> rest;
        rest = byimBuyerPoolRelationShipService.findList(param);
        return rest;
    }

    @ApiOperation(value = "买家池买家查询", notes = "买家池买家查询", position = 5)
    @RequestMapping(value = "/buyerpool/buyers/_search", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = BuyerPoolBuyersSearchValidator.class)
    public BaseRestPaginationResult<BuyerPoolBuyersRsParam> searchBuyersByBuyerPool(@RequestBody BuyerPoolBuyersRsParam param) {
        param.setBuyerName(DbUtils.buildLikeCondition(param.getBuyerName(), DbUtils.LikeMode.PARTIAL));
        if (StringUtils.isEmpty(param.getBuyerId()) && StringUtils.isNotEmpty(param.getBuyerCode())) {
            String buyerId = this.findBuyerId(param.getBuyerCode());
            param.setBuyerId(buyerId);
        }
        return byimBuyerPoolRelationShipService.findPageList(param);
    }

    private String findBuyerId(String buyerCode) {
        //通过买家编码查询买家ID
        BuyerAccountRsParam accountRsParam = new BuyerAccountRsParam();
        accountRsParam.setBuyerCode(buyerCode);
        return byimBuyerService.findBuyerId(accountRsParam);
    }
}
