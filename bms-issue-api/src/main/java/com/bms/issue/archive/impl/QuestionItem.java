package com.bms.issue.archive.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import com.bms.issue.archive.AbstractArchive;
import com.bms.issue.archive.Completable;
import com.bms.issue.archive.Createable;
import com.bms.issue.archive.Deletable;
import com.bms.issue.archive.Linkable;
import com.bms.issue.archive.Modifiable;
import com.bms.issue.archive.impl.list.QuestionAccessoryList;
import com.bms.issue.bean.Blackboard;
import com.bms.issue.bean.entity.QuestionItemEntity;
import com.bms.issue.constant.i18n.ErrorCode;
import com.bms.issue.constant.i18n.ModuleCode;
import com.bms.issue.dao.QuestionItemDao;
import com.bms.issue.util.LinkHelper;
import com.framework.exception.BusinessException;

/**
 *
 * 记录问题订单的处理明细信息

 * @author li_huiqian

 */
public class QuestionItem extends AbstractArchive implements Completable, Createable, Linkable, Modifiable, Deletable {

    private static Logger logger = LoggerFactory.getLogger(QuestionItem.class);

    private static final String TABLE_NAME = "ISSU_QUESTION_ITEM";

    /** 问题订单问题表明细问题点Entity */
    private QuestionItemEntity entity;

    public QuestionItemEntity getEntity() {
        logger.info(this + "#getEntity");
        return entity;
    }


    /** 问题订单问题信息表 */
    private Question question;

    private boolean isQuestionComplete = false;

    /**
     * 关联完毕后调用
     *
     */
    public void questionLinked() {
        logger.info(this + "#questionLinked");
        isQuestionComplete = true;
    }

    /**
     * 重新取数据时用
     *
     */
    public void questionUnlink() {
        logger.info(this + "#questionUnlink");
        isQuestionComplete = false;
    }

    public Question getQuestion() {
        logger.info(this + "#getQuestion");
        if (!isDataSynced())
            return question;

        if (question == null || !isQuestionComplete) {
            Question question = new Question(entity.getQuestionId());
            question.setBlackboard(getBlackboard());
            question.complete(false);
            isQuestionComplete = true;
            this.question = null;
            if(question.isDataSynced())
                link(question);
        }

        return question;
    }
    /** 记录问题附件相关信息，如问题本身的附件或问题处理的附件 */
    private List<QuestionAccessory> questionAccessorys;

    private boolean isQuestionAccessorysComplete = false;

    /**
     * 关联完毕后调用
     *
     */
    public void questionAccessorysLinked() {
        logger.info(this + "#questionAccessorysLinked");
        isQuestionAccessorysComplete = true;
    }

    /**
     * 重新取数据时用
     *
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
            if(list.isDataSynced()) {
                link(list.getArchives());
                for (QuestionAccessory item : questionAccessorys)
                    item.questionItemLinked();
            }
        }

        return questionAccessorys;
    }

    /**
     * 构造函数，已过时，请使用QuestionItem.build(blackboard).forComplete(id)
     *
     */
    
    public  QuestionItem(Long id) {
        logger.info(this + "#QuestionItem");
        Assert.notNull(id);
        entity = new QuestionItemEntity();
        entity.setItemId(id);
    }

    /**
     * 构造函数，已过时，请使用QuestionItem.build(blackboard).forCreate(entity,)
     *
     */
    
    public  QuestionItem(QuestionItemEntity entity) {
        logger.info(this + "#QuestionItem");
        Assert.notNull(entity);
        this.entity = entity;
        setDataSynced(false);
    }

    /**
     * 构造函数，已过时，请使用QuestionItem.build(blackboard).forComplete(linkedArchive)
     *
     */
    
    public  QuestionItem(Question linkedArchive) {
        logger.info(this + "#QuestionItem");
        Assert.notNull(linkedArchive);
        Assert.notNull(linkedArchive.getEntity());
        Assert.notNull(linkedArchive.getEntity().getQuestionId());
        entity = new QuestionItemEntity();
        entity.setQuestionId(linkedArchive.getEntity().getQuestionId());
    }

    @Override
    public void link(Linkable target) {
        logger.info(this + "#link");
        if (target == null)
            return;

        if (target instanceof Question) {
            LinkHelper.link(this, target, "entity.questionId");
        
        } else if (target instanceof QuestionAccessory) {
            LinkHelper.link(this, target, "entity.itemId");
        
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

        if (item0 instanceof Question) {
            LinkHelper.link(this, targets, "entity.questionId");
        
        } else if (item0 instanceof QuestionAccessory) {
            LinkHelper.link(this, targets, "entity.itemId");
        
        }
    }

    @Override
    public void complete(boolean allowDelete) {
        logger.info(this + "#complete");
        // 判断是否是最新
        if (isDataSynced()) {
            return;
        }

        if (entity.getItemId() != null) {
            QuestionItemEntity entity = new QuestionItemEntity();
            entity.setItemId(this.entity.getItemId());
            this.entity = entity;
        } else if (entity.getQuestionId() != null) {
            QuestionItemEntity entity = new QuestionItemEntity();
            entity.setQuestionId(this.entity.getQuestionId());
            this.entity = entity;
        }

        // 设置允许DEL_FLG=true
        if (allowDelete)
            this.entity.setDelFlg(true);
        else
            this.entity.setDelFlg(false);

        // 查询数据库
        QuestionItemDao dao = getDao(QuestionItemDao.class);
        QuestionItemEntity entity = dao.findOne(this.entity);
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
        QuestionItemDao dao = getDao(QuestionItemDao.class);

        // 一意制约检测
        // 获取ID
        Long id = getBlackboard().maxId(TABLE_NAME);
        // 设置ID
        this.entity.setItemId(id);

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
        QuestionItemDao dao = getDao(QuestionItemDao.class);

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
        QuestionItemDao dao = getDao(QuestionItemDao.class);

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
            return this.getClass().getName() + this.entity.getItemId();
        else
            return this.getClass().getName();
    }

    public static Builder build(Blackboard blackboard) {
        return new Builder(blackboard);
    }

    public static class Builder{

    private Blackboard blackboard;

    public  Builder(Blackboard blackboard) {
        logger.info(this + "#Builder");
        this.blackboard = blackboard;
    }

    /**
     * 创建对象，用于根据id查询数据，此对象必须使用complete方法补全
     *
     */
    public QuestionItem forComplete(Long id) {
        logger.info(this + "#forComplete");
        QuestionItem build = new QuestionItem(id);
        build.setBlackboard(blackboard);
        return build;
    }

    /**
     * 创建对象，用于插入数据库，此对象必须使用create方法插入数据库
     *
     */
    public QuestionItem forCreate(QuestionItemEntity entity) {
        logger.info(this + "#forCreate");
        QuestionItem build = new QuestionItem(entity);
        build.setBlackboard(blackboard);
        return build;
    }

    /**
     * 创建对象，用于根据entity.questionId查询数据，此对象必须使用complete方法补全
     *
     */
    public QuestionItem forComplete(Question linkedArchive) {
        logger.info(this + "#forComplete");
        QuestionItem build = new QuestionItem(linkedArchive);
        build.setBlackboard(blackboard);
        return build;
    }

    }


}