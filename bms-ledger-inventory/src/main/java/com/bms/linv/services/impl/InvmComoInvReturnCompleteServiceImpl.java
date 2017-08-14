package com.bms.linv.services.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.bms.linv.bean.param.*;
import com.bms.linv.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.linv.bean.entity.*;
import com.bms.linv.bean.result.LINV0106IResult;
import com.bms.linv.business.LinvPublicMethodService;
import com.bms.linv.services.InvmComoDealDetailService;
import com.bms.linv.services.InvmComoInvReturnCompleteService;
import com.framework.base.consts.NumberConst;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.DateUtils;
import com.framework.exception.BusinessException;
import com.framework.redis.dao.BaseRedisDao;

/**
 * Created by wang_haichun on 2017/4/18.
 */
@Service
public class InvmComoInvReturnCompleteServiceImpl extends BaseServiceImpl implements InvmComoInvReturnCompleteService {
    @Autowired
    private BaseRedisDao baseRedisDao;
    @Autowired
    private InvmComoBalanceDealDetailDao invmComoBalanceDealDetailDao;
    @Autowired
    private InvmComoInvReturnCompleteDao comoInvReturnCompleteDao;
    @Autowired
    private LinvPublicMethodService publicMethodService;
    @Autowired
    private InvmComoInventoryDao invmComoInventoryDao;
    @Autowired
    private InvmComoDealDetailService comoDealDetailService;
    @Autowired
    private InvmComoBalanceInventoryDao invmComoBalanceInventoryDao;
    @Autowired
    private InvmComoDealDetailDao invmComoDealDetailDao;

    @Override
    public BaseDao getBaseDao() {
        return comoInvReturnCompleteDao;
    }

    /**
     * 货权交易退货完成接口
     */
    @Override
    public LINV0106IResult modifyComoInvReturnComplete(List<LINV0106IParam> param) {
        LINV0106IResult result = new LINV0106IResult();
        String userId = "WMS";
        Date nowDate = DateUtils.getCurrent();

        //业务单号重复验证
        //checkComoTran(param);

        for (LINV0106IParam invLists : param) {
            LINV0106ISourceParam source = invLists.getSource();
            LINV0106IDealParam deal = invLists.getDeal();

            // 根据释放数量，若释放数量大于0，释放占用数量
            if (deal.getReleaseQty().compareTo(BigDecimal.ZERO) == NumberConst.IntDef.INT_ONE) {
                InvmComoAlocInventory comoAlocInventory = this.findComoAlocInv(source);
                if (null == comoAlocInventory) {
                    throw new BusinessException("LINV.COMO_DEAL_RETURN", "未查询到占用交易");
                }
                comoAlocInventory.setAlocQty(BigDecimal.ZERO.subtract(deal.getReleaseQty()));
                // 1.调用公共 商品占用库存数量减少
                publicMethodService.cancelOwComAloc(comoAlocInventory,
                    this.newComoAlocDealDetail(comoAlocInventory, deal));
            }

            // 2.源货权人商品库存减少
          //  if (null != deal.getDeductSrcInv() ) {
                if(deal.getDeductSrcInv()) {
                    subOwerComoInv(userId, nowDate, source, deal);
                }
          //  }else {
          //      subOwerComoInv(userId, nowDate, source, deal);
         //   }

            // 3.目标货权人商品库存增加
            if (null != deal.getAddTargetInv() && deal.getAddTargetInv()) {
                // 指定目标方
                if (null != deal.getSrcTransactionId() || null != deal.getSrcTransactionDetailId()) {
                    this.comoReturnForSrcTran(source, deal);
                } else {
                    this.comoReturn(source, deal);
                }
            }
        }
        result.setMessage("S");
        return result;
    }

