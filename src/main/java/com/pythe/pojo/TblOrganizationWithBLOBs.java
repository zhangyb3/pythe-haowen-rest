package com.pythe.pojo;

public class TblOrganizationWithBLOBs extends TblOrganization {
    private String description;

    private String member;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member == null ? null : member.trim();
    }
}