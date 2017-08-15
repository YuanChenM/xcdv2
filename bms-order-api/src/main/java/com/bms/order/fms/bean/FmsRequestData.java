package com.bms.order.fms.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by yuan_chen on 2017/4/19 0012.
 *
 * FmsRequestData<T>
 */
public class FmsRequestData<T> implements Serializable {

    private static final long serialVersionUID = 6028754237451532709L;

    private int total;
    private List<T> head;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getHead() {
        return head;
    }

    public void setHead(List<T> head) {
        this.head = head;
    }
}
