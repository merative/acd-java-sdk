/* ***************************************************************** */
/*                                                                   */
/* (C) Copyright Merative US L.P. and others 2018, 2023              */
/*                                                                   */
/* SPDX-License-Identifier: Apache-2.0                               */
/*                                                                   */
/* ***************************************************************** */

package com.merative.acd.v1.flows;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import com.ibm.cloud.sdk.core.http.HttpStatus;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.merative.acd.v1.AnnotatorForClinicalData;
import com.merative.acd.v1.AcdServiceTest;
import com.merative.acd.v1.common.Constants;
import com.merative.acd.v1.model.AcdFlow;
import com.merative.acd.v1.model.Annotator;
import com.merative.acd.v1.model.AnnotatorFlow;
import com.merative.acd.v1.model.CreateFlowsOptions;
import com.merative.acd.v1.model.DeleteFlowsOptions;
import com.merative.acd.v1.model.Flow;
import com.merative.acd.v1.model.FlowEntry;
import com.merative.acd.v1.model.GetFlowsByIdOptions;
import com.merative.acd.v1.model.UpdateFlowsOptions;
import com.merative.acd.v1.model.UpdateFlowsOptions.Builder;

/**
 *
 * Class for testing PUT /v1/flows/{id}.
 *
 */
public class TestUpdateFlows extends AcdServiceTest {
	private AnnotatorForClinicalData service;

	private Response<Void> createFlowForUpdateTest() {
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
			System.out.println("testUpdateFlows (Create): Service returned status code "
					+ e.getStatusCode() + ": " + e.getMessage());
			System.out.println("Detailed error info:\n" + e.getDebuggingInfo().toString());
		}
		return resp;
	}

	private Response<Void> deleteExistingFlow(String flowId) {
		DeleteFlowsOptions options = new DeleteFlowsOptions.Builder().id(flowId).build();

		Response<Void> resp = null;
		try {
			ServiceCall<Void> sc = service.deleteFlows(options);
			resp = sc.execute();
		} catch (ServiceResponseException e) {
			// Base class for all exceptions caused by error responses from the service
			System.out.println("testUpdateFlows (Delete): Service returned status code "
					+ e.getStatusCode() + ": " + e.getMessage());
			System.out.println("Detailed error info:\n" + e.getDebuggingInfo().toString());
		}
		return resp;
	}

	public TestUpdateFlows() {
		super();
		try {
			service = this.getServiceInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdateFlows() {
		// Determine if flow exists
		GetFlowsByIdOptions getOptions = new GetFlowsByIdOptions.Builder("java_sdk_test_flow").build();
		try {
			ServiceCall<AcdFlow> scGet = service.getFlowsById(getOptions);
			scGet.execute();
		} catch (ServiceResponseException e) {
			if (e != null && e.getStatusCode() == HttpStatus.NOT_FOUND) {
				createFlowForUpdateTest();
			}
		}

		Annotator conceptDetection = new Annotator.Builder()
				.name(Constants.CONCEPT_DETECTION_NAME)
				.build();
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
				.name("Java SDK Test Flow - updated")
				.description("Java SDK Test Flow - updated")
				.annotatorFlows(Arrays.asList(annotatorFlow))
				.build();

		UpdateFlowsOptions updateOptions = new UpdateFlowsOptions.Builder()
				.id("java_sdk_test_flow")
				.acdFlow(acdFlow)
				.build();

		Response<Void> resp = null;
		try {
			ServiceCall<Void> scUpdate = service.updateFlows(updateOptions);
			resp = scUpdate.execute();
		} catch (ServiceResponseException e) {
			// Base class for all exceptions caused by error responses from the service
			System.out.println("testUpdateFlows (Update): Service returned status code "
					+ e.getStatusCode() + ": " + e.getMessage());
			System.out.println("Detailed error info:\n" + e.getDebuggingInfo().toString());
		}
		if (resp != null) {
			Assert.assertEquals(resp.getStatusCode(), HttpStatus.OK);
		}
		deleteExistingFlow("java_sdk_test_flow");
	}

	@Test
	public void testUpdateFlowsBuilder() {
		// Determine if flow exists
		GetFlowsByIdOptions getOptions = new GetFlowsByIdOptions.Builder("java_sdk_test_flow").build();
		try {
			ServiceCall<AcdFlow> scGet = service.getFlowsById(getOptions);
			scGet.execute();
		} catch (ServiceResponseException e) {
			if (e != null && e.getStatusCode() == HttpStatus.NOT_FOUND) {
				createFlowForUpdateTest();
			}
		}

		Annotator conceptDetection = new Annotator.Builder()
				.name(Constants.CONCEPT_DETECTION_NAME)
				.build();
		FlowEntry cdFlowEntry = new FlowEntry
				.Builder().annotator(conceptDetection).build();
		Flow flow = new Flow.Builder()
				.elements(Arrays.asList(cdFlowEntry))
				.async(true)
				.build();
		AnnotatorFlow annotatorFlow = new AnnotatorFlow.Builder()
				.flow(flow)
				.build();

		Builder builder = new UpdateFlowsOptions.Builder()
				.id("java_sdk_test_flow")
				.newId("java_sdk_test_flow")
				.newAnnotatorFlows(Arrays.asList(annotatorFlow));

		Response<Void> resp = null;
		try {
			ServiceCall<Void> scUpdate = service.updateFlows(builder.build());
			resp = scUpdate.execute();
		} catch (ServiceResponseException e) {
			// Base class for all exceptions caused by error responses from the service
			System.out.println("testUpdateFlowsBuilder (Update): Service returned status code "
					+ e.getStatusCode() + ": " + e.getMessage());
			System.out.println("Detailed error info:\n" + e.getDebuggingInfo().toString());
		}
		if (resp != null) {
			Assert.assertEquals(resp.getStatusCode(), HttpStatus.OK);
		}
		deleteExistingFlow("java_sdk_test_flow");
	}

	@Test
	public void testBuilderFromOptions() {
		UpdateFlowsOptions options = new UpdateFlowsOptions.Builder().id("abcd").build();

		Builder builder = options.newBuilder();
		Assert.assertNotNull(builder);
	}

}
