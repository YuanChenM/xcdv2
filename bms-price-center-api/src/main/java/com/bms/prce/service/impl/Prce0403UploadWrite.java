package com.bms.prce.service.impl;

import com.bms.prce.bean.param.PRCE0209IDetailParam;
import com.bms.prce.bean.param.PRCE0209IParam;
import com.bms.prce.bean.param.PRCE0403UploadDetailParam;
import com.bms.prce.service.PrcePricePlateDetailService;
import com.framework.boot.plugin.async.bean.param.AsyncUploadParam;
import com.framework.boot.plugin.async.service.impl.UploadExcelWriteImpl;
import com.framework.core.utils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by memorykai on 2017/5/7.
 */
@Service("prce0403Write")
public class Prce0403UploadWrite extends UploadExcelWriteImpl {
    private static final Logger logger = LoggerFactory.getLogger(Prce0403UploadWrite.class);

    @Autowired
    private PrcePricePlateDetailService pricePlateDetailService;

    @Override
    public <PRCE0403UploadParam> void toWriteData(List<PRCE0403UploadParam> list, AsyncUploadParam asyncUploadParam) {
        //定义接口参数
        List<PRCE0209IParam> prce0209IParams = new ArrayList<>();       //接口入参
        PRCE0209IParam prce0209IParam = null;
        com.bms.prce.bean.param.PRCE0403UploadParam uploadParam = null;
        List<PRCE0403UploadDetailParam> uploadPricePlateList = null;
        List<PRCE0209IDetailParam> pricePlateList = null;
        for (PRCE0403UploadParam param : list) {
            uploadParam = (com.bms.prce.bean.param.PRCE0403UploadParam) param;
            prce0209IParam = BeanUtils.toBean(uploadParam, PRCE0209IParam.class);
            uploadPricePlateList = uploadParam.getPricePlateList();
            pricePlateList = BeanUtils.toList(uploadPricePlateList, PRCE0209IDetailParam.class);
            prce0209IParam.setPricePlateList(pricePlateList);
            prce0209IParams.add(prce0209IParam);
        }

        //写入数据库
        pricePlateDetailService.modifyPricePlate(prce0209IParams);
    }
}
