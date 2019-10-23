package com.entity;

public class FamilyHistory {
    private Long familyHistoryId;

    private String cardId;

    private String relation;

    private String illnessName;

    private String describe;

    public Long getFamilyHistoryId() {
        return familyHistoryId;
    }

    public void setFamilyHistoryId(Long familyHistoryId) {
        this.familyHistoryId = familyHistoryId;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId == null ? null : cardId.trim();
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation == null ? null : relation.trim();
    }

    public String getIllnessName() {
        return illnessName;
    }

    public void setIllnessName(String illnessName) {
        this.illnessName = illnessName == null ? null : illnessName.trim();
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe == null ? null : describe.trim();
    }
}