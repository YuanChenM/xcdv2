package com.bms.issue.service.impl;

import java.util.HashMap;
import java.util.List;

import com.bms.issue.archive.impl.Issue;
import com.bms.issue.archive.impl.Question;
import com.bms.issue.archive.impl.QuestionAccessory;
import com.bms.issue.archive.impl.list.QuestionAccessoryList;
import com.bms.issue.constant.enumeration.IssueStatus;
import com.bms.issue.constant.enumeration.OperatorType;
import com.bms.issue.constant.i18n.ErrorCode;
import com.bms.issue.constant.i18n.ModuleCode;
import com.bms.issue.dao.IssueDao;
import com.bms.issue.dao.QuestionAccessoryDao;
import com.bms.issue.dao.QuestionDao;
import com.framework.core.utils.CollectionUtils;
import com.framework.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bms.issue.archive.impl.Operator;
import com.bms.issue.bean.Blackboard;
import com.bms.issue.bean.param.ISSU0201IBean;
import com.bms.issue.service.ISSU0201IService;
import com.framework.redis.dao.BaseRedisDao;

/**
 * 问题订单问题新增接口Service
 *
 * @author li_huiqian
 */
@Service
public class ISSU0201IServiceImpl implements ISSU0201IService {

    @Autowired
    private BaseRedisDao redisDao;

    @Autowired
    private IssueDao issueDao;

    @Autowired
    private QuestionDao questionDao;

    @Autowired
    private QuestionAccessoryDao questionAccessoryDao;

    /**
     * 接收问题信息，创建问题
     *
     * @param operator 操作者
     * @param bean     ISSU0201IBean
     */
    @Override
    public Long execute(Operator operator, ISSU0201IBean bean) {
        // 本Service用参数传递容器
        HashMap<String, Object> map = new HashMap<>();
        Blackboard blackboard = new Blackboard();
        ;
        blackboard.setOperator(operator);
        map.put("bean", bean);
        map.put("blackboard", blackboard);

        pre(map);
        Long id = process(map);
        post(map);
        return id;
    }

    /**
     * 准备
     *
     * @param map HashMap
     */
    private void pre(HashMap<String, Object> map) {
        // 获取参数
        ISSU0201IBean bean = (ISSU0201IBean) map.get("bean");
        Blackboard blackboard = (Blackboard) map.get("blackboard");
        // 设置DAO
        // TODO 设置DAO
        blackboard.setBaseRedisDao(redisDao);
        blackboard.putBaseDao(issueDao);
        blackboard.putBaseDao(questionDao);
        blackboard.putBaseDao(questionAccessoryDao);

        //操作者
        Operator operator = blackboard.getOperator();
        operator.setBlackboard(blackboard);
        // 获取完整操作者
        operator.complete(false);
        //权限判断
        checkOperatorType(operator);
        map.put("blackboard",blackboard);

    }

    /**
     * 执行
     *
     * @param map HashMap
     */
    private Long process(HashMap<String, Object> map) {
        // 获取参数
        ISSU0201IBean bean = (ISSU0201IBean) map.get("bean");
        Blackboard blackboard = (Blackboard) map.get("blackboard");
        // 执行操作
        Issue issue = bean.getIssueById();
        issue.setBlackboard(blackboard);
        issue.complete(false);
        if(!issue.isDataSynced()){
            throw new BusinessException(ModuleCode.ISSU,ErrorCode.E020101, String.valueOf(issue.getEntity().getIssueId()));
        }
        IssueStatus issueStatus = IssueStatus.getInstance(issue.getEntity().getIssueStatus());
        if(issueStatus != IssueStatus.CLOSED && issueStatus != IssueStatus.WAIT_CLOSE){

        }else {
            throw new BusinessException(ModuleCode.ISSU,ErrorCode.E020102 ,String.valueOf(issue.getEntity().getIssueId()));
        }
        Question question = bean.createQuestion();
        question.setBlackboard(blackboard);
        List<QuestionAccessory> accessories = question.getQuestionAccessorys();
        question.create();
        if(!CollectionUtils.isEmpty(accessories)){
            for(QuestionAccessory accessory : accessories){
                accessory.getEntity().setQuestionId(question.getEntity().getQuestionId());
            }
            QuestionAccessoryList questionAccessoryList = QuestionAccessoryList.build(blackboard).forCreate(
                    accessories.toArray(new QuestionAccessory[0]));
            questionAccessoryList.create();
        }
        return question.getEntity().getQuestionId();
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

    private void checkOperatorType(Operator operator){
        OperatorType operatorType = OperatorType.getInstance(operator.getOperatorType());
        if(operatorType == OperatorType.BUYER){

        }else if(operatorType == OperatorType.BS){
            throw new BusinessException(ModuleCode.ISSU, ErrorCode.E000001,operatorType.getName());
        }else if(operatorType == OperatorType.SA){

        }else if(operatorType == OperatorType.MANAGER){

        }else {
            throw new BusinessException(ModuleCode.ISSU, ErrorCode.E000001,operatorType.getName());
        }
    }
}
