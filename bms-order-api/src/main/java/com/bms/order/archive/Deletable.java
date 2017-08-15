package com.bms.order.archive;

/**
 * 可删除的
 * 
 * @author li_huiqian
 *
 */
public interface Deletable {

    /**
     * 将entity进行逻辑删除。删除的Entity必须先从数据库中取出，再做删除
     */
    public void delete();

}
