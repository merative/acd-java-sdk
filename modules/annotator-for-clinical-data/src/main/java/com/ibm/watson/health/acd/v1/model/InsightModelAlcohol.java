/*
 * Copyright 2021, 2022 IBM Corp. All Rights Reserved.
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
 * InsightModelData Alcohol.
 */
public class InsightModelAlcohol extends DynamicModel<Object> {

  @SerializedName("usage")
  protected InsightModelAlcoholUsage usage;
  @SerializedName("useStatus")
  protected InsightModelAlcoholUseStatus useStatus;
  @SerializedName("useQualifier")
  protected InsightModelAlcoholUseQualifier useQualifier;
  @SerializedName("exposureScore")
  protected Float exposureScore;
  @SerializedName("nonPatientScore")
  protected Float nonPatientScore;
  @SerializedName("treatmentScore")
  protected Float treatmentScore;

  public InsightModelAlcohol() {
	  super(new TypeToken<Object>() { });
  }

  /**
   * Gets the usage.
   *
   * @return the usage
   */
  public InsightModelAlcoholUsage getUsage() {
    return this.usage;
  }

  /**
   * Gets the useStatus.
   *
   * @return the useStatus
   */
  public InsightModelAlcoholUseStatus getUseStatus() {
    return this.useStatus;
  }

  /**
   * Gets the useQualifier.
   *
   * @return the useQualifier
   */
  public InsightModelAlcoholUseQualifier getUseQualifier() {
	  return this.useQualifier;
  }

  /**
   * Gets the exposureScore.
   *
   * @return the exposureScore
   */
  public Float getExposureScore() {
	  return this.exposureScore;
  }

  /**
   * Gets the nonPatientScore.
   *
   * @return the nonPatientScore
   */
  public Float getNonPatientScore() {
	  return this.nonPatientScore;
  }

  /**
   * Gets the treatmentScore.
   *
   * @return the treatmentScore
   */
  public Float getTreatmentScore() {
	  return this.treatmentScore;
  }

}
