/* ***************************************************************** */
/*                                                                   */
/* Merative Confidential                                             */
/*                                                                   */
/* (C) Copyright Merative US L.P. 2001, 2023                         */
/*                                                                   */
/* SPDX-License-Identifier: Apache 2-0                               */
/*                                                                   */
/* ***************************************************************** */

package com.ibm.watson.health.acd.v1.acd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.watson.health.acd.v1.AnnotatorForClinicalData;
import com.ibm.watson.health.acd.v1.WatsonServiceTest;
import com.ibm.watson.health.acd.v1.common.Constants;
import com.ibm.watson.health.acd.v1.common.TestContainerGroup;
import com.ibm.watson.health.acd.v1.model.AnalyzeOptions;
import com.ibm.watson.health.acd.v1.model.Annotator;
import com.ibm.watson.health.acd.v1.model.AnnotatorFlow;
import com.ibm.watson.health.acd.v1.model.ConfigurationEntity;
import com.ibm.watson.health.acd.v1.model.ContainerGroup;
import com.ibm.watson.health.acd.v1.model.Flow;
import com.ibm.watson.health.acd.v1.model.Flow.Builder;
import com.ibm.watson.health.acd.v1.model.FlowEntry;
import com.ibm.watson.health.acd.v1.model.SymptomDisease;
import com.ibm.watson.health.acd.v1.model.UnstructuredContainer;
import com.ibm.watson.health.acd.v1.util.FlowUtil;

/**
 *
 * Class for testing /v1/analyze.
 *
 */
public class TestAnalyze extends WatsonServiceTest {
	private AnnotatorForClinicalData service;

