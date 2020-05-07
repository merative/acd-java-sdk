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
 * Concept.
 */
public class Concept<Type> extends GenericModel {
  private String idType;
  private String typeType;
  private Long uidType;
  private Long beginType ;
  private Long endType;
  private String coveredTextType;
  private Boolean negatedType;
  private Boolean hypotheticalType;
  private String cuiType;
  private String preferredNameType;
  private String semanticTypeType;
  private String sourceType;
  private String sourceVersionType;
  private Disambiguation disambiguationDataType;
  private String sectionNormalizedNameType;
  private String sectionSurfaceFormType;

  private String icd9CodeType;
  private String icd10CodeType;
  private String snomedConceptIdType;
  private String nciCodeType;
  private String meshIdType;
  private String rxNormIdType;
  private String loincIdType;
  private String vocabsType;
  private String cptCodeType;

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
   * Gets the preferredName.
   *
   * @return the preferredName
   */
  public String getPreferredName() {
    return preferredNameType;
  }

  /**
   * Gets the semanticType.
   *
   * @return the semanticType
   */
  public String getSemanticType() {
    return semanticTypeType;
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
   * Gets the sourceVersion.
   *
   * @return the sourceVersion
   */
  public String getSourceVersion() {
    return sourceVersionType;
  }

  /**
   * Gets the disambiguationData.
   *
   * @return the disambiguationData
   */
  public Disambiguation getDisambiguationData() {
    return disambiguationDataType;
  }

  /**
   * Gets the sectionNormalizedName.
   *
   * @return the sectionNormalizedName
   */
  public String getSectionNormalizedName() {
    return  sectionNormalizedNameType;
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
   * Gets the getIcd9Code.
   * @return the getIcd9Code
   */
  public String getIcd9Code() {
    return icd9CodeType;
  }

  /**
   * Gets the getIcd10CodeForm.
   * @return the getIcd10CodeForm
   */
  public String getIcd10Code() {
    return icd10CodeType;
  }

  /**
   * Gets the getSnomedConceptId.
   * @return the getSnomedConceptId
   */
  public String getSnomedConceptId() {
    return snomedConceptIdType;
  }

  /**
   * Gets the getNciCode.
   * @return the getNciCode
   */
  public String getNciCode() {
    return nciCodeType;
  }

  /**
   * Gets the getCptCode.
   * @return the getCptCode
   */
  public String getCptCode() {
    return cptCodeType;
  }

  /**
   * Gets the getMeshId.
   * @return the getMeshId
   */
  public String getMeshId() {
    return meshIdType;
  }

  /**
   * Gets the getRxNormId.
   * @return the getRxNormId
   */
  public String getRxNormId() {
   return rxNormIdType;
  }

  /**
   * Gets the getLoincId.
   * @return the getLoincId
   */
  public String getLoincId() {
    return loincIdType;
  }

  /**
   * Gets the getVocabs.
   * @return the getVocabs
   */
  public String getVocabs() {
   return vocabsType;
  }
}
