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
 * InsightModelData Diagnosis.
 */
public class InsightModelDataDiagnosis extends DynamicModel {

  private Type usageType = new TypeToken<InsightModelDataUsage>() { } .getType();
  private Type suspectedScoreType = new TypeToken<Float>() { } .getType();
  private Type symptomScoreType = new TypeToken<Float>() { } .getType();
  private Type traumaScoreType = new TypeToken<Float>() { } .getType();
  private Type familyHistoryScoreType = new TypeToken<Float>() { } .getType();
  private Type modifiersType = new TypeToken<InsightModelDataDiagnosisModifier>() { } .getType();

  /**
   * Gets the usage.
   *
   * @return the usage
   */
  public InsightModelDataUsage getUsage() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("usage"), usageType);
  }

  /**
   * Gets the suspectedScore.
   *
   * @return the suspectedScore
   */
  public Float getSuspectedScore() {
	  return GsonSerializationHelper.serializeDynamicModelProperty(this.get("suspectedScore"), suspectedScoreType);
  }

  /**
   * Gets the symptomScore.
   *
   * @return the symptomScore
   */
  public Float getSymptomScore() {
	  return GsonSerializationHelper.serializeDynamicModelProperty(this.get("symptomScore"), symptomScoreType);
  }

  /**
   * Gets the traumaScore.
   *
   * @return the traumaScore
   */
  public Float getTraumaScore() {
	  return GsonSerializationHelper.serializeDynamicModelProperty(this.get("traumaScore"), traumaScoreType);
  }

  /**
   * Gets the familyHistoryScore.
   *
   * @return the familyHistoryScore
   */
  public Float getFamilyHistoryScore() {
	  return GsonSerializationHelper.serializeDynamicModelProperty(this.get("familyHistoryScore"), familyHistoryScoreType);
  }

  /**
   * Gets the modifiers.
   *
   * @return the modifiers
   */
  public InsightModelDataDiagnosisModifier getModifiers() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("modifiers"), modifiersType);
  }

//  /**
//   * Sets the usage.
//   *
//   * @param usage the new usage
//   */
//  public void setUsage(final InsightModelDataUsage usage) {
//    this.put("usage", usage);
//  }
//
//  /**
//   * Sets the suspectedScore.
//   *
//   * @param suspectedScore the new suspectedScore
//   */
//  public void setSuspectedScore(final Float suspectedScore) {
//    this.put("suspectedScore", suspectedScore);
//  }
//
//  /**
//   * Sets the symptomScore.
//   *
//   * @param symptomScore the new symptomScore
//   */
//  public void setSymptomScore(final Float symptomScore) {
//    this.put("symptomScore", symptomScore);
//  }
//
//  /**
//   * Sets the traumaScore.
//   *
//   * @param traumaScore the new traumaScore
//   */
//  public void setTraumaScore(final Float traumaScore) {
//    this.put("traumaScore", traumaScore);
//  }
//
//  /**
//   * Sets the familyHistoryScore.
//   *
//   * @param familyHistoryScore the new familyHistoryScore
//   */
//  public void setFamilyHistoryScore(final Float familyHistoryScore) {
//    this.put("familyHistoryScore", familyHistoryScore);
//  }

//  /**
//   * Sets the modifiers.
//   *
//   * @param modifiers the new modifiers
//   */
//   public void setModifiers(final InsightModelDataDiagnosisModifier modifiers) {
//     this.put("modifiers", modifiers);
//   }

}
