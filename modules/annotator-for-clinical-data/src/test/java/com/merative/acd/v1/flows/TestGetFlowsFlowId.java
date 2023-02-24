/* ***************************************************************** */
/*                                                                   */
/* (C) Copyright Merative US L.P. and others 2018, 2023              */
/*                                                                   */
/* SPDX-License-Identifier: Apache-2.0                               */
/*                                                                   */
/* ***************************************************************** */

package com.merative.acd.v1.flows;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.merative.acd.v1.AnnotatorForClinicalData;
import com.merative.acd.v1.AcdServiceTest;
import com.merative.acd.v1.common.Constants;
import com.merative.acd.v1.model.AcdFlow;
import com.merative.acd.v1.model.AnnotatorFlow;
import com.merative.acd.v1.model.Flow;
import com.merative.acd.v1.model.FlowEntry;
import com.merative.acd.v1.model.GetFlowsByIdOptions;
import com.merative.acd.v1.model.GetFlowsByIdOptions.Builder;

/**
 *
 * Class for testing GET /v1/flows/{id}.
 *
 */
public class TestGetFlowsFlowId extends AcdServiceTest {
	private AnnotatorForClinicalData service;

	public TestGetFlowsFlowId() {
		super();
		try {
			service = this.getServiceInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetFlowsById() {
		GetFlowsByIdOptions options = new GetFlowsByIdOptions.Builder().id(Constants.FLOW_ID).build();

		Response<AcdFlow> response = null;
		try {
			ServiceCall<AcdFlow> sc = service.getFlowsById(options);
			response = sc.execute();
		} catch (ServiceResponseException e) {
			// Base class for all exceptions caused by error responses from the service
			System.out.println("testGetFlowsById: Service returned status code "
					+ e.getStatusCode() + ": " + e.getMessage());
			System.out.println("Detailed error info:\n" + e.getDebuggingInfo().toString());
		}
		if (response != null) {
			AcdFlow flow = response.getResult();
			Assert.assertNotNull(flow);
			Assert.assertEquals(flow.id(), Constants.FLOW_ID);
			Assert.assertNotNull(flow.name());
			String desc = flow.description();
			if (desc != null) {
				Assert.assertTrue(desc.length() > 0);
			}
			List<AnnotatorFlow> flowList = flow.annotatorFlows();
			if (flowList != null && !flowList.isEmpty()) {
				for (AnnotatorFlow annoFlow : flowList) {
					Flow flowForAnnotator = annoFlow.flow();
					List<FlowEntry> flowEntries = flowForAnnotator.elements();
					if (flowEntries != null && !flowEntries.isEmpty()) {
						for (FlowEntry entry : flowEntries) {
							Assert.assertNotNull(entry);
						}
					}
				}
			}
		}
	}

	@Test
	public void testGetFlowsByIdBuilder() {
		Builder builder = new GetFlowsByIdOptions.Builder(Constants.FLOW_ID);

		Response<AcdFlow> response = null;
		try {
			ServiceCall<AcdFlow> sc = service.getFlowsById(builder.build());
			response = sc.execute();
		} catch (ServiceResponseException e) {
			// Base class for all exceptions caused by error responses from the service
			System.out.println("testGetFlowsByIdBuilder: Service returned status code "
					+ e.getStatusCode() + ": " + e.getMessage());
			System.out.println("Detailed error info:\n" + e.getDebuggingInfo().toString());
		}
		if (response != null) {
			AcdFlow flow = response.getResult();
			Assert.assertNotNull(flow);
			Assert.assertNotNull(flow.id());
			Assert.assertNotNull(flow.name());
			String desc = flow.description();
			if (desc != null) {
				Assert.assertTrue(desc.length() > 0);
			}
			List<AnnotatorFlow> flowList = flow.annotatorFlows();
			if (flowList != null && !flowList.isEmpty()) {
				for (AnnotatorFlow annoFlow : flowList) {
					Flow flowForAnnotator = annoFlow.flow();
					List<FlowEntry> flowEntries = flowForAnnotator.elements();
					if (flowEntries != null && !flowEntries.isEmpty()) {
						for (FlowEntry entry : flowEntries) {
							Assert.assertNotNull(entry);
						}
					}
				}
			}
		}
	}

	@Test
	public void testGetBuilderFromOptions() {
		GetFlowsByIdOptions options = new GetFlowsByIdOptions.Builder().id(Constants.FLOW_ID).build();

		Builder builder = options.newBuilder();
		Assert.assertNotNull(builder);
	}
}
