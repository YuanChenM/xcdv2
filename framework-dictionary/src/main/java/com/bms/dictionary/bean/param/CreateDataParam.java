package com.bms.dictionary.bean.param;

import com.bms.dictionary.bean.entity.DictNodeValue;

import java.io.Serializable;
import java.util.List;

/**
 * Created by dai_youcheng on 2016-11-10.
 */
public class CreateDataParam implements Serializable {
    private String rootCode;
    private String  dictCode;
    private List<DictNodeValue> values;

    public String getRootCode() {
        return rootCode;
    }

    public void setRootCode(String rootCode) {
        this.rootCode = rootCode;
    }

    public String getDictCode() {
        return dictCode;
    }

    public void setDictCode(String dictCode) {
        this.dictCode = dictCode;
    }

    public List<DictNodeValue> getValues() {
        return values;
    }

    public void setValues(List<DictNodeValue> values) {
        this.values = values;
    }
}
