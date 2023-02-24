/* ***************************************************************** */
/*                                                                   */
/* (C) Copyright Merative US L.P. and others 2020, 2023              */
/*                                                                   */
/* SPDX-License-Identifier: Apache-2.0                               */
/*                                                                   */
/* ***************************************************************** */

package com.merative.acd.v1.model;

import java.util.List;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * AcdCartridges.
 */
public class AcdCartridges extends GenericModel {

  protected String id;
  protected String name;
  protected String status;
  protected Long statusCode;
  protected String statusLocation;
  protected String startTime;
  protected String endTime;
  protected String duration;
  protected String correlationId;
  protected Long artifactResponseCode;
  protected List<ServiceError> artifactResponse;

  /**
   * Gets the id.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the status.
   *
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * Gets the statusCode.
   *
   * @return the statusCode
   */
  public Long getStatusCode() {
    return statusCode;
  }

  /**
   * Gets the statusLocation.
   *
   * @return the statusLocation
   */
  public String getStatusLocation() {
    return statusLocation;
  }

  /**
   * Gets the startTime.
   *
   * @return the startTime
   */
  public String getStartTime() {
    return startTime;
  }

  /**
   * Gets the endTime.
   *
   * @return the endTime
   */
  public String getEndTime() {
    return endTime;
  }

  /**
   * Gets the duration.
   *
   * @return the duration
   */
  public String getDuration() {
    return duration;
  }

  /**
   * Gets the correlationId.
   *
   * @return the correlationId
   */
  public String getCorrelationId() {
    return correlationId;
  }

  /**
   * Gets the artifactResponseCode.
   *
   * @return the artifactResponseCode
   */
  public Long getArtifactResponseCode() {
    return artifactResponseCode;
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

