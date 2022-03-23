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

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.watson.health.acd.v1.AnnotatorForClinicalData;
import com.ibm.watson.health.acd.v1.WatsonServiceTest;
import com.ibm.watson.health.acd.v1.common.Constants;
import com.ibm.watson.health.acd.v1.model.AcdFlow;
import com.ibm.watson.health.acd.v1.model.AnnotatorFlow;
import com.ibm.watson.health.acd.v1.model.Flow;
import com.ibm.watson.health.acd.v1.model.FlowEntry;
import com.ibm.watson.health.acd.v1.model.GetFlowsByIdOptions;
import com.ibm.watson.health.acd.v1.model.GetFlowsByIdOptions.Builder;

/**
 *
 * Class for testing GET /v1/flows/{id}.
 *
 */
public class TestGetFlowsFlowId extends WatsonServiceTest {
	private AnnotatorForClinicalData service;

	public TestGetFlowsFlowId() {
		super();
		try {
			service = this.getServiceInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetFlowsById() {
		GetFlowsByIdOptions options = new GetFlowsByIdOptions.Builder().id(Constants.FLOW_ID).build();

		Response<AcdFlow> response = null;
		try {
			ServiceCall<AcdFlow> sc = service.getFlowsById(options);
			response = sc.execute();
		} catch (ServiceResponseException e) {
			// Base class for all exceptions caused by error responses from the service
			System.out.println("testGetFlowsById: Service returned status code "
					+ e.getStatusCode() + ": " + e.getMessage());
			System.out.println("Detailed error info:\n" + e.getDebuggingInfo().toString());
		}
		if (response != null) {
			AcdFlow flow = response.getResult();
			Assert.assertNotNull(flow);
			Assert.assertEquals(flow.id(), Constants.FLOW_ID);
			Assert.assertNotNull(flow.name());
			String desc = flow.description();
			if (desc != null) {
				Assert.assertTrue(desc.length() > 0);
			}
			List<AnnotatorFlow> flowList = flow.annotatorFlows();
			if (flowList != null && !flowList.isEmpty()) {
				for (AnnotatorFlow annoFlow : flowList) {
					Flow flowForAnnotator = annoFlow.flow();
					List<FlowEntry> flowEntries = flowForAnnotator.elements();
					if (flowEntries != null && !flowEntries.isEmpty()) {
						for (FlowEntry entry : flowEntries) {
							Assert.assertNotNull(entry);
						}
					}
				}
			}
		}
	}

	@Test
	public void testGetFlowsByIdBuilder() {
		Builder builder = new GetFlowsByIdOptions.Builder(Constants.FLOW_ID);

		Response<AcdFlow> response = null;
		try {
			ServiceCall<AcdFlow> sc = service.getFlowsById(builder.build());
			response = sc.execute();
		} catch (ServiceResponseException e) {
			// Base class for all exceptions caused by error responses from the service
			System.out.println("testGetFlowsByIdBuilder: Service returned status code "
					+ e.getStatusCode() + ": " + e.getMessage());
			System.out.println("Detailed error info:\n" + e.getDebuggingInfo().toString());
		}
		if (response != null) {
			AcdFlow flow = response.getResult();
			Assert.assertNotNull(flow);
			Assert.assertNotNull(flow.id());
			Assert.assertNotNull(flow.name());
			String desc = flow.description();
			if (desc != null) {
				Assert.assertTrue(desc.length() > 0);
			}
			List<AnnotatorFlow> flowList = flow.annotatorFlows();
			if (flowList != null && !flowList.isEmpty()) {
				for (AnnotatorFlow annoFlow : flowList) {
					Flow flowForAnnotator = annoFlow.flow();
					List<FlowEntry> flowEntries = flowForAnnotator.elements();
					if (flowEntries != null && !flowEntries.isEmpty()) {
						for (FlowEntry entry : flowEntries) {
							Assert.assertNotNull(entry);
						}
					}
				}
			}
		}
	}

	@Test
	public void testGetBuilderFromOptions() {
		GetFlowsByIdOptions options = new GetFlowsByIdOptions.Builder().id(Constants.FLOW_ID).build();

		Builder builder = options.newBuilder();
		Assert.assertNotNull(builder);
	}
}
