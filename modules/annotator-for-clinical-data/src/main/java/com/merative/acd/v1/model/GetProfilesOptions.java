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
 * The getProfiles options.
 */
public class GetProfilesOptions extends GenericModel {


  /**
   * Builder.
   */
  public static class Builder {

    private Builder(GetProfilesOptions getProfilesOptions) {
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a GetProfilesOptions.
     *
     * @return the getProfilesOptions
     */
    public GetProfilesOptions build() {
      return new GetProfilesOptions(this);
    }
  }

  private GetProfilesOptions(Builder builder) {
  }

  /**
   * New builder.
   *
   * @return a GetProfilesOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}
