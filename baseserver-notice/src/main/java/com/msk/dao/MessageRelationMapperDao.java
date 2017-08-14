package com.msk.dao;

import com.msk.bean.CreateNoticeBean;
import com.msk.bean.DeleteMessRelBean;
import com.msk.bean.UpdateMessRelBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * Created by mao_yejun on 2016/10/12.
 */
@Mapper
public interface MessageRelationMapperDao {
    int createMessageRelation(List<CreateNoticeBean> createNoticeBeanList);
    int updateMessageRelationById(UpdateMessRelBean updateMessRelBean);
    int updateMessageRelationByEmploy(UpdateMessRelBean updateMessRelBean);
    int deleteMessageRelationById(DeleteMessRelBean deleteMessRelBean);
    int deleteMessageRelationByEmploy(DeleteMessRelBean deleteMessRelBean);
}
