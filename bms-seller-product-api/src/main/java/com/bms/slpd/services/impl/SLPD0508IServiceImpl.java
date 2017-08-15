package com.bms.slpd.services.impl;

import com.bms.slpd.bean.entity.SlpdAgentSupplyProduct;
import com.bms.slpd.bean.entity.SlpdManufacturerProduct;
import com.bms.slpd.bean.entity.SlpdProducerProduct;
import com.bms.slpd.bean.param.SLPD0508IParam;
import com.bms.slpd.bean.param.SLPD0509IParam;
import com.bms.slpd.bean.param.SLPD0704IParam;
import com.bms.slpd.bean.param.field.SLPD0508IManufacturerProductParam;
import com.bms.slpd.bean.param.field.SLPD0509IAgentProductParam;
import com.bms.slpd.bean.param.field.SLPD0704IProducerProductParam;
import com.bms.slpd.constant.CodeMasterConstant;
import com.bms.slpd.constant.MessageConstant;
import com.bms.slpd.dao.SLPD0508IDao;
import com.bms.slpd.services.SLPD0508IService;
import com.bms.slpd.services.SLPD0509IService;
import com.bms.slpd.services.SLPD0704IService;
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
public class SLPD0508IServiceImpl extends BaseServiceImpl implements SLPD0508IService {
    private static final Logger logger = LoggerFactory.getLogger(SLPD0508IServiceImpl.class);

    @Autowired
    private SLPD0508IDao slpd0508iDao;
    @Autowired
    private SLPD0509IService slpd0509IService;
    @Autowired
    private SLPD0704IService slpd0704IService;
    @Override
    public BaseDao getBaseDao() {
        return this.slpd0508iDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int auditManufacturerProducts(SLPD0508IParam slpd0508iParam) {
        List<SLPD0508IManufacturerProductParam> productParams = slpd0508iParam.getManufacturerProductParams();
        //查询制造商对应的生产商Id
        List<Long> approvedIds = new ArrayList<>();
        List<Long> rejectedIds = new ArrayList<>();
        for (SLPD0508IManufacturerProductParam manufacturerProductParam : productParams) {
            //准入级联操作
            if (CodeMasterConstant.AuditStu.APPROVED.equals(manufacturerProductParam.getAuditStu()))
                approvedIds.add(manufacturerProductParam.getManufacturerProductId());
            if (CodeMasterConstant.AuditStu.REJECTED.equals(manufacturerProductParam.getAuditStu()))
                rejectedIds.add(manufacturerProductParam.getManufacturerProductId());
        }
        if(CollectionUtils.isNotEmpty(approvedIds)){
            //查询未准入的生产商
            List<SlpdProducerProduct> approvedManufacturer = this.slpd0508iDao.findProducerProducts(approvedIds);
            if (CollectionUtils.isNotEmpty(approvedManufacturer)) {
                //准入对应的生产商
                SLPD0704IParam slpd0704IParam = new SLPD0704IParam();
                List<SLPD0704IProducerProductParam> producerProductParams = new ArrayList<>();
                SLPD0704IProducerProductParam slpd0704IProducerProductParam = null;
                for (SlpdProducerProduct slpdProducerProduct : approvedManufacturer) {
                    slpd0704IProducerProductParam = new SLPD0704IProducerProductParam();
                    slpd0704IProducerProductParam.setProducerProductId(slpdProducerProduct.getProducerProductId());
                    slpd0704IProducerProductParam.setVersion(slpdProducerProduct.getVersion());
                    slpd0704IProducerProductParam.setAuditRemark("");
                    slpd0704IProducerProductParam.setAuditStu(CodeMasterConstant.AuditStu.APPROVED);
                    producerProductParams.add(slpd0704IProducerProductParam);
                }
                slpd0704IParam.setProducerProductParams(producerProductParams);
                this.slpd0704IService.auditProducerProducts(slpd0704IParam);
            }
        }

        if(CollectionUtils.isNotEmpty(rejectedIds)){
            //查询未禁止的代理商
            List<SlpdAgentSupplyProduct> rejectedManufacturer = this.slpd0508iDao.findAgentProducts(rejectedIds);
            if (CollectionUtils.isNotEmpty(rejectedManufacturer)) {
                //禁止对应的代理商
                SLPD0509IParam slpd0509IParam = new SLPD0509IParam();
                List<SLPD0509IAgentProductParam> agentProductParams = new ArrayList<>();
                SLPD0509IAgentProductParam slpd0509IAgentProductParam = null;
                for (SlpdAgentSupplyProduct agentProduct : rejectedManufacturer) {
                    slpd0509IAgentProductParam = new SLPD0509IAgentProductParam();
                    slpd0509IAgentProductParam.setAsProductId(agentProduct.getAsProductId());
                    slpd0509IAgentProductParam.setAuditStu(CodeMasterConstant.AuditStu.REJECTED);
                    slpd0509IAgentProductParam.setVersion(agentProduct.getVersion());
                    slpd0509IAgentProductParam.setAuditRemark("");//TODO 默认值
                    agentProductParams.add(slpd0509IAgentProductParam);
                }
                slpd0509IParam.setAgentProductParams(agentProductParams);
                this.slpd0509IService.auditAgentProducts(slpd0509IParam);
            }
        }

        List<SlpdManufacturerProduct> entities = this.handleParameter(productParams);
        for (SlpdManufacturerProduct manufacturerProduct : entities) {
            this.updateProductAuditStu(manufacturerProduct);
        }
        return productParams.size();
    }

    /**
     * 拼接修改entity
     */
    private List<SlpdManufacturerProduct> handleParameter(List<SLPD0508IManufacturerProductParam> productParams) {
        final String userId = super.getLoginUserId();
        final Date today = DateUtils.getCurrent();
        List<SlpdManufacturerProduct> manufacturerProducts = new ArrayList<>();
        SlpdManufacturerProduct manufacturerProduct = null;
        for (SLPD0508IManufacturerProductParam manufacturerProductParam : productParams) {
            manufacturerProduct = BeanUtils.toBean(manufacturerProductParam, SlpdManufacturerProduct.class);
            manufacturerProduct.setUpdId(userId);
            manufacturerProduct.setUpdTime(today);
//            manufacturerProduct.setAuditHistory(manufacturerProductParam.getAuditStu() + "," + userId + "," + today);
            manufacturerProduct.setAuditHistory("auditHistory");
            manufacturerProducts.add(manufacturerProduct);
        }
        return manufacturerProducts;
    }


    /**
     * 修改产品的审核状态
     */
    private int updateProductAuditStu(SlpdManufacturerProduct product) {
        int matched = this.slpd0508iDao.updateManufacturerProductAuditStu(product);
        if (matched != NumberConst.IntDef.INT_ONE) {
            String builder = new StringBuilder()
                    .append("审核产品失败，agentProductId参数值")
                    .append(product.getManufacturerProductId())
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
