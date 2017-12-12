package com.pythe.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TblAnswerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TblAnswerExample() {
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

        public Criteria andStudentidIsNull() {
            addCriterion("studentId is null");
            return (Criteria) this;
        }

        public Criteria andStudentidIsNotNull() {
            addCriterion("studentId is not null");
            return (Criteria) this;
        }

        public Criteria andStudentidEqualTo(Long value) {
            addCriterion("studentId =", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidNotEqualTo(Long value) {
            addCriterion("studentId <>", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidGreaterThan(Long value) {
            addCriterion("studentId >", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidGreaterThanOrEqualTo(Long value) {
            addCriterion("studentId >=", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidLessThan(Long value) {
            addCriterion("studentId <", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidLessThanOrEqualTo(Long value) {
            addCriterion("studentId <=", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidIn(List<Long> values) {
            addCriterion("studentId in", values, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidNotIn(List<Long> values) {
            addCriterion("studentId not in", values, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidBetween(Long value1, Long value2) {
            addCriterion("studentId between", value1, value2, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidNotBetween(Long value1, Long value2) {
            addCriterion("studentId not between", value1, value2, "studentid");
            return (Criteria) this;
        }

        public Criteria andTeacheridIsNull() {
            addCriterion("teacherId is null");
            return (Criteria) this;
        }

        public Criteria andTeacheridIsNotNull() {
            addCriterion("teacherId is not null");
            return (Criteria) this;
        }

        public Criteria andTeacheridEqualTo(Long value) {
            addCriterion("teacherId =", value, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridNotEqualTo(Long value) {
            addCriterion("teacherId <>", value, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridGreaterThan(Long value) {
            addCriterion("teacherId >", value, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridGreaterThanOrEqualTo(Long value) {
            addCriterion("teacherId >=", value, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridLessThan(Long value) {
            addCriterion("teacherId <", value, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridLessThanOrEqualTo(Long value) {
            addCriterion("teacherId <=", value, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridIn(List<Long> values) {
            addCriterion("teacherId in", values, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridNotIn(List<Long> values) {
            addCriterion("teacherId not in", values, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridBetween(Long value1, Long value2) {
            addCriterion("teacherId between", value1, value2, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridNotBetween(Long value1, Long value2) {
            addCriterion("teacherId not between", value1, value2, "teacherid");
            return (Criteria) this;
        }

        public Criteria andFeeIsNull() {
            addCriterion("fee is null");
            return (Criteria) this;
        }

        public Criteria andFeeIsNotNull() {
            addCriterion("fee is not null");
            return (Criteria) this;
        }

        public Criteria andFeeEqualTo(Double value) {
            addCriterion("fee =", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotEqualTo(Double value) {
            addCriterion("fee <>", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeGreaterThan(Double value) {
            addCriterion("fee >", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeGreaterThanOrEqualTo(Double value) {
            addCriterion("fee >=", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeLessThan(Double value) {
            addCriterion("fee <", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeLessThanOrEqualTo(Double value) {
            addCriterion("fee <=", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeIn(List<Double> values) {
            addCriterion("fee in", values, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotIn(List<Double> values) {
            addCriterion("fee not in", values, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeBetween(Double value1, Double value2) {
            addCriterion("fee between", value1, value2, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotBetween(Double value1, Double value2) {
            addCriterion("fee not between", value1, value2, "fee");
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

        public Criteria andAnswergradeIsNull() {
            addCriterion("answerGrade is null");
            return (Criteria) this;
        }

        public Criteria andAnswergradeIsNotNull() {
            addCriterion("answerGrade is not null");
            return (Criteria) this;
        }

        public Criteria andAnswergradeEqualTo(String value) {
            addCriterion("answerGrade =", value, "answergrade");
            return (Criteria) this;
        }

        public Criteria andAnswergradeNotEqualTo(String value) {
            addCriterion("answerGrade <>", value, "answergrade");
            return (Criteria) this;
        }

        public Criteria andAnswergradeGreaterThan(String value) {
            addCriterion("answerGrade >", value, "answergrade");
            return (Criteria) this;
        }

        public Criteria andAnswergradeGreaterThanOrEqualTo(String value) {
            addCriterion("answerGrade >=", value, "answergrade");
            return (Criteria) this;
        }

        public Criteria andAnswergradeLessThan(String value) {
            addCriterion("answerGrade <", value, "answergrade");
            return (Criteria) this;
        }

        public Criteria andAnswergradeLessThanOrEqualTo(String value) {
            addCriterion("answerGrade <=", value, "answergrade");
            return (Criteria) this;
        }

        public Criteria andAnswergradeLike(String value) {
            addCriterion("answerGrade like", value, "answergrade");
            return (Criteria) this;
        }

        public Criteria andAnswergradeNotLike(String value) {
            addCriterion("answerGrade not like", value, "answergrade");
            return (Criteria) this;
        }

        public Criteria andAnswergradeIn(List<String> values) {
            addCriterion("answerGrade in", values, "answergrade");
            return (Criteria) this;
        }

        public Criteria andAnswergradeNotIn(List<String> values) {
            addCriterion("answerGrade not in", values, "answergrade");
            return (Criteria) this;
        }

        public Criteria andAnswergradeBetween(String value1, String value2) {
            addCriterion("answerGrade between", value1, value2, "answergrade");
            return (Criteria) this;
        }

        public Criteria andAnswergradeNotBetween(String value1, String value2) {
            addCriterion("answerGrade not between", value1, value2, "answergrade");
            return (Criteria) this;
        }

        public Criteria andKnowledgeidIsNull() {
            addCriterion("knowledgeId is null");
            return (Criteria) this;
        }

        public Criteria andKnowledgeidIsNotNull() {
            addCriterion("knowledgeId is not null");
            return (Criteria) this;
        }

        public Criteria andKnowledgeidEqualTo(Long value) {
            addCriterion("knowledgeId =", value, "knowledgeid");
            return (Criteria) this;
        }

        public Criteria andKnowledgeidNotEqualTo(Long value) {
            addCriterion("knowledgeId <>", value, "knowledgeid");
            return (Criteria) this;
        }

        public Criteria andKnowledgeidGreaterThan(Long value) {
            addCriterion("knowledgeId >", value, "knowledgeid");
            return (Criteria) this;
        }

        public Criteria andKnowledgeidGreaterThanOrEqualTo(Long value) {
            addCriterion("knowledgeId >=", value, "knowledgeid");
            return (Criteria) this;
        }

        public Criteria andKnowledgeidLessThan(Long value) {
            addCriterion("knowledgeId <", value, "knowledgeid");
            return (Criteria) this;
        }

        public Criteria andKnowledgeidLessThanOrEqualTo(Long value) {
            addCriterion("knowledgeId <=", value, "knowledgeid");
            return (Criteria) this;
        }

        public Criteria andKnowledgeidIn(List<Long> values) {
            addCriterion("knowledgeId in", values, "knowledgeid");
            return (Criteria) this;
        }

        public Criteria andKnowledgeidNotIn(List<Long> values) {
            addCriterion("knowledgeId not in", values, "knowledgeid");
            return (Criteria) this;
        }

        public Criteria andKnowledgeidBetween(Long value1, Long value2) {
            addCriterion("knowledgeId between", value1, value2, "knowledgeid");
            return (Criteria) this;
        }

        public Criteria andKnowledgeidNotBetween(Long value1, Long value2) {
            addCriterion("knowledgeId not between", value1, value2, "knowledgeid");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("updatetime is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("updatetime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterion("updatetime =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterion("updatetime <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterion("updatetime >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updatetime >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterion("updatetime <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("updatetime <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterion("updatetime in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterion("updatetime not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("updatetime between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("updatetime not between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andAStatusIsNull() {
            addCriterion("a_status is null");
            return (Criteria) this;
        }

        public Criteria andAStatusIsNotNull() {
            addCriterion("a_status is not null");
            return (Criteria) this;
        }

        public Criteria andAStatusEqualTo(Integer value) {
            addCriterion("a_status =", value, "aStatus");
            return (Criteria) this;
        }

        public Criteria andAStatusNotEqualTo(Integer value) {
            addCriterion("a_status <>", value, "aStatus");
            return (Criteria) this;
        }

        public Criteria andAStatusGreaterThan(Integer value) {
            addCriterion("a_status >", value, "aStatus");
            return (Criteria) this;
        }

        public Criteria andAStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("a_status >=", value, "aStatus");
            return (Criteria) this;
        }

        public Criteria andAStatusLessThan(Integer value) {
            addCriterion("a_status <", value, "aStatus");
            return (Criteria) this;
        }

        public Criteria andAStatusLessThanOrEqualTo(Integer value) {
            addCriterion("a_status <=", value, "aStatus");
            return (Criteria) this;
        }

        public Criteria andAStatusIn(List<Integer> values) {
            addCriterion("a_status in", values, "aStatus");
            return (Criteria) this;
        }

        public Criteria andAStatusNotIn(List<Integer> values) {
            addCriterion("a_status not in", values, "aStatus");
            return (Criteria) this;
        }

        public Criteria andAStatusBetween(Integer value1, Integer value2) {
            addCriterion("a_status between", value1, value2, "aStatus");
            return (Criteria) this;
        }

        public Criteria andAStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("a_status not between", value1, value2, "aStatus");
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