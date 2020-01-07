package com.macro.mall.tiny.mbg.model;

import java.util.ArrayList;
import java.util.List;

public class ChatListExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ChatListExample() {
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

        public Criteria andMyidIsNull() {
            addCriterion("myid is null");
            return (Criteria) this;
        }

        public Criteria andMyidIsNotNull() {
            addCriterion("myid is not null");
            return (Criteria) this;
        }

        public Criteria andMyidEqualTo(Long value) {
            addCriterion("myid =", value, "myid");
            return (Criteria) this;
        }

        public Criteria andMyidNotEqualTo(Long value) {
            addCriterion("myid <>", value, "myid");
            return (Criteria) this;
        }

        public Criteria andMyidGreaterThan(Long value) {
            addCriterion("myid >", value, "myid");
            return (Criteria) this;
        }

        public Criteria andMyidGreaterThanOrEqualTo(Long value) {
            addCriterion("myid >=", value, "myid");
            return (Criteria) this;
        }

        public Criteria andMyidLessThan(Long value) {
            addCriterion("myid <", value, "myid");
            return (Criteria) this;
        }

        public Criteria andMyidLessThanOrEqualTo(Long value) {
            addCriterion("myid <=", value, "myid");
            return (Criteria) this;
        }

        public Criteria andMyidIn(List<Long> values) {
            addCriterion("myid in", values, "myid");
            return (Criteria) this;
        }

        public Criteria andMyidNotIn(List<Long> values) {
            addCriterion("myid not in", values, "myid");
            return (Criteria) this;
        }

        public Criteria andMyidBetween(Long value1, Long value2) {
            addCriterion("myid between", value1, value2, "myid");
            return (Criteria) this;
        }

        public Criteria andMyidNotBetween(Long value1, Long value2) {
            addCriterion("myid not between", value1, value2, "myid");
            return (Criteria) this;
        }

        public Criteria andMyavatorIsNull() {
            addCriterion("myavator is null");
            return (Criteria) this;
        }

        public Criteria andMyavatorIsNotNull() {
            addCriterion("myavator is not null");
            return (Criteria) this;
        }

        public Criteria andMyavatorEqualTo(String value) {
            addCriterion("myavator =", value, "myavator");
            return (Criteria) this;
        }

        public Criteria andMyavatorNotEqualTo(String value) {
            addCriterion("myavator <>", value, "myavator");
            return (Criteria) this;
        }

        public Criteria andMyavatorGreaterThan(String value) {
            addCriterion("myavator >", value, "myavator");
            return (Criteria) this;
        }

        public Criteria andMyavatorGreaterThanOrEqualTo(String value) {
            addCriterion("myavator >=", value, "myavator");
            return (Criteria) this;
        }

        public Criteria andMyavatorLessThan(String value) {
            addCriterion("myavator <", value, "myavator");
            return (Criteria) this;
        }

        public Criteria andMyavatorLessThanOrEqualTo(String value) {
            addCriterion("myavator <=", value, "myavator");
            return (Criteria) this;
        }

        public Criteria andMyavatorLike(String value) {
            addCriterion("myavator like", value, "myavator");
            return (Criteria) this;
        }

        public Criteria andMyavatorNotLike(String value) {
            addCriterion("myavator not like", value, "myavator");
            return (Criteria) this;
        }

        public Criteria andMyavatorIn(List<String> values) {
            addCriterion("myavator in", values, "myavator");
            return (Criteria) this;
        }

        public Criteria andMyavatorNotIn(List<String> values) {
            addCriterion("myavator not in", values, "myavator");
            return (Criteria) this;
        }

        public Criteria andMyavatorBetween(String value1, String value2) {
            addCriterion("myavator between", value1, value2, "myavator");
            return (Criteria) this;
        }

        public Criteria andMyavatorNotBetween(String value1, String value2) {
            addCriterion("myavator not between", value1, value2, "myavator");
            return (Criteria) this;
        }

