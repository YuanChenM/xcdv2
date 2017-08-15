package com.bms.order.bean.externalCall.agent.entity;

import java.io.Serializable;

/**
 * Created by zhang_qiang1 on 2017/1/4.
 */
public class AgentEntity  implements Serializable{

    private String bsId;//  买手id


    private String bsCode;// 买手编码


    private String bsName;// 买手名称


    private  String bsType;// 买手类型


    private  Boolean isStoreGoods=true;// 是否囤实物  true  ： 囤实物  false 囤货权


    public String getBsId() {
        return bsId;
    }

    public void setBsId(String bsId) {
        this.bsId = bsId;
    }

    public String getBsCode() {
        return bsCode;
    }

    public void setBsCode(String bsCode) {
        this.bsCode = bsCode;
    }

    public String getBsName() {
        return bsName;
    }

    public void setBsName(String bsName) {
        this.bsName = bsName;
    }

    public String getBsType() {
        return bsType;
    }

    public void setBsType(String bsType) {
        this.bsType = bsType;
    }


    public Boolean getIsStoreGoods() {
        return isStoreGoods;
    }

    public void setIsStoreGoods(Boolean isStoreGoods) {
        this.isStoreGoods = isStoreGoods;
    }

    @Override
    public String toString() {
        return "AgentEntity{" +
                "bsId='" + bsId + '\'' +
                ", bsCode='" + bsCode + '\'' +
                ", bsName='" + bsName + '\'' +
                ", bsType='" + bsType + '\'' +
                ", isStoreGoods=" + isStoreGoods +
                '}';
    }
}
