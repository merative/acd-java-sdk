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
 * InsightModelData.
 */
public class InsightModelData extends DynamicModel {

  private Type medicationType = new TypeToken<InsightModelDataMedication>() { } .getType();
  private Type procedureType = new TypeToken<InsightModelDataProcedure>() { } .getType();
  private Type diagnosisType = new TypeToken<InsightModelDataDiagnosis>() { } .getType();
  private Type normalityType = new TypeToken<InsightModelDataNormality>() { } .getType();

  /**
   * Gets the medication.
   *
   * @return the medication
   */
  public InsightModelDataMedication getMedication() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("medication"), medicationType);
  }

  /**
   * Gets the procedure.
   *
   * @return the procedure
   */
  public InsightModelDataProcedure getProcedure() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("procedure"), procedureType);
  }

  /**
   * Gets the diagnosis.
   *
   * @return the diagnosis
   */
  public InsightModelDataDiagnosis getDiagnosis() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("diagnosis"), diagnosisType);
  }

  /**
   * Gets the normality.
   *
   * @return the normality
   */
  public InsightModelDataNormality getNormality() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("normality"), normalityType);
  }

  /**
   * Sets the medication.
   *
   * @param medication the new medication
   */
  public void setMedication(final InsightModelDataMedication medication) {
    this.put("medication", medication);
  }

  /**
   * Sets the procedure.
   *
   * @param procedure the new procedure
   */
  public void setProcedure(final InsightModelDataProcedure procedure) {
    this.put("procedure", procedure);
  }

  /**
   * Sets the diagnosis.
   *
   * @param diagnosis the new diagnosis
   */
  public void setDiagnosis(final InsightModelDataDiagnosis diagnosis) {
    this.put("diagnosis", diagnosis);
  }

  /**
   * Sets the normality.
   *
   * @param normality the new normality
   */
  public void setNormality(final InsightModelDataNormality normality) {
    this.put("normality", normality);
  }

}
