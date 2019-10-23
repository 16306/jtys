package com.entity;

import java.util.Date;

public class Hospitalization {
    private Long hospitalizationId;

    private Long caseId;

    private Long hospitalizationNumber;

    private String diseaseType;

    private Long physicianNumber;

    private String chiefPhysician;

    private Date admissionTime;

    private Date dischargeTime;

    public Long getHospitalizationId() {
        return hospitalizationId;
    }

    public void setHospitalizationId(Long hospitalizationId) {
        this.hospitalizationId = hospitalizationId;
    }

    public Long getCaseId() {
        return caseId;
    }

    public void setCaseId(Long caseId) {
        this.caseId = caseId;
    }

    public Long getHospitalizationNumber() {
        return hospitalizationNumber;
    }

    public void setHospitalizationNumber(Long hospitalizationNumber) {
        this.hospitalizationNumber = hospitalizationNumber;
    }

    public String getDiseaseType() {
        return diseaseType;
    }

    public void setDiseaseType(String diseaseType) {
        this.diseaseType = diseaseType == null ? null : diseaseType.trim();
    }

    public Long getPhysicianNumber() {
        return physicianNumber;
    }

    public void setPhysicianNumber(Long physicianNumber) {
        this.physicianNumber = physicianNumber;
    }

    public String getChiefPhysician() {
        return chiefPhysician;
    }

    public void setChiefPhysician(String chiefPhysician) {
        this.chiefPhysician = chiefPhysician == null ? null : chiefPhysician.trim();
    }

    public Date getAdmissionTime() {
        return admissionTime;
    }

    public void setAdmissionTime(Date admissionTime) {
        this.admissionTime = admissionTime;
    }

    public Date getDischargeTime() {
        return dischargeTime;
    }

    public void setDischargeTime(Date dischargeTime) {
        this.dischargeTime = dischargeTime;
    }
}