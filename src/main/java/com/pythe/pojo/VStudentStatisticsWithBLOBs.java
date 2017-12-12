package com.pythe.pojo;

public class VStudentStatisticsWithBLOBs extends VStudentStatistics {
    private String collection;

    private String knowledgespace;

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection == null ? null : collection.trim();
    }

    public String getKnowledgespace() {
        return knowledgespace;
    }

    public void setKnowledgespace(String knowledgespace) {
        this.knowledgespace = knowledgespace == null ? null : knowledgespace.trim();
    }
}