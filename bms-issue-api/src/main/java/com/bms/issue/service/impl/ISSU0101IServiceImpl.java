package com.bms.issue.service.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.common.rest.apiclient.RestApiClientFactory;
import com.bms.issue.archive.impl.Issue;
import com.bms.issue.archive.impl.Operator;
import com.bms.issue.bean.Blackboard;
import com.bms.issue.bean.entity.IssueEntity;
import com.bms.issue.bean.param.ISSU0101IBean;
import com.bms.issue.constant.enumeration.InitiatorType;
import com.bms.issue.constant.enumeration.IssueStatus;
import com.bms.issue.constant.enumeration.OrderType;
import com.bms.issue.constant.i18n.ErrorCode;
import com.bms.issue.constant.i18n.ModuleCode;
import com.bms.issue.dao.IssueDao;
import com.bms.issue.external.archive.BuyerOrder;
import com.bms.issue.service.ISSU0101IService;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.StringUtils;
import com.framework.exception.BusinessException;
import com.framework.redis.dao.BaseRedisDao;

/**
 * 问题订单创建接口Service
 *
 * @author li_huiqian
 */
@Service
public class ISSU0101IServiceImpl extends BaseServiceImpl implements ISSU0101IService {

    @Autowired
    private BaseRedisDao redisDao;

    @Autowired
    private IssueDao issueDao;

    @Autowired
    private RestApiClientFactory restApiClientFactory;

    /**
     * 接收问题订单基本信息、问题信息，创建问题订单
     *
     * @param operator 操作者
     * @param bean     ISSU0101IBean
     */
    @Override
    public IssueEntity execute(Operator operator, ISSU0101IBean bean) {
        // 本Service用参数传递容器
        HashMap<String, Object> map = new HashMap<>();
        Blackboard blackboard = new Blackboard();
        blackboard.setOperator(operator);
        map.put("bean", bean);
        map.put("blackboard", blackboard);

        pre(map);
        process(map);
        post(map);
        return ((Issue) map.get("issue")).getEntity();
    }

    /**
     * 准备
     *
     * @param map HashMap
     */
    private void pre(HashMap<String, Object> map) {
        // 获取参数
        ISSU0101IBean bean = (ISSU0101IBean) map.get("bean");
        Blackboard blackboard = (Blackboard) map.get("blackboard");
        // 设置DAO
        blackboard.setBaseRedisDao(redisDao);
        blackboard.putBaseDao(issueDao);

        //操作者
        Operator operator = blackboard.getOperator();
        operator.setBlackboard(blackboard);
        // 获取完整操作者
        operator.complete(false);
        checkOperatorAndInitiator(operator, bean);
        map.put("blackboard", blackboard);
        map.put("bean", bean);
    }

    /**
     * 执行
     *
     * @param map HashMap
     */
    private void process(HashMap<String, Object> map) {
        // 获取参数
        ISSU0101IBean bean = (ISSU0101IBean) map.get("bean");
        Blackboard blackboard = (Blackboard) map.get("blackboard");
        //操作者
        Operator operator = blackboard.getOperator();
        operator.setBlackboard(blackboard);

        // 执行操作
        BuyerOrder buyerOrder = null;
        if (null != bean.getOrderId()) {
            buyerOrder = BuyerOrder.findById(operator, bean.getOrderId());
            if (null == buyerOrder) {
                throw new BusinessException(ModuleCode.ISSU, ErrorCode.E010107, bean.getOrderId() + "");
            }
            checkOrderInfo(buyerOrder, bean);
        }

        IssueEntity issueEntity = getIssueEntity(bean, buyerOrder);
        Issue issue = Issue.build(blackboard).forCreate(issueEntity);
        issue.create();
        map.put("issue", issue);
    }

    /**
     * 收尾
     *
     * @param map HashMap
     */
    private void post(HashMap<String, Object> map) {

    }

    /**
     * 检查操作人的操作权限
     *
     * @param operator
     */
    public void checkOperatorAndInitiator(Operator operator, ISSU0101IBean bean) {
        InitiatorType initiatorType = InitiatorType.getInstance(bean.getInitiatorType());
        if (operator.isBuyer()) {
            if (initiatorType != InitiatorType.Buyer) {
                throw new BusinessException(ModuleCode.ISSU, ErrorCode.E010101);
            }
            if (StringUtils.isEmpty(bean.getInitiatorId())) {
                bean.setInitiatorId(operator.getOperatorId());
            }
            if (!bean.getInitiatorId().equals(operator.getOperatorId())) {
                throw new BusinessException(ModuleCode.ISSU, ErrorCode.E010102);
            }
        } else if (operator.isSa()) {
            if (initiatorType != InitiatorType.SA) {
                throw new BusinessException(ModuleCode.ISSU, ErrorCode.E010103);
            }
            if (StringUtils.isEmpty(bean.getInitiatorId())) {
                bean.setInitiatorId(operator.getOperatorId());
            }
            if (!bean.getInitiatorId().equals(operator.getOperatorId())) {
                throw new BusinessException(ModuleCode.ISSU, ErrorCode.E010104);
            }
        } else if (operator.isStaff()) {

        } else {
            throw new BusinessException(ModuleCode.ISSU, ErrorCode.E010105);
        }
    }

