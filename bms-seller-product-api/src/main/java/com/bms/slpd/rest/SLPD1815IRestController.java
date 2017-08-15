package com.bms.slpd.rest;

import com.bms.slpd.bean.param.SLPD1815IParam;
import com.bms.slpd.bean.result.SLPD1815IResult;
import com.bms.slpd.bean.result.field.SLPD1815IItemPropertyResult;
import com.bms.slpd.services.SLPD1815IService;
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
@Api(tags = "SLPD1815IRestController", description = "查询单品规格API")
public class SLPD1815IRestController extends BaseRestController {

	@Autowired
	private SLPD1815IService slpd1815IService;

	@ApiOperation(value = "查询单品规格URL",
			notes = "查询单品规格，可分页查询；")
	@RequestMapping(value = "/classes/machinings/breeds/items/properties/_find",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public SLPD1815IResult findItemProperties(@RequestBody SLPD1815IParam slpd1815iParam) {
		BaseRestPaginationResult<SLPD1815IItemPropertyResult> restResult = this.slpd1815IService.findItemProperties(slpd1815iParam);
		SLPD1815IResult slpd1815iResult = new SLPD1815IResult();
		slpd1815iResult.setTotal(restResult.getTotal());
		slpd1815iResult.setData(restResult.getData());
		slpd1815iResult.setMessages(MessageUtils.getSuccessMessage());
		return slpd1815iResult;
	}

}
