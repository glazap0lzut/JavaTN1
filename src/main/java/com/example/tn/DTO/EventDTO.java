package com.example.tn.DTO;

import java.time.LocalDateTime;

public class EventDTO {
    private String title;
    private String location;
    private String applicant;
    private String comment;
    private boolean isOnline;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private boolean isOutlook;
    private Long userId; // Поле для хранения идентификатора пользователя
    private Long id;

    // Геттеры и сеттеры

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public boolean isOutlook() {
        return isOutlook;
    }

    public void setOutlook(boolean outlook) {
        this.isOutlook = outlook;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    // Геттеры и сеттеры
}
