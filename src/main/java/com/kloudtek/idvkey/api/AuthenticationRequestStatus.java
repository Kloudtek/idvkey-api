/*
 * Copyright (c) 2016 Kloudtek Ltd
 */

package com.kloudtek.idvkey.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.Nullable;

/**
 * Created by yannick on 16/3/16.
 */
public class AuthenticationRequestStatus {
    @JsonProperty
    private ApprovalStatus status;
    @JsonProperty
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
