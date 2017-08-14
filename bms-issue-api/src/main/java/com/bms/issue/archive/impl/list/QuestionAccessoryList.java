package com.bms.issue.archive.impl.list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import com.bms.issue.archive.AbstractArchive;
import com.bms.issue.archive.Completable;
import com.bms.issue.archive.Createable;
import com.bms.issue.archive.Deletable;
import com.bms.issue.archive.Linkable;
import com.bms.issue.archive.Modifiable;
import com.bms.issue.archive.impl.Question;
import com.bms.issue.archive.impl.QuestionAccessory;
import com.bms.issue.archive.impl.QuestionItem;
import com.bms.issue.bean.Blackboard;
import com.bms.issue.bean.entity.QuestionAccessoryEntity;
import com.bms.issue.constant.i18n.ErrorCode;
import com.bms.issue.constant.i18n.ModuleCode;
import com.bms.issue.dao.QuestionAccessoryDao;
import com.bms.issue.util.LinkHelper;
import com.framework.exception.BusinessException;

/**
 *
 * 记录问题附件相关信息，如问题本身的附件或问题处理的附件列表辅助类
 * 
 * @author li_huiqian
 * 
 */
public class QuestionAccessoryList extends AbstractArchive
        implements Completable, Createable, Linkable, Modifiable, Deletable {

    private static Logger logger = LoggerFactory.getLogger(QuestionAccessoryList.class);

    private static final String TABLE_NAME = "ISSU_QUESTION_ACCESSORY";

    /** 问题附件Entity */
    private List<QuestionAccessoryEntity> entities;

    /** 记录问题附件相关信息，如问题本身的附件或问题处理的附件列表辅助类 */
    private List<QuestionAccessory> archives;

    public List<QuestionAccessory> getArchives() {
        logger.info(this + "#getArchives");
        return archives;
    }

    /** 问题订单问题信息表 */
    private List<Question> questions;

    /** 记录问题订单的处理明细信息 */
    private List<QuestionItem> questionItems;

    private List<Long> ids;

    /**
     * 构造函数
     *
     */
    
    public QuestionAccessoryList(Long[] ids) {
        logger.info(this + "#QuestionAccessoryList");
        Assert.notEmpty(ids);
        this.ids = new ArrayList<>();
        for (Long id : ids)
            this.ids.add(id);
    }

    /**
     * 构造函数
     *
     */
    
    public QuestionAccessoryList(List<QuestionAccessoryEntity> entities) {
        logger.info(this + "#QuestionAccessoryList");
        Assert.notEmpty(entities);
        this.entities = entities;
        setDataSynced(false);
    }

    /**
     * 构造函数
     *
     */
    
    public QuestionAccessoryList(QuestionAccessory[] archives) {
        logger.info(this + "#QuestionAccessoryList");
        Assert.notEmpty(archives);
        for (QuestionAccessory archive : archives) {
            Assert.notNull(archive.getEntity());
        }

        this.archives = new ArrayList<>();
        this.entities = new ArrayList<>();
        for (QuestionAccessory archive : archives) {
            this.archives.add(archive);
            this.entities.add(archive.getEntity());
        }

        setDataSynced(false);
    }

    /**
     * 构造函数
     *
     */
    
    public QuestionAccessoryList(Question linkedArchive) {
        logger.info(this + "#QuestionAccessoryList");
        Assert.notNull(linkedArchive);
        Assert.notNull(linkedArchive.getEntity());
        Assert.notNull(linkedArchive.getEntity().getQuestionId());
        this.questions = new ArrayList<>();
        this.questions.add(linkedArchive);
    }

    /**
     * 构造函数
     *
     */
    
    public QuestionAccessoryList(Question[] linkedArchives) {
        logger.info(this + "#QuestionAccessoryList");
        Assert.notEmpty(linkedArchives);
        this.questions = new ArrayList<>();
        for (Question linkedArchive : linkedArchives) {
            Assert.notNull(linkedArchive.getEntity());
            Assert.notNull(linkedArchive.getEntity().getQuestionId());
            this.questions.add(linkedArchive);
        }
    }

    /**
     * 构造函数
     *
     */
    
    public QuestionAccessoryList(QuestionItem linkedArchive) {
        logger.info(this + "#QuestionAccessoryList");
        Assert.notNull(linkedArchive);
        Assert.notNull(linkedArchive.getEntity());
        Assert.notNull(linkedArchive.getEntity().getItemId());
        this.questionItems = new ArrayList<>();
        this.questionItems.add(linkedArchive);
    }

    /**
     * 构造函数
     *
     */
    
    public QuestionAccessoryList(QuestionItem[] linkedArchives) {
        logger.info(this + "#QuestionAccessoryList");
        Assert.notEmpty(linkedArchives);
        this.questionItems = new ArrayList<>();
        for (QuestionItem linkedArchive : linkedArchives) {
            Assert.notNull(linkedArchive.getEntity());
            Assert.notNull(linkedArchive.getEntity().getItemId());
            this.questionItems.add(linkedArchive);
        }
    }

    @Override
    public void link(Linkable target) {
        logger.info(this + "#link");
        if (target == null)
            return;

        if (target instanceof Question) {
            LinkHelper.link(this.archives, target, "entity.questionId");

        } else if (target instanceof QuestionItem) {
            LinkHelper.link(this.archives, target, "entity.itemId");

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
            LinkHelper.link(this.archives, targets, "entity.questionId");

        } else if (item0 instanceof QuestionItem) {
            LinkHelper.link(this.archives, targets, "entity.itemId");

        }
    }

    @Override
    public void complete(boolean allowDelete) {
        logger.info(this + "#complete");
        Map<String, Object> map = new HashMap<>();

        if (ids != null && ids.size() != 0)
            map.put("ids", ids);
        else if (questions != null && questions.size() != 0)
            map.put("questions", questions);
        else if (questionItems != null && questionItems.size() != 0)
            map.put("questionItems", questionItems);
        // 设置允许DEL_FLG=true
        if (allowDelete)
            map.put("delFlg", true);
        else
            map.put("delFlg", false);

        // 查询数据库
        QuestionAccessoryDao dao = getDao(QuestionAccessoryDao.class);
        List<QuestionAccessoryEntity> entities = dao.findAll(map);
        if (entities == null || entities.isEmpty())
            return;

        for (QuestionAccessoryEntity entity : entities) {
            QuestionAccessory archive = QuestionAccessory.build(getBlackboard()).forCreate(entity);
            archive.setDataSynced(true);

            if (archives == null)
                archives = new ArrayList<>();
            archives.add(archive);
        }

        setDataSynced(true);

    }

    @Override
    public void create() {
        logger.info(this + "#create");
        Assert.notEmpty(entities);

        // 获取Dao
        QuestionAccessoryDao dao = getDao(QuestionAccessoryDao.class);

        // 一意制约检测

        // 获取ID
        Long id = getBlackboard().maxId(TABLE_NAME, entities.size());
        // 设置ID
        for (int i = 0; i < entities.size(); i++) {
            QuestionAccessoryEntity entity = entities.get(i);
            entity.setAccessoryId(id);
            id += 1;
        }

        // 设置共通字段
        for (int i = 0; i < entities.size(); i++) {
            QuestionAccessoryEntity entity = entities.get(i);
            insertCommon(entity);
        }

        // 插入数据库
        int count = dao.batchSave(entities);
        if (count != entities.size())
            throw new BusinessException(ModuleCode.ISSU, ErrorCode.E000005);

        setDataSynced(true);

    }

    @Override
    public void modify() {
        logger.info(this + "#modify");
        Assert.notEmpty(entities);

        // 获取Dao
        QuestionAccessoryDao dao = getDao(QuestionAccessoryDao.class);

        // 设置共通字段
        for (int i = 0; i < entities.size(); i++) {
            QuestionAccessoryEntity entity = entities.get(i);
            updateCommon(entity);
        }

        // 更新数据库带排他检测
        int count = dao.batchModify(entities);
        if (count != 1)
            throw new BusinessException(ModuleCode.ISSU, ErrorCode.E000007);

    }

    @Override
    public void delete() {
        logger.info(this + "#delete");
        Assert.notEmpty(entities);

        // 获取Dao
        QuestionAccessoryDao dao = getDao(QuestionAccessoryDao.class);

        // 设置共通字段
        for (int i = 0; i < entities.size(); i++) {
            QuestionAccessoryEntity entity = entities.get(i);
            deleteCommon(entity);
        }

        // 更新数据库带排他检测
        int count = dao.batchDelete(entities);
        if (count != 1)
            throw new BusinessException(ModuleCode.ISSU, ErrorCode.E000009);

    }

    @Override
    public String toString() {
        return this.getClass().getName();
    }

    @Override
    public void setDataSynced(boolean dataSynced) {
        logger.info(this + "#setDataSynced");
        if (archives != null)
            for (QuestionAccessory archive : archives)
                archive.setDataSynced(dataSynced);
        super.setDataSynced(dataSynced);
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
         * 创建对象列表，用于根据id查询数据，此对象列表必须使用complete方法补全
         *
         */
        public QuestionAccessoryList forComplete(Long[] ids) {
            logger.info(this + "#forComplete");
            QuestionAccessoryList build = new QuestionAccessoryList(ids);
            build.setBlackboard(blackboard);
            return build;
        }

        /**
         * 创建对象列表，用于插入数据库，此对象列表必须使用create方法插入数据库
         *
         */
        public QuestionAccessoryList forCreate(QuestionAccessory[] archives) {
            logger.info(this + "#forCreate");
            QuestionAccessoryList build = new QuestionAccessoryList(archives);
            build.setBlackboard(blackboard);

            return build;
        }

        /**
         * 创建对象列表，用于修改/删除数据，此对象列表必须使用modify/delete方法
         *
         */
        public QuestionAccessoryList forUpdate(QuestionAccessory[] archives) {
            logger.info(this + "#forUpdate");
            QuestionAccessoryList build = new QuestionAccessoryList(archives);
            build.setBlackboard(blackboard);
            build.setDataSynced(true);

            return build;
        }

        /**
         * 创建对象，用于根据entity.questionId查询数据，此对象必须使用complete方法补全
         *
         */
        public QuestionAccessoryList forComplete(Question linkedArchive) {
            logger.info(this + "#forComplete");
            QuestionAccessoryList build = new QuestionAccessoryList(linkedArchive);
            build.setBlackboard(blackboard);
            return build;
        }

        /**
         * 创建对象，用于根据entity.itemId查询数据，此对象必须使用complete方法补全
         *
         */
        public QuestionAccessoryList forComplete(QuestionItem linkedArchive) {
            logger.info(this + "#forComplete");
            QuestionAccessoryList build = new QuestionAccessoryList(linkedArchive);
            build.setBlackboard(blackboard);
            return build;
        }

    }

}