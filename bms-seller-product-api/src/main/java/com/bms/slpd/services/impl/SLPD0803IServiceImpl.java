package com.bms.slpd.services.impl;

import com.bms.slpd.bean.UpdateEntity;
import com.bms.slpd.bean.entity.SlpdProducerProduct;
import com.bms.slpd.bean.entity.SlpdProduct;
import com.bms.slpd.bean.entity.SlpdSellerCommodity;
import com.bms.slpd.bean.entity.target.SlpdSellerCommodityTarget;
import com.bms.slpd.bean.param.SLPD0802IParam;
import com.bms.slpd.bean.param.SLPD0803IParam;
import com.bms.slpd.bean.result.SLPD0803IResult;
import com.bms.slpd.bean.result.field.SLPD0802ISellerCommodityResult;
import com.bms.slpd.dao.SLPD0803IDao;
import com.bms.slpd.services.SLPD0803IService;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.DateUtils;
import com.framework.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SLPD0803IServiceImpl extends BaseServiceImpl implements SLPD0803IService {

    @Autowired
    private SLPD0803IDao slpd0803IDao;

    @Override
    public BaseDao getBaseDao() {
        return slpd0803IDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SLPD0803IResult modifySellerCommoditys(SLPD0803IParam requestParam) {
        SLPD0803IResult result = new SLPD0803IResult();
        int tableFlg = requestParam.getTargetTableFlg();
        List<Long> sellerCommodityIds = new ArrayList<>();
        List<Long> producerProductIds = new ArrayList<>();
        List<String> productIds = new ArrayList<>();
        int count = 0;
        Date now = DateUtils.getCurrent();
        String userId = super.getLoginUserId();

        //tableFlg=1时,更新卖家产品生产商表信息
        if (tableFlg == 0 || tableFlg == 1) {
            SlpdSellerCommodityTarget target = setTarget(requestParam);
            if (requestParam.getSlpdSellerCommodities() != null && requestParam.getSlpdSellerCommodities().size() > 0) {
                List<SlpdSellerCommodity> slpdSellerCommodities = requestParam.getSlpdSellerCommodities();
                for (SlpdSellerCommodity param : slpdSellerCommodities) {
                    UpdateEntity<SlpdSellerCommodity, SlpdSellerCommodityTarget> updateEntity = new UpdateEntity<>();
                    param.setUpdId(userId);
                    param.setUpdTime(now);
                    updateEntity.setEntity(param);
                    updateEntity.setTarget(target);

                    int num = slpd0803IDao.batchModify(updateEntity);
                    if (0 < num) {
                        count += num;
                        sellerCommodityIds.add(updateEntity.getEntity().getSellerCommodityId());
                    } else {
                        throw new BusinessException("", "");
                    }
                }
                result.setCount(count);
                result.setSellerCommodityIds(sellerCommodityIds);
            }
        }

        //tableFlg=2时,更新产品表信息
        if (tableFlg == 0 || tableFlg == 2) {
            if (requestParam.getSlpdProducts() != null && requestParam.getSlpdProducts().size() > 0) {
                UpdateEntity updateEntity = new UpdateEntity<>();
                int num = 0;

                for (SlpdProduct slpdProduct : requestParam.getSlpdProducts()) {
                    slpdProduct.setUpdId(userId);
                    slpdProduct.setUpdTime(now);
                    updateEntity.setEntity(slpdProduct);
                    num = slpd0803IDao.updateProductTypes(updateEntity);
                    if (0 < num) {
                        productIds.add(slpdProduct.getProductId());
                        count += num;
                    } else {
                        throw new BusinessException("", "");
                    }

                    //如果产品禁止准入,批量禁止产品生产商,卖家产品生产商
                    if (slpdProduct.getAuditStu().equals("4")) {
                        SLPD0802IParam slpd0802IParam = new SLPD0802IParam();
                        slpd0802IParam.setProductIds(productIds);
                        //查询状态不为0的卖家产品生产商
                        List<String> slpdSellerCommodityAuditStus=new ArrayList<>();
                        slpdSellerCommodityAuditStus.add("1");
                        slpdSellerCommodityAuditStus.add("2");
                        slpdSellerCommodityAuditStus.add("3");
                        slpdSellerCommodityAuditStus.add("4");
                        slpd0802IParam.setAuditStus(slpdSellerCommodityAuditStus);
                        //BaseRestPaginationResult<SLPD0802ISellerCommodityResult> slpdSellerCommodityResults = slpd0802IService.findSellerCommoditys(slpd0802IParam);
                        BaseRestPaginationResult<SLPD0802ISellerCommodityResult> slpdSellerCommodityResults = null;

                        //禁止准入产品生产商
                        if (slpdSellerCommodityResults.getData() != null && slpdSellerCommodityResults.getData().size() > 0) {
                            for (SLPD0802ISellerCommodityResult slpdSellerCommodityResult : slpdSellerCommodityResults.getData()) {
                                /*if(slpdSellerCommodityResult.getProducerAuditStu().equals("0")){//当产品生产商状态为"0",跳过修改,保持原状态
                                    continue;
                                }*/
                                SlpdProducerProduct slpdProducerProduct = new SlpdProducerProduct();
                                //slpdProducerProduct.setProducerProductId(slpdSellerCommodityResult.getProducerProductId());
                                slpdProducerProduct.setAuditStu("3");
                                slpdProducerProduct.setUpdId(userId);
                                slpdProducerProduct.setUpdTime(now);
                                updateEntity.setEntity(slpdProducerProduct);
                                int number = 0;
                                number = slpd0803IDao.updateProducerProductTypes(updateEntity);

                                if (0 < number) {

                                } else {
                                    throw new BusinessException("", ""); //TODO 国际化
                                }
                            }
                            updateEntity.setTarget(setTarget(requestParam));

                            //禁止准入卖家产品生产商
                            for (SLPD0802ISellerCommodityResult slpdSellerCommodityResult : slpdSellerCommodityResults.getData()) {
                                SlpdSellerCommodity sellerCommodity = new SlpdSellerCommodity();
                                sellerCommodity.setSellerCommodityId(slpdSellerCommodityResult.getSellerCommodityId());
                                sellerCommodity.setAuditStu("3");
                                sellerCommodity.setUpdId(userId);
                                sellerCommodity.setUpdTime(now);
                                updateEntity.setEntity(sellerCommodity);
                                int number = 0;
                                number = slpd0803IDao.batchModify(updateEntity);
                                if (0 < number) {

                                } else {
                                    throw new BusinessException("", ""); //TODO 国际化
                                }
                            }
                        }
                    }
                }
                result.setCount(count);
                result.setProductIds(productIds);
            }
        }
        //tableFlg=3时,更新产品生产商表信息
        if (tableFlg == 0 || tableFlg == 3) {
            if (requestParam.getSlpdProducerProducts() != null && requestParam.getSlpdProducerProducts().size() > 0) {
                UpdateEntity updateEntity = new UpdateEntity<>();
                int num = 0;
                for (SlpdProducerProduct slpdProducerProduct : requestParam.getSlpdProducerProducts()) {
                    slpdProducerProduct.setUpdId(userId);
                    slpdProducerProduct.setUpdTime(now);
                    updateEntity.setEntity(slpdProducerProduct);
                    num = slpd0803IDao.updateProducerProductTypes(updateEntity);
                    if (0 < num) {
                        producerProductIds.add(slpdProducerProduct.getProducerProductId());
                        count += num;
                    } else {
                        throw new BusinessException("", "");
                    }
                    //当禁止准入产品生产商时,批量禁止卖家产品生产商
                    if (slpdProducerProduct.getAuditStu().equals("3")) {

                        updateEntity.setTarget(setTarget(requestParam));
                        SlpdSellerCommodity sellerCommodity = new SlpdSellerCommodity();
                        sellerCommodity.setProducerProductId(slpdProducerProduct.getProducerProductId());
                        sellerCommodity.setAuditStu("3");
                        sellerCommodity.setUpdId(userId);
                        sellerCommodity.setUpdTime(now);
                        updateEntity.setEntity(sellerCommodity);
                        int number = 0;
                        number = slpd0803IDao.updateSellerCommodityAudit(updateEntity);//批量禁止卖家产品生产商
                    }
                }
                result.setCount(count);
                result.setProducerProductIds(producerProductIds);
            }
        }

        return result;
    }

    public SlpdSellerCommodityTarget setTarget(SLPD0803IParam requestParam) {
        String[] targets = requestParam.getTargets();
        if (targets == null) {
            //throw new BusinessException("SLPD", MessageConstant.Info.I000005);
        }

        SlpdSellerCommodityTarget sellerCommodityTarget = new SlpdSellerCommodityTarget();
        List<String> invalid = new ArrayList<>();
        for (String str : targets) {
            if ("sellerId".equals(str)) {
                sellerCommodityTarget.setSellerIdFlg(true);
            } else if ("producerProductId".equals(str)) {
                sellerCommodityTarget.setProducerProductIdFlg(true);
            } else if ("articleNo".equals(str)) {
                sellerCommodityTarget.setArticleNoFlg(true);
            } else if ("commodityId".equals(str)) {
                sellerCommodityTarget.setCommodityIdFlg(true);
            } else if ("salesTitle".equals(str)) {
                sellerCommodityTarget.setSalesTitleFlg(true);
            } else if ("delFlg".equals(str)) {
                sellerCommodityTarget.setDelFlgFlg(true);
            } else if ("auditStu".equals(str)) {
                sellerCommodityTarget.setAuditStuFlg(true);
            } else if ("auditRemark".equals(str)) {
                sellerCommodityTarget.setAuditRemarkFlg(true);
            } else {
                invalid.add(str);
            }
        }

        if (invalid.size() > 0) {
            StringBuilder builder = new StringBuilder();
            for (String str : invalid) {
                builder.append(str).append(",");
            }
            //throw new BusinessException("SLPD", MessageConstant.Error.E000010, builder.toString());
        }

        return sellerCommodityTarget;
    }

}