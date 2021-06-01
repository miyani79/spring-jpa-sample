package com.miyani.sample.spring.boot.jpa.dto;

public class UserInfoDTO
{
    private String userId;
    private String deptCode;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }
}
