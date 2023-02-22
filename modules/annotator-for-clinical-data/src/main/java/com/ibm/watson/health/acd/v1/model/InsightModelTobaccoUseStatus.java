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
 * InsightModelData Tobacco Use Status.
 */
public class InsightModelTobaccoUseStatus extends DynamicModel<Object> {

  @SerializedName("currentScore")
  protected Float currentScore;
  @SerializedName("stoppedScore")
  protected Float stoppedScore;
  @SerializedName("neverScore")
  protected Float neverScore;

  public InsightModelTobaccoUseStatus() {
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
   * Returns the value from InsightModelTobaccoUseStatus annotation by specified key.
   *
   * @param key the name of the field to get
   */
  @Override
  public Object get(String key) {
	  Object value = super.get(key);
	  if (value == null) {
		  try {
			  Field field = InsightModelTobaccoUseStatus.class.getDeclaredField(key);
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
