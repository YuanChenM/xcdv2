package com.bms.slpd.rest;

import com.bms.slpd.bean.param.SLPD0503IParam;
import com.bms.slpd.bean.result.SLPD0503IResult;
import com.bms.slpd.services.SLPD0503IService;
import com.bms.slpd.validator.SLPD0503IValidator;
import com.framework.base.rest.RestResponse;
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

@RestController
@Api(description = "修改品牌单品",
        tags = "SLPD0503IRestController")
public class SLPD0503IRestController extends BaseRestController {

    @Autowired
    private SLPD0503IService slpd0503IService;

    @ApiOperation(value = "修改品牌单品",
            notes = "修改品牌单品")
    @RequestMapping(value = "/products/classes/machinings/breeds/brands/items/_modify",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Validator(validatorClass = SLPD0503IValidator.class)
    public RestResponse<SLPD0503IResult> modifyBrandItems(@RequestBody SLPD0503IParam slpd0503IParam) {
    //public RestResponse<SLPD0503IResult> modifyBrandItems(@RequestBody UpdateRestRequest<SLPD0503IParam> slpd0503IParam) {
        //SLPD0503IResult slpd0503IResult = slpd0503IService.modifyBrandItems(slpd0503IParam);

        //String[] args = new String[]{MessageManager.getMessage(MessageConstant.Label.BrandItem)};
        //String message = MessageManager.getMessage(MessageConstant.Info.I000002, args);
        //String[] messages = new String[]{message};

        RestResponse<SLPD0503IResult> response = new RestResponse<>();
        //response.setMessage(messages);
        //response.setResult(slpd0503IResult);
        return response;
    }

}
