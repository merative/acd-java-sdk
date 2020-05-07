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
			this.setUp();
			service = this.getServiceInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testAnalyze() {
		AnalyzeWithFlowOptions options = new AnalyzeWithFlowOptions.Builder().flowId(Constants.FLOW_ID)
				.contentType(Constants.CONTENT_TYPE).text(Constants.TEXT).build();

		ServiceCall<ContainerGroup> sc = service.analyzeWithFlow(options);
		Response<ContainerGroup> response = sc.execute();
		ContainerGroup containerGroup = response.getResult();
		Assert.assertNotNull(containerGroup);
		TestContainerGroup.testContainerGroups(containerGroup);
	}

	@Test
	public void testAnalyzeFlowId() {
		AnalyzeWithFlowOptions options = new AnalyzeWithFlowOptions.Builder(Constants.FLOW_ID)
				.contentType(Constants.CONTENT_TYPE).text(Constants.TEXT).build();

		ServiceCall<ContainerGroup> sc = service.analyzeWithFlow(options);
		Response<ContainerGroup> response = sc.execute();
		ContainerGroup containerGroup = response.getResult();
		Assert.assertNotNull(containerGroup);
		TestContainerGroup.testContainerGroups(containerGroup);
	}

	@Test
	public void testAnalyzeFlowIdNoOptions() {

		ContainerGroup containerGroup = service.analyzeWithFlow(Constants.FLOW_ID, Constants.TEXT);
		Assert.assertNotNull(containerGroup);
		TestContainerGroup.testContainerGroups(containerGroup);
	}

	@Test
	public void testAnalyzeFlowIdNoOptionsDetailedResponse() {

		Response<ContainerGroup> response = service.analyzeWithFlowInclResponseDetails(Constants.FLOW_ID, Constants.TEXT);
		ContainerGroup containerGroup = response.getResult();
		Assert.assertNotNull(containerGroup);
		TestContainerGroup.testContainerGroups(containerGroup);
	}

	@Test
	public void testAnalyzeFlowIdNoOptionsReturnText() {

		ContainerGroup containerGroup = service.analyzeWithFlow(Constants.FLOW_ID, Constants.TEXT, true);
		Assert.assertNotNull(containerGroup);
		TestContainerGroup.testContainerGroups(containerGroup);
	}

	@Test
	public void testAnalyzeFlowIdNoOptionsReturnTextDetailedResponse() {

		Response<ContainerGroup> response = service.analyzeWithFlowInclResponseDetails(Constants.FLOW_ID, Constants.TEXT, true);
		ContainerGroup containerGroup = response.getResult();
		Assert.assertNotNull(containerGroup);
		TestContainerGroup.testContainerGroups(containerGroup);
	}

	@Test
	public void testAnalyzeFlowIdUnstructuredContainer() {
		UnstructuredContainer unstructured = new UnstructuredContainer.Builder().text(Constants.TEXT).build();
		ContainerGroup containerGroup = service.analyzeWithFlow(Constants.FLOW_ID, unstructured);
		TestContainerGroup.testContainerGroups(containerGroup);
	}

	@Test
	public void testAnalyzeFlowIdUnstructuredContainerDetailedReponse() {
		UnstructuredContainer unstructured = new UnstructuredContainer.Builder().text(Constants.TEXT).build();
		Response<ContainerGroup> response = service.analyzeWithFlowInclResponseDetails(Constants.FLOW_ID, unstructured);
		ContainerGroup containerGroup = response.getResult();
		TestContainerGroup.testContainerGroups(containerGroup);
	}

	@Test
	public void testAnalyzeFlowIdUnstructuredContainerReturnText() {
		UnstructuredContainer unstructured = new UnstructuredContainer.Builder().text(Constants.TEXT).build();
		ContainerGroup containerGroup = service.analyzeWithFlow(Constants.FLOW_ID, unstructured, true);
		Assert.assertNotNull(containerGroup);
		TestContainerGroup.testContainerGroups(containerGroup);
	}

	@Test
	public void testAnalyzeFlowIdUnstructuredContainerReturnTextDetailedResponse() {
		UnstructuredContainer unstructured = new UnstructuredContainer.Builder().text(Constants.TEXT).build();
		Response<ContainerGroup> response  = service.analyzeWithFlowInclResponseDetails(Constants.FLOW_ID, unstructured, true);
		ContainerGroup containerGroup = response.getResult();
		Assert.assertNotNull(containerGroup);
		TestContainerGroup.testContainerGroups(containerGroup);
	}

	@Test
	public void testGetBuilderFromOptions() {
		AnalyzeWithFlowOptions options = new AnalyzeWithFlowOptions.Builder().flowId(Constants.FLOW_ID)
				.contentType(Constants.CONTENT_TYPE).text(Constants.TEXT).build();
		Builder builder = options.newBuilder();
		Assert.assertNotNull(builder);
	}
}
