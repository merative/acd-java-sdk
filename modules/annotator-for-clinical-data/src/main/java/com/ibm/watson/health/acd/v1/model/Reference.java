/*
 * Copyright 2021, 2022 IBM Corp. All Rights Reserved.
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

import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.ibm.cloud.sdk.core.service.model.DynamicModel;

public class Reference extends DynamicModel<Object> {

  @SerializedName("uid")
  protected Long uid;
  @SerializedName("selectionLabel")
  protected String selectionLabel;
  @SerializedName("valueIndex")
  protected Integer valueIndex;

  public Reference() {
	  super(new TypeToken<Object>() { });
  }

  /**
   * Gets the uid.
   *
   * @return the uid
   */
  public Long getUid() {
    return this.uid;
  }

  /**
   * Gets the selectionLabel.
   * @return the selectionLabel
   */
  public String getSelectionLabel() {
    return this.selectionLabel;
  }

  /**
   * Gets the valueIndex.
   * @return the valueIndex
   */
  public Integer getValueIndex() {
    return this.valueIndex;
  }

  /**
   * Sets the uid.
   *
   * @param uid the new uid
   */
  public void setUid(final Long uid) {
    this.uid = uid;
  }

  /**
   * Sets the selectionLabel.
   *
   * @param selectionLabel the new selectionLabel
   */
  public void setSelectionLabel(final String selectionLabel) {
    this.selectionLabel = selectionLabel;
  }

  /**
   * Sets the valueIndex.
   *
   * @param valueIndex the new valueIndex
   */
  public void setValueIndex(final Integer valueIndex) {
    this.valueIndex = valueIndex;
  }

}
