package com.entity;

public class Family {
    private Long familyId;

    private String householderName;

    private Integer population;

    private String householderPhone;

    private String address;

    private Long hospitalId;

    public Long getFamilyId() {
        return familyId;
    }

    public void setFamilyId(Long familyId) {
        this.familyId = familyId;
    }

    public String getHouseholderName() {
        return householderName;
    }

    public void setHouseholderName(String householderName) {
        this.householderName = householderName == null ? null : householderName.trim();
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public String getHouseholderPhone() {
        return householderPhone;
    }

    public void setHouseholderPhone(String householderPhone) {
        this.householderPhone = householderPhone == null ? null : householderPhone.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Long getHospitalId()
    {
        return hospitalId;
    }

    public void setHospitalId(Long hospitalId)
    {
        this.hospitalId = hospitalId;
    }
}