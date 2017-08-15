package com.bms.order.archive;

/**
 * 可修改的
 * 
 * @author li_huiqian
 *
 */
public interface Modifiable {

    /**
     * 将修改后的entity插入数据库，注意，entity必须是从数据库中取出的，自建的无法修改
     */
    public void modify();

}
