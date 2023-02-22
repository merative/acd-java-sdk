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
 * InsightModelData Substance Abuse.
 */
public class InsightModelSubstanceAbuse extends DynamicModel<Object> {

  @SerializedName("treatmentScore")
  protected Float treatmentScore;
  @SerializedName("nonPatientScore")
  protected Float nonPatientScore;
  @SerializedName("treatment")
  protected InsightModelSubstanceAbuseTreatment treatment;

  public InsightModelSubstanceAbuse() {
	  super(new TypeToken<Object>() { });
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
     * Gets the nonPatientScore.
     *
     * @return the nonPatientScore
     */
    public Float getNonPatientScore() {
  	  return this.nonPatientScore;
    }

    /**
     * Gets the treatment.
     *
     * @return the treatment
     */
    public InsightModelSubstanceAbuseTreatment getTreatment() {
  	  return this.treatment;
    }

  /**
   * Returns the value from InsightModelSubstanceAbuse annotation by specified key.
   *
   * @param key the name of the field to get
   */
  @Override
  public Object get(String key) {
	  Object value = super.get(key);
	  if (value == null) {
		  try {
			  Field field = InsightModelSubstanceAbuse.class.getDeclaredField(key);
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
