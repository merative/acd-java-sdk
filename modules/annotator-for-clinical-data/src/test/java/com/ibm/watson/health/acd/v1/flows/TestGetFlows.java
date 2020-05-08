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

import org.junit.Assert;
import org.junit.Test;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.watson.health.acd.v1.AnnotatorForClinicalData;
import com.ibm.watson.health.acd.v1.WatsonServiceTest;
import com.ibm.watson.health.acd.v1.common.Constants;
import com.ibm.watson.health.acd.v1.model.GetFlowsOptions;
import com.ibm.watson.health.acd.v1.model.GetFlowsOptions.Builder;
import com.ibm.watson.health.acd.v1.model.ListStringWrapper;

/**
 *
 * Class for testing /v1/flows.
 *
 */
public class TestGetFlows extends WatsonServiceTest {
	private AnnotatorForClinicalData service;

	public TestGetFlows() {
		super();
		try {
			this.setUp();
			service = this.getServiceInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetFlows() {
		Assert.assertNotNull(service.getFlows());
	}

	@Test
	public void testGetFlowsOptions() {
		GetFlowsOptions options = new GetFlowsOptions.Builder().build();

		ServiceCall<ListStringWrapper> sc = service.getFlows(options);
		Response<ListStringWrapper> response = sc.execute();
		Assert.assertNotNull(response.getResult());
	}

	@Test
	public void testGetBuilderFromOptions() {
		GetFlowsOptions options = new GetFlowsOptions.Builder().build();
		Builder builder = options.newBuilder();
		Assert.assertNotNull(builder);
	}
}
