/*
 * Copyright 2018, 2022 IBM Corp. All Rights Reserved.
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
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.watson.health.acd.v1.AnnotatorForClinicalData;
import com.ibm.watson.health.acd.v1.WatsonServiceTest;
import com.ibm.watson.health.acd.v1.common.Constants;
import com.ibm.watson.health.acd.v1.common.TestContainerGroup;
import com.ibm.watson.health.acd.v1.model.AnalyzeWithFlowOptions;
import com.ibm.watson.health.acd.v1.model.AnalyzeWithFlowOptions.Builder;
import com.ibm.watson.health.acd.v1.model.ContainerGroup;
import com.ibm.watson.health.acd.v1.model.UnstructuredContainer;

/**
 *
 * Class for testing /v1/analyze/(flow_id}.
 *
 */
public class TestAnalyzeFlowId extends WatsonServiceTest {
	private AnnotatorForClinicalData service;

	public TestAnalyzeFlowId() {
		super();
		try {
			service = this.getServiceInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testAnalyzeFlowIdOptionsFlowId() {

		for (int i = 0; i < Constants.SAMPLE_TEXT_ARRAY.length; i++) {
			AnalyzeWithFlowOptions options = new AnalyzeWithFlowOptions.Builder().flowId(Constants.FLOW_ID)
					.contentType(Constants.CONTENT_TYPE).text(Constants.SAMPLE_TEXT_ARRAY[i]).build();

			ServiceCall<ContainerGroup> sc = service.analyzeWithFlow(options);
			ContainerGroup containerGroup = null;
			try {
				Response<ContainerGroup> response = sc.execute();
				containerGroup = response.getResult();
			} catch (ServiceResponseException e) {
				// Base class for all exceptions caused by error responses from the service
				System.out.println("testAnalyzeFlowIdOptionsFlowId: Service returned status code "
						+ e.getStatusCode() + ": " + e.getMessage());
				System.out.println("Detailed error info:\n" + e.getDebuggingInfo().toString());
			}
			Assert.assertNotNull(containerGroup);
			TestContainerGroup.testContainerGroups(containerGroup);
		}
	}

	@Test
	public void testAnalyzeFlowIdOptions() {

		for (int i = 0; i < Constants.SAMPLE_TEXT_ARRAY.length; i++) {
			AnalyzeWithFlowOptions options = new AnalyzeWithFlowOptions.Builder(Constants.FLOW_ID)
					.contentType(Constants.CONTENT_TYPE).text(Constants.SAMPLE_TEXT_ARRAY[i]).build();

			ServiceCall<ContainerGroup> sc = service.analyzeWithFlow(options);
			ContainerGroup containerGroup = null;
			try {
				Response<ContainerGroup> response = sc.execute();
				containerGroup = response.getResult();
			} catch (ServiceResponseException e) {
				// Base class for all exceptions caused by error responses from the service
				System.out.println("testAnalyzeFlowIdOptions: Service returned status code "
						+ e.getStatusCode() + ": " + e.getMessage());
				System.out.println("Detailed error info:\n" + e.getDebuggingInfo().toString());
			}
			Assert.assertNotNull(containerGroup);
			TestContainerGroup.testContainerGroups(containerGroup);
		}
	}

	@Test
	public void testAnalyzeFlowIdNoOptions() {

		for (int i = 0; i < Constants.SAMPLE_TEXT_ARRAY.length; i++) {
			ContainerGroup containerGroup = null;
			try {
				containerGroup = service.analyzeWithFlow(Constants.FLOW_ID, Constants.SAMPLE_TEXT_ARRAY[i]);
			} catch (ServiceResponseException e) {
				// Base class for all exceptions caused by error responses from the service
				System.out.println("testAnalyzeFlowIdNoOptions: Service returned status code "
						+ e.getStatusCode() + ": " + e.getMessage());
				System.out.println("Detailed error info:\n" + e.getDebuggingInfo().toString());
			}
			Assert.assertNotNull(containerGroup);
			TestContainerGroup.testContainerGroups(containerGroup);
		}
	}

	@Test
	public void testAnalyzeFlowIdNoOptionsDetailedResponse() {

		for (int i = 0; i < Constants.SAMPLE_TEXT_ARRAY.length; i++) {
			ContainerGroup containerGroup = null;
			try {
				Response<ContainerGroup> response = service.analyzeWithFlowInclResponseDetails(Constants.FLOW_ID, Constants.SAMPLE_TEXT_ARRAY[i]);
				containerGroup = response.getResult();
			} catch (ServiceResponseException e) {
				// Base class for all exceptions caused by error responses from the service
				System.out.println("testAnalyzeFlowIdNoOptionsDetailedResponse: Service returned status code "
						+ e.getStatusCode() + ": " + e.getMessage());
				System.out.println("Detailed error info:\n" + e.getDebuggingInfo().toString());
			}
			Assert.assertNotNull(containerGroup);
			TestContainerGroup.testContainerGroups(containerGroup);
		}
	}

	@Test
	public void testAnalyzeFlowIdNoOptionsReturnText() {

		for (int i = 0; i < Constants.SAMPLE_TEXT_ARRAY.length; i++) {
			ContainerGroup containerGroup = null;
			try {
				containerGroup = service.analyzeWithFlow(Constants.FLOW_ID, Constants.SAMPLE_TEXT_ARRAY[i], true);
			} catch (ServiceResponseException e) {
				// Base class for all exceptions caused by error responses from the service
				System.out.println("testAnalyzeFlowIdNoOptionsReturnText: Service returned status code "
						+ e.getStatusCode() + ": " + e.getMessage());
				System.out.println("Detailed error info:\n" + e.getDebuggingInfo().toString());
			}
			Assert.assertNotNull(containerGroup);
			TestContainerGroup.testContainerGroups(containerGroup);
		}
	}

	@Test
	public void testAnalyzeFlowIdNoOptionsReturnTextDetailedResponse() {

		for (int i = 0; i < Constants.SAMPLE_TEXT_ARRAY.length; i++) {
			ContainerGroup containerGroup = null;
			try {
				Response<ContainerGroup> response = service.analyzeWithFlowInclResponseDetails(Constants.FLOW_ID, Constants.SAMPLE_TEXT_ARRAY[i], true);
				containerGroup = response.getResult();
			} catch (ServiceResponseException e) {
				// Base class for all exceptions caused by error responses from the service
				System.out.println("testAnalyzeFlowIdNoOptionsReturnTextDetailedResponse: Service returned status code "
						+ e.getStatusCode() + ": " + e.getMessage());
				System.out.println("Detailed error info:\n" + e.getDebuggingInfo().toString());
			}
			Assert.assertNotNull(containerGroup);
			TestContainerGroup.testContainerGroups(containerGroup);
		}
	}

	@Test
	public void testAnalyzeFlowIdUnstructuredContainer() {

		for (int i = 0; i < Constants.SAMPLE_TEXT_ARRAY.length; i++) {
			UnstructuredContainer unstructured = new UnstructuredContainer.Builder().text(Constants.SAMPLE_TEXT_ARRAY[i]).build();
			ContainerGroup containerGroup = null;
			try {
				containerGroup = service.analyzeWithFlow(Constants.FLOW_ID, unstructured);
			} catch (ServiceResponseException e) {
				// Base class for all exceptions caused by error responses from the service
				System.out.println("testAnalyzeFlowIdUnstructuredContainer: Service returned status code "
						+ e.getStatusCode() + ": " + e.getMessage());
				System.out.println("Detailed error info:\n" + e.getDebuggingInfo().toString());
			}
			Assert.assertNotNull(containerGroup);
			TestContainerGroup.testContainerGroups(containerGroup);
		}
	}

	@Test
	public void testAnalyzeFlowIdUnstructuredContainerDetailedReponse() {

		for (int i = 0; i < Constants.SAMPLE_TEXT_ARRAY.length; i++) {
			UnstructuredContainer unstructured = new UnstructuredContainer.Builder().text(Constants.SAMPLE_TEXT_ARRAY[i]).build();
			ContainerGroup containerGroup = null;
			try {
				Response<ContainerGroup> response = service.analyzeWithFlowInclResponseDetails(Constants.FLOW_ID, unstructured);
				containerGroup = response.getResult();
			} catch (ServiceResponseException e) {
				// Base class for all exceptions caused by error responses from the service
				System.out.println("testAnalyzeFlowIdUnstructuredContainerDetailedReponse: Service returned status code "
						+ e.getStatusCode() + ": " + e.getMessage());
				System.out.println("Detailed error info:\n" + e.getDebuggingInfo().toString());
			}
			Assert.assertNotNull(containerGroup);
			TestContainerGroup.testContainerGroups(containerGroup);
		}
	}

	@Test
	public void testAnalyzeFlowIdUnstructuredContainerReturnText() {

		for (int i = 0; i < Constants.SAMPLE_TEXT_ARRAY.length; i++) {
			UnstructuredContainer unstructured = new UnstructuredContainer.Builder().text(Constants.SAMPLE_TEXT_ARRAY[i]).build();
			ContainerGroup containerGroup = null;
			try {
				containerGroup = service.analyzeWithFlow(Constants.FLOW_ID, unstructured, true);
			} catch (ServiceResponseException e) {
				// Base class for all exceptions caused by error responses from the service
				System.out.println("testAnalyzeFlowIdUnstructuredContainerReturnText: Service returned status code "
						+ e.getStatusCode() + ": " + e.getMessage());
				System.out.println("Detailed error info:\n" + e.getDebuggingInfo().toString());
			}
			Assert.assertNotNull(containerGroup);
			TestContainerGroup.testContainerGroups(containerGroup);
		}
	}

	@Test
	public void testAnalyzeFlowIdUnstructuredContainerReturnTextDetailedResponse() {

		for (int i = 0; i < Constants.SAMPLE_TEXT_ARRAY.length; i++) {
			UnstructuredContainer unstructured = new UnstructuredContainer.Builder().text(Constants.SAMPLE_TEXT_ARRAY[i]).build();
			ContainerGroup containerGroup = null;
			try {
				Response<ContainerGroup> response  = service.analyzeWithFlowInclResponseDetails(Constants.FLOW_ID, unstructured, true);
				containerGroup = response.getResult();
			} catch (ServiceResponseException e) {
				// Base class for all exceptions caused by error responses from the service
				System.out.println("testAnalyzeFlowIdUnstructuredContainerReturnTextDetailedResponse: Service returned status code "
						+ e.getStatusCode() + ": " + e.getMessage());
				System.out.println("Detailed error info:\n" + e.getDebuggingInfo().toString());
			}
			Assert.assertNotNull(containerGroup);
			TestContainerGroup.testContainerGroups(containerGroup);
		}
	}
	
	@Test
	public void testAnalyzeFlowIdUnstructuredContainerDebug() {

		for (int i = 0; i < Constants.SAMPLE_TEXT_ARRAY.length; i++) {
			UnstructuredContainer unstructured = new UnstructuredContainer.Builder().text(Constants.SAMPLE_TEXT_ARRAY[i]).build();
			ContainerGroup containerGroup = null;
			try {
				Response<ContainerGroup> response  = service.analyzeWithFlowDebug(Constants.FLOW_ID, unstructured, false, true);
				containerGroup = response.getResult();
			} catch (ServiceResponseException e) {
				// Base class for all exceptions caused by error responses from the service
				System.out.println("testAnalyzeFlowIdUnstructuredContainerDebug: Service returned status code "
						+ e.getStatusCode() + ": " + e.getMessage());
				System.out.println("Detailed error info:\n" + e.getDebuggingInfo().toString());
			}
			Assert.assertNotNull(containerGroup);
			TestContainerGroup.testContainerGroups(containerGroup);
		}
	}
	
	@Test
	public void testAnalyzeFlowIdDebug() {

		for (int i = 0; i < Constants.SAMPLE_TEXT_ARRAY.length; i++) {
			ContainerGroup containerGroup = null;
			try {
				containerGroup = service.analyzeWithFlowDebug(Constants.FLOW_ID, Constants.SAMPLE_TEXT_ARRAY[i], false, true);
			} catch (ServiceResponseException e) {
				// Base class for all exceptions caused by error responses from the service
				System.out.println("testAnalyzeFlowIdDebug: Service returned status code "
						+ e.getStatusCode() + ": " + e.getMessage());
				System.out.println("Detailed error info:\n" + e.getDebuggingInfo().toString());
			}
			Assert.assertNotNull(containerGroup);
			TestContainerGroup.testContainerGroups(containerGroup);
		}
	}

	@Test
	public void testGetBuilderFromOptions() {
		AnalyzeWithFlowOptions options = new AnalyzeWithFlowOptions.Builder().flowId(Constants.FLOW_ID)
				.contentType(Constants.CONTENT_TYPE).text(Constants.TEXT).build();
		Builder builder = options.newBuilder();
		Assert.assertNotNull(builder);
	}
}
