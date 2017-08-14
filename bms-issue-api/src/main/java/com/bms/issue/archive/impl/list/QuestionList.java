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
import com.bms.issue.archive.impl.Issue;
import com.bms.issue.archive.impl.Question;
import com.bms.issue.archive.impl.QuestionAccessory;
import com.bms.issue.archive.impl.QuestionHandling;
import com.bms.issue.archive.impl.QuestionItem;
import com.bms.issue.bean.Blackboard;
import com.bms.issue.bean.entity.QuestionEntity;
import com.bms.issue.constant.i18n.ErrorCode;
import com.bms.issue.constant.i18n.ModuleCode;
import com.bms.issue.dao.QuestionDao;
import com.bms.issue.util.LinkHelper;
import com.framework.exception.BusinessException;

/**
 * 问题订单问题信息表列表辅助类
 *
 * @author li_huiqian
 */
public class QuestionList extends AbstractArchive implements Completable, Createable, Linkable, Modifiable, Deletable {

    private static Logger logger = LoggerFactory.getLogger(QuestionList.class);

    private static final String TABLE_NAME = "ISSU_QUESTION";

    /**
     * 问题订单问题表Entity
     */
    private List<QuestionEntity> entities;


    /**
     * 问题订单问题信息表列表辅助类
     */
    private List<Question> archives;

    public List<Question> getArchives() {
        logger.info(this + "#getArchives");
        return archives;
    }

    /**
     * 记录问题订单总表信息
     */
    private List<Issue> issues;


    private List<Long> ids;

    private List<String> codes;


    /**
     * 构造函数
     */
    
    public QuestionList(Long[] ids) {
        logger.info(this + "#QuestionList");
        Assert.notEmpty(ids);
        this.ids = new ArrayList<>();
        for (Long id : ids)
            this.ids.add(id);
    }

    /**
     * 构造函数
     */
    
    public QuestionList(String[] codes) {
        logger.info(this + "#QuestionList");
        Assert.notEmpty(codes);
        this.codes = new ArrayList<>();
        for (String code : codes)
            this.codes.add(code);
    }

    /**
     * 构造函数
     */
    
    public QuestionList(List<QuestionEntity> entities) {
        logger.info(this + "#QuestionList");
        Assert.notEmpty(entities);
        this.entities = entities;
        setDataSynced(false);
    }

    /**
     * 构造函数
     */
    
    public QuestionList(Question[] archives) {
        logger.info(this + "#QuestionList");
        Assert.notEmpty(archives);
        for (Question archive : archives) {
            Assert.notNull(archive.getEntity());
        }

        this.archives = new ArrayList<>();
        this.entities = new ArrayList<>();
        for (Question archive : archives) {
            this.archives.add(archive);
            this.entities.add(archive.getEntity());
        }

        setDataSynced(false);
    }

    /**
     * 构造函数
     */
    
    public QuestionList(Issue linkedArchive) {
        logger.info(this + "#QuestionList");
        Assert.notNull(linkedArchive);
        Assert.notNull(linkedArchive.getEntity());
        Assert.notNull(linkedArchive.getEntity().getIssueId());
        this.issues = new ArrayList<>();
        this.issues.add(linkedArchive);
    }

    /**
     * 构造函数
     */
    
    public QuestionList(Issue[] linkedArchives) {
        logger.info(this + "#QuestionList");
        Assert.notEmpty(linkedArchives);
        this.issues = new ArrayList<>();
        for (Issue linkedArchive : linkedArchives) {
            Assert.notNull(linkedArchive.getEntity());
            Assert.notNull(linkedArchive.getEntity().getIssueId());
            this.issues.add(linkedArchive);
        }
    }


    @Override
    public void link(Linkable target) {
        logger.info(this + "#link");
        if (target == null)
            return;

        if (target instanceof Issue) {
            LinkHelper.link(this.archives, target, "entity.issueId");

        } else if (target instanceof QuestionAccessory) {
            LinkHelper.link(this.archives, target, "entity.questionId");

        } else if (target instanceof QuestionItem) {
            LinkHelper.link(this.archives, target, "entity.questionId");

        } else if (target instanceof QuestionHandling) {
            LinkHelper.link(this.archives, target, "entity.questionId");

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
            LinkHelper.link(this.archives, targets, "entity.issueId");

        } else if (item0 instanceof QuestionAccessory) {
            LinkHelper.link(this.archives, targets, "entity.questionId");

        } else if (item0 instanceof QuestionItem) {
            LinkHelper.link(this.archives, targets, "entity.questionId");

        } else if (item0 instanceof QuestionHandling) {
            LinkHelper.link(this.archives, targets, "entity.questionId");

        }
    }

