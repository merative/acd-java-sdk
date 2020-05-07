/*
 * Copyright 2018 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.ibm.watson.health.iml.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import com.ibm.cloud.sdk.core.util.Validator;

/**
 * The deleteCorpusSchema options.
 */
public class DeleteCorpusSchemaOptions extends GenericModel {

  private String instance;

  /**
   * Builder.
   */
  public static class Builder {
    private String instance;

    private Builder(DeleteCorpusSchemaOptions deleteCorpusSchemaOptions) {
      this.instance = deleteCorpusSchemaOptions.instance;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param instance the instance
     */
    public Builder(String instance) {
      this.instance = instance;
    }

    /**
     * Builds a DeleteCorpusSchemaOptions.
     *
     * @return the deleteCorpusSchemaOptions
     */
    public DeleteCorpusSchemaOptions build() {
      return new DeleteCorpusSchemaOptions(this);
    }

    /**
     * Set the instance.
     *
     * @param instance the instance
     * @return the DeleteCorpusSchemaOptions builder
     */
    public Builder instance(String instance) {
      this.instance = instance;
      return this;
    }
  }

  private DeleteCorpusSchemaOptions(Builder builder) {
    Validator.notNull(builder.instance, "instance cannot be null");
    instance = builder.instance;
  }

  /**
   * New builder.
   *
   * @return a DeleteCorpusSchemaOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the instance.
   *
   * corpus schema.
   *
   * @return the instance
   */
  public String instance() {
    return instance;
  }
}

