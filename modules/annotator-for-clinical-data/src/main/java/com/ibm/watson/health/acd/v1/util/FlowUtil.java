/* ***************************************************************** */
/*                                                                   */
/* Merative Confidential                                             */
/*                                                                   */
/* (C) Copyright Merative US L.P. 2018, 2023                         */
/*                                                                   */
/* SPDX-License-Identifier: Apache-2.0                               */
/*                                                                   */
/* ***************************************************************** */

package com.ibm.watson.health.acd.v1.util;

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import com.ibm.cloud.sdk.core.util.Validator;
import com.ibm.watson.health.acd.v1.model.Annotator;
import com.ibm.watson.health.acd.v1.model.Flow;
import com.ibm.watson.health.acd.v1.model.FlowEntry;

/**
 * FlowUtil
 *
 * To create flow object.
 *
 * This class is manually written and not generated from swagger codegen.
 * */

public class FlowUtil extends GenericModel {

  private List<String> annotators;
  private Boolean async;

  /**
   * Builder.
   */
  public static class Builder {
    private List<String> annotators;
    private Boolean async;

    private Builder(FlowUtil flowUtil) {
      annotators = flowUtil.annotators;
      async = flowUtil.async;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a FlowUtil.
     *
     * @return the flowUtil
     */
    /*
     *
     * Following code is temporary. Currently async does not work and default value is false.
     * So there is no point of keeping multiple level of flow.
     * In future we have comment out the existing code and following commented code will work.
     *
     * */
    public Flow build() {
      Flow flow = null;
      List<FlowEntry> elementList = new ArrayList<FlowEntry>();

      if (!annotators.isEmpty()) {
        for (String annotator : annotators) {
          FlowEntry flowEntry = createAnnotator(annotator);
          elementList.add(flowEntry);
        }
        flow = new Flow.Builder().elements(elementList).async(false).build();

      }
      return flow;

    }

    /**
     * Adds an annotators to annotators.
     *
     * @param annotators
     *            the new annotators
     * @return the FlowUtil builder
     */
    public Builder addAnnotators(String annotators) {
      Validator.notNull(annotators, "annotators cannot be null");
      if (this.annotators == null) {
        this.annotators = new ArrayList<String>();
      }
      this.annotators.add(annotators);
      return this;
    }

    /**
     * Set the annotators. Existing annotators will be replaced.
     *
     * @param annotators
     *            the annotators
     * @return the FlowUtil builder
     */
    public Builder annotators(List<String> annotators) {
      this.annotators = annotators;
      return this;
    }

    /**
     * Set the async.
     *
     * @param async
     *            the async
     * @return the FlowUtil builder
     */
    public Builder async(Boolean async) {
      this.async = async;
      return this;
    }
  }

  private FlowUtil(Builder builder) {
    annotators = builder.annotators;
    async = builder.async;
  }

  /**
   * New builder.
   *
   * @return a FlowUtil builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the annotators.
   *
   * @return the annotators
   */
  public List<String> annotators() {
    return annotators;
  }

  /**
   * Gets the async.
   *
   * @return the async
   */
  public Boolean async() {
    return async;
  }

  public static FlowEntry createAnnotator(String name) {
    Annotator annotator = new Annotator.Builder().name(name).build();
    FlowEntry flowEntry = new FlowEntry.Builder().annotator(annotator).build();
    return flowEntry;
  }

  public static Flow buildFlow(Flow flow) {
    return flow;
  }
}
