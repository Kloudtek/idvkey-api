/*
 * Copyright (c) 2016 Kloudtek Ltd
 */

package com.kloudtek.idvkey.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.net.URL;

/**
 * Created by yannick on 22/3/16.
 */
public class PreIdentifiedAuthenticationRequest extends AuthenticationRequest {
    @JsonProperty(required = true)
    private String userRef;

    public PreIdentifiedAuthenticationRequest() {
    }

    public PreIdentifiedAuthenticationRequest(@Nullable URL callbackUrl, @Nullable SecurityLevel securityLevel, @NotNull String userRef) {
        super(callbackUrl, securityLevel);
        this.userRef = userRef;
    }

    @NotNull
    public String getUserRef() {
        return userRef;
    }

    public void setUserRef(@NotNull String userRef) {
        this.userRef = userRef;
    }
}
