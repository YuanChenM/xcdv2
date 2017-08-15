package com.bms.order.services.impl;

import com.bms.order.archive.impl.*;
import com.bms.order.archive.impl.list.BuyerForcastDeliverDetailList;
import com.bms.order.archive.impl.list.ReceiveNotificationDetailList;
import com.bms.order.bean.Blackboard;
import com.bms.order.bean.param.ORDR0808IBean;
import com.bms.order.constant.enumeration.BuyerReturnStu;
import com.bms.order.constant.i18n.ErrorCode;
import com.bms.order.constant.i18n.ModuleCode;
import com.bms.order.dao.*;
import com.bms.order.services.ORDR0808IService;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.DecimalUtils;
import com.framework.exception.BusinessException;
import com.framework.redis.dao.BaseRedisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2017/3/6.
 */
@Service
public class ORDR0808IServiceImpl implements ORDR0808IService {


    @Autowired
    private BaseRedisDao redisDao;

    @Autowired
    private BuyerReturnDao buyerReturnDao;

    @Autowired
    private BuyerReturnDetailDao buyerReturnDetailDao;

    @Autowired
    private BuyerForcastDeliverDetailDao buyerForcastDeliverDetailDao;

    @Autowired
    private BuyerForcastDeliverDetailAttachedDao buyerForcastDeliverDetailAttachedDao;

    @Autowired
    private ReceiveNotificationDetailDao receiveNotificationDetailDao;

    @Autowired
    private DistributionNotificationDetailDao distributionNotificationDetailDao;

    @Override
    public void execute(Operator operator, ORDR0808IBean bean) {
        // 本Service用参数传递容器
        HashMap<String, Object> map = new HashMap<>();
        Blackboard blackboard = new Blackboard();
        ;
        blackboard.setOperator(operator);
        map.put("param", bean);
        map.put("blackboard", blackboard);

        pre(map);
        process(map);
        post(map);
    }

    /**
     * 准备
     *
     * @param map HashMap
     */
    private void pre(HashMap<String, Object> map) {
        // 获取参数
        ORDR0808IBean param = (ORDR0808IBean) map.get("param");
        Blackboard blackboard = (Blackboard) map.get("blackboard");
        // 设置DAO
        // TODO 设置DAO
        blackboard.setBaseRedisDao(redisDao);
        blackboard.putBaseDao(buyerReturnDao);
        blackboard.putBaseDao(buyerReturnDetailDao);
        blackboard.putBaseDao(buyerForcastDeliverDetailDao);
        blackboard.putBaseDao(buyerForcastDeliverDetailAttachedDao);
        blackboard.putBaseDao(receiveNotificationDetailDao);
        blackboard.putBaseDao(distributionNotificationDetailDao);
        //操作者
        Operator operator = blackboard.getOperator();
        operator.setBlackboard(blackboard);
        // 获取完整操作者
        operator.complete(false);
        BuyerReturn buyerReturn = param.findBuyerReturnById();
        buyerReturn.setBlackboard(blackboard);
        map.put("buyerReturn",buyerReturn);
    }

    /**
     * 执行
     *
     * @param map HashMap
     */
    private void process(HashMap<String, Object> map) {
        // 获取参数
        ORDR0808IBean param = (ORDR0808IBean) map.get("param");
        BuyerReturn buyerReturn = (BuyerReturn) map.get("buyerReturn");
        buyerReturn.complete(false);
        if(!buyerReturn.isDataSynced()){
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E080801);
        }

        if(!param.getVer().equals(buyerReturn.getEntity().getVersion())){
            throw new BusinessException(ModuleCode.ORDR,ErrorCode.E080802);
        }

