package com.pythe.pojo;

public class TblUserWithBLOBs extends TblUser {
    private String description;

    private String collection;

    private String complaintlist;

    private String knowledgespace;

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

    public String getComplaintlist() {
        return complaintlist;
    }

    public void setComplaintlist(String complaintlist) {
        this.complaintlist = complaintlist == null ? null : complaintlist.trim();
    }

    public String getKnowledgespace() {
        return knowledgespace;
    }

    public void setKnowledgespace(String knowledgespace) {
        this.knowledgespace = knowledgespace == null ? null : knowledgespace.trim();
    }

    public String getMasterknowledge() {
        return masterknowledge;
    }

    public void setMasterknowledge(String masterknowledge) {
        this.masterknowledge = masterknowledge == null ? null : masterknowledge.trim();
    }
}