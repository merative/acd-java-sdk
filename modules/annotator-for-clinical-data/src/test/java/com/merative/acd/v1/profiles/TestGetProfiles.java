/* ***************************************************************** */
/*                                                                   */
/* (C) Copyright Merative US L.P. and others 2018, 2023              */
/*                                                                   */
/* SPDX-License-Identifier: Apache-2.0                               */
/*                                                                   */
/* ***************************************************************** */

package com.merative.acd.v1.profiles;

import org.junit.Assert;
import org.junit.Test;
import java.util.Map;
import java.util.Set;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.merative.acd.v1.AnnotatorForClinicalData;
import com.merative.acd.v1.AcdServiceTest;
import com.merative.acd.v1.common.Constants;
import com.merative.acd.v1.model.GetProfilesOptions;
import com.merative.acd.v1.model.ServiceStatus;
import com.merative.acd.v1.model.GetProfilesOptions.Builder;
import com.merative.acd.v1.model.AcdProfile;

/**
 *
 * Class for testing /v1/profiles.
 *
 */
public class TestGetProfiles extends AcdServiceTest {
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
