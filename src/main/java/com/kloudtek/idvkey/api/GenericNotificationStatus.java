package com.kloudtek.idvkey.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.Nullable;

/**
 * Created by yannick on 3/6/16.
 */
public class GenericNotificationStatus {
    @JsonProperty
    private String actionId;

    public GenericNotificationStatus() {
    }

    public GenericNotificationStatus(@Nullable String actionId) {
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
