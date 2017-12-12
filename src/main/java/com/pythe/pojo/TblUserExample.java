package com.pythe.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TblUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TblUserExample() {
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

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPhonenumIsNull() {
            addCriterion("phoneNum is null");
            return (Criteria) this;
        }

        public Criteria andPhonenumIsNotNull() {
            addCriterion("phoneNum is not null");
            return (Criteria) this;
        }

        public Criteria andPhonenumEqualTo(String value) {
            addCriterion("phoneNum =", value, "phonenum");
            return (Criteria) this;
        }

        public Criteria andPhonenumNotEqualTo(String value) {
            addCriterion("phoneNum <>", value, "phonenum");
            return (Criteria) this;
        }

        public Criteria andPhonenumGreaterThan(String value) {
            addCriterion("phoneNum >", value, "phonenum");
            return (Criteria) this;
        }

        public Criteria andPhonenumGreaterThanOrEqualTo(String value) {
            addCriterion("phoneNum >=", value, "phonenum");
            return (Criteria) this;
        }

        public Criteria andPhonenumLessThan(String value) {
            addCriterion("phoneNum <", value, "phonenum");
            return (Criteria) this;
        }

        public Criteria andPhonenumLessThanOrEqualTo(String value) {
            addCriterion("phoneNum <=", value, "phonenum");
            return (Criteria) this;
        }

        public Criteria andPhonenumLike(String value) {
            addCriterion("phoneNum like", value, "phonenum");
            return (Criteria) this;
        }

        public Criteria andPhonenumNotLike(String value) {
            addCriterion("phoneNum not like", value, "phonenum");
            return (Criteria) this;
        }

        public Criteria andPhonenumIn(List<String> values) {
            addCriterion("phoneNum in", values, "phonenum");
            return (Criteria) this;
        }

        public Criteria andPhonenumNotIn(List<String> values) {
            addCriterion("phoneNum not in", values, "phonenum");
            return (Criteria) this;
        }

        public Criteria andPhonenumBetween(String value1, String value2) {
            addCriterion("phoneNum between", value1, value2, "phonenum");
            return (Criteria) this;
        }

        public Criteria andPhonenumNotBetween(String value1, String value2) {
            addCriterion("phoneNum not between", value1, value2, "phonenum");
            return (Criteria) this;
        }

        public Criteria andFavoriteIsNull() {
            addCriterion("favorite is null");
            return (Criteria) this;
        }

        public Criteria andFavoriteIsNotNull() {
            addCriterion("favorite is not null");
            return (Criteria) this;
        }

        public Criteria andFavoriteEqualTo(String value) {
            addCriterion("favorite =", value, "favorite");
            return (Criteria) this;
        }

        public Criteria andFavoriteNotEqualTo(String value) {
            addCriterion("favorite <>", value, "favorite");
            return (Criteria) this;
        }

        public Criteria andFavoriteGreaterThan(String value) {
            addCriterion("favorite >", value, "favorite");
            return (Criteria) this;
        }

        public Criteria andFavoriteGreaterThanOrEqualTo(String value) {
            addCriterion("favorite >=", value, "favorite");
            return (Criteria) this;
        }

        public Criteria andFavoriteLessThan(String value) {
            addCriterion("favorite <", value, "favorite");
            return (Criteria) this;
        }

        public Criteria andFavoriteLessThanOrEqualTo(String value) {
            addCriterion("favorite <=", value, "favorite");
            return (Criteria) this;
        }

        public Criteria andFavoriteLike(String value) {
            addCriterion("favorite like", value, "favorite");
            return (Criteria) this;
        }

        public Criteria andFavoriteNotLike(String value) {
            addCriterion("favorite not like", value, "favorite");
            return (Criteria) this;
        }

        public Criteria andFavoriteIn(List<String> values) {
            addCriterion("favorite in", values, "favorite");
            return (Criteria) this;
        }

        public Criteria andFavoriteNotIn(List<String> values) {
            addCriterion("favorite not in", values, "favorite");
            return (Criteria) this;
        }

        public Criteria andFavoriteBetween(String value1, String value2) {
            addCriterion("favorite between", value1, value2, "favorite");
            return (Criteria) this;
        }

        public Criteria andFavoriteNotBetween(String value1, String value2) {
            addCriterion("favorite not between", value1, value2, "favorite");
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

        public Criteria andCreatedIsNull() {
            addCriterion("created is null");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNotNull() {
            addCriterion("created is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedEqualTo(Date value) {
            addCriterion("created =", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotEqualTo(Date value) {
            addCriterion("created <>", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThan(Date value) {
            addCriterion("created >", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThanOrEqualTo(Date value) {
            addCriterion("created >=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThan(Date value) {
            addCriterion("created <", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThanOrEqualTo(Date value) {
            addCriterion("created <=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedIn(List<Date> values) {
            addCriterion("created in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotIn(List<Date> values) {
            addCriterion("created not in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedBetween(Date value1, Date value2) {
            addCriterion("created between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotBetween(Date value1, Date value2) {
            addCriterion("created not between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andUpdatedIsNull() {
            addCriterion("updated is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedIsNotNull() {
            addCriterion("updated is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedEqualTo(Date value) {
            addCriterion("updated =", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotEqualTo(Date value) {
            addCriterion("updated <>", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedGreaterThan(Date value) {
            addCriterion("updated >", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedGreaterThanOrEqualTo(Date value) {
            addCriterion("updated >=", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedLessThan(Date value) {
            addCriterion("updated <", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedLessThanOrEqualTo(Date value) {
            addCriterion("updated <=", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedIn(List<Date> values) {
            addCriterion("updated in", values, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotIn(List<Date> values) {
            addCriterion("updated not in", values, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedBetween(Date value1, Date value2) {
            addCriterion("updated between", value1, value2, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotBetween(Date value1, Date value2) {
            addCriterion("updated not between", value1, value2, "updated");
            return (Criteria) this;
        }

        public Criteria andOpenidIsNull() {
            addCriterion("openId is null");
            return (Criteria) this;
        }

        public Criteria andOpenidIsNotNull() {
            addCriterion("openId is not null");
            return (Criteria) this;
        }

        public Criteria andOpenidEqualTo(String value) {
            addCriterion("openId =", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotEqualTo(String value) {
            addCriterion("openId <>", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidGreaterThan(String value) {
            addCriterion("openId >", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidGreaterThanOrEqualTo(String value) {
            addCriterion("openId >=", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidLessThan(String value) {
            addCriterion("openId <", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidLessThanOrEqualTo(String value) {
            addCriterion("openId <=", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidLike(String value) {
            addCriterion("openId like", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotLike(String value) {
            addCriterion("openId not like", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidIn(List<String> values) {
            addCriterion("openId in", values, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotIn(List<String> values) {
            addCriterion("openId not in", values, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidBetween(String value1, String value2) {
            addCriterion("openId between", value1, value2, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotBetween(String value1, String value2) {
            addCriterion("openId not between", value1, value2, "openid");
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

        public Criteria andPopularityIsNull() {
            addCriterion("popularity is null");
            return (Criteria) this;
        }

        public Criteria andPopularityIsNotNull() {
            addCriterion("popularity is not null");
            return (Criteria) this;
        }

        public Criteria andPopularityEqualTo(String value) {
            addCriterion("popularity =", value, "popularity");
            return (Criteria) this;
        }

        public Criteria andPopularityNotEqualTo(String value) {
            addCriterion("popularity <>", value, "popularity");
            return (Criteria) this;
        }

        public Criteria andPopularityGreaterThan(String value) {
            addCriterion("popularity >", value, "popularity");
            return (Criteria) this;
        }

        public Criteria andPopularityGreaterThanOrEqualTo(String value) {
            addCriterion("popularity >=", value, "popularity");
            return (Criteria) this;
        }

        public Criteria andPopularityLessThan(String value) {
            addCriterion("popularity <", value, "popularity");
            return (Criteria) this;
        }

        public Criteria andPopularityLessThanOrEqualTo(String value) {
            addCriterion("popularity <=", value, "popularity");
            return (Criteria) this;
        }

        public Criteria andPopularityLike(String value) {
            addCriterion("popularity like", value, "popularity");
            return (Criteria) this;
        }

        public Criteria andPopularityNotLike(String value) {
            addCriterion("popularity not like", value, "popularity");
            return (Criteria) this;
        }

        public Criteria andPopularityIn(List<String> values) {
            addCriterion("popularity in", values, "popularity");
            return (Criteria) this;
        }

        public Criteria andPopularityNotIn(List<String> values) {
            addCriterion("popularity not in", values, "popularity");
            return (Criteria) this;
        }

        public Criteria andPopularityBetween(String value1, String value2) {
            addCriterion("popularity between", value1, value2, "popularity");
            return (Criteria) this;
        }

        public Criteria andPopularityNotBetween(String value1, String value2) {
            addCriterion("popularity not between", value1, value2, "popularity");
            return (Criteria) this;
        }

        public Criteria andOrganizationidIsNull() {
            addCriterion("organizationId is null");
            return (Criteria) this;
        }

        public Criteria andOrganizationidIsNotNull() {
            addCriterion("organizationId is not null");
            return (Criteria) this;
        }

        public Criteria andOrganizationidEqualTo(Long value) {
            addCriterion("organizationId =", value, "organizationid");
            return (Criteria) this;
        }

        public Criteria andOrganizationidNotEqualTo(Long value) {
            addCriterion("organizationId <>", value, "organizationid");
            return (Criteria) this;
        }

        public Criteria andOrganizationidGreaterThan(Long value) {
            addCriterion("organizationId >", value, "organizationid");
            return (Criteria) this;
        }

        public Criteria andOrganizationidGreaterThanOrEqualTo(Long value) {
            addCriterion("organizationId >=", value, "organizationid");
            return (Criteria) this;
        }

        public Criteria andOrganizationidLessThan(Long value) {
            addCriterion("organizationId <", value, "organizationid");
            return (Criteria) this;
        }

        public Criteria andOrganizationidLessThanOrEqualTo(Long value) {
            addCriterion("organizationId <=", value, "organizationid");
            return (Criteria) this;
        }

        public Criteria andOrganizationidIn(List<Long> values) {
            addCriterion("organizationId in", values, "organizationid");
            return (Criteria) this;
        }

        public Criteria andOrganizationidNotIn(List<Long> values) {
            addCriterion("organizationId not in", values, "organizationid");
            return (Criteria) this;
        }

        public Criteria andOrganizationidBetween(Long value1, Long value2) {
            addCriterion("organizationId between", value1, value2, "organizationid");
            return (Criteria) this;
        }

        public Criteria andOrganizationidNotBetween(Long value1, Long value2) {
            addCriterion("organizationId not between", value1, value2, "organizationid");
            return (Criteria) this;
        }

        public Criteria andSolvedIsNull() {
            addCriterion("solved is null");
            return (Criteria) this;
        }

        public Criteria andSolvedIsNotNull() {
            addCriterion("solved is not null");
            return (Criteria) this;
        }

        public Criteria andSolvedEqualTo(String value) {
            addCriterion("solved =", value, "solved");
            return (Criteria) this;
        }

        public Criteria andSolvedNotEqualTo(String value) {
            addCriterion("solved <>", value, "solved");
            return (Criteria) this;
        }

        public Criteria andSolvedGreaterThan(String value) {
            addCriterion("solved >", value, "solved");
            return (Criteria) this;
        }

        public Criteria andSolvedGreaterThanOrEqualTo(String value) {
            addCriterion("solved >=", value, "solved");
            return (Criteria) this;
        }

        public Criteria andSolvedLessThan(String value) {
            addCriterion("solved <", value, "solved");
            return (Criteria) this;
        }

        public Criteria andSolvedLessThanOrEqualTo(String value) {
            addCriterion("solved <=", value, "solved");
            return (Criteria) this;
        }

        public Criteria andSolvedLike(String value) {
            addCriterion("solved like", value, "solved");
            return (Criteria) this;
        }

        public Criteria andSolvedNotLike(String value) {
            addCriterion("solved not like", value, "solved");
            return (Criteria) this;
        }

        public Criteria andSolvedIn(List<String> values) {
            addCriterion("solved in", values, "solved");
            return (Criteria) this;
        }

        public Criteria andSolvedNotIn(List<String> values) {
            addCriterion("solved not in", values, "solved");
            return (Criteria) this;
        }

        public Criteria andSolvedBetween(String value1, String value2) {
            addCriterion("solved between", value1, value2, "solved");
            return (Criteria) this;
        }

        public Criteria andSolvedNotBetween(String value1, String value2) {
            addCriterion("solved not between", value1, value2, "solved");
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