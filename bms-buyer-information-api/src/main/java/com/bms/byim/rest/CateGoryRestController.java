package com.bms.byim.rest;

import com.alibaba.fastjson.TypeReference;
import com.bms.byim.bean.entity.ByimCategory;
import com.bms.byim.bean.param.BaseBean;
import com.bms.byim.bean.param.BuyerAllRsParam;
import com.bms.byim.bean.param.BuyerPoolRsParam;
import com.bms.byim.bean.param.CategoryRsParam;
import com.bms.byim.bean.result.CategoryRsResult;
import com.bms.byim.constant.ApiUrlDef;
import com.bms.byim.services.ByimCategoryService;
import com.bms.byim.validator.CategoryAddValidator;
import com.bms.byim.validator.CategoryUpdateValidator;
import com.bms.common.rest.apiclient.RestApiClient;
import com.bms.common.rest.apiclient.RestApiClientFactory;
import com.framework.base.consts.NumberConst;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseRestController;
import com.framework.boot.plugin.configserver.properties.ConfigServerUtils;
import com.framework.core.db.DbUtils;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.NumberUtils;
import com.framework.core.utils.StringUtils;
import com.framework.exception.BusinessException;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by tao_zhifa on 2016/12/6.
 */
@RestController
@Api(value = "bms-byim-api", description = "买家分类增删改查", position = 1, tags = "CateGoryRestController")
public class CateGoryRestController extends BaseRestController {
    Logger logger = LoggerFactory.getLogger(CateGoryRestController.class);
    @Autowired
    private ByimCategoryService byimCategoryService;
    @Autowired
    private BuyerBuyerRestController buyerBasicRestController;
    @Autowired
    private RestApiClientFactory apiClientFactory;

    @ApiOperation(value = "买家分类增加", notes = "买家分类增加", position = 5)
    @RequestMapping(value = "/buyers/category/_add", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = CategoryAddValidator.class)
    public List<CategoryRsParam> addBuyersCategory(@RequestBody List<CategoryRsParam> param) {
        insertCheck(param);
        List<ByimCategory> byimCategoryList = BeanUtils.toList(param, ByimCategory.class);
        byimCategoryService.executeBatchSave(byimCategoryList);
        List<CategoryRsParam> categoryRsParamList;
        categoryRsParamList = BeanUtils.toList(param, CategoryRsParam.class);
        return categoryRsParamList;
    }


