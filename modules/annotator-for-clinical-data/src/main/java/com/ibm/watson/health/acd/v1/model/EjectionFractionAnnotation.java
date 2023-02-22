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

import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.ibm.cloud.sdk.core.service.model.DynamicModel;

/**
 * EjectionFractionAnnotation.
 */
public class EjectionFractionAnnotation extends DynamicModel<Object> {
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
  @SerializedName("firstValue")
  protected String firstValue;
  @SerializedName("efAlphabeticValueSurfaceForm")
  protected String efAlphabeticValueSurfaceForm;
  @SerializedName("secondValue")
  protected String secondValue;
  @SerializedName("efTermSurfaceForm")
  protected String efTermSurfaceForm;
  @SerializedName("efSuffixSurfaceForm")
  protected String efSuffixSurfaceForm;
  @SerializedName("efSuffixNormalizedName")
  protected String efSuffixNormalizedName;
  @SerializedName("efAlphabeticValueNormalizedName")
  protected String efAlphabeticValueNormalizedName;
  @SerializedName("efTermNormalizedName")
  protected String efTermNormalizedName;
  @SerializedName("isRange")
  protected String isRange;
  @SerializedName("sectionNormalizedName")
  protected String sectionNormalizedName;
  @SerializedName("sectionSurfaceForm")
  protected String sectionSurfaceForm;

  public EjectionFractionAnnotation() {
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
   * Gets the firstValue.
   *
   * @return the firstValue
   */
  public String getFirstValue() {
    return this.firstValue;
  }

  /**
   * Gets the efAlphabeticValueSurfaceForm.
   *
   * @return the efAlphabeticValueSurfaceForm
   */
  public String getEfAlphabeticValueSurfaceForm() {
    return this.efAlphabeticValueSurfaceForm;
  }

  /**
   * Gets the secondValue.
   *
   * @return the secondValue
   */
  public String getSecondValue() {
    return this.secondValue;
  }

  /**
   * Gets the efTermSurfaceForm.
   *
   * @return the efTermSurfaceForm
   */
  public String getEfTermSurfaceForm() {
    return this.efTermSurfaceForm;
  }

  /**
   * Gets the efSuffixSurfaceForm.
   *
   * @return the efSuffixSurfaceForm
   */
  public String getEfSuffixSurfaceForm() {
    return this.efSuffixSurfaceForm;
  }

  /**
   * Gets the efSuffixNormalizedName.
   *
   * @return the efSuffixNormalizedName
   */
  public String getEfSuffixNormalizedName() {
    return this.efSuffixNormalizedName;
  }

  /**
   * Gets the efAlphabeticValueNormalizedName.
   *
   * @return the efAlphabeticValueNormalizedName
   */
  public String getEfAlphabeticValueNormalizedName() {
    return this.efAlphabeticValueNormalizedName;
  }

  /**
   * Gets the efTermNormalizedName.
   *
   * @return the efTermNormalizedName
   */
  public String getEfTermNormalizedName() {
    return this.efTermNormalizedName;
  }

  /**
   * Gets the isRange.
   *
   * @return the isRange
   */
  public String getIsRange() {
    return this.isRange;
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
   * Returns the value from EjectionFractionAnnotation by specified key.
   *
   * @param key the name of the field to get
   */
  @Override
  public Object get(String key) {
	  Object value = super.get(key);
	  if (value == null) {
		  try {
			  Field field = EjectionFractionAnnotation.class.getDeclaredField(key);
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
