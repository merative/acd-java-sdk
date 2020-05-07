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
 * Range.
 */
public class Range extends GenericModel {

  private String begin;
  private String end;

  /**
   * Gets the begin.
   *
   * @return the begin
   */
  public String getBegin() {
    return begin;
  }

  /**
   * Gets the end.
   *
   * @return the end
   */
  public String getEnd() {
    return end;
  }

  /**
   * Sets the beginning of the range.
   *
   * @param rangeBegin the begin
   */
  public void setBegin(String rangeBegin) {
	  begin = rangeBegin;
  }

  /**
   * Sets the end of the range.
   *
   * @param rangeEnd the end
   */
  public void setEnd(String rangeEnd) {
	  end = rangeEnd;
  }
}

