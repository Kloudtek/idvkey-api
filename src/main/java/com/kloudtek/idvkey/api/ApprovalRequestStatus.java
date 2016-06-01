/*
 * Copyright (c) 2016 Kloudtek Ltd
 */

package com.kloudtek.idvkey.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Used to request a confirmation from a user
 */
public class ApprovalRequestStatus {
    @JsonProperty
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
