package com.bms.issue.service.impl;

import com.bms.issue.archive.impl.Operator;
import com.bms.issue.archive.impl.Question;
import com.bms.issue.archive.impl.QuestionAccessory;
import com.bms.issue.bean.Blackboard;
import com.bms.issue.bean.entity.QuestionAccessoryEntity;
import com.bms.issue.bean.entity.QuestionEntity;
import com.bms.issue.bean.param.ISSU0205IBean;
import com.bms.issue.constant.i18n.ErrorCode;
import com.bms.issue.constant.i18n.ModuleCode;
import com.bms.issue.dao.QuestionAccessoryDao;
import com.bms.issue.dao.QuestionDao;
import com.bms.issue.service.ISSU0205IService;
import com.framework.exception.BusinessException;
import com.framework.redis.dao.BaseRedisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * 问题附件删除接口Service
 *
 * @author li_huiqian
 */
@Service
public class ISSU0205IServiceImpl implements ISSU0205IService {

    @Autowired
    private BaseRedisDao redisDao;


    @Autowired
    private QuestionDao questionDao;

    @Autowired
    private QuestionAccessoryDao questionAccessoryDao;

    /**
     * 接收问题的附件信息，删除附件信息，即更新删除标志
     *
     * @param operator 操作者
     * @param bean     ISSU0205IBean
     */
    @Override
    public void execute(Operator operator, ISSU0205IBean bean) {
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
    }

    /**
     * 准备
     *
     * @param map HashMap
     */
    private void pre(HashMap<String, Object> map) {
// 获取参数
        ISSU0205IBean param = (ISSU0205IBean) map.get("param");
        Blackboard blackboard = (Blackboard) map.get("blackboard");
// 设置DAO

        blackboard.setBaseRedisDao(redisDao);
        blackboard.putBaseDao(questionDao);
        blackboard.putBaseDao(questionAccessoryDao);

//操作者
        Operator operator = blackboard.getOperator();
        operator.setBlackboard(blackboard);
// 获取完整操作者
        operator.complete(false);

        QuestionAccessory questionAccessory = this.checkQuestionAccessory(param, blackboard);

// 返回参数
        map.put("questionAccessory", questionAccessory);
    }

    /**
     * 执行
     *
     * @param map HashMap
     */
    private void process(HashMap<String, Object> map) {
// 获取参数
        QuestionAccessory questionAccessory = (QuestionAccessory) map.get("questionAccessory");
// 执行操作
        questionAccessory.delete();
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
     * 检查问题  的附件是否存在
     *
     * @param bean
     * @param blackboard
     * @return
     */
    private QuestionAccessory checkQuestionAccessory(ISSU0205IBean bean, Blackboard blackboard) {
        QuestionAccessory questionAccessory = new QuestionAccessory(bean.getAccessoryId());
        questionAccessory.setBlackboard(blackboard);
        questionAccessory.complete(false);
        QuestionAccessoryEntity questionAccessoryEntity = questionAccessory.getEntity();
        if (!questionAccessory.isDataSynced()) {
            throw new BusinessException(ModuleCode.ISSU, ErrorCode.E020501, bean.getAccessoryId().toString());
        }
        Integer version = bean.getVersion();
        if (!version.equals(questionAccessoryEntity.getVersion())) {
            throw new BusinessException(ModuleCode.ISSU, ErrorCode.E020502, bean.getAccessoryId().toString());
        }

        Question question = questionAccessory.getQuestion();
        QuestionEntity questionEntity = question.getEntity();
        if (!question.isDataSynced()) {
            throw new BusinessException(ModuleCode.ISSU, ErrorCode.E020503, bean.getQuestionId().toString());
        }
        if (!bean.getQuestionId().equals(questionEntity.getQuestionId())) {
            throw new BusinessException(ModuleCode.ISSU, ErrorCode.E020504, bean.getQuestionId().toString());
        }
        return questionAccessory;
    }
}
