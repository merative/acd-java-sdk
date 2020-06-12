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

import java.lang.reflect.Type;

import com.google.gson.reflect.TypeToken;
import com.ibm.watson.developer_cloud.service.model.DynamicModel;
import com.ibm.watson.developer_cloud.util.GsonSerializationHelper;

/**
 * InsightModelData Medication.
 */
public class InsightModelDataMedication extends DynamicModel {

  private Type usageType = new TypeToken<InsightModelDataUsage>() { } .getType();
  private Type startedType = new TypeToken<InsightModelDataEvent>() { } .getType();
  private Type stoppedType = new TypeToken<InsightModelDataEvent>() { } .getType();
  private Type doseChangedType = new TypeToken<InsightModelDataEvent>() { } .getType();
  private Type adverseType = new TypeToken<InsightModelDataEvent>() { } .getType();

  /**
   * Gets the usage.
   *
   * @return the usage
   */
  public InsightModelDataUsage getUsage() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("usage"), usageType);
  }

  /**
   * Gets the started.
   *
   * @return the started
   */
  public InsightModelDataEvent getStarted() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("startedEvent"), startedType);
  }

  /**
   * Gets the stopped.
   *
   * @return the stopped
   */
  public InsightModelDataEvent getStopped() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("stoppedEvent"), stoppedType);
  }

  /**
   * Gets the doseChanged.
   *
   * @return the doseChanged
   */
  public InsightModelDataEvent getDoseChanged() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("doseChangedEvent"), doseChangedType);
  }

  /**
   * Gets the adverse.
   *
   * @return the adverse
   */
  public InsightModelDataEvent getAdverse() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("adverseEvent"), adverseType);
  }

  /**
   * Sets the usage.
   *
   * @param usage the new usage
   */
  public void setUsage(final InsightModelDataUsage usage) {
    this.put("usage", usage);
  }

  /**
   * Sets the started.
   *
   * @param started the new started
   */
  public void setStarted(final InsightModelDataEvent started) {
    this.put("startedEvent", started);
  }

  /**
   * Sets the stopped.
   *
   * @param stopped the new stopped
   */
  public void setStopped(final InsightModelDataEvent stopped) {
    this.put("stoppedEvent", stopped);
  }

  /**
   * Sets the doseChanged.
   *
   * @param doseChanged the new doseChanged
   */
  public void setDoseChanged(final InsightModelDataEvent doseChanged) {
    this.put("doseChangedEvent", doseChanged);
  }

  /**
   * Sets the adverse.
   *
   * @param adverse the new adverse
   */
  public void setAdverse(final InsightModelDataEvent adverse) {
    this.put("adverseEvent", adverse);
  }

}
