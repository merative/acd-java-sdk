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
 * InsightModelData Type.
 */
public class InsightModelDataType extends DynamicModel<Object> {

  @SerializedName("deviceScore")
  protected Float deviceScore;
  @SerializedName("materialScore")
  protected Float materialScore;
  @SerializedName("medicationScore")
  protected Float medicationScore;
  @SerializedName("procedureScore")
  protected Float procedureScore;
  @SerializedName("conditionManagementScore")
  protected Float conditionManagementScore;

  public InsightModelDataType() {
	  super(new TypeToken<Object>() { });
  }

  /**
   * Gets the deviceScore.
   *
   * @return the deviceScore
   */
  public Float getDeviceScore() {
	  return this.deviceScore;
  }

  /**
   * Gets the materialScore.
   *
   * @return the materialScore
   */
  public Float getMaterialScore() {
	  return this.materialScore;
  }

  /**
   * Gets the medicationScore.
   *
   * @return the medicationScore
   */
  public Float getMedicationScore() {
	  return this.medicationScore;
  }

  /**
   * Gets the procedureScore.
   *
   * @return the procedureScore
   */
  public Float getProcedureScore() {
	  return this.procedureScore;
  }

  /**
   * Gets the conditionManagementScore.
   *
   * @return the conditionManagementScore
   */
  public Float getConditionManagementScore() {
	  return this.conditionManagementScore;
  }

  /**
   * Returns the value from InsightModelDataType annotation by specified key.
   *
   * @param key the name of the field to get
   */
  @Override
  public Object get(String key) {
	  Object value = super.get(key);
	  if (value == null) {
		  try {
			  Field field = InsightModelDataType.class.getDeclaredField(key);
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
