package com.bms.issue.bean.param;

import com.bms.issue.common.rest.param.RestBean;

/**
 * 问题附件删除接口Param
 *
 * @author li_huiqian
 */
public class ISSU0205IBean extends RestBean {
    private static final long serialVersionUID = 1L;

    /**
     * 问题id
     */
    private Long questionId;
    /**
     * 附件id
     */

    private Long accessoryId;


    /**
     * 附件版本号
     */

    private Integer version;


    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Long getAccessoryId() {
        return accessoryId;
    }

    public void setAccessoryId(Long accessoryId) {
        this.accessoryId = accessoryId;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
