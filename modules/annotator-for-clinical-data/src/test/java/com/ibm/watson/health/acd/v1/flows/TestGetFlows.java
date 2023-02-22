/* ***************************************************************** */
/*                                                                   */
/* (C) Copyright Merative US L.P. and others 2018, 2023              */
/*                                                                   */
/* SPDX-License-Identifier: Apache-2.0                               */
/*                                                                   */
/* ***************************************************************** */

package com.ibm.watson.health.acd.v1.flows;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;
import java.util.Set;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.watson.health.acd.v1.AnnotatorForClinicalData;
import com.ibm.watson.health.acd.v1.WatsonServiceTest;
import com.ibm.watson.health.acd.v1.common.Constants;
import com.ibm.watson.health.acd.v1.model.GetFlowsOptions;
import com.ibm.watson.health.acd.v1.model.GetFlowsOptions.Builder;
import com.ibm.watson.health.acd.v1.model.AcdFlow;

/**
 *
 * Class for testing GET /v1/flows.
 *
 */
public class TestGetFlows extends WatsonServiceTest {
	private AnnotatorForClinicalData service;

	public TestGetFlows() {
		super();
		try {
			service = this.getServiceInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetFlows() {
		GetFlowsOptions options = new GetFlowsOptions.Builder().build();

		Response<Map<String, AcdFlow>> response = null;
		try {
			ServiceCall<Map<String, AcdFlow>> sc = service.getFlows(options);
			response = sc.execute();
		} catch (ServiceResponseException e) {
			// Base class for all exceptions caused by error responses from the service
			System.out.println("testGetFlows: Service returned status code "
					+ e.getStatusCode() + ": " + e.getMessage());
			System.out.println("Detailed error info:\n" + e.getDebuggingInfo().toString());
		}
		if (response != null) {
			Assert.assertNotNull(response.getResult());
			Map<String, AcdFlow> flowMap = response.getResult();
			Set<String> keys = flowMap.keySet();
			for (String key: keys) {
				Assert.assertNotNull(flowMap.get(key));
			}
		}
	}

	@Test
	public void testGetFlowsNoOptions() {
		Response<Map<String, AcdFlow>> response = null;
		try {
			ServiceCall<Map<String, AcdFlow>> sc = service.getFlows();
			response = sc.execute();
		} catch (ServiceResponseException e) {
			// Base class for all exceptions caused by error responses from the service
			System.out.println("testGetFlowsNoOptions: Service returned status code "
					+ e.getStatusCode() + ": " + e.getMessage());
			System.out.println("Detailed error info:\n" + e.getDebuggingInfo().toString());
		}
		if (response != null) {
			Assert.assertNotNull(response.getResult());
			Map<String, AcdFlow> flowMap = response.getResult();
			Set<String> keys = flowMap.keySet();
			for (String key: keys) {
				Assert.assertNotNull(flowMap.get(key));
			}
		}
	}

	@Test
	public void testGetFlowsBuilder() {
		Builder builder = new GetFlowsOptions.Builder();

		Response<Map<String, AcdFlow>> response = null;
		try {
			ServiceCall<Map<String, AcdFlow>> sc = service.getFlows(builder.build());
			response = sc.execute();
		} catch (ServiceResponseException e) {
			// Base class for all exceptions caused by error responses from the service
			System.out.println("testGetFlowsBuilder: Service returned status code "
					+ e.getStatusCode() + ": " + e.getMessage());
			System.out.println("Detailed error info:\n" + e.getDebuggingInfo().toString());
		}
		if (response != null) {
			Assert.assertNotNull(response.getResult());
			Map<String, AcdFlow> flowMap = response.getResult();
			Set<String> keys = flowMap.keySet();
			for (String key: keys) {
				Assert.assertNotNull(flowMap.get(key));
			}
		}
	}

	@Test
	public void testGetBuilderFromOptions() {
		GetFlowsOptions options = new GetFlowsOptions.Builder().build();

		Builder builder = options.newBuilder();
		Assert.assertNotNull(builder);
	}
}
