package com.pythe.pojo;

import java.util.Date;

public class TblAnswer {
    private Long answerid;

    private Long questionid;

    private Long studentid;

    private Long teacherid;

    private Double fee;

    private Double rewardnum;

    private Long likesnum;

    private Date answertime;

    private String answergrade;

    private Long knowledgeid;

    private Date updatetime;

    private Integer aStatus;

    private String answercontent;

    public Long getAnswerid() {
        return answerid;
    }

    public void setAnswerid(Long answerid) {
        this.answerid = answerid;
    }

    public Long getQuestionid() {
        return questionid;
    }

    public void setQuestionid(Long questionid) {
        this.questionid = questionid;
    }

    public Long getStudentid() {
        return studentid;
    }

    public void setStudentid(Long studentid) {
        this.studentid = studentid;
    }

    public Long getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Long teacherid) {
        this.teacherid = teacherid;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public Double getRewardnum() {
        return rewardnum;
    }

    public void setRewardnum(Double rewardnum) {
        this.rewardnum = rewardnum;
    }

    public Long getLikesnum() {
        return likesnum;
    }

    public void setLikesnum(Long likesnum) {
        this.likesnum = likesnum;
    }

    public Date getAnswertime() {
        return answertime;
    }

    public void setAnswertime(Date answertime) {
        this.answertime = answertime;
    }

    public String getAnswergrade() {
        return answergrade;
    }

    public void setAnswergrade(String answergrade) {
        this.answergrade = answergrade == null ? null : answergrade.trim();
    }

    public Long getKnowledgeid() {
        return knowledgeid;
    }

    public void setKnowledgeid(Long knowledgeid) {
        this.knowledgeid = knowledgeid;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Integer getaStatus() {
        return aStatus;
    }

    public void setaStatus(Integer aStatus) {
        this.aStatus = aStatus;
    }

    public String getAnswercontent() {
        return answercontent;
    }

    public void setAnswercontent(String answercontent) {
        this.answercontent = answercontent == null ? null : answercontent.trim();
    }
}