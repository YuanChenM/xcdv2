/*
 * 2017/03/01 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.agif.dao;

import com.bms.agif.bean.param.PartnerRsParam;
import com.framework.boot.base.BaseDao;

import java.io.Serializable;
import java.util.List;

/**
 * <p>AgifPartnerDao接口。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public interface AgifPartnerDao extends BaseDao {
    <T> List<T> findAgentPageList(Serializable var1);

    String findAgentCode();

    String findButlerCode();

    String findPartnerCode();

    PartnerRsParam selectPartnerTel(PartnerRsParam partnerRsParam);
}