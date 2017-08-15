package com.bms.slpd.services.impl;

import com.bms.slpd.bean.entity.SlpdLogisticsAreaProduct;
import com.bms.slpd.bean.param.SLPD1203IParam;
import com.bms.slpd.bean.param.field.SLPD1203ILgcsProductParam;
import com.bms.slpd.bean.result.SLPD1203IResult;
import com.bms.slpd.constant.MessageConstant;
import com.bms.slpd.dao.SLPD1203IDao;
import com.bms.slpd.services.SLPD1203IService;
import com.framework.base.consts.NumberConst;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.DateUtils;
import com.framework.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SLPD1203IServiceImpl extends BaseServiceImpl implements SLPD1203IService {

    @Autowired
    private SLPD1203IDao slpd1203IDao;

    @Override
    public BaseDao getBaseDao() {
        return slpd1203IDao;
    }

    @Override
    public SLPD1203IResult updateLgcsCommodities(SLPD1203IParam param) {
        List<SlpdLogisticsAreaProduct> entityList = this.mappingEntity(param);

        List<Long> lacIds = new ArrayList<>();
        int count = NumberConst.IntDef.INT_ZERO;
        for (SlpdLogisticsAreaProduct commodity : entityList) {
            int updCount = slpd1203IDao.updateLgcsCommodities(commodity);

            if (NumberConst.IntDef.INT_ZERO < updCount) {
                lacIds.add(commodity.getLacId());
                ++count;
            } else {
                throw new BusinessException(MessageConstant.MODULE_NAME_ZH, "物流区商品修改失败,请刷新页面重试!");
            }
        }

        SLPD1203IResult result = new SLPD1203IResult();
        result.setMessages(new String[]{MessageConstant.SUCCESS});
        result.setCount(count);
        result.setLacIds(lacIds);
        return result;
    }

    /**
     * mapping entity
     */
    private List<SlpdLogisticsAreaProduct> mappingEntity(SLPD1203IParam param) {
        Date updTime = DateUtils.getCurrent();
        String updId = super.getLoginUserId();

        List<SlpdLogisticsAreaProduct> entityList = new ArrayList<>();
        List<SLPD1203ILgcsProductParam> commodityParams = param.getLgcsCommodityParams();
        String shelfStu = param.getShelfStu();
        SlpdLogisticsAreaProduct commodity = null;
        for (SLPD1203ILgcsProductParam commodityParam : commodityParams) {
            commodity = BeanUtils.toBean(commodityParam, SlpdLogisticsAreaProduct.class);
            commodity.setShelfStu(shelfStu);
            commodity.setUpdTime(updTime);
            commodity.setUpdId(updId);
            entityList.add(commodity);
        }

        return entityList;
    }
}
