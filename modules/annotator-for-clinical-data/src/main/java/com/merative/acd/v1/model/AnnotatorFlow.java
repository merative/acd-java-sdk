/* ***************************************************************** */
/*                                                                   */
/* (C) Copyright Merative US L.P. and others 2018, 2023              */
/*                                                                   */
/* SPDX-License-Identifier: Apache-2.0                               */
/*                                                                   */
/* ***************************************************************** */

package com.merative.acd.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

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
