/*
 * (C) Copyright IBM Corp. 2020.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.ibm.watson.health.acd.v1.model;

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

