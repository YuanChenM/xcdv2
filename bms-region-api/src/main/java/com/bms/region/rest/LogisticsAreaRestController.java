package com.bms.region.rest;

import com.bms.region.bean.entity.RegnLogisticsArea;
import com.bms.region.bean.param.BaseBean;
import com.bms.region.bean.param.LogisticsAreaPageParam;
import com.bms.region.bean.param.LogisticsAreaRsParam;
import com.bms.region.bean.result.LogisticsAreaRestResult;
import com.bms.region.constant.MessageDef;
import com.bms.region.services.RegnLogisticsAreaService;
import com.bms.region.utils.RestCommUtil;
import com.bms.region.validator.LogisticsAreaAddValidator;
import com.bms.region.validator.LogisticsAreaUpdateValidator;
import com.framework.base.consts.NumberConst;
import com.framework.base.rest.result.BaseRestPaginationResult;
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
    description = "物流区操作",
    position = 1,
    tags = "LogisticsAreaRestController")
public class LogisticsAreaRestController extends BaseRestController {

    @Autowired
    private RegnLogisticsAreaService regnLogisticsAreaService;

    @ApiOperation(value = "单独物流区域信息查询操作",
        notes = "单独物流区域信息查询操作",
        position = 5)
    @RequestMapping(value = "/region/logistics/_search",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<LogisticsAreaRsParam> searchRegionLogistics(@RequestBody LogisticsAreaRsParam logisticsParam) {
        if (StringUtils.isNotEmpty(logisticsParam.getLgcsAreaName())) {
            logisticsParam.setLgcsAreaName(DbUtils.buildLikeCondition(logisticsParam.getLgcsAreaName(), DbUtils.LikeMode.PARTIAL));
        }
        List<LogisticsAreaRsParam> list = regnLogisticsAreaService.findList(logisticsParam);
        return list;
    }

    @ApiOperation(value = "searchRegionLogistics",
        notes = "物流区到领地信息查询操作",
        position = 5)
    @RequestMapping(value = "/region/logistics/demesne/_search",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    public BaseRestPaginationResult<LogisticsAreaRestResult> searchRegionLogisticsToDemesne(
        @RequestBody LogisticsAreaPageParam pageParam) {

        if (StringUtils.isNotEmpty(pageParam.getLgcsAreaName())) {
            pageParam.setLgcsAreaName(DbUtils.buildLikeCondition(pageParam.getLgcsAreaName(), DbUtils.LikeMode.PARTIAL));
        }
        if (StringUtils.isNotEmpty(pageParam.getZoneName())) {
            pageParam.setZoneName(DbUtils.buildLikeCondition(pageParam.getZoneName(), DbUtils.LikeMode.PARTIAL));
        }
        if (StringUtils.isNotEmpty(pageParam.getDistributionName())) {
            pageParam.setDistributionName(DbUtils.buildLikeCondition(pageParam.getDistributionName(), DbUtils.LikeMode.PARTIAL));
        }
        if (StringUtils.isNotEmpty(pageParam.getDemesneName())) {
            pageParam.setDemesneName(DbUtils.buildLikeCondition(pageParam.getDemesneName(), DbUtils.LikeMode.PARTIAL));
        }

        BaseRestPaginationResult<LogisticsAreaRestResult> list = regnLogisticsAreaService.findPageList(pageParam);
        return list;
    }

    @ApiOperation(value = "物流区域信息新增",
        notes = "物流区域信息新增",
        position = 5)
    @RequestMapping(value = "/region/logistics/_add",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    @Validator(validatorClass = LogisticsAreaAddValidator.class)
    public List<LogisticsAreaRsParam> addRegionLogistics(@RequestBody List<LogisticsAreaRsParam> logisticsParam) {
        String[] messageArr = checkLogisticsParamsAdd(logisticsParam);
        // 校验数据的重复性
        if (messageArr != null) {
            throw new BusinessException("region", "REGN.E00013");
        }
        // 校验数据库是否存在重复
        this.checkCityAddToDb(logisticsParam);
        // 对象转换
        List<RegnLogisticsArea> codeList = insertCheck(logisticsParam);
        List<List<RegnLogisticsArea>> list = RestCommUtil.insertRanking(codeList);
        regnLogisticsAreaService.executeBatchSave(list);
        return logisticsParam;
    }

    @ApiOperation(value = "物流区域信息修改",
        notes = "物流区域信息修改",
        position = 5)
    @RequestMapping(value = "/region/logistics/_update",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    @Validator(validatorClass = LogisticsAreaUpdateValidator.class)
    public void updteRegionLogistics(
        @RequestBody List<BaseBean<LogisticsAreaRsParam, LogisticsAreaRsParam>> logisticsParam) {
        // 校验数据的数据库重复性
        this.checkLogisticsParamsUpdate(logisticsParam);
        // 数据修改
        regnLogisticsAreaService.executeModify(logisticsParam);
    }

    /**
     * 新增参数获取
     *
     * @param paramList
     * @return
     */
    public List<RegnLogisticsArea> insertCheck(List<LogisticsAreaRsParam> paramList) {
        List<RegnLogisticsArea> codeList = new ArrayList<>();
        int listSize = paramList.size();
        RegnLogisticsArea regnLogisticsArea;
        for (int i = 0; i < listSize; i++) {
            regnLogisticsArea = BeanUtils.toBean(paramList.get(i), RegnLogisticsArea.class);
            regnLogisticsArea.setLgcsAreaCode(paramList.get(i).getLgcsAreaCode());
            regnLogisticsArea.setLgcsAreaName(paramList.get(i).getLgcsAreaName());
            Date currentDate = DateUtils.getCurrent();
            regnLogisticsArea.setCrtTime(currentDate);
            regnLogisticsArea.setCrtId(regnLogisticsAreaService.getLoginUserId());
            regnLogisticsArea.setUpdId(regnLogisticsAreaService.getLoginUserId());
            regnLogisticsArea.setUpdTime(currentDate);
            regnLogisticsArea.setDivisionLevel(NumberConst.IntDef.INT_ZERO);
            Long maxId = regnLogisticsAreaService.maxId("REGN_LOGISTICS_AREA");
            regnLogisticsArea.setLgcsAreaId(maxId);
            paramList.get(i).setLgcsAreaId(maxId);
            codeList.add(regnLogisticsArea);
        }
        return codeList;
    }

    /**
     * 新增数据验证传入数据本身是否有重复数据
     *
     * @param logisticsAreaRsParams
     * @return
     */
    private String[] checkLogisticsParamsAdd(List<LogisticsAreaRsParam> logisticsAreaRsParams) {
        String[] returnMessage = null;
        List<String> messageList = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(logisticsAreaRsParams)) {
            LogisticsAreaRsParam param;
            int listSize = logisticsAreaRsParams.size();
            Set set = new HashSet();
            for (int i = NumberConst.IntDef.INT_ZERO; i < listSize; i++) {
                param = logisticsAreaRsParams.get(i);
                String mapKey = logisticsAreaRsParams.get(i).getLgcsAreaCode()
                        + logisticsAreaRsParams.get(i).getLgcsAreaName();
                if (set.contains(mapKey)) {
                    String[] args = new String[] { MessageManager.getMessage(param.getLgcsAreaCode(),
                        StringUtils.toString(i + NumberConst.IntDef.INT_ONE)) };
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
     * @param logisticsAreaRsParams
     */
    private void checkCityAddToDb(List<LogisticsAreaRsParam> logisticsAreaRsParams) {
        LogisticsAreaRsParam logisticsArea;
        if (CollectionUtils.isNotEmpty(logisticsAreaRsParams)) {
            for (int i = NumberConst.IntDef.INT_ZERO; i < logisticsAreaRsParams.size(); i++) {
               /* logisticsArea = regnLogisticsAreaService.findOne(logisticsAreaRsParams.get(i));*/
                List<LogisticsAreaRsParam> checkDatas=  regnLogisticsAreaService.checkData(logisticsAreaRsParams.get(i));
                if (checkDatas.size()>NumberConst.IntDef.INT_ZERO) {
                    String[] args = new String[] { String.valueOf(i + 1),
                        MessageManager.getMessage(MessageDef.Label.L00001) };
                    throw new BusinessException("region", "REGN.E00013");
                }
            }
        }
    }

    /**
     * 物流区数据校验
     * 
     * @param logisticsParam
     */
    public void checkLogisticsParamsUpdate(List<BaseBean<LogisticsAreaRsParam, LogisticsAreaRsParam>> logisticsParam) {
        if (CollectionUtils.isNotEmpty(logisticsParam)) {
            for (int i = 0; i < logisticsParam.size(); i++) {
                LogisticsAreaRsParam target = logisticsParam.get(i).getTarget();
                target.setLgcsAreaId(logisticsParam.get(i).getFilter().getLgcsAreaId());
                /*LogisticsAreaRsParam dbRsParam = regnLogisticsAreaService.findOne(target);*/
                List<LogisticsAreaRsParam> checkDatas=  regnLogisticsAreaService.checkData(target);
                if (checkDatas.size() > NumberConst.IntDef.INT_ZERO  && target.isDelFlg() == false) {
                    if (target.getDisableFlg() == null || target.getDisableFlg().equals("1")) {
                        // 存在相同的编码或者名称
                        throw new BusinessException("region", "REGN.E00013");
                    }
                }
            }
        } else {
            throw new BusinessException("region", "REGN.E00013");
        }
    }

}
