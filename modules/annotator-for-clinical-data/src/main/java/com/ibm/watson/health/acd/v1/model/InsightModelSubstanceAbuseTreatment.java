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
 * InsightModelData Substance Abuse Treatment.
 */
public class InsightModelSubstanceAbuseTreatment extends DynamicModel<Object> {

  @SerializedName("discussedScore")
  protected Float discussedScore;
  @SerializedName("complianceScore")
  protected Float complianceScore;

  public InsightModelSubstanceAbuseTreatment() {
	  super(new TypeToken<Object>() { });
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
   * Gets the complianceScore.
   *
   * @return the complianceScore
   */
  public Float getComplianceScore() {
	  return this.complianceScore;
  }

  /**
   * Returns the value from InsightModelSubstanceAbuseTreatment annotation by specified key.
   *
   * @param key the name of the field to get
   */
  @Override
  public Object get(String key) {
	  Object value = super.get(key);
	  if (value == null) {
		  try {
			  Field field = InsightModelSubstanceAbuseTreatment.class.getDeclaredField(key);
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
