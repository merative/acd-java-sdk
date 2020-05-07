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
package com.ibm.watson.health.iml.v1.corpora;
import static com.ibm.watson.health.iml.v1.utils.ServiceUtilities.getProperty;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.watson.health.iml.v1.InsightsForMedicalLiteratureService;
import com.ibm.watson.health.iml.v1.common.Constants;
import com.ibm.watson.health.iml.v1.model.CorporaConfig;
import com.ibm.watson.health.iml.v1.model.CorpusModel;
import com.ibm.watson.health.iml.v1.model.GetCorpusConfigOptions;
import com.ibm.watson.health.iml.v1.model.GetCorpusConfigOptions.Builder;
import com.ibm.watson.health.iml.v1.utils.ServiceUtilities;

/**
 * Class for testing /v1/corpora/{corpus} api.
 *
 */
public class TestGetCorpusInfo {
	private InsightsForMedicalLiteratureService imlService;

	public TestGetCorpusInfo() {
		try {
			imlService = ServiceUtilities.getServiceInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetCorpusInfo() {
		GetCorpusConfigOptions ccOptions = new GetCorpusConfigOptions.Builder(getProperty(Constants.CORPUS)).build();

		ServiceCall<CorporaConfig> sc = imlService.getCorpusConfig(ccOptions);

		Response<CorporaConfig> response = sc.execute();
		CorporaConfig ccm = response.getResult();
		List<CorpusModel> corpora = ccm.getCorpora();
		for (CorpusModel corpusConfig : corpora) {
			Assert.assertNotNull(corpusConfig.getCorpusName());
			List<String> corpusOntologies = corpusConfig.getOntologies();
			for (String ontology : corpusOntologies) {
				Assert.assertNotNull(ontology);
			}
		}
	}

	@Test
	public void testGetCorpusInfoVerbose() {
		GetCorpusConfigOptions ccOptions = new GetCorpusConfigOptions.Builder(getProperty(Constants.CORPUS))
				.verbose(true).build();

		ServiceCall<CorporaConfig> sc = imlService.getCorpusConfig(ccOptions);

		Response<CorporaConfig> response = sc.execute();
		CorporaConfig ccm = response.getResult();
		List<CorpusModel> corpora = ccm.getCorpora();
		for (CorpusModel corpusConfig : corpora) {
			Assert.assertNotNull(corpusConfig.getCorpusName());
			List<String> corpusOntologies = corpusConfig.getOntologies();
			for (String ontology : corpusOntologies) {
				Assert.assertNotNull(ontology);
			}
		}
	}

	@Test
	public void testGetCorpusInfoEmptyBuilder() {
		Builder builder = new GetCorpusConfigOptions.Builder();
		builder.corpus(getProperty(Constants.CORPUS));

		ServiceCall<CorporaConfig> sc = imlService.getCorpusConfig(builder.build());

		Response<CorporaConfig> response = sc.execute();
		CorporaConfig ccm = response.getResult();
		List<CorpusModel> corpora = ccm.getCorpora();
		for (CorpusModel corpusConfig : corpora) {
			Assert.assertNotNull(corpusConfig.getCorpusName());
			List<String> corpusOntologies = corpusConfig.getOntologies();
			for (String ontology : corpusOntologies) {
				Assert.assertNotNull(ontology);
			}
		}
	}

	@Test
	public void testGetBuilderFromOptions() {
		GetCorpusConfigOptions ccOptions = new GetCorpusConfigOptions.Builder(getProperty(Constants.CORPUS))
				.verbose(true).build();
		Builder builder = ccOptions.newBuilder();
		Assert.assertNotNull(builder);
	}
}
