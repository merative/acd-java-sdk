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


/**
 * AnnotatorFlow.
 */
public class AnnotatorFlow extends GenericModel {

  private String profile;
  private Flow flow;

  /*Manually added code*/
  public AnnotatorFlow() {
  }

  /**
   * Builder.
   */
  public static class Builder {
    private String profile;
    private Flow flow;

    private Builder(AnnotatorFlow annotatorFlow) {
      profile = annotatorFlow.profile;
      flow = annotatorFlow.flow;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a AnnotatorFlow.
     *
     * @return the annotatorFlow
     */
    public AnnotatorFlow build() {
      return new AnnotatorFlow(this);
    }

    /**
     * Set the profile.
     *
     * @param profile the profile
     * @return the AnnotatorFlow builder
     */
    public Builder profile(String profile) {
      this.profile = profile;
      return this;
    }

    /**
     * Set the flow.
     *
     * @param flow the flow
     * @return the AnnotatorFlow builder
     */
    public Builder flow(Flow flow) {
      this.flow = flow;
      return this;
    }
  }

  private AnnotatorFlow(Builder builder) {
    profile = builder.profile;
    flow = builder.flow;
  }

  /**
   * New builder.
   *
   * @return a AnnotatorFlow builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the profile.
   *
   * @return the profile
   */
  public String profile() {
    return profile;
  }

  /**
   * Gets the flow.
   *
   * @return the flow
   */
  public Flow flow() {
    return flow;
  }
}
