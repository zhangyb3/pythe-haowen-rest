package com.pythe.pojo;

public class VTeacherStatisticsWithBLOBs extends VTeacherStatistics {
    private String popularity;

    private String collection;

    private String masterknowledge;

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity == null ? null : popularity.trim();
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection == null ? null : collection.trim();
    }

    public String getMasterknowledge() {
        return masterknowledge;
    }

    public void setMasterknowledge(String masterknowledge) {
        this.masterknowledge = masterknowledge == null ? null : masterknowledge.trim();
    }
}