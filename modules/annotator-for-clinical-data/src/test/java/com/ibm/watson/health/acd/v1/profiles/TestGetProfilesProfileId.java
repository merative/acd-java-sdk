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

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.watson.health.acd.v1.AnnotatorForClinicalData;
import com.ibm.watson.health.acd.v1.WatsonServiceTest;
import com.ibm.watson.health.acd.v1.common.Constants;
import com.ibm.watson.health.acd.v1.model.AcdProfile;
import com.ibm.watson.health.acd.v1.model.Annotator;
import com.ibm.watson.health.acd.v1.model.GetProfileOptions;
import com.ibm.watson.health.acd.v1.model.GetProfileOptions.Builder;

/**
 *
 * Class for testing /v1/profiles/{id}.
 *
 */
public class TestGetProfilesProfileId extends WatsonServiceTest {
	private AnnotatorForClinicalData service;

	public TestGetProfilesProfileId() {
		super();
		try {
			service = this.getServiceInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetProfile() {
		GetProfileOptions options = new GetProfileOptions.Builder().id(Constants.PROFILE_ID).build();

		Response<AcdProfile> response = null;
		try {
			ServiceCall<AcdProfile> sc = service.getProfile(options);
			response = sc.execute();
		} catch (ServiceResponseException e) {
			// Base class for all exceptions caused by error responses from the service
			System.out.println("testGetProfile: Service returned status code "
					+ e.getStatusCode() + ": " + e.getMessage());
			System.out.println("Detailed error info:\n" + e.getDebuggingInfo().toString());
		}
		if (response != null) {
			AcdProfile profile = response.getResult();
			Assert.assertNotNull(profile);
			Assert.assertEquals(profile.id(), Constants.PROFILE_ID);
			Assert.assertNotNull(profile.name());
			if (profile.description() != null) {
				Assert.assertTrue(profile.description().length() > 0);
			}
			List<Annotator> annotators = profile.annotators();
			Assert.assertNotNull(annotators);
			for (Annotator annotator : annotators) {
				Assert.assertNotNull(annotator.name());
				Assert.assertNull(annotator.description());
			}
		}
	}

	@Test
	public void testGetProfileBuilder() {
		Builder builder = new GetProfileOptions.Builder(Constants.PROFILE_ID);

		Response<AcdProfile> response = null;
		try {
			ServiceCall<AcdProfile> sc = service.getProfile(builder.build());
			response = sc.execute();
		} catch (ServiceResponseException e) {
			// Base class for all exceptions caused by error responses from the service
			System.out.println("testGetProfileBuilder: Service returned status code "
					+ e.getStatusCode() + ": " + e.getMessage());
			System.out.println("Detailed error info:\n" + e.getDebuggingInfo().toString());
		}
		if (response != null) {
			AcdProfile profile = response.getResult();
			Assert.assertNotNull(profile);
			Assert.assertEquals(profile.id(), Constants.PROFILE_ID);
			Assert.assertNotNull(profile.name());
			List<Annotator> annotators = profile.annotators();
			Assert.assertNotNull(annotators);
			for (Annotator annotator : annotators) {
				Assert.assertNotNull(annotator.name());
				Assert.assertNull(annotator.description());
			}
		}
	}

	@Test
	public void testGetBuilderFromOptions() {
		GetProfileOptions options = new GetProfileOptions.Builder().id(Constants.PROFILE_ID).build();

		Builder builder = options.newBuilder();
		Assert.assertNotNull(builder);
	}
}
