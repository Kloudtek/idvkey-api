/*
 * Copyright (c) 2016 Kloudtek Ltd
 */

package com.kloudtek.idvkey.api;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

/**
 * approval request status
 */
@JsonClassDescription("approval request status")
public class ApprovalRequestStatus {
    @JsonProperty(required = true)
    @JsonPropertyDescription("approval status")
    private ApprovalStatus status;

    public ApprovalRequestStatus() {
    }

    public ApprovalRequestStatus(ApprovalStatus status) {
        this.status = status;
    }

    public ApprovalStatus getStatus() {
        return status;
    }

    public void setStatus(ApprovalStatus status) {
        this.status = status;
    }

}
