package com.pythe.pojo;

import java.util.Date;

public class VHomepageList {
    private Long questionid;

    private Integer subjectid;

    private Double reward;

    private Date answertime;

    private Long answerid;

    private Long likesnum;

    private Long knowledgeid;

    private String level2;

    private String knowledge;

    private Long userid;

    private Integer gradeid;

    private String studentname;

    private String studentimg;

    private Double rewardnum;

    private String teacherimg;

    private String teachername;

    public Long getQuestionid() {
        return questionid;
    }

    public void setQuestionid(Long questionid) {
        this.questionid = questionid;
    }

    public Integer getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(Integer subjectid) {
        this.subjectid = subjectid;
    }

    public Double getReward() {
        return reward;
    }

    public void setReward(Double reward) {
        this.reward = reward;
    }

    public Date getAnswertime() {
        return answertime;
    }

    public void setAnswertime(Date answertime) {
        this.answertime = answertime;
    }

    public Long getAnswerid() {
        return answerid;
    }

    public void setAnswerid(Long answerid) {
        this.answerid = answerid;
    }

    public Long getLikesnum() {
        return likesnum;
    }

    public void setLikesnum(Long likesnum) {
        this.likesnum = likesnum;
    }

    public Long getKnowledgeid() {
        return knowledgeid;
    }

    public void setKnowledgeid(Long knowledgeid) {
        this.knowledgeid = knowledgeid;
    }

    public String getLevel2() {
        return level2;
    }

    public void setLevel2(String level2) {
        this.level2 = level2 == null ? null : level2.trim();
    }

    public String getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(String knowledge) {
        this.knowledge = knowledge == null ? null : knowledge.trim();
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Integer getGradeid() {
        return gradeid;
    }

    public void setGradeid(Integer gradeid) {
        this.gradeid = gradeid;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname == null ? null : studentname.trim();
    }

    public String getStudentimg() {
        return studentimg;
    }

    public void setStudentimg(String studentimg) {
        this.studentimg = studentimg == null ? null : studentimg.trim();
    }

    public Double getRewardnum() {
        return rewardnum;
    }

    public void setRewardnum(Double rewardnum) {
        this.rewardnum = rewardnum;
    }

    public String getTeacherimg() {
        return teacherimg;
    }

    public void setTeacherimg(String teacherimg) {
        this.teacherimg = teacherimg == null ? null : teacherimg.trim();
    }

    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername == null ? null : teachername.trim();
    }
}