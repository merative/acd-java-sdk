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
import java.util.Map;

import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * UnstructuredContainer.
 */
public class UnstructuredContainer extends GenericModel {

  private String text;
  private String id;
  private String type;
  private ContainerAnnotation data;
  private Map<String, Map> metadata;
  private Long uid;

  /**
   * Builder.
   */
  public static class Builder {
    private String text;
    private String id;
    private String type;
    private ContainerAnnotation data;
    private Map<String, Map> metadata;
    private Long uid;

    private Builder(UnstructuredContainer unstructuredContainer) {
      text = unstructuredContainer.text;
      id = unstructuredContainer.id;
      type = unstructuredContainer.type;
      data = unstructuredContainer.data;
      metadata = unstructuredContainer.metadata;
      uid = unstructuredContainer.uid;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a UnstructuredContainer.
     *
     * @return the unstructuredContainer
     */
    public UnstructuredContainer build() {
      return new UnstructuredContainer(this);
    }

    /**
     * Set the text.
     *
     * @param text
     *            the text
     * @return the UnstructuredContainer builder
     */
    public Builder text(String text) {
      this.text = text;
      return this;
    }

    /**
     * Set the id.
     *
     * @param id
     *            the id
     * @return the UnstructuredContainer builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Set the type.
     *
     * @param type
     *            the type
     * @return the UnstructuredContainer builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Set the data.
     *
     * @param data
     *            the data
     * @return the UnstructuredContainer builder
     */
    public Builder data(ContainerAnnotation data) {
      this.data = data;
      return this;
    }

    /**
     * Set the metadata.
     *
     * @param metadata
     *            the metadata
     * @return the UnstructuredContainer builder
     */
    public Builder metadata(Map<String, Map> metadata) {
      this.metadata = metadata;
      return this;
    }

    /**
     * Set the uid.
     *
     * @param uid
     *            the uid
     * @return the UnstructuredContainer builder
     */
    public Builder uid(long uid) {
      this.uid = uid;
      return this;
    }
  }

  private UnstructuredContainer(Builder builder) {
    text = builder.text;
    id = builder.id;
    type = builder.type;
    data = builder.data;
    metadata = builder.metadata;
    uid = builder.uid;
  }

  /**
   * New builder.
   *
   * @return a UnstructuredContainer builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the text.
   *
   * @return the text
   */
  public String text() {
    return text;
  }

  /**
   * Gets the id.
   *
   * @return the id
   */
  public String id() {
    return id;
  }

  /**
   * Gets the type.
   *
   * @return the type
   */
  public String type() {
    return type;
  }

  /**
   * Gets the data.
   *
   * @return the data
   */
  public ContainerAnnotation data() {
    return data;
  }

  /**
   * Gets the metadata.
   *
   * @return the metadata
   */
  public Map<String, Map> metadata() {
    return metadata;
  }

  /**
   * Gets the uid.
   *
   * @return the uid
   */
  public Long uid() {
    return uid;
  }

  /*
   * Manually added method
   */

  public List<Concept> getConcepts() {

    return this.data().getConcepts();
  }

  /*
   * Manually added method
   */

  /**
   * Gets the symptomDiseaseInd.
   *
   * @return the symptomDiseaseInd
   */

  public List<SymptomDisease> getSymptomDisease() {

    return this.data().getSymptomDiseaseInd();
  }

  /*
   * Manually added method
   */

  /**
   * Gets the bathingAssistanceInd.
   *
   * @return the bathingAssistanceInd
   */
  public List<AssistanceAnnotation> getBathingAssistance() {
    return this.data().getBathingAssistanceInd();
  }

  /*
   * Manually added method
   */

  /**
   * Gets the dressingAssistanceInd.
   *
   * @return the dressingAssistanceInd
   */
  public List<AssistanceAnnotation> getDressingAssistance() {
    return this.data().getDressingAssistanceInd();
  }

  /*
   * Manually added method
   */

  /**
   * Gets the eatingAssistanceInd.
   *
   * @return the eatingAssistanceInd
   */
  public List<AssistanceAnnotation> getEatingAssistance() {
    return this.data().getEatingAssistanceInd();
  }

  /*
   * Manually added method
   */

  /**
   * Gets the walkingAssistanceInd.
   *
   * @return the walkingAssistanceInd
   */
  public List<AssistanceAnnotation> getWalkingAssistance() {
    return this.data().getWalkingAssistanceInd();
  }

