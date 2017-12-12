package com.pythe.pojo;

public class QuestionAnswers {
    private Long answerid;

    private Double rewardnum;

    private Long likesnum;

    private Long questionid;

    private String questioncontent;

    private Double reward;

    private Double fee;

    private String answercontent;

    private Long questionTeacherid;

    private Long answerTeacherid;

    public Long getAnswerid() {
        return answerid;
    }

    public void setAnswerid(Long answerid) {
        this.answerid = answerid;
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

    public Long getQuestionid() {
        return questionid;
    }

    public void setQuestionid(Long questionid) {
        this.questionid = questionid;
    }

    public String getQuestioncontent() {
        return questioncontent;
    }

    public void setQuestioncontent(String questioncontent) {
        this.questioncontent = questioncontent == null ? null : questioncontent.trim();
    }

    public Double getReward() {
        return reward;
    }

    public void setReward(Double reward) {
        this.reward = reward;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public String getAnswercontent() {
        return answercontent;
    }

    public void setAnswercontent(String answercontent) {
        this.answercontent = answercontent == null ? null : answercontent.trim();
    }

    public Long getQuestionTeacherid() {
        return questionTeacherid;
    }

    public void setQuestionTeacherid(Long questionTeacherid) {
        this.questionTeacherid = questionTeacherid;
    }

    public Long getAnswerTeacherid() {
        return answerTeacherid;
    }

    public void setAnswerTeacherid(Long answerTeacherid) {
        this.answerTeacherid = answerTeacherid;
    }
}