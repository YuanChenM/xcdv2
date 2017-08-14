package com.bms.issue.service;
import org.springframework.transaction.annotation.Transactional;
import com.bms.issue.archive.impl.Operator;
import com.bms.issue.bean.param.ISSU0202IBean;
/**
*问题订单问题结案接口Service
*@author li_huiqian
*/
public interface ISSU0202IService {
/**
*接收问题结案信息，问题结案
*@param operator 操作者
*@param bean ISSU0202IBean
*/
@Transactional
public void execute(Operator operator, ISSU0202IBean bean);
}