    /**
     * 源货权人商品库存减少 、新增明细（记录的库存为减少）、 余量修改（减少）、 余量明细新增（记录的库存为减少）
     * 
     * @param userId
     * @param nowDate
     * @param source
     * @param deal
     */
    private void subOwerComoInv(String userId, Date nowDate, LINV0106ISourceParam source, LINV0106IDealParam deal) {

        // 源货权人商品库存减少
        InvmComoInventory comoInventory = this.findComoInv(source);
        if (null == comoInventory) {
            throw new BusinessException("LINV.COMO_DEAL_RETURN", "未查询到退货方商品库存");
        }
        BigDecimal qty=BigDecimal.valueOf(0).subtract(deal.getReturnQty());
        comoInventory.setIvQty(qty);
        comoInventory.setUpdId(userId);
        comoInventory.setUpdTime(nowDate);
        int updateComoInvResult = this.modifyComoInv(comoInventory);
        if (updateComoInvResult == NumberConst.IntDef.INT_ZERO) {
            throw new BusinessException("LINV.COMO_DEAL_RETURN", "退货方商品库存减少失败");
        }

        // 新增明细（记录的库存为减少）
        //deal.setReturnQty(BigDecimal.ZERO.subtract(deal.getReturnQty()));// 明细数据为负
        Long storeDealId=baseRedisDao.getTablePrimaryKey("invm_como_deal_detail", 1);
        int saveComoDealDetailResult = this.saveComoDealDetail(comoInventory, deal,storeDealId,qty);
        if (saveComoDealDetailResult == NumberConst.IntDef.INT_ZERO) {
            throw new BusinessException("LINV.COMO_DEAL_RETURN", "新增货权人商品交易明细失败");
        }

        // 余量修改（减少）
        InvmComoBalanceInventory invmComoBalanceInventory = new InvmComoBalanceInventory();
        invmComoBalanceInventory.setStoreNo(comoInventory.getStoreNo());
        List<InvmComoBalanceInventory> comBalanList = invmComoBalanceInventoryDao.findAll(invmComoBalanceInventory);
        BigDecimal dealQty = deal.getReturnQty();
        // 先进先出的规则进行余量的扣减
        for (int i = 0; i < comBalanList.size(); i++) {
            invmComoBalanceInventory.setInvId(comBalanList.get(i).getInvId());
            invmComoBalanceInventory.setUpdId(userId);
            invmComoBalanceInventory.setUpdTime(nowDate);
            BigDecimal availableQty = (comBalanList.get(i).getInboundQty())
                .subtract(comBalanList.get(i).getOutboundQty());
            if (dealQty.compareTo(availableQty) > 0) {
                invmComoBalanceInventory.setOutboundQty(availableQty);
                invmComoBalanceInventoryDao.modify(invmComoBalanceInventory);

                // 余量明细新增（记录的库存为减少）
                InvmComoBalanceDealDetail invmComoBalanceDealDetail = new InvmComoBalanceDealDetail();
                invmComoBalanceDealDetail.setDetailId(baseRedisDao.getTablePrimaryKey("invm_como_aloc_deal_detail", 1));
                invmComoBalanceDealDetail.setStoreDealId(storeDealId);
                invmComoBalanceDealDetail.setOwnerId(comoInventory.getOwnerId());
                invmComoBalanceDealDetail.setBalanceInvId(comBalanList.get(i).getInvId());
                invmComoBalanceDealDetail.setSrcTransactionId(comBalanList.get(i).getTransactionId());
                invmComoBalanceDealDetail.setSrcTransactionNo(comBalanList.get(i).getTransactionNo());
                invmComoBalanceDealDetail.setSrcTransactionDetailId(comBalanList.get(i).getTransactionDetailId());
                invmComoBalanceDealDetail.setDealQty(BigDecimal.valueOf(0).subtract(availableQty));
                invmComoBalanceDealDetail.setCrtId(userId);
                invmComoBalanceDealDetail.setCrtTime(nowDate);
                invmComoBalanceDealDetailDao.save(invmComoBalanceDealDetail);

                dealQty = dealQty.subtract(availableQty);
            } else {
                invmComoBalanceInventory.setOutboundQty(dealQty);
                invmComoBalanceInventoryDao.modify(invmComoBalanceInventory);

                // 余量明细新增（记录的库存为减少）
                InvmComoBalanceDealDetail invmComoBalanceDealDetail = new InvmComoBalanceDealDetail();
                invmComoBalanceDealDetail.setDetailId(baseRedisDao.getTablePrimaryKey("invm_como_aloc_deal_detail", 1));
                invmComoBalanceDealDetail.setStoreDealId(storeDealId);
                invmComoBalanceDealDetail.setOwnerId(comoInventory.getOwnerId());
                invmComoBalanceDealDetail.setBalanceInvId(comBalanList.get(i).getInvId());
                invmComoBalanceDealDetail.setSrcTransactionId(comBalanList.get(i).getTransactionId());
                invmComoBalanceDealDetail.setSrcTransactionNo(comBalanList.get(i).getTransactionNo());
                invmComoBalanceDealDetail.setSrcTransactionDetailId(comBalanList.get(i).getTransactionDetailId());
                invmComoBalanceDealDetail.setDealQty(BigDecimal.valueOf(0).subtract(dealQty));
                invmComoBalanceDealDetail.setCrtId(userId);
                invmComoBalanceDealDetail.setCrtTime(nowDate);
                invmComoBalanceDealDetailDao.save(invmComoBalanceDealDetail);
                break;
            }
        }
    }

