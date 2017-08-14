package com.msk.sso.client.bean.result;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by shi_yuxi on 2016/9/28.
 */
@XmlRootElement(name = "ChangePasswordMessage")
public class ChangePasswordMessage implements Serializable{
    private String status;
    private String errorMessage;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
