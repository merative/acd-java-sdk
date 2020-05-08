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
package com.ibm.watson.health.iml.v1.status;

import org.junit.Assert;
import org.junit.Test;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.watson.health.iml.v1.InsightsForMedicalLiteratureService;
import com.ibm.watson.health.iml.v1.common.Constants;
import com.ibm.watson.health.iml.v1.model.GetHealthCheckStatusOptions;
import com.ibm.watson.health.iml.v1.model.GetHealthCheckStatusOptions.Builder;
import com.ibm.watson.health.iml.v1.model.ServiceStatus;
import com.ibm.watson.health.iml.v1.utils.ServiceUtilities;

/**
 *
 * Class for testing /v1/status/health_check.
 *
 */
public class TestGetStatusHealthCheck {
	private InsightsForMedicalLiteratureService imlService;

	public TestGetStatusHealthCheck() {
		try {
			imlService = ServiceUtilities.getServiceInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetHealthCheckStatus() {
		GetHealthCheckStatusOptions options = new GetHealthCheckStatusOptions.Builder().build();

		ServiceCall<ServiceStatus> sc = imlService.getHealthCheckStatus(options);
		Response<ServiceStatus> response = sc.execute();
		ServiceStatus status = response.getResult();
		Assert.assertEquals(status.getServiceState(), Constants.STATUS_OK);
		String details = status.getStateDetails();
		if (details != null) {
			Assert.assertTrue(details.length() > 0);
		} else {
			Assert.assertNull(details);
		}
	}

	@Test
	public void testGetHealthCheckStatusNoOptions() {

		ServiceCall<ServiceStatus> sc = imlService.getHealthCheckStatus();
		Response<ServiceStatus> response = sc.execute();
		ServiceStatus status = response.getResult();
		Assert.assertEquals(status.getServiceState(), Constants.STATUS_OK);
		String details = status.getStateDetails();
		if (details != null) {
			Assert.assertTrue(details.length() > 0);
		} else {
			Assert.assertNull(details);
		}
	}

	@Test
	public void testGetHealthCheckStatusNullOptions() {

		ServiceCall<ServiceStatus> sc = imlService.getHealthCheckStatus(null);
		Response<ServiceStatus> response = sc.execute();
		ServiceStatus status = response.getResult();
		Assert.assertEquals(status.getServiceState(), Constants.STATUS_OK);
		String details = status.getStateDetails();
		if (details != null) {
			Assert.assertTrue(details.length() > 0);
		} else {
			Assert.assertNull(details);
		}
	}

	@Test
	public void testGetHealthCheckStatusFormatXML() {
		GetHealthCheckStatusOptions options = new GetHealthCheckStatusOptions.Builder()
				.format(Constants.XML_FORMAT).build();

		ServiceCall<ServiceStatus> sc = imlService.getHealthCheckStatus(options);
		Response<ServiceStatus> response = sc.execute();
		ServiceStatus status = response.getResult();
		Assert.assertEquals(status.getServiceState(), Constants.STATUS_OK);
	}

	@Test
	public void testGetHealthCheckStatusAcceptXML() {
		GetHealthCheckStatusOptions options = new GetHealthCheckStatusOptions.Builder()
				.accept(Constants.XML_FORMAT).build();

		ServiceCall<ServiceStatus> sc = imlService.getHealthCheckStatus(options);
		Response<ServiceStatus> response = sc.execute();
		ServiceStatus status = response.getResult();
		Assert.assertEquals(status.getServiceState(), Constants.STATUS_OK);
	}

	@Test
	public void testGetBuilderFromOptions() {
		GetHealthCheckStatusOptions options = new GetHealthCheckStatusOptions.Builder()
				.accept(Constants.XML_FORMAT).build();

		Builder builder = options.newBuilder();
		Assert.assertNotNull(builder);
	}
}
