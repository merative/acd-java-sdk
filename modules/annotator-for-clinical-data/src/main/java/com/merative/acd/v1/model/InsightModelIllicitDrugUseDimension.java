/* ***************************************************************** */
/*                                                                   */
/* (C) Copyright Merative US L.P. and others 2021, 2023              */
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
 * InsightModelData Illicit Drug Use Dimension.
 */
public class InsightModelIllicitDrugUseDimension extends DynamicModel<Object> {

  @SerializedName("abuseScore")
  protected Float abuseScore;
  @SerializedName("medicalScore")
  protected Float medicalScore;

  public InsightModelIllicitDrugUseDimension() {
	  super(new TypeToken<Object>() { });
  }

  /**
   * Gets the abuseScore.
   *
   * @return the abuseScore
   */
  public Float getAbuseScore() {
    return this.abuseScore;
  }

  /**
   * Gets the medicalScore.
   *
   * @return the medicalScore
   */
  public Float getMedicalScore() {
    return this.medicalScore;
  }

  /**
   * Returns the value from InsightModelIllicitDrugUseDimension annotation by specified key.
   *
   * @param key the name of the field to get
   */
  @Override
  public Object get(String key) {
	  Object value = super.get(key);
	  if (value == null) {
		  try {
			  Field field = InsightModelIllicitDrugUseDimension.class.getDeclaredField(key);
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
