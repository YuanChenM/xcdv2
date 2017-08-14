package com.bms.issue.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.bms.issue.archive.impl.Issue;
import com.bms.issue.archive.impl.Question;
import com.bms.issue.bean.entity.QuestionEntity;
import com.bms.issue.constant.enumeration.IssueStatus;
import com.bms.issue.constant.i18n.ErrorCode;
import com.bms.issue.constant.i18n.ModuleCode;
import com.bms.issue.dao.IssueDao;
import com.bms.issue.dao.QuestionDao;
import com.framework.core.utils.DateUtils;
import com.framework.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bms.issue.archive.impl.Operator;
import com.bms.issue.bean.Blackboard;
import com.bms.issue.bean.param.ISSU0202IBean;
import com.bms.issue.service.ISSU0202IService;
import com.framework.redis.dao.BaseRedisDao;

/**
 * 问题订单问题结案接口Service
 *
 * @author li_huiqian
 */
@Service
public class ISSU0202IServiceImpl implements ISSU0202IService {

    @Autowired
    private BaseRedisDao redisDao;
    @Autowired
    private IssueDao issueDao;
    @Autowired
    private QuestionDao questionDao;

    /**
     * 接收问题结案信息，问题结案
     *
     * @param operator 操作者
     * @param bean     ISSU0202IBean
     */
    @Override
    public void execute(Operator operator, ISSU0202IBean bean) {
    // 本Service用参数传递容器
        HashMap<String, Object> map = new HashMap<>();
        Blackboard blackboard = new Blackboard();
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
        ISSU0202IBean param = (ISSU0202IBean) map.get("param");
        Blackboard blackboard = (Blackboard) map.get("blackboard");
    // 设置DAO
        blackboard.setBaseRedisDao(redisDao);
        blackboard.putBaseDao(issueDao);
        blackboard.putBaseDao(questionDao);

    //操作者
        Operator operator = blackboard.getOperator();
        operator.setBlackboard(blackboard);
    // 获取完整操作者
        operator.complete(false);

        Question question = this.checkQuestion(param, blackboard);
    // 返回参数
        map.put("question", question);
    }

    /**
     * 执行
     *
     * @param map HashMap
     */
    private void process(HashMap<String, Object> map) {
    // 获取参数
        ISSU0202IBean param = (ISSU0202IBean) map.get("param");
        Question question = (Question) map.get("question");
        QuestionEntity questionEntity = question.getEntity();
        // 执行操作
        questionEntity.setQuestionIsClose(true);
        Date questionCloseTime = DateUtils.parseDateTime(param.getQuestionCloseTime());
        questionEntity.setQuestionCloseTime(questionCloseTime);
        questionEntity.setQuestionCloseUid(param.getQuestionCloseUid());
        questionEntity.setQuestionCloseUname(param.getQuestionCloseUname());
        question.modify();

        Issue issue = this.checkAllQuestionIsClose(param.getIssueId(), question.getBlackboard());
        if (issue != null) {
            issue.getEntity().setIssueStatus(IssueStatus.WAIT_CLOSE.getCode());// 待结案状态
            issue.modify();
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

    private Question checkQuestion(ISSU0202IBean bean, Blackboard blackboard) {


        Long questionId = bean.getQuestionId();//  check 穩定是否存在

        Question question = new Question(questionId);
        question.setBlackboard(blackboard);
        question.complete(false);
        QuestionEntity questionEntity = question.getEntity();
        if (!question.isDataSynced()) {
            throw new BusinessException(ModuleCode.ISSU, ErrorCode.E020201, questionId.toString());
        }

        //  判断是否结案
        Boolean questionIsClose = questionEntity.isQuestionIsClose();
        if (questionIsClose != null && questionIsClose) {
            throw new BusinessException(ModuleCode.ISSU, ErrorCode.E020202, questionId.toString());
        }
        Issue issue = question.getIssue();
        if (issue == null) {
            throw new BusinessException(ModuleCode.ISSU, ErrorCode.E020203, bean.getIssueId() + "");
        }

        Long issueId = bean.getIssueId();//  check  　　问题订单是否存在
        if (!issueId.equals(questionEntity.getIssueId())) {
            throw new BusinessException(ModuleCode.ISSU, ErrorCode.E020204, issueId.toString());
        }

        Integer version = bean.getVersion();
        if (!version.equals(question.getEntity().getVersion())) {
            throw new BusinessException(ModuleCode.ISSU, ErrorCode.E020205, questionId.toString());
        }
        return question;
    }

    /**
     * 检查问题订单下所有的问题 是否都 结案
     *
     * @return
     */
    private Issue checkAllQuestionIsClose(Long issueId, Blackboard blackboard) {
        Boolean flag = true;
        Issue issue = new Issue(issueId);
        issue.setBlackboard(blackboard);
        issue.complete(false);
        List<Question> questionList = issue.getQuestions();
        for (Question question : questionList) {
            Boolean questionIsClose = question.getEntity().isQuestionIsClose();
            if (questionIsClose == null || !questionIsClose) {
                flag = false;
                break;
            }
        }
        if (!flag) {
            issue = null;
        }
        return issue;
    }
}
