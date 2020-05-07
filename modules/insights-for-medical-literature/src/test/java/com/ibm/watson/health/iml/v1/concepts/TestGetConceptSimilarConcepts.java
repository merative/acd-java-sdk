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
package com.ibm.watson.health.iml.v1.concepts;
import static com.ibm.watson.health.iml.v1.utils.ServiceUtilities.getProperty;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.watson.health.iml.v1.InsightsForMedicalLiteratureService;
import com.ibm.watson.health.iml.v1.common.Constants;
import com.ibm.watson.health.iml.v1.model.ArtifactModel;
import com.ibm.watson.health.iml.v1.model.ConceptListModel;
import com.ibm.watson.health.iml.v1.model.ConceptModel;
import com.ibm.watson.health.iml.v1.model.GetSimilarConceptsOptions;
import com.ibm.watson.health.iml.v1.model.GetSimilarConceptsOptions.Builder;
import com.ibm.watson.health.iml.v1.utils.ServiceUtilities;

/**
 * Class for testing /v1/corpora/{corpus}/concepts/{name_of_id}/similar_concepts api.
 *
 */
public class TestGetConceptSimilarConcepts {
	private InsightsForMedicalLiteratureService imlService;

	public TestGetConceptSimilarConcepts() {
		try {
			imlService = ServiceUtilities.getServiceInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetSimilarConcepts() {
		GetSimilarConceptsOptions options = new GetSimilarConceptsOptions.Builder()
				.corpus(getProperty(Constants.CORPUS)).nameOrId("heart").addReturnOntologies("mesh").build();

		ServiceCall<ConceptListModel> sc = imlService.getSimilarConcepts(options);
		Response<ConceptListModel> response = sc.execute();
		ConceptListModel clm = response.getResult();
		List<ArtifactModel> concepts = clm.getConcepts();
		for (ArtifactModel concept : concepts) {
			Assert.assertNotNull(concept.getCui());
			Assert.assertEquals(concept.getOntology(), "mesh");
			Assert.assertNotNull(concept.getPreferredName());
		}
	}

	@Test
	public void testGetSimilarConceptsSourceOtology() {
		GetSimilarConceptsOptions options = new GetSimilarConceptsOptions.Builder()
				.corpus(getProperty(Constants.CORPUS)).nameOrId("heart").addReturnOntologies("mesh")
				.ontology("umls").build();

		ServiceCall<ConceptListModel> sc = imlService.getSimilarConcepts(options);
		Response<ConceptListModel> response = sc.execute();
		ConceptListModel clm = response.getResult();
		List<ArtifactModel> concepts = clm.getConcepts();
		for (ArtifactModel concept : concepts) {
			Assert.assertNotNull(concept.getCui());
			Assert.assertEquals(concept.getOntology(), "mesh");
			Assert.assertNotNull(concept.getPreferredName());
		}
	}

	@Test
	public void testGetSimilarConceptsSourceResultLimit() {
		GetSimilarConceptsOptions options = new GetSimilarConceptsOptions.Builder()
				.corpus(getProperty(Constants.CORPUS)).nameOrId("heart").addReturnOntologies("mesh")
				.ontology("umls").limit(5).build();

		ServiceCall<ConceptListModel> sc = imlService.getSimilarConcepts(options);
		Response<ConceptListModel> response = sc.execute();
		ConceptListModel clm = response.getResult();
		List<ArtifactModel> concepts = clm.getConcepts();
		for (ArtifactModel concept : concepts) {
			Assert.assertNotNull(concept.getCui());
			Assert.assertEquals(concept.getOntology(), "mesh");
			Assert.assertNotNull(concept.getPreferredName());
		}
	}

	@Test
	public void testGetSimilarConceptsMultipleOtologies() {
		List<String> returnOntologies = new ArrayList<String>(2);
		returnOntologies.add("mesh");
		returnOntologies.add("umls");
		GetSimilarConceptsOptions options = new GetSimilarConceptsOptions.Builder()
				.corpus(getProperty(Constants.CORPUS)).nameOrId("heart").returnOntologies(returnOntologies)
				.ontology("umls").build();

		ServiceCall<ConceptListModel> sc = imlService.getSimilarConcepts(options);
		Response<ConceptListModel> response = sc.execute();
		ConceptListModel clm = response.getResult();
		List<ArtifactModel> concepts = clm.getConcepts();
		for (ArtifactModel concept : concepts) {
			Assert.assertNotNull(concept.getCui());
			Assert.assertNotNull(concept.getOntology());
			Assert.assertNotNull(concept.getPreferredName());
		}
	}

	@Test
	public void testGetSimilarConceptsSourceBuilder() {
		List<String> returnOntologies = new ArrayList<String>(2);
		returnOntologies.add("mesh");
		Builder builder = new GetSimilarConceptsOptions
				.Builder(getProperty(Constants.CORPUS), "heart", returnOntologies);

		ServiceCall<ConceptListModel> sc = imlService.getSimilarConcepts(builder.build());
		Response<ConceptListModel> response = sc.execute();
		ConceptListModel clm = response.getResult();
		List<ArtifactModel> concepts = clm.getConcepts();
		for (ArtifactModel concept : concepts) {
			Assert.assertNotNull(concept.getCui());
			Assert.assertEquals(concept.getOntology(), "mesh");
			Assert.assertNotNull(concept.getPreferredName());
		}
	}

	@Test
	public void testGetBuilderFromOptions() {
		List<String> returnOntologies = new ArrayList<String>(2);
		returnOntologies.add("mesh");
		returnOntologies.add("umls");
		GetSimilarConceptsOptions options = new GetSimilarConceptsOptions
				.Builder(getProperty(Constants.CORPUS), "heart", returnOntologies).build();

		Builder builder = options.newBuilder();
		Assert.assertNotNull(builder);
	}
}
