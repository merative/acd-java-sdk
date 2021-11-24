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
 * InsightModelData Alcohol Use Qualifier.
 */
public class InsightModelAlcoholUseQualifier extends DynamicModel {

  private Type lightScoreType  = new TypeToken<Float>() { } .getType();
  private Type moderateScoreType = new TypeToken<Float>() { } .getType();
  private Type heavyScoreType = new TypeToken<Float>() { } .getType();
  private Type abuseScoreType = new TypeToken<Float>() { } .getType();

  /**
   * Gets the lightScore.
   *
   * @return the lightScore
   */
  public Float getLightScore() {
  	return GsonSerializationHelper.serializeDynamicModelProperty(this.get("lightScore"), lightScoreType);
  }

  /**
   * Gets the moderateScore.
   *
   * @return the moderateScore
   */
  public Float getModerateScore() {
  	return GsonSerializationHelper.serializeDynamicModelProperty(this.get("moderateScore"), moderateScoreType);
  }

  /**
   * Gets the heavyScore.
   *
   * @return the heavyScore
   */
  public Float getHeavyScore() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("heavyScore"), heavyScoreType);
  }

  /**
   * Gets the abuseScore.
   *
   * @return the abuseScore
   */
  public Float getAbuseScore() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("abuseScore"), abuseScoreType);
  }

//  /**
//   * Sets the lightScore.
//   *
//   * @param lightScore the new lightScore
//   */
//  public void setLightScore(final Float lightScore) {
//    this.put("lightScore", lightScore);
//  }
//
//  /**
//   * Sets the moderateScore.
//   *
//   * @param moderateScore the new moderateScore
//   */
//  public void setModerateScore(final Float moderateScore) {
//    this.put("moderateScore", moderateScore);
//  }
//
//  /**
//   * Sets the moderateScore.
//   *
//   * @param moderateScore the new moderateScore
//   */
//  public void setModerateScore(final Float moderateScore) {
//    this.put("moderateScore", moderateScore);
//  }
//
//  /**
//   * Sets the heavyScore.
//   *
//   * @param heavyScore the new heavyScore
//   */
//  public void setHeavyScore(final Float heavyScore) {
//    this.put("heavyScore", heavyScore);
//  }
//
//  /**
//   * Sets the abuseScore.
//   *
//   * @param abuseScore the new abuseScore
//   */
//  public void setAbuseScore(final Float abuseScore) {
//    this.put("abuseScore", abuseScore);
//  }
}
