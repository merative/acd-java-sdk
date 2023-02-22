/* ***************************************************************** */
/*                                                                   */
/* (C) Copyright Merative US L.P. and others 2020, 2023              */
/*                                                                   */
/* SPDX-License-Identifier: Apache-2.0                               */
/*                                                                   */
/* ***************************************************************** */

package com.ibm.watson.health.acd.v1.cartridges;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.ibm.cloud.sdk.core.http.HttpStatus;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.watson.health.acd.v1.AnnotatorForClinicalData;
import com.ibm.watson.health.acd.v1.WatsonServiceTest;
import com.ibm.watson.health.acd.v1.model.CartridgesPostMultipartOptions;
import com.ibm.watson.health.acd.v1.model.CartridgesPostMultipartOptions.Builder;
import com.ibm.watson.health.acd.v1.model.DeleteUserSpecificArtifactsOptions;
import com.ibm.watson.health.acd.v1.model.DeployCartridgeResponse;

/**
*
* Class for testing POST /v1/cartridges.
*
*/
public class TestCreateCartridges extends WatsonServiceTest {
	private AnnotatorForClinicalData service;

	private Response<Void> deleteExistingCartridge(File cartridgeFile) {
		Response<Void> resp = null;
		DeleteUserSpecificArtifactsOptions options = new DeleteUserSpecificArtifactsOptions();

		try {
			ServiceCall<Void> sc = service.deleteUserSpecificArtifacts(options);
			resp = sc.execute();
		} catch (ServiceResponseException e) {
			// Base class for all exceptions caused by error responses from the service
			System.out.println("testCreateCartridges (Delete): Service returned status code "
					+ e.getStatusCode() + ": " + e.getMessage());
			System.out.println("Detailed error info:\n" + e.getDebuggingInfo().toString());
		}
		return resp;
	}

	public TestCreateCartridges() {
		super();
		try {
			service = this.getServiceInstance();
			Map<String, String> headers = new HashMap<String, String>();
			// set tenant ID
			headers.put("X-IBM-Client-Id", "sdk-test");
			service.setDefaultHeaders(headers);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testCreateCartridges() {
		File cartridgeFile = new File("src/test/java/com/ibm/watson/health/acd/v1/cartridges/javasdktestcartridge.zip");

		Boolean fileFound = true;
		CartridgesPostMultipartOptions options = null;
		try {
			options = new CartridgesPostMultipartOptions.Builder().archiveFile(cartridgeFile).build();
		} catch (FileNotFoundException e) {
			fileFound = false;
		}
		Assert.assertTrue(fileFound);
		Assert.assertTrue(options != null);

		Response<DeployCartridgeResponse> response = null;
		try {
			ServiceCall<DeployCartridgeResponse> sc = service.cartridgesPostMultipart(options);
			response = sc.execute();
		} catch (ServiceResponseException e1) {
			// Base class for all exceptions caused by error responses from the service
			System.out.println("testCreateCartridges: Service returned status code "
					+ e1.getStatusCode() + ": " + e1.getMessage());
			System.out.println("Detailed error info:\n" + e1.getDebuggingInfo().toString());
			if (e1.getStatusCode() == HttpStatus.CONFLICT) {
				deleteExistingCartridge(cartridgeFile);
			}
		}
		if (response != null) {
			Assert.assertNotNull(response.getResult());
			deleteExistingCartridge(cartridgeFile);
		}
	}

	@Test
	public void testCreateCartridgesBuilder() {
		File cartridgeFile = new File("src/test/java/com/ibm/watson/health/acd/v1/cartridges/javasdktestcartridge.zip");
		Boolean fileFound = true;
		Builder builder = null;
		try {
			builder = new CartridgesPostMultipartOptions.Builder().archiveFile(cartridgeFile);
		} catch (FileNotFoundException e) {
			fileFound = false;
		}
		Assert.assertTrue(fileFound);
		Assert.assertTrue(builder != null);

		Response<DeployCartridgeResponse> response = null;
		try {
			ServiceCall<DeployCartridgeResponse> sc = service.cartridgesPostMultipart(builder.build());
			response = sc.execute();
		} catch (ServiceResponseException e) {
			// Base class for all exceptions caused by error responses from the service
			System.out.println("testCreateCartridgesBuilder: Service returned status code "
					+ e.getStatusCode() + ": " + e.getMessage());
			System.out.println("Detailed error info:\n" + e.getDebuggingInfo().toString());
			if (e.getStatusCode() == HttpStatus.CONFLICT) {
				deleteExistingCartridge(cartridgeFile);
			}
		}
		if (response != null) {
			Assert.assertNotNull(response.getResult());
			deleteExistingCartridge(cartridgeFile);
		}
	}

	@Test
	public void testBuilderFromOptions() {
		CartridgesPostMultipartOptions options = new CartridgesPostMultipartOptions.Builder().build();

		Builder builder = options.newBuilder();
		Assert.assertNotNull(builder);
	}
}
