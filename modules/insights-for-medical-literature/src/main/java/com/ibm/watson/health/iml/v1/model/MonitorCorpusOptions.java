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
package com.ibm.watson.health.iml.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The monitorCorpus options.
 */
public class MonitorCorpusOptions extends GenericModel {

  protected String apikey;

  /**
   * Builder.
   */
  public static class Builder {
    private String apikey;

    private Builder(MonitorCorpusOptions monitorCorpusOptions) {
      this.apikey = monitorCorpusOptions.apikey;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param apikey the apikey
     */
    public Builder(String apikey) {
      this.apikey = apikey;
    }

    /**
     * Builds a MonitorCorpusOptions.
     *
     * @return the new MonitorCorpusOptions instance
     */
    public MonitorCorpusOptions build() {
      return new MonitorCorpusOptions(this);
    }

    /**
     * Set the apikey.
     *
     * @param apikey the apikey
     * @return the MonitorCorpusOptions builder
     */
    public Builder apikey(String apikey) {
      this.apikey = apikey;
      return this;
    }
  }

  protected MonitorCorpusOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.apikey,
      "apikey cannot be null");
    apikey = builder.apikey;
  }

  /**
   * New builder.
   *
   * @return a MonitorCorpusOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the apikey.
   *
   * Apikey with read only permissions for monitoring.
   *
   * @return the apikey
   */
  public String apikey() {
    return apikey;
  }
}

