package com.batch.prce.service.impl;

import com.alibaba.fastjson.TypeReference;
import com.batch.prce.bean.entity.PrceProductInfo;
import com.batch.prce.bean.param.BaseRestParam;
import com.batch.prce.bean.param.GoodSyncBParam;
import com.batch.prce.bean.result.PRCE0212IResult;
import com.batch.prce.dao.PRCE0101BDao;
import com.batch.prce.service.PRCE0101BService;
import com.bms.common.rest.batchclient.RestBatchClient;
import com.bms.common.rest.batchclient.RestBatchClientFactory;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.boot.plugin.configserver.ConfigServerPropertyLoad;
import com.framework.boot.plugin.configserver.properties.ConfigServerUtils;
import com.framework.core.utils.DateUtils;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by sunjiaju on 2017/2/16.
 */
@Service
public class PRCE0101BServiceImpl extends BaseServiceImpl implements PRCE0101BService {

    @Autowired
    private PRCE0101BDao prce0101BDao;

    @Autowired
    private RestBatchClientFactory restClientFactory;

    @Override
    public BaseDao getBaseDao() {
        return prce0101BDao;
    }

    /**
     * 同步商品数据
     *
     * @return
     */
    @Override
    public int goodsSync() {
        int syncCount = 0;
        // 获取卖家产品侧数据
        List<PrceProductInfo> productInfos = getProductInfos();
        if (CollectionUtils.isNotEmpty(productInfos)) {
            // 删除数据
            prce0101BDao.remove(new BaseRestParam());
            // 插入新获取的数据
            if (CollectionUtils.isNotEmpty(productInfos)) {
                int nn = 0;
                for (int i = 0; i < productInfos.size(); i += 500) {
                    nn = i + 500;
                    if (nn > productInfos.size()) {
                        nn = productInfos.size();
                    }
                    syncCount += prce0101BDao.batchInsert(productInfos.subList(i, nn));
                }
            }
        }
        return syncCount;
    }

    /**
     * 获取卖家产品侧数据
     *
     * @return
     */
    private List<PrceProductInfo> getProductInfos() {
        List<PrceProductInfo> results = new ArrayList<>();
        String url = ConfigServerUtils.getAPIUrl(ConfigServerPropertyLoad.getModelName("como-api"), "api/commodity/salelist/_search");
        RestBatchClient restClient = restClientFactory.newBatchRestClient();
        BaseRestPaginationResult<PRCE0212IResult> response = restClient.post(url, new GoodSyncBParam(), new TypeReference<BaseRestPaginationResult<PRCE0212IResult>>() {
        }, "PRCE0101B");
        if (response != null && CollectionUtils.isNotEmpty(response.getData())) {
            Date crtTime = DateUtils.getCurrent();
            for (PRCE0212IResult commodityResult : response.getData()) {
                PrceProductInfo productInfo = new PrceProductInfo();
                BeanUtils.copyProperties(commodityResult, productInfo);
                productInfo.setGoodId(commodityResult.getCommodityId());
                productInfo.setCrtId("PRCE0101B");
                productInfo.setCrtTime(crtTime);
                results.add(productInfo);
            }
        }
        return results;
    }

    /**
     * 获取需备份商品数据
     *
     * @return
     */
    @Override
    public List<PrceProductInfo> getBackUp() {
        List<PrceProductInfo> preProductInfos = prce0101BDao.findAll();
        for (PrceProductInfo productInfo : preProductInfos) {
            productInfo.setCrtId("PRCE0101B");
            productInfo.setCrtTime(DateUtils.getCurrent());
        }
        return preProductInfos;
    }
}
