package com.bms.issue.archive.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import com.bms.issue.archive.AbstractArchive;
import com.bms.issue.archive.Codeable;
import com.bms.issue.archive.Completable;
import com.bms.issue.archive.Createable;
import com.bms.issue.archive.Deletable;
import com.bms.issue.archive.Linkable;
import com.bms.issue.archive.Modifiable;
import com.bms.issue.archive.impl.list.QuestionAccessoryList;
import com.bms.issue.archive.impl.list.QuestionHandlingList;
import com.bms.issue.archive.impl.list.QuestionItemList;
import com.bms.issue.bean.Blackboard;
import com.bms.issue.bean.entity.QuestionEntity;
import com.bms.issue.constant.i18n.ErrorCode;
import com.bms.issue.constant.i18n.ModuleCode;
import com.bms.issue.dao.QuestionDao;
import com.bms.issue.util.CodeRule;
import com.bms.issue.util.LinkHelper;
import com.framework.exception.BusinessException;

/**
 * 问题订单问题信息表
 *
 * @author li_huiqian
 */
public class Question extends AbstractArchive
        implements Completable, Createable, Linkable, Modifiable, Deletable, Codeable {

    private static Logger logger = LoggerFactory.getLogger(Question.class);

    private static final String TABLE_NAME = "ISSU_QUESTION";

    /**
     * 问题订单问题表Entity
     */
    private QuestionEntity entity;

    public QuestionEntity getEntity() {
        logger.info(this + "#getEntity");
        return entity;
    }

    /**
     * 记录问题订单总表信息
     */
    private Issue issue;

    private boolean isIssueComplete = false;

    /**
     * 关联完毕后调用
     */
    public void issueLinked() {
        logger.info(this + "#issueLinked");
        isIssueComplete = true;
    }

    /**
     * 重新取数据时用
     */
    public void issueUnlink() {
        logger.info(this + "#issueUnlink");
        isIssueComplete = false;
    }

    public Issue getIssue() {
        logger.info(this + "#getIssue");
        if (!isDataSynced())
            return issue;

        if (issue == null || !isIssueComplete) {
            Issue issue = new Issue(entity.getIssueId());
            issue.setBlackboard(getBlackboard());
            issue.complete(false);
            isIssueComplete = true;
            this.issue = null;
            if (issue.isDataSynced())
                link(issue);
        }

        return issue;
    }

    /**
     * 记录问题附件相关信息，如问题本身的附件或问题处理的附件
     */
    private List<QuestionAccessory> questionAccessorys;

    private boolean isQuestionAccessorysComplete = false;

    /**
     * 关联完毕后调用
     */
    public void questionAccessorysLinked() {
        logger.info(this + "#questionAccessorysLinked");
        isQuestionAccessorysComplete = true;
    }

    /**
     * 重新取数据时用
     */
    public void questionAccessorysUnlink() {
        logger.info(this + "#questionAccessorysUnlink");
        isQuestionAccessorysComplete = false;
    }

    public List<QuestionAccessory> getQuestionAccessorys() {
        logger.info(this + "#getQuestionAccessorys");
        if (!isDataSynced())
            return questionAccessorys;

        if (questionAccessorys == null || !isQuestionAccessorysComplete) {
            QuestionAccessoryList list = new QuestionAccessoryList(this);
            list.setBlackboard(getBlackboard());
            list.complete(false);
            isQuestionAccessorysComplete = true;
            questionAccessorys = null;
            if (list.isDataSynced()) {
                link(list.getArchives());
                for (QuestionAccessory item : questionAccessorys)
                    item.questionLinked();
            }
        }

        return questionAccessorys;
    }

    /**
     * 记录问题订单的处理明细信息
     */
    private List<QuestionItem> questionItems;

    private boolean isQuestionItemsComplete = false;

    /**
     * 关联完毕后调用
     */
    public void questionItemsLinked() {
        logger.info(this + "#questionItemsLinked");
        isQuestionItemsComplete = true;
    }

    /**
     * 重新取数据时用
     */
    public void questionItemsUnlink() {
        logger.info(this + "#questionItemsUnlink");
        isQuestionItemsComplete = false;
    }

    public List<QuestionItem> getQuestionItems() {
        logger.info(this + "#getQuestionItems");
        if (!isDataSynced())
            return questionItems;

        if (questionItems == null || !isQuestionItemsComplete) {
            QuestionItemList list = new QuestionItemList(this);
            list.setBlackboard(getBlackboard());
            list.complete(false);
            isQuestionItemsComplete = true;
            questionItems = null;
            if (list.isDataSynced()) {
                link(list.getArchives());
                for (QuestionItem item : questionItems)
                    item.questionLinked();
            }
        }

        return questionItems;
    }

    /**
     * 记录问题订单的处理建议、结案建议等信息
     */
    private List<QuestionHandling> questionHandlings;

    private boolean isQuestionHandlingsComplete = false;

    /**
     * 关联完毕后调用
     */
    public void questionHandlingsLinked() {
        logger.info(this + "#questionHandlingsLinked");
        isQuestionHandlingsComplete = true;
    }

    /**
     * 重新取数据时用
     */
    public void questionHandlingsUnlink() {
        logger.info(this + "#questionHandlingsUnlink");
        isQuestionHandlingsComplete = false;
    }

    public List<QuestionHandling> getQuestionHandlings() {
        logger.info(this + "#getQuestionHandlings");
        if (!isDataSynced())
            return questionHandlings;

        if (questionHandlings == null || !isQuestionHandlingsComplete) {
            QuestionHandlingList list = new QuestionHandlingList(this);
            list.setBlackboard(getBlackboard());
            list.complete(false);
            isQuestionHandlingsComplete = true;
            questionHandlings = null;
            if (list.isDataSynced()) {
                link(list.getArchives());
                for (QuestionHandling item : questionHandlings)
                    item.questionLinked();
            }
        }

        return questionHandlings;
    }

    /**
     * 构造函数，已过时，请使用Question.build(blackboard).forComplete(id)
     */
    
    public Question(Long id) {
        logger.info(this + "#Question");
        Assert.notNull(id);
        entity = new QuestionEntity();
        entity.setQuestionId(id);
    }

    /**
     * 构造函数，已过时，请使用Question.build(blackboard).forComplete(code)
     */
    
    public Question(String code) {
        logger.info(this + "#Question");
        Assert.notNull(code);
        entity = new QuestionEntity();
        entity.setQuestionCode(code);
    }

    /**
     * 构造函数，已过时，请使用Question.build(blackboard).forCreate(entity,)
     */
    
    public Question(QuestionEntity entity) {
        logger.info(this + "#Question");
        Assert.notNull(entity);
        this.entity = entity;
        setDataSynced(false);
    }

    /**
     * 构造函数，已过时，请使用Question.build(blackboard).forComplete(linkedArchive)
     */
    
    public Question(Issue linkedArchive) {
        logger.info(this + "#Question");
        Assert.notNull(linkedArchive);
        Assert.notNull(linkedArchive.getEntity());
        Assert.notNull(linkedArchive.getEntity().getIssueId());
        entity = new QuestionEntity();
        entity.setIssueId(linkedArchive.getEntity().getIssueId());
    }

    @Override
    public void link(Linkable target) {
        logger.info(this + "#link");
        if (target == null)
            return;

        if (target instanceof Issue) {
            LinkHelper.link(this, target, "entity.issueId");

        } else if (target instanceof QuestionAccessory) {
            LinkHelper.link(this, target, "entity.questionId");

        } else if (target instanceof QuestionItem) {
            LinkHelper.link(this, target, "entity.questionId");

        } else if (target instanceof QuestionHandling) {
            LinkHelper.link(this, target, "entity.questionId");

        }
    }

    @Override
    public void link(List<?> targets) {
        logger.info(this + "#link");
        if (targets == null || targets.size() == 0)
            return;

        Object obj0 = targets.get(0);
        if (!(obj0 instanceof Linkable))
            return;
        Linkable item0 = (Linkable) obj0;

        if (item0 instanceof Issue) {
            LinkHelper.link(this, targets, "entity.issueId");

        } else if (item0 instanceof QuestionAccessory) {
            LinkHelper.link(this, targets, "entity.questionId");

        } else if (item0 instanceof QuestionItem) {
            LinkHelper.link(this, targets, "entity.questionId");

        } else if (item0 instanceof QuestionHandling) {
            LinkHelper.link(this, targets, "entity.questionId");

        }
    }

    @Override
    public void complete(boolean allowDelete) {
        logger.info(this + "#complete");
        // 判断是否是最新
        if (isDataSynced()) {
            return;
        }

        if (entity.getQuestionId() != null) {
            QuestionEntity entity = new QuestionEntity();
            entity.setQuestionId(this.entity.getQuestionId());
            this.entity = entity;
        } else if (entity.getQuestionCode() != null) {
            QuestionEntity entity = new QuestionEntity();
            entity.setQuestionCode(this.entity.getQuestionCode());
            this.entity = entity;
        } else if (entity.getIssueId() != null) {
            QuestionEntity entity = new QuestionEntity();
            entity.setIssueId(this.entity.getIssueId());
            this.entity = entity;
        }

        // 设置允许DEL_FLG=true
        if (allowDelete)
            this.entity.setDelFlg(true);
        else
            this.entity.setDelFlg(false);

        // 查询数据库
        QuestionDao dao = getDao(QuestionDao.class);
        QuestionEntity entity = dao.findOne(this.entity);
        if (entity == null)
            return;
        this.entity = entity;

        setDataSynced(true);

    }

    @Override
    public void create() {
        logger.info(this + "#create");
        Assert.notNull(entity);

        // 判断是否需要创建
        if (isDataSynced())
            throw new BusinessException(ModuleCode.ISSU, ErrorCode.E000003); 

        // 获取Dao
        QuestionDao dao = getDao(QuestionDao.class);

        // 生成编码
        generateCode();

        // 一意制约检测
        Question unique = new Question(entity.getQuestionCode());
        unique.setBlackboard(getBlackboard());
        unique.complete(false);
        if (unique.isDataSynced())
            throw new BusinessException(ModuleCode.ISSU, ErrorCode.E000004); 
        // 获取ID
        Long id = getBlackboard().maxId(TABLE_NAME);
        // 设置ID
        this.entity.setQuestionId(id);

        // 设置共通字段
        insertCommon(this.entity);

        // 插入数据库
        int count = dao.save(this.entity);
        if (count != 1)
            throw new BusinessException(ModuleCode.ISSU, ErrorCode.E000005); 

        setDataSynced(true);

    }

    @Override
    public void modify() {
        logger.info(this + "#modify");
        Assert.notNull(entity);

        // 判断是否需要修改
        if (!isDataSynced())
            throw new BusinessException(ModuleCode.ISSU, ErrorCode.E000006); 

        // 获取Dao
        QuestionDao dao = getDao(QuestionDao.class);

        // 设置共通字段
        updateCommon(this.entity);

        // 更新数据库带排他检测
        int count = dao.modify(this.entity);
        if (count != 1)
            throw new BusinessException(ModuleCode.ISSU, ErrorCode.E000007); 

    }

    @Override
    public void delete() {
        logger.info(this + "#delete");
        Assert.notNull(entity);

        // 判断是否需要删除
        if (!isDataSynced())
            throw new BusinessException(ModuleCode.ISSU, ErrorCode.E000008); 

        // 获取Dao
        QuestionDao dao = getDao(QuestionDao.class);

        // 设置共通字段
        deleteCommon(this.entity);

        // 删除数据库带排他检测
        int count = dao.delete(this.entity);
        if (count != 1)
            throw new BusinessException(ModuleCode.ISSU, ErrorCode.E000009);

    }

    @Override
    public String toString() {
        if (entity != null)
            return this.getClass().getName() + this.entity.getQuestionId();
        else
            return this.getClass().getName();
    }

    public static Builder build(Blackboard blackboard) {
        return new Builder(blackboard);
    }

    public static class Builder {

        private Blackboard blackboard;

        public Builder(Blackboard blackboard) {
            logger.info(this + "#Builder");
            this.blackboard = blackboard;
        }

        /**
         * 创建对象，用于根据id查询数据，此对象必须使用complete方法补全
         */
        public Question forComplete(Long id) {
            logger.info(this + "#forComplete");
            Question build = new Question(id);
            build.setBlackboard(blackboard);
            return build;
        }

        /**
         * 创建对象，用于根据code查询数据，此对象必须使用complete方法补全
         */
        public Question forComplete(String code) {
            logger.info(this + "#forComplete");
            Question build = new Question(code);
            build.setBlackboard(blackboard);
            return build;
        }

        /**
         * 创建对象，用于插入数据库，此对象必须使用create方法插入数据库
         */
        public Question forCreate(QuestionEntity entity) {
            logger.info(this + "#forCreate");
            Question build = new Question(entity);
            build.setBlackboard(blackboard);
            return build;
        }

        /**
         * 创建对象，用于根据entity.issueId查询数据，此对象必须使用complete方法补全
         */
        public Question forComplete(Issue linkedArchive) {
            logger.info(this + "#forComplete");
            Question build = new Question(linkedArchive);
            build.setBlackboard(blackboard);
            return build;
        }

    }

    @Override
    public void generateCode() {
        entity.setQuestionCode(CodeRule.commonRule("WTBM"));
    }
}