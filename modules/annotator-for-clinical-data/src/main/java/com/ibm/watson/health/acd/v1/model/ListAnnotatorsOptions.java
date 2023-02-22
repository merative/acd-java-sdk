/* ***************************************************************** */
/*                                                                   */
/* (C) Copyright Merative US L.P. and others 2018, 2023              */
/*                                                                   */
/* SPDX-License-Identifier: Apache-2.0                               */
/*                                                                   */
/* ***************************************************************** */

package com.ibm.watson.health.acd.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The listAnnotators options.
 */
public class ListAnnotatorsOptions extends GenericModel {


  /**
   * Builder.
   */
  public static class Builder {

    private Builder(ListAnnotatorsOptions listAnnotatorsOptions) {
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a ListAnnotatorsOptions.
     *
     * @return the listAnnotatorsOptions
     */
    public ListAnnotatorsOptions build() {
      return new ListAnnotatorsOptions(this);
    }
  }

  private ListAnnotatorsOptions(Builder builder) {
  }

  /**
   * New builder.
   *
   * @return a ListAnnotatorsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}
