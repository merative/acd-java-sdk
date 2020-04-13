/*
 * Copyright 2018 IBM Corp. All Rights Reserved.
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

import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Section trigger.
 */
public class SectionTrigger extends GenericModel {

  private String type;
  private String begin;
  private String end;
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
//  public void setType(String type) {
//    this.type = type;
//  }

  /**
   * Get the trigger beginning offset.
   * @return beginning offset
   */
  public String getBegin() {
    return begin;
  }
//  public void setBegin(String begin) {
//    this.begin = begin;
//  }

  /**
   * Get the trigger ending offset.
   * @return ending offset
   */
  public String getEnd() {
    return end;
  }
//  public void setEnd(String end) {
//    this.end = end;
//  }

  /**
   * Get the trigger text.
   * @return covered text
   */
  public String getCoveredText() {
    return coveredText;
  }
//  public void setCoveredText(String coveredText) {
//    this.coveredText = coveredText;
//  }

  /**
   * Get the trigger ontology source.
   * @return the source
   */
  public String getSource() {
    return source;
  }
//  public void setSource(String source) {
//    this.source = source;
//  }

  /**
   * Get the trigger section name.
   * @return normalized section name
   */
  public String getSectionNormalizedName() {
    return sectionNormalizedName;
  }
//  public void setSectionNormalizedName(String sectionNormalizedName) {
//    this.sectionNormalizedName = sectionNormalizedName;
//  }



}
