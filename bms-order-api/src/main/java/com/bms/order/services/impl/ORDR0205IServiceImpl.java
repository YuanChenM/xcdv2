package com.bms.order.services.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.order.archive.impl.BuyerBatchOrderDetail;
import com.bms.order.archive.impl.Operator;
import com.bms.order.bean.Blackboard;
import com.bms.order.bean.param.ORDR0205IBeanParam;
import com.bms.order.constant.i18n.ErrorCode;
import com.bms.order.constant.i18n.ModuleCode;
import com.bms.order.dao.BuyerBatchOrderDetailAttachedDao;
import com.bms.order.dao.BuyerBatchOrderDetailDao;
import com.bms.order.services.ORDR0205IService;
import com.framework.exception.BusinessException;
import com.framework.redis.dao.BaseRedisDao;

/**
 * 订单手动分拆阈值设定接口Service
 *
 * @author li_huiqian
 */
@Service
public class ORDR0205IServiceImpl implements ORDR0205IService {

    @Autowired
    private BaseRedisDao baseRedisDao;

    @Autowired
    private BuyerBatchOrderDetailDao buyerBatchOrderDetailDao;

    @Autowired
    private BuyerBatchOrderDetailAttachedDao buyerBatchOrderDetailAttachedDao;
    /**
     * 设定是否进行手动分拆
     *
     * @param operator 操作者
     * @param param    ORDR0205IBeanParam
     */
    @Override
    public void execute(Operator operator, ORDR0205IBeanParam param) {
        // 本Service用参数传递容器
        HashMap<String, Object> map = new HashMap<>();
        Blackboard blackboard = new Blackboard();
        blackboard.setOperator(operator);
        map.put("param", param);
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
        ORDR0205IBeanParam param = (ORDR0205IBeanParam) map.get("param");
        Blackboard blackboard = (Blackboard) map.get("blackboard");
        // 设置DAO.
        blackboard.setBaseRedisDao(baseRedisDao);
        blackboard.putBaseDao(buyerBatchOrderDetailDao);
        blackboard.putBaseDao(buyerBatchOrderDetailAttachedDao);
        //操作者
        Operator operator = blackboard.getOperator();
        operator.setBlackboard(blackboard);
        // 获取完整操作者
        operator.complete(false);

        // 获取分批订单明细
        BuyerBatchOrderDetail buyerBatchOrderDetail = param.generateBuyerBatchOrderDetail();
        buyerBatchOrderDetail.setBlackboard(blackboard);
        BuyerBatchOrderDetail modified = param.modified();

        // 返回参数
        map.put("buyerBatchOrderDetail", buyerBatchOrderDetail);
        map.put("modified", modified);
    }

    /**
     * 执行
     *
     * @param map HashMap
     */
    private void process(HashMap<String, Object> map) {
        // 获取参数
        BuyerBatchOrderDetail buyerBatchOrderDetail = (BuyerBatchOrderDetail) map.get("buyerBatchOrderDetail");
        BuyerBatchOrderDetail modified = (BuyerBatchOrderDetail) map.get("modified");
        // 处理
        splitSettings(buyerBatchOrderDetail,modified);
        // 返回参数
    }

    /**
     * 收尾
     *
     * @param map HashMap
     */
    private void post(HashMap<String, Object> map) {
        // 获取参数

        // 返回参数

    }


    private void splitSettings(BuyerBatchOrderDetail buyerBatchOrderDetail, BuyerBatchOrderDetail modified) {
        buyerBatchOrderDetail.complete(false);
        if (!buyerBatchOrderDetail.isDataSynced()) {
            throw new BusinessException(ModuleCode.ORDR,
                    ErrorCode.E020501 + buyerBatchOrderDetail.getEntity().getBuyerBatchOrderDetailId());
            // 国际化
        }
        buyerBatchOrderDetail.getEntity().setManualSplitFlg(modified.getEntity().getManualSplitFlg());

        buyerBatchOrderDetail.modify();
    }

}
