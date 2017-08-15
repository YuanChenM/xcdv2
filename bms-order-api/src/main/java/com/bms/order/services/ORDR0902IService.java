package com.bms.order.services;
import org.springframework.transaction.annotation.Transactional;
import com.bms.order.archive.impl.Operator;
import com.bms.order.bean.param.ORDR0902IBean;
/**
*买手退货单确认接口Service
*@author li_huiqian
*/
public interface ORDR0902IService {
/**
*接收买手退回确认信息，更改退货状态
*@param operator 操作者
*@param bean ORDR0902IBean
*/
@Transactional
public void execute(Operator operator, ORDR0902IBean bean);
}
