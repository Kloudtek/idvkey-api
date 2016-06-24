package com.kloudtek.idvkey.api;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import org.jetbrains.annotations.Nullable;

/**
 * Generic notification status
 */
@JsonClassDescription("Generic notification status")
public class GenericNotificationRequestStatus {
    @JsonProperty
    @JsonPropertyDescription("The action that was selected by the user or null if the user hasn't responded to the notification yet")
    private String actionId;

    public GenericNotificationRequestStatus() {
    }

    public GenericNotificationRequestStatus(@Nullable String actionId) {
        this.actionId = actionId;
    }

    @Nullable
    public String getActionId() {
        return actionId;
    }

    public void setActionId(@Nullable String actionId) {
        this.actionId = actionId;
    }
}
