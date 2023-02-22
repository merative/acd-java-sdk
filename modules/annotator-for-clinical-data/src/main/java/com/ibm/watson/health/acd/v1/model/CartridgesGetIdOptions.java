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
 * The cartridgesGetId options.
 */
public class CartridgesGetIdOptions extends GenericModel {

  protected String id;

  /**
   * Builder.
   */
  public static class Builder {
    private String id;

    private Builder(CartridgesGetIdOptions cartridgesGetIdOptions) {
      this.id = cartridgesGetIdOptions.id;
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
     * Builds a CartridgesGetIdOptions.
     *
     * @return the new CartridgesGetIdOptions instance
     */
    public CartridgesGetIdOptions build() {
      return new CartridgesGetIdOptions(this);
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the CartridgesGetIdOptions builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }
  }

  protected CartridgesGetIdOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.id,
      "id cannot be empty");
    id = builder.id;
  }

  /**
   * New builder.
   *
   * @return a CartridgesGetIdOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the id.
   *
   * Cartridge ID.
   *
   * @return the id
   */
  public String id() {
    return id;
  }
}

