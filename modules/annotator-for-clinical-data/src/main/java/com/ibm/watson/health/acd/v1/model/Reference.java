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

public class Reference extends DynamicModel<Object> {

  @SerializedName("uid")
  protected Long uid;
  @SerializedName("selectionLabel")
  protected String selectionLabel;
  @SerializedName("valueIndex")
  protected Integer valueIndex;

  public Reference() {
	  super(new TypeToken<Object>() { });
  }

  /**
   * Gets the uid.
   *
   * @return the uid
   */
  public Long getUid() {
    return this.uid;
  }

  /**
   * Gets the selectionLabel.
   * @return the selectionLabel
   */
  public String getSelectionLabel() {
    return this.selectionLabel;
  }

  /**
   * Gets the valueIndex.
   * @return the valueIndex
   */
  public Integer getValueIndex() {
    return this.valueIndex;
  }

  /**
   * Sets the uid.
   *
   * @param uid the new uid
   */
  public void setUid(final Long uid) {
    this.uid = uid;
  }

  /**
   * Sets the selectionLabel.
   *
   * @param selectionLabel the new selectionLabel
   */
  public void setSelectionLabel(final String selectionLabel) {
    this.selectionLabel = selectionLabel;
  }

  /**
   * Sets the valueIndex.
   *
   * @param valueIndex the new valueIndex
   */
  public void setValueIndex(final Integer valueIndex) {
    this.valueIndex = valueIndex;
  }

  /**
   * Returns the value from Reference annotation by specified key.
   *
   * @param key the name of the field to get
   */
  @Override
  public Object get(String key) {
	  Object value = super.get(key);
	  if (value == null) {
		  try {
			  Field field = Reference.class.getDeclaredField(key);
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