    @ApiOperation(value = "买家分类修改", notes = "买家分类修改", position = 5)
    @RequestMapping(value = "/buyers/category/_modify", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = CategoryUpdateValidator.class)
    public List<CategoryRsParam> modifyBuyersCategory(@RequestBody List<BaseBean<CategoryRsParam, CategoryRsParam>> paramList) {
        logger.info("买家分类修改");
        int beansSize = paramList.size();
        Map<String, String> map = new HashMap<>();
        List<BaseBean<ByimCategory, ByimCategory>> baseBeanList = new ArrayList<>();
        for (int i = 0; i < beansSize; i++) {

            //验证买家分类是否使用
            CategoryRsParam param = new CategoryRsParam();
            param.setCategoryId(paramList.get(i).getFilter().getCategoryId());
            List<CategoryRsParam> category = findBuyersCategoryList(param);
            String[] args = category.get(0).getNodePath().split(",");
            BaseRestPaginationResult<BuyerAllRsParam> searchDataResult = null;
            BaseRestPaginationResult<BuyerPoolRsParam> buyerPoolRelationShip = null;
            BuyerAllRsParam buyerAllParam;
            if (args.length == NumberConst.IntDef.INT_ONE) {
                buyerAllParam = new BuyerAllRsParam();
                buyerAllParam.setBuyerType(category.get(0).getCategoryCode());
                searchDataResult = buyerBasicRestController.search(buyerAllParam);

                BuyerPoolRsParam buyerPoolRsParam = new BuyerPoolRsParam();
                buyerPoolRsParam.setBuyerType(category.get(0).getCategoryCode());
                buyerPoolRelationShip = findBuyerPoolRelationShip(buyerPoolRsParam);
            }
            if (args.length == NumberConst.IntDef.INT_TWO) {
                param = new CategoryRsParam();
                param.setCategoryId(NumberUtils.toLong(args[0]));
                List<CategoryRsParam> buyerTypeList = findBuyersCategoryList(param);

                buyerAllParam = new BuyerAllRsParam();
                buyerAllParam.setBuyerType(buyerTypeList.get(0).getCategoryCode());
                buyerAllParam.setBuyerFirstCategory(category.get(0).getCategoryCode());
                searchDataResult = buyerBasicRestController.search(buyerAllParam);

                BuyerPoolRsParam buyerPoolRsParam = new BuyerPoolRsParam();
                buyerPoolRsParam.setBuyerType(buyerTypeList.get(0).getCategoryCode());
                buyerPoolRsParam.setBuyerFirstCategory(category.get(0).getCategoryCode());
                buyerPoolRelationShip = findBuyerPoolRelationShip(buyerPoolRsParam);
            }
            if (args.length == NumberConst.IntDef.INT_THREE) {
                param = new CategoryRsParam();
                param.setCategoryId(NumberUtils.toLong(args[0]));
                List<CategoryRsParam> buyerTypeList = findBuyersCategoryList(param);

                param = new CategoryRsParam();
                param.setCategoryId(NumberUtils.toLong(args[1]));
                List<CategoryRsParam> buyersFirstCategoryList = findBuyersCategoryList(param);

                buyerAllParam = new BuyerAllRsParam();
                buyerAllParam.setBuyerType(buyerTypeList.get(0).getCategoryCode());
                buyerAllParam.setBuyerFirstCategory(buyersFirstCategoryList.get(0).getCategoryCode());
                buyerAllParam.setBuyerSubCategory(category.get(0).getCategoryCode());
                searchDataResult = buyerBasicRestController.search(buyerAllParam);

                BuyerPoolRsParam buyerPoolRsParam = new BuyerPoolRsParam();
                buyerPoolRsParam.setBuyerType(buyerTypeList.get(0).getCategoryCode());
                buyerPoolRsParam.setBuyerFirstCategory(buyersFirstCategoryList.get(0).getCategoryCode());
                buyerPoolRsParam.setBuyerSubCategory(category.get(0).getCategoryCode());
                buyerPoolRelationShip = findBuyerPoolRelationShip(buyerPoolRsParam);
            }

            if (searchDataResult != null && searchDataResult.getTotal() != NumberUtils.INTEGER_ZERO) {
                return null;
            }
            if (buyerPoolRelationShip != null && buyerPoolRelationShip.getTotal() != NumberUtils.INTEGER_ZERO) {
                return null;
            }

            BaseBean<ByimCategory, ByimCategory> bean = new BaseBean<>();
            ByimCategory filter = BeanUtils.toBean(paramList.get(i).getFilter(), ByimCategory.class);
            ByimCategory target = BeanUtils.toBean(paramList.get(i).getTarget(), ByimCategory.class);
            bean.setFilter(filter);
            bean.setTarget(target);
            if (!StringUtils.isEmpty(paramList.get(i).getTarget().getCategoryCode())) {
                if (map.size() != NumberUtils.INTEGER_ZERO) {
                    if (!StringUtils.isEmpty(map.get(paramList.get(i).getTarget().getCategoryCode()))) {
                        return null;
                    } else {
                        map.put(paramList.get(i).getTarget().getCategoryCode(), i + "");
                    }
                } else {
                    map.put(paramList.get(i).getTarget().getCategoryCode(), i + "");
                }
            }

            int checkedCategoryId = byimCategoryService.checkedCategoryId(paramList.get(i).getFilter());
            if (checkedCategoryId != NumberConst.IntDef.INT_ZERO) {
                if (!StringUtils.isEmpty(bean.getTarget().getCategoryCode())) {
                    ByimCategory parentIdCate = byimCategoryService.findOne(bean.getFilter());
                    if (parentIdCate == null || parentIdCate.getParentId() == null) {
                        return null;
                    }
                    bean.getTarget().setParentId(parentIdCate.getParentId());
                    int counts = byimCategoryService.getCount(bean.getTarget());
                    if (counts != NumberUtils.INTEGER_ZERO) {
                        ByimCategory byimCategory = byimCategoryService.findByByimCategoryCode(bean.getTarget());
                        if (!byimCategory.getCategoryId().equals(bean.getFilter().getCategoryId())) {
                            return null;
                        }
                    }
                }
                baseBeanList.add(bean);
            } else {
                return null;
            }

        }
        List<CategoryRsParam> longList = byimCategoryService.executeModify(baseBeanList);
        if (CollectionUtils.isEmpty(longList)) {
            return null;
        }
        return longList;
    }


