package com.bms.region.rest;

import com.bms.region.bean.entity.RegnProvince;
import com.bms.region.bean.param.BaseBean;
import com.bms.region.bean.param.ProvinceRsParam;
import com.bms.region.constant.MessageDef;
import com.bms.region.services.RegnProvinceService;
import com.bms.region.utils.RestCommUtil;
import com.bms.region.validator.ProvinceAddValidator;
import com.bms.region.validator.ProvinceUpdateValidator;
import com.framework.base.consts.NumberConst;
import com.framework.boot.base.BaseRestController;
import com.framework.core.db.DbUtils;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.StringUtils;
import com.framework.exception.BusinessException;
import com.framework.i18n.util.MessageManager;
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
 * Created by tao_zhifa on 2016/12/2.
 */

@RestController
@Api(value = "bms-region-api",
        description = "省操作",
        position = 1,
        tags = "ProvinceRestController")
public class ProvinceRestController extends BaseRestController {

    @Autowired
    RegnProvinceService regnProvinceService;

    @ApiOperation(value = "省信息单独查询",
            notes = "省信息单独查询",
            position = 5)
    @RequestMapping(value = "/region/province/_search",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<ProvinceRsParam> searchRegionProvince(@RequestBody ProvinceRsParam provinceParam) {
        // 查询省信息列表
        if (StringUtils.isNotEmpty(provinceParam.getProvinceName())) {
            provinceParam.setProvinceName(DbUtils.buildLikeCondition(provinceParam.getProvinceName(), DbUtils.LikeMode.PARTIAL));
        }
        List<ProvinceRsParam> list = regnProvinceService.findList(provinceParam);
        return list;
    }

    @ApiOperation(value = "省信息新增",
            notes = "省信息新增",
            position = 5)
    @RequestMapping(value = "/region/province/_add",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = ProvinceAddValidator.class)
    public List<ProvinceRsParam> addRegionProvince(@RequestBody List<ProvinceRsParam> provinceRsParams) {
        String[] messageArr = checkProvinceParamsAdd(provinceRsParams);
        // 校验数据的重复性
        if (messageArr != null) {
            throw new BusinessException("region", "REGN.E00013");
        }
        this.checkProvinceAddToDb(provinceRsParams);
        List<RegnProvince> codeList = insertChecked(provinceRsParams);
        List<List<RegnProvince>> list = RestCommUtil.insertRanking(codeList);
        regnProvinceService.executeBatchSave(list);
        return provinceRsParams;
    }

    @ApiOperation(value = "省信息修改,作废处理",
            notes = "省信息修改,作废处理",
            position = 5)
    @RequestMapping(value = "/region/province/_update",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = ProvinceUpdateValidator.class)
    public void updateRegionProvince(@RequestBody List<BaseBean<ProvinceRsParam, ProvinceRsParam>> provinceParam) {
        this.checkProvinceParamsUpdate(provinceParam);
        regnProvinceService.executeModify(provinceParam);
    }

    /**
     * 新增参数获取
     *
     * @param paramList
     * @return
     */
    public List<RegnProvince> insertChecked(List<ProvinceRsParam> paramList) {
        int listSize = paramList.size();
        List<RegnProvince> codeList = new ArrayList<>();
        RegnProvince param;
        for (int i = 0; i < listSize; i++) {
            param = BeanUtils.toBean(paramList.get(i), RegnProvince.class);
            param.setProvinceCode(paramList.get(i).getProvinceCode());
            param.setProvinceName(paramList.get(i).getProvinceName());
            Date currentDate = DateUtils.getCurrent();
            param.setCrtTime(currentDate);
            param.setCrtId(regnProvinceService.getLoginUserId());
            param.setUpdId(regnProvinceService.getLoginUserId());
            param.setUpdTime(currentDate);
            Long maxId = regnProvinceService.maxId("REGN_PROVINCE");
            param.setProvinceId(maxId);
            paramList.get(i).setProvinceId(maxId);
            param.setDivisionLevel(NumberConst.IntDef.INT_ZERO);
            codeList.add(param);
        }
        return codeList;
    }

    /**
     * 新增数据验证传入数据本身是否有重复数据
     *
     * @param provinceRsParams
     * @return
     */
    private String[] checkProvinceParamsAdd(List<ProvinceRsParam> provinceRsParams) {
        String[] returnMessage = null;
        List<String> messageList = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(provinceRsParams)) {
            ProvinceRsParam param;
            int listSize = provinceRsParams.size();
            Set set = new HashSet();
            for (int i = NumberConst.IntDef.INT_ZERO; i < listSize; i++) {
                param = provinceRsParams.get(i);
                String mapKey = provinceRsParams.get(i).getProvinceCode() + provinceRsParams.get(i).getProvinceName();
                if (set.contains(mapKey)) {
                    String[] args = new String[]{MessageManager.getMessage(param.getProvinceCode(),
                            StringUtils.toString(i + NumberConst.IntDef.INT_ONE))};
                    String message = MessageManager.getMessage(MessageDef.Error.E00001, args);
                    returnMessage[NumberConst.IntDef.INT_ZERO] = message;
                    messageList.add(message);
                } else {
                    set.add(mapKey);
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
     * 新增参数与DB验证
     *
     * @param provinceRsParams
     */
    private void checkProvinceAddToDb(List<ProvinceRsParam> provinceRsParams) {
        ProvinceRsParam param;
        if (CollectionUtils.isNotEmpty(provinceRsParams)) {
            for (int i = NumberConst.IntDef.INT_ZERO; i < provinceRsParams.size(); i++) {
                /*param = regnProvinceService.findOne(provinceRsParams.get(i));*/
                List<ProvinceRsParam> checkDatas = regnProvinceService.checkData(provinceRsParams.get(i));
                if (checkDatas.size() > NumberConst.IntDef.INT_ZERO) {
                    String[] args = new String[]{String.valueOf(i + 1),
                            MessageManager.getMessage(MessageDef.Label.L00002)};
                    throw new BusinessException("region", "REGN.E00013");
                }
            }
        }
    }

    /**
     * 省数据校验
     *
     * @param provinceParam
     */
    public void checkProvinceParamsUpdate(List<BaseBean<ProvinceRsParam, ProvinceRsParam>> provinceParam) {
        Map<String, Object> mapCode = new HashMap<>();
        Map<String, Object> mapName = new HashMap<>();
        if (CollectionUtils.isNotEmpty(provinceParam)) {
            for (int i = 0; i < provinceParam.size(); i++) {
                ProvinceRsParam filter = provinceParam.get(i).getFilter();
                ProvinceRsParam target = provinceParam.get(i).getTarget();
                /*ProvinceRsParam dbRsParam = regnProvinceService.findOne(target);*/
                List<ProvinceRsParam> checkDatas = regnProvinceService.checkData(target);
                if (checkDatas.size()>NumberConst.IntDef.INT_ZERO && target.isDelFlg() == false) {
                    if (target.getDisableFlg() == null || target.getDisableFlg().equals("1")) {
                        // 存在相同的编码或者名称
                        throw new BusinessException("region", "REGN.E00013");
                    }
                }
                if (mapCode.isEmpty()) {
                    mapCode.put(target.getProvinceCode(), target);
                    mapName.put(target.getProvinceName(), target);
                } else if (mapCode.get(target.getProvinceCode()) != null
                        || mapName.get(target.getProvinceName()) != null) {
                    // 存在相同的编码或者名称
                    throw new BusinessException("region", "REGN.E00013");
                }
            }
        } else {
            throw new BusinessException("region", "REGN.E00013");
        }
    }

}
