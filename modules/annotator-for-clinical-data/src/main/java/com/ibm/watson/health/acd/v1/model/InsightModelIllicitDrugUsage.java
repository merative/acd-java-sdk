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
 * InsightModelData Illicit Drug Usage.
 */
public class InsightModelIllicitDrugUsage extends DynamicModel<Object> {

  @SerializedName("useScore")
  protected Float useScore;
  @SerializedName("noneScore")
  protected Float noneScore;
  @SerializedName("unknownScore")
  protected Float unknownScore;
  @SerializedName("discussedScore")
  protected Float discussedScore;
  @SerializedName("treatmentScore")
  protected Float treatmentScore;

  public InsightModelIllicitDrugUsage() {
	  super(new TypeToken<Object>() { });
  }

  /**
   * Gets the useScore.
   *
   * @return the useScore
   */
  public Float getUseScore() {
	  return this.useScore;
  }

  /**
   * Gets the noneScore.
   *
   * @return the noneScore
   */
  public Float getNoneScore() {
	  return this.noneScore;
  }

  /**
   * Gets the unknownScore.
   *
   * @return the unknownScore
   */
  public Float getUnknownScore() {
	  return this.unknownScore;
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
   * Gets the treatmentScore.
   *
   * @return the treatmentScore
   */
  public Float getTreatmentScore() {
	  return this.treatmentScore;
  }

  /**
   * Returns the value from InsightModelIllicitDrugUsage annotation by specified key.
   *
   * @param key the name of the field to get
   */
  @Override
  public Object get(String key) {
	  Object value = super.get(key);
	  if (value == null) {
		  try {
			  Field field = InsightModelIllicitDrugUsage.class.getDeclaredField(key);
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
