package com.entity;

import java.util.Date;

public class Purchase {
    private Long purchaseId;

    private Long purchaseFamilyId;

    private Date purchaseTime;

    private Long deviceId;

    private Long handleId;

    public Long getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Long purchaseId) {
        this.purchaseId = purchaseId;
    }

    public Long getPurchaseFamilyId() {
        return purchaseFamilyId;
    }

    public void setPurchaseFamilyId(Long purchaseFamilyId) {
        this.purchaseFamilyId = purchaseFamilyId;
    }

    public Date getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(Date purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public Long getHandleId() {
        return handleId;
    }

    public void setHandleId(Long handleId) {
        this.handleId = handleId;
    }
}