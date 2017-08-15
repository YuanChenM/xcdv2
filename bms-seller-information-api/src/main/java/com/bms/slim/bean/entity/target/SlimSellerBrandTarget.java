/*
 * 2017/01/12 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.slim.bean.entity.target;

import com.bms.slim.bean.BaseTarget;

/**
 * <p>表SLIM_SELLER_BRAND对应的实体SlimSellerBrand</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class SlimSellerBrandTarget extends BaseTarget {
    /** 代理及分销授权合同号 */
    private boolean agcyDistAuzContNoFlg;
    /** 代理及分销授权合同URL */
    private boolean agcyDistAuzContUrlFlg;
    /** 授权期开始时间 */
    private boolean startAuzDateFlg;
    /** 授权期结束时间 */
    private boolean endAuzDateFlg;

    public boolean isAgcyDistAuzContNoFlg() {
        return agcyDistAuzContNoFlg;
    }

    public void setAgcyDistAuzContNoFlg(boolean agcyDistAuzContNoFlg) {
        this.agcyDistAuzContNoFlg = agcyDistAuzContNoFlg;
    }

    public boolean isAgcyDistAuzContUrlFlg() {
        return agcyDistAuzContUrlFlg;
    }

    public void setAgcyDistAuzContUrlFlg(boolean agcyDistAuzContUrlFlg) {
        this.agcyDistAuzContUrlFlg = agcyDistAuzContUrlFlg;
    }

    public boolean isStartAuzDateFlg() {
        return startAuzDateFlg;
    }

    public void setStartAuzDateFlg(boolean startAuzDateFlg) {
        this.startAuzDateFlg = startAuzDateFlg;
    }

    public boolean isEndAuzDateFlg() {
        return endAuzDateFlg;
    }

    public void setEndAuzDateFlg(boolean endAuzDateFlg) {
        this.endAuzDateFlg = endAuzDateFlg;
    }
}
