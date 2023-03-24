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
 * InsightModelData Event.
 */
public class InsightModelDataEvent extends DynamicModel<Object> {

  @SerializedName("score")
  protected Float score;
  @SerializedName("allergyScore")
  protected Float allergyScore;
  @SerializedName("usage")
  protected InsightModelDataUsage usage;

  public InsightModelDataEvent() {
	  super(new TypeToken<Object>() { });
  }

  /**
   * Gets the score.
   *
   * @return the score
   */
  public Float getScore() {
	  return this.score;
  }

  /**
   * Gets the allergy score.
   *
   * @return the allergy score
   */
  public Float getAllergyScore() {
	  return this.allergyScore;
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
   * Returns the value from InsightModelDataEvent annotation by specified key.
   *
   * @param key the name of the field to get
   */
  @Override
  public Object get(String key) {
	  Object value = super.get(key);
	  if (value == null) {
		  try {
			  Field field = InsightModelDataEvent.class.getDeclaredField(key);
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
