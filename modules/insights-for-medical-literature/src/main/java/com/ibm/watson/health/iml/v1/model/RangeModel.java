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
package com.ibm.watson.health.iml.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Object representing an attribute value range.
 */
public class RangeModel extends GenericModel {

  protected String operator;
  protected String min;
  protected String max;
  protected Long count;

  /**
   * Gets the operator.
   *
   * Operator assigned to attribute value.
   *
   * @return the operator
   */
  public String getOperator() {
    return operator;
  }

  /**
   * Gets the min.
   *
   * Minimum value assigned to attribute value.
   *
   * @return the min
   */
  public String getMin() {
    return min;
  }

  /**
   * Gets the max.
   *
   * Maximum value assigned to attribute value.
   *
   * @return the max
   */
  public String getMax() {
    return max;
  }

  /**
   * Gets the count.
   *
   * Corpus frequency for attribute value.
   *
   * @return the count
   */
  public Long getCount() {
    return count;
  }
}

