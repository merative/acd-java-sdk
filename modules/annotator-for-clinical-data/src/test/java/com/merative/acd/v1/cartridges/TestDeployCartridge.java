/* ***************************************************************** */
/*                                                                   */
/* (C) Copyright Merative US L.P. and others 2020, 2023              */
/*                                                                   */
/* SPDX-License-Identifier: Apache-2.0                               */
/*                                                                   */
/* ***************************************************************** */

package com.merative.acd.v1.cartridges;

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
import com.merative.acd.v1.AnnotatorForClinicalData;
import com.merative.acd.v1.AcdServiceTest;
import com.merative.acd.v1.model.DeleteUserSpecificArtifactsOptions;
import com.merative.acd.v1.model.DeployCartridgeOptions;
import com.merative.acd.v1.model.DeployCartridgeOptions.Builder;
import com.merative.acd.v1.model.DeployCartridgeResponse;

/**
*
* Class for testing POST /v1/deploy.
*
*/
public class TestDeployCartridge extends AcdServiceTest {
	private AnnotatorForClinicalData service;

	private Response<Void> deleteExistingCartridge(File cartridgeFile) {
		Response<Void> resp = null;
		DeleteUserSpecificArtifactsOptions options = new DeleteUserSpecificArtifactsOptions();

		try {
			ServiceCall<Void> sc = service.deleteUserSpecificArtifacts(options);
			resp = sc.execute();
		} catch (ServiceResponseException e) {
			// Base class for all exceptions caused by error responses from the service
			System.out.println("testDeployCartridge (Delete): Service returned status code "
					+ e.getStatusCode() + ": " + e.getMessage());
			System.out.println("Detailed error info:\n" + e.getDebuggingInfo().toString());
		}
		return resp;
	}

	public TestDeployCartridge() {
		super();
		try {
			this.setUp();
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
	public void testDeployCartridge() {
		File cartridgeFile = new File("src/test/java/com/merative/acd/v1/cartridges/javasdktestcartridge.zip");

		Boolean fileFound = true;
		DeployCartridgeOptions options = null;
		try {
			options = new DeployCartridgeOptions.Builder().archiveFile(cartridgeFile).build();
		} catch (FileNotFoundException e) {
			fileFound = false;
		}
		Assert.assertTrue(fileFound);
		Assert.assertTrue(options != null);

		Response<DeployCartridgeResponse> response = null;
		try {
			ServiceCall<DeployCartridgeResponse> sc = service.deployCartridge(options);
			response = sc.execute();
		} catch (ServiceResponseException e1) {
			// Base class for all exceptions caused by error responses from the service
			System.out.println("testDeployCartridge: Service returned status code "
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
	public void testDeployCartridgeBuilder() {
		File cartridgeFile = new File("src/test/java/com/merative/acd/v1/cartridges/javasdktestcartridge.zip");
		Boolean fileFound = true;
		Builder builder = null;
		try {
			builder = new DeployCartridgeOptions.Builder().archiveFile(cartridgeFile);
		} catch (FileNotFoundException e) {
			fileFound = false;
		}
		Assert.assertTrue(fileFound);
		Assert.assertTrue(builder != null);

		Response<DeployCartridgeResponse> response = null;
		try {
			ServiceCall<DeployCartridgeResponse> sc = service.deployCartridge(builder.build());
			response = sc.execute();
		} catch (ServiceResponseException e) {
			// Base class for all exceptions caused by error responses from the service
			System.out.println("testDeployCartridgeBuilder: Service returned status code "
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
		DeployCartridgeOptions options = new DeployCartridgeOptions.Builder().build();

		Builder builder = options.newBuilder();
		Assert.assertNotNull(builder);
	}
}
