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

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.http.ServiceCall;
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
			this.setUp();
			service = this.getServiceInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetProfiles() {
		Assert.assertNotNull(service.getProfiles());
	}

	@Test
	public void testGetProfile() {
		GetProfileOptions options = new GetProfileOptions.Builder().id(Constants.PROFILE_ID).build();

		ServiceCall<AcdProfile> sc = service.getProfile(options);
		Response<AcdProfile> response = sc.execute();
		AcdProfile profile = response.getResult();
		Assert.assertNotNull(profile);
		Assert.assertEquals(profile.getId(), Constants.PROFILE_ID);
		Assert.assertNotNull(profile.getName());
		if (profile.getDescription() != null) {
			Assert.assertTrue(profile.getDescription().length() > 0);
		}
		List<Annotator> annotators = profile.getAnnotators();
		Assert.assertNotNull(annotators);
		for (Annotator annotator : annotators) {
			Assert.assertNotNull(annotator.name());
			Assert.assertNull(annotator.description());
		}
	}

	@Test
	public void testGetProfileForId() {

		AcdProfile profile = service.getProfile(Constants.PROFILE_ID);

		Assert.assertNotNull(profile);
		Assert.assertEquals(profile.getId(), Constants.PROFILE_ID);
		Assert.assertNotNull(profile.getName());
		Assert.assertNotNull(profile.getDescription());
		List<Annotator> annotators = profile.getAnnotators();
		Assert.assertNotNull(annotators);
		for (Annotator annotator : annotators) {
			Assert.assertNotNull(annotator.name());
			Assert.assertNull(annotator.description());
		}
	}

	@Test
	public void testGetProfileForIdIncResponseDetails() {

		Response<AcdProfile> response  = service.getProfileInclResponseDetails(Constants.PROFILE_ID);
		AcdProfile profile = response.getResult();
		Assert.assertNotNull(profile);
		Assert.assertEquals(profile.getId(), Constants.PROFILE_ID);
		Assert.assertNotNull(profile.getName());
		Assert.assertNotNull(profile.getDescription());
		List<Annotator> annotators = profile.getAnnotators();
		Assert.assertNotNull(annotators);
		for (Annotator annotator : annotators) {
			Assert.assertNotNull(annotator.name());
			Assert.assertNull(annotator.description());
		}
	}

	@Test
	public void testGetProfileBuilder() {
		GetProfileOptions options = new GetProfileOptions.Builder(Constants.PROFILE_ID).build();

		ServiceCall<AcdProfile> sc = service.getProfile(options);
		Response<AcdProfile> response = sc.execute();
		AcdProfile profile = response.getResult();
		Assert.assertNotNull(profile);
		Assert.assertEquals(profile.getId(), Constants.PROFILE_ID);
		Assert.assertNotNull(profile.getName());
		Assert.assertNotNull(profile.getDescription());
		List<Annotator> annotators = profile.getAnnotators();
		Assert.assertNotNull(annotators);
		for (Annotator annotator : annotators) {
			Assert.assertNotNull(annotator.name());
			Assert.assertNull(annotator.description());
		}
	}

	@Test
	public void getBuilderFromOptions() {
		GetProfileOptions options = new GetProfileOptions.Builder().id(Constants.PROFILE_ID).build();
		Builder builder = options.newBuilder();
		Assert.assertNotNull(builder);
	}
}
