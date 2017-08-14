package com.bms.region.rest;

import com.bms.region.bean.entity.RegnStreet;
import com.bms.region.bean.param.BaseBean;
import com.bms.region.bean.param.StreetRsPageParam;
import com.bms.region.bean.param.StreetRsParam;
import com.bms.region.bean.result.StreetRestResult;
import com.bms.region.services.RegnStreetService;
import com.bms.region.validator.StreetSaveValidator;
import com.bms.region.validator.StreetUpdOrDelValidator;
import com.framework.base.consts.NumberConst;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseRestController;
import com.framework.core.db.DbUtils;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.DateUtils;
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

import java.util.*;

/**
 * Created by yuan_zhifei on 2016/12/1.
 */
@RestController
@Api(value = "bms-region-api",
    description = "街道信息",
    position = 1,
    tags = "StreetRestController")
public class StreetRestController extends BaseRestController {
    @Autowired
    private RegnStreetService streetService;

    @ApiOperation(value = "街道信息单独查询",
        notes = "街道信息单独查询")
    @RequestMapping(value = "/region/street/_search",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    public BaseRestPaginationResult<StreetRestResult> searchRegionStreet(@RequestBody StreetRsPageParam param) {
        if (StringUtils.isNotEmpty(param.getProvinceName())) {
            param.setProvinceName(DbUtils.buildLikeCondition(param.getProvinceName(), DbUtils.LikeMode.PARTIAL));
        }
        if (StringUtils.isNotEmpty(param.getCityName())) {
            param.setCityName(DbUtils.buildLikeCondition(param.getCityName(), DbUtils.LikeMode.PARTIAL));
        }
        if (StringUtils.isNotEmpty(param.getDistrictName())) {
            param.setDistrictName(DbUtils.buildLikeCondition(param.getDistrictName(), DbUtils.LikeMode.PARTIAL));
        }
        if (StringUtils.isNotEmpty(param.getStreetName())) {
            param.setStreetName(DbUtils.buildLikeCondition(param.getStreetName(), DbUtils.LikeMode.PARTIAL));
        }
        return streetService.findPageList(param);
    }

    @ApiOperation(value = "街道信息新增",
        notes = "街道信息新增")
    @RequestMapping(value = "/region/street/_add",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    @Validator(validatorClass = StreetSaveValidator.class)
    public List<StreetRsParam> addRegionStreet(@RequestBody List<StreetRsParam> paramRequest) {
        this.checkStreetParamList(paramRequest);
        List<RegnStreet> list = this.insertCheck(paramRequest);
        streetService.saveStreetParamList(list);
        return paramRequest;
    }

    @ApiOperation(value = "街道信息修改/作废处理",
        notes = "街道信息修改/作废处理")
    @RequestMapping(value = "/region/street/_update",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    @Validator(validatorClass = StreetUpdOrDelValidator.class)
    public void updateRegionStreet(@RequestBody List<BaseBean<StreetRsParam, StreetRsParam>> paramRequest) {
        this.checkStreetUpdate(paramRequest);
        streetService.modifyStreetParamList(paramRequest);
    }

    /**
     * 新增参数验证
     * 
     * @param streetParamList
     * @return
     */
    private void checkStreetParamList(List<StreetRsParam> streetParamList) {
        RegnStreet regnStreet;
        if (CollectionUtils.isNotEmpty(streetParamList)) {
            for (int i = NumberConst.IntDef.INT_ZERO; i < streetParamList.size(); i++) {
                regnStreet = streetService.findOne(streetParamList.get(i));
                if (regnStreet != null) {
//                    String[] args = new String[] { String.valueOf(i + 1),
//                        MessageManager.getMessage(MessageDef.Label.L00004) };
//                    throw new BusinessException("region", MessageDef.Error.E00002, args);
                    throw new BusinessException("region","REGN.E00013");
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
    public List<RegnStreet> insertCheck(List<StreetRsParam> paramList) {
        List<RegnStreet> codeList = new ArrayList<>();
        int listSize = paramList.size();
        Date currentDate = DateUtils.getCurrent();
        for (int i = 0; i < listSize; i++) {
            RegnStreet regnStreet = BeanUtils.toBean(paramList.get(i), RegnStreet.class);
            regnStreet.setCrtTime(currentDate);
             regnStreet.setCrtId(streetService.getLoginUserId());
             regnStreet.setUpdId(streetService.getLoginUserId());
            regnStreet.setUpdTime(currentDate);
            regnStreet.setDivisionLevel(NumberConst.IntDef.INT_ZERO);
            Long maxId = streetService.maxId("REGN_STREET");
            regnStreet.setStreetId(maxId);
            paramList.get(i).setStreetId(maxId);
            codeList.add(regnStreet);
        }
        return codeList;
    }

    /**
     * 街道更新检查
     * 
     * @param param
     */
    private void checkStreetUpdate(List<BaseBean<StreetRsParam, StreetRsParam>> param) {
        int listSize = param.size();
        Map<String, Object> map = new HashMap<>();
        RegnStreet street;
        for (int i = NumberConst.IntDef.INT_ZERO; i < listSize; i++) {
            StreetRsParam filter = param.get(i).getFilter();
            StreetRsParam target = param.get(i).getTarget();
            String mapKey = filter.getStreetId() + target.getStreetCode() + target.getStreetName();
            if (target.getStreetCode() != null && target.isDelFlg() == false) {
                if(target.getDisableFlg() == null || target.getDisableFlg().equals("1")){
                    street = streetService.findOne(target);
                    if (street != null) {
                        if (!street.getStreetId().equals(filter.getStreetId())) {
//                            String[] args = new String[] { MessageManager.getMessage(street.getStreetCode(),
//                                    StringUtils.toString(i + NumberConst.IntDef.INT_ONE)) };
//                            throw new BusinessException("region", MessageDef.Error.E00002, args);
                            throw new BusinessException("region","REGN.E00013");
                        }
                    } else {
                        if (map.isEmpty()) {
                            map.put(mapKey, filter);
                        } else if (map.get(mapKey) != null) {
//                            throw new BusinessException("region", MessageDef.Error.E00002);
                            throw new BusinessException("region","REGN.E00013");
                        }
                    }
                }
            }
        }
    }
}
