package com.pythe.pojo;

public class VStudentStatistics {
    private Long studentid;

    private String favorite;

    private Double outcome;

    private String studentname;

    public Long getStudentid() {
        return studentid;
    }

    public void setStudentid(Long studentid) {
        this.studentid = studentid;
    }

    public String getFavorite() {
        return favorite;
    }

    public void setFavorite(String favorite) {
        this.favorite = favorite == null ? null : favorite.trim();
    }

    public Double getOutcome() {
        return outcome;
    }

    public void setOutcome(Double outcome) {
        this.outcome = outcome;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname == null ? null : studentname.trim();
    }
}