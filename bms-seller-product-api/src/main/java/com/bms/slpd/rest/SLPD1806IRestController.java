package com.bms.slpd.rest;

import com.bms.slpd.bean.param.SLPD1806IParam;
import com.bms.slpd.bean.result.SLPD1806IResult;
import com.bms.slpd.bean.result.field.SLPD1806IManufacturerProducerProductResult;
import com.bms.slpd.services.SLPD1806IService;
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
@Api(tags = "SLPD1806IRestController", description = "批量查询制造商单品品牌规格生产商API")
public class SLPD1806IRestController extends BaseRestController {

	@Autowired
	private SLPD1806IService slpd1806IService;

	@ApiOperation(value = "批量查询制造商单品品牌规格生产商",
			notes = "批量查询制造商单品品牌规格生产商")
	@RequestMapping(value = "/classes/machinings/breeds/brands/items/properties/manufacturer/_find",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public SLPD1806IResult findProducts(@RequestBody SLPD1806IParam slpd1806iParam) {
		BaseRestPaginationResult<SLPD1806IManufacturerProducerProductResult> restResult = this.slpd1806IService.findManufacturerProducts(slpd1806iParam);
		SLPD1806IResult slpd1806iResult = new SLPD1806IResult();
		slpd1806iResult.setTotal(restResult.getTotal());
		slpd1806iResult.setData(restResult.getData());
		slpd1806iResult.setMessages(MessageUtils.getSuccessMessage());
		return slpd1806iResult;
	}

}