    /**
     * 遍历需要插入的数据
     *
     * @param param
     * @param restResult
     * @return
     */
    public IssueEntity getIssueEntity(ISSU0101IBean param, BuyerOrder buyerOrder) {
        IssueEntity issueEntity = new IssueEntity();
        if (null != param.getOrderId() && buyerOrder != null) {
            issueEntity.setOrderId(buyerOrder.getEntity().getBuyerOrderId());
            issueEntity.setOrderCode(buyerOrder.getEntity().getBuyerOrderCode());
            issueEntity.setLogisticsZoneId(buyerOrder.getEntity().getLogisticsZoneId());
            issueEntity.setLogisticsZoneCode(buyerOrder.getEntity().getLogisticsZoneCode());
            issueEntity.setLogisticsZoneName(buyerOrder.getEntity().getLogisticsZoneName());
            issueEntity.setBuyerId(buyerOrder.getEntity().getBuyerId());
            issueEntity.setBuyerCode(buyerOrder.getEntity().getBuyerCode());
            issueEntity.setBuyerName(buyerOrder.getEntity().getBuyerName());
            issueEntity.setOrderType(OrderType.BUYER_ORDER.getCode());
        }
        issueEntity.setInitiatorId(param.getInitiatorId());
        issueEntity.setInitiatorName(param.getInitiatorName());
        issueEntity.setInitiatorType(param.getInitiatorType());
        issueEntity.setInitiateTime(DateUtils.parse(DateUtils.FORMAT_YYYY_MM_DD_HH_MM_SS, param.getInitiateTime()));
        issueEntity.setIssueDesc(param.getIssueDesc());
        if (param.getIssueStatus().equals(IssueStatus.INITIATING.getCode()) || param.getIssueStatus().equals(IssueStatus.WAIT_HANDLE.getCode())) {
            issueEntity.setIssueStatus(param.getIssueStatus());
        } else {
            throw new BusinessException(ModuleCode.ISSU, ErrorCode.E010106);
        }
        return issueEntity;
    }

    /**
     * 检查订单信息和发起人信息是否一样
     *
     * @param restResult
     * @param bean
     */
    public void checkOrderInfo(BuyerOrder buyerOrder, ISSU0101IBean bean) {
        InitiatorType initiatorType = InitiatorType.getInstance(bean.getInitiatorType());
        if (initiatorType == InitiatorType.Buyer) {
            if (!StringUtils.isEmpty(bean.getInitiatorId())) {
                if (StringUtils.isEmpty(buyerOrder.getEntity().getBuyerId())) {
                    throw new BusinessException(ModuleCode.ISSU, ErrorCode.E010108);
                }
                if (!buyerOrder.getEntity().getBuyerId().equals(bean.getInitiatorId())) {
                    throw new BusinessException(ModuleCode.ISSU, ErrorCode.E010108);
                }
            }

            if (StringUtils.isEmpty(buyerOrder.getEntity().getBuyerName())) {
                throw new BusinessException(ModuleCode.ISSU, ErrorCode.E010109);
            }
            if (!buyerOrder.getEntity().getBuyerName().equals(bean.getInitiatorName())) {
                throw new BusinessException(ModuleCode.ISSU, ErrorCode.E010109);
            }
        }
        if (initiatorType == InitiatorType.SA) {
            if (!StringUtils.isEmpty(bean.getInitiatorId())) {
                if (StringUtils.isEmpty(buyerOrder.getEntity().getOrderPlacerId())) {
                    throw new BusinessException(ModuleCode.ISSU, ErrorCode.E010110);
                }
                if (!buyerOrder.getEntity().getOrderPlacerId().equals(bean.getInitiatorId())) {
                    throw new BusinessException(ModuleCode.ISSU, ErrorCode.E010110);
                }
            }
            if (StringUtils.isEmpty(buyerOrder.getEntity().getOrderPlacerName())) {
                throw new BusinessException(ModuleCode.ISSU, ErrorCode.E010111);
            }
            if (!buyerOrder.getEntity().getOrderPlacerName().equals(bean.getInitiatorName())) {
                throw new BusinessException(ModuleCode.ISSU, ErrorCode.E010111);
            }
        }
    }

    @Override
    public BaseDao getBaseDao() {
        return null;
    }
}
