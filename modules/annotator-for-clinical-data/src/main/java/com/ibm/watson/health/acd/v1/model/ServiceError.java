/* ***************************************************************** */
/*                                                                   */
/* Merative Confidential                                             */
/*                                                                   */
/* (C) Copyright Merative US L.P. 2018, 2023                         */
/*                                                                   */
/* SPDX-License-Identifier: Apache-2.0                               */
/*                                                                   */
/* ***************************************************************** */

package com.ibm.watson.health.acd.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Object representing an HTTP response with an error.
 */
public class ServiceError extends GenericModel {

  /**
   * error severity level.
   */
  public interface Level {
    /** ERROR. */
    String ERROR = "ERROR";
    /** WARNING. */
    String WARNING = "WARNING";
    /** INFO. */
    String INFO = "INFO";
  }

  protected Long code;
  protected String message;
  protected String level;
  protected String description;
  protected String moreInfo;
  protected String correlationId;
  protected String artifact;
  protected String href;

  /**
   * Gets the code.
   *
   * respone code.
   *
   * @return the code
   */
  public Long getCode() {
    return code;
  }

  /**
   * Gets the message.
   *
   * response error message.
   *
   * @return the message
   */
  public String getMessage() {
    return message;
  }

  /**
   * Gets the level.
   *
   * error severity level.
   *
   * @return the level
   */
  public String getLevel() {
    return level;
  }

  /**
   * Gets the description.
   *
   * error description.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the moreInfo.
   *
   * additional error information.
   *
   * @return the moreInfo
   */
  public String getMoreInfo() {
    return moreInfo;
  }

  /**
   * Gets the correlationId.
   *
   * error message correlation identifier.
   *
   * @return the correlationId
   */
  public String getCorrelationId() {
    return correlationId;
  }

  /**
   * Gets the artifact.
   *
   * @return the artifact
   */
  public String getArtifact() {
    return artifact;
  }

  /**
   * Gets the href.
   *
   * @return the href
   */
  public String getHref() {
    return href;
  }
}

