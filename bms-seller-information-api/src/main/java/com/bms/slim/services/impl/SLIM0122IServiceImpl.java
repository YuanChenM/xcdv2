package com.bms.slim.services.impl;

import com.bms.slim.bean.entity.SlimSeller;
import com.bms.slim.bean.param.SLIM0122IParam;
import com.bms.slim.bean.param.field.SLIM0122SellerParam;
import com.bms.slim.bean.result.SLIM0122IResult;
import com.bms.slim.constant.TableConstant;
import com.bms.slim.dao.SLIM0122IDao;
import com.bms.slim.services.SLIM0122IService;
import com.framework.base.consts.NumberConst;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.DateUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class SLIM0122IServiceImpl extends BaseServiceImpl implements SLIM0122IService {

    @Autowired
    private SLIM0122IDao slim0122IDao;

    @Override
    public BaseDao getBaseDao() {
        return slim0122IDao;
    }

    /**
     * <p>局部常量类。</p>
     */
    private interface Macro {
        String SELLERS = "sellers";
        String SELLER_IDS = "seller_ids";
    }

    @Override
    public SLIM0122IResult addSellers(SLIM0122IParam slim0122IParam) {
        SLIM0122IResult result = new SLIM0122IResult();
        int count = NumberConst.IntDef.INT_ZERO;
        List<Long> sellerIds = new ArrayList<>();
        Map<String, Object> resultMap = handelParam(slim0122IParam);
        if (MapUtils.isNotEmpty(resultMap)) {
            List<SlimSeller> sellers = (List<SlimSeller>) resultMap.get(Macro.SELLERS);
            count = slim0122IDao.saveSellers(sellers);
            sellerIds = (List<Long>) resultMap.get(Macro.SELLER_IDS);
        }
        result.setCount(count);
        result.setSellerIds(sellerIds);
        return result;
    }

    /**
     * 处理数据
     *
     * @param slim0122IParam
     * @return
     */
    private Map<String, Object> handelParam(SLIM0122IParam slim0122IParam) {
        //声明变量
//        final String userId = super.getLoginUserId();
        /** test start **/
        String userId = "1";
        /** test end **/
        final Date current = DateUtils.getCurrent();

        Map<String, Object> resultMap = new HashedMap();
        List<SLIM0122SellerParam> params = slim0122IParam.getSellerParams();
        List<Long> sellerIds = new ArrayList<>();
        List<SlimSeller> sellers = new ArrayList<>();
        for (SLIM0122SellerParam param : params) {
            SlimSeller slimSeller = BeanUtils.toBean(param, SlimSeller.class);
            Long sellerId = this.maxId(TableConstant.Name.SLIM_SELLER);
            slimSeller.setSellerId(sellerId);
            slimSeller.setSellerCode(generateSellerCode(sellerId));
            slimSeller.setCrtId(userId);
            slimSeller.setCrtTime(current);
            slimSeller.setUpdId(userId);
            slimSeller.setUpdTime(current);

            sellers.add(slimSeller);
            sellerIds.add(sellerId);
        }
        resultMap.put(Macro.SELLER_IDS, sellerIds);
        resultMap.put(Macro.SELLERS, sellers);
        return resultMap;
    }

    public String generateSellerCode(Long sellerId) {
        return String.format("%08d", sellerId);
    }
}
