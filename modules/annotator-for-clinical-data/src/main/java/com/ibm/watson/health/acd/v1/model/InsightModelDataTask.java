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
 * InsightModelData Task.
 */
public class InsightModelDataTask extends DynamicModel<Object> {

  @SerializedName("therapeuticScore")
  protected Float therapeuticScore;
  @SerializedName("diagnosticScore")
  protected Float diagnosticScore;
  @SerializedName("labTestScore")
  protected Float labTestScore;
  @SerializedName("surgicalTaskScore")
  protected Float surgicalTaskScore;
  @SerializedName("clinicalAssessmentScore")
  protected Float clinicalAssessmentScore;

  public InsightModelDataTask() {
	  super(new TypeToken<Object>() { });
  }

  /**
   * Gets the therapeuticScore.
   *
   * @return the therapeuticScore
   */
  public Float getTherapeuticScore() {
	  return this.therapeuticScore;
  }

  /**
   * Gets the diagnosticScore.
   *
   * @return the diagnosticScore
   */
  public Float getDiagnosticScore() {
	  return this.diagnosticScore;
  }

  /**
   * Gets the labTestScore.
   *
   * @return the labTestScore
   */
  public Float getLabTestScore() {
	  return this.labTestScore;
  }

  /**
   * Gets the surgicalTaskScore.
   *
   * @return the surgicalTaskScore
   */
  public Float getSurgicalTaskScore() {
	  return this.surgicalTaskScore;
  }

  /**
   * Gets the clinicalAssessmentScore.
   *
   * @return the clinicalAssessmentScore
   */
  public Float getClinicalAssessmentScore() {
	  return this.clinicalAssessmentScore;
  }

}
