package com.entity;

public class AllergyHistory {
    private Long allergyId;

    private String cardId;

    private String allergen;

    private String describe;

    public Long getAllergyId() {
        return allergyId;
    }

    public void setAllergyId(Long allergyId) {
        this.allergyId = allergyId;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId == null ? null : cardId.trim();
    }

    public String getAllergen() {
        return allergen;
    }

    public void setAllergen(String allergen) {
        this.allergen = allergen == null ? null : allergen.trim();
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe == null ? null : describe.trim();
    }
}