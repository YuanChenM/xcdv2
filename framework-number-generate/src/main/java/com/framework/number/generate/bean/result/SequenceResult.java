package com.framework.number.generate.bean.result;

import com.framework.number.generate.enums.ResetType;

import java.io.Serializable;

/**
 * Created by jackjiang on 16/11/21.
 */
public class SequenceResult implements Serializable{
    private long index;
    private String createDate;
    private String updateTime;
    private ResetType resetType;

    public long getIndex() {
        return index;
    }

    public void setIndex(long index) {
        this.index = index;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public ResetType getResetType() {
        return resetType;
    }

    public void setResetType(ResetType resetType) {
        this.resetType = resetType;
    }
}
