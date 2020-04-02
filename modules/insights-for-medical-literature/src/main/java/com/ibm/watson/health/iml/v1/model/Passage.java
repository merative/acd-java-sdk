/*
 * Copyright 2018 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.ibm.watson.health.iml.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Passage.
 */
public class Passage extends GenericModel {

  private String documentSection;
  private StringBuilder text;
  private Long timestamp;

  /**
   * Gets the documentSection.
   *
   * @return the documentSection
   */
  public String getDocumentSection() {
    return documentSection;
  }

  /**
   * Gets the text.
   *
   * @return the text
   */
  public StringBuilder getText() {
    return text;
  }

  /**
   * Gets the timestamp.
   *
   * @return the timestamp
   */
  public Long getTimestamp() {
    return timestamp;
  }
}

