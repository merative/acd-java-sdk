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
 * LabValueAnnotation.
 */
public class LabValueAnnotation extends DynamicModel<Object> {
  @SerializedName("id")
  protected String id;
  @SerializedName("type")
  protected String type;
  @SerializedName("uid")
  protected Long uid;
  @SerializedName("begin")
  protected Long begin;
  @SerializedName("end")
  protected Long end;
  @SerializedName("coveredText")
  protected String coveredText;
  @SerializedName("negated")
  protected Boolean negated;
  @SerializedName("hypothetical")
  protected Boolean hypothetical;
  @SerializedName("loincId")
  protected String loincId;
  @SerializedName("lowValue")
  protected String lowValue;
  @SerializedName("dateInMilliseconds")
  protected String dateInMilliseconds;
  @SerializedName("labTypeSurfaceForm")
  protected String labTypeSurfaceForm;
  @SerializedName("labTypeNormalizedName")
  protected String labTypeNormalizedName;
  @SerializedName("labValue")
  protected String labValue;
  @SerializedName("sectionNormalizedName")
  protected String sectionNormalizedName;
  @SerializedName("sectionSurfaceForm")
  protected String sectionSurfaceForm;

  public LabValueAnnotation() {
	  super(new TypeToken<Object>() { });
  }

  /**
   * Gets the id.
   *
   * @return the id
   */
  public String getId() {
    return this.id;
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
   * Gets the uid.
   *
   * @return the uid
   */
  public Long getUid() {
    return this.uid;
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
   * Gets the negated.
   *
   * @return the negated
   */
  public Boolean isNegated() {
    Boolean negated = this.negated;
    if (negated == null) {
      negated = false;
    }
    return negated;
  }

  /**
   * Gets the hypothetical.
   *
   * @return the hypothetical
   */
  public Boolean isHypothetical() {
    Boolean hypothetical = this.hypothetical;
    if (hypothetical == null) {
      hypothetical = false;
    }
    return hypothetical;
  }

  /**
   * Gets the loincId.
   *
   * @return the loincId
   */
  public String getLoincId() {
    return this.loincId;
  }

  /**
   * Gets the lowValue.
   *
   * @return the lowValue
   */
  public String getLowValue() {
    return this.lowValue;
  }

  /**
   * Gets the dateInMilliseconds.
   *
   * @return the dateInMilliseconds
   */
  public String getDateInMilliseconds() {
    return this.dateInMilliseconds;
  }

  /**
   * Gets the labTypeSurfaceForm.
   *
   * @return the labTypeSurfaceForm
   */
  public String getLabTypeSurfaceForm() {
    return this.labTypeSurfaceForm;
  }

  /**
   * Gets the labTypeNormalizedName.
   *
   * @return the labTypeNormalizedName
   */
  public String getLabTypeNormalizedName() {
    return this.labTypeNormalizedName;
  }

  /**
   * Gets the labValue.
   *
   * @return the labValue
   */
  public String getLabValue() {
    return this.labValue;
  }

  /**
   * Gets the sectionNormalizedName.
   *
   * @return the sectionNormalizedName
   */
  public String getSectionNormalizedName() {
    return this.sectionNormalizedName;
  }

  /**
   * Gets the sectionSurfaceForm.
   *
   * @return the sectionSurfaceForm
   */
  public String getSectionSurfaceForm() {
    return this.sectionSurfaceForm;
  }

  /**
   * Returns the value from LabValueAnnotation annotation by specified key.
   *
   * @param key the name of the field to get
   */
  @Override
  public Object get(String key) {
	  Object value = super.get(key);
	  if (value == null) {
		  try {
			  Field field = LabValueAnnotation.class.getDeclaredField(key);
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
