package com.batch.bybatch.bean.result;

import java.io.Serializable;

/**
 * Created by guan_zhongheng on 2017/2/23.
 */
public class StandardGradeResult implements Serializable{

    /**
     * 定性评级标准ID
     */
    private long gradeStandardId;

    /**
     * 定性评级
     */
    private String gradeStandard;

    /**
     * 最小量级
     */
    private int singelAmount;

    /**
     * 最大量级
     */
    private int allAmount;

    public long getGradeStandardId() {
        return gradeStandardId;
    }

    public void setGradeStandardId(long gradeStandardId) {
        this.gradeStandardId = gradeStandardId;
    }

    public String getGradeStandard() {
        return gradeStandard;
    }

    public void setGradeStandard(String gradeStandard) {
        this.gradeStandard = gradeStandard;
    }

    public int getSingelAmount() {
        return singelAmount;
    }

    public void setSingelAmount(int singelAmount) {
        this.singelAmount = singelAmount;
    }

    public int getAllAmount() {
        return allAmount;
    }

    public void setAllAmount(int allAmount) {
        this.allAmount = allAmount;
    }
}
