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

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * ContainerAnnotation.
 */
public class ContainerAnnotation extends GenericModel {

  @SerializedName("AllergyInd")
  private List<Annotation> allergyInd;
  private List<AttributeValueAnnotation> attributeValues;
  @SerializedName("BathingAssistanceInd")
  private List<AssistanceAnnotation> bathingAssistanceInd;
  @SerializedName("IcaCancerDiagnosisInd")
  private List<CancerDiagnosis> icaCancerDiagnosisInd;
  private List<Concept> concepts;
  private List<ConceptValue> conceptValues;
  @SerializedName("DressingAssistanceInd")
  private List<AssistanceAnnotation> dressingAssistanceInd;
  @SerializedName("EatingAssistanceInd")
  private List<AssistanceAnnotation> eatingAssistanceInd;
  @SerializedName("EjectionFractionInd")
  private List<EjectionFractionAnnotation> ejectionFractionInd;
  private List<Annotation> hypotheticalSpans;
  @SerializedName("LabValueInd")
  private List<LabValueAnnotation> labValueInd;
  @SerializedName("MedicationInd")
  private List<MedicationAnnotation> medicationInd;
  @SerializedName("EmailAddressInd")
  private List<Annotation> emailAddressInd;
  @SerializedName("LocationInd")
  private List<Annotation> locationInd;
  @SerializedName("PersonInd")
  private List<Annotation> personInd;
  @SerializedName("US_PhoneNumberInd")
  private List<Annotation> uSPhoneNumberInd;
  @SerializedName("MedicalInstitutionInd")
  private List<Annotation> medicalInstitutionInd;
  private List<NluEntity> nluEntities;
  @SerializedName("OrganizationInd")
  private List<Annotation> organizationInd;
  private List<NegatedSpan> negatedSpans;
  @SerializedName("ProcedureInd")
  private List<Procedure> procedureInd;
  private List<Relation> relations;
  @SerializedName("sections")
  private List<SectionAnnotation> sections;
  @SerializedName("SeeingAssistanceInd")
  private List<AssistanceAnnotation> seeingAssistanceInd;
  @SerializedName("SmokingInd")
  private List<Smoking> smokingInd;
  @SerializedName("SymptomDiseaseInd")
  private List<SymptomDisease> symptomDiseaseInd;
  @SerializedName("ToiletingAssistanceInd")
  private List<AssistanceAnnotation> toiletingAssistanceInd;
  @SerializedName("WalkingAssistanceInd")
  private List<AssistanceAnnotation> walkingAssistanceInd;
  @SerializedName("spellCorrectedText")
  private List<SpellCorrectedText> spellCorrectedText;
  @SerializedName("spellingCorrections")
  private List<SpellingCorrection> spellingCorrections;

    /**
     * Gets the allergyInd.
     *
     * @return the allergyInd
     */
    public List<Annotation> getAllergyInd() {
      return allergyInd;
    }

    /**
     * Gets the attributeValues.
     *
     * @return the attributeValues
     */
    public List<AttributeValueAnnotation> getAttributeValues() {
      return attributeValues;
    }

    /**
     * Gets the bathingAssistanceInd.
     *
     * @return the bathingAssistanceInd
     */
    public List<AssistanceAnnotation> getBathingAssistanceInd() {
      return bathingAssistanceInd;
    }

    /**
     * Gets the icaCancerDiagnosisInd.
     *
     * @return the icaCancerDiagnosisInd
     */
    public List<CancerDiagnosis> getIcaCancerDiagnosisInd() {
      return icaCancerDiagnosisInd;
    }

    /**
     * Gets the concepts.
     *
     * @return the concepts
     */
    public List<Concept> getConcepts() {
      return concepts;
    }

    /**
     * Gets the conceptValues.
     *
     * @return the conceptValues
     */
    public List<ConceptValue> getConceptValues() {
      return conceptValues;
    }

    /**
     * Gets the dressingAssistanceInd.
     *
     * @return the dressingAssistanceInd
     */
    public List<AssistanceAnnotation> getDressingAssistanceInd() {
      return dressingAssistanceInd;
    }

    /**
     * Gets the eatingAssistanceInd.
     *
     * @return the eatingAssistanceInd
     */
    public List<AssistanceAnnotation> getEatingAssistanceInd() {
      return eatingAssistanceInd;
    }

