/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package org.threeabn.apps.mysdainterless.modal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;

import java.util.Date;
import java.util.UUID;

/**
 * Created by k-joseph on 26/09/17.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MySDAObject {

    @JsonProperty("id")
    @DatabaseField(columnName = "id", generatedId = true)
    private Integer id;

    @JsonProperty("uuid")
    @DatabaseField(columnName = "uuid", unique = true, canBeNull = false)
    private String uuid = UUID.randomUUID().toString();

    @DatabaseField(columnName = "created_on", dataType = DataType.DATE, canBeNull = false)
    @JsonProperty("createdOn")
    private Date createdOn = new Date();

    /**
     * Hides object from user interface
     */
    @JsonProperty("voided")
    @DatabaseField(columnName = "voided", dataType = DataType.BOOLEAN)
    private boolean voided = false;

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("uuid")
    public String getUuid() {
        return uuid;
    }

    @JsonProperty("uuid")
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }


    @JsonProperty("createdOn")
    public Date getCreatedOn() {
        return createdOn;
    }

    @JsonProperty("createdOn")
    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    @JsonProperty("voided")
    public boolean isVoided() {
        return voided;
    }

    @JsonProperty("voided")
    public boolean getVoided() {
        return isVoided();
    }

    @JsonProperty("voided")
    public void setVoided(boolean voided) {
        this.voided = voided;
    }
}
