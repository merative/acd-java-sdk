/*
 * Copyright 2018 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.ibm.watson.health.acd.v1.model;

import java.lang.reflect.Type;

import com.google.gson.reflect.TypeToken;
import com.ibm.watson.developer_cloud.service.model.DynamicModel;
import com.ibm.watson.developer_cloud.util.GsonSerializationHelper;

/**
 * EjectionFractionAnnotation.
 */
public class EjectionFractionAnnotation extends DynamicModel {
  private Type idType = new TypeToken<String>() { } .getType();
  private Type typeType = new TypeToken<String>() { } .getType();
  private Type uidType = new TypeToken<Long>() { } .getType();
  private Type beginType = new TypeToken<Long>() { } .getType();
  private Type endType = new TypeToken<Long>() { } .getType();
  private Type coveredTextType = new TypeToken<String>() { } .getType();
  private Type negatedType = new TypeToken<Boolean>() { } .getType();
  private Type hypotheticalType = new TypeToken<Boolean>() { } .getType();
  private Type firstValueType = new TypeToken<String>() { } .getType();
  private Type efAlphabeticValueSurfaceFormType = new TypeToken<String>() { } .getType();
  private Type secondValueType = new TypeToken<String>() { } .getType();
  private Type efTermSurfaceFormType = new TypeToken<String>() { } .getType();
  private Type efSuffixSurfaceFormType = new TypeToken<String>() { } .getType();
  private Type efSuffixNormalizedNameType = new TypeToken<String>() { } .getType();
  private Type efAlphabeticValueNormalizedNameType = new TypeToken<String>() { } .getType();
  private Type efTermNormalizedNameType = new TypeToken<String>() { } .getType();
  private Type isRangeType = new TypeToken<String>() { } .getType();
  private Type sectionNormalizedNameType = new TypeToken<String>() { } .getType();
  private Type sectionSurfaceFormType = new TypeToken<String>() { } .getType();


  /**
   * Gets the id.
   *
   * @return the id
   */
  public String getId() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("id"), idType);
  }

  /**
   * Gets the type.
   *
   * @return the type
   */
  public String getType() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("type"), typeType);
  }

  /**
   * Gets the uid.
   *
   * @return the uid
   */
  public Long getUid() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("uid"), uidType);
  }

  /**
   * Gets the begin.
   *
   * @return the begin
   */
  public Long getBegin() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("begin"), beginType);
  }

  /**
   * Gets the end.
   *
   * @return the end
   */
  public Long getEnd() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("end"), endType);
  }

  /**
   * Gets the coveredText.
   *
   * @return the coveredText
   */
  public String getCoveredText() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("coveredText"), coveredTextType);
  }

  /**
   * Gets the negated.
   *
   * @return the negated
   */
  public Boolean isNegated() {
    Boolean negated = GsonSerializationHelper.serializeDynamicModelProperty(this.get("negated"), negatedType);
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
    Boolean hypothetical = GsonSerializationHelper.serializeDynamicModelProperty(this.get("hypothetical"), hypotheticalType);
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
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("firstValue"), firstValueType);
  }

  /**
   * Gets the efAlphabeticValueSurfaceForm.
   *
   * @return the efAlphabeticValueSurfaceForm
   */
  public String getEfAlphabeticValueSurfaceForm() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("efAlphabeticValueSurfaceForm"), efAlphabeticValueSurfaceFormType);
  }

  /**
   * Gets the secondValue.
   *
   * @return the secondValue
   */
  public String getSecondValue() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("secondValue"), secondValueType);
  }

  /**
   * Gets the efTermSurfaceForm.
   *
   * @return the efTermSurfaceForm
   */
  public String getEfTermSurfaceForm() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("efTermSurfaceForm"), efTermSurfaceFormType);
  }

  /**
   * Gets the efSuffixSurfaceForm.
   *
   * @return the efSuffixSurfaceForm
   */
  public String getEfSuffixSurfaceForm() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("efSuffixSurfaceForm"), efSuffixSurfaceFormType);
  }

  /**
   * Gets the efSuffixNormalizedName.
   *
   * @return the efSuffixNormalizedName
   */
  public String getEfSuffixNormalizedName() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("efSuffixNormalizedName"), efSuffixNormalizedNameType);
  }

  /**
   * Gets the efAlphabeticValueNormalizedName.
   *
   * @return the efAlphabeticValueNormalizedName
   */
  public String getEfAlphabeticValueNormalizedName() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("efAlphabeticValueNormalizedName"), efAlphabeticValueNormalizedNameType);
  }

  /**
   * Gets the efTermNormalizedName.
   *
   * @return the efTermNormalizedName
   */
  public String getEfTermNormalizedName() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("efTermNormalizedName"), efTermNormalizedNameType);
  }

  /**
   * Gets the isRange.
   *
   * @return the isRange
   */
  public String getIsRange() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("isRange"), isRangeType);
  }

  /**
   * Gets the sectionNormalizedName.
   *
   * @return the sectionNormalizedName
   */
  public String getSectionNormalizedName() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("sectionNormalizedName"), sectionNormalizedNameType);
  }

  /**
   * Gets the sectionSurfaceForm.
   *
   * @return the sectionSurfaceForm
   */
  public String getSectionSurfaceForm() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("sectionSurfaceForm"), sectionSurfaceFormType);
  }


