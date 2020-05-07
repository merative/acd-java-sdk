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
 * SymptomDisease.
 */
public class SymptomDisease extends GenericModel {
  private String idType;
  private String typeType;
  private Long uidType;
  private Long beginType;
  private Long endType;
  private String coveredTextType;
  private Boolean negatedType;
  private Boolean hypotheticalType;
  private String cuiType;
  private String icd10CodeType;
  private String sectionNormalizedNameType;
  private String modalityType;
  private String symptomDiseaseSurfaceFormType;
  private String dateInMillisecondsType;
  private String snomedConceptIdType;
  private String ccsCodeType;
  private String symptomDiseaseNormalizedNameType;
  private String sectionSurfaceFormType;
  private String icd9CodeType;
  private String hccCodeType;
  private Disambiguation disambiguationDataType;


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
  public String getCui() {
    return cuiType;
  }

  /**
   * Gets the icd10Code.
   *
   * @return the icd10Code
   */
  public String getIcd10Code() {
    return icd10CodeType;
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
   * Gets the symptomDiseaseSurfaceForm.
   *
   * @return the symptomDiseaseSurfaceForm
   */
  public String getSymptomDiseaseSurfaceForm() {
    return symptomDiseaseSurfaceFormType;
  }

  /**
   * Gets the dateInMilliseconds.
   *
   * @return the dateInMilliseconds
   */
  public String getDateInMilliseconds() {
    return dateInMillisecondsType;
  }

  /**
   * Gets the snomedConceptId.
   *
   * @return the snomedConceptId
   */
  public String getSnomedConceptId() {
    return snomedConceptIdType;
  }

  /**
   * Gets the ccsCode.
   *
   * @return the ccsCode
   */
  public String getCcsCode() {
    return ccsCodeType;
  }

  /**
   * Gets the symptomDiseaseNormalizedName.
   *
   * @return the symptomDiseaseNormalizedName
   */
  public String getSymptomDiseaseNormalizedName() {
    return symptomDiseaseNormalizedNameType;
  }

  /**
   * Gets the sectionSurfaceForm.
   *
   * @return the sectionSurfaceForm
   */
  public String getSectionSurfaceForm() {
    return sectionSurfaceFormType;
  }

  /**
   * Gets the icd9Code.
   *
   * @return the icd9Code
   */
  public String getIcd9Code() {
    return icd9CodeType;
  }

  /**
   * Gets the hccCode.
   *
   * @return the hccCode
   */
  public String getHccCode() {
    return hccCodeType;
  }

  /**
   * Gets the disambiguationData.
   *
   * @return the disambiguationData
   */
  public Disambiguation getDisambiguationData() {
    return disambiguationDataType;
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
//  public void setCui(final String cui) {
//    this.put("cui", cui);
//  }
//
//  /**
//   * Sets the icd10Code.
//   *
//   * @param icd10Code the new icd10Code
//   */
//  public void setIcd10Code(final String icd10Code) {
//    this.put("icd10Code", icd10Code);
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
//   * Sets the symptomDiseaseSurfaceForm.
//   *
//   * @param symptomDiseaseSurfaceForm the new symptomDiseaseSurfaceForm
//   */
//  public void setSymptomDiseaseSurfaceForm(final String symptomDiseaseSurfaceForm) {
//    this.put("symptomDiseaseSurfaceForm", symptomDiseaseSurfaceForm);
//  }
//
//  /**
//   * Sets the dateInMilliseconds.
//   *
//   * @param dateInMilliseconds the new dateInMilliseconds
//   */
//  public void setDateInMilliseconds(final String dateInMilliseconds) {
//    this.put("dateInMilliseconds", dateInMilliseconds);
//  }
//
//  /**
//   * Sets the snomedConceptId.
//   *
//   * @param snomedConceptId the new snomedConceptId
//   */
//  public void setSnomedConceptId(final String snomedConceptId) {
//    this.put("snomedConceptId", snomedConceptId);
//  }
//
//  /**
//   * Sets the ccsCode.
//   *
//   * @param ccsCode the new ccsCode
//   */
//  public void setCcsCode(final String ccsCode) {
//    this.put("ccsCode", ccsCode);
//  }
//
//  /**
//   * Sets the symptomDiseaseNormalizedName.
//   *
//   * @param symptomDiseaseNormalizedName the new symptomDiseaseNormalizedName
//   */
//  public void setSymptomDiseaseNormalizedName(final String symptomDiseaseNormalizedName) {
//    this.put("symptomDiseaseNormalizedName", symptomDiseaseNormalizedName);
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
//  /**
//   * Sets the icd9Code.
//   *
//   * @param icd9Code the new icd9Code
//   */
//  public void setIcd9Code(final String icd9Code) {
//    this.put("icd9Code", icd9Code);
//  }
//
//  /**
//   * Sets the hccCode.
//   *
//   * @param hccCode the new hccCode
//   */
//  public void setHccCode(final String hccCode) {
//    this.put("hccCode", hccCode);
//  }
//
//  /**
//   * Sets the disambiguationData.
//   *
//   * @param disambiguationData the new disambiguationData
//   */
//  public void setDisambiguationData(final Disambiguation disambiguationData) {
//    this.put("disambiguationData", disambiguationData);
//  }
}
