package com.entity;

import java.util.Date;

public class HealthKnowledge {
    private Long healthKnowledgeId;

    private String title;

    private String content;

    private Long publisherId;

    private String reviewStatus;

    private String reviewer;

    private Date reviewTime;

    public Long getHealthKnowledgeId() {
        return healthKnowledgeId;
    }

    public void setHealthKnowledgeId(Long healthKnowledgeId) {
        this.healthKnowledgeId = healthKnowledgeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Long getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Long publisherId) {
        this.publisherId = publisherId;
    }

    public String getReviewStatus() {
        return reviewStatus;
    }

    public void setReviewStatus(String reviewStatus) {
        this.reviewStatus = reviewStatus == null ? null : reviewStatus.trim();
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer == null ? null : reviewer.trim();
    }

    public Date getReviewTime() {
        return reviewTime;
    }

    public void setReviewTime(Date reviewTime) {
        this.reviewTime = reviewTime;
    }
}