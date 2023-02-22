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

import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * ListStringWrapper.
 */
public class ListStringWrapper extends GenericModel {

  private List<String> data;

  /**
   * Gets the data.
   *
   * @return the data
   */
  public List<String> getData() {
    return data;
  }

  /**
   * Sets the data.
   *
   * @param data the new data
   */
  public void setData(final List<String> data) {
    this.data = data;
  }
}
