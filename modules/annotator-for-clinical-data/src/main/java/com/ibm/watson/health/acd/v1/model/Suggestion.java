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

public class Suggestion extends DynamicModel<Object> {

  @SerializedName("applied")
  protected Boolean applied;
  @SerializedName("confidence")
  protected Double confidence;
  @SerializedName("semtypes")
  protected List<String> semtypes;
  @SerializedName("text")
  protected String text;

  public Suggestion() {
	  super(new TypeToken<Object>() { });
  }

  /**
   * Gets the applied field.
   *
   * @return the applied field
   */
  public Boolean getApplied() {
    return this.applied;
  }

  /**
   * Gets the confidence field.
   *
   * @return the confidence field
   */
  public Double getConfidence() {
    return this.confidence;
  }

  /**
   * Gets the semtypes field.
   *
   * @return the semtypes field
   */
  public List<String> getSemtypes() {
    return this.semtypes;
  }

  /**
   * Gets the text field.
   *
   * @return the text field
   */
  public String getText() {
    return this.text;
  }

  /**
   * Returns the value from Suggestion annotation by specified key.
   *
   * @param key the name of the field to get
   */
  @Override
  public Object get(String key) {
	  Object value = super.get(key);
	  if (value == null) {
		  try {
			  Field field = Suggestion.class.getDeclaredField(key);
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
