package com.bms.issue.archive;

import java.util.List;

/**
 * 可关联的
 * 
 * @author li_huiqian
 *
 */
public interface Linkable {

    /**
     * 关联两个对象，如果两个对象不存在关联，则不做变更
     * 
     * @param target
     */
    public void link(Linkable target);

    /**
     * 关联一个对象和一个列表，如果双方不存在关联，则不做变更
     * 
     * @param targets
     */
    public void link(List<?> targets);

}
