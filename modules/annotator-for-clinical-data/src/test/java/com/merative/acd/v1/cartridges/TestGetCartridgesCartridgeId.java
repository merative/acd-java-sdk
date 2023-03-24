/* ***************************************************************** */
/*                                                                   */
/* (C) Copyright Merative US L.P. and others 2018, 2023              */
/*                                                                   */
/* SPDX-License-Identifier: Apache-2.0                               */
/*                                                                   */
/* ***************************************************************** */

package com.merative.acd.v1.cartridges;

import org.junit.Assert;
import org.junit.Test;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.merative.acd.v1.AnnotatorForClinicalData;
import com.merative.acd.v1.AcdServiceTest;
import com.merative.acd.v1.common.Constants;
import com.merative.acd.v1.model.AcdCartridges;
import com.merative.acd.v1.model.CartridgesGetIdOptions;
import com.merative.acd.v1.model.CartridgesGetIdOptions.Builder;

/**
*
* Class for testing GET /v1/cartridges/{id}.
*
*/
public class TestGetCartridgesCartridgeId extends AcdServiceTest {
	private AnnotatorForClinicalData service;

	public TestGetCartridgesCartridgeId() {
		super();
		try {
			service = this.getServiceInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetCartridgesCartridgeId() {
		CartridgesGetIdOptions options = new CartridgesGetIdOptions.Builder().id(Constants.CARTRIDGE_ID).build();

		Response<AcdCartridges> response = null;
		try {
			ServiceCall<AcdCartridges> sc = service.cartridgesGetId(options);
			response = sc.execute();
		} catch (ServiceResponseException e) {
			// Base class for all exceptions caused by error responses from the service
			System.out.println("testGetCartridgesCartridgeId: Service returned status code "
					+ e.getStatusCode() + ": " + e.getMessage());
			System.out.println("Detailed error info:\n" + e.getDebuggingInfo().toString());
		}
		if (response != null) {
			Assert.assertNotNull(response.getResult());
			AcdCartridges cartridge = response.getResult();
			Assert.assertNotNull(cartridge.getId());
		}
	}

	@Test
	public void testGetCartridgesCartridgeIdBuilder() {
		Builder builder = new CartridgesGetIdOptions.Builder(Constants.CARTRIDGE_ID);

		Response<AcdCartridges> response = null;
		try {
			ServiceCall<AcdCartridges> sc = service.cartridgesGetId(builder.build());
			response = sc.execute();
		} catch (ServiceResponseException e) {
			// Base class for all exceptions caused by error responses from the service
			System.out.println("testGetCartridgesCartridgeIdBuilder: Service returned status code "
					+ e.getStatusCode() + ": " + e.getMessage());
			System.out.println("Detailed error info:\n" + e.getDebuggingInfo().toString());
		}
		if (response != null) {
			Assert.assertNotNull(response.getResult());
			AcdCartridges cartridge = response.getResult();
			Assert.assertNotNull(cartridge.getId());
		}
	}

	@Test
	public void testGetBuilderFromOptions() {
		CartridgesGetIdOptions options = new CartridgesGetIdOptions.Builder().id(Constants.CARTRIDGE_ID).build();

		Builder builder = options.newBuilder();
		Assert.assertNotNull(builder);
	}
}
