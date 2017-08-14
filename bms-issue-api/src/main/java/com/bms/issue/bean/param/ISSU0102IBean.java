package com.bms.issue.bean.param;

import com.bms.issue.common.rest.param.RestBean;

/**
 * 问题订单发起提交接口Param
 *
 * @author li_huiqian
 */
public class ISSU0102IBean extends RestBean {
    private static final long serialVersionUID = 1L;

    private Long issueId;

    private Integer ver;

    public Long getIssueId() {
        return issueId;
    }

    public void setIssueId(Long issueId) {
        this.issueId = issueId;
    }

    public Integer getVer() {
        return ver;
    }

    public void setVer(Integer ver) {
        this.ver = ver;
    }
}
