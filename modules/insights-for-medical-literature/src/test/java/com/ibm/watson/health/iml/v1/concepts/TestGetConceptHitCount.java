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
package com.ibm.watson.health.iml.v1.concepts;
import static com.ibm.watson.health.iml.v1.utils.ServiceUtilities.getProperty;
import org.junit.Assert;
import org.junit.Test;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.watson.health.iml.v1.InsightsForMedicalLiteratureService;
import com.ibm.watson.health.iml.v1.model.GetHitCountOptions;
import com.ibm.watson.health.iml.v1.model.GetHitCountOptions.Builder;
import com.ibm.watson.health.iml.v1.model.HitCount;
import com.ibm.watson.health.iml.v1.utils.ServiceUtilities;

public class TestGetConceptHitCount {
	static final String CORPUS = "CORPUS";
	private InsightsForMedicalLiteratureService imlService;

	public TestGetConceptHitCount() {
		try {
			imlService = ServiceUtilities.getServiceInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void getConceptHitCount() {
		GetHitCountOptions options = new GetHitCountOptions.Builder(getProperty(CORPUS), "C0243026").build();

		ServiceCall<HitCount> sc = imlService.getHitCount(options);
		Response<HitCount> response = sc.execute();
		HitCount hitCount = response.getResult();
		Assert.assertNotNull(hitCount);
		Assert.assertTrue(hitCount.getHitCount() > 0);
	}

	@Test
	public void getConceptHitCountBuilder() {

		Builder builder = new GetHitCountOptions.Builder();
		builder.corpus(getProperty(CORPUS));
		builder.nameOrId("C0243026");
		builder.ontology("umls");
		ServiceCall<HitCount> sc = imlService.getHitCount(builder.build());
		Response<HitCount> response = sc.execute();
		HitCount hitCount = response.getResult();
		Assert.assertNotNull(hitCount);
		Assert.assertTrue(hitCount.getHitCount() > 0);
	}

}
