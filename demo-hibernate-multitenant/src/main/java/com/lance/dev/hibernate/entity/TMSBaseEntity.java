package com.lance.dev.hibernate.entity;

import org.hibernate.collection.spi.PersistentCollection;
import org.hibernate.proxy.HibernateProxy;
import org.hibernate.proxy.LazyInitializer;

import javax.persistence.*;
import java.util.Date;


/**
 * TMS系统的实体对象的基础类.
 * <p/>
 * 这是一个抽象类，且不是被持久化的实体类，但可以被子类继承并包含对应的字段。所包括的字段为
 * 绝大多数实体类都需要用到的字段。对于不需要用到的，设定默认值即可。
 *
 * @author Tan Liang (Bred Tan)
 * @since 2014/5/12
 */
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class TMSBaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = -4932645577838935714L;

    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 30)
    protected String id;

    @Column(length = 30)
    protected String instanceSeqId;

    @Column(length = 30)
    protected String createdById;

    @Column(length = 50)
    protected String createdByName;

    protected Date createdDate;

    @Column(length = 30)
    protected String updatedById;

    @Column(length = 50)
    protected String updatedByName;

    protected Date updatedDate;

    protected String companyName;

    @Override
    public String toString() {
        return "TMSBaseEntity{" +
                "id='" + id + '\'' +
                ", instanceSeqId='" + instanceSeqId + '\'' +
                ", createdById='" + createdById + '\'' +
                ", createdByName='" + createdByName + '\'' +
                ", createdDate=" + createdDate +
                ", updatedById='" + updatedById + '\'' +
                ", updatedByName='" + updatedByName + '\'' +
                ", updatedDate=" + updatedDate +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInstanceSeqId() {
        return instanceSeqId;
    }

    public void setInstanceSeqId(String instanceSeqId) {
        this.instanceSeqId = instanceSeqId;
    }

    public String getCreatedById() {
        return createdById;
    }

    public void setCreatedById(String createdById) {
        this.createdById = createdById;
    }

    public String getCreatedByName() {
        return createdByName;
    }

    public void setCreatedByName(String createdByName) {
        this.createdByName = createdByName;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdatedById() {
        return updatedById;
    }

    public void setUpdatedById(String updatedById) {
        this.updatedById = updatedById;
    }

    public String getUpdatedByName() {
        return updatedByName;
    }

    public void setUpdatedByName(String updatedByName) {
        this.updatedByName = updatedByName;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TMSBaseEntity that = (TMSBaseEntity) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }

    protected boolean isLazy(Object value) {
        if (value instanceof HibernateProxy) {//hibernate代理对象
            LazyInitializer initializer = ((HibernateProxy) value).getHibernateLazyInitializer();
            if (initializer.isUninitialized()) {
                return true;
            }
        } else if (value instanceof PersistentCollection) {//实体关联集合一对多等
            PersistentCollection collection = (PersistentCollection) value;
            if (!collection.wasInitialized()) {
                return true;
            }
            Object val = collection.getValue();
            if (val == null) {
                return true;
            }
        }
        return false;
    }

    protected boolean isCanUse(Object value) {
        return !isCannotUse(value);
    }

    protected boolean isCannotUse(Object value) {
        return value == null || isLazy(value);
    }
}
