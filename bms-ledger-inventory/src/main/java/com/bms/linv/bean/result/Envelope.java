package com.bms.linv.bean.result;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

/**
 * Created by wang_fan on 2017/4/14.
 */
@XStreamAlias("soap:Envelope")
public class Envelope {

    @XStreamAlias("soap:Body")
    private Body body;

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }
}