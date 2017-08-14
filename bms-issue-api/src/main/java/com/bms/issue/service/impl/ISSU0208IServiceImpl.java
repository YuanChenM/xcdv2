package com.bms.issue.service.impl;

import com.bms.issue.archive.impl.Operator;
import com.bms.issue.archive.impl.Question;
import com.bms.issue.archive.impl.QuestionHandling;
import com.bms.issue.bean.Blackboard;
import com.bms.issue.bean.param.ISSU0208IBean;
import com.bms.issue.constant.i18n.ErrorCode;
import com.bms.issue.constant.i18n.ModuleCode;
import com.bms.issue.dao.QuestionDao;
import com.bms.issue.dao.QuestionHandlingDao;
import com.bms.issue.service.ISSU0208IService;
import com.framework.core.utils.DateUtils;
import com.framework.exception.BusinessException;
import com.framework.redis.dao.BaseRedisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * 问题处理/结案建议新增接口Service
 *
 * @author li_huiqian
 */
@Service
public class ISSU0208IServiceImpl implements ISSU0208IService {

    @Autowired
    private BaseRedisDao redisDao;
    @Autowired
    private QuestionHandlingDao questionHandlingDao;
    @Autowired
    private QuestionDao questionDao;

    /**
     * 问题处理/结案建议新增接口
     *
     * @param operator 操作者
     * @param bean     ISSU0208IBean
     */
    @Override
    public Long execute(Operator operator, ISSU0208IBean bean) {
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
        QuestionHandling questionHandling = (QuestionHandling) map.get("questionHandling");
        return questionHandling.getEntity().getHandlingId();
    }

    /**
     * 准备
     *
     * @param map HashMap
     */
    private void pre(HashMap<String, Object> map) {
// 获取参数
        ISSU0208IBean param = (ISSU0208IBean) map.get("param");
        Blackboard blackboard = (Blackboard) map.get("blackboard");
// 设置DAO
        blackboard.setBaseRedisDao(redisDao);
        blackboard.putBaseDao(questionHandlingDao);
        blackboard.putBaseDao(questionDao);

//操作者
        Operator operator = blackboard.getOperator();
        operator.setBlackboard(blackboard);
// 获取完整操作者
        operator.complete(false);

        QuestionHandling questionHandling = param.getQuestionHandling();
        questionHandling.setBlackboard(blackboard);
        this.checkQuestHanding(questionHandling);
        questionHandling.getEntity().setHandlingTime(DateUtils.parseDateTime(param.getHandlingTime()));// string==>date
// 返回参数
        map.put("questionHandling", questionHandling);
    }

    /**
     * 执行
     *
     * @param map HashMap
     */
    private void process(HashMap<String, Object> map) {
// 获取参数
        QuestionHandling questionHandling = (QuestionHandling) map.get("questionHandling");
        questionHandling.create();

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


    public void checkQuestHanding(QuestionHandling questionHandling) {
        Long questionId = questionHandling.getEntity().getQuestionId();
        Question question = new Question(questionId);
        question.setBlackboard(questionHandling.getBlackboard());
        question.complete(false);
        if(!question.isDataSynced()){// 该问题不存在
            throw new BusinessException(ModuleCode.ISSU, ErrorCode.E020801);
        }
        Boolean questionIsClose = question.getEntity().isQuestionIsClose();
        if ( questionIsClose != null&&questionIsClose ) {// 判断已经结案
            throw new BusinessException(ModuleCode.ISSU, ErrorCode.E020801);
        }


    }
}
