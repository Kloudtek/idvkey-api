/*
 * Copyright (c) 2016 Kloudtek Ltd
 */

package com.kloudtek.idvkey.api;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import org.jetbrains.annotations.NotNull;

import java.net.URL;

/**
 * User to service link request
 */
@JsonClassDescription("User to service link request status")
public class ServiceLinkRequestStatus {
    @JsonProperty(required = true)
    @JsonPropertyDescription("link request status (PENDING, ACCEPTED, DENIED)")
    @javax.validation.constraints.NotNull
    private ServiceLinkRequestStatusType status;

    public ServiceLinkRequestStatus() {
    }

    public ServiceLinkRequestStatus(ServiceLinkRequestStatusType status) {
        this.status = status;
    }

    public ServiceLinkRequestStatusType getStatus() {
        return status;
    }

    public void setStatus(ServiceLinkRequestStatusType status) {
        this.status = status;
    }
}
