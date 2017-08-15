package com.bms.slpd.rest;


import com.bms.slpd.bean.param.SLPD0201IParam;
import com.bms.slpd.bean.result.SLPD0201IResult;
import com.bms.slpd.bean.result.field.SLPD0201IBreedResult;
import com.bms.slpd.services.SLPD0201IService;
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
@Api(tags = "SLPD0201IRestController", description = "批量查询品种API")
public class SLPD0201IRestController extends BaseRestController {

	@Autowired
	private SLPD0201IService slpd0201IService;

	@ApiOperation(value = "批量查询品种URL",
			notes = "批量查询品种")
	@RequestMapping(value = "/classes/machinings/breeds/_find",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public SLPD0201IResult findBreeds(@RequestBody SLPD0201IParam slpd0201IParam) {
		BaseRestPaginationResult<SLPD0201IBreedResult> restResult = this.slpd0201IService.findBreeds(slpd0201IParam);
		SLPD0201IResult slpd0201IResult = new SLPD0201IResult();
		slpd0201IResult.setTotal(restResult.getTotal());
		slpd0201IResult.setData(restResult.getData());
		slpd0201IResult.setMessages(MessageUtils.getSuccessMessage());
		return slpd0201IResult;
	}

}
