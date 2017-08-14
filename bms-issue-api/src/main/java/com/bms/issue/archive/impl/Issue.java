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
import com.bms.issue.archive.impl.list.QuestionList;
import com.bms.issue.bean.Blackboard;
import com.bms.issue.bean.entity.IssueEntity;
import com.bms.issue.constant.i18n.ErrorCode;
import com.bms.issue.constant.i18n.ModuleCode;
import com.bms.issue.dao.IssueDao;
import com.bms.issue.util.CodeRule;
import com.bms.issue.util.LinkHelper;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.StringUtils;
import com.framework.exception.BusinessException;
import com.framework.number.generate.NumberGenerateManager;
import com.framework.number.generate.enums.ResetType;

/**
 * 记录问题订单总表信息
 *
 * @author li_huiqian
 */
public class Issue extends AbstractArchive
        implements Completable, Createable, Linkable, Modifiable, Deletable, Codeable {

    private static Logger logger = LoggerFactory.getLogger(Issue.class);

    private static final String TABLE_NAME = "ISSU_ISSUE";

    /**
     * 问题订单总表Entity
     */
    private IssueEntity entity;

    public IssueEntity getEntity() {
        logger.info(this + "#getEntity");
        return entity;
    }


    /**
     * 问题订单问题信息表
     */
    private List<Question> questions;

    private boolean isQuestionsComplete = false;

    /**
     * 关联完毕后调用
     */
    public void questionsLinked() {
        logger.info(this + "#questionsLinked");
        isQuestionsComplete = true;
    }

    /**
     * 重新取数据时用
     */
    public void questionsUnlink() {
        logger.info(this + "#questionsUnlink");
        isQuestionsComplete = false;
    }

    public List<Question> getQuestions() {
        logger.info(this + "#getQuestions");
        if (!isDataSynced())
            return questions;

        if (questions == null || !isQuestionsComplete) {
            QuestionList list = new QuestionList(this);
            list.setBlackboard(getBlackboard());
            list.complete(false);
            isQuestionsComplete = true;
            questions = null;
            if (list.isDataSynced()) {
                link(list.getArchives());
                for (Question item : questions)
                    item.issueLinked();
            }
        }

        return questions;
    }

    /**
     * 构造函数，已过时，请使用Issue.build(blackboard).forComplete(id)
     */
    
    public Issue(Long id) {
        logger.info(this + "#Issue");
        Assert.notNull(id);
        entity = new IssueEntity();
        entity.setIssueId(id);
    }

    /**
     * 构造函数，已过时，请使用Issue.build(blackboard).forComplete(code)
     */
    
    public Issue(String code) {
        logger.info(this + "#Issue");
        Assert.notNull(code);
        entity = new IssueEntity();
        entity.setIssueCode(code);
    }

    /**
     * 构造函数，已过时，请使用Issue.build(blackboard).forCreate(entity,)
     */
    
    public Issue(IssueEntity entity) {
        logger.info(this + "#Issue");
        Assert.notNull(entity);
        this.entity = entity;
        setDataSynced(false);
    }


    @Override
    public void link(Linkable target) {
        logger.info(this + "#link");
        if (target == null)
            return;

        if (target instanceof Question) {
            LinkHelper.link(this, target, "entity.issueId");

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
            LinkHelper.link(this, targets, "entity.issueId");

        }
    }

    @Override
    public void complete(boolean allowDelete) {
        logger.info(this + "#complete");
        // 判断是否是最新
        if (isDataSynced()) {
            return;
        }

        if (entity.getIssueId() != null) {
            IssueEntity entity = new IssueEntity();
            entity.setIssueId(this.entity.getIssueId());
            this.entity = entity;
        } else if (entity.getIssueCode() != null) {
            IssueEntity entity = new IssueEntity();
            entity.setIssueCode(this.entity.getIssueCode());
            this.entity = entity;
        }

        // 设置允许DEL_FLG=true
        if (allowDelete)
            this.entity.setDelFlg(true);
        else
            this.entity.setDelFlg(false);

        // 查询数据库
        IssueDao dao = getDao(IssueDao.class);
        IssueEntity entity = dao.findOne(this.entity);
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
        IssueDao dao = getDao(IssueDao.class);
        entity.setIssueCode(this.createIssueCode(entity.getBuyerCode()));

        // 生成编码
        generateCode();

        // 一意制约检测
        Issue unique = new Issue(entity.getIssueCode());
        unique.setBlackboard(getBlackboard());
        unique.complete(false);
        if (unique.isDataSynced())
            throw new BusinessException(ModuleCode.ISSU, ErrorCode.E000004);
        // 获取ID
        Long id = getBlackboard().maxId(TABLE_NAME);
        // 设置ID
        this.entity.setIssueId(id);

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
        IssueDao dao = getDao(IssueDao.class);

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
        IssueDao dao = getDao(IssueDao.class);

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
            return this.getClass().getName() + this.entity.getIssueId();
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
        public Issue forComplete(Long id) {
            logger.info(this + "#forComplete");
            Issue build = new Issue(id);
            build.setBlackboard(blackboard);
            return build;
        }

        /**
         * 创建对象，用于根据code查询数据，此对象必须使用complete方法补全
         */
        public Issue forComplete(String code) {
            logger.info(this + "#forComplete");
            Issue build = new Issue(code);
            build.setBlackboard(blackboard);
            return build;
        }

        /**
         * 创建对象，用于插入数据库，此对象必须使用create方法插入数据库
         */
        public Issue forCreate(IssueEntity entity) {
            logger.info(this + "#forCreate");
            Issue build = new Issue(entity);
            build.setBlackboard(blackboard);
            return build;
        }

    }

    /**
     * 生成问题编码
     * @param buyerCode
     * @return
     */
    public String createIssueCode(String buyerCode){
        StringBuffer param = new StringBuffer("ISSUE");
        if (StringUtils.isNotEmpty(buyerCode)){
            param.append("-");
            param.append(buyerCode);
        }
        String date = DateUtils.fmtToday();
        param.append("-");
        param.append(date);
        String issueCode = NumberGenerateManager.sequences(param.toString(), ResetType.Day, 4);
        return issueCode;
    }

    @Override
    public void generateCode() {
        entity.setIssueCode(CodeRule.commonRule("WTDD"));
    }

}