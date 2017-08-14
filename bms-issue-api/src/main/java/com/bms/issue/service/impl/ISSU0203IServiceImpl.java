package com.bms.issue.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.common.rest.apiclient.RestApiClientFactory;
import com.bms.issue.archive.impl.Issue;
import com.bms.issue.archive.impl.Operator;
import com.bms.issue.archive.impl.Question;
import com.bms.issue.archive.impl.QuestionAccessory;
import com.bms.issue.bean.Blackboard;
import com.bms.issue.bean.entity.IssueEntity;
import com.bms.issue.bean.entity.QuestionAccessoryEntity;
import com.bms.issue.bean.entity.QuestionEntity;
import com.bms.issue.bean.param.ISSU0203IBean;
import com.bms.issue.common.rest.param.PageList;
import com.bms.issue.constant.IssueConst;
import com.bms.issue.constant.enumeration.IssueStatus;
import com.bms.issue.constant.i18n.ErrorCode;
import com.bms.issue.constant.i18n.ModuleCode;
import com.bms.issue.dao.IssueDao;
import com.bms.issue.dao.QuestionAccessoryDao;
import com.bms.issue.dao.QuestionDao;
import com.bms.issue.external.archive.BuyerOrder;
import com.bms.issue.external.bean.param.BuyerOrderSearchFilter;
import com.bms.issue.service.ISSU0203IService;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.StringUtils;
import com.framework.exception.BusinessException;
import com.framework.redis.dao.BaseRedisDao;

/**
 * 问题订单问题修改接口Service
 *
 * @author li_huiqian
 */
@Service
public class ISSU0203IServiceImpl implements ISSU0203IService {

    @Autowired
    private BaseRedisDao redisDao;
    @Autowired
    private IssueDao issueDao;
    @Autowired
    private QuestionDao questionDao;
    @Autowired
    private QuestionAccessoryDao questionAccessoryDao;
    @Autowired
    private RestApiClientFactory restApiClientFactory;

