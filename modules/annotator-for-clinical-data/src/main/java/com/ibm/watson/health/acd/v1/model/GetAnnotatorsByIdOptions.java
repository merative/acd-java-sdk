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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The getAnnotatorsById options.
 */
public class GetAnnotatorsByIdOptions extends GenericModel {

  protected String id;

  /**
   * Builder.
   */
  public static class Builder {
    private String id;

    private Builder(GetAnnotatorsByIdOptions getAnnotatorsByIdOptions) {
      this.id = getAnnotatorsByIdOptions.id;
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
     * Builds a GetAnnotatorsByIdOptions.
     *
     * @return the new GetAnnotatorsByIdOptions instance
     */
    public GetAnnotatorsByIdOptions build() {
      return new GetAnnotatorsByIdOptions(this);
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the GetAnnotatorsByIdOptions builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }
  }

  protected GetAnnotatorsByIdOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.id,
      "id cannot be empty");
    id = builder.id;
  }

  /**
   * New builder.
   *
   * @return a GetAnnotatorsByIdOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the id.
   *
   * The ID the Service API was registered under.
   *
   * @return the id
   */
  public String id() {
    return id;
  }
}

