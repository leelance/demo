package com.lance.dev.hibernate.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * @author lance
 * @since 2015/2/13 11:29.
 */
@Entity
@Table(name = "t_marriage_enum")
public class MarriageEnumEntity {
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
    /**企业名称*/
    protected String companyName;
    /**编号*/
    protected String serialNumber;
    /**名称*/
    protected String enumValue;
    /**描述*/
    protected String description;
    /**开始日期*/
    protected Date startDate;
    /**结束日期*/
    protected Date endDate;
    /**状态标志位*/
    protected Integer status;
    /**默认选项*/
    @Column(name="is_default")
    protected boolean isDefault;

    @Column(name="sort")
    protected Integer sort;

    //为用户自定义词典服务
    protected int dictionaryKey;

    private boolean selected;

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

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getEnumValue() {
        return enumValue;
    }

    public void setEnumValue(String enumValue) {
        this.enumValue = enumValue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public int getDictionaryKey() {
        return dictionaryKey;
    }

    public void setDictionaryKey(int dictionaryKey) {
        this.dictionaryKey = dictionaryKey;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
