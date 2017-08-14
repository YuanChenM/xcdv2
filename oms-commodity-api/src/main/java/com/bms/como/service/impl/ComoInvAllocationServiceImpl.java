/*
 * 2017/03/27 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.como.service.impl;

import com.bms.como.bean.entity.ComoInvAllocation;
import com.bms.como.bean.entity.ComoInvAllocationDetail;
import com.bms.como.bean.entity.ComoInvAllocationResult;
import com.bms.como.bean.param.*;
import com.bms.como.bean.result.ComoInvAllocationDetailRsResult;
import com.bms.como.bean.result.ComoInvAllocationRsResult;
import com.bms.como.constant.TableConstant;
import com.bms.como.dao.ComoInvAllocationDao;
import com.bms.como.dao.ComoInvAllocationDetailDao;
import com.bms.como.dao.ComoInvAllocationResultDao;
import com.bms.como.service.ComoInvAllocationService;
import com.bms.como.util.RestCommUtil;
import com.framework.base.consts.NumberConst;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.db.DbUtils;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.StringUtils;
import com.framework.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>ComoInvAllocationService。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
@Service
public class ComoInvAllocationServiceImpl extends BaseServiceImpl implements ComoInvAllocationService {
    private final String ALLOCATION_PROCESSING = "001";//执行中
    private final String ALLOCATION_COMPLETED = "002";//已完成
    private final String ALLOCATION_CANCEL = "003";//已取消

    @Autowired
    private ComoInvAllocationDao comoInvAllocationDao;
    @Autowired
    private ComoInvAllocationDetailDao comoInvAllocationDetailDao;
    @Autowired
    private ComoInvAllocationResultDao comoInvAllocationResultDao;

    @Override
    public BaseDao getBaseDao() {
        return comoInvAllocationDao;
    }

    @Override
    public ComoInvAllocationRsResult saveInvAllocation(ComoInvAllocationRsParam invAllocationRsParam) {
        //查询顺序码
        String allocationCode = new StringBuilder().append("AL").append(DateUtils.format("yyMMdd",new Date())).toString();
        int codeCount = this.findInvAllocationCodeCount(DbUtils.buildLikeCondition(allocationCode, DbUtils.LikeMode.FRONT)) + 1;
        //新增库存划拨单
        ComoInvAllocationRsResult allocationRsResult = new ComoInvAllocationRsResult();
        ComoInvAllocation invAllocation = BeanUtils.toBean(invAllocationRsParam, ComoInvAllocation.class);
        Date currentDate = DateUtils.getCurrent();
        Long allocationId = this.maxId(TableConstant.Name.COMO_INV_ALLOCATION);
        String loginUserId = this.getLoginUserId();
        invAllocation.setAllocationCode(new StringBuilder().append(allocationCode).append(String.format("%05d",codeCount)).toString());
        invAllocation.setAllocationId(allocationId);
        invAllocation.setAllocationStu(ALLOCATION_PROCESSING);
        invAllocation.setApplyTime(currentDate);
        invAllocation.setCrtId(loginUserId);
        invAllocation.setCrtTime(currentDate);
        invAllocation.setUpdId(loginUserId);
        invAllocation.setUpdTime(currentDate);
        invAllocation.setDelFlg(false);
        invAllocation.setVersion(NumberConst.IntDef.INT_ONE);
        allocationRsResult.setAllocationId(allocationId);
        this.save(invAllocation);
        if (CollectionUtils.isNotEmpty(invAllocationRsParam.getDetailRsParams())) {
            //批量新增库存划拨单明细数据
            List<ComoInvAllocationDetail> invAllocationDetails = new ArrayList<>();
            ComoInvAllocationDetail invAllocationDetail = null;
            ComoInvAllocationDetailRsParam allocationDetailRsParam = null;
            List<Long> allocationDetailIds = new ArrayList<>();
            int checkDetailRepeat = NumberConst.IntDef.INT_ZERO;
            for (int i = NumberConst.IntDef.INT_ZERO; i < invAllocationRsParam.getDetailRsParams().size(); i++) {
                allocationDetailRsParam = invAllocationRsParam.getDetailRsParams().get(i);
                //检查数据库中明细是否重复（相同原商品，目标商品，SKU编码和批次，仅数量不一样），如有重复直接报错。
//                checkDetailRepeat = this.comoInvAllocationDetailDao.checkDetailRepeat(allocationDetailRsParam);
                if (checkDetailRepeat > NumberConst.IntDef.INT_ZERO) {
                    throw new BusinessException("como", "COMO.E01003");
                } else {
                    invAllocationDetail = BeanUtils.toBean(allocationDetailRsParam, ComoInvAllocationDetail.class);
                    currentDate = DateUtils.getCurrent();
                    Long allocationDetailId = this.maxId(TableConstant.Name.COMO_INV_ALLOCATION_DETAIL);
                    if(null == invAllocationDetail.getFactQty()){
                        invAllocationDetail.setFactQty(new BigDecimal(0));
                    }
                    invAllocationDetail.setAllocationDetailId(allocationDetailId);
                    invAllocationDetail.setAllocationId(allocationId);
                    invAllocationDetail.setCrtId(loginUserId);
                    invAllocationDetail.setCrtTime(currentDate);
                    invAllocationDetail.setUpdId(loginUserId);
                    invAllocationDetail.setUpdTime(currentDate);
                    invAllocationDetail.setDelFlg(false);
                    invAllocationDetail.setVersion(NumberConst.IntDef.INT_ONE);
                    allocationDetailIds.add(allocationDetailId);
                    /*if (i > NumberConst.IntDef.INT_ZERO) {
                        for (int j = NumberConst.IntDef.INT_ZERO; j < invAllocationDetails.size(); j++) {
                            //检查明细传入参数是否重复
                            ComoInvAllocationDetail detail = invAllocationDetails.get(j);
                            if (
                                    (invAllocationDetail.getAllocationId() == detail.getAllocationId())
                                   *//* && (invAllocationDetail.getTargetCommodityId() == detail.getTargetCommodityId())
                                    && (invAllocationDetail.getOriginalCommodityId() == detail.getOriginalCommodityId())
                                    && (invAllocationDetail.getSkuCode().equals(detail.getSkuCode()))
                                    && (invAllocationDetail.getLotNo().equals(detail.getLotNo()))
                                    && (invAllocationDetail.getOwnerId().equals(detail.getOwnerId()))*//*
                                    ) {
                                throw new BusinessException("como", "COMO.E01003");
                            } else {
                                continue;
                            }
                        }
                    }*/
                    invAllocationDetails.add(invAllocationDetail);
                }
            }
            allocationRsResult.setAllocationDetailIds(allocationDetailIds);
            if (checkDetailRepeat == NumberConst.IntDef.INT_ZERO) {
                List<List<ComoInvAllocationDetail>> list = RestCommUtil.insertRanking(invAllocationDetails);
                int listSize = list.size();
                for (int i = NumberConst.IntDef.INT_ZERO; i < listSize; i++) {
                    this.comoInvAllocationDetailDao.batchInsert(list.get(i));
                }
            }
        }
        return allocationRsResult;
    }

    @Override
    public BaseRestPaginationResult<ComoInvAllocationRsResult> searchInvAllocations(ComoInvAllocationRsParam invAllocationRsParam) {
        BaseRestPaginationResult<ComoInvAllocationRsResult> paginationResult = this.findPageList(invAllocationRsParam);
        if (paginationResult != null && CollectionUtils.isNotEmpty(paginationResult.getData())) {
            for (ComoInvAllocationRsResult allocationRsResult : paginationResult.getData()) {
                ComoInvAllocationDetailRsParam detailRsParam = new ComoInvAllocationDetailRsParam();
                detailRsParam.setAllocationId(allocationRsResult.getAllocationId());
                detailRsParam.setTargetCommodityIds(invAllocationRsParam.getTargetCommodityIds());
                List<ComoInvAllocationDetailRsResult> detailRsResults = comoInvAllocationDetailDao.findInvAllocationDetails(detailRsParam);
                allocationRsResult.setDetails(detailRsResults);
            }
        }
        return paginationResult;
    }

    @Override
    public int saveInvAllocationResult(AllocationResultRsParam rsParam) {
        List<ComoInvAllocationResult> allocationResults = new ArrayList<>();
        ComoInvAllocationResult allocationResult = null;
        List<ProductParam> productLis = rsParam.getProductList();
        ProductParam productParam = null;
        int result = NumberConst.IntDef.INT_ZERO;
        for (int i = NumberConst.IntDef.INT_ZERO; i < productLis.size(); i++) {
            productParam = productLis.get(i);
            allocationResult = new ComoInvAllocationResult();
            allocationResult.setFailReason(rsParam.getFailReason());
            allocationResult.setAllocationId(Long.valueOf(rsParam.getOrderId()));
            allocationResult.setConsignee(productParam.getSlCode());
            allocationResult.setSupplierCode(productParam.getSupplierCode());
            allocationResult.setSkuCode(productParam.getSkuCode());
            allocationResult.setUom(productParam.getUnit());
            allocationResult.setOldSaleStatus(productParam.getOldLabel());
            allocationResult.setNewSaleStatus(productParam.getNewLabel());
            WarehouseRsParam warehouseRsParam = null;
            List<WarehouseRsParam> whList = productParam.getWhList();
            for (int j = NumberConst.IntDef.INT_ZERO; j < whList.size(); j++) {
                warehouseRsParam = whList.get(j);
                allocationResult.setWhId(Long.valueOf(1));
                allocationResult.setWhCode(warehouseRsParam.getWhCode());
                allocationResult.setWhName(warehouseRsParam.getWhName());
                List<BatchStorageRsParam> lotList = warehouseRsParam.getLotList();
                BatchStorageRsParam batchStorage = null;
                for (int k = NumberConst.IntDef.INT_ZERO; k < lotList.size(); k++) {
                    batchStorage = lotList.get(k);
                    //查询划拨明细信息
                    ComoInvAllocationDetailRsParam detailRsParam = new ComoInvAllocationDetailRsParam();
                    detailRsParam.setAllocationId(Long.valueOf(rsParam.getOrderId()));
                    detailRsParam.setOwnerCode(productParam.getSlCode());
                    detailRsParam.setLotNo(batchStorage.getLotNo());
                    detailRsParam.setSkuCode(productParam.getSkuCode());
                    detailRsParam.setUom(productParam.getUnit());
                    List<ComoInvAllocationDetailRsResult> detailRsResults = this.comoInvAllocationDetailDao.findAll(detailRsParam);
                    if (CollectionUtils.isNotEmpty(detailRsResults)) {
                        ComoInvAllocationDetailRsResult detailRsResult = detailRsResults.get(NumberConst.IntDef.INT_ZERO);
                        allocationResult.setInventoryStu(detailRsResult.getInventoryStu());
                    } else {
                        allocationResult.setInventoryStu("");
                    }
                    allocationResult.setLotNo(batchStorage.getLotNo());
                    allocationResult.setPlanQty(batchStorage.getAdjustQty());
                    allocationResult.setFactQty(batchStorage.getAdjustQty());
                    String resultId = StringUtils.toString(this.maxId(TableConstant.Name.COMO_INV_ALLOCATION_RESULT));
                    Date currentDate = DateUtils.getCurrent();
                    String loginUserId = this.getLoginUserId();
                    allocationResult.setResultId(resultId);
                    allocationResult.setDelFlg(false);
                    allocationResult.setCrtId(loginUserId);
                    allocationResult.setCrtTime(currentDate);
                    allocationResult.setUpdId(loginUserId);
                    allocationResult.setUpdTime(currentDate);
                    allocationResult.setVersion(NumberConst.IntDef.INT_ONE);
                    allocationResults.add(allocationResult);
                }
            }
        }
        List<List<ComoInvAllocationResult>> list = RestCommUtil.insertRanking(allocationResults);
        int listSize = list.size();
        for (int i = NumberConst.IntDef.INT_ZERO; i < listSize; i++) {
            result = this.comoInvAllocationResultDao.batchInsert(list.get(i));
        }
        if ("1".equals(rsParam.getSetLabelResult())) {
            //成功更新划拨单明细的执行数量
            Date currentDate = DateUtils.getCurrent();
            ComoInvAllocationDetail detail = new ComoInvAllocationDetail();
            detail.setAllocationId(Long.valueOf(rsParam.getOrderId()));
            detail.setUpdId(getLoginUserId());
            detail.setUpdTime(currentDate);
            this.comoInvAllocationDetailDao.modifyFactQty(detail);
            //更新划拨单主表
            ComoInvAllocation invAllocation = new ComoInvAllocation();
            invAllocation.setAllocationId(Long.valueOf(rsParam.getOrderId()));
            invAllocation.setAllocationStu(ALLOCATION_COMPLETED);
            invAllocation.setAllocationResult(true);
            invAllocation.setCompletedMan(this.getLoginUserId());
            invAllocation.setCompletedTime(currentDate);
            invAllocation.setUpdId(this.getLoginUserId());
            invAllocation.setUpdTime(currentDate);
            this.comoInvAllocationDao.modify(invAllocation);
        } else {
            //失败更新划拨单主表
            Date currentDate = DateUtils.getCurrent();
            ComoInvAllocation invAllocation = new ComoInvAllocation();
            invAllocation.setAllocationId(Long.valueOf(rsParam.getOrderId()));
            invAllocation.setAllocationStu(ALLOCATION_CANCEL);
            invAllocation.setAllocationResult(false);
            invAllocation.setCompletedMan(this.getLoginUserId());
            invAllocation.setCompletedTime(currentDate);
            invAllocation.setUpdId(this.getLoginUserId());
            invAllocation.setUpdTime(currentDate);
            this.comoInvAllocationDao.modify(invAllocation);
        }
        return result;
    }


    /**
     * 根据AL-年月 查询数量
     */
    @Override
    public int findInvAllocationCodeCount(String allocationCode) {
        return comoInvAllocationDao.findInvAllocationCodeCount(allocationCode);
    }

    @Override
    public int modifyInvAllocationDetail(ComoInvAllocationDetail param) {
        return comoInvAllocationDetailDao.modifyFactQty(param);
    }

    @Override
    public int addInvAllocationDetail(List<ComoInvAllocationResult> param) {
        if(CollectionUtils.isNotEmpty(param)){
            for(ComoInvAllocationResult result : param){
                String resultId = StringUtils.toString(this.maxId(TableConstant.Name.COMO_INV_ALLOCATION_RESULT));
                result.setResultId(resultId);
                result.setCrtId(super.getLoginUserId());
                result.setCrtTime(DateUtils.getCurrent());
                result.setUpdId(super.getLoginUserId());
                result.setUpdTime(DateUtils.getCurrent());
            }
            return comoInvAllocationResultDao.batchInsert(param);
        }

        return 0;
    }
}