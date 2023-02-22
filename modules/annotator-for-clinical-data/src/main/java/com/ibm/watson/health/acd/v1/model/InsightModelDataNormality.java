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
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.ibm.cloud.sdk.core.service.model.DynamicModel;

/**
 * InsightModelData Normality.
 */
public class InsightModelDataNormality extends DynamicModel<Object> {

  @SerializedName("usage")
  protected InsightModelDataNormalityUsage usage;
  @SerializedName("evidence")
  protected List<InsightModelDataEvidence> evidence;
  @SerializedName("directlyAffectedScore")
  protected Float directlyAffectedScore;

  public InsightModelDataNormality() {
	  super(new TypeToken<Object>() { });
  }

  /**
   * Gets the usage.
   *
   * @return the usage
   */
  public InsightModelDataNormalityUsage getUsage() {
    return this.usage;
  }

  /**
   * Gets the evidence.
   *
   * @return the evidence
   */
  public List<InsightModelDataEvidence> getEvidence() {
    return this.evidence;
  }

  /**
   * Gets the directlyAffectedScore.
   *
   * @return the directlyAffectedScore
   */
  public Float getDirectlyAffectedScore() {
	  return this.directlyAffectedScore;
  }

  /**
   * Returns the value from InsightModelDataNormality annotation by specified key.
   *
   * @param key the name of the field to get
   */
  @Override
  public Object get(String key) {
	  Object value = super.get(key);
	  if (value == null) {
		  try {
			  Field field = InsightModelDataNormality.class.getDeclaredField(key);
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
