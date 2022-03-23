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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.ibm.cloud.sdk.core.service.model.DynamicModel;
import com.ibm.watson.health.acd.v1.util.CustomCollection;

/**
 * AttributeValueAnnotation.
 */
public class AttributeValueAnnotation extends DynamicModel<Object> {

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
  @SerializedName("preferredName")
  protected String preferredName;
  @SerializedName("values")
  protected List<Map> values;
  @SerializedName("source")
  protected String source;
  @SerializedName("sourceVersion")
  protected String sourceVersion;
  @SerializedName("concept")
  protected Concept concept;
  @SerializedName("name")
  protected String name;
  @SerializedName("sectionNormalizedName")
  protected String sectionNormalizedName;
  @SerializedName("sectionSurfaceForm")
  protected String sectionSurfaceForm;
  @SerializedName("icd9Code")
  protected String icd9Code;
  @SerializedName("icd10Code")
  protected String icd10Code;
  @SerializedName("snomedConceptId")
  protected String snomedConceptId;
  @SerializedName("nciCode")
  protected String nciCode;
  @SerializedName("meshId")
  protected String meshId;
  @SerializedName("rxNormId")
  protected String rxNormId;
  @SerializedName("loincId")
  protected String loincId;
  @SerializedName("vocabs")
  protected String vocabs;
  @SerializedName("cptCode")
  protected String cptCode;
  @SerializedName("ccsCode")
  protected String ccsCode;
  @SerializedName("hccCode")
  protected String hccCode;
  @SerializedName("disambiguationData")
  protected Disambiguation disambiguationData;
  @SerializedName("insightModelData")
  protected InsightModelData insightModelData;
  @SerializedName("ruleId")
  protected String ruleId;
  @SerializedName("derivedFrom")
  protected List<Concept> derivedFrom;
  @SerializedName("temporal")
  protected List<Temporal> temporal;
  @SerializedName("evidenceSpans")
  protected List<Reference> evidenceSpans;

