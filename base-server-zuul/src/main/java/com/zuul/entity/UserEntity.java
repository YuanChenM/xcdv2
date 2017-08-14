package com.zuul.entity;

import javax.persistence.*;

import org.hibernate.annotations.Where;

import java.util.List;

/**
 * Created by mao_yejun on 2016/12/19.
 */
@Entity
@Table(name = "INTERFACE_USER")
public class UserEntity extends BaseEntity {
    @Id
    @Column(name = "INTERFACE_USER_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;
    @Column(name = "INTERFACE_USER_LOGIN_ID")
    private String loginId;
    @Column(name = "INTERFACE_USER_PASSWORD")
    private String password;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "COMPANY_NAME")
    private String companyName;
    @Column(name = "CONTACTS")
    private String contacts;
    @Column(name = "CONTACTS_PHONE")
    private String phone;
    @Column(name = "CONTACTS_MAIL")
    private String mail;
    @Column(name = "WE_CHAT")
    private String weChat;
    @Column(name = "QQ")
    private String qq;
    @Column(name = "COMPANY_WEB_ADD")
    private String companyWebAdd;
    @Column(name = "IS_ALL")
    private boolean allFlg;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "INTERFACE_USER_ID")
    @Where(clause = "del_flg='0'")
    private SecurityKeyEntity securityKeyEntity;
    @JoinColumn(name = "INTERFACE_USER_ID")
    @OneToMany(fetch = FetchType.EAGER)
    @Where(clause = "del_flg='0'")
    private List<UserAuthorityEntity> userAuthority;

    public boolean getAllFlg() {
        return allFlg;
    }

    public void setAllFlg(boolean allFlg) {
        this.allFlg = allFlg;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getWeChat() {
        return weChat;
    }

    public void setWeChat(String weChat) {
        this.weChat = weChat;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getCompanyWebAdd() {
        return companyWebAdd;
    }

    public void setCompanyWebAdd(String companyWebAdd) {
        this.companyWebAdd = companyWebAdd;
    }

    public List<UserAuthorityEntity> getUserAuthority() {
        return userAuthority;
    }

    public void setUserAuthority(List<UserAuthorityEntity> userAuthority) {
        this.userAuthority = userAuthority;
    }

    public SecurityKeyEntity getSecurityKeyEntity() {
        return securityKeyEntity;
    }

    public void setSecurityKeyEntity(SecurityKeyEntity securityKeyEntity) {
        this.securityKeyEntity = securityKeyEntity;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UserEntity() {
    }
}
