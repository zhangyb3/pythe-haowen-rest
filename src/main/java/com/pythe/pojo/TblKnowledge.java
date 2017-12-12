package com.pythe.pojo;

public class TblKnowledge {
    private Long knowledgeid;

    private Integer gradeid;

    private String level1;

    private String level2;

    private String knowledge;

    private String similarity;

    private Integer subjectid;

    public Long getKnowledgeid() {
        return knowledgeid;
    }

    public void setKnowledgeid(Long knowledgeid) {
        this.knowledgeid = knowledgeid;
    }

    public Integer getGradeid() {
        return gradeid;
    }

    public void setGradeid(Integer gradeid) {
        this.gradeid = gradeid;
    }

    public String getLevel1() {
        return level1;
    }

    public void setLevel1(String level1) {
        this.level1 = level1 == null ? null : level1.trim();
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

    public String getSimilarity() {
        return similarity;
    }

    public void setSimilarity(String similarity) {
        this.similarity = similarity == null ? null : similarity.trim();
    }

    public Integer getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(Integer subjectid) {
        this.subjectid = subjectid;
    }
}