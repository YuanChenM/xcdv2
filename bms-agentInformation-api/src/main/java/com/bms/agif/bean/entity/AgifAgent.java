/*
 * 2017/03/08 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.agif.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表agif_agent对应的实体AgifAgent</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class AgifAgent extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 买手ID */
    private String agentId;
    /** 买手姓名 */
    private String agentName;
    /** 买手编码 */
    private String agentCode;
    /** 买手分类编码 */
    private String categoryCode;
    /** 买手分类名称 */
    private String categoryName;
    /** true:是 false:否 */
    private String isCreditTermAgent;
    /** 0:男 1:女 */
    private String agentSex;
    /** 头像 */
    private String agentPic;
    /** 身份证号 */
    private String agentCardId;
    /** 省ID */
    private Long provinceId;
    /** 省编码 */
    private String provinceCode;
    /** 省名称 */
    private String provinceName;
    /** 城市（地区）ID */
    private Long cityId;
    /** 城市（地区）编码 */
    private String cityCode;
    /** 城市（地区）名称 */
    private String cityName;
    /** 区（县）ID */
    private Long districtId;
    /** 区（县）编码 */
    private String districtCode;
    /** 区（县）名称 */
    private String districtName;
    /** 街道（乡）ID */
    private Long streetId;
    /** 街道（乡）编码 */
    private String streetCode;
    /** 街道（乡）名称 */
    private String streetName;
    /** 详细地址 */
    private String agentAddr;
    /** 微信 */
    private String agentWechat;
    /** QQ */
    private String agentQq;
    /** 开户行 */
    private String agentBankName;
    /** 开户名 */
    private String agentBankAccountName;
    /** 开户帐号 */
    private String agentBankAccount;
    /** 存储图片上传文件服务器后返回的ID */
    private String agentPicWeb;

    /**
     * <p>默认构造函数</p>
     */
    public AgifAgent() {
    }

    /**
     * <p>买手ID</p>
     *
     * @return 买手ID
     */
    public String getAgentId() {
        return agentId;
    }

    /**
     * <p>买手ID</p>
     *
     * @param agentId 买手ID
     */
    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }
    /**
     * <p>买手姓名</p>
     *
     * @return 买手姓名
     */
    public String getAgentName() {
        return agentName;
    }

    /**
     * <p>买手姓名</p>
     *
     * @param agentName 买手姓名
     */
    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }
    /**
     * <p>买手编码</p>
     *
     * @return 买手编码
     */
    public String getAgentCode() {
        return agentCode;
    }

    /**
     * <p>买手编码</p>
     *
     * @param agentCode 买手编码
     */
    public void setAgentCode(String agentCode) {
        this.agentCode = agentCode;
    }
    /**
     * <p>买手分类编码</p>
     *
     * @return 买手分类编码
     */
    public String getCategoryCode() {
        return categoryCode;
    }

    /**
     * <p>买手分类编码</p>
     *
     * @param categoryCode 买手分类编码
     */
    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }
    /**
     * <p>买手分类名称</p>
     *
     * @return 买手分类名称
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * <p>买手分类名称</p>
     *
     * @param categoryName 买手分类名称
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    /**
     * <p>true:是 false:否</p>
     *
     * @return true:是 false:否
     */
    public String getIsCreditTermAgent() {
        return isCreditTermAgent;
    }

    /**
     * <p>true:是 false:否</p>
     *
     * @param isCreditTermAgent true:是 false:否
     */
    public void setIsCreditTermAgent(String isCreditTermAgent) {
        this.isCreditTermAgent = isCreditTermAgent;
    }
    /**
     * <p>0:男 1:女</p>
     *
     * @return 0:男 1:女
     */
    public String getAgentSex() {
        return agentSex;
    }

    /**
     * <p>0:男 1:女</p>
     *
     * @param agentSex 0:男 1:女
     */
    public void setAgentSex(String agentSex) {
        this.agentSex = agentSex;
    }
    /**
     * <p>头像</p>
     *
     * @return 头像
     */
    public String getAgentPic() {
        return agentPic;
    }

    /**
     * <p>头像</p>
     *
     * @param agentPic 头像
     */
    public void setAgentPic(String agentPic) {
        this.agentPic = agentPic;
    }
    /**
     * <p>身份证号</p>
     *
     * @return 身份证号
     */
    public String getAgentCardId() {
        return agentCardId;
    }

    /**
     * <p>身份证号</p>
     *
     * @param agentCardId 身份证号
     */
    public void setAgentCardId(String agentCardId) {
        this.agentCardId = agentCardId;
    }
    /**
     * <p>省ID</p>
     *
     * @return 省ID
     */
    public Long getProvinceId() {
        return provinceId;
    }

    /**
     * <p>省ID</p>
     *
     * @param provinceId 省ID
     */
    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }
    /**
     * <p>省编码</p>
     *
     * @return 省编码
     */
    public String getProvinceCode() {
        return provinceCode;
    }

    /**
     * <p>省编码</p>
     *
     * @param provinceCode 省编码
     */
    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }
    /**
     * <p>省名称</p>
     *
     * @return 省名称
     */
    public String getProvinceName() {
        return provinceName;
    }

    /**
     * <p>省名称</p>
     *
     * @param provinceName 省名称
     */
    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }
    /**
     * <p>城市（地区）ID</p>
     *
     * @return 城市（地区）ID
     */
    public Long getCityId() {
        return cityId;
    }

    /**
     * <p>城市（地区）ID</p>
     *
     * @param cityId 城市（地区）ID
     */
    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }
    /**
     * <p>城市（地区）编码</p>
     *
     * @return 城市（地区）编码
     */
    public String getCityCode() {
        return cityCode;
    }

    /**
     * <p>城市（地区）编码</p>
     *
     * @param cityCode 城市（地区）编码
     */
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }
    /**
     * <p>城市（地区）名称</p>
     *
     * @return 城市（地区）名称
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * <p>城市（地区）名称</p>
     *
     * @param cityName 城市（地区）名称
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
    /**
     * <p>区（县）ID</p>
     *
     * @return 区（县）ID
     */
    public Long getDistrictId() {
        return districtId;
    }

    /**
     * <p>区（县）ID</p>
     *
     * @param districtId 区（县）ID
     */
    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
    }
    /**
     * <p>区（县）编码</p>
     *
     * @return 区（县）编码
     */
    public String getDistrictCode() {
        return districtCode;
    }

    /**
     * <p>区（县）编码</p>
     *
     * @param districtCode 区（县）编码
     */
    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }
    /**
     * <p>区（县）名称</p>
     *
     * @return 区（县）名称
     */
    public String getDistrictName() {
        return districtName;
    }

    /**
     * <p>区（县）名称</p>
     *
     * @param districtName 区（县）名称
     */
    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }
    /**
     * <p>街道（乡）ID</p>
     *
     * @return 街道（乡）ID
     */
    public Long getStreetId() {
        return streetId;
    }

    /**
     * <p>街道（乡）ID</p>
     *
     * @param streetId 街道（乡）ID
     */
    public void setStreetId(Long streetId) {
        this.streetId = streetId;
    }
    /**
     * <p>街道（乡）编码</p>
     *
     * @return 街道（乡）编码
     */
    public String getStreetCode() {
        return streetCode;
    }

    /**
     * <p>街道（乡）编码</p>
     *
     * @param streetCode 街道（乡）编码
     */
    public void setStreetCode(String streetCode) {
        this.streetCode = streetCode;
    }
    /**
     * <p>街道（乡）名称</p>
     *
     * @return 街道（乡）名称
     */
    public String getStreetName() {
        return streetName;
    }

    /**
     * <p>街道（乡）名称</p>
     *
     * @param streetName 街道（乡）名称
     */
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }
    /**
     * <p>详细地址</p>
     *
     * @return 详细地址
     */
    public String getAgentAddr() {
        return agentAddr;
    }

    /**
     * <p>详细地址</p>
     *
     * @param agentAddr 详细地址
     */
    public void setAgentAddr(String agentAddr) {
        this.agentAddr = agentAddr;
    }
    /**
     * <p>微信</p>
     *
     * @return 微信
     */
    public String getAgentWechat() {
        return agentWechat;
    }

    /**
     * <p>微信</p>
     *
     * @param agentWechat 微信
     */
    public void setAgentWechat(String agentWechat) {
        this.agentWechat = agentWechat;
    }
    /**
     * <p>QQ</p>
     *
     * @return QQ
     */
    public String getAgentQq() {
        return agentQq;
    }

    /**
     * <p>QQ</p>
     *
     * @param agentQq QQ
     */
    public void setAgentQq(String agentQq) {
        this.agentQq = agentQq;
    }
    /**
     * <p>开户行</p>
     *
     * @return 开户行
     */
    public String getAgentBankName() {
        return agentBankName;
    }

    /**
     * <p>开户行</p>
     *
     * @param agentBankName 开户行
     */
    public void setAgentBankName(String agentBankName) {
        this.agentBankName = agentBankName;
    }
    /**
     * <p>开户名</p>
     *
     * @return 开户名
     */
    public String getAgentBankAccountName() {
        return agentBankAccountName;
    }

    /**
     * <p>开户名</p>
     *
     * @param agentBankAccountName 开户名
     */
    public void setAgentBankAccountName(String agentBankAccountName) {
        this.agentBankAccountName = agentBankAccountName;
    }
    /**
     * <p>开户帐号</p>
     *
     * @return 开户帐号
     */
    public String getAgentBankAccount() {
        return agentBankAccount;
    }

    /**
     * <p>开户帐号</p>
     *
     * @param agentBankAccount 开户帐号
     */
    public void setAgentBankAccount(String agentBankAccount) {
        this.agentBankAccount = agentBankAccount;
    }
    /**
     * <p>存储图片上传文件服务器后返回的ID</p>
     *
     * @return 存储图片上传文件服务器后返回的ID
     */
    public String getAgentPicWeb() {
        return agentPicWeb;
    }

    /**
     * <p>存储图片上传文件服务器后返回的ID</p>
     *
     * @param agentPicWeb 存储图片上传文件服务器后返回的ID
     */
    public void setAgentPicWeb(String agentPicWeb) {
        this.agentPicWeb = agentPicWeb;
    }

}
