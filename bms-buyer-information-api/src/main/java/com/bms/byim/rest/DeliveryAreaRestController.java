package com.bms.byim.rest;

import com.bms.byim.bean.entity.ByimDeliveryArea;
import com.bms.byim.bean.param.BaseBean;
import com.bms.byim.bean.param.DeliveryAreaRsParam;
import com.bms.byim.constant.MessageDef;
import com.bms.byim.services.ByimDeliveryAreaService;
import com.bms.byim.validator.DeliveryAreaAddValidator;
import com.bms.byim.validator.DeliveryAreaSearchValidator;
import com.bms.byim.validator.DeliveryAreaUpdateValidator;
import com.framework.base.consts.NumberConst;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseRestController;
import com.framework.core.utils.StringUtils;
import com.framework.exception.BusinessException;
import com.framework.i18n.util.MessageManager;
import com.framework.validator.annotation.Validator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections.CollectionUtils;
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

/**
 * Created by zhao_chen1 on 2016/12/9.
 */
@RestController
@Api(value = "bms-byim-api", description = "车辆通行区域信息管理", position = 1, tags = "DeliveryAreaRestController")
public class DeliveryAreaRestController extends BaseRestController {

    Logger logger = LoggerFactory.getLogger(DeliveryAreaRestController.class);

    @Autowired
    private ByimDeliveryAreaService byimDeliveryAreaService;

    @ApiOperation(value = "车辆通行区域码查询", notes = "车辆通行区域码查询")
    @RequestMapping(value = "/buyers/delivery/area/_search", method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = DeliveryAreaSearchValidator.class)
    public BaseRestPaginationResult<DeliveryAreaRsParam> SearchByDeliveryAreaSearch(@RequestBody DeliveryAreaRsParam param) {
        BaseRestPaginationResult<DeliveryAreaRsParam> deliveryArea = byimDeliveryAreaService.findPageList(param);
        return deliveryArea;
    }

    @ApiOperation(value = "车辆通行区域码新增", notes = "车辆通行区域码新增")
    @RequestMapping(value = "/buyers/delivery/area/_add", method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = DeliveryAreaAddValidator.class)
    public Integer addByDeliveryArea(@RequestBody List<DeliveryAreaRsParam> params) {
        logger.info("新增参数list自身是否有重复数据");
        addByDeliveryAreaCheck(params);
        logger.info("新增参数和DB数据是否相同验证");
        checkDeliveryAreaAddParam(params);
        logger.info("车辆通行区域码新增");
        return byimDeliveryAreaService.saveDeliveryArea(params);
    }

    @ApiOperation(value = "车辆通行区域码修改", notes = "车辆通行区域码修改")
    @RequestMapping(value = "/buyers/delivery/area/_update", method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = DeliveryAreaUpdateValidator.class)
    public int updateByDeliveryArea(@RequestBody List<BaseBean<DeliveryAreaRsParam, DeliveryAreaRsParam>> params) {
        int result = NumberConst.IntDef.INT_ZERO;
        if (CollectionUtils.isNotEmpty(params)) {
            logger.info("该数据是否被使用");
            int count = this.byimDeliveryAreaService.findDeliveryArea(params);
            if (count > NumberConst.IntDef.INT_ZERO) {
                result = NumberConst.IntDef.INT_N_ONE;
            } else {
                this.updateByDeliveryAreaCheck(params);
                this.checkDeliveryUpdate(params);
                result = this.byimDeliveryAreaService.updateDeliveryArea(params);
            }
        }
        return result;
    }

    /**
     * 验证编辑的参数和db参数是否重复
     *
     * @param param
     * @return
     */
    private void checkDeliveryUpdate(List<BaseBean<DeliveryAreaRsParam, DeliveryAreaRsParam>> param) {
        int listSize = param.size();
        for (int i = NumberConst.IntDef.INT_ZERO; i < listSize; i++) {
            DeliveryAreaRsParam filter = param.get(i).getFilter();
            DeliveryAreaRsParam target = param.get(i).getTarget();
            //根据filter的主键查出是否存在该条数据
            /*ByimDeliveryArea delivery = byimDeliveryAreaService.findOne(filter);*/
            int count = byimDeliveryAreaService.getCount(filter);
            if (count > NumberConst.IntDef.INT_ZERO) {
                /*List<DeliveryAreaRsParam> deliveryAreas = byimDeliveryAreaService.findList(target);*/
                ByimDeliveryArea delivery = byimDeliveryAreaService.findOne(target);
                if (!target.getDelFlg()) {
                    if (null != delivery) {
                        if (!(filter.getDeliveryAreaId()).equals(delivery.getDeliveryAreaId())) {
                            throw new BusinessException("byim", "BYIM.E00012");
                        }
                    }
                }
            } else {
                String[] args = new String[]{String.valueOf(i + 1), MessageManager.getMessage(MessageDef.Label.L00008)};
                throw new BusinessException("byim", "BYIM.E00013");
            }
        }
    }

    /**
     * 新增参数和db参数验证是否重复
     *
     * @param deliveryAreaParamList
     * @return
     */
    private void checkDeliveryAreaAddParam(List<DeliveryAreaRsParam> deliveryAreaParamList) {
        ByimDeliveryArea byimDeliveryArea;
        if (org.apache.commons.collections.CollectionUtils.isNotEmpty(deliveryAreaParamList)) {
            for (int i = NumberConst.IntDef.INT_ZERO; i < deliveryAreaParamList.size(); i++) {
                List<DeliveryAreaRsParam> deliveryAreas = byimDeliveryAreaService.findList(deliveryAreaParamList.get(i));
                if (CollectionUtils.isNotEmpty(deliveryAreas)) {
                    String[] args = new String[]{String.valueOf(i + 1), MessageManager.getMessage(MessageDef.Label.L00008)};
                    throw new BusinessException("byim", "BYIM.E00012");
                }
            }
        }
    }

    /**
     * 新增参数集合中重复参数验证
     *
     * @param params
     */
    public void addByDeliveryAreaCheck(List<DeliveryAreaRsParam> params) {
        Set<String> inParamSet = new HashSet<>();
        for (int i = 0; i < params.size(); i++) {
            DeliveryAreaRsParam param = params.get(i);
            String code = param.getLgcsAreaCode() + param.getProvinceCode() + param.getCityCode() + param.getDeliveryAreaCode();
            if (inParamSet.contains(code)) {
                String[] args = new String[]{String.valueOf(i + 1), MessageManager.getMessage(MessageDef.Label.L00014)};
                throw new BusinessException("byim", "BYIM.E00012");
            } else {
                inParamSet.add(code);
            }
        }
    }

    public void updateByDeliveryAreaCheck(List<BaseBean<DeliveryAreaRsParam, DeliveryAreaRsParam>> params) {
        Set<String> updateParamSet = new HashSet<>();
        for (int i = 0; i < params.size(); i++) {
            DeliveryAreaRsParam target = params.get(i).getTarget();
            if (!StringUtils.isEmpty(target.getDeliveryAreaCode())) {
                String code = target.getLgcsAreaCode() + target.getProvinceCode() + target.getCityCode() + target.getDeliveryAreaCode();
                if (updateParamSet.contains(code)) {
                    String[] args = new String[]{String.valueOf(i + 1), MessageManager.getMessage(MessageDef.Label.L00014)};
                    throw new BusinessException("byim", "BYIM.E00012");
                } else {
                    updateParamSet.add(code);
                }
            }
        }

    }


}
