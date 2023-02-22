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
import com.ibm.cloud.sdk.core.util.Validator;

/**
 * The getFlow options.
 */
public class GetFlowOptions extends GenericModel {

  private String id;

  /**
   * Builder.
   */
  public static class Builder {
    private String id;

    private Builder(GetFlowOptions getFlowOptions) {
      id = getFlowOptions.id;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param id the id
     */
    public Builder(String id) {
      this.id = id;
    }

    /**
     * Builds a GetFlowOptions.
     *
     * @return the getFlowOptions
     */
    public GetFlowOptions build() {
      return new GetFlowOptions(this);
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the GetFlowOptions builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }
  }

  private GetFlowOptions(Builder builder) {
    Validator.notEmpty(builder.id, "id cannot be empty");
    id = builder.id;
  }

  /**
   * New builder.
   *
   * @return a GetFlowOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the id.
   *
   * Flow ID.
   *
   * @return the id
   */
  public String id() {
    return id;
  }
}