        if(!BuyerReturnStu.TO_CONFIRM.getCode().equals(buyerReturn.getEntity().getBuyerReturnStatus())){
            throw new BusinessException(ModuleCode.ORDR,ErrorCode.E080803, buyerReturn.getEntity().getReturnId().toString());
        }
        List<BuyerReturnDetail> buyerReturnDetails = buyerReturn.getBuyerReturnDetails();
        if(CollectionUtils.isEmpty(buyerReturnDetails)){
            throw new BusinessException(ModuleCode.ORDR,ErrorCode.E080804);
        }
        map.put("buyerReturnDetails",buyerReturnDetails);
        //更新买家退货单
        modifyBuyerReturn(map);
        //处理订单相关信息
        dealOrderInfo(map);

    }

    /**
     * 收尾
     *
     * @param map HashMap
     */
    private void post(HashMap<String, Object> map) {
        // 获取参数

        // 执行操作

    }


    /**
     * 更新退货单相关信息
     * @param map
     */
    private void modifyBuyerReturn(HashMap<String, Object> map){
        //获取参数
        ORDR0808IBean param = (ORDR0808IBean) map.get("param");
        BuyerReturn buyerReturn = (BuyerReturn) map.get("buyerReturn");
        buyerReturn.getEntity().setConfirmType(param.getConfirmType());
        buyerReturn.getEntity().setBuyerConfirmUserType(param.getConfirmUserType());
        buyerReturn.getEntity().setConfirmUid(param.getConfirmUid());
        buyerReturn.getEntity().setConfirmUname(param.getConfirmUname());
        Date confirmTime = DateUtils.parse("yyyy-MM-dd HH:mm:ss",param.getConfirmTime());
        buyerReturn.getEntity().setConfirmTime(confirmTime);
        buyerReturn.getEntity().setConfirmRemark(param.getConfirmRemark());
        buyerReturn.getEntity().setBuyerReturnStatus(BuyerReturnStu.CANCEL.getCode());
        buyerReturn.modify();
    }

    /**
     * 更新订单相关信息状态
     * @param map
     */
    private void dealOrderInfo(HashMap<String, Object> map){

        Blackboard blackboard = (Blackboard) map.get("blackboard");
        List<BuyerReturnDetail> buyerReturnDetails = (List<BuyerReturnDetail>) map.get("buyerReturnDetails");
        List<ReceiveNotificationDetail> receiveNotificationDetails = new ArrayList<>();
        List<BuyerForcastDeliverDetail> buyerForcastDeliverDetails = new ArrayList<>();
        for(BuyerReturnDetail buyerReturnDetail : buyerReturnDetails){
            //收货明细ID
            Long receiveDetailId = buyerReturnDetail.getEntity().getReceiveNotificationDetailId();
            //退货单ID
            Long returnId = buyerReturnDetail.getEntity().getReturnId();
            //退货明细中退货数量
            BigDecimal returnedQty = buyerReturnDetail.getEntity().getReturnQty();
            ReceiveNotificationDetail receiveNotificationDetail = ReceiveNotificationDetail.build(blackboard).forComplete(receiveDetailId);
            receiveNotificationDetail.complete(false);
            if(!receiveNotificationDetail.isDataSynced()){
                throw new BusinessException(ModuleCode.ORDR,ErrorCode.E080805);
            }
            //设置收货明细表中退货数量
            receiveNotificationDetail.getEntity().setReturnQuantity(DecimalUtils.subtract(
                    receiveNotificationDetail.getEntity().getReturnQuantity(),returnedQty));
            receiveNotificationDetails.add(receiveNotificationDetail);
            //配送明细
            Long distributionDetailId = buyerReturnDetail.getEntity().getDistributionNotificationDetailId();
            DistributionNotificationDetail distributionNotificationDetail = DistributionNotificationDetail.build(blackboard).
                    forComplete(distributionDetailId);
            distributionNotificationDetail.complete(false);
            if(!distributionNotificationDetail.isDataSynced()){
                throw new BusinessException(ModuleCode.ORDR,ErrorCode.E080806);
            }

            BuyerForcastDeliverDetail buyerForcastDeliverDetail = distributionNotificationDetail.getBuyerForcastDeliverDetail();
            if(null == buyerForcastDeliverDetail){
                throw new BusinessException(ModuleCode.ORDR,ErrorCode.E080807);
            }
            //设置预配送明细表中退货数量
            buyerForcastDeliverDetail.getEntity().setReturnQuantity(DecimalUtils.subtract(
                    buyerForcastDeliverDetail.getEntity().getReturnQuantity(),returnedQty));
            buyerForcastDeliverDetails.add(buyerForcastDeliverDetail);
        }
        //更新收货明细退货数量
        ReceiveNotificationDetailList receiveNotificationDetailList = ReceiveNotificationDetailList.build(blackboard).forUpdate(
                receiveNotificationDetails.toArray(new ReceiveNotificationDetail[0]));
        receiveNotificationDetailList.modify();
        //更新预配送明细退货数量
        BuyerForcastDeliverDetailList buyerForcastDeliverDetailList = BuyerForcastDeliverDetailList.build(blackboard).forUpdate(
                buyerForcastDeliverDetails.toArray(new BuyerForcastDeliverDetail[0]));
        buyerForcastDeliverDetailList.modify();
    }
}
