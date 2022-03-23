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
package com.ibm.watson.health.acd.v1.flows;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import com.ibm.cloud.sdk.core.http.HttpStatus;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.watson.health.acd.v1.AnnotatorForClinicalData;
import com.ibm.watson.health.acd.v1.WatsonServiceTest;
import com.ibm.watson.health.acd.v1.model.AcdFlow;
import com.ibm.watson.health.acd.v1.model.Annotator;
import com.ibm.watson.health.acd.v1.model.AnnotatorFlow;
import com.ibm.watson.health.acd.v1.model.CreateFlowsOptions;
import com.ibm.watson.health.acd.v1.model.DeleteFlowsOptions;
import com.ibm.watson.health.acd.v1.model.CreateFlowsOptions.Builder;
import com.ibm.watson.health.acd.v1.model.Flow;
import com.ibm.watson.health.acd.v1.model.FlowEntry;
import com.ibm.watson.health.acd.v1.model.GetFlowsByIdOptions;


/**
 *
 * Class for testing POST /v1/flows/{id}.
 *
 */
public class TestCreateFlows extends WatsonServiceTest {
	private AnnotatorForClinicalData service;

	private Response<Void> deleteExistingFlow(String flowId) {
		DeleteFlowsOptions options = new DeleteFlowsOptions.Builder().id(flowId).build();

		Response<Void> resp = null;
		try {
			ServiceCall<Void> sc = service.deleteFlows(options);
			resp = sc.execute();
		} catch (ServiceResponseException e) {
			// Base class for all exceptions caused by error responses from the service
			System.out.println("testCreateFlows (Delete): Service returned status code "
					+ e.getStatusCode() + ": " + e.getMessage());
			System.out.println("Detailed error info:\n" + e.getDebuggingInfo().toString());
		}
		return resp;
	}

	public TestCreateFlows() {
		super();
		try {
			service = this.getServiceInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testCreateFlows() {
		// Determine if flow already exists
		Boolean flowExists = false;
		GetFlowsByIdOptions getOptions = new GetFlowsByIdOptions.Builder().id("java_sdk_test_flow").build();
		try {
			ServiceCall<AcdFlow> scGet = service.getFlowsById(getOptions);
			scGet.execute();
			flowExists = true;
		} catch (ServiceResponseException e) {
		}
		if (flowExists) {
			deleteExistingFlow("java_sdk_test_flow");
		}

		Annotator conceptDetection = new Annotator.Builder()
				.name(Annotator.Name.CONCEPT_DETECTION).build();
		FlowEntry cdFlowEntry = new FlowEntry
				.Builder().annotator(conceptDetection).build();
		Flow flow = new Flow.Builder()
				.elements(Arrays.asList(cdFlowEntry))
				.async(true)
				.build();
		AnnotatorFlow annotatorFlow = new AnnotatorFlow.Builder()
				.flow(flow)
				.build();

		AcdFlow acdFlow = new AcdFlow.Builder()
				.id("java_sdk_test_flow")
				.name("Java SDK Test Flow")
				.description("Java SDK Test Flow")
				.annotatorFlows(Arrays.asList(annotatorFlow))
				.build();

		CreateFlowsOptions createOptions = new CreateFlowsOptions
				.Builder()
				.acdFlow(acdFlow)
				.build();

		Response<Void> resp = null;
		try {
			ServiceCall<Void> scCreate = service.createFlows(createOptions);
			resp = scCreate.execute();
		} catch (ServiceResponseException e1) {
			// Base class for all exceptions caused by error responses from the service
			System.out.println("testCreateFlows (Create): Service returned status code "
					+ e1.getStatusCode() + ": " + e1.getMessage());
			System.out.println("Detailed error info:\n" + e1.getDebuggingInfo().toString());
			if (e1.getStatusCode() == HttpStatus.CONFLICT) {
				deleteExistingFlow("java_sdk_test_flow");
			}
		}
		if (resp != null) {
			Assert.assertEquals(resp.getStatusCode(), HttpStatus.CREATED);
			deleteExistingFlow("java_sdk_test_flow");
		}

		// negative test
		boolean illegalArgTest = false;
		try {
			ServiceCall<Void> scCreate = service.createFlows();
			scCreate.execute();
		} catch (IllegalArgumentException e1) {
			illegalArgTest = true;
		}
		Assert.assertTrue(illegalArgTest);
	}

	@Test
	public void testCreateFlowsBuilder() {
		Annotator conceptDetection = new Annotator.Builder()
				.name(Annotator.Name.CONCEPT_DETECTION).build();
		FlowEntry cdFlowEntry = new FlowEntry
				.Builder().annotator(conceptDetection).build();
		Flow flow = new Flow.Builder()
				.elements(Arrays.asList(cdFlowEntry))
				.async(true)
				.build();
		AnnotatorFlow annotatorFlow = new AnnotatorFlow.Builder()
				.flow(flow)
				.build();
		Builder builder = new CreateFlowsOptions.Builder()
				.id("java_sdk_test_flow")
				.annotatorFlows(Arrays.asList(annotatorFlow));

		Response<Void> response = null;
		try {
			ServiceCall<Void> sc = service.createFlows(builder.build());
			response = sc.execute();
		} catch (ServiceResponseException e) {
			// Base class for all exceptions caused by error responses from the service
			System.out.println("testCreateFlowsBuilder: Service returned status code "
					+ e.getStatusCode() + ": " + e.getMessage());
			System.out.println("Detailed error info:\n" + e.getDebuggingInfo().toString());
			if (e.getStatusCode() == HttpStatus.CONFLICT) {
				deleteExistingFlow("java_sdk_test_flow");
			}
		}
		if (response != null) {
			Assert.assertEquals(response.getStatusCode(), HttpStatus.CREATED);
			deleteExistingFlow("java_sdk_test_flow");
		}
	}

	@Test
	public void testBuilderFromOptions() {
		CreateFlowsOptions options = new CreateFlowsOptions.Builder().build();

		Builder builder = options.newBuilder();
		Assert.assertNotNull(builder);
	}
}
