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
package com.ibm.watson.health.acd.v1.common;

import java.util.List;

import org.junit.Assert;

import com.ibm.watson.health.acd.v1.model.Annotation;
import com.ibm.watson.health.acd.v1.model.AnnotatorFlow;
import com.ibm.watson.health.acd.v1.model.AssistanceAnnotation;
import com.ibm.watson.health.acd.v1.model.AttributeValueAnnotation;
import com.ibm.watson.health.acd.v1.model.CancerDiagnosis;
import com.ibm.watson.health.acd.v1.model.Concept;
import com.ibm.watson.health.acd.v1.model.ConceptValue;
import com.ibm.watson.health.acd.v1.model.ContainerGroup;
import com.ibm.watson.health.acd.v1.model.EjectionFractionAnnotation;
import com.ibm.watson.health.acd.v1.model.Flow;
import com.ibm.watson.health.acd.v1.model.FlowEntry;
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
import com.ibm.watson.health.acd.v1.model.Temporal;
import com.ibm.watson.health.acd.v1.model.UnstructuredContainer;

public class TestContainerGroup {

	public static void testContainerGroups(ContainerGroup containerGroup) {
		List<Annotation> allergyAnnotations = containerGroup.getAllergy();
		if (allergyAnnotations != null && !allergyAnnotations.isEmpty()) {
			for (Annotation annotation : allergyAnnotations) {
				TestAnnotation.testAnnotation(annotation);
			}
			Annotation annotation = containerGroup.getAllergy(0);
			Assert.assertNotNull(annotation);
		}
		List<AnnotatorFlow> annotatorFlows = containerGroup.getAnnotatorFlows();
		if (annotatorFlows != null && !annotatorFlows.isEmpty()) {
			for (AnnotatorFlow annoFlow : annotatorFlows) {
				Flow flow = annoFlow.flow();
				Assert.assertNotNull(flow);
				List<FlowEntry> flowEntries = flow.elements();
				if (flowEntries != null && !flowEntries.isEmpty()) {
					for (FlowEntry entry : flowEntries) {
						Assert.assertNotNull(entry);
					}
				}
			}
		}
		List<AttributeValueAnnotation> attributeValues = containerGroup.getAttributeValues();
		if (attributeValues != null && !attributeValues.isEmpty()) {
			for (AttributeValueAnnotation annotation : attributeValues) {
				TestAttributeAnnotation.testAttributeValue(annotation);
			}
			AttributeValueAnnotation firstValue = containerGroup.getAttributeValues(0);
			Assert.assertNotNull(firstValue);
		}
		List<AssistanceAnnotation> bathingAnnotations = containerGroup.getBathingAssistance();
		if (bathingAnnotations != null && !bathingAnnotations.isEmpty()) {
			for (AssistanceAnnotation annotation : bathingAnnotations) {
				TestAssistanceAnnotation.testAssistanceAnnotation(annotation);
			}
			AssistanceAnnotation annotation = containerGroup.getBathingAssistance(0);
			Assert.assertNotNull(annotation);
		}
		List<CancerDiagnosis> cancerAnnotations = containerGroup.getCancerDiagnosis();
		if (cancerAnnotations != null && !cancerAnnotations.isEmpty()) {
			for (CancerDiagnosis annotation : cancerAnnotations) {
				TestCancerAnnotation.testCancerAnnotation(annotation);
			}
			CancerDiagnosis annotation = containerGroup.getCancerDiagnosis(0);
			Assert.assertNotNull(annotation);
		}
		List<Concept> concepts = containerGroup.getConcepts();
		if (concepts != null && !concepts.isEmpty()) {
			for (Concept concept : concepts) {
				TestConcept.testConcept(concept);
			}
			Concept concept = containerGroup.getConcepts(0);
			Assert.assertNotNull(concept);
		}
		List<ConceptValue> conceptValues = containerGroup.getConceptValues();
		if (conceptValues != null && !conceptValues.isEmpty()) {
			for (ConceptValue value : conceptValues) {

				TestConceptValue.testConceptValue(value);
			}
			ConceptValue value = containerGroup.getConceptValues(0);
			Assert.assertNotNull(value);
		}
		List<AssistanceAnnotation> dressingAnnotations = containerGroup.getDressingAssistance();
		if (dressingAnnotations != null && !dressingAnnotations.isEmpty()) {
			for (AssistanceAnnotation annotation : dressingAnnotations) {
				TestAssistanceAnnotation.testAssistanceAnnotation(annotation);
			}
			AssistanceAnnotation annotation = containerGroup.getDressingAssistance(0);
			Assert.assertNotNull(annotation);
		}
		List<AssistanceAnnotation> eatingAnnotation = containerGroup.getEatingAssistance();
		if (eatingAnnotation != null && !eatingAnnotation.isEmpty()) {
			for (AssistanceAnnotation annotation : eatingAnnotation) {
				TestAssistanceAnnotation.testAssistanceAnnotation(annotation);
			}
			AssistanceAnnotation annotation = containerGroup.getEatingAssistance(0);
			Assert.assertNotNull(annotation);
		}
		List<EjectionFractionAnnotation> ejectionAnnotations = containerGroup.getEjectionFractionInd();
		if (ejectionAnnotations != null && !ejectionAnnotations.isEmpty()) {
			for (EjectionFractionAnnotation annotation : ejectionAnnotations) {
				TestEjectionFractionAnnotation.testEjectionFractionAnnotation(annotation);
			}
			EjectionFractionAnnotation annotation = containerGroup.getEjectionFractionInd(0);
			Assert.assertNotNull(annotation);
		}
		List<Annotation> emailAnnotations = containerGroup.getEmailAddressInd();
		if (emailAnnotations != null && !emailAnnotations.isEmpty()) {
			for (Annotation annotation : emailAnnotations) {
				TestAnnotation.testAnnotation(annotation);
			}
			Annotation annotation = containerGroup.getEmailAddressInd(0);
			Assert.assertNotNull(annotation);
		}
		List<Annotation> hypotheticals = containerGroup.getHypotheticalSpans();
		if (hypotheticals != null && !hypotheticals.isEmpty()) {
			for (Annotation annotation : hypotheticals) {
				TestAnnotation.testAnnotation(annotation);
			}
			Annotation annotation = containerGroup.getHypotheticalSpans(0);
			Assert.assertNotNull(annotation);
		}
		List<LabValueAnnotation> labValues = containerGroup.getLabValueInd();
		if (labValues != null && !labValues.isEmpty()) {
			for (LabValueAnnotation annotation : labValues) {
				TestLabValueAnnotation.testLabValueAnnotation(annotation);
			}
			LabValueAnnotation annotation = containerGroup.getLabValueInd(0);
			Assert.assertNotNull(annotation);
		}
		List<Annotation> locationAnnotations = containerGroup.getLocationInd();
		if (locationAnnotations != null && !locationAnnotations.isEmpty()) {
			for (Annotation annotation : locationAnnotations) {
				TestAnnotation.testAnnotation(annotation);
			}
			Annotation annotation = containerGroup.getLocationInd(0);
			Assert.assertNotNull(annotation);
		}
		List<Annotation> medicalInstitutions = containerGroup.getMedicalInstitution();
		if (medicalInstitutions != null && !medicalInstitutions.isEmpty()) {
			for (Annotation annotation : medicalInstitutions) {
				TestAnnotation.testAnnotation(annotation);
			}
			Annotation annotation = containerGroup.getMedicalInstitution(0);
			Assert.assertNotNull(annotation);
		}
		List<MedicationAnnotation> medicationAnnotations = containerGroup.getMedicationInd();
		if (medicationAnnotations != null && !medicationAnnotations.isEmpty()) {
			for (MedicationAnnotation annotation : medicationAnnotations) {
				TestMedicationAnnotation.testMedicationAnnotation(annotation);
			}
			MedicationAnnotation annotation = containerGroup.getMedicationInd(0);
			Assert.assertNotNull(annotation);
		}
		List<NegatedSpan> negations = containerGroup.getNegatedSpans();
		if (negations != null && !negations.isEmpty()) {
			for (NegatedSpan annotation : negations) {
				TestNegatedSpan.testNegatedSpan(annotation);
			}
			NegatedSpan annotation = containerGroup.getNegatedSpans(0);
			Assert.assertNotNull(annotation);
		}
		List<NluEntity> nluEntities = containerGroup.getNluEntities();
		if (nluEntities != null && !nluEntities.isEmpty()) {
			for (NluEntity annotation : nluEntities) {
				TestNluEntityAnnotation.testNluEntity(annotation);
			}
			NluEntity annotation = containerGroup.getNluEntity(0);
			Assert.assertNotNull(annotation);
		}
		List<Annotation> organizationAnnotations = containerGroup.getOrganization();
		if (organizationAnnotations != null && !organizationAnnotations.isEmpty()) {
			for (Annotation annotation : organizationAnnotations) {
				TestAnnotation.testAnnotation(annotation);
			}
			Annotation annotation = containerGroup.getOrganization(0);
			Assert.assertNotNull(annotation);
		}
		List<Annotation> personAnnotations = containerGroup.getPerson();
		if (personAnnotations != null && !personAnnotations.isEmpty()) {
			for (Annotation annotation : personAnnotations) {
				TestAnnotation.testAnnotation(annotation);
			}
			Annotation annotation = containerGroup.getPerson(0);
			Assert.assertNotNull(annotation);
		}
		List<Procedure> procedures = containerGroup.getProcedure();
		if (procedures != null && !procedures.isEmpty()) {
			for (Procedure annotation : procedures) {
				TestProcedureAnnotation.testProcedureAnnotation(annotation);
			}
			Procedure annotation = containerGroup.getProcedure(0);
			Assert.assertNotNull(annotation);
		}
		List<Relation> relations = containerGroup.getRelations();
		if (relations != null && !relations.isEmpty()) {
			for (Relation annotation : relations) {
				TestRelationAnnotation.testRelationAnnotation(annotation);
			}
			Relation annotation = containerGroup.getRelation(0);
			Assert.assertNotNull(annotation);
		}
		List<SectionAnnotation> sectionAnnotations = containerGroup.getSectionAnnotations();
		if (sectionAnnotations != null && !sectionAnnotations.isEmpty()) {
			for (SectionAnnotation annotation : sectionAnnotations) {
				TestSectionAnnotation.testSectionAnnotation(annotation);
			}
			SectionAnnotation annotation = containerGroup.getSectionAnnotations(0);
			Assert.assertNotNull(annotation);
		}
		List<AssistanceAnnotation> seeingAnnotations = containerGroup.getSeeingAssistanceInd();
		if (seeingAnnotations != null && !seeingAnnotations.isEmpty()) {
			for (AssistanceAnnotation annotation : seeingAnnotations) {
				TestAssistanceAnnotation.testAssistanceAnnotation(annotation);
			}
			AssistanceAnnotation annotation = containerGroup.getSeeingAssistanceInd(0);
			Assert.assertNotNull(annotation);
		}
		List<Smoking> smokingAnnotaions = containerGroup.getSmoking();
		if (smokingAnnotaions != null && !smokingAnnotaions.isEmpty()) {
			for (Smoking annotation : smokingAnnotaions) {
				TestSmokingAnnotation.testSmokingAnnotation(annotation);
			}
			Smoking annotation = containerGroup.getSmoking(0);
			Assert.assertNotNull(annotation);
		}
		List<SpellCorrectedText> textCorrections = containerGroup.getSpellCorrectedText();
		if (textCorrections != null && !textCorrections.isEmpty()) {
			for (SpellCorrectedText annotation : textCorrections) {
				TestTextCorrection.testTextCorrection(annotation);
			}
			SpellCorrectedText correction = containerGroup.getSpellCorrectedText(0);
			Assert.assertNotNull(correction);
		}
		List<SpellingCorrection> spellingCorrections = containerGroup.getSpellingCorrections();
		if (spellingCorrections != null && !spellingCorrections.isEmpty()) {
			for (SpellingCorrection annotation : spellingCorrections) {
				TestSpellCorrectionAnnotation.testSpellCorrectionAnnotation(annotation);
			}
			SpellingCorrection correction = containerGroup.getSpellingCorrections(0);
			Assert.assertNotNull(correction);
		}
		List<SymptomDisease> symptomAnnotations = containerGroup.getSymptomDisease();
		if (symptomAnnotations != null && !symptomAnnotations.isEmpty()) {
			for (SymptomDisease annotation : symptomAnnotations) {
				TestSymptomAnnotation.testSymptomAnnotation(annotation);
			}
			SymptomDisease annotation = containerGroup.getSymptomDisease(0);
			Assert.assertNotNull(annotation);
		}
		List<AssistanceAnnotation> toiletingAnnotations = containerGroup.getToiletingAssistance();
		if (toiletingAnnotations != null && !toiletingAnnotations.isEmpty()) {
			for (AssistanceAnnotation annotation : toiletingAnnotations) {
				TestAssistanceAnnotation.testAssistanceAnnotation(annotation);
			}
			AssistanceAnnotation annotation = containerGroup.getToiletingAssistance(0);
			Assert.assertNotNull(annotation);
		}
		List<UnstructuredContainer> unstructuredContainers = containerGroup.getUnstructured();
		if (unstructuredContainers != null && !unstructuredContainers.isEmpty()) {
			for (UnstructuredContainer container : unstructuredContainers) {
				TestUnstructuredContainer.testUnstructuredContainer(container);
			}
			UnstructuredContainer container = containerGroup.getUnstructured(0);
			Assert.assertNotNull(container);
		}
		List<Annotation> phoneAnnotations = containerGroup.getUSPhoneNumberInd();
		if (phoneAnnotations != null && !phoneAnnotations.isEmpty()) {
			for (Annotation annotation : phoneAnnotations) {
				TestAnnotation.testAnnotation(annotation);
			}
			Annotation annotation = containerGroup.getUSPhoneNumberInd(0);
			Assert.assertNotNull(annotation);
		}
		List<AssistanceAnnotation> walkingAnnotations = containerGroup.getWalkingAssistance();
		if (walkingAnnotations != null && !walkingAnnotations.isEmpty()) {
			for (AssistanceAnnotation annotation : walkingAnnotations) {
				TestAssistanceAnnotation.testAssistanceAnnotation(annotation);
			}
			AssistanceAnnotation annotation = containerGroup.getWalkingAssistance(0);
			Assert.assertNotNull(annotation);
		}
		List<Temporal> temporalSpans = containerGroup.getTemporalSpans();
		if (temporalSpans != null && !temporalSpans.isEmpty()) {
			for (Temporal annotation : temporalSpans) {
				TestTemporal.testTemporal(annotation);
			}
			Temporal annotation = containerGroup.getTemporalSpans(0);
			Assert.assertNotNull(annotation);
		}
	}
}
