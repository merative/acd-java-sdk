/*
 * Copyright 2018, 2020 IBM Corp. All Rights Reserved.
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
package com.ibm.watson.health.iml.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * RankedDocConcept.
 */
public class RankedDocConcept extends GenericModel {

  private String preferredName;
  private String cui;
  private Long rank;
  private Long hitCount;

  /**
   * Gets the preferredName.
   *
   * @return the preferredName
   */
  public String getPreferredName() {
    return preferredName;
  }

  /**
   * Gets the cui.
   *
   * @return the cui
   */
  public String getCui() {
    return cui;
  }

  /**
   * Gets the rank.
   *
   * @return the rank
   */
  public Long getRank() {
    return rank;
  }

  /**
   * Gets the hitCount.
   *
   * @return the hitCount
   */
  public Long getHitCount() {
    return hitCount;
  }
}

