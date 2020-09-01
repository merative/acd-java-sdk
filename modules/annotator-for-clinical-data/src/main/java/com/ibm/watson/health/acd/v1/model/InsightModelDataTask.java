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
 * InsightModelData Task.
 */
public class InsightModelDataTask extends DynamicModel {

  private Type therapeuticScoreType = new TypeToken<Float>() { } .getType();
  private Type diagnosticScoreType = new TypeToken<Float>() { } .getType();
  private Type labTestScoreType = new TypeToken<Float>() { } .getType();
  private Type surgicalTaskScoreType = new TypeToken<Float>() { } .getType();
  private Type clinicalAssessmentScoreType = new TypeToken<Float>() { } .getType();

  /**
   * Gets the therapeuticScore.
   *
   * @return the therapeuticScore
   */
  public Float getTherapeuticScore() {
	  return GsonSerializationHelper.serializeDynamicModelProperty(this.get("therapeuticScore"), therapeuticScoreType);
  }

  /**
   * Gets the diagnosticScore.
   *
   * @return the diagnosticScore
   */
  public Float getDiagnosticScore() {
	  return GsonSerializationHelper.serializeDynamicModelProperty(this.get("diagnosticScore"), diagnosticScoreType);
  }

  /**
   * Gets the labTestScore.
   *
   * @return the labTestScore
   */
  public Float getLabTestScore() {
	  return GsonSerializationHelper.serializeDynamicModelProperty(this.get("labTestScore"), labTestScoreType);
  }

  /**
   * Gets the surgicalTaskScore.
   *
   * @return the surgicalTaskScore
   */
  public Float getSurgicalTaskScore() {
	  return GsonSerializationHelper.serializeDynamicModelProperty(this.get("surgicalTaskScore"), surgicalTaskScoreType);
  }

  /**
   * Gets the clinicalAssessmentScore.
   *
   * @return the clinicalAssessmentScore
   */
  public Float getClinicalAssessmentScore() {
	  return GsonSerializationHelper.serializeDynamicModelProperty(this.get("clinicalAssessmentScore"), clinicalAssessmentScoreType);
  }

//  /**
//   * Sets the therapeuticScore.
//   *
//   * @param therapeuticScore the new therapeuticScore
//   */
//  public void setTherapeuticScore(final Float therapeuticScore) {
//    this.put("therapeuticScore", therapeuticScore);
//  }
//
//  /**
//   * Sets the diagnosticScore.
//   *
//   * @param diagnosticScore the new diagnosticScore
//   */
//  public void setDiagnosticScore(final Float diagnosticScore) {
//    this.put("diagnosticScore", diagnosticScore);
//  }
//
//  /**
//   * Sets the labTestScore.
//   *
//   * @param labTestScore the new labTestScore
//   */
//  public void setLabTestScore(final Float labTestScore) {
//    this.put("labTestScore", labTestScore);
//  }
//
//  /**
//   * Sets the surgicalTaskScore.
//   *
//   * @param surgicalTaskScore the new surgicalTaskScore
//   */
//  public void setSurgicalTaskScore(final Float surgicalTaskScore) {
//    this.put("surgicalTaskScore", surgicalTaskScore);
//  }
//
//  /**
//   * Sets the clinicalAssessmentScore.
//   *
//   * @param clinicalAssessmentScore the new clinicalAssessmentScore
//   */
//  public void setClinicalAssessmentScore(final Float clinicalAssessmentScore) {
//    this.put("clinicalAssessmentScore", clinicalAssessmentScore);
//  }

}
