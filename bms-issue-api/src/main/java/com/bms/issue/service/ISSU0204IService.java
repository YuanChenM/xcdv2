package com.bms.issue.service;
import org.springframework.transaction.annotation.Transactional;
import com.bms.issue.archive.impl.Operator;
import com.bms.issue.bean.param.ISSU0204IBean;
/**
*问题附件保存接口Service
*@author li_huiqian
*/
public interface ISSU0204IService {
/**
*接收问题的附件信息，保存问题附件
*@param operator 操作者
*@param bean ISSU0204IBean
*/
@Transactional
public void execute(Operator operator, ISSU0204IBean bean);
}
