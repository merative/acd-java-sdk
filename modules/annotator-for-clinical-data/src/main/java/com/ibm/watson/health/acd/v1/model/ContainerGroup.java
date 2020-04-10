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

import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * ContainerGroup.
 */
public class ContainerGroup extends GenericModel {

  private List<UnstructuredContainer> unstructured;
  private List<AnnotatorFlow> annotatorFlows;

  /**
   * Gets the unstructured.
   *
   * @return the unstructured
   */
  public List<UnstructuredContainer> getUnstructured() {
    return unstructured;
  }

  /**
   * Gets the annotatorFlows.
   *
   * @return the annotatorFlows
   */
  public List<AnnotatorFlow> getAnnotatorFlows() {
    return annotatorFlows;
  }

  /**
   * Sets the unstructured.
   *
   * @param unstructured
   *            the new unstructured
   */
  public void setUnstructured(final List<UnstructuredContainer> unstructured) {
    this.unstructured = unstructured;
  }

  /**
   * Sets the annotatorFlows.
   *
   * @param annotatorFlows
   *            the new annotatorFlows
   */
  public void setAnnotatorFlows(final List<AnnotatorFlow> annotatorFlows) {
    this.annotatorFlows = annotatorFlows;
  }

  /*
   *
   * Manually added code
   *
   */

  public UnstructuredContainer getUnstructured(int index) {
    Validator.notNull(this.getUnstructured(), "Unstructured List is Null");
    UnstructuredContainer unstructuredContainer = this.getUnstructured().get(index);

    return unstructuredContainer;
  }

  /*
   * Manually added method
   */

  public List<Concept> getConcepts() {
    validateUnstructuredElementData("Concepts");
    return this.getUnstructured().get(0).data().getConcepts();
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
    validateUnstructuredElementData("SymptomDisease");
    return this.getUnstructured().get(0).data().getSymptomDiseaseInd();
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
    validateUnstructuredElementData("BathingAssistance");
    return this.getUnstructured().get(0).data().getBathingAssistanceInd();
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
    validateUnstructuredElementData("DressingAssistance");
    return this.getUnstructured().get(0).data().getDressingAssistanceInd();
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
    validateUnstructuredElementData("EatingAssistance");
    return this.getUnstructured().get(0).data().getEatingAssistanceInd();
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
    validateUnstructuredElementData("WalkingAssistance");
    return this.getUnstructured().get(0).data().getWalkingAssistanceInd();
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
    validateUnstructuredElementData("ToiletingAssistance");
    return this.getUnstructured().get(0).data().getToiletingAssistanceInd();
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
    validateUnstructuredElementData("CancerDiagnosis");
    return this.getUnstructured().get(0).data().getIcaCancerDiagnosisInd();
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
    validateUnstructuredElementData("HypotheticalSpans");
    return this.getUnstructured().get(0).data().getHypotheticalSpans();
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
    validateUnstructuredElementData("Allergy");
    return this.getUnstructured().get(0).data().getAllergyInd();
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
    validateUnstructuredElementData("NegatedSpans");
    return this.getUnstructured().get(0).data().getNegatedSpans();
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
    validateUnstructuredElementData("ConceptValues");
    return this.getUnstructured().get(0).data().getConceptValues();
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
    validateUnstructuredElementData("Procedure");
    return this.getUnstructured().get(0).data().getProcedureInd();
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
    validateUnstructuredElementData("Smoking");
    return this.getUnstructured().get(0).data().getSmokingInd();
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
    validateUnstructuredElementData("Organization");
    return this.getUnstructured().get(0).data().getOrganizationInd();
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
    validateUnstructuredElementData("Person");
    return this.getUnstructured().get(0).data().getPersonInd();
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
    validateUnstructuredElementData("MedicalInstitution");
    return this.getUnstructured().get(0).data().getMedicalInstitutionInd();

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
    validateUnstructuredElementData("AttributeValues");
    return this.getUnstructured().get(0).data().getAttributeValues();
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
    validateUnstructuredElementData("EjectionFractionInd");
    return this.getUnstructured().get(0).data().getEjectionFractionInd();
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
    validateUnstructuredElementData("LabValueInd");
    return this.getUnstructured().get(0).data().getLabValueInd();
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
    validateUnstructuredElementData("MedicationInd");
    return this.getUnstructured().get(0).data().getMedicationInd();
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
    validateUnstructuredElementData("EmailAddressInd");
    return this.getUnstructured().get(0).data().getEmailAddressInd();
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
    validateUnstructuredElementData("LocationInd");
    return this.getUnstructured().get(0).data().getLocationInd();
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
    validateUnstructuredElementData("USPhoneNumberInd");
    return this.getUnstructured().get(0).data().getUSPhoneNumberInd();
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
    validateUnstructuredElementData("SeeingAssistanceInd");
    return this.getUnstructured().get(0).data().getSeeingAssistanceInd();
  }

