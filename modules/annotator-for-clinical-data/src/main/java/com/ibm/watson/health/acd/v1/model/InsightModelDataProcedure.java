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
 * InsightModelData Procedure.
 */
public class InsightModelDataProcedure extends DynamicModel<Object> {

  @SerializedName("usage")
  protected InsightModelDataUsage usage;
  @SerializedName("task")
  protected InsightModelDataTask task;
  @SerializedName("type")
  protected InsightModelDataType type;
  @SerializedName("modifiers")
  protected InsightModelDataProcedureModifier modifiers;

  public InsightModelDataProcedure() {
	  super(new TypeToken<Object>() { });
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
   * Gets the task.
   *
   * @return the task
   */
  public InsightModelDataTask getTask() {
    return this.task;
  }

  /**
   * Gets the type.
   *
   * @return the type
   */
  public InsightModelDataType getType() {
    return this.type;
  }

  /**
   * Gets the modifiers.
   *
   * @return the modifiers
   */
  public InsightModelDataProcedureModifier getModifiers() {
    return this.modifiers;
  }

  /**
   * Returns the value from InsightModelDataProcedure annotation by specified key.
   *
   * @param key the name of the field to get
   */
  @Override
  public Object get(String key) {
	  Object value = super.get(key);
	  if (value == null) {
		  try {
			  Field field = InsightModelDataProcedure.class.getDeclaredField(key);
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
