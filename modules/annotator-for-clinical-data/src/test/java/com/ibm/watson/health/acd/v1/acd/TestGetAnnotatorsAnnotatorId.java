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
import com.ibm.watson.health.acd.v1.common.Constants;
import com.ibm.watson.health.acd.v1.model.Annotator;
import com.ibm.watson.health.acd.v1.model.GetAnnotatorsByIdOptions;
import com.ibm.watson.health.acd.v1.utils.ServiceUtilities;

public class TestGetAnnotatorsAnnotatorId {
	private AnnotatorForClinicalData service;

	public TestGetAnnotatorsAnnotatorId() {
		try {
			service = ServiceUtilities.getServiceInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetAnnotator() {
		GetAnnotatorsByIdOptions options = new GetAnnotatorsByIdOptions.Builder().id(Constants.CONCEPT_DETECTION_NAME).build();

		ServiceCall<Annotator> sc = service.getAnnotatorsById(options);
		Response<Annotator> response = sc.execute();
		Annotator annotator = response.getResult();
		if (annotator.name() !=  null) {
			Assert.assertTrue(annotator.name().length() > 0);
		}
		Assert.assertNull(annotator.configurations());

	}

	@Test
	public void testGetAnnotatorBuilder() {
		GetAnnotatorsByIdOptions options = new GetAnnotatorsByIdOptions.Builder(Constants.CONCEPT_DETECTION_NAME).build();

		ServiceCall<Annotator> sc = service.getAnnotatorsById(options);
		Response<Annotator> response = sc.execute();
		Annotator annotator = response.getResult();
		if (annotator.name() !=  null) {
			Assert.assertTrue(annotator.name().length() > 0);
		}
		Assert.assertNull(annotator.configurations());

	}
}
