/*
 * Copyright (c) 2016 Kloudtek Ltd
 */

package com.kloudtek.idvkey.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import org.jetbrains.annotations.Nullable;

import java.net.URL;

/**
 * If your user is browsing your website and you need to wait until he's responded to a notification, specify a callbackUrl which will make the operation result to include an url for you to redirect the user's to (HTTP 302). Once the user has completed the operation he will be redirected back to the callbackUrl with opId appended as a query parameter
 */
public class AbstractNotificationRequest {
    @JsonProperty
    @JsonPropertyDescription("If your user is browsing your website and you need to wait until he's responded to a notification, specify a callbackUrl which will make the operation result to include an url for you to redirect the user's to (HTTP 302). Once the user has completed the operation he will be redirected back to the callbackUrl with opId appended as a query parameter")
    private URL callbackUrl;
    @JsonProperty(required = false)
    @JsonPropertyDescription("Security level for the notification (if not set will default to the service default)")
    private SecurityLevel securityLevel;

    public AbstractNotificationRequest() {
    }

    public AbstractNotificationRequest(@Nullable URL callbackUrl, @Nullable SecurityLevel securityLevel) {
        this.callbackUrl = callbackUrl;
        this.securityLevel = securityLevel;
    }

    @Nullable
    public URL getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(@Nullable URL callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    public SecurityLevel getSecurityLevel() {
        return securityLevel;
    }

    public void setSecurityLevel(SecurityLevel securityLevel) {
        this.securityLevel = securityLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractNotificationRequest)) return false;

        AbstractNotificationRequest that = (AbstractNotificationRequest) o;

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
        return "AbstractNotificationRequest{" +
                "callbackUrl=" + callbackUrl +
                ", securityLevel=" + securityLevel +
                '}';
    }
}
