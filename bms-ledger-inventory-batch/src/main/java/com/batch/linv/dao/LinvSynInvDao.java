/*
 * 2017/02/08 自动生成 新規作成
 * (c) 江苏润和.
 */
package com.batch.linv.dao;

import com.batch.linv.bean.entity.*;
import com.framework.boot.base.BaseDao;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * LinvSkuInfoDao接口。
 * </p>
 *
 * @author 自动生成
 * @version 1.00
 */
public interface LinvSynInvDao extends BaseDao {

    @Transactional
    void saveSkuInfo(LinvSkuInfo param);

    @Transactional
    void saveNameInfo(LinvNameInfo param);

    @Transactional
    void saveCommInfo(LinvCommInfo param);

    //1、同步生产商批次库存
    void synLotFromLoadByTran();
    //2、同步生产商供应商库存
    void synSpFromLoadByTran();
    //3、同步规格库存
    void synSpecFromLoadByTran();
    //4、同步平台商品库存
    void synPlatFromLoadByTran();

    List<InvmLoad> findAllSkuCode(InvmPage param);

    int countSku();

    void setLoadSyncDelFlag();

    void cleanLoadLogData();
    void setLoadLogDelFlag();

    void cleanCommoLogData();
    void setCommoLogDelFlag();

    void backUpData();

    void backUpCommoData();

    void saveLoadSync(LINV0117IResultParam param);

}