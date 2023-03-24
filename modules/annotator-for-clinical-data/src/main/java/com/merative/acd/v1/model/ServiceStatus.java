/* ***************************************************************** */
/*                                                                   */
/* (C) Copyright Merative US L.P. and others 2020, 2023              */
/*                                                                   */
/* SPDX-License-Identifier: Apache-2.0                               */
/*                                                                   */
/* ***************************************************************** */

package com.merative.acd.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * ServiceStatus contains the current service state.
 */
public class ServiceStatus extends GenericModel {

  /**
   * Current service state.
   */
  public interface ServiceState {
    /** OK. */
    String OK = "OK";
    /** WARNING. */
    String WARNING = "WARNING";
    /** ERROR. */
    String ERROR = "ERROR";
  }

  protected String serviceState;
  protected String stateDetails;

  /**
   * Gets the serviceState.
   *
   * scurrent service state.
   *
   * @return the serviceState
   */
  public String getServiceState() {
    return serviceState;
  }

  /**
   * Gets the stateDetails.
   *
   * service state details.
   *
   * @return the stateDetails
   */
  public String getStateDetails() {
    return stateDetails;
  }
}

