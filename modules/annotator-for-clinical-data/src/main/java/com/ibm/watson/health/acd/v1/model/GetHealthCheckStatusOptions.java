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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The getHealthCheckStatus options.
 */
public class GetHealthCheckStatusOptions extends GenericModel {

  /**
   * Override response format.
   */
  public interface Format {
    /** json. */
    String JSON = "json";
    /** xml. */
    String XML = "xml";
  }

  protected String accept;
  protected String format;

  /**
   * Builder.
   */
  public static class Builder {
    private String accept;
    private String format;

    private Builder(GetHealthCheckStatusOptions getHealthCheckStatusOptions) {
      this.accept = getHealthCheckStatusOptions.accept;
      this.format = getHealthCheckStatusOptions.format;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a GetHealthCheckStatusOptions.
     *
     * @return the new GetHealthCheckStatusOptions instance
     */
    public GetHealthCheckStatusOptions build() {
      return new GetHealthCheckStatusOptions(this);
    }

    /**
     * Set the accept.
     *
     * @param accept the accept
     * @return the GetHealthCheckStatusOptions builder
     */
    public Builder accept(String accept) {
      this.accept = accept;
      return this;
    }

    /**
     * Set the format.
     *
     * @param format the format
     * @return the GetHealthCheckStatusOptions builder
     */
    public Builder format(String format) {
      this.format = format;
      return this;
    }
  }

  protected GetHealthCheckStatusOptions(Builder builder) {
    accept = builder.accept;
    format = builder.format;
  }

  /**
   * New builder.
   *
   * @return a GetHealthCheckStatusOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the accept.
   *
   * The type of the response: application/json or application/xml.
   *
   * @return the accept
   */
  public String accept() {
    return accept;
  }

  /**
   * Gets the format.
   *
   * Override response format.
   *
   * @return the format
   */
  public String format() {
    return format;
  }
}

