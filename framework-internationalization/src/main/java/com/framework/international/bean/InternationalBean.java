package com.framework.international.bean;

/**
 * Created by dai_youcheng on 2016-12-5.
 */
public class InternationalBean {
    private String number;
    private String Cn;
    private String En;

    public InternationalBean(String number, String cn, String zn) {
        this.number = number;
        this.Cn = cn;
        this.En = zn;
    }

    public InternationalBean() {

    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCn() {
        return Cn;
    }

    public void setCn(String cn) {
        this.Cn = cn;
    }

    public String getEn() {
        return En;
    }

    public void setEn(String zn) {
        this.En = zn;
    }
}
