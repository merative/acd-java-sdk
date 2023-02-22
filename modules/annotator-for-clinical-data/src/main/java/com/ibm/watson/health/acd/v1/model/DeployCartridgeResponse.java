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
 * DeployCartridgeResponse.
 */
public class DeployCartridgeResponse extends GenericModel {

  protected Long code;
  protected List<ServiceError> artifactResponse;

  /**
   * Gets the code.
   *
   * @return the code
   */
  public Long getCode() {
    return code;
  }

  /**
   * Gets the artifactResponse.
   *
   * @return the artifactResponse
   */
  public List<ServiceError> getArtifactResponse() {
    return artifactResponse;
  }
}

