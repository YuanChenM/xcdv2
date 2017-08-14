package com.bms.issue.service;
import org.springframework.transaction.annotation.Transactional;
import com.bms.issue.archive.impl.Operator;
import com.bms.issue.bean.param.ISSU0208IBean;
/**
*问题处理/结案建议新增接口Service
*@author li_huiqian
*/
public interface ISSU0208IService {
/**
*问题处理/结案建议新增接口
*@param operator 操作者
*@param bean ISSU0208IBean
*/
@Transactional
public Long  execute(Operator operator, ISSU0208IBean bean);
}
