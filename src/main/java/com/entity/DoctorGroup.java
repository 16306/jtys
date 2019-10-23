package com.entity;

public class DoctorGroup {
    private Long doctorGroupId;

    private String name;

    private String groupLeaderName;

    private String groupLeaderPhone;

    private String secondLeaderName;

    private String secondLeaderPhone;

    private String speciality;

    private String serviceArea;

    public Long getDoctorGroupId() {
        return doctorGroupId;
    }

    public void setDoctorGroupId(Long doctorGroupId) {
        this.doctorGroupId = doctorGroupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getGroupLeaderName() {
        return groupLeaderName;
    }

    public void setGroupLeaderName(String groupLeaderName) {
        this.groupLeaderName = groupLeaderName == null ? null : groupLeaderName.trim();
    }

    public String getGroupLeaderPhone() {
        return groupLeaderPhone;
    }

    public void setGroupLeaderPhone(String groupLeaderPhone) {
        this.groupLeaderPhone = groupLeaderPhone == null ? null : groupLeaderPhone.trim();
    }

    public String getSecondLeaderName() {
        return secondLeaderName;
    }

    public void setSecondLeaderName(String secondLeaderName) {
        this.secondLeaderName = secondLeaderName == null ? null : secondLeaderName.trim();
    }

    public String getSecondLeaderPhone() {
        return secondLeaderPhone;
    }

    public void setSecondLeaderPhone(String secondLeaderPhone) {
        this.secondLeaderPhone = secondLeaderPhone == null ? null : secondLeaderPhone.trim();
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality == null ? null : speciality.trim();
    }

    public String getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(String serviceArea) {
        this.serviceArea = serviceArea == null ? null : serviceArea.trim();
    }
}