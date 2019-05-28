package com.oa.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AttendExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AttendExample() {
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

        public Criteria andAttendIdIsNull() {
            addCriterion("attend_id is null");
            return (Criteria) this;
        }

        public Criteria andAttendIdIsNotNull() {
            addCriterion("attend_id is not null");
            return (Criteria) this;
        }

        public Criteria andAttendIdEqualTo(Integer value) {
            addCriterion("attend_id =", value, "attendId");
            return (Criteria) this;
        }

        public Criteria andAttendIdNotEqualTo(Integer value) {
            addCriterion("attend_id <>", value, "attendId");
            return (Criteria) this;
        }

        public Criteria andAttendIdGreaterThan(Integer value) {
            addCriterion("attend_id >", value, "attendId");
            return (Criteria) this;
        }

        public Criteria andAttendIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("attend_id >=", value, "attendId");
            return (Criteria) this;
        }

        public Criteria andAttendIdLessThan(Integer value) {
            addCriterion("attend_id <", value, "attendId");
            return (Criteria) this;
        }

        public Criteria andAttendIdLessThanOrEqualTo(Integer value) {
            addCriterion("attend_id <=", value, "attendId");
            return (Criteria) this;
        }

        public Criteria andAttendIdIn(List<Integer> values) {
            addCriterion("attend_id in", values, "attendId");
            return (Criteria) this;
        }

        public Criteria andAttendIdNotIn(List<Integer> values) {
            addCriterion("attend_id not in", values, "attendId");
            return (Criteria) this;
        }

        public Criteria andAttendIdBetween(Integer value1, Integer value2) {
            addCriterion("attend_id between", value1, value2, "attendId");
            return (Criteria) this;
        }

        public Criteria andAttendIdNotBetween(Integer value1, Integer value2) {
            addCriterion("attend_id not between", value1, value2, "attendId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andDeptIdIsNull() {
            addCriterion("dept_id is null");
            return (Criteria) this;
        }

        public Criteria andDeptIdIsNotNull() {
            addCriterion("dept_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeptIdEqualTo(Integer value) {
            addCriterion("dept_id =", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotEqualTo(Integer value) {
            addCriterion("dept_id <>", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdGreaterThan(Integer value) {
            addCriterion("dept_id >", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("dept_id >=", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdLessThan(Integer value) {
            addCriterion("dept_id <", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdLessThanOrEqualTo(Integer value) {
            addCriterion("dept_id <=", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdIn(List<Integer> values) {
            addCriterion("dept_id in", values, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotIn(List<Integer> values) {
            addCriterion("dept_id not in", values, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdBetween(Integer value1, Integer value2) {
            addCriterion("dept_id between", value1, value2, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotBetween(Integer value1, Integer value2) {
            addCriterion("dept_id not between", value1, value2, "deptId");
            return (Criteria) this;
        }

        public Criteria andCurrDateIsNull() {
            addCriterion("curr_date is null");
            return (Criteria) this;
        }

        public Criteria andCurrDateIsNotNull() {
            addCriterion("curr_date is not null");
            return (Criteria) this;
        }

        public Criteria andCurrDateEqualTo(Date value) {
            addCriterion("curr_date =", value, "currDate");
            return (Criteria) this;
        }

        public Criteria andCurrDateNotEqualTo(Date value) {
            addCriterion("curr_date <>", value, "currDate");
            return (Criteria) this;
        }

        public Criteria andCurrDateGreaterThan(Date value) {
            addCriterion("curr_date >", value, "currDate");
            return (Criteria) this;
        }

        public Criteria andCurrDateGreaterThanOrEqualTo(Date value) {
            addCriterion("curr_date >=", value, "currDate");
            return (Criteria) this;
        }

        public Criteria andCurrDateLessThan(Date value) {
            addCriterion("curr_date <", value, "currDate");
            return (Criteria) this;
        }

        public Criteria andCurrDateLessThanOrEqualTo(Date value) {
            addCriterion("curr_date <=", value, "currDate");
            return (Criteria) this;
        }

        public Criteria andCurrDateIn(List<Date> values) {
            addCriterion("curr_date in", values, "currDate");
            return (Criteria) this;
        }

        public Criteria andCurrDateNotIn(List<Date> values) {
            addCriterion("curr_date not in", values, "currDate");
            return (Criteria) this;
        }

        public Criteria andCurrDateBetween(Date value1, Date value2) {
            addCriterion("curr_date between", value1, value2, "currDate");
            return (Criteria) this;
        }

        public Criteria andCurrDateNotBetween(Date value1, Date value2) {
            addCriterion("curr_date not between", value1, value2, "currDate");
            return (Criteria) this;
        }

        public Criteria andWeekIsNull() {
            addCriterion("week is null");
            return (Criteria) this;
        }

        public Criteria andWeekIsNotNull() {
            addCriterion("week is not null");
            return (Criteria) this;
        }

        public Criteria andWeekEqualTo(String value) {
            addCriterion("week =", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekNotEqualTo(String value) {
            addCriterion("week <>", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekGreaterThan(String value) {
            addCriterion("week >", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekGreaterThanOrEqualTo(String value) {
            addCriterion("week >=", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekLessThan(String value) {
            addCriterion("week <", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekLessThanOrEqualTo(String value) {
            addCriterion("week <=", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekLike(String value) {
            addCriterion("week like", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekNotLike(String value) {
            addCriterion("week not like", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekIn(List<String> values) {
            addCriterion("week in", values, "week");
            return (Criteria) this;
        }

        public Criteria andWeekNotIn(List<String> values) {
            addCriterion("week not in", values, "week");
            return (Criteria) this;
        }

        public Criteria andWeekBetween(String value1, String value2) {
            addCriterion("week between", value1, value2, "week");
            return (Criteria) this;
        }

        public Criteria andWeekNotBetween(String value1, String value2) {
            addCriterion("week not between", value1, value2, "week");
            return (Criteria) this;
        }

        public Criteria andAttendMorStartIsNull() {
            addCriterion("attend_mor_start is null");
            return (Criteria) this;
        }

        public Criteria andAttendMorStartIsNotNull() {
            addCriterion("attend_mor_start is not null");
            return (Criteria) this;
        }

        public Criteria andAttendMorStartEqualTo(Date value) {
            addCriterion("attend_mor_start =", value, "attendMorStart");
            return (Criteria) this;
        }

        public Criteria andAttendMorStartNotEqualTo(Date value) {
            addCriterion("attend_mor_start <>", value, "attendMorStart");
            return (Criteria) this;
        }

        public Criteria andAttendMorStartGreaterThan(Date value) {
            addCriterion("attend_mor_start >", value, "attendMorStart");
            return (Criteria) this;
        }

        public Criteria andAttendMorStartGreaterThanOrEqualTo(Date value) {
            addCriterion("attend_mor_start >=", value, "attendMorStart");
            return (Criteria) this;
        }

        public Criteria andAttendMorStartLessThan(Date value) {
            addCriterion("attend_mor_start <", value, "attendMorStart");
            return (Criteria) this;
        }

        public Criteria andAttendMorStartLessThanOrEqualTo(Date value) {
            addCriterion("attend_mor_start <=", value, "attendMorStart");
            return (Criteria) this;
        }

        public Criteria andAttendMorStartIn(List<Date> values) {
            addCriterion("attend_mor_start in", values, "attendMorStart");
            return (Criteria) this;
        }

        public Criteria andAttendMorStartNotIn(List<Date> values) {
            addCriterion("attend_mor_start not in", values, "attendMorStart");
            return (Criteria) this;
        }

        public Criteria andAttendMorStartBetween(Date value1, Date value2) {
            addCriterion("attend_mor_start between", value1, value2, "attendMorStart");
            return (Criteria) this;
        }

        public Criteria andAttendMorStartNotBetween(Date value1, Date value2) {
            addCriterion("attend_mor_start not between", value1, value2, "attendMorStart");
            return (Criteria) this;
        }

        public Criteria andAttendMorLeaveIsNull() {
            addCriterion("attend_mor_leave is null");
            return (Criteria) this;
        }

        public Criteria andAttendMorLeaveIsNotNull() {
            addCriterion("attend_mor_leave is not null");
            return (Criteria) this;
        }

        public Criteria andAttendMorLeaveEqualTo(Date value) {
            addCriterion("attend_mor_leave =", value, "attendMorLeave");
            return (Criteria) this;
        }

        public Criteria andAttendMorLeaveNotEqualTo(Date value) {
            addCriterion("attend_mor_leave <>", value, "attendMorLeave");
            return (Criteria) this;
        }

        public Criteria andAttendMorLeaveGreaterThan(Date value) {
            addCriterion("attend_mor_leave >", value, "attendMorLeave");
            return (Criteria) this;
        }

        public Criteria andAttendMorLeaveGreaterThanOrEqualTo(Date value) {
            addCriterion("attend_mor_leave >=", value, "attendMorLeave");
            return (Criteria) this;
        }

        public Criteria andAttendMorLeaveLessThan(Date value) {
            addCriterion("attend_mor_leave <", value, "attendMorLeave");
            return (Criteria) this;
        }

        public Criteria andAttendMorLeaveLessThanOrEqualTo(Date value) {
            addCriterion("attend_mor_leave <=", value, "attendMorLeave");
            return (Criteria) this;
        }

        public Criteria andAttendMorLeaveIn(List<Date> values) {
            addCriterion("attend_mor_leave in", values, "attendMorLeave");
            return (Criteria) this;
        }

        public Criteria andAttendMorLeaveNotIn(List<Date> values) {
            addCriterion("attend_mor_leave not in", values, "attendMorLeave");
            return (Criteria) this;
        }

        public Criteria andAttendMorLeaveBetween(Date value1, Date value2) {
            addCriterion("attend_mor_leave between", value1, value2, "attendMorLeave");
            return (Criteria) this;
        }

        public Criteria andAttendMorLeaveNotBetween(Date value1, Date value2) {
            addCriterion("attend_mor_leave not between", value1, value2, "attendMorLeave");
            return (Criteria) this;
        }

        public Criteria andAttendNoonStartIsNull() {
            addCriterion("attend_noon_start is null");
            return (Criteria) this;
        }

        public Criteria andAttendNoonStartIsNotNull() {
            addCriterion("attend_noon_start is not null");
            return (Criteria) this;
        }

        public Criteria andAttendNoonStartEqualTo(Date value) {
            addCriterion("attend_noon_start =", value, "attendNoonStart");
            return (Criteria) this;
        }

        public Criteria andAttendNoonStartNotEqualTo(Date value) {
            addCriterion("attend_noon_start <>", value, "attendNoonStart");
            return (Criteria) this;
        }

        public Criteria andAttendNoonStartGreaterThan(Date value) {
            addCriterion("attend_noon_start >", value, "attendNoonStart");
            return (Criteria) this;
        }

        public Criteria andAttendNoonStartGreaterThanOrEqualTo(Date value) {
            addCriterion("attend_noon_start >=", value, "attendNoonStart");
            return (Criteria) this;
        }

        public Criteria andAttendNoonStartLessThan(Date value) {
            addCriterion("attend_noon_start <", value, "attendNoonStart");
            return (Criteria) this;
        }

        public Criteria andAttendNoonStartLessThanOrEqualTo(Date value) {
            addCriterion("attend_noon_start <=", value, "attendNoonStart");
            return (Criteria) this;
        }

        public Criteria andAttendNoonStartIn(List<Date> values) {
            addCriterion("attend_noon_start in", values, "attendNoonStart");
            return (Criteria) this;
        }

        public Criteria andAttendNoonStartNotIn(List<Date> values) {
            addCriterion("attend_noon_start not in", values, "attendNoonStart");
            return (Criteria) this;
        }

        public Criteria andAttendNoonStartBetween(Date value1, Date value2) {
            addCriterion("attend_noon_start between", value1, value2, "attendNoonStart");
            return (Criteria) this;
        }

        public Criteria andAttendNoonStartNotBetween(Date value1, Date value2) {
            addCriterion("attend_noon_start not between", value1, value2, "attendNoonStart");
            return (Criteria) this;
        }

        public Criteria andAttendNoonLeaveIsNull() {
            addCriterion("attend_noon_leave is null");
            return (Criteria) this;
        }

        public Criteria andAttendNoonLeaveIsNotNull() {
            addCriterion("attend_noon_leave is not null");
            return (Criteria) this;
        }

        public Criteria andAttendNoonLeaveEqualTo(Date value) {
            addCriterion("attend_noon_leave =", value, "attendNoonLeave");
            return (Criteria) this;
        }

        public Criteria andAttendNoonLeaveNotEqualTo(Date value) {
            addCriterion("attend_noon_leave <>", value, "attendNoonLeave");
            return (Criteria) this;
        }

        public Criteria andAttendNoonLeaveGreaterThan(Date value) {
            addCriterion("attend_noon_leave >", value, "attendNoonLeave");
            return (Criteria) this;
        }

        public Criteria andAttendNoonLeaveGreaterThanOrEqualTo(Date value) {
            addCriterion("attend_noon_leave >=", value, "attendNoonLeave");
            return (Criteria) this;
        }

        public Criteria andAttendNoonLeaveLessThan(Date value) {
            addCriterion("attend_noon_leave <", value, "attendNoonLeave");
            return (Criteria) this;
        }

        public Criteria andAttendNoonLeaveLessThanOrEqualTo(Date value) {
            addCriterion("attend_noon_leave <=", value, "attendNoonLeave");
            return (Criteria) this;
        }

        public Criteria andAttendNoonLeaveIn(List<Date> values) {
            addCriterion("attend_noon_leave in", values, "attendNoonLeave");
            return (Criteria) this;
        }

        public Criteria andAttendNoonLeaveNotIn(List<Date> values) {
            addCriterion("attend_noon_leave not in", values, "attendNoonLeave");
            return (Criteria) this;
        }

        public Criteria andAttendNoonLeaveBetween(Date value1, Date value2) {
            addCriterion("attend_noon_leave between", value1, value2, "attendNoonLeave");
            return (Criteria) this;
        }

        public Criteria andAttendNoonLeaveNotBetween(Date value1, Date value2) {
            addCriterion("attend_noon_leave not between", value1, value2, "attendNoonLeave");
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