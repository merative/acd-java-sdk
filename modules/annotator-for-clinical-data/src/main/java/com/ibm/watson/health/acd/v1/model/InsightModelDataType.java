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
 * InsightModelData Type.
 */
public class InsightModelDataType extends DynamicModel {

  private Type deviceScoreType = new TypeToken<Float>() { } .getType();
  private Type materialScoreType = new TypeToken<Float>() { } .getType();
  private Type medicationScoreType = new TypeToken<Float>() { } .getType();
  private Type procedureScoreType = new TypeToken<Float>() { } .getType();
  private Type conditionManagementScoreType = new TypeToken<Float>() { } .getType();

  /**
   * Gets the deviceScore.
   *
   * @return the deviceScore
   */
  public Float getDeviceScore() {
	  return GsonSerializationHelper.serializeDynamicModelProperty(this.get("deviceScore"), deviceScoreType);
  }

  /**
   * Gets the materialScore.
   *
   * @return the materialScore
   */
  public Float getMaterialScore() {
	  return GsonSerializationHelper.serializeDynamicModelProperty(this.get("materialScore"), materialScoreType);
  }

  /**
   * Gets the medicationScore.
   *
   * @return the medicationScore
   */
  public Float getMedicationScore() {
	  return GsonSerializationHelper.serializeDynamicModelProperty(this.get("medicationScore"), medicationScoreType);
  }

  /**
   * Gets the procedureScore.
   *
   * @return the procedureScore
   */
  public Float getProcedureScore() {
	  return GsonSerializationHelper.serializeDynamicModelProperty(this.get("procedureScore"), procedureScoreType);
  }

  /**
   * Gets the conditionManagementScore.
   *
   * @return the conditionManagementScore
   */
  public Float getConditionManagementScore() {
	  return GsonSerializationHelper.serializeDynamicModelProperty(this.get("conditionManagementScore"), conditionManagementScoreType);
  }

  /**
   * Sets the deviceScore.
   *
   * @param deviceScore the new deviceScore
   */
  public void setDeviceScore(final Float deviceScore) {
    this.put("deviceScore", deviceScore);
  }

  /**
   * Sets the materialScore.
   *
   * @param materialScore the new materialScore
   */
  public void setMaterialScore(final Float materialScore) {
    this.put("materialScore", materialScore);
  }

  /**
   * Sets the medicationScore.
   *
   * @param medicationScore the new medicationScore
   */
  public void setMedicationScore(final Float medicationScore) {
    this.put("medicationScore", medicationScore);
  }

  /**
   * Sets the procedureScore.
   *
   * @param procedureScore the new procedureScore
   */
  public void setProcedureScore(final Float procedureScore) {
    this.put("procedureScore", procedureScore);
  }

  /**
   * Sets the conditionManagementScore.
   *
   * @param conditionManagementScore the new conditionManagementScore
   */
  public void setConditionManagementScore(final Float conditionManagementScore) {
    this.put("conditionManagementScore", conditionManagementScore);
  }

}
