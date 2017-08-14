package com.bms.issue.service.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.common.rest.apiclient.RestApiClientFactory;
import com.bms.issue.archive.impl.Issue;
import com.bms.issue.archive.impl.Operator;
import com.bms.issue.bean.Blackboard;
import com.bms.issue.bean.param.ISSU0104IBean;
import com.bms.issue.constant.enumeration.InitiatorType;
import com.bms.issue.constant.enumeration.IssueStatus;
import com.bms.issue.constant.i18n.ErrorCode;
import com.bms.issue.constant.i18n.ModuleCode;
import com.bms.issue.dao.IssueDao;
import com.bms.issue.external.archive.BuyerOrder;
import com.bms.issue.service.ISSU0104IService;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.StringUtils;
import com.framework.exception.BusinessException;
import com.framework.redis.dao.BaseRedisDao;

/**
 * 问题订单修改接口Service
 *
 * @author li_huiqian
 */
@Service
public class ISSU0104IServiceImpl extends BaseServiceImpl implements ISSU0104IService {

    @Autowired
    private BaseRedisDao redisDao;

    @Autowired
    private IssueDao issueDao;

    @Autowired
    private RestApiClientFactory restApiClientFactory;

    /**
     * 接收问题订单基本信息、问题信息，修改问题订单
     *
     * @param operator 操作者
     * @param bean     ISSU0104IBean
     */
    @Override
    public void execute(Operator operator, ISSU0104IBean bean) {
        // 本Service用参数传递容器
        HashMap<String, Object> map = new HashMap<>();
        Blackboard blackboard = new Blackboard();
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
        ISSU0104IBean bean = (ISSU0104IBean) map.get("bean");
        Blackboard blackboard = (Blackboard) map.get("blackboard");
        // 设置DAO
        blackboard.setBaseRedisDao(redisDao);
        blackboard.putBaseDao(issueDao);

        //操作者
        Operator operator = blackboard.getOperator();
        operator.setBlackboard(blackboard);
        // 获取完整操作者
        operator.complete(false);
        Issue issue = Issue.build(blackboard).forComplete(bean.getIssueId());
        issue.complete(false);
        if (!issue.isDataSynced()) {
            throw new BusinessException(ModuleCode.ISSU, ErrorCode.E010401);
        }
        //查询订单信息
        if (null != issue.getEntity().getOrderId()) {
            BuyerOrder buyerOrder = BuyerOrder.findById(blackboard.getOperator(), issue.getEntity().getOrderId());
            checkModifyInfo(buyerOrder, issue, bean);
        }
        map.put("issue", issue);
    }

    /**
     * 执行
     *
     * @param map HashMap
     */
    private void process(HashMap<String, Object> map) {
        // 获取参数
        Issue issue = (Issue) map.get("issue");
        ISSU0104IBean bean = (ISSU0104IBean) map.get("bean");
        // 执行操作
        if (!StringUtils.isEmpty(bean.getInitiatorType())) {
            issue.getEntity().setInitiatorId(bean.getInitiatorId());
            issue.getEntity().setInitiatorType(bean.getInitiatorType());
            issue.getEntity().setInitiatorName(bean.getInitiatorName());
        }
        if (!StringUtils.isEmpty(bean.getInitiateTime())) {
            issue.getEntity().setInitiateTime(DateUtils.parse(DateUtils.FORMAT_YYYY_MM_DD_HH_MM_SS, bean.getInitiateTime()));
        }
        if (!StringUtils.isEmpty(bean.getIssueDesc())) {
            issue.getEntity().setIssueDesc(bean.getIssueDesc());
        }

        if (!StringUtils.isEmpty(bean.getCloseUid())) {
            issue.getEntity().setCloseUid(bean.getCloseUid());
        }

        if (!StringUtils.isEmpty(bean.getCloseUname())) {
            issue.getEntity().setCloseUname(bean.getCloseUname());
        }

        if (!StringUtils.isEmpty(bean.getCloseTime())) {
            issue.getEntity().setCloseTime(DateUtils.parse(DateUtils.FORMAT_YYYY_MM_DD_HH_MM_SS, bean.getCloseTime()));
        }

        if (!StringUtils.isEmpty(bean.getIssueResult())) {
            issue.getEntity().setIssueResult(bean.getIssueResult());
        }

        if (!StringUtils.isEmpty(bean.getIssueDecision())) {
            issue.getEntity().setIssueDecision(bean.getIssueDecision());
        }
        issue.getEntity().setVersion(bean.getVer());
        issue.modify();
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
     * 检查修改内容是否正确
     *
     * @param restResult
     * @param issue
     * @param bean
     */
    public void checkModifyInfo(BuyerOrder buyerOrder, Issue issue, ISSU0104IBean bean) {
        if (null == buyerOrder) {
            throw new BusinessException(ModuleCode.ISSU, ErrorCode.E010402, issue.getEntity().getOrderId() + "");
        }

        IssueStatus issueStatus = IssueStatus.getInstance(issue.getEntity().getIssueStatus());
        //如果问题订单状态不是已结案 就不能修改结案信息
        if (issueStatus != IssueStatus.CLOSED) {
            if (!StringUtils.isEmpty(bean.getCloseTime())
                    || !StringUtils.isEmpty(bean.getCloseUid())
                    || !StringUtils.isEmpty(bean.getCloseUname())
                    || !StringUtils.isEmpty(bean.getIssueResult())
                    || !StringUtils.isEmpty(bean.getIssueDecision())) {
                throw new BusinessException(ModuleCode.ISSU, ErrorCode.E010403, bean.getIssueId() + "");
            }
        }

        //校验发起人的修改是否正确
        //发起人类型不为空
        if (!StringUtils.isEmpty(bean.getInitiatorType())) {
            //得到这个发起人的类型
            InitiatorType initiatorType = InitiatorType.getInstance(bean.getInitiatorType());
            if (null == initiatorType) {
                throw new BusinessException(ModuleCode.ISSU, ErrorCode.E010404);
            }
            //买家 判断这个订单的买家信息和现在的是否一样
            if (initiatorType == InitiatorType.Buyer) {
                if (!bean.getInitiatorName().equals(buyerOrder.getEntity().getBuyerName())) {
                    throw new BusinessException(ModuleCode.ISSU, ErrorCode.E010405);
                }
            }

            //管家 判断这个订单的下单员信息和现在的发起人信息是否一样
            if (initiatorType == InitiatorType.SA) {
                if (!bean.getInitiatorName().equals(buyerOrder.getEntity().getOrderPlacerName())) {
                    throw new BusinessException(ModuleCode.ISSU, ErrorCode.E010405);
                }
            }
        }
    }

    @Override
    public BaseDao getBaseDao() {
        return null;
    }
}
