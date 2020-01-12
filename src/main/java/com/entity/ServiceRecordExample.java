package com.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ServiceRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ServiceRecordExample() {
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

        public Criteria andServiceIdIsNull() {
            addCriterion("Service_id is null");
            return (Criteria) this;
        }

        public Criteria andServiceIdIsNotNull() {
            addCriterion("Service_id is not null");
            return (Criteria) this;
        }

        public Criteria andServiceIdEqualTo(Long value) {
            addCriterion("Service_id =", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdNotEqualTo(Long value) {
            addCriterion("Service_id <>", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdGreaterThan(Long value) {
            addCriterion("Service_id >", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdGreaterThanOrEqualTo(Long value) {
            addCriterion("Service_id >=", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdLessThan(Long value) {
            addCriterion("Service_id <", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdLessThanOrEqualTo(Long value) {
            addCriterion("Service_id <=", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdIn(List<Long> values) {
            addCriterion("Service_id in", values, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdNotIn(List<Long> values) {
            addCriterion("Service_id not in", values, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdBetween(Long value1, Long value2) {
            addCriterion("Service_id between", value1, value2, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdNotBetween(Long value1, Long value2) {
            addCriterion("Service_id not between", value1, value2, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceTimeIsNull() {
            addCriterion("service_time is null");
            return (Criteria) this;
        }

        public Criteria andServiceTimeIsNotNull() {
            addCriterion("service_time is not null");
            return (Criteria) this;
        }

        public Criteria andServiceTimeEqualTo(Date value) {
            addCriterion("service_time =", value, "serviceTime");
            return (Criteria) this;
        }

        public Criteria andServiceTimeNotEqualTo(Date value) {
            addCriterion("service_time <>", value, "serviceTime");
            return (Criteria) this;
        }

        public Criteria andServiceTimeGreaterThan(Date value) {
            addCriterion("service_time >", value, "serviceTime");
            return (Criteria) this;
        }

        public Criteria andServiceTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("service_time >=", value, "serviceTime");
            return (Criteria) this;
        }

        public Criteria andServiceTimeLessThan(Date value) {
            addCriterion("service_time <", value, "serviceTime");
            return (Criteria) this;
        }

        public Criteria andServiceTimeLessThanOrEqualTo(Date value) {
            addCriterion("service_time <=", value, "serviceTime");
            return (Criteria) this;
        }

        public Criteria andServiceTimeIn(List<Date> values) {
            addCriterion("service_time in", values, "serviceTime");
            return (Criteria) this;
        }

        public Criteria andServiceTimeNotIn(List<Date> values) {
            addCriterion("service_time not in", values, "serviceTime");
            return (Criteria) this;
        }

        public Criteria andServiceTimeBetween(Date value1, Date value2) {
            addCriterion("service_time between", value1, value2, "serviceTime");
            return (Criteria) this;
        }

        public Criteria andServiceTimeNotBetween(Date value1, Date value2) {
            addCriterion("service_time not between", value1, value2, "serviceTime");
            return (Criteria) this;
        }

        public Criteria andDoctorGroupIdIsNull() {
            addCriterion("doctor_group_id is null");
            return (Criteria) this;
        }

        public Criteria andDoctorGroupIdIsNotNull() {
            addCriterion("doctor_group_id is not null");
            return (Criteria) this;
        }

        public Criteria andDoctorGroupIdEqualTo(Long value) {
            addCriterion("doctor_group_id =", value, "doctorGroupId");
            return (Criteria) this;
        }

        public Criteria andDoctorGroupIdNotEqualTo(Long value) {
            addCriterion("doctor_group_id <>", value, "doctorGroupId");
            return (Criteria) this;
        }

        public Criteria andDoctorGroupIdGreaterThan(Long value) {
            addCriterion("doctor_group_id >", value, "doctorGroupId");
            return (Criteria) this;
        }

        public Criteria andDoctorGroupIdGreaterThanOrEqualTo(Long value) {
            addCriterion("doctor_group_id >=", value, "doctorGroupId");
            return (Criteria) this;
        }

        public Criteria andDoctorGroupIdLessThan(Long value) {
            addCriterion("doctor_group_id <", value, "doctorGroupId");
            return (Criteria) this;
        }

        public Criteria andDoctorGroupIdLessThanOrEqualTo(Long value) {
            addCriterion("doctor_group_id <=", value, "doctorGroupId");
            return (Criteria) this;
        }

        public Criteria andDoctorGroupIdIn(List<Long> values) {
            addCriterion("doctor_group_id in", values, "doctorGroupId");
            return (Criteria) this;
        }

        public Criteria andDoctorGroupIdNotIn(List<Long> values) {
            addCriterion("doctor_group_id not in", values, "doctorGroupId");
            return (Criteria) this;
        }

        public Criteria andDoctorGroupIdBetween(Long value1, Long value2) {
            addCriterion("doctor_group_id between", value1, value2, "doctorGroupId");
            return (Criteria) this;
        }

        public Criteria andDoctorGroupIdNotBetween(Long value1, Long value2) {
            addCriterion("doctor_group_id not between", value1, value2, "doctorGroupId");
            return (Criteria) this;
        }

        public Criteria andFamilyIdIsNull() {
            addCriterion("family_id is null");
            return (Criteria) this;
        }

        public Criteria andFamilyIdIsNotNull() {
            addCriterion("family_id is not null");
            return (Criteria) this;
        }

        public Criteria andFamilyIdEqualTo(Long value) {
            addCriterion("family_id =", value, "familyId");
            return (Criteria) this;
        }

        public Criteria andFamilyIdNotEqualTo(Long value) {
            addCriterion("family_id <>", value, "familyId");
            return (Criteria) this;
        }

        public Criteria andFamilyIdGreaterThan(Long value) {
            addCriterion("family_id >", value, "familyId");
            return (Criteria) this;
        }

        public Criteria andFamilyIdGreaterThanOrEqualTo(Long value) {
            addCriterion("family_id >=", value, "familyId");
            return (Criteria) this;
        }

        public Criteria andFamilyIdLessThan(Long value) {
            addCriterion("family_id <", value, "familyId");
            return (Criteria) this;
        }

        public Criteria andFamilyIdLessThanOrEqualTo(Long value) {
            addCriterion("family_id <=", value, "familyId");
            return (Criteria) this;
        }

        public Criteria andFamilyIdIn(List<Long> values) {
            addCriterion("family_id in", values, "familyId");
            return (Criteria) this;
        }

        public Criteria andFamilyIdNotIn(List<Long> values) {
            addCriterion("family_id not in", values, "familyId");
            return (Criteria) this;
        }

        public Criteria andFamilyIdBetween(Long value1, Long value2) {
            addCriterion("family_id between", value1, value2, "familyId");
            return (Criteria) this;
        }

        public Criteria andFamilyIdNotBetween(Long value1, Long value2) {
            addCriterion("family_id not between", value1, value2, "familyId");
            return (Criteria) this;
        }

        public Criteria andFamilyMemberIdIsNull() {
            addCriterion("family_member_id is null");
            return (Criteria) this;
        }

        public Criteria andFamilyMemberIdIsNotNull() {
            addCriterion("family_member_id is not null");
            return (Criteria) this;
        }

        public Criteria andFamilyMemberIdEqualTo(Long value) {
            addCriterion("family_member_id =", value, "familyMemberId");
            return (Criteria) this;
        }

        public Criteria andFamilyMemberIdNotEqualTo(Long value) {
            addCriterion("family_member_id <>", value, "familyMemberId");
            return (Criteria) this;
        }

        public Criteria andFamilyMemberIdGreaterThan(Long value) {
            addCriterion("family_member_id >", value, "familyMemberId");
            return (Criteria) this;
        }

        public Criteria andFamilyMemberIdGreaterThanOrEqualTo(Long value) {
            addCriterion("family_member_id >=", value, "familyMemberId");
            return (Criteria) this;
        }

        public Criteria andFamilyMemberIdLessThan(Long value) {
            addCriterion("family_member_id <", value, "familyMemberId");
            return (Criteria) this;
        }

        public Criteria andFamilyMemberIdLessThanOrEqualTo(Long value) {
            addCriterion("family_member_id <=", value, "familyMemberId");
            return (Criteria) this;
        }

        public Criteria andFamilyMemberIdIn(List<Long> values) {
            addCriterion("family_member_id in", values, "familyMemberId");
            return (Criteria) this;
        }

        public Criteria andFamilyMemberIdNotIn(List<Long> values) {
            addCriterion("family_member_id not in", values, "familyMemberId");
            return (Criteria) this;
        }

        public Criteria andFamilyMemberIdBetween(Long value1, Long value2) {
            addCriterion("family_member_id between", value1, value2, "familyMemberId");
            return (Criteria) this;
        }

        public Criteria andFamilyMemberIdNotBetween(Long value1, Long value2) {
            addCriterion("family_member_id not between", value1, value2, "familyMemberId");
            return (Criteria) this;
        }

        public Criteria andServiceContentIsNull() {
            addCriterion("service_content is null");
            return (Criteria) this;
        }

        public Criteria andServiceContentIsNotNull() {
            addCriterion("service_content is not null");
            return (Criteria) this;
        }

        public Criteria andServiceContentEqualTo(String value) {
            addCriterion("service_content =", value, "serviceContent");
            return (Criteria) this;
        }

        public Criteria andServiceContentNotEqualTo(String value) {
            addCriterion("service_content <>", value, "serviceContent");
            return (Criteria) this;
        }

        public Criteria andServiceContentGreaterThan(String value) {
            addCriterion("service_content >", value, "serviceContent");
            return (Criteria) this;
        }

        public Criteria andServiceContentGreaterThanOrEqualTo(String value) {
            addCriterion("service_content >=", value, "serviceContent");
            return (Criteria) this;
        }

        public Criteria andServiceContentLessThan(String value) {
            addCriterion("service_content <", value, "serviceContent");
            return (Criteria) this;
        }

        public Criteria andServiceContentLessThanOrEqualTo(String value) {
            addCriterion("service_content <=", value, "serviceContent");
            return (Criteria) this;
        }

        public Criteria andServiceContentLike(String value) {
            addCriterion("service_content like", value, "serviceContent");
            return (Criteria) this;
        }

        public Criteria andServiceContentNotLike(String value) {
            addCriterion("service_content not like", value, "serviceContent");
            return (Criteria) this;
        }

        public Criteria andServiceContentIn(List<String> values) {
            addCriterion("service_content in", values, "serviceContent");
            return (Criteria) this;
        }

        public Criteria andServiceContentNotIn(List<String> values) {
            addCriterion("service_content not in", values, "serviceContent");
            return (Criteria) this;
        }

        public Criteria andServiceContentBetween(String value1, String value2) {
            addCriterion("service_content between", value1, value2, "serviceContent");
            return (Criteria) this;
        }

        public Criteria andServiceContentNotBetween(String value1, String value2) {
            addCriterion("service_content not between", value1, value2, "serviceContent");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIsNull() {
            addCriterion("service_type is null");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIsNotNull() {
            addCriterion("service_type is not null");
            return (Criteria) this;
        }

        public Criteria andServiceTypeEqualTo(String value) {
            addCriterion("service_type =", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeNotEqualTo(String value) {
            addCriterion("service_type <>", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeGreaterThan(String value) {
            addCriterion("service_type >", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeGreaterThanOrEqualTo(String value) {
            addCriterion("service_type >=", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeLessThan(String value) {
            addCriterion("service_type <", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeLessThanOrEqualTo(String value) {
            addCriterion("service_type <=", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeLike(String value) {
            addCriterion("service_type like", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeNotLike(String value) {
            addCriterion("service_type not like", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIn(List<String> values) {
            addCriterion("service_type in", values, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeNotIn(List<String> values) {
            addCriterion("service_type not in", values, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeBetween(String value1, String value2) {
            addCriterion("service_type between", value1, value2, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeNotBetween(String value1, String value2) {
            addCriterion("service_type not between", value1, value2, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluationIsNull() {
            addCriterion("service_evaluation is null");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluationIsNotNull() {
            addCriterion("service_evaluation is not null");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluationEqualTo(String value) {
            addCriterion("service_evaluation =", value, "serviceEvaluation");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluationNotEqualTo(String value) {
            addCriterion("service_evaluation <>", value, "serviceEvaluation");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluationGreaterThan(String value) {
            addCriterion("service_evaluation >", value, "serviceEvaluation");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluationGreaterThanOrEqualTo(String value) {
            addCriterion("service_evaluation >=", value, "serviceEvaluation");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluationLessThan(String value) {
            addCriterion("service_evaluation <", value, "serviceEvaluation");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluationLessThanOrEqualTo(String value) {
            addCriterion("service_evaluation <=", value, "serviceEvaluation");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluationLike(String value) {
            addCriterion("service_evaluation like", value, "serviceEvaluation");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluationNotLike(String value) {
            addCriterion("service_evaluation not like", value, "serviceEvaluation");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluationIn(List<String> values) {
            addCriterion("service_evaluation in", values, "serviceEvaluation");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluationNotIn(List<String> values) {
            addCriterion("service_evaluation not in", values, "serviceEvaluation");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluationBetween(String value1, String value2) {
            addCriterion("service_evaluation between", value1, value2, "serviceEvaluation");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluationNotBetween(String value1, String value2) {
            addCriterion("service_evaluation not between", value1, value2, "serviceEvaluation");
            return (Criteria) this;
        }

        public Criteria andHospitalIdIsNull() {
            addCriterion("hospital_id is null");
            return (Criteria) this;
        }

        public Criteria andHospitalIdIsNotNull() {
            addCriterion("hospital_id is not null");
            return (Criteria) this;
        }

        public Criteria andHospitalIdEqualTo(Long value) {
            addCriterion("hospital_id =", value, "hospitalId");
            return (Criteria) this;
        }

        public Criteria andHospitalIdNotEqualTo(Long value) {
            addCriterion("hospital_id <>", value, "hospitalId");
            return (Criteria) this;
        }

        public Criteria andHospitalIdGreaterThan(Long value) {
            addCriterion("hospital_id >", value, "hospitalId");
            return (Criteria) this;
        }

        public Criteria andHospitalIdGreaterThanOrEqualTo(Long value) {
            addCriterion("hospital_id >=", value, "hospitalId");
            return (Criteria) this;
        }

        public Criteria andHospitalIdLessThan(Long value) {
            addCriterion("hospital_id <", value, "hospitalId");
            return (Criteria) this;
        }

        public Criteria andHospitalIdLessThanOrEqualTo(Long value) {
            addCriterion("hospital_id <=", value, "hospitalId");
            return (Criteria) this;
        }

        public Criteria andHospitalIdIn(List<Long> values) {
            addCriterion("hospital_id in", values, "hospitalId");
            return (Criteria) this;
        }

        public Criteria andHospitalIdNotIn(List<Long> values) {
            addCriterion("hospital_id not in", values, "hospitalId");
            return (Criteria) this;
        }

        public Criteria andHospitalIdBetween(Long value1, Long value2) {
            addCriterion("hospital_id between", value1, value2, "hospitalId");
            return (Criteria) this;
        }

        public Criteria andHospitalIdNotBetween(Long value1, Long value2) {
            addCriterion("hospital_id not between", value1, value2, "hospitalId");
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