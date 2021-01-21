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
package com.ibm.watson.health.acd.v1.profiles;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.ibm.cloud.sdk.core.http.HttpStatus;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.watson.health.acd.v1.AnnotatorForClinicalData;
import com.ibm.watson.health.acd.v1.WatsonServiceTest;
import com.ibm.watson.health.acd.v1.model.AcdProfile;
import com.ibm.watson.health.acd.v1.model.Annotator;
import com.ibm.watson.health.acd.v1.model.CreateProfileOptions;
import com.ibm.watson.health.acd.v1.model.DeleteProfileOptions;
import com.ibm.watson.health.acd.v1.model.DeleteProfileOptions.Builder;
import com.ibm.watson.health.acd.v1.model.GetProfileOptions;

/**
 *
 * Class for testing DELETE /v1/profiles/{id}.
 *
 */
public class TestDeleteProfiles extends WatsonServiceTest {
	private AnnotatorForClinicalData service;

	private Response<Void> createProfileForDeleteTest() {
		Map<String, List<String>> paramMap = new HashMap<String, List<String>>();
		paramMap.put("libraries", Arrays.asList("umls.latest"));
		Annotator conceptDetection = new Annotator.Builder()
				.name(Annotator.Name.CONCEPT_DETECTION)
				.parameters(paramMap)
				.build();
		AcdProfile acdProfile = new AcdProfile.Builder()
				.id("java_sdk_test_profile")
				.annotators(Arrays.asList(conceptDetection))
				.build();

		CreateProfileOptions options = new CreateProfileOptions.Builder()
				.acdProfile(acdProfile)
				.build();

		Response<Void> resp = null;
		try {
			ServiceCall<Void> scCreate = service.createProfile(options);
			resp = scCreate.execute();
		} catch (ServiceResponseException e) {
			// Base class for all exceptions caused by error responses from the service
			System.out.println("testDeleteProfiles (Create): Service returned status code "
					+ e.getStatusCode() + ": " + e.getMessage());
			System.out.println("Detailed error info:\n" + e.getDebuggingInfo().toString());
		}
		return resp;
	}

	public TestDeleteProfiles() {
		super();
		try {
			this.setUp();
			service = this.getServiceInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDeleteProfiles() {
		// Determine if profile exists
		GetProfileOptions getOptions = new GetProfileOptions.Builder().id("java_sdk_test_profile").build();
		try {
			ServiceCall<AcdProfile> sc = service.getProfile(getOptions);
			sc.execute();
		} catch (ServiceResponseException e) {
			if (e != null && e.getStatusCode() == HttpStatus.NOT_FOUND) {
				createProfileForDeleteTest();
			}
		}

		DeleteProfileOptions options = new DeleteProfileOptions.Builder().id("java_sdk_test_profile").build();
		Response<Void> response = null;
		try {
			ServiceCall<Void> sc = service.deleteProfile(options);
			response = sc.execute();
		} catch (ServiceResponseException e1) {
			// Base class for all exceptions caused by error responses from the service
			System.out.println("testDeleteProfiles (Delete): Service returned status code "
					+ e1.getStatusCode() + ": " + e1.getMessage());
			System.out.println("Detailed error info:\n" + e1.getDebuggingInfo().toString());
		}
		if (response != null) {
			Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
		}
	}

	@Test
	public void testDeleteProfilesBuilder() {
		// Determine if profile exists
		GetProfileOptions getOptions = new GetProfileOptions.Builder().id("java_sdk_test_profile").build();
		try {
			ServiceCall<AcdProfile> sc = service.getProfile(getOptions);
			sc.execute();
		} catch (ServiceResponseException e) {
			if (e != null && e.getStatusCode() == HttpStatus.NOT_FOUND) {
				createProfileForDeleteTest();
			}
		}
		Builder builder = new DeleteProfileOptions.Builder("java_sdk_test_profile");

		Response<Void> response = null;
		try {
			ServiceCall<Void> sc = service.deleteProfile(builder.build());
			response = sc.execute();
		} catch (ServiceResponseException e1) {
			// Base class for all exceptions caused by error responses from the service
			System.out.println("testDeleteProfilesBuilder (Delete): Service returned status code "
					+ e1.getStatusCode() + ": " + e1.getMessage());
			System.out.println("Detailed error info:\n" + e1.getDebuggingInfo().toString());
		}
		if (response != null) {
			Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
		}
	}

	@Test
	public void testBuilderFromOptions() {
		DeleteProfileOptions options = new DeleteProfileOptions.Builder().id("abcd").build();

		Builder builder = options.newBuilder();
		Assert.assertNotNull(builder);
	}
}
