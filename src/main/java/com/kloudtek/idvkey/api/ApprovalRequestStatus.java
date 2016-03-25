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
    private State state;

    public ApprovalRequestStatus() {
    }

    public ApprovalRequestStatus(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public enum State {
        PENDING, APPROVED, DENIED
    }
}
