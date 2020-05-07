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
 * The getServiceStatus options.
 */
public class GetServiceStatusOptions extends GenericModel {

  /**
   * Override response format.
   */
  public interface Format {
    /** json. */
    String JSON = "json";
    /** xml. */
    String XML = "xml";
  }

  /**
   * Perform a shallow liveness check.
   */
  public interface LivenessCheck {
    /** true. */
    String TRUE = "true";
    /** false. */
    String FALSE = "false";
  }

  protected String accept;
  protected String format;
  protected String livenessCheck;

  /**
   * Builder.
   */
  public static class Builder {
    private String accept;
    private String format;
    private String livenessCheck;

    private Builder(GetServiceStatusOptions getServiceStatusOptions) {
      this.accept = getServiceStatusOptions.accept;
      this.format = getServiceStatusOptions.format;
      this.livenessCheck = getServiceStatusOptions.livenessCheck;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a GetServiceStatusOptions.
     *
     * @return the new GetServiceStatusOptions instance
     */
    public GetServiceStatusOptions build() {
      return new GetServiceStatusOptions(this);
    }

    /**
     * Set the accept.
     *
     * @param accept the accept
     * @return the GetServiceStatusOptions builder
     */
    public Builder accept(String accept) {
      this.accept = accept;
      return this;
    }

    /**
     * Set the format.
     *
     * @param format the format
     * @return the GetServiceStatusOptions builder
     */
    public Builder format(String format) {
      this.format = format;
      return this;
    }

    /**
     * Set the livenessCheck.
     *
     * @param livenessCheck the livenessCheck
     * @return the GetServiceStatusOptions builder
     */
    public Builder livenessCheck(String livenessCheck) {
      this.livenessCheck = livenessCheck;
      return this;
    }
  }

  protected GetServiceStatusOptions(Builder builder) {
    accept = builder.accept;
    format = builder.format;
    livenessCheck = builder.livenessCheck;
  }

  /**
   * New builder.
   *
   * @return a GetServiceStatusOptions builder
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

  /**
   * Gets the livenessCheck.
   *
   * Perform a shallow liveness check.
   *
   * @return the livenessCheck
   */
  public String livenessCheck() {
    return livenessCheck;
  }
}

