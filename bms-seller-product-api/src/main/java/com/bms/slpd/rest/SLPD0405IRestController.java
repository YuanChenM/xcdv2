package com.bms.slpd.rest;


import com.bms.slpd.bean.param.SLPD0405IParam;
import com.bms.slpd.bean.result.SLPD0405IResult;
import com.bms.slpd.bean.result.wrapper.SlpdBrandOwnerResult;
import com.bms.slpd.services.SLPD0405IService;
import com.bms.slpd.utils.MessageUtils;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseRestController;
import com.framework.core.utils.BeanUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ding_guangjian on 2016/12/8.
 */
@RestController
@Api(description = "查询品牌所有人",
        tags = "SLPD0405IRestController")
public class SLPD0405IRestController extends BaseRestController {
    @Autowired
    private SLPD0405IService slpd0405IService;

    @ApiOperation(value = "查询品牌所有人",
            notes = "filter传入品牌所有人IDList,品牌IDList,品牌所有人编码,品牌所有人名称,品牌所有人类型,删除标志查询品牌信息")
    @RequestMapping(value = "/brands/owners/_find",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public SLPD0405IResult findBrandOwners(@RequestBody SLPD0405IParam param) {
        BaseRestPaginationResult<SlpdBrandOwnerResult> pagingResult = slpd0405IService.findBrandOwenList(param);
        SLPD0405IResult slpd0405IResult = BeanUtils.toBean(pagingResult, SLPD0405IResult.class);
        slpd0405IResult.setMessage(MessageUtils.getSuccessMessage());
        return slpd0405IResult;
    }
}
