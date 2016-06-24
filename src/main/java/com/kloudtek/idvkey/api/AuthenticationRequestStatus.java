/*
 * Copyright (c) 2016 Kloudtek Ltd
 */

package com.kloudtek.idvkey.api;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import org.jetbrains.annotations.Nullable;

/**
 * Authentication request status
 */
@JsonClassDescription("Authentication request status")
public class AuthenticationRequestStatus {
    @JsonProperty(required = true)
    @JsonPropertyDescription("authentication request status")
    private ApprovalStatus status;
    @JsonProperty
    @JsonPropertyDescription("User reference (or null if authentication hasn't been granted)")
    private String userRef;

    public AuthenticationRequestStatus() {
    }

    public AuthenticationRequestStatus(ApprovalStatus status, @Nullable String userRef) {
        this.status = status;
        this.userRef = userRef;
    }

    public ApprovalStatus getStatus() {
        return status;
    }

    public void setStatus(ApprovalStatus status) {
        this.status = status;
    }

    @Nullable
    public String getUserRef() {
        return userRef;
    }

    public void setUserRef(String userRef) {
        this.userRef = userRef;
    }

}