    /**
     * Gets the ejectionFractionInd.
     *
     * @return the ejectionFractionInd
     */
    public List<EjectionFractionAnnotation> getEjectionFractionInd() {
      return ejectionFractionInd;
    }

    /**
     * Gets the hypotheticalSpans.
     *
     * @return the hypotheticalSpans
     */
    public List<Annotation> getHypotheticalSpans() {
      return hypotheticalSpans;
    }

    /**
     * Gets the labValueInd.
     *
     * @return the labValueInd
     */
    public List<LabValueAnnotation> getLabValueInd() {
      return labValueInd;
    }

    /**
     * Gets the medicationInd.
     *
     * @return the medicationInd
     */
    public List<MedicationAnnotation> getMedicationInd() {
      return medicationInd;
    }

    /**
     * Gets the NluEntity.
     *
     * @return the NluEntity
     */
    public List<NluEntity> getNluEntities() {
      return nluEntities;
    }

    /**
     * Gets the emailAddressInd.
     *
     * @return the emailAddressInd
     */
    public List<Annotation> getEmailAddressInd() {
      return emailAddressInd;
    }

    /**
     * Gets the locationInd.
     *
     * @return the locationInd
     */
    public List<Annotation> getLocationInd() {
      return locationInd;
    }

    /**
     * Gets the personInd.
     *
     * @return the personInd
     */
    public List<Annotation> getPersonInd() {
      return personInd;
    }

    /**
     * Gets the uSPhoneNumberInd.
     *
     * @return the uSPhoneNumberInd
     */
    public List<Annotation> getUSPhoneNumberInd() {
      return uSPhoneNumberInd;
    }

    /**
     * Gets the medicalInstitutionInd.
     *
     * @return the medicalInstitutionInd
     */
    public List<Annotation> getMedicalInstitutionInd() {
      return medicalInstitutionInd;
    }

    /**
     * Gets the organizationInd.
     *
     * @return the organizationInd
     */
    public List<Annotation> getOrganizationInd() {
      return organizationInd;
    }

    /**
     * Gets the negatedSpans.
     *
     * @return the negatedSpans
     */
    public List<NegatedSpan> getNegatedSpans() {
      return negatedSpans;
    }

    /**
     * Gets the procedureInd.
     *
     * @return the procedureInd
     */
    public List<Procedure> getProcedureInd() {
      return procedureInd;
    }

    /**
     * Gets the Relation.
     *
     * @return the Relation
     */
    public List<Relation> getRelations() {
      return relations;
    }

    /**
     * Gets the section.
     *
     * @return the section
     */
    public List<SectionAnnotation> getSectionAnnotations() {
      return sections;
    }


    /**
     * Gets the seeingAssistanceInd.
     *
     * @return the seeingAssistanceInd
     */
    public List<AssistanceAnnotation> getSeeingAssistanceInd() {
      return seeingAssistanceInd;
    }

    /**
     * Gets the smokingInd.
     *
     * @return the smokingInd
     */
    public List<Smoking> getSmokingInd() {
      return smokingInd;
    }

    /**
     * Gets the symptomDiseaseInd.
     *
     * @return the symptomDiseaseInd
     */
    public List<SymptomDisease> getSymptomDiseaseInd() {
      return symptomDiseaseInd;
    }

    /**
     * Gets the toiletingAssistanceInd.
     *
     * @return the toiletingAssistanceInd
     */
    public List<AssistanceAnnotation> getToiletingAssistanceInd() {
      return toiletingAssistanceInd;
    }

    /**
     * Gets the spellCorrectedText.
     *
     * @return the spellCorrectedText
     */
    public List<SpellCorrectedText> getSpellCorrectedText() {
      return spellCorrectedText;
    }

    /**
     * Returns the spelling corrections.
     * @return list of spelling corrections
     */
    public List<SpellingCorrection> getSpellingCorrections() {
      return spellingCorrections;
    }

