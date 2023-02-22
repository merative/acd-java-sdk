/* ***************************************************************** */
/*                                                                   */
/* (C) Copyright Merative US L.P. and others 2021, 2023              */
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
 * InsightModelData Illicit Drug Use Status.
 */
public class InsightModelIllicitDrugUseStatus extends DynamicModel<Object> {

  @SerializedName("currentScore")
  protected Float currentScore;
  @SerializedName("stoppedScore")
  protected Float stoppedScore;
  @SerializedName("neverScore")
  protected Float neverScore;
  @SerializedName("complianceScore")
  protected Float complianceScore;

  public InsightModelIllicitDrugUseStatus() {
	  super(new TypeToken<Object>() { });
  }

  /**
   * Gets the currentScore.
   *
   * @return the currentScore
   */
  public Float getCurrentScore() {
	  return this.currentScore;
  }

  /**
   * Gets the stoppedScore.
   *
   * @return the stoppedScore
   */
  public Float getStoppedScore() {
	  return this.stoppedScore;
  }

  /**
   * Gets the neverScore.
   *
   * @return the neverScore
   */
  public Float getNeverScore() {
	  return this.neverScore;
  }

  /**
   * Gets the complianceScore.
   *
   * @return the complianceScore
   */
  public Float getComplianceScore() {
	  return this.complianceScore;
  }

  /**
   * Returns the value from InsightModelIllicitDrugUseStatus annotation by specified key.
   *
   * @param key the name of the field to get
   */
  @Override
  public Object get(String key) {
	  Object value = super.get(key);
	  if (value == null) {
		  try {
			  Field field = InsightModelIllicitDrugUseStatus.class.getDeclaredField(key);
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
