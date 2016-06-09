/*
 * Copyright (c) 2016 Kloudtek Ltd
 */

package com.kloudtek.idvkey.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.Nullable;

import javax.validation.constraints.NotNull;
import java.net.URL;

/**
 * Created by yannick on 22/3/16.
 */
public class AuthenticationRequest {
    @JsonProperty(required = true)
    private URL callbackUrl;
    @JsonProperty
    private SecurityLevel securityLevel;

    public AuthenticationRequest() {
    }

    public AuthenticationRequest(@NotNull URL callbackUrl, @Nullable SecurityLevel securityLevel) {
        this.callbackUrl = callbackUrl;
        this.securityLevel = securityLevel;
    }

    @NotNull
    public URL getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(@NotNull URL callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    @Nullable
    public SecurityLevel getSecurityLevel() {
        return securityLevel;
    }

    public void setSecurityLevel(@Nullable SecurityLevel securityLevel) {
        this.securityLevel = securityLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AuthenticationRequest)) return false;

        AuthenticationRequest that = (AuthenticationRequest) o;

        if (callbackUrl != null ? !callbackUrl.equals(that.callbackUrl) : that.callbackUrl != null) return false;
        return securityLevel == that.securityLevel;

    }

    @Override
    public int hashCode() {
        int result = callbackUrl != null ? callbackUrl.hashCode() : 0;
        result = 31 * result + (securityLevel != null ? securityLevel.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AuthenticationRequest{" +
                "callbackUrl=" + callbackUrl +
                ", securityLevel=" + securityLevel +
                '}';
    }
}
