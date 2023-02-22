/* ***************************************************************** */
/*                                                                   */
/* Merative Confidential                                             */
/*                                                                   */
/* (C) Copyright Merative US L.P. 2018, 2023                         */
/*                                                                   */
/* SPDX-License-Identifier: Apache-2.0                               */
/*                                                                   */
/* ***************************************************************** */

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
import com.ibm.watson.health.acd.v1.model.Flow;
import com.ibm.watson.health.acd.v1.model.FlowEntry;
import com.ibm.watson.health.acd.v1.model.GetFlowsByIdOptions;
import com.ibm.watson.health.acd.v1.model.DeleteFlowsOptions.Builder;


/**
 *
 * Class for testing DELETE /v1/flows/{id}.
 *
 */
public class TestDeleteFlows extends WatsonServiceTest {
	private AnnotatorForClinicalData service;

	private Response<Void> createFlowForDeleteTest() {
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
		} catch (ServiceResponseException e) {
			// Base class for all exceptions caused by error responses from the service
			System.out.println("testDeleteFlows (Create): Service returned status code "
					+ e.getStatusCode() + ": " + e.getMessage());
			System.out.println("Detailed error info:\n" + e.getDebuggingInfo().toString());
		}
		return resp;
	}

	public TestDeleteFlows() {
		super();
		try {
			service = this.getServiceInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDeleteFlows() {
		// Determine if flow exists
		GetFlowsByIdOptions getOptions = new GetFlowsByIdOptions.Builder().id("java_sdk_test_flow").build();
		try {
			ServiceCall<AcdFlow> scGet = service.getFlowsById(getOptions);
			scGet.execute();
		} catch (ServiceResponseException e) {
			if (e != null && e.getStatusCode() == HttpStatus.NOT_FOUND) {
				createFlowForDeleteTest();
			}
		}

		DeleteFlowsOptions options = new DeleteFlowsOptions.Builder().id("java_sdk_test_flow").build();

		Response<Void> response = null;
		try {
			ServiceCall<Void> sc = service.deleteFlows(options);
			response = sc.execute();
		} catch (ServiceResponseException e) {
			// Base class for all exceptions caused by error responses from the service
			System.out.println("testDeleteFlows (Delete): Service returned status code "
					+ e.getStatusCode() + ": " + e.getMessage());
			System.out.println("Detailed error info:\n" + e.getDebuggingInfo().toString());
		}
		if (response != null) {
			Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
		}
	}

	@Test
	public void testDeleteFlowsBuilder() {
		// Determine if flow exists
		GetFlowsByIdOptions getOptions = new GetFlowsByIdOptions.Builder().id("java_sdk_test_flow").build();
		try {
			ServiceCall<AcdFlow> scGet = service.getFlowsById(getOptions);
			scGet.execute();
		} catch (ServiceResponseException e) {
			if (e != null && e.getStatusCode() == HttpStatus.NOT_FOUND) {
				createFlowForDeleteTest();
			}
		}
		Builder builder = new DeleteFlowsOptions.Builder("java_sdk_test_flow");

		Response<Void> response = null;
		try {
			ServiceCall<Void> sc = service.deleteFlows(builder.build());
			response = sc.execute();
		} catch (ServiceResponseException e) {
			// Base class for all exceptions caused by error responses from the service
			System.out.println("testDeleteFlowsBuilder (Delete): Service returned status code "
					+ e.getStatusCode() + ": " + e.getMessage());
			System.out.println("Detailed error info:\n" + e.getDebuggingInfo().toString());
		}
		if (response != null) {
			Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
		}
	}

	@Test
	public void testBuilderFromOptions() {
		DeleteFlowsOptions options = new DeleteFlowsOptions.Builder().id("abcd").build();

		Builder builder = options.newBuilder();
		Assert.assertNotNull(builder);
	}
}
