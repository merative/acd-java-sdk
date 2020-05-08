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
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.watson.health.iml.v1.InsightsForMedicalLiteratureService;
import com.ibm.watson.health.iml.v1.model.GetRelatedConceptsOptions;
import com.ibm.watson.health.iml.v1.model.GetRelatedConceptsOptions.Builder;
import com.ibm.watson.health.iml.v1.model.RelatedConceptModel;
import com.ibm.watson.health.iml.v1.model.RelatedConceptsModel;
import com.ibm.watson.health.iml.v1.utils.ServiceUtilities;

public class TestGetConceptRelatedConcepts {

	static final String CORPUS = "CORPUS";
	private InsightsForMedicalLiteratureService imlService;

	public TestGetConceptRelatedConcepts() {
		try {
			imlService = ServiceUtilities.getServiceInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void getRelatedConcepts() {
		GetRelatedConceptsOptions options = new GetRelatedConceptsOptions.Builder().corpus(getProperty(CORPUS))
				.nameOrId("C0243026").relationship("children").maxDepth(2).build();

		ServiceCall<RelatedConceptsModel> sc = imlService.getRelatedConcepts(options);
		Response<RelatedConceptsModel> response = sc.execute();
		RelatedConceptsModel relatedConcepts = response.getResult();
		Assert.assertNotNull(relatedConcepts);
	}

	@Test
	public void getRelatedConceptsOntology() {
		GetRelatedConceptsOptions options = new GetRelatedConceptsOptions.Builder().corpus(getProperty(CORPUS))
				.nameOrId("C0243026").relationship("children").ontology("umls").build();

		ServiceCall<RelatedConceptsModel> sc = imlService.getRelatedConcepts(options);
		Response<RelatedConceptsModel> response = sc.execute();
		RelatedConceptsModel relatedConcepts = response.getResult();
		Assert.assertNotNull(relatedConcepts);
	}

	@Test
	public void getRelatedConceptsRecursive() {
		GetRelatedConceptsOptions options = new GetRelatedConceptsOptions.Builder().corpus(getProperty(CORPUS))
				.nameOrId("C0243026").relationship("children").recursive(true).build();

		ServiceCall<RelatedConceptsModel> sc = imlService.getRelatedConcepts(options);
		Response<RelatedConceptsModel> response = sc.execute();
		RelatedConceptsModel relatedConcepts = response.getResult();
		Assert.assertNotNull(relatedConcepts);
	}

	@Test
	public void getRelatedConceptsSingleLayerMaxDepth() {
		GetRelatedConceptsOptions options = new GetRelatedConceptsOptions.Builder().corpus(getProperty(CORPUS))
				.nameOrId("C0243026").relationship("children").maxDepth(1).build();

		ServiceCall<RelatedConceptsModel> sc = imlService.getRelatedConcepts(options);
		Response<RelatedConceptsModel> response = sc.execute();
		RelatedConceptsModel relatedConcepts = response.getResult();
		Assert.assertNotNull(relatedConcepts);
	}

	@Test
	public void getRelatedConceptsTreeLayout() {
		GetRelatedConceptsOptions options = new GetRelatedConceptsOptions.Builder().corpus(getProperty(CORPUS))
				.nameOrId("C0243026").relationship("children").treeLayout(true).build();

		ServiceCall<RelatedConceptsModel> sc = imlService.getRelatedConcepts(options);
		Response<RelatedConceptsModel> response = sc.execute();
		RelatedConceptsModel relatedConcepts = response.getResult();
		Assert.assertNotNull(relatedConcepts);
	}

	@Test
	public void getRelatedConceptsBuilder() {
		Builder builder = new GetRelatedConceptsOptions.Builder(getProperty(CORPUS), "C0243026", "children");


		ServiceCall<RelatedConceptsModel> sc = imlService.getRelatedConcepts(builder.build());
		Response<RelatedConceptsModel> response = sc.execute();
		RelatedConceptsModel relatedConcepts = response.getResult();
		Assert.assertNotNull(relatedConcepts);
	}

	@Test
	public void getRelatedConceptsBuilderFromOptions() {
		GetRelatedConceptsOptions options = new GetRelatedConceptsOptions.Builder().corpus(getProperty(CORPUS))
				.nameOrId("C0243026").relationship("children").treeLayout(true).build();
		Builder builder = options.newBuilder();
	}

}
