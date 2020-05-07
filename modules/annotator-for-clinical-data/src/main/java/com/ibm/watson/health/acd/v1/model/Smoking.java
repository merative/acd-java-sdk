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
 * Smoking.
 */
public class Smoking extends GenericModel {
  private String idType;
  private String typeType;
  private Long uidType;
  private Long beginType;
  private Long endType;
  private String coveredTextType;
  private Boolean negatedType;
  private Boolean hypotheticalType;
  private String participationType;
  private String sectionNormalizedNameType;
  private String modalityType;
  private String currentType;
  private String smokeTermSurfaceFormType;
  private String smokeTermNormalizedNameType;
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
   * Gets the participation.
   *
   * @return the participation
   */
  public String getParticipation() {
    return participationType;
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
   * Gets the modality.
   *
   * @return the modality
   */
  public String getModality() {
    return modalityType;
  }

  /**
   * Gets the current.
   *
   * @return the current
   */
  public String getCurrent() {
    return currentType;
  }

  /**
   * Gets the smokeTermSurfaceForm.
   *
   * @return the smokeTermSurfaceForm
   */
  public String getSmokeTermSurfaceForm() {
    return smokeTermSurfaceFormType;
  }

  /**
   * Gets the smokeTermNormalizedName.
   *
   * @return the smokeTermNormalizedName
   */
  public String getSmokeTermNormalizedName() {
    return smokeTermNormalizedNameType;
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
//   * Sets the participation.
//   *
//   * @param participation the new participation
//   */
//  public void setParticipation(final String participation) {
//    this.put("participation", participation);
//  }
//
//  /**
//   * Sets the sectionNormalizedName.
//   *
//   * @param sectionNormalizedName the new sectionNormalizedName
//   */
//  public void setSectionNormalizedName(final String sectionNormalizedName) {
//    this.put("sectionNormalizedName", sectionNormalizedName);
//  }
//
//  /**
//   * Sets the modality.
//   *
//   * @param modality the new modality
//   */
//  public void setModality(final String modality) {
//    this.put("modality", modality);
//  }
//
//  /**
//   * Sets the current.
//   *
//   * @param current the new current
//   */
//  public void setCurrent(final String current) {
//    this.put("current", current);
//  }
//
//  /**
//   * Sets the smokeTermSurfaceForm.
//   *
//   * @param smokeTermSurfaceForm the new smokeTermSurfaceForm
//   */
//  public void setSmokeTermSurfaceForm(final String smokeTermSurfaceForm) {
//    this.put("smokeTermSurfaceForm", smokeTermSurfaceForm);
//  }
//
//  /**
//   * Sets the smokeTermNormalizedName.
//   *
//   * @param smokeTermNormalizedName the new smokeTermNormalizedName
//   */
//  public void setSmokeTermNormalizedName(final String smokeTermNormalizedName) {
//    this.put("smokeTermNormalizedName", smokeTermNormalizedName);
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
}
