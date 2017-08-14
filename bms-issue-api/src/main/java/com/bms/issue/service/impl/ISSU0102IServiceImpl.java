package com.bms.issue.service.impl;

import java.util.HashMap;
import java.util.List;

import com.bms.common.rest.apiclient.RestApiClient;
import com.bms.common.rest.apiclient.RestApiClientFactory;
import com.bms.issue.archive.impl.Issue;
import com.bms.issue.constant.enumeration.InitiatorType;
import com.bms.issue.constant.enumeration.IssueStatus;
import com.bms.issue.constant.i18n.ErrorCode;
import com.bms.issue.constant.i18n.ModuleCode;
import com.bms.issue.dao.IssueDao;
import com.framework.core.utils.StringUtils;
import com.framework.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bms.issue.archive.impl.Operator;
import com.bms.issue.bean.Blackboard;
import com.bms.issue.bean.param.ISSU0102IBean;
import com.bms.issue.service.ISSU0102IService;
import com.framework.redis.dao.BaseRedisDao;

/**
 * 问题订单发起提交接口Service
 *
 * @author li_huiqian
 */
@Service
public class ISSU0102IServiceImpl implements ISSU0102IService {

    @Autowired
    private BaseRedisDao redisDao;

    @Autowired
    private IssueDao issueDao;

    /**
     * 接收问题订单基本信息、问题信息，提交发起问题订单
     *
     * @param operator 操作者
     * @param bean     ISSU0102IBean
     */
    @Override
    public void execute(Operator operator, ISSU0102IBean bean) {
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
        ISSU0102IBean bean = (ISSU0102IBean) map.get("bean");
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
        //判断问题订单是否存在
        if (!issue.isDataSynced()) {
            throw new BusinessException(ModuleCode.ISSU, ErrorCode.E010201, bean.getIssueId().toString());
        }
        //判断数据操作权限
        if (operator.isBuyer()) {
            if (!operator.getOperatorId().equals(issue.getEntity().getInitiatorId())) {
                throw new BusinessException(ModuleCode.ISSU, ErrorCode.E010202);
            }
            if (!issue.getEntity().getInitiatorType().equals(InitiatorType.Buyer.getCode())) {
                throw new BusinessException(ModuleCode.ISSU, ErrorCode.E010203);
            }
        } else if (operator.isSa()) {
            if (!operator.getOperatorId().equals(issue.getEntity().getInitiatorId())) {
                throw new BusinessException(ModuleCode.ISSU, ErrorCode.E010204);
            }
            if (!issue.getEntity().getInitiatorType().equals(InitiatorType.SA.getCode())) {
                throw new BusinessException(ModuleCode.ISSU, ErrorCode.E010205);
            }
        } else if (!operator.isStaff()) {
            throw new BusinessException(ModuleCode.ISSU, ErrorCode.E010206, operator.getOperatorId() + "");
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
        ISSU0102IBean bean = (ISSU0102IBean) map.get("bean");
        Issue issue = (Issue) map.get("issue");
        //判断状态是否为发起中
        if (!issue.getEntity().getIssueStatus().equals(IssueStatus.INITIATING.getCode())) {
            throw new BusinessException(ModuleCode.ISSU, ErrorCode.E010207, bean.getIssueId() + "", issue.getEntity().getIssueStatus());
        }
        issue.getEntity().setIssueStatus(IssueStatus.WAIT_HANDLE.getCode());
        issue.getEntity().setVersion(bean.getVer());
        issue.modify();
    }

    /**
     * 收尾
     *
     * @param map HashMap
     */
    private void post(HashMap<String, Object> map) {

    }
}
