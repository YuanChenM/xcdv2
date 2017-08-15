package com.bms.slpd.rest;

import com.bms.slpd.bean.param.SLPD0501IParam;
import com.bms.slpd.bean.result.SLPD0501IResult;
import com.bms.slpd.bean.result.field.SLPD0501IProductResult;
import com.bms.slpd.services.SLPD0501IService;
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

@RestController
@Api(tags = "SLPD0501IRestController", description = "批量查询产品API")
public class SLPD0501IRestController extends BaseRestController {

	@Autowired
	private SLPD0501IService slpd0501IService;

	@ApiOperation(value = "批量查询产品URL",
			notes = "批量查询产品，可分页查询；")
	@RequestMapping(value = "/classes/machinings/breeds/brands/items/properties/products/_find",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public SLPD0501IResult findProducts(@RequestBody SLPD0501IParam slpd0501iParam) {
		BaseRestPaginationResult<SLPD0501IProductResult> restResult = this.slpd0501IService.findProducts(slpd0501iParam);
		SLPD0501IResult slpd0501iResult = new SLPD0501IResult();
		slpd0501iResult.setTotal(restResult.getTotal());
		slpd0501iResult.setData(restResult.getData());
		slpd0501iResult.setMessages(MessageUtils.getSuccessMessage());
		return slpd0501iResult;
	}

}
