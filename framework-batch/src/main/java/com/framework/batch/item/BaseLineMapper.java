package com.framework.batch.item;

import org.springframework.batch.item.file.LineMapper;
import org.springframework.beans.factory.InitializingBean;

/**
 * <p>行映射器接口，定义了将Flat文件中的一条记录转化为域对象（通常为java对象）。</p>
 *
 * @author xia_xiaojie
 * @date 2016/11/09
 * @version 1.0.0
 */
public interface BaseLineMapper<I> extends LineMapper<I>, InitializingBean {

}
