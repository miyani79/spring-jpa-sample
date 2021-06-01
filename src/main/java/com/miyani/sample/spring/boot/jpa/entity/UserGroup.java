package com.miyani.sample.spring.boot.jpa.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;


/**
 * The persistent class for the USER_GROUP database table.
 *
 */
@Entity
@Table(name="USER_GROUP")
public class UserGroup implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name="IS_ADMIN")
    @ColumnDefault("'N'")
    private String isAdmin = "N";

    @Column(name="IS_DEFAULT")
    @ColumnDefault("'Y'")
    private String isDefault = "Y";

    @Column(name="IS_DELEGATOR")
    private String isDelegator;

    @Column(name="RESTRICT_RIGHT")
    private String restrictRight;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn (name="USER_ID")
    private UserInfo userInfo;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn (name="GROUP_ID")
    private GroupInfo groupInfo;

    public UserInfo getDevUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public GroupInfo getGroupInfo() {
        return groupInfo;
    }

    public void setGroupInfo(GroupInfo groupInfo) {
        this.groupInfo = groupInfo;
    }

    public String getIsAdmin() {
        return this.isAdmin;
    }

    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getIsDefault() {
        return this.isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }

    public String getIsDelegator() {
        return this.isDelegator;
    }

    public void setIsDelegator(String isDelegator) {
        this.isDelegator = isDelegator;
    }

    public String getRestrictRight() {
        return this.restrictRight;
    }

    public void setRestrictRight(String restrictRight) {
        this.restrictRight = restrictRight;
    }
}
