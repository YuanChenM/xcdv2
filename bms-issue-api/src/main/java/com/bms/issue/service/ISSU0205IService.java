package com.bms.issue.service;
import org.springframework.transaction.annotation.Transactional;
import com.bms.issue.archive.impl.Operator;
import com.bms.issue.bean.param.ISSU0205IBean;
/**
*问题附件删除接口Service
*@author li_huiqian
*/
public interface ISSU0205IService {
/**
*接收问题的附件信息，删除附件信息，即更新删除标志
*@param operator 操作者
*@param bean ISSU0205IBean
*/
@Transactional
public void execute(Operator operator, ISSU0205IBean bean);
}
