package com.bms.byim.rest;

import com.bms.byim.bean.param.BaseBean;
import com.bms.byim.bean.param.StandardFrequenterLevelRsParam;
import com.bms.byim.constant.MessageDef;
import com.bms.byim.services.ByimStandardFrequenterLevelService;
import com.bms.byim.validator.StandardFrequenterLevelAddValidator;
import com.bms.byim.validator.StandardFrequenterLevelUpdateValidator;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseRestController;
import com.framework.core.utils.CollectionUtils;
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

@RestController
@Api(value = "bms-byim-api", description = "常客买家定级标准", position = 1, tags = "StandardFrequenterLevelController")
public class StandardFrequenterLevelController extends BaseRestController {

    Logger logger = LoggerFactory.getLogger(StandardFrequenterLevelController.class);
    @Autowired
    private ByimStandardFrequenterLevelService byimStandardFrequenterLevelService;

    @ApiOperation(value = "常客买家定级标准查询", notes = "常客买家定级标准查询")
    @RequestMapping(value = "/buyers/frequenterLevel/standard/_search", method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public BaseRestPaginationResult<StandardFrequenterLevelRsParam> search(@RequestBody StandardFrequenterLevelRsParam param) {
       /* buyerAllRsParam.setBossName(DbUtils.buildLikeCondition(buyerAllRsParam.getBossName(), DbUtils.LikeMode.PARTIAL));*/
        BaseRestPaginationResult<StandardFrequenterLevelRsParam> basicRsResult = byimStandardFrequenterLevelService.findPageList(param);
        return basicRsResult;
    }

    @ApiOperation(value = "常客买家定级标准新增", notes = "常客买家定级标准新增")
    @RequestMapping(value = "/buyers/frequenterLevel/standard/_add", method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = StandardFrequenterLevelAddValidator.class)
    public Integer add(@RequestBody List<StandardFrequenterLevelRsParam> param) {
        addCheck(param);
        return byimStandardFrequenterLevelService.insertFrequenterLevel(param);
    }

    @ApiOperation(value = "常客买家定级标准更新", notes = "常客买家定级标准更新")
    @RequestMapping(value = "/buyers/frequenterLevel/standard/_update", method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = StandardFrequenterLevelUpdateValidator.class)
    public Integer update(@RequestBody List<BaseBean<StandardFrequenterLevelRsParam, StandardFrequenterLevelRsParam>> param) {
        updateCheck(param);
        return byimStandardFrequenterLevelService.updateFrequenterLevel(param);

    }

    /**
     * 编辑参数验证
     *
     * @param params
     */
    public void updateCheck(List<BaseBean<StandardFrequenterLevelRsParam, StandardFrequenterLevelRsParam>> params) {
        int size = params.size();
        String standard;
        Set<String> set = new HashSet<String>();
        BaseRestPaginationResult<StandardFrequenterLevelRsParam> result;
        logger.info("参数集合自身是否有重复数据验证");
        if (CollectionUtils.isNotEmpty(params)) {
            //验证传来的参数list 是否有重复数据
            for (int i = 0; i < size; i++) {
                standard = params.get(i).getTarget().getLevelStandard();
                if (set.contains(standard)) {
                    //message需要再处理
                    throw new BusinessException(null, MessageDef.Error.E00002);
                } else {
                    set.add(standard);
                }
            }
            logger.info("参数是否和数据库相同数据");
            //验证参数与DB是否有重复数据
            for (int j = 0; j < size; j++) {
                StandardFrequenterLevelRsParam filter = params.get(j).getTarget();
                StandardFrequenterLevelRsParam target = params.get(j).getTarget();
                if (!target.getDelFlg()) {
                    StandardFrequenterLevelRsParam standardEntity = byimStandardFrequenterLevelService.findOne(target);
                    if(standardEntity!=null){
                        if (!standardEntity.getLevelStandardId().equals(filter.getLevelStandardId())) {
                            throw new BusinessException(null, MessageDef.Error.E00002);
                        }
                    }
                }

            }
        }
    }

    /**
     * 新增参数验证
     *
     * @param params
     */
    public void addCheck(List<StandardFrequenterLevelRsParam> params) {
        int size = params.size();
        String standard;
        Set<String> set = new HashSet<String>();
        BaseRestPaginationResult<StandardFrequenterLevelRsParam> result;
        if (CollectionUtils.isNotEmpty(params)) {
            logger.info("参数集合自身是否有重复数据验证");
            for (int i = 0; i < size; i++) {
                standard = params.get(i).getLevelStandard();
                if (set.contains(standard)) {
                    //message需要再处理
                    throw new BusinessException(null, MessageDef.Error.E00002);
                } else {
                    set.add(standard);
                }
            }
            logger.info("参数是否和数据库相同数据");
            for (int j = 0; j < size; j++) {
                result = byimStandardFrequenterLevelService.findPageList(params.get(j));
                if (result.getTotal() > 0) {
                    //message需要再处理
                    throw new BusinessException(null, MessageDef.Error.E00002);
                }
            }
        }

    }

}
