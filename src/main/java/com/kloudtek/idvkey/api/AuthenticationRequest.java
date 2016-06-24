/*
 * Copyright (c) 2016 Kloudtek Ltd
 */

package com.kloudtek.idvkey.api;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.Nullable;

import javax.validation.constraints.NotNull;
import java.net.URL;

/**
 * Authentication request
 **/
@JsonClassDescription("Authentication request")
public class AuthenticationRequest extends AbstractNotificationRequest {
    public AuthenticationRequest() {
    }

    public AuthenticationRequest(@NotNull URL callbackUrl, @Nullable SecurityLevel securityLevel) {
        super(callbackUrl, securityLevel);
    }

    @Override
    public String toString() {
        return "AuthenticationRequest{} " + super.toString();
    }
}
