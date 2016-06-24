/*
 * Copyright (c) 2016 Kloudtek Ltd
 */

package com.kloudtek.idvkey.api;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.net.URL;

/**
 * Created by yannick on 22/3/16.
 */
@JsonClassDescription("Authentication request where the user has already been linked and has been pre-identified by the service/webi")
public class PreIdentifiedAuthenticationRequest extends AuthenticationRequest {
    @JsonProperty(required = true)
    @JsonPropertyDescription("User reference for the pre-identified user")
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
