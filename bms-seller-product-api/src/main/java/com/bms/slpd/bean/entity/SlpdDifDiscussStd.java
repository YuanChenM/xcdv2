/*
 * 2017/02/09 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.slpd.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表SLPD_DIF_DISCUSS_STD对应的实体SlpdDifDiscussStd</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class SlpdDifDiscussStd extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 主键 */
    private Long difDiscussId;
    /** 档案卡类型 */
    private Long difStdType;
    /** 论证内容差异值 */
    private String discussDifVal;
    /** 0 -- 加工技术标准mct  1-- 加工质量标准tnc */
    private String stdType;
    /** 0 -- 市场  1-- 生厂商 */
    private String discussType;
    /** 提案日 */
    private java.util.Date raiseDate;
    /** 结案日 */
    private java.util.Date fixDate;
    /** 生产商ID */
    private Long producerId;
    /** 生产商名 */
    private String producerName;
    /** 备注 */
    private String remark;

    /**
     * <p>默认构造函数</p>
     */
    public SlpdDifDiscussStd() {
    }

    /**
     * <p>主键</p>
     *
     * @return 主键
     */
    public Long getDifDiscussId() {
        return difDiscussId;
    }

    /**
     * <p>主键</p>
     *
     * @param difDiscussId 主键
     */
    public void setDifDiscussId(Long difDiscussId) {
        this.difDiscussId = difDiscussId;
    }

    public Long getDifStdType() {
        return difStdType;
    }

    public void setDifStdType(Long difStdType) {
        this.difStdType = difStdType;
    }

    /**
     * <p>论证内容差异值</p>
     *
     * @return 论证内容差异值
     */
    public String getDiscussDifVal() {
        return discussDifVal;
    }

    /**
     * <p>论证内容差异值</p>
     *
     * @param discussDifVal 论证内容差异值
     */
    public void setDiscussDifVal(String discussDifVal) {
        this.discussDifVal = discussDifVal;
    }
    /**
     * <p>0 -- 加工技术标准mct  1-- 加工质量标准tnc</p>
     *
     * @return 0 -- 加工技术标准mct  1-- 加工质量标准tnc
     */
    public String getStdType() {
        return stdType;
    }

    /**
     * <p>0 -- 加工技术标准mct  1-- 加工质量标准tnc</p>
     *
     * @param stdType 0 -- 加工技术标准mct  1-- 加工质量标准tnc
     */
    public void setStdType(String stdType) {
        this.stdType = stdType;
    }
    /**
     * <p>0 -- 市场  1-- 生厂商</p>
     *
     * @return 0 -- 市场  1-- 生厂商
     */
    public String getDiscussType() {
        return discussType;
    }

    /**
     * <p>0 -- 市场  1-- 生厂商</p>
     *
     * @param discussType 0 -- 市场  1-- 生厂商
     */
    public void setDiscussType(String discussType) {
        this.discussType = discussType;
    }
    /**
     * <p>提案日</p>
     *
     * @return 提案日
     */
    public java.util.Date getRaiseDate() {
        return raiseDate;
    }

    /**
     * <p>提案日</p>
     *
     * @param raiseDate 提案日
     */
    public void setRaiseDate(java.util.Date raiseDate) {
        this.raiseDate = raiseDate;
    }
    /**
     * <p>结案日</p>
     *
     * @return 结案日
     */
    public java.util.Date getFixDate() {
        return fixDate;
    }

    /**
     * <p>结案日</p>
     *
     * @param fixDate 结案日
     */
    public void setFixDate(java.util.Date fixDate) {
        this.fixDate = fixDate;
    }
    /**
     * <p>生产商ID</p>
     *
     * @return 生产商ID
     */
    public Long getProducerId() {
        return producerId;
    }

    /**
     * <p>生产商ID</p>
     *
     * @param producerId 生产商ID
     */
    public void setProducerId(Long producerId) {
        this.producerId = producerId;
    }
    /**
     * <p>生产商名</p>
     *
     * @return 生产商名
     */
    public String getProducerName() {
        return producerName;
    }

    /**
     * <p>生产商名</p>
     *
     * @param producerName 生产商名
     */
    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }
    /**
     * <p>备注</p>
     *
     * @return 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * <p>备注</p>
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

}
