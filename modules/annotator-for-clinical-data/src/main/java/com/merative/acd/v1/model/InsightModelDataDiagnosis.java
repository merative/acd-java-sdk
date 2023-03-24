/* ***************************************************************** */
/*                                                                   */
/* (C) Copyright Merative US L.P. and others 2018, 2023              */
/*                                                                   */
/* SPDX-License-Identifier: Apache-2.0                               */
/*                                                                   */
/* ***************************************************************** */

package com.merative.acd.v1.model;

import java.lang.reflect.Field;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.ibm.cloud.sdk.core.service.model.DynamicModel;

/**
 * InsightModelData Diagnosis.
 */
public class InsightModelDataDiagnosis extends DynamicModel<Object> {

  @SerializedName("usage")
  protected InsightModelDataUsage usage;
  @SerializedName("suspectedScore")
  protected Float suspectedScore;
  @SerializedName("symptomScore")
  protected Float symptomScore;
  @SerializedName("traumaScore")
  protected Float traumaScore;
  @SerializedName("familyHistoryScore")
  protected Float familyHistoryScore;
  @SerializedName("modifiers")
  protected InsightModelDataDiagnosisModifier modifiers;

  public InsightModelDataDiagnosis() {
	  super(new TypeToken<Object>() { });
  }

  /**
   * Gets the usage.
   *
   * @return the usage
   */
  public InsightModelDataUsage getUsage() {
    return this.usage;
  }

  /**
   * Gets the suspectedScore.
   *
   * @return the suspectedScore
   */
  public Float getSuspectedScore() {
	  return this.suspectedScore;
  }

  /**
   * Gets the symptomScore.
   *
   * @return the symptomScore
   */
  public Float getSymptomScore() {
	  return this.symptomScore;
  }

  /**
   * Gets the traumaScore.
   *
   * @return the traumaScore
   */
  public Float getTraumaScore() {
	  return this.traumaScore;
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
   * Gets the modifiers.
   *
   * @return the modifiers
   */
  public InsightModelDataDiagnosisModifier getModifiers() {
    return this.modifiers;
  }

  /**
   * Returns the value from InsightModelDataDiagnosis annotation by specified key.
   *
   * @param key the name of the field to get
   */
  @Override
  public Object get(String key) {
	  Object value = super.get(key);
	  if (value == null) {
		  try {
			  Field field = InsightModelDataDiagnosis.class.getDeclaredField(key);
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
