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
package com.ibm.watson.health.iml.v1.search;
import static com.ibm.watson.health.iml.v1.utils.ServiceUtilities.getProperty;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.watson.health.iml.v1.InsightsForMedicalLiteratureService;
import com.ibm.watson.health.iml.v1.common.Constants;
import com.ibm.watson.health.iml.v1.model.ConceptListModel;
import com.ibm.watson.health.iml.v1.model.ArtifactModel;
import com.ibm.watson.health.iml.v1.model.TypeaheadOptions;
import com.ibm.watson.health.iml.v1.model.TypeaheadOptions.Builder;
import com.ibm.watson.health.iml.v1.utils.ServiceUtilities;

public class TestGetSearchTypeahead {
	private InsightsForMedicalLiteratureService imlService;

	public TestGetSearchTypeahead() {
		try {
			imlService = ServiceUtilities.getServiceInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void getSeachTypeahead() {
		TypeaheadOptions taOptions = new TypeaheadOptions.Builder().corpus(getProperty(Constants.CORPUS)).query("Sep").build();

		ServiceCall<ConceptListModel> sc = imlService.typeahead(taOptions);

		Response<ConceptListModel> response = sc.execute();
		ConceptListModel clm = response.getResult();
		List<ArtifactModel> cmList = clm.getConcepts();
		for (ArtifactModel cm : cmList) {
			Assert.assertNotNull(cm.getCui());
			Assert.assertNotNull(cm.getOntology());
			Assert.assertNotNull(cm.getPreferredName());
			Assert.assertNotNull(cm.getSemanticType());
		}
	}

	@Test
	public void getSeachTypeaheadBuilder() {
		Builder builder = new TypeaheadOptions.Builder(getProperty(Constants.CORPUS), "Sep");

		ServiceCall<ConceptListModel> sc = imlService.typeahead(builder.build());

		Response<ConceptListModel> response = sc.execute();
		ConceptListModel clm = response.getResult();
		List<ArtifactModel> cmList = clm.getConcepts();
		for (ArtifactModel cm : cmList) {
			Assert.assertNotNull(cm.getCui());
			Assert.assertNotNull(cm.getOntology());
			Assert.assertNotNull(cm.getPreferredName());
			Assert.assertNotNull(cm.getSemanticType());
		}
	}

	@Test
	public void getSeachTypeaheadFullOptions() {
		TypeaheadOptions taOptions = new TypeaheadOptions.Builder(getProperty(Constants.CORPUS), "Sep")
				.addOntologies(Constants.UMLS).addTypes("DiseaseOrSyndrome").category("disorders")
				.verbose(true).limit(5).maxHitCount(20000).noDuplicates(true).build();

		ServiceCall<ConceptListModel> sc = imlService.typeahead(taOptions);

		Response<ConceptListModel> response = sc.execute();
		ConceptListModel clm = response.getResult();
		List<ArtifactModel> cmList = clm.getConcepts();
		for (ArtifactModel cm : cmList) {
			Assert.assertNotNull(cm.getCui());
			Assert.assertNotNull(cm.getOntology());
			Assert.assertNotNull(cm.getPreferredName());
			Assert.assertNotNull(cm.getSemanticType());
		}
	}

	@Test
	public void getSeachTypeaheadFullOptionsLists() {
		List<String> typesList = new ArrayList<String>(1);
		List<String> ontologies = new ArrayList<String>(1);
		typesList.add("DiseaseOrSyndrome");
		ontologies.add("umls");
		TypeaheadOptions taOptions = new TypeaheadOptions.Builder(getProperty(Constants.CORPUS), "Sep")
				.ontologies(ontologies).types(typesList).category("disorders")
				.verbose(true).limit(5).maxHitCount(20000).noDuplicates(true).build();

		ServiceCall<ConceptListModel> sc = imlService.typeahead(taOptions);

		Response<ConceptListModel> response = sc.execute();
		ConceptListModel clm = response.getResult();
		List<ArtifactModel> cmList = clm.getConcepts();
		for (ArtifactModel cm : cmList) {
			Assert.assertNotNull(cm.getCui());
			Assert.assertNotNull(cm.getOntology());
			Assert.assertNotNull(cm.getPreferredName());
			Assert.assertNotNull(cm.getSemanticType());
		}
	}

	@Test
	public void getBuilderFromOptions() {
		TypeaheadOptions taOptions = new TypeaheadOptions.Builder().corpus(getProperty(Constants.CORPUS)).query("Sep").build();
		Builder builder = taOptions.newBuilder();

		Assert.assertNotNull(builder);
	}
}
