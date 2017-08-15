/*
 * 2017/03/15 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.bms.slim.bean.entity;

import com.framework.base.rest.entity.BaseEntity;

/**
 * <p>表slim_iso_management_system_certification对应的实体SlimIsoManagementSystemCertification</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class SlimIsoManagementSystemCertification extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /** 主键ID */
    private Long isoMscId;
    /** 卖家角色ID */
    private Long sellerRoleId;
    /** 类型（1：动物防疫条件合格证  2：定点屠宰许可证  3：食品生产许可证 4：
            产品品类名称必填)
            
            上传
            单位名称（必填)
            
            保存
            进沪(京、津)登记信息 5：清真食品生产经营许可证） */
    private String certType;
    /** 资质证书类型（1：ISO9001  2：ISO22000  3：ISO14001） */
    private String isoType;
    /** 证书编号 */
    private String certNo;
    /** 认证标准 */
    private String certificationStandard;
    /** 认证范围 */
    private String certificationScope;
    /** 发证日期及有效期 */
    private String issueDateValidPeriod;
    /** 认证机构 */
    private String certificationAuthority;
    /** 认证证书URL */
    private String certUrl;

    /**
     * <p>默认构造函数</p>
     */
    public SlimIsoManagementSystemCertification() {
    }

    /**
     * <p>主键ID</p>
     *
     * @return 主键ID
     */
    public Long getIsoMscId() {
        return isoMscId;
    }

    /**
     * <p>主键ID</p>
     *
     * @param isoMscId 主键ID
     */
    public void setIsoMscId(Long isoMscId) {
        this.isoMscId = isoMscId;
    }
    /**
     * <p>卖家角色ID</p>
     *
     * @return 卖家角色ID
     */
    public Long getSellerRoleId() {
        return sellerRoleId;
    }

    /**
     * <p>卖家角色ID</p>
     *
     * @param sellerRoleId 卖家角色ID
     */
    public void setSellerRoleId(Long sellerRoleId) {
        this.sellerRoleId = sellerRoleId;
    }
    /**
     * <p>类型（1：动物防疫条件合格证  2：定点屠宰许可证  3：食品生产许可证 4：
            产品品类名称必填)
            
            上传
            单位名称（必填)
            
            保存
            进沪(京、津)登记信息 5：清真食品生产经营许可证）</p>
     *
     * @return 类型（1：动物防疫条件合格证  2：定点屠宰许可证  3：食品生产许可证 4：
            产品品类名称必填)
            
            上传
            单位名称（必填)
            
            保存
            进沪(京、津)登记信息 5：清真食品生产经营许可证）
     */
    public String getCertType() {
        return certType;
    }

    /**
     * <p>类型（1：动物防疫条件合格证  2：定点屠宰许可证  3：食品生产许可证 4：
            产品品类名称必填)
            
            上传
            单位名称（必填)
            
            保存
            进沪(京、津)登记信息 5：清真食品生产经营许可证）</p>
     *
     * @param certType 类型（1：动物防疫条件合格证  2：定点屠宰许可证  3：食品生产许可证 4：
            产品品类名称必填)
            
            上传
            单位名称（必填)
            
            保存
            进沪(京、津)登记信息 5：清真食品生产经营许可证）
     */
    public void setCertType(String certType) {
        this.certType = certType;
    }
    /**
     * <p>资质证书类型（1：ISO9001  2：ISO22000  3：ISO14001）</p>
     *
     * @return 资质证书类型（1：ISO9001  2：ISO22000  3：ISO14001）
     */
    public String getIsoType() {
        return isoType;
    }

    /**
     * <p>资质证书类型（1：ISO9001  2：ISO22000  3：ISO14001）</p>
     *
     * @param isoType 资质证书类型（1：ISO9001  2：ISO22000  3：ISO14001）
     */
    public void setIsoType(String isoType) {
        this.isoType = isoType;
    }
    /**
     * <p>证书编号</p>
     *
     * @return 证书编号
     */
    public String getCertNo() {
        return certNo;
    }

    /**
     * <p>证书编号</p>
     *
     * @param certNo 证书编号
     */
    public void setCertNo(String certNo) {
        this.certNo = certNo;
    }
    /**
     * <p>认证标准</p>
     *
     * @return 认证标准
     */
    public String getCertificationStandard() {
        return certificationStandard;
    }

    /**
     * <p>认证标准</p>
     *
     * @param certificationStandard 认证标准
     */
    public void setCertificationStandard(String certificationStandard) {
        this.certificationStandard = certificationStandard;
    }
    /**
     * <p>认证范围</p>
     *
     * @return 认证范围
     */
    public String getCertificationScope() {
        return certificationScope;
    }

    /**
     * <p>认证范围</p>
     *
     * @param certificationScope 认证范围
     */
    public void setCertificationScope(String certificationScope) {
        this.certificationScope = certificationScope;
    }
    /**
     * <p>发证日期及有效期</p>
     *
     * @return 发证日期及有效期
     */
    public String getIssueDateValidPeriod() {
        return issueDateValidPeriod;
    }

    /**
     * <p>发证日期及有效期</p>
     *
     * @param issueDateValidPeriod 发证日期及有效期
     */
    public void setIssueDateValidPeriod(String issueDateValidPeriod) {
        this.issueDateValidPeriod = issueDateValidPeriod;
    }
    /**
     * <p>认证机构</p>
     *
     * @return 认证机构
     */
    public String getCertificationAuthority() {
        return certificationAuthority;
    }

    /**
     * <p>认证机构</p>
     *
     * @param certificationAuthority 认证机构
     */
    public void setCertificationAuthority(String certificationAuthority) {
        this.certificationAuthority = certificationAuthority;
    }
    /**
     * <p>认证证书URL</p>
     *
     * @return 认证证书URL
     */
    public String getCertUrl() {
        return certUrl;
    }

    /**
     * <p>认证证书URL</p>
     *
     * @param certUrl 认证证书URL
     */
    public void setCertUrl(String certUrl) {
        this.certUrl = certUrl;
    }

}
