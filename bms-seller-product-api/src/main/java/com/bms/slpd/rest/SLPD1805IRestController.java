package com.bms.slpd.rest;

import com.bms.slpd.bean.param.SLPD1805IParam;
import com.bms.slpd.bean.result.SLPD1805IResult;
import com.bms.slpd.bean.result.field.SLPD1805IProductProducerResult;
import com.bms.slpd.services.SLPD1805IService;
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
@Api(tags = "SLPD1805IRestController", description = "批量查询单品品牌规格生产商API")
public class SLPD1805IRestController extends BaseRestController {

	@Autowired
	private SLPD1805IService slpd1805IService;

	@ApiOperation(value = "批量查询单品品牌规格生产商URL",
			notes = "批量查询单品品牌规格生产商，可分页查询；")
	@RequestMapping(value = "/classes/machinings/breeds/brands/items/properties/producers/_find",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public SLPD1805IResult findProducts(@RequestBody SLPD1805IParam slpd1805iParam) {
		BaseRestPaginationResult<SLPD1805IProductProducerResult> restResult = this.slpd1805IService.findProductProducers(slpd1805iParam);
		SLPD1805IResult slpd1805iResult = new SLPD1805IResult();
		slpd1805iResult.setTotal(restResult.getTotal());
		slpd1805iResult.setData(restResult.getData());
		slpd1805iResult.setMessages(MessageUtils.getSuccessMessage());
		return slpd1805iResult;
	}

}