    /**
     * 目标货权人商品库存增加 、新增明细（记录的库存为增加）、 余量修改（增加）、 余量明细新增（记录的库存为增加）
     * 指定目标货权人源单据ID
     */
    private void comoReturnForSrcTran(LINV0106ISourceParam source, LINV0106IDealParam deal) {
        String userId = "WMS";
        Date nowDate = DateUtils.getCurrent();

        // 目标货权人商品库存增加
        InvmComoInventory invmComoInventory = new InvmComoInventory();
        invmComoInventory.setOwnerId(deal.getTargetId());
        invmComoInventory.setOwnerCode(deal.getTargetCode());
        invmComoInventory.setOwnerType(deal.getTargetType());
        invmComoInventory.setCommodityId(String.valueOf(source.getCommodityId()));
        invmComoInventory.setIvType(source.getIvType());
        invmComoInventory.setLaId(source.getLogicAreaId());
        invmComoInventory.setSplatCode(source.getSalePlatform());
        invmComoInventory.setComoIvType(source.getComoIvType());
        InvmComoInventory comoInventory = invmComoInventoryDao.findOne(invmComoInventory);
        BigDecimal qty=deal.getReturnQty();
        comoInventory.setIvQty(qty);
        int updateComoInvResult = this.modifyComoInv(comoInventory);
        if (updateComoInvResult == NumberConst.IntDef.INT_ZERO) {
            throw new BusinessException("LINV.COMO_DEAL_RETURN", "退货方商品库存减少失败");
        }

        // 新增明细（记录的库存为增加）
       // deal.setReturnQty(BigDecimal.ZERO.subtract(deal.getReturnQty()));
        Long storeDealId=baseRedisDao.getTablePrimaryKey("invm_como_deal_detail", 1);
        int saveComoDealDetailResult = this.saveComoDealDetail(comoInventory, deal,storeDealId,qty);
        if (saveComoDealDetailResult == NumberConst.IntDef.INT_ZERO) {
            throw new BusinessException("LINV.COMO_DEAL_RETURN", "新增货权人商品交易明细失败");
        }

        // 余量修改（增加）
        InvmComoBalanceInventory invmComoBalanceInventory = new InvmComoBalanceInventory();
        invmComoBalanceInventory.setStoreNo(comoInventory.getStoreNo());
        invmComoBalanceInventory.setTransactionId(deal.getSrcTransactionId());
        invmComoBalanceInventory.setTransactionNo(deal.getSrcTransactionNo());
        invmComoBalanceInventory.setTransactionDetailId(deal.getSrcTransactionDetailId());
        List<InvmComoBalanceInventory> comBalanList = invmComoBalanceInventoryDao
            .findAlltoSub(invmComoBalanceInventory);
        if (comBalanList.size() == 0) {
            throw new BusinessException("LINV.COMO_DEAL_RETURN", "未找到指定目标方余量库存");
        }

        BigDecimal dealQty = deal.getReturnQty();

        // 指定目标方只有一条记录
        InvmComoBalanceInventory comBalan = comBalanList.get(0);
        invmComoBalanceInventory.setInvId(comBalan.getInvId());
        invmComoBalanceInventory.setUpdId(userId);
        invmComoBalanceInventory.setUpdTime(nowDate);
        BigDecimal availableQty = comBalan.getOutboundQty();
        if (dealQty.compareTo(availableQty) <= 0) {
            invmComoBalanceInventory.setOutboundQty(BigDecimal.valueOf(0).subtract(dealQty));
            invmComoBalanceInventoryDao.modify(invmComoBalanceInventory);

            // 余量明细新增（记录的库存为增加）
            InvmComoBalanceDealDetail invmComoBalanceDealDetail = new InvmComoBalanceDealDetail();
            invmComoBalanceDealDetail.setDetailId(baseRedisDao.getTablePrimaryKey("invm_como_aloc_deal_detail", 1));
            invmComoBalanceDealDetail.setStoreDealId(storeDealId);
            invmComoBalanceDealDetail.setOwnerId(comoInventory.getOwnerId());
            invmComoBalanceDealDetail.setBalanceInvId(comBalan.getInvId());
            invmComoBalanceDealDetail.setSrcTransactionId(comBalan.getTransactionId());
            invmComoBalanceDealDetail.setSrcTransactionNo(comBalan.getTransactionNo());
            invmComoBalanceDealDetail.setSrcTransactionDetailId(comBalan.getTransactionDetailId());
            invmComoBalanceDealDetail.setDealQty(dealQty);
            invmComoBalanceDealDetail.setCrtId(userId);
            invmComoBalanceDealDetail.setCrtTime(nowDate);
            invmComoBalanceDealDetailDao.save(invmComoBalanceDealDetail);
        } else {
            throw new BusinessException("LINV.COMO_DEAL_RETURN", "指定目标方余量库存不足");
        }
    }

