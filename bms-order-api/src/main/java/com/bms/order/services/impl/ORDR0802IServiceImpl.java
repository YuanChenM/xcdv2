package com.bms.order.services.impl;

import java.math.BigDecimal;
import java.util.*;

import com.bms.order.archive.impl.*;
import com.bms.order.archive.impl.list.DistributionNotificationDetailList;
import com.bms.order.archive.impl.list.DistributionNotificationList;
import com.bms.order.constant.enumeration.BuyerBatchOrderStu;
import com.bms.order.constant.enumeration.BuyerOrderStu;
import com.bms.order.constant.enumeration.BuyerReturnStu;
import com.bms.order.constant.enumeration.DistributionNotificationStu;
import com.bms.order.constant.i18n.ErrorCode;
import com.bms.order.constant.i18n.ModuleCode;
import com.bms.order.dao.*;
import com.bms.order.external.archive.Issue;
import com.bms.order.external.bean.param.ISSU0105IFilter;
import com.bms.order.external.bean.result.ISSU0105IRestResult;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.DecimalUtils;
import com.framework.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bms.order.bean.Blackboard;
import com.bms.order.bean.param.ORDR0802IBean;
import com.bms.order.services.ORDR0802IService;
import com.framework.redis.dao.BaseRedisDao;

/**
 * 买家退货单确认接口Service
 *
 * @author li_huiqian
 */
@Service
public class ORDR0802IServiceImpl implements ORDR0802IService {

    @Autowired
    private BaseRedisDao redisDao;

    @Autowired
    private BuyerReturnDao buyerReturnDao;

    @Autowired
    private BuyerReturnDetailDao buyerReturnDetailDao;

    @Autowired
    private BuyerOrderDao buyerOrderDao;

    @Autowired
    private BuyerOrderAttachedDao buyerOrderAttachedDao;

    @Autowired
    private BuyerBatchOrderDao buyerBatchOrderDao;

    @Autowired
    private BuyerBatchOrderAttachedDao buyerBatchOrderAttachedDao;

    @Autowired
    private BuyerForcastDeliverDetailDao buyerForcastDeliverDetailDao;

    @Autowired
    private BuyerForcastDeliverDetailAttachedDao buyerForcastDeliverDetailAttachedDao;

    @Autowired
    private DistributionNotificationDao distributionNotificationDao;

    @Autowired
    private DistributionNotificationDetailDao distributionNotificationDetailDao;


    /**
     * 接收买家平台退货的确认信息，更改退货单状态
     *
     * @param operator 操作者
     * @param bean     ORDR0802IBean
     */
    @Override
    public void execute(Operator operator, ORDR0802IBean bean) {
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
        ORDR0802IBean param = (ORDR0802IBean) map.get("param");
        Blackboard blackboard = (Blackboard) map.get("blackboard");
        // 设置DAO
        blackboard.setBaseRedisDao(redisDao);
        blackboard.putBaseDao(buyerReturnDao);
        blackboard.putBaseDao(buyerReturnDetailDao);
        blackboard.putBaseDao(buyerOrderDao);
        blackboard.putBaseDao(buyerOrderAttachedDao);
        blackboard.putBaseDao(buyerBatchOrderDao);
        blackboard.putBaseDao(buyerBatchOrderAttachedDao);
        blackboard.putBaseDao(buyerForcastDeliverDetailDao);
        blackboard.putBaseDao(buyerForcastDeliverDetailAttachedDao);
        blackboard.putBaseDao(distributionNotificationDao);
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
        ORDR0802IBean param = (ORDR0802IBean) map.get("param");
        BuyerReturn buyerReturn = (BuyerReturn) map.get("buyerReturn");
        buyerReturn.complete(false);
        if(!buyerReturn.isDataSynced()){
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E080201);
        }

        if(!param.getVer().equals(buyerReturn.getEntity().getVersion())){
            throw new BusinessException(ModuleCode.ORDR,ErrorCode.E080202);
        }

