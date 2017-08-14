package com.bms.issue.service.impl;

import java.util.HashMap;
import java.util.List;

import com.bms.issue.archive.impl.Question;
import com.bms.issue.archive.impl.QuestionAccessory;
import com.bms.issue.archive.impl.QuestionItem;
import com.bms.issue.archive.impl.list.QuestionAccessoryList;
import com.bms.issue.bean.entity.QuestionItemEntity;
import com.bms.issue.constant.i18n.ErrorCode;
import com.bms.issue.constant.i18n.ModuleCode;
import com.bms.issue.dao.QuestionAccessoryDao;
import com.bms.issue.dao.QuestionDao;
import com.bms.issue.dao.QuestionItemDao;
import com.framework.core.utils.CollectionUtils;
import com.framework.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bms.issue.archive.impl.Operator;
import com.bms.issue.bean.Blackboard;
import com.bms.issue.bean.param.ISSU0206IBean;
import com.bms.issue.service.ISSU0206IService;
import com.framework.redis.dao.BaseRedisDao;

/**
 * 问题点新增接口Service
 *
 * @author li_huiqian
 */
@Service
public class ISSU0206IServiceImpl implements ISSU0206IService {

    @Autowired
    private BaseRedisDao redisDao;
    @Autowired
    private QuestionDao questionDao;
    @Autowired
    private QuestionItemDao questionItemDao;
    @Autowired
    private QuestionAccessoryDao questionAccessoryDao;

    /**
     * 接收问题点信息，新增问题点
     *
     * @param operator 操作者
     * @param bean     ISSU0206IBean
     */
    @Override
    public QuestionItem execute(Operator operator, ISSU0206IBean bean) {
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
        QuestionItem questionItem = (QuestionItem)map.get("questionItem");
        return questionItem;
    }

    /**
     * 准备
     *
     * @param map HashMap
     */
    private void pre(HashMap<String, Object> map) {
// 获取参数
        ISSU0206IBean bean = (ISSU0206IBean) map.get("bean");
        Blackboard blackboard = (Blackboard) map.get("blackboard");
// 设置DAO
// TODO 设置DAO
        blackboard.setBaseRedisDao(redisDao);
        blackboard.putBaseDao(questionDao);
        blackboard.putBaseDao(questionItemDao);
        blackboard.putBaseDao(questionAccessoryDao);

// blackboard.putBaseDao(buyerOrderDao);

//操作者
        Operator operator = blackboard.getOperator();
        operator.setBlackboard(blackboard);
// 获取完整操作者
        operator.complete(false);
        Question question = Question.build(blackboard).forComplete(bean.getQuestionId());
        question.complete(false);

        if (!question.isDataSynced()) {
            throw new BusinessException(ModuleCode.ISSU, ErrorCode.E020601);
        }
        if (null != question.getEntity().isQuestionIsClose() && question.getEntity().isQuestionIsClose() == true) {
            throw new BusinessException(ModuleCode.ISSU, ErrorCode.E020602);
        }
    }

    /**
     * 执行
     *
     * @param map HashMap
     */
    private void process(HashMap<String, Object> map) {
// 获取参数
        ISSU0206IBean bean = (ISSU0206IBean) map.get("bean");
        Blackboard blackboard = (Blackboard) map.get("blackboard");
// 执行操作
        QuestionItem questionItem = bean.createQuestionItem();
        questionItem.setBlackboard(blackboard);
        List<QuestionAccessory> accessories = questionItem.getQuestionAccessorys();
        questionItem.create();
        if(!CollectionUtils.isEmpty(accessories)){
            for(QuestionAccessory accessory : accessories){
                accessory.getEntity().setItemId(questionItem.getEntity().getItemId());
            }
            QuestionAccessoryList questionAccessoryList = QuestionAccessoryList.build(blackboard).forCreate(
                    accessories.toArray(new QuestionAccessory[0]));
            questionAccessoryList.create();
        }
        map.put("questionItem",questionItem);
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
