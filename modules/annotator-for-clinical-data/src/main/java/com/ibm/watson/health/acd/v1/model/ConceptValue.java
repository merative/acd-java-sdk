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
 * ConceptValue.
 */
public class ConceptValue extends GenericModel {
  private String idType;
  private String typeType;
  private Long uidType;
  private Long beginType;
  private Long endType;
  private String coveredTextType;
  private Boolean negatedType;
  private Boolean hypotheticalType;
  private Long cuiType;
  private String dimensionType;
  private String preferredNameType;
  private String triggerType;
  private String sourceType;
  private String valueType;
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
   * Gets the cui.
   *
   * @return the cui
   */
  public Long getCui() {
    return cuiType;
  }

  /**
   * Gets the dimension.
   *
   * @return the dimension
   */
  public String getDimension() {
    return dimensionType;
  }

  /**
   * Gets the preferredName.
   *
   * @return the preferredName
   */
  public String getPreferredName() {
    return preferredNameType;
  }

  /**
   * Gets the trigger.
   *
   * @return the trigger
   */
  public String getTrigger() {
    return triggerType;
  }

  /**
   * Gets the source.
   *
   * @return the source
   */
  public String getSource() {
    return sourceType;
  }

  /**
   * Gets the value.
   *
   * @return the value
   */
  public String getValue() {
    return valueType;
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
//   * Sets the cui.
//   *
//   * @param cui the new cui
//   */
//  public void setCui(final Long cui) {
//    this.put("cui", cui);
//  }
//
//  /**
//   * Sets the dimension.
//   *
//   * @param dimension the new dimension
//   */
//  public void setDimension(final String dimension) {
//    this.put("dimension", dimension);
//  }
//
//  /**
//   * Sets the preferredName.
//   *
//   * @param preferredName the new preferredName
//   */
//  public void setPreferredName(final String preferredName) {
//    this.put("preferredName", preferredName);
//  }
//
//  /**
//   * Sets the trigger.
//   *
//   * @param trigger the new trigger
//   */
//  public void setTrigger(final String trigger) {
//    this.put("trigger", trigger);
//  }
//
//  /**
//   * Sets the source.
//   *
//   * @param source the new source
//   */
//  public void setSource(final String source) {
//    this.put("source", source);
//  }
//
//  /**
//   * Sets the value.
//   *
//   * @param value the new value
//   */
//  public void setValue(final String value) {
//    this.put("value", value);
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
