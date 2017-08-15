package com.bms.order.services;

import com.bms.order.archive.impl.Operator;
import com.bms.order.bean.param.ORDR0905IBean;
import org.springframework.transaction.annotation.Transactional;

/**
*买手退货单确认接口Service
*@author li_huiqian
*/
public interface ORDR0905IService {
/**
*接收买手退回确认取消信息，更改退货状态
*@param operator 操作者
*@param bean ORDR0905IBean
*/
@Transactional
public void execute(Operator operator, ORDR0905IBean bean);
}
