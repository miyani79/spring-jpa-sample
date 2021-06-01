package com.miyani.sample.spring.boot.jpa.dto;

import java.util.Objects;

public class GroupInfoDTO
{
    private String groupId;
    private String description;
    private String groupName;
    private String parentGroupId;
    private String useYn;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getParentGroupId() {
        return parentGroupId;
    }

    public void setParentGroupId(String parentGroupId) {
        this.parentGroupId = parentGroupId;
    }

    public String getUseYn() {
        return useYn;
    }

    public void setUseYn(String useYn) {
        this.useYn = useYn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupInfoDTO that = (GroupInfoDTO) o;
        return Objects.equals(groupId, that.groupId) && Objects.equals(description, that.description) && Objects.equals(groupName, that.groupName) && Objects.equals(parentGroupId, that.parentGroupId) && Objects.equals(useYn, that.useYn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupId, description, groupName, parentGroupId, useYn);
    }

    @Override
    public String toString() {
        return "GroupInfoDTO{" +
                "groupId='" + groupId + '\'' +
                ", description='" + description + '\'' +
                ", groupName='" + groupName + '\'' +
                ", parentGroupId='" + parentGroupId + '\'' +
                ", useYn='" + useYn + '\'' +
                '}';
    }
}
