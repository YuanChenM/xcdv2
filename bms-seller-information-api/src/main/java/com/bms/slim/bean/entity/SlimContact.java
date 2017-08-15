/*
 * 2017/02/24 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.slim.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表SLIM_CONTACT对应的实体SlimContact</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class SlimContact extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 联系人ID */
    private Long contactId;
    /** 联系人名称 */
    private String contactName;
    /** 联系人类型(1:签约联系人;2:订单联系人;3:收款联系人;4营销负责人;5:合同负责人;6:生产负责人;7:品控负责人;8:包材负责人;9:运输负责人;10:合同快递收件人) */
    private String contactType;
    /** 工作单位ID */
    private Long workunitId;
    /** 工作单位类型，1：卖家，2：生产商 */
    private String workunitType;
    /** 手机号 */
    private String mobile;
    /** 微信号 */
    private String wechat;
    /** QQ号 */
    private String qq;
    /** EMAIL地址 */
    private String email;

    /**
     * <p>默认构造函数</p>
     */
    public SlimContact() {
    }

    /**
     * <p>联系人ID</p>
     *
     * @return 联系人ID
     */
    public Long getContactId() {
        return contactId;
    }

    /**
     * <p>联系人ID</p>
     *
     * @param contactId 联系人ID
     */
    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }
    /**
     * <p>联系人名称</p>
     *
     * @return 联系人名称
     */
    public String getContactName() {
        return contactName;
    }

    /**
     * <p>联系人名称</p>
     *
     * @param contactName 联系人名称
     */
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }
    /**
     * <p>联系人类型(1:签约联系人;2:订单联系人;3:收款联系人;4营销负责人;5:合同负责人;6:生产负责人;7:品控负责人;8:包材负责人;9:运输负责人;10:合同快递收件人)</p>
     *
     * @return 联系人类型(1:签约联系人;2:订单联系人;3:收款联系人;4营销负责人;5:合同负责人;6:生产负责人;7:品控负责人;8:包材负责人;9:运输负责人;10:合同快递收件人)
     */
    public String getContactType() {
        return contactType;
    }

    /**
     * <p>联系人类型(1:签约联系人;2:订单联系人;3:收款联系人;4营销负责人;5:合同负责人;6:生产负责人;7:品控负责人;8:包材负责人;9:运输负责人;10:合同快递收件人)</p>
     *
     * @param contactType 联系人类型(1:签约联系人;2:订单联系人;3:收款联系人;4营销负责人;5:合同负责人;6:生产负责人;7:品控负责人;8:包材负责人;9:运输负责人;10:合同快递收件人)
     */
    public void setContactType(String contactType) {
        this.contactType = contactType;
    }
    /**
     * <p>工作单位ID</p>
     *
     * @return 工作单位ID
     */
    public Long getWorkunitId() {
        return workunitId;
    }

    /**
     * <p>工作单位ID</p>
     *
     * @param workunitId 工作单位ID
     */
    public void setWorkunitId(Long workunitId) {
        this.workunitId = workunitId;
    }
    /**
     * <p>工作单位类型，1：卖家，2：生产商</p>
     *
     * @return 工作单位类型，1：卖家，2：生产商
     */
    public String getWorkunitType() {
        return workunitType;
    }

    /**
     * <p>工作单位类型，1：卖家，2：生产商</p>
     *
     * @param workunitType 工作单位类型，1：卖家，2：生产商
     */
    public void setWorkunitType(String workunitType) {
        this.workunitType = workunitType;
    }
    /**
     * <p>手机号</p>
     *
     * @return 手机号
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * <p>手机号</p>
     *
     * @param mobile 手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    /**
     * <p>微信号</p>
     *
     * @return 微信号
     */
    public String getWechat() {
        return wechat;
    }

    /**
     * <p>微信号</p>
     *
     * @param wechat 微信号
     */
    public void setWechat(String wechat) {
        this.wechat = wechat;
    }
    /**
     * <p>QQ号</p>
     *
     * @return QQ号
     */
    public String getQq() {
        return qq;
    }

    /**
     * <p>QQ号</p>
     *
     * @param qq QQ号
     */
    public void setQq(String qq) {
        this.qq = qq;
    }
    /**
     * <p>EMAIL地址</p>
     *
     * @return EMAIL地址
     */
    public String getEmail() {
        return email;
    }

    /**
     * <p>EMAIL地址</p>
     *
     * @param email EMAIL地址
     */
    public void setEmail(String email) {
        this.email = email;
    }

}
