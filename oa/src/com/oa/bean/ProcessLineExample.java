package com.oa.bean;

import java.util.ArrayList;
import java.util.List;

public class ProcessLineExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProcessLineExample() {
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

        public Criteria andProcessLineIdIsNull() {
            addCriterion("process_line_id is null");
            return (Criteria) this;
        }

        public Criteria andProcessLineIdIsNotNull() {
            addCriterion("process_line_id is not null");
            return (Criteria) this;
        }

        public Criteria andProcessLineIdEqualTo(Integer value) {
            addCriterion("process_line_id =", value, "processLineId");
            return (Criteria) this;
        }

        public Criteria andProcessLineIdNotEqualTo(Integer value) {
            addCriterion("process_line_id <>", value, "processLineId");
            return (Criteria) this;
        }

        public Criteria andProcessLineIdGreaterThan(Integer value) {
            addCriterion("process_line_id >", value, "processLineId");
            return (Criteria) this;
        }

        public Criteria andProcessLineIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("process_line_id >=", value, "processLineId");
            return (Criteria) this;
        }

        public Criteria andProcessLineIdLessThan(Integer value) {
            addCriterion("process_line_id <", value, "processLineId");
            return (Criteria) this;
        }

        public Criteria andProcessLineIdLessThanOrEqualTo(Integer value) {
            addCriterion("process_line_id <=", value, "processLineId");
            return (Criteria) this;
        }

        public Criteria andProcessLineIdIn(List<Integer> values) {
            addCriterion("process_line_id in", values, "processLineId");
            return (Criteria) this;
        }

        public Criteria andProcessLineIdNotIn(List<Integer> values) {
            addCriterion("process_line_id not in", values, "processLineId");
            return (Criteria) this;
        }

        public Criteria andProcessLineIdBetween(Integer value1, Integer value2) {
            addCriterion("process_line_id between", value1, value2, "processLineId");
            return (Criteria) this;
        }

        public Criteria andProcessLineIdNotBetween(Integer value1, Integer value2) {
            addCriterion("process_line_id not between", value1, value2, "processLineId");
            return (Criteria) this;
        }

        public Criteria andProcessNoIsNull() {
            addCriterion("process_no is null");
            return (Criteria) this;
        }

        public Criteria andProcessNoIsNotNull() {
            addCriterion("process_no is not null");
            return (Criteria) this;
        }

        public Criteria andProcessNoEqualTo(String value) {
            addCriterion("process_no =", value, "processNo");
            return (Criteria) this;
        }

        public Criteria andProcessNoNotEqualTo(String value) {
            addCriterion("process_no <>", value, "processNo");
            return (Criteria) this;
        }

        public Criteria andProcessNoGreaterThan(String value) {
            addCriterion("process_no >", value, "processNo");
            return (Criteria) this;
        }

        public Criteria andProcessNoGreaterThanOrEqualTo(String value) {
            addCriterion("process_no >=", value, "processNo");
            return (Criteria) this;
        }

        public Criteria andProcessNoLessThan(String value) {
            addCriterion("process_no <", value, "processNo");
            return (Criteria) this;
        }

        public Criteria andProcessNoLessThanOrEqualTo(String value) {
            addCriterion("process_no <=", value, "processNo");
            return (Criteria) this;
        }

        public Criteria andProcessNoLike(String value) {
            addCriterion("process_no like", value, "processNo");
            return (Criteria) this;
        }

        public Criteria andProcessNoNotLike(String value) {
            addCriterion("process_no not like", value, "processNo");
            return (Criteria) this;
        }

        public Criteria andProcessNoIn(List<String> values) {
            addCriterion("process_no in", values, "processNo");
            return (Criteria) this;
        }

        public Criteria andProcessNoNotIn(List<String> values) {
            addCriterion("process_no not in", values, "processNo");
            return (Criteria) this;
        }

        public Criteria andProcessNoBetween(String value1, String value2) {
            addCriterion("process_no between", value1, value2, "processNo");
            return (Criteria) this;
        }

        public Criteria andProcessNoNotBetween(String value1, String value2) {
            addCriterion("process_no not between", value1, value2, "processNo");
            return (Criteria) this;
        }

        public Criteria andPreNodeIdIsNull() {
            addCriterion("pre_node_id is null");
            return (Criteria) this;
        }

        public Criteria andPreNodeIdIsNotNull() {
            addCriterion("pre_node_id is not null");
            return (Criteria) this;
        }

        public Criteria andPreNodeIdEqualTo(Integer value) {
            addCriterion("pre_node_id =", value, "preNodeId");
            return (Criteria) this;
        }

        public Criteria andPreNodeIdNotEqualTo(Integer value) {
            addCriterion("pre_node_id <>", value, "preNodeId");
            return (Criteria) this;
        }

        public Criteria andPreNodeIdGreaterThan(Integer value) {
            addCriterion("pre_node_id >", value, "preNodeId");
            return (Criteria) this;
        }

        public Criteria andPreNodeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("pre_node_id >=", value, "preNodeId");
            return (Criteria) this;
        }

        public Criteria andPreNodeIdLessThan(Integer value) {
            addCriterion("pre_node_id <", value, "preNodeId");
            return (Criteria) this;
        }

        public Criteria andPreNodeIdLessThanOrEqualTo(Integer value) {
            addCriterion("pre_node_id <=", value, "preNodeId");
            return (Criteria) this;
        }

        public Criteria andPreNodeIdIn(List<Integer> values) {
            addCriterion("pre_node_id in", values, "preNodeId");
            return (Criteria) this;
        }

        public Criteria andPreNodeIdNotIn(List<Integer> values) {
            addCriterion("pre_node_id not in", values, "preNodeId");
            return (Criteria) this;
        }

        public Criteria andPreNodeIdBetween(Integer value1, Integer value2) {
            addCriterion("pre_node_id between", value1, value2, "preNodeId");
            return (Criteria) this;
        }

        public Criteria andPreNodeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("pre_node_id not between", value1, value2, "preNodeId");
            return (Criteria) this;
        }

        public Criteria andNextNodeIdIsNull() {
            addCriterion("next_node_id is null");
            return (Criteria) this;
        }

        public Criteria andNextNodeIdIsNotNull() {
            addCriterion("next_node_id is not null");
            return (Criteria) this;
        }

        public Criteria andNextNodeIdEqualTo(Integer value) {
            addCriterion("next_node_id =", value, "nextNodeId");
            return (Criteria) this;
        }

        public Criteria andNextNodeIdNotEqualTo(Integer value) {
            addCriterion("next_node_id <>", value, "nextNodeId");
            return (Criteria) this;
        }

        public Criteria andNextNodeIdGreaterThan(Integer value) {
            addCriterion("next_node_id >", value, "nextNodeId");
            return (Criteria) this;
        }

        public Criteria andNextNodeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("next_node_id >=", value, "nextNodeId");
            return (Criteria) this;
        }

        public Criteria andNextNodeIdLessThan(Integer value) {
            addCriterion("next_node_id <", value, "nextNodeId");
            return (Criteria) this;
        }

        public Criteria andNextNodeIdLessThanOrEqualTo(Integer value) {
            addCriterion("next_node_id <=", value, "nextNodeId");
            return (Criteria) this;
        }

        public Criteria andNextNodeIdIn(List<Integer> values) {
            addCriterion("next_node_id in", values, "nextNodeId");
            return (Criteria) this;
        }

        public Criteria andNextNodeIdNotIn(List<Integer> values) {
            addCriterion("next_node_id not in", values, "nextNodeId");
            return (Criteria) this;
        }

        public Criteria andNextNodeIdBetween(Integer value1, Integer value2) {
            addCriterion("next_node_id between", value1, value2, "nextNodeId");
            return (Criteria) this;
        }

        public Criteria andNextNodeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("next_node_id not between", value1, value2, "nextNodeId");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
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