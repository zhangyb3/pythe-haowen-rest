package com.pythe.pojo;

import java.util.ArrayList;
import java.util.List;

public class TblTeacherExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TblTeacherExample() {
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

        public Criteria andMasterknowledgeIsNull() {
            addCriterion("masterKnowledge is null");
            return (Criteria) this;
        }

        public Criteria andMasterknowledgeIsNotNull() {
            addCriterion("masterKnowledge is not null");
            return (Criteria) this;
        }

        public Criteria andMasterknowledgeEqualTo(String value) {
            addCriterion("masterKnowledge =", value, "masterknowledge");
            return (Criteria) this;
        }

        public Criteria andMasterknowledgeNotEqualTo(String value) {
            addCriterion("masterKnowledge <>", value, "masterknowledge");
            return (Criteria) this;
        }

        public Criteria andMasterknowledgeGreaterThan(String value) {
            addCriterion("masterKnowledge >", value, "masterknowledge");
            return (Criteria) this;
        }

        public Criteria andMasterknowledgeGreaterThanOrEqualTo(String value) {
            addCriterion("masterKnowledge >=", value, "masterknowledge");
            return (Criteria) this;
        }

        public Criteria andMasterknowledgeLessThan(String value) {
            addCriterion("masterKnowledge <", value, "masterknowledge");
            return (Criteria) this;
        }

        public Criteria andMasterknowledgeLessThanOrEqualTo(String value) {
            addCriterion("masterKnowledge <=", value, "masterknowledge");
            return (Criteria) this;
        }

        public Criteria andMasterknowledgeLike(String value) {
            addCriterion("masterKnowledge like", value, "masterknowledge");
            return (Criteria) this;
        }

        public Criteria andMasterknowledgeNotLike(String value) {
            addCriterion("masterKnowledge not like", value, "masterknowledge");
            return (Criteria) this;
        }

        public Criteria andMasterknowledgeIn(List<String> values) {
            addCriterion("masterKnowledge in", values, "masterknowledge");
            return (Criteria) this;
        }

        public Criteria andMasterknowledgeNotIn(List<String> values) {
            addCriterion("masterKnowledge not in", values, "masterknowledge");
            return (Criteria) this;
        }

        public Criteria andMasterknowledgeBetween(String value1, String value2) {
            addCriterion("masterKnowledge between", value1, value2, "masterknowledge");
            return (Criteria) this;
        }

        public Criteria andMasterknowledgeNotBetween(String value1, String value2) {
            addCriterion("masterKnowledge not between", value1, value2, "masterknowledge");
            return (Criteria) this;
        }

        public Criteria andPopularityIsNull() {
            addCriterion("popularity is null");
            return (Criteria) this;
        }

        public Criteria andPopularityIsNotNull() {
            addCriterion("popularity is not null");
            return (Criteria) this;
        }

        public Criteria andPopularityEqualTo(Long value) {
            addCriterion("popularity =", value, "popularity");
            return (Criteria) this;
        }

        public Criteria andPopularityNotEqualTo(Long value) {
            addCriterion("popularity <>", value, "popularity");
            return (Criteria) this;
        }

        public Criteria andPopularityGreaterThan(Long value) {
            addCriterion("popularity >", value, "popularity");
            return (Criteria) this;
        }

        public Criteria andPopularityGreaterThanOrEqualTo(Long value) {
            addCriterion("popularity >=", value, "popularity");
            return (Criteria) this;
        }

        public Criteria andPopularityLessThan(Long value) {
            addCriterion("popularity <", value, "popularity");
            return (Criteria) this;
        }

        public Criteria andPopularityLessThanOrEqualTo(Long value) {
            addCriterion("popularity <=", value, "popularity");
            return (Criteria) this;
        }

        public Criteria andPopularityIn(List<Long> values) {
            addCriterion("popularity in", values, "popularity");
            return (Criteria) this;
        }

        public Criteria andPopularityNotIn(List<Long> values) {
            addCriterion("popularity not in", values, "popularity");
            return (Criteria) this;
        }

        public Criteria andPopularityBetween(Long value1, Long value2) {
            addCriterion("popularity between", value1, value2, "popularity");
            return (Criteria) this;
        }

        public Criteria andPopularityNotBetween(Long value1, Long value2) {
            addCriterion("popularity not between", value1, value2, "popularity");
            return (Criteria) this;
        }

        public Criteria andOrganizationIsNull() {
            addCriterion("organization is null");
            return (Criteria) this;
        }

        public Criteria andOrganizationIsNotNull() {
            addCriterion("organization is not null");
            return (Criteria) this;
        }

        public Criteria andOrganizationEqualTo(Long value) {
            addCriterion("organization =", value, "organization");
            return (Criteria) this;
        }

        public Criteria andOrganizationNotEqualTo(Long value) {
            addCriterion("organization <>", value, "organization");
            return (Criteria) this;
        }

        public Criteria andOrganizationGreaterThan(Long value) {
            addCriterion("organization >", value, "organization");
            return (Criteria) this;
        }

        public Criteria andOrganizationGreaterThanOrEqualTo(Long value) {
            addCriterion("organization >=", value, "organization");
            return (Criteria) this;
        }

        public Criteria andOrganizationLessThan(Long value) {
            addCriterion("organization <", value, "organization");
            return (Criteria) this;
        }

        public Criteria andOrganizationLessThanOrEqualTo(Long value) {
            addCriterion("organization <=", value, "organization");
            return (Criteria) this;
        }

        public Criteria andOrganizationIn(List<Long> values) {
            addCriterion("organization in", values, "organization");
            return (Criteria) this;
        }

        public Criteria andOrganizationNotIn(List<Long> values) {
            addCriterion("organization not in", values, "organization");
            return (Criteria) this;
        }

        public Criteria andOrganizationBetween(Long value1, Long value2) {
            addCriterion("organization between", value1, value2, "organization");
            return (Criteria) this;
        }

        public Criteria andOrganizationNotBetween(Long value1, Long value2) {
            addCriterion("organization not between", value1, value2, "organization");
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