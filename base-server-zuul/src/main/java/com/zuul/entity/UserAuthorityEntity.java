package com.zuul.entity;
import javax.persistence.*;

/**
 * Created by mao_yejun on 2017/2/20.
 */
@Entity
@Table(name = "INTERFACE_USER_AUTHORITY")
public class UserAuthorityEntity extends BaseEntity {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "INTERFACE_USER_ID")
    private long userId;
    @Column(name = "INTERFACE_DETAIL_ID")
    private long interfaceDetailId;
    @ManyToOne
    @JoinColumn(name = "INTERFACE_DETAIL_ID", referencedColumnName = "INTERFACE_DETAIL_ID", unique = true, nullable = false, insertable = false, updatable = false)
    private InterfaceEntity interfaceEntity;

    public InterfaceEntity getInterfaceEntity() {
        return interfaceEntity;
    }

    public void setInterfaceEntity(InterfaceEntity interfaceEntity) {
        this.interfaceEntity = interfaceEntity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getInterfaceDetailId() {
        return interfaceDetailId;
    }

    public void setInterfaceDetailId(long interfaceDetailId) {
        this.interfaceDetailId = interfaceDetailId;
    }
}