    @Override
    public void complete(boolean allowDelete) {
        logger.info(this + "#complete");
        Map<String, Object> map = new HashMap<>();

        if (ids != null && ids.size() != 0)
            map.put("ids", ids);
        else if (codes != null && codes.size() != 0)
            map.put("codes", codes);
        else if (issues != null && issues.size() != 0)
            map.put("issues", issues);
        // 设置允许DEL_FLG=true
        if (allowDelete)
            map.put("delFlg", true);
        else
            map.put("delFlg", false);

        // 查询数据库
        QuestionDao dao = getDao(QuestionDao.class);
        List<QuestionEntity> entities = dao.findAll(map);
        if (entities == null || entities.isEmpty())
            return;

        for (QuestionEntity entity : entities) {
            Question archive = Question.build(getBlackboard()).forCreate(entity);
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
        QuestionDao dao = getDao(QuestionDao.class);

        // 生成编码
        for (Question archive : archives) {
            archive.generateCode();
        }

        // 一意制约检测
        String[] codes = new String[entities.size()];
        for (int i = 0; i < entities.size(); i++) {
            codes[i] = entities.get(i).getQuestionCode();
        }


        QuestionList unique = new QuestionList(codes);
        unique.setBlackboard(getBlackboard());
        unique.complete(false);
        if (unique.isDataSynced())
            throw new BusinessException(ModuleCode.ISSU, ErrorCode.E000004);

        // 获取ID
        Long id = getBlackboard().maxId(TABLE_NAME, entities.size());
        // 设置ID
        for (int i = 0; i < entities.size(); i++) {
            QuestionEntity entity = entities.get(i);
            entity.setQuestionId(id);
            id += 1;
        }

        // 设置共通字段
        for (int i = 0; i < entities.size(); i++) {
            QuestionEntity entity = entities.get(i);
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
        QuestionDao dao = getDao(QuestionDao.class);

        // 设置共通字段
        for (int i = 0; i < entities.size(); i++) {
            QuestionEntity entity = entities.get(i);
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
        QuestionDao dao = getDao(QuestionDao.class);

        // 设置共通字段
        for (int i = 0; i < entities.size(); i++) {
            QuestionEntity entity = entities.get(i);
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
            for (Question archive : archives)
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
         */
        public QuestionList forComplete(Long[] ids) {
            logger.info(this + "#forComplete");
            QuestionList build = new QuestionList(ids);
            build.setBlackboard(blackboard);
            return build;
        }

        /**
         * 创建对象列表，用于根据code查询数据，此对象列表必须使用complete方法补全
         */
        public QuestionList forComplete(String[] codes) {
            logger.info(this + "#forComplete");
            QuestionList build = new QuestionList(codes);
            build.setBlackboard(blackboard);
            return build;
        }

        /**
         * 创建对象列表，用于插入数据库，此对象列表必须使用create方法插入数据库
         */
        public QuestionList forCreate(Question[] archives) {
            logger.info(this + "#forCreate");
            QuestionList build = new QuestionList(archives);
            build.setBlackboard(blackboard);

            return build;
        }

        /**
         * 创建对象列表，用于修改/删除数据，此对象列表必须使用modify/delete方法
         */
        public QuestionList forUpdate(Question[] archives) {
            logger.info(this + "#forUpdate");
            QuestionList build = new QuestionList(archives);
            build.setBlackboard(blackboard);
            build.setDataSynced(true);

            return build;
        }

        /**
         * 创建对象，用于根据entity.issueId查询数据，此对象必须使用complete方法补全
         */
        public QuestionList forComplete(Issue linkedArchive) {
            logger.info(this + "#forComplete");
            QuestionList build = new QuestionList(linkedArchive);
            build.setBlackboard(blackboard);
            return build;
        }

    }


}