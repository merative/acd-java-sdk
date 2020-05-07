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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * AnnotatorFlow.
 */
public class AnnotatorFlow extends GenericModel {

  protected String profile;
  protected Flow flow;
  protected String id;
  protected String type;
  protected Map<String, List<Entity>> data;
  protected Map<String, Object> metadata;
  protected List<ConfigurationEntity> globalConfigurations;
  protected Long uid;

  /**
   * Builder.
   */
  public static class Builder {
    private String profile;
    private Flow flow;
    private String id;
    private String type;
    private Map<String, List<Entity>> data;
    private Map<String, Object> metadata;
    private List<ConfigurationEntity> globalConfigurations;
    private Long uid;

    private Builder(AnnotatorFlow annotatorFlow) {
      this.profile = annotatorFlow.profile;
      this.flow = annotatorFlow.flow;
      this.id = annotatorFlow.id;
      this.type = annotatorFlow.type;
      this.data = annotatorFlow.data;
      this.metadata = annotatorFlow.metadata;
      this.globalConfigurations = annotatorFlow.globalConfigurations;
      this.uid = annotatorFlow.uid;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param flow the flow
     */
    public Builder(Flow flow) {
      this.flow = flow;
    }

    /**
     * Builds a AnnotatorFlow.
     *
     * @return the new AnnotatorFlow instance
     */
    public AnnotatorFlow build() {
      return new AnnotatorFlow(this);
    }

    /**
     * Adds an globalConfigurations to globalConfigurations.
     *
     * @param globalConfigurations the new globalConfigurations
     * @return the AnnotatorFlow builder
     */
    public Builder addGlobalConfigurations(ConfigurationEntity globalConfigurations) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(globalConfigurations,
        "globalConfigurations cannot be null");
      if (this.globalConfigurations == null) {
        this.globalConfigurations = new ArrayList<ConfigurationEntity>();
      }
      this.globalConfigurations.add(globalConfigurations);
      return this;
    }

    /**
     * Set the profile.
     *
     * @param profile the profile
     * @return the AnnotatorFlow builder
     */
    public Builder profile(String profile) {
      this.profile = profile;
      return this;
    }

    /**
     * Set the flow.
     *
     * @param flow the flow
     * @return the AnnotatorFlow builder
     */
    public Builder flow(Flow flow) {
      this.flow = flow;
      return this;
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the AnnotatorFlow builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the AnnotatorFlow builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Set the data.
     *
     * @param data the data
     * @return the AnnotatorFlow builder
     */
    public Builder data(Map<String, List<Entity>> data) {
      this.data = data;
      return this;
    }

    /**
     * Set the metadata.
     *
     * @param metadata the metadata
     * @return the AnnotatorFlow builder
     */
    public Builder metadata(Map<String, Object> metadata) {
      this.metadata = metadata;
      return this;
    }

    /**
     * Set the globalConfigurations.
     * Existing globalConfigurations will be replaced.
     *
     * @param globalConfigurations the globalConfigurations
     * @return the AnnotatorFlow builder
     */
    public Builder globalConfigurations(List<ConfigurationEntity> globalConfigurations) {
      this.globalConfigurations = globalConfigurations;
      return this;
    }

    /**
     * Set the uid.
     *
     * @param uid the uid
     * @return the AnnotatorFlow builder
     */
    public Builder uid(long uid) {
      this.uid = uid;
      return this;
    }
  }

  protected AnnotatorFlow(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.flow,
      "flow cannot be null");
    profile = builder.profile;
    flow = builder.flow;
    id = builder.id;
    type = builder.type;
    data = builder.data;
    metadata = builder.metadata;
    globalConfigurations = builder.globalConfigurations;
    uid = builder.uid;
  }

  /**
   * New builder.
   *
   * @return a AnnotatorFlow builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the profile.
   *
   * @return the profile
   */
  public String profile() {
    return profile;
  }

  /**
   * Gets the flow.
   *
   * @return the flow
   */
  public Flow flow() {
    return flow;
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
   * Gets the data.
   *
   * @return the data
   */
  public Map<String, List<Entity>> data() {
    return data;
  }

  /**
   * Gets the metadata.
   *
   * @return the metadata
   */
  public Map<String, Object> metadata() {
    return metadata;
  }

  /**
   * Gets the globalConfigurations.
   *
   * @return the globalConfigurations
   */
  public List<ConfigurationEntity> globalConfigurations() {
    return globalConfigurations;
  }

  /**
   * Gets the uid.
   *
   * @return the uid
   */
  public Long uid() {
    return uid;
  }
}

