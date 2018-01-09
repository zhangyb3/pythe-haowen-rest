package com.pythe.pojo;

public class VQuestionIsAnswersWithBLOBs extends VQuestionIsAnswers {
    private String questioncontent;

    private String answercontent;

    public String getQuestioncontent() {
        return questioncontent;
    }

    public void setQuestioncontent(String questioncontent) {
        this.questioncontent = questioncontent == null ? null : questioncontent.trim();
    }

    public String getAnswercontent() {
        return answercontent;
    }

    public void setAnswercontent(String answercontent) {
        this.answercontent = answercontent == null ? null : answercontent.trim();
    }
}