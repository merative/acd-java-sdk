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
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * ContainerAnnotation.
 */
public class ContainerAnnotation extends GenericModel {

  @SerializedName("AllergyInd")
  protected List<Annotation> allergyInd;
  @SerializedName("attributeValues")
  protected List<AttributeValueAnnotation> attributeValues;
  @SerializedName("BathingAssistanceInd")
  protected List<AssistanceAnnotation> bathingAssistanceInd;
  @SerializedName("IcaCancerDiagnosisInd")
  protected List<CancerDiagnosis> icaCancerDiagnosisInd;
  @SerializedName("concepts")
  protected List<Concept> concepts;
  @SerializedName("conceptValues")
  protected List<ConceptValue> conceptValues;
  @SerializedName("DressingAssistanceInd")
  protected List<AssistanceAnnotation> dressingAssistanceInd;
  @SerializedName("EatingAssistanceInd")
  protected List<AssistanceAnnotation> eatingAssistanceInd;
  @SerializedName("EjectionFractionInd")
  protected List<EjectionFractionAnnotation> ejectionFractionInd;
  @SerializedName("hypotheticalSpans")
  protected List<Annotation> hypotheticalSpans;
  @SerializedName("LabValueInd")
  protected List<LabValueAnnotation> labValueInd;
  @SerializedName("MedicationInd")
  protected List<MedicationAnnotation> medicationInd;
  @SerializedName("EmailAddressInd")
  protected List<Annotation> emailAddressInd;
  @SerializedName("LocationInd")
  protected List<Annotation> locationInd;
  @SerializedName("PersonInd")
  protected List<Annotation> personInd;
  @SerializedName("US_PhoneNumberInd")
  protected List<Annotation> uSPhoneNumberInd;
  @SerializedName("MedicalInstitutionInd")
  protected List<Annotation> medicalInstitutionInd;
  @SerializedName("nluEntities")
  protected List<NluEntity> nluEntities;
  @SerializedName("OrganizationInd")
  protected List<Annotation> organizationInd;
  @SerializedName("negatedSpans")
  protected List<NegatedSpan> negatedSpans;
  @SerializedName("ProcedureInd")
  protected List<Procedure> procedureInd;
  @SerializedName("relations")
  protected List<Relation> relations;
  @SerializedName("sections")
  protected List<SectionAnnotation> sections;
  @SerializedName("SeeingAssistanceInd")
  protected List<AssistanceAnnotation> seeingAssistanceInd;
  @SerializedName("SmokingInd")
  protected List<Smoking> smokingInd;
  @SerializedName("SymptomDiseaseInd")
  protected List<SymptomDisease> symptomDiseaseInd;
  @SerializedName("ToiletingAssistanceInd")
  protected List<AssistanceAnnotation> toiletingAssistanceInd;
  @SerializedName("WalkingAssistanceInd")
  protected List<AssistanceAnnotation> walkingAssistanceInd;
  @SerializedName("spellCorrectedText")
  protected List<SpellCorrectedText> spellCorrectedText;
  @SerializedName("spellingCorrections")
  protected List<SpellingCorrection> spellingCorrections;
  @SerializedName("temporalSpans")
  protected List<Temporal> temporalSpans;
  @SerializedName("lines")
  protected List<Annotation> lines;
  @SerializedName("sentences")
  protected List<Annotation> sentences;
  @SerializedName("paragraphs")
  protected List<Annotation> paragraphs;
  @SerializedName("AllergyMedicationInd")
  protected List<AllergyMedicationInd> allergyMedicationInd;

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

    /**
     * Gets the temporalSpans.
     *
     * @return the temporalSpans
     */
    public List<Temporal> getTemporalSpans() {
      return temporalSpans;
    }


    /**
     * Gets the lines scopes.
     *
     * @return the lines scopes
     */
    public List<Annotation> getLines() {
      return lines;
    }

    /**
     * Gets the sentences scopes.
     *
     * @return the sentences scopes
     */
    public List<Annotation> getSentences() {
      return sentences;
    }

    /**
     * Gets the paragraphs scopes.
     *
     * @return the paragraphs scopes
     */
    public List<Annotation> getParagraphs() {
      return paragraphs;
    }

    /**
     * Gets the AllergyMedicationInd.
     *
     * @return the allergyMedicationInd
     */
    public List<AllergyMedicationInd> getAllergyMedicationInd() {
    	return allergyMedicationInd;
    }

  }
