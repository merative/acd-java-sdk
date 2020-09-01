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
 * InsightModelData Procedure.
 */
public class InsightModelDataProcedure extends DynamicModel {

  private Type usageType = new TypeToken<InsightModelDataUsage>() { } .getType();
  private Type taskType = new TypeToken<InsightModelDataTask>() { } .getType();
  private Type typeType = new TypeToken<InsightModelDataType>() { } .getType();
  private Type modifiersType = new TypeToken<InsightModelDataProcedureModifier>() { } .getType();

  /**
   * Gets the usage.
   *
   * @return the usage
   */
  public InsightModelDataUsage getUsage() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("usage"), usageType);
  }

  /**
   * Gets the task.
   *
   * @return the task
   */
  public InsightModelDataTask getTask() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("task"), taskType);
  }

  /**
   * Gets the type.
   *
   * @return the type
   */
  public InsightModelDataType getType() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("type"), typeType);
  }

  /**
   * Gets the modifiers.
   *
   * @return the modifiers
   */
  public InsightModelDataProcedureModifier getModifiers() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("modifiers"), modifiersType);
  }

//  /**
//   * Sets the usage.
//   *
//   * @param usage the new usage
//   */
//  public void setUsage(final InsightModelDataUsage usage) {
//    this.put("usage", usage);
//  }
//
//  /**
//   * Sets the task.
//   *
//   * @param task the new task
//   */
//  public void setTask(final InsightModelDataTask task) {
//    this.put("task", task);
//  }
//
//  /**
//   * Sets the type.
//   *
//   * @param type the new type
//   */
//  public void setType(final InsightModelDataType type) {
//    this.put("type", type);
//  }
//
//   /**
//   * Sets the modifiers.
//   *
//   * @param modifiers the new modifiers
//   */
//   public void setModifiers(final InsightModelDataProcedureModifier modifiers) {
//    this.put("modifiers", modifiers);
//   }

}
