package com.entity;

import java.util.Date;

public class Medication {
    private Long medicationId;

    private Long caseId;

    private String drugName;

    private Date medicationTime;

    private String precautions;

    private Date startTime;

    public Long getMedicationId() {
        return medicationId;
    }

    public void setMedicationId(Long medicationId) {
        this.medicationId = medicationId;
    }

    public Long getCaseId() {
        return caseId;
    }

    public void setCaseId(Long caseId) {
        this.caseId = caseId;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName == null ? null : drugName.trim();
    }

    public Date getMedicationTime() {
        return medicationTime;
    }

    public void setMedicationTime(Date medicationTime) {
        this.medicationTime = medicationTime;
    }

    public String getPrecautions() {
        return precautions;
    }

    public void setPrecautions(String precautions) {
        this.precautions = precautions == null ? null : precautions.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
}