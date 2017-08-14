/*
 * 2016/12/14 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.bymt.services.impl;

import com.bms.bymt.bean.entity.BymtTerminalMarketNotarget;
import com.bms.bymt.bean.param.BaseBean;
import com.bms.bymt.bean.param.TerminalMarketNotargetRsParam;
import com.bms.bymt.dao.BymtTerminalMarketNotargetDao;
import com.bms.bymt.services.BymtTerminalMarketNotargetService;
import com.bms.bymt.utils.RestCommUtil;
import com.framework.base.consts.NumberConst;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>BymtTerminalMarketNotargetService接口实现类。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
@Service
public class BymtTerminalMarketNotargetServiceImpl extends BaseServiceImpl implements BymtTerminalMarketNotargetService {

    @Autowired
    private BymtTerminalMarketNotargetDao bymtTerminalMarketNotargetDao;

    @Override
    public BaseDao getBaseDao() {
        return bymtTerminalMarketNotargetDao;
    }

    @Override
    public int saveMarketNotargetList(List<BymtTerminalMarketNotarget> marketNotargetEntityList) {
        List<List<BymtTerminalMarketNotarget>> list = RestCommUtil.insertRanking(marketNotargetEntityList);
        int result = NumberConst.IntDef.INT_ZERO;
        int listSize = list.size();
        for (int i = NumberConst.IntDef.INT_ZERO; i < listSize; i++) {
            int res = this.batchSave(list.get(i));
            result = result + res;
        }
        return result;
    }

    @Override
    public int modifyMarketNoTargetBuyerList(List<BaseBean<TerminalMarketNotargetRsParam, TerminalMarketNotargetRsParam>> noTargetBuyerParamList) {
        BaseBean<BymtTerminalMarketNotarget, BymtTerminalMarketNotarget> marketNotargetBaseBean = new BaseBean<>();
        Date currentDate = DateUtils.getCurrent();
        int listSize = noTargetBuyerParamList.size();
        int result = NumberConst.IntDef.INT_ZERO;
        String loginUserId = super.getLoginUserId();
        for (int i = NumberConst.IntDef.INT_ZERO; i < listSize; i++) {
            TerminalMarketNotargetRsParam filter = noTargetBuyerParamList.get(i).getFilter();
            TerminalMarketNotargetRsParam target = noTargetBuyerParamList.get(i).getTarget();
            BymtTerminalMarketNotarget noTargetEntityFilter = BeanUtils.toBean(filter, BymtTerminalMarketNotarget.class);
            BymtTerminalMarketNotarget noTargetEntityTarget = BeanUtils.toBean(target, BymtTerminalMarketNotarget.class);
            noTargetEntityTarget.setUpdId(loginUserId);
            noTargetEntityTarget.setUpdTime(currentDate);
            marketNotargetBaseBean.setFilter(noTargetEntityFilter);
            marketNotargetBaseBean.setTarget(noTargetEntityTarget);
            int res = this.modify(marketNotargetBaseBean);
            result = result + res;
        }
        return result;
    }

    @Override
    public TerminalMarketNotargetRsParam findSum(TerminalMarketNotargetRsParam marketNotargetParam) {
        return bymtTerminalMarketNotargetDao.findSum(marketNotargetParam);
    }
}