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
 * InsightModelData Event.
 */
public class InsightModelDataEvent extends DynamicModel {

  private Type scoreType = new TypeToken<Float>() { } .getType();
  private Type allergyScoreType = new TypeToken<Float>() { } .getType();
  private Type usageType = new TypeToken<InsightModelDataUsage>() { } .getType();

  /**
   * Gets the score.
   *
   * @return the score
   */
  public Float getScore() {
	  return GsonSerializationHelper.serializeDynamicModelProperty(this.get("score"), scoreType);
  }

  /**
   * Gets the allergy score.
   *
   * @return the allergy score
   */
  public Float getAllergyScore() {
	  return GsonSerializationHelper.serializeDynamicModelProperty(this.get("allergyScore"), allergyScoreType);
  }

  /**
   * Gets the usage.
   *
   * @return the usage
   */
  public InsightModelDataUsage getUsage() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("usage"), usageType);
  }

//  /**
//   * Sets the score.
//   *
//   * @param score the new score
//   */
//  public void setScore(final Float score) {
//    this.put("score", score);
//  }
//
//  /**
//   * Sets the allergy score.
//   *
//   * @param allergyScore the new allergy score
//   */
//  public void setAllergyScore(final Float allergyScore) {
//    this.put("allergyScore", allergyScore);
//  }
//
//  /**
//   * Sets the usage.
//   *
//   * @param usage the new usage
//   */
//  public void setUsage(final InsightModelDataUsage usage) {
//    this.put("usage", usage);
//  }

}