    /**
     * 接收问题信息，修改问题
     *
     * @param operator 操作者
     * @param bean     ISSU0203IBean
     */
    @Override
    public void execute(Operator operator, ISSU0203IBean bean) {
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
        ISSU0203IBean param = (ISSU0203IBean) map.get("param");
        Blackboard blackboard = (Blackboard) map.get("blackboard");


        // 设置DAO

        blackboard.setBaseRedisDao(redisDao);
        blackboard.putBaseDao(issueDao);
        blackboard.putBaseDao(questionDao);
        blackboard.putBaseDao(questionAccessoryDao);

        //操作者
        Operator operator = blackboard.getOperator();
        operator.setBlackboard(blackboard);
        // 获取完整操作者
        operator.complete(false);

        Question question = this.checkQuestion(param, blackboard);
        Issue issue = this.getIssue(question, param);

        // 返回参数
        map.put("question", question);
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
        Question question = (Question) map.get("question");
        ISSU0203IBean bean = (ISSU0203IBean) map.get("param");
        QuestionEntity entity = question.getEntity();
        String questionCatagory1 = bean.getQuestionCatagory1();
        if (questionCatagory1 != null) {
            entity.setQuestionCatagory1(questionCatagory1);
        }
        String questionCatagory2 = bean.getQuestionCatagory2();
        if (questionCatagory2 != null) {
            entity.setQuestionCatagory2(questionCatagory2);
        }
        String questionCatagory3 = bean.getQuestionCatagory3();
        if (questionCatagory3 != null) {
            entity.setQuestionCatagory3(questionCatagory3);
        }
        String questionKeyword = bean.getQuestionKeyword();
        if (questionKeyword != null) {
            entity.setQuestionKeyword(questionKeyword);
        }
        String questionDesc = bean.getQuestionDesc();
        if (questionDesc != null) {
            entity.setQuestionDesc(questionDesc);
        }
        String questionStartTime = bean.getQuestionStartTime();
        if (questionStartTime != null) {
            if (questionStartTime.equals("")) {
                entity.setQuestionStartTime(null);
            } else {
                entity.setQuestionStartTime(DateUtils.parseDateTime(questionStartTime));
            }
        }
        String questionStartUid = bean.getQuestionStartUid();
        if (questionStartUid != null) {
            entity.setQuestionStartUid(questionStartUid);
        }
        String questionStartUname = bean.getQuestionStartUname();
        if (questionStartUname != null) {
            entity.setQuestionStartUname(questionStartUname);
        }
        question.modify();
        List<ISSU0203IBean.ISSU0203Accessory> accessorys = bean.getAccessorys();
        this.updateAccessorys(accessorys, question);
        if(issue!=null){
            issue.modify();//修改问题订单列表状态
        }

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

    /**
     * 修改 附件
     *
     * @param accessorys
     * @param question
     */
    private void updateAccessorys(List<ISSU0203IBean.ISSU0203Accessory> accessorys, Question question) {
        if (CollectionUtils.isNotEmpty(accessorys)) {
            for (ISSU0203IBean.ISSU0203Accessory accessory : accessorys) {
                Boolean delFlg = accessory.getDelFlg();
                QuestionAccessory questionAccessory = null;
                if (delFlg != null && delFlg) {// 删除
                    Long accessoryId = accessory.getAccessoryId();
                    this.checkQuestionAccessory(question, accessoryId);
                    questionAccessory = new QuestionAccessory(accessoryId);
                    questionAccessory.setBlackboard(question.getBlackboard());
                    questionAccessory.complete(false);
                    questionAccessory.delete();
                } else {// 添加
                    QuestionAccessoryEntity questionAccessoryEntity = new QuestionAccessoryEntity();
                    questionAccessoryEntity.setQuestionId(accessory.getQuestionId());
                    questionAccessoryEntity.setFileId(accessory.getFileId());
                    questionAccessoryEntity.setFileName(accessory.getFileName());
                    questionAccessoryEntity.setFileType(accessory.getFileType());
                    questionAccessoryEntity.setAccessoryType(IssueConst.ACCESSORYTYPE_QUESTION);
                    questionAccessory = new QuestionAccessory(questionAccessoryEntity);
                    questionAccessory.setBlackboard(question.getBlackboard());
                    questionAccessory.create();
                }
            }
        }

    }

    /**
     * 检查 附件是否存在
     *
     * @param question
     * @param accessoryId
     */
    private void checkQuestionAccessory(Question question, Long accessoryId) {
        List<QuestionAccessory> accessoryList = question.getQuestionAccessorys();
        Boolean isExist = false;// 不存在
        if (CollectionUtils.isNotEmpty(accessoryList)) {
            for (QuestionAccessory accessory : accessoryList) {
                Long dbAccessoryId = accessory.getEntity().getAccessoryId();
                if (dbAccessoryId.equals(accessoryId)) {
                    isExist = true;
                }
            }
        }
        if (!isExist) {
            throw new BusinessException(ModuleCode.ISSU, ErrorCode.E020305, accessoryId.toString());
        }

    }


    /**
     * 检查问题是否存在及相关检查
     *
     * @param bean
     * @param blackboard
     * @return
     */
    private Question checkQuestion(ISSU0203IBean bean, Blackboard blackboard) {
        Question question = new Question(bean.getQuestionId());
        question.setBlackboard(blackboard);
        question.complete(false);

        QuestionEntity questionEntity = question.getEntity();
        if (!question.isDataSynced()) {
            throw new BusinessException(ModuleCode.ISSU, ErrorCode.E020301, bean.getQuestionId().toString());
        }


        Boolean questionIsClose = questionEntity.isQuestionIsClose();
        if (questionIsClose != null && questionIsClose) {  //  判读是否结案   如果结案
            throw new BusinessException(ModuleCode.ISSU, ErrorCode.E020307, bean.getQuestionId().toString());
        }

        Integer version = bean.getVersion();
        if (!version.equals(questionEntity.getVersion())) {
            throw new BusinessException(ModuleCode.ISSU, ErrorCode.E020302, bean.getQuestionId().toString());
        }


        Issue issue = question.getIssue();

        IssueEntity issueEntity = issue.getEntity();

        if (issueEntity == null) {
            throw new BusinessException(ModuleCode.ISSU, ErrorCode.E020303, bean.getIssueId().toString());
        }


        if (!bean.getIssueId().equals(issueEntity.getIssueId())) {
            throw new BusinessException(ModuleCode.ISSU, ErrorCode.E020304, bean.getIssueId().toString());
        }


        if (bean.getOrderDetailId() != null) {
            Long orderId = issueEntity.getOrderId();

            // 调用外部接口   check order  及orderDetailId
            BuyerOrderSearchFilter filter = new BuyerOrderSearchFilter();
            filter.setBuyerBatchOrderDetailId(new Long[] {bean.getOrderDetailId()});
            PageList<BuyerOrder> buyerOrders = BuyerOrder.findList(blackboard.getOperator(), filter, 1, 1, 1);
            if (buyerOrders.getTotal() == 0) {
                throw new BusinessException(ModuleCode.ISSU, ErrorCode.E020305, bean.getOrderDetailId().toString());
            }
            BuyerOrder buyerOrder = buyerOrders.get(0);

            if (!orderId.equals(buyerOrder.getEntity().getBuyerOrderId())) {
                throw new BusinessException(ModuleCode.ISSU, ErrorCode.E020305, bean.getOrderDetailId().toString());
            }
        }


        return question;
    }

    /**获取问题列表
     * @param question
     * @param bean
     * @return
     */
    public Issue getIssue(Question question, ISSU0203IBean bean) {
        Issue issue = null;
        Long issueId = question.getEntity().getIssueId();// 问题订单id
        String startTime = bean.getQuestionStartTime();
        String startUid = bean.getQuestionStartUid();
        String startUname = bean.getQuestionStartUname();
        if ((!StringUtils.isEmpty(startTime)) && (!StringUtils.isEmpty(startUid)) && (!StringUtils.isEmpty(startUname))) {// 三者同时并存  修改问题列表状态
            issue = new Issue(issueId);
            issue.setBlackboard(question.getBlackboard());
            issue.complete(false);
            IssueEntity issueEntity=   issue.getEntity();
            issueEntity.setIssueStatus(IssueStatus.HANDLING.getCode());
        }
        return issue;
    }
}
