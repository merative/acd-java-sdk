/*
 * (C) Copyright IBM Corp. 2020.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.ibm.watson.health.acd.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * ConfigurationEntity.
 */
public class ConfigurationEntity extends GenericModel {

  protected String id;
  protected String type;
  protected Long uid;
  protected Long mergeid;

  /**
   * Builder.
   */
  public static class Builder {
    private String id;
    private String type;
    private Long uid;
    private Long mergeid;

    private Builder(ConfigurationEntity configurationEntity) {
      this.id = configurationEntity.id;
      this.type = configurationEntity.type;
      this.uid = configurationEntity.uid;
      this.mergeid = configurationEntity.mergeid;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a ConfigurationEntity.
     *
     * @return the new ConfigurationEntity instance
     */
    public ConfigurationEntity build() {
      return new ConfigurationEntity(this);
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the ConfigurationEntity builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the ConfigurationEntity builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Set the uid.
     *
     * @param uid the uid
     * @return the ConfigurationEntity builder
     */
    public Builder uid(long uid) {
      this.uid = uid;
      return this;
    }

    /**
     * Set the mergeid.
     *
     * @param mergeid the mergeid
     * @return the ConfigurationEntity builder
     */
    public Builder mergeid(long mergeid) {
      this.mergeid = mergeid;
      return this;
    }
  }

  protected ConfigurationEntity(Builder builder) {
    id = builder.id;
    type = builder.type;
    uid = builder.uid;
    mergeid = builder.mergeid;
  }

  /**
   * New builder.
   *
   * @return a ConfigurationEntity builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the id.
   *
   * @return the id
   */
  public String id() {
    return id;
  }

  /**
   * Gets the type.
   *
   * @return the type
   */
  public String type() {
    return type;
  }

  /**
   * Gets the uid.
   *
   * @return the uid
   */
  public Long uid() {
    return uid;
  }

  /**
   * Gets the mergeid.
   *
   * @return the mergeid
   */
  public Long mergeid() {
    return mergeid;
  }
}

