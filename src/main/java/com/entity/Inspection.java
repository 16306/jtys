package com.entity;

import java.util.Date;

public class Inspection {
    private Long inspectionId;

    private Long caseId;

    private String inspectionItem;

    private Date inspectionTime;

    private String inspectionConclusion;

    public Long getInspectionId() {
        return inspectionId;
    }

    public void setInspectionId(Long inspectionId) {
        this.inspectionId = inspectionId;
    }

    public Long getCaseId() {
        return caseId;
    }

    public void setCaseId(Long caseId) {
        this.caseId = caseId;
    }

    public String getInspectionItem() {
        return inspectionItem;
    }

    public void setInspectionItem(String inspectionItem) {
        this.inspectionItem = inspectionItem == null ? null : inspectionItem.trim();
    }

    public Date getInspectionTime() {
        return inspectionTime;
    }

    public void setInspectionTime(Date inspectionTime) {
        this.inspectionTime = inspectionTime;
    }

    public String getInspectionConclusion() {
        return inspectionConclusion;
    }

    public void setInspectionConclusion(String inspectionConclusion) {
        this.inspectionConclusion = inspectionConclusion == null ? null : inspectionConclusion.trim();
    }
}