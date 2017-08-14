package com.bms.bypo.rest;

import com.bms.bypo.bean.entity.BypoStandardProduct;
import com.bms.bypo.bean.param.BaseBean;
import com.bms.bypo.bean.param.StandardProductRsParam;
import com.bms.bypo.constant.MessageDef;
import com.bms.bypo.services.BypoStandardProductService;
import com.bms.bypo.validator.StandardProductAddValidator;
import com.bms.bypo.validator.StandardProductModifyValidator;
import com.framework.base.consts.NumberConst;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseRestController;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.StringUtils;
import com.framework.exception.BusinessException;
import com.framework.i18n.util.MessageManager;
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

import java.util.Date;
import java.util.List;

/**
 * Created by zhang_jian4 on 2017/01/04.
 */
@RestController
@Api(value = "bms-bypo-api",
        description = "分类买家池标准产品池",
        position = 1,
        tags = "StandardProductRestController")
public class StandardProductRestController extends BaseRestController {
    Logger logger = LoggerFactory.getLogger(StandardProductRestController.class);
    @Autowired
    private BypoStandardProductService standardProductService;

    @ApiOperation(value = "分类买家池标准产品池查询", notes = "分类买家池标准产品池查询")
    @RequestMapping(value = "/buyerPool/products/_search",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public BaseRestPaginationResult<StandardProductRsParam> searchStandardProduct(@RequestBody StandardProductRsParam rsParam) {
        String[] args = new String[]{MessageManager.getMessage(MessageDef.Label.L00040)};
        String[] returnMessage = null;
        String message = null;
        logger.info("分类买家池标准产品池查询开始");
        BaseRestPaginationResult<StandardProductRsParam> pageList = this.standardProductService.findPageList(rsParam);
        if ((pageList == null || CollectionUtils.isEmpty(pageList.getData())) && StringUtils.isNotEmpty(rsParam.getModifyFlg())) {
            //有品牌无生产商
            rsParam.setModifyFlg("2");
            pageList = this.standardProductService.findStandardProduct(rsParam);
            if (CollectionUtils.isEmpty(pageList.getData())) {
                //无品牌有生产商
                rsParam.setModifyFlg("3");
                pageList = this.standardProductService.findStandardProduct(rsParam);
                if (CollectionUtils.isEmpty(pageList.getData())) {
                    //无品牌和生产商
                    rsParam.setModifyFlg("1");
                    pageList = this.standardProductService.findStandardProduct(rsParam);
                }
            }
        }
        return pageList;
    }

    @ApiOperation(value = "分类买家池标准产品池新增", notes = "分类买家池标准产品池新增")
    @RequestMapping(value = "/buyerPool/products/_add",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = StandardProductAddValidator.class)
    public Integer addStandardProduct(@RequestBody List<StandardProductRsParam> standardProductRsParamList) {
        StandardProductRsParam standardProductRsParam = null;
        BypoStandardProduct standardProduct = null;
        Date currentDate = DateUtils.getCurrent();
        int result = NumberConst.IntDef.INT_ZERO;
        if (CollectionUtils.isNotEmpty(standardProductRsParamList)) {
            String loginUserId = this.standardProductService.getLoginUserId();
            standardProductRsParam = standardProductRsParamList.get(NumberConst.IntDef.INT_ZERO);
            int standardProductIsExist = standardProductService.standardProductIsExist(standardProductRsParam);
            if (standardProductIsExist > NumberConst.IntDef.INT_ZERO) {
                throw new BusinessException("bypo", "BYPO.E00005");
            } else {
                standardProduct = BeanUtils.toBean(standardProductRsParam, BypoStandardProduct.class);
                Long standardProductId = this.standardProductService.maxId("BYPO_STANDARD_PRODUCT");
                standardProduct.setStandardProductId(standardProductId);
                standardProduct.setDelFlg(false);
                standardProduct.setUpdId(loginUserId);
                standardProduct.setUpdTime(currentDate);
                standardProduct.setCrtId(loginUserId);
                standardProduct.setCrtTime(currentDate);
                standardProduct.setVersion(NumberConst.IntDef.INT_ONE);
                logger.info("分类买家池标准产品池新增开始");
                result = this.standardProductService.save(standardProduct);
            }
        }
        return result;

    }


    @ApiOperation(value = "分类买家池标准产品池修改", notes = "分类买家池标准产品池修改")
    @RequestMapping(value = "/buyerPool/products/_update",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = StandardProductModifyValidator.class)
    public Integer modifyStandardProduct(@RequestBody BaseBean<StandardProductRsParam, StandardProductRsParam> baseBean) {
        StandardProductRsParam standardProductParamFilter = baseBean.getFilter();
        StandardProductRsParam standardProductParamTarget = baseBean.getTarget();
        BypoStandardProduct bypoStandardProductFilter = BeanUtils.toBean(standardProductParamFilter, BypoStandardProduct.class);
        BypoStandardProduct bypoStandardProductTarget = BeanUtils.toBean(standardProductParamTarget, BypoStandardProduct.class);
        int standardProductIsExist = standardProductService.standardProductIsExist(standardProductParamTarget);
        if (standardProductIsExist > NumberConst.IntDef.INT_ZERO) {
            throw new BusinessException("bypo", "BYPO.E00005");
        } else {
            // 判断是否存在(更新、逻辑删除不需要)
            BaseBean<BypoStandardProduct, BypoStandardProduct> bypoStandardProductBaseBean = new BaseBean<>();
            Date currentDate = DateUtils.getCurrent();
            bypoStandardProductTarget.setUpdId(standardProductService.getLoginUserId());
            bypoStandardProductTarget.setUpdTime(currentDate);
            bypoStandardProductBaseBean.setFilter(bypoStandardProductFilter);
            bypoStandardProductBaseBean.setTarget(bypoStandardProductTarget);
            logger.info("分类买家池标准产品池修改开始");
            int result = this.standardProductService.modify(bypoStandardProductBaseBean);
            return result;
        }
    }
}
