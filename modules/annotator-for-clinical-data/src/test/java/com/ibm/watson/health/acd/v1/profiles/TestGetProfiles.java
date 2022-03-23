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
package com.ibm.watson.health.acd.v1.profiles;

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
import com.ibm.watson.health.acd.v1.model.GetProfilesOptions;
import com.ibm.watson.health.acd.v1.model.ServiceStatus;
import com.ibm.watson.health.acd.v1.model.GetProfilesOptions.Builder;
import com.ibm.watson.health.acd.v1.model.AcdProfile;

/**
 *
 * Class for testing /v1/profiles.
 *
 */
public class TestGetProfiles extends WatsonServiceTest {
	private AnnotatorForClinicalData service;

	public TestGetProfiles() {
		super();
		try {
			service = this.getServiceInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Test
	public void testGetProfiles() {
		GetProfilesOptions options = new GetProfilesOptions.Builder().build();

		Response<Map<String, AcdProfile>> response = null;
		try {
		ServiceCall<Map<String, AcdProfile>> sc = service.getProfiles(options);
		response = sc.execute();
		} catch (ServiceResponseException e) {
			// Base class for all exceptions caused by error responses from the service
			System.out.println("testGetProfiles: Service returned status code "
					+ e.getStatusCode() + ": " + e.getMessage());
			System.out.println("Detailed error info:\n" + e.getDebuggingInfo().toString());
		}
		if (response != null) {
			Assert.assertNotNull(response.getResult());
			Map<String, AcdProfile> profileMap = response.getResult();
			Set<String> keys = profileMap.keySet();
			for (String key : keys) {
				Assert.assertNotNull(profileMap.get(key));
			}
		}
	}

	@Test
	public void testGetProfilesNoOptions() {
		Response<Map<String, AcdProfile>> response = null;
		try {
			ServiceCall<Map<String, AcdProfile>> sc = service.getProfiles();
			response = sc.execute();
		} catch (ServiceResponseException e) {
			// Base class for all exceptions caused by error responses from the service
			System.out.println("testGetProfilesNoOptions: Service returned status code "
					+ e.getStatusCode() + ": " + e.getMessage());
			System.out.println("Detailed error info:\n" + e.getDebuggingInfo().toString());
		}
		if (response != null) {
			Assert.assertNotNull(response.getResult());
			Map<String, AcdProfile> profileMap = response.getResult();
			Set<String> keys = profileMap.keySet();
			for (String key : keys) {
				Assert.assertNotNull(profileMap.get(key));
			}
		}
	}

	@Test
	public void testGetProfilesBuilder() {
		Builder builder = new GetProfilesOptions.Builder();

		Response<Map<String, AcdProfile>> response = null;
		try {
		ServiceCall<Map<String, AcdProfile>> sc = service.getProfiles(builder.build());
		response = sc.execute();
		} catch (ServiceResponseException e) {
			// Base class for all exceptions caused by error responses from the service
			System.out.println("testGetProfilesBuilder: Service returned status code "
					+ e.getStatusCode() + ": " + e.getMessage());
			System.out.println("Detailed error info:\n" + e.getDebuggingInfo().toString());
		}
		if (response != null) {
			Assert.assertNotNull(response.getResult());
			Map<String, AcdProfile> profileMap = response.getResult();
			Set<String> keys = profileMap.keySet();
			for (String key : keys) {
				Assert.assertNotNull(profileMap.get(key));
			}
		}
	}

	@Test
	public void testGetBuilderFromOptions() {
		GetProfilesOptions options = new GetProfilesOptions.Builder().build();

		Builder builder = options.newBuilder();
		Assert.assertNotNull(builder);
	}
}
