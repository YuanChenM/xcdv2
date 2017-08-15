package com.bms.order.services;
import org.springframework.transaction.annotation.Transactional;
import com.bms.order.archive.impl.Operator;
import com.bms.order.bean.param.ORDR0804IBean;
/**
*买家现场退货数据接收接口Service
*@author li_huiqian
*/
public interface ORDR0804IService {
/**
*接收配送PDA系统的现场拒收退货信息，创建退货单，创建完成的退货即为已确认状态，由于是在现场发起的退货，即认为是已经确认的退货
*@param operator 操作者
*@param bean ORDR0804IBean
*/
@Transactional
public Long execute(Operator operator, ORDR0804IBean bean);
}