        public Criteria andTargetidIsNull() {
            addCriterion("targetid is null");
            return (Criteria) this;
        }

        public Criteria andTargetidIsNotNull() {
            addCriterion("targetid is not null");
            return (Criteria) this;
        }

        public Criteria andTargetidEqualTo(Long value) {
            addCriterion("targetid =", value, "targetid");
            return (Criteria) this;
        }

        public Criteria andTargetidNotEqualTo(Long value) {
            addCriterion("targetid <>", value, "targetid");
            return (Criteria) this;
        }

        public Criteria andTargetidGreaterThan(Long value) {
            addCriterion("targetid >", value, "targetid");
            return (Criteria) this;
        }

        public Criteria andTargetidGreaterThanOrEqualTo(Long value) {
            addCriterion("targetid >=", value, "targetid");
            return (Criteria) this;
        }

        public Criteria andTargetidLessThan(Long value) {
            addCriterion("targetid <", value, "targetid");
            return (Criteria) this;
        }

        public Criteria andTargetidLessThanOrEqualTo(Long value) {
            addCriterion("targetid <=", value, "targetid");
            return (Criteria) this;
        }

        public Criteria andTargetidIn(List<Long> values) {
            addCriterion("targetid in", values, "targetid");
            return (Criteria) this;
        }

        public Criteria andTargetidNotIn(List<Long> values) {
            addCriterion("targetid not in", values, "targetid");
            return (Criteria) this;
        }

        public Criteria andTargetidBetween(Long value1, Long value2) {
            addCriterion("targetid between", value1, value2, "targetid");
            return (Criteria) this;
        }

        public Criteria andTargetidNotBetween(Long value1, Long value2) {
            addCriterion("targetid not between", value1, value2, "targetid");
            return (Criteria) this;
        }

        public Criteria andTargetnameIsNull() {
            addCriterion("targetname is null");
            return (Criteria) this;
        }

        public Criteria andTargetnameIsNotNull() {
            addCriterion("targetname is not null");
            return (Criteria) this;
        }

        public Criteria andTargetnameEqualTo(String value) {
            addCriterion("targetname =", value, "targetname");
            return (Criteria) this;
        }

        public Criteria andTargetnameNotEqualTo(String value) {
            addCriterion("targetname <>", value, "targetname");
            return (Criteria) this;
        }

        public Criteria andTargetnameGreaterThan(String value) {
            addCriterion("targetname >", value, "targetname");
            return (Criteria) this;
        }

        public Criteria andTargetnameGreaterThanOrEqualTo(String value) {
            addCriterion("targetname >=", value, "targetname");
            return (Criteria) this;
        }

        public Criteria andTargetnameLessThan(String value) {
            addCriterion("targetname <", value, "targetname");
            return (Criteria) this;
        }

        public Criteria andTargetnameLessThanOrEqualTo(String value) {
            addCriterion("targetname <=", value, "targetname");
            return (Criteria) this;
        }

        public Criteria andTargetnameLike(String value) {
            addCriterion("targetname like", value, "targetname");
            return (Criteria) this;
        }

        public Criteria andTargetnameNotLike(String value) {
            addCriterion("targetname not like", value, "targetname");
            return (Criteria) this;
        }

        public Criteria andTargetnameIn(List<String> values) {
            addCriterion("targetname in", values, "targetname");
            return (Criteria) this;
        }

        public Criteria andTargetnameNotIn(List<String> values) {
            addCriterion("targetname not in", values, "targetname");
            return (Criteria) this;
        }

        public Criteria andTargetnameBetween(String value1, String value2) {
            addCriterion("targetname between", value1, value2, "targetname");
            return (Criteria) this;
        }

        public Criteria andTargetnameNotBetween(String value1, String value2) {
            addCriterion("targetname not between", value1, value2, "targetname");
            return (Criteria) this;
        }

