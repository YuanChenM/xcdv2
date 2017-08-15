package com.bms.slpd.rest;

import com.bms.slpd.bean.param.SLPD0802IParam;
import com.bms.slpd.bean.result.SLPD0802IResult;
import com.bms.slpd.bean.result.field.SLPD0802ISellerCommodityResult;
import com.bms.slpd.services.SLPD0802IService;
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
@Api(tags = "SLPD0802IRestController", description = "批量查询卖家单品品牌(规格)生产商API")
public class SLPD0802IRestController extends BaseRestController {

	@Autowired
	private SLPD0802IService slpd0802IService;

	@ApiOperation(value = "批量查询卖家单品品牌(规格)生产商URL",
			notes = "批量查询卖家单品品牌(规格)生产商")
	@RequestMapping(value = "/classes/machinings/breeds/brands/items/properties/products/producers/sellers/_find",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public SLPD0802IResult findSellerCommodities(@RequestBody SLPD0802IParam slpd0802IParam) {
		BaseRestPaginationResult<SLPD0802ISellerCommodityResult> restResult = this.slpd0802IService.findSellerCommodities(slpd0802IParam);
		SLPD0802IResult slpd0802IResult = new SLPD0802IResult();
		slpd0802IResult.setTotal(restResult.getTotal());
		slpd0802IResult.setData(restResult.getData());
		slpd0802IResult.setMessages(MessageUtils.getSuccessMessage());
		return slpd0802IResult;
	}

}
