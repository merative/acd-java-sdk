/*
 * Copyright 2018, 2022 IBM Corp. All Rights Reserved.
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

import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.ibm.cloud.sdk.core.service.model.DynamicModel;

/**
 * SymptomDisease.
 */
public class SymptomDisease extends DynamicModel<Object> {
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
  @SerializedName("cui")
  protected String cui;
  @SerializedName("icd10Code")
  protected String icd10Code;
  @SerializedName("sectionNormalizedName")
  protected String sectionNormalizedName;
  @SerializedName("modality")
  protected String modality;
  @SerializedName("symptomDiseaseSurfaceForm")
  protected String symptomDiseaseSurfaceForm;
  @SerializedName("dateInMilliseconds")
  protected String dateInMilliseconds;
  @SerializedName("snomedConceptId")
  protected String snomedConceptId;
  @SerializedName("ccsCode")
  protected String ccsCode;
  @SerializedName("symptomDiseaseNormalizedName")
  protected String symptomDiseaseNormalizedName;
  @SerializedName("sectionSurfaceForm")
  protected String sectionSurfaceForm;
  @SerializedName("icd9Code")
  protected String icd9Code;
  @SerializedName("hccCode")
  protected String hccCode;
  @SerializedName("disambiguationData")
  protected Disambiguation disambiguationData;
  @SerializedName("insightModelData")
  protected InsightModelData insightModelData;
  @SerializedName("temporal")
  protected List<Temporal> temporal;
  @SerializedName("date")
  protected String date;
  @SerializedName("dateSource")
  protected String dateSource;

  public SymptomDisease() {
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
   * Gets the cui.
   *
   * @return the cui
   */
  public String getCui() {
    return this.cui;
  }

  /**
   * Gets the icd10Code.
   *
   * @return the icd10Code
   */
  public String getIcd10Code() {
    return this.icd10Code;
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
   * Gets the modality.
   *
   * @return the modality
   */
  public String getModality() {
    return this.modality;
  }

  /**
   * Gets the symptomDiseaseSurfaceForm.
   *
   * @return the symptomDiseaseSurfaceForm
   */
  public String getSymptomDiseaseSurfaceForm() {
    return this.symptomDiseaseSurfaceForm;
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
   * Gets the snomedConceptId.
   *
   * @return the snomedConceptId
   */
  public String getSnomedConceptId() {
    return this.snomedConceptId;
  }

  /**
   * Gets the ccsCode.
   *
   * @return the ccsCode
   */
  public String getCcsCode() {
    return this.ccsCode;
  }

  /**
   * Gets the symptomDiseaseNormalizedName.
   *
   * @return the symptomDiseaseNormalizedName
   */
  public String getSymptomDiseaseNormalizedName() {
    return this.symptomDiseaseNormalizedName;
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
   * Gets the icd9Code.
   *
   * @return the icd9Code
   */
  public String getIcd9Code() {
    return this.icd9Code;
  }

  /**
   * Gets the hccCode.
   *
   * @return the hccCode
   */
  public String getHccCode() {
    return this.hccCode;
  }

  /**
   * Gets the disambiguationData.
   *
   * @return the disambiguationData
   */
  public Disambiguation getDisambiguationData() {
    return this.disambiguationData;
  }

  /**
   * Gets the insightModelData.
   * @return the insightModelData
   */
  public InsightModelData getInsightModelData() {
    return this.insightModelData;
  }

  /**
   * Gets the temporal.
   *
   * @return the temporal
   */
  public List<Temporal> getTemporal() {
	  return this.temporal;
  }

  /**
   * Gets the date.
   *
   * @return the date
   */
  public String getDate() {
    return this.date;
  }

  /**
   * Gets the dateSource.
   *
   * @return the dateSource
   */
  public String getDateSource() {
    return this.dateSource;
  }

}
