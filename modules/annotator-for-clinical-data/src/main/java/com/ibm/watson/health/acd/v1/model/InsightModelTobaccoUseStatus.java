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

/**
 * InsightModelData Tobacco Use Status.
 */
public class InsightModelTobaccoUseStatus extends DynamicModel {

  private Type currentScoreType = new TypeToken<Float>() { } .getType();
  private Type stoppedScoreType = new TypeToken<Float>() { } .getType();
  private Type neverScoreType = new TypeToken<Float>() { } .getType();

  /**
   * Gets the currentScore.
   *
   * @return the currentScore
   */
  public Float getCurrentScore() {
	  return GsonSerializationHelper.serializeDynamicModelProperty(this.get("currentScore"), currentScoreType);
  }

  /**
   * Gets the stoppedScore.
   *
   * @return the stoppedScore
   */
  public Float getStoppedScore() {
	  return GsonSerializationHelper.serializeDynamicModelProperty(this.get("stoppedScore"), stoppedScoreType);
  }

  /**
   * Gets the neverScore.
   *
   * @return the neverScore
   */
  public Float getNeverScore() {
	  return GsonSerializationHelper.serializeDynamicModelProperty(this.get("neverScore"), neverScoreType);
  }

//
//  /**
//   * Sets the currentScore.
//   *
//   * @param currentScore the new currentScore
//   */
//  public void setCurrentScore(final Float currentScore) {
//    this.put("currentScore", currentScore);
//  }
//
//  /**
//   * Sets the stoppedScore.
//   *
//   * @param stoppedScore the new stoppedScore
//   */
//  public void setStoppedScore(final Float stoppedScore) {
//    this.put("stoppedScore", stoppedScore);
//  }
//
//  /**
//   * Sets the neverScore.
//   *
//   * @param neverScore the new neverScore
//   */
//  public void setNeverScore(final Float neverScore) {
//    this.put("neverScore", neverScore);
//  }

}
