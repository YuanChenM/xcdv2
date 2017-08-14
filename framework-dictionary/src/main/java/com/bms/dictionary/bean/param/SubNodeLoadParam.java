package com.bms.dictionary.bean.param;


import com.framework.base.rest.param.BaseRestPaginationParam;

/**
 * Created by dai_youcheng on 2016-11-11.
 */
public class SubNodeLoadParam extends BaseRestPaginationParam {
    private String dictId;
    /**倘若有多层，是否只展示节点下面的第一层**/
    private boolean multilevelFlag;
    public String getDictId() {
        return dictId;
    }

    public void setDictId(String dictId) {
        this.dictId = dictId;
    }

    public boolean isMultilevelFlag() {
        return multilevelFlag;
    }

    public void setMultilevelFlag(boolean multilevelFlag) {
        this.multilevelFlag = multilevelFlag;
    }
}
