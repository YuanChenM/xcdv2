package com.bms.slpd.rest;

import com.bms.slpd.bean.param.SLPD1804IParam;
import com.bms.slpd.bean.result.SLPD1804IResult;
import com.bms.slpd.bean.result.field.SLPD1804IProductResult;
import com.bms.slpd.services.SLPD1804IService;
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
@Api(tags = "SLPD1804IRestController", description = "批量查询单品品牌规格API")
public class SLPD1804IRestController extends BaseRestController {

	@Autowired
	private SLPD1804IService slpd1804IService;

	@ApiOperation(value = "批量查询单品品牌规格URL",
			notes = "批量查询单品品牌规格，可分页查询；")
	@RequestMapping(value = "/classes/machinings/breeds/brands/items/properties/_find",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public SLPD1804IResult findProducts(@RequestBody SLPD1804IParam slpd1804iParam) {
		BaseRestPaginationResult<SLPD1804IProductResult> restResult = this.slpd1804IService.findProducts(slpd1804iParam);
		SLPD1804IResult slpd1804iResult = new SLPD1804IResult();
		slpd1804iResult.setTotal(restResult.getTotal());
		slpd1804iResult.setData(restResult.getData());
		slpd1804iResult.setMessages(MessageUtils.getSuccessMessage());
		return slpd1804iResult;
	}

}
