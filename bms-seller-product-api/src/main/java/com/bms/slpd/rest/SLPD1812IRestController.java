package com.bms.slpd.rest;

import com.bms.slpd.bean.param.SLPD1812IParam;
import com.bms.slpd.bean.result.SLPD1812IResult;
import com.bms.slpd.bean.result.field.SLPD1812IProductResult;
import com.bms.slpd.services.SLPD1812IService;
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
@Api(tags = "SLPD1812IRestController", description = "批量查询单品品牌规格API")
public class SLPD1812IRestController extends BaseRestController {

	@Autowired
	private SLPD1812IService slpd1812IService;

	@ApiOperation(value = "批量查询单品品牌规格(未绑定)URL",
			notes = "批量查询单品品牌规格(未绑定)，可分页查询；")
	@RequestMapping(value = "/classes/machinings/breeds/brands/items/properties/unbind/_find",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public SLPD1812IResult findProducts(@RequestBody SLPD1812IParam slpd1812iParam) {
		BaseRestPaginationResult<SLPD1812IProductResult> restResult = this.slpd1812IService.findProducts(slpd1812iParam);
		SLPD1812IResult slpd1812iResult = new SLPD1812IResult();
		slpd1812iResult.setTotal(restResult.getTotal());
		slpd1812iResult.setData(restResult.getData());
		slpd1812iResult.setMessages(MessageUtils.getSuccessMessage());
		return slpd1812iResult;
	}

}
