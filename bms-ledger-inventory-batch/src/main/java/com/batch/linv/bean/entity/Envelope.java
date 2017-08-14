package com.batch.linv.bean.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

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