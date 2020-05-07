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

import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import com.ibm.watson.health.acd.v1.util.CustomCollection;

/**
 * AttributeValueAnnotation.
 */
public class AttributeValueAnnotation extends GenericModel {

  private String idType;
  private String typeType;
  private Long uidType;
  private Long beginType;
  private Long endType;
  private String coveredTextType;
  private Boolean negatedType;
  private Boolean hypotheticalType;
  private String preferredNameType;
  private List<CustomCollection> valuesType;
  private String sourceType;
  private String sourceVersionType;
  private Concept conceptType;
  private String nameType;
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
   * Gets the preferredName.
   *
   * @return the preferredName
   */
  public String getPreferredName() {
    return preferredNameType;
  }

  /**
   * Gets the values.
   *
   * @return the values
   */
  public List<CustomCollection> getValues() {
    return valuesType;
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
   * Gets the concept.
   *
   * @return the concept
   */
  public Concept getConcept() {
      return conceptType;
    }

  /**
   * Gets the name.
   *
   * @return the name
   */
  public String getName() {
    return nameType;
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

  /**
   * Get icd9 code or null.
   * @return the icd9 code
   */
  public String getIcd9Code() {
    return icd9CodeType;
  }

  /**
   * Get icd10 code or null.
   * @return t he icd10 code
   */
  public String getIcd10Code() {
    return icd10CodeType;
  }

  /**
   * Get snomed code or null.
   * @return the snomed identifier
   */
  public String getSnomedConceptId() {
    return snomedConceptIdType;
  }

  /**
   * Get snomed nci code or null.
   * @return the nci code
   */
  public String getNciCode() {
    return nciCodeType;
  }

  /**
   * Get Medical Subject Heading id or null.
   * @return mesh id
   */
  public String getMeshId() {
    return meshIdType;
  }

  /**
   * Get Rx norm id or null.
   * @return rx norm id
   */
  public String getRxNormId() {
    return rxNormIdType;
  }

  /**
   * Get Loinc id or null.
   * @return the loinc identifier
   */
  public String getLoincId() {
    return loincIdType;
  }

  /**
   * Get vocabularies or null.
   * @return artifact vocabs
   */
  public String getVocabs() {
    return vocabsType;
  }

  /**
   * Gets the getCptCode.
   * @return the getCptCode
   */
  public String getCptCode() {
    return cptCodeType;
  }

  /**
   * Gets the getdisambiguationData.
   * @return the getDisambiguationData
   */
  public Disambiguation getDisambiguationData() {
    return disambiguationDataType;
  }
}
