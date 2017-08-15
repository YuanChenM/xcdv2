package com.bms.slpd.services.impl;

import com.bms.slpd.bean.entity.SlpdLogisticsAreaProduct;
import com.bms.slpd.bean.param.field.SLPD1201ILgcsAreaProduct;
import com.bms.slpd.bean.result.SLPD1201IResult;
import com.bms.slpd.constant.MessageConstant;
import com.bms.slpd.constant.TableConstant;
import com.bms.slpd.dao.SLPD1201IDao;
import com.bms.slpd.services.SLPD1201IService;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class SLPD1201IServiceImpl extends BaseServiceImpl implements SLPD1201IService {

    @Autowired
    private SLPD1201IDao slpd1201IDao;

    @Override
    public BaseDao getBaseDao() {
        return slpd1201IDao;
    }

    @Override
    public SLPD1201IResult saveLgcsCommodities(List<SLPD1201ILgcsAreaProduct> lgcsAreaCommodities) {
        Date crtTime = DateUtils.getCurrent();
        String crtId = super.getLoginUserId();
        SLPD1201IResult result = new SLPD1201IResult();

        //过滤已存在数据
        List<SLPD1201ILgcsAreaProduct> lgcsAreaCommodityList = this.dropExistData(lgcsAreaCommodities);
        if (CollectionUtils.isEmpty(lgcsAreaCommodityList)) {
            result.setMessages(new String[]{"数据已存在,新增失败"});
            return result;
        }
        //mapping新增的entity
        List<SlpdLogisticsAreaProduct> lacCommodities = BeanUtils.toList(lgcsAreaCommodityList, SlpdLogisticsAreaProduct.class);
        List<Long> lacIds = new ArrayList<>();
        for (SlpdLogisticsAreaProduct commodity : lacCommodities) {
            commodity.setLacId(this.maxId(TableConstant.Name.SLPD_LOGISTICS_AREA_PRODUCT));
            commodity.setCrtId(crtId);
            commodity.setCrtTime(crtTime);
            commodity.setUpdId(crtId);
            commodity.setUpdTime(crtTime);

            lacIds.add(commodity.getLacId());
        }
        int count = slpd1201IDao.saveLgcsCommodities(lacCommodities);

        result.setMessages(new String[]{MessageConstant.SUCCESS});
        result.setCount(count);
        result.setLacIds(lacIds);
        return result;
    }

    /**
     * 过滤已存在的物流区code和商品Id数据
     */
    private List<SLPD1201ILgcsAreaProduct> dropExistData(List<SLPD1201ILgcsAreaProduct> lgcsAreaCommodities) {
        List<SlpdLogisticsAreaProduct> existResult = this.slpd1201IDao.findExistLgcsCommodities(lgcsAreaCommodities);
        Iterator it = null;
        Long lgcsId = null;
        String productId = null;
        SLPD1201ILgcsAreaProduct sourceParam = null;

        for (SlpdLogisticsAreaProduct slpdLogisticsAreaProduct : existResult) {
            lgcsId = slpdLogisticsAreaProduct.getLgcsAreaId();
            productId = slpdLogisticsAreaProduct.getProductId();
            it = lgcsAreaCommodities.iterator();
            while (it.hasNext()) {
                sourceParam = (SLPD1201ILgcsAreaProduct)it.next();
                if (lgcsId.longValue() == sourceParam.getLgcsAreaId().longValue() && productId.equals(sourceParam.getProductId())) {
                    it.remove();
                }
            }
        }

        return lgcsAreaCommodities;
    }
}
