/*
 * (C) Copyright IBM Corp. 2022.
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
package com.ibm.watson.health.acd.v1.cartridges;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.watson.health.acd.v1.AnnotatorForClinicalData;
import com.ibm.watson.health.acd.v1.WatsonServiceTest;
import com.ibm.watson.health.acd.v1.model.AcdCartridges;
import com.ibm.watson.health.acd.v1.model.AcdCartridgesList;
import com.ibm.watson.health.acd.v1.model.CartridgesGetOptions;

/**
*
* Class for testing GET /v1/cartridges.
*
*/
public class TestGetCartridges extends WatsonServiceTest {
	private AnnotatorForClinicalData service;

	public TestGetCartridges() {
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
	public void testGetCartridges() {
		CartridgesGetOptions options = new CartridgesGetOptions();

		Response<AcdCartridgesList> response = null;
		try {
			ServiceCall<AcdCartridgesList> sc = service.cartridgesGet(options);
			response = sc.execute();
		} catch (ServiceResponseException e) {
			// Base class for all exceptions caused by error responses from the service
			System.out.println("testGetCartridges: Service returned status code "
					+ e.getStatusCode() + ": " + e.getMessage());
			System.out.println("Detailed error info:\n" + e.getDebuggingInfo().toString());
		}
		if (response != null) {
			Assert.assertNotNull(response.getResult());
			AcdCartridgesList cartridgeList = response.getResult();
			List<AcdCartridges> cartridges = cartridgeList.getCartridges();
			for (AcdCartridges cartridge : cartridges){
				Assert.assertNotNull(cartridge.getId());
			}
		}
	}

	@Test
	public void testGetBuilderFromOptions() {
		CartridgesGetOptions options = new CartridgesGetOptions();
		Assert.assertNotNull(options);
	}
}
