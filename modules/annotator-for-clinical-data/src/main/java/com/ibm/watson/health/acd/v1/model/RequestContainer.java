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
 * RequestContainer.
 */
public class RequestContainer extends GenericModel {

  private List<UnstructuredContainer> unstructured;
  private List<AnnotatorFlow> annotatorFlows;

  /**
   * Builder.
   */
  public static class Builder {
    private List<UnstructuredContainer> unstructured;
    private List<AnnotatorFlow> annotatorFlows;

    private Builder(RequestContainer requestContainer) {
      unstructured = requestContainer.unstructured;
      annotatorFlows = requestContainer.annotatorFlows;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a RequestContainer.
     *
     * @return the requestContainer
     */
    public RequestContainer build() {
      return new RequestContainer(this);
    }

    /**
     * Adds an unstructured to unstructured.
     *
     * @param unstructured the new unstructured
     * @return the RequestContainer builder
     */
    public Builder addUnstructured(UnstructuredContainer unstructured) {
      Validator.notNull(unstructured, "unstructured cannot be null");
      if (this.unstructured == null) {
        this.unstructured = new ArrayList<UnstructuredContainer>();
      }
      this.unstructured.add(unstructured);
      return this;
    }

    /**
     * Adds an annotatorFlows to annotatorFlows.
     *
     * @param annotatorFlows the new annotatorFlows
     * @return the RequestContainer builder
     */
    public Builder addAnnotatorFlows(AnnotatorFlow annotatorFlows) {
      Validator.notNull(annotatorFlows, "annotatorFlows cannot be null");
      if (this.annotatorFlows == null) {
        this.annotatorFlows = new ArrayList<AnnotatorFlow>();
      }
      this.annotatorFlows.add(annotatorFlows);
      return this;
    }

    /**
     * Set the unstructured.
     * Existing unstructured will be replaced.
     *
     * @param unstructured the unstructured
     * @return the RequestContainer builder
     */
    public Builder unstructured(List<UnstructuredContainer> unstructured) {
      this.unstructured = unstructured;
      return this;
    }

    /**
     * Set the annotatorFlows.
     * Existing annotatorFlows will be replaced.
     *
     * @param annotatorFlows the annotatorFlows
     * @return the RequestContainer builder
     */
    public Builder annotatorFlows(List<AnnotatorFlow> annotatorFlows) {
      this.annotatorFlows = annotatorFlows;
      return this;
    }
  }

  private RequestContainer(Builder builder) {
    unstructured = builder.unstructured;
    annotatorFlows = builder.annotatorFlows;
  }

  /**
   * New builder.
   *
   * @return a RequestContainer builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the unstructured.
   *
   * @return the unstructured
   */
  public List<UnstructuredContainer> unstructured() {
    return unstructured;
  }

  /**
   * Gets the annotatorFlows.
   *
   * @return the annotatorFlows
   */
  public List<AnnotatorFlow> annotatorFlows() {
    return annotatorFlows;
  }
}