    /**
     * 目标货权人商品库存增加 、新增明细（记录的库存为增加）、 余量修改（增加）、 余量明细新增（记录的库存为增加）
     * 不指定目标货权人源单据ID
     */
    private void comoReturn(LINV0106ISourceParam source, LINV0106IDealParam deal) {
        String userId = "WMS";
        Date nowDate = DateUtils.getCurrent();

        // 目标货权人商品库存增加
        InvmComoInventory invmComoInventory = new InvmComoInventory();
        invmComoInventory.setOwnerId(deal.getTargetId());
        invmComoInventory.setOwnerCode(deal.getTargetCode());
        invmComoInventory.setOwnerType(deal.getTargetType());
        invmComoInventory.setCommodityId(String.valueOf(source.getCommodityId()));
        invmComoInventory.setIvType(source.getIvType());
        invmComoInventory.setLaId(source.getLogicAreaId());
        invmComoInventory.setSplatCode(source.getSalePlatform());
        invmComoInventory.setComoIvType(source.getComoIvType());
        InvmComoInventory comoInventory = invmComoInventoryDao.findOne(invmComoInventory);
        BigDecimal qty=deal.getReturnQty();
        comoInventory.setIvQty(qty);
        int updateComoInvResult = this.modifyComoInv(comoInventory);
        if (updateComoInvResult == NumberConst.IntDef.INT_ZERO) {
            throw new BusinessException("LINV.COMO_DEAL_RETURN", "退货方商品库存减少失败");
        }

        // 新增明细（记录的库存为增加）
        Long storeDealId=baseRedisDao.getTablePrimaryKey("invm_como_deal_detail", 1);
        int saveComoDealDetailResult = this.saveComoDealDetail(comoInventory, deal,storeDealId,qty);
        if (saveComoDealDetailResult == NumberConst.IntDef.INT_ZERO) {
            throw new BusinessException("LINV.COMO_DEAL_RETURN", "新增货权人商品交易明细失败");
        }

        // 余量修改（增加）
        InvmComoBalanceInventory invmComoBalanceInventory = new InvmComoBalanceInventory();
        invmComoBalanceInventory.setStoreNo(comoInventory.getStoreNo());
        List<InvmComoBalanceInventory> comBalanList = invmComoBalanceInventoryDao
            .findAlltoSub(invmComoBalanceInventory);
        if (comBalanList.size() == 0) {
            throw new BusinessException("LINV.COMO_DEAL_RETURN", "未找到目标方余量库存");
        }
        BigDecimal dealQty = deal.getReturnQty();

        // 先进先出的规则进行余量的增加
        for (int i = 0; i < comBalanList.size(); i++) {
            invmComoBalanceInventory.setInvId(comBalanList.get(i).getInvId());
            invmComoBalanceInventory.setUpdId(userId);
            invmComoBalanceInventory.setUpdTime(nowDate);
            BigDecimal availableQty = comBalanList.get(i).getOutboundQty();
            if (dealQty.compareTo(availableQty) > 0) {
                invmComoBalanceInventory.setOutboundQty(BigDecimal.valueOf(0).subtract(availableQty));
                invmComoBalanceInventoryDao.modify(invmComoBalanceInventory);

                // 余量明细新增（记录的库存为增加）
                InvmComoBalanceDealDetail invmComoBalanceDealDetail = new InvmComoBalanceDealDetail();
                invmComoBalanceDealDetail.setDetailId(baseRedisDao.getTablePrimaryKey("invm_como_aloc_deal_detail", 1));
                invmComoBalanceDealDetail.setStoreDealId(storeDealId);
                invmComoBalanceDealDetail.setOwnerId(comoInventory.getOwnerId());
                invmComoBalanceDealDetail.setBalanceInvId(comBalanList.get(i).getInvId());
                invmComoBalanceDealDetail.setSrcTransactionId(comBalanList.get(i).getTransactionId());
                invmComoBalanceDealDetail.setSrcTransactionNo(comBalanList.get(i).getTransactionNo());
                invmComoBalanceDealDetail.setSrcTransactionDetailId(comBalanList.get(i).getTransactionDetailId());
                invmComoBalanceDealDetail.setDealQty(availableQty);
                invmComoBalanceDealDetail.setCrtId(userId);
                invmComoBalanceDealDetail.setCrtTime(nowDate);
                invmComoBalanceDealDetailDao.save(invmComoBalanceDealDetail);

                dealQty = dealQty.subtract(availableQty);
            } else {
                invmComoBalanceInventory.setOutboundQty(BigDecimal.valueOf(0).subtract(dealQty));
                invmComoBalanceInventoryDao.modify(invmComoBalanceInventory);

                // 余量明细新增（记录的库存为增加）
                InvmComoBalanceDealDetail invmComoBalanceDealDetail = new InvmComoBalanceDealDetail();
                invmComoBalanceDealDetail.setDetailId(baseRedisDao.getTablePrimaryKey("invm_como_aloc_deal_detail", 1));
                invmComoBalanceDealDetail.setStoreDealId(storeDealId);
                invmComoBalanceDealDetail.setOwnerId(comoInventory.getOwnerId());
                invmComoBalanceDealDetail.setBalanceInvId(comBalanList.get(i).getInvId());
                invmComoBalanceDealDetail.setSrcTransactionId(comBalanList.get(i).getTransactionId());
                invmComoBalanceDealDetail.setSrcTransactionNo(comBalanList.get(i).getTransactionNo());
                invmComoBalanceDealDetail.setSrcTransactionDetailId(comBalanList.get(i).getTransactionDetailId());
                invmComoBalanceDealDetail.setDealQty(dealQty);
                invmComoBalanceDealDetail.setCrtId(userId);
                invmComoBalanceDealDetail.setCrtTime(nowDate);
                invmComoBalanceDealDetailDao.save(invmComoBalanceDealDetail);
                break;
            }
        }

    }

