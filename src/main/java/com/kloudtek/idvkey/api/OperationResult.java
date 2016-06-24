/*
 * Copyright (c) 2016 Kloudtek Ltd
 */

package com.kloudtek.idvkey.api;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import javax.validation.constraints.NotNull;
import java.net.URL;

/**
 * IDVKey operation result.
 */
@JsonClassDescription("IDVKey operation result")
public class OperationResult {
    @JsonProperty(required = true)
    @JsonPropertyDescription("Operation identifier (this will be needed in order to check the operation status")
    private String opId;
    @JsonProperty
    @JsonPropertyDescription("If a callback URL was specified in the request, this will provide you a URL that you should redirect (HTTP 302) your user browser's to. Once the operation is completed the user will be redirected back to the callbackUrl specified")
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
