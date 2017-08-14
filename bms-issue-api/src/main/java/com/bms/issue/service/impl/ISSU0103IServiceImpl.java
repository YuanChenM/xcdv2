package com.bms.issue.service.impl;

import java.util.HashMap;
import java.util.List;

import com.bms.issue.archive.impl.Issue;
import com.bms.issue.bean.entity.IssueEntity;
import com.bms.issue.constant.enumeration.IssueStatus;
import com.bms.issue.constant.i18n.ErrorCode;
import com.bms.issue.constant.i18n.ModuleCode;
import com.bms.issue.dao.IssueDao;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.StringUtils;
import com.framework.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bms.issue.archive.impl.Operator;
import com.bms.issue.bean.Blackboard;
import com.bms.issue.bean.param.ISSU0103IBean;
import com.bms.issue.service.ISSU0103IService;
import com.framework.redis.dao.BaseRedisDao;

/**
 * 问题订单结案提交接口Service
 *
 * @author li_huiqian
 */
@Service
public class ISSU0103IServiceImpl implements ISSU0103IService {

    @Autowired
    private BaseRedisDao redisDao;

    @Autowired
    private IssueDao issueDao;

    /**
     * 接收问题订单结案信息，问题订单结案
     *
     * @param operator 操作者
     * @param bean     ISSU0103IBean
     */
    @Override
    public void execute(Operator operator, ISSU0103IBean bean) {
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
        Blackboard blackboard = (Blackboard) map.get("blackboard");
        // 设置DAO
        blackboard.setBaseRedisDao(redisDao);
        blackboard.putBaseDao(issueDao);

        //操作者
        Operator operator = blackboard.getOperator();
        operator.setBlackboard(blackboard);
        // 获取完整操作者
        operator.complete(false);
    }

    /**
     * 执行
     *
     * @param map HashMap
     */
    private void process(HashMap<String, Object> map) {
        // 获取参数
        ISSU0103IBean bean = (ISSU0103IBean) map.get("bean");
        Blackboard blackboard = (Blackboard) map.get("blackboard");
        // 执行操作
        Issue issue = Issue.build(blackboard).forComplete(bean.getIssueId());
        issue.complete(false);
        if (!issue.isDataSynced()) {
            throw new BusinessException(ModuleCode.ISSU, ErrorCode.E010301, bean.getIssueId() + "");
        }
        if (!issue.getEntity().getIssueStatus().equals(IssueStatus.WAIT_CLOSE.getCode())) {
            throw new BusinessException(ModuleCode.ISSU, ErrorCode.E010302, bean.getIssueId() + "");
        }
        issue.getEntity().setIssueId(bean.getIssueId());
        issue.getEntity().setCloseUid(bean.getCloseUid());
        issue.getEntity().setCloseUname(bean.getCloseUname());
        issue.getEntity().setCloseTime(DateUtils.parse(DateUtils.FORMAT_YYYY_MM_DD_HH_MM_SS, bean.getCloseTime()));
        issue.getEntity().setIssueResult(bean.getIssueResult());
        issue.getEntity().setIssueDecision(bean.getIssueDecision());
        issue.getEntity().setIssueStatus(IssueStatus.CLOSED.getCode());
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
}
