/*
 * Copyright (c) 2016 Kloudtek Ltd
 */

package com.kloudtek.idvkey.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.net.URL;

/**
 * Created by yannick on 22/3/16.
 */
public class AbstractNotificationRequest {
    @JsonProperty(required = true)
    @NotNull
    private URL callbackUrl;
    @JsonProperty(required = true)
    @NotNull
    private URL cancelUrl;

    public AbstractNotificationRequest() {
    }

    public AbstractNotificationRequest(URL callbackUrl, URL cancelUrl) {
        this.callbackUrl = callbackUrl;
        this.cancelUrl = cancelUrl;
    }

    @NotNull
    public URL getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(@NotNull URL callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    @NotNull
    public URL getCancelUrl() {
        return cancelUrl;
    }

    public void setCancelUrl(@NotNull URL cancelUrl) {
        this.cancelUrl = cancelUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractNotificationRequest)) return false;

        AbstractNotificationRequest that = (AbstractNotificationRequest) o;

        if (callbackUrl != null ? !callbackUrl.equals(that.callbackUrl) : that.callbackUrl != null) return false;
        return cancelUrl != null ? cancelUrl.equals(that.cancelUrl) : that.cancelUrl == null;

    }

    @Override
    public int hashCode() {
        int result = callbackUrl != null ? callbackUrl.hashCode() : 0;
        result = 31 * result + (cancelUrl != null ? cancelUrl.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AbstractNotificationRequest{" +
                "callbackUrl=" + callbackUrl +
                ", cancelUrl=" + cancelUrl +
                '}';
    }
}
