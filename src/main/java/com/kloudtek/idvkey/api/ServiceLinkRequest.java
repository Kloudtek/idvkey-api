/*
 * Copyright (c) 2016 Kloudtek Ltd
 */

package com.kloudtek.idvkey.api;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;

import java.net.URL;

/**
 * User to service link request
 */
@JsonClassDescription("User to service link request")
public class ServiceLinkRequest {
    @JsonProperty(required = true)
    @javax.validation.constraints.NotNull
    private String userRef;
    @JsonProperty
    private URL url;

    public ServiceLinkRequest() {
    }

    public ServiceLinkRequest(@NotNull String userRef, @NotNull URL url) {
        this.userRef = userRef;
        this.url = url;
    }

    @NotNull
    public String getUserRef() {
        return userRef;
    }

    public void setUserRef(@NotNull String userRef) {
        this.userRef = userRef;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }
}
