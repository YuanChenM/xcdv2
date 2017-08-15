package com.bms.slim.bean.param.wrapper;

import com.framework.base.rest.entity.BaseEntity;

public class SlimContactParam extends BaseEntity {

        /** 序列号 */
        private static final long serialVersionUID = 1L;
        /** 联系人ID */
        private Long contactId;
        /** 联系人名称 */
        private String contactName;
        /** 工作单位ID */
        private Long workunitId;
        /** 工作单位类型，1：卖家单位，2：生产商单位 */
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
        public SlimContactParam() {
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
         * <p>工作单位类型，1：卖家单位，2：生产商单位</p>
         *
         * @return 工作单位类型，1：卖家单位，2：生产商单位
         */
        public String getWorkunitType() {
            return workunitType;
        }

        /**
         * <p>工作单位类型，1：卖家单位，2：生产商单位</p>
         *
         * @param workunitType 工作单位类型，1：卖家单位，2：生产商单位
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
