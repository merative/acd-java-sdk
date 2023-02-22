/* ***************************************************************** */
/*                                                                   */
/* Merative Confidential                                             */
/*                                                                   */
/* (C) Copyright Merative US L.P. 2018, 2023                         */
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
 * InsightModelData Illicit Drug.
 */
public class InsightModelIllicitDrug extends DynamicModel<Object> {

  @SerializedName("usage")
  protected InsightModelIllicitDrugUsage usage;
  @SerializedName("useStatus")
  protected InsightModelIllicitDrugUseStatus useStatus;
  @SerializedName("useQualifier")
  protected InsightModelIllicitDrugUseQualifier useQualifier;
  @SerializedName("useDimension")
  protected InsightModelIllicitDrugUseDimension useDimension;
  @SerializedName("exposureScore")
  protected Float exposureScore;
  @SerializedName("nonPatientScore")
  protected Float nonPatientScore;
  @SerializedName("treatmentScore")
  protected Float treatmentScore;

  public InsightModelIllicitDrug() {
	  super(new TypeToken<Object>() { });
  }

  /**
   * Gets the usage.
   *
   * @return the usage
   */
  public InsightModelIllicitDrugUsage getUsage() {
    return this.usage;
  }

  /**
   * Gets the useStatus.
   *
   * @return the useStatus
   */
  public InsightModelIllicitDrugUseStatus getUseStatus() {
    return this.useStatus;
  }

  /**
   * Gets the useQualifier.
   *
   * @return the useQualifier
   */
  public InsightModelIllicitDrugUseQualifier getUseQualifier() {
	  return this.useQualifier;
  }

  /**
   * Gets the useDimension.
   *
   * @return the useDimension
   */
  public InsightModelIllicitDrugUseDimension getUseDimension() {
	  return this.useDimension;
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

  /**
   * Returns the value from InsightModelIllicitDrug annotation by specified key.
   *
   * @param key the name of the field to get
   */
  @Override
  public Object get(String key) {
	  Object value = super.get(key);
	  if (value == null) {
		  try {
			  Field field = InsightModelIllicitDrug.class.getDeclaredField(key);
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
