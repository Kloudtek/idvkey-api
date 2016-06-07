package com.kloudtek.idvkey.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Request to display a generic notification to the user
 */
public class GenericNotificationRequest extends AbstractNotificationRequest {
    @JsonProperty(required = true)
    @javax.validation.constraints.NotNull
    private String userRef;
    @JsonProperty(required = true)
    @javax.validation.constraints.NotNull
    private String title;
    @JsonProperty(required = true)
    @javax.validation.constraints.NotNull
    private String text;
    @JsonProperty(required = false, defaultValue = "false")
    private boolean urgent;
    @JsonProperty(required = false, defaultValue = "true")
    private boolean centeredHorizontal;
    @JsonProperty(required = false, defaultValue = "true")
    private boolean centeredVertical;
    @JsonProperty(required = false, defaultValue = "true")
    private boolean cancellable;
    @JsonProperty(required = false)
    private SecurityLevel securityLevel;
    @JsonProperty(required = false)
    private Date expiry;
    @JsonProperty
    private List<Action> actions = new ArrayList<>();

    public GenericNotificationRequest() {
    }

    public GenericNotificationRequest(@NotNull String userRef, @NotNull URL callbackUrl, @NotNull URL cancelUrl, @NotNull String title, @NotNull String text, @Nullable SecurityLevel securityLevel, @Nullable Date expiry, Action... actions) {
        this(userRef, callbackUrl, cancelUrl, title, text, true, true, true, securityLevel, expiry, actions);
    }

