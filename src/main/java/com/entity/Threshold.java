package com.entity;

public class Threshold {
    private Long id;

    private String code;

    private String presetValue;

    private String measurementType;

    private Long warningId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getPresetValue() {
        return presetValue;
    }

    public void setPresetValue(String presetValue) {
        this.presetValue = presetValue == null ? null : presetValue.trim();
    }

    public String getMeasurementType() {
        return measurementType;
    }

    public void setMeasurementType(String measurementType) {
        this.measurementType = measurementType == null ? null : measurementType.trim();
    }

    public Long getWarningId() {
        return warningId;
    }

    public void setWarningId(Long warningId) {
        this.warningId = warningId;
    }
}