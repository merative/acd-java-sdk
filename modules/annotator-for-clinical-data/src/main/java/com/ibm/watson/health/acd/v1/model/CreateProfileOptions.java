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
 * The createProfile options.
 */
public class CreateProfileOptions extends GenericModel {

  protected String id;
  protected String name;
  protected String description;
  protected String publishedDate;
  protected Boolean publish;
  protected String version;
  protected String cartridgeId;
  protected List<Annotator> annotators;

  /**
   * Builder.
   */
  public static class Builder {
    private String id;
    private String name;
    private String description;
    private String publishedDate;
    private Boolean publish;
    private String version;
    private String cartridgeId;
    private List<Annotator> annotators;

    private Builder(CreateProfileOptions createProfileOptions) {
      this.id = createProfileOptions.id;
      this.name = createProfileOptions.name;
      this.description = createProfileOptions.description;
      this.publishedDate = createProfileOptions.publishedDate;
      this.publish = createProfileOptions.publish;
      this.version = createProfileOptions.version;
      this.cartridgeId = createProfileOptions.cartridgeId;
      this.annotators = createProfileOptions.annotators;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a CreateProfileOptions.
     *
     * @return the new CreateProfileOptions instance
     */
    public CreateProfileOptions build() {
      return new CreateProfileOptions(this);
    }

    /**
     * Adds an annotators to annotators.
     *
     * @param annotators the new annotators
     * @return the CreateProfileOptions builder
     */
    public Builder addAnnotators(Annotator annotators) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(annotators,
        "annotators cannot be null");
      if (this.annotators == null) {
        this.annotators = new ArrayList<Annotator>();
      }
      this.annotators.add(annotators);
      return this;
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the CreateProfileOptions builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the CreateProfileOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the CreateProfileOptions builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the publishedDate.
     *
     * @param publishedDate the publishedDate
     * @return the CreateProfileOptions builder
     */
    public Builder publishedDate(String publishedDate) {
      this.publishedDate = publishedDate;
      return this;
    }

    /**
     * Set the publish.
     *
     * @param publish the publish
     * @return the CreateProfileOptions builder
     */
    public Builder publish(Boolean publish) {
      this.publish = publish;
      return this;
    }

    /**
     * Set the version.
     *
     * @param version the version
     * @return the CreateProfileOptions builder
     */
    public Builder version(String version) {
      this.version = version;
      return this;
    }

    /**
     * Set the cartridgeId.
     *
     * @param cartridgeId the cartridgeId
     * @return the CreateProfileOptions builder
     */
    public Builder cartridgeId(String cartridgeId) {
      this.cartridgeId = cartridgeId;
      return this;
    }

    /**
     * Set the annotators.
     * Existing annotators will be replaced.
     *
     * @param annotators the annotators
     * @return the CreateProfileOptions builder
     */
    public Builder annotators(List<Annotator> annotators) {
      this.annotators = annotators;
      return this;
    }

    /**
     * Set the acdProfile.
     *
     * @param acdProfile the acdProfile
     * @return the CreateProfileOptions builder
     */
    public Builder acdProfile(AcdProfile acdProfile) {
      this.id = acdProfile.id();
      this.name = acdProfile.name();
      this.description = acdProfile.description();
      this.publishedDate = acdProfile.publishedDate();
      this.publish = acdProfile.publish();
      this.version = acdProfile.version();
      this.cartridgeId = acdProfile.cartridgeId();
      this.annotators = acdProfile.annotators();
      return this;
    }
  }

  protected CreateProfileOptions(Builder builder) {
    id = builder.id;
    name = builder.name;
    description = builder.description;
    publishedDate = builder.publishedDate;
    publish = builder.publish;
    version = builder.version;
    cartridgeId = builder.cartridgeId;
    annotators = builder.annotators;
  }

  /**
   * New builder.
   *
   * @return a CreateProfileOptions builder
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
   * Gets the name.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the description.
   *
   * @return the description
   */
  public String description() {
    return description;
  }

  /**
   * Gets the publishedDate.
   *
   * @return the publishedDate
   */
  public String publishedDate() {
    return publishedDate;
  }

  /**
   * Gets the publish.
   *
   * @return the publish
   */
  public Boolean publish() {
    return publish;
  }

  /**
   * Gets the version.
   *
   * @return the version
   */
  public String version() {
    return version;
  }

  /**
   * Gets the cartridgeId.
   *
   * @return the cartridgeId
   */
  public String cartridgeId() {
    return cartridgeId;
  }

  /**
   * Gets the annotators.
   *
   * @return the annotators
   */
  public List<Annotator> annotators() {
    return annotators;
  }
}

