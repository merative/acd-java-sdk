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
 * InsightModelData Substance Abuse.
 */
public class InsightModelSubstanceAbuse extends DynamicModel {

  private Type treatmentScoreType = new TypeToken<Float>() { } .getType();
  private Type nonPatientScoreType = new TypeToken<Float>() { } .getType();
  private Type treatmentType = new TypeToken<InsightModelSubstanceAbuseTreatment>() { } .getType();

    /**
     * Gets the treatmentScore.
     *
     * @return the treatmentScore
     */
    public Float getTreatmentScore() {
  	  return GsonSerializationHelper.serializeDynamicModelProperty(this.get("treatmentScore"), treatmentScoreType);
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
     * Gets the treatment.
     *
     * @return the treatment
     */
    public InsightModelSubstanceAbuseTreatment getTreatment() {
  	  return GsonSerializationHelper.serializeDynamicModelProperty(this.get("treatment"), treatmentType);
    }

//  /**
//   * Sets the treatmentScore.
//   *
//   * @param treatmentScore the new treatmentScore
//   */
//  public void setTreatmentScore(final Float treatmentScore) {
//    this.put("treatmentScore", treatmentScore);
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
//
//  /**
//   * Sets the treatment.
//   *
//   * @param treatment the new treatment
//   */
//  public void setTreatment(final InsightModelDataTreatment treatment) {
//    this.put("treatment", treatment);
//  }
}
