/*
 * Copyright (c) 2016 Kloudtek Ltd
 */

package com.kloudtek.idvkey.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;

import java.net.URL;

/**
 * Created by yannick on 17/3/16.
 */
public class ServiceLinkRequest {
    @JsonProperty(required = true)
    @javax.validation.constraints.NotNull
    private String userRef;
    @JsonProperty(required = true)
    @javax.validation.constraints.NotNull
    private URL url;
    @JsonProperty(required = true)
    @javax.validation.constraints.NotNull
    private URL cancelUrl;

    public ServiceLinkRequest() {
    }

    public ServiceLinkRequest(@NotNull String userRef, @NotNull URL url, @NotNull URL cancelUrl) {
        this.userRef = userRef;
        this.url = url;
        this.cancelUrl = cancelUrl;
    }

    @NotNull
    public String getUserRef() {
        return userRef;
    }

    public void setUserRef(@NotNull String userRef) {
        this.userRef = userRef;
    }

    @NotNull
    public URL getUrl() {
        return url;
    }

    public void setUrl(@NotNull URL url) {
        this.url = url;
    }

    @NotNull
    public URL getCancelUrl() {
        return cancelUrl;
    }

    public void setCancelUrl(@NotNull URL cancelUrl) {
        this.cancelUrl = cancelUrl;
    }
}
