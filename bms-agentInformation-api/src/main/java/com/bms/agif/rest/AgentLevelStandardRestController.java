package com.bms.agif.rest;

import com.bms.agif.bean.param.AgentLevelStandardPageParam;
import com.bms.agif.bean.param.BaseBean;
import com.bms.agif.bean.param.ButlerExpEducationRsParam;
import com.bms.agif.bean.param.AgentLevelStandardPageParam;
import com.bms.agif.bean.result.AgentLevelStandardResult;
import com.bms.agif.service.AgifAgentLevelStandardService;
import com.bms.agif.service.AgifButlerExpEducationService;
import com.bms.agif.validator.AgentLevelStandardAddValidator;
import com.bms.agif.validator.AgentLevelStandardModifyValidator;
import com.bms.agif.validator.ButlerExpEducationAddValidator;
import com.bms.agif.validator.ButlerExpEducationUpdateValidator;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseRestController;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.StringUtils;
import com.framework.exception.BusinessException;
import com.framework.validator.annotation.Validator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
 * Created by zhao_chen  on 2017/3/2.
 */
@RestController
@Api(value = "bms-agif-api", description = "买手定级标准管理及买手定级", position = 1, tags = "AgentLevelStandardRestController")
public class AgentLevelStandardRestController extends BaseRestController {

    @Autowired
    private AgifAgentLevelStandardService levelStandardService;

    @ApiOperation(value = "买手定级标准管理及买手定级查询", notes = "买手定级标准管理及买手定级查询")
    @RequestMapping(value = "/agent/level/standard/_search", method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public BaseRestPaginationResult<AgentLevelStandardPageParam> search(@RequestBody AgentLevelStandardPageParam param) {
        BaseRestPaginationResult<AgentLevelStandardPageParam> result = levelStandardService.findPageList(param);
        return result;
    }

    @ApiOperation(value = "买手定级标准管理及买手定级新增", notes = "买手定级标准管理及买手定级新增")
    @RequestMapping(value = "/agent/level/standard/_add", method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = AgentLevelStandardAddValidator.class)
    public AgentLevelStandardResult add(@RequestBody List<AgentLevelStandardPageParam> param) {
        checkParamsAdd(param);
        addValidatorDataToDB(param);
        AgentLevelStandardResult result = levelStandardService.saveAgentLevelStandard(param);
        return result;
    }

    @ApiOperation(value = "买手定级标准管理及买手定级更新", notes = "买手定级标准管理及买手定级更新")
    @RequestMapping(value = "/agent/level/standard/_update", method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = AgentLevelStandardModifyValidator.class)
    public AgentLevelStandardResult update(@RequestBody List<BaseBean<AgentLevelStandardPageParam, AgentLevelStandardPageParam>> param) {
        modifyValidatorDataToDB(param);
        checkParamsUpdate(param);
        AgentLevelStandardResult resultCount = levelStandardService.modifyAgentLevelStandard(param);
        return resultCount;
    }

    /**
     * 新增参数与db验证是否重复
     *
     * @param param
     */
    public void addValidatorDataToDB(List<AgentLevelStandardPageParam> param) {
        AgentLevelStandardPageParam validataParam;
        Long total = 0L;
        if (CollectionUtils.isNotEmpty(param)) {
            for (AgentLevelStandardPageParam bean : param) {
                validataParam = new AgentLevelStandardPageParam();
                validataParam.setLgcsAreaId(bean.getLgcsAreaId());
                validataParam.setLevelName(bean.getLevelName());
                BaseRestPaginationResult<AgentLevelStandardPageParam> result = levelStandardService.findPageList(validataParam);
                total = result.getTotal();
                if (total > 0) {
                    throw new BusinessException("agif", "AGIF.E06002");
                }
            }
        }
    }

    /**
     * 编辑参数与db验证是否重复
     *
     * @param param
     */
    public void modifyValidatorDataToDB(List<BaseBean<AgentLevelStandardPageParam, AgentLevelStandardPageParam>> param) {
        if (CollectionUtils.isNotEmpty(param)) {
            AgentLevelStandardPageParam filter;
            for (BaseBean<AgentLevelStandardPageParam, AgentLevelStandardPageParam> bean : param) {
                filter = new AgentLevelStandardPageParam();
                filter.setLevelName(bean.getTarget().getLevelName());
                filter.setLgcsAreaId(bean.getTarget().getLgcsAreaId());
                BaseRestPaginationResult<AgentLevelStandardPageParam> result = levelStandardService.findPageList(filter);
                if (null != result && CollectionUtils.isNotEmpty(result.getData())) {
                    AgentLevelStandardPageParam resultEntity = result.getData().get(0);
                    Long id = resultEntity.getLevelId();
                    if (!id.equals(bean.getFilter().getLevelId())) {
                        throw new BusinessException("agif", "AGIF.E06002");
                    }
                }
            }
        }
    }

    /**
     * 新增参数集合验证是否有重复
     *
     * @param param
     */
    public void checkParamsAdd(List<AgentLevelStandardPageParam> param) {
        Set set;
        for (int i = 0; i < param.size(); i++) {
            set = new HashSet();
            String code = param.get(i).getLgcsAreaId() + param.get(i).getLevelName();
            if (set.contains(code)) {
                throw new BusinessException("agif", "AGIF.E06003");
            } else {
                set.add(code);
            }
        }
    }


    /**
     * 编辑参数集合验证是否重复
     *
     * @param param
     */
    public void checkParamsUpdate(List<BaseBean<AgentLevelStandardPageParam, AgentLevelStandardPageParam>> param) {
        Set set;
        for (int i = 0; i < param.size(); i++) {
            set = new HashSet();
            AgentLevelStandardPageParam target = param.get(i).getTarget();
            if (StringUtils.isNotEmpty(target.getLevelName())) {
                String code = target.getLgcsAreaId() + target.getLevelName();
                if (set.contains(code)) {
                    throw new BusinessException("agif", "AGIF.E06003");
                } else {
                    set.add(code);
                }
            }
        }

    }

}