	public TestAnalyze() {
		super();
		try {
			service = this.getServiceInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testAnalyzeSingleAnnotator() {
		ConfigurationEntity ce = new ConfigurationEntity.Builder()
				.id("t1")
				.type("customType")
				.uid(99)
				.build();
		Map<String, String> params = new HashMap<String, String>();
		params.put("include_optional_fields", "medical_codes");

		Annotator annotator = new Annotator.Builder().name(Constants.CONCEPT_DETECTION_NAME)
				.build();
		FlowEntry flowEntry = new FlowEntry.Builder().annotator(annotator).build();
		Flow elementFlow = new Flow.Builder().addElements(flowEntry).async(false).build();
		AnnotatorFlow annotatorFlow = new AnnotatorFlow.Builder().flow(elementFlow).build();

		for (int i = 0; i < Constants.SAMPLE_TEXT_ARRAY.length; i++) {
			UnstructuredContainer unstructured = new UnstructuredContainer.Builder().text(Constants.SAMPLE_TEXT_ARRAY[i]).build();

			AnalyzeOptions options = new AnalyzeOptions.Builder().addAnnotatorFlows(annotatorFlow).addUnstructured(unstructured).build();

			ServiceCall<ContainerGroup> sc = service.analyze(options);

			ContainerGroup containerGroup = null;
			try {
				Response<ContainerGroup> response = sc.execute();
				containerGroup = response.getResult();
			} catch (ServiceResponseException e) {
				// Base class for all exceptions caused by error responses from the service
				System.out.println("testAnalyzeSingleAnnotator: Service returned status code "
						+ e.getStatusCode() + ": " + e.getMessage());
				System.out.println("Detailed error info:\n" + e.getDebuggingInfo().toString());
			}
			Assert.assertNotNull(containerGroup);
			TestContainerGroup.testContainerGroups(containerGroup);
		}
	}

	@Test
	public void testAnalyzeText() {
		Annotator annotator = new Annotator.Builder().name(Constants.CONCEPT_DETECTION_NAME).build();
		FlowEntry flowEntry = new FlowEntry.Builder().annotator(annotator).build();
		Flow elementFlow = new Flow.Builder().addElements(flowEntry).async(false).build();

		for (int i = 0; i < Constants.SAMPLE_TEXT_ARRAY.length; i++) {
			ContainerGroup containerGroup = null;
			try {
				containerGroup = service.analyze(Constants.SAMPLE_TEXT_ARRAY[i], elementFlow);
			} catch (ServiceResponseException e) {
				// Base class for all exceptions caused by error responses from the service
				System.out.println("testAnalyzeText: Service returned status code "
						+ e.getStatusCode() + ": " + e.getMessage());
				System.out.println("Detailed error info:\n" + e.getDebuggingInfo().toString());
			}
			Assert.assertNotNull(containerGroup);
			TestContainerGroup.testContainerGroups(containerGroup);
		}
	}

	@Test
	public void testAnalyzeTextDetailedResponse() {
		Annotator annotator = new Annotator.Builder().name(Constants.CONCEPT_DETECTION_NAME).build();
		FlowEntry flowEntry = new FlowEntry.Builder().annotator(annotator).build();
		Flow elementFlow = new Flow.Builder().addElements(flowEntry).async(false).build();

		for (int i = 0; i < Constants.SAMPLE_TEXT_ARRAY.length; i++) {
			ContainerGroup containerGroup = null;
			try {
				Response<ContainerGroup> response = service.analyzeInclResponseDetails(Constants.SAMPLE_TEXT_ARRAY[i], elementFlow);
				containerGroup = response.getResult();
			} catch (ServiceResponseException e) {
				// Base class for all exceptions caused by error responses from the service
				System.out.println("testAnalyzeTextDetailedResponse: Service returned status code "
						+ e.getStatusCode() + ": " + e.getMessage());
				System.out.println("Detailed error info:\n" + e.getDebuggingInfo().toString());
			}
			Assert.assertNotNull(containerGroup);
			TestContainerGroup.testContainerGroups(containerGroup);
		}
	}

	@Test
	public void testAnalyzeTextReturnText() {
		Annotator annotator = new Annotator.Builder().name(Constants.CONCEPT_DETECTION_NAME).build();
		FlowEntry flowEntry = new FlowEntry.Builder().annotator(annotator).build();
		Flow elementFlow = new Flow.Builder().addElements(flowEntry).async(false).build();

		for (int i = 0; i < Constants.SAMPLE_TEXT_ARRAY.length; i++) {
			ContainerGroup containerGroup = null;
			try {
				containerGroup = service.analyze(Constants.SAMPLE_TEXT_ARRAY[i], elementFlow, true);
			} catch (ServiceResponseException e) {
				// Base class for all exceptions caused by error responses from the service
				System.out.println("testAnalyzeTextReturnText: Service returned status code "
						+ e.getStatusCode() + ": " + e.getMessage());
				System.out.println("Detailed error info:\n" + e.getDebuggingInfo().toString());
			}
			Assert.assertNotNull(containerGroup);
			TestContainerGroup.testContainerGroups(containerGroup);
		}
	}

	@Test
	public void testAnalyzeTextReturnTextDetailedResponse() {
		Annotator annotator = new Annotator.Builder().name(Constants.CONCEPT_DETECTION_NAME).build();
		FlowEntry flowEntry = new FlowEntry.Builder().annotator(annotator).build();
		Flow elementFlow = new Flow.Builder().addElements(flowEntry).async(false).build();

		for (int i = 0; i < Constants.SAMPLE_TEXT_ARRAY.length; i++) {
			ContainerGroup containerGroup = null;
			try {
				Response<ContainerGroup> response = service.analyzeInclResponseDetails(Constants.SAMPLE_TEXT_ARRAY[i], elementFlow, true);
				containerGroup = response.getResult();
			} catch (ServiceResponseException e) {
				// Base class for all exceptions caused by error responses from the service
				System.out.println("testAnalyzeTextReturnTextDetailedResponse: Service returned status code "
						+ e.getStatusCode() + ": " + e.getMessage());
				System.out.println("Detailed error info:\n" + e.getDebuggingInfo().toString());
			}
			Assert.assertNotNull(containerGroup);
			TestContainerGroup.testContainerGroups(containerGroup);
		}
	}
	
	@Test
	public void testAnalyzeTextDebug() {
		Annotator annotator = new Annotator.Builder().name(Constants.CONCEPT_DETECTION_NAME).build();
		FlowEntry flowEntry = new FlowEntry.Builder().annotator(annotator).build();
		Flow elementFlow = new Flow.Builder().addElements(flowEntry).async(false).build();

		for (int i = 0; i < Constants.SAMPLE_TEXT_ARRAY.length; i++) {
			ContainerGroup containerGroup = null;
			try {
				Response<ContainerGroup> response = service.analyzeDebug(Constants.SAMPLE_TEXT_ARRAY[i], elementFlow, true, true);
				containerGroup = response.getResult();
			} catch (ServiceResponseException e) {
				// Base class for all exceptions caused by error responses from the service
				System.out.println("testAnalyzeTextDebug: Service returned status code "
						+ e.getStatusCode() + ": " + e.getMessage());
				System.out.println("Detailed error info:\n" + e.getDebuggingInfo().toString());
			}
			Assert.assertNotNull(containerGroup);
			TestContainerGroup.testContainerGroups(containerGroup);
		}
	}

	@Test
	public void testAnalyzeMultipleAnnotators() {
		Annotator allergy = new Annotator.Builder().name(Constants.ALLERGY).build();
		FlowEntry allergyEntry = new FlowEntry.Builder().annotator(allergy).build();
		Annotator ad = new Annotator.Builder().name(Constants.ATTRIBUTE_DETECTION_NAME).build();
		FlowEntry adEntry = new FlowEntry.Builder().annotator(ad).build();
		Annotator bathing = new Annotator.Builder().name(Constants.BATHING).build();
		FlowEntry bathingyEntry = new FlowEntry.Builder().annotator(bathing).build();
		Annotator cancer = new Annotator.Builder().name(Constants.CANCER).build();
		FlowEntry cancerEntry = new FlowEntry.Builder().annotator(cancer).build();
		Annotator cd = new Annotator.Builder().name(Constants.CONCEPT_DETECTION_NAME).build();
		FlowEntry cdEntry = new FlowEntry.Builder().annotator(cd).build();
		Annotator cv = new Annotator.Builder().name(Constants.CONCEPT_VALUE).build();
		FlowEntry cvEntry = new FlowEntry.Builder().annotator(cv).build();
		Annotator dis = new Annotator.Builder().name(Constants.DISAMBIGUATION).build();
		FlowEntry disEntry = new FlowEntry.Builder().annotator(dis).build();
		Annotator dressing = new Annotator.Builder().name(Constants.DRESSING).build();
		FlowEntry dressingEntry = new FlowEntry.Builder().annotator(dressing).build();
		Annotator eating = new Annotator.Builder().name(Constants.EATING).build();
		FlowEntry eatingEntry = new FlowEntry.Builder().annotator(eating).build();
		Annotator ef = new Annotator.Builder().name(Constants.EJECTION_FRACTION).build();
		FlowEntry efEntry = new FlowEntry.Builder().annotator(ef).build();
		Annotator hypo = new Annotator.Builder().name(Constants.HYPOTHETICAL).build();
		FlowEntry hypoEntry = new FlowEntry.Builder().annotator(hypo).build();
		Annotator lv = new Annotator.Builder().name(Constants.LAB_VALUE).build();
		FlowEntry lvEntry = new FlowEntry.Builder().annotator(lv).build();
		Annotator med = new Annotator.Builder().name(Constants.MEDICATION).build();
		FlowEntry medEntry = new FlowEntry.Builder().annotator(med).build();
		Annotator model = new Annotator.Builder().name(Constants.MODEL_BROKER).build();
		FlowEntry modelEntry = new FlowEntry.Builder().annotator(model).build();
		Annotator namedEntities = new Annotator.Builder().name(Constants.NAMED_ENTITIES).build();
		FlowEntry neEntry = new FlowEntry.Builder().annotator(namedEntities).build();
		Annotator neg = new Annotator.Builder().name(Constants.NEGATION).build();
		FlowEntry negEntry = new FlowEntry.Builder().annotator(neg).build();
		Annotator proc = new Annotator.Builder().name(Constants.PROCEDURE).build();
		FlowEntry procEntry = new FlowEntry.Builder().annotator(proc).build();
		Annotator relation = new Annotator.Builder().name(Constants.RELATION).build();
		FlowEntry relationEntry = new FlowEntry.Builder().annotator(relation).build();
		Annotator seeing = new Annotator.Builder().name(Constants.SEEING).build();
		FlowEntry seeingEntry = new FlowEntry.Builder().annotator(seeing).build();
		Annotator smoking = new Annotator.Builder().name(Constants.SMOKING).build();
		FlowEntry smokingEntry = new FlowEntry.Builder().annotator(smoking).build();
		Annotator spell = new Annotator.Builder().name(Constants.SPELL_CHECKER).build();
		FlowEntry spellEntry = new FlowEntry.Builder().annotator(spell).build();
		Annotator sd = new Annotator.Builder().name(Constants.SYMPTOM_DISEASE).build();
		FlowEntry sdEntry = new FlowEntry.Builder().annotator(sd).build();
		Annotator toilet = new Annotator.Builder().name(Constants.TOILETING).build();
		FlowEntry toiletEntry = new FlowEntry.Builder().annotator(toilet).build();
		Annotator walk = new Annotator.Builder().name(Constants.WALKING).build();
		FlowEntry walkEntry = new FlowEntry.Builder().annotator(walk).build();
		Annotator section = new Annotator.Builder().name(Constants.SECTION).build();
		FlowEntry sectionEntry = new FlowEntry.Builder().annotator(section).build();
		List<FlowEntry> flowEntries = new ArrayList<FlowEntry>(25);
		flowEntries.add(sdEntry);
		flowEntries.add(cdEntry);
		flowEntries.add(allergyEntry);
		flowEntries.add(bathingyEntry);
		flowEntries.add(cancerEntry);
		flowEntries.add(cvEntry);
		flowEntries.add(disEntry);
		flowEntries.add(dressingEntry);
		flowEntries.add(eatingEntry);
		flowEntries.add(efEntry);
		flowEntries.add(hypoEntry);
		flowEntries.add(lvEntry);
		flowEntries.add(medEntry);
		//		flowEntries.add(modelEntry);
		flowEntries.add(neEntry);
		flowEntries.add(negEntry);
		flowEntries.add(procEntry);
		flowEntries.add(relationEntry);
		flowEntries.add(sectionEntry);
		flowEntries.add(seeingEntry);
		flowEntries.add(smokingEntry);
		flowEntries.add(spellEntry);
		flowEntries.add(toiletEntry);
		flowEntries.add(walkEntry);
		flowEntries.add(adEntry);

		Flow elementflow = new Flow.Builder().elements(flowEntries).async(false).build();
		AnnotatorFlow annotatorflow = new AnnotatorFlow.Builder().flow(elementflow).build();

		for (int i = 0; i < Constants.SAMPLE_TEXT_ARRAY.length; i++) {
			UnstructuredContainer unstructured = new UnstructuredContainer.Builder().text(Constants.SAMPLE_TEXT_ARRAY[i]).build();
			AnalyzeOptions options = new AnalyzeOptions.Builder().addAnnotatorFlows(annotatorflow).addUnstructured(unstructured).build();

			ServiceCall<ContainerGroup> sc = service.analyze(options);

			ContainerGroup containerGroup = null;
			try {
				Response<ContainerGroup> response = sc.execute();
				containerGroup = response.getResult();
			} catch (ServiceResponseException e) {
				// Base class for all exceptions caused by error responses from the service
				System.out.println("testAnalyzeMultipleAnnotators: Service returned status code "
						+ e.getStatusCode() + ": " + e.getMessage());
				System.out.println("Detailed error info:\n" + e.getDebuggingInfo().toString());
			}
			Assert.assertNotNull(containerGroup);
			TestContainerGroup.testContainerGroups(containerGroup);
		}
	}

	@Test
	public void testAnalyzeFlowUtilBuildFlow() {
		Annotator annotator = new Annotator.Builder().name(Constants.CONCEPT_DETECTION_NAME).build();

		FlowEntry flowEntry = new FlowEntry.Builder().annotator(annotator).build();
		Flow elementFlow = new Flow.Builder().addElements(flowEntry).async(false).build();
		Assert.assertEquals(elementFlow, FlowUtil.buildFlow(elementFlow));

		AnnotatorFlow annotatorflow = new AnnotatorFlow.Builder().flow(elementFlow).build();

		for (int i = 0; i < Constants.SAMPLE_TEXT_ARRAY.length; i++) {
			UnstructuredContainer unstructured = new UnstructuredContainer.Builder().text(Constants.SAMPLE_TEXT_ARRAY[i]).build();

			AnalyzeOptions options = new AnalyzeOptions.Builder().addAnnotatorFlows(annotatorflow).addUnstructured(unstructured).build();

			ServiceCall<ContainerGroup> sc = service.analyze(options);

			ContainerGroup containerGroup = null;
			try {
				Response<ContainerGroup> response = sc.execute();
				containerGroup = response.getResult();
			} catch (ServiceResponseException e) {
				// Base class for all exceptions caused by error responses from the service
				System.out.println("testAnalyzeFlowUtilBuildFlow: Service returned status code "
						+ e.getStatusCode() + ": " + e.getMessage());
				System.out.println("Detailed error info:\n" + e.getDebuggingInfo().toString());
			}
			Assert.assertNotNull(containerGroup);
			TestContainerGroup.testContainerGroups(containerGroup);
		}
	}

	@Test
    public void testAnalyzeFlowUtilAnnotator() {
		Flow flow = new FlowUtil.Builder().addAnnotators(Constants.SYMPTOM_DISEASE).async(true).build();

		// Request to ACD
		ContainerGroup results = null;
		try {
			results = service.analyze("Patient has diabetes", flow);
		} catch (ServiceResponseException e) {
			// Base class for all exceptions caused by error responses from the service
			System.out.println("testAnalyzeFlowUtilAnnotator: Service returned status code "
					+ e.getStatusCode() + ": " + e.getMessage());
			System.out.println("Detailed error info:\n" + e.getDebuggingInfo().toString());
		}
		Assert.assertNotNull(results);
		Assert.assertNotNull(results.getSymptomDisease());
		SymptomDisease attrAnno = results.getSymptomDisease(0);
		Assert.assertEquals("diabetes", attrAnno.getSymptomDiseaseSurfaceForm());
	}

	@Test
	public void testBuilderFromOptions() {
		Annotator annotator = new Annotator.Builder().name(Constants.CONCEPT_DETECTION_NAME)
				.build();
		Assert.assertNull(annotator.annotator());
		Assert.assertNull(annotator.description());
		Assert.assertNull(annotator.configurations());
		Assert.assertNull(annotator.parameters());
		FlowEntry flowEntry = new FlowEntry.Builder().annotator(annotator).build();
		com.ibm.watson.health.acd.v1.model.FlowEntry.Builder flowEntryBuilder = flowEntry.newBuilder();
		Assert.assertNotNull(flowEntryBuilder);
		Flow elementFlow = new Flow.Builder().addElements(flowEntry).async(false).build();
		Builder flowBuilder = elementFlow.newBuilder();
		Assert.assertNotNull(flowBuilder);
		AnnotatorFlow annotatorFlow = new AnnotatorFlow.Builder().flow(elementFlow).build();
		com.ibm.watson.health.acd.v1.model.AnnotatorFlow.Builder afBuilder = annotatorFlow.newBuilder();
		Assert.assertNotNull(afBuilder);

		for (int i = 0; i < Constants.SAMPLE_TEXT_ARRAY.length; i++) {
			UnstructuredContainer unstructured = new UnstructuredContainer.Builder().text(Constants.SAMPLE_TEXT_ARRAY[i]).build();
			AnalyzeOptions options = new AnalyzeOptions.Builder().addAnnotatorFlows(annotatorFlow).addUnstructured(unstructured).build();
			com.ibm.watson.health.acd.v1.model.AnalyzeOptions.Builder optionsBuilder = options.newBuilder();
			Assert.assertNotNull(optionsBuilder);
		}
	}
}
