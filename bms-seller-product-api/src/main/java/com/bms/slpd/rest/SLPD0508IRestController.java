package com.bms.slpd.rest;

import com.bms.slpd.bean.param.SLPD0508IParam;
import com.bms.slpd.bean.result.SLPD0508IResult;
import com.bms.slpd.services.SLPD0508IService;
import com.bms.slpd.utils.MessageUtils;
import com.bms.slpd.validator.SLPD0508IValidator;
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

@Api(tags = "SLPD0508IRestController", description = "批量审核制造商产品生产商API")
@RestController
public class SLPD0508IRestController extends BaseRestController {

	@Autowired
	private SLPD0508IService slpd0508iService;

	@ApiOperation(value = "批量审核制造商产品生产商URL",
			notes = "批量禁止制造商产品生产商和代理商产品生产商,准入制造商生产商产品,及所对应的生产商产品,产品")
	@RequestMapping(value = "/classes/machinings/breeds/brands/items/properties/manufacturer/_audit",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@Validator(validatorClass = SLPD0508IValidator.class)
	public SLPD0508IResult auditProducts(@RequestBody SLPD0508IParam slpd0508iParam) {
		int count = this.slpd0508iService.auditManufacturerProducts(slpd0508iParam);
		SLPD0508IResult slpd0508IResult = new SLPD0508IResult();
		slpd0508IResult.setCount(count);
		slpd0508IResult.setMessages(MessageUtils.getSuccessMessage());
		return slpd0508IResult;
	}

}
