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
package com.ibm.watson.health.acd.v1.acd;

import org.junit.Assert;
import org.junit.Test;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.watson.health.acd.v1.AnnotatorForClinicalData;
import com.ibm.watson.health.acd.v1.WatsonServiceTest;
import com.ibm.watson.health.acd.v1.common.Constants;
import com.ibm.watson.health.acd.v1.model.GetAnnotatorsOptions;
import com.ibm.watson.health.acd.v1.model.ListAnnotatorsOptions;
import com.ibm.watson.health.acd.v1.model.ListAnnotatorsOptions.Builder;
import com.ibm.watson.health.acd.v1.model.ListStringWrapper;

/**
 *
 * Class for testing /v1/annotators.
 *
 */
public class TestGetAnnotators extends WatsonServiceTest {
	private AnnotatorForClinicalData service;

	public TestGetAnnotators() {
		super();
		try {
			this.setUp();
			service = this.getServiceInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetAnnotators() {
		Assert.assertNotNull(service.getAnnotators());
	}

	@Test
	public void testGetAnnotatorsOptions() {
		GetAnnotatorsOptions options = new GetAnnotatorsOptions();
		ServiceCall<ListStringWrapper> sc = service.getAnnotators(options);
		Response<ListStringWrapper> response = sc.execute();
		Assert.assertNotNull(response.getResult());
	}

	@Test
	public void testGetBuilderFromOptions() {
		ListAnnotatorsOptions options = new ListAnnotatorsOptions.Builder().build();
		Builder builder = options.newBuilder();
		Assert.assertNotNull(builder);
	}
}