    /**
     * 查询货权人商品占用
     */
    @Override
    public InvmComoAlocInventory findComoAlocInv(LINV0106ISourceParam param) {
        return comoInvReturnCompleteDao.findComoAlocInv(param);
    }

    /**
     * 查询货权人商品库存
     */
    @Override
    public InvmComoInventory findComoInv(LINV0106ISourceParam param) {
        return comoInvReturnCompleteDao.findComoInv(param);
    }

    /**
     * 退货方商品库存减少
     */
    @Override
    public int modifyComoInv(InvmComoInventory comoInventory) {
        return comoInvReturnCompleteDao.modifyComoInv(comoInventory);
    }

    /**
     * 新增货权人商品占用明细
     */
    private InvmComoAlocDealDetail newComoAlocDealDetail(InvmComoAlocInventory comoAlocInventory,
        LINV0106IDealParam deal) {
        Date nowDate = DateUtils.getCurrent();
        String userId = "WMS";
        InvmComoAlocDealDetail comoAlocDealDetail = new InvmComoAlocDealDetail();
        comoAlocDealDetail.setAlocNo(comoAlocInventory.getAlocNo());
        comoAlocDealDetail.setTransactionId(deal.getTransactionId());
        comoAlocDealDetail.setTransactionNo(deal.getTransactionNo());
        comoAlocDealDetail.setTransactionDetailId(deal.getTransactionDetailId());
        comoAlocDealDetail.setTransactionSequence(deal.getTransactionSequence());
        comoAlocDealDetail.setTransactionSource(deal.getTransactionSource());
        comoAlocDealDetail.setTransactionType(InvmComoInvReturnCompleteService.TRANSACTION_TYPE);
        comoAlocDealDetail.setTransactionTime(nowDate);
        comoAlocDealDetail.setRefNo(deal.getRefNo());
        comoAlocDealDetail.setBizType(deal.getBizType());
        comoAlocDealDetail.setAlocPrice(deal.getReturnPrice());
        comoAlocDealDetail.setAlocQty(deal.getReleaseQty());
        comoAlocDealDetail.setDelFlg(false);
        comoAlocDealDetail.setCrtId(userId);
        comoAlocDealDetail.setCrtTime(nowDate);
        comoAlocDealDetail.setVersion(NumberConst.IntDef.INT_ONE);
        return comoAlocDealDetail;
    }

