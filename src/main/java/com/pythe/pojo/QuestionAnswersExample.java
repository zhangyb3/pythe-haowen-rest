package com.pythe.pojo;

import java.util.ArrayList;
import java.util.List;

public class QuestionAnswersExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public QuestionAnswersExample() {
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

        public Criteria andQuestioncontentIsNull() {
            addCriterion("questionContent is null");
            return (Criteria) this;
        }

        public Criteria andQuestioncontentIsNotNull() {
            addCriterion("questionContent is not null");
            return (Criteria) this;
        }

        public Criteria andQuestioncontentEqualTo(String value) {
            addCriterion("questionContent =", value, "questioncontent");
            return (Criteria) this;
        }

        public Criteria andQuestioncontentNotEqualTo(String value) {
            addCriterion("questionContent <>", value, "questioncontent");
            return (Criteria) this;
        }

        public Criteria andQuestioncontentGreaterThan(String value) {
            addCriterion("questionContent >", value, "questioncontent");
            return (Criteria) this;
        }

        public Criteria andQuestioncontentGreaterThanOrEqualTo(String value) {
            addCriterion("questionContent >=", value, "questioncontent");
            return (Criteria) this;
        }

        public Criteria andQuestioncontentLessThan(String value) {
            addCriterion("questionContent <", value, "questioncontent");
            return (Criteria) this;
        }

        public Criteria andQuestioncontentLessThanOrEqualTo(String value) {
            addCriterion("questionContent <=", value, "questioncontent");
            return (Criteria) this;
        }

        public Criteria andQuestioncontentLike(String value) {
            addCriterion("questionContent like", value, "questioncontent");
            return (Criteria) this;
        }

        public Criteria andQuestioncontentNotLike(String value) {
            addCriterion("questionContent not like", value, "questioncontent");
            return (Criteria) this;
        }

        public Criteria andQuestioncontentIn(List<String> values) {
            addCriterion("questionContent in", values, "questioncontent");
            return (Criteria) this;
        }

        public Criteria andQuestioncontentNotIn(List<String> values) {
            addCriterion("questionContent not in", values, "questioncontent");
            return (Criteria) this;
        }

        public Criteria andQuestioncontentBetween(String value1, String value2) {
            addCriterion("questionContent between", value1, value2, "questioncontent");
            return (Criteria) this;
        }

