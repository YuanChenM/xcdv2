package com.zuul.entity;

import javax.persistence.*;
/**
 * Created by mao_yejun on 2017/2/20.
 */
@Entity
@Table(name = "INTERFACE_MODULE")
public class ModuleEntity extends BaseEntity {
    @Id
    @Column(name = "INTERFACE_MODULE_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long moduleId;
    @Column(name = "INTERFACE_MODULE_CODE")
    private String moduleCode;
    @Column(name = "INTERFACE_MODULE_NAME")
    private String moduleName;

    public long getModuleId() {
        return moduleId;
    }

    public void setModuleId(long moduleId) {
        this.moduleId = moduleId;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }
}
