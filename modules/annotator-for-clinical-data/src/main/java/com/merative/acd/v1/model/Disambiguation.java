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
 * Disambiguation.
 */
public class Disambiguation extends GenericModel {

  private String validity;

  /**
   * Gets the validity.
   *
   * @return the validity
   */
  public String getValidity() {
    return validity;
  }

//  /**
//   * Sets the validity.
//   *
//   * @param validity the new validity
//   */
//  public void setValidity(final String validity) {
//    this.validity = validity;
//  }
}
