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
package com.ibm.watson.health.acd.v1.flows;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.watson.health.acd.v1.AnnotatorForClinicalData;
import com.ibm.watson.health.acd.v1.WatsonServiceTest;
import com.ibm.watson.health.acd.v1.common.Constants;
import com.ibm.watson.health.acd.v1.model.AcdFlow;
import com.ibm.watson.health.acd.v1.model.AnnotatorFlow;
import com.ibm.watson.health.acd.v1.model.Flow;
import com.ibm.watson.health.acd.v1.model.FlowEntry;
import com.ibm.watson.health.acd.v1.model.GetFlowOptions;
import com.ibm.watson.health.acd.v1.model.GetFlowOptions.Builder;
import com.ibm.watson.health.acd.v1.model.GetFlowsByIdOptions;

/**
 *
 * Class for testing /v1/flows/{id}.
 *
 */
public class TestGetFlowsFlowId extends WatsonServiceTest {
	private AnnotatorForClinicalData service;

	public TestGetFlowsFlowId() {
		super();
		try {
			this.setUp();
			service = this.getServiceInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetFlow() {
		GetFlowsByIdOptions options = new GetFlowsByIdOptions.Builder().id(Constants.FLOW_ID).build();

		ServiceCall<AcdFlow> sc = service.getFlowsById(options);
		Response<AcdFlow> response = sc.execute();
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

	@Test
	public void testGetFlowBuilder() {
		GetFlowsByIdOptions options = new GetFlowsByIdOptions.Builder(Constants.FLOW_ID).build();

		ServiceCall<AcdFlow> sc = service.getFlowsById(options);
		Response<AcdFlow> response = sc.execute();
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

	@Test
	public void testBuilderFromOptions() {
		GetFlowOptions options = new GetFlowOptions.Builder().id(Constants.FLOW_ID).build();
		Builder builder = options.newBuilder();
		Assert.assertNotNull(builder);
	}
}
