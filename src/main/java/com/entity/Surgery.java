package com.entity;

import java.util.Date;

public class Surgery {
    private Long surgeryId;

    private Long caseId;

    private String surgicalName;

    private Date operativeTime;

    private String surgicalDescription;

    private String surgeon;

    public Long getSurgeryId() {
        return surgeryId;
    }

    public void setSurgeryId(Long surgeryId) {
        this.surgeryId = surgeryId;
    }

    public Long getCaseId() {
        return caseId;
    }

    public void setCaseId(Long caseId) {
        this.caseId = caseId;
    }

    public String getSurgicalName() {
        return surgicalName;
    }

    public void setSurgicalName(String surgicalName) {
        this.surgicalName = surgicalName == null ? null : surgicalName.trim();
    }

    public Date getOperativeTime() {
        return operativeTime;
    }

    public void setOperativeTime(Date operativeTime) {
        this.operativeTime = operativeTime;
    }

    public String getSurgicalDescription() {
        return surgicalDescription;
    }

    public void setSurgicalDescription(String surgicalDescription) {
        this.surgicalDescription = surgicalDescription == null ? null : surgicalDescription.trim();
    }

    public String getSurgeon() {
        return surgeon;
    }

    public void setSurgeon(String surgeon) {
        this.surgeon = surgeon == null ? null : surgeon.trim();
    }
}