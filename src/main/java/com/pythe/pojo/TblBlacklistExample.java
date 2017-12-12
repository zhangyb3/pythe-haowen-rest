package com.pythe.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TblBlacklistExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TblBlacklistExample() {
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

        public Criteria andBlacklistidIsNull() {
            addCriterion("blacklistId is null");
            return (Criteria) this;
        }

        public Criteria andBlacklistidIsNotNull() {
            addCriterion("blacklistId is not null");
            return (Criteria) this;
        }

        public Criteria andBlacklistidEqualTo(Long value) {
            addCriterion("blacklistId =", value, "blacklistid");
            return (Criteria) this;
        }

        public Criteria andBlacklistidNotEqualTo(Long value) {
            addCriterion("blacklistId <>", value, "blacklistid");
            return (Criteria) this;
        }

        public Criteria andBlacklistidGreaterThan(Long value) {
            addCriterion("blacklistId >", value, "blacklistid");
            return (Criteria) this;
        }

        public Criteria andBlacklistidGreaterThanOrEqualTo(Long value) {
            addCriterion("blacklistId >=", value, "blacklistid");
            return (Criteria) this;
        }

        public Criteria andBlacklistidLessThan(Long value) {
            addCriterion("blacklistId <", value, "blacklistid");
            return (Criteria) this;
        }

        public Criteria andBlacklistidLessThanOrEqualTo(Long value) {
            addCriterion("blacklistId <=", value, "blacklistid");
            return (Criteria) this;
        }

        public Criteria andBlacklistidIn(List<Long> values) {
            addCriterion("blacklistId in", values, "blacklistid");
            return (Criteria) this;
        }

        public Criteria andBlacklistidNotIn(List<Long> values) {
            addCriterion("blacklistId not in", values, "blacklistid");
            return (Criteria) this;
        }

        public Criteria andBlacklistidBetween(Long value1, Long value2) {
            addCriterion("blacklistId between", value1, value2, "blacklistid");
            return (Criteria) this;
        }

        public Criteria andBlacklistidNotBetween(Long value1, Long value2) {
            addCriterion("blacklistId not between", value1, value2, "blacklistid");
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

        public Criteria andStarttimeIsNull() {
            addCriterion("startTime is null");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNotNull() {
            addCriterion("startTime is not null");
            return (Criteria) this;
        }

        public Criteria andStarttimeEqualTo(Date value) {
            addCriterion("startTime =", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotEqualTo(Date value) {
            addCriterion("startTime <>", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThan(Date value) {
            addCriterion("startTime >", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("startTime >=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThan(Date value) {
            addCriterion("startTime <", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThanOrEqualTo(Date value) {
            addCriterion("startTime <=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeIn(List<Date> values) {
            addCriterion("startTime in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotIn(List<Date> values) {
            addCriterion("startTime not in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeBetween(Date value1, Date value2) {
            addCriterion("startTime between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotBetween(Date value1, Date value2) {
            addCriterion("startTime not between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andComplainedidIsNull() {
            addCriterion("complainedId is null");
            return (Criteria) this;
        }

        public Criteria andComplainedidIsNotNull() {
            addCriterion("complainedId is not null");
            return (Criteria) this;
        }

        public Criteria andComplainedidEqualTo(Long value) {
            addCriterion("complainedId =", value, "complainedid");
            return (Criteria) this;
        }

        public Criteria andComplainedidNotEqualTo(Long value) {
            addCriterion("complainedId <>", value, "complainedid");
            return (Criteria) this;
        }

        public Criteria andComplainedidGreaterThan(Long value) {
            addCriterion("complainedId >", value, "complainedid");
            return (Criteria) this;
        }

        public Criteria andComplainedidGreaterThanOrEqualTo(Long value) {
            addCriterion("complainedId >=", value, "complainedid");
            return (Criteria) this;
        }

        public Criteria andComplainedidLessThan(Long value) {
            addCriterion("complainedId <", value, "complainedid");
            return (Criteria) this;
        }

        public Criteria andComplainedidLessThanOrEqualTo(Long value) {
            addCriterion("complainedId <=", value, "complainedid");
            return (Criteria) this;
        }

        public Criteria andComplainedidIn(List<Long> values) {
            addCriterion("complainedId in", values, "complainedid");
            return (Criteria) this;
        }

        public Criteria andComplainedidNotIn(List<Long> values) {
            addCriterion("complainedId not in", values, "complainedid");
            return (Criteria) this;
        }

        public Criteria andComplainedidBetween(Long value1, Long value2) {
            addCriterion("complainedId between", value1, value2, "complainedid");
            return (Criteria) this;
        }

        public Criteria andComplainedidNotBetween(Long value1, Long value2) {
            addCriterion("complainedId not between", value1, value2, "complainedid");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
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