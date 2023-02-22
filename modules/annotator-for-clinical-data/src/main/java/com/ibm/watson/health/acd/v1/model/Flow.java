/* ***************************************************************** */
/*                                                                   */
/* Merative Confidential                                             */
/*                                                                   */
/* (C) Copyright Merative US L.P. 2001, 2023                         */
/*                                                                   */
/* SPDX-License-Identifier: Apache 2-0                               */
/*                                                                   */
/* ***************************************************************** */

package com.ibm.watson.health.acd.v1.model;

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import com.ibm.cloud.sdk.core.util.Validator;

/**
 * Flow.
 */
public class Flow extends GenericModel {

  private List<FlowEntry> elements;
  private Boolean async = true;

  /**
   * Builder.
   */
  public static class Builder {
    private List<FlowEntry> elements;
    private Boolean async;

    private Builder(Flow flow) {
      elements = flow.elements;
      async = flow.async;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a Flow.
     *
     * @return the flow
     */
    public Flow build() {
      return new Flow(this);
    }

    /**
     * Adds an elements to elements.
     *
     * @param elements the new elements
     * @return the Flow builder
     */
    public Builder addElements(FlowEntry elements) {
      Validator.notNull(elements, "elements cannot be null");
      if (this.elements == null) {
        this.elements = new ArrayList<FlowEntry>();
      }
      this.elements.add(elements);
      return this;
    }

    /**
     * Set the elements.
     * Existing elements will be replaced.
     *
     * @param elements the elements
     * @return the Flow builder
     */
    public Builder elements(List<FlowEntry> elements) {
      this.elements = elements;
      return this;
    }

    /**
     * Set the async.
     *
     * @param async the async
     * @return the Flow builder
     */
    public Builder async(Boolean async) {
      this.async = async;
      return this;
    }
  }

  private Flow(Builder builder) {
    elements = builder.elements;
    async = builder.async;
  }

  /**
   * New builder.
   *
   * @return a Flow builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the elements.
   *
   * @return the elements
   */
  public List<FlowEntry> elements() {
    return elements;
  }

  /**
   * Gets the async.
   *
   * @return the async
   */
  public Boolean async() {
    return async;
  }
}
