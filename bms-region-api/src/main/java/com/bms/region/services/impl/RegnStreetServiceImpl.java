/*
 * 2016/12/01 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.region.services.impl;

import com.bms.region.bean.entity.RegnStreet;
import com.bms.region.bean.param.BaseBean;
import com.bms.region.bean.param.RegnCheckParam;
import com.bms.region.bean.param.StreetRsParam;
import com.bms.region.dao.RegnStreetDao;
import com.bms.region.services.RegnCommonService;
import com.bms.region.services.RegnStreetService;
import com.bms.region.utils.RestCommUtil;
import com.framework.base.consts.NumberConst;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * <p>RegnStreetService接口实现类。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
@Service
public class RegnStreetServiceImpl extends BaseServiceImpl implements RegnStreetService {

    @Autowired
    private RegnStreetDao regnStreetDao;

    @Autowired
    private RegnCommonService regnCommonService;

    @Override
    public BaseDao getBaseDao() {
        return regnStreetDao;
    }

    /**
     * 批量新增街道信息
     *
     * @param streetParamList
     * @return
     */
    @Override
    public int saveStreetParamList(List<RegnStreet> streetParamList) {
        List<List<RegnStreet>> list = RestCommUtil.insertRanking(streetParamList);
        int result = NumberConst.IntDef.INT_ZERO;
        if (CollectionUtils.isNotEmpty(list)) {
            int listCount = list.size();
            for (int i = NumberConst.IntDef.INT_ZERO; i < listCount; i++) {
                int res = this.batchSave(list.get(i));
                result = result + res;
            }
        }
        return result;
    }

    /**
     * 批量修改街道信息
     *
     * @param streetParamList
     * @return
     */
    @Override
    public int modifyStreetParamList(List<BaseBean<StreetRsParam, StreetRsParam>> streetParamList) {
        Date currentDate = DateUtils.getCurrent();
        BaseBean<RegnStreet, RegnStreet> baseBean = new BaseBean<>();
        int listSize = streetParamList.size();
        int result = NumberConst.IntDef.INT_ZERO;
        for (int i = NumberConst.IntDef.INT_ZERO; i < listSize; i++) {
            StreetRsParam filter = streetParamList.get(i).getFilter();
            StreetRsParam target = streetParamList.get(i).getTarget();
            RegnStreet streetEntityFilter = BeanUtils.toBean(filter, RegnStreet.class);
            RegnStreet streetEntityTarget = BeanUtils.toBean(target, RegnStreet.class);
            streetEntityTarget.setUpdId(this.getLoginUserId());
            streetEntityTarget.setUpdTime(currentDate);
            baseBean.setFilter(streetEntityFilter);
            baseBean.setTarget(streetEntityTarget);

            // 优先验证其他系统是否已经使用
            HashMap<String,Long> checkParam = new HashMap<>();
            checkParam.put("streetId",streetEntityFilter.getStreetId());
            regnCommonService.checkSystemUse(checkParam);

            int res = this.modify(baseBean);
            result = result + res;
        }
        return result;
    }
}