package com.bms.slpd.rest;

import com.bms.slpd.bean.param.SLPD1202IParam;
import com.bms.slpd.bean.result.SLPD1202IResult;
import com.bms.slpd.bean.result.field.SLPD1202ILgcsAreaCommodityResult;
import com.bms.slpd.constant.MessageConstant;
import com.bms.slpd.services.SLPD1202IService;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseRestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "SLPD1202IRestController", description = "批量查询物流区产品API")
@RestController
public class SLPD1202IRestController extends BaseRestController {

    @Autowired
    private SLPD1202IService slpd1202iService;

    @ApiOperation(value = "批量查询物流区产品(分页)",
            notes = "根据物流区商品Id集合,物流区Id集合,物流区编码集合,物流区名称,产品需求等级，上下架状态(默认查询所有),分页查询物流区产品")
    @RequestMapping(value = "/logistics/areas/products/_find",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public SLPD1202IResult findLogisticsAreaCommodities(@RequestBody SLPD1202IParam slpd1202IParam) {
        BaseRestPaginationResult<SLPD1202ILgcsAreaCommodityResult> pageResult = this.slpd1202iService.findLgcsCommodities(slpd1202IParam);

        SLPD1202IResult result = new SLPD1202IResult();
        result.setMessages(new String[]{MessageConstant.SUCCESS});
        result.setTotal(pageResult.getTotal());
        result.setData(pageResult.getData());

        return result;
    }

}
