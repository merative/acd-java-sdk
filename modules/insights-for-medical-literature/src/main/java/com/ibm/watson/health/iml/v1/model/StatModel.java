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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Object representing a corpus statistic.
 */
public class StatModel extends GenericModel {

  protected String name;
  protected Long count;
  @SerializedName("cumulative_usecs")
  protected Long cumulativeUsecs;
  @SerializedName("minimum_usecs")
  protected Long minimumUsecs;
  @SerializedName("maximum_usecs")
  protected Long maximumUsecs;
  @SerializedName("cumulative_quantity")
  protected Long cumulativeQuantity;
  @SerializedName("quantity_type")
  protected String quantityType;
  @SerializedName("minimum_quantity")
  protected Long minimumQuantity;
  @SerializedName("maximum_quantity")
  protected Long maximumQuantity;

  /**
   * Gets the name.
   *
   * Statistic name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the count.
   *
   * Count value for statistic.
   *
   * @return the count
   */
  public Long getCount() {
    return count;
  }

  /**
   * Gets the cumulativeUsecs.
   *
   * Total nanoseconds value for statistic.
   *
   * @return the cumulativeUsecs
   */
  public Long getCumulativeUsecs() {
    return cumulativeUsecs;
  }

  /**
   * Gets the minimumUsecs.
   *
   * Minimum nanosecond value for statistic.
   *
   * @return the minimumUsecs
   */
  public Long getMinimumUsecs() {
    return minimumUsecs;
  }

  /**
   * Gets the maximumUsecs.
   *
   * Maximum nanoseconds value for statistic.
   *
   * @return the maximumUsecs
   */
  public Long getMaximumUsecs() {
    return maximumUsecs;
  }

  /**
   * Gets the cumulativeQuantity.
   *
   * Total quantity value for statistic.
   *
   * @return the cumulativeQuantity
   */
  public Long getCumulativeQuantity() {
    return cumulativeQuantity;
  }

  /**
   * Gets the quantityType.
   *
   * Quantity type for statistic.
   *
   * @return the quantityType
   */
  public String getQuantityType() {
    return quantityType;
  }

  /**
   * Gets the minimumQuantity.
   *
   * Minimum quantity value for statistic.
   *
   * @return the minimumQuantity
   */
  public Long getMinimumQuantity() {
    return minimumQuantity;
  }

  /**
   * Gets the maximumQuantity.
   *
   * Maximum quantity value for statistic.
   *
   * @return the maximumQuantity
   */
  public Long getMaximumQuantity() {
    return maximumQuantity;
  }
}

