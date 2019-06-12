package com.oa.bean;

import java.util.ArrayList;
import java.util.List;

public class ProcessNodeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProcessNodeExample() {
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

        public Criteria andProcessNodeIdIsNull() {
            addCriterion("process_node_id is null");
            return (Criteria) this;
        }

        public Criteria andProcessNodeIdIsNotNull() {
            addCriterion("process_node_id is not null");
            return (Criteria) this;
        }

        public Criteria andProcessNodeIdEqualTo(Integer value) {
            addCriterion("process_node_id =", value, "processNodeId");
            return (Criteria) this;
        }

        public Criteria andProcessNodeIdNotEqualTo(Integer value) {
            addCriterion("process_node_id <>", value, "processNodeId");
            return (Criteria) this;
        }

        public Criteria andProcessNodeIdGreaterThan(Integer value) {
            addCriterion("process_node_id >", value, "processNodeId");
            return (Criteria) this;
        }

        public Criteria andProcessNodeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("process_node_id >=", value, "processNodeId");
            return (Criteria) this;
        }

        public Criteria andProcessNodeIdLessThan(Integer value) {
            addCriterion("process_node_id <", value, "processNodeId");
            return (Criteria) this;
        }

        public Criteria andProcessNodeIdLessThanOrEqualTo(Integer value) {
            addCriterion("process_node_id <=", value, "processNodeId");
            return (Criteria) this;
        }

        public Criteria andProcessNodeIdIn(List<Integer> values) {
            addCriterion("process_node_id in", values, "processNodeId");
            return (Criteria) this;
        }

        public Criteria andProcessNodeIdNotIn(List<Integer> values) {
            addCriterion("process_node_id not in", values, "processNodeId");
            return (Criteria) this;
        }

        public Criteria andProcessNodeIdBetween(Integer value1, Integer value2) {
            addCriterion("process_node_id between", value1, value2, "processNodeId");
            return (Criteria) this;
        }

        public Criteria andProcessNodeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("process_node_id not between", value1, value2, "processNodeId");
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

        public Criteria andProcessNodeNameIsNull() {
            addCriterion("process_node_name is null");
            return (Criteria) this;
        }

        public Criteria andProcessNodeNameIsNotNull() {
            addCriterion("process_node_name is not null");
            return (Criteria) this;
        }

        public Criteria andProcessNodeNameEqualTo(String value) {
            addCriterion("process_node_name =", value, "processNodeName");
            return (Criteria) this;
        }

        public Criteria andProcessNodeNameNotEqualTo(String value) {
            addCriterion("process_node_name <>", value, "processNodeName");
            return (Criteria) this;
        }

        public Criteria andProcessNodeNameGreaterThan(String value) {
            addCriterion("process_node_name >", value, "processNodeName");
            return (Criteria) this;
        }

        public Criteria andProcessNodeNameGreaterThanOrEqualTo(String value) {
            addCriterion("process_node_name >=", value, "processNodeName");
            return (Criteria) this;
        }

        public Criteria andProcessNodeNameLessThan(String value) {
            addCriterion("process_node_name <", value, "processNodeName");
            return (Criteria) this;
        }

        public Criteria andProcessNodeNameLessThanOrEqualTo(String value) {
            addCriterion("process_node_name <=", value, "processNodeName");
            return (Criteria) this;
        }

        public Criteria andProcessNodeNameLike(String value) {
            addCriterion("process_node_name like", value, "processNodeName");
            return (Criteria) this;
        }

        public Criteria andProcessNodeNameNotLike(String value) {
            addCriterion("process_node_name not like", value, "processNodeName");
            return (Criteria) this;
        }

        public Criteria andProcessNodeNameIn(List<String> values) {
            addCriterion("process_node_name in", values, "processNodeName");
            return (Criteria) this;
        }

        public Criteria andProcessNodeNameNotIn(List<String> values) {
            addCriterion("process_node_name not in", values, "processNodeName");
            return (Criteria) this;
        }

        public Criteria andProcessNodeNameBetween(String value1, String value2) {
            addCriterion("process_node_name between", value1, value2, "processNodeName");
            return (Criteria) this;
        }

        public Criteria andProcessNodeNameNotBetween(String value1, String value2) {
            addCriterion("process_node_name not between", value1, value2, "processNodeName");
            return (Criteria) this;
        }

        public Criteria andProcessNodeRoleIsNull() {
            addCriterion("process_node_role is null");
            return (Criteria) this;
        }

        public Criteria andProcessNodeRoleIsNotNull() {
            addCriterion("process_node_role is not null");
            return (Criteria) this;
        }

        public Criteria andProcessNodeRoleEqualTo(String value) {
            addCriterion("process_node_role =", value, "processNodeRole");
            return (Criteria) this;
        }

        public Criteria andProcessNodeRoleNotEqualTo(String value) {
            addCriterion("process_node_role <>", value, "processNodeRole");
            return (Criteria) this;
        }

        public Criteria andProcessNodeRoleGreaterThan(String value) {
            addCriterion("process_node_role >", value, "processNodeRole");
            return (Criteria) this;
        }

        public Criteria andProcessNodeRoleGreaterThanOrEqualTo(String value) {
            addCriterion("process_node_role >=", value, "processNodeRole");
            return (Criteria) this;
        }

        public Criteria andProcessNodeRoleLessThan(String value) {
            addCriterion("process_node_role <", value, "processNodeRole");
            return (Criteria) this;
        }

        public Criteria andProcessNodeRoleLessThanOrEqualTo(String value) {
            addCriterion("process_node_role <=", value, "processNodeRole");
            return (Criteria) this;
        }

        public Criteria andProcessNodeRoleLike(String value) {
            addCriterion("process_node_role like", value, "processNodeRole");
            return (Criteria) this;
        }

        public Criteria andProcessNodeRoleNotLike(String value) {
            addCriterion("process_node_role not like", value, "processNodeRole");
            return (Criteria) this;
        }

        public Criteria andProcessNodeRoleIn(List<String> values) {
            addCriterion("process_node_role in", values, "processNodeRole");
            return (Criteria) this;
        }

        public Criteria andProcessNodeRoleNotIn(List<String> values) {
            addCriterion("process_node_role not in", values, "processNodeRole");
            return (Criteria) this;
        }

        public Criteria andProcessNodeRoleBetween(String value1, String value2) {
            addCriterion("process_node_role between", value1, value2, "processNodeRole");
            return (Criteria) this;
        }

        public Criteria andProcessNodeRoleNotBetween(String value1, String value2) {
            addCriterion("process_node_role not between", value1, value2, "processNodeRole");
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