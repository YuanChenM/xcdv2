package com.bms.bymt.rest;

import com.bms.bymt.bean.entity.BymtMarketPicture;
import com.bms.bymt.bean.param.BaseBean;
import com.bms.bymt.bean.param.MarketPictureRsParam;
import com.bms.bymt.services.BymtMarketPictureService;
import com.bms.bymt.validator.PictureValidator;
import com.bms.bymt.validator.pictureAddAndUpdateValidator;
import com.framework.base.consts.NumberConst;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseRestController;
import com.framework.core.utils.BeanUtils;
import com.framework.validator.annotation.Validator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by guan_zhongheng on 2016/12/16.
 */
@RestController
@Api(value = "bms-bymt-api", description = "证件信息", position = 1, tags = "PictureRestController")
public class PictureRestController extends BaseRestController {

    Logger logger = LoggerFactory.getLogger(PictureRestController.class);

    @Autowired
    private BymtMarketPictureService bymtMarketPictureService;

    @ApiOperation(value = "addPictureInfo",
            notes = "证件信息查询")
    @RequestMapping(value = "/buyerMarket/picture/_search", method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = PictureValidator.class)
    public BaseRestPaginationResult<MarketPictureRsParam> searchPictureInfo(@RequestBody MarketPictureRsParam marketPictureParam) {
        BaseRestPaginationResult<MarketPictureRsParam> baseRestPaginationResult = new BaseRestPaginationResult<>();
        List<BymtMarketPicture> pictureList = bymtMarketPictureService.findList(marketPictureParam);
        if (pictureList.size() > NumberConst.IntDef.INT_ZERO) {
            baseRestPaginationResult.setData(BeanUtils.toList(pictureList, MarketPictureRsParam.class));
        }
        return baseRestPaginationResult;
    }

    @ApiOperation(value = "证件图片信息新增和修改", notes = "证件图片信息新增和修改")
    @RequestMapping(value = "/buyerMarket/picture/_update", method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = pictureAddAndUpdateValidator.class)
    public Integer updateAndInsertPicture(@RequestBody List<BaseBean<MarketPictureRsParam, MarketPictureRsParam>> param) {
        logger.info("证件图片信息新增和修改");
        Integer result = this.bymtMarketPictureService.updateAndSave(param);
        return result;
    }
}
