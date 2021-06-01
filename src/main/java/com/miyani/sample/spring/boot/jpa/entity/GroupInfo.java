package com.miyani.sample.spring.boot.jpa.entity;

import org.hibernate.annotations.ColumnDefault;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the GROUP_INFO database table.
 *
 */
@Entity
@Table(name="GROUP_INFO")
public class GroupInfo implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="GROUP_ID")
    private String groupId;

    private String description;

    @Column(name="GROUP_NAME")
    private String groupName;

    @Column(name="PARENT_GROUP_ID")
    private String parentGroupId;

    @Column(name="USE_YN")
    private String useYn = "Y";

    public String getGroupId() {
        return this.groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getParentGroupId() {
        return this.parentGroupId;
    }

    public void setParentGroupId(String parentGroupId) {
        this.parentGroupId = parentGroupId;
    }

    public String getUseYn() {
        return this.useYn;
    }

    public void setUseYn(String useYn) {
        this.useYn = useYn;
    }
}
