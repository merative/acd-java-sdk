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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The updateFlows options.
 */
public class UpdateFlowsOptions extends GenericModel {

  protected String id;
  protected String newId;
  protected String newName;
  protected String newDescription;
  protected String newPublishedDate;
  protected Boolean newPublish;
  protected String newVersion;
  protected String newCartridgeId;
  protected List<AnnotatorFlow> newAnnotatorFlows;

  /**
   * Builder.
   */
  public static class Builder {
    private String id;
    private String newId;
    private String newName;
    private String newDescription;
    private String newPublishedDate;
    private Boolean newPublish;
    private String newVersion;
    private String newCartridgeId;
    private List<AnnotatorFlow> newAnnotatorFlows;

    private Builder(UpdateFlowsOptions updateFlowsOptions) {
      this.id = updateFlowsOptions.id;
      this.newId = updateFlowsOptions.newId;
      this.newName = updateFlowsOptions.newName;
      this.newDescription = updateFlowsOptions.newDescription;
      this.newPublishedDate = updateFlowsOptions.newPublishedDate;
      this.newPublish = updateFlowsOptions.newPublish;
      this.newVersion = updateFlowsOptions.newVersion;
      this.newCartridgeId = updateFlowsOptions.newCartridgeId;
      this.newAnnotatorFlows = updateFlowsOptions.newAnnotatorFlows;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param id the id
     */
    public Builder(String id) {
      this.id = id;
    }

    /**
     * Builds a UpdateFlowsOptions.
     *
     * @return the new UpdateFlowsOptions instance
     */
    public UpdateFlowsOptions build() {
      return new UpdateFlowsOptions(this);
    }

    /**
     * Adds an newAnnotatorFlows to newAnnotatorFlows.
     *
     * @param newAnnotatorFlows the new newAnnotatorFlows
     * @return the UpdateFlowsOptions builder
     */
    public Builder addNewAnnotatorFlows(AnnotatorFlow newAnnotatorFlows) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(newAnnotatorFlows,
        "newAnnotatorFlows cannot be null");
      if (this.newAnnotatorFlows == null) {
        this.newAnnotatorFlows = new ArrayList<AnnotatorFlow>();
      }
      this.newAnnotatorFlows.add(newAnnotatorFlows);
      return this;
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the UpdateFlowsOptions builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Set the newId.
     *
     * @param newId the newId
     * @return the UpdateFlowsOptions builder
     */
    public Builder newId(String newId) {
      this.newId = newId;
      return this;
    }

    /**
     * Set the newName.
     *
     * @param newName the newName
     * @return the UpdateFlowsOptions builder
     */
    public Builder newName(String newName) {
      this.newName = newName;
      return this;
    }

    /**
     * Set the newDescription.
     *
     * @param newDescription the newDescription
     * @return the UpdateFlowsOptions builder
     */
    public Builder newDescription(String newDescription) {
      this.newDescription = newDescription;
      return this;
    }

    /**
     * Set the newPublishedDate.
     *
     * @param newPublishedDate the newPublishedDate
     * @return the UpdateFlowsOptions builder
     */
    public Builder newPublishedDate(String newPublishedDate) {
      this.newPublishedDate = newPublishedDate;
      return this;
    }

    /**
     * Set the newPublish.
     *
     * @param newPublish the newPublish
     * @return the UpdateFlowsOptions builder
     */
    public Builder newPublish(Boolean newPublish) {
      this.newPublish = newPublish;
      return this;
    }

    /**
     * Set the newVersion.
     *
     * @param newVersion the newVersion
     * @return the UpdateFlowsOptions builder
     */
    public Builder newVersion(String newVersion) {
      this.newVersion = newVersion;
      return this;
    }

    /**
     * Set the newCartridgeId.
     *
     * @param newCartridgeId the newCartridgeId
     * @return the UpdateFlowsOptions builder
     */
    public Builder newCartridgeId(String newCartridgeId) {
      this.newCartridgeId = newCartridgeId;
      return this;
    }

    /**
     * Set the newAnnotatorFlows.
     * Existing newAnnotatorFlows will be replaced.
     *
     * @param newAnnotatorFlows the newAnnotatorFlows
     * @return the UpdateFlowsOptions builder
     */
    public Builder newAnnotatorFlows(List<AnnotatorFlow> newAnnotatorFlows) {
      this.newAnnotatorFlows = newAnnotatorFlows;
      return this;
    }

    /**
     * Set the acdFlow.
     *
     * @param acdFlow the acdFlow
     * @return the UpdateFlowsOptions builder
     */
    public Builder acdFlow(AcdFlow acdFlow) {
      this.newId = acdFlow.id();
      this.newName = acdFlow.name();
      this.newDescription = acdFlow.description();
      this.newPublishedDate = acdFlow.publishedDate();
      this.newPublish = acdFlow.publish();
      this.newVersion = acdFlow.version();
      this.newCartridgeId = acdFlow.cartridgeId();
      this.newAnnotatorFlows = acdFlow.annotatorFlows();
      return this;
    }
  }

  protected UpdateFlowsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.id,
      "id cannot be empty");
    id = builder.id;
    newId = builder.newId;
    newName = builder.newName;
    newDescription = builder.newDescription;
    newPublishedDate = builder.newPublishedDate;
    newPublish = builder.newPublish;
    newVersion = builder.newVersion;
    newCartridgeId = builder.newCartridgeId;
    newAnnotatorFlows = builder.newAnnotatorFlows;
  }

  /**
   * New builder.
   *
   * @return a UpdateFlowsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the id.
   *
   * Flow ID.
   *
   * @return the id
   */
  public String id() {
    return id;
  }

  /**
   * Gets the newId.
   *
   * @return the newId
   */
  public String newId() {
    return newId;
  }

  /**
   * Gets the newName.
   *
   * @return the newName
   */
  public String newName() {
    return newName;
  }

  /**
   * Gets the newDescription.
   *
   * @return the newDescription
   */
  public String newDescription() {
    return newDescription;
  }

  /**
   * Gets the newPublishedDate.
   *
   * @return the newPublishedDate
   */
  public String newPublishedDate() {
    return newPublishedDate;
  }

  /**
   * Gets the newPublish.
   *
   * @return the newPublish
   */
  public Boolean newPublish() {
    return newPublish;
  }

  /**
   * Gets the newVersion.
   *
   * @return the newVersion
   */
  public String newVersion() {
    return newVersion;
  }

  /**
   * Gets the newCartridgeId.
   *
   * @return the newCartridgeId
   */
  public String newCartridgeId() {
    return newCartridgeId;
  }

  /**
   * Gets the newAnnotatorFlows.
   *
   * @return the newAnnotatorFlows
   */
  public List<AnnotatorFlow> newAnnotatorFlows() {
    return newAnnotatorFlows;
  }
}

