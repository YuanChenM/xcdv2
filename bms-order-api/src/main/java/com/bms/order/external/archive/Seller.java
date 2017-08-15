package com.bms.order.external.archive;

import com.alibaba.fastjson.TypeReference;
import com.bms.order.constant.UrlConst;
import com.bms.order.constant.i18n.ErrorCode;
import com.bms.order.constant.i18n.ModuleCode;
import com.bms.order.external.bean.entity.SellerEntity;
import com.bms.order.external.bean.param.SLIM0250IRestParam;
import com.bms.order.external.bean.result.SLIM0I0250RestResult;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.exception.BusinessException;

import java.util.ArrayList;
import java.util.List;

/**
 * 买手
 * Created by ni_shaotang on 2017/3/15.
 */
public class Seller extends AbstractExternalArchive {

    private SellerEntity entity;

    /** 平台卖家Code */
    public static final String SELLER_CODE = "00000001";

    public SellerEntity getEntity() {
        return entity;
    }

    //禁止外部构建
    private Seller() {

    }

    /**
     * 查询卖家信息
     *
     * @return
     */
    public static List<Seller> getSellers(List<Long> sellerIds) {

        // 获取URL
        String url = UrlConst.API_SLIM_URL + UrlConst.ACTION_SLIM0250I;

        // 返回值类型
        TypeReference<BaseRestPaginationResult<SLIM0I0250RestResult>> typeReference = new TypeReference<BaseRestPaginationResult<SLIM0I0250RestResult>>() {
        };

        // 构造对象
        Seller seller = new Seller();
        List<Seller> sellers = new ArrayList<>();
        SLIM0250IRestParam param = new SLIM0250IRestParam();
        param.setEntitySellerIds(sellerIds);
        param.setRoleId("4");

        // 调用接口（使用关联对象的rest client）
        BaseRestPaginationResult<SLIM0I0250RestResult> paginationResult = seller.getRestClient().post(url, param,
                typeReference);

        if (paginationResult.getTotal() == 0)
            return sellers;

        // 获取买家信息
        for(SLIM0I0250RestResult result : paginationResult.getData()) {
            SellerEntity entity = new SellerEntity();
            entity.setSellerId(result.getEntitySellerId());
            entity.setSellerCode(result.getEntitySellerCode());
            entity.setSellerName(result.getFullName());

            seller.entity = entity;
            seller.setDataSynced(true);

            sellers.add(seller);
        }

        return sellers;
    }

    /**
     * 根据编码查询卖家信息
     *
     * @return
     */
    public static Seller getSellerByCode(String sellerCode) {

        // 获取URL
        String url = UrlConst.API_SLIM_URL + UrlConst.ACTION_SLIM0250I;

        // 返回值类型
        TypeReference<BaseRestPaginationResult<SLIM0I0250RestResult>> typeReference = new TypeReference<BaseRestPaginationResult<SLIM0I0250RestResult>>() {
        };

        // 构造对象
        Seller seller = new Seller();
        SLIM0250IRestParam param = new SLIM0250IRestParam();
        param.setEntitySellerCode(sellerCode);
        param.setRoleId("4");

        // 调用接口（使用关联对象的rest client）
        BaseRestPaginationResult<SLIM0I0250RestResult> paginationResult = seller.getRestClient().post(url, param,
                typeReference);

        if (paginationResult == null || paginationResult.getTotal() != 1)
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E060405, sellerCode);

        // 补全信息
        SLIM0I0250RestResult result = paginationResult.getData().get(0);
        SellerEntity entity = new SellerEntity();
        entity.setSellerId(result.getEntitySellerId());
        entity.setSellerCode(result.getEntitySellerCode());
        entity.setSellerName(result.getFullName());
        seller.entity = entity;
        seller.setDataSynced(true);

        return seller;
    }
}
