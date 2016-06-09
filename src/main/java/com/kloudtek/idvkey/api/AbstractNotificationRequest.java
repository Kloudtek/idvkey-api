/*
 * Copyright (c) 2016 Kloudtek Ltd
 */

package com.kloudtek.idvkey.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.Nullable;

import java.net.URL;

/**
 * Created by yannick on 22/3/16.
 */
public class AbstractNotificationRequest {
    @JsonProperty(required = false)
    private URL callbackUrl;

    public AbstractNotificationRequest() {
    }

    public AbstractNotificationRequest(@Nullable URL callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    @Nullable
    public URL getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(@Nullable URL callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractNotificationRequest)) return false;

        AbstractNotificationRequest that = (AbstractNotificationRequest) o;

        return callbackUrl != null ? callbackUrl.equals(that.callbackUrl) : that.callbackUrl == null;

    }

    @Override
    public int hashCode() {
        return callbackUrl != null ? callbackUrl.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "AbstractNotificationRequest{" +
                "callbackUrl=" + callbackUrl +
                '}';
    }
}
