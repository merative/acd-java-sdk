/* ***************************************************************** */
/*                                                                   */
/* (C) Copyright Merative US L.P. and others 2018, 2023              */
/*                                                                   */
/* SPDX-License-Identifier: Apache-2.0                               */
/*                                                                   */
/* ***************************************************************** */

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
import com.ibm.watson.health.acd.v1.model.GetProfileOptions;
import com.ibm.watson.health.acd.v1.model.UpdateProfileOptions;
import com.ibm.watson.health.acd.v1.model.UpdateProfileOptions.Builder;

/**
 *
 * Class for testing PUT /v1/profiles/{id}.
 *
 */
public class TestUpdateProfiles extends WatsonServiceTest {
	private AnnotatorForClinicalData service;

	private Response<Void> createProfileForUpdateTest() {
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
			System.out.println("testUpdateProfiles (Create): Service returned status code "
					+ e.getStatusCode() + ": " + e.getMessage());
			System.out.println("Detailed error info:\n" + e.getDebuggingInfo().toString());
		}
		return resp;
	}

	private Response<Void> deleteExistingProfile(String profileId) {
		DeleteProfileOptions options = new DeleteProfileOptions.Builder().id(profileId).build();

		Response<Void> resp = null;
		try {
			ServiceCall<Void> sc = service.deleteProfile(options);
			resp = sc.execute();
		} catch (ServiceResponseException e) {
			// Base class for all exceptions caused by error responses from the service
			System.out.println("testUpdateProfiles (Delete): Service returned status code "
					+ e.getStatusCode() + ": " + e.getMessage());
			System.out.println("Detailed error info:\n" + e.getDebuggingInfo().toString());
		}
		return resp;
	}

	public TestUpdateProfiles() {
		super();
		try {
			service = this.getServiceInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdateProfiles() {
		// Determine if profile exists
		GetProfileOptions getOptions = new GetProfileOptions.Builder().id("java_sdk_test_profile").build();
		try {
			ServiceCall<AcdProfile> sc = service.getProfile(getOptions);
			sc.execute();
		} catch (ServiceResponseException e) {
			if (e != null && e.getStatusCode() == HttpStatus.NOT_FOUND) {
				createProfileForUpdateTest();
			}
		}

		UpdateProfileOptions options = new UpdateProfileOptions.Builder()
				.id("java_sdk_test_profile")
				.newId("java_sdk_test_profile")
				.build();

		Response<Void> response = null;
		try {
			ServiceCall<Void> sc = service.updateProfile(options);
			response = sc.execute();
		} catch (ServiceResponseException e1) {
			// Base class for all exceptions caused by error responses from the service
			System.out.println("testUpdateProfiles (Update): Service returned status code "
					+ e1.getStatusCode() + ": " + e1.getMessage());
			System.out.println("Detailed error info:\n" + e1.getDebuggingInfo().toString());
		}
		if (response != null) {
			Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
		}
		deleteExistingProfile("java_sdk_test_profile");
	}

	@Test
	public void testUpdateProfilesBuilder() {
		// Determine if profile exists
		GetProfileOptions getOptions = new GetProfileOptions.Builder().id("java_sdk_test_profile").build();
		try {
			ServiceCall<AcdProfile> sc = service.getProfile(getOptions);
			sc.execute();
		} catch (ServiceResponseException e) {
			if (e != null && e.getStatusCode() == HttpStatus.NOT_FOUND) {
				createProfileForUpdateTest();
			}
		}
		//Builder builder = new UpdateProfileOptions.Builder("java_sdk_test_profile");
		Builder builder = new UpdateProfileOptions.Builder()
				.id("java_sdk_test_profile")
				.newId("java_sdk_test_profile");

		Response<Void> response = null;
		try {
			ServiceCall<Void> sc = service.updateProfile(builder.build());
			response = sc.execute();
		} catch (ServiceResponseException e1) {
			// Base class for all exceptions caused by error responses from the service
			System.out.println("testUpdateProfilesBuilder (Update): Service returned status code "
					+ e1.getStatusCode() + ": " + e1.getMessage());
			System.out.println("Detailed error info:\n" + e1.getDebuggingInfo().toString());
		}
		if (response != null) {
			Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
		}
		deleteExistingProfile("java_sdk_test_profile");
	}

	@Test
	public void testBuilderFromOptions() {
		UpdateProfileOptions options = new UpdateProfileOptions.Builder().id("abcd").build();

		Builder builder = options.newBuilder();
		Assert.assertNotNull(builder);
	}
}
