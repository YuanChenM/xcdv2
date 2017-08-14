package com.bms.issue.service;
import org.springframework.transaction.annotation.Transactional;
import com.bms.issue.archive.impl.Operator;
import com.bms.issue.bean.param.ISSU0207IBean;
/**
*问题点编辑接口Service
*@author li_huiqian
*/
public interface ISSU0207IService {
/**
*接收问题点信息，编辑问题点，可适用于问题点的方案执行、问题点的结案等
*@param operator 操作者
*@param bean ISSU0207IBean
*/
@Transactional
public void execute(Operator operator, ISSU0207IBean bean);
}
