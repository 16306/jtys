package com.entity;

public class ObstericalHistory {
    private Long obstericalId;

    private String cardId;

    private String marriage;

    private String birth;

    public Long getObstericalId() {
        return obstericalId;
    }

    public void setObstericalId(Long obstericalId) {
        this.obstericalId = obstericalId;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId == null ? null : cardId.trim();
    }

    public String getMarriage() {
        return marriage;
    }

    public void setMarriage(String marriage) {
        this.marriage = marriage == null ? null : marriage.trim();
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth == null ? null : birth.trim();
    }
}