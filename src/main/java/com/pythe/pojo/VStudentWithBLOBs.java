package com.pythe.pojo;

public class VStudentWithBLOBs extends VStudent {
    private String description;

    private String collection;

    private String knowledgespace;

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

    public String getKnowledgespace() {
        return knowledgespace;
    }

    public void setKnowledgespace(String knowledgespace) {
        this.knowledgespace = knowledgespace == null ? null : knowledgespace.trim();
    }
}