/*
 * Copyright 2018, 2020 IBM Corp. All Rights Reserved.
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
package com.ibm.watson.health.acd.v1.common;

import java.util.List;

import org.junit.Assert;

import com.ibm.watson.health.acd.v1.model.Annotation;
import com.ibm.watson.health.acd.v1.model.AssistanceAnnotation;
import com.ibm.watson.health.acd.v1.model.AttributeValueAnnotation;
import com.ibm.watson.health.acd.v1.model.CancerDiagnosis;
import com.ibm.watson.health.acd.v1.model.Concept;
import com.ibm.watson.health.acd.v1.model.ConceptValue;
import com.ibm.watson.health.acd.v1.model.EjectionFractionAnnotation;
import com.ibm.watson.health.acd.v1.model.LabValueAnnotation;
import com.ibm.watson.health.acd.v1.model.MedicationAnnotation;
import com.ibm.watson.health.acd.v1.model.NegatedSpan;
import com.ibm.watson.health.acd.v1.model.NluEntity;
import com.ibm.watson.health.acd.v1.model.Procedure;
import com.ibm.watson.health.acd.v1.model.Relation;
import com.ibm.watson.health.acd.v1.model.SectionAnnotation;
import com.ibm.watson.health.acd.v1.model.Smoking;
import com.ibm.watson.health.acd.v1.model.SpellCorrectedText;
import com.ibm.watson.health.acd.v1.model.SpellingCorrection;
import com.ibm.watson.health.acd.v1.model.SymptomDisease;
import com.ibm.watson.health.acd.v1.model.UnstructuredContainer;

public class TestUnstructuredContainer {

	public static void testUnstructuredContainer(UnstructuredContainer container) {
		List<Annotation> allergyAnnotations = container.getAllergy();
		if (allergyAnnotations != null && !allergyAnnotations.isEmpty()) {
			for (Annotation annotation : allergyAnnotations) {
				TestAnnotation.testAnnotation(annotation);
			}
			Annotation annotation = container.getAllergy(0);
			Assert.assertNotNull(annotation);
		}
		List<AttributeValueAnnotation> attributeValues = container.getAttributeValues();
		if (attributeValues != null && !attributeValues.isEmpty()) {
			for (AttributeValueAnnotation annotation : attributeValues) {
				TestAttributeAnnotation.testAttributeValue(annotation);
			}
			AttributeValueAnnotation firstValue = container.getAttributeValues(0);
			Assert.assertNotNull(firstValue);
		}
		List<AssistanceAnnotation> bathingAnnotations = container.getBathingAssistance();
		if (bathingAnnotations != null && !bathingAnnotations.isEmpty()) {
			for (AssistanceAnnotation annotation : bathingAnnotations) {
				TestAssistanceAnnotation.testAssistanceAnnotation(annotation);
			}
			AssistanceAnnotation annotation = container.getBathingAssistance(0);
			Assert.assertNotNull(annotation);
		}
		List<CancerDiagnosis> cancerAnnotations = container.getCancerDiagnosis();
		if (cancerAnnotations != null && !cancerAnnotations.isEmpty()) {
			for (CancerDiagnosis annotation : cancerAnnotations) {
				TestCancerAnnotation.testCancerAnnotation(annotation);
			}
			CancerDiagnosis annotation = container.getCancerDiagnosis(0);
			Assert.assertNotNull(annotation);
		}
		List<Concept> concepts = container.getConcepts();
		if (concepts != null && !concepts.isEmpty()) {
			for (Concept concept : concepts) {
				TestConcept.testConcept(concept);
			}
			Concept concept = container.getConcepts(0);
			Assert.assertNotNull(concept);
		}
//		List<ConceptValue> conceptValues = container.getConceptValues();
//		if (conceptValues != null && !conceptValues.isEmpty()) {
//			for (ConceptValue value : conceptValues) {
//				TestConceptValue.testConceptValue(value);
//			}
//			ConceptValue value = container.getConceptValues(0);
//			Assert.assertNotNull(value);
//		}
		List<AssistanceAnnotation> dressingAnnotations = container.getDressingAssistance();
		if (dressingAnnotations != null && !dressingAnnotations.isEmpty()) {
			for (AssistanceAnnotation annotation : dressingAnnotations) {
				TestAssistanceAnnotation.testAssistanceAnnotation(annotation);
			}
			AssistanceAnnotation annotation = container.getDressingAssistance(0);
			Assert.assertNotNull(annotation);
		}
		List<AssistanceAnnotation> eatingAnnotation = container.getEatingAssistance();
		if (eatingAnnotation != null && !eatingAnnotation.isEmpty()) {
			for (AssistanceAnnotation annotation : eatingAnnotation) {
				TestAssistanceAnnotation.testAssistanceAnnotation(annotation);
			}
			AssistanceAnnotation annotation = container.getEatingAssistance(0);
			Assert.assertNotNull(annotation);
		}
		List<EjectionFractionAnnotation> ejectionAnnotations = container.getEjectionFractionInd();
		if (ejectionAnnotations != null && !ejectionAnnotations.isEmpty()) {
			for (EjectionFractionAnnotation annotation : ejectionAnnotations) {
				TestEjectionFractionAnnotation.testEjectionFractionAnnotation(annotation);
			}
			EjectionFractionAnnotation annotation = container.getEjectionFractionInd(0);
			Assert.assertNotNull(annotation);
		}
		List<Annotation> emailAnnotations = container.getEmailAddressInd();
		if (emailAnnotations != null && !emailAnnotations.isEmpty()) {
			for (Annotation annotation : emailAnnotations) {
				TestAnnotation.testAnnotation(annotation);
			}
			Annotation annotation = container.getEmailAddressInd(0);
			Assert.assertNotNull(annotation);
		}
		List<Annotation> hypotheticals = container.getHypotheticalSpans();
		if (hypotheticals != null && !hypotheticals.isEmpty()) {
			for (Annotation annotation : hypotheticals) {
				TestAnnotation.testAnnotation(annotation);
			}
			Annotation annotation = container.getHypotheticalSpans(0);
			Assert.assertNotNull(annotation);
		}
		List<LabValueAnnotation> labValues = container.getLabValueInd();
		if (labValues != null && !labValues.isEmpty()) {
			for (LabValueAnnotation annotation : labValues) {
				TestLabValueAnnotation.testLabValueAnnotation(annotation);
			}
			LabValueAnnotation annotation = container.getLabValueInd(0);
			Assert.assertNotNull(annotation);
		}
		List<Annotation> locationAnnotations = container.getLocationInd();
		if (locationAnnotations != null && !locationAnnotations.isEmpty()) {
			for (Annotation annotation : locationAnnotations) {
				TestAnnotation.testAnnotation(annotation);
			}
			Annotation annotation = container.getLocationInd(0);
			Assert.assertNotNull(annotation);
		}
		List<Annotation> medicalInstitutions = container.getMedicalInstitution();
		if (medicalInstitutions != null && !medicalInstitutions.isEmpty()) {
			for (Annotation annotation : medicalInstitutions) {
				TestAnnotation.testAnnotation(annotation);
			}
			Annotation annotation = container.getMedicalInstitution(0);
			Assert.assertNotNull(annotation);
		}
		List<MedicationAnnotation> medicationAnnotations = container.getMedicationInd();
		if (medicationAnnotations != null && !medicationAnnotations.isEmpty()) {
			for (MedicationAnnotation annotation : medicationAnnotations) {
				TestMedicationAnnotation.testMedicationAnnotation(annotation);
			}
			MedicationAnnotation annotation = container.getMedicationInd(0);
			Assert.assertNotNull(annotation);
		}
		List<NegatedSpan> negations = container.getNegatedSpans();
		if (negations != null && !negations.isEmpty()) {
			for (NegatedSpan annotation : negations) {
				TestNegatedSpan.testNegatedSpan(annotation);
			}
			NegatedSpan annotation = container.getNegatedSpans(0);
			Assert.assertNotNull(annotation);
		}
		List<NluEntity> nluEntities = container.getNluEntities();
		if (nluEntities != null && !nluEntities.isEmpty()) {
			for (NluEntity annotation : nluEntities) {
				TestNluEntityAnnotation.testNluEntity(annotation);
			}
			NluEntity annotation = container.getNluEntity(0);
			Assert.assertNotNull(annotation);
		}
		List<Annotation> organizationAnnotations = container.getOrganization();
		if (organizationAnnotations != null && !organizationAnnotations.isEmpty()) {
			for (Annotation annotation : organizationAnnotations) {
				TestAnnotation.testAnnotation(annotation);
			}
			Annotation annotation = container.getOrganization(0);
			Assert.assertNotNull(annotation);
		}
		List<Annotation> personAnntations = container.getPerson();
		if (personAnntations != null && !personAnntations.isEmpty()) {
			for (Annotation annotation : personAnntations) {
				TestAnnotation.testAnnotation(annotation);
			}
			Annotation annotation = container.getPerson(0);
			Assert.assertNotNull(annotation);
		}
		List<Procedure> procedures = container.getProcedure();
		if (procedures != null && !procedures.isEmpty()) {
			for (Procedure annotation : procedures) {
				TestProcedureAnnotation.testProcedureAnnotation(annotation);
			}
			Procedure annotation = container.getProcedure(0);
			Assert.assertNotNull(annotation);
		}
		List<Relation> relations = container.getRelations();
		if (relations != null && !relations.isEmpty()) {
			for (Relation annotation : relations) {
				TestRelationAnnotation.testRelationAnnotation(annotation);
			}
			Relation annotation = container.getRelation(0);
			Assert.assertNotNull(annotation);
		}
		List<SectionAnnotation> sectionAnnotations = container.getSectionAnnotations();
		if (sectionAnnotations != null && !sectionAnnotations.isEmpty()) {
			for (SectionAnnotation annotation : sectionAnnotations) {
				TestSectionAnnotation.testSectionAnnotation(annotation);
			}
			SectionAnnotation annotation = container.getSectionAnnotations(0);
			Assert.assertNotNull(annotation);
		}
		List<AssistanceAnnotation> seeingAnnoations = container.getSeeingAssistanceInd();
		if (seeingAnnoations != null && !seeingAnnoations.isEmpty()) {
			for (AssistanceAnnotation annotation : seeingAnnoations) {
				TestAssistanceAnnotation.testAssistanceAnnotation(annotation);
			}
			AssistanceAnnotation annotation = container.getSeeingAssistanceInd(0);
			Assert.assertNotNull(annotation);
		}
		List<Smoking> smokingAnnotaions = container.getSmoking();
		if (smokingAnnotaions != null && !smokingAnnotaions.isEmpty()) {
			for (Smoking annotation : smokingAnnotaions) {
				TestSmokingAnnotation.testSmokingAnnotation(annotation);
			}
			Smoking annotation = container.getSmoking(0);
			Assert.assertNotNull(annotation);
		}
		List<SpellCorrectedText> textCorrections = container.getSpellCorrectedText();
		if (textCorrections != null && !textCorrections.isEmpty()) {
			for (SpellCorrectedText annotation : textCorrections) {
				TestTextCorrection.testTextCorrection(annotation);
			}
			SpellCorrectedText correction = container.getSpellCorrectedText(0);
			Assert.assertNotNull(correction);
		}
		List<SpellingCorrection> spellingCorrections = container.getSpellingCorrections();
		if (spellingCorrections != null && !spellingCorrections.isEmpty()) {
			for (SpellingCorrection annotation : spellingCorrections) {
				TestSpellCorrectionAnnotation.testSpellCorrectionAnnotation(annotation);
			}
			SpellingCorrection correction = container.getSpellingCorrections(0);
			Assert.assertNotNull(correction);
		}
		List<SymptomDisease> symptomAnnotations = container.getSymptomDisease();
		if (symptomAnnotations != null && !symptomAnnotations.isEmpty()) {
			for (SymptomDisease annotation : symptomAnnotations) {
				TestSymptomAnnotation.testSymptomAnnotation(annotation);
			}
			SymptomDisease annotation = container.getSymptomDisease(0);
			Assert.assertNotNull(annotation);
		}
		List<AssistanceAnnotation> toiletingAnnotations = container.getToiletingAssistance();
		if (toiletingAnnotations != null && !toiletingAnnotations.isEmpty()) {
			for (AssistanceAnnotation annotation : toiletingAnnotations) {
				TestAssistanceAnnotation.testAssistanceAnnotation(annotation);
			}
			AssistanceAnnotation annotation = container.getToiletingAssistance(0);
			Assert.assertNotNull(annotation);
		}
		List<Annotation> phoneAnnotations = container.getUSPhoneNumberInd();
		if (phoneAnnotations != null && !phoneAnnotations.isEmpty()) {
			for (Annotation annotation : phoneAnnotations) {
				TestAnnotation.testAnnotation(annotation);
			}
			Annotation annotation = container.getUSPhoneNumberInd(0);
			Assert.assertNotNull(annotation);
		}
		List<AssistanceAnnotation> walkingAnnotations = container.getWalkingAssistance();
		if (walkingAnnotations != null && !walkingAnnotations.isEmpty()) {
			for (AssistanceAnnotation annotation : walkingAnnotations) {
				TestAssistanceAnnotation.testAssistanceAnnotation(annotation);
			}
			AssistanceAnnotation annotation = container.getWalkingAssistance(0);
			Assert.assertNotNull(annotation);
		}
	}
}
