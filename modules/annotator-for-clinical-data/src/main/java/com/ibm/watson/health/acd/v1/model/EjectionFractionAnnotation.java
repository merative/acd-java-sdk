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

import com.ibm.cloud.sdk.core.service.model.GenericModel;


/**
 * EjectionFractionAnnotation.
 */
public class EjectionFractionAnnotation extends GenericModel {
  private String idType;
  private String typeType;
  private Long uidType;
  private Long beginType;
  private Long endType;
  private String coveredTextType;
  private Boolean negatedType;
  private Boolean hypotheticalType;
  private String firstValueType;
  private String efAlphabeticValueSurfaceFormType;
  private String secondValueType;
  private String efTermSurfaceFormType;
  private String efSuffixSurfaceFormType;
  private String efSuffixNormalizedNameType;
  private String efAlphabeticValueNormalizedNameType;
  private String efTermNormalizedNameType;
  private String isRangeType;
  private String sectionNormalizedNameType;
  private String sectionSurfaceFormType;


  /**
   * Gets the id.
   *
   * @return the id
   */
  public String getId() {
    return idType;
  }

  /**
   * Gets the type.
   *
   * @return the type
   */
  public String getType() {
    return typeType;
  }

  /**
   * Gets the uid.
   *
   * @return the uid
   */
  public Long getUid() {
    return uidType;
  }

  /**
   * Gets the begin.
   *
   * @return the begin
   */
  public Long getBegin() {
    return beginType;
  }

  /**
   * Gets the end.
   *
   * @return the end
   */
  public Long getEnd() {
    return endType;
  }

  /**
   * Gets the coveredText.
   *
   * @return the coveredText
   */
  public String getCoveredText() {
    return coveredTextType;
  }

  /**
   * Gets the negated.
   *
   * @return the negated
   */
  public Boolean isNegated() {
    return negatedType;
  }

  /**
   * Gets the hypothetical.
   *
   * @return the hypothetical
   */
  public Boolean isHypothetical() {
    return hypotheticalType;
  }

  /**
   * Gets the firstValue.
   *
   * @return the firstValue
   */
  public String getFirstValue() {
    return firstValueType;
  }

  /**
   * Gets the efAlphabeticValueSurfaceForm.
   *
   * @return the efAlphabeticValueSurfaceForm
   */
  public String getEfAlphabeticValueSurfaceForm() {
    return efAlphabeticValueSurfaceFormType;
  }

  /**
   * Gets the secondValue.
   *
   * @return the secondValue
   */
  public String getSecondValue() {
    return secondValueType;
  }

  /**
   * Gets the efTermSurfaceForm.
   *
   * @return the efTermSurfaceForm
   */
  public String getEfTermSurfaceForm() {
    return efTermSurfaceFormType;
  }

  /**
   * Gets the efSuffixSurfaceForm.
   *
   * @return the efSuffixSurfaceForm
   */
  public String getEfSuffixSurfaceForm() {
    return efSuffixSurfaceFormType;
  }

  /**
   * Gets the efSuffixNormalizedName.
   *
   * @return the efSuffixNormalizedName
   */
  public String getEfSuffixNormalizedName() {
    return efSuffixNormalizedNameType;
  }

  /**
   * Gets the efAlphabeticValueNormalizedName.
   *
   * @return the efAlphabeticValueNormalizedName
   */
  public String getEfAlphabeticValueNormalizedName() {
    return efAlphabeticValueNormalizedNameType;
  }

  /**
   * Gets the efTermNormalizedName.
   *
   * @return the efTermNormalizedName
   */
  public String getEfTermNormalizedName() {
    return efTermNormalizedNameType;
  }

  /**
   * Gets the isRange.
   *
   * @return the isRange
   */
  public String getIsRange() {
    return isRangeType;
  }

  /**
   * Gets the sectionNormalizedName.
   *
   * @return the sectionNormalizedName
   */
  public String getSectionNormalizedName() {
    return sectionNormalizedNameType;
  }

  /**
   * Gets the sectionSurfaceForm.
   *
   * @return the sectionSurfaceForm
   */
  public String getSectionSurfaceForm() {
    return sectionSurfaceFormType;
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
