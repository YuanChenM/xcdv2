package com.bms.agif.rest;

import com.bms.agif.bean.param.BaseBean;
import com.bms.agif.bean.param.ButlerLevelStandardPageParam;
import com.bms.agif.bean.result.ButlerLevelStandardResult;
import com.bms.agif.service.AgifButlerLevelStandardService;
import com.bms.agif.validator.ButlerLevelStandardAddValidator;
import com.bms.agif.validator.ButlerLevelStandardModifyValidator;
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
@Api(value = "bms-agif-api", description = "冻品管家定级标准管理及冻品管家定级", position = 1, tags = "ButlerLevelStandardRestController")
public class ButlerLevelStandardRestController extends BaseRestController {

    @Autowired
    private AgifButlerLevelStandardService butlerLevelStandardService;

    @ApiOperation(value = "冻品管家定级标准管理及冻品管家定级查询", notes = "冻品管家定级标准管理及冻品管家定级查询")
    @RequestMapping(value = "/butler/level/standard/_search", method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public BaseRestPaginationResult<ButlerLevelStandardPageParam> search(@RequestBody ButlerLevelStandardPageParam param) {
        BaseRestPaginationResult<ButlerLevelStandardPageParam> result = butlerLevelStandardService.findPageList(param);
        return result;
    }

    @ApiOperation(value = "冻品管家定级标准管理及冻品管家定级新增", notes = "冻品管家定级标准管理及冻品管家定级新增")
    @RequestMapping(value = "/butler/level/standard/_add", method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = ButlerLevelStandardAddValidator.class)
    public ButlerLevelStandardResult add(@RequestBody List<ButlerLevelStandardPageParam> param) {
        checkParamsAdd(param);
        addValidatorDataToDB(param);
        ButlerLevelStandardResult result = butlerLevelStandardService.saveButlerLevelStandard(param);
        return result;
    }

    @ApiOperation(value = "冻品管家定级标准管理及冻品管家定级更新", notes = "冻品管家定级标准管理及冻品管家定级更新")
    @RequestMapping(value = "/butler/level/standard/_update", method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = ButlerLevelStandardModifyValidator.class)
    public ButlerLevelStandardResult update(@RequestBody List<BaseBean<ButlerLevelStandardPageParam, ButlerLevelStandardPageParam>> param) {
        checkParamsUpdate(param);
        modifyValidatorDataToDB(param);
        ButlerLevelStandardResult result = butlerLevelStandardService.modifyButlerLevelStandard(param);
        return result;
    }


    /**
     * 新增参数与db验证是否重复
     *
     * @param param
     */
    public void addValidatorDataToDB(List<ButlerLevelStandardPageParam> param) {
        ButlerLevelStandardPageParam validataParam;
        Long total = 0L;
        if (CollectionUtils.isNotEmpty(param)) {
            for (ButlerLevelStandardPageParam bean : param) {
                validataParam = new ButlerLevelStandardPageParam();
                validataParam.setLgcsAreaId(bean.getLgcsAreaId());
                validataParam.setLevelName(bean.getLevelName());
                BaseRestPaginationResult<ButlerLevelStandardPageParam> result = butlerLevelStandardService.findPageList(validataParam);
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
    public void modifyValidatorDataToDB(List<BaseBean<ButlerLevelStandardPageParam, ButlerLevelStandardPageParam>> param) {
        if (CollectionUtils.isNotEmpty(param)) {
            ButlerLevelStandardPageParam filter;
            for (BaseBean<ButlerLevelStandardPageParam, ButlerLevelStandardPageParam> bean : param) {
                filter = new ButlerLevelStandardPageParam();
                filter.setLevelName(bean.getTarget().getLevelName());
                filter.setLgcsAreaId(bean.getTarget().getLgcsAreaId());
                BaseRestPaginationResult<ButlerLevelStandardPageParam> result = butlerLevelStandardService.findPageList(filter);
                if (null != result && CollectionUtils.isNotEmpty(result.getData())) {
                    ButlerLevelStandardPageParam resultEntity = result.getData().get(0);
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
    public void checkParamsAdd(List<ButlerLevelStandardPageParam> param) {
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
    public void checkParamsUpdate(List<BaseBean<ButlerLevelStandardPageParam, ButlerLevelStandardPageParam>> param) {
        Set set;
        for (int i = 0; i < param.size(); i++) {
            set = new HashSet();
            ButlerLevelStandardPageParam target = param.get(i).getTarget();
            if (StringUtils.isNotEmpty(target.getLevelName())) {
                String idCode = target.getLgcsAreaId() + target.getLevelName();
                if (set.contains(idCode)) {
                    throw new BusinessException("agif", "AGIF.E06003");
                } else {
                    set.add(idCode);
                }
            }
        }

    }


}