        public Criteria andQuestioncontentNotBetween(String value1, String value2) {
            addCriterion("questionContent not between", value1, value2, "questioncontent");
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

        public Criteria andAnswercontentIsNull() {
            addCriterion("answerContent is null");
            return (Criteria) this;
        }

        public Criteria andAnswercontentIsNotNull() {
            addCriterion("answerContent is not null");
            return (Criteria) this;
        }

        public Criteria andAnswercontentEqualTo(String value) {
            addCriterion("answerContent =", value, "answercontent");
            return (Criteria) this;
        }

        public Criteria andAnswercontentNotEqualTo(String value) {
            addCriterion("answerContent <>", value, "answercontent");
            return (Criteria) this;
        }

        public Criteria andAnswercontentGreaterThan(String value) {
            addCriterion("answerContent >", value, "answercontent");
            return (Criteria) this;
        }

        public Criteria andAnswercontentGreaterThanOrEqualTo(String value) {
            addCriterion("answerContent >=", value, "answercontent");
            return (Criteria) this;
        }

        public Criteria andAnswercontentLessThan(String value) {
            addCriterion("answerContent <", value, "answercontent");
            return (Criteria) this;
        }

        public Criteria andAnswercontentLessThanOrEqualTo(String value) {
            addCriterion("answerContent <=", value, "answercontent");
            return (Criteria) this;
        }

        public Criteria andAnswercontentLike(String value) {
            addCriterion("answerContent like", value, "answercontent");
            return (Criteria) this;
        }

        public Criteria andAnswercontentNotLike(String value) {
            addCriterion("answerContent not like", value, "answercontent");
            return (Criteria) this;
        }

        public Criteria andAnswercontentIn(List<String> values) {
            addCriterion("answerContent in", values, "answercontent");
            return (Criteria) this;
        }

        public Criteria andAnswercontentNotIn(List<String> values) {
            addCriterion("answerContent not in", values, "answercontent");
            return (Criteria) this;
        }

        public Criteria andAnswercontentBetween(String value1, String value2) {
            addCriterion("answerContent between", value1, value2, "answercontent");
            return (Criteria) this;
        }

        public Criteria andAnswercontentNotBetween(String value1, String value2) {
            addCriterion("answerContent not between", value1, value2, "answercontent");
            return (Criteria) this;
        }

        public Criteria andQuestionTeacheridIsNull() {
            addCriterion("question_teacherId is null");
            return (Criteria) this;
        }

        public Criteria andQuestionTeacheridIsNotNull() {
            addCriterion("question_teacherId is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionTeacheridEqualTo(Long value) {
            addCriterion("question_teacherId =", value, "questionTeacherid");
            return (Criteria) this;
        }

        public Criteria andQuestionTeacheridNotEqualTo(Long value) {
            addCriterion("question_teacherId <>", value, "questionTeacherid");
            return (Criteria) this;
        }

        public Criteria andQuestionTeacheridGreaterThan(Long value) {
            addCriterion("question_teacherId >", value, "questionTeacherid");
            return (Criteria) this;
        }

        public Criteria andQuestionTeacheridGreaterThanOrEqualTo(Long value) {
            addCriterion("question_teacherId >=", value, "questionTeacherid");
            return (Criteria) this;
        }

        public Criteria andQuestionTeacheridLessThan(Long value) {
            addCriterion("question_teacherId <", value, "questionTeacherid");
            return (Criteria) this;
        }

        public Criteria andQuestionTeacheridLessThanOrEqualTo(Long value) {
            addCriterion("question_teacherId <=", value, "questionTeacherid");
            return (Criteria) this;
        }

        public Criteria andQuestionTeacheridIn(List<Long> values) {
            addCriterion("question_teacherId in", values, "questionTeacherid");
            return (Criteria) this;
        }

        public Criteria andQuestionTeacheridNotIn(List<Long> values) {
            addCriterion("question_teacherId not in", values, "questionTeacherid");
            return (Criteria) this;
        }

        public Criteria andQuestionTeacheridBetween(Long value1, Long value2) {
            addCriterion("question_teacherId between", value1, value2, "questionTeacherid");
            return (Criteria) this;
        }

        public Criteria andQuestionTeacheridNotBetween(Long value1, Long value2) {
            addCriterion("question_teacherId not between", value1, value2, "questionTeacherid");
            return (Criteria) this;
        }

        public Criteria andAnswerTeacheridIsNull() {
            addCriterion("answer_teacherId is null");
            return (Criteria) this;
        }

        public Criteria andAnswerTeacheridIsNotNull() {
            addCriterion("answer_teacherId is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerTeacheridEqualTo(Long value) {
            addCriterion("answer_teacherId =", value, "answerTeacherid");
            return (Criteria) this;
        }

        public Criteria andAnswerTeacheridNotEqualTo(Long value) {
            addCriterion("answer_teacherId <>", value, "answerTeacherid");
            return (Criteria) this;
        }

        public Criteria andAnswerTeacheridGreaterThan(Long value) {
            addCriterion("answer_teacherId >", value, "answerTeacherid");
            return (Criteria) this;
        }

        public Criteria andAnswerTeacheridGreaterThanOrEqualTo(Long value) {
            addCriterion("answer_teacherId >=", value, "answerTeacherid");
            return (Criteria) this;
        }

        public Criteria andAnswerTeacheridLessThan(Long value) {
            addCriterion("answer_teacherId <", value, "answerTeacherid");
            return (Criteria) this;
        }

        public Criteria andAnswerTeacheridLessThanOrEqualTo(Long value) {
            addCriterion("answer_teacherId <=", value, "answerTeacherid");
            return (Criteria) this;
        }

        public Criteria andAnswerTeacheridIn(List<Long> values) {
            addCriterion("answer_teacherId in", values, "answerTeacherid");
            return (Criteria) this;
        }

        public Criteria andAnswerTeacheridNotIn(List<Long> values) {
            addCriterion("answer_teacherId not in", values, "answerTeacherid");
            return (Criteria) this;
        }

        public Criteria andAnswerTeacheridBetween(Long value1, Long value2) {
            addCriterion("answer_teacherId between", value1, value2, "answerTeacherid");
            return (Criteria) this;
        }

        public Criteria andAnswerTeacheridNotBetween(Long value1, Long value2) {
            addCriterion("answer_teacherId not between", value1, value2, "answerTeacherid");
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