package com.bms.linv.business;

import com.bms.linv.bean.param.*;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 占用业务处理
 * Created by zheng_xu on 2017/4/14.
 */
public interface LinvAllocationBusinessService extends BaseService {

    /**
     * SKU产品占用
     * @param param
     */
    @Transactional
    void allocatedProduct(List<LINV0103IParam> param);

    /**
     * 货权人商品占用
     * @param param
     */
    @Transactional
    void allocatedComm(List<LINV0107IParam> param);

    /**
     * 货权人商品占用修改
     * @param param
     */
    @Transactional
    void modifyCommAloc(List<LINV0109IParam> param);

    /**
     * 货权人商品占用取消
     * @param param
     */
    @Transactional
    void cancelOwComAloc(List<LINV0108IParam> param);

    /**
     * 产品占用取消
     * @param param
     */
    @Transactional
    void cancelProcductAloc(List<LINV0104IParam> param);

}