  /*
   * Manually added method
   */

  /**
   * Gets the toiletingAssistanceInd.
   *
   * @return the toiletingAssistanceInd
   */
  public List<AssistanceAnnotation> getToiletingAssistance() {
    return this.data().getToiletingAssistanceInd();
  }

  /*
   * Manually added method
   */

  /**
   * Gets the icaCancerDiagnosisInd.
   *
   * @return the icaCancerDiagnosisInd
   */
  public List<CancerDiagnosis> getCancerDiagnosis() {
    return this.data().getIcaCancerDiagnosisInd();
  }

  /*
   * Manually added method
   */

  /**
   * Gets the hypotheticalSpans.
   *
   * @return the hypotheticalSpans
   */
  public List<Annotation> getHypotheticalSpans() {
    return this.data().getHypotheticalSpans();
  }

  /*
   * Manually added method
   */

  /**
   * Gets the allergyInd.
   *
   * @return the allergyInd
   */
  public List<Annotation> getAllergy() {
    return this.data().getAllergyInd();
  }

  /*
   * Manually added method
   */

  /**
   * Gets the negatedSpans.
   *
   * @return the negatedSpans
   */
  public List<NegatedSpan> getNegatedSpans() {
    return this.data().getNegatedSpans();
  }

  /*
   * Manually added method
   */

  /**
   * Gets the conceptValues.
   *
   * @return the conceptValues
   */
  public List<ConceptValue> getConceptValues() {
    return this.data().getConceptValues();
  }

  /*
   * Manually added method
   */

  /**
   * Gets the procedureInd.
   *
   * @return the procedureInd
   */
  public List<Procedure> getProcedure() {
    return this.data().getProcedureInd();
  }

  /*
   * Manually added method
   */

  /**
   * Gets the smokingInd.
   *
   * @return the smokingInd
   */
  public List<Smoking> getSmoking() {
    return this.data().getSmokingInd();
  }

  /*
   * Manually added method
   */

  /**
   * Gets the organizationInd.
   *
   * @return the organizationInd
   */
  public List<Annotation> getOrganization() {
    return this.data().getOrganizationInd();
  }

  /*
   * Manually added method
   */

  /**
   * Gets the personInd.
   *
   * @return the personInd
   */
  public List<Annotation> getPerson() {
    return this.data().getPersonInd();
  }

  /*
   * Manually added method
   */

  /**
   * Gets the medicalInstitutionInd.
   *
   * @return the medicalInstitutionInd
   */
  public List<Annotation> getMedicalInstitution() {
    return this.data().getMedicalInstitutionInd();

  }

  /*
   * Manually added method
   */

  /**
   * Gets the attributeValues.
   *
   * @return the attributeValues
   */
  public List<AttributeValueAnnotation> getAttributeValues() {
    return this.data().getAttributeValues();
  }

  /*
   * Manually added method
   */

  /**
   * Gets the ejectionFractionInd.
   *
   * @return the ejectionFractionInd
   */
  public List<EjectionFractionAnnotation> getEjectionFractionInd() {
    return this.data().getEjectionFractionInd();
  }

  /*
   * Manually added method
   */

  /**
   * Gets the labValueInd.
   *
   * @return the labValueInd
   */
  public List<LabValueAnnotation> getLabValueInd() {
    return this.data().getLabValueInd();
  }

  /*
   * Manually added method
   */

  /**
   * Gets the medicationInd.
   *
   * @return the medicationInd
   */
  public List<MedicationAnnotation> getMedicationInd() {
    return this.data().getMedicationInd();
  }

  /*
   * Manually added method
   */

  /**
   * Gets the emailAddressInd.
   *
   * @return the emailAddressInd
   */
  public List<Annotation> getEmailAddressInd() {
    return this.data().getEmailAddressInd();
  }

  /*
   * Manually added method
   */

  /**
   * Gets the locationInd.
   *
   * @return the locationInd
   */
  public List<Annotation> getLocationInd() {
    return this.data().getLocationInd();
  }

  /*
   * Manually added method
   */

  /**
   * Gets the uSPhoneNumberInd.
   *
   * @return the uSPhoneNumberInd
   */
  public List<Annotation> getUSPhoneNumberInd() {
    return this.data().getUSPhoneNumberInd();
  }

  /*
   * Manually added method
   */

