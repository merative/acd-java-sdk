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
 * InsightModelData Substance Abuse Treatment.
 */
public class InsightModelSubstanceAbuseTreatment extends DynamicModel {

  private Type discussedScoreType = new TypeToken<Float>() { } .getType();
  private Type complianceScoreType = new TypeToken<Float>() { } .getType();

  /**
   * Gets the discussedScore.
   *
   * @return the discussedScore
   */
  public Float getDiscussedScore() {
	  return GsonSerializationHelper.serializeDynamicModelProperty(this.get("discussedScore"), discussedScoreType);
  }

  /**
   * Gets the complianceScore.
   *
   * @return the complianceScore
   */
  public Float getComplianceScore() {
	  return GsonSerializationHelper.serializeDynamicModelProperty(this.get("complianceScore"), complianceScoreType);
  }

//
//  /**
//   * Sets the discussedScore.
//   *
//   * @param discussedScore the new discussedScore
//   */
//  public void setDiscussedScore(final Float discussedScore) {
//    this.put("discussedScore", discussedScore);
//  }
//
//  /**
//   * Sets the complianceScore.
//   *
//   * @param complianceScore the new complianceScore
//   */
//  public void setComplianceScore(final Float complianceScore) {
//    this.put("complianceScore", complianceScore);
//  }
}
