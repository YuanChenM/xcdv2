package com.bms.slpd.services.impl;

import com.bms.slpd.bean.entity.SlpdAgentSupplyProduct;
import com.bms.slpd.bean.param.SLPD1811IAgentProductParam;
import com.bms.slpd.bean.param.SLPD1811IParam;
import com.bms.slpd.bean.result.SLPD1811IResult;
import com.bms.slpd.constant.MessageConstant;
import com.bms.slpd.dao.SLPD1811IDao;
import com.bms.slpd.services.SLPD1811IService;
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
public class SLPD1811IServiceImpl extends BaseServiceImpl implements SLPD1811IService {

    @Autowired
    private SLPD1811IDao slpd1811IDao;

    @Override
    public BaseDao getBaseDao() {
        return slpd1811IDao;
    }

    @Override
    public SLPD1811IResult deleteAgentProducts(SLPD1811IParam slpd1811iParam) {
        final String userId = this.getLoginUserId();
        final Date time = DateUtils.getCurrent();
        int total = NumberConst.IntDef.INT_ZERO;
        List<SLPD1811IAgentProductParam> params = slpd1811iParam.getAgentProductParams();
        SlpdAgentSupplyProduct agentSupplyProduct = null;
        List<Long> agentProductIds = new ArrayList<>();
        for (SLPD1811IAgentProductParam agentProductParam : params) {
            agentSupplyProduct = BeanUtils.toBean(agentProductParam, SlpdAgentSupplyProduct.class);
            agentSupplyProduct.setUpdId(userId);
            agentSupplyProduct.setUpdTime(time);
            int count = this.slpd1811IDao.updateAgentProducts(agentSupplyProduct);
            if (NumberConst.IntDef.INT_ZERO == count)
                throw new BusinessException(MessageConstant.MODULE_NAME_EN, "删除代理商失败,请刷新页面重试");
            total++;
            agentProductIds.add(agentProductParam.getAsProductId());
        }
        SLPD1811IResult result = new SLPD1811IResult();
        result.setCount(total);
        result.setAsProductIds(agentProductIds);
        result.setMessage(new String[]{MessageConstant.SUCCESS});
        return result;
    }


}
