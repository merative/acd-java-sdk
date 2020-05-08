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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.watson.health.iml.v1.InsightsForMedicalLiteratureService;
import com.ibm.watson.health.iml.v1.common.Constants;
import com.ibm.watson.health.iml.v1.model.AddCorpusDocumentOptions;
import com.ibm.watson.health.iml.v1.model.AddCorpusDocumentOptions.Builder;
import com.ibm.watson.health.iml.v1.utils.ServiceUtilities;

public class TestAddDocumentToCorpus {
	private InsightsForMedicalLiteratureService imlService;

	public TestAddDocumentToCorpus() {
		try {
			imlService = ServiceUtilities.getServiceInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testAddDocumentToCorpus() {
		Map<String, Object> docMap = new HashMap<String, Object>();
		docMap.put("doc_id", "1");
		docMap.put("title", "Study for asthma treatments using anabolic inhaled steroids");
		docMap.put("abstract", "Study for asthma treatments using anabolic inhaled steroidsd");
		docMap.put("text", "The study determined asthma can be effectively treated using inhaled anabloioc steroidsd in conjection with emergency inhalers like albuterol");
		docMap.put("publicationName", "Journal of Asthma");
		Map<String, String> refData = new HashMap<String, String>();
		refData.put("articleId", "1234");
		refData.put("articleTitle", "Asthma and inhalers");
		docMap.put("references", refData);

		AddCorpusDocumentOptions docOptions = new AddCorpusDocumentOptions.Builder().acdUrl("https://us-south.wh-acd.cloud.ibm.com/wh-acd/api").apiKey("10zamyYX_Hm4dYJyWhw1o1XOt9tSJzQfNmoSzeEt0oNR")
				.flowId("iml_general_medical_literature_v9.0_iml_general_medical_literature_flow_flow").corpus(ServiceUtilities.getProperty(Constants.CUSTOM_CORPUS)).document(docMap).build();
		ServiceCall<Void> sc = imlService.addCorpusDocument(docOptions);

		try {
		Response<Void> response = sc.execute();
		} catch (Exception mie) {
			Assert.assertNotNull(mie.getMessage());
		}
	}

	@Test
	public void testAddDocumentToCorpusOtherAnnotators() {
		String annotatorUrl = "third.partty.annotator";
		List<String> otherAnnotators = new ArrayList<String>(1);
		otherAnnotators.add(annotatorUrl);

		AddCorpusDocumentOptions docOptions = new AddCorpusDocumentOptions.Builder().acdUrl(ServiceUtilities.getProperty(Constants.ACD_URL)).apiKey(Constants.ACD_APIKEY)
				.flowId("iml_general_medical_literature_v9.0_iml_general_medical_literature_flow_flow").corpus(ServiceUtilities.getProperty(Constants.CUSTOM_CORPUS)).build();
		ServiceCall<Void> sc = imlService.addCorpusDocument(docOptions);

	}

	@Test
	public void testBuilderFromOptions() {
		AddCorpusDocumentOptions docOptions = new AddCorpusDocumentOptions.Builder().acdUrl("https://us-south.wh-acd.cloud.ibm.com/wh-acd/api").apiKey("10zamyYX_Hm4dYJyWhw1o1XOt9tSJzQfNmoSzeEt0oNR")
				.flowId("iml_general_medical_literature_v9.0_iml_general_medical_literature_flow_flow").corpus("custom_test1").build();

		Builder builder = docOptions.newBuilder();
		Assert.assertNotNull(builder);
	}
}
