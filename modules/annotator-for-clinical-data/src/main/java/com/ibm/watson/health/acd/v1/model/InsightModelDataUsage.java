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
 * InsightModelData Usage.
 */
public class InsightModelDataUsage extends DynamicModel<Object> {

  @SerializedName("takenScore")
  protected Float takenScore;
  @SerializedName("explicitScore")
  protected Float explicitScore;
  @SerializedName("implicitScore")
  protected Float implicitScore;
  @SerializedName("consideringScore")
  protected Float consideringScore;
  @SerializedName("patientReportedScore")
  protected Float patientReportedScore;
  @SerializedName("discussedScore")
  protected Float discussedScore;
  @SerializedName("labMeasurementScore")
  protected Float labMeasurementScore;
  @SerializedName("pendingScore")
  protected Float pendingScore;

  public InsightModelDataUsage() {
	  super(new TypeToken<Object>() { });
  }

  /**
   * Gets the takenScore.
   *
   * @return the takenScore
   */
  public Float getTakenScore() {
	  return this.takenScore;
  }

  /**
   * Gets the explicitScore.
   *
   * @return the explicitScore
   */
  public Float getExplicitScore() {
	  return this.explicitScore;
  }

  /**
   * Gets the implicitScore.
   *
   * @return the implicitScore
   */
  public Float getImplicitScore() {
	  return this.implicitScore;
  }

  /**
   * Gets the consideringScore.
   *
   * @return the consideringScore
   */
  public Float getConsideringScore() {
	  return this.consideringScore;
  }

  /**
   * Gets the patientReportedScore.
   *
   * @return the patientReportedScore
   */
  public Float getPatientReportedScore() {
	  return this.patientReportedScore;
  }

  /**
   * Gets the discussedScore.
   *
   * @return the discussedScore
   */
  public Float getDiscussedScore() {
	  return this.discussedScore;
  }

  /**
   * Gets the labMeasurementScore.
   *
   * @return the labMeasurementScore
   */
  public Float getLabMeasurementScore() {
	  return this.labMeasurementScore;
  }

  /**
   * Gets the pendingScore.
   *
   * @return the pendingScore
   */
  public Float getPendingScore() {
	  return this.pendingScore;
  }

  /**
   * Returns the value from InsightModelDataUsage annotation by specified key.
   *
   * @param key the name of the field to get
   */
  @Override
  public Object get(String key) {
	  Object value = super.get(key);
	  if (value == null) {
		  try {
			  Field field = InsightModelDataUsage.class.getDeclaredField(key);
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
