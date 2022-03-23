/*
 * Copyright 2018, 2022 IBM Corp. All Rights Reserved.
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

/**
 * InsightModelData Procedure.
 */
public class InsightModelDataProcedure extends DynamicModel<Object> {

  @SerializedName("usage")
  protected InsightModelDataUsage usage;
  @SerializedName("task")
  protected InsightModelDataTask task;
  @SerializedName("type")
  protected InsightModelDataType type;
  @SerializedName("modifiers")
  protected InsightModelDataProcedureModifier modifiers;

  public InsightModelDataProcedure() {
	  super(new TypeToken<Object>() { });
  }

  /**
   * Gets the usage.
   *
   * @return the usage
   */
  public InsightModelDataUsage getUsage() {
    return this.usage;
  }

  /**
   * Gets the task.
   *
   * @return the task
   */
  public InsightModelDataTask getTask() {
    return this.task;
  }

  /**
   * Gets the type.
   *
   * @return the type
   */
  public InsightModelDataType getType() {
    return this.type;
  }

  /**
   * Gets the modifiers.
   *
   * @return the modifiers
   */
  public InsightModelDataProcedureModifier getModifiers() {
    return this.modifiers;
  }

}
