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
 * InsightModelData Illicit Drug Use Qualifier.
 */
public class InsightModelIllicitDrugUseQualifier extends DynamicModel<Object> {

  @SerializedName("lightScore")
  protected Float lightScore;
  @SerializedName("moderateScore")
  protected Float moderateScore;
  @SerializedName("heavyScore")
  protected Float heavyScore;

  public InsightModelIllicitDrugUseQualifier() {
	  super(new TypeToken<Object>() { });
  }

  /**
   * Gets the lightScore.
   *
   * @return the lightScore
   */
  public Float getLightScore() {
  	return this.lightScore;
  }

  /**
   * Gets the moderateScore.
   *
   * @return the moderateScore
   */
  public Float getModerateScore() {
  	return this.moderateScore;
  }

  /**
   * Gets the heavyScore.
   *
   * @return the heavyScore
   */
  public Float getHeavyScore() {
    return this.heavyScore;
  }

  /**
   * Returns the value from InsightModelIllicitDrugUseQualifier annotation by specified key.
   *
   * @param key the name of the field to get
   */
  @Override
  public Object get(String key) {
	  Object value = super.get(key);
	  if (value == null) {
		  try {
			  Field field = InsightModelIllicitDrugUseQualifier.class.getDeclaredField(key);
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
