package com.bms.order.services.impl;

import com.bms.order.archive.impl.*;
import com.bms.order.bean.Blackboard;
import com.bms.order.bean.entity.BsReturnDetailEntity;
import com.bms.order.bean.entity.BsReturnEntity;
import com.bms.order.bean.entity.BsStockpileSplitDetailEntity;
import com.bms.order.bean.param.ORDR0902IBean;
import com.bms.order.bean.param.ORDR0905IBean;
import com.bms.order.constant.enumeration.BsOrderType;
import com.bms.order.constant.enumeration.BsReturnStu;
import com.bms.order.constant.i18n.ErrorCode;
import com.bms.order.constant.i18n.ModuleCode;
import com.bms.order.dao.*;
import com.bms.order.services.ORDR0902IService;
import com.bms.order.services.ORDR0905IService;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.DecimalUtils;
import com.framework.exception.BusinessException;
import com.framework.redis.dao.BaseRedisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

/**
 * 买手退货单确认接口Service
 *
 * @author li_huiqian
 */
@Service
public class ORDR0905IServiceImpl implements ORDR0905IService {

    @Autowired
    private BaseRedisDao redisDao;
    @Autowired
    private BsOrderDao bsOrderDao;
    @Autowired
    private BsOrderAttachedDao bsOrderAttachedDao;
    @Autowired
    private BsStockpileSplitDetailDao bsStockpileSplitDetailDao;
    @Autowired
    private BsStockpileSplitDetailAttachedDao bsStockpileSplitDetailAttachedDao;
    @Autowired
    private BsReturnDao bsReturnDao;
    @Autowired
    private BsReturnDetailDao bsReturnDetailDao;


    /**
     * 接收买手退回确认信息，更改退货状态
     *
     * @param operator 操作者
     * @param bean     ORDR0902IBean
     */
    @Override
    public void execute(Operator operator, ORDR0905IBean bean) {
        // 本Service用参数传递容器
        HashMap<String, Object> map = new HashMap<>();
        Blackboard blackboard = new Blackboard();
        ;
        blackboard.setOperator(operator);
        map.put("bean", bean);
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
        ORDR0905IBean param = (ORDR0905IBean) map.get("bean");
        Blackboard blackboard = (Blackboard) map.get("blackboard");
        // 设置DAO
        blackboard.setBaseRedisDao(redisDao);
        blackboard.putBaseDao(bsOrderDao);
        blackboard.putBaseDao(bsReturnDao);
        blackboard.putBaseDao(bsReturnDetailDao);
        blackboard.putBaseDao(bsOrderAttachedDao);
        blackboard.putBaseDao(bsStockpileSplitDetailDao);
        blackboard.putBaseDao(bsStockpileSplitDetailAttachedDao);
        //操作者
        Operator operator = blackboard.getOperator();
        operator.setBlackboard(blackboard);
        // 获取完整操作者
        operator.complete(false);
        BsReturn bsReturn = this.checkBsReturnStu(param, blackboard);
        // 返回参数
        map.put("bsReturn", bsReturn);
    }

    /**
     * 执行
     *
     * @param map HashMap
     */
    private void process(HashMap<String, Object> map) {
        // 获取参数
        BsReturn bsReturn = (BsReturn) map.get("bsReturn");
        ORDR0905IBean param = (ORDR0905IBean) map.get("bean");
        // 执行操作
        BsReturnEntity bsReturnEntity = bsReturn.getEntity();
        bsReturnEntity.setBsReturnStu(BsReturnStu.CANCEL.getCode());//根据接口传递的接口信息更新退货单主表信息，状态为“已取消”
        bsReturnEntity.setConfirmUid(param.getConfirmUid());
        bsReturnEntity.setConfirmUname(param.getConfirmUname());
        bsReturnEntity.setConfirmRemark(param.getConfirmRemark());
        bsReturnEntity.setConfirmTime(DateUtils.parseDateTime(param.getConfirmTime()));
        bsReturn.modify();
        List<BsReturnDetail> bsReturnDetailList = bsReturn.getBsReturnDetails();
        if (CollectionUtils.isNotEmpty(bsReturnDetailList)) {// 设置退货明细数量
            for (BsReturnDetail bsReturnDetail : bsReturnDetailList) {
                BsReturnDetailEntity bsReturnDetailEntity = bsReturnDetail.getEntity();
                BigDecimal returnQty = bsReturnDetailEntity.getReturnQty();// 已经退货的
                Long bsStockpileSplitDetailId = bsReturnDetailEntity.getBsStockpileSplitDetailId();
                BsStockpileSplitDetail bsStockpileSplitDetail = new BsStockpileSplitDetail(bsStockpileSplitDetailId);
                bsStockpileSplitDetail.setBlackboard(bsReturn.getBlackboard());
                bsStockpileSplitDetail.complete(false);
                if (!bsStockpileSplitDetail.isDataSynced()) {
                    throw new BusinessException(ModuleCode.ORDR, ErrorCode.E090504,bsStockpileSplitDetailId.toString());
                }
                BsStockpileSplitDetailEntity bsStockpileSplitDetailEntity = bsStockpileSplitDetail.getEntity();
                BigDecimal returnQuantity = bsStockpileSplitDetailEntity.getReturnQuantity();
                bsStockpileSplitDetailEntity.setReturnQuantity(DecimalUtils.subtract(returnQuantity,returnQty));
                bsStockpileSplitDetail.modify();
            }
        }

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
     * 需要是待确认状态的退货单才能被确认
     *
     * @param bean
     * @param blackboard
     */
    private BsReturn checkBsReturnStu(ORDR0905IBean bean, Blackboard blackboard) {
        BsReturn bsReturn = new BsReturn(bean.getReturnId());
        bsReturn.setBlackboard(blackboard);
        bsReturn.complete(false);
        if (!bsReturn.isDataSynced()) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E090501);
        }
        BsReturnEntity bsReturnEntity = bsReturn.getEntity();
        if (!bsReturnEntity.getVersion().equals(bean.getVer())) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E090502);
        }
        String stu = bsReturnEntity.getBsReturnStu();
        if (!(stu != null && stu.equals(BsReturnStu.TO_CONFIRM.getCode()))) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E090503);
        }
        return bsReturn;
    }


}
