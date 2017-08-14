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
import com.bms.issue.bean.Blackboard;
import com.bms.issue.bean.entity.IssueEntity;
import com.bms.issue.constant.i18n.ErrorCode;
import com.bms.issue.constant.i18n.ModuleCode;
import com.bms.issue.dao.IssueDao;
import com.bms.issue.util.LinkHelper;
import com.framework.exception.BusinessException;

/**
 * 记录问题订单总表信息列表辅助类
 *
 * @author li_huiqian
 */
public class IssueList extends AbstractArchive implements Completable, Createable, Linkable, Modifiable, Deletable {

    private static Logger logger = LoggerFactory.getLogger(IssueList.class);

    private static final String TABLE_NAME = "ISSU_ISSUE";

    /**
     * 问题订单总表Entity
     */
    private List<IssueEntity> entities;


    /**
     * 记录问题订单总表信息列表辅助类
     */
    private List<Issue> archives;

    public List<Issue> getArchives() {
        logger.info(this + "#getArchives");
        return archives;
    }


    private List<Long> ids;

    private List<String> codes;


    /**
     * 构造函数
     */
    
    public IssueList(Long[] ids) {
        logger.info(this + "#IssueList");
        Assert.notEmpty(ids);
        this.ids = new ArrayList<>();
        for (Long id : ids)
            this.ids.add(id);
    }

    /**
     * 构造函数
     */
    
    public IssueList(String[] codes) {
        logger.info(this + "#IssueList");
        Assert.notEmpty(codes);
        this.codes = new ArrayList<>();
        for (String code : codes)
            this.codes.add(code);
    }

    /**
     * 构造函数
     */
    
    public IssueList(List<IssueEntity> entities) {
        logger.info(this + "#IssueList");
        Assert.notEmpty(entities);
        this.entities = entities;
        setDataSynced(false);
    }

    /**
     * 构造函数
     */
    
    public IssueList(Issue[] archives) {
        logger.info(this + "#IssueList");
        Assert.notEmpty(archives);
        for (Issue archive : archives) {
            Assert.notNull(archive.getEntity());
        }

        this.archives = new ArrayList<>();
        this.entities = new ArrayList<>();
        for (Issue archive : archives) {
            this.archives.add(archive);
            this.entities.add(archive.getEntity());
        }

        setDataSynced(false);
    }


    @Override
    public void link(Linkable target) {
        logger.info(this + "#link");
        if (target == null)
            return;

        if (target instanceof Question) {
            LinkHelper.link(this.archives, target, "entity.issueId");

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
            LinkHelper.link(this.archives, targets, "entity.issueId");

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
        // 设置允许DEL_FLG=true
        if (allowDelete)
            map.put("delFlg", true);
        else
            map.put("delFlg", false);

        // 查询数据库
        IssueDao dao = getDao(IssueDao.class);
        List<IssueEntity> entities = dao.findAll(map);
        if (entities == null || entities.isEmpty())
            return;

        for (IssueEntity entity : entities) {
            Issue archive = Issue.build(getBlackboard()).forCreate(entity);
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
        IssueDao dao = getDao(IssueDao.class);

        // 生成编码
        for (Issue archive : archives)
            archive.generateCode();

        // 一意制约检测
        String[] codes = new String[entities.size()];
        for (int i = 0; i < entities.size(); i++) {
            codes[i] = entities.get(i).getIssueCode();
        }


        IssueList unique = new IssueList(codes);
        unique.setBlackboard(getBlackboard());
        unique.complete(false);
        if (unique.isDataSynced())
            throw new BusinessException(ModuleCode.ISSU, ErrorCode.E000004);

        // 获取ID
        Long id = getBlackboard().maxId(TABLE_NAME, entities.size());
        // 设置ID
        for (int i = 0; i < entities.size(); i++) {
            IssueEntity entity = entities.get(i);
            entity.setIssueId(id);
            id += 1;
        }

        // 设置共通字段
        for (int i = 0; i < entities.size(); i++) {
            IssueEntity entity = entities.get(i);
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
        IssueDao dao = getDao(IssueDao.class);

        // 设置共通字段
        for (int i = 0; i < entities.size(); i++) {
            IssueEntity entity = entities.get(i);
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
        IssueDao dao = getDao(IssueDao.class);

        // 设置共通字段
        for (int i = 0; i < entities.size(); i++) {
            IssueEntity entity = entities.get(i);
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
            for (Issue archive : archives)
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
        public IssueList forComplete(Long[] ids) {
            logger.info(this + "#forComplete");
            IssueList build = new IssueList(ids);
            build.setBlackboard(blackboard);
            return build;
        }

        /**
         * 创建对象列表，用于根据code查询数据，此对象列表必须使用complete方法补全
         */
        public IssueList forComplete(String[] codes) {
            logger.info(this + "#forComplete");
            IssueList build = new IssueList(codes);
            build.setBlackboard(blackboard);
            return build;
        }

        /**
         * 创建对象列表，用于插入数据库，此对象列表必须使用create方法插入数据库
         */
        public IssueList forCreate(Issue[] archives) {
            logger.info(this + "#forCreate");
            IssueList build = new IssueList(archives);
            build.setBlackboard(blackboard);

            return build;
        }

        /**
         * 创建对象列表，用于修改/删除数据，此对象列表必须使用modify/delete方法
         */
        public IssueList forUpdate(Issue[] archives) {
            logger.info(this + "#forUpdate");
            IssueList build = new IssueList(archives);
            build.setBlackboard(blackboard);
            build.setDataSynced(true);

            return build;
        }

    }


}