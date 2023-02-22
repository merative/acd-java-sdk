/* ***************************************************************** */
/*                                                                   */
/* Merative Confidential                                             */
/*                                                                   */
/* (C) Copyright Merative US L.P. 2001, 2023                         */
/*                                                                   */
/* SPDX-License-Identifier: Apache 2-0                               */
/*                                                                   */
/* ***************************************************************** */

package com.ibm.watson.health.acd.v1.model;

import java.lang.reflect.Field;

import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.ibm.cloud.sdk.core.service.model.DynamicModel;

/**
 * InsightModelData Medication.
 */
public class InsightModelDataMedication extends DynamicModel<Object> {

  @SerializedName("usage")
  protected InsightModelDataUsage usage;
  @SerializedName("started")
  protected InsightModelDataEvent started;
  @SerializedName("stopped")
  protected InsightModelDataEvent stopped;
  @SerializedName("doseChanged")
  protected InsightModelDataEvent doseChanged;
  @SerializedName("adverse")
  protected InsightModelDataEvent adverse;

  public InsightModelDataMedication() {
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
   * Gets the started.
   *
   * @return the started
   */
  public InsightModelDataEvent getStarted() {
    return this.started;
  }

  /**
   * Gets the stopped.
   *
   * @return the stopped
   */
  public InsightModelDataEvent getStopped() {
    return this.stopped;
  }

  /**
   * Gets the doseChanged.
   *
   * @return the doseChanged
   */
  public InsightModelDataEvent getDoseChanged() {
    return this.doseChanged;
  }

  /**
   * Gets the adverse.
   *
   * @return the adverse
   */
  public InsightModelDataEvent getAdverse() {
    return this.adverse;
  }

  /**
   * Returns the value from InsightModelDataMedication annotation by specified key.
   *
   * @param key the name of the field to get
   */
  @Override
  public Object get(String key) {
	  Object value = super.get(key);
	  if (value == null) {
		  try {
			  Field field = InsightModelDataMedication.class.getDeclaredField(key);
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
