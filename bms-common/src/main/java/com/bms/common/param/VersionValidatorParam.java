package com.bms.common.param;


import com.framework.base.rest.entity.BaseEntity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mao_yejun on 2016/12/1.
 */
public class VersionValidatorParam extends BaseEntity {
    private Map<String, Object> filterMap = new HashMap();

    public void setFilterObject(String key, Object value) {
        this.filterMap.put(key, value);
    }

    public Map<String, Object> getFilterMap() {
        return filterMap;
    }

    public void setFilterMap(Map<String, Object> filterMap) {
        this.filterMap = filterMap;
    }
}
