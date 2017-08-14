/*
 * 2016/12/02 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.dictionary.bean.entity;


import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表dict_node_value对应的实体DictNodeValue</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class DictNodeValue extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** DATA_ID */
    private Long dataId;
    /** DICT_ID */
    private Long dictId;
    /** DATA_VALUE */
    private String dataValue;
    /** DATA_EN */
    private String dataEn;
    /** DATA_CN */
    private String dataCn;

    /**
     * <p>默认构造函数</p>
     */
    public DictNodeValue() {
    }

    /**
     * <p>DATA_ID</p>
     *
     * @return DATA_ID
     */
    public Long getDataId() {
        return dataId;
    }

    /**
     * <p>DATA_ID</p>
     *
     * @param dataId DATA_ID
     */
    public void setDataId(Long dataId) {
        this.dataId = dataId;
    }
    /**
     * <p>DICT_ID</p>
     *
     * @return DICT_ID
     */
    public Long getDictId() {
        return dictId;
    }

    /**
     * <p>DICT_ID</p>
     *
     * @param dictId DICT_ID
     */
    public void setDictId(Long dictId) {
        this.dictId = dictId;
    }
    /**
     * <p>DATA_VALUE</p>
     *
     * @return DATA_VALUE
     */
    public String getDataValue() {
        return dataValue;
    }

    /**
     * <p>DATA_VALUE</p>
     *
     * @param dataValue DATA_VALUE
     */
    public void setDataValue(String dataValue) {
        this.dataValue = dataValue;
    }
    /**
     * <p>DATA_EN</p>
     *
     * @return DATA_EN
     */
    public String getDataEn() {
        return dataEn;
    }

    /**
     * <p>DATA_EN</p>
     *
     * @param dataEn DATA_EN
     */
    public void setDataEn(String dataEn) {
        this.dataEn = dataEn;
    }
    /**
     * <p>DATA_CN</p>
     *
     * @return DATA_CN
     */
    public String getDataCn() {
        return dataCn;
    }

    /**
     * <p>DATA_CN</p>
     *
     * @param dataCn DATA_CN
     */
    public void setDataCn(String dataCn) {
        this.dataCn = dataCn;
    }

}