  /**
   * Gets the seeingAssistanceInd.
   *
   * @return the seeingAssistanceInd
   */
  public List<AssistanceAnnotation> getSeeingAssistanceInd() {
    return this.data().getSeeingAssistanceInd();
  }


  /*
   * Manually added method
   */

  /**
   * Gets the section.
   *
   * @return the section
   */
  public List<SectionAnnotation> getSectionAnnotations() {
    return this.data().getSectionAnnotations();
  }

  /*
   * Manually added method
   */

  /**
   * Gets the NluEntity.
   *
   * @return the NluEntity
   */
  public List<NluEntity> getNluEntities() {
    return this.data().getNluEntities();
  }

  /*
   * Manually added method
   */

  /**
   * Gets the Relation.
   *
   * @return the Relation
   */
  public List<Relation> getRelations() {
    return this.data().getRelations();
  }

  /**
   * Gets the SpellCorrectedText objects in the container.
   *
   * @return the SpellCorrectedText
   */
  public List<SpellCorrectedText> getSpellCorrectedText() {
    return this.data().getSpellCorrectedText();
  }

  /**
   * Gets the SpellingCorrection objects in the container.
   *
   * @return the SpellingCorrection
   */
  public List<SpellingCorrection> getSpellingCorrections() {
    return this.data().getSpellingCorrections();
  }

  /*
   *
   * Manually added code
   *
   */

  public Concept getConcepts(int index) {

    return this.data().getConcepts().get(index);
  }

  /*
   * Manually added method
   */

  /**
   * Gets the symptomDiseaseInd.
   *
   * @return the symptomDiseaseInd
   */

  public SymptomDisease getSymptomDisease(int index) {

    return this.data().getSymptomDiseaseInd().get(index);
  }

  /*
   * Manually added method
   */

  /**
   * Gets the bathingAssistanceInd.
   *
   * @return the bathingAssistanceInd
   */
  public AssistanceAnnotation getBathingAssistance(int index) {
    return this.data().getBathingAssistanceInd().get(index);
  }

  /*
   * Manually added method
   */

  /**
   * Gets the dressingAssistanceInd.
   *
   * @return the dressingAssistanceInd
   */
  public AssistanceAnnotation getDressingAssistance(int index) {
    return this.data().getDressingAssistanceInd().get(index);
  }

  /*
   * Manually added method
   */

  /**
   * Gets the eatingAssistanceInd.
   *
   * @return the eatingAssistanceInd
   */
  public AssistanceAnnotation getEatingAssistance(int index) {
    return this.data().getEatingAssistanceInd().get(index);
  }

  /*
   * Manually added method
   */

  /**
   * Gets the walkingAssistanceInd.
   *
   * @return the walkingAssistanceInd
   */
  public AssistanceAnnotation getWalkingAssistance(int index) {
    return this.data().getWalkingAssistanceInd().get(index);
  }

  /*
   * Manually added method
   */

  /**
   * Gets the toiletingAssistanceInd.
   *
   * @return the toiletingAssistanceInd
   */
  public AssistanceAnnotation getToiletingAssistance(int index) {
    return this.data().getToiletingAssistanceInd().get(index);
  }

  /*
   * Manually added method
   */

  /**
   * Gets the icaCancerDiagnosisInd.
   *
   * @return the icaCancerDiagnosisInd
   */
  public CancerDiagnosis getCancerDiagnosis(int index) {
    return this.data().getIcaCancerDiagnosisInd().get(index);
  }

  /*
   * Manually added method
   */

  /**
   * Gets the hypotheticalSpans.
   *
   * @return the hypotheticalSpans
   */
  public Annotation getHypotheticalSpans(int index) {
    return this.data().getHypotheticalSpans().get(index);
  }

  /*
   * Manually added method
   */

  /**
   * Gets the allergyInd.
   *
   * @return the allergyInd
   */
  public Annotation getAllergy(int index) {
    return this.data().getAllergyInd().get(index);
  }

  /*
   * Manually added method
   */

  /**
   * Gets the negatedSpans.
   *
   * @return the negatedSpans
   */
  public NegatedSpan getNegatedSpans(int index) {
    return this.data().getNegatedSpans().get(index);
  }

  /*
   * Manually added method
   */

  /**
   * Gets the conceptValues.
   *
   * @return the conceptValues
   */
  public ConceptValue getConceptValues(int index) {
    return this.data().getConceptValues().get(index);
  }