    @ApiOperation(value = "查询树状结构买家分类", notes = "查询树状结构买家分类", position = 5)
    @RequestMapping(value = "/buyers/category/tree/_search", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<CategoryRsParam> findBuyersCategoryTree(@RequestBody CategoryRsParam param) {
        logger.info("查询树状结构买家分类");
        CategoryRsResult categoryRsResult = new CategoryRsResult();
        String str = param.getNodePath().substring(param.getNodePath().length() - 1, param.getNodePath().length());
        CategoryRsParam categoryRsParam = new CategoryRsParam();
        if (",".equals(str)) {
            categoryRsParam.setNodePathLike(DbUtils.buildLikeCondition(param.getNodePath(), DbUtils.LikeMode.FRONT));
        } else {
            categoryRsParam.setNodePath(param.getNodePath());
            categoryRsParam.setNodePathLike(DbUtils.buildLikeCondition(param.getNodePath()+",", DbUtils.LikeMode.FRONT));
        }
        List<CategoryRsParam> categoryRsParamList = byimCategoryService.findList(categoryRsParam);
        List<CategoryRsParam> returnList = createTree(categoryRsParamList);
        categoryRsResult.setCategoryRsParamList(returnList);
        return returnList;
    }


    @ApiOperation(value = "查询列表结构买家分类", notes = "查询列表结构买家分类", position = 5)
    @RequestMapping(value = "/buyers/category/list/_search", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<CategoryRsParam> findBuyersCategoryList(@RequestBody CategoryRsParam param) {
        param.setCategoryCode(DbUtils.buildLikeCondition(param.getCategoryCode(), DbUtils.LikeMode.PARTIAL));
        param.setCategoryName(DbUtils.buildLikeCondition(param.getCategoryName(), DbUtils.LikeMode.PARTIAL));
        List<CategoryRsParam> categoryRsParamList = byimCategoryService.findListInfo(param);
        return categoryRsParamList;
    }

    /**
     * 将DB中存储的数据,转换成树状返回
     *
     * @param paramList
     * @return
     */
    public List<CategoryRsParam> createTree(List<CategoryRsParam> paramList) {
        List<CategoryRsParam> returnList = new ArrayList<>();
        if (paramList != null) {
            for (CategoryRsParam cateGoryParam : paramList) {
                boolean flag = false;
                for (CategoryRsParam categoryRsParamChildren : paramList) {
                    if (cateGoryParam.getParentId() != null && (cateGoryParam.getParentId().equals(categoryRsParamChildren.getCategoryId()))) {
                        flag = true;
                        if (categoryRsParamChildren.getCategoryList() == null) {
                            categoryRsParamChildren.setCategoryList(new ArrayList<CategoryRsParam>());
                        }
                        categoryRsParamChildren.getCategoryList().add(cateGoryParam);
                        break;
                    }
                }
                if (!flag) {
                    returnList.add(cateGoryParam);
                }
            }
        }
        return returnList;
    }


    /**
     * 1.买家分类新增判断在同一级别下code存在问题和name存在问题
     * 2.将买家分类notePath赋值并且组装成list返回
     *
     * @param paramList
     * @return
     */
    public void insertCheck(List<CategoryRsParam> paramList) {
        int beansSize = paramList.size();
        String[] args;
        Map<String, String> map = new HashMap<>();
        Map<String, String> nameMap = new HashMap<>();
        for (int j = 0; j < beansSize; j++) {
            if (map.size() != NumberUtils.INTEGER_ZERO) {
                if (!StringUtils.isEmpty(map.get(paramList.get(j).getCategoryCode()))) {
//                    args = new String[]{StringUtils.toString(j + 1), MessageManager.getMessage(MessageDef.Label.L00004)};
                    throw new BusinessException("BY", "BYIM.E00016");
                } else {
                    if(!StringUtils.isEmpty(paramList.get(j).getCategoryCode())){
                        map.put(paramList.get(j).getCategoryCode(), j + "");
                    }
                }
            } else {
                if(!StringUtils.isEmpty(paramList.get(j).getCategoryCode())) {
                    map.put(paramList.get(j).getCategoryCode(), j + "");
                }
            }
            int count = byimCategoryService.getCount(paramList.get(j));
            if (count != NumberUtils.INTEGER_ZERO) {
//                args = new String[]{StringUtils.toString(j + 1), MessageManager.getMessage(MessageDef.Label.L00004)};
                throw new BusinessException("BY", "BYIM.E00016");
            }


            if (nameMap.size() != NumberUtils.INTEGER_ZERO) {
                if (!StringUtils.isEmpty(nameMap.get(paramList.get(j).getCategoryName()))) {
//                    args = new String[]{StringUtils.toString(j + 1), MessageManager.getMessage(MessageDef.Label.L00003)};
                    throw new BusinessException("BY", "BYIM.E00017");
                } else {
                    if(!StringUtils.isEmpty(paramList.get(j).getCategoryName())){
                        nameMap.put(paramList.get(j).getCategoryName(), j + "");
                    }
                }
            } else {
                if(!StringUtils.isEmpty(paramList.get(j).getCategoryName())){
                    nameMap.put(paramList.get(j).getCategoryName(), j + "");
                }
            }
            int nameCount = byimCategoryService.nameCount(paramList.get(j));
            if (nameCount != NumberUtils.INTEGER_ZERO) {
//                args = new String[]{StringUtils.toString(j + 1), MessageManager.getMessage(MessageDef.Label.L00003)};
                throw new BusinessException("BY", "BYIM.E00017");
            }

        }
    }

    /**
     * 查询买家池接口
     *
     * @param buyerPoolRsParam
     * @return
     */
    public BaseRestPaginationResult<BuyerPoolRsParam> findBuyerPoolRelationShip(BuyerPoolRsParam buyerPoolRsParam) {
//        String url = "http://localhost:8091/bms-bypo-api/api/buyerPool/_search";
        String url = ConfigServerUtils.getAPIUrl(ApiUrlDef.BYPO_MODULE, ApiUrlDef.BUYERPOOL.buyerPoolSearch);
        RestApiClient restApiClient = apiClientFactory.newApiRestClient();
        BaseRestPaginationResult<BuyerPoolRsParam> response;
        response = restApiClient.post(url, buyerPoolRsParam,
                new TypeReference<BaseRestPaginationResult<BuyerPoolRsParam>>() {
                });

        return response;
    }
}

