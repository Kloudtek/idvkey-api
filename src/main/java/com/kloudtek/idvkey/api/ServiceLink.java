/*
 * Copyright (c) 2016 Kloudtek Ltd
 */

package com.kloudtek.idvkey.api;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

/**
 * User link to a service
 */
@JsonClassDescription("User link to a service")
public class ServiceLink {
    @JsonProperty(required = true)
    @JsonPropertyDescription("service identifier")
    private String serviceId;
    @JsonProperty(required = true)
    @JsonPropertyDescription("user reference")
    private String userRef;

    public ServiceLink() {
    }

    public ServiceLink(String serviceId, String userRef) {
        this.serviceId = serviceId;
        this.userRef = userRef;
    }

    public String getUserRef() {
        return userRef;
    }

    public void setUserRef(String userRef) {
        this.userRef = userRef;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }
}
