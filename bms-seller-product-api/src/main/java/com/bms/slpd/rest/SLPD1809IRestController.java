package com.bms.slpd.rest;

import com.bms.slpd.bean.param.SLPD1809IParam;
import com.bms.slpd.bean.result.SLPD1809IResult;
import com.bms.slpd.bean.result.field.SLPD1809IAgentSupplyProductResult;
import com.bms.slpd.services.SLPD1809IService;
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
@Api(tags = "SLPD1809IRestController", description = "批量查询单品品牌规格代理商")
public class SLPD1809IRestController extends BaseRestController {

	@Autowired
	private SLPD1809IService slpd1809IService;

	@ApiOperation(value = "批量查询单品品牌规格代理商",
			notes = "批量查询单品品牌规格代理商")
	@RequestMapping(value = "/classes/machinings/breeds/brands/items/properties/agent/supply/_find",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public SLPD1809IResult findAgentSupplyProducts(@RequestBody SLPD1809IParam slpd1809IParam) {
		BaseRestPaginationResult<SLPD1809IAgentSupplyProductResult> restResult = slpd1809IService.findAgentSupplyProducts(slpd1809IParam);
		SLPD1809IResult slpd1809IResult = new SLPD1809IResult();
		slpd1809IResult.setTotal(restResult.getTotal());
		slpd1809IResult.setData(restResult.getData());
		slpd1809IResult.setMessages(MessageUtils.getSuccessMessage());
		return slpd1809IResult;
	}

}
