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
 * InsightModelData Type.
 */
public class InsightModelDataType extends DynamicModel<Object> {

  @SerializedName("deviceScore")
  protected Float deviceScore;
  @SerializedName("materialScore")
  protected Float materialScore;
  @SerializedName("medicationScore")
  protected Float medicationScore;
  @SerializedName("procedureScore")
  protected Float procedureScore;
  @SerializedName("conditionManagementScore")
  protected Float conditionManagementScore;

  public InsightModelDataType() {
	  super(new TypeToken<Object>() { });
  }

  /**
   * Gets the deviceScore.
   *
   * @return the deviceScore
   */
  public Float getDeviceScore() {
	  return this.deviceScore;
  }

  /**
   * Gets the materialScore.
   *
   * @return the materialScore
   */
  public Float getMaterialScore() {
	  return this.materialScore;
  }

  /**
   * Gets the medicationScore.
   *
   * @return the medicationScore
   */
  public Float getMedicationScore() {
	  return this.medicationScore;
  }

  /**
   * Gets the procedureScore.
   *
   * @return the procedureScore
   */
  public Float getProcedureScore() {
	  return this.procedureScore;
  }

  /**
   * Gets the conditionManagementScore.
   *
   * @return the conditionManagementScore
   */
  public Float getConditionManagementScore() {
	  return this.conditionManagementScore;
  }

}
