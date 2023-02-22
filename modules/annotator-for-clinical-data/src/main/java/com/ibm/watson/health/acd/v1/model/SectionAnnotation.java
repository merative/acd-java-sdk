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
 * SectionAnnotation.
 */
public class SectionAnnotation extends DynamicModel<Object> {

  @SerializedName("begin")
  protected Long begin;
  @SerializedName("end")
  protected Long end;
  @SerializedName("type")
  protected String type;
  @SerializedName("coveredText")
  protected String coveredText;
  @SerializedName("sectionType")
  protected String sectionType;
  @SerializedName("trigger")
  protected SectionTrigger sectionTrigger;

  public SectionAnnotation() {
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
   * Gets the sectionTrigger.
   * @return the sectionTrigger
   */
  public SectionTrigger getTrigger() {
    return this.sectionTrigger;
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
   * Gets the type.
   *
   * @return the type
   */
  public String getType() {
    return this.type;
  }

  /**
   * Gets the section type.
   *
   * @return the section type
   */
  public String getSectionType() {
    return this.sectionType;
  }

  /**
   * Returns the value from SectionAnnotation annotation by specified key.
   *
   * @param key the name of the field to get
   */
  @Override
  public Object get(String key) {
	  Object value = super.get(key);
	  if (value == null) {
		  try {
			  Field field = SectionAnnotation.class.getDeclaredField(key);
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
