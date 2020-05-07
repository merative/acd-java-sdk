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
 * The enableCorpusSearchTracking options.
 */
public class EnableCorpusSearchTrackingOptions extends GenericModel {

  protected Boolean enableTracking;

  /**
   * Builder.
   */
  public static class Builder {
    private Boolean enableTracking;

    private Builder(EnableCorpusSearchTrackingOptions enableCorpusSearchTrackingOptions) {
      this.enableTracking = enableCorpusSearchTrackingOptions.enableTracking;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a EnableCorpusSearchTrackingOptions.
     *
     * @return the new EnableCorpusSearchTrackingOptions instance
     */
    public EnableCorpusSearchTrackingOptions build() {
      return new EnableCorpusSearchTrackingOptions(this);
    }

    /**
     * Set the enableTracking.
     *
     * @param enableTracking the enableTracking
     * @return the EnableCorpusSearchTrackingOptions builder
     */
    public Builder enableTracking(Boolean enableTracking) {
      this.enableTracking = enableTracking;
      return this;
    }
  }

  protected EnableCorpusSearchTrackingOptions(Builder builder) {
    enableTracking = builder.enableTracking;
  }

  /**
   * New builder.
   *
   * @return a EnableCorpusSearchTrackingOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the enableTracking.
   *
   * Enable corpus read event tracking.  Default is false.
   *
   * @return the enableTracking
   */
  public Boolean enableTracking() {
    return enableTracking;
  }
}

