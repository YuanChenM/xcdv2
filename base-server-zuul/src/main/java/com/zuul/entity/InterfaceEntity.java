package com.zuul.entity;


import javax.persistence.*;

/**
 * Created by mao_yejun on 2017/2/20.
 */
@Entity
@Table(name = "INTERFACE_DETAIL")
public class InterfaceEntity extends BaseEntity {
    @Id
    @Column(name = "INTERFACE_DETAIL_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long interfaceDetailId;
    @Column(name = "INTERFACE_MODULE_ID")
    private long moduleId;
    @Column(name = "INTERFACE_CODE")
    private String interfaceCode;
    @Column(name = "INTERFACE_NAME")
    private String interfaceName;
    @Column(name = "INTERFACE_URL")
    private String interfaceUrl;
    @Column(name = "STATUS")
    private String status;
    @ManyToOne
    @JoinColumn(name = "INTERFACE_MODULE_ID", referencedColumnName = "INTERFACE_MODULE_ID", unique = true, nullable = false, insertable = false, updatable = false)
    private ModuleEntity moduleEntity;

    public ModuleEntity getModuleEntity() {
        return moduleEntity;
    }

    public void setModuleEntity(ModuleEntity moduleEntity) {
        this.moduleEntity = moduleEntity;
    }

    public long getInterfaceDetailId() {
        return interfaceDetailId;
    }

    public void setInterfaceDetailId(long interfaceDetailId) {
        this.interfaceDetailId = interfaceDetailId;
    }

    public long getModuleId() {
        return moduleId;
    }

    public void setModuleId(long moduleId) {
        this.moduleId = moduleId;
    }

    public String getInterfaceCode() {
        return interfaceCode;
    }

    public void setInterfaceCode(String interfaceCode) {
        this.interfaceCode = interfaceCode;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public String getInterfaceUrl() {
        return interfaceUrl;
    }

    public void setInterfaceUrl(String interfaceUrl) {
        this.interfaceUrl = interfaceUrl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