        if(!BuyerReturnStu.TO_CONFIRM.getCode().equals(buyerReturn.getEntity().getBuyerReturnStatus())){
            throw new BusinessException(ModuleCode.ORDR,ErrorCode.E080203, buyerReturn.getEntity().getReturnId().toString());
        }
        checkIssue(buyerReturn.getEntity().getOrderId());
        //更新买家退货单
        modifyBuyerReturn(map);
        //处理订单相关信息
        dealOrderInfo(map);
        // 执行操作

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
        ORDR0802IBean param = (ORDR0802IBean) map.get("param");
        BuyerReturn buyerReturn = (BuyerReturn) map.get("buyerReturn");
        buyerReturn.getEntity().setConfirmUid(param.getConfirmUid());
        buyerReturn.getEntity().setConfirmUname(param.getConfirmUname());
        buyerReturn.getEntity().setBuyerConfirmUserType(param.getConfirmUserType());
        buyerReturn.getEntity().setConfirmType(param.getConfirmType());
        Date confirmTime = DateUtils.parse("yyyy-MM-dd HH:mm:ss",param.getConfirmTime());
        buyerReturn.getEntity().setConfirmTime(confirmTime);
        buyerReturn.getEntity().setConfirmRemark(param.getConfirmRemark());
        buyerReturn.getEntity().setBuyerReturnStatus(BuyerReturnStu.CONFIRMED.getCode());
        buyerReturn.modify();
    }

    /**
     * 更新订单相关信息状态
     * @param map
     */
    private void dealOrderInfo(HashMap<String, Object> map){
        //获取参数
        Blackboard blackboard = (Blackboard) map.get("blackboard");
        BuyerReturn buyerReturn = (BuyerReturn) map.get("buyerReturn");
        Long orderId = buyerReturn.getEntity().getOrderId();
        Long returnId = buyerReturn.getEntity().getReturnId();
        BuyerOrder buyerOrder = BuyerOrder.build(blackboard).forComplete(orderId);
        buyerOrder.complete(false);
        if(!buyerOrder.isDataSynced()){
            throw new BusinessException(ModuleCode.ORDR,ErrorCode.E080204);
        }

        //判断配送单是否全部退货,全部退货则更新配送单状态为全部退货
        List<BuyerReturnDetail> returnDetails = buyerReturn.getBuyerReturnDetails();
        //配送明细ID
        List<Long> disIds = new ArrayList<>();
        Map<Long,Long> idsMap = new HashMap<>();
        for(BuyerReturnDetail buyerReturnDetail : returnDetails){
            idsMap.put(buyerReturnDetail.getEntity().getDistributionNotificationId(),buyerReturnDetail.getEntity().getDistributionNotificationId());
        }
        for(Long id : idsMap.keySet()){
            disIds.add(id);
        }
        DistributionNotificationList distributionNotificationList =
                DistributionNotificationList.build(blackboard).forComplete(disIds.toArray(new Long[0]));
        distributionNotificationList.complete(false);
        //查询每张配送通知单下面所有的配送明细
        for(DistributionNotification distributionNotification : distributionNotificationList.getArchives()){
            List<DistributionNotificationDetail> distributionNotificationDetails = distributionNotification.getDistributionNotificationDetails();
            //该配送单下所有退货数量
            BigDecimal totalReturnQty = BigDecimal.ZERO;
            //该配送单下所有配送数量
            BigDecimal totalSendQty = BigDecimal.ZERO;
            for(DistributionNotificationDetail distributionNotificationDetail : distributionNotificationDetails){
                BuyerForcastDeliverDetail buyerForcastDeliverDetail = distributionNotificationDetail.getBuyerForcastDeliverDetail();
                //拒收数量
                BigDecimal rejectQty = buyerForcastDeliverDetail.getEntity().getRejectQuantity();
                //退货数量
                BigDecimal returnQty = buyerForcastDeliverDetail.getEntity().getReturnQuantity();
                //退货总数量
                totalReturnQty = DecimalUtils.add(totalReturnQty,DecimalUtils.add(rejectQty,returnQty));
                //配送总数量
                totalSendQty = DecimalUtils.add(totalSendQty,distributionNotificationDetail.getEntity().getDistributionQuantity());
            }
            //更新配送通知单全部退货状态
            if(totalSendQty.compareTo(totalReturnQty) == 0){
                distributionNotification.getEntity().setDistributionNotificationStu(DistributionNotificationStu.ALL_RETURN.getCode());
                distributionNotification.modify();
            }
        }


        //只判断状态已完成的订单
        if(BuyerOrderStu.ALREADY_COMPLETED.getCode().equals(buyerOrder.getEntity().getBuyerOrderStu())){
            List<BuyerBatchOrder> buyerBatchOrders = buyerOrder.getBuyerBatchOrders();
            if(CollectionUtils.isEmpty(buyerBatchOrders)){
                throw new BusinessException(ModuleCode.ORDR,ErrorCode.E080205);
            }
            //全部退货的分批订单集合
            List<BuyerBatchOrder> allReturnBatchOrders = new ArrayList<>();
            for(BuyerBatchOrder buyerBatchOrder : buyerBatchOrders){
                if (buyerBatchOrder.getEntity().getBuyerBatchOrderStu().equals(BuyerBatchOrderStu.CANCEL.getCode())){
                    allReturnBatchOrders.add(buyerBatchOrder);
                    continue;
                }
                List<BuyerForcastDeliverDetail> buyerForcastDeliverDetails = buyerBatchOrder.getBuyerForcastDeliverDetails();
                if(CollectionUtils.isEmpty(buyerForcastDeliverDetails)){
                    throw new BusinessException(ModuleCode.ORDR,ErrorCode.E080206,buyerReturn.getEntity().getReturnId().toString());
                }
                //全部退货的预配送明细集合
                List<BuyerForcastDeliverDetail> allReturnForcastDetais = new ArrayList<>();
                for(BuyerForcastDeliverDetail buyerForcastDeliverDetail : buyerForcastDeliverDetails){
                    //迟收数量
                    BigDecimal delayQty = buyerForcastDeliverDetail.getEntity().getDelayQuantity();
                    if(null == delayQty || BigDecimal.ZERO.compareTo(delayQty) == 0){
                        //拒收数量
                        BigDecimal rejectQty = buyerForcastDeliverDetail.getEntity().getRejectQuantity();
                        //退货数量
                        BigDecimal returnQty = buyerForcastDeliverDetail.getEntity().getReturnQuantity();
                        //实际发货数量
                        BigDecimal realSendQty = buyerForcastDeliverDetail.getEntity().getRealSendQuantity();
                        //退货总数量
                        BigDecimal totalReturnQty = DecimalUtils.add(rejectQty,returnQty);
                        BigDecimal subtractQty = DecimalUtils.subtract(realSendQty,totalReturnQty);
                        if(subtractQty.compareTo(BigDecimal.ZERO) == 0){
                            allReturnForcastDetais.add(buyerForcastDeliverDetail);
                        }

                    }
                }
                if(allReturnForcastDetais.containsAll(buyerForcastDeliverDetails)){
                    allReturnBatchOrders.add(buyerBatchOrder);
                }
            }
            if(allReturnBatchOrders.containsAll(buyerBatchOrders)){
                //更新买家分批订单状态为全部退货
                for(BuyerBatchOrder buyerBatchOrder : buyerBatchOrders){
                    buyerBatchOrder.getEntity().setBuyerBatchOrderStu(BuyerBatchOrderStu.ALL_RETURN.getCode());
                    buyerBatchOrder.modify();
                }
                //更新买家订单状态为全部退货
                buyerOrder.getEntity().setBuyerOrderStu(BuyerOrderStu.RETURNED.getCode());
                buyerOrder.modify();
            }
        }
    }

    /**
     * 查看是否已创建问题订单
     * @param orderId
     */
    private void checkIssue(Long orderId){
        ISSU0105IFilter filter = new ISSU0105IFilter();
        filter.setOrderId(new Long[]{orderId});
        BaseRestPaginationResult<ISSU0105IRestResult> result = Issue.queryIssueOrder(filter);
        if (result==null || CollectionUtils.isEmpty(result.getData())){
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E080207, orderId.toString());
        }
    }
}
