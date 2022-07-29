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

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import com.ibm.cloud.sdk.core.util.Validator;

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
	  UnstructuredContainer container = new UnstructuredContainer.Builder().build();
	  try {
      Validator.notNull(this.getUnstructured(), "Unstructured List is Null");
      container = this.getUnstructured().get(index);
	  } catch (IllegalArgumentException iae) {
	  //ACD didn't return any annotations
     }

    return container;
  }

  /*
   * Manually added method
   */

  public List<Concept> getConcepts() {
	  List<Concept> concepts = new ArrayList<Concept>();
	  try {
	    validateUnstructuredElementData("Concepts");
	   concepts = this.getUnstructured().get(0).data().getConcepts();
	  } catch (IllegalArgumentException iae) {
	  	//ACD didn't return any concepts
	  }
    return concepts;
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
	  List<SymptomDisease> concepts = new ArrayList<SymptomDisease>();
	  try {
      validateUnstructuredElementData("SymptomDisease");
      concepts = this.getUnstructured().get(0).data().getSymptomDiseaseInd();
	  } catch (IllegalArgumentException iae) {
	  	//ACD didn't return any annotations
	  }
	  return concepts;
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
	  List<AssistanceAnnotation> annotations = new ArrayList<AssistanceAnnotation>();
	  try {
      validateUnstructuredElementData("BathingAssistance");
      annotations = this.getUnstructured().get(0).data().getBathingAssistanceInd();
  	} catch (IllegalArgumentException iae) {
	  	//ACD didn't return any annotations
	  }
	  return annotations;
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
  	List<AssistanceAnnotation> annotations = new ArrayList<AssistanceAnnotation>();
	  try {
      validateUnstructuredElementData("DressingAssistance");
      annotations = this.getUnstructured().get(0).data().getDressingAssistanceInd();
	  } catch (IllegalArgumentException iae) {
	  	//ACD didn't return any annotations
	  }
	  return annotations;
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
  	List<AssistanceAnnotation> annotations = new ArrayList<AssistanceAnnotation>();
  	try {
      validateUnstructuredElementData("EatingAssistance");
      annotations = this.getUnstructured().get(0).data().getEatingAssistanceInd();
	  } catch (IllegalArgumentException iae) {
	  	//ACD didn't return any annotations
	  }
  	return annotations;
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
  	List<AssistanceAnnotation> annotations = new ArrayList<AssistanceAnnotation>();
	  try {
      validateUnstructuredElementData("WalkingAssistance");
      annotations = this.getUnstructured().get(0).data().getWalkingAssistanceInd();
  	} catch (IllegalArgumentException iae) {
	  	//ACD didn't return any annotations
	  }
	  return annotations;
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
  	List<AssistanceAnnotation> annotations = new ArrayList<AssistanceAnnotation>();
  	try {
      validateUnstructuredElementData("ToiletingAssistance");
      annotations = this.getUnstructured().get(0).data().getToiletingAssistanceInd();
	  } catch (IllegalArgumentException iae) {
	  	//ACD didn't return any annotations
  	}
	  return annotations;
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
  	List<CancerDiagnosis> concepts = new ArrayList<CancerDiagnosis>();
	  try {
      validateUnstructuredElementData("CancerDiagnosis");
      return this.getUnstructured().get(0).data().getIcaCancerDiagnosisInd();
	  } catch (IllegalArgumentException iae) {
	  	//ACD didn't return any annotations
	  }
	  return concepts;
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
  	List<Annotation> annotations = new ArrayList<Annotation>();
	  try {
      validateUnstructuredElementData("HypotheticalSpans");
      annotations = this.getUnstructured().get(0).data().getHypotheticalSpans();
	  } catch (IllegalArgumentException iae) {
	  	//ACD didn't return any annotations
  	}
  	return annotations;
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
  	List<Annotation> annotations = new ArrayList<Annotation>();
  	try {
      validateUnstructuredElementData("Allergy");
      annotations = this.getUnstructured().get(0).data().getAllergyInd();
  	} catch (IllegalArgumentException iae) {
  		//ACD didn't return any annotations
  	}
  	return annotations;
  }

  /**
   * Gets the AllergyMedicationInd.
   *
   * @return the allergyMedicationInd
   */
  public List<AllergyMedicationInd> getAllergyMedication() {
  	List<AllergyMedicationInd> annotations = new ArrayList<AllergyMedicationInd>();
  	try {
      validateUnstructuredElementData("MedicationAllergy");
      annotations = this.getUnstructured().get(0).data().getAllergyMedicationInd();
  	} catch (IllegalArgumentException iae) {
  		//ACD didn't return any annotations
  	}
  	return annotations;
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
  	List<NegatedSpan> negattions = new ArrayList<NegatedSpan>();
  	try {
      validateUnstructuredElementData("NegatedSpans");
      negattions = this.getUnstructured().get(0).data().getNegatedSpans();
  	} catch (IllegalArgumentException iae) {
  		//ACD didn't return any annotations
  	}
  	return negattions;
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
  	List<ConceptValue> values = new ArrayList<ConceptValue>();
	  try {
      validateUnstructuredElementData("ConceptValues");
      values = this.getUnstructured().get(0).data().getConceptValues();
	  } catch (IllegalArgumentException iae) {
	  	//ACD didn't return any annotations
	  }
	  return values;
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
  	List<Procedure> procedures = new ArrayList<Procedure>();
	  try {
      validateUnstructuredElementData("Procedure");
      procedures = this.getUnstructured().get(0).data().getProcedureInd();
  	} catch (IllegalArgumentException iae) {
  		//ACD didn't return any annotations
	  }
  	return procedures;
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
	List<Smoking> annotations = new ArrayList<Smoking>();
  	try {
      validateUnstructuredElementData("Smoking");
      annotations = this.getUnstructured().get(0).data().getSmokingInd();
	  } catch (IllegalArgumentException iae) {
	  	//ACD didn't return any annotations
	  }
	  return annotations;
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
  	List<Annotation> annotations = new ArrayList<Annotation>();
	  try {
      validateUnstructuredElementData("Organization");
      annotations = this.getUnstructured().get(0).data().getOrganizationInd();
	  } catch (IllegalArgumentException iae) {
	  	//ACD didn't return any annotations
	  }
	  return annotations;
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
    List<Annotation> annotations = new ArrayList<Annotation>();
	  try {
      validateUnstructuredElementData("Person");
      annotations = this.getUnstructured().get(0).data().getPersonInd();
  	} catch (IllegalArgumentException iae) {
  		//ACD didn't return any annotations
  	}
  	return annotations;
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
  	List<Annotation> annotations = new ArrayList<Annotation>();
	  try {
      validateUnstructuredElementData("MedicalInstitution");
      annotations = this.getUnstructured().get(0).data().getMedicalInstitutionInd();
	  } catch (IllegalArgumentException iae) {
	  	//ACD didn't return any annotations
	  }
	  return annotations;
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
  	List<AttributeValueAnnotation> annotations = new ArrayList<AttributeValueAnnotation>();
  	try {
      validateUnstructuredElementData("AttributeValues");
      annotations = this.getUnstructured().get(0).data().getAttributeValues();
  	} catch (IllegalArgumentException iae) {
  		//ACD didn't return any annotations
	  }
	  return annotations;
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
  	List<EjectionFractionAnnotation> annotations = new ArrayList<EjectionFractionAnnotation>();
	  try {
      validateUnstructuredElementData("EjectionFractionInd");
      annotations = this.getUnstructured().get(0).data().getEjectionFractionInd();
	  } catch (IllegalArgumentException iae) {
	  	//ACD didn't return any annotations
  	}
  	return annotations;
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
  	List<LabValueAnnotation> annotations = new ArrayList<LabValueAnnotation>();
	  try {
      validateUnstructuredElementData("LabValueInd");
      annotations = this.getUnstructured().get(0).data().getLabValueInd();
	  } catch (IllegalArgumentException iae) {
	  	//ACD didn't return any annotations
  	}
	  return annotations;
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
  	List<MedicationAnnotation> annotations = new ArrayList<MedicationAnnotation>();
	  try {
      validateUnstructuredElementData("MedicationInd");
      annotations = this.getUnstructured().get(0).data().getMedicationInd();
  	} catch (IllegalArgumentException iae) {
	  	//ACD didn't return any annotations
	  }
	  return annotations;
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
	  List<Annotation> annotations = new ArrayList<Annotation>();
	  try {
      validateUnstructuredElementData("EmailAddressInd");
      annotations = this.getUnstructured().get(0).data().getEmailAddressInd();
  	} catch (IllegalArgumentException iae) {
	  	//ACD didn't return any annotations
	  }
	  return annotations;
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
	  List<Annotation> annotations = new ArrayList<Annotation>();
	  try {
      validateUnstructuredElementData("LocationInd");
      annotations = this.getUnstructured().get(0).data().getLocationInd();
  	} catch (IllegalArgumentException iae) {
	  	//ACD didn't return any annotations
  	}
	  return annotations;
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
	  List<Annotation> annotations = new ArrayList<Annotation>();
	  try {
      validateUnstructuredElementData("USPhoneNumberInd");
      annotations = this.getUnstructured().get(0).data().getUSPhoneNumberInd();
   } catch (IllegalArgumentException iae) {
  		//ACD didn't return any annotations
  	}
  	return annotations;
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
	  List<AssistanceAnnotation> annotations = new ArrayList<AssistanceAnnotation>();
  	try {
      validateUnstructuredElementData("SeeingAssistanceInd");
      annotations = this.getUnstructured().get(0).data().getSeeingAssistanceInd();
  	} catch (IllegalArgumentException iae) {
	  	//ACD didn't return any annotations
  	}
  	return annotations;
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
	  List<SectionAnnotation> annotations = new ArrayList<SectionAnnotation>();
  	try {
      validateUnstructuredElementData("SectionAnnotations");
      annotations = this.getUnstructured().get(0).data().getSectionAnnotations();
  	} catch (IllegalArgumentException iae) {
  		//ACD didn't return any annotations
  	}
  	return annotations;
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
	  List<NluEntity> annotations = new ArrayList<NluEntity>();
	  try {
      validateUnstructuredElementData("nluEntities");
      annotations = this.getUnstructured().get(0).data().getNluEntities();
  	} catch (IllegalArgumentException iae) {
  		//ACD didn't return any annotations
  	}
  	return annotations;
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
	  List<Relation> relations = new ArrayList<Relation>();
  	try {
      validateUnstructuredElementData("relations");
      relations = this.getUnstructured().get(0).data().getRelations();
  	} catch (IllegalArgumentException iae) {
  		//ACD didn't return any annotations
  	}
  	return relations;
  }

  /**
   * Gets all of the SpellCorrectedText objects in the container.
   *
   * @return the SpellCorrectedText objects
   */
  public List<SpellCorrectedText> getSpellCorrectedText() {
	  List<SpellCorrectedText> corrections = new ArrayList<SpellCorrectedText>();
  	try {
      validateUnstructuredElementData("spellCorrrectedText");
      corrections = this.getUnstructured().get(0).data().getSpellCorrectedText();
  	} catch (IllegalArgumentException iae) {
  		//ACD didn't return any annotations
  	}
  	return corrections;
  }

  /**
   * Gets all of the SpellingCorrections in the container.
   *
   * @return the SpellingCorrections objects
   */
  public List<SpellingCorrection> getSpellingCorrections() {
	  List<SpellingCorrection> corrections = new ArrayList<SpellingCorrection>();
  	try {
      validateUnstructuredElementData("spellingCorrections");
      corrections = this.getUnstructured().get(0).data().getSpellingCorrections();
  	} catch (IllegalArgumentException iae) {
  		//ACD didn't return any annotations
  	}
  	return corrections;
  }

  /**
   * Gets the temporalSpans.
   *
   * @return the temporalSpans
   */
  public List<Temporal> getTemporalSpans() {
  	List<Temporal> temporals = new ArrayList<Temporal>();
  	try {
      validateUnstructuredElementData("TemporalSpans");
      temporals = this.getUnstructured().get(0).data().getTemporalSpans();
  	} catch (IllegalArgumentException iae) {
  		//ACD didn't return any annotations
  	}
  	return temporals;
  }


  /*
   * Manually added method
   */

   /**
    * Gets the concept.
    * @param index position to retrieve
    * @return the concept or null if invalid index
    */
  public Concept getConcepts(int index) {
	  Concept concept = null;
	  try {
      validateUnstructuredElementData("Concepts");
      concept = this.getUnstructured().get(0).data().getConcepts().get(index);
	  } catch (IllegalArgumentException iae) {
	  	//ACD didn't return any annotations
	  }
	  return concept;
  }

  /*
   * Manually added method
   */

  /**
   * Gets the symptomDiseaseInd.
   *
   * @param index position to retrieve
   *
   * @return the symptomDiseaseInd or null if invalid index
   */

  public SymptomDisease getSymptomDisease(int index) {
	  SymptomDisease annotation = null;
	  try {
      validateUnstructuredElementData("SymptomDisease");
      annotation = this.getUnstructured().get(0).data().getSymptomDiseaseInd().get(index);
	  } catch (IllegalArgumentException iae) {
		//ACD didn't return any annotations
	  }
  	return annotation;
  }

  /*
   * Manually added method
   */

  /**
   * Gets the bathingAssistanceInd.
   *
   * @param index position to retrieve
   *
   * @return the bathingAssistanceInd or null if invalid index
   */
  public AssistanceAnnotation getBathingAssistance(int index) {
	  AssistanceAnnotation annotation = null;
	  try {
      validateUnstructuredElementData("BathingAssistance");
      annotation = this.getUnstructured().get(0).data().getBathingAssistanceInd().get(index);
  	} catch (IllegalArgumentException iae) {
	  	//ACD didn't return any annotations
	  }
	  return annotation;
  }

  /*
   * Manually added method
   */

  /**
   * Gets the dressingAssistanceInd.
   *
   * @param index position to retrieve
   *
   * @return the dressingAssistanceInd or null if index invalid
   */
  public AssistanceAnnotation getDressingAssistance(int index) {
	  AssistanceAnnotation annotation = null;
  	try {
      validateUnstructuredElementData("DressingAssistance");
      annotation = this.getUnstructured().get(0).data().getDressingAssistanceInd().get(index);
  	} catch (IllegalArgumentException iae) {
	  	//ACD didn't return any annotations
  	}
  	return annotation;
  }

  /*
   * Manually added method
   */

  /**
   * Gets the eatingAssistanceInd.
   *
   * @param index position to retrieve
   *
   * @return the eatingAssistanceInd or null if invalid index
   */
  public AssistanceAnnotation getEatingAssistance(int index) {
	  AssistanceAnnotation annotation = null;
    try {
      validateUnstructuredElementData("EatingAssistance");
      annotation = this.getUnstructured().get(0).data().getEatingAssistanceInd().get(index);
  	} catch (IllegalArgumentException iae) {
  		//ACD didn't return any annotations
  	}
  	return annotation;
  }

  /*
   * Manually added method
   */

  /**
   * Gets the walkingAssistanceInd.
   *
   * @param index position to retrieve
   *
   * @return the walkingAssistanceInd or null if invalid index
   */
  public AssistanceAnnotation getWalkingAssistance(int index) {
	  AssistanceAnnotation annotation = null;
	  try {
      validateUnstructuredElementData("WalkingAssistance");
      annotation = this.getUnstructured().get(0).data().getWalkingAssistanceInd().get(index);
	  } catch (IllegalArgumentException iae) {
	  	//ACD didn't return any annotations
  	}
	  return annotation;
  }

  /*
   * Manually added method
   */

  /**
   * Gets the toiletingAssistanceInd.
   *
   * @param index position to retrieve
   *
   * @return the toiletingAssistanceInd or null if invalid index
   */
  public AssistanceAnnotation getToiletingAssistance(int index) {
	  AssistanceAnnotation annotation = null;
	  try {
      validateUnstructuredElementData("ToiletingAssistance");
      annotation = this.getUnstructured().get(0).data().getToiletingAssistanceInd().get(index);
	  } catch (IllegalArgumentException iae) {
	  	//ACD didn't return any annotations
	  }
  	return annotation;
  }

  /*
   * Manually added method
   */

  /**
   * Gets the icaCancerDiagnosisInd.
   *
   * @param index position to retrieve
   *
   * @return the icaCancerDiagnosisInd or null if invalid index
   */
  public CancerDiagnosis getCancerDiagnosis(int index) {
	  CancerDiagnosis annotation = null;
	  try {
      validateUnstructuredElementData("CancerDiagnosis");
      annotation = this.getUnstructured().get(0).data().getIcaCancerDiagnosisInd().get(index);
  	} catch (IllegalArgumentException iae) {
  		//ACD didn't return any annotations
	  }
	  return annotation;
  }

  /*
   * Manually added method
   */

  /**
   * Gets the hypotheticalSpans.
   *
   * @param index position to retrieve
   *
   * @return the hypotheticalSpan or null if invalid index
   */
  public Annotation getHypotheticalSpans(int index) {
	  Annotation annotation = null;
	  try {
      validateUnstructuredElementData("HypotheticalSpans");
      annotation = this.getUnstructured().get(0).data().getHypotheticalSpans().get(index);
	  } catch (IllegalArgumentException iae) {
	  	//ACD didn't return any annotations
	  }
	  return annotation;
  }

  /*
   * Manually added method
   */

  /**
   * Gets the allergyInd.
   *
   * @param index position to retrieve
   *
   * @return the allergyInd or null if invalid index
   */
  public Annotation getAllergy(int index) {
	  Annotation annotation = null;
  	try {
      validateUnstructuredElementData("Allergy");
      annotation = this.getUnstructured().get(0).data().getAllergyInd().get(index);
	  } catch (IllegalArgumentException iae) {
	  	//ACD didn't return any annotations
	  }
  	return annotation;
  }

  /**
   * Gets the AllergyMedicationInd.
   *
   * @param index position to retrieve
   *
   * @return the allergyMedicationInd
   */
  public AllergyMedicationInd getAllergyMedication(int index) {
  	AllergyMedicationInd annotation = null;
  	try {
      validateUnstructuredElementData("MedicationAllergy");
      annotation = this.getUnstructured().get(0).data().getAllergyMedicationInd().get(index);
  	} catch (IllegalArgumentException iae) {
  		//ACD didn't return any annotations
  	}
  	return annotation;
  }

  /*
   * Manually added method
   */

  /**
   * Gets the negatedSpans.
   *
   * @param index position to retrieve
   *
   * @return the negatedSpans or null in invalid index
   */
  public NegatedSpan getNegatedSpans(int index) {
	  NegatedSpan negation = null;
  	try {
      validateUnstructuredElementData("NegatedSpans");
      negation = this.getUnstructured().get(0).data().getNegatedSpans().get(index);
  	} catch (IllegalArgumentException iae) {
  		//ACD didn't return any annotations
  	}
  	return negation;
  }

  /*
   * Manually added method
   */

  /**
   * Gets the conceptValues.
   *
   * @param index position to retrieve
   *
   * @return the conceptValues or null if invalid index
   */
  public ConceptValue getConceptValues(int index) {
	  ConceptValue value = null;
  	try {
      validateUnstructuredElementData("ConceptValues");
      value = this.getUnstructured().get(0).data().getConceptValues().get(index);
  	} catch (IllegalArgumentException iae) {
  		//ACD didn't return any annotations
  	}
  	return value;
  }

  /*
   * Manually added method
   */

  /**
   * Gets the procedureInd.
   *
   * @param index position to retrieve
   *
   * @return the procedureInd or null if invalid index
   */
  public Procedure getProcedure(int index) {
	  Procedure procedure = null;
  	try {
      validateUnstructuredElementData("Procedure");
      procedure = this.getUnstructured().get(0).data().getProcedureInd().get(index);
  	} catch (IllegalArgumentException iae) {
  		//ACD didn't return any annotations
  	}
  	return procedure;
  }

  /*
   * Manually added method
   */

  /**
   * Gets the smokingInd.
   *
   * @param index position to retrieve
   *
   * @return the smokingInd or null if invalid index
   */
  public Smoking getSmoking(int index) {
	  Smoking annotation = null;
  	try {
      validateUnstructuredElementData("Smoking");
      annotation = this.getUnstructured().get(0).data().getSmokingInd().get(index);
  	} catch (IllegalArgumentException iae) {
  		//ACD didn't return any annotations
  	}
  	return annotation;
  }

  /*
   * Manually added method
   */

  /**
   * Gets the organizationInd.
   *
   * @param index position to retrieve
   *
   * @return the organizationInd or null if invalid index
   */
  public Annotation getOrganization(int index) {
	  Annotation annotation = null;
	  try {
      validateUnstructuredElementData("Organization");
      annotation = this.getUnstructured().get(0).data().getOrganizationInd().get(index);
	  } catch (IllegalArgumentException iae) {
  		//ACD didn't return any annotations
  	}
  	return annotation;
  }

  /*
   * Manually added method
   */

  /**
   * Gets the personInd.
   *
   * @param index position to retrieve
   *
   * @return the personInd or null if invalid index
   */
  public Annotation getPerson(int index) {
	  Annotation annotation = null;
  	try {
      validateUnstructuredElementData("Person");
      annotation = this.getUnstructured().get(0).data().getPersonInd().get(index);
  	} catch (IllegalArgumentException iae) {
  		//ACD didn't return any annotations
  	}
  	return annotation;
  }

  /*
   * Manually added method
   */

  /**
   * Gets the medicalInstitutionInd.
   *
   * @param index position to retrieve
   *
   * @return the medicalInstitutionInd or null if invalid index
   */
  public Annotation getMedicalInstitution(int index) {
	  Annotation annotation = null;
  	try {
      validateUnstructuredElementData("MedicalInstitution");
      annotation = this.getUnstructured().get(0).data().getMedicalInstitutionInd().get(index);
	  } catch (IllegalArgumentException iae) {
  		//ACD didn't return any annotations
  	}
  	return annotation;
  }

  /*
   * Manually added method
   */

  /**
   * Gets the attributeValues.
   *
   * @param index position to retrieve
   *
   * @return the attributeValues or null if invalid index
   */
  public AttributeValueAnnotation getAttributeValues(int index) {
	  AttributeValueAnnotation annotation = null;
	  try {
      validateUnstructuredElementData("AttributeValues");
      annotation = this.getUnstructured().get(0).data().getAttributeValues().get(index);
	  } catch (IllegalArgumentException iae) {
  		//ACD didn't return any annotations
	  }
	  return annotation;
  }

  /*
   * Manually added method
   */

  /**
   * Gets the ejectionFractionInd.
   *
   * @param index position to retrieve
   *
   * @return the ejectionFractionInd or null if invalid index
   */
  public EjectionFractionAnnotation getEjectionFractionInd(int index) {
	  EjectionFractionAnnotation annotation = null;
  	try {
      validateUnstructuredElementData("EjectionFractionInd");
      annotation = this.getUnstructured().get(0).data().getEjectionFractionInd().get(index);
  	} catch (IllegalArgumentException iae) {
  		//ACD didn't return any annotations
  	}
  	return annotation;
  }

  /*
   * Manually added method
   */

  /**
   * Gets the labValueInd.
   *
   * @param index position to retrieve
   *
   * @return the labValueInd or null if invalid index
   */
  public LabValueAnnotation getLabValueInd(int index) {
	  LabValueAnnotation annotation = null;
	  try {
      validateUnstructuredElementData("LabValueInd");
      annotation = this.getUnstructured().get(0).data().getLabValueInd().get(index);
  	} catch (IllegalArgumentException iae) {
	  	//ACD didn't return any annotations
	  }
	  return annotation;
  }

  /*
   * Manually added method
   */

  /**
   * Gets the medicationInd.
   *
   * @param index position to retrieve
   *
   * @return the medicationInd or null if invalid index
   */
  public MedicationAnnotation getMedicationInd(int index) {
	  MedicationAnnotation annotation = null;
  	try {
      validateUnstructuredElementData("MedicationInd");
      annotation = this.getUnstructured().get(0).data().getMedicationInd().get(index);
	  } catch (IllegalArgumentException iae) {
	  	//ACD didn't return any annotations
	  }
	  return annotation;
  }

  /*
   * Manually added method
   */

  /**
   * Gets the emailAddressInd.
   *
   * @param index position to retrieve
   *
   * @return the emailAddressInd or null if invalid index
   */
  public Annotation getEmailAddressInd(int index) {
	  Annotation annotation = null;
  	try {
      validateUnstructuredElementData("EmailAddressInd");
      annotation = this.getUnstructured().get(0).data().getEmailAddressInd().get(index);
  	} catch (IllegalArgumentException iae) {
  		//ACD didn't return any annotations
  	}
	  return annotation;
  }

  /*
   * Manually added method
   */

  /**
   * Gets the locationInd.
   *
   * @param index position to retrieve
   *
   * @return the locationInd or null if invalid index
   */
  public Annotation getLocationInd(int index) {
	  Annotation annotation = null;
	  try {
      validateUnstructuredElementData("LocationInd");
      annotation = this.getUnstructured().get(0).data().getLocationInd().get(index);
	  } catch (IllegalArgumentException iae) {
	  	//ACD didn't return any annotations
  	}
	  return annotation;
  }

  /*
   * Manually added method
   */

  /**
   * Gets the uSPhoneNumberInd.
   *
   * @param index position to retrieve
   *
   * @return the uSPhoneNumberInd or null if invalid index
   */
  public Annotation getUSPhoneNumberInd(int index) {
	  Annotation annotation = null;
	  try {
      validateUnstructuredElementData("USPhoneNumberInd");
       annotation = this.getUnstructured().get(0).data().getUSPhoneNumberInd().get(index);
	  } catch (IllegalArgumentException iae) {
		  //ACD didn't return any annotations
	  }
  	return annotation;
  }

  /*
   * Manually added method
   */

  /**
   * Gets the seeingAssistanceInd.
   *
   * @param index position to retrieve
   *
   * @return the seeingAssistanceInd or null if invalid index
   */
  public AssistanceAnnotation getSeeingAssistanceInd(int index) {
	  AssistanceAnnotation annotation = null;
	  try {
      validateUnstructuredElementData("SeeingAssistanceInd");
      annotation = this.getUnstructured().get(0).data().getSeeingAssistanceInd().get(index);
    } catch (IllegalArgumentException iae) {
	  	//ACD didn't return any annotations
	  }
	  return annotation;
  }


  /*
   * Manually added method
   */

  /**
   * Gets the sectionAnnotations.
   *
   * @param index position to retrieve
   *
   * @return the sectionAnnotations or null if invalid index
   */
  public SectionAnnotation getSectionAnnotations(int index) {
	  SectionAnnotation annotation = null;
    try {
      validateUnstructuredElementData("SectionAnnotations");
      annotation = this.getUnstructured().get(0).data().getSectionAnnotations().get(index);
	  } catch (IllegalArgumentException iae) {
	  	//ACD didn't return any annotations
	  }
	  return annotation;
  }

  /*
   * Manually added method
   */

  /**
   * Gets the NluEntity.
   * @param index position to retrieve
   *
   * @return the NluEntity or null if invalid index
   */
  public NluEntity getNluEntity(int index) {
	  NluEntity annotation = null;
	  try {
      validateUnstructuredElementData("nluEntities");
      annotation = this.getUnstructured().get(0).data().getNluEntities().get(index);
	  } catch (IllegalArgumentException iae) {
	  	//ACD didn't return any annotations
	  }
	  return annotation;
  }

  /*
   * Manually added method
   */

  /**
   * Gets the Relation.
   *
   * @param index position to retrieve
   *
   * @return the Relation or null if invalid index
   */
  public Relation getRelation(int index) {
	  Relation annotation = null;
	  try {
      validateUnstructuredElementData("relations");
      annotation = this.getUnstructured().get(0).data().getRelations().get(index);
	  } catch (IllegalArgumentException iae) {
  		//ACD didn't return any annotations
  	}
  	return annotation;
  }

  /**
   * Gets the SpellCorrectedText.
   *
   * @param index position to retrieve
   *
   * @return the SpellCorrectedText or null if invalid index
   */
  public SpellCorrectedText getSpellCorrectedText(int index) {
	  SpellCorrectedText annotation = null;
	  try {
      validateUnstructuredElementData("spellCorrrectedText");
      annotation = this.getUnstructured().get(0).data().getSpellCorrectedText().get(index);
	  } catch (IllegalArgumentException iae) {
	  	//ACD didn't return any annotations
	  }
  	return annotation;
  }

  /**
   * Gets SpellingCorrections at the given index.
   *
   * @param index position to retrieve
   *
   * @return the SpellingCorrection or null if invalid index
   */
  public SpellingCorrection getSpellingCorrections(int index) {
	  SpellingCorrection annotation = null;
	  try {
      validateUnstructuredElementData("spellingCorrections");
      annotation = this.getUnstructured().get(0).data().getSpellingCorrections().get(index);
	  } catch (IllegalArgumentException iae) {
	  	//ACD didn't return any annotations
  	}
  	return annotation;
  }

  /**
   * Gets the temporalSpans at given index.
   *
   * @param index position to retrieve
   *
   * @return the temporalSpan or null in invalid index
   */
  public Temporal getTemporalSpans(int index) {
	  Temporal temporal = null;
  	try {
      validateUnstructuredElementData("TemporalSpans");
      temporal = this.getUnstructured().get(0).data().getTemporalSpans().get(index);
  	} catch (IllegalArgumentException iae) {
  		//ACD didn't return any annotations
  	}
  	return temporal;
  }

  /**
   * Gets the lines scopes.
   *
   * @return the lines scopes
   */
  public List<Annotation> getLines() {
	  List<Annotation> annotations = new ArrayList<Annotation>();
	  try {
      validateUnstructuredElementData("lines");
      annotations = this.getUnstructured().get(0).data().getLines();
   } catch (IllegalArgumentException iae) {
  		//ACD didn't return any annotations
  	}
  	return annotations;
  }

  /**
   * Gets the line scope at given index.
   *
   * @param index position to retrieve
   *
   * @return the line scope
   */
  public Annotation getLines(int index) {
  	Annotation annotation = null;
	  try {
      validateUnstructuredElementData("lines");
      annotation = this.getUnstructured().get(0).data().getLines().get(index);
	  } catch (IllegalArgumentException iae) {
	  	//ACD didn't return any annotations
  	}
  	return annotation;
  }

  /**
   * Gets the sentences scopes.
   *
   * @return the sentences scopes
   */
  public List<Annotation> getSentences() {
  	List<Annotation> annotations = new ArrayList<Annotation>();
	  try {
      validateUnstructuredElementData("sentences");
      annotations = this.getUnstructured().get(0).data().getSentences();
	  } catch (IllegalArgumentException iae) {
	  	//ACD didn't return any annotations
  	}
  	return annotations;
  }

  /**
   * Gets the sentence scope at given index.
   *
   * @param index position to retrieve
   *
   * @return the sentence scope
   */
  public Annotation getSentences(int index) {
  	Annotation annotation = null;
	  try {
      validateUnstructuredElementData("sentences");
      annotation = this.getUnstructured().get(0).data().getSentences().get(index);
	  } catch (IllegalArgumentException iae) {
	  	//ACD didn't return any annotations
  	}
  	return annotation;
  }

  /**
   * Gets the paragraphs scopes.
   *
   * @return the paragraphs scopes
   */
  public List<Annotation> getParagraphs() {
  	List<Annotation> annotations = new ArrayList<Annotation>();
	  try {
      validateUnstructuredElementData("paragraphs");
      annotations = this.getUnstructured().get(0).data().getParagraphs();
	  } catch (IllegalArgumentException iae) {
	  	//ACD didn't return any annotations
  	}
  	return annotations;
  }

  /**
   * Gets the paragraph scope at given index.
   *
   * @param index position to retrieve
   *
   * @return the paragraph scope
   */
  public Annotation getParagraphs(int index) {
  	Annotation annotation = null;
	  try {
      validateUnstructuredElementData("paragraphs");
      annotation = this.getUnstructured().get(0).data().getParagraphs().get(index);
	  } catch (IllegalArgumentException iae) {
	  	//ACD didn't return any annotations
  	}
  	return annotation;
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
