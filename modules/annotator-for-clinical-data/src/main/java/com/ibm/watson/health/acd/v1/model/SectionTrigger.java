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
 * Section trigger.
 */
public class SectionTrigger extends GenericModel {

  private String type;
  private Long begin;
  private Long end;
  private String coveredText;
  private String source;
  private String sectionNormalizedName;

  /**
   * Get the trigger type.
   * @return the trigger type
   */
  public String getType() {
    return type;
  }

  /**
   * Get the trigger beginning offset.
   * @return beginning offset
   */
  public Long getBegin() {
    return begin;
  }

  /**
   * Get the trigger ending offset.
   * @return ending offset
   */
  public Long getEnd() {
    return end;
  }

  /**
   * Get the trigger text.
   * @return covered text
   */
  public String getCoveredText() {
    return coveredText;
  }

  /**
   * Get the trigger ontology source.
   * @return the source
   */
  public String getSource() {
    return source;
  }

  /**
   * Get the trigger section name.
   * @return normalized section name
   */
  public String getSectionNormalizedName() {
    return sectionNormalizedName;
  }

}
