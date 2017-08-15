package com.bms.slim.services.impl;

import com.bms.slim.bean.entity.SlimSellerBusinessQualification;
import com.bms.slim.bean.param.SLIM0104IParam;
import com.bms.slim.bean.param.field.SLIM0104ISBQParam;
import com.bms.slim.bean.result.SLIM0104IResult;
import com.bms.slim.constant.MessageConstant;
import com.bms.slim.constant.TableConstant;
import com.bms.slim.dao.SLIM0104IDao;
import com.bms.slim.services.SLIM0104IService;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SLIM0104IServiceImpl extends BaseServiceImpl implements SLIM0104IService {

    @Autowired
    private SLIM0104IDao slim0104IDao;

    @Override
    public BaseDao getBaseDao() {
        return slim0104IDao;
    }

    @Override
    public SLIM0104IResult addSellerBusinessQualifications(SLIM0104IParam param) {
        Date dateTime = DateUtils.getCurrent();
        String userId = super.getLoginUserId();
        List<SLIM0104ISBQParam> saveParam = param.getSbqParams();
        SlimSellerBusinessQualification slimSellerBusinessQualification = null;
        List<SlimSellerBusinessQualification> saveList = new ArrayList<>();
        List<Long> sbqIds = new ArrayList<>();
        List<Long> entityIds = new ArrayList<>();
        for (SLIM0104ISBQParam sbqParam : saveParam) {
            slimSellerBusinessQualification = BeanUtils.toBean(sbqParam, SlimSellerBusinessQualification.class);
            slimSellerBusinessQualification.setSbqId(this.maxId(TableConstant.Name.SLIM_SELLER_BUSINESS_QUALIFICATION));
            slimSellerBusinessQualification.setCrtId(userId);
            slimSellerBusinessQualification.setCrtTime(dateTime);
            slimSellerBusinessQualification.setUpdTime(dateTime);
            slimSellerBusinessQualification.setUpdId(userId);
            saveList.add(slimSellerBusinessQualification);
            sbqIds.add(slimSellerBusinessQualification.getSbqId());
            entityIds.add(sbqParam.getEntitySellerId());
        }
        SLIM0104IResult result = new SLIM0104IResult();
        List<SlimSellerBusinessQualification> existEntityList = slim0104IDao.findSellerEntityId(entityIds);
        if (CollectionUtils.isEmpty(existEntityList)) {
            int count = slim0104IDao.saveSBQs(saveList);
            result.setCount(count);
            result.setSbqIds(sbqIds);
            result.setMessages(new String[]{MessageConstant.SUCCESS});

        } else {
            StringBuilder existStr = new StringBuilder("卖家实体Id:");
            for (SlimSellerBusinessQualification sbq : existEntityList) {
                existStr.append(sbq.getEntitySellerId()).append(",");
            }
            existStr.append("已经存在,不能重复添加");
            result.setMessages(new String[]{MessageConstant.FAILURE,existStr.toString()});
        }
        return result;
    }
}
