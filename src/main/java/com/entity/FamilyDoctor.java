package com.entity;

import java.util.Date;

public class FamilyDoctor {
    private Long familyDoctorId;

    private Long doctorGroupId;

    private Long familyId;

    private Date dateOfContract;

    private Integer contractDuration;

    private String contractContent;

    public Long getFamilyDoctorId() {
        return familyDoctorId;
    }

    public void setFamilyDoctorId(Long familyDoctorId) {
        this.familyDoctorId = familyDoctorId;
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

    public Date getDateOfContract() {
        return dateOfContract;
    }

    public void setDateOfContract(Date dateOfContract) {
        this.dateOfContract = dateOfContract;
    }

    public Integer getContractDuration() {
        return contractDuration;
    }

    public void setContractDuration(Integer contractDuration) {
        this.contractDuration = contractDuration;
    }

    public String getContractContent() {
        return contractContent;
    }

    public void setContractContent(String contractContent) {
        this.contractContent = contractContent == null ? null : contractContent.trim();
    }
}