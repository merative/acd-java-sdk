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
import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.ibm.cloud.sdk.core.service.model.DynamicModel;
import com.ibm.watson.health.acd.v1.util.CustomCollection;

/**
 * Temporal.
 */
public class Temporal extends DynamicModel<Object> {
  @SerializedName("begin")
  protected Long begin;
  @SerializedName("end")
  protected Long end;
  @SerializedName("coveredText")
  protected String coveredText;
  @SerializedName("temporalType")
  protected Map temporalType;
  @SerializedName("relationTypes")
  protected Map relationTypes;

  public Temporal() {
	  super(new TypeToken<Object>() { });
  }

  /**
   * Gets the begin.
   *
   * @return the begin
   */
  public Long getBegin() {
    return this.begin;
  }

  /**
   * Gets the end.
   *
   * @return the end
   */
  public Long getEnd() {
    return this.end;
  }

  /**
   * Gets the coveredText.
   *
   * @return the coveredText
   */
  public String getCoveredText() {
    return this.coveredText;
  }

  /**
   * Gets the temporal type.
   *
   * @return the temporal type
   */
  public CustomCollection getTemporalType() {
    Object temporalTypeObject = this.temporalType;
    CustomCollection customCollection = new CustomCollection();
    return customCollection.convertToCustomCollection(temporalTypeObject);
  }

  /**
   * Gets the temporal type map.
   *
   * @return the temporal type map
   */
  public Map getTemporalTypeMap() {
    return this.temporalType;
  }

  /**
   * Gets the relation types.
   *
   * @return the relation types
   */
  public CustomCollection getRelationTypes() {
    Object relationTypesObject = this.relationTypes;
    CustomCollection customCollection = new CustomCollection();
    return customCollection.convertToCustomCollection(relationTypesObject);
  }

  /**
   * Gets the relation types map.
   *
   * @return the relation types map
   */
  public Map getRelationTypesMap() {
    return this.relationTypes;
  }

  /**
   * Returns the value from Temporal annotation by specified key.
   *
   * @param key the name of the field to get
   */
  @Override
  public Object get(String key) {
	  Object value = super.get(key);
	  if (value == null) {
		  try {
			  Field field = Temporal.class.getDeclaredField(key);
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
