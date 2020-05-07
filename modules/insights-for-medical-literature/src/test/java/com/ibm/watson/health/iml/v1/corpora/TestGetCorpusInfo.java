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

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.watson.health.iml.v1.InsightsForMedicalLiteratureService;
import com.ibm.watson.health.iml.v1.WatsonServiceTest;
import com.ibm.watson.health.iml.v1.common.Constants;
import com.ibm.watson.health.iml.v1.model.CorporaConfigModel;
import com.ibm.watson.health.iml.v1.model.Corpus;
import com.ibm.watson.health.iml.v1.model.GetCorpusConfigOptions;
import com.ibm.watson.health.iml.v1.model.GetCorpusConfigOptions.Builder;

/**
 * Class for testing /v1/corpora/{corpus} api.
 *
 */
public class TestGetCorpusInfo extends WatsonServiceTest {
	private InsightsForMedicalLiteratureService imlService;

	public TestGetCorpusInfo() {
		super();
		try {
			this.setUp();
			imlService = this.getServiceInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetCorpusInfo() {
		GetCorpusConfigOptions ccOptions = new GetCorpusConfigOptions.Builder(this.getProperty(Constants.CORPUS)).build();

		ServiceCall<CorporaConfigModel> sc = imlService.getCorpusConfig(ccOptions);

		Response<CorporaConfigModel> response = sc.execute();
		CorporaConfigModel ccm = response.getResult();
		List<Corpus> corpora = ccm.getCorpora();
		for (Corpus corpusConfig : corpora) {
			Assert.assertNotNull(corpusConfig.getCorpusName());
			List<String> corpusOntologies = corpusConfig.getOntologies();
			for (String ontology : corpusOntologies) {
				Assert.assertNotNull(ontology);
			}
		}
	}

	@Test
	public void testGetCorpusInfoVerbose() {
		GetCorpusConfigOptions ccOptions = new GetCorpusConfigOptions.Builder(this.getProperty(Constants.CORPUS))
				.verbose(true).build();

		ServiceCall<CorporaConfigModel> sc = imlService.getCorpusConfig(ccOptions);

		Response<CorporaConfigModel> response = sc.execute();
		CorporaConfigModel ccm = response.getResult();
		List<Corpus> corpora = ccm.getCorpora();
		for (Corpus corpusConfig : corpora) {
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

		ServiceCall<CorporaConfigModel> sc = imlService.getCorpusConfig(builder.build());

		Response<CorporaConfigModel> response = sc.execute();
		CorporaConfigModel ccm = response.getResult();
		List<Corpus> corpora = ccm.getCorpora();
		for (Corpus corpusConfig : corpora) {
			Assert.assertNotNull(corpusConfig.getCorpusName());
			List<String> corpusOntologies = corpusConfig.getOntologies();
			for (String ontology : corpusOntologies) {
				Assert.assertNotNull(ontology);
			}
		}
	}

	@Test
	public void testGetBuilderFromOptions() {
		GetCorpusConfigOptions ccOptions = new GetCorpusConfigOptions.Builder(this.getProperty(Constants.CORPUS))
				.verbose(true).build();
		Builder builder = ccOptions.newBuilder();
		Assert.assertNotNull(builder);
	}
}
