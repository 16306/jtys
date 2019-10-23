package com.entity;

import java.util.Date;

public class ServiceRecord {
    private Long serviceId;

    private Date serviceTime;

    private Long doctorGroupId;

    private Long familyId;

    private Long familyMemberId;

    private String serviceContent;

    private String serviceType;

    private String serviceEvaluation;

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public Date getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(Date serviceTime) {
        this.serviceTime = serviceTime;
    }

    public Long getDoctorGroupId() {
        return doctorGroupId;
    }

    public void setDoctorGroupId(Long doctorGroupId) {
        this.doctorGroupId = doctorGroupId;
    }

    public Long getFamilyId() {
        return familyId;
    }

    public void setFamilyId(Long familyId) {
        this.familyId = familyId;
    }

    public Long getFamilyMemberId() {
        return familyMemberId;
    }

    public void setFamilyMemberId(Long familyMemberId) {
        this.familyMemberId = familyMemberId;
    }

    public String getServiceContent() {
        return serviceContent;
    }

    public void setServiceContent(String serviceContent) {
        this.serviceContent = serviceContent == null ? null : serviceContent.trim();
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType == null ? null : serviceType.trim();
    }

    public String getServiceEvaluation() {
        return serviceEvaluation;
    }

    public void setServiceEvaluation(String serviceEvaluation) {
        this.serviceEvaluation = serviceEvaluation == null ? null : serviceEvaluation.trim();
    }
}