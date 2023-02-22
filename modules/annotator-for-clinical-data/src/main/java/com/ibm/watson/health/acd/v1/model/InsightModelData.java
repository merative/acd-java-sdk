/* ***************************************************************** */
/*                                                                   */
/* (C) Copyright Merative US L.P. and others 2018, 2023              */
/*                                                                   */
/* SPDX-License-Identifier: Apache-2.0                               */
/*                                                                   */
/* ***************************************************************** */

package com.ibm.watson.health.acd.v1.model;

import java.lang.reflect.Field;

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

  /**
   * Returns the value from InsightModelData annotation by specified key.
   *
   * @param key the name of the field to get
   */
  @Override
  public Object get(String key) {
	  Object value = super.get(key);
	  if (value == null) {
		  try {
			  Field field = InsightModelData.class.getDeclaredField(key);
			  value = field.get(this);
		  } catch (NoSuchFieldException e) {
			  return null;
		  } catch (Exception e1) {
			  e1.printStackTrace();
		  }
	  }
	  return value;
  }

}