    /**
     * 新增货权人商品交易明细
     */
    private int saveComoDealDetail(InvmComoInventory comoInventory, LINV0106IDealParam deal,Long storeDealId,BigDecimal qty) {
        Date nowDate = DateUtils.getCurrent();
        String userId = "WMS";
        InvmComoDealDetail comoDealDetail = new InvmComoDealDetail();
        comoDealDetail.setStoreDealId(storeDealId);
        comoDealDetail.setStoreNo(comoInventory.getStoreNo());
        comoDealDetail.setTransactionId(deal.getTransactionId());
        comoDealDetail.setTransactionNo(deal.getTransactionNo());
        comoDealDetail.setTransactionDetailId(deal.getTransactionDetailId());
        comoDealDetail.setTransactionSource(deal.getTransactionSource());
        comoDealDetail.setTransactionType(InvmComoInvReturnCompleteService.TRANSACTION_TYPE);
        comoDealDetail.setTransactionTime(nowDate);
        comoDealDetail.setRefNo(deal.getRefNo());
        comoDealDetail.setBizType(deal.getBizType());
        comoDealDetail.setDealPrice(deal.getReturnPrice());
        comoDealDetail.setDealQty(qty);
        if(qty.compareTo(BigDecimal.ZERO)<0){
            comoDealDetail.setTgtId(deal.getTargetId());
            comoDealDetail.setTgtCode(deal.getTargetCode());
            comoDealDetail.setTgtType(deal.getTargetType());
        }
        comoDealDetail.setDelFlg(false);
        comoDealDetail.setCrtId(userId);
        comoDealDetail.setCrtTime(nowDate);
        comoDealDetail.setVersion(NumberConst.IntDef.INT_ONE);
        int result = comoDealDetailService.save(comoDealDetail);
        return result;
    }

    /**
     * 商品库存业务单号重复验证
     *
     * @param params
     */
    private void checkComoTran(List<LINV0106IParam> params) {
        for (int i = 0; i < params.size(); i++) {
            LINV0106IDealParam deal = params.get(i).getDeal();
            InvmComoDealDetail dealDetail = new InvmComoDealDetail();
            dealDetail.setTransactionId(deal.getTransactionId());
            dealDetail.setTransactionNo(deal.getTransactionNo());
            dealDetail.setTransactionDetailId(deal.getTransactionDetailId());
            int count = invmComoDealDetailDao.count(dealDetail);
            if (count > 0) {
                throw new BusinessException("LINV_COMOIDITY", "业务单号重复");
            }
        }
    }

}
