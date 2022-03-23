/*
 * Copyright 2018, 2022 IBM Corp. All Rights Reserved.
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

import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.ibm.cloud.sdk.core.service.model.DynamicModel;

/**
 * InsightModelData Usage.
 */
public class InsightModelDataUsage extends DynamicModel<Object> {

  @SerializedName("takenScore")
  protected Float takenScore;
  @SerializedName("explicitScore")
  protected Float explicitScore;
  @SerializedName("implicitScore")
  protected Float implicitScore;
  @SerializedName("consideringScore")
  protected Float consideringScore;
  @SerializedName("patientReportedScore")
  protected Float patientReportedScore;
  @SerializedName("discussedScore")
  protected Float discussedScore;
  @SerializedName("labMeasurementScore")
  protected Float labMeasurementScore;
  @SerializedName("pendingScore")
  protected Float pendingScore;

  public InsightModelDataUsage() {
	  super(new TypeToken<Object>() { });
  }

  /**
   * Gets the takenScore.
   *
   * @return the takenScore
   */
  public Float getTakenScore() {
	  return this.takenScore;
  }

  /**
   * Gets the explicitScore.
   *
   * @return the explicitScore
   */
  public Float getExplicitScore() {
	  return this.explicitScore;
  }

  /**
   * Gets the implicitScore.
   *
   * @return the implicitScore
   */
  public Float getImplicitScore() {
	  return this.implicitScore;
  }

  /**
   * Gets the consideringScore.
   *
   * @return the consideringScore
   */
  public Float getConsideringScore() {
	  return this.consideringScore;
  }

  /**
   * Gets the patientReportedScore.
   *
   * @return the patientReportedScore
   */
  public Float getPatientReportedScore() {
	  return this.patientReportedScore;
  }

  /**
   * Gets the discussedScore.
   *
   * @return the discussedScore
   */
  public Float getDiscussedScore() {
	  return this.discussedScore;
  }

  /**
   * Gets the labMeasurementScore.
   *
   * @return the labMeasurementScore
   */
  public Float getLabMeasurementScore() {
	  return this.labMeasurementScore;
  }

  /**
   * Gets the pendingScore.
   *
   * @return the pendingScore
   */
  public Float getPendingScore() {
	  return this.pendingScore;
  }

}
