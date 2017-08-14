package com.bms.issue.service;
import org.springframework.transaction.annotation.Transactional;
import com.bms.issue.archive.impl.Operator;
import com.bms.issue.bean.param.ISSU0203IBean;
/**
*问题订单问题修改接口Service
*@author li_huiqian
*/
public interface ISSU0203IService {
/**
*接收问题信息，修改问题
*@param operator 操作者
*@param bean ISSU0203IBean
*/
@Transactional
public void execute(Operator operator, ISSU0203IBean bean);
}
