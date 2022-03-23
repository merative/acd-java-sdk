/*
 * Copyright 2018, 2022 IBM Corp. All Rights Reserved.
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
