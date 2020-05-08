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
 * The getCorporaConfig options.
 */
public class GetCorporaConfigOptions extends GenericModel {

  protected Boolean verbose;

  /**
   * Builder.
   */
  public static class Builder {
    private Boolean verbose;

    private Builder(GetCorporaConfigOptions getCorporaConfigOptions) {
      this.verbose = getCorporaConfigOptions.verbose;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a GetCorporaConfigOptions.
     *
     * @return the new GetCorporaConfigOptions instance
     */
    public GetCorporaConfigOptions build() {
      return new GetCorporaConfigOptions(this);
    }

    /**
     * Set the verbose.
     *
     * @param verbose the verbose
     * @return the GetCorporaConfigOptions builder
     */
    public Builder verbose(Boolean verbose) {
      this.verbose = verbose;
      return this;
    }
  }

  protected GetCorporaConfigOptions(Builder builder) {
    verbose = builder.verbose;
  }

  /**
   * New builder.
   *
   * @return a GetCorporaConfigOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the verbose.
   *
   * Verbose output.  Default verbose = false.
   *
   * @return the verbose
   */
  public Boolean verbose() {
    return verbose;
  }
}