  /*
   * Manually added method
   */

  /**
   * Gets the SectionAnnotations.
   *
   * @return the SectionAnnotations
   */
  public List<SectionAnnotation> getSectionAnnotations() {
    validateUnstructuredElementData("SectionAnnotations");
    return this.getUnstructured().get(0).data().getSectionAnnotations();
  }


  /*
   * Manually added method
   */

  /**
   * Gets the NluEntities.
   *
   * @return the NluEntities
   */
  public List<NluEntity> getNluEntities() {
    validateUnstructuredElementData("nluEntities");
    return this.getUnstructured().get(0).data().getNluEntities();
  }

  /*
   * Manually added method
   */

  /**
   * Gets the Relations.
   *
   * @return the Relations
   */
  public List<Relation> getRelations() {
    validateUnstructuredElementData("relations");
    return this.getUnstructured().get(0).data().getRelations();
  }

  /**
   * Gets all of the SpellCorrectedText objects in the container.
   *
   * @return the SpellCorrectedText objects
   */
  public List<SpellCorrectedText> getSpellCorrectedText() {
    validateUnstructuredElementData("spellCorrrectedText");
    return this.getUnstructured().get(0).data().getSpellCorrectedText();
  }

  /**
   * Gets all of the SpellingCorrections in the container.
   *
   * @return the SpellingCorrections objects
   */
  public List<SpellingCorrection> getSpellingCorrections() {
    validateUnstructuredElementData("spellingCorrections");
    return this.getUnstructured().get(0).data().getSpellingCorrections();
  }


  /*
   * Manually added method
   */

  public Concept getConcepts(int index) {
    validateUnstructuredElementData("Concepts");
    return this.getUnstructured().get(0).data().getConcepts().get(index);
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
    validateUnstructuredElementData("SymptomDisease");
    return this.getUnstructured().get(0).data().getSymptomDiseaseInd().get(index);
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
    validateUnstructuredElementData("BathingAssistance");
    return this.getUnstructured().get(0).data().getBathingAssistanceInd().get(index);
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
    validateUnstructuredElementData("DressingAssistance");
    return this.getUnstructured().get(0).data().getDressingAssistanceInd().get(index);
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
    validateUnstructuredElementData("EatingAssistance");
    return this.getUnstructured().get(0).data().getEatingAssistanceInd().get(index);
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
    validateUnstructuredElementData("WalkingAssistance");
    return this.getUnstructured().get(0).data().getWalkingAssistanceInd().get(index);
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
    validateUnstructuredElementData("ToiletingAssistance");
    return this.getUnstructured().get(0).data().getToiletingAssistanceInd().get(index);
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
    validateUnstructuredElementData("CancerDiagnosis");
    return this.getUnstructured().get(0).data().getIcaCancerDiagnosisInd().get(index);
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
    validateUnstructuredElementData("HypotheticalSpans");
    return this.getUnstructured().get(0).data().getHypotheticalSpans().get(index);
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
    validateUnstructuredElementData("Allergy");
    return this.getUnstructured().get(0).data().getAllergyInd().get(index);
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
    validateUnstructuredElementData("NegatedSpans");
    return this.getUnstructured().get(0).data().getNegatedSpans().get(index);
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
    validateUnstructuredElementData("ConceptValues");
    return this.getUnstructured().get(0).data().getConceptValues().get(index);
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
    validateUnstructuredElementData("Procedure");
    return this.getUnstructured().get(0).data().getProcedureInd().get(index);
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
    validateUnstructuredElementData("Smoking");
    return this.getUnstructured().get(0).data().getSmokingInd().get(index);
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
    validateUnstructuredElementData("Organization");
    return this.getUnstructured().get(0).data().getOrganizationInd().get(index);
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
    validateUnstructuredElementData("Person");
    return this.getUnstructured().get(0).data().getPersonInd().get(index);
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
    validateUnstructuredElementData("MedicalInstitution");
    return this.getUnstructured().get(0).data().getMedicalInstitutionInd().get(index);

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
    validateUnstructuredElementData("AttributeValues");
    return this.getUnstructured().get(0).data().getAttributeValues().get(index);
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
    validateUnstructuredElementData("EjectionFractionInd");
    return this.getUnstructured().get(0).data().getEjectionFractionInd().get(index);
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
    validateUnstructuredElementData("LabValueInd");
    return this.getUnstructured().get(0).data().getLabValueInd().get(index);
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
    validateUnstructuredElementData("MedicationInd");
    return this.getUnstructured().get(0).data().getMedicationInd().get(index);
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
    validateUnstructuredElementData("EmailAddressInd");
    return this.getUnstructured().get(0).data().getEmailAddressInd().get(index);
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
    validateUnstructuredElementData("LocationInd");
    return this.getUnstructured().get(0).data().getLocationInd().get(index);
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
    validateUnstructuredElementData("USPhoneNumberInd");
    return this.getUnstructured().get(0).data().getUSPhoneNumberInd().get(index);
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
    validateUnstructuredElementData("SeeingAssistanceInd");
    return this.getUnstructured().get(0).data().getSeeingAssistanceInd().get(index);
  }


  /*
   * Manually added method
   */

  /**
   * Gets the sectionAnnotations.
   *
   * @return the sectionAnnotations
   */
  public SectionAnnotation getSectionAnnotations(int index) {
    validateUnstructuredElementData("SectionAnnotations");
    return this.getUnstructured().get(0).data().getSectionAnnotations().get(index);
  }

  /*
   * Manually added method
   */

  /**
   * Gets the NluEntity.
   *
   * @return the NluEntity
   */
  public NluEntity getNluEntity(int index) {
    validateUnstructuredElementData("nluEntities");
    return this.getUnstructured().get(0).data().getNluEntities().get(index);
  }

  /*
   * Manually added method
   */

  /**
   * Gets the Relation.
   *
   * @return the Relation
   */
  public Relation getRelation(int index) {
    validateUnstructuredElementData("relations");
    return this.getUnstructured().get(0).data().getRelations().get(index);
  }

  /**
   * Gets the SpellCorrectedText.
   *
   * @return the SpellCorrectedText
   */
  public SpellCorrectedText getSpellCorrectedText(int index) {
    validateUnstructuredElementData("spellCorrrectedText");
    return this.getUnstructured().get(0).data().getSpellCorrectedText().get(index);
  }

  /**
   * Gets SpellingCorrections at the given index.
   *
   * @return the SpellingCorrection
   */
  public SpellingCorrection getSpellingCorrections(int index) {
    validateUnstructuredElementData("spellingCorrections");
    return this.getUnstructured().get(0).data().getSpellingCorrections().get(index);
  }

  /*
   * Manually added method
   */

  /**
   * Validator to prevent possible NullPointerException.  Validator
   * will generate IllegalArgumentException if 'notNull' check is true.
   */
  private void validateUnstructuredElementData(String annoType) {
    String errorMsg = "No " + annoType + " Annotations - Unstructured List is Null";
    Validator.notNull(this.getUnstructured(), errorMsg);

    errorMsg = "No " + annoType + " Annotations - Unstructured List Element is Null";
    Validator.notNull(this.getUnstructured().get(0), errorMsg);

    errorMsg = "No " + annoType + " Annotations - Unstructured List Element Data is Null";
    Validator.notNull(this.getUnstructured().get(0).data(), errorMsg);
  }
}
