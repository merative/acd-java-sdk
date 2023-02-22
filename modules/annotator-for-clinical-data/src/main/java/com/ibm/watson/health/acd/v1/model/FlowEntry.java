/* ***************************************************************** */
/*                                                                   */
/* Merative Confidential                                             */
/*                                                                   */
/* (C) Copyright Merative US L.P. 2018, 2023                         */
/*                                                                   */
/* SPDX-License-Identifier: Apache-2.0                               */
/*                                                                   */
/* ***************************************************************** */

package com.ibm.watson.health.acd.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * FlowEntry.
 */
public class FlowEntry extends GenericModel {

  private Annotator annotator;
  private Flow flow;

  /**
   * Builder.
   */
  public static class Builder {
    private Annotator annotator;
    private Flow flow;

    private Builder(FlowEntry flowEntry) {
      annotator = flowEntry.annotator;
      flow = flowEntry.flow;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a FlowEntry.
     *
     * @return the flowEntry
     */
    public FlowEntry build() {
      return new FlowEntry(this);
    }

    /**
     * Set the annotator.
     *
     * @param annotator the annotator
     * @return the FlowEntry builder
     */
    public Builder annotator(Annotator annotator) {
      this.annotator = annotator;
      return this;
    }

    /**
     * Set the flow.
     *
     * @param flow the flow
     * @return the FlowEntry builder
     */
    public Builder flow(Flow flow) {
      this.flow = flow;
      return this;
    }
  }

  private FlowEntry(Builder builder) {
    annotator = builder.annotator;
    flow = builder.flow;
  }

  /**
   * New builder.
   *
   * @return a FlowEntry builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the annotator.
   *
   * @return the annotator
   */
  public Annotator annotator() {
    return annotator;
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
