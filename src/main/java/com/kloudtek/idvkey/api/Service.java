/*
 * Copyright (c) 2016 Kloudtek Ltd
 */

package com.kloudtek.idvkey.api;

import com.fasterxml.jackson.annotation.*;

import java.util.Date;

/**
 * Represents a service that leverages IDVKey (generally a website)
 */
@JsonRootName("service")
@JsonClassDescription("Represents a service that leverages IDVKey (generally a website)")
public class Service {
    @JsonProperty(required = true)
    @JsonPropertyDescription("Service identifier")
    private String id;
    @JsonProperty(required = true)
    @JsonPropertyDescription("Service name")
    private String name;
    @JsonProperty
    @JsonPropertyDescription("Service website URL")
    private String website;
    @JsonProperty
    @JsonPropertyDescription("Default security level")
    private String defaultSecurityLevel;
    @JsonProperty
    @JsonPropertyDescription("Time at which the service was created")
    private Date created;
    @JsonProperty
    @JsonPropertyDescription("Time at which the service was last updated")
    private Date lastUpdated;

    public Service() {
    }

    public Service(String id, String name, String website, String defaultSecurityLevel, Date created, Date lastUpdated) {
        this.id = id;
        this.name = name;
        this.website = website;
        this.defaultSecurityLevel = defaultSecurityLevel;
        this.created = created;
        this.lastUpdated = lastUpdated;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getDefaultSecurityLevel() {
        return defaultSecurityLevel;
    }

    public void setDefaultSecurityLevel(String defaultSecurityLevel) {
        this.defaultSecurityLevel = defaultSecurityLevel;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
