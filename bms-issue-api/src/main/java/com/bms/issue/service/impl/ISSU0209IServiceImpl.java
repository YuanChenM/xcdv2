package com.bms.issue.service.impl;

import java.util.HashMap;
import java.util.List;

import com.bms.issue.archive.impl.Question;
import com.bms.issue.archive.impl.QuestionHandling;
import com.bms.issue.constant.enumeration.HandlingResult;
import com.bms.issue.constant.i18n.ErrorCode;
import com.bms.issue.constant.i18n.ModuleCode;
import com.bms.issue.dao.QuestionDao;
import com.bms.issue.dao.QuestionHandlingDao;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.StringUtils;
import com.framework.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bms.issue.archive.impl.Operator;
import com.bms.issue.bean.Blackboard;
import com.bms.issue.bean.param.ISSU0209IBean;
import com.bms.issue.service.ISSU0209IService;
import com.framework.redis.dao.BaseRedisDao;

/**
 * 问题处理/结案建议编辑接口Service
 *
 * @author li_huiqian
 */
@Service
public class ISSU0209IServiceImpl implements ISSU0209IService {

    @Autowired
    private BaseRedisDao redisDao;

    @Autowired
    private QuestionDao questionDao;

    @Autowired
    private QuestionHandlingDao questionHandlingDao;

    /**
     * 问题处理/结案建议编辑接口
     *
     * @param operator 操作者
     * @param bean     ISSU0209IBean
     */
    @Override
    public void execute(Operator operator, ISSU0209IBean bean) {
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
        ISSU0209IBean bean = (ISSU0209IBean) map.get("bean");
        Blackboard blackboard = (Blackboard) map.get("blackboard");
        // 设置DAO
        blackboard.setBaseRedisDao(redisDao);
        blackboard.putBaseDao(questionDao);
        blackboard.putBaseDao(questionHandlingDao);

        //操作者
        Operator operator = blackboard.getOperator();
        operator.setBlackboard(blackboard);
        // 获取完整操作者
        operator.complete(false);
        Question question = Question.build(blackboard).forComplete(bean.getQuestionId());
        question.complete(false);
        if (!question.isDataSynced()) {
            throw new BusinessException(ModuleCode.ISSU, ErrorCode.E020901);
        }

        QuestionHandling questionHandling = QuestionHandling.build(blackboard).forComplete(bean.getHandlingId());
        questionHandling.complete(false);
        if (!questionHandling.isDataSynced()) {
            throw new BusinessException(ModuleCode.ISSU, ErrorCode.E020902);
        }
        map.put("questionHandling", questionHandling);
        map.put("question", question);
    }

    /**
     * 执行
     *
     * @param map HashMap
     */
    private void process(HashMap<String, Object> map) {
        // 获取参数
        QuestionHandling questionHandling = (QuestionHandling) map.get("questionHandling");
        Question question = (Question) map.get("question");
        ISSU0209IBean bean = (ISSU0209IBean) map.get("bean");
        // 执行操作
        if (question.getEntity().isQuestionIsClose()) {
            throw new BusinessException(ModuleCode.ISSU, ErrorCode.E020903);
        }
        questionHandling.getEntity().setVersion(bean.getVer());
        questionHandling.getEntity().setHandlingType(bean.getHandlingType());
        if (!StringUtils.isEmpty(bean.getHandlingContent())) {
            questionHandling.getEntity().setHandlingContent(bean.getHandlingContent());
        }
        if (!StringUtils.isEmpty(bean.getHandlingTime())) {
            questionHandling.getEntity().setHandlingTime(DateUtils.parse(DateUtils.FORMAT_YYYY_MM_DD_HH_MM_SS, bean.getHandlingTime()));
        }
        if (!StringUtils.isEmpty(bean.getHandlingUid())) {
            questionHandling.getEntity().setHandlingUid(bean.getHandlingUid());
        }
        if (!StringUtils.isEmpty(bean.getHandlingUname())) {
            questionHandling.getEntity().setHandlingUname(bean.getHandlingUname());
        }
        if (!StringUtils.isEmpty(bean.getHandlingResult())) {
            HandlingResult handlingResult = HandlingResult.getInstance(bean.getHandlingResult());
            if (null == handlingResult) {
                throw new BusinessException(ModuleCode.ISSU, ErrorCode.E020904);
            }
            questionHandling.getEntity().setHandlingResult(bean.getHandlingResult());
        }
        if (!StringUtils.isEmpty(bean.getHandlingResultReason())) {
            questionHandling.getEntity().setHandlingResultReason(bean.getHandlingResultReason());
        }
        questionHandling.modify();
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
