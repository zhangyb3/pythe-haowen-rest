package com.pythe.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VStudentBillExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VStudentBillExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTeacherOutidIsNull() {
            addCriterion("teacher_outId is null");
            return (Criteria) this;
        }

        public Criteria andTeacherOutidIsNotNull() {
            addCriterion("teacher_outId is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherOutidEqualTo(Long value) {
            addCriterion("teacher_outId =", value, "teacherOutid");
            return (Criteria) this;
        }

        public Criteria andTeacherOutidNotEqualTo(Long value) {
            addCriterion("teacher_outId <>", value, "teacherOutid");
            return (Criteria) this;
        }

        public Criteria andTeacherOutidGreaterThan(Long value) {
            addCriterion("teacher_outId >", value, "teacherOutid");
            return (Criteria) this;
        }

        public Criteria andTeacherOutidGreaterThanOrEqualTo(Long value) {
            addCriterion("teacher_outId >=", value, "teacherOutid");
            return (Criteria) this;
        }

        public Criteria andTeacherOutidLessThan(Long value) {
            addCriterion("teacher_outId <", value, "teacherOutid");
            return (Criteria) this;
        }

        public Criteria andTeacherOutidLessThanOrEqualTo(Long value) {
            addCriterion("teacher_outId <=", value, "teacherOutid");
            return (Criteria) this;
        }

        public Criteria andTeacherOutidIn(List<Long> values) {
            addCriterion("teacher_outId in", values, "teacherOutid");
            return (Criteria) this;
        }

        public Criteria andTeacherOutidNotIn(List<Long> values) {
            addCriterion("teacher_outId not in", values, "teacherOutid");
            return (Criteria) this;
        }

        public Criteria andTeacherOutidBetween(Long value1, Long value2) {
            addCriterion("teacher_outId between", value1, value2, "teacherOutid");
            return (Criteria) this;
        }

        public Criteria andTeacherOutidNotBetween(Long value1, Long value2) {
            addCriterion("teacher_outId not between", value1, value2, "teacherOutid");
            return (Criteria) this;
        }

        public Criteria andStudentOutidIsNull() {
            addCriterion("student_outId is null");
            return (Criteria) this;
        }

        public Criteria andStudentOutidIsNotNull() {
            addCriterion("student_outId is not null");
            return (Criteria) this;
        }

        public Criteria andStudentOutidEqualTo(Long value) {
            addCriterion("student_outId =", value, "studentOutid");
            return (Criteria) this;
        }

        public Criteria andStudentOutidNotEqualTo(Long value) {
            addCriterion("student_outId <>", value, "studentOutid");
            return (Criteria) this;
        }

        public Criteria andStudentOutidGreaterThan(Long value) {
            addCriterion("student_outId >", value, "studentOutid");
            return (Criteria) this;
        }

        public Criteria andStudentOutidGreaterThanOrEqualTo(Long value) {
            addCriterion("student_outId >=", value, "studentOutid");
            return (Criteria) this;
        }

        public Criteria andStudentOutidLessThan(Long value) {
            addCriterion("student_outId <", value, "studentOutid");
            return (Criteria) this;
        }

        public Criteria andStudentOutidLessThanOrEqualTo(Long value) {
            addCriterion("student_outId <=", value, "studentOutid");
            return (Criteria) this;
        }

        public Criteria andStudentOutidIn(List<Long> values) {
            addCriterion("student_outId in", values, "studentOutid");
            return (Criteria) this;
        }

        public Criteria andStudentOutidNotIn(List<Long> values) {
            addCriterion("student_outId not in", values, "studentOutid");
            return (Criteria) this;
        }

        public Criteria andStudentOutidBetween(Long value1, Long value2) {
            addCriterion("student_outId between", value1, value2, "studentOutid");
            return (Criteria) this;
        }

        public Criteria andStudentOutidNotBetween(Long value1, Long value2) {
            addCriterion("student_outId not between", value1, value2, "studentOutid");
            return (Criteria) this;
        }

        public Criteria andTeacherInidIsNull() {
            addCriterion("teacher_inId is null");
            return (Criteria) this;
        }

        public Criteria andTeacherInidIsNotNull() {
            addCriterion("teacher_inId is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherInidEqualTo(Long value) {
            addCriterion("teacher_inId =", value, "teacherInid");
            return (Criteria) this;
        }

        public Criteria andTeacherInidNotEqualTo(Long value) {
            addCriterion("teacher_inId <>", value, "teacherInid");
            return (Criteria) this;
        }

        public Criteria andTeacherInidGreaterThan(Long value) {
            addCriterion("teacher_inId >", value, "teacherInid");
            return (Criteria) this;
        }

        public Criteria andTeacherInidGreaterThanOrEqualTo(Long value) {
            addCriterion("teacher_inId >=", value, "teacherInid");
            return (Criteria) this;
        }

        public Criteria andTeacherInidLessThan(Long value) {
            addCriterion("teacher_inId <", value, "teacherInid");
            return (Criteria) this;
        }

        public Criteria andTeacherInidLessThanOrEqualTo(Long value) {
            addCriterion("teacher_inId <=", value, "teacherInid");
            return (Criteria) this;
        }

        public Criteria andTeacherInidIn(List<Long> values) {
            addCriterion("teacher_inId in", values, "teacherInid");
            return (Criteria) this;
        }

        public Criteria andTeacherInidNotIn(List<Long> values) {
            addCriterion("teacher_inId not in", values, "teacherInid");
            return (Criteria) this;
        }

        public Criteria andTeacherInidBetween(Long value1, Long value2) {
            addCriterion("teacher_inId between", value1, value2, "teacherInid");
            return (Criteria) this;
        }

        public Criteria andTeacherInidNotBetween(Long value1, Long value2) {
            addCriterion("teacher_inId not between", value1, value2, "teacherInid");
            return (Criteria) this;
        }

        public Criteria andStudentInidIsNull() {
            addCriterion("student_inId is null");
            return (Criteria) this;
        }

        public Criteria andStudentInidIsNotNull() {
            addCriterion("student_inId is not null");
            return (Criteria) this;
        }

        public Criteria andStudentInidEqualTo(Long value) {
            addCriterion("student_inId =", value, "studentInid");
            return (Criteria) this;
        }

        public Criteria andStudentInidNotEqualTo(Long value) {
            addCriterion("student_inId <>", value, "studentInid");
            return (Criteria) this;
        }

        public Criteria andStudentInidGreaterThan(Long value) {
            addCriterion("student_inId >", value, "studentInid");
            return (Criteria) this;
        }

        public Criteria andStudentInidGreaterThanOrEqualTo(Long value) {
            addCriterion("student_inId >=", value, "studentInid");
            return (Criteria) this;
        }

        public Criteria andStudentInidLessThan(Long value) {
            addCriterion("student_inId <", value, "studentInid");
            return (Criteria) this;
        }

        public Criteria andStudentInidLessThanOrEqualTo(Long value) {
            addCriterion("student_inId <=", value, "studentInid");
            return (Criteria) this;
        }

        public Criteria andStudentInidIn(List<Long> values) {
            addCriterion("student_inId in", values, "studentInid");
            return (Criteria) this;
        }

        public Criteria andStudentInidNotIn(List<Long> values) {
            addCriterion("student_inId not in", values, "studentInid");
            return (Criteria) this;
        }

        public Criteria andStudentInidBetween(Long value1, Long value2) {
            addCriterion("student_inId between", value1, value2, "studentInid");
            return (Criteria) this;
        }

        public Criteria andStudentInidNotBetween(Long value1, Long value2) {
            addCriterion("student_inId not between", value1, value2, "studentInid");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNull() {
            addCriterion("money is null");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNotNull() {
            addCriterion("money is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyEqualTo(Double value) {
            addCriterion("money =", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotEqualTo(Double value) {
            addCriterion("money <>", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThan(Double value) {
            addCriterion("money >", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("money >=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThan(Double value) {
            addCriterion("money <", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThanOrEqualTo(Double value) {
            addCriterion("money <=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyIn(List<Double> values) {
            addCriterion("money in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotIn(List<Double> values) {
            addCriterion("money not in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyBetween(Double value1, Double value2) {
            addCriterion("money between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotBetween(Double value1, Double value2) {
            addCriterion("money not between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andObjectidIsNull() {
            addCriterion("objectId is null");
            return (Criteria) this;
        }

        public Criteria andObjectidIsNotNull() {
            addCriterion("objectId is not null");
            return (Criteria) this;
        }

        public Criteria andObjectidEqualTo(Long value) {
            addCriterion("objectId =", value, "objectid");
            return (Criteria) this;
        }

        public Criteria andObjectidNotEqualTo(Long value) {
            addCriterion("objectId <>", value, "objectid");
            return (Criteria) this;
        }

        public Criteria andObjectidGreaterThan(Long value) {
            addCriterion("objectId >", value, "objectid");
            return (Criteria) this;
        }

        public Criteria andObjectidGreaterThanOrEqualTo(Long value) {
            addCriterion("objectId >=", value, "objectid");
            return (Criteria) this;
        }

        public Criteria andObjectidLessThan(Long value) {
            addCriterion("objectId <", value, "objectid");
            return (Criteria) this;
        }

        public Criteria andObjectidLessThanOrEqualTo(Long value) {
            addCriterion("objectId <=", value, "objectid");
            return (Criteria) this;
        }

        public Criteria andObjectidIn(List<Long> values) {
            addCriterion("objectId in", values, "objectid");
            return (Criteria) this;
        }

        public Criteria andObjectidNotIn(List<Long> values) {
            addCriterion("objectId not in", values, "objectid");
            return (Criteria) this;
        }

        public Criteria andObjectidBetween(Long value1, Long value2) {
            addCriterion("objectId between", value1, value2, "objectid");
            return (Criteria) this;
        }

        public Criteria andObjectidNotBetween(Long value1, Long value2) {
            addCriterion("objectId not between", value1, value2, "objectid");
            return (Criteria) this;
        }

        public Criteria andOperationtypeIsNull() {
            addCriterion("operationType is null");
            return (Criteria) this;
        }

        public Criteria andOperationtypeIsNotNull() {
            addCriterion("operationType is not null");
            return (Criteria) this;
        }

        public Criteria andOperationtypeEqualTo(String value) {
            addCriterion("operationType =", value, "operationtype");
            return (Criteria) this;
        }

        public Criteria andOperationtypeNotEqualTo(String value) {
            addCriterion("operationType <>", value, "operationtype");
            return (Criteria) this;
        }

        public Criteria andOperationtypeGreaterThan(String value) {
            addCriterion("operationType >", value, "operationtype");
            return (Criteria) this;
        }

        public Criteria andOperationtypeGreaterThanOrEqualTo(String value) {
            addCriterion("operationType >=", value, "operationtype");
            return (Criteria) this;
        }

        public Criteria andOperationtypeLessThan(String value) {
            addCriterion("operationType <", value, "operationtype");
            return (Criteria) this;
        }

        public Criteria andOperationtypeLessThanOrEqualTo(String value) {
            addCriterion("operationType <=", value, "operationtype");
            return (Criteria) this;
        }

        public Criteria andOperationtypeLike(String value) {
            addCriterion("operationType like", value, "operationtype");
            return (Criteria) this;
        }

        public Criteria andOperationtypeNotLike(String value) {
            addCriterion("operationType not like", value, "operationtype");
            return (Criteria) this;
        }

        public Criteria andOperationtypeIn(List<String> values) {
            addCriterion("operationType in", values, "operationtype");
            return (Criteria) this;
        }

        public Criteria andOperationtypeNotIn(List<String> values) {
            addCriterion("operationType not in", values, "operationtype");
            return (Criteria) this;
        }

        public Criteria andOperationtypeBetween(String value1, String value2) {
            addCriterion("operationType between", value1, value2, "operationtype");
            return (Criteria) this;
        }

        public Criteria andOperationtypeNotBetween(String value1, String value2) {
            addCriterion("operationType not between", value1, value2, "operationtype");
            return (Criteria) this;
        }

        public Criteria andOperationtimeIsNull() {
            addCriterion("operationTime is null");
            return (Criteria) this;
        }

        public Criteria andOperationtimeIsNotNull() {
            addCriterion("operationTime is not null");
            return (Criteria) this;
        }

        public Criteria andOperationtimeEqualTo(Date value) {
            addCriterion("operationTime =", value, "operationtime");
            return (Criteria) this;
        }

        public Criteria andOperationtimeNotEqualTo(Date value) {
            addCriterion("operationTime <>", value, "operationtime");
            return (Criteria) this;
        }

        public Criteria andOperationtimeGreaterThan(Date value) {
            addCriterion("operationTime >", value, "operationtime");
            return (Criteria) this;
        }

        public Criteria andOperationtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("operationTime >=", value, "operationtime");
            return (Criteria) this;
        }

        public Criteria andOperationtimeLessThan(Date value) {
            addCriterion("operationTime <", value, "operationtime");
            return (Criteria) this;
        }

        public Criteria andOperationtimeLessThanOrEqualTo(Date value) {
            addCriterion("operationTime <=", value, "operationtime");
            return (Criteria) this;
        }

        public Criteria andOperationtimeIn(List<Date> values) {
            addCriterion("operationTime in", values, "operationtime");
            return (Criteria) this;
        }

        public Criteria andOperationtimeNotIn(List<Date> values) {
            addCriterion("operationTime not in", values, "operationtime");
            return (Criteria) this;
        }

        public Criteria andOperationtimeBetween(Date value1, Date value2) {
            addCriterion("operationTime between", value1, value2, "operationtime");
            return (Criteria) this;
        }

        public Criteria andOperationtimeNotBetween(Date value1, Date value2) {
            addCriterion("operationTime not between", value1, value2, "operationtime");
            return (Criteria) this;
        }

        public Criteria andPayIdIsNull() {
            addCriterion("pay_id is null");
            return (Criteria) this;
        }

        public Criteria andPayIdIsNotNull() {
            addCriterion("pay_id is not null");
            return (Criteria) this;
        }

        public Criteria andPayIdEqualTo(String value) {
            addCriterion("pay_id =", value, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdNotEqualTo(String value) {
            addCriterion("pay_id <>", value, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdGreaterThan(String value) {
            addCriterion("pay_id >", value, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdGreaterThanOrEqualTo(String value) {
            addCriterion("pay_id >=", value, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdLessThan(String value) {
            addCriterion("pay_id <", value, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdLessThanOrEqualTo(String value) {
            addCriterion("pay_id <=", value, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdLike(String value) {
            addCriterion("pay_id like", value, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdNotLike(String value) {
            addCriterion("pay_id not like", value, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdIn(List<String> values) {
            addCriterion("pay_id in", values, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdNotIn(List<String> values) {
            addCriterion("pay_id not in", values, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdBetween(String value1, String value2) {
            addCriterion("pay_id between", value1, value2, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdNotBetween(String value1, String value2) {
            addCriterion("pay_id not between", value1, value2, "payId");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoIsNull() {
            addCriterion("out_trade_no is null");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoIsNotNull() {
            addCriterion("out_trade_no is not null");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoEqualTo(String value) {
            addCriterion("out_trade_no =", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoNotEqualTo(String value) {
            addCriterion("out_trade_no <>", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoGreaterThan(String value) {
            addCriterion("out_trade_no >", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoGreaterThanOrEqualTo(String value) {
            addCriterion("out_trade_no >=", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoLessThan(String value) {
            addCriterion("out_trade_no <", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoLessThanOrEqualTo(String value) {
            addCriterion("out_trade_no <=", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoLike(String value) {
            addCriterion("out_trade_no like", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoNotLike(String value) {
            addCriterion("out_trade_no not like", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoIn(List<String> values) {
            addCriterion("out_trade_no in", values, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoNotIn(List<String> values) {
            addCriterion("out_trade_no not in", values, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoBetween(String value1, String value2) {
            addCriterion("out_trade_no between", value1, value2, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoNotBetween(String value1, String value2) {
            addCriterion("out_trade_no not between", value1, value2, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andPaidIsNull() {
            addCriterion("paid is null");
            return (Criteria) this;
        }

        public Criteria andPaidIsNotNull() {
            addCriterion("paid is not null");
            return (Criteria) this;
        }

        public Criteria andPaidEqualTo(Integer value) {
            addCriterion("paid =", value, "paid");
            return (Criteria) this;
        }

        public Criteria andPaidNotEqualTo(Integer value) {
            addCriterion("paid <>", value, "paid");
            return (Criteria) this;
        }

        public Criteria andPaidGreaterThan(Integer value) {
            addCriterion("paid >", value, "paid");
            return (Criteria) this;
        }

        public Criteria andPaidGreaterThanOrEqualTo(Integer value) {
            addCriterion("paid >=", value, "paid");
            return (Criteria) this;
        }

        public Criteria andPaidLessThan(Integer value) {
            addCriterion("paid <", value, "paid");
            return (Criteria) this;
        }

        public Criteria andPaidLessThanOrEqualTo(Integer value) {
            addCriterion("paid <=", value, "paid");
            return (Criteria) this;
        }

        public Criteria andPaidIn(List<Integer> values) {
            addCriterion("paid in", values, "paid");
            return (Criteria) this;
        }

        public Criteria andPaidNotIn(List<Integer> values) {
            addCriterion("paid not in", values, "paid");
            return (Criteria) this;
        }

        public Criteria andPaidBetween(Integer value1, Integer value2) {
            addCriterion("paid between", value1, value2, "paid");
            return (Criteria) this;
        }

        public Criteria andPaidNotBetween(Integer value1, Integer value2) {
            addCriterion("paid not between", value1, value2, "paid");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUserimgIsNull() {
            addCriterion("userImg is null");
            return (Criteria) this;
        }

        public Criteria andUserimgIsNotNull() {
            addCriterion("userImg is not null");
            return (Criteria) this;
        }

        public Criteria andUserimgEqualTo(String value) {
            addCriterion("userImg =", value, "userimg");
            return (Criteria) this;
        }

        public Criteria andUserimgNotEqualTo(String value) {
            addCriterion("userImg <>", value, "userimg");
            return (Criteria) this;
        }

        public Criteria andUserimgGreaterThan(String value) {
            addCriterion("userImg >", value, "userimg");
            return (Criteria) this;
        }

        public Criteria andUserimgGreaterThanOrEqualTo(String value) {
            addCriterion("userImg >=", value, "userimg");
            return (Criteria) this;
        }

        public Criteria andUserimgLessThan(String value) {
            addCriterion("userImg <", value, "userimg");
            return (Criteria) this;
        }

        public Criteria andUserimgLessThanOrEqualTo(String value) {
            addCriterion("userImg <=", value, "userimg");
            return (Criteria) this;
        }

        public Criteria andUserimgLike(String value) {
            addCriterion("userImg like", value, "userimg");
            return (Criteria) this;
        }

        public Criteria andUserimgNotLike(String value) {
            addCriterion("userImg not like", value, "userimg");
            return (Criteria) this;
        }

        public Criteria andUserimgIn(List<String> values) {
            addCriterion("userImg in", values, "userimg");
            return (Criteria) this;
        }

        public Criteria andUserimgNotIn(List<String> values) {
            addCriterion("userImg not in", values, "userimg");
            return (Criteria) this;
        }

        public Criteria andUserimgBetween(String value1, String value2) {
            addCriterion("userImg between", value1, value2, "userimg");
            return (Criteria) this;
        }

        public Criteria andUserimgNotBetween(String value1, String value2) {
            addCriterion("userImg not between", value1, value2, "userimg");
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