//  /**
//   * Sets the id.
//   *
//   * @param id the new id
//   */
//  public void setId(final String id) {
//    this.put("id", id);
//  }
//
//  /**
//   * Sets the type.
//   *
//   * @param type the new type
//   */
//  public void setType(final String type) {
//    this.put("type", type);
//  }
//
//  /**
//   * Sets the uid.
//   *
//   * @param uid the new uid
//   */
//  public void setUid(final Long uid) {
//    this.put("uid", uid);
//  }
//
//  /**
//   * Sets the begin.
//   *
//   * @param begin the new begin
//   */
//  public void setBegin(final Long begin) {
//    this.put("begin", begin);
//  }
//
//  /**
//   * Sets the end.
//   *
//   * @param end the new end
//   */
//  public void setEnd(final Long end) {
//    this.put("end", end);
//  }
//
//  /**
//   * Sets the coveredText.
//   *
//   * @param coveredText the new coveredText
//   */
//  public void setCoveredText(final String coveredText) {
//    this.put("coveredText", coveredText);
//  }
//
//  /**
//   * Sets the negated.
//   *
//   * @param negated the new negated
//   */
//  public void setNegated(final Boolean negated) {
//    this.put("negated", negated);
//  }
//
//  /**
//   * Sets the hypothetical.
//   *
//   * @param hypothetical the new hypothetical
//   */
//  public void setHypothetical(final Boolean hypothetical) {
//    this.put("hypothetical", hypothetical);
//  }
//
//  /**
//   * Sets the firstValue.
//   *
//   * @param firstValue the new firstValue
//   */
//  public void setFirstValue(final String firstValue) {
//    this.put("firstValue", firstValue);
//  }
//
//  /**
//   * Sets the efAlphabeticValueSurfaceForm.
//   *
//   * @param efAlphabeticValueSurfaceForm the new efAlphabeticValueSurfaceForm
//   */
//  public void setEfAlphabeticValueSurfaceForm(final String efAlphabeticValueSurfaceForm) {
//    this.put("efAlphabeticValueSurfaceForm", efAlphabeticValueSurfaceForm);
//  }
//
//  /**
//   * Sets the secondValue.
//   *
//   * @param secondValue the new secondValue
//   */
//  public void setSecondValue(final String secondValue) {
//    this.put("secondValue", secondValue);
//  }
//
//  /**
//   * Sets the efTermSurfaceForm.
//   *
//   * @param efTermSurfaceForm the new efTermSurfaceForm
//   */
//  public void setEfTermSurfaceForm(final String efTermSurfaceForm) {
//    this.put("efTermSurfaceForm", efTermSurfaceForm);
//  }
//
//  /**
//   * Sets the efSuffixSurfaceForm.
//   *
//   * @param efSuffixSurfaceForm the new efSuffixSurfaceForm
//   */
//  public void setEfSuffixSurfaceForm(final String efSuffixSurfaceForm) {
//    this.put("efSuffixSurfaceForm", efSuffixSurfaceForm);
//  }
//
//  /**
//   * Sets the efSuffixNormalizedName.
//   *
//   * @param efSuffixNormalizedName the new efSuffixNormalizedName
//   */
//  public void setEfSuffixNormalizedName(final String efSuffixNormalizedName) {
//    this.put("efSuffixNormalizedName", efSuffixNormalizedName);
//  }
//
//  /**
//   * Sets the efAlphabeticValueNormalizedName.
//   *
//   * @param efAlphabeticValueNormalizedName the new efAlphabeticValueNormalizedName
//   */
//  public void setEfAlphabeticValueNormalizedName(final String efAlphabeticValueNormalizedName) {
//    this.put("efAlphabeticValueNormalizedName", efAlphabeticValueNormalizedName);
//  }
//
//  /**
//   * Sets the efTermNormalizedName.
//   *
//   * @param efTermNormalizedName the new efTermNormalizedName
//   */
//  public void setEfTermNormalizedName(final String efTermNormalizedName) {
//    this.put("efTermNormalizedName", efTermNormalizedName);
//  }
//
//  /**
//   * Sets the isRange.
//   *
//   * @param isRange the new isRange
//   */
//  public void setIsRange(final String isRange) {
//    this.put("isRange", isRange);
//  }
//
//  /**
//   * Sets the sectionSurfaceForm.
//   *
//   * @param sectionSurfaceForm the new sectionSurfaceForm
//   */
//  public void setSectionSurfaceForm(final String sectionSurfaceForm) {
//    this.put("sectionSurfaceForm", sectionSurfaceForm);
//  }
//
//
//  /**
//   * Sets the sectionNormalizedName.
//   *
//   * @param sectionNormalizedName the new sectionNormalizedName
//   */
//  public void setSectionNormalizedName(final String sectionNormalizedName) {
//    this.put("sectionNormalizedName", sectionNormalizedName);
//  }

}
