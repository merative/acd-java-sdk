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
 * InsightModelData Alcohol.
 */
public class InsightModelAlcohol extends DynamicModel {

  private Type usageType = new TypeToken<InsightModelAlcoholUsage>() { } .getType();
  private Type useStatusType = new TypeToken<InsightModelAlcoholUseStatus>() { } .getType();
  private Type useQualifierType = new TypeToken<InsightModelAlcoholUseQualifier>() { } .getType();
  private Type exposureScoreType  = new TypeToken<Float>() { } .getType();
  private Type nonPatientScoreType  = new TypeToken<Float>() { } .getType();
  private Type treatmentScoreType  = new TypeToken<Float>() { } .getType();

  /**
   * Gets the usage.
   *
   * @return the usage
   */
  public InsightModelAlcoholUsage getUsage() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("usage"), usageType);
  }

  /**
   * Gets the useStatus.
   *
   * @return the useStatus
   */
  public InsightModelAlcoholUseStatus getUseStatus() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("useStatus"), useStatusType);
  }

  /**
   * Gets the useQualifier.
   *
   * @return the useQualifier
   */
  public InsightModelAlcoholUseQualifier getUseQualifier() {
	  return GsonSerializationHelper.serializeDynamicModelProperty(this.get("useQualifier"), useQualifierType);
  }

  /**
   * Gets the exposureScore.
   *
   * @return the exposureScore
   */
  public Float getExposureScore() {
	  return GsonSerializationHelper.serializeDynamicModelProperty(this.get("exposureScore"), exposureScoreType);
  }

  /**
   * Gets the nonPatientScore.
   *
   * @return the nonPatientScore
   */
  public Float getNonPatientScore() {
	  return GsonSerializationHelper.serializeDynamicModelProperty(this.get("nonPatientScore"), nonPatientScoreType);
  }

  /**
   * Gets the treatmentScore.
   *
   * @return the treatmentScore
   */
  public Float getTreatmentScore() {
	  return GsonSerializationHelper.serializeDynamicModelProperty(this.get("treatmentScore"), treatmentScoreType);
  }

//  /**
//   * Sets the usage.
//   *
//   * @param usage the new usage
//   */
//  public void setUsage(final InsightModelAlcoholUsage usage) {
//    this.put("usage", usage);
//  }
//
//  /**
//   * Sets the useStatus.
//   *
//   * @param useStatus the new useStatus
//   */
//  public void setUseStatus(final InsightModelAlcoholUseStatus useStatus) {
//    this.put("useStatus", useStatus);
//  }
//
//  /**
//   * Sets the useQualifier.
//   *
//   * @param useQualifier the new useQualifier
//   */
//  public void setUseQualifier(final InsightModelAlcoholUseQualifier useQualifier) {
//    this.put("useQualifier", useQualifier);
//  }
//
//  /**
//   * Sets the exposureScore.
//   *
//   * @param exposureScore the new exposureScore
//   */
//  public void setExposureScore(final Float exposureScore) {
//    this.put("exposureScore", exposureScore);
//  }
//
//  /**
//   * Sets the nonPatientScore.
//   *
//   * @param nonPatientScore the new nonPatientScore
//   */
//  public void setNonPatientScore(final Float nonPatientScore) {
//    this.put("nonPatientScore", nonPatientScore);
//  }

//  /**
//   * Sets the treatmentScore.
//   *
//   * @param treatmentScore the new treatmentScore
//   */
//  public void setTreatmentScore(final Float treatmentScore) {
//    this.put("treatmentScore", treatmentScore);
//  }

}
