/*
 * Copyright (c) 2016 Kloudtek Ltd
 */

package com.kloudtek.idvkey.api;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.kloudtek.kryptotek.CryptoUtils;
import com.kloudtek.kryptotek.DigestAlgorithm;
import com.kloudtek.kryptotek.key.HMACKey;

import java.io.Serializable;
import java.security.InvalidKeyException;
import java.util.Base64;

/**
 * API cryptographic key and metadata
 */
@JsonClassDescription("API cryptographic key and metadata")
public class APIKeyBundle implements Serializable {
    @JsonProperty(value = "id",required = true)
    @JsonPropertyDescription("key id")
    private String id;
    @JsonProperty(value = "alias",required = true)
    @JsonPropertyDescription("key alias")
    private String alias;
    @JsonProperty(value = "type",required = true)
    @JsonPropertyDescription("key type")
    private KeyType type;
    @JsonProperty("value")
    @JsonPropertyDescription("key value (if HMAC will be the raw HMAC key base 64 encoded)")
    private String value;

    public APIKeyBundle() {
    }

    public APIKeyBundle(String id, String alias, KeyType type, String value) {
        this.id = id;
        this.alias = alias;
        this.type = type;
        this.value = value;
    }

    @JsonIgnore
    public HMACKey toHMACKey() throws InvalidKeyException {
        if (type != KeyType.HMAC_SHA256) {
            throw new IllegalArgumentException("Key is not an HMAC_SHA256 Key: " + type.name());
        }
        return CryptoUtils.readHMACKey(DigestAlgorithm.SHA256, Base64.getDecoder().decode(value));
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public KeyType getType() {
        return type;
    }

    public void setType(KeyType type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
