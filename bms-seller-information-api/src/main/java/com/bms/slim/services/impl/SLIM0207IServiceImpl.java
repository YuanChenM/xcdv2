package com.bms.slim.services.impl;

import com.bms.slim.bean.entity.SlimDesignatSlaughterPermit;
import com.bms.slim.bean.param.SLIM0207IParam;
import com.bms.slim.bean.param.field.SLIM0207DesignatSlaughterPermitParam;
import com.bms.slim.bean.result.SLIM0207IResult;
import com.bms.slim.constant.TableConstant;
import com.bms.slim.dao.SLIM0207IDao;
import com.bms.slim.services.SLIM0207IService;
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
public class SLIM0207IServiceImpl extends BaseServiceImpl implements SLIM0207IService {

    @Autowired
    private SLIM0207IDao slim0207IDao;

    @Override
    public BaseDao getBaseDao() {
        return slim0207IDao;
    }

    /**
     * <p>局部常量类。</p>
     */
    private interface Macro {
        String DSP_IDS = "dsp_ids";
        String DESIGNAT_SLAUGHTER_PERMIT = "designatSlaughterPermit";
    }

    @Override
    public SLIM0207IResult saveDesignatSlaughterPermits(SLIM0207IParam slim0207IParam) {
        SLIM0207IResult result = new SLIM0207IResult();
        int count = NumberConst.IntDef.INT_ZERO;
        List<Long> dspIds = new ArrayList<>();
        Map<String, Object> resultMap = handelParam(slim0207IParam);
        if(MapUtils.isNotEmpty(resultMap)){
            List<SlimDesignatSlaughterPermit> designatSlaughterPermits = (List<SlimDesignatSlaughterPermit>) resultMap.get(Macro.DESIGNAT_SLAUGHTER_PERMIT);
            count = slim0207IDao.saveDesignatSlaughterPermits(designatSlaughterPermits);
            dspIds = (List<Long>) resultMap.get(Macro.DSP_IDS);
        }
        result.setCount(count);
        result.setDspIds(dspIds);
        return result;
    }

    /**
     * 处理数据
     *
     * @param slim0207IParam
     * @return
     */
    private Map<String, Object> handelParam(SLIM0207IParam slim0207IParam) {
        //声明变量
//        final String userId = super.getLoginUserId();
        final String userId = "1";
        final Date current = DateUtils.getCurrent();

        Map<String,Object> resultMap = new HashedMap();
        List<SLIM0207DesignatSlaughterPermitParam> params = slim0207IParam.getSlim0207DesignatSlaughterPermitParams();
        List<Long> dspIds = new ArrayList<>();
        List<SlimDesignatSlaughterPermit> designatSlaughterPermits = new ArrayList<>();
        for(SLIM0207DesignatSlaughterPermitParam param : params){
            SlimDesignatSlaughterPermit designatSlaughterPermit = BeanUtils.toBean(param, SlimDesignatSlaughterPermit.class);
            Long dspId = this.maxId(TableConstant.Name.SLIM_DESIGNAT_SLAUGHTER_PERMIT);
            designatSlaughterPermit.setDspId(dspId);
            designatSlaughterPermit.setCrtId(userId);
            designatSlaughterPermit.setCrtTime(current);
            designatSlaughterPermit.setUpdId(userId);
            designatSlaughterPermit.setUpdTime(current);

            designatSlaughterPermits.add(designatSlaughterPermit);
            dspIds.add(dspId);
        }
        resultMap.put(Macro.DSP_IDS,dspIds);
        resultMap.put(Macro.DESIGNAT_SLAUGHTER_PERMIT,designatSlaughterPermits);
        return  resultMap;
    }

}
