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
package com.ibm.watson.health.acd.v1.status;

import org.junit.Assert;
import org.junit.Test;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.watson.health.acd.v1.AnnotatorForClinicalData;
import com.ibm.watson.health.acd.v1.WatsonServiceTest;
import com.ibm.watson.health.acd.v1.model.GetHealthCheckOptions;
import com.ibm.watson.health.acd.v1.model.GetHealthCheckOptions.Builder;

/**
 *
 * Class to test /v1/status/health_check.
 *
 */
public class TestGetHealthCheckStatus extends WatsonServiceTest {
	private AnnotatorForClinicalData service;

	public TestGetHealthCheckStatus() {
		super();
		try {
			this.setUp();
			service = this.getServiceInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetHealthCheckStatus() {
		Assert.assertNotNull(service.getHealthCheck());
	}

	@Test
	public void testGetHealthCheckStatusOptions() {
		GetHealthCheckOptions options = new GetHealthCheckOptions.Builder().build();

		ServiceCall<String> sc = service.getHealthCheck(options);
		Response<String> response = sc.execute();

		Assert.assertEquals(response.getResult(), "{\"serviceState\":\"OK\"}");
	}

	@Test
	public void testGetHealthCheckStatusInclResponseDetails() {

		Response<String> response = service.getHealthCheckInclResponseDetails();

		Assert.assertEquals(response.getResult(), "{\"serviceState\":\"OK\"}");
	}

	@Test
	public void testGetBuilderFromOptions() {
		GetHealthCheckOptions options = new GetHealthCheckOptions.Builder().build();
		Builder builder = options.newBuilder();
		Assert.assertNotNull(builder);
	}
}