  /*
   * Manually added method
   */

  /**
   * Gets the procedureInd.
   *
   * @return the procedureInd
   */
  public Procedure getProcedure(int index) {
    return this.data().getProcedureInd().get(index);
  }

  /*
   * Manually added method
   */

  /**
   * Gets the smokingInd.
   *
   * @return the smokingInd
   */
  public Smoking getSmoking(int index) {
    return this.data().getSmokingInd().get(index);
  }

  /*
   * Manually added method
   */

  /**
   * Gets the organizationInd.
   *
   * @return the organizationInd
   */
  public Annotation getOrganization(int index) {
    return this.data().getOrganizationInd().get(index);
  }

  /*
   * Manually added method
   */

  /**
   * Gets the personInd.
   *
   * @return the personInd
   */
  public Annotation getPerson(int index) {
    return this.data().getPersonInd().get(index);
  }

  /*
   * Manually added method
   */

  /**
   * Gets the medicalInstitutionInd.
   *
   * @return the medicalInstitutionInd
   */
  public Annotation getMedicalInstitution(int index) {
    return this.data().getMedicalInstitutionInd().get(index);

  }

  /*
   * Manually added method
   */

  /**
   * Gets the attributeValues.
   *
   * @return the attributeValues
   */
  public AttributeValueAnnotation getAttributeValues(int index) {
    return this.data().getAttributeValues().get(index);
  }

  /*
   * Manually added method
   */

  /**
   * Gets the ejectionFractionInd.
   *
   * @return the ejectionFractionInd
   */
  public EjectionFractionAnnotation getEjectionFractionInd(int index) {
    return this.data().getEjectionFractionInd().get(index);
  }

  /*
   * Manually added method
   */

  /**
   * Gets the labValueInd.
   *
   * @return the labValueInd
   */
  public LabValueAnnotation getLabValueInd(int index) {
    return this.data().getLabValueInd().get(index);
  }

  /*
   * Manually added method
   */

  /**
   * Gets the medicationInd.
   *
   * @return the medicationInd
   */
  public MedicationAnnotation getMedicationInd(int index) {
    return this.data().getMedicationInd().get(index);
  }

  /*
   * Manually added method
   */

  /**
   * Gets the emailAddressInd.
   *
   * @return the emailAddressInd
   */
  public Annotation getEmailAddressInd(int index) {
    return this.data().getEmailAddressInd().get(index);
  }

  /*
   * Manually added method
   */

  /**
   * Gets the locationInd.
   *
   * @return the locationInd
   */
  public Annotation getLocationInd(int index) {
    return this.data().getLocationInd().get(index);
  }

  /*
   * Manually added method
   */

  /**
   * Gets the uSPhoneNumberInd.
   *
   * @return the uSPhoneNumberInd
   */
  public Annotation getUSPhoneNumberInd(int index) {
    return this.data().getUSPhoneNumberInd().get(index);
  }

  /*
   * Manually added method
   */

  /**
   * Gets the seeingAssistanceInd.
   *
   * @return the seeingAssistanceInd
   */
  public AssistanceAnnotation getSeeingAssistanceInd(int index) {
    return this.data().getSeeingAssistanceInd().get(index);
  }


  /*
   * Manually added method
   */

  /**
   * Gets SectionAnnotations.
   *
   * @return the sectionAnnotations
   */
  public SectionAnnotation getSectionAnnotations(int index) {
    return this.data().getSectionAnnotations().get(index);
  }

  /*
   * Manually added method
   */

  /**
   * Gets NluEntity.
   *
   * @return the NluEntity
   */
  public NluEntity getNluEntity(int index) {
    return this.data().getNluEntities().get(index);
  }

  /**
   * Gets Relation.
   *
   * @return the Relation
   */
  public Relation getRelation(int index) {
    return this.data().getRelations().get(index);
  }

  /**
   * Gets the SpellingCorrection object at the given index.
   *
   * @return the SpellingCorrection
   */
  public SpellingCorrection getSpellingCorrections(int index) {
    return this.data().getSpellingCorrections().get(index);
  }

  /**
   * Gets the SpellCorrectedText at the given index.
   *
   * @return the SpellCorrectedText
   */
  public SpellCorrectedText getSpellCorrectedText(int index) {
    return this.data().getSpellCorrectedText().get(index);
  }
}
