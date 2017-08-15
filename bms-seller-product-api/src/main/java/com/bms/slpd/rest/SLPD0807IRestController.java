package com.bms.slpd.rest;

import com.bms.slpd.bean.param.SLPD0804IParam;
import com.bms.slpd.bean.result.SLPD0804IResult;
import com.bms.slpd.services.SLPD0807IService;
import com.bms.slpd.utils.MessageUtils;
import com.bms.slpd.validator.SLPD0804IValidator;
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

@Api(tags = "SLPD0807IRestController", description = "批量审核卖家产品生产商(三合一内部接口)")
@RestController
public class SLPD0807IRestController extends BaseRestController {

	@Autowired
	private SLPD0807IService slpd0807iService;

	@ApiOperation(value = "批量审核卖家产品生产商(三合一内部接口)API",
			notes = "审核卖家单品品牌规格生产商,生成货号及商品ID,添加至物流区商品表")
	@RequestMapping(value = "/sellers/producers/products/auditStus/articleNos/commodityIds/regions/commodities/_add",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@Validator(validatorClass = SLPD0804IValidator.class)
	public SLPD0804IResult auditSellerCommodities(@RequestBody SLPD0804IParam slpd0804iParam) {
		this.slpd0807iService.auditSellerCommodities(slpd0804iParam);
		SLPD0804IResult slpd0804iResult = new SLPD0804IResult();
		slpd0804iResult.setMessages(MessageUtils.getSuccessMessage());
		return slpd0804iResult;
	}

}
