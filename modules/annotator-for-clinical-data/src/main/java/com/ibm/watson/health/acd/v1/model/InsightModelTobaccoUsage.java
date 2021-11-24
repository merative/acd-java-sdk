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
 * InsightModelData Tobacco Usage.
 */
public class InsightModelTobaccoUsage extends DynamicModel {

  private Type useScoreType = new TypeToken<Float>() { } .getType();
  private Type noneScoreType = new TypeToken<Float>() { } .getType();
  private Type unknownScoreType = new TypeToken<Float>() { } .getType();
  private Type discussedScoreType = new TypeToken<Float>() { } .getType();

  /**
   * Gets the useScore.
   *
   * @return the useScore
   */
  public Float getUseScore() {
	  return GsonSerializationHelper.serializeDynamicModelProperty(this.get("useScore"), useScoreType);
  }

  /**
   * Gets the noneScore.
   *
   * @return the noneScore
   */
  public Float getNoneScore() {
	  return GsonSerializationHelper.serializeDynamicModelProperty(this.get("noneScore"), noneScoreType);
  }

  /**
   * Gets the unknownScore.
   *
   * @return the unknownScore
   */
  public Float getUnknownScore() {
	  return GsonSerializationHelper.serializeDynamicModelProperty(this.get("unknownScore"), unknownScoreType);
  }

  /**
   * Gets the discussedScore.
   *
   * @return the discussedScore
   */
  public Float getDiscussedScore() {
	  return GsonSerializationHelper.serializeDynamicModelProperty(this.get("discussedScore"), discussedScoreType);
  }

//  /**
//   * Sets the useScore.
//   *
//   * @param useScore the new useScore
//   */
//  public void setUseScore(final Float useScore) {
//    this.put("useScore", useScore);
//  }
//
//  /**
//   * Sets the noneScore.
//   *
//   * @param noneScore the new noneScore
//   */
//  public void setNoneScore(final Float noneScore) {
//    this.put("noneScore", noneScore);
//  }
//
//  /**
//   * Sets the unknownScore.
//   *
//   * @param unknownScore the new unknownScore
//   */
//  public void setUnknownScore(final Float unknownScore) {
//    this.put("unknownScore", unknownScore);
//  }
//
//  /**
//   * Sets the discussedScore.
//   *
//   * @param discussedScore the new discussedScore
//   */
//  public void setDiscussedScore(final Float discussedScore) {
//    this.put("discussedScore", discussedScore);
//  }

}
