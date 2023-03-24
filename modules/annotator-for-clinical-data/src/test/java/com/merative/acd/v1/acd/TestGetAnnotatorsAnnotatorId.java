/* ***************************************************************** */
/*                                                                   */
/* (C) Copyright Merative US L.P. and others 2018, 2023              */
/*                                                                   */
/* SPDX-License-Identifier: Apache-2.0                               */
/*                                                                   */
/* ***************************************************************** */

package com.merative.acd.v1.acd;

import org.junit.Assert;
import org.junit.Test;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.merative.acd.v1.AnnotatorForClinicalData;
import com.merative.acd.v1.AcdServiceTest;
import com.merative.acd.v1.common.Constants;
import com.merative.acd.v1.model.GetAnnotatorOptions;
import com.merative.acd.v1.model.GetAnnotatorOptions.Builder;
import com.merative.acd.v1.model.GetAnnotatorsByIdOptions;
import com.merative.acd.v1.model.ServiceApiBean;

public class TestGetAnnotatorsAnnotatorId extends AcdServiceTest {
	private AnnotatorForClinicalData service;

	public TestGetAnnotatorsAnnotatorId() {
		super();
		try {
			service = this.getServiceInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetAnnotator() {
		GetAnnotatorsByIdOptions options = new GetAnnotatorsByIdOptions.Builder().id(Constants.CONCEPT_DETECTION_NAME).build();

		ServiceCall<ServiceApiBean> sc = service.getAnnotatorsById(options);
		Response<ServiceApiBean> response = sc.execute();
		ServiceApiBean annotator = response.getResult();
		if (annotator.getDescription() !=  null) {
			Assert.assertTrue(annotator.getDescription().length() > 0);
		}
	}

	@Test
	public void testGetAnnotatorBuilder() {
		GetAnnotatorsByIdOptions options = new GetAnnotatorsByIdOptions.Builder().id(Constants.CONCEPT_DETECTION_NAME).build();

		ServiceCall<ServiceApiBean> sc = service.getAnnotatorsById(options);
		Response<ServiceApiBean> response = sc.execute();
		ServiceApiBean annotator = response.getResult();
		if (annotator.getDescription() !=  null) {
			Assert.assertTrue(annotator.getDescription().length() > 0);
		}
	}

	@Test
	public void testBuilderFromOptions() {
		GetAnnotatorOptions options = new GetAnnotatorOptions.Builder(Constants.CONCEPT_DETECTION_NAME).build();
		Builder builder = options.newBuilder();
		Assert.assertNotNull(builder);
	}
}
