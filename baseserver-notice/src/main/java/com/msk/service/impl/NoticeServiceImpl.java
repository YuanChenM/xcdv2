package com.msk.service.impl;

import com.framework.base.bean.Sort;
import com.framework.base.consts.NumberConst;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.core.db.DbUtils;
import com.framework.core.utils.ArrayUtils;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.StringUtils;
import com.framework.core.utils.UUIDUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.msk.bean.CreateNoticeBean;
import com.msk.bean.DeleteMessRelBean;
import com.msk.bean.UpdateMessRelBean;
import com.msk.bean.param.*;
import com.msk.bean.result.NoticeResult;
import com.msk.bean.result.SenderNoticeResult;
import com.msk.common.CommonDef;
import com.msk.dao.MessageContextMapperDao;
import com.msk.dao.MessageHistoryDao;
import com.msk.dao.MessageRelationMapperDao;
import com.msk.dao.NoticeMapperDao;
import com.msk.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by mao_yejun on 2016/10/12.
 */
@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private MessageRelationMapperDao messageRelationMapperDao;
    @Autowired
    private MessageContextMapperDao messageContextMapperDao;
    @Autowired
    private NoticeMapperDao noticeMapperDao;
    @Autowired
    private MessageHistoryDao messageHistoryDao;

    @Override
    @Transactional
    public Boolean createNoticeByEmploy(CreateNoticeParam createNoticeByEmployParam) {
        //创建信息
        String contextId = UUIDUtils.genPrimaryKey();
        String crtId = createNoticeByEmployParam.getSenderCode();
        Date date = DateUtils.getCurrent();
        String type = createNoticeByEmployParam.getType();
        CreateNoticeBean createNoticeBean = new CreateNoticeBean();
        createNoticeBean.setCrtId(crtId);
        createNoticeBean.setCrtTime(date);
        createNoticeBean.setMessageId(contextId);
        createNoticeBean.setMessageContext(createNoticeByEmployParam.getMessageContext());
        createNoticeBean.setTitle(createNoticeByEmployParam.getTitle());
        int ctxRs = messageContextMapperDao.createMessageContext(createNoticeBean);
        if (ctxRs == 0) {
            return false;
        }
        //创建关联
        List<String> receiverCodes = createNoticeByEmployParam.getReceiverCodes();
        List<CreateNoticeBean> list = new ArrayList<CreateNoticeBean>();
        for (String code : receiverCodes) {
            CreateNoticeBean bean = new CreateNoticeBean();
            bean.setId(UUIDUtils.genPrimaryKey());
            bean.setCrtId(crtId);
            bean.setCrtTime(date);
            bean.setSendDateTime(date);
            bean.setMessageId(contextId);
            bean.setType(type);
            bean.setStatus(CommonDef.NoticeStatusDef.CREATE);
            bean.setSenderCode(crtId);
            bean.setReceiverCode(code);
            list.add(bean);
        }
        int mrRs = messageRelationMapperDao.createMessageRelation(list);
        if (mrRs == 0) {
            throw new RuntimeException();
        }
        return true;
    }

    @Override
    public BaseRestPaginationResult<NoticeResult> queryNoticeList(QueryNoticeListParam queryNoticeListParam) {
        BaseRestPaginationResult<NoticeResult> pageResult = new BaseRestPaginationResult<>();
        Page<NoticeResult> page;
        if (queryNoticeListParam == null || queryNoticeListParam.getPagination() == null) {
            page = PageHelper.startPage(NumberConst.IntDef.INT_ZERO, NumberConst.IntDef.INT_ZERO, true, false, true);
        } else {
            page = PageHelper.startPage(queryNoticeListParam.getPagination().getStartPos(), queryNoticeListParam.getPagination().getPageSize(), true, false, true);
        }
        // 排序处理
        if (ArrayUtils.isNotEmpty(queryNoticeListParam.getSort())) {
            StringBuffer sql = new StringBuffer();
            for (Sort sort : queryNoticeListParam.getSort()) {
                String sortField = sort.getSortField();
                if (StringUtils.isEmpty(sortField)) {
                    continue;
                }
                sql.append("," + sortField);
                if (sort.getDescFlag()) {
                    sql.append(" desc");
                } else {
                    sql.append(" asc");
                }
            }
            PageHelper.orderBy(sql.toString().replaceFirst(",", ""));
        } else {
            // 默认排序
            PageHelper.orderBy("sendDateTime DESC,status DESC");
        }

        if (StringUtils.isNotEmpty(queryNoticeListParam.getTitle())) {
            String title = DbUtils.buildLikeCondition(queryNoticeListParam.getTitle(), DbUtils.LikeMode.PARTIAL);
            queryNoticeListParam.setTitle(title);
        }
        List<NoticeResult> data = noticeMapperDao.queryNoticeList(queryNoticeListParam);
        pageResult.setTotal(page.getTotal());
        if (page.getTotal() != NumberConst.IntDef.INT_ZERO) {
            pageResult.setData(data);
        } else {
            pageResult.setData(new ArrayList<NoticeResult>());
        }
        return pageResult;

    }

    @Override
    public NoticeResult queryNoticeDetail(QueryNoticeDetailParam queryNoticeDetailParamParam) {
        if (StringUtils.isNotEmpty(queryNoticeDetailParamParam.getTitle())) {
            String title = DbUtils.buildLikeCondition(queryNoticeDetailParamParam.getTitle(), DbUtils.LikeMode.PARTIAL);
            queryNoticeDetailParamParam.setTitle(title);
        }
        return noticeMapperDao.queryNoticeDetail(queryNoticeDetailParamParam);
    }

    @Override
    @Transactional
    public Boolean updateMessageRelationById(UpdateNoticeParam updateNoticeParam) {
        UpdateMessRelBean updateMessRelBean = new UpdateMessRelBean();
        updateMessRelBean.setStatus(updateNoticeParam.getStatus());
        updateMessRelBean.setUpdId(updateNoticeParam.getUpdId());
        updateMessRelBean.setUpdTime(new Date());
        updateMessRelBean.setLookUpTime(new Date());
        updateMessRelBean.setMessageRelationId(updateNoticeParam.getIds());
        updateMessRelBean.setMessageIds(updateNoticeParam.getMessageIds());
        int rs = messageRelationMapperDao.updateMessageRelationById(updateMessRelBean);
        if (rs == 0) {
            return false;
        }
        return true;
    }

    @Override
    @Transactional
    public Boolean updateMessageRelationByEmploy(UpdateNoticeByEmployParam updateNoticeByEmployParam) {
        UpdateMessRelBean updateMessRelBean = new UpdateMessRelBean();
        updateMessRelBean.setStatus(updateNoticeByEmployParam.getStatus());
        updateMessRelBean.setUpdId(updateNoticeByEmployParam.getUpdId());
        updateMessRelBean.setUpdTime(new Date());
        updateMessRelBean.setLookUpTime(new Date());
        updateMessRelBean.setReceiverCode(updateNoticeByEmployParam.getUserCode());
        int rs = messageRelationMapperDao.updateMessageRelationByEmploy(updateMessRelBean);
        if (rs == 0) {
            return false;
        }
        return true;
    }

    @Override
    @Transactional
    public Boolean deleteNoticeById(DeleteNoticeParam deleteNoticeParam) {
        DeleteMessRelBean deleteMessRelBean = new DeleteMessRelBean();
        deleteMessRelBean.setIds(deleteNoticeParam.getIds());
        //备份数据
        int crs = messageHistoryDao.createMessageHistory(deleteMessRelBean);
        if (crs == 0) {
            return false;
        }
        //删除数据
        int drs = messageRelationMapperDao.deleteMessageRelationById(deleteMessRelBean);
        if (drs == 0) {
            throw new RuntimeException();
        }
        return true;
    }

    @Override
    public Boolean deleteNoticeByEmploy(DeleteNoticeByEmployParam deleteNoticeByEmployParam) {
        DeleteMessRelBean deleteMessRelBean = new DeleteMessRelBean();
        deleteMessRelBean.setUserCode(deleteNoticeByEmployParam.getUserCode());
        //备份数据
        int crs = messageHistoryDao.createMessageHistory(deleteMessRelBean);
        if (crs == 0) {
            return false;
        }
        //删除数据
        int drs = messageRelationMapperDao.deleteMessageRelationByEmploy(deleteMessRelBean);
        if (drs == 0) {
            throw new RuntimeException();
        }
        return true;
    }

    @Override
    public BaseRestPaginationResult<SenderNoticeResult> querySenderNoticeList(QueryNoticeSenderParam param) {
        BaseRestPaginationResult<SenderNoticeResult> pageResult = new BaseRestPaginationResult<>();
        Page<NoticeResult> page;
        if (param == null || param.getPagination() == null) {
            page = PageHelper.startPage(NumberConst.IntDef.INT_ZERO, NumberConst.IntDef.INT_ZERO, true, false, true);
        } else {
            page = PageHelper.startPage(param.getPagination().getStartPos(), param.getPagination().getPageSize(), true, false, true);
        }
        if (StringUtils.isNotEmpty(param.getTitle())) {
            String title = DbUtils.buildLikeCondition(param.getTitle(), DbUtils.LikeMode.PARTIAL);
            param.setTitle(title);
        }
        if (StringUtils.isNotEmpty(param.getMessageContext())) {
            String messageContext = DbUtils.buildLikeCondition(param.getMessageContext(), DbUtils.LikeMode.PARTIAL);
            param.setMessageContext(messageContext);
        }
        List<SenderNoticeResult> data =  messageContextMapperDao.querySenderNoticeList(param);
        pageResult.setTotal(page.getTotal());
        if (page.getTotal() != NumberConst.IntDef.INT_ZERO) {
            pageResult.setData(data);
        } else {
            pageResult.setData(new ArrayList<SenderNoticeResult>());
        }
        return  pageResult;
    }

}
