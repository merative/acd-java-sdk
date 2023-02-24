/* ***************************************************************** */
/*                                                                   */
/* (C) Copyright Merative US L.P. and others 2018, 2023              */
/*                                                                   */
/* SPDX-License-Identifier: Apache-2.0                               */
/*                                                                   */
/* ***************************************************************** */

package com.merative.acd.v1.profiles;

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
import com.merative.acd.v1.AnnotatorForClinicalData;
import com.merative.acd.v1.AcdServiceTest;
import com.merative.acd.v1.model.AcdProfile;
import com.merative.acd.v1.model.Annotator;
import com.merative.acd.v1.model.CreateProfileOptions;
import com.merative.acd.v1.model.CreateProfileOptions.Builder;
import com.merative.acd.v1.model.DeleteProfileOptions;
import com.merative.acd.v1.model.GetProfileOptions;

/**
 *
 * Class for testing POST /v1/profiles/{id}.
 *
 */
public class TestCreateProfiles extends AcdServiceTest {
	private AnnotatorForClinicalData service;

	private Response<Void> deleteExistingProfile(String profileId) {
		DeleteProfileOptions options = new DeleteProfileOptions.Builder().id(profileId).build();

		Response<Void> resp = null;
		try {
			ServiceCall<Void> sc = service.deleteProfile(options);
			resp = sc.execute();
		} catch (ServiceResponseException e) {
			// Base class for all exceptions caused by error responses from the service
			System.out.println("testCreateProfiles (Delete): Service returned status code "
					+ e.getStatusCode() + ": " + e.getMessage());
			System.out.println("Detailed error info:\n" + e.getDebuggingInfo().toString());
		}
		return resp;
	}

	public TestCreateProfiles() {
		super();
		try {
			service = this.getServiceInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testCreateProfiles() {
		// Determine if profile exists
		Boolean profileExists = false;
		GetProfileOptions getOptions = new GetProfileOptions.Builder().id("java_sdk_test_profile").build();
		try {
			ServiceCall<AcdProfile> sc = service.getProfile(getOptions);
			sc.execute();
			profileExists = true;
		} catch (ServiceResponseException e) {
		}
		if (profileExists) {
			deleteExistingProfile("java_sdk_test_profile");
		}
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

		CreateProfileOptions createOptions = new CreateProfileOptions.Builder()
				.acdProfile(acdProfile)
				.build();

		Response<Void> resp = null;
		try {
			ServiceCall<Void> scCreate = service.createProfile(createOptions);
			resp = scCreate.execute();
		} catch (ServiceResponseException e1) {
			// Base class for all exceptions caused by error responses from the service
			System.out.println("testCreateProfiles (Create): Service returned status code "
					+ e1.getStatusCode() + ": " + e1.getMessage());
			System.out.println("Detailed error info:\n" + e1.getDebuggingInfo().toString());
		}
		if (resp != null) {
			Assert.assertEquals(resp.getStatusCode(), HttpStatus.CREATED);
			deleteExistingProfile("java_sdk_test_profile");
		}

		// negative test
		boolean illegalArgTest = false;
		try {
			ServiceCall<Void> scCreate = service.createProfile();
			scCreate.execute();
		} catch (IllegalArgumentException e1) {
			illegalArgTest = true;
		}
		Assert.assertTrue(illegalArgTest);
	}

	@Test
	public void testCreateProfilesBuilder() {
		// Determine if profile exists
		Boolean profileExists = false;
		GetProfileOptions getOptions = new GetProfileOptions.Builder().id("java_sdk_test_profile").build();
		try {
			ServiceCall<AcdProfile> sc = service.getProfile(getOptions);
			sc.execute();
			profileExists = true;
		} catch (ServiceResponseException e) {
		}
		if (profileExists) {
			deleteExistingProfile("java_sdk_test_profile");
		}
		Map<String, List<String>> paramMap = new HashMap<String, List<String>>();
		paramMap.put("libraries", Arrays.asList("umls.latest"));
		Annotator conceptDetection = new Annotator.Builder()
				.name(Annotator.Name.CONCEPT_DETECTION)
				.parameters(paramMap)
				.build();

		Builder builder = new CreateProfileOptions.Builder()
				.id("java_sdk_test_profile")
				.annotators(Arrays.asList(conceptDetection));

		Response<Void> resp = null;
		try {
			ServiceCall<Void> scCreate = service.createProfile(builder.build());
			resp = scCreate.execute();
		} catch (ServiceResponseException e1) {
			// Base class for all exceptions caused by error responses from the service
			System.out.println("testCreateProfilesBuilder (Create): Service returned status code "
					+ e1.getStatusCode() + ": " + e1.getMessage());
			System.out.println("Detailed error info:\n" + e1.getDebuggingInfo().toString());
		}
		if (resp != null) {
			Assert.assertEquals(resp.getStatusCode(), HttpStatus.CREATED);
			deleteExistingProfile("java_sdk_test_profile");
		}

		// negative test
		boolean illegalArgTest = false;
		try {
			ServiceCall<Void> scCreate = service.createProfile();
			scCreate.execute();
		} catch (IllegalArgumentException e1) {
			illegalArgTest = true;
		}
		Assert.assertTrue(illegalArgTest);
	}

	@Test
	public void testBuilderFromOptions() {
		CreateProfileOptions options = new CreateProfileOptions.Builder().build();

		Builder builder = options.newBuilder();
		Assert.assertNotNull(builder);
	}
}
