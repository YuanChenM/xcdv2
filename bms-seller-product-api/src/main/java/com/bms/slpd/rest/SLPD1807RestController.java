package com.bms.slpd.rest;

import com.bms.fms.notice.FmsNotice;
import com.bms.slpd.bean.param.SLPD1807IParam;
import com.bms.slpd.bean.result.SLPD1807IResult;
import com.bms.slpd.services.SLPD1807IService;
import com.framework.boot.base.BaseRestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "SLPD1807RestController", description = "批量新增制造商单品品牌规格生产商API")
public class SLPD1807RestController extends BaseRestController {
    @Autowired
    private FmsNotice fmsNotice;
    @Autowired
    private SLPD1807IService slpd1807IService;

    @ApiOperation(value = "批量新增制造商单品品牌规格生产商",
            notes = "批量新增制造商单品品牌规格生产商")
    @RequestMapping(value = "/classes/machinings/breeds/brands/items/properties/manufacturer/_add",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public SLPD1807IResult findProducts(@RequestBody SLPD1807IParam slpd1807iParam) {
        SLPD1807IResult result = slpd1807IService.saveManufacturerProducts(slpd1807iParam);
        if (null != result) {
            for (String sku : result.getSkus()) {
                this.fmsNotice.sendSku(sku);
            }
        }
        return result;
    }

}
