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
    @JsonProperty
    private String userRef;

    public AuthenticationRequest() {
    }

    public AuthenticationRequest(URL callbackURL, URL cancelUrl) {
        super(callbackURL, cancelUrl);
    }

    public AuthenticationRequest(URL callbackUrl, URL cancelUrl, SecurityLevel securityLevel) {
        super(callbackUrl, cancelUrl);
        this.securityLevel = securityLevel;
    }

    public AuthenticationRequest(URL callbackUrl, URL cancelUrl, SecurityLevel securityLevel, String userRef) {
        super(callbackUrl, cancelUrl);
        this.securityLevel = securityLevel;
        this.userRef = userRef;
    }

    public AuthenticationRequest(URL callbackUrl, URL cancelUrl, String userRef) {
        super(callbackUrl, cancelUrl);
        this.userRef = userRef;
    }

    public SecurityLevel getSecurityLevel() {
        return securityLevel;
    }

    public void setSecurityLevel(SecurityLevel securityLevel) {
        this.securityLevel = securityLevel;
    }

    public String getUserRef() {
        return userRef;
    }

    public void setUserRef(String userRef) {
        this.userRef = userRef;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AuthenticationRequest)) return false;
        if (!super.equals(o)) return false;

        AuthenticationRequest that = (AuthenticationRequest) o;

        if (securityLevel != that.securityLevel) return false;
        return userRef != null ? userRef.equals(that.userRef) : that.userRef == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (securityLevel != null ? securityLevel.hashCode() : 0);
        result = 31 * result + (userRef != null ? userRef.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AuthenticationRequest{" +
                "securityLevel=" + securityLevel +
                ", userRef='" + userRef + '\'' +
                "} " + super.toString();
    }
}
