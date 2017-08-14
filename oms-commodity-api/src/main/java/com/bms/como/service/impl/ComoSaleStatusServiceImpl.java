/*
 * 2017/03/27 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.como.service.impl;

import com.bms.como.bean.entity.ComoSaleStatus;
import com.bms.como.bean.param.BaseBean;
import com.bms.como.bean.param.SaleStatusRsParam;
import com.bms.como.constant.TableConstant;
import com.bms.como.dao.ComoSaleStatusDao;
import com.bms.como.service.ComoSaleStatusService;
import com.framework.base.consts.NumberConst;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>ComoSaleStatusService接口实现类。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
@Service
public class ComoSaleStatusServiceImpl extends BaseServiceImpl implements ComoSaleStatusService {

    @Autowired
    private ComoSaleStatusDao comoSaleStatusDao;

    @Override
    public BaseDao getBaseDao() {
        return comoSaleStatusDao;
    }

    @Override
    public int checkCode(SaleStatusRsParam saleStatusRsParam) {
        return comoSaleStatusDao.checkCode(saleStatusRsParam);
    }

    @Override
    public int checkName(SaleStatusRsParam saleStatusRsParam) {
        return comoSaleStatusDao.checkName(saleStatusRsParam);
    }

    @Override
    public SaleStatusRsParam saveSaleStatus(SaleStatusRsParam saleStatusRsParam) {
        ComoSaleStatus saleStatus = BeanUtils.toBean(saleStatusRsParam, ComoSaleStatus.class);
        Date currentDate = DateUtils.getCurrent();
        String longUserId = this.getLoginUserId();
        Long saleStatusId = this.maxId(TableConstant.Name.COMO_SALE_STATUS);
        saleStatusRsParam.setSaleStatusId(saleStatusId);
        int isDefault = this.comoSaleStatusDao.findDefault();
        if (isDefault > NumberConst.IntDef.INT_ZERO) {
            //判断是否存在默认销售状态
            saleStatus.setIsDefault(saleStatusRsParam.getIsDefault());
        } else {
            //设为默认
            saleStatus.setIsDefault(true);
        }
        saleStatus.setIsValid(saleStatusRsParam.getIsValid());
        saleStatus.setSaleStatusId(saleStatusId);
        saleStatus.setCrtId(longUserId);
        saleStatus.setCrtTime(currentDate);
        saleStatus.setUpdId(longUserId);
        saleStatus.setUpdTime(currentDate);
        saleStatus.setDelFlg(false);
        saleStatus.setVersion(NumberConst.IntDef.INT_ONE);
        int result = this.save(saleStatus);
        saleStatusRsParam.setResult(result);
        if (saleStatus.getIsDefault()) {
            //新增数据为默认的话把原默认标签取消
            saleStatus.setIsDefault(false);
            this.comoSaleStatusDao.modifyDefault(saleStatus);
        }
        return saleStatusRsParam;
    }

    @Override
    public int modifySaleStatus(BaseBean<SaleStatusRsParam, SaleStatusRsParam> saleStatusRsParam) {
        BaseBean<ComoSaleStatus, ComoSaleStatus> baseBean = new BaseBean<>();
        Date currentDate = DateUtils.getCurrent();
        String longUserId = this.getLoginUserId();
        ComoSaleStatus saleStatusFilter = BeanUtils.toBean(saleStatusRsParam.getFilter(), ComoSaleStatus.class);
        ComoSaleStatus saleStatusTarget = BeanUtils.toBean(saleStatusRsParam.getTarget(), ComoSaleStatus.class);
        saleStatusTarget.setIsDefault(saleStatusRsParam.getTarget().getIsDefault());
        saleStatusTarget.setIsValid(saleStatusRsParam.getTarget().getIsValid());
        saleStatusTarget.setUpdId(longUserId);
        saleStatusTarget.setUpdTime(currentDate);
        baseBean.setFilter(saleStatusFilter);
        baseBean.setTarget(saleStatusTarget);
        int result = this.modify(baseBean);
        if (saleStatusTarget.getIsDefault()) {
            //修改数据为默认的话把原默认标签取消
            saleStatusTarget.setIsDefault(false);
            this.comoSaleStatusDao.modifyDefault(saleStatusTarget);
        }
        return result;
    }
}