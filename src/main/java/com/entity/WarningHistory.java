package com.entity;

import java.util.Date;

public class WarningHistory {
    private Long warningHistoryId;

    private String detector;

    private String cardId;

    private String content;

    private Date time;

    public Long getWarningHistoryId() {
        return warningHistoryId;
    }

    public void setWarningHistoryId(Long warningHistoryId) {
        this.warningHistoryId = warningHistoryId;
    }

    public String getDetector() {
        return detector;
    }

    public void setDetector(String detector) {
        this.detector = detector == null ? null : detector.trim();
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId == null ? null : cardId.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}