/*
 * 2017/01/10 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.prce.service.impl;

import com.alibaba.fastjson.TypeReference;
import com.bms.common.rest.apiclient.RestApiClient;
import com.bms.common.rest.apiclient.RestApiClientFactory;
import com.bms.prce.bean.param.PRCE0210IDealParam;
import com.bms.prce.bean.param.PRCE0212IParam;
import com.bms.prce.bean.param.PRCE0214IParam;
import com.bms.prce.bean.result.PRCE0212IResult;
import com.bms.prce.dao.PrceProductInfoDao;
import com.bms.prce.dao.PrceProductInfoHistoryDao;
import com.bms.prce.service.PrceProductInfoService;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.boot.plugin.configserver.ConfigServerPropertyLoad;
import com.framework.boot.plugin.configserver.properties.ConfigServerUtils;
import com.framework.core.utils.DateUtils;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>PrceProductInfoService接口实现类。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
@Service
public class PrceProductInfoServiceImpl extends BaseServiceImpl implements PrceProductInfoService {

    @Autowired
    private PrceProductInfoHistoryDao productInfoHistoryDao;

    @Autowired
    private PrceProductInfoDao productInfoDao;

    @Autowired
    private RestApiClientFactory restClientFactory;

    @Override
    public BaseDao getBaseDao() {
        return productInfoDao;
    }

    /**
     * 商品同步
     */
    public int prceGoodsSync() {
        int syncCount = 0;
        // 获取卖家产品侧数据
        List<PRCE0212IResult> productInfos = getProductInfos();
        if (CollectionUtils.isNotEmpty(productInfos)) {
            // 备份数据
            PRCE0210IDealParam dealParam = new PRCE0210IDealParam();
            dealParam.setUpdTime(DateUtils.getCurrent());
            dealParam.setUpdId(super.getLoginUserId());
            productInfoHistoryDao.save(dealParam);
            // 删除数据
            productInfoDao.remove(new PRCE0212IParam());
            // 插入新获取的数据
            if (CollectionUtils.isNotEmpty(productInfos)) {
                int nn = 0;
                Date crtTime = DateUtils.getCurrent();
                for (int i = 0; i < productInfos.size(); i += 1000) {
                    nn = i + 1000;
                    if (nn > productInfos.size()) {
                        nn = productInfos.size();
                    }
                    syncCount += productInfoDao.batchInsert(productInfos.subList(i, nn));
                }
            }
        }
        return syncCount;
    }

    /**
     * 价盘删除
     */
    public int plateDelete(List<PRCE0214IParam> param) {
        int delCount = 0;
        Date current = DateUtils.getCurrent();
        if (CollectionUtils.isNotEmpty(param)){
            for (PRCE0214IParam prce0214IParam : param){
                PRCE0210IDealParam dealParam = new PRCE0210IDealParam();
                dealParam.setUpdId(super.getLoginUserId());
                dealParam.setUpdTime(current);
                dealParam.setGoodId(prce0214IParam.getGoodId());
                delCount += productInfoDao.modify(dealParam);
            }
        }
        PRCE0210IDealParam delParam = new PRCE0210IDealParam();
        delParam.setUpdId(super.getLoginUserId());
        delParam.setUpdTime(current);
        productInfoDao.deleteModify(delParam);
        return delCount;
    }

    /**
     * 获取卖家产品侧数据
     *
     * @return
     */
    private List<PRCE0212IResult> getProductInfos() {
        String url = ConfigServerUtils.getAPIUrl(ConfigServerPropertyLoad.getModelName("como-api"), "api/commodity/salelist/_search");
        RestApiClient restClient = restClientFactory.newApiRestClient();
        BaseRestPaginationResult<PRCE0212IResult> result = restClient.post(url, new PRCE0212IParam(), new TypeReference<BaseRestPaginationResult<PRCE0212IResult>>() {
        });
        if (result != null && CollectionUtils.isNotEmpty(result.getData())) {
            Date crtTime = DateUtils.getCurrent();
            for (PRCE0212IResult commodityResult : result.getData()) {
                commodityResult.setCrtId(super.getLoginUserId());
                commodityResult.setCrtTime(DateUtils.formatDateTime(crtTime));
            }
            return result.getData();
        }
        return null;
    }
}