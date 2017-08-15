package com.bms.slpd.rest;

import com.bms.slpd.bean.param.SLPD0805IParam;
import com.bms.slpd.bean.result.SLPD0805IResult;
import com.bms.slpd.bean.result.field.SLPD0805ICommodityResult;
import com.bms.slpd.services.SLPD0805IService;
import com.bms.slpd.utils.MessageUtils;
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

@RestController
@Api(tags = "SLPD0805IRestController", description = "批量查询商品清单API")
public class SLPD0805IRestController extends BaseRestController {

	@Autowired
	private SLPD0805IService slpd0805IService;

	@ApiOperation(value = "批量查询商品清单URL",
			notes = "批量查询商品清单")
	@RequestMapping(value = "/commodities/_find",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public SLPD0805IResult findSellerCommodities(@RequestBody SLPD0805IParam slpd0805IParam) {
		BaseRestPaginationResult<SLPD0805ICommodityResult> restResult = this.slpd0805IService.findSellerCommodities(slpd0805IParam);
		SLPD0805IResult slpd0805IResult = new SLPD0805IResult();
		slpd0805IResult.setTotal(restResult.getTotal());
		slpd0805IResult.setData(restResult.getData());
		slpd0805IResult.setMessages(MessageUtils.getSuccessMessage());
		return slpd0805IResult;
	}

}
