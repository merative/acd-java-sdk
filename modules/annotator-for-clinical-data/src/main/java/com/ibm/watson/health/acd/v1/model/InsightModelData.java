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
 * InsightModelData.
 */
public class InsightModelData extends DynamicModel<Object> {

  @SerializedName("medication")
  protected InsightModelDataMedication medication;
  @SerializedName("procedure")
  protected InsightModelDataProcedure procedure;
  @SerializedName("diagnosis")
  protected InsightModelDataDiagnosis diagnosis;
  @SerializedName("normality")
  protected InsightModelDataNormality normality;
  @SerializedName("tobacco")
  protected InsightModelTobacco tobacco;
  @SerializedName("alcohol")
  protected InsightModelAlcohol alcohol;
  @SerializedName("illicitDrug")
  protected InsightModelIllicitDrug illicitDrug;
  @SerializedName("substance")
  protected InsightModelSubstanceAbuse substance;

  public InsightModelData() {
	  super(new TypeToken<Object>() { });
  }

  /**
   * Gets the medication.
   *
   * @return the medication
   */
  public InsightModelDataMedication getMedication() {
    return this.medication;
  }

  /**
   * Gets the procedure.
   *
   * @return the procedure
   */
  public InsightModelDataProcedure getProcedure() {
    return this.procedure;
  }

  /**
   * Gets the diagnosis.
   *
   * @return the diagnosis
   */
  public InsightModelDataDiagnosis getDiagnosis() {
    return this.diagnosis;
  }

  /**
   * Gets the normality.
   *
   * @return the normality
   */
  public InsightModelDataNormality getNormality() {
    return this.normality;
  }

  /**
   * Gets the tobacco.
   *
   * @return the tobacco
   */
  public InsightModelTobacco getTobacco() {
	  return this.tobacco;
  }

  /**
   * Gets the alcohol.
   *
   * @return the alcohol
   */
  public InsightModelAlcohol getAlcohol() {
	  return this.alcohol;
  }

  /**
   * Gets the illicitDrug.
   *
   * @return the illicitDrug
   */
  public InsightModelIllicitDrug getIllicitDrug() {
	  return this.illicitDrug;
  }

  /**
   * Gets the substance.
   *
   * @return the substance
   */
  public InsightModelSubstanceAbuse getSubstance() {
	  return this.substance;
  }

}
