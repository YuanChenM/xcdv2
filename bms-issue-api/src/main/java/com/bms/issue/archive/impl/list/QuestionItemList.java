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
import com.bms.issue.bean.entity.QuestionItemEntity;
import com.bms.issue.constant.i18n.ErrorCode;
import com.bms.issue.constant.i18n.ModuleCode;
import com.bms.issue.dao.QuestionItemDao;
import com.bms.issue.util.LinkHelper;
import com.framework.exception.BusinessException;

/**
 *
 * 记录问题订单的处理明细信息列表辅助类

 * @author li_huiqian

 */
public class QuestionItemList extends AbstractArchive implements Completable, Createable, Linkable, Modifiable, Deletable {

    private static Logger logger = LoggerFactory.getLogger(QuestionItemList.class);

    private static final String TABLE_NAME = "ISSU_QUESTION_ITEM";

    /** 问题订单问题表明细问题点Entity */
    private List<QuestionItemEntity> entities;


    /** 记录问题订单的处理明细信息列表辅助类 */
    private List<QuestionItem> archives;

    public List<QuestionItem> getArchives() {
        logger.info(this + "#getArchives");
        return archives;
    }

    /** 问题订单问题信息表 */
    private List<Question> questions;


    private List<Long> ids;


    /**
     * 构造函数
     *
     */
    
    public  QuestionItemList(Long[] ids) {
        logger.info(this + "#QuestionItemList");
        Assert.notEmpty(ids);
        this.ids = new ArrayList<>();
        for (Long id : ids)
            this.ids.add(id);
    }

    /**
     * 构造函数
     *
     */
    
    public  QuestionItemList(List<QuestionItemEntity> entities) {
        logger.info(this + "#QuestionItemList");
        Assert.notEmpty(entities);
        this.entities = entities;
        setDataSynced(false);
    }

    /**
     * 构造函数
     *
     */
    
    public  QuestionItemList(QuestionItem[] archives) {
        logger.info(this + "#QuestionItemList");
        Assert.notEmpty(archives);
        for (QuestionItem archive : archives) {
            Assert.notNull(archive.getEntity());
        }

        this.archives = new ArrayList<>();
        this.entities = new ArrayList<>();
        for (QuestionItem archive : archives) {
            this.archives.add(archive);
            this.entities.add(archive.getEntity());
        }

        setDataSynced(false);
    }

    /**
     * 构造函数
     *
     */
    
    public  QuestionItemList(Question linkedArchive) {
        logger.info(this + "#QuestionItemList");
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
    
    public  QuestionItemList(Question[] linkedArchives) {
        logger.info(this + "#QuestionItemList");
        Assert.notEmpty(linkedArchives);
        this.questions = new ArrayList<>();
        for (Question linkedArchive : linkedArchives) {
            Assert.notNull(linkedArchive.getEntity());
            Assert.notNull(linkedArchive.getEntity().getQuestionId());
            this.questions.add(linkedArchive);
        }
    }


    @Override
    public void link(Linkable target) {
        logger.info(this + "#link");
        if (target == null)
            return;

        if (target instanceof Question) {
            LinkHelper.link(this.archives, target, "entity.questionId");
        
        } else if (target instanceof QuestionAccessory) {
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
        
        } else if (item0 instanceof QuestionAccessory) {
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
        // 设置允许DEL_FLG=true
        if (allowDelete)
            map.put("delFlg", true);
        else
            map.put("delFlg", false);

        // 查询数据库
        QuestionItemDao dao = getDao(QuestionItemDao.class);
        List<QuestionItemEntity> entities = dao.findAll(map);
        if (entities == null || entities.isEmpty())
            return;

        for (QuestionItemEntity entity : entities) {
            QuestionItem archive = QuestionItem.build(getBlackboard()).forCreate(entity);
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
        QuestionItemDao dao = getDao(QuestionItemDao.class);

        // 一意制约检测

        // 获取ID
        Long id = getBlackboard().maxId(TABLE_NAME, entities.size());
        // 设置ID
        for (int i = 0; i < entities.size(); i++) {
            QuestionItemEntity entity = entities.get(i);
            entity.setItemId(id);
            id += 1;
        }

        // 设置共通字段
        for (int i = 0; i < entities.size(); i++) {
            QuestionItemEntity entity = entities.get(i);
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
        QuestionItemDao dao = getDao(QuestionItemDao.class);

        // 设置共通字段
        for (int i = 0; i < entities.size(); i++) {
            QuestionItemEntity entity = entities.get(i);
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
        QuestionItemDao dao = getDao(QuestionItemDao.class);

        // 设置共通字段
        for (int i = 0; i < entities.size(); i++) {
            QuestionItemEntity entity = entities.get(i);
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
            for (QuestionItem archive : archives)
                archive.setDataSynced(dataSynced);
        super.setDataSynced(dataSynced);
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
     * 创建对象列表，用于根据id查询数据，此对象列表必须使用complete方法补全
     *
     */
    public QuestionItemList forComplete(Long[] ids) {
        logger.info(this + "#forComplete");
        QuestionItemList build = new QuestionItemList(ids);
        build.setBlackboard(blackboard);
        return build;
    }

    /**
     * 创建对象列表，用于插入数据库，此对象列表必须使用create方法插入数据库
     *
     */
    public QuestionItemList forCreate(QuestionItem[] archives) {
        logger.info(this + "#forCreate");
        QuestionItemList build = new QuestionItemList(archives);
        build.setBlackboard(blackboard);

        return build;
    }

    /**
     * 创建对象列表，用于修改/删除数据，此对象列表必须使用modify/delete方法
     *
     */
    public QuestionItemList forUpdate(QuestionItem[] archives) {
        logger.info(this + "#forUpdate");
        QuestionItemList build = new QuestionItemList(archives);
        build.setBlackboard(blackboard);
        build.setDataSynced(true);

        return build;
    }

    /**
     * 创建对象，用于根据entity.questionId查询数据，此对象必须使用complete方法补全
     *
     */
    public QuestionItemList forComplete(Question linkedArchive) {
        logger.info(this + "#forComplete");
        QuestionItemList build = new QuestionItemList(linkedArchive);
        build.setBlackboard(blackboard);
        return build;
    }

    }


}