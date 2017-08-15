package com.bms.order.external.archive;

import com.alibaba.fastjson.TypeReference;
import com.bms.order.constant.UrlConst;
import com.bms.order.constant.i18n.ErrorCode;
import com.bms.order.constant.i18n.ModuleCode;
import com.bms.order.external.bean.param.REGN0102IRestParam;
import com.bms.order.external.bean.result.REGN0102IRestResult;
import com.framework.core.utils.CollectionUtils;
import com.framework.exception.BusinessException;

import java.util.ArrayList;
import java.util.List;

/**
 * 物流区
 * 
 * @author li_huiqian
 *
 */
public class Logistics extends AbstractExternalArchive {
    private Logistics() {
    }

    /**
     * 获取物流区
     * 
     * @return
     */
    public static REGN0102IRestResult findLogisticsByCode(String lgcsAreaCode) {
        // 获取URL
        String url = UrlConst.API_REGION_URL + UrlConst.ACTION_REGN0102I;

        // 构造入参
        REGN0102IRestParam param = new REGN0102IRestParam();
        param.setDelFlg(false);
        param.setLgcsAreaCode(lgcsAreaCode);
        // 返回值类型
        TypeReference<ArrayList<REGN0102IRestResult>> typeReference = new TypeReference<ArrayList<REGN0102IRestResult>>() {
        };

        // 构造对象
        Logistics temp = new Logistics();
        // 调用接口
        List<REGN0102IRestResult> results = temp.getRestClient().post(url, param, typeReference);

        if (CollectionUtils.isEmpty(results) || results.size() != 1)
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000002, "通过一个物流区Code不能确定物流区信息");

        return results.get(0);
    }
}
