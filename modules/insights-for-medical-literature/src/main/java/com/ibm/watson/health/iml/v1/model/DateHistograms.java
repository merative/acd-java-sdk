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
 * DateHistograms.
 */
public class DateHistograms extends GenericModel {

  private String interval;
  private Long utc;

  public DateHistograms() {

  }
  /**
   * Gets the interval.
   *
   * @return the interval
   */
  public String getInterval() {
    return interval;
  }

  /**
   * Gets the interval.
   *
   * @param timespan the interval
   */
  public void setInterval(String timespan) {
    interval = timespan;
  }

  /**
   * Gets the utc offset.
   *
   * @return the utc
   */
  public Long getUtc() {
    return utc;
  }

  /**
   * Sets the utc offset for timezone.
   *
   * @param timezoneOffset the utc
   */
  public void setUtc(long timezoneOffset) {
    utc = timezoneOffset;
  }
}

