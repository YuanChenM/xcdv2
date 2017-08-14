/*
 * 2017/03/01 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.agif.bean.param;

import com.framework.base.rest.param.BaseRestPaginationParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>表AGIF_BUTLER对应的实体AgifButler</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
@ApiModel(value = "ButlerRsParam", description = "冻品管家基本信息Param")
public class ButlerRsParam extends BaseRestPaginationParam {
    @ApiModelProperty(value = "管家ID")
    private String butlerId;
    @ApiModelProperty(value = "买手ID")
    private String agentId;
    @ApiModelProperty(value = "管家编码")
    private String butlerCode;
    @ApiModelProperty(value = "管家名称")
    private String butlerName;
    @ApiModelProperty(value = "出生日期")
    private String butlerBirthday;
    @ApiModelProperty(value = "性别")
    private String butlerSex;
    @ApiModelProperty(value = "微信")
    private String butlerWechat;
    @ApiModelProperty(value = "QQ")
    private String butlerQq;
    @ApiModelProperty(value = "身份证号")
    private java.lang.String idCardNo;
    @ApiModelProperty(value = "存储身份证正面图片上传文件服务器后返回的ID")
    private String idCardFront;
    @ApiModelProperty(value = "存储身份证反面图片上传文件服务器后返回的ID")
    private String idCardBack;
    @ApiModelProperty(value = "管家帐号ID")
    private Long accountId;
    @ApiModelProperty(value = "帐号名")
    private String accountName;
    @ApiModelProperty(value = "密码")
    private String password;
    @ApiModelProperty(value = "注册手机")
    private String telNo;
    @ApiModelProperty(value = "注册邮箱")
    private String mailAddr;
    @ApiModelProperty(value = "买手姓名")
    private String agentName;
    @ApiModelProperty(value = "买手编码")
    private String agentCode;
    @ApiModelProperty(value = "关系id")
    private Long relationId;
    @ApiModelProperty(value = "物流区主键")
    private Long lgcsAreaId;
    @ApiModelProperty(value = "物流区编码")
    private String lgcsAreaCode;
    @ApiModelProperty(value = "物流区名称")
    private String lgcsAreaName;
    @ApiModelProperty(value = "物流区划地区主键")
    private Long zoneId;
    @ApiModelProperty(value = "物流区划地区编码")
    private String zoneCode;
    @ApiModelProperty(value = "物流区划地区名称")
    private String zoneName;
    @ApiModelProperty(value = "配送站主键")
    private Long distributionId;
    @ApiModelProperty(value = "配送站分类")
    private String distributionType;
    @ApiModelProperty(value = "配送站表示码")
    private String distributionName;
    @ApiModelProperty(value = "配送站编码(全国所有配送站用4位阿拉伯数字，系统自动按新增顺序从0001顺序编码)")
    private String distributionCode;
    @ApiModelProperty(value = "领地ID")
    private Long demesneId;
    @ApiModelProperty(value = "领地分类")
    private String demesneType;
    @ApiModelProperty(value = "领地表示码")
    private String demesneName;
    @ApiModelProperty(value = "领地编码(以配送站为单元用2位阿拉伯数字，系统自动按新增顺序从01顺序编码)")
    private String demesneCode;
    @ApiModelProperty(value = "删除标识")
    private Boolean delFlg;

    /**
     * <p>默认构造函数</p>
     */
    public ButlerRsParam() {
    }

    public String getIdCardNo() {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }

    public Boolean getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(Boolean delFlg) {
        this.delFlg = delFlg;
    }


    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public String getMailAddr() {
        return mailAddr;
    }

    public void setMailAddr(String mailAddr) {
        this.mailAddr = mailAddr;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getAgentCode() {
        return agentCode;
    }

    public void setAgentCode(String agentCode) {
        this.agentCode = agentCode;
    }

    public Long getRelationId() {
        return relationId;
    }

    public void setRelationId(Long relationId) {
        this.relationId = relationId;
    }

    public Long getLgcsAreaId() {
        return lgcsAreaId;
    }

    public void setLgcsAreaId(Long lgcsAreaId) {
        this.lgcsAreaId = lgcsAreaId;
    }

    public String getLgcsAreaCode() {
        return lgcsAreaCode;
    }

    public void setLgcsAreaCode(String lgcsAreaCode) {
        this.lgcsAreaCode = lgcsAreaCode;
    }

    public String getLgcsAreaName() {
        return lgcsAreaName;
    }

    public void setLgcsAreaName(String lgcsAreaName) {
        this.lgcsAreaName = lgcsAreaName;
    }

    public Long getZoneId() {
        return zoneId;
    }

    public void setZoneId(Long zoneId) {
        this.zoneId = zoneId;
    }

    public String getZoneCode() {
        return zoneCode;
    }

    public void setZoneCode(String zoneCode) {
        this.zoneCode = zoneCode;
    }

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    public Long getDistributionId() {
        return distributionId;
    }

    public void setDistributionId(Long distributionId) {
        this.distributionId = distributionId;
    }

    public String getDistributionType() {
        return distributionType;
    }

    public void setDistributionType(String distributionType) {
        this.distributionType = distributionType;
    }

    public String getDistributionName() {
        return distributionName;
    }

    public void setDistributionName(String distributionName) {
        this.distributionName = distributionName;
    }

    public String getDistributionCode() {
        return distributionCode;
    }

    public void setDistributionCode(String distributionCode) {
        this.distributionCode = distributionCode;
    }

    public Long getDemesneId() {
        return demesneId;
    }

    public void setDemesneId(Long demesneId) {
        this.demesneId = demesneId;
    }

    public String getDemesneType() {
        return demesneType;
    }

    public void setDemesneType(String demesneType) {
        this.demesneType = demesneType;
    }

    public String getDemesneName() {
        return demesneName;
    }

    public void setDemesneName(String demesneName) {
        this.demesneName = demesneName;
    }

    public String getDemesneCode() {
        return demesneCode;
    }

    public void setDemesneCode(String demesneCode) {
        this.demesneCode = demesneCode;
    }

    /**
     * <p>BUTLER_ID</p>
     *
     * @return BUTLER_ID
     */
    public String getButlerId() {
        return butlerId;
    }

    /**
     * <p>BUTLER_ID</p>
     *
     * @param butlerId BUTLER_ID
     */
    public void setButlerId(String butlerId) {
        this.butlerId = butlerId;
    }

    /**
     * <p>AGENT_ID</p>
     *
     * @return AGENT_ID
     */
    public String getAgentId() {
        return agentId;
    }

    /**
     * <p>AGENT_ID</p>
     *
     * @param agentId AGENT_ID
     */
    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    /**
     * <p>BUTLER_CODE</p>
     *
     * @return BUTLER_CODE
     */
    public String getButlerCode() {
        return butlerCode;
    }

    /**
     * <p>BUTLER_CODE</p>
     *
     * @param butlerCode BUTLER_CODE
     */
    public void setButlerCode(String butlerCode) {
        this.butlerCode = butlerCode;
    }

    /**
     * <p>BUTLER_NAME</p>
     *
     * @return BUTLER_NAME
     */
    public String getButlerName() {
        return butlerName;
    }

    /**
     * <p>BUTLER_NAME</p>
     *
     * @param butlerName BUTLER_NAME
     */
    public void setButlerName(String butlerName) {
        this.butlerName = butlerName;
    }

    /**
     * <p>BUTLER_BIRTHDAY</p>
     *
     * @return BUTLER_BIRTHDAY
     */
    public String getButlerBirthday() {
        return butlerBirthday;
    }

    /**
     * <p>BUTLER_BIRTHDAY</p>
     *
     * @param butlerBirthday BUTLER_BIRTHDAY
     */
    public void setButlerBirthday(String butlerBirthday) {
        this.butlerBirthday = butlerBirthday;
    }

    /**
     * <p>BUTLER_SEX</p>
     *
     * @return BUTLER_SEX
     */
    public String getButlerSex() {
        return butlerSex;
    }

    /**
     * <p>BUTLER_SEX</p>
     *
     * @param butlerSex BUTLER_SEX
     */
    public void setButlerSex(String butlerSex) {
        this.butlerSex = butlerSex;
    }

    /**
     * <p>BUTLER_WECHAT</p>
     *
     * @return BUTLER_WECHAT
     */
    public String getButlerWechat() {
        return butlerWechat;
    }

    /**
     * <p>BUTLER_WECHAT</p>
     *
     * @param butlerWechat BUTLER_WECHAT
     */
    public void setButlerWechat(String butlerWechat) {
        this.butlerWechat = butlerWechat;
    }

    /**
     * <p>BUTLER_QQ</p>
     *
     * @return BUTLER_QQ
     */
    public String getButlerQq() {
        return butlerQq;
    }

    /**
     * <p>BUTLER_QQ</p>
     *
     * @param butlerQq BUTLER_QQ
     */
    public void setButlerQq(String butlerQq) {
        this.butlerQq = butlerQq;
    }

    /**
     * <p>存储身份证正面图片上传文件服务器后返回的ID</p>
     *
     * @return 存储身份证正面图片上传文件服务器后返回的ID
     */
    public String getIdCardFront() {
        return idCardFront;
    }

    /**
     * <p>存储身份证正面图片上传文件服务器后返回的ID</p>
     *
     * @param idCardFront 存储身份证正面图片上传文件服务器后返回的ID
     */
    public void setIdCardFront(String idCardFront) {
        this.idCardFront = idCardFront;
    }

    /**
     * <p>存储身份证反面图片上传文件服务器后返回的ID</p>
     *
     * @return 存储身份证反面图片上传文件服务器后返回的ID
     */
    public String getIdCardBack() {
        return idCardBack;
    }

    /**
     * <p>存储身份证反面图片上传文件服务器后返回的ID</p>
     *
     * @param idCardBack 存储身份证反面图片上传文件服务器后返回的ID
     */
    public void setIdCardBack(String idCardBack) {
        this.idCardBack = idCardBack;
    }

}
