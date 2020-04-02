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
