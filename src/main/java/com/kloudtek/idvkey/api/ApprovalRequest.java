/*
 * Copyright (c) 2016 Kloudtek Ltd
 */

package com.kloudtek.idvkey.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.net.URL;

/**
 * Used to request a confirmation from a user
 */
public class ApprovalRequest extends AbstractNotificationRequest {
    @JsonProperty(required = true)
    @javax.validation.constraints.NotNull
    @JsonPropertyDescription("The user reference for the user which needs to approve this request")
    private String userRef;
    //    @JsonProperty
//    @JsonPropertyDescription("An optional session id. If this is set you will have to provide the same session id when getting the approval status.")
//    private String sessionId;
    @JsonProperty(required = true)
    @javax.validation.constraints.NotNull
    @JsonPropertyDescription("Approval notification title")
    private String title;
    @JsonProperty(required = true)
    @javax.validation.constraints.NotNull
    @JsonPropertyDescription("Approval notification text")
    private String text;
    @JsonProperty
    @JsonPropertyDescription("Approval notification short text. This will be displayed when there is limited size like for example in android notifications")
    private String shortText;
    @JsonProperty
    @JsonPropertyDescription("Set if the text should be centered horizontally")
    private boolean centeredHorizontal = true;
    @JsonProperty
    @JsonPropertyDescription("Set if the text should be centered vertically")
    private boolean centeredVertical = true;
    @JsonProperty
    @JsonPropertyDescription("If set and the user denies the notification, this text will be displayed and the user will be requested to confirm the denial")
    private String denyConfirmMsg;
    @JsonProperty
    @JsonPropertyDescription("If set and the user approves the notification, this text will be displayed and the user will be requested to confirm the approval")
    private String approveConfirmMsg;
    @JsonProperty
    @JsonPropertyDescription("This message will be displayed to the user after he denies approval")
    private String denyMsg;
    @JsonProperty
    @JsonPropertyDescription("This message will be displayed to the user after he approves this request")
    private String approveMsg;
    @JsonProperty
    @JsonPropertyDescription("Security level for this operation. If not set the service/website default security level will be used.")
    private SecurityLevel securityLevel;

    public ApprovalRequest() {
    }

    public ApprovalRequest(@NotNull String userRef, @NotNull URL redirectUrl,
                           @NotNull String title, @NotNull String text) {
        this(userRef, redirectUrl, title, text, null);
    }

    public ApprovalRequest(@NotNull String userRef, @NotNull URL redirectUrl,
                           @NotNull String title, @NotNull String text, @Nullable SecurityLevel securityLevel) {
        super(redirectUrl);
        this.userRef = userRef;
        this.title = title;
        this.text = text;
        this.securityLevel = securityLevel;
    }

    @NotNull
    public String getUserRef() {
        return userRef;
    }

    public void setUserRef(@NotNull String userRef) {
        this.userRef = userRef;
    }

    @NotNull
    public String getTitle() {
        return title;
    }

    public void setTitle(@NotNull String title) {
        this.title = title;
    }

    @NotNull
    public String getText() {
        return text;
    }

    public void setText(@NotNull String text) {
        this.text = text;
    }

    public String getShortText() {
        return shortText;
    }

    public void setShortText(String shortText) {
        this.shortText = shortText;
    }

    public boolean isCenteredHorizontal() {
        return centeredHorizontal;
    }

    public void setCenteredHorizontal(boolean centeredHorizontal) {
        this.centeredHorizontal = centeredHorizontal;
    }

    public boolean isCenteredVertical() {
        return centeredVertical;
    }

    public void setCenteredVertical(boolean centeredVertical) {
        this.centeredVertical = centeredVertical;
    }

    public String getDenyConfirmMsg() {
        return denyConfirmMsg;
    }

    public void setDenyConfirmMsg(String denyConfirmMsg) {
        this.denyConfirmMsg = denyConfirmMsg;
    }

    public String getApproveConfirmMsg() {
        return approveConfirmMsg;
    }

    public void setApproveConfirmMsg(String approveConfirmMsg) {
        this.approveConfirmMsg = approveConfirmMsg;
    }

    public String getDenyMsg() {
        return denyMsg;
    }

    public void setDenyMsg(String denyMsg) {
        this.denyMsg = denyMsg;
    }

    public String getApproveMsg() {
        return approveMsg;
    }

    public void setApproveMsg(String approveMsg) {
        this.approveMsg = approveMsg;
    }

    public SecurityLevel getSecurityLevel() {
        return securityLevel;
    }

    public void setSecurityLevel(SecurityLevel securityLevel) {
        this.securityLevel = securityLevel;
    }
}
