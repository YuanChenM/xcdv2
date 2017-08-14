package com.bms.issue.service;
import com.bms.issue.archive.impl.QuestionItem;
import org.springframework.transaction.annotation.Transactional;
import com.bms.issue.archive.impl.Operator;
import com.bms.issue.bean.param.ISSU0206IBean;
/**
*问题点新增接口Service
*@author li_huiqian
*/
public interface ISSU0206IService {
/**
*接收问题点信息，新增问题点
*@param operator 操作者
*@param bean ISSU0206IBean
*/
@Transactional
public QuestionItem execute(Operator operator, ISSU0206IBean bean);
}
