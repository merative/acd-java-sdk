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
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.watson.health.iml.v1.InsightsForMedicalLiteratureService;
import com.ibm.watson.health.iml.v1.common.Constants;
import com.ibm.watson.health.iml.v1.model.AnnotationModel;
import com.ibm.watson.health.iml.v1.model.AnnotationsModel;
import com.ibm.watson.health.iml.v1.model.ConceptModel;
import com.ibm.watson.health.iml.v1.model.DataModel;
import com.ibm.watson.health.iml.v1.model.GetDocumentAnnotationsOptions;
import com.ibm.watson.health.iml.v1.model.GetDocumentAnnotationsOptions.Builder;
import com.ibm.watson.health.iml.v1.model.UnstructuredModel;
import com.ibm.watson.health.iml.v1.utils.ServiceUtilities;

/**
 *
 * Class for testing /v1/corpoora/{corpus}/documents/{document_id}/annotations.
 *
 */
public class TestGetDocumentsDocumentAnnotations {
	private InsightsForMedicalLiteratureService imlService;

	public TestGetDocumentsDocumentAnnotations() {
		try {
			imlService = ServiceUtilities.getServiceInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetDocumentAnnotations() {
		GetDocumentAnnotationsOptions options = new GetDocumentAnnotationsOptions.Builder()
				.corpus(ServiceUtilities.getProperty(Constants.CORPUS)).documentId(Constants.TEST_DOCUMENT_ID)
				.documentSection(Constants.DOCUMENT_ANNOTATION_SECTION).build();

		ServiceCall<AnnotationsModel> sc = imlService.getDocumentAnnotations(options);
		Response<AnnotationsModel> response = sc.execute();
		AnnotationsModel model = response.getResult();
		Assert.assertNotNull(model);
		List<UnstructuredModel> unstructuredModelList = model.getUnstructured();
		for (UnstructuredModel unstructuredModel : unstructuredModelList) {
			DataModel data = unstructuredModel.getData();
			Assert.assertNotNull(data);
			List<ConceptModel> concepts = data.getConcepts();
			Assert.assertNotNull(concepts);
			for (ConceptModel annotation : concepts) {
				Assert.assertNull(annotation.getAttributeId());
				Assert.assertNotNull(annotation.getCui());
				Assert.assertNotNull(annotation.getPreferredName());
				Assert.assertNotNull(annotation.getSource());
				Assert.assertNotNull(annotation.getType());
				Assert.assertNotNull(annotation.getSection());
				Assert.assertTrue(annotation.getBegin() < annotation.getEnd());
			}
			List<ConceptModel> attributes = data.getAttributeValues();
			Assert.assertNotNull(attributes);
			for (ConceptModel annotation : attributes) {
				Assert.assertNotNull(annotation.getAttributeId());
				Assert.assertNotNull(annotation.getPreferredName());
				Assert.assertNotNull(annotation.getSource());
				Assert.assertNotNull(annotation.getType());
				Assert.assertNotNull(annotation.getSection());
				Assert.assertTrue(annotation.getBegin() < annotation.getEnd());
			}
		}
	}

	@Test
	public void testGetDocumentAnnotationsIncludeText() {
		GetDocumentAnnotationsOptions options = new GetDocumentAnnotationsOptions.Builder()
				.corpus(ServiceUtilities.getProperty(Constants.CORPUS)).documentId(Constants.TEST_DOCUMENT_ID)
				.documentSection(Constants.DOCUMENT_ANNOTATION_SECTION).includeText(true).build();

		ServiceCall<AnnotationsModel> sc = imlService.getDocumentAnnotations(options);
		Response<AnnotationsModel> response = sc.execute();
		AnnotationsModel model = response.getResult();
		Assert.assertNotNull(model);
		List<UnstructuredModel> unstructuredModelList = model.getUnstructured();
		for (UnstructuredModel unstructuredModel : unstructuredModelList) {
			Assert.assertNotNull(unstructuredModel.getText());
			DataModel data = unstructuredModel.getData();
			Assert.assertNotNull(data);
			List<ConceptModel> concepts = data.getConcepts();
			Assert.assertNotNull(concepts);
			for (ConceptModel annotation : concepts) {
				Assert.assertNull(annotation.getAttributeId());
				Assert.assertNotNull(annotation.getCui());
				Assert.assertNotNull(annotation.getPreferredName());
				Assert.assertNotNull(annotation.getSource());
				Assert.assertNotNull(annotation.getType());
				Assert.assertNotNull(annotation.getSection());
				Assert.assertTrue(annotation.getBegin() < annotation.getEnd());
			}
			List<ConceptModel> attributes = data.getAttributeValues();
			Assert.assertNotNull(attributes);
			for (ConceptModel annotation : attributes) {
				Assert.assertNotNull(annotation.getAttributeId());
				Assert.assertNotNull(annotation.getPreferredName());
				Assert.assertNotNull(annotation.getSource());
				Assert.assertNotNull(annotation.getType());
				Assert.assertNotNull(annotation.getSection());
				Assert.assertTrue(annotation.getBegin() < annotation.getEnd());
			}
		}
	}

	@Test
	public void testGetDocumentAnnotationsSpecificArtifacts() {
		GetDocumentAnnotationsOptions options = new GetDocumentAnnotationsOptions.Builder()
				.corpus(ServiceUtilities.getProperty(Constants.CORPUS)).documentId(Constants.TEST_DOCUMENT_ID)
				.documentSection(Constants.DOCUMENT_ANNOTATION_SECTION).addCuis("C0007028").build();

		ServiceCall<AnnotationsModel> sc = imlService.getDocumentAnnotations(options);
		Response<AnnotationsModel> response = sc.execute();
		AnnotationsModel model = response.getResult();
		Assert.assertNotNull(model);
		List<UnstructuredModel> unstructuredModelList = model.getUnstructured();
		for (UnstructuredModel unstructuredModel : unstructuredModelList) {
			DataModel data = unstructuredModel.getData();
			Assert.assertNotNull(data);
			List<ConceptModel> concepts = data.getConcepts();
			Assert.assertNotNull(concepts);
			for (ConceptModel annotation : concepts) {
				Assert.assertNull(annotation.getAttributeId());
				Assert.assertNotNull(annotation.getCui());
				Assert.assertNotNull(annotation.getPreferredName());
				Assert.assertNotNull(annotation.getSource());
				Assert.assertNotNull(annotation.getType());
				Assert.assertNotNull(annotation.getSection());
				Assert.assertNotNull(annotation.getCoveredText());
				Assert.assertTrue(annotation.getBegin() < annotation.getEnd());
			}
		}
	}

	@Test
	public void testGetDocumentAnnotationsSpecificMultipleArtifacts() {
		List<String> cuis = new ArrayList<String>(2);
		cuis.add("C0007028");
		cuis.add("C0332285");
		GetDocumentAnnotationsOptions options = new GetDocumentAnnotationsOptions.Builder()
				.corpus(ServiceUtilities.getProperty(Constants.CORPUS)).documentId(Constants.TEST_DOCUMENT_ID)
				.documentSection(Constants.DOCUMENT_ANNOTATION_SECTION).cuis(cuis).build();

		ServiceCall<AnnotationsModel> sc = imlService.getDocumentAnnotations(options);
		Response<AnnotationsModel> response = sc.execute();
		AnnotationsModel model = response.getResult();
		Assert.assertNotNull(model);
		List<UnstructuredModel> unstructuredModelList = model.getUnstructured();
		for (UnstructuredModel unstructuredModel : unstructuredModelList) {
			DataModel data = unstructuredModel.getData();
			Assert.assertNotNull(data);
			List<ConceptModel> concepts = data.getConcepts();
			Assert.assertNotNull(concepts);
			for (ConceptModel annotation : concepts) {
				Assert.assertNull(annotation.getAttributeId());
				Assert.assertNotNull(annotation.getCui());
				Assert.assertNotNull(annotation.getPreferredName());
				Assert.assertNotNull(annotation.getSource());
				Assert.assertNotNull(annotation.getType());
				Assert.assertNotNull(annotation.getSection());
				Assert.assertNotNull(annotation.getCoveredText());
				Assert.assertTrue(annotation.getBegin() < annotation.getEnd());
			}
		}
	}

	@Test
	public void testGetDocumentAnnotationsBuilder() {
		Builder builder = new GetDocumentAnnotationsOptions
				.Builder(ServiceUtilities.getProperty(Constants.CORPUS), Constants.TEST_DOCUMENT_ID, Constants.DOCUMENT_ANNOTATION_SECTION);

		ServiceCall<AnnotationsModel> sc = imlService.getDocumentAnnotations(builder.build());
		Response<AnnotationsModel> response = sc.execute();
		AnnotationsModel model = response.getResult();
		Assert.assertNotNull(model);
		List<UnstructuredModel> unstructuredModelList = model.getUnstructured();
		for (UnstructuredModel unstructuredModel : unstructuredModelList) {
			DataModel data = unstructuredModel.getData();
			Assert.assertNotNull(data);
			List<ConceptModel> concepts = data.getConcepts();
			Assert.assertNotNull(concepts);
			for (ConceptModel annotation : concepts) {
				Assert.assertNull(annotation.getAttributeId());
				Assert.assertNotNull(annotation.getCui());
				Assert.assertNotNull(annotation.getPreferredName());
				Assert.assertNotNull(annotation.getSource());
				Assert.assertNotNull(annotation.getType());
				Assert.assertNotNull(annotation.getSection());
				Assert.assertNotNull(annotation.getCoveredText());
				Assert.assertTrue(annotation.getBegin() < annotation.getEnd());
			}
		}
	}

	@Test
	public void testGetBuilderFromOptions() {
		GetDocumentAnnotationsOptions options = new GetDocumentAnnotationsOptions.Builder()
				.corpus(ServiceUtilities.getProperty(Constants.CORPUS)).documentId(Constants.TEST_DOCUMENT_ID)
				.documentSection(Constants.DOCUMENT_ANNOTATION_SECTION).includeText(true).build();
		Builder builder = options.newBuilder();
		Assert.assertNotNull(builder);
	}
}