    public GenericNotificationRequest(@NotNull String userRef, @NotNull URL callbackUrl, @NotNull URL cancelUrl, @NotNull String title, @NotNull String text, boolean centeredHorizontal, boolean centeredVertical,
                                      boolean cancellable, @Nullable SecurityLevel securityLevel, @Nullable Date expiry, Action... actions) {
        super(callbackUrl);
        this.userRef = userRef;
        this.title = title;
        this.text = text;
        this.centeredHorizontal = centeredHorizontal;
        this.centeredVertical = centeredVertical;
        this.cancellable = cancellable;
        this.securityLevel = securityLevel;
        this.expiry = expiry;
        if (actions != null) {
            this.actions = Arrays.asList(actions);
        }
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

    /**
     * Set the text to be displayed to the user
     *
     * @return Text to display to the user
     */
    @NotNull
    public String getText() {
        return text;
    }

    /**
     * Get the text to be displayed to the user
     *
     * @param text Text to be displayed
     */
    public void setText(@NotNull String text) {
        this.text = text;
    }

    /**
     * Get if the notification is urgent
     *
     * @return True if the notification is urgent
     */
    public boolean isUrgent() {
        return urgent;
    }

    /**
     * Set if the notification is urgent
     *
     * @param urgent True
     */
    public void setUrgent(boolean urgent) {
        this.urgent = urgent;
    }

    /**
     * Get if the text should be centered horizontally
     *
     * @return True if the text should be centered horizontally
     */
    public boolean isCenteredHorizontal() {
        return centeredHorizontal;
    }

    /**
     * Set if the text should be centered horizontally
     *
     * @param centeredHorizontal True if the text should be centered horizontally
     */
    public void setCenteredHorizontal(boolean centeredHorizontal) {
        this.centeredHorizontal = centeredHorizontal;
    }

    /**
     * Get if the text should be centered vertically
     *
     * @return True if the text should be centered vertically
     */
    public boolean isCenteredVertical() {
        return centeredVertical;
    }

    /**
     * Set if the text should be centered vertically
     *
     * @param centeredVertical True if the text should be centered vertically
     */
    public void setCenteredVertical(boolean centeredVertical) {
        this.centeredVertical = centeredVertical;
    }

    /**
     * Set if this action is cancellable
     *
     * @return True if the action can be cancelled before the user has acted on it.
     */
    public boolean isCancellable() {
        return cancellable;
    }

    /**
     * Set if this action is cancellable
     *
     * @param cancellable True if the action can be cancelled before the user has acted on it.
     */
    public void setCancellable(boolean cancellable) {
        this.cancellable = cancellable;
    }

    /**
     * Get the security level for this notification. If null the default service/website security level will be used instead
     *
     * @return Security level (or null)
     */
    @Nullable
    public SecurityLevel getSecurityLevel() {
        return securityLevel;
    }

    /**
     * Set the security level for this notification. If null the default service/website security level will be used instead
     *
     * @param securityLevel Security level or null if default should be used
     */
    public void setSecurityLevel(@Nullable SecurityLevel securityLevel) {
        this.securityLevel = securityLevel;
    }

    /**
     * Get the expiry for this notification (there might still be a maximum expiry depending on your idvkey subscription plan)
     *
     * @return Expiry for this notification or null if it shouldn't expire
     */
    public Date getExpiry() {
        return expiry;
    }

    /**
     * Set the expiry date for this notification (there might still be a maximum expiry depending on your idvkey subscription plan)
     *
     * @param expiry Expiry data or null if it shouldn't expire.
     */
    public void setExpiry(Date expiry) {
        this.expiry = expiry;
    }

    /**
     * Get all actions that will be made available for the user
     *
     * @return Actions
     */
    public List<Action> getActions() {
        return actions;
    }

    /**
     * Set actions that will be made available to the user
     *
     * @param actions Actions
     */
    public void setActions(List<Action> actions) {
        this.actions = actions;
    }

    /**
     * Add an action
     *
     * @param action action to add
     */
    public void addAction(Action action) {
        if (actions == null) {
            actions = new ArrayList<>();
        }
        actions.add(action);
    }

    /**
     * Actions that will be made available to the user (as a button to click on for example). The id of the selected action will be available in the notification status
     */
    public static class Action {
        @JsonProperty(required = true)
        @javax.validation.constraints.NotNull
        private String id;
        @JsonProperty(required = true)
        @javax.validation.constraints.NotNull
        private String name;
        @JsonProperty(required = false)
        private String color;
        @JsonProperty(required = false)
        private String confirmationMsg;
        @JsonProperty(required = false)
        private String postSelectionMsg;
        @JsonProperty(required = true)
        @javax.validation.constraints.NotNull
        private Location location;

        public Action() {
        }

        public Action(@NotNull String id, String name, @NotNull Location location) {
            this.id = id;
            this.name = name;
            this.location = location;
        }

        public Action(@NotNull String id, String name, @Nullable String color, @Nullable String confirmationMsg, @Nullable String postSelectionMsg, @NotNull Location location) {
            this(id, name, location);
            this.color = color;
            this.confirmationMsg = confirmationMsg;
            this.postSelectionMsg = postSelectionMsg;
        }

        /**
         * Get color for MAIN_BUTTON colors
         *
         * @return color
         */
        @Nullable
        public String getColor() {
            return color;
        }

        /**
         * Color to be used for an MAIN_BUTTON action.
         *
         * @param color Color ( in form of  #RRGGBB #AARRGGBB or one of the following names: 'red', 'blue', 'green', 'black', 'white', 'gray', 'cyan', 'magenta', 'yellow', 'lightgray', 'darkgray', 'grey', 'lightgrey', 'darkgrey', 'aqua', 'fuchsia', 'lime', 'maroon', 'navy', 'olive', 'purple', 'silver', 'teal'.  )
         */
        public void setColor(@Nullable String color) {
            this.color = color;
        }

        /**
         * Get the action's id
         *
         * @return Button id
         */
        @NotNull
        public String getId() {
            return id;
        }

        /**
         * Set the action's id
         *
         * @param id Action id
         */
        public void setId(@NotNull String id) {
            this.id = id;
        }

        /**
         * Get the action name that will be displayed to the user
         *
         * @return Action name
         */
        @NotNull
        public String getName() {
            return name;
        }

        /**
         * Set the action name that will be displayed to the user
         *
         * @param name Action name
         */
        public void setName(@NotNull String name) {
            this.name = name;
        }

        /**
         * Set a confirmation message that will be displayed to the user if he choose this action, for the user to confirm his choice of this action
         *
         * @return Confirmation message.
         */
        @Nullable
        public String getConfirmationMsg() {
            return confirmationMsg;
        }

        /**
         * Get a confirmation message that will be displayed to the user if he choose this action, for the user to confirm his choice of this action
         *
         * @param confirmationMsg Confirmation message
         */
        public void setConfirmationMsg(@Nullable String confirmationMsg) {
            this.confirmationMsg = confirmationMsg;
        }

        /**
         * Get a message that will be displayed after a use selects this action (this will happen after the confirmation msg has been displayed and accepted, should one have been set)
         *
         * @return post selection message
         */
        @Nullable
        public String getPostSelectionMsg() {
            return postSelectionMsg;
        }

        /**
         * Set a message that will be displayed after a use selects this action (this will happen after the confirmation msg has been displayed and accepted, should one have been set)
         *
         * @param postSelectionMsg post selection message.
         */
        public void setPostSelectionMsg(@Nullable String postSelectionMsg) {
            this.postSelectionMsg = postSelectionMsg;
        }

        /**
         * Get the location of this action in the UI. This can be with as a main button (we strongly recommend not to use more than 3 actions in that location) or in the menu.
         *
         * @return Action location
         */
        @NotNull
        public Location getLocation() {
            return location;
        }

        /**
         * Get the location of this action in the UI. This can be with as a main button (we strongly recommend not to use more than 3 actions in that location) or in the menu.
         *
         * @param location action UI location
         */
        public void setLocation(@NotNull Location location) {
            this.location = location;
        }
    }

    public enum Location {
        MAIN_BUTTON, MENU
    }
}
