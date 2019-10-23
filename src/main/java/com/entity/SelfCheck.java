package com.entity;

import java.util.Date;

public class SelfCheck {
    private Long selfCheckId;

    private String cardId;

    private Long measurementId;

    private Date measurementTime;

    private String measurementResult;

    private Long deviceId;

    private String deviceSource;

    private Date usageTime;

    public Long getSelfCheckId() {
        return selfCheckId;
    }

    public void setSelfCheckId(Long selfCheckId) {
        this.selfCheckId = selfCheckId;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId == null ? null : cardId.trim();
    }

    public Long getMeasurementId() {
        return measurementId;
    }

    public void setMeasurementId(Long measurementId) {
        this.measurementId = measurementId;
    }

    public Date getMeasurementTime() {
        return measurementTime;
    }

    public void setMeasurementTime(Date measurementTime) {
        this.measurementTime = measurementTime;
    }

    public String getMeasurementResult() {
        return measurementResult;
    }

    public void setMeasurementResult(String measurementResult) {
        this.measurementResult = measurementResult == null ? null : measurementResult.trim();
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceSource() {
        return deviceSource;
    }

    public void setDeviceSource(String deviceSource) {
        this.deviceSource = deviceSource == null ? null : deviceSource.trim();
    }

    public Date getUsageTime() {
        return usageTime;
    }

    public void setUsageTime(Date usageTime) {
        this.usageTime = usageTime;
    }
}