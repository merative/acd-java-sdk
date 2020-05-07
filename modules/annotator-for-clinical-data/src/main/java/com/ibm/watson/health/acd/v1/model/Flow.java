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

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Flow.
 */
public class Flow extends GenericModel {

  protected List<FlowEntry> elements;
  protected Boolean async;

  /**
   * Builder.
   */
  public static class Builder {
    private List<FlowEntry> elements;
    private Boolean async;

    private Builder(Flow flow) {
      this.elements = flow.elements;
      this.async = flow.async;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a Flow.
     *
     * @return the new Flow instance
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
      com.ibm.cloud.sdk.core.util.Validator.notNull(elements,
        "elements cannot be null");
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

  protected Flow(Builder builder) {
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

