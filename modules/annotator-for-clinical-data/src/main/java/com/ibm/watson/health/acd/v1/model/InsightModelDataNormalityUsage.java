/* ***************************************************************** */
/*                                                                   */
/* (C) Copyright Merative US L.P. and others 2018, 2023              */
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
 * InsightModelData Normality Usage.
 */
public class InsightModelDataNormalityUsage extends DynamicModel<Object> {

  @SerializedName("normalScore")
  protected Float normalScore;
  @SerializedName("abnormalScore")
  protected Float abnormalScore;
  @SerializedName("unknownScore")
  protected Float unknownScore;
  @SerializedName("nonFindingScore")
  protected Float nonFindingScore;

  public InsightModelDataNormalityUsage() {
	  super(new TypeToken<Object>() { });
  }

  /**
   * Gets the normalScore.
   *
   * @return the normalScore
   */
  public Float getNormalScore() {
	  return this.normalScore;
  }

  /**
   * Gets the abnormalScore.
   *
   * @return the abnormalScore
   */
  public Float getAbnormalScore() {
	  return this.abnormalScore;
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
   * Gets the nonFindingScore.
   *
   * @return the nonFindingScore
   */
  public Float getNonFindingScore() {
	  return this.nonFindingScore;
  }

  /**
   * Returns the value from InsightModelDataNormalityUsage annotation by specified key.
   *
   * @param key the name of the field to get
   */
  @Override
  public Object get(String key) {
	  Object value = super.get(key);
	  if (value == null) {
		  try {
			  Field field = InsightModelDataNormalityUsage.class.getDeclaredField(key);
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
