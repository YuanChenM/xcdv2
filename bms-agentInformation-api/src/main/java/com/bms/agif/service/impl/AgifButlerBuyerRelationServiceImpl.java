/*
 * 2017/03/01 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.agif.service.impl;

import com.alibaba.fastjson.TypeReference;
import com.bms.agif.bean.entity.AgifButlerBuyerRelation;
import com.bms.agif.bean.param.ButlerBuyerRelationRsPageParam;
import com.bms.agif.bean.param.ButlerRsParam;
import com.bms.agif.bean.param.BuyerAllRsParam;
import com.bms.agif.constant.ApiUrlDef;
import com.bms.agif.dao.AgifButlerBuyerRelationDao;
import com.bms.agif.service.AgifButlerBuyerRelationService;
import com.bms.agif.service.AgifButlerService;
import com.bms.common.rest.apiclient.RestApiClient;
import com.bms.common.rest.apiclient.RestApiClientFactory;
import com.framework.base.bean.Pagination;
import com.framework.base.rest.param.BaseRestPaginationParam;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.boot.plugin.configserver.properties.ConfigServerUtils;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.NumberUtils;
import com.framework.exception.BusinessException;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>AgifButlerBuyerRelationService接口实现类。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
@Service
public class AgifButlerBuyerRelationServiceImpl extends BaseServiceImpl implements AgifButlerBuyerRelationService {

    @Autowired
    private AgifButlerBuyerRelationDao AgifButlerBuyerRelationDao;
    @Autowired
    private RestApiClientFactory restApiClientFactory;
    @Autowired
    private AgifButlerService agifButlerService;

    @Override
    public BaseDao getBaseDao() {
        return AgifButlerBuyerRelationDao;
    }

    public <O extends Serializable, T extends BaseRestPaginationParam> BaseRestPaginationResult<O> findRelationPageList(T param) {
        BaseRestPaginationResult pageResult = new BaseRestPaginationResult();
        Page page;
        if (param == null) {
            page = PageHelper.startPage(0, 0, true, Boolean.valueOf(false), Boolean.valueOf(true));
        } else {
            Pagination data = param.getPagination();
            if (data == null) {
                page = PageHelper.startPage(0, 0, true, Boolean.valueOf(false), Boolean.valueOf(true));
            } else {
                page = PageHelper.startPage(data.getStartPos(), data.getPageSize(), true, Boolean.valueOf(false), Boolean.valueOf(true));
            }

            this.setSort(param.getSort());
        }

        List data1 = this.AgifButlerBuyerRelationDao.findRelationPageList(param);
        pageResult.setTotal(page.getTotal());
        if (page.getTotal() != 0L) {
            pageResult.setData(data1);
        } else {
            pageResult.setData(new ArrayList());
        }

        return pageResult;
    }

    public <O extends Serializable, T extends BaseRestPaginationParam> BaseRestPaginationResult<O> findBuyerButlerAgentPageList(T param) {
        BaseRestPaginationResult pageResult = new BaseRestPaginationResult();
        Page page;
        if (param == null) {
            page = PageHelper.startPage(0, 0, true, Boolean.valueOf(false), Boolean.valueOf(true));
        } else {
            Pagination data = param.getPagination();
            if (data == null) {
                page = PageHelper.startPage(0, 0, true, Boolean.valueOf(false), Boolean.valueOf(true));
            } else {
                page = PageHelper.startPage(data.getStartPos(), data.getPageSize(), true, Boolean.valueOf(false), Boolean.valueOf(true));
            }

            this.setSort(param.getSort());
        }

        List data1 = this.AgifButlerBuyerRelationDao.findBuyerButlerAgentPageList(param);
        pageResult.setTotal(page.getTotal());
        if (page.getTotal() != 0L) {
            pageResult.setData(data1);
        } else {
            pageResult.setData(new ArrayList());
        }

        return pageResult;
    }

    @Override
    public Integer buyerCount(ButlerBuyerRelationRsPageParam butlerBuyerRelationRsPageParam) {
        return this.AgifButlerBuyerRelationDao.buyerCount(butlerBuyerRelationRsPageParam);
    }


    @Override
    public int bing(List<ButlerBuyerRelationRsPageParam> pageParam) {
        Date currentDate = DateUtils.getCurrent();
        List<AgifButlerBuyerRelation> list = new ArrayList<>();
        int batchSaveCount = NumberUtils.INTEGER_ZERO;
        for (int i = 0, size = pageParam.size(); i < size; i++) {
            int count = getCount(pageParam.get(i));
            if (count != NumberUtils.INTEGER_ZERO) {
                return -1; //已经绑定过数据
            }
            int result = buyerCount(pageParam.get(i));
            if (result != NumberUtils.INTEGER_ZERO) {
                return -1; // 一个买家只能绑定一个管家
            }

            BuyerAllRsParam buyerAllParam = new BuyerAllRsParam();
            buyerAllParam.setBuyerId(pageParam.get(i).getBuyerId());
            String url = ConfigServerUtils.getAPIUrl(ApiUrlDef.BYIM_MODULE, ApiUrlDef.BUYER.buyerBasicSearch);
            RestApiClient restApiClient = restApiClientFactory.newApiRestClient();
            //根据买家ID查询买家信息
            BaseRestPaginationResult<BuyerAllRsParam> searchDataResult = restApiClient.post(url, buyerAllParam, new TypeReference<BaseRestPaginationResult<BuyerAllRsParam>>() {
            });

            ButlerRsParam butlerRsParam = new ButlerRsParam();
            butlerRsParam.setButlerId(pageParam.get(i).getButlerId());

//            BaseRestPaginationResult<ButlerRsParam> butlerList = agifButlerService.findPageList(butlerRsParam);
            List<ButlerRsParam> butlerList = agifButlerService.findList(butlerRsParam);


            if (("分销买家").equals(searchDataResult.getData().get(0).getBuyerTypeName()) ||
                    (("用户买家").equals(searchDataResult.getData().get(0).getBuyerTypeName())) &&
                            (("团膳买家").equals(searchDataResult.getData().get(0).getBuyerFirstCategoryName()) ||
                                    ("加工厂买家").equals(searchDataResult.getData().get(0).getBuyerFirstCategoryName())) ||
                    (searchDataResult.getData().get(0).getIsControlPuerchasngChain() != null && searchDataResult.getData().get(0).getIsControlPuerchasngChain())) {
                if (searchDataResult.getData().get(0).getDistributionId() == null) {
                    throw new BusinessException("agif", "AGIF.E04002");
                }

                if (CollectionUtils.isEmpty(butlerList)) {
                    throw new BusinessException("agif", "AGIF.E04006");
                }

                int x = NumberUtils.INTEGER_ZERO;
                int y = NumberUtils.INTEGER_ZERO;
                for (ButlerRsParam param : butlerList) {
                    if (param.getDistributionId() != null) {
                        if (searchDataResult.getData().get(0).getDistributionId().equals(param.getDistributionId())) {
                            x = NumberUtils.INTEGER_ONE;
                        }
                    } else {
                        y++;
                    }
                }

                if (x == NumberUtils.INTEGER_ZERO) {
                    throw new BusinessException("agif", "AGIF.E04001");
                }

                if (y == butlerList.size()) {
                    throw new BusinessException("agif", "AGIF.E04006");
                }


            }
            if (searchDataResult.getData().get(0).getIsControlPuerchasngChain() == null || !searchDataResult.getData().get(0).getIsControlPuerchasngChain()) {
                if (("菜场买家").equals(searchDataResult.getData().get(0).getBuyerTypeName()) ||
                        (("用户买家").equals(searchDataResult.getData().get(0).getBuyerTypeName())) &&
                                (("烧卤买家").equals(searchDataResult.getData().get(0).getBuyerFirstCategoryName()) ||
                                        ("餐饮买家").equals(searchDataResult.getData().get(0).getBuyerFirstCategoryName()))) {

                    if (searchDataResult.getData().get(0).getDistributionId() == null) {
                        throw new BusinessException("agif", "AGIF.E04002");
                    }
                    if (searchDataResult.getData().get(0).getDemesneId() == null) {
                        throw new BusinessException("agif", "AGIF.E04003");
                    }

                    if (CollectionUtils.isEmpty(butlerList)) {
                        throw new BusinessException("agif", "AGIF.E04006");
                    }

                    int x = NumberUtils.INTEGER_ZERO;
                    int y = NumberUtils.INTEGER_ZERO;
                    int z = NumberUtils.INTEGER_ZERO;
                    int k = NumberUtils.INTEGER_ZERO;
                    for (ButlerRsParam param : butlerList) {
                        if (param.getDistributionId() != null) {
                            if (searchDataResult.getData().get(0).getDistributionId().equals(param.getDistributionId())) {
                                x = NumberUtils.INTEGER_ONE;
                                if (param.getDemesneId() != null) {
                                    if (searchDataResult.getData().get(0).getDemesneId().equals(param.getDemesneId())) {
                                        z = NumberUtils.INTEGER_ONE;
                                    }
                                }
                            }

                        } else {
                            y++;
                        }
                        if (param.getDemesneId() == null) {
                            k++;
                        }

                    }

                    if (x == NumberUtils.INTEGER_ZERO) {
                        throw new BusinessException("agif", "AGIF.E04004");
                    }

                    if (y == butlerList.size()) {
                        throw new BusinessException("agif", "AGIF.E04006");
                    }
                    if (z == NumberUtils.INTEGER_ZERO) {
                        throw new BusinessException("agif", "AGIF.E04005");
                    }

                    if (k == butlerList.size()) {
                        throw new BusinessException("agif", "AGIF.E04007");
                    }

                }
            }

            AgifButlerBuyerRelation bean = BeanUtils.toBean(pageParam.get(i), AgifButlerBuyerRelation.class);
            Long maxId = maxId("AGIF_BUTLER_BUYER_RELATION");
            String loginUser = getLoginUserId();
            bean.setUpdTime(currentDate);
            bean.setCrtTime(currentDate);
            bean.setStartTime(currentDate);
            bean.setUpdId(loginUser);
            bean.setCrtId(loginUser);
            bean.setVersion(1);
            bean.setDelFlg(false);
            bean.setRelationId(maxId);
            list.add(bean);
            batchSaveCount = this.batchSave(list);
        }

        return batchSaveCount;
    }

    @Override
    public int unBind(List<ButlerBuyerRelationRsPageParam> paramList) {
        int count;
        int countAll = NumberUtils.INTEGER_ZERO;
        Date currentDate = DateUtils.getCurrent();
        for (int i = 0, size = paramList.size(); i < size; i++) {
            AgifButlerBuyerRelation bean = BeanUtils.toBean(paramList.get(i), AgifButlerBuyerRelation.class);
            String loginUser = getLoginUserId();
            bean.setUpdId(loginUser);
            bean.setUpdTime(currentDate);
            bean.setEndTime(currentDate);
            count = this.modify(bean);
            countAll += count;
        }
        return countAll;
    }
}