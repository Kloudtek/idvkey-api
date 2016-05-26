/*
 * Copyright (c) 2016 Kloudtek Ltd
 */

package com.kloudtek.idvkey.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.net.URL;

/**
 * Created by yannick on 22/3/16.
 */
public class AuthenticationRequest extends AbstractNotificationRequest {
    @JsonProperty
    private SecurityLevel securityLevel;

    public AuthenticationRequest() {
    }

    public AuthenticationRequest(String serviceId, URL callbackURL, URL cancelUrl) {
        super(serviceId, callbackURL, cancelUrl);
    }

    public AuthenticationRequest(String serviceId, URL callbackUrl, URL cancelUrl, SecurityLevel securityLevel) {
        super(serviceId, callbackUrl, cancelUrl);
        this.securityLevel = securityLevel;
    }

    public SecurityLevel getSecurityLevel() {
        return securityLevel;
    }

    public void setSecurityLevel(SecurityLevel securityLevel) {
        this.securityLevel = securityLevel;
    }
}
