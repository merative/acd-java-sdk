/*
 * (C) Copyright IBM Corp. 2020.
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

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.watson.health.acd.v1.AnnotatorForClinicalData;
import com.ibm.watson.health.acd.v1.WatsonServiceTest;
import com.ibm.watson.health.acd.v1.model.AcdCartridges;
import com.ibm.watson.health.acd.v1.model.AcdCartridgesList;
import com.ibm.watson.health.acd.v1.model.CartridgesGetOptions;

public class TestGetCartridges extends WatsonServiceTest {
	private AnnotatorForClinicalData service;

	public TestGetCartridges() {
		super();
		try {
			this.setUp();
			service = this.getServiceInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetCartridges() {
		Assert.assertNotNull(service.cartridgesGet());
	}

	@Test
	public void testGetCartridgesWOptions() {
		CartridgesGetOptions options = new CartridgesGetOptions();

		ServiceCall<AcdCartridgesList> sc = service.cartridgesGet(options);
		Response<AcdCartridgesList> response = sc.execute();
		Assert.assertNotNull(response.getResult());
		AcdCartridgesList cartridgeList = response.getResult();
		List<AcdCartridges> cartridges = cartridgeList.getCartridges();
		for (AcdCartridges cartridge : cartridges){
			Assert.assertNotNull(cartridge.getId());
		}

	}
}
