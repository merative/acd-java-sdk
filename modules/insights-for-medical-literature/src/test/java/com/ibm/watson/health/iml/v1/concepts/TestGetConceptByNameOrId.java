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
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.watson.health.iml.v1.InsightsForMedicalLiteratureService;
import com.ibm.watson.health.iml.v1.common.Constants;
import com.ibm.watson.health.iml.v1.model.ConceptInfoModel;
import com.ibm.watson.health.iml.v1.model.GetCuiInfoOptions;
import com.ibm.watson.health.iml.v1.model.GetCuiInfoOptions.Builder;
import com.ibm.watson.health.iml.v1.utils.ServiceUtilities;

public class TestGetConceptByNameOrId {
	static final String CORPUS = "CORPUS";
	private InsightsForMedicalLiteratureService imlService;

	public TestGetConceptByNameOrId() {
		try {
			imlService = ServiceUtilities.getServiceInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetConceptsByNameOrId() {
		GetCuiInfoOptions cuiOptions = new GetCuiInfoOptions.Builder(getProperty(CORPUS), "C0243026").treeLayout(false).build();
		ServiceCall<ConceptInfoModel> sc = imlService.getCuiInfo(cuiOptions);

		Response<ConceptInfoModel> response = sc.execute();
		ConceptInfoModel ucim = response.getResult();
		Assert.assertNotNull(ucim);
		Assert.assertNotNull(ucim.getCui());
		Assert.assertNotNull(ucim.getOntology());
		Assert.assertNotNull(ucim.getPreferredName());
		Assert.assertNotNull(ucim.getSemanticTypes());
		Assert.assertNotNull(ucim.getSurfaceForms());
		Assert.assertTrue(ucim.isHasChildren());
		Assert.assertTrue(ucim.isHasParents());
		Assert.assertTrue(ucim.isHasSiblings());
	}

	@Test
	public void testGetConceptsByNameOrIdTreeLayout() {
		GetCuiInfoOptions cuiOptions = new GetCuiInfoOptions.Builder(getProperty(CORPUS), "C0243026").ontology(Constants.UMLS).treeLayout(true).build();
		ServiceCall<ConceptInfoModel> sc = imlService.getCuiInfo(cuiOptions);

		Response<ConceptInfoModel> response = sc.execute();
		ConceptInfoModel ucim = response.getResult();
		Assert.assertNotNull(ucim);
		Assert.assertNotNull(ucim.getCui());
		Object preferredName = ucim.getPreferredName();
		if (preferredName instanceof Map) {
			Map<String, Object> treeLayout = (Map<String, Object>) preferredName;
			Assert.assertNotNull(treeLayout.get("name"));
		}
	}

	@Test
	public void testGetConceptsByNameOrIdWithFields() {
		String fields = "semanticTypes";
		GetCuiInfoOptions cuiOptions = new GetCuiInfoOptions.Builder(getProperty(CORPUS), "C0243026")
				.fields(fields).treeLayout(false).build();
		ServiceCall<ConceptInfoModel> sc = imlService.getCuiInfo(cuiOptions);

		Response<ConceptInfoModel> response = sc.execute();
		ConceptInfoModel ucim = response.getResult();
		Assert.assertNotNull(ucim);
		Assert.assertNotNull(ucim.getCui());
		Assert.assertNotNull(ucim.getSemanticTypes());
	}

	@Test
	public void testGetConceptsByNameOrIdWithOntology() {
		String fields = "semanticTypes";
		GetCuiInfoOptions cuiOptions = new GetCuiInfoOptions.Builder(getProperty(CORPUS), "C0243026")
				.fields(fields).ontology("umls").treeLayout(false).build();
		ServiceCall<ConceptInfoModel> sc = imlService.getCuiInfo(cuiOptions);

		Response<ConceptInfoModel> response = sc.execute();
		ConceptInfoModel ucim = response.getResult();
		Assert.assertNotNull(ucim);
		Assert.assertNotNull(ucim.getCui());
		Assert.assertNotNull(ucim.getSemanticTypes());
	}

	@Test
	public void testGetConceptsByNameOrIdBuilder() {
		String fields = "semanticTypes";
		Builder builder = new GetCuiInfoOptions.Builder(getProperty(CORPUS), "C0243026");
		builder.fields(fields);
		builder.ontology("umls");
		builder.treeLayout(false);
		ServiceCall<ConceptInfoModel> sc = imlService.getCuiInfo(builder.build());

		Response<ConceptInfoModel> response = sc.execute();
		ConceptInfoModel ucim = response.getResult();
		Assert.assertNotNull(ucim);
		Assert.assertNotNull(ucim.getCui());
		Assert.assertNotNull(ucim.getSemanticTypes());
	}

	@Test
	public void testGetConceptsByNameOrIdEmptyBuilder() {
		String fields = "semanticTypes";
		Builder builder = new GetCuiInfoOptions.Builder();
		builder.corpus(getProperty(CORPUS));
		builder.nameOrId("C0243026");
		builder.fields(fields);
		builder.ontology("umls");
		builder.treeLayout(false);
		ServiceCall<ConceptInfoModel> sc = imlService.getCuiInfo(builder.build());

		Response<ConceptInfoModel> response = sc.execute();
		ConceptInfoModel ucim = response.getResult();
		Assert.assertNotNull(ucim);
		Assert.assertNotNull(ucim.getCui());
		Assert.assertNotNull(ucim.getSemanticTypes());
	}
}