        public Criteria andTargetavatorIsNull() {
            addCriterion("targetavator is null");
            return (Criteria) this;
        }

        public Criteria andTargetavatorIsNotNull() {
            addCriterion("targetavator is not null");
            return (Criteria) this;
        }

        public Criteria andTargetavatorEqualTo(String value) {
            addCriterion("targetavator =", value, "targetavator");
            return (Criteria) this;
        }

        public Criteria andTargetavatorNotEqualTo(String value) {
            addCriterion("targetavator <>", value, "targetavator");
            return (Criteria) this;
        }

        public Criteria andTargetavatorGreaterThan(String value) {
            addCriterion("targetavator >", value, "targetavator");
            return (Criteria) this;
        }

        public Criteria andTargetavatorGreaterThanOrEqualTo(String value) {
            addCriterion("targetavator >=", value, "targetavator");
            return (Criteria) this;
        }

        public Criteria andTargetavatorLessThan(String value) {
            addCriterion("targetavator <", value, "targetavator");
            return (Criteria) this;
        }

        public Criteria andTargetavatorLessThanOrEqualTo(String value) {
            addCriterion("targetavator <=", value, "targetavator");
            return (Criteria) this;
        }

        public Criteria andTargetavatorLike(String value) {
            addCriterion("targetavator like", value, "targetavator");
            return (Criteria) this;
        }

        public Criteria andTargetavatorNotLike(String value) {
            addCriterion("targetavator not like", value, "targetavator");
            return (Criteria) this;
        }

        public Criteria andTargetavatorIn(List<String> values) {
            addCriterion("targetavator in", values, "targetavator");
            return (Criteria) this;
        }

        public Criteria andTargetavatorNotIn(List<String> values) {
            addCriterion("targetavator not in", values, "targetavator");
            return (Criteria) this;
        }

        public Criteria andTargetavatorBetween(String value1, String value2) {
            addCriterion("targetavator between", value1, value2, "targetavator");
            return (Criteria) this;
        }

        public Criteria andTargetavatorNotBetween(String value1, String value2) {
            addCriterion("targetavator not between", value1, value2, "targetavator");
            return (Criteria) this;
        }

        public Criteria andHavenewIsNull() {
            addCriterion("havenew is null");
            return (Criteria) this;
        }

        public Criteria andHavenewIsNotNull() {
            addCriterion("havenew is not null");
            return (Criteria) this;
        }

        public Criteria andHavenewEqualTo(Byte value) {
            addCriterion("havenew =", value, "havenew");
            return (Criteria) this;
        }

        public Criteria andHavenewNotEqualTo(Byte value) {
            addCriterion("havenew <>", value, "havenew");
            return (Criteria) this;
        }

        public Criteria andHavenewGreaterThan(Byte value) {
            addCriterion("havenew >", value, "havenew");
            return (Criteria) this;
        }

        public Criteria andHavenewGreaterThanOrEqualTo(Byte value) {
            addCriterion("havenew >=", value, "havenew");
            return (Criteria) this;
        }

        public Criteria andHavenewLessThan(Byte value) {
            addCriterion("havenew <", value, "havenew");
            return (Criteria) this;
        }

        public Criteria andHavenewLessThanOrEqualTo(Byte value) {
            addCriterion("havenew <=", value, "havenew");
            return (Criteria) this;
        }

        public Criteria andHavenewIn(List<Byte> values) {
            addCriterion("havenew in", values, "havenew");
            return (Criteria) this;
        }

        public Criteria andHavenewNotIn(List<Byte> values) {
            addCriterion("havenew not in", values, "havenew");
            return (Criteria) this;
        }

        public Criteria andHavenewBetween(Byte value1, Byte value2) {
            addCriterion("havenew between", value1, value2, "havenew");
            return (Criteria) this;
        }

        public Criteria andHavenewNotBetween(Byte value1, Byte value2) {
            addCriterion("havenew not between", value1, value2, "havenew");
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