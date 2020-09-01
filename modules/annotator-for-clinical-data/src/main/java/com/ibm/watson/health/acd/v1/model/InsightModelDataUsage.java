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
 * InsightModelData Usage.
 */
public class InsightModelDataUsage extends DynamicModel {

  private Type takenScoreType = new TypeToken<Float>() { } .getType();
  private Type explicitScoreType = new TypeToken<Float>() { } .getType();
  private Type implicitScoreType = new TypeToken<Float>() { } .getType();
  private Type consideringScoreType = new TypeToken<Float>() { } .getType();
  private Type patientReportedScoreType = new TypeToken<Float>() { } .getType();
  private Type discussedScoreType = new TypeToken<Float>() { } .getType();
  private Type labMeasurementScoreType = new TypeToken<Float>() { } .getType();
  private Type pendingScoreType = new TypeToken<Float>() { } .getType();

  /**
   * Gets the takenScore.
   *
   * @return the takenScore
   */
  public Float getTakenScore() {
	  return GsonSerializationHelper.serializeDynamicModelProperty(this.get("takenScore"), takenScoreType);
  }

  /**
   * Gets the explicitScore.
   *
   * @return the explicitScore
   */
  public Float getExplicitScore() {
	  return GsonSerializationHelper.serializeDynamicModelProperty(this.get("explicitScore"), explicitScoreType);
  }

  /**
   * Gets the implicitScore.
   *
   * @return the implicitScore
   */
  public Float getImplicitScore() {
	  return GsonSerializationHelper.serializeDynamicModelProperty(this.get("implicitScore"), implicitScoreType);
  }

  /**
   * Gets the consideringScore.
   *
   * @return the consideringScore
   */
  public Float getConsideringScore() {
	  return GsonSerializationHelper.serializeDynamicModelProperty(this.get("consideringScore"), consideringScoreType);
  }

  /**
   * Gets the patientReportedScore.
   *
   * @return the patientReportedScore
   */
  public Float getPatientReportedScore() {
	  return GsonSerializationHelper.serializeDynamicModelProperty(this.get("patientReportedScore"), patientReportedScoreType);
  }

  /**
   * Gets the discussedScore.
   *
   * @return the discussedScore
   */
  public Float getDiscussedScore() {
	  return GsonSerializationHelper.serializeDynamicModelProperty(this.get("discussedScore"), discussedScoreType);
  }

  /**
   * Gets the labMeasurementScore.
   *
   * @return the labMeasurementScore
   */
  public Float getLabMeasurementScore() {
	  return GsonSerializationHelper.serializeDynamicModelProperty(this.get("labMeasurementScore"), labMeasurementScoreType);
  }

  /**
   * Gets the pendingScore.
   *
   * @return the pendingScore
   */
  public Float getPendingScore() {
	  return GsonSerializationHelper.serializeDynamicModelProperty(this.get("pendingScore"), pendingScoreType);
  }

//  /**
//   * Sets the takenScore.
//   *
//   * @param takenScore the new takenScore
//   */
//  public void setTakenScore(final Float takenScore) {
//    this.put("takenScore", takenScore);
//  }
//
//  /**
//   * Sets the explicitScore.
//   *
//   * @param explicitScore the new explicitScore
//   */
//  public void setExplicitScore(final Float explicitScore) {
//    this.put("explicitScore", explicitScore);
//  }
//
//  /**
//   * Sets the implicitScore.
//   *
//   * @param implicitScore the new implicitScore
//   */
//  public void setImplicitScore(final Float implicitScore) {
//    this.put("implicitScore", implicitScore);
//  }
//
//  /**
//   * Sets the consideringScore.
//   *
//   * @param consideringScore the new consideringScore
//   */
//  public void setConsideringScore(final Float consideringScore) {
//    this.put("consideringScore", consideringScore);
//  }
//
//  /**
//   * Sets the patientReportedScore.
//   *
//   * @param patientReportedScore the new patientReportedScore
//   */
//  public void setPatientReportedScore(final Float patientReportedScore) {
//    this.put("patientReportedScore", patientReportedScore);
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
//
//  /**
//   * Sets the labMeasurementScore.
//   *
//   * @param labMeasurementScore the new labMeasurementScore
//   */
//  public void setLabMeasurementScore(final Float labMeasurementScore) {
//    this.put("labMeasurementScore", labMeasurementScore);
//  }
//
//  /**
//   * Sets the pendingScore.
//   *
//   * @param pendingScore the new pendingScore
//   */
//  public void setPendingScore(final Float pendingScore) {
//    this.put("pendingScore", pendingScore);
//  }

}
