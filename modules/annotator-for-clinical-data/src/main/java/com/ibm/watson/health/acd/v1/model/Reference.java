/*
 * Copyright 2021 IBM Corp. All Rights Reserved.
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

import java.lang.reflect.Type;

import com.google.gson.reflect.TypeToken;
import com.ibm.watson.developer_cloud.service.model.DynamicModel;
import com.ibm.watson.developer_cloud.util.GsonSerializationHelper;

public class Reference extends DynamicModel {

  private Type uidType = new TypeToken<Long>() { } .getType();
  private Type selectionLabelType = new TypeToken<String>() { } .getType();
  private Type valueIndexType = new TypeToken<Integer>() { } .getType();

  /**
   * Gets the uid.
   *
   * @return the uid
   */
  public Long getUid() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("uid"), uidType);
  }

  /**
   * Gets the selectionLabel.
   * @return the selectionLabel
   */
  public String getSelectionLabel() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("selectionLabel"), selectionLabelType);
  }

  /**
   * Gets the valueIndex.
   * @return the valueIndex
   */
  public Integer getValueIndex() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("valueIndex"), valueIndexType);
  }

  /**
   * Sets the uid.
   *
   * @param uid the new uid
   */
  public void setUid(final Long uid) {
    this.put("uid", uid);
  }

  /**
   * Sets the selectionLabel.
   *
   * @param selectionLabel the new selectionLabel
   */
  public void setSelectionLabel(final String selectionLabel) {
    this.put("selectionLabel", selectionLabel);
  }

  /**
   * Sets the valueIndex.
   *
   * @param valueIndex the new valueIndex
   */
  public void setValueIndex(final Integer valueIndex) {
    this.put("valueIndex", valueIndex);
  }

}
