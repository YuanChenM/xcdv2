package com.zuul.entity;


import java.util.Date;
import javax.persistence.*;
/**
 * Created by mao_yejun on 2017/2/20.
 */
@Entity
@Table(name = "INTERFACE_SECURITY_KEY")
public class SecurityKeyEntity extends BaseEntity {
    @Id
    @Column(name = "INTERFACE_SECURITY_KEY_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long securityKeyId;
    @Column(name = "SECURITY_KEY")
    private String securityKey;
    @Column(name = "API_KEY")
    private String apiKey;
    @Column(name = "TIMELINESS_TYPE")
    private Integer timelinessType;
    @Column(name = "TIMELINESS")
    private Integer timeliness;
    @Column(name = "STATUS")
    private Integer status;
    @Column(name = "INTERFACE_USER_ID")
    private long userId;
    @Column(name = "LOGIN_TIME")
    private Date loginTime;
    @ManyToOne
    @JoinColumn(name = "INTERFACE_USER_ID", referencedColumnName = "INTERFACE_USER_ID", unique = true, nullable = false, insertable = false, updatable = false)
    private UserEntity userEntity;

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public long getSecurityKeyId() {
        return securityKeyId;
    }

    public void setSecurityKeyId(long securityKeyId) {
        this.securityKeyId = securityKeyId;
    }

    public String getSecurityKey() {
        return securityKey;
    }

    public void setSecurityKey(String securityKey) {
        this.securityKey = securityKey;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public Integer getTimelinessType() {
        return timelinessType;
    }

    public void setTimelinessType(Integer timelinessType) {
        this.timelinessType = timelinessType;
    }

    public Integer getTimeliness() {
        return timeliness;
    }

    public void setTimeliness(Integer timeliness) {
        this.timeliness = timeliness;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
