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
import com.ibm.watson.health.iml.v1.model.CorporaConfigModel;
import com.ibm.watson.health.iml.v1.model.Corpus;
import com.ibm.watson.health.iml.v1.model.GetCorporaConfigOptions;
import com.ibm.watson.health.iml.v1.model.GetCorporaConfigOptions.Builder;

/**
 * Class for testing /v1/corpora api.
 *
 */
public class TestGetCorpora extends WatsonServiceTest {
	private InsightsForMedicalLiteratureService imlService;

	public TestGetCorpora() {
		super();
		try {
			this.setUp();
			imlService = this.getServiceInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	// retrieves the instance configuration
	public void testGetCorporaConfig() {

		ServiceCall<CorporaConfigModel> sc = imlService.getCorporaConfig();

		try {
			Response<CorporaConfigModel> response = sc.execute();
			CorporaConfigModel ccm = response.getResult();
			List<Corpus> corpusList = ccm.getCorpora();
			for (Corpus corpusConfig : corpusList) {
				Assert.assertNotNull(corpusConfig.getCorpusName());
				List<String> corpusOntologies = corpusConfig.getOntologies();
				for (String ontology : corpusOntologies) {
					Assert.assertNotNull(ontology);
				}
			}
		} catch (RuntimeException re) {
			// throw
		}
	}

	@Test
	// retrieves the instance configuration - verbose data
	public void testGetCorporaConfigVerbose() {
		GetCorporaConfigOptions options = new GetCorporaConfigOptions.Builder().verbose(true).build();
		ServiceCall<CorporaConfigModel> sc = imlService.getCorporaConfig(options);

		try {
			Response<CorporaConfigModel> response = sc.execute();
			CorporaConfigModel ccm = response.getResult();
			List<Corpus> corpusList = ccm.getCorpora();
			for (Corpus corpusConfig : corpusList) {
				Assert.assertNotNull(corpusConfig.getCorpusName());
				List<String> corpusOntologies = corpusConfig.getOntologies();
				for (String ontology : corpusOntologies) {
					Assert.assertNotNull(ontology);
				}
			}
		} catch (RuntimeException re) {
			// throw
		}
	}

	@Test
	public void testGetBuilderFromOptions() {
		GetCorporaConfigOptions options = new GetCorporaConfigOptions.Builder().verbose(true).build();
		Builder builder = options.newBuilder();
		Assert.assertNotNull(builder);
	}
}
