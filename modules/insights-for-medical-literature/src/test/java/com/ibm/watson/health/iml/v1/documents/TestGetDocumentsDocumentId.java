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
import static com.ibm.watson.health.iml.v1.utils.ServiceUtilities.getProperty;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.watson.health.iml.v1.InsightsForMedicalLiteratureService;
import com.ibm.watson.health.iml.v1.common.Constants;
import com.ibm.watson.health.iml.v1.model.DocumentTextModel;
import com.ibm.watson.health.iml.v1.model.GetDocumentInfoOptions;
import com.ibm.watson.health.iml.v1.model.GetDocumentInfoOptions.Builder;
import com.ibm.watson.health.iml.v1.model.GetDocumentInfoResponse;
import com.ibm.watson.health.iml.v1.utils.ServiceUtilities;

/**
 * Class for testing /v1/corpora/{corpus}/documents/{document_id} api.
 *
 */
public class TestGetDocumentsDocumentId {
	private InsightsForMedicalLiteratureService imlService;

	public TestGetDocumentsDocumentId() {
		try {
			imlService = ServiceUtilities.getServiceInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void getDocumentInfo() {
		GetDocumentInfoOptions options = new GetDocumentInfoOptions.Builder().corpus(getProperty(Constants.CORPUS))
				.documentId(Constants.TEST_DOCUMENT_ID).build();

		ServiceCall<GetDocumentInfoResponse> sc = imlService.getDocumentInfo(options);
		Response<GetDocumentInfoResponse> response = sc.execute();
		GetDocumentInfoResponse document = response.getResult();
		Assert.assertNotNull(document);

	}

	@Test
	public void getDocumentInfoVerboseFalse() {
		GetDocumentInfoOptions options = new GetDocumentInfoOptions.Builder().corpus(getProperty(Constants.CORPUS))
				.documentId(Constants.TEST_DOCUMENT_ID).verbose(false).build();

		ServiceCall<GetDocumentInfoResponse> sc = imlService.getDocumentInfo(options);
		Response<GetDocumentInfoResponse> response = sc.execute();
		GetDocumentInfoResponse document = response.getResult();
		Assert.assertNotNull(document);
	}

	@Test
	public void getDocumentInfoBuilder() {
		Builder builder  = new GetDocumentInfoOptions.Builder(getProperty(Constants.CORPUS), Constants.TEST_DOCUMENT_ID);

		ServiceCall<GetDocumentInfoResponse> sc = imlService.getDocumentInfo(builder.build());
		Response<GetDocumentInfoResponse> response = sc.execute();
		GetDocumentInfoResponse document = response.getResult();
		Assert.assertNotNull(document);
	}

	@Test
	public void getBuilderFromOptions() {
		GetDocumentInfoOptions options = new GetDocumentInfoOptions.Builder().corpus(getProperty(Constants.CORPUS))
				.documentId(Constants.TEST_DOCUMENT_ID).verbose(false).build();

		Builder builder = options.newBuilder();
		Assert.assertNotNull(builder);
	}
}
