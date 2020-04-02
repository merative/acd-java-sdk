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
package com.ibm.watson.health.iml.v1.documents;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.watson.health.iml.v1.InsightsForMedicalLiteratureService;
import com.ibm.watson.health.iml.v1.WatsonServiceTest;
import com.ibm.watson.health.iml.v1.common.Constants;
import com.ibm.watson.health.iml.v1.model.DocumentTextModel;
import com.ibm.watson.health.iml.v1.model.GetDocumentInfoOptions;
import com.ibm.watson.health.iml.v1.model.GetDocumentInfoOptions.Builder;

/**
 * Class for testing /v1/corpora/{corpus}/documents/{document_id} api.
 *
 */
public class TestGetDocumentsDocumentId extends WatsonServiceTest {
	private InsightsForMedicalLiteratureService imlService;

	public TestGetDocumentsDocumentId() {
		super();
		try {
			this.setUp();
			imlService = this.getServiceInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void getDocumentInfo() {
		GetDocumentInfoOptions options = new GetDocumentInfoOptions.Builder().corpus(getProperty(Constants.CORPUS))
				.fields("publishDate").documentId(Constants.TEST_DOCUMENT_ID).build();

		ServiceCall<DocumentTextModel> sc = imlService.getDocumentInfo(options);
		Response<DocumentTextModel> response = sc.execute();
		DocumentTextModel document = response.getResult();
		Assert.assertNotNull(document);
		Assert.assertNotNull(document.getMetadata());
		Map<String, List<String>> dataMap = document.getMetadata();
		Set<String> dataKeys = dataMap.keySet();
		for (String key : dataKeys) {
			Assert.assertNotNull(key);
			Assert.assertNotNull(dataMap.get(key));
		}
		Assert.assertNotNull(document.getTitle());
		Assert.assertNotNull(document.getSections());
		Map<String, String> sectionMap = document.getSections();
		Set<String> sectionKeys = sectionMap.keySet();
		for (String key : sectionKeys) {
			Assert.assertNotNull(key);
			Assert.assertNotNull(sectionMap.get(key));
		}
	}

	@Test
	public void getDocumentInfoVerboseFalse() {
		GetDocumentInfoOptions options = new GetDocumentInfoOptions.Builder().corpus(getProperty(Constants.CORPUS))
				.documentId(Constants.TEST_DOCUMENT_ID).verbose(false).build();

		ServiceCall<DocumentTextModel> sc = imlService.getDocumentInfo(options);
		Response<DocumentTextModel> response = sc.execute();
		DocumentTextModel document = response.getResult();
		Assert.assertNotNull(document);
		Assert.assertNotNull(document.getMetadata());
		Map<String, List<String>> dataMap = document.getMetadata();
		Set<String> dataKeys = dataMap.keySet();
		for (String key : dataKeys) {
			Assert.assertNotNull(key);
			Assert.assertNotNull(dataMap.get(key));
		}
		Assert.assertNotNull(document.getTitle());
	}

	@Test
	public void getDocumentInfoBuilder() {
		Builder builder  = new GetDocumentInfoOptions.Builder(getProperty(Constants.CORPUS), Constants.TEST_DOCUMENT_ID);

		ServiceCall<DocumentTextModel> sc = imlService.getDocumentInfo(builder.build());
		Response<DocumentTextModel> response = sc.execute();
		DocumentTextModel document = response.getResult();
		Assert.assertNotNull(document);
		Assert.assertNotNull(document.getMetadata());
		Map<String, List<String>> dataMap = document.getMetadata();
		Set<String> dataKeys = dataMap.keySet();
		for (String key : dataKeys) {
			Assert.assertNotNull(key);
			Assert.assertNotNull(dataMap.get(key));
		}
		Assert.assertNotNull(document.getTitle());
	}

	@Test
	public void getBuilderFromOptions() {
		GetDocumentInfoOptions options = new GetDocumentInfoOptions.Builder().corpus(getProperty(Constants.CORPUS))
				.documentId(Constants.TEST_DOCUMENT_ID).verbose(false).build();

		Builder builder = options.newBuilder();
		Assert.assertNotNull(builder);
	}
}
