/* ***************************************************************** */
/*                                                                   */
/* Merative Confidential                                             */
/*                                                                   */
/* (C) Copyright Merative US L.P. 2001, 2023                         */
/*                                                                   */
/* SPDX-License-Identifier: Apache 2-0                               */
/*                                                                   */
/* ***************************************************************** */

package com.ibm.watson.health.acd.v1.model;

import java.lang.reflect.Field;

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

  /**
   * Returns the value from InsightModelDataTask annotation by specified key.
   *
   * @param key the name of the field to get
   */
  @Override
  public Object get(String key) {
	  Object value = super.get(key);
	  if (value == null) {
		  try {
			  Field field = InsightModelDataTask.class.getDeclaredField(key);
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
