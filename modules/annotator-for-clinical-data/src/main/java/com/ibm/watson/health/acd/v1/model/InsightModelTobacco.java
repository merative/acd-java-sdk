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
 * InsightModelData Tobacco.
 */
public class InsightModelTobacco extends DynamicModel<Object> {

  @SerializedName("usage")
  protected InsightModelTobaccoUsage usage;
  @SerializedName("useStatus")
  protected InsightModelTobaccoUseStatus useStatus;
  @SerializedName("exposureScore")
  protected Float exposureScore;
  @SerializedName("familyHistoryScore")
  protected Float familyHistoryScore;
  @SerializedName("nonPatientScore")
  protected Float nonPatientScore;
  @SerializedName("treatmentScore")
  protected Float treatmentScore;

  public InsightModelTobacco() {
	  super(new TypeToken<Object>() { });
  }

  /**
   * Gets the usage.
   *
   * @return the usage
   */
  public InsightModelTobaccoUsage getUsage() {
    return this.usage;
  }

  /**
   * Gets the useStatus.
   *
   * @return the useStatus
   */
  public InsightModelTobaccoUseStatus getUseStatus() {
    return this.useStatus;
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
   * Gets the familyHistoryScore.
   *
   * @return the familyHistoryScore
   */
  public Float getFamilyHistoryScore() {
	  return this.familyHistoryScore;
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
   * Returns the value from InsightModelTobacco annotation by specified key.
   *
   * @param key the name of the field to get
   */
  @Override
  public Object get(String key) {
	  Object value = super.get(key);
	  if (value == null) {
		  try {
			  Field field = InsightModelTobacco.class.getDeclaredField(key);
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
