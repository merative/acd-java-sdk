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
import java.util.Map;
import java.util.Set;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.merative.acd.v1.AnnotatorForClinicalData;
import com.merative.acd.v1.AcdServiceTest;
import com.merative.acd.v1.model.GetAnnotatorsOptions;
import com.merative.acd.v1.model.ListAnnotatorsOptions;
import com.merative.acd.v1.model.ListAnnotatorsOptions.Builder;
import com.merative.acd.v1.model.ServiceApiBean;

/**
 *
 * Class for testing /v1/annotators.
 *
 */
public class TestGetAnnotators extends AcdServiceTest {
	private AnnotatorForClinicalData service;

	public TestGetAnnotators() {
		super();
		try {
			service = this.getServiceInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetAnnotators() {
		Response<Map<String, ServiceApiBean>> response = null;
		try {
			ServiceCall<Map<String, ServiceApiBean>> sc = service.getAnnotators();
			response = sc.execute();
		} catch (ServiceResponseException e) {
			// Base class for all exceptions caused by error responses from the service
			System.out.println("testGetAnnotators: Service returned status code "
					+ e.getStatusCode() + ": " + e.getMessage());
			System.out.println("Detailed error info:\n" + e.getDebuggingInfo().toString());
		}
		if (response != null) {
			Assert.assertNotNull(response.getResult());
			Map<String, ServiceApiBean> annoMap = response.getResult();
			Set<String> keys = annoMap.keySet();
			for (String key: keys) {
				Assert.assertNotNull(annoMap.get(key));
			}

		}		
	}

	@Test
	public void testGetAnnotatorsOptions() {
		GetAnnotatorsOptions options = new GetAnnotatorsOptions();
		Response<Map<String, ServiceApiBean>> response = null;
		
		try {
		ServiceCall<Map<String, ServiceApiBean>> sc = service.getAnnotators(options);
		response = sc.execute();
		} catch (ServiceResponseException e) {
			// Base class for all exceptions caused by error responses from the service
			System.out.println("testGetAnnotatorsOptions: Service returned status code "
					+ e.getStatusCode() + ": " + e.getMessage());
			System.out.println("Detailed error info:\n" + e.getDebuggingInfo().toString());
		}
		if (response != null) {
			Assert.assertNotNull(response.getResult());
			Map<String, ServiceApiBean> annotatorMap = response.getResult();
			Set<String> keys = annotatorMap.keySet();
			for (String key : keys) {
				Assert.assertNotNull(annotatorMap.get(key));
			}
		}
	}

	@Test
	public void testGetBuilderFromOptions() {
		ListAnnotatorsOptions options = new ListAnnotatorsOptions.Builder().build();
		Builder builder = options.newBuilder();
		Assert.assertNotNull(builder);
	}
}
