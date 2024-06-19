package com.utfpr.APIWeb2.core.domain;

import java.util.UUID;

public class Task {

    private UUID id;
    private String title;
    private String description;
    private String createBY;
    private String responsibilityTo;

    public Task() {
    }

    public Task(UUID id, String title, String description, String createBY, String responsibilityTo) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.createBY = createBY;
        this.responsibilityTo = responsibilityTo;
    }

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getCreateBY() {
        return createBY;
    }

    public void setCreateBY(String createBY) {
        this.createBY = createBY;
    }

    public String getResponsibilityTo() {
        return responsibilityTo;
    }

    public void setResponsibilityTo(String responsibilityTo) {
        this.responsibilityTo = responsibilityTo;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
