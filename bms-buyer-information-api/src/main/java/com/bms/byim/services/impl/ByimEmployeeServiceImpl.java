/*
 * 2016/12/29 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.byim.services.impl;

import com.bms.byim.bean.entity.ByimEmployee;
import com.bms.byim.bean.param.BaseBean;
import com.bms.byim.bean.param.EmployeeRsParam;
import com.bms.byim.bean.result.EmployeeRsResult;
import com.bms.byim.dao.ByimEmployeeDao;
import com.bms.byim.services.ByimEmployeeService;
import com.bms.byim.utils.RestCommUtil;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>ByimEmployeeService接口实现类。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
@Service
public class ByimEmployeeServiceImpl extends BaseServiceImpl implements ByimEmployeeService {

    @Autowired
    private ByimEmployeeDao byimEmployeeDao;

    @Override
    public BaseDao getBaseDao() {
        return byimEmployeeDao;
    }

    @Override
    public EmployeeRsResult executeBatchSave(List<ByimEmployee> paramList) {
        String loginUserId = getLoginUserId();
        List<ByimEmployee> list = new ArrayList<>();
        EmployeeRsResult rsResult = new EmployeeRsResult();
        EmployeeRsParam employeeRsParam = null;
        List<EmployeeRsParam> employeeRsParams = new ArrayList<>();
        for (int i = 0, sizes = paramList.size(); i < sizes; i++) {
            ByimEmployee bean = BeanUtils.toBean(paramList.get(i), ByimEmployee.class);
            Date currentDate = DateUtils.getCurrent();
            Long maxId = maxId("BYIM_EMPLOYEE");
            bean.setUpdId(loginUserId);
            bean.setCrtId(loginUserId);
            bean.setUpdTime(currentDate);
            bean.setCrtTime(currentDate);
            bean.setEmployeeId(maxId);
            list.add(bean);
            employeeRsParam = BeanUtils.toBean(bean, EmployeeRsParam.class);
            employeeRsParams.add(employeeRsParam);
        }
        rsResult.setEmployeeList(employeeRsParams);
        List<List<ByimEmployee>> insertList = RestCommUtil.insertRanking(list);

        int insertCount;
        int countAll = NumberUtils.INTEGER_ZERO;
        int splSize = insertList.size();
        for (int j = 0; j < splSize; j++) {
            insertCount = batchSave(insertList.get(j));
            countAll += insertCount;
        }

        ByimEmployee byimEmployee = new ByimEmployee();
        int j = -NumberUtils.INTEGER_ONE;
        for (int i = paramList.size() - 1; i >= 0; i--) {
            if (paramList.get(i).getEmployeeType().equals("1")) {
                byimEmployee.setEmployeeId(list.get(i).getEmployeeId());
                byimEmployee.setBuyerId(list.get(i).getBuyerId());
                j = i;
                break;
            }
        }
        if (j != -NumberUtils.INTEGER_ONE) {
            byimEmployeeDao.modifyFalse(byimEmployee);
            byimEmployeeDao.modifyIsNewestBoss(byimEmployee);
        }
        return rsResult;
    }

    @Override
    public int executeUpdate(BaseBean<EmployeeRsParam, EmployeeRsParam> param) {
        BaseBean<ByimEmployee, ByimEmployee> bean = new BaseBean<>();
        Date currentDate = DateUtils.getCurrent();
        ByimEmployee filter = BeanUtils.toBean(param.getFilter(), ByimEmployee.class);
        ByimEmployee target = BeanUtils.toBean(param.getTarget(), ByimEmployee.class);
        String loginUserId = getLoginUserId();
        target.setUpdId(loginUserId);
        target.setUpdTime(currentDate);
        bean.setFilter(filter);
        bean.setTarget(target);

        if ("1".equals(bean.getTarget().getEmployeeType())) {
            ByimEmployee byimEmployee = new ByimEmployee();
            byimEmployee.setEmployeeId(bean.getFilter().getEmployeeId());
            ByimEmployee beans = byimEmployeeDao.findOne(byimEmployee);
            byimEmployee.setBuyerId(beans.getBuyerId());
            byimEmployeeDao.modifyFalse(byimEmployee);
            bean.getTarget().setIsNewestBoss(true);
        } else {
            bean.getTarget().setIsNewestBoss(false);
        }
        int updateCount;
        updateCount = modify(bean);
        return updateCount;
    }
}