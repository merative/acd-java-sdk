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
 * The updateProfile options.
 */
public class UpdateProfileOptions extends GenericModel {

  protected String id;
  protected String newId;
  protected String newName;
  protected String newDescription;
  protected String newPublishedDate;
  protected Boolean newPublish;
  protected String newVersion;
  protected String newCartridgeId;
  protected List<Annotator> newAnnotators;

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
    private List<Annotator> newAnnotators;

    private Builder(UpdateProfileOptions updateProfileOptions) {
      this.id = updateProfileOptions.id;
      this.newId = updateProfileOptions.newId;
      this.newName = updateProfileOptions.newName;
      this.newDescription = updateProfileOptions.newDescription;
      this.newPublishedDate = updateProfileOptions.newPublishedDate;
      this.newPublish = updateProfileOptions.newPublish;
      this.newVersion = updateProfileOptions.newVersion;
      this.newCartridgeId = updateProfileOptions.newCartridgeId;
      this.newAnnotators = updateProfileOptions.newAnnotators;
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
     * Builds a UpdateProfileOptions.
     *
     * @return the new UpdateProfileOptions instance
     */
    public UpdateProfileOptions build() {
      return new UpdateProfileOptions(this);
    }

    /**
     * Adds an newAnnotators to newAnnotators.
     *
     * @param newAnnotators the new newAnnotators
     * @return the UpdateProfileOptions builder
     */
    public Builder addNewAnnotators(Annotator newAnnotators) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(newAnnotators,
        "newAnnotators cannot be null");
      if (this.newAnnotators == null) {
        this.newAnnotators = new ArrayList<Annotator>();
      }
      this.newAnnotators.add(newAnnotators);
      return this;
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the UpdateProfileOptions builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Set the newId.
     *
     * @param newId the newId
     * @return the UpdateProfileOptions builder
     */
    public Builder newId(String newId) {
      this.newId = newId;
      return this;
    }

    /**
     * Set the newName.
     *
     * @param newName the newName
     * @return the UpdateProfileOptions builder
     */
    public Builder newName(String newName) {
      this.newName = newName;
      return this;
    }

    /**
     * Set the newDescription.
     *
     * @param newDescription the newDescription
     * @return the UpdateProfileOptions builder
     */
    public Builder newDescription(String newDescription) {
      this.newDescription = newDescription;
      return this;
    }

    /**
     * Set the newPublishedDate.
     *
     * @param newPublishedDate the newPublishedDate
     * @return the UpdateProfileOptions builder
     */
    public Builder newPublishedDate(String newPublishedDate) {
      this.newPublishedDate = newPublishedDate;
      return this;
    }

    /**
     * Set the newPublish.
     *
     * @param newPublish the newPublish
     * @return the UpdateProfileOptions builder
     */
    public Builder newPublish(Boolean newPublish) {
      this.newPublish = newPublish;
      return this;
    }

    /**
     * Set the newVersion.
     *
     * @param newVersion the newVersion
     * @return the UpdateProfileOptions builder
     */
    public Builder newVersion(String newVersion) {
      this.newVersion = newVersion;
      return this;
    }

    /**
     * Set the newCartridgeId.
     *
     * @param newCartridgeId the newCartridgeId
     * @return the UpdateProfileOptions builder
     */
    public Builder newCartridgeId(String newCartridgeId) {
      this.newCartridgeId = newCartridgeId;
      return this;
    }

    /**
     * Set the newAnnotators.
     * Existing newAnnotators will be replaced.
     *
     * @param newAnnotators the newAnnotators
     * @return the UpdateProfileOptions builder
     */
    public Builder newAnnotators(List<Annotator> newAnnotators) {
      this.newAnnotators = newAnnotators;
      return this;
    }

    /**
     * Set the acdProfile.
     *
     * @param acdProfile the acdProfile
     * @return the UpdateProfileOptions builder
     */
    public Builder acdProfile(AcdProfile acdProfile) {
      this.newId = acdProfile.id();
      this.newName = acdProfile.name();
      this.newDescription = acdProfile.description();
      this.newPublishedDate = acdProfile.publishedDate();
      this.newPublish = acdProfile.publish();
      this.newVersion = acdProfile.version();
      this.newCartridgeId = acdProfile.cartridgeId();
      this.newAnnotators = acdProfile.annotators();
      return this;
    }
  }

  protected UpdateProfileOptions(Builder builder) {
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
    newAnnotators = builder.newAnnotators;
  }

  /**
   * New builder.
   *
   * @return a UpdateProfileOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the id.
   *
   * Profile ID.
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
   * Gets the newAnnotators.
   *
   * @return the newAnnotators
   */
  public List<Annotator> newAnnotators() {
    return newAnnotators;
  }
}

