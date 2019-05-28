package com.oa.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AttendCountExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AttendCountExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
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

        public Criteria andAbsenceCountIsNull() {
            addCriterion("absence_count is null");
            return (Criteria) this;
        }

        public Criteria andAbsenceCountIsNotNull() {
            addCriterion("absence_count is not null");
            return (Criteria) this;
        }

        public Criteria andAbsenceCountEqualTo(Integer value) {
            addCriterion("absence_count =", value, "absenceCount");
            return (Criteria) this;
        }

        public Criteria andAbsenceCountNotEqualTo(Integer value) {
            addCriterion("absence_count <>", value, "absenceCount");
            return (Criteria) this;
        }

        public Criteria andAbsenceCountGreaterThan(Integer value) {
            addCriterion("absence_count >", value, "absenceCount");
            return (Criteria) this;
        }

        public Criteria andAbsenceCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("absence_count >=", value, "absenceCount");
            return (Criteria) this;
        }

        public Criteria andAbsenceCountLessThan(Integer value) {
            addCriterion("absence_count <", value, "absenceCount");
            return (Criteria) this;
        }

        public Criteria andAbsenceCountLessThanOrEqualTo(Integer value) {
            addCriterion("absence_count <=", value, "absenceCount");
            return (Criteria) this;
        }

        public Criteria andAbsenceCountIn(List<Integer> values) {
            addCriterion("absence_count in", values, "absenceCount");
            return (Criteria) this;
        }

        public Criteria andAbsenceCountNotIn(List<Integer> values) {
            addCriterion("absence_count not in", values, "absenceCount");
            return (Criteria) this;
        }

        public Criteria andAbsenceCountBetween(Integer value1, Integer value2) {
            addCriterion("absence_count between", value1, value2, "absenceCount");
            return (Criteria) this;
        }

        public Criteria andAbsenceCountNotBetween(Integer value1, Integer value2) {
            addCriterion("absence_count not between", value1, value2, "absenceCount");
            return (Criteria) this;
        }

        public Criteria andDateYearIsNull() {
            addCriterion("date_year is null");
            return (Criteria) this;
        }

        public Criteria andDateYearIsNotNull() {
            addCriterion("date_year is not null");
            return (Criteria) this;
        }

        public Criteria andDateYearEqualTo(String value) {
            addCriterion("date_year =", value, "dateYear");
            return (Criteria) this;
        }

        public Criteria andDateYearNotEqualTo(String value) {
            addCriterion("date_year <>", value, "dateYear");
            return (Criteria) this;
        }

        public Criteria andDateYearGreaterThan(String value) {
            addCriterion("date_year >", value, "dateYear");
            return (Criteria) this;
        }

        public Criteria andDateYearGreaterThanOrEqualTo(String value) {
            addCriterion("date_year >=", value, "dateYear");
            return (Criteria) this;
        }

        public Criteria andDateYearLessThan(String value) {
            addCriterion("date_year <", value, "dateYear");
            return (Criteria) this;
        }

        public Criteria andDateYearLessThanOrEqualTo(String value) {
            addCriterion("date_year <=", value, "dateYear");
            return (Criteria) this;
        }

        public Criteria andDateYearLike(String value) {
            addCriterion("date_year like", value, "dateYear");
            return (Criteria) this;
        }

        public Criteria andDateYearNotLike(String value) {
            addCriterion("date_year not like", value, "dateYear");
            return (Criteria) this;
        }

        public Criteria andDateYearIn(List<String> values) {
            addCriterion("date_year in", values, "dateYear");
            return (Criteria) this;
        }

        public Criteria andDateYearNotIn(List<String> values) {
            addCriterion("date_year not in", values, "dateYear");
            return (Criteria) this;
        }

        public Criteria andDateYearBetween(String value1, String value2) {
            addCriterion("date_year between", value1, value2, "dateYear");
            return (Criteria) this;
        }

        public Criteria andDateYearNotBetween(String value1, String value2) {
            addCriterion("date_year not between", value1, value2, "dateYear");
            return (Criteria) this;
        }

        public Criteria andDateMothIsNull() {
            addCriterion("date_moth is null");
            return (Criteria) this;
        }

        public Criteria andDateMothIsNotNull() {
            addCriterion("date_moth is not null");
            return (Criteria) this;
        }

        public Criteria andDateMothEqualTo(String value) {
            addCriterion("date_moth =", value, "dateMoth");
            return (Criteria) this;
        }

        public Criteria andDateMothNotEqualTo(String value) {
            addCriterion("date_moth <>", value, "dateMoth");
            return (Criteria) this;
        }

        public Criteria andDateMothGreaterThan(String value) {
            addCriterion("date_moth >", value, "dateMoth");
            return (Criteria) this;
        }

        public Criteria andDateMothGreaterThanOrEqualTo(String value) {
            addCriterion("date_moth >=", value, "dateMoth");
            return (Criteria) this;
        }

        public Criteria andDateMothLessThan(String value) {
            addCriterion("date_moth <", value, "dateMoth");
            return (Criteria) this;
        }

        public Criteria andDateMothLessThanOrEqualTo(String value) {
            addCriterion("date_moth <=", value, "dateMoth");
            return (Criteria) this;
        }

        public Criteria andDateMothLike(String value) {
            addCriterion("date_moth like", value, "dateMoth");
            return (Criteria) this;
        }

        public Criteria andDateMothNotLike(String value) {
            addCriterion("date_moth not like", value, "dateMoth");
            return (Criteria) this;
        }

        public Criteria andDateMothIn(List<String> values) {
            addCriterion("date_moth in", values, "dateMoth");
            return (Criteria) this;
        }

        public Criteria andDateMothNotIn(List<String> values) {
            addCriterion("date_moth not in", values, "dateMoth");
            return (Criteria) this;
        }

        public Criteria andDateMothBetween(String value1, String value2) {
            addCriterion("date_moth between", value1, value2, "dateMoth");
            return (Criteria) this;
        }

        public Criteria andDateMothNotBetween(String value1, String value2) {
            addCriterion("date_moth not between", value1, value2, "dateMoth");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeLengthIsNull() {
            addCriterion("leave_time_length is null");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeLengthIsNotNull() {
            addCriterion("leave_time_length is not null");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeLengthEqualTo(Integer value) {
            addCriterion("leave_time_length =", value, "leaveTimeLength");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeLengthNotEqualTo(Integer value) {
            addCriterion("leave_time_length <>", value, "leaveTimeLength");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeLengthGreaterThan(Integer value) {
            addCriterion("leave_time_length >", value, "leaveTimeLength");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeLengthGreaterThanOrEqualTo(Integer value) {
            addCriterion("leave_time_length >=", value, "leaveTimeLength");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeLengthLessThan(Integer value) {
            addCriterion("leave_time_length <", value, "leaveTimeLength");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeLengthLessThanOrEqualTo(Integer value) {
            addCriterion("leave_time_length <=", value, "leaveTimeLength");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeLengthIn(List<Integer> values) {
            addCriterion("leave_time_length in", values, "leaveTimeLength");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeLengthNotIn(List<Integer> values) {
            addCriterion("leave_time_length not in", values, "leaveTimeLength");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeLengthBetween(Integer value1, Integer value2) {
            addCriterion("leave_time_length between", value1, value2, "leaveTimeLength");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeLengthNotBetween(Integer value1, Integer value2) {
            addCriterion("leave_time_length not between", value1, value2, "leaveTimeLength");
            return (Criteria) this;
        }

        public Criteria andLateTimeLengthIsNull() {
            addCriterion("late_time_length is null");
            return (Criteria) this;
        }

        public Criteria andLateTimeLengthIsNotNull() {
            addCriterion("late_time_length is not null");
            return (Criteria) this;
        }

        public Criteria andLateTimeLengthEqualTo(Integer value) {
            addCriterion("late_time_length =", value, "lateTimeLength");
            return (Criteria) this;
        }

        public Criteria andLateTimeLengthNotEqualTo(Integer value) {
            addCriterion("late_time_length <>", value, "lateTimeLength");
            return (Criteria) this;
        }

        public Criteria andLateTimeLengthGreaterThan(Integer value) {
            addCriterion("late_time_length >", value, "lateTimeLength");
            return (Criteria) this;
        }

        public Criteria andLateTimeLengthGreaterThanOrEqualTo(Integer value) {
            addCriterion("late_time_length >=", value, "lateTimeLength");
            return (Criteria) this;
        }

        public Criteria andLateTimeLengthLessThan(Integer value) {
            addCriterion("late_time_length <", value, "lateTimeLength");
            return (Criteria) this;
        }

        public Criteria andLateTimeLengthLessThanOrEqualTo(Integer value) {
            addCriterion("late_time_length <=", value, "lateTimeLength");
            return (Criteria) this;
        }

        public Criteria andLateTimeLengthIn(List<Integer> values) {
            addCriterion("late_time_length in", values, "lateTimeLength");
            return (Criteria) this;
        }

        public Criteria andLateTimeLengthNotIn(List<Integer> values) {
            addCriterion("late_time_length not in", values, "lateTimeLength");
            return (Criteria) this;
        }

        public Criteria andLateTimeLengthBetween(Integer value1, Integer value2) {
            addCriterion("late_time_length between", value1, value2, "lateTimeLength");
            return (Criteria) this;
        }

        public Criteria andLateTimeLengthNotBetween(Integer value1, Integer value2) {
            addCriterion("late_time_length not between", value1, value2, "lateTimeLength");
            return (Criteria) this;
        }

        public Criteria andLateCountIsNull() {
            addCriterion("late_count is null");
            return (Criteria) this;
        }

        public Criteria andLateCountIsNotNull() {
            addCriterion("late_count is not null");
            return (Criteria) this;
        }

        public Criteria andLateCountEqualTo(Integer value) {
            addCriterion("late_count =", value, "lateCount");
            return (Criteria) this;
        }

        public Criteria andLateCountNotEqualTo(Integer value) {
            addCriterion("late_count <>", value, "lateCount");
            return (Criteria) this;
        }

        public Criteria andLateCountGreaterThan(Integer value) {
            addCriterion("late_count >", value, "lateCount");
            return (Criteria) this;
        }

        public Criteria andLateCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("late_count >=", value, "lateCount");
            return (Criteria) this;
        }

        public Criteria andLateCountLessThan(Integer value) {
            addCriterion("late_count <", value, "lateCount");
            return (Criteria) this;
        }

        public Criteria andLateCountLessThanOrEqualTo(Integer value) {
            addCriterion("late_count <=", value, "lateCount");
            return (Criteria) this;
        }

        public Criteria andLateCountIn(List<Integer> values) {
            addCriterion("late_count in", values, "lateCount");
            return (Criteria) this;
        }

        public Criteria andLateCountNotIn(List<Integer> values) {
            addCriterion("late_count not in", values, "lateCount");
            return (Criteria) this;
        }

        public Criteria andLateCountBetween(Integer value1, Integer value2) {
            addCriterion("late_count between", value1, value2, "lateCount");
            return (Criteria) this;
        }

        public Criteria andLateCountNotBetween(Integer value1, Integer value2) {
            addCriterion("late_count not between", value1, value2, "lateCount");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
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