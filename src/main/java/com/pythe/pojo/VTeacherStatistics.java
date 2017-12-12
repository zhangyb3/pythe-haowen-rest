package com.pythe.pojo;

public class VTeacherStatistics {
    private Long teacherid;

    private Double income;

    private String teachername;

    public Long getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Long teacherid) {
        this.teacherid = teacherid;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername == null ? null : teachername.trim();
    }
}