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
 * The getFlows options.
 */
public class GetFlowsOptions extends GenericModel {


  /**
   * Builder.
   */
  public static class Builder {

    private Builder(GetFlowsOptions getFlowsOptions) {
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a GetFlowsOptions.
     *
     * @return the getFlowsOptions
     */
    public GetFlowsOptions build() {
      return new GetFlowsOptions(this);
    }
  }

  private GetFlowsOptions(Builder builder) {
  }

  /**
   * New builder.
   *
   * @return a GetFlowsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}
