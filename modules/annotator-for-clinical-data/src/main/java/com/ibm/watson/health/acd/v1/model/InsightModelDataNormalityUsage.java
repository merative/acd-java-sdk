/*
 * Copyright 2018, 2021 IBM Corp. All Rights Reserved.
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
 * InsightModelData Normality Usage.
 */
public class InsightModelDataNormalityUsage extends DynamicModel {

  private Type normalScoreType = new TypeToken<Float>() { } .getType();
  private Type abnormalScoreType = new TypeToken<Float>() { } .getType();
  private Type unknownScoreType = new TypeToken<Float>() { } .getType();
  private Type nonFindingScoreType = new TypeToken<Float>() { } .getType();

  /**
   * Gets the normalScore.
   *
   * @return the normalScore
   */
  public Float getNormalScore() {
	  return GsonSerializationHelper.serializeDynamicModelProperty(this.get("normalScore"), normalScoreType);
  }

  /**
   * Gets the abnormalScore.
   *
   * @return the abnormalScore
   */
  public Float getAbnormalScore() {
	  return GsonSerializationHelper.serializeDynamicModelProperty(this.get("abnormalScore"), abnormalScoreType);
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
   * Gets the nonFindingScore.
   *
   * @return the nonFindingScore
   */
  public Float getNonFindingScore() {
	  return GsonSerializationHelper.serializeDynamicModelProperty(this.get("nonFindingScore"), nonFindingScoreType);
  }

//  /**
//   * Sets the normalScore.
//   *
//   * @param normalScore the new normalScore
//   */
//  public void setNormalScore(final Float normalScore) {
//    this.put("normalScore", normalScore);
//  }
//
//  /**
//   * Sets the abnormalScore.
//   *
//   * @param abnormalScore the new abnormalScore
//   */
//  public void setAbnormalScore(final Float abnormalScore) {
//    this.put("abnormalScore", abnormalScore);
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
//   * Sets the nonFindingScore.
//   *
//   * @param nonFindingScore the new nonFindingScore
//   */
//  public void setNonFindingScore(final Float nonFindingScore) {
//    this.put("nonFindingScore", nonFindingScore);
//  }

}
