package com.pythe.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VHomepageListExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VHomepageListExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andQuestionidIsNull() {
            addCriterion("questionId is null");
            return (Criteria) this;
        }

        public Criteria andQuestionidIsNotNull() {
            addCriterion("questionId is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionidEqualTo(Long value) {
            addCriterion("questionId =", value, "questionid");
            return (Criteria) this;
        }

        public Criteria andQuestionidNotEqualTo(Long value) {
            addCriterion("questionId <>", value, "questionid");
            return (Criteria) this;
        }

        public Criteria andQuestionidGreaterThan(Long value) {
            addCriterion("questionId >", value, "questionid");
            return (Criteria) this;
        }

        public Criteria andQuestionidGreaterThanOrEqualTo(Long value) {
            addCriterion("questionId >=", value, "questionid");
            return (Criteria) this;
        }

        public Criteria andQuestionidLessThan(Long value) {
            addCriterion("questionId <", value, "questionid");
            return (Criteria) this;
        }

        public Criteria andQuestionidLessThanOrEqualTo(Long value) {
            addCriterion("questionId <=", value, "questionid");
            return (Criteria) this;
        }

        public Criteria andQuestionidIn(List<Long> values) {
            addCriterion("questionId in", values, "questionid");
            return (Criteria) this;
        }

        public Criteria andQuestionidNotIn(List<Long> values) {
            addCriterion("questionId not in", values, "questionid");
            return (Criteria) this;
        }

        public Criteria andQuestionidBetween(Long value1, Long value2) {
            addCriterion("questionId between", value1, value2, "questionid");
            return (Criteria) this;
        }

        public Criteria andQuestionidNotBetween(Long value1, Long value2) {
            addCriterion("questionId not between", value1, value2, "questionid");
            return (Criteria) this;
        }

        public Criteria andSubjectidIsNull() {
            addCriterion("subjectId is null");
            return (Criteria) this;
        }

        public Criteria andSubjectidIsNotNull() {
            addCriterion("subjectId is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectidEqualTo(Integer value) {
            addCriterion("subjectId =", value, "subjectid");
            return (Criteria) this;
        }

        public Criteria andSubjectidNotEqualTo(Integer value) {
            addCriterion("subjectId <>", value, "subjectid");
            return (Criteria) this;
        }

        public Criteria andSubjectidGreaterThan(Integer value) {
            addCriterion("subjectId >", value, "subjectid");
            return (Criteria) this;
        }

        public Criteria andSubjectidGreaterThanOrEqualTo(Integer value) {
            addCriterion("subjectId >=", value, "subjectid");
            return (Criteria) this;
        }

        public Criteria andSubjectidLessThan(Integer value) {
            addCriterion("subjectId <", value, "subjectid");
            return (Criteria) this;
        }

        public Criteria andSubjectidLessThanOrEqualTo(Integer value) {
            addCriterion("subjectId <=", value, "subjectid");
            return (Criteria) this;
        }

        public Criteria andSubjectidIn(List<Integer> values) {
            addCriterion("subjectId in", values, "subjectid");
            return (Criteria) this;
        }

        public Criteria andSubjectidNotIn(List<Integer> values) {
            addCriterion("subjectId not in", values, "subjectid");
            return (Criteria) this;
        }

        public Criteria andSubjectidBetween(Integer value1, Integer value2) {
            addCriterion("subjectId between", value1, value2, "subjectid");
            return (Criteria) this;
        }

        public Criteria andSubjectidNotBetween(Integer value1, Integer value2) {
            addCriterion("subjectId not between", value1, value2, "subjectid");
            return (Criteria) this;
        }

        public Criteria andRewardIsNull() {
            addCriterion("reward is null");
            return (Criteria) this;
        }

        public Criteria andRewardIsNotNull() {
            addCriterion("reward is not null");
            return (Criteria) this;
        }

        public Criteria andRewardEqualTo(Double value) {
            addCriterion("reward =", value, "reward");
            return (Criteria) this;
        }

        public Criteria andRewardNotEqualTo(Double value) {
            addCriterion("reward <>", value, "reward");
            return (Criteria) this;
        }

        public Criteria andRewardGreaterThan(Double value) {
            addCriterion("reward >", value, "reward");
            return (Criteria) this;
        }

        public Criteria andRewardGreaterThanOrEqualTo(Double value) {
            addCriterion("reward >=", value, "reward");
            return (Criteria) this;
        }

        public Criteria andRewardLessThan(Double value) {
            addCriterion("reward <", value, "reward");
            return (Criteria) this;
        }

        public Criteria andRewardLessThanOrEqualTo(Double value) {
            addCriterion("reward <=", value, "reward");
            return (Criteria) this;
        }

        public Criteria andRewardIn(List<Double> values) {
            addCriterion("reward in", values, "reward");
            return (Criteria) this;
        }

        public Criteria andRewardNotIn(List<Double> values) {
            addCriterion("reward not in", values, "reward");
            return (Criteria) this;
        }

        public Criteria andRewardBetween(Double value1, Double value2) {
            addCriterion("reward between", value1, value2, "reward");
            return (Criteria) this;
        }

        public Criteria andRewardNotBetween(Double value1, Double value2) {
            addCriterion("reward not between", value1, value2, "reward");
            return (Criteria) this;
        }

        public Criteria andAnswertimeIsNull() {
            addCriterion("answerTime is null");
            return (Criteria) this;
        }

        public Criteria andAnswertimeIsNotNull() {
            addCriterion("answerTime is not null");
            return (Criteria) this;
        }

        public Criteria andAnswertimeEqualTo(Date value) {
            addCriterion("answerTime =", value, "answertime");
            return (Criteria) this;
        }

        public Criteria andAnswertimeNotEqualTo(Date value) {
            addCriterion("answerTime <>", value, "answertime");
            return (Criteria) this;
        }

        public Criteria andAnswertimeGreaterThan(Date value) {
            addCriterion("answerTime >", value, "answertime");
            return (Criteria) this;
        }

        public Criteria andAnswertimeGreaterThanOrEqualTo(Date value) {
            addCriterion("answerTime >=", value, "answertime");
            return (Criteria) this;
        }

        public Criteria andAnswertimeLessThan(Date value) {
            addCriterion("answerTime <", value, "answertime");
            return (Criteria) this;
        }

        public Criteria andAnswertimeLessThanOrEqualTo(Date value) {
            addCriterion("answerTime <=", value, "answertime");
            return (Criteria) this;
        }

        public Criteria andAnswertimeIn(List<Date> values) {
            addCriterion("answerTime in", values, "answertime");
            return (Criteria) this;
        }

        public Criteria andAnswertimeNotIn(List<Date> values) {
            addCriterion("answerTime not in", values, "answertime");
            return (Criteria) this;
        }

        public Criteria andAnswertimeBetween(Date value1, Date value2) {
            addCriterion("answerTime between", value1, value2, "answertime");
            return (Criteria) this;
        }

        public Criteria andAnswertimeNotBetween(Date value1, Date value2) {
            addCriterion("answerTime not between", value1, value2, "answertime");
            return (Criteria) this;
        }

        public Criteria andAnsweridIsNull() {
            addCriterion("answerId is null");
            return (Criteria) this;
        }

        public Criteria andAnsweridIsNotNull() {
            addCriterion("answerId is not null");
            return (Criteria) this;
        }

        public Criteria andAnsweridEqualTo(Long value) {
            addCriterion("answerId =", value, "answerid");
            return (Criteria) this;
        }

        public Criteria andAnsweridNotEqualTo(Long value) {
            addCriterion("answerId <>", value, "answerid");
            return (Criteria) this;
        }

        public Criteria andAnsweridGreaterThan(Long value) {
            addCriterion("answerId >", value, "answerid");
            return (Criteria) this;
        }

        public Criteria andAnsweridGreaterThanOrEqualTo(Long value) {
            addCriterion("answerId >=", value, "answerid");
            return (Criteria) this;
        }

        public Criteria andAnsweridLessThan(Long value) {
            addCriterion("answerId <", value, "answerid");
            return (Criteria) this;
        }

        public Criteria andAnsweridLessThanOrEqualTo(Long value) {
            addCriterion("answerId <=", value, "answerid");
            return (Criteria) this;
        }

        public Criteria andAnsweridIn(List<Long> values) {
            addCriterion("answerId in", values, "answerid");
            return (Criteria) this;
        }

        public Criteria andAnsweridNotIn(List<Long> values) {
            addCriterion("answerId not in", values, "answerid");
            return (Criteria) this;
        }

        public Criteria andAnsweridBetween(Long value1, Long value2) {
            addCriterion("answerId between", value1, value2, "answerid");
            return (Criteria) this;
        }

        public Criteria andAnsweridNotBetween(Long value1, Long value2) {
            addCriterion("answerId not between", value1, value2, "answerid");
            return (Criteria) this;
        }

        public Criteria andLikesnumIsNull() {
            addCriterion("likesNum is null");
            return (Criteria) this;
        }

        public Criteria andLikesnumIsNotNull() {
            addCriterion("likesNum is not null");
            return (Criteria) this;
        }

        public Criteria andLikesnumEqualTo(Long value) {
            addCriterion("likesNum =", value, "likesnum");
            return (Criteria) this;
        }

        public Criteria andLikesnumNotEqualTo(Long value) {
            addCriterion("likesNum <>", value, "likesnum");
            return (Criteria) this;
        }

        public Criteria andLikesnumGreaterThan(Long value) {
            addCriterion("likesNum >", value, "likesnum");
            return (Criteria) this;
        }

        public Criteria andLikesnumGreaterThanOrEqualTo(Long value) {
            addCriterion("likesNum >=", value, "likesnum");
            return (Criteria) this;
        }

        public Criteria andLikesnumLessThan(Long value) {
            addCriterion("likesNum <", value, "likesnum");
            return (Criteria) this;
        }

        public Criteria andLikesnumLessThanOrEqualTo(Long value) {
            addCriterion("likesNum <=", value, "likesnum");
            return (Criteria) this;
        }

        public Criteria andLikesnumIn(List<Long> values) {
            addCriterion("likesNum in", values, "likesnum");
            return (Criteria) this;
        }

        public Criteria andLikesnumNotIn(List<Long> values) {
            addCriterion("likesNum not in", values, "likesnum");
            return (Criteria) this;
        }

        public Criteria andLikesnumBetween(Long value1, Long value2) {
            addCriterion("likesNum between", value1, value2, "likesnum");
            return (Criteria) this;
        }

        public Criteria andLikesnumNotBetween(Long value1, Long value2) {
            addCriterion("likesNum not between", value1, value2, "likesnum");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userId is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userId is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Long value) {
            addCriterion("userId =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Long value) {
            addCriterion("userId <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Long value) {
            addCriterion("userId >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Long value) {
            addCriterion("userId >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Long value) {
            addCriterion("userId <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Long value) {
            addCriterion("userId <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Long> values) {
            addCriterion("userId in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Long> values) {
            addCriterion("userId not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Long value1, Long value2) {
            addCriterion("userId between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Long value1, Long value2) {
            addCriterion("userId not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andGradeidIsNull() {
            addCriterion("gradeId is null");
            return (Criteria) this;
        }

        public Criteria andGradeidIsNotNull() {
            addCriterion("gradeId is not null");
            return (Criteria) this;
        }

        public Criteria andGradeidEqualTo(Integer value) {
            addCriterion("gradeId =", value, "gradeid");
            return (Criteria) this;
        }

        public Criteria andGradeidNotEqualTo(Integer value) {
            addCriterion("gradeId <>", value, "gradeid");
            return (Criteria) this;
        }

        public Criteria andGradeidGreaterThan(Integer value) {
            addCriterion("gradeId >", value, "gradeid");
            return (Criteria) this;
        }

        public Criteria andGradeidGreaterThanOrEqualTo(Integer value) {
            addCriterion("gradeId >=", value, "gradeid");
            return (Criteria) this;
        }

        public Criteria andGradeidLessThan(Integer value) {
            addCriterion("gradeId <", value, "gradeid");
            return (Criteria) this;
        }

        public Criteria andGradeidLessThanOrEqualTo(Integer value) {
            addCriterion("gradeId <=", value, "gradeid");
            return (Criteria) this;
        }

        public Criteria andGradeidIn(List<Integer> values) {
            addCriterion("gradeId in", values, "gradeid");
            return (Criteria) this;
        }

        public Criteria andGradeidNotIn(List<Integer> values) {
            addCriterion("gradeId not in", values, "gradeid");
            return (Criteria) this;
        }

        public Criteria andGradeidBetween(Integer value1, Integer value2) {
            addCriterion("gradeId between", value1, value2, "gradeid");
            return (Criteria) this;
        }

        public Criteria andGradeidNotBetween(Integer value1, Integer value2) {
            addCriterion("gradeId not between", value1, value2, "gradeid");
            return (Criteria) this;
        }

        public Criteria andStudentnameIsNull() {
            addCriterion("studentName is null");
            return (Criteria) this;
        }

        public Criteria andStudentnameIsNotNull() {
            addCriterion("studentName is not null");
            return (Criteria) this;
        }

        public Criteria andStudentnameEqualTo(String value) {
            addCriterion("studentName =", value, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameNotEqualTo(String value) {
            addCriterion("studentName <>", value, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameGreaterThan(String value) {
            addCriterion("studentName >", value, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameGreaterThanOrEqualTo(String value) {
            addCriterion("studentName >=", value, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameLessThan(String value) {
            addCriterion("studentName <", value, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameLessThanOrEqualTo(String value) {
            addCriterion("studentName <=", value, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameLike(String value) {
            addCriterion("studentName like", value, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameNotLike(String value) {
            addCriterion("studentName not like", value, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameIn(List<String> values) {
            addCriterion("studentName in", values, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameNotIn(List<String> values) {
            addCriterion("studentName not in", values, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameBetween(String value1, String value2) {
            addCriterion("studentName between", value1, value2, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameNotBetween(String value1, String value2) {
            addCriterion("studentName not between", value1, value2, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentimgIsNull() {
            addCriterion("studentImg is null");
            return (Criteria) this;
        }

        public Criteria andStudentimgIsNotNull() {
            addCriterion("studentImg is not null");
            return (Criteria) this;
        }

        public Criteria andStudentimgEqualTo(String value) {
            addCriterion("studentImg =", value, "studentimg");
            return (Criteria) this;
        }

        public Criteria andStudentimgNotEqualTo(String value) {
            addCriterion("studentImg <>", value, "studentimg");
            return (Criteria) this;
        }

        public Criteria andStudentimgGreaterThan(String value) {
            addCriterion("studentImg >", value, "studentimg");
            return (Criteria) this;
        }

        public Criteria andStudentimgGreaterThanOrEqualTo(String value) {
            addCriterion("studentImg >=", value, "studentimg");
            return (Criteria) this;
        }

        public Criteria andStudentimgLessThan(String value) {
            addCriterion("studentImg <", value, "studentimg");
            return (Criteria) this;
        }

        public Criteria andStudentimgLessThanOrEqualTo(String value) {
            addCriterion("studentImg <=", value, "studentimg");
            return (Criteria) this;
        }

        public Criteria andStudentimgLike(String value) {
            addCriterion("studentImg like", value, "studentimg");
            return (Criteria) this;
        }

        public Criteria andStudentimgNotLike(String value) {
            addCriterion("studentImg not like", value, "studentimg");
            return (Criteria) this;
        }

        public Criteria andStudentimgIn(List<String> values) {
            addCriterion("studentImg in", values, "studentimg");
            return (Criteria) this;
        }

        public Criteria andStudentimgNotIn(List<String> values) {
            addCriterion("studentImg not in", values, "studentimg");
            return (Criteria) this;
        }

        public Criteria andStudentimgBetween(String value1, String value2) {
            addCriterion("studentImg between", value1, value2, "studentimg");
            return (Criteria) this;
        }

        public Criteria andStudentimgNotBetween(String value1, String value2) {
            addCriterion("studentImg not between", value1, value2, "studentimg");
            return (Criteria) this;
        }

        public Criteria andRewardnumIsNull() {
            addCriterion("rewardNum is null");
            return (Criteria) this;
        }

        public Criteria andRewardnumIsNotNull() {
            addCriterion("rewardNum is not null");
            return (Criteria) this;
        }

        public Criteria andRewardnumEqualTo(Double value) {
            addCriterion("rewardNum =", value, "rewardnum");
            return (Criteria) this;
        }

        public Criteria andRewardnumNotEqualTo(Double value) {
            addCriterion("rewardNum <>", value, "rewardnum");
            return (Criteria) this;
        }

        public Criteria andRewardnumGreaterThan(Double value) {
            addCriterion("rewardNum >", value, "rewardnum");
            return (Criteria) this;
        }

        public Criteria andRewardnumGreaterThanOrEqualTo(Double value) {
            addCriterion("rewardNum >=", value, "rewardnum");
            return (Criteria) this;
        }

        public Criteria andRewardnumLessThan(Double value) {
            addCriterion("rewardNum <", value, "rewardnum");
            return (Criteria) this;
        }

        public Criteria andRewardnumLessThanOrEqualTo(Double value) {
            addCriterion("rewardNum <=", value, "rewardnum");
            return (Criteria) this;
        }

        public Criteria andRewardnumIn(List<Double> values) {
            addCriterion("rewardNum in", values, "rewardnum");
            return (Criteria) this;
        }

        public Criteria andRewardnumNotIn(List<Double> values) {
            addCriterion("rewardNum not in", values, "rewardnum");
            return (Criteria) this;
        }

        public Criteria andRewardnumBetween(Double value1, Double value2) {
            addCriterion("rewardNum between", value1, value2, "rewardnum");
            return (Criteria) this;
        }

        public Criteria andRewardnumNotBetween(Double value1, Double value2) {
            addCriterion("rewardNum not between", value1, value2, "rewardnum");
            return (Criteria) this;
        }

        public Criteria andTeacherimgIsNull() {
            addCriterion("teacherImg is null");
            return (Criteria) this;
        }

        public Criteria andTeacherimgIsNotNull() {
            addCriterion("teacherImg is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherimgEqualTo(String value) {
            addCriterion("teacherImg =", value, "teacherimg");
            return (Criteria) this;
        }

        public Criteria andTeacherimgNotEqualTo(String value) {
            addCriterion("teacherImg <>", value, "teacherimg");
            return (Criteria) this;
        }

        public Criteria andTeacherimgGreaterThan(String value) {
            addCriterion("teacherImg >", value, "teacherimg");
            return (Criteria) this;
        }

        public Criteria andTeacherimgGreaterThanOrEqualTo(String value) {
            addCriterion("teacherImg >=", value, "teacherimg");
            return (Criteria) this;
        }

        public Criteria andTeacherimgLessThan(String value) {
            addCriterion("teacherImg <", value, "teacherimg");
            return (Criteria) this;
        }

        public Criteria andTeacherimgLessThanOrEqualTo(String value) {
            addCriterion("teacherImg <=", value, "teacherimg");
            return (Criteria) this;
        }

        public Criteria andTeacherimgLike(String value) {
            addCriterion("teacherImg like", value, "teacherimg");
            return (Criteria) this;
        }

        public Criteria andTeacherimgNotLike(String value) {
            addCriterion("teacherImg not like", value, "teacherimg");
            return (Criteria) this;
        }

        public Criteria andTeacherimgIn(List<String> values) {
            addCriterion("teacherImg in", values, "teacherimg");
            return (Criteria) this;
        }

        public Criteria andTeacherimgNotIn(List<String> values) {
            addCriterion("teacherImg not in", values, "teacherimg");
            return (Criteria) this;
        }

        public Criteria andTeacherimgBetween(String value1, String value2) {
            addCriterion("teacherImg between", value1, value2, "teacherimg");
            return (Criteria) this;
        }

        public Criteria andTeacherimgNotBetween(String value1, String value2) {
            addCriterion("teacherImg not between", value1, value2, "teacherimg");
            return (Criteria) this;
        }

        public Criteria andTeachernameIsNull() {
            addCriterion("teacherName is null");
            return (Criteria) this;
        }

        public Criteria andTeachernameIsNotNull() {
            addCriterion("teacherName is not null");
            return (Criteria) this;
        }

        public Criteria andTeachernameEqualTo(String value) {
            addCriterion("teacherName =", value, "teachername");
            return (Criteria) this;
        }

        public Criteria andTeachernameNotEqualTo(String value) {
            addCriterion("teacherName <>", value, "teachername");
            return (Criteria) this;
        }

        public Criteria andTeachernameGreaterThan(String value) {
            addCriterion("teacherName >", value, "teachername");
            return (Criteria) this;
        }

        public Criteria andTeachernameGreaterThanOrEqualTo(String value) {
            addCriterion("teacherName >=", value, "teachername");
            return (Criteria) this;
        }

        public Criteria andTeachernameLessThan(String value) {
            addCriterion("teacherName <", value, "teachername");
            return (Criteria) this;
        }

        public Criteria andTeachernameLessThanOrEqualTo(String value) {
            addCriterion("teacherName <=", value, "teachername");
            return (Criteria) this;
        }

        public Criteria andTeachernameLike(String value) {
            addCriterion("teacherName like", value, "teachername");
            return (Criteria) this;
        }

        public Criteria andTeachernameNotLike(String value) {
            addCriterion("teacherName not like", value, "teachername");
            return (Criteria) this;
        }

        public Criteria andTeachernameIn(List<String> values) {
            addCriterion("teacherName in", values, "teachername");
            return (Criteria) this;
        }

        public Criteria andTeachernameNotIn(List<String> values) {
            addCriterion("teacherName not in", values, "teachername");
            return (Criteria) this;
        }

        public Criteria andTeachernameBetween(String value1, String value2) {
            addCriterion("teacherName between", value1, value2, "teachername");
            return (Criteria) this;
        }

        public Criteria andTeachernameNotBetween(String value1, String value2) {
            addCriterion("teacherName not between", value1, value2, "teachername");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}