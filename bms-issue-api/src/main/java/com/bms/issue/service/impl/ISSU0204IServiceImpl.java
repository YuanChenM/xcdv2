package com.bms.issue.service.impl;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bms.issue.archive.impl.Operator;
import com.bms.issue.bean.Blackboard;
import com.bms.issue.bean.param.ISSU0204IBean;
import com.bms.issue.service.ISSU0204IService;
import com.framework.redis.dao.BaseRedisDao;
/**
*问题附件保存接口Service
*@author li_huiqian
*/
@Service
public class ISSU0204IServiceImpl implements ISSU0204IService {

@Autowired
private BaseRedisDao redisDao;
/**
*接收问题的附件信息，保存问题附件
*@param operator 操作者
*@param bean ISSU0204IBean
*/
@Override
public void execute(Operator operator, ISSU0204IBean bean) {
// 本Service用参数传递容器
HashMap<String, Object> map = new HashMap<>();
Blackboard blackboard = new Blackboard();;
blackboard.setOperator(operator);
map.put("bean", bean);
map.put("blackboard", blackboard);

pre(map);
process(map);
post(map);
}
/**
*准备
*@param map HashMap
*/
private void pre(HashMap<String, Object> map){
// 获取参数
ISSU0204IBean param = (ISSU0204IBean)  map.get("param");
Blackboard blackboard = (Blackboard) map.get("blackboard");
// 设置DAO
// TODO 设置DAO
blackboard.setBaseRedisDao(redisDao);
// blackboard.putBaseDao(buyerOrderDao);

//操作者
Operator operator = blackboard.getOperator();
operator.setBlackboard(blackboard);
// 获取完整操作者
operator.complete(false);

// 返回参数
// map.put("issue", issue);
}
/**
*执行
*@param map HashMap
*/
private void process(HashMap<String, Object> map){
// 获取参数

// 执行操作

}
/**
*收尾
*@param map HashMap
*/
private void post(HashMap<String, Object> map){
// 获取参数

// 执行操作

}
}
