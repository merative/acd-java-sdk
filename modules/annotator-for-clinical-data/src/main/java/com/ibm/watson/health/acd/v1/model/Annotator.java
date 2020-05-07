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
 * Annotator.
 */
public class Annotator extends GenericModel {

  protected String name;
  protected Map<String, List<String>> parameters;
  protected List<ConfigurationEntity> configurations;

  /**
   * Builder.
   */
  public static class Builder {
    private String name;
    private Map<String, List<String>> parameters;
    private List<ConfigurationEntity> configurations;

    private Builder(Annotator annotator) {
      this.name = annotator.name;
      this.parameters = annotator.parameters;
      this.configurations = annotator.configurations;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param name the name
     */
    public Builder(String name) {
      this.name = name;
    }

    /**
     * Builds a Annotator.
     *
     * @return the new Annotator instance
     */
    public Annotator build() {
      return new Annotator(this);
    }

    /**
     * Adds an configurations to configurations.
     *
     * @param configurations the new configurations
     * @return the Annotator builder
     */
    public Builder addConfigurations(ConfigurationEntity configurations) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(configurations,
        "configurations cannot be null");
      if (this.configurations == null) {
        this.configurations = new ArrayList<ConfigurationEntity>();
      }
      this.configurations.add(configurations);
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the Annotator builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the parameters.
     *
     * @param parameters the parameters
     * @return the Annotator builder
     */
    public Builder parameters(Map<String, List<String>> parameters) {
      this.parameters = parameters;
      return this;
    }

    /**
     * Set the configurations.
     * Existing configurations will be replaced.
     *
     * @param configurations the configurations
     * @return the Annotator builder
     */
    public Builder configurations(List<ConfigurationEntity> configurations) {
      this.configurations = configurations;
      return this;
    }
  }

  protected Annotator(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.name,
      "name cannot be null");
    name = builder.name;
    parameters = builder.parameters;
    configurations = builder.configurations;
  }

  /**
   * New builder.
   *
   * @return a Annotator builder
   */
  public Builder newBuilder() {
    return new Builder(this);
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
   * Gets the parameters.
   *
   * @return the parameters
   */
  public Map<String, List<String>> parameters() {
    return parameters;
  }

  /**
   * Gets the configurations.
   *
   * @return the configurations
   */
  public List<ConfigurationEntity> configurations() {
    return configurations;
  }
}

