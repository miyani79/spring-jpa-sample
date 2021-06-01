package com.miyani.sample.spring.boot.jpa.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the USER_INFO database table.
 *
 */
@Entity
@Table(name="USER_INFO")
public class UserInfo implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="USER_ID")
    private String userId;

    @Temporal(TemporalType.DATE)
    @Column(name="ACCESS_DATE")
    private Date accessDate;

    @Column(name="DEPT_CODE")
    private String deptCode;

    private String description;

    private String email;

    @Temporal(TemporalType.DATE)
    @Column(name="FROM_DATE")
    private Date fromDate;

    @Column(name="MOBILE_PHONE")
    private String mobilePhone;

    @Column(name="NOT_AT_WORK")
    private String notAtWork;

    @Column(name="TEAM_LEADER")
    private String teamLeader;

    @Column(name="TEL_NO")
    private String telNo;

    @Temporal(TemporalType.DATE)
    @Column(name="TO_DATE")
    private Date toDate;

    @Column(name="USER_DIV")
    private String userDiv;

    @Column(name="USER_NAME")
    private String userName;

    @Column(name="USER_PASSWD")
    private String userPasswd;

    @OneToMany (mappedBy = "userInfo")
    private List<UserGroup> userGroupList = new ArrayList<>();

    public void addGroup(UserGroup userGroup) {
        userGroupList.add(userGroup);
        userGroup.setUserInfo(this);
    }


    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getAccessDate() {
        return this.accessDate;
    }

    public void setAccessDate(Date accessDate) {
        this.accessDate = accessDate;
    }

    public String getDeptCode() {
        return this.deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFromDate() {
        return this.fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public String getMobilePhone() {
        return this.mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getNotAtWork() {
        return this.notAtWork;
    }

    public void setNotAtWork(String notAtWork) {
        this.notAtWork = notAtWork;
    }

    public String getTeamLeader() {
        return this.teamLeader;
    }

    public void setTeamLeader(String teamLeader) {
        this.teamLeader = teamLeader;
    }

    public String getTelNo() {
        return this.telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public Date getToDate() {
        return this.toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public String getUserDiv() {
        return this.userDiv;
    }

    public void setUserDiv(String userDiv) {
        this.userDiv = userDiv;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPasswd() {
        return this.userPasswd;
    }

    public void setUserPasswd(String userPasswd) {
        this.userPasswd = userPasswd;
    }
}