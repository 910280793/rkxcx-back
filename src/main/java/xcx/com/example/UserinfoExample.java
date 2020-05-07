package xcx.com.example;

import java.util.ArrayList;
import java.util.List;

public class UserinfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserinfoExample() {
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

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andTestIdIsNull() {
            addCriterion("test_id is null");
            return (Criteria) this;
        }

        public Criteria andTestIdIsNotNull() {
            addCriterion("test_id is not null");
            return (Criteria) this;
        }

        public Criteria andTestIdEqualTo(Integer value) {
            addCriterion("test_id =", value, "testId");
            return (Criteria) this;
        }

        public Criteria andTestIdNotEqualTo(Integer value) {
            addCriterion("test_id <>", value, "testId");
            return (Criteria) this;
        }

        public Criteria andTestIdGreaterThan(Integer value) {
            addCriterion("test_id >", value, "testId");
            return (Criteria) this;
        }

        public Criteria andTestIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("test_id >=", value, "testId");
            return (Criteria) this;
        }

        public Criteria andTestIdLessThan(Integer value) {
            addCriterion("test_id <", value, "testId");
            return (Criteria) this;
        }

        public Criteria andTestIdLessThanOrEqualTo(Integer value) {
            addCriterion("test_id <=", value, "testId");
            return (Criteria) this;
        }

        public Criteria andTestIdIn(List<Integer> values) {
            addCriterion("test_id in", values, "testId");
            return (Criteria) this;
        }

        public Criteria andTestIdNotIn(List<Integer> values) {
            addCriterion("test_id not in", values, "testId");
            return (Criteria) this;
        }

        public Criteria andTestIdBetween(Integer value1, Integer value2) {
            addCriterion("test_id between", value1, value2, "testId");
            return (Criteria) this;
        }

        public Criteria andTestIdNotBetween(Integer value1, Integer value2) {
            addCriterion("test_id not between", value1, value2, "testId");
            return (Criteria) this;
        }

        public Criteria andTestNameIsNull() {
            addCriterion("test_name is null");
            return (Criteria) this;
        }

        public Criteria andTestNameIsNotNull() {
            addCriterion("test_name is not null");
            return (Criteria) this;
        }

        public Criteria andTestNameEqualTo(String value) {
            addCriterion("test_name =", value, "testName");
            return (Criteria) this;
        }

        public Criteria andTestNameNotEqualTo(String value) {
            addCriterion("test_name <>", value, "testName");
            return (Criteria) this;
        }

        public Criteria andTestNameGreaterThan(String value) {
            addCriterion("test_name >", value, "testName");
            return (Criteria) this;
        }

        public Criteria andTestNameGreaterThanOrEqualTo(String value) {
            addCriterion("test_name >=", value, "testName");
            return (Criteria) this;
        }

        public Criteria andTestNameLessThan(String value) {
            addCriterion("test_name <", value, "testName");
            return (Criteria) this;
        }

        public Criteria andTestNameLessThanOrEqualTo(String value) {
            addCriterion("test_name <=", value, "testName");
            return (Criteria) this;
        }

        public Criteria andTestNameLike(String value) {
            addCriterion("test_name like", value, "testName");
            return (Criteria) this;
        }

        public Criteria andTestNameNotLike(String value) {
            addCriterion("test_name not like", value, "testName");
            return (Criteria) this;
        }

        public Criteria andTestNameIn(List<String> values) {
            addCriterion("test_name in", values, "testName");
            return (Criteria) this;
        }

        public Criteria andTestNameNotIn(List<String> values) {
            addCriterion("test_name not in", values, "testName");
            return (Criteria) this;
        }

        public Criteria andTestNameBetween(String value1, String value2) {
            addCriterion("test_name between", value1, value2, "testName");
            return (Criteria) this;
        }

        public Criteria andTestNameNotBetween(String value1, String value2) {
            addCriterion("test_name not between", value1, value2, "testName");
            return (Criteria) this;
        }

        public Criteria andDtCountIsNull() {
            addCriterion("dt_count is null");
            return (Criteria) this;
        }

        public Criteria andDtCountIsNotNull() {
            addCriterion("dt_count is not null");
            return (Criteria) this;
        }

        public Criteria andDtCountEqualTo(Integer value) {
            addCriterion("dt_count =", value, "dtCount");
            return (Criteria) this;
        }

        public Criteria andDtCountNotEqualTo(Integer value) {
            addCriterion("dt_count <>", value, "dtCount");
            return (Criteria) this;
        }

        public Criteria andDtCountGreaterThan(Integer value) {
            addCriterion("dt_count >", value, "dtCount");
            return (Criteria) this;
        }

        public Criteria andDtCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("dt_count >=", value, "dtCount");
            return (Criteria) this;
        }

        public Criteria andDtCountLessThan(Integer value) {
            addCriterion("dt_count <", value, "dtCount");
            return (Criteria) this;
        }

        public Criteria andDtCountLessThanOrEqualTo(Integer value) {
            addCriterion("dt_count <=", value, "dtCount");
            return (Criteria) this;
        }

        public Criteria andDtCountIn(List<Integer> values) {
            addCriterion("dt_count in", values, "dtCount");
            return (Criteria) this;
        }

        public Criteria andDtCountNotIn(List<Integer> values) {
            addCriterion("dt_count not in", values, "dtCount");
            return (Criteria) this;
        }

        public Criteria andDtCountBetween(Integer value1, Integer value2) {
            addCriterion("dt_count between", value1, value2, "dtCount");
            return (Criteria) this;
        }

        public Criteria andDtCountNotBetween(Integer value1, Integer value2) {
            addCriterion("dt_count not between", value1, value2, "dtCount");
            return (Criteria) this;
        }

        public Criteria andScCountIsNull() {
            addCriterion("sc_count is null");
            return (Criteria) this;
        }

        public Criteria andScCountIsNotNull() {
            addCriterion("sc_count is not null");
            return (Criteria) this;
        }

        public Criteria andScCountEqualTo(Integer value) {
            addCriterion("sc_count =", value, "scCount");
            return (Criteria) this;
        }

        public Criteria andScCountNotEqualTo(Integer value) {
            addCriterion("sc_count <>", value, "scCount");
            return (Criteria) this;
        }

        public Criteria andScCountGreaterThan(Integer value) {
            addCriterion("sc_count >", value, "scCount");
            return (Criteria) this;
        }

        public Criteria andScCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("sc_count >=", value, "scCount");
            return (Criteria) this;
        }

        public Criteria andScCountLessThan(Integer value) {
            addCriterion("sc_count <", value, "scCount");
            return (Criteria) this;
        }

        public Criteria andScCountLessThanOrEqualTo(Integer value) {
            addCriterion("sc_count <=", value, "scCount");
            return (Criteria) this;
        }

        public Criteria andScCountIn(List<Integer> values) {
            addCriterion("sc_count in", values, "scCount");
            return (Criteria) this;
        }

        public Criteria andScCountNotIn(List<Integer> values) {
            addCriterion("sc_count not in", values, "scCount");
            return (Criteria) this;
        }

        public Criteria andScCountBetween(Integer value1, Integer value2) {
            addCriterion("sc_count between", value1, value2, "scCount");
            return (Criteria) this;
        }

        public Criteria andScCountNotBetween(Integer value1, Integer value2) {
            addCriterion("sc_count not between", value1, value2, "scCount");
            return (Criteria) this;
        }

        public Criteria andCtCountIsNull() {
            addCriterion("ct_count is null");
            return (Criteria) this;
        }

        public Criteria andCtCountIsNotNull() {
            addCriterion("ct_count is not null");
            return (Criteria) this;
        }

        public Criteria andCtCountEqualTo(Integer value) {
            addCriterion("ct_count =", value, "ctCount");
            return (Criteria) this;
        }

        public Criteria andCtCountNotEqualTo(Integer value) {
            addCriterion("ct_count <>", value, "ctCount");
            return (Criteria) this;
        }

        public Criteria andCtCountGreaterThan(Integer value) {
            addCriterion("ct_count >", value, "ctCount");
            return (Criteria) this;
        }

        public Criteria andCtCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("ct_count >=", value, "ctCount");
            return (Criteria) this;
        }

        public Criteria andCtCountLessThan(Integer value) {
            addCriterion("ct_count <", value, "ctCount");
            return (Criteria) this;
        }

        public Criteria andCtCountLessThanOrEqualTo(Integer value) {
            addCriterion("ct_count <=", value, "ctCount");
            return (Criteria) this;
        }

        public Criteria andCtCountIn(List<Integer> values) {
            addCriterion("ct_count in", values, "ctCount");
            return (Criteria) this;
        }

        public Criteria andCtCountNotIn(List<Integer> values) {
            addCriterion("ct_count not in", values, "ctCount");
            return (Criteria) this;
        }

        public Criteria andCtCountBetween(Integer value1, Integer value2) {
            addCriterion("ct_count between", value1, value2, "ctCount");
            return (Criteria) this;
        }

        public Criteria andCtCountNotBetween(Integer value1, Integer value2) {
            addCriterion("ct_count not between", value1, value2, "ctCount");
            return (Criteria) this;
        }
    }

    /**
     */
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