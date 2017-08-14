package com.bms.region.rest;

import com.bms.region.bean.entity.RegnDistrict;
import com.bms.region.bean.param.BaseBean;
import com.bms.region.bean.param.DistrictRsParam;
import com.bms.region.bean.result.DistrictRestResult;
import com.bms.region.services.RegnDistrictService;
import com.bms.region.validator.DistrictAddValidator;
import com.bms.region.validator.DistrictSearchValidator;
import com.bms.region.validator.DistrictUpdateValidator;
import com.framework.base.consts.NumberConst;
import com.framework.boot.base.BaseRestController;
import com.framework.core.db.DbUtils;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.StringUtils;
import com.framework.exception.BusinessException;
import com.framework.validator.annotation.Validator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * Created by zhao_chen on 2016/12/5.
 */
@RestController
@Api(value = "bms-region-api",
        description = "区县信息操作",
        position = 1,
        tags = "RegnDistrictController")
public class DistrictRestController extends BaseRestController {
    @Autowired
    private RegnDistrictService regnDistrictService;

    /**
     * 区域信息查询
     *
     * @param param
     * @return
     */
    @ApiOperation(value = "区域信息查询",
            notes = "区域信息查询")
    @RequestMapping(value = "/region/district/_search",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = DistrictSearchValidator.class)
    public List<DistrictRestResult> searchRegnDistrict(@RequestBody DistrictRsParam param) {

        if (StringUtils.isNotEmpty(param.getCityName())) {
            param.setCityName(DbUtils.buildLikeCondition(param.getCityName(), DbUtils.LikeMode.PARTIAL));
        }
        if (StringUtils.isNotEmpty(param.getDistrictName())) {
            param.setDistrictName(DbUtils.buildLikeCondition(param.getDistrictName(), DbUtils.LikeMode.PARTIAL));
        }
        List<DistrictRestResult> restResults = regnDistrictService.findList(param);
        return restResults;
    }

    /**
     * 区县信息新增操作
     *
     * @param param
     * @return
     */
    @ApiOperation(value = "区县信息新增操作",
            notes = "区县信息新增操作")
    @RequestMapping(value = "/region/district/_add",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = DistrictAddValidator.class)
    public List<DistrictRsParam> addRegnDistrict(@RequestBody List<DistrictRsParam> param) {
        this.checkiDistrictParamList(param);
        List<RegnDistrict> list = this.insertCheck(param);
        regnDistrictService.saveDistrict(list);
        return param;
    }

    /**
     * 区县信息编辑和删除操作
     *
     * @param param
     * @return
     */
    @ApiOperation(value = "区县信息编辑和删除操作",
            notes = "区县信息编辑和删除操作")
    @RequestMapping(value = "/region/district/_update",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = DistrictUpdateValidator.class)
    public void updaterRegnDistrict(@RequestBody List<BaseBean<DistrictRsParam, DistrictRsParam>> param) {
        this.checkDistrictUpdate(param);
        regnDistrictService.updateDistrict(param);
    }

    /**
     * 区县修改参数验证
     *
     * @param param
     * @return
     */
    private void checkDistrictUpdate(List<BaseBean<DistrictRsParam, DistrictRsParam>> param) {
        int listSize = param.size();
        Map<String, Object> map = new HashMap<>();
        RegnDistrict district;
        for (int i = NumberConst.IntDef.INT_ZERO; i < listSize; i++) {
            DistrictRsParam filter = param.get(i).getFilter();
            DistrictRsParam target = param.get(i).getTarget();
            String mapKey = filter.getDistrictId() + target.getDistrictCode() + target.getDistrictName();
            if (target.getDistrictCode() != null) {
                district = regnDistrictService.findOne(target);

                if (district != null && target.isDelFlg() == false) {
                    if (target.getDisableFlg() == null || target.getDisableFlg().equals("1")) {
                        if (!district.getDistrictId().equals(target.getDistrictId())) {
                            /*String[] args = new String[] { String.valueOf(i + 1),
                                    MessageManager.getMessage(MessageDef.Label.L00003) };
                            throw new BusinessException("region", MessageDef.Error.E00002, args);*/
                            throw new BusinessException("region", "REGN.E00013");
                        }
                    }
                } else {
                    if (map.isEmpty()) {
                        map.put(mapKey, filter);
                    } else if (map.get(mapKey) != null) {
                        /*throw new BusinessException("region", MessageDef.Error.E00002);*/
                        throw new BusinessException("region", "REGN.E00013");
                    }
                }
            }
        }
    }

    /**
     * 新增参数验证
     *
     * @param cityParamList
     * @return
     */
    private void checkiDistrictParamList(List<DistrictRsParam> cityParamList) {
        RegnDistrict regnDistrict;
        if (CollectionUtils.isNotEmpty(cityParamList)) {
            for (int i = NumberConst.IntDef.INT_ZERO; i < cityParamList.size(); i++) {
                regnDistrict = regnDistrictService.findOne(cityParamList.get(i));
                if (regnDistrict != null) {
             /*       String[] args = new String[] { String.valueOf(i + 1),
                        MessageManager.getMessage(MessageDef.Label.L00004) };
                    throw new BusinessException("region", MessageDef.Error.E00002, args);*/
                    throw new BusinessException("region", "REGN.E00013");
                }
            }
        }
    }

    /**
     * 新增参数获取
     *
     * @param paramList
     * @return
     */
    public List<RegnDistrict> insertCheck(List<DistrictRsParam> paramList) {
        List<RegnDistrict> codeList = new ArrayList<>();
        int listSize = paramList.size();
        Date currentDate = DateUtils.getCurrent();
        for (int i = 0; i < listSize; i++) {
            RegnDistrict regnDistrict = BeanUtils.toBean(paramList.get(i), RegnDistrict.class);
            regnDistrict.setCrtTime(currentDate);
            regnDistrict.setCrtId(regnDistrictService.getLoginUserId());
            regnDistrict.setUpdId(regnDistrictService.getLoginUserId());
            regnDistrict.setUpdTime(currentDate);
            regnDistrict.setDivisionLevel(NumberConst.IntDef.INT_ZERO);
            Long maxId = regnDistrictService.maxId("REGN_DISTRICT");
            regnDistrict.setDistrictId(maxId);
            paramList.get(i).setDistrictId(maxId);
            codeList.add(regnDistrict);
        }
        return codeList;
    }
}
