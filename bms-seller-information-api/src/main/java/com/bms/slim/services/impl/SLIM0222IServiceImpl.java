package com.bms.slim.services.impl;

import com.bms.slim.bean.entity.SlimProducerHonorCertificate;
import com.bms.slim.bean.entity.SlimProducerStorageCapacity;
import com.bms.slim.bean.param.SLIM0222IParam;
import com.bms.slim.bean.param.SLIM0231IParam;
import com.bms.slim.bean.param.field.SLIM0222ProducerHonorCertificateParam;
import com.bms.slim.bean.param.field.SLIM0231ProducerStorageCapacityParam;
import com.bms.slim.bean.result.SLIM0222IResult;
import com.bms.slim.constant.TableConstant;
import com.bms.slim.dao.SLIM0222IDao;
import com.bms.slim.dao.SLIM0231IDao;
import com.bms.slim.services.SLIM0222IService;
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
public class SLIM0222IServiceImpl extends BaseServiceImpl implements SLIM0222IService {

    @Autowired
    private SLIM0222IDao slim0222IDao;

    @Override
    public BaseDao getBaseDao() {
        return slim0222IDao;
    }

    /**
     * <p>局部常量类。</p>
     */
    private interface Macro {
        String PRODUCERHONORCERTIFICATES = "producerHonorCertificates";
        String HONORCERT_IDS = "honorCert_Ids";
    }

    @Override
    public SLIM0222IResult addProducerHonorCertificate(SLIM0222IParam slim0222IParam) {
        SLIM0222IResult result = new SLIM0222IResult();
        int count = NumberConst.IntDef.INT_ZERO;
        List<Long> honorCertIds = new ArrayList<>();
        Map<String,Object> resultMap = handelParam(slim0222IParam);
        if(MapUtils.isNotEmpty(resultMap)){
            List<SlimProducerHonorCertificate> producerHonorCertificates = (List<SlimProducerHonorCertificate>) resultMap.get(Macro.PRODUCERHONORCERTIFICATES);
            count = slim0222IDao.saveProducerHonorCertificates(producerHonorCertificates);
            honorCertIds = (List<Long>) resultMap.get(Macro.HONORCERT_IDS);
        }
        result.setCount(count);
        result.setHonorCertIds(honorCertIds);
        return result;
    }

    /**
     * 处理数据
     * @param slim0222IParam
     * @return
     */
    private Map<String,Object> handelParam(SLIM0222IParam slim0222IParam){
        //声明变量
        final String userId = super.getLoginUserId();
        final Date current = DateUtils.getCurrent();

        Map<String,Object> resultMap = new HashedMap();
        List<SLIM0222ProducerHonorCertificateParam> params = slim0222IParam.getProducerHonorCertificateParams();
        List<Long> honorCertIds = new ArrayList<>();
        List<SlimProducerHonorCertificate> producerHonorCertificates = new ArrayList<>();
        for(SLIM0222ProducerHonorCertificateParam param : params){
            SlimProducerHonorCertificate producerHonorCertificate = BeanUtils.toBean(param,SlimProducerHonorCertificate.class);
            Long honorCertId = this.maxId(TableConstant.Name.SLIM_PRODUCER_HONOR_CERTIFICATE);
            producerHonorCertificate.setHonorCertId(honorCertId);
            producerHonorCertificate.setCrtId(userId);
            producerHonorCertificate.setCrtTime(current);
            producerHonorCertificate.setUpdId(userId);
            producerHonorCertificate.setUpdTime(current);

            producerHonorCertificates.add(producerHonorCertificate);
            honorCertIds.add(honorCertId);
        }
        resultMap.put(Macro.HONORCERT_IDS,honorCertIds);
        resultMap.put(Macro.PRODUCERHONORCERTIFICATES,producerHonorCertificates);
        return  resultMap;
    }

}
