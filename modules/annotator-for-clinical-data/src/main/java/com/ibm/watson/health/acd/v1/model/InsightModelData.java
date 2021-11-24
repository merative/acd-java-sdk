/*
 * Copyright 2018, 2021 IBM Corp. All Rights Reserved.
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
  private Type tobaccoType = new TypeToken<InsightModelTobacco>() { } .getType();
  private Type alcoholType = new TypeToken<InsightModelAlcohol>() { } .getType();
  private Type illicitDrugType = new TypeToken<InsightModelIllicitDrug>() { } .getType();
  private Type substanceType = new TypeToken<InsightModelSubstanceAbuse>() { } .getType();

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
   * Gets the tobacco.
   *
   * @return the tobacco
   */
  public InsightModelTobacco getTobacco() {
	  return GsonSerializationHelper.serializeDynamicModelProperty(this.get("tobacco"), tobaccoType);
  }

  /**
   * Gets the alcohol.
   *
   * @return the alcohol
   */
  public InsightModelAlcohol getAlcohol() {
	  return GsonSerializationHelper.serializeDynamicModelProperty(this.get("alcohol"), alcoholType);
  }

  /**
   * Gets the illicitDrug.
   *
   * @return the illicitDrug
   */
  public InsightModelIllicitDrug getIllicitDrug() {
	  return GsonSerializationHelper.serializeDynamicModelProperty(this.get("illicitDrug"), illicitDrugType);
  }

  /**
   * Gets the substance.
   *
   * @return the substance
   */
  public InsightModelSubstanceAbuse getSubstance() {
	  return GsonSerializationHelper.serializeDynamicModelProperty(this.get("substance"), substanceType);
  }

//  /**
//   * Sets the medication.
//   *
//   * @param medication the new medication
//   */
//  public void setMedication(final InsightModelDataMedication medication) {
//    this.put("medication", medication);
//  }
//
//  /**
//   * Sets the procedure.
//   *
//   * @param procedure the new procedure
//   */
//  public void setProcedure(final InsightModelDataProcedure procedure) {
//    this.put("procedure", procedure);
//  }
//
//  /**
//   * Sets the diagnosis.
//   *
//   * @param diagnosis the new diagnosis
//   */
//  public void setDiagnosis(final InsightModelDataDiagnosis diagnosis) {
//    this.put("diagnosis", diagnosis);
//  }
//
//  /**
//   * Sets the normality.
//   *
//   * @param normality the new normality
//   */
//  public void setNormality(final InsightModelDataNormality normality) {
//    this.put("normality", normality);
//  }
//
//  /**
//   * Sets the tobacco.
//   *
//   * @param tobacco the new tobacco
//   */
//  public void setTobacco(final InsightModelTobacco tobacco) {
//    this.put("tobacco", tobacco);
//  }
//
//  /**
//   * Sets the alcohol.
//   *
//   * @param alcohol the new alcohol
//   */
//  public void setAlcohol(final InsightModelAlcohol alcohol) {
//    this.put("alcohol", alcohol);
//  }
//
//  /**
//   * Sets the illicitDrug.
//   *
//   * @param illicitDrug the new illicitDrug
//   */
//  public void setIllicitDrug(final InsightModelIllicitDrug illicitDrug) {
//    this.put("illicitDrug", illicitDrug);
//  }
//
//  /**
//   * Sets the substance.
//   *
//   * @param substance the new substance
//   */
//  public void setSubstance(final InsightModelSubstanceAbuse substance) {
//    this.put("substance", substance);
//  }

}
