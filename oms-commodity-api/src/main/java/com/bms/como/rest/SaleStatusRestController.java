package com.bms.como.rest;

import com.bms.como.bean.entity.ComoSaleStatus;
import com.bms.como.bean.param.BaseBean;
import com.bms.como.bean.param.SaleStatusRsParam;
import com.bms.como.service.ComoSaleStatusService;
import com.bms.como.validator.SaleStatusAddValidator;
import com.bms.como.validator.SaleStatusUpdateValidator;
import com.framework.base.consts.NumberConst;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseRestController;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.DateUtils;
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

import java.util.Date;

/**
 * Created by yuan_zhifei on 2017/3/27.
 */
@RestController
@Api(value = "bms-como-api", description = "销售状态信息", position = 1, tags = "SaleStatusRestController")
public class SaleStatusRestController extends BaseRestController {
    @Autowired
    private ComoSaleStatusService comoSaleStatusService;


    @ApiOperation(value = "销售状态新增接口", notes = "销售状态新增接口", position = 1)
    @RequestMapping(value = "/commodity/saleStatus/_add", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = SaleStatusAddValidator.class)
    public SaleStatusRsParam savePartnerSaleStatus(@RequestBody SaleStatusRsParam saleStatusRsParam) {
        int checkResult = checkParam(saleStatusRsParam);
        if (checkResult == NumberConst.IntDef.INT_ZERO) {
            saleStatusRsParam = comoSaleStatusService.saveSaleStatus(saleStatusRsParam);
        } else {
            saleStatusRsParam.setResult(checkResult);
        }
        return saleStatusRsParam;
    }

    @ApiOperation(value = "销售状态编辑接口", notes = "销售状态编辑接口", position = 2)
    @RequestMapping(value = "/commodity/saleStatus/_update", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = SaleStatusUpdateValidator.class)
    public Integer updateSaleStatus(@RequestBody BaseBean<SaleStatusRsParam, SaleStatusRsParam> saleStatusRsParam) {
        SaleStatusRsParam saleStatus = saleStatusRsParam.getTarget();
        int checkResult = checkParam(saleStatus);
        int result = NumberConst.IntDef.INT_ZERO;
        if (checkResult == NumberConst.IntDef.INT_ZERO) {
            result = this.comoSaleStatusService.modifySaleStatus(saleStatusRsParam);
        } else {
            result = checkResult;
        }
        return result;
    }

    @ApiOperation(value = "销售状态查询接口", notes = "销售状态查询接口", position = 3)
    @RequestMapping(value = "/commodity/saleStatus/_search", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public BaseRestPaginationResult<SaleStatusRsParam> saleStatusSearch(@RequestBody SaleStatusRsParam saleStatusRsParam) {
        /*saleStatusRsParam.setSaleStatusCode(DbUtils.buildLikeCondition(saleStatusRsParam.getSaleStatusCode(), DbUtils.LikeMode.PARTIAL));
        saleStatusRsParam.setSaleStatusName(DbUtils.buildLikeCondition(saleStatusRsParam.getSaleStatusName(), DbUtils.LikeMode.PARTIAL));*/
        BaseRestPaginationResult<SaleStatusRsParam> paginationResult = this.comoSaleStatusService.findPageList(saleStatusRsParam);
        return paginationResult;
    }

    //check销售状态编码和名称是否唯一
    private int checkParam(SaleStatusRsParam saleStatusRsParam) {
        int checkCode = this.comoSaleStatusService.checkCode(saleStatusRsParam);
        int checkName = this.comoSaleStatusService.checkName(saleStatusRsParam);
        int result = NumberConst.IntDef.INT_ZERO;
        if (checkCode > NumberConst.IntDef.INT_ZERO) {
            //销售状态编码已存在！
            result = NumberConst.IntDef.INT_N_ONE;
            throw new BusinessException("como", "COMO.E01001");
        } else if (checkName > NumberConst.IntDef.INT_ZERO) {
            //销售状态名称已存在！
            result = NumberConst.IntDef.INT_N_TWO;
            throw new BusinessException("como", "COMO.E01002");
        }
        return result;
    }
}
