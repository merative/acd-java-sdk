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
 * Concept.
 */
public class Concept extends DynamicModel {
  private Type idType = new TypeToken<String>() { } .getType();
  private Type typeType = new TypeToken<String>() { } .getType();
  private Type uidType = new TypeToken<Long>() { } .getType();
  private Type beginType = new TypeToken<Long>() { } .getType();
  private Type endType = new TypeToken<Long>() { } .getType();
  private Type coveredTextType = new TypeToken<String>() { } .getType();
  private Type negatedType = new TypeToken<Boolean>() { } .getType();
  private Type hypotheticalType = new TypeToken<Boolean>() { } .getType();
  private Type cuiType = new TypeToken<String>() { } .getType();
  private Type preferredNameType = new TypeToken<String>() { } .getType();
  private Type semanticTypeType = new TypeToken<String>() { } .getType();
  private Type sourceType = new TypeToken<String>() { } .getType();
  private Type sourceVersionType = new TypeToken<String>() { } .getType();
  private Type disambiguationDataType = new TypeToken<Disambiguation>() { } .getType();
  private Type sectionNormalizedNameType = new TypeToken<String>() { } .getType();
  private Type sectionSurfaceFormType = new TypeToken<String>() { } .getType();

  private Type icd9CodeType = new TypeToken<String>() { } .getType();
  private Type icd10CodeType = new TypeToken<String>() { } .getType();
  private Type snomedConceptIdType = new TypeToken<String>() { } .getType();
  private Type nciCodeType = new TypeToken<String>() { } .getType();
  private Type meshIdType = new TypeToken<String>() { } .getType();
  private Type rxNormIdType = new TypeToken<String>() { } .getType();
  private Type loincIdType = new TypeToken<String>() { } .getType();
  private Type vocabsType = new TypeToken<String>() { } .getType();
  private Type cptCodeType = new TypeToken<String>() { } .getType();




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
   * Gets the cui.
   *
   * @return the cui
   */
  public String getCui() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("cui"), cuiType);
  }

  /**
   * Gets the preferredName.
   *
   * @return the preferredName
   */
  public String getPreferredName() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("preferredName"), preferredNameType);
  }

  /**
   * Gets the semanticType.
   *
   * @return the semanticType
   */
  public String getSemanticType() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("semanticType"), semanticTypeType);
  }

  /**
   * Gets the source.
   *
   * @return the source
   */
  public String getSource() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("source"), sourceType);
  }

  /**
   * Gets the sourceVersion.
   *
   * @return the sourceVersion
   */
  public String getSourceVersion() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("sourceVersion"), sourceVersionType);
  }

  /**
   * Gets the disambiguationData.
   *
   * @return the disambiguationData
   */
  public Disambiguation getDisambiguationData() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("disambiguationData"), disambiguationDataType);
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


  /**
   * Gets the getIcd9Code.
   * @return the getIcd9Code
   */
  public String getIcd9Code() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("icd9Code"), icd9CodeType);
  }

  /**
   * Gets the getIcd10CodeForm.
   * @return the getIcd10CodeForm
   */
  public String getIcd10Code() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("icd10Code"), icd10CodeType);
  }

  /**
   * Gets the getSnomedConceptId.
   * @return the getSnomedConceptId
   */
  public String getSnomedConceptId() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("snomedConceptId"), snomedConceptIdType);
  }

  /**
   * Gets the getNciCode.
   * @return the getNciCode
   */
  public String getNciCode() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("nciCode"), nciCodeType);
  }

  /**
   * Gets the getCptCode.
   * @return the getCptCode
   */
  public String getCptCode() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("cptCode"), cptCodeType);
  }

  /**
   * Gets the getMeshId.
   * @return the getMeshId
   */
  public String getMeshId() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("meshId"), meshIdType);
  }

  /**
   * Gets the getRxNormId.
   * @return the getRxNormId
   */
  public String getRxNormId() {
   return GsonSerializationHelper.serializeDynamicModelProperty(this.get("rxNormId"), rxNormIdType);
  }

  /**
   * Gets the getLoincId.
   * @return the getLoincId
   */
  public String getLoincId() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("loincId"), loincIdType);
  }

  /**
   * Gets the getVocabs.
   * @return the getVocabs
   */
  public String getVocabs() {
   return GsonSerializationHelper.serializeDynamicModelProperty(this.get("vocabs"), vocabsType);
  }



  /**
   * Sets the id.
   *
   * @param id the new id
   */
  public void setId(final String id) {
    this.put("id", id);
  }

  /**
   * Sets the type.
   *
   * @param type the new type
   */
  public void setType(final String type) {
    this.put("type", type);
  }

  /**
   * Sets the uid.
   *
   * @param uid the new uid
   */
  public void setUid(final Long uid) {
    this.put("uid", uid);
  }

  /**
   * Sets the begin.
   *
   * @param begin the new begin
   */
  public void setBegin(final Long begin) {
    this.put("begin", begin);
  }

  /**
   * Sets the end.
   *
   * @param end the new end
   */
  public void setEnd(final Long end) {
    this.put("end", end);
  }

  /**
   * Sets the coveredText.
   *
   * @param coveredText the new coveredText
   */
  public void setCoveredText(final String coveredText) {
    this.put("coveredText", coveredText);
  }

  /**
   * Sets the negated.
   *
   * @param negated the new negated
   */
  public void setNegated(final Boolean negated) {
    this.put("negated", negated);
  }

  /**
   * Sets the hypothetical.
   *
   * @param hypothetical the new hypothetical
   */
  public void setHypothetical(final Boolean hypothetical) {
    this.put("hypothetical", hypothetical);
  }

  /**
   * Sets the cui.
   *
   * @param cui the new cui
   */
  public void setCui(final Long cui) {
    this.put("cui", cui);
  }

  /**
   * Sets the preferredName.
   *
   * @param preferredName the new preferredName
   */
  public void setPreferredName(final String preferredName) {
    this.put("preferredName", preferredName);
  }

  /**
   * Sets the semanticType.
   *
   * @param semanticType the new semanticType
   */
  public void setSemanticType(final String semanticType) {
    this.put("semanticType", semanticType);
  }

  /**
   * Sets the source.
   *
   * @param source the new source
   */
  public void setSource(final String source) {
    this.put("source", source);
  }

  /**
   * Sets the sourceVersion.
   *
   * @param sourceVersion the new sourceVersion
   */
  public void setSourceVersion(final String sourceVersion) {
    this.put("sourceVersion", sourceVersion);
  }

  /**
   * Sets the disambiguationData.
   *
   * @param disambiguationData the new disambiguationData
   */
  public void setDisambiguationData(final Disambiguation disambiguationData) {
    this.put("disambiguationData", disambiguationData);
  }

  /**
   * Sets the icd 9 code.
   *
   * @param icd9Code the new icd 9 Code
   */
  public void setIcd9Code(final String icd9Code) {
  this.put("icd9Code", icd9Code);
  }

  /**
   * Sets the icd 10 code.
   *
   * @param icd10Code the new icd 10 code
   */
  public void setIcd10Code(final String icd10Code) {
    this.put("icd10Code", icd10Code);
  }

  /**
   * Sets the snomed concept id.
   *
   * @param snomedConceptId the new snomed concept id
   */
  public void setSnomedConceptId(final String snomedConceptId) {
    this.put("snomedConceptId", snomedConceptId);
  }

  /**
   * Sets the nci code.
   *
   * @param nciCode the new nci code
   */
  public void setNciCode(final String nciCode) {
    this.put("nciCode", nciCode);
  }

  /**
   * Sets the cpt code.
   *
   * @param cptCode the new cpt code
   */
  public void setCptCode(final String cptCode) {
    this.put("cptCode", cptCode);
  }

  /**
   * Sets the mesh id.
   *
   * @param meshId the new mesh id
   */
  public void setMeshId(final String meshId) {
    this.put("meshId", meshId);
  }

  /**
   * Sets the rx norm id.
   *
   * @param rxNormId the new rx norm id
   */
  public void setRxNormId(final String rxNormId) {
    this.put("rxNormId", rxNormId);
  }

  /**
   * Sets the loinc id.
   *
   * @param loincId the new loinc id
   */
  public void setLoincId(final String loincId) {
    this.put("loincId", loincId);
  }

  /**
   * Sets the vocabs.
   *
   * @param vocabs the new vocabs id
   */
  public void setVocabs(final String vocabs) {
    this.put("vocabs", vocabs);
  }

}
