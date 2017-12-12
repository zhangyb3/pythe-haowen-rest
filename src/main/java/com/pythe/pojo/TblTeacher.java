package com.pythe.pojo;

public class TblTeacher {
    private Long teacherid;

    private Integer subjectid;

    private String masterknowledge;

    private Long popularity;

    private Long organization;

    private String decription;

    public Long getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Long teacherid) {
        this.teacherid = teacherid;
    }

    public Integer getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(Integer subjectid) {
        this.subjectid = subjectid;
    }

    public String getMasterknowledge() {
        return masterknowledge;
    }

    public void setMasterknowledge(String masterknowledge) {
        this.masterknowledge = masterknowledge == null ? null : masterknowledge.trim();
    }

    public Long getPopularity() {
        return popularity;
    }

    public void setPopularity(Long popularity) {
        this.popularity = popularity;
    }

    public Long getOrganization() {
        return organization;
    }

    public void setOrganization(Long organization) {
        this.organization = organization;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription == null ? null : decription.trim();
    }
}