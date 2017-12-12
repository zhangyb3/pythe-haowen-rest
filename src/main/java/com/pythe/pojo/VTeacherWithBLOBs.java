package com.pythe.pojo;

public class VTeacherWithBLOBs extends VTeacher {
    private String description;

    private String collection;

    private String masterknowledge;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
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