    /**
     * Gets the walkingAssistanceInd.
     *
     * @return the walkingAssistanceInd
     */
    public List<AssistanceAnnotation> getWalkingAssistanceInd() {
      return walkingAssistanceInd;
    }

//    /**
//     * Sets the allergyInd.
//     *
//     * @param allergyInd the new allergyInd
//     */
//    public void setAllergyInd(final List<Annotation> allergyInd) {
//      this.allergyInd = allergyInd;
//    }
//
//    /**
//     * Sets the attributeValues.
//     *
//     * @param attributeValues the new attributeValues
//     */
//    public void setAttributeValues(final List<AttributeValueAnnotation> attributeValues) {
//      this.attributeValues = attributeValues;
//    }
//
//    /**
//     * Sets the bathingAssistanceInd.
//     *
//     * @param bathingAssistanceInd the new bathingAssistanceInd
//     */
//    public void setBathingAssistanceInd(final List<AssistanceAnnotation> bathingAssistanceInd) {
//      this.bathingAssistanceInd = bathingAssistanceInd;
//    }
//
//    /**
//     * Sets the icaCancerDiagnosisInd.
//     *
//     * @param icaCancerDiagnosisInd the new icaCancerDiagnosisInd
//     */
//    public void setIcaCancerDiagnosisInd(final List<CancerDiagnosis> icaCancerDiagnosisInd) {
//      this.icaCancerDiagnosisInd = icaCancerDiagnosisInd;
//    }
//
//    /**
//     * Sets the concepts.
//     *
//     * @param concepts the new concepts
//     */
//    public void setConcepts(final List<Concept> concepts) {
//      this.concepts = concepts;
//    }
//
//    /**
//     * Sets the conceptValues.
//     *
//     * @param conceptValues the new conceptValues
//     */
//    public void setConceptValues(final List<ConceptValue> conceptValues) {
//      this.conceptValues = conceptValues;
//    }
//
//    /**
//     * Sets the dressingAssistanceInd.
//     *
//     * @param dressingAssistanceInd the new dressingAssistanceInd
//     */
//    public void setDressingAssistanceInd(final List<AssistanceAnnotation> dressingAssistanceInd) {
//      this.dressingAssistanceInd = dressingAssistanceInd;
//    }
//
//    /**
//     * Sets the eatingAssistanceInd.
//     *
//     * @param eatingAssistanceInd the new eatingAssistanceInd
//     */
//    public void setEatingAssistanceInd(final List<AssistanceAnnotation> eatingAssistanceInd) {
//      this.eatingAssistanceInd = eatingAssistanceInd;
//    }
//
//    /**
//     * Sets the ejectionFractionInd.
//     *
//     * @param ejectionFractionInd the new ejectionFractionInd
//     */
//    public void setEjectionFractionInd(final List<EjectionFractionAnnotation> ejectionFractionInd) {
//      this.ejectionFractionInd = ejectionFractionInd;
//    }
//
//    /**
//     * Sets the hypotheticalSpans.
//     *
//     * @param hypotheticalSpans the new hypotheticalSpans
//     */
//    public void setHypotheticalSpans(final List<Annotation> hypotheticalSpans) {
//      this.hypotheticalSpans = hypotheticalSpans;
//    }
//
//    /**
//     * Sets the labValueInd.
//     *
//     * @param labValueInd the new labValueInd
//     */
//    public void setLabValueInd(final List<LabValueAnnotation> labValueInd) {
//      this.labValueInd = labValueInd;
//    }
//
//    /**
//     * Sets the medicationInd.
//     *
//     * @param medicationInd the new medicationInd
//     */
//    public void setMedicationInd(final List<MedicationAnnotation> medicationInd) {
//      this.medicationInd = medicationInd;
//    }
//
//    /**
//     * Sets the NluEntity.
//     *
//     * @param NluEntity the new NluEntity
//     */
//    public void setNluEntities(final List<NluEntity> nluEntities) {
//      this.nluEntities = nluEntities;
//    }
//
//    /**
//     * Sets the emailAddressInd.
//     *
//     * @param emailAddressInd the new emailAddressInd
//     */
//    public void setEmailAddressInd(final List<Annotation> emailAddressInd) {
//      this.emailAddressInd = emailAddressInd;
//    }
//
//    /**
//     * Sets the locationInd.
//     *
//     * @param locationInd the new locationInd
//     */
//    public void setLocationInd(final List<Annotation> locationInd) {
//      this.locationInd = locationInd;
//    }
//
//    /**
//     * Sets the personInd.
//     *
//     * @param personInd the new personInd
//     */
//    public void setPersonInd(final List<Annotation> personInd) {
//      this.personInd = personInd;
//    }
//
//    /**
//     * Sets the uSPhoneNumberInd.
//     *
//     * @param uSPhoneNumberInd the new uSPhoneNumberInd
//     */
//    public void setUSPhoneNumberInd(final List<Annotation> uSPhoneNumberInd) {
//      this.uSPhoneNumberInd = uSPhoneNumberInd;
//    }
//
//    /**
//     * Sets the medicalInstitutionInd.
//     *
//     * @param medicalInstitutionInd the new medicalInstitutionInd
//     */
//    public void setMedicalInstitutionInd(final List<Annotation> medicalInstitutionInd) {
//      this.medicalInstitutionInd = medicalInstitutionInd;
//    }
//
//    /**
//     * Sets the organizationInd.
//     *
//     * @param organizationInd the new organizationInd
//     */
//    public void setOrganizationInd(final List<Annotation> organizationInd) {
//      this.organizationInd = organizationInd;
//    }
//
//    /**
//     * Sets the negatedSpans.
//     *
//     * @param negatedSpans the new negatedSpans
//     */
//    public void setNegatedSpans(final List<NegatedSpan> negatedSpans) {
//      this.negatedSpans = negatedSpans;
//    }
//
//    /**
//     * Sets the procedureInd.
//     *
//     * @param procedureInd the new procedureInd
//     */
//    public void setProcedureInd(final List<Procedure> procedureInd) {
//      this.procedureInd = procedureInd;
//    }
//
//    /**
//     * Sets the Relation
//     *
//     * @param Relation the new Relation
//     */
//    public void setRelations(final List<Relation> relations) {
//      this.relations = relations;
//    }
//
//    /**
//     * Sets the section
//     *
//     * @param sectionAnnoationLst the new list of sectionAnnotation
//     */
//    public void setSections(final List<SectionAnnotation> sectionAnnotationLst) {
//      this.sections = sectionAnnotationLst;
//    }
//
//
//    /**
//     * Sets the seeingAssistanceInd.
//     *
//     * @param seeingAssistanceInd the new seeingAssistanceInd
//     */
//    public void setSeeingAssistanceInd(final List<AssistanceAnnotation> seeingAssistanceInd) {
//      this.seeingAssistanceInd = seeingAssistanceInd;
//    }
//
//    /**
//     * Sets the smokingInd.
//     *
//     * @param smokingInd the new smokingInd
//     */
//    public void setSmokingInd(final List<Smoking> smokingInd) {
//      this.smokingInd = smokingInd;
//    }
//
//    /**
//     * Sets the symptomDiseaseInd.
//     *
//     * @param symptomDiseaseInd the new symptomDiseaseInd
//     */
//    public void setSymptomDiseaseInd(final List<SymptomDisease> symptomDiseaseInd) {
//      this.symptomDiseaseInd = symptomDiseaseInd;
//    }
//
//    /**
//     * Sets the toiletingAssistanceInd.
//     *
//     * @param toiletingAssistanceInd the new toiletingAssistanceInd
//     */
//    public void setToiletingAssistanceInd(final List<AssistanceAnnotation> toiletingAssistanceInd) {
//      this.toiletingAssistanceInd = toiletingAssistanceInd;
//    }
//
//    /**
//     * Sets the walkingAssistanceInd.
//     *
//     * @param walkingAssistanceInd the new walkingAssistanceInd
//     */
//    public void setWalkingAssistanceInd(final List<AssistanceAnnotation> walkingAssistanceInd) {
//      this.walkingAssistanceInd = walkingAssistanceInd;
//    }
//
//    /**
//     * Sets the spellCorrectedText.
//     *
//     * @param spellCorrectedText the new spellCorrectedText
//     */
//    public void setSpellCorrectedText(final List<SpellCorrectedText> spellCorrectedTexts) {
//      this.spellCorrectedText = spellCorrectedTexts;
//    }
//
//    /**
//     * Sets the spelling corrections
//     *
//     * @param spellingCorrections the new spelling corrections
//     */
//    public void setSpellingCorrections(final List<SpellingCorrection> spellingCorrections) {
//      this.spellingCorrections = spellingCorrections;
//    }
  }
