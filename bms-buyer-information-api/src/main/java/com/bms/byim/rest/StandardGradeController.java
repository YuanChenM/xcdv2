package com.bms.byim.rest;

import com.bms.byim.bean.param.BaseBean;
import com.bms.byim.bean.param.StandardGradeRsParam;
import com.bms.byim.constant.MessageDef;
import com.bms.byim.services.ByimStandardGradeService;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseRestController;
import com.framework.core.utils.CollectionUtils;
import com.framework.exception.BusinessException;
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
@Api(value = "bms-byim-api", description = "买家定性评级标准", position = 1, tags = "StandardGradeController")
public class StandardGradeController extends BaseRestController {

    Logger logger = LoggerFactory.getLogger(StandardGradeController.class);
    @Autowired
    private ByimStandardGradeService byimStandardGradeService;


    @ApiOperation(value = "买家定性评级标准查询", notes = "买家定性评级标准查询")
    @RequestMapping(value = "/buyers/grade/standard/_search", method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public BaseRestPaginationResult<StandardGradeRsParam> search(@RequestBody StandardGradeRsParam param) {
       /* buyerAllRsParam.setBossName(DbUtils.buildLikeCondition(buyerAllRsParam.getBossName(), DbUtils.LikeMode.PARTIAL));*/
        BaseRestPaginationResult<StandardGradeRsParam> basicRsResult = byimStandardGradeService.findPageList(param);
        return basicRsResult;
    }

    @ApiOperation(value = "买家定性评级标准新增", notes = "买家定性评级标准新增")
    @RequestMapping(value = "/buyers/grade/standard/_add", method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    //@Validator(validatorClass = StandardFrequenterLevelAddValidator.class)
    public Integer add(@RequestBody List<StandardGradeRsParam> param) {
        addCheck(param);
        return byimStandardGradeService.insertStandardGrade(param);
    }

    @ApiOperation(value = "买家定性评级标准更新", notes = "买家定性评级标准更新")
    @RequestMapping(value = "/buyers/grade/standard/_update", method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
     //@Validator(validatorClass = StandardFrequenterLevelUpdateValidator.class)
    public Integer update(@RequestBody List<BaseBean<StandardGradeRsParam, StandardGradeRsParam>> param) {
        updateCheck(param);
        return byimStandardGradeService.updateStandardGrade(param);

    }

    /**
     * 编辑参数验证
     *
     * @param params
     */
    public void updateCheck(List<BaseBean<StandardGradeRsParam, StandardGradeRsParam>> params) {
        int size = params.size();
        String standard;
        Set<String> set = new HashSet<String>();
        BaseRestPaginationResult<StandardGradeRsParam> result;
        logger.info("参数集合自身是否有重复数据验证");
        if (CollectionUtils.isNotEmpty(params)) {
            //验证传来的参数list 是否有重复数据
            for (int i = 0; i < size; i++) {
                standard = params.get(i).getTarget().getGradeStandard();
                if (set.contains(standard)) {
                    //message需要再处理
                    throw new BusinessException(null, MessageDef.Error.E00002);
                } else {
                    set.add(standard);
                }
            }
            logger.info("参数是否和数据库相同数据");
            //验证参数与DB是否有重复数据

            String gradeStandard = "";
            for (int j = 0; j < size; j++) {
                if (params.get(j).getTarget().getDelFlg() == false) {
                    StandardGradeRsParam filter = params.get(j).getTarget();
                    StandardGradeRsParam target = params.get(j).getTarget();
                    if (!target.getDelFlg()) {
                        StandardGradeRsParam standardEntity = byimStandardGradeService.findOne(target);
                        if (standardEntity != null) {
                            if (!standardEntity.getGradeStandardId().equals(filter.getGradeStandardId())) {
                                throw new BusinessException(null, MessageDef.Error.E00002);
                            }
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
    public void addCheck(List<StandardGradeRsParam> params) {
        int size = params.size();
        String standard;
        Set<String> set = new HashSet<String>();
        BaseRestPaginationResult<StandardGradeRsParam> result;
        if (CollectionUtils.isNotEmpty(params)) {
            logger.info("参数集合自身是否有重复数据验证");
            for (int i = 0; i < size; i++) {
                standard = params.get(i).getGradeStandard();
                if (set.contains(standard)) {
                    //message需要再处理
                    throw new BusinessException(null, MessageDef.Error.E00002);
                } else {
                    set.add(standard);
                }
            }
            logger.info("参数是否和数据库相同数据");
            for (int j = 0; j < size; j++) {
                result = byimStandardGradeService.findPageList(params.get(j));
                if (result != null) {
                    if (result.getTotal() > 0) {
                        //message需要再处理
                        throw new BusinessException(null, MessageDef.Error.E00002);
                    }
                }


            }
        }

    }


}
