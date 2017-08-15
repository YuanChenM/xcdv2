package com.bms.slpd.rest;

import com.bms.slpd.bean.param.SLPD1201IParam;
import com.bms.slpd.bean.param.SLPD1201IParam;
import com.bms.slpd.bean.result.SLPD1201IResult;
import com.bms.slpd.bean.result.SLPD1202IResult;
import com.bms.slpd.services.SLPD1201IService;
import com.bms.slpd.utils.MessageUtils;
import com.bms.slpd.validator.SLPD1201IValidator;
import com.framework.boot.base.BaseRestController;
import com.framework.validator.annotation.Validator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "SLPD1201IRestController", description = "批量新增物流区产品API")
@RestController
public class SLPD1201IRestController extends BaseRestController {

	@Autowired
	private SLPD1201IService slpd1201iService;

	@ApiOperation(value = "批量新增物流区产品",
			notes = "批量新增物流区产品,新增的物流区产品均为下架状态")
	@RequestMapping(value = "/logistics/areas/products/_add",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@Validator(validatorClass = SLPD1201IValidator.class)
	public SLPD1201IResult addLogisticsAreaProducts(@RequestBody SLPD1201IParam slpd1201IParam) {
		return this.slpd1201iService.saveLgcsCommodities(slpd1201IParam.getLgcsAreaCommodities());

	}

}
