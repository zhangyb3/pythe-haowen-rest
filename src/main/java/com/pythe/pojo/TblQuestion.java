package com.pythe.pojo;

import java.util.Date;

public class TblQuestion {
    private Long questionid;

    private Integer status;

    private Long studentid;

    private Long teacherid;

    private Double reward;

    private Date starttime;

    private Date endtime;

    private Integer subjectid;

    private Integer counter;

    private String answered;

    private String usersSelected;

    private String questioncontent;

    public Long getQuestionid() {
        return questionid;
    }

    public void setQuestionid(Long questionid) {
        this.questionid = questionid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public Double getReward() {
        return reward;
    }

    public void setReward(Double reward) {
        this.reward = reward;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Integer getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(Integer subjectid) {
        this.subjectid = subjectid;
    }

    public Integer getCounter() {
        return counter;
    }

    public void setCounter(Integer counter) {
        this.counter = counter;
    }

    public String getAnswered() {
        return answered;
    }

    public void setAnswered(String answered) {
        this.answered = answered == null ? null : answered.trim();
    }

    public String getUsersSelected() {
        return usersSelected;
    }

    public void setUsersSelected(String usersSelected) {
        this.usersSelected = usersSelected == null ? null : usersSelected.trim();
    }

    public String getQuestioncontent() {
        return questioncontent;
    }

    public void setQuestioncontent(String questioncontent) {
        this.questioncontent = questioncontent == null ? null : questioncontent.trim();
    }
}