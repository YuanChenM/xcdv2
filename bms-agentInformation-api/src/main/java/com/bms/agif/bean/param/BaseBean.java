package com.bms.agif.bean.param;


import java.io.Serializable;

public class BaseBean<T1,T2> implements Serializable {

    private T1 filter;

    private T2 target;

    public T1 getFilter() {
        return filter;
    }

    public void setFilter(T1 filter) {
        this.filter = filter;
    }

    public T2 getTarget() {
        return target;
    }

    public void setTarget(T2 target) {
        this.target = target;
    }
}
