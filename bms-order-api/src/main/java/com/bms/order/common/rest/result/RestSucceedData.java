package com.bms.order.common.rest.result;

import java.io.Serializable;

/**
 * 成功的Data
 * 
 * @author li_huiqian
 *
 */
public class RestSucceedData implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 7528915704589287863L;

    /**
     * 正确数据的ID
     */
    private Object succeedId;

    /**
     * 失败数据在传入数据中的位置，从0开始
     */
    private int index;

    /**
     * @return the succeedId
     */
    public Object getSucceedId() {
        return succeedId;
    }

    /**
     * @param succeedId
     *            the succeedId to set
     */
    public void setSucceedId(Object succeedId) {
        this.succeedId = succeedId;
    }

    /**
     * @return the index
     */
    public int getIndex() {
        return index;
    }

    /**
     * @param index
     *            the index to set
     */
    public void setIndex(int index) {
        this.index = index;
    }

}
