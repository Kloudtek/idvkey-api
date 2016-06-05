/*
 * Copyright (c) 2016 Kloudtek Ltd
 */

package com.kloudtek.idvkey.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.net.URL;

/**
 * Operation result, which is returned by IDVKey when you request any kind of user authentication operation.
 */
public class OperationResult {
    @JsonProperty(required = true)
    private String opId;
    @JsonProperty
    private URL redirectUrl;

    public OperationResult() {
    }

    public OperationResult(@NotNull String opId, URL redirectUrl) {
        this.opId = opId;
        this.redirectUrl = redirectUrl;
    }

    /**
     * Operation id
     *
     * @return operation id
     */
    @NotNull
    public String getOpId() {
        return opId;
    }

    public void setOpId(@NotNull String opId) {
        this.opId = opId;
    }

    /**
     * URL that you should redirect your user to
     *
     * @return redirect url
     */
    public URL getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(URL redirectUrl) {
        this.redirectUrl = redirectUrl;
    }
}
