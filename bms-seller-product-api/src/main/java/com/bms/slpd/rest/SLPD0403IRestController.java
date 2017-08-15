package com.bms.slpd.rest;


import com.bms.slpd.bean.param.SLPD0403IParam;
import com.bms.slpd.bean.result.SLPD0403IResult;
import com.bms.slpd.bean.result.wrapper.SlpdBrandResult;
import com.bms.slpd.constant.MessageConstant;
import com.bms.slpd.services.SLPD0403IService;
import com.bms.slpd.utils.MessageUtils;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseRestController;
import com.framework.core.utils.BeanUtils;
import com.framework.i18n.util.MessageManager;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(description = "批量查询品牌",
        tags = "SLPD0403IRestController")
public class SLPD0403IRestController extends BaseRestController {

    @Autowired
    private SLPD0403IService slpd0403IService;

    @ApiOperation(value = "批量查询品牌",
            notes = "filter传入品牌所有人IDList,品牌IDList,品牌编码,品牌名称,品牌类型,删除标志查询品牌信息")
    @RequestMapping(value = "/brands/_find",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public SLPD0403IResult findBrands(@RequestBody SLPD0403IParam restRequest) {
        BaseRestPaginationResult<SlpdBrandResult> pagingResult = slpd0403IService.findBrandList(restRequest);
        SLPD0403IResult slpd0403IResult = BeanUtils.toBean(pagingResult, SLPD0403IResult.class);
        slpd0403IResult.setMessage(MessageUtils.getSuccessMessage());
        return slpd0403IResult;
    }

}
