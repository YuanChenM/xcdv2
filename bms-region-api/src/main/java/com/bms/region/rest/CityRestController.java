package com.bms.region.rest;

import com.bms.region.bean.entity.RegnCity;
import com.bms.region.bean.param.BaseBean;
import com.bms.region.bean.param.CityRsParam;
import com.bms.region.constant.MessageDef;
import com.bms.region.services.RegnCityService;
import com.bms.region.validator.CityAddValidator;
import com.bms.region.validator.CityUpdateValidator;
import com.framework.base.consts.NumberConst;
import com.framework.boot.base.BaseRestController;
import com.framework.core.db.DbUtils;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.StringUtils;
import com.framework.exception.BusinessException;
import com.framework.i18n.util.MessageManager;
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
 * Created by zhao_chen on 2016/12/1.
 */
@RestController
@Api(value = "bms-region-api",
    description = "城市信息操作",
    position = 1,
    tags = "CityRestController")
public class CityRestController extends BaseRestController {

    @Autowired
    private RegnCityService regnCityService;

    @ApiOperation(value = "根据省/城市信息查询返回到省",
        notes = "根据省/城市相关属性查询数据")
    @RequestMapping(value = "/region/city/_search",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<CityRsParam> searchRegionCity(@RequestBody CityRsParam param) {
        if (StringUtils.isNotEmpty(param.getProvinceName())) {
            param.setProvinceName(DbUtils.buildLikeCondition(param.getProvinceName(), DbUtils.LikeMode.PARTIAL));
        }
        if (StringUtils.isNotEmpty(param.getCityName())) {
            param.setCityName(DbUtils.buildLikeCondition(param.getCityName(), DbUtils.LikeMode.PARTIAL));
        }
        List<CityRsParam> cityList = regnCityService.findList(param);
        return cityList;
    }

    @ApiOperation(value = "城市信息批量新增",
        notes = "城市信息批量新增")
    @RequestMapping(value = "/region/city/_add",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    @Validator(validatorClass = CityAddValidator.class)
    public List<CityRsParam> addRegnCity(@RequestBody List<CityRsParam> param) {
        this.checkCityAddToDb(param);
        List<RegnCity> list = this.insertCheck(param);
        regnCityService.saveCity(list);
        return param;
    }

    @ApiOperation(value = "城市信息编辑操作",
        notes = "城市信息编辑操作")
    @RequestMapping(value = "/region/city/_update",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    @Validator(validatorClass = CityUpdateValidator.class)
    public void updateRegnCity(@RequestBody List<BaseBean<CityRsParam, CityRsParam>> param) {
        String[] messageArr = checkCityParamsUpdate(param);
        if (messageArr != null) {
            throw new BusinessException("region", "REGN.E00013");
        }
        this.checkCityUpdateToDb(param);
        regnCityService.updateCity(param);
    }

    /**
     * 城市信息编辑参数验证和DB是否有重复
     *
     * @param param
     * @return
     */
    private void checkCityUpdateToDb(List<BaseBean<CityRsParam, CityRsParam>> param) {
        int listSize = param.size();
        List<CityRsParam> regnCitys;
        /*RegnCity regnCity;*/
        for (int i = NumberConst.IntDef.INT_ZERO; i < listSize; i++) {
            CityRsParam filter = param.get(i).getFilter();
            CityRsParam target = param.get(i).getTarget();
            if (target.getCityCode() != null && target.isDelFlg() == false) {
                if(target.getDisableFlg() == null || target.getDisableFlg().equals("1")){
                    regnCitys = regnCityService.checkCity(target);
                    if (CollectionUtils.isNotEmpty(regnCitys) && regnCitys.size()>0) {
                       /* String[] args = new String[] { String.valueOf(i + 1),
                                MessageManager.getMessage(MessageDef.Label.L00003) };
                        throw new BusinessException("region", MessageDef.Error.E00002, args);*/
                        throw new BusinessException("region","REGN.E00013");
                    }
                }
            }
        }
    }

    /**
     * 城市新增参数与DB验证
     *
     * @param cityParamList
     */
    private void checkCityAddToDb(List<CityRsParam> cityParamList) {
        RegnCity regnCity;
        List<CityRsParam> regnCitys =null;
        if (CollectionUtils.isNotEmpty(cityParamList)) {
            for (int i = NumberConst.IntDef.INT_ZERO; i < cityParamList.size(); i++) {
                regnCitys = regnCityService.checkCity(cityParamList.get(i));
                if (CollectionUtils.isNotEmpty(regnCitys) && regnCitys.size()>= NumberConst.IntDef.INT_ZERO) {
                    throw new BusinessException("region","REGN.E00013");
                }
            }
        }
    }

    /**
     * 编辑数据，验证传入参数本身是否有相同数据
     * 
     * @param params
     * @return
     */
    public String[] checkCityParamsUpdate(List<BaseBean<CityRsParam, CityRsParam>> params) {
        Set<String> updateParamSet = new HashSet<>();
        List<String> messageList = new ArrayList<>();
        Set set;
        for (int i = 0; i < params.size(); i++) {
            set = new HashSet();
            CityRsParam target = params.get(i).getTarget();
            if (StringUtils.isNotEmpty(target.getCityCode())) {
                String idCode = target.getProvinceId() + target.getCityCode();
                if (set.contains(idCode)) {
                    String[] args = new String[] { MessageManager.getMessage(target.getCityCode(),
                        StringUtils.toString(i + NumberConst.IntDef.INT_ONE)) };
                    String message = MessageManager.getMessage(MessageDef.Error.E00001, args);
                    messageList.add(message);
                } else {
                    set.add(idCode);
                }
            }
        }
        String[] messageArr = null;
        if (messageList.size() > 0) {
            messageArr = new String[messageList.size()];
            messageArr = messageList.toArray(messageArr);
        }
        return messageArr;
    }

    /**
     * 新增参数获取
     *
     * @param paramList
     * @return
     */
    public List<RegnCity> insertCheck(List<CityRsParam> paramList) {
        List<RegnCity> codeList = new ArrayList<>();
        int listSize = paramList.size();
        RegnCity regnCity;
        Date currentDate = DateUtils.getCurrent();
        for (int i = 0; i < listSize; i++) {
            RegnCity city = BeanUtils.toBean(paramList.get(i), RegnCity.class);
            city.setCrtTime(currentDate);
             city.setCrtId(regnCityService.getLoginUserId());
             city.setUpdId(regnCityService.getLoginUserId());
            city.setUpdTime(currentDate);
            city.setDivisionLevel(NumberConst.IntDef.INT_ZERO);
            Long maxId = regnCityService.maxId("REGN_CITY");
            city.setCityId(maxId);
            paramList.get(i).setCityId(maxId);
            codeList.add(city);
        }
        return codeList;
    }
}
