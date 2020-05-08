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
import com.ibm.watson.health.iml.v1.model.ArtifactModel;
import com.ibm.watson.health.iml.v1.model.ConceptListModel;
import com.ibm.watson.health.iml.v1.model.ConceptModel;
import com.ibm.watson.health.iml.v1.model.GetConceptsOptions;
import com.ibm.watson.health.iml.v1.model.GetConceptsOptions.Builder;
import com.ibm.watson.health.iml.v1.utils.ServiceUtilities;

public class TestGetConcepts {
	static final String CORPUS = "CORPUS";
	private InsightsForMedicalLiteratureService imlService;

	public TestGetConcepts() {
		try {
			imlService = ServiceUtilities.getServiceInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void getConceptsFromSingleCui() {
		String cuis = "C0018787";
		GetConceptsOptions cOptions = new GetConceptsOptions.Builder().corpus(getProperty(CORPUS)).addCuis(cuis).build();

		ServiceCall<ConceptListModel> sc = imlService.getConcepts(cOptions);

		Response<ConceptListModel> response = sc.execute();
		ConceptListModel clm = response.getResult();
		List<ArtifactModel> cmList = clm.getConcepts();
		for (ArtifactModel concept : cmList) {
			Assert.assertEquals(concept.getCui(), cuis);
			Assert.assertNotNull(concept.getOntology());
			Assert.assertNotNull(concept.getPreferredName());
		}
	}

	@Test
	public void getConceptsFromSingleCuiVerbose() {
		String cuis = "C0018787";
		GetConceptsOptions cOptions = new GetConceptsOptions.Builder(getProperty(CORPUS)).addCuis(cuis)
				.verbose(true).build();

		ServiceCall<ConceptListModel> sc = imlService.getConcepts(cOptions);

		Response<ConceptListModel> response = sc.execute();
		ConceptListModel clm = response.getResult();
		List<ArtifactModel> cmList = clm.getConcepts();
		for (ArtifactModel concept : cmList) {
			Assert.assertEquals(concept.getCui(), cuis);
			Assert.assertNotNull(concept.getOntology());
			Assert.assertNotNull(concept.getPreferredName());
		}
	}

	@Test
	public void getConceptsFromMultipleCuis() {
		String cui = "C0018787";
		List<String> cuis = new ArrayList<String>(2);
		cuis.add(cui);
		cui = "C0243026";
		cuis.add(cui);
		GetConceptsOptions cOptions = new GetConceptsOptions.Builder(getProperty(CORPUS)).cuis(cuis).build();

		ServiceCall<ConceptListModel> sc = imlService.getConcepts(cOptions);

		Response<ConceptListModel> response = sc.execute();
		ConceptListModel clm = response.getResult();
		List<ArtifactModel> cmList = clm.getConcepts();
		for (ArtifactModel concept : cmList) {
			Assert.assertNotNull(concept.getCui());
			Assert.assertNotNull(concept.getPreferredName());
			Assert.assertNotNull(concept.getOntology());
		}
	}

	@Test
	public void getConceptsFromSinglePreferredName() {
		String preferredName = "Heart";
		GetConceptsOptions cOptions = new GetConceptsOptions.Builder(getProperty(CORPUS))
				.addPreferredNames(preferredName).build();

		ServiceCall<ConceptListModel> sc = imlService.getConcepts(cOptions);

		Response<ConceptListModel> response = sc.execute();
		ConceptListModel clm = response.getResult();
		List<ArtifactModel> cmList = clm.getConcepts();
		for (ArtifactModel concept : cmList) {
			Assert.assertNotNull(concept.getCui());
			Assert.assertEquals(concept.getPreferredName(), preferredName);
			Assert.assertNotNull(concept.getOntology());
		}
	}

	@Test
	public void getConceptsFromMultiplePreferredNames() {
		String preferredName1 = "Heart";
		String preferredName2 = "Sepsis";
		List<String> preferredNames = new ArrayList<String>(2);
		preferredNames.add(preferredName1);
		preferredNames.add(preferredName2);
		GetConceptsOptions cOptions = new GetConceptsOptions.Builder(getProperty(CORPUS))
				.preferredNames(preferredNames).build();

		ServiceCall<ConceptListModel> sc = imlService.getConcepts(cOptions);

		Response<ConceptListModel> response = sc.execute();
		ConceptListModel clm = response.getResult();
		List<ArtifactModel> cmList = clm.getConcepts();
		for (ArtifactModel concept : cmList) {
			Assert.assertNotNull(concept.getCui());
			Assert.assertNotNull(concept.getPreferredName());
			Assert.assertNotNull(concept.getOntology());
		}
	}

	@Test
	public void getConceptsFromSingleSurfaceForm() {
		String surfaceForm = "cardiac";
		GetConceptsOptions cOptions = new GetConceptsOptions.Builder(getProperty(CORPUS))
				.addSurfaceForms(surfaceForm).build();

		ServiceCall<ConceptListModel> sc = imlService.getConcepts(cOptions);

		Response<ConceptListModel> response = sc.execute();
		ConceptListModel clm = response.getResult();
		List<ArtifactModel> cmList = clm.getConcepts();
		for (ArtifactModel concept : cmList) {
			Assert.assertNotNull(concept.getCui());
			Assert.assertNotNull(concept.getPreferredName());
			Assert.assertNotNull(concept.getOntology());
		}
	}

	@Test
	public void getConceptsFromMultipleSurfaceForms() {
		String surfaceForm = "cardiac";
		List<String> surfaceForms = new ArrayList<String>(2);
		surfaceForms.add(surfaceForm);
		surfaceForm = "sepsis";
		surfaceForms.add(surfaceForm);
		GetConceptsOptions cOptions = new GetConceptsOptions.Builder(getProperty(CORPUS))
				.surfaceForms(surfaceForms).build();

		ServiceCall<ConceptListModel> sc = imlService.getConcepts(cOptions);

		Response<ConceptListModel> response = sc.execute();
		ConceptListModel clm = response.getResult();
		List<ArtifactModel> cmList = clm.getConcepts();
		for (ArtifactModel concept : cmList) {
			Assert.assertNotNull(concept.getPreferredName());
			Assert.assertNotNull(concept.getOntology());
		}
	}

	@Test
	public void getConceptsFromMultipleSurfaceFormsSortedResults() {
		String preferredName = "Heart";
		List<String> preferredNames = new ArrayList<String>(2);
		preferredNames.add(preferredName);
		preferredName = "Sepsis";
		preferredNames.add(preferredName);
		GetConceptsOptions cOptions = new GetConceptsOptions.Builder(getProperty(CORPUS))
				.preferredNames(preferredNames).sort("-hitCount").build();

		ServiceCall<ConceptListModel> sc = imlService.getConcepts(cOptions);

		Response<ConceptListModel> response = sc.execute();
		ConceptListModel clm = response.getResult();
		List<ArtifactModel> cmList = clm.getConcepts();
		for (ArtifactModel concept : cmList) {
			Assert.assertNotNull(concept.getPreferredName());
			Assert.assertNotNull(concept.getOntology());
		}
	}

	@Test
	public void getConceptsFromMultipleSurfaceFormsLimitedResults() {
		String preferredName = "Heart";
		List<String> preferredNames = new ArrayList<String>(2);
		preferredNames.add(preferredName);
		preferredName = "Sepsis";
		preferredNames.add(preferredName);
		GetConceptsOptions cOptions = new GetConceptsOptions.Builder(getProperty(CORPUS))
				.preferredNames(preferredNames).limit(2).build();

		ServiceCall<ConceptListModel> sc = imlService.getConcepts(cOptions);

		Response<ConceptListModel> response = sc.execute();
		ConceptListModel clm = response.getResult();
		List<ArtifactModel> cmList = clm.getConcepts();
		for (ArtifactModel concept : cmList) {
			Assert.assertNotNull(concept.getPreferredName());
			Assert.assertNotNull(concept.getOntology());
		}
	}

	@Test
	public void getConceptsFromSingleAttribute() {
		String attributeId = "organ";
		List<String> attributes = new ArrayList<String>(1);
		attributes.add(attributeId);
		GetConceptsOptions cOptions = new GetConceptsOptions.Builder(getProperty(CORPUS))
				.addAttributes(attributeId).build();

		ServiceCall<ConceptListModel> sc = imlService.getConcepts(cOptions);

		Response<ConceptListModel> response = sc.execute();
		ConceptListModel clm = response.getResult();
		List<ArtifactModel> cmList = clm.getConcepts();
		for (ArtifactModel concept : cmList) {
			Assert.assertNotNull(concept.getCui());
			Assert.assertNotNull(concept.getPreferredName());
			Assert.assertNotNull(concept.getOntology());
		}
	}

	@Test
	public void getConceptsFromMultipleAttributes() {
		String attributeId = "age_group";
		List<String> attributes = new ArrayList<String>(1);
		attributes.add(attributeId);
		attributeId = "smoking_status";
		attributes.add(attributeId);
		GetConceptsOptions cOptions = new GetConceptsOptions.Builder(getProperty(CORPUS))
				.attributes(attributes).build();

		ServiceCall<ConceptListModel> sc = imlService.getConcepts(cOptions);

		Response<ConceptListModel> response = sc.execute();
		ConceptListModel clm = response.getResult();
		List<ArtifactModel> cmList = clm.getConcepts();
		for (ArtifactModel concept : cmList) {
			Assert.assertNotNull(concept.getPreferredName());
			Assert.assertNotNull(concept.getOntology());
		}
	}

	@Test
	public void getBuilderFromOptions() {
		String cuis = "C0018787";
		GetConceptsOptions cOptions = new GetConceptsOptions.Builder().corpus(getProperty(CORPUS)).addCuis(cuis).build();
		Builder builder = cOptions.newBuilder();
		Assert.assertNotNull(builder);
	}
}
