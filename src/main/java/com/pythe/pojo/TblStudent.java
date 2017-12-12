package com.pythe.pojo;

public class TblStudent {
    private Long studentid;

    private String description;

    private String mathspace;

    public Long getStudentid() {
        return studentid;
    }

    public void setStudentid(Long studentid) {
        this.studentid = studentid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getMathspace() {
        return mathspace;
    }

    public void setMathspace(String mathspace) {
        this.mathspace = mathspace == null ? null : mathspace.trim();
    }
}