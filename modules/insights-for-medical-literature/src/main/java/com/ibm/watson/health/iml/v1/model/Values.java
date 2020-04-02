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
 * Values.
 */
public class Values extends GenericModel {

  private String attributeId;
  private String unit;
  private String scope;

  /**
   * Attribute Value.
   */
  public Values() {

  }

  /**
   * Gets the attributeId.
   *
   * @return the attributeId
   */
  public String getAttributeId() {
    return attributeId;
  }

  /**
   * Gets the unit.
   *
   * @return the unit
   */
  public String getUnit() {
    return unit;
  }

  /**
   * Gets the scope.
   *
   * @return the scope
   */
  public String getScope() {
    return scope;
  }

  /**
   * Sets the attributeId.
   *
   * @param attributeId the new attributeId
   */
  public void setAttributeId(final String attributeId) {
    this.attributeId = attributeId;
  }

  /**
   * Sets the unit.
   *
   * @param unit the new unit
   */
  public void setUnit(final String unit) {
    this.unit = unit;
  }

  /**
   * Sets the scope.
   *
   * @param scope the new scope
   */
  public void setScope(final String scope) {
    this.scope = scope;
  }
}

