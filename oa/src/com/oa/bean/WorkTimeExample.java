package com.oa.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WorkTimeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WorkTimeExample() {
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

        public Criteria andAttendMorStartTimeIsNull() {
            addCriterion("attend_mor_start_time is null");
            return (Criteria) this;
        }

        public Criteria andAttendMorStartTimeIsNotNull() {
            addCriterion("attend_mor_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andAttendMorStartTimeEqualTo(Date value) {
            addCriterion("attend_mor_start_time =", value, "attendMorStartTime");
            return (Criteria) this;
        }

        public Criteria andAttendMorStartTimeNotEqualTo(Date value) {
            addCriterion("attend_mor_start_time <>", value, "attendMorStartTime");
            return (Criteria) this;
        }

        public Criteria andAttendMorStartTimeGreaterThan(Date value) {
            addCriterion("attend_mor_start_time >", value, "attendMorStartTime");
            return (Criteria) this;
        }

        public Criteria andAttendMorStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("attend_mor_start_time >=", value, "attendMorStartTime");
            return (Criteria) this;
        }

        public Criteria andAttendMorStartTimeLessThan(Date value) {
            addCriterion("attend_mor_start_time <", value, "attendMorStartTime");
            return (Criteria) this;
        }

        public Criteria andAttendMorStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("attend_mor_start_time <=", value, "attendMorStartTime");
            return (Criteria) this;
        }

        public Criteria andAttendMorStartTimeIn(List<Date> values) {
            addCriterion("attend_mor_start_time in", values, "attendMorStartTime");
            return (Criteria) this;
        }

        public Criteria andAttendMorStartTimeNotIn(List<Date> values) {
            addCriterion("attend_mor_start_time not in", values, "attendMorStartTime");
            return (Criteria) this;
        }

        public Criteria andAttendMorStartTimeBetween(Date value1, Date value2) {
            addCriterion("attend_mor_start_time between", value1, value2, "attendMorStartTime");
            return (Criteria) this;
        }

        public Criteria andAttendMorStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("attend_mor_start_time not between", value1, value2, "attendMorStartTime");
            return (Criteria) this;
        }

        public Criteria andAttendMorEndTimeIsNull() {
            addCriterion("attend_mor_end_time is null");
            return (Criteria) this;
        }

        public Criteria andAttendMorEndTimeIsNotNull() {
            addCriterion("attend_mor_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andAttendMorEndTimeEqualTo(Date value) {
            addCriterion("attend_mor_end_time =", value, "attendMorEndTime");
            return (Criteria) this;
        }

        public Criteria andAttendMorEndTimeNotEqualTo(Date value) {
            addCriterion("attend_mor_end_time <>", value, "attendMorEndTime");
            return (Criteria) this;
        }

        public Criteria andAttendMorEndTimeGreaterThan(Date value) {
            addCriterion("attend_mor_end_time >", value, "attendMorEndTime");
            return (Criteria) this;
        }

        public Criteria andAttendMorEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("attend_mor_end_time >=", value, "attendMorEndTime");
            return (Criteria) this;
        }

        public Criteria andAttendMorEndTimeLessThan(Date value) {
            addCriterion("attend_mor_end_time <", value, "attendMorEndTime");
            return (Criteria) this;
        }

        public Criteria andAttendMorEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("attend_mor_end_time <=", value, "attendMorEndTime");
            return (Criteria) this;
        }

        public Criteria andAttendMorEndTimeIn(List<Date> values) {
            addCriterion("attend_mor_end_time in", values, "attendMorEndTime");
            return (Criteria) this;
        }

        public Criteria andAttendMorEndTimeNotIn(List<Date> values) {
            addCriterion("attend_mor_end_time not in", values, "attendMorEndTime");
            return (Criteria) this;
        }

        public Criteria andAttendMorEndTimeBetween(Date value1, Date value2) {
            addCriterion("attend_mor_end_time between", value1, value2, "attendMorEndTime");
            return (Criteria) this;
        }

        public Criteria andAttendMorEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("attend_mor_end_time not between", value1, value2, "attendMorEndTime");
            return (Criteria) this;
        }

        public Criteria andWorkMorStartTimeIsNull() {
            addCriterion("work_mor_start_time is null");
            return (Criteria) this;
        }

        public Criteria andWorkMorStartTimeIsNotNull() {
            addCriterion("work_mor_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andWorkMorStartTimeEqualTo(Date value) {
            addCriterion("work_mor_start_time =", value, "workMorStartTime");
            return (Criteria) this;
        }

        public Criteria andWorkMorStartTimeNotEqualTo(Date value) {
            addCriterion("work_mor_start_time <>", value, "workMorStartTime");
            return (Criteria) this;
        }

        public Criteria andWorkMorStartTimeGreaterThan(Date value) {
            addCriterion("work_mor_start_time >", value, "workMorStartTime");
            return (Criteria) this;
        }

        public Criteria andWorkMorStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("work_mor_start_time >=", value, "workMorStartTime");
            return (Criteria) this;
        }

        public Criteria andWorkMorStartTimeLessThan(Date value) {
            addCriterion("work_mor_start_time <", value, "workMorStartTime");
            return (Criteria) this;
        }

        public Criteria andWorkMorStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("work_mor_start_time <=", value, "workMorStartTime");
            return (Criteria) this;
        }

        public Criteria andWorkMorStartTimeIn(List<Date> values) {
            addCriterion("work_mor_start_time in", values, "workMorStartTime");
            return (Criteria) this;
        }

        public Criteria andWorkMorStartTimeNotIn(List<Date> values) {
            addCriterion("work_mor_start_time not in", values, "workMorStartTime");
            return (Criteria) this;
        }

        public Criteria andWorkMorStartTimeBetween(Date value1, Date value2) {
            addCriterion("work_mor_start_time between", value1, value2, "workMorStartTime");
            return (Criteria) this;
        }

        public Criteria andWorkMorStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("work_mor_start_time not between", value1, value2, "workMorStartTime");
            return (Criteria) this;
        }

        public Criteria andWorkMorEndTimeIsNull() {
            addCriterion("work_mor_end_time is null");
            return (Criteria) this;
        }

        public Criteria andWorkMorEndTimeIsNotNull() {
            addCriterion("work_mor_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andWorkMorEndTimeEqualTo(Date value) {
            addCriterion("work_mor_end_time =", value, "workMorEndTime");
            return (Criteria) this;
        }

        public Criteria andWorkMorEndTimeNotEqualTo(Date value) {
            addCriterion("work_mor_end_time <>", value, "workMorEndTime");
            return (Criteria) this;
        }

        public Criteria andWorkMorEndTimeGreaterThan(Date value) {
            addCriterion("work_mor_end_time >", value, "workMorEndTime");
            return (Criteria) this;
        }

        public Criteria andWorkMorEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("work_mor_end_time >=", value, "workMorEndTime");
            return (Criteria) this;
        }

        public Criteria andWorkMorEndTimeLessThan(Date value) {
            addCriterion("work_mor_end_time <", value, "workMorEndTime");
            return (Criteria) this;
        }

        public Criteria andWorkMorEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("work_mor_end_time <=", value, "workMorEndTime");
            return (Criteria) this;
        }

        public Criteria andWorkMorEndTimeIn(List<Date> values) {
            addCriterion("work_mor_end_time in", values, "workMorEndTime");
            return (Criteria) this;
        }

        public Criteria andWorkMorEndTimeNotIn(List<Date> values) {
            addCriterion("work_mor_end_time not in", values, "workMorEndTime");
            return (Criteria) this;
        }

        public Criteria andWorkMorEndTimeBetween(Date value1, Date value2) {
            addCriterion("work_mor_end_time between", value1, value2, "workMorEndTime");
            return (Criteria) this;
        }

        public Criteria andWorkMorEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("work_mor_end_time not between", value1, value2, "workMorEndTime");
            return (Criteria) this;
        }

        public Criteria andAttendMorLeaveStartTimeIsNull() {
            addCriterion("attend_mor_leave_start_time is null");
            return (Criteria) this;
        }

        public Criteria andAttendMorLeaveStartTimeIsNotNull() {
            addCriterion("attend_mor_leave_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andAttendMorLeaveStartTimeEqualTo(Date value) {
            addCriterion("attend_mor_leave_start_time =", value, "attendMorLeaveStartTime");
            return (Criteria) this;
        }

        public Criteria andAttendMorLeaveStartTimeNotEqualTo(Date value) {
            addCriterion("attend_mor_leave_start_time <>", value, "attendMorLeaveStartTime");
            return (Criteria) this;
        }

        public Criteria andAttendMorLeaveStartTimeGreaterThan(Date value) {
            addCriterion("attend_mor_leave_start_time >", value, "attendMorLeaveStartTime");
            return (Criteria) this;
        }

        public Criteria andAttendMorLeaveStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("attend_mor_leave_start_time >=", value, "attendMorLeaveStartTime");
            return (Criteria) this;
        }

        public Criteria andAttendMorLeaveStartTimeLessThan(Date value) {
            addCriterion("attend_mor_leave_start_time <", value, "attendMorLeaveStartTime");
            return (Criteria) this;
        }

        public Criteria andAttendMorLeaveStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("attend_mor_leave_start_time <=", value, "attendMorLeaveStartTime");
            return (Criteria) this;
        }

        public Criteria andAttendMorLeaveStartTimeIn(List<Date> values) {
            addCriterion("attend_mor_leave_start_time in", values, "attendMorLeaveStartTime");
            return (Criteria) this;
        }

        public Criteria andAttendMorLeaveStartTimeNotIn(List<Date> values) {
            addCriterion("attend_mor_leave_start_time not in", values, "attendMorLeaveStartTime");
            return (Criteria) this;
        }

        public Criteria andAttendMorLeaveStartTimeBetween(Date value1, Date value2) {
            addCriterion("attend_mor_leave_start_time between", value1, value2, "attendMorLeaveStartTime");
            return (Criteria) this;
        }

        public Criteria andAttendMorLeaveStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("attend_mor_leave_start_time not between", value1, value2, "attendMorLeaveStartTime");
            return (Criteria) this;
        }

        public Criteria andAttendMorLeaveEndTimeIsNull() {
            addCriterion("attend_mor_leave_end_time is null");
            return (Criteria) this;
        }

        public Criteria andAttendMorLeaveEndTimeIsNotNull() {
            addCriterion("attend_mor_leave_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andAttendMorLeaveEndTimeEqualTo(Date value) {
            addCriterion("attend_mor_leave_end_time =", value, "attendMorLeaveEndTime");
            return (Criteria) this;
        }

        public Criteria andAttendMorLeaveEndTimeNotEqualTo(Date value) {
            addCriterion("attend_mor_leave_end_time <>", value, "attendMorLeaveEndTime");
            return (Criteria) this;
        }

        public Criteria andAttendMorLeaveEndTimeGreaterThan(Date value) {
            addCriterion("attend_mor_leave_end_time >", value, "attendMorLeaveEndTime");
            return (Criteria) this;
        }

        public Criteria andAttendMorLeaveEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("attend_mor_leave_end_time >=", value, "attendMorLeaveEndTime");
            return (Criteria) this;
        }

        public Criteria andAttendMorLeaveEndTimeLessThan(Date value) {
            addCriterion("attend_mor_leave_end_time <", value, "attendMorLeaveEndTime");
            return (Criteria) this;
        }

        public Criteria andAttendMorLeaveEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("attend_mor_leave_end_time <=", value, "attendMorLeaveEndTime");
            return (Criteria) this;
        }

        public Criteria andAttendMorLeaveEndTimeIn(List<Date> values) {
            addCriterion("attend_mor_leave_end_time in", values, "attendMorLeaveEndTime");
            return (Criteria) this;
        }

        public Criteria andAttendMorLeaveEndTimeNotIn(List<Date> values) {
            addCriterion("attend_mor_leave_end_time not in", values, "attendMorLeaveEndTime");
            return (Criteria) this;
        }

        public Criteria andAttendMorLeaveEndTimeBetween(Date value1, Date value2) {
            addCriterion("attend_mor_leave_end_time between", value1, value2, "attendMorLeaveEndTime");
            return (Criteria) this;
        }

        public Criteria andAttendMorLeaveEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("attend_mor_leave_end_time not between", value1, value2, "attendMorLeaveEndTime");
            return (Criteria) this;
        }

        public Criteria andAttendAfternoonStartTimeIsNull() {
            addCriterion("attend_afternoon_start_time is null");
            return (Criteria) this;
        }

        public Criteria andAttendAfternoonStartTimeIsNotNull() {
            addCriterion("attend_afternoon_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andAttendAfternoonStartTimeEqualTo(Date value) {
            addCriterion("attend_afternoon_start_time =", value, "attendAfternoonStartTime");
            return (Criteria) this;
        }

        public Criteria andAttendAfternoonStartTimeNotEqualTo(Date value) {
            addCriterion("attend_afternoon_start_time <>", value, "attendAfternoonStartTime");
            return (Criteria) this;
        }

        public Criteria andAttendAfternoonStartTimeGreaterThan(Date value) {
            addCriterion("attend_afternoon_start_time >", value, "attendAfternoonStartTime");
            return (Criteria) this;
        }

        public Criteria andAttendAfternoonStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("attend_afternoon_start_time >=", value, "attendAfternoonStartTime");
            return (Criteria) this;
        }

        public Criteria andAttendAfternoonStartTimeLessThan(Date value) {
            addCriterion("attend_afternoon_start_time <", value, "attendAfternoonStartTime");
            return (Criteria) this;
        }

        public Criteria andAttendAfternoonStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("attend_afternoon_start_time <=", value, "attendAfternoonStartTime");
            return (Criteria) this;
        }

        public Criteria andAttendAfternoonStartTimeIn(List<Date> values) {
            addCriterion("attend_afternoon_start_time in", values, "attendAfternoonStartTime");
            return (Criteria) this;
        }

        public Criteria andAttendAfternoonStartTimeNotIn(List<Date> values) {
            addCriterion("attend_afternoon_start_time not in", values, "attendAfternoonStartTime");
            return (Criteria) this;
        }

        public Criteria andAttendAfternoonStartTimeBetween(Date value1, Date value2) {
            addCriterion("attend_afternoon_start_time between", value1, value2, "attendAfternoonStartTime");
            return (Criteria) this;
        }

        public Criteria andAttendAfternoonStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("attend_afternoon_start_time not between", value1, value2, "attendAfternoonStartTime");
            return (Criteria) this;
        }

        public Criteria andAttendAfternoonEndTimeIsNull() {
            addCriterion("attend_afternoon_end_time is null");
            return (Criteria) this;
        }

        public Criteria andAttendAfternoonEndTimeIsNotNull() {
            addCriterion("attend_afternoon_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andAttendAfternoonEndTimeEqualTo(Date value) {
            addCriterion("attend_afternoon_end_time =", value, "attendAfternoonEndTime");
            return (Criteria) this;
        }

        public Criteria andAttendAfternoonEndTimeNotEqualTo(Date value) {
            addCriterion("attend_afternoon_end_time <>", value, "attendAfternoonEndTime");
            return (Criteria) this;
        }

        public Criteria andAttendAfternoonEndTimeGreaterThan(Date value) {
            addCriterion("attend_afternoon_end_time >", value, "attendAfternoonEndTime");
            return (Criteria) this;
        }

        public Criteria andAttendAfternoonEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("attend_afternoon_end_time >=", value, "attendAfternoonEndTime");
            return (Criteria) this;
        }

        public Criteria andAttendAfternoonEndTimeLessThan(Date value) {
            addCriterion("attend_afternoon_end_time <", value, "attendAfternoonEndTime");
            return (Criteria) this;
        }

        public Criteria andAttendAfternoonEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("attend_afternoon_end_time <=", value, "attendAfternoonEndTime");
            return (Criteria) this;
        }

        public Criteria andAttendAfternoonEndTimeIn(List<Date> values) {
            addCriterion("attend_afternoon_end_time in", values, "attendAfternoonEndTime");
            return (Criteria) this;
        }

        public Criteria andAttendAfternoonEndTimeNotIn(List<Date> values) {
            addCriterion("attend_afternoon_end_time not in", values, "attendAfternoonEndTime");
            return (Criteria) this;
        }

        public Criteria andAttendAfternoonEndTimeBetween(Date value1, Date value2) {
            addCriterion("attend_afternoon_end_time between", value1, value2, "attendAfternoonEndTime");
            return (Criteria) this;
        }

        public Criteria andAttendAfternoonEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("attend_afternoon_end_time not between", value1, value2, "attendAfternoonEndTime");
            return (Criteria) this;
        }

        public Criteria andWorkStartTimeAfternoonIsNull() {
            addCriterion("work_start_time_afternoon is null");
            return (Criteria) this;
        }

        public Criteria andWorkStartTimeAfternoonIsNotNull() {
            addCriterion("work_start_time_afternoon is not null");
            return (Criteria) this;
        }

        public Criteria andWorkStartTimeAfternoonEqualTo(Date value) {
            addCriterion("work_start_time_afternoon =", value, "workStartTimeAfternoon");
            return (Criteria) this;
        }

        public Criteria andWorkStartTimeAfternoonNotEqualTo(Date value) {
            addCriterion("work_start_time_afternoon <>", value, "workStartTimeAfternoon");
            return (Criteria) this;
        }

        public Criteria andWorkStartTimeAfternoonGreaterThan(Date value) {
            addCriterion("work_start_time_afternoon >", value, "workStartTimeAfternoon");
            return (Criteria) this;
        }

        public Criteria andWorkStartTimeAfternoonGreaterThanOrEqualTo(Date value) {
            addCriterion("work_start_time_afternoon >=", value, "workStartTimeAfternoon");
            return (Criteria) this;
        }

        public Criteria andWorkStartTimeAfternoonLessThan(Date value) {
            addCriterion("work_start_time_afternoon <", value, "workStartTimeAfternoon");
            return (Criteria) this;
        }

        public Criteria andWorkStartTimeAfternoonLessThanOrEqualTo(Date value) {
            addCriterion("work_start_time_afternoon <=", value, "workStartTimeAfternoon");
            return (Criteria) this;
        }

        public Criteria andWorkStartTimeAfternoonIn(List<Date> values) {
            addCriterion("work_start_time_afternoon in", values, "workStartTimeAfternoon");
            return (Criteria) this;
        }

        public Criteria andWorkStartTimeAfternoonNotIn(List<Date> values) {
            addCriterion("work_start_time_afternoon not in", values, "workStartTimeAfternoon");
            return (Criteria) this;
        }

        public Criteria andWorkStartTimeAfternoonBetween(Date value1, Date value2) {
            addCriterion("work_start_time_afternoon between", value1, value2, "workStartTimeAfternoon");
            return (Criteria) this;
        }

        public Criteria andWorkStartTimeAfternoonNotBetween(Date value1, Date value2) {
            addCriterion("work_start_time_afternoon not between", value1, value2, "workStartTimeAfternoon");
            return (Criteria) this;
        }

        public Criteria andWorkEndTimeAfternoonIsNull() {
            addCriterion("work_end_time_afternoon is null");
            return (Criteria) this;
        }

        public Criteria andWorkEndTimeAfternoonIsNotNull() {
            addCriterion("work_end_time_afternoon is not null");
            return (Criteria) this;
        }

        public Criteria andWorkEndTimeAfternoonEqualTo(Date value) {
            addCriterion("work_end_time_afternoon =", value, "workEndTimeAfternoon");
            return (Criteria) this;
        }

        public Criteria andWorkEndTimeAfternoonNotEqualTo(Date value) {
            addCriterion("work_end_time_afternoon <>", value, "workEndTimeAfternoon");
            return (Criteria) this;
        }

        public Criteria andWorkEndTimeAfternoonGreaterThan(Date value) {
            addCriterion("work_end_time_afternoon >", value, "workEndTimeAfternoon");
            return (Criteria) this;
        }

        public Criteria andWorkEndTimeAfternoonGreaterThanOrEqualTo(Date value) {
            addCriterion("work_end_time_afternoon >=", value, "workEndTimeAfternoon");
            return (Criteria) this;
        }

        public Criteria andWorkEndTimeAfternoonLessThan(Date value) {
            addCriterion("work_end_time_afternoon <", value, "workEndTimeAfternoon");
            return (Criteria) this;
        }

        public Criteria andWorkEndTimeAfternoonLessThanOrEqualTo(Date value) {
            addCriterion("work_end_time_afternoon <=", value, "workEndTimeAfternoon");
            return (Criteria) this;
        }

        public Criteria andWorkEndTimeAfternoonIn(List<Date> values) {
            addCriterion("work_end_time_afternoon in", values, "workEndTimeAfternoon");
            return (Criteria) this;
        }

        public Criteria andWorkEndTimeAfternoonNotIn(List<Date> values) {
            addCriterion("work_end_time_afternoon not in", values, "workEndTimeAfternoon");
            return (Criteria) this;
        }

        public Criteria andWorkEndTimeAfternoonBetween(Date value1, Date value2) {
            addCriterion("work_end_time_afternoon between", value1, value2, "workEndTimeAfternoon");
            return (Criteria) this;
        }

        public Criteria andWorkEndTimeAfternoonNotBetween(Date value1, Date value2) {
            addCriterion("work_end_time_afternoon not between", value1, value2, "workEndTimeAfternoon");
            return (Criteria) this;
        }

        public Criteria andAttendAfterLeaveStartTimeIsNull() {
            addCriterion("attend_after_leave_start_time is null");
            return (Criteria) this;
        }

        public Criteria andAttendAfterLeaveStartTimeIsNotNull() {
            addCriterion("attend_after_leave_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andAttendAfterLeaveStartTimeEqualTo(Date value) {
            addCriterion("attend_after_leave_start_time =", value, "attendAfterLeaveStartTime");
            return (Criteria) this;
        }

        public Criteria andAttendAfterLeaveStartTimeNotEqualTo(Date value) {
            addCriterion("attend_after_leave_start_time <>", value, "attendAfterLeaveStartTime");
            return (Criteria) this;
        }

        public Criteria andAttendAfterLeaveStartTimeGreaterThan(Date value) {
            addCriterion("attend_after_leave_start_time >", value, "attendAfterLeaveStartTime");
            return (Criteria) this;
        }

        public Criteria andAttendAfterLeaveStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("attend_after_leave_start_time >=", value, "attendAfterLeaveStartTime");
            return (Criteria) this;
        }

        public Criteria andAttendAfterLeaveStartTimeLessThan(Date value) {
            addCriterion("attend_after_leave_start_time <", value, "attendAfterLeaveStartTime");
            return (Criteria) this;
        }

        public Criteria andAttendAfterLeaveStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("attend_after_leave_start_time <=", value, "attendAfterLeaveStartTime");
            return (Criteria) this;
        }

        public Criteria andAttendAfterLeaveStartTimeIn(List<Date> values) {
            addCriterion("attend_after_leave_start_time in", values, "attendAfterLeaveStartTime");
            return (Criteria) this;
        }

        public Criteria andAttendAfterLeaveStartTimeNotIn(List<Date> values) {
            addCriterion("attend_after_leave_start_time not in", values, "attendAfterLeaveStartTime");
            return (Criteria) this;
        }

        public Criteria andAttendAfterLeaveStartTimeBetween(Date value1, Date value2) {
            addCriterion("attend_after_leave_start_time between", value1, value2, "attendAfterLeaveStartTime");
            return (Criteria) this;
        }

        public Criteria andAttendAfterLeaveStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("attend_after_leave_start_time not between", value1, value2, "attendAfterLeaveStartTime");
            return (Criteria) this;
        }

        public Criteria andAttendAfterLeaveEndTimeIsNull() {
            addCriterion("attend_after_leave_end_time is null");
            return (Criteria) this;
        }

        public Criteria andAttendAfterLeaveEndTimeIsNotNull() {
            addCriterion("attend_after_leave_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andAttendAfterLeaveEndTimeEqualTo(Date value) {
            addCriterion("attend_after_leave_end_time =", value, "attendAfterLeaveEndTime");
            return (Criteria) this;
        }

        public Criteria andAttendAfterLeaveEndTimeNotEqualTo(Date value) {
            addCriterion("attend_after_leave_end_time <>", value, "attendAfterLeaveEndTime");
            return (Criteria) this;
        }

        public Criteria andAttendAfterLeaveEndTimeGreaterThan(Date value) {
            addCriterion("attend_after_leave_end_time >", value, "attendAfterLeaveEndTime");
            return (Criteria) this;
        }

        public Criteria andAttendAfterLeaveEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("attend_after_leave_end_time >=", value, "attendAfterLeaveEndTime");
            return (Criteria) this;
        }

        public Criteria andAttendAfterLeaveEndTimeLessThan(Date value) {
            addCriterion("attend_after_leave_end_time <", value, "attendAfterLeaveEndTime");
            return (Criteria) this;
        }

        public Criteria andAttendAfterLeaveEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("attend_after_leave_end_time <=", value, "attendAfterLeaveEndTime");
            return (Criteria) this;
        }

        public Criteria andAttendAfterLeaveEndTimeIn(List<Date> values) {
            addCriterion("attend_after_leave_end_time in", values, "attendAfterLeaveEndTime");
            return (Criteria) this;
        }

        public Criteria andAttendAfterLeaveEndTimeNotIn(List<Date> values) {
            addCriterion("attend_after_leave_end_time not in", values, "attendAfterLeaveEndTime");
            return (Criteria) this;
        }

        public Criteria andAttendAfterLeaveEndTimeBetween(Date value1, Date value2) {
            addCriterion("attend_after_leave_end_time between", value1, value2, "attendAfterLeaveEndTime");
            return (Criteria) this;
        }

        public Criteria andAttendAfterLeaveEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("attend_after_leave_end_time not between", value1, value2, "attendAfterLeaveEndTime");
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