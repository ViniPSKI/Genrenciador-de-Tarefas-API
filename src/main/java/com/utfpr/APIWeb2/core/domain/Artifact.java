package com.utfpr.APIWeb2.core.domain;

import java.util.UUID;

public class Artifact {

    private UUID id;
    private String annotation;
    private String createBy;
    private UUID sourceTask;

    public Artifact(String annotation, String createBy, UUID sourceTask) {
        this.annotation = annotation;
        this.createBy = createBy;
        this.sourceTask = sourceTask;
    }

    public Artifact() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public UUID getSourceTask() {
        return sourceTask;
    }

    public void setSourceTask(UUID sourceTask) {
        this.sourceTask = sourceTask;
    }
}
