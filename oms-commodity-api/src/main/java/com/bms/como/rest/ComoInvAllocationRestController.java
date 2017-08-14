package com.bms.como.rest;

import com.bms.como.bean.entity.ComoInvAllocation;
import com.bms.como.bean.entity.ComoInvAllocationDetail;
import com.bms.como.bean.entity.ComoInvAllocationResult;
import com.bms.como.bean.param.AllocationResultRsParam;
import com.bms.como.bean.param.ComoInvAllocationRsParam;
import com.bms.como.bean.result.ComoInvAllocationCompleteRsResult;
import com.bms.como.bean.result.ComoInvAllocationRsResult;
import com.bms.como.constant.MessageConstant;
import com.bms.como.service.ComoInvAllocationService;
import com.bms.como.validator.ComoInvAllocationAddValidator;
import com.bms.como.validator.ComoInvAllocationDetailModifyValidator;
import com.bms.como.validator.ComoInvAllocationModifyValidator;
import com.bms.como.validator.ComoInvAllocationResultAddValidator;
import com.framework.base.consts.NumberConst;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseRestController;
import com.framework.core.utils.DateUtils;
import com.framework.validator.annotation.Validator;
import com.sun.org.apache.regexp.internal.RE;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by yuan_zhifei on 2017/4/1.
 */
@RestController
@Api(value = "bms-como-api", description = "库存划拨单信息", position = 1, tags = "ComoInvAllocationRestController")
public class ComoInvAllocationRestController extends BaseRestController {
    @Autowired
    private ComoInvAllocationService invAllocationService;

    @ApiOperation(value = "COMO0304I库存划拨单新增接口", notes = "COMO0304I库存划拨单新增接口", position = 1)
    @RequestMapping(value = "/commodity/inventory/allocation/_add", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = ComoInvAllocationAddValidator.class)
    public ComoInvAllocationRsResult saveInvAllocation(@RequestBody ComoInvAllocationRsParam invAllocationRsParam) {
        return invAllocationService.saveInvAllocation(invAllocationRsParam);
    }

    @ApiOperation(value = "COMO0306I库存划拨单查询接口", notes = "COMO0306I库存划拨单查询接口", position = 2)
    @RequestMapping(value = "/commodity/inventory/allocation/_search", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public BaseRestPaginationResult<ComoInvAllocationRsResult> searchInvAllocations(@RequestBody ComoInvAllocationRsParam invAllocationRsParam) {
        return invAllocationService.searchInvAllocations(invAllocationRsParam);
    }

    @ApiOperation(value = "COMO0305I库存划拨结果回传接收接口", notes = "COMO0305I库存划拨结果回传接收接口", position = 3)
    @RequestMapping(value = "/commodity/inventory/allocation/result/_recevice", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = ComoInvAllocationResultAddValidator.class)
    public Integer saveInvAllocationResult(@RequestBody AllocationResultRsParam rsParam) {
        return invAllocationService.saveInvAllocationResult(rsParam);
    }


    @ApiOperation(value = "库存划拨单状态修改接口", notes = "库存划拨单状态修改接口", position = 4)
    @RequestMapping(value = "/commodity/inventory/allocation/_modify", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = ComoInvAllocationModifyValidator.class)
    public ComoInvAllocationCompleteRsResult modiyInvAllocation(@RequestBody ComoInvAllocation param) {
        param.setUpdId(super.getUserId());
        param.setUpdTime(DateUtils.getCurrent());
        int count = invAllocationService.modify(param);
        ComoInvAllocationCompleteRsResult result = new ComoInvAllocationCompleteRsResult();
        result.setCount(count);
        if(count > NumberConst.IntDef.INT_ZERO){
            result.setMessage(MessageConstant.SUCCESS);
        }else {
            result.setMessage(MessageConstant.FAILURE);
        }
        return result;
    }


    @ApiOperation(value = "库存划拨单详情修改接口", notes = "库存划拨单详情修改接口", position = 5)
    @RequestMapping(value = "/commodity/inventory/allocation/detail/_modify", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = ComoInvAllocationDetailModifyValidator.class)
    public ComoInvAllocationCompleteRsResult modiyInvAllocationDetail(@RequestBody ComoInvAllocationDetail param) {
        param.setUpdId(super.getUserId());
        param.setUpdTime(DateUtils.getCurrent());
        int count = invAllocationService.modifyInvAllocationDetail(param);
        ComoInvAllocationCompleteRsResult result = new ComoInvAllocationCompleteRsResult();
        result.setCount(count);
        if(count > NumberConst.IntDef.INT_ZERO){
            result.setMessage(MessageConstant.SUCCESS);
        }else {
            result.setMessage(MessageConstant.FAILURE);
        }
        return result;
    }


    @ApiOperation(value = "新增库存划拨结果接口", notes = "新增库存划拨结果接口", position = 6)
    @RequestMapping(value = "/commodity/inventory/allocation/result/_add", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ComoInvAllocationCompleteRsResult saveInvAllocationResult(@RequestBody List<ComoInvAllocationResult> rsParam) {
        int count = invAllocationService.addInvAllocationDetail(rsParam);
        ComoInvAllocationCompleteRsResult result = new ComoInvAllocationCompleteRsResult();
        result.setCount(count);
        if(count > NumberConst.IntDef.INT_ZERO){
            result.setMessage(MessageConstant.SUCCESS);
        }else {
            result.setMessage(MessageConstant.FAILURE);
        }
        return result;
    }



}
