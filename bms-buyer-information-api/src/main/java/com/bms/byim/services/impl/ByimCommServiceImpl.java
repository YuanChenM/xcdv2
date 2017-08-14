/*
 * 2016/12/29 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.byim.services.impl;

import com.alibaba.fastjson.TypeReference;
import com.bms.byim.bean.param.CityLgcsAreaParam;
import com.bms.byim.constant.ApiUrlDef;
import com.bms.byim.services.ByimCommService;
import com.bms.common.rest.client.RestClient;
import com.bms.common.rest.client.RestClientFactory;
import com.framework.boot.plugin.configserver.properties.ConfigServerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>ByimBasicService接口实现类。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
@Service
public class ByimCommServiceImpl implements ByimCommService {
    @Autowired
    private RestClientFactory restClientFactory;
    /**
     * 查询城市信息物流区-城市
     * @param cityParam
     * @return
     */
    public  List<CityLgcsAreaParam> searchCityLgcs(CityLgcsAreaParam cityParam) {
        if (null == cityParam) {
            cityParam = new CityLgcsAreaParam();
        }
        //String url = ApiUrlDef.REGION_ENV + ApiUrlDef.REGION.cityLgcsSearch;
        String url = ConfigServerUtils.getAPIUrl(ApiUrlDef.REGN_MODULE,ApiUrlDef.REGION.cityLgcsSearch);
        RestClient restClient = restClientFactory.newRestClient();
        List<CityLgcsAreaParam> lgcsList = restClient.post(url, cityParam, new TypeReference<ArrayList<CityLgcsAreaParam>>() {
        });
        return lgcsList;
    }
}