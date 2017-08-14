/*
 * 2016/12/01 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.region.services.impl;

import com.bms.region.bean.entity.RegnLogisticsArea;
import com.bms.region.bean.param.BaseBean;
import com.bms.region.bean.param.LogisticsAreaRsParam;
import com.bms.region.bean.param.RegnCheckParam;
import com.bms.region.constant.MessageDef;
import com.bms.region.dao.RegnLogisticsAreaDao;
import com.bms.region.services.RegnCommonService;
import com.bms.region.services.RegnLogisticsAreaService;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.NumberUtils;
import com.framework.exception.BusinessException;
import com.framework.i18n.util.MessageManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * <p>RegnLogisticsAreaService接口实现类。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
@Service
public class RegnLogisticsAreaServiceImpl extends BaseServiceImpl implements RegnLogisticsAreaService {

    @Autowired
    private RegnLogisticsAreaDao regnLogisticsAreaDao;

    @Autowired
    private RegnCommonService regnCommonService;

    @Override
    public BaseDao getBaseDao() {
        return regnLogisticsAreaDao;
    }

    @Override
    public Integer checkedLgcsAreaId(LogisticsAreaRsParam param) {
        return regnLogisticsAreaDao.checkedLgcsAreaId(param);
    }

    @Override
    public void executeModify(List<BaseBean<LogisticsAreaRsParam, LogisticsAreaRsParam>> paramList) {
        int listSize = paramList.size();
        BaseBean<LogisticsAreaRsParam, RegnLogisticsArea> param;
        Date currentDate = DateUtils.getCurrent();
        for (int i = 0; i < listSize; i++) {
            param = new BaseBean<>();
            RegnLogisticsArea logisticsArea = BeanUtils.toBean(paramList.get(i).getTarget(), RegnLogisticsArea.class);
            logisticsArea.setUpdTime(currentDate);
            logisticsArea.setUpdId(this.getLoginUserId());
            param.setFilter(paramList.get(i).getFilter());
            param.setTarget(logisticsArea);

            // 优先验证其他系统是否已经使用
            HashMap<String,Long> checkParam = new HashMap<>();
            checkParam.put("lgcsAreaId",paramList.get(i).getFilter().getLgcsAreaId());
            regnCommonService.checkSystemUse(checkParam);

            int uCount = this.modify(param);
            if (uCount == NumberUtils.INTEGER_ZERO) {
                throw new BusinessException("region", MessageManager.getMessage(MessageDef.Error.E00008));
            }
        }
    }


    @Override
    public Integer executeBatchSave(List<List<RegnLogisticsArea>> paramList) {
        int listCount = paramList.size();
        int insertCount;
        int countAll = NumberUtils.INTEGER_ZERO;
        for (int i = 0; i < listCount; i++) {
            insertCount = batchSave(paramList.get(i));
            countAll += insertCount;
        }
        return countAll;
    }

    @Override
    public List<LogisticsAreaRsParam> checkData(LogisticsAreaRsParam param) {
        return regnLogisticsAreaDao.checkData(param);
    }
}