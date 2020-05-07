/*
 * Copyright 2018 IBM Corp. All Rights Reserved.
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
package com.ibm.watson.health.iml.v1.corpora;

import org.junit.Assert;
import org.junit.Test;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.watson.health.iml.v1.InsightsForMedicalLiteratureService;
import com.ibm.watson.health.iml.v1.model.MonitorCorpusOptions;
import com.ibm.watson.health.iml.v1.model.MonitorCorpusOptions.Builder;
import com.ibm.watson.health.iml.v1.utils.ServiceUtilities;

public class TestMonitorCorpus {
	private InsightsForMedicalLiteratureService imlService;

	public TestMonitorCorpus() {
		try {
			imlService = ServiceUtilities.getServiceInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testMonitorCorpus() {
		String apikey = "12";
		MonitorCorpusOptions monitorOptions = new MonitorCorpusOptions.Builder(apikey).build();

		ServiceCall<Void> sc = imlService.monitorCorpus(monitorOptions);
		try {
			Response<Void> response = sc.execute();
		} catch (Exception mie) {
			Assert.assertNotNull(mie.getMessage());
		}
	}

	@Test
	public void testMonitorCorpusEmptyBuilder() {
		String apikey = "12";
		MonitorCorpusOptions monitorOptions = new MonitorCorpusOptions.Builder().apikey(apikey).build();

		ServiceCall<Void> sc = imlService.monitorCorpus(monitorOptions);
		try {
			Response<Void> response = sc.execute();
		} catch (Exception mie) {
			Assert.assertNotNull(mie.getMessage());
		}
	}

	@Test
	public void testGetBuilderFromOptions() {
		String apikey = "12";
		MonitorCorpusOptions monitorOptions = new MonitorCorpusOptions.Builder().apikey(apikey).build();

		Builder builder = monitorOptions.newBuilder();
		Assert.assertNotNull(builder);
	}
}
