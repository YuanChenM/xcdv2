package com.bms.slpd.services.impl;

import com.bms.slpd.bean.entity.SlpdAgentSupplyProduct;
import com.bms.slpd.bean.entity.SlpdManufacturerProduct;
import com.bms.slpd.bean.param.SLPD0508IParam;
import com.bms.slpd.bean.param.SLPD0509IParam;
import com.bms.slpd.bean.param.field.SLPD0508IManufacturerProductParam;
import com.bms.slpd.bean.param.field.SLPD0509IAgentProductParam;
import com.bms.slpd.constant.CodeMasterConstant;
import com.bms.slpd.constant.MessageConstant;
import com.bms.slpd.dao.SLPD0509IDao;
import com.bms.slpd.services.SLPD0508IService;
import com.bms.slpd.services.SLPD0509IService;
import com.framework.base.consts.NumberConst;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.DateUtils;
import com.framework.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SLPD0509IServiceImpl extends BaseServiceImpl implements SLPD0509IService {
    private static final Logger logger = LoggerFactory.getLogger(SLPD0509IServiceImpl.class);

    @Autowired
    private SLPD0509IDao slpd0509iDao;
    @Autowired
    private SLPD0508IService slpd0508IService;
    @Override
    public BaseDao getBaseDao() {
        return this.slpd0509iDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int auditAgentProducts(SLPD0509IParam slpd0509iParam) {
        List<SLPD0509IAgentProductParam> productParams = slpd0509iParam.getAgentProductParams();
        //查询代理商对应的制造商Id
        List<Long> agentIds = new ArrayList<>();
        for (SLPD0509IAgentProductParam agentProductParam : productParams) {
            //准入级联操作
            if (CodeMasterConstant.AuditStu.APPROVED.equals(agentProductParam.getAuditStu()))
                agentIds.add(agentProductParam.getAsProductId());
        }
        if(CollectionUtils.isNotEmpty(agentIds)){
            List<SlpdManufacturerProduct> manufacturers = this.slpd0509iDao.findManufacturers(agentIds);
            if (CollectionUtils.isNotEmpty(manufacturers)) {
                //准入对应的制造商
                SLPD0508IParam slpd0508IParam = new SLPD0508IParam();
                List<SLPD0508IManufacturerProductParam> manufacturerProductParams = new ArrayList<>();
                SLPD0508IManufacturerProductParam manufacturerProductParam = null;
                for (SlpdManufacturerProduct manufacturerProduct : manufacturers) {
                    manufacturerProductParam = new SLPD0508IManufacturerProductParam();
                    manufacturerProductParam.setAuditRemark("");
                    manufacturerProductParam.setVersion(manufacturerProduct.getVersion());
                    manufacturerProductParam.setAuditStu(CodeMasterConstant.AuditStu.APPROVED);
                    manufacturerProductParam.setManufacturerProductId(manufacturerProduct.getManufacturerProductId());
                    manufacturerProductParams.add(manufacturerProductParam);
                }
                slpd0508IParam.setManufacturerProductParams(manufacturerProductParams);
                this.slpd0508IService.auditManufacturerProducts(slpd0508IParam);
            }
        }
        List<SlpdAgentSupplyProduct> entities = this.handleParameter(productParams);
        for (SlpdAgentSupplyProduct agentSupplyProduct : entities) {
            this.updateProductAuditStu(agentSupplyProduct);
        }
        return productParams.size();
    }

    /**
     * 拼接修改entity
     */
    private List<SlpdAgentSupplyProduct> handleParameter(List<SLPD0509IAgentProductParam> productParams) {
        final String userId = super.getLoginUserId();
        final Date today = DateUtils.getCurrent();
        List<SlpdAgentSupplyProduct> agentSupplyProducts = new ArrayList<>();
        SlpdAgentSupplyProduct agentSupplyProduct = null;
        for (SLPD0509IAgentProductParam agentProductParam : productParams) {
            agentSupplyProduct = BeanUtils.toBean(agentProductParam, SlpdAgentSupplyProduct.class);
            agentSupplyProduct.setUpdId(userId);
            agentSupplyProduct.setUpdTime(today);
//            agentSupplyProduct.setAuditHistory(agentProductParam.getAuditStu() + "," + userId + "," + today);
            agentSupplyProduct.setAuditHistory("auditHistory");
            agentSupplyProducts.add(agentSupplyProduct);
        }
        return agentSupplyProducts;
    }


    /**
     * 修改产品的审核状态
     */
    private int updateProductAuditStu(SlpdAgentSupplyProduct product) {
        int matched = this.slpd0509iDao.updateAgentProductAuditStu(product);
        if (matched != NumberConst.IntDef.INT_ONE) {
            String builder = new StringBuilder()
                    .append("审核产品失败，agentProductId参数值")
                    .append(product.getAsProductId())
                    .append("，version参数值")
                    .append(product.getVersion())
                    .append("。")
                    .toString();
            logger.info(builder);
            throw new BusinessException(MessageConstant.MODULE_NAME_ZH, "审核产品失败，请刷新页面重试。");
        }
        return matched;
    }

}