  public AttributeValueAnnotation() {
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
   * Gets the preferredName.
   *
   * @return the preferredName
   */
  public String getPreferredName() {
    return this.preferredName;
  }

  /**
   * Gets the values.
   *
   * @return the values
   */
  public List<CustomCollection> getValues() {
    List<Object> listObjects = new ArrayList<Object>();
    for (Map map : this.values) {
    	Gson gson = new Gson();
    	JsonElement jsonElement = gson.toJsonTree(map);
    	Object mapObj = gson.fromJson(jsonElement, Object.class);
    	listObjects.add(mapObj);
    }
    CustomCollection customCollection = new CustomCollection();
    List<CustomCollection> listValues = customCollection.convertToCustomCollectionList(listObjects);
    return listValues;
  }

  /*
   *
   * Manually Added code
   *
   * */
  public CustomCollection getValues(int index) {
    List<Object> listObjects = new ArrayList<Object>();
    for (Map map : this.values) {
    	Gson gson = new Gson();
    	JsonElement jsonElement = gson.toJsonTree(map);
    	Object mapObj = gson.fromJson(jsonElement, Object.class);
    	listObjects.add(mapObj);
    }
    CustomCollection customCollection = new CustomCollection();
    CustomCollection values = customCollection.convertToCustomCollection(listObjects.get(index));
    return values;
  }

  /**
   * Gets the source.
   *
   * @return the source
   */
  public String getSource() {
    return this.source;
  }

  /**
   * Gets the sourceVersion.
   *
   * @return the sourceVersion
   */
  public String getSourceVersion() {
    return this.sourceVersion;
  }

  /**
   * Gets the concept.
   *
   * @return the concept
   */
  public Concept getConcept() {
      return this.concept;
    }

  /**
   * Gets the name.
   *
   * @return the name
   */
  public String getName() {
    return this.name;
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
   * Get icd9 code or null.
   * @return the icd9 code
   */
  public String getIcd9Code() {
    return this.icd9Code;
  }

  /**
   * Get icd10 code or null.
   * @return t he icd10 code
   */
  public String getIcd10Code() {
    return this.icd10Code;
  }

  /**
   * Get snomed code or null.
   * @return the snomed identifier
   */
  public String getSnomedConceptId() {
    return this.snomedConceptId;
  }

  /**
   * Get snomed nci code or null.
   * @return the nci code
   */
  public String getNciCode() {
    return this.nciCode;
  }

  /**
   * Get Medical Subject Heading id or null.
   * @return the mesh identifier
   */
  public String getMeshId() {
    return this.meshId;
  }

  /**
   * Get Rx norm id or null.
   * @return the rx norm identifier
   */
  public String getRxNormId() {
    return this.rxNormId;
  }

  /**
   * Get Loinc id or null.
   * @return the loinc identifier
   */
  public String getLoincId() {
    return this.loincId;
  }

  /**
   * Get vocabularies or null.
   * @return artifact vocabs
   */
  public String getVocabs() {
    return this.vocabs;
  }

  /**
   * Gets the getCptCode.
   * @return the getCptCode
   */
  public String getCptCode() {
    return this.cptCode;
  }

  /**
   * Gets the getCcsCode.
   * @return the getCcsCode
   */
  public String getCcsCode() {
    return this.ccsCode;
  }

  /**
   * Gets the getHccCode.
   * @return the getHccCode
   */
  public String getHccCode() {
    return this.hccCode;
  }

  /**
   * Gets the getdisambiguationData.
   * @return the getDisambiguationData
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
   * Gets the ruleId.
   * @return the ruleId
   */
  public String getRuleId() {
    return this.ruleId;
  }

  /**
   * Gets the derivedFrom.
   *
   * @return the derivedFrom
   */
  public List<Concept> getDerivedFrom() {
	  return this.derivedFrom;
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
   * Gets the evidenceSpans.
   *
   * @return the evidenceSpans
   */
  public List<Reference> getEvidenceSpans() {
	  return this.evidenceSpans;
  }

  /**
   * Sets the id.
   *
   * @param id the new id
   */
  public void setId(final String id) {
    this.id = id;
  }

  /**
   * Sets the type.
   *
   * @param type the new type
   */
  public void setType(final String type) {
    this.type = type;
  }

  /**
   * Sets the uid.
   *
   * @param uid the new uid
   */
  public void setUid(final Long uid) {
    this.uid = uid;
  }

  /**
   * Sets the begin.
   *
   * @param begin the new begin
   */
  public void setBegin(final Long begin) {
    this.begin = begin;
  }

  /**
   * Sets the end.
   *
   * @param end the new end
   */
  public void setEnd(final Long end) {
    this.end = end;
  }

  /**
   * Sets the coveredText.
   *
   * @param coveredText the new coveredText
   */
  public void setCoveredText(final String coveredText) {
    this.coveredText = coveredText;
  }

  /**
   * Sets the negated.
   *
   * @param negated the new negated
   */
  public void setNegated(final Boolean negated) {
    this.negated = negated;
  }

  /**
   * Sets the hypothetical.
   *
   * @param hypothetical the new hypothetical
   */
  public void setHypothetical(final Boolean hypothetical) {
    this.hypothetical = hypothetical;
  }

  /**
   * Sets the preferredName.
   *
   * @param preferredName the new preferredName
   */
  public void setPreferredName(final String preferredName) {
    this.preferredName = preferredName;
  }

  /**
   * Sets the values.
   *
   * @param values the new values
   */
  public void setValues(final List<Map> values) {
    this.values = values;
  }

  /**
   * Sets the source.
   *
   * @param source the new source
   */
  public void setSource(final String source) {
    this.source = source;
  }

  /**
   * Sets the sourceVersion.
   *
   * @param sourceVersion the new sourceVersion
   */
  public void setSourceVersion(final String sourceVersion) {
    this.sourceVersion = sourceVersion;
  }

  /**
   * Sets the concept.
   *
   * @param concept the new concept
   */
  public void setConcept(final Concept concept) {
      this.concept = concept;
    }

  /**
   * Sets the name.
   *
   * @param name the new name
   */
  public void setName(final String name) {
    this.name = name;
  }


  /**
   * Sets the sectionSurfaceForm.
   *
   * @param sectionSurfaceForm the new sectionSurfaceForm
   */
  public void setSectionSurfaceForm(final String sectionSurfaceForm) {
    this.sectionSurfaceForm = sectionSurfaceForm;
  }


  /**
   * Sets the sectionNormalizedName.
   *
   * @param sectionNormalizedName the new sectionNormalizedName
   */
  public void setSectionNormalizedName(final String sectionNormalizedName) {
    this.sectionNormalizedName = sectionNormalizedName;
  }


  /**
   * Sets the icd 9 code.
   *
   * @param icd9Code the new icd 9 Code
   */
  public void setIcd9Code(final String icd9Code) {
  this.icd9Code = icd9Code;
  }

  /**
   * Sets the icd 10 code.
   *
   * @param icd10Code the new icd 10 code
   */
  public void setIcd10Code(final String icd10Code) {
    this.icd10Code = icd10Code;
  }

  /**
   * Sets the snomed concept id.
   *
   * @param snomedConceptId the new snomed concept id
   */
  public void setSnomedConceptId(final String snomedConceptId) {
    this.snomedConceptId = snomedConceptId;
  }

  /**
   * Sets the nci code.
   *
   * @param nciCode the new nci code
   */
  public void setNciCode(final String nciCode) {
    this.nciCode = nciCode;
  }

  /**
   * Sets the mesh id.
   *
   * @param meshId the new mesh id
   */
  public void setMeshId(final String meshId) {
    this.meshId = meshId;
  }

  /**
   * Sets the rx norm id.
   *
   * @param rxNormId the new rx norm id
   */
  public void setRxNormId(final String rxNormId) {
    this.rxNormId = rxNormId;
  }

  /**
   * Sets the loinc id.
   *
   * @param loincId the new loinc id
   */
  public void setLoincId(final String loincId) {
    this.loincId = loincId;
  }

  /**
   * Sets the vocabs.
   *
   * @param vocabs the new vocabs id
   */
  public void setVocabs(final String vocabs) {
    this.vocabs = vocabs;
  }

  /**
   * Sets the cpt code.
   *
   * @param cptCode the new cpt code
   */
  public void setCptCode(final String cptCode) {
    this.cptCode = cptCode;
  }

  /**
   * Sets the ccs code.
   *
   * @param ccsCode the new ccs code
   */
  public void setCcsCode(final String ccsCode) {
    this.ccsCode = ccsCode;
  }

  /**
   * Sets the hcc code.
   *
   * @param hccCode the new hcc code
   */
  public void setHccCode(final String hccCode) {
    this.hccCode = hccCode;
  }

  /**
   * Sets the disambiguation data.
   *
   * @param disambiguationData the new disambiguation data
   */
  public void setDisambiguationData(final Disambiguation disambiguationData) {
      this.disambiguationData = disambiguationData;
  }

  /**
   * Sets the insightModelData.
   *
   * @param insightModelData the new insightModelData
   */
  public void setInsightModelData(final InsightModelData insightModelData) {
      this.insightModelData = insightModelData;
  }

  /**
   * Sets the ruleId.
   *
   * @param ruleId the new rule Id
   */
  public void setRuleId(final String ruleId) {
    this.ruleId = ruleId;
  }

  /**
   * Sets the derivedFrom.
   *
   * @param derivedFrom the new derivedFrom
   */
  public void setDerivedFrom(final List<Concept> derivedFrom) {
    this.derivedFrom = derivedFrom;
  }

  /**
   * Sets the temporal.
   *
   * @param temporal the new temporal
   */
  public void setTemporal(final List<Temporal> temporal) {
    this.temporal = temporal;
  }

  /**
   * Sets the evidenceSpans.
   *
   * @param evidenceSpans the new evidenceSpans
   */
  public void setEvidenceSpans(final List<Reference> evidenceSpans) {
    this.evidenceSpans = evidenceSpans;
  }

}
