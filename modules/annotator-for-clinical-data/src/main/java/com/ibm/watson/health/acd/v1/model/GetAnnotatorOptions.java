/*
 * Copyright 2018 IBM Corp. All Rights Reserved.
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

import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * The getAnnotator options.
 */
public class GetAnnotatorOptions extends GenericModel {

  private String id;

  /**
   * Builder.
   */
  public static class Builder {
    private String id;

    private Builder(GetAnnotatorOptions getAnnotatorOptions) {
      id = getAnnotatorOptions.id;
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
     * Builds a GetAnnotatorOptions.
     *
     * @return the getAnnotatorOptions
     */
    public GetAnnotatorOptions build() {
      return new GetAnnotatorOptions(this);
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the GetAnnotatorOptions builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }
  }

  private GetAnnotatorOptions(Builder builder) {
    Validator.notEmpty(builder.id, "id cannot be empty");
    id = builder.id;
  }

  /**
   * New builder.
   *
   * @return a GetAnnotatorOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the id.
   *
   * The ID the Service API was registered under.
   *
   * @return the id
   */
  public String id() {
    return id;
  }
}
