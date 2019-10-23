package com.entity;

public class PastHistory {
    private Long pastId;

    private String cardId;

    private String describe;

    public Long getPastId() {
        return pastId;
    }

    public void setPastId(Long pastId) {
        this.pastId = pastId;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId == null ? null : cardId.trim();
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe == null ? null : describe.trim();
    }
}