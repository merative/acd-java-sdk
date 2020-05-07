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

import org.junit.Assert;
import org.junit.Test;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.watson.health.iml.v1.InsightsForMedicalLiteratureService;
import com.ibm.watson.health.iml.v1.common.Constants;
import com.ibm.watson.health.iml.v1.model.CorpusInfoModel;
import com.ibm.watson.health.iml.v1.model.CorpusProvider;
import com.ibm.watson.health.iml.v1.model.GetDocumentsOptions;
import com.ibm.watson.health.iml.v1.model.GetDocumentsOptions.Builder;
import com.ibm.watson.health.iml.v1.utils.ServiceUtilities;

/**
 * Class for testing /v1/corpora/{corpus}/documents api.
 *
 */
public class TestGetDocuments {
	private InsightsForMedicalLiteratureService imlService;

	public TestGetDocuments() {
		try {
			imlService = ServiceUtilities.getServiceInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void getDocuments() {
		GetDocumentsOptions options = new GetDocumentsOptions.Builder().corpus(ServiceUtilities.getProperty(Constants.CORPUS)).build();

		ServiceCall<CorpusInfoModel> sc = imlService.getDocuments(options);
		Response<CorpusInfoModel> response = sc.execute();
		CorpusInfoModel corpusInfo = response.getResult();
		Assert.assertTrue(corpusInfo.getDocumentCount() > 0);
		Assert.assertNotNull(corpusInfo.getProviders());
		List<CorpusProvider> providers = corpusInfo.getProviders();
		for (CorpusProvider provider : providers) {
			Assert.assertNotNull(provider.getName());
			Assert.assertTrue(provider.getDocumentCount() > 0);
		}
	}

	@Test
	public void getDocumentsBuilder() {
		Builder builder = new GetDocumentsOptions.Builder(ServiceUtilities.getProperty(Constants.CORPUS));

		ServiceCall<CorpusInfoModel> sc = imlService.getDocuments(builder.build());
		Response<CorpusInfoModel> response = sc.execute();
		CorpusInfoModel corpusInfo = response.getResult();
		Assert.assertTrue(corpusInfo.getDocumentCount() > 0);
		Assert.assertNotNull(corpusInfo.getProviders());
		List<CorpusProvider> providers = corpusInfo.getProviders();
		for (CorpusProvider provider : providers) {
			Assert.assertNotNull(provider.getName());
			Assert.assertTrue(provider.getDocumentCount() > 0);
		}
	}

	@Test
	public void getBuilderFromOptions() {
		GetDocumentsOptions options = new GetDocumentsOptions.Builder().corpus(Constants.CORPUS).build();
		Builder builder = options.newBuilder();
		Assert.assertNotNull(builder);
	}
}
