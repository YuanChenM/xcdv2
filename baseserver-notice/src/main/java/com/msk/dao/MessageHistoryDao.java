package com.msk.dao;

import com.msk.bean.DeleteMessRelBean;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by mao_yejun on 2016/10/13.
 */
@Mapper
public interface MessageHistoryDao {
    int createMessageHistory(DeleteMessRelBean deleteMessRelBean);
}
