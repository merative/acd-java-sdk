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
import java.util.List;

import com.google.gson.reflect.TypeToken;
import com.ibm.watson.developer_cloud.service.model.DynamicModel;
import com.ibm.watson.developer_cloud.util.GsonSerializationHelper;

/**
 * InsightModelData Normality.
 */
public class InsightModelDataNormality extends DynamicModel {

  private Type usageType = new TypeToken<InsightModelDataNormalityUsage>() { } .getType();
  private Type evidenceType = new TypeToken<List<InsightModelDataEvidence>>() { } .getType();
  private Type directlyAffectedScoreType  = new TypeToken<Float>() { } .getType();

  /**
   * Gets the usage.
   *
   * @return the usage
   */
  public InsightModelDataNormalityUsage getUsage() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("usage"), usageType);
  }

  /**
   * Gets the evidence.
   *
   * @return the evidence
   */
  public List<InsightModelDataEvidence> getEvidence() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("evidence"), evidenceType);
  }

  /**
   * Gets the directlyAffectedScore.
   *
   * @return the directlyAffectedScore
   */
  public Float getDirectlyAffectedScore() {
	  return GsonSerializationHelper.serializeDynamicModelProperty(this.get("directlyAffectedScore"), directlyAffectedScoreType);
  }

//  /**
//   * Sets the usage.
//   *
//   * @param usage the new usage
//   */
//  public void setUsage(final InsightModelDataNormalityUsage usage) {
//    this.put("usage", usage);
//  }
//
//  /**
//   * Sets the evidence.
//   *
//   * @param evidence the new evidence
//   */
//  public void setEvidence(final List<InsightModelDataEvidence> evidence) {
//    this.put("evidence", evidence);
//  }

//  /**
//   * Sets the directlyAffectedScore.
//   *
//   * @param directlyAffectedScore the new directlyAffectedScore
//   */
//   public void setDirectlyAffectedScore(final Float directlyAffectedScore) {
//     this.put("directlyAffectedScore", directlyAffectedScore);
//   }

}
