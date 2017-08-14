package com.bms.issue.service.impl;

import com.bms.issue.archive.impl.Operator;
import com.bms.issue.archive.impl.Question;
import com.bms.issue.archive.impl.QuestionAccessory;
import com.bms.issue.archive.impl.QuestionItem;
import com.bms.issue.bean.Blackboard;
import com.bms.issue.bean.entity.QuestionAccessoryEntity;
import com.bms.issue.bean.entity.QuestionItemEntity;
import com.bms.issue.bean.param.ISSU0207IBean;
import com.bms.issue.constant.IssueConst;
import com.bms.issue.constant.i18n.ErrorCode;
import com.bms.issue.constant.i18n.ModuleCode;
import com.bms.issue.dao.IssueDao;
import com.bms.issue.dao.QuestionAccessoryDao;
import com.bms.issue.dao.QuestionDao;
import com.bms.issue.dao.QuestionItemDao;
import com.bms.issue.service.ISSU0207IService;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.StringUtils;
import com.framework.exception.BusinessException;
import com.framework.redis.dao.BaseRedisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * 问题点编辑接口Service
 *
 * @author li_huiqian
 */
@Service
public class ISSU0207IServiceImpl implements ISSU0207IService {

    @Autowired
    private BaseRedisDao redisDao;

    @Autowired
    private IssueDao issueDao;
    @Autowired
    private QuestionDao questionDao;
    @Autowired
    private QuestionItemDao questionItemDao;
    @Autowired
    private QuestionAccessoryDao questionAccessoryDao;


    /**
     * 接收问题点信息，编辑问题点，可适用于问题点的方案执行、问题点的结案等
     *
     * @param operator 操作者
     * @param bean     ISSU0207IBean
     */
    @Override
    public void execute(Operator operator, ISSU0207IBean bean) {
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
    }

    /**
     * 准备
     *
     * @param map HashMap
     */
    private void pre(HashMap<String, Object> map) {
// 获取参数
        ISSU0207IBean param = (ISSU0207IBean) map.get("bean");
        Blackboard blackboard = (Blackboard) map.get("blackboard");
// 设置DAO
        blackboard.setBaseRedisDao(redisDao);
        blackboard.putBaseDao(issueDao);
        blackboard.putBaseDao(questionDao);
        blackboard.putBaseDao(questionItemDao);
        blackboard.putBaseDao(questionAccessoryDao);

//操作者
        Operator operator = blackboard.getOperator();
        operator.setBlackboard(blackboard);
// 获取完整操作者
        operator.complete(false);
        QuestionItem questionItem = this.checkQuestionItem(param, blackboard);
        // 返回参数
        map.put("questionItem", questionItem);
    }

    /**
     * 执行
     *
     * @param map HashMap
     */
    private void process(HashMap<String, Object> map) {
// 获取参数
        QuestionItem questionItem = (QuestionItem) map.get("questionItem");
        ISSU0207IBean param = (ISSU0207IBean) map.get("bean");
        questionItem.modify();
        List<ISSU0207IBean.ISSU0207Accessory> accessorys = param.getAccessorys();
        this.updateAccessorys(accessorys, questionItem);

// 执行操作

    }

    /**
     * @param bean
     * @param blackboard
     * @return
     */
    public QuestionItem checkQuestionItem(ISSU0207IBean bean, Blackboard blackboard) {
        Long itemId = bean.getItemId();
        Long questionId = bean.getQuestionId();
        Integer version = bean.getVersion();
        QuestionItem questionItem = new QuestionItem(itemId);
        questionItem.setBlackboard(blackboard);
        questionItem.complete(false);
        if (!questionItem.isDataSynced()) {
            throw new BusinessException(ModuleCode.ISSU, ErrorCode.E020701, bean.getItemId().toString());
        }

        Question question = questionItem.getQuestion();
        if (!question.isDataSynced()) {// 问题check
            //  问题不存在
            throw new BusinessException(ModuleCode.ISSU, ErrorCode.E020705, bean.getQuestionId().toString());
        }

        Boolean questionIsClose = question.getEntity().isQuestionIsClose();
        if (questionIsClose != null && questionIsClose) {
            //  已经结案的 问题
            throw new BusinessException(ModuleCode.ISSU, ErrorCode.E020706, question.getEntity().getQuestionId().toString());
        }

        QuestionItemEntity questionItemEntity = questionItem.getEntity();
        if (!itemId.equals(questionItemEntity.getItemId())) {
            throw new BusinessException(ModuleCode.ISSU, ErrorCode.E020701, itemId.toString());
        }
        if (!questionId.equals(questionItemEntity.getQuestionId())) {
            throw new BusinessException(ModuleCode.ISSU, ErrorCode.E020702, questionId.toString());
        }
        if (!version.equals(questionItemEntity.getVersion())) {
            throw new BusinessException(ModuleCode.ISSU, ErrorCode.E020703, itemId.toString());
        }
        String itemDesc = bean.getItemDesc();
        if (itemDesc != null) {
            questionItemEntity.setItemDesc(itemDesc);
        }
        String itemSolution = bean.getItemSolution();
        if (itemSolution != null) {
            questionItemEntity.setItemSolution(itemSolution);
        }

        String itemExcutor = bean.getItemExcutor();
        if (itemExcutor != null) {
            questionItemEntity.setItemExcutor(itemExcutor);
        }
        String itemStartTime = bean.getItemStartTime();
        if (itemStartTime != null) {
            if (itemStartTime.length() == 0) {
                questionItemEntity.setItemStartTime(null);
            } else {
                questionItemEntity.setItemStartTime(DateUtils.parseDateTime(bean.getItemStartTime()));
            }
        }
        String endTime = bean.getItemEndTime();
        if (endTime != null) {
            if (endTime.length() == 0) {
                questionItemEntity.setItemEndTime(null);
            } else {
                questionItemEntity.setItemEndTime(DateUtils.parseDateTime(bean.getItemEndTime()));
            }
        }
        String itemResult = bean.getItemResult();
        if (itemResult != null) {
            questionItemEntity.setItemResult(itemResult);
        }
        String itemFeedBack = bean.getItemFeedBack();
        if (itemFeedBack != null) {
            questionItemEntity.setItemFeedback(itemFeedBack);
        }
        String itemCloser = bean.getItemCloser();
        if (itemCloser != null) {
            questionItemEntity.setItemCloser(itemCloser);
        }
        String itemCloseTime = bean.getItemCloseTime();
        if (itemCloseTime != null) {
            if (itemCloseTime.length() == 0) {
                questionItemEntity.setItemCloseTime(null);
            } else {
                questionItemEntity.setItemCloseTime(DateUtils.parseDateTime(bean.getItemCloseTime()));
            }
        }
        return questionItem;
    }

    /**
     * 修改 附件
     *
     * @param accessorys
     * @param questionItem
     */
    private void updateAccessorys(List<ISSU0207IBean.ISSU0207Accessory> accessorys, QuestionItem questionItem) {
        if (CollectionUtils.isNotEmpty(accessorys)) {
            for (ISSU0207IBean.ISSU0207Accessory accessory : accessorys) {
                Boolean delFlg = accessory.getDelFlg();
                QuestionAccessory questionAccessory = null;
                if (delFlg != null && delFlg) {// 删除
                    Long accessoryId = accessory.getAccessoryId();
                    Integer version = accessory.getVersion();
                    this.checkQuestionAccessory(questionItem, accessoryId, version);
                    questionAccessory = new QuestionAccessory(accessoryId);
                    questionAccessory.setBlackboard(questionItem.getBlackboard());
                    questionAccessory.complete(false);
                    questionAccessory.delete();
                } else {// 添加
                    QuestionAccessoryEntity questionAccessoryEntity = new QuestionAccessoryEntity();
                    questionAccessoryEntity.setItemId(accessory.getItemId());
                    questionAccessoryEntity.setFileId(accessory.getFileId());
                    questionAccessoryEntity.setFileName(accessory.getFileName());
                    questionAccessoryEntity.setFileType(accessory.getFileType());
                    questionAccessoryEntity.setAccessoryType(IssueConst.ACCESSORYTYPE_QUESTIONITEM);
                    questionAccessory = new QuestionAccessory(questionAccessoryEntity);
                    questionAccessory.setBlackboard(questionItem.getBlackboard());
                    questionAccessory.create();
                }
            }
        }

    }

    /**
     * 检查 附件是否存在
     *
     * @param questionItem
     * @param accessoryId
     */
    private void checkQuestionAccessory(QuestionItem questionItem, Long accessoryId, Integer version) {
        List<QuestionAccessory> accessoryList = questionItem.getQuestionAccessorys();
        Boolean isExist = false;// 不存在
        if (CollectionUtils.isNotEmpty(accessoryList)) {
            for (QuestionAccessory accessory : accessoryList) {
                Long dbAccessoryId = accessory.getEntity().getAccessoryId();
                Integer dbVersion = accessory.getEntity().getVersion();
                if (dbAccessoryId.equals(accessoryId) && version.equals(dbVersion)) {
                    isExist = true;
                }
            }
        }
        if (!isExist) {
            throw new BusinessException(ModuleCode.ISSU, ErrorCode.E020704, accessoryId.toString());
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
}
