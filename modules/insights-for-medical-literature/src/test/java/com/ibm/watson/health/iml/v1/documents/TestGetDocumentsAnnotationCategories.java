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

import static com.ibm.watson.health.iml.v1.utils.ServiceUtilities.getProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.watson.health.iml.v1.InsightsForMedicalLiteratureService;
import com.ibm.watson.health.iml.v1.common.Constants;
import com.ibm.watson.health.iml.v1.model.AnnotationModel;
import com.ibm.watson.health.iml.v1.model.CategoriesModel;
import com.ibm.watson.health.iml.v1.model.Entry;
import com.ibm.watson.health.iml.v1.model.GetDocumentCategoriesOptions;
import com.ibm.watson.health.iml.v1.model.GetDocumentCategoriesOptions.Builder;
import com.ibm.watson.health.iml.v1.model.Passage;
import com.ibm.watson.health.iml.v1.model.PassagesModel;
import com.ibm.watson.health.iml.v1.model.SentenceModel;
import com.ibm.watson.health.iml.v1.utils.ServiceUtilities;

/**
 *
 * Class for testing /v1/corpoora/{corpus}/documents/{document_id}/categories.
 *
 */
public class TestGetDocumentsAnnotationCategories {
	private InsightsForMedicalLiteratureService imlService;

	public TestGetDocumentsAnnotationCategories() {
		try {
			imlService = ServiceUtilities.getServiceInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void getTestGetDocumentCategores() {
		GetDocumentCategoriesOptions options = new GetDocumentCategoriesOptions.Builder()
				.corpus(getProperty(Constants.CORPUS))
				.documentId(Constants.TEST_DOCUMENT_ID)
				.fields("passages,annotations, highlightedTitle").build();

		ServiceCall<CategoriesModel> sc = imlService
				.getDocumentCategories(options);
		Response<CategoriesModel> response = sc.execute();
		CategoriesModel model = response.getResult();
		Assert.assertNotNull(model.highlightedTitle());
		String highlightedAbstract = model.highlightedAbstract();
		if (highlightedAbstract != null) {
			Assert.assertTrue(highlightedAbstract.toString().length() > 0);
		}
		String highlightedBody = model.highlightedBody();
		if (highlightedBody != null) {
			Assert.assertTrue(highlightedBody.toString().length() > 0);
		}
		String license = model.modelLicense();
		if (license != null) {
			Assert.assertTrue(license.length() > 0);
		}
		Map<String, AnnotationModel> annotationModel = model.annotations();
		if (annotationModel != null) {
			Set<String> keys = annotationModel.keySet();
			for (String key : keys) {
				AnnotationModel annotation = annotationModel.get(key);
				Assert.assertNotNull(annotation.preferredName());
				Assert.assertNotNull(annotation.ontology());
				Assert.assertNotNull(annotation.type());
				Assert.assertNotNull(annotation.section());
				Assert.assertTrue(annotation.begin() < annotation.end());
			}
		}
		Map<String, PassagesModel> passagesModel = model.passages();
		if (passagesModel != null) {
			Set<String> passageKeys = passagesModel.keySet();
			for (String passageKey : passageKeys) {
				PassagesModel passageMap = passagesModel.get(passageKey);
				Entry entry = passageMap.getEntry();
				if (entry != null) {
					entry.getId();
					List<SentenceModel> sentenceList = entry.getSentences();
					for (SentenceModel sentence : sentenceList) {
						Assert.assertNotNull(sentence.documentSection());
						Assert.assertTrue(sentence.begin() >= 0);
						Assert.assertNotNull(sentence.text());
						Assert.assertTrue(sentence.timestamp() == 0);
					}
				}
			}
		}
	}

	@Test
	public void getTestGetDocumentCategoresCustomTags() {
		GetDocumentCategoriesOptions options = new GetDocumentCategoriesOptions.Builder()
				.corpus(getProperty(Constants.CORPUS))
				.documentId(Constants.TEST_DOCUMENT_ID).highlightTagBegin("<u>")
				.highlightTagEnd("</u>").build();

		ServiceCall<CategoriesModel> sc = imlService
				.getDocumentCategories(options);
		Response<CategoriesModel> response = sc.execute();
		CategoriesModel model = response.getResult();
		Assert.assertNotNull(model.highlightedTitle());
		String highlightedAbstract = model.highlightedAbstract();
		if (highlightedAbstract != null) {
			Assert.assertTrue(highlightedAbstract.length() > 0);
		}
		String highlightedBody = model.highlightedBody();
		if (highlightedBody != null) {
			Assert.assertTrue(highlightedBody.length() > 0);
		}
		String license = model.modelLicense();
		if (license != null) {
			Assert.assertTrue(license.length() > 0);
		}
		Map<String, AnnotationModel> annotationModel = model.annotations();
		if (annotationModel != null) {
			Set<String> keys = annotationModel.keySet();
			for (String key : keys) {
				AnnotationModel annotation = annotationModel.get(key);
				Assert.assertNotNull(annotation.preferredName());
				Assert.assertNotNull(annotation.ontology());
				Assert.assertNotNull(annotation.type());
				Assert.assertNotNull(annotation.section());
				Assert.assertTrue(annotation.begin() < annotation.end());
			}
		}
		Map<String, PassagesModel> passagesModel = model.passages();
		if (passagesModel != null) {
			Set<String> passageKeys = passagesModel.keySet();
			for (String passageKey : passageKeys) {
				PassagesModel passageMap = passagesModel.get(passageKey);
				Entry entry = passageMap.getEntry();
				if (entry != null) {
					entry.getId();
					List<SentenceModel> sentenceList = entry.getSentences();
					for (SentenceModel sentence : sentenceList) {
						Assert.assertNotNull(sentence.documentSection());
						Assert.assertTrue(sentence.begin() >= 0);
						Assert.assertNotNull(sentence.text());
						Assert.assertTrue(sentence.timestamp() == 0);
					}
				}
			}
		}
	}

	@Test
	public void getTestGetDocumentCategoresSpecificType() {
		GetDocumentCategoriesOptions options = new GetDocumentCategoriesOptions.Builder()
				.corpus(getProperty(Constants.CORPUS))
				.documentId(Constants.TEST_DOCUMENT_ID).addTypes("Finding")
				.build();

		ServiceCall<CategoriesModel> sc = imlService
				.getDocumentCategories(options);
		Response<CategoriesModel> response = sc.execute();
		CategoriesModel model = response.getResult();

		String highlightedAbstract = model.highlightedAbstract();
		if (highlightedAbstract != null) {
			Assert.assertTrue(highlightedAbstract.length() > 0);
		}
		String license = model.modelLicense();
		if (license != null) {
			Assert.assertTrue(license.length() > 0);
		}
		Map<String, AnnotationModel> annotationModel = model.annotations();
		if (annotationModel != null) {
			Set<String> keys = annotationModel.keySet();
			for (String key : keys) {
				AnnotationModel annotation = annotationModel.get(key);
				Assert.assertNotNull(annotation.preferredName());
				Assert.assertNotNull(annotation.ontology());
				Assert.assertNotNull(annotation.type());
				Assert.assertNotNull(annotation.section());
				Assert.assertTrue(annotation.begin() < annotation.end());
			}
		}
		Map<String, PassagesModel> passagesModel = model.passages();
		if (passagesModel != null) {
			Set<String> passageKeys = passagesModel.keySet();
			for (String passageKey : passageKeys) {
				PassagesModel passageMap = passagesModel.get(passageKey);
				Entry entry = passageMap.getEntry();
				if (entry != null) {
					entry.getId();
					List<SentenceModel> sentenceList = entry.getSentences();
					for (SentenceModel sentence : sentenceList) {
						Assert.assertNotNull(sentence.documentSection());
						Assert.assertTrue(sentence.begin() >= 0);
						Assert.assertNotNull(sentence.text());
						Assert.assertTrue(sentence.timestamp() == 0);
					}
				}
			}
		}
	}

	@Test
	public void getTestGetDocumentCategoresSpecificTypes() {
		List<String> types = new ArrayList<String>(2);
		types.add("Finding");
		types.add("DiseaseOrSyndrome");
		GetDocumentCategoriesOptions options = new GetDocumentCategoriesOptions.Builder()
				.corpus(getProperty(Constants.CORPUS))
				.documentId(Constants.TEST_DOCUMENT_ID).types(types).build();

		ServiceCall<CategoriesModel> sc = imlService
				.getDocumentCategories(options);
		Response<CategoriesModel> response = sc.execute();
		CategoriesModel model = response.getResult();

		String highlightedAbstract = model.highlightedAbstract();
		if (highlightedAbstract != null) {
			Assert.assertTrue(highlightedAbstract.length() > 0);
		}

		String license = model.modelLicense();
		if (license != null) {
			Assert.assertTrue(license.length() > 0);
		}
		Map<String, AnnotationModel> annotationModel = model.annotations();
		if (annotationModel != null) {
			Set<String> keys = annotationModel.keySet();
			for (String key : keys) {
				AnnotationModel annotation = annotationModel.get(key);
				Assert.assertNotNull(annotation.preferredName());
				Assert.assertNotNull(annotation.ontology());
				Assert.assertNotNull(annotation.type());
				Assert.assertNotNull(annotation.section());
				Assert.assertTrue(annotation.begin() < annotation.end());
			}
		}
		Map<String, PassagesModel> passagesModel = model.passages();
		if (passagesModel != null) {
			Set<String> passageKeys = passagesModel.keySet();
			for (String passageKey : passageKeys) {
				PassagesModel passageMap = passagesModel.get(passageKey);
				Entry entry = passageMap.getEntry();
				if (entry != null) {
					entry.getId();
					List<SentenceModel> sentenceList = entry.getSentences();
					for (SentenceModel sentence : sentenceList) {
						Assert.assertNotNull(sentence.documentSection());
						Assert.assertTrue(sentence.begin() >= 0);
						Assert.assertNotNull(sentence.text());
						Assert.assertTrue(sentence.timestamp() == 0);
					}
				}
			}
		}
	}

	@Test
	public void getTestGetDocumentCategoresSpecificCategory() {
		GetDocumentCategoriesOptions options = new GetDocumentCategoriesOptions.Builder()
				.corpus(getProperty(Constants.CORPUS))
				.documentId(Constants.TEST_DOCUMENT_ID).category("disorders")
				.build();

		ServiceCall<CategoriesModel> sc = imlService
				.getDocumentCategories(options);
		Response<CategoriesModel> response = sc.execute();
		CategoriesModel model = response.getResult();
		Assert.assertNotNull(model.highlightedTitle());
		String highlightedAbstract = model.highlightedAbstract();
		if (highlightedAbstract != null) {
			Assert.assertTrue(highlightedAbstract.length() > 0);
		}
		String license = model.modelLicense();
		if (license != null) {
			Assert.assertTrue(license.length() > 0);
		}
		Map<String, AnnotationModel> annotationModel = model.annotations();
		if (annotationModel != null) {
			Set<String> keys = annotationModel.keySet();
			for (String key : keys) {
				AnnotationModel annotation = annotationModel.get(key);
				Assert.assertNotNull(annotation.preferredName());
				Assert.assertNotNull(annotation.ontology());
				Assert.assertNotNull(annotation.type());
				Assert.assertNotNull(annotation.section());
				Assert.assertTrue(annotation.begin() < annotation.end());
			}
		}
		Map<String, PassagesModel> passagesModel = model.passages();
		if (passagesModel != null) {
			Set<String> passageKeys = passagesModel.keySet();
			for (String passageKey : passageKeys) {
				PassagesModel passageMap = passagesModel.get(passageKey);
				Entry entry = passageMap.getEntry();
				if (entry != null) {
					entry.getId();
					List<SentenceModel> sentenceList = entry.getSentences();
					for (SentenceModel sentence : sentenceList) {
						Assert.assertNotNull(sentence.documentSection());
						Assert.assertTrue(sentence.begin() >= 0);
						Assert.assertNotNull(sentence.text());
						Assert.assertTrue(sentence.timestamp() == 0);
					}
				}
			}
		}
	}

	@Test
	public void getTestGetDocumentCategoresNegatedOnly() {
		GetDocumentCategoriesOptions options = new GetDocumentCategoriesOptions.Builder()
				.corpus(getProperty(Constants.CORPUS))
				.documentId(Constants.TEST_DOCUMENT_ID)
				.onlyNegatedConcepts(true).build();

		ServiceCall<CategoriesModel> sc = imlService
				.getDocumentCategories(options);
		Response<CategoriesModel> response = sc.execute();
		CategoriesModel model = response.getResult();

		String license = model.modelLicense();
		if (license != null) {
			Assert.assertTrue(license.length() > 0);
		}

	}

	@Test
	public void getTestGetDocumentCategoresSpecificFields() {
		String fields = "highlightedTitle";
		GetDocumentCategoriesOptions options = new GetDocumentCategoriesOptions.Builder()
				.corpus(getProperty(Constants.CORPUS))
				.documentId(Constants.TEST_DOCUMENT_ID).fields(fields).build();

		ServiceCall<CategoriesModel> sc = imlService
				.getDocumentCategories(options);
		Response<CategoriesModel> response = sc.execute();
		CategoriesModel model = response.getResult();
		Assert.assertNotNull(model.highlightedTitle());
		Assert.assertNull(model.highlightedAbstract());
		Assert.assertNull(model.highlightedBody());
	}

	@Test
	public void getTestGetDocumentCategoresLimitedResutls() {
		GetDocumentCategoriesOptions options = new GetDocumentCategoriesOptions.Builder()
				.corpus(getProperty(Constants.CORPUS))
				.documentId(Constants.TEST_DOCUMENT_ID).limit(5).build();

		ServiceCall<CategoriesModel> sc = imlService
				.getDocumentCategories(options);
		Response<CategoriesModel> response = sc.execute();
		CategoriesModel model = response.getResult();
		Assert.assertNotNull(model.highlightedTitle());
		String highlightedAbstract = model.highlightedAbstract();
		Assert.assertTrue(highlightedAbstract.length() > 0);
		String license = model.modelLicense();
		if (license != null) {
			Assert.assertTrue(license.length() > 0);
		}
		Map<String, AnnotationModel> annotationModel = model.annotations();
		if (annotationModel != null) {
			Set<String> keys = annotationModel.keySet();
			for (String key : keys) {
				AnnotationModel annotation = annotationModel.get(key);
				Assert.assertNotNull(annotation.preferredName());
				Assert.assertNotNull(annotation.ontology());
				Assert.assertNotNull(annotation.type());
				Assert.assertNotNull(annotation.section());
				Assert.assertTrue(annotation.begin() < annotation.end());
			}
		}
		Map<String, PassagesModel> passagesModel = model.passages();
		if (passagesModel != null) {
			Set<String> passageKeys = passagesModel.keySet();
			for (String passageKey : passageKeys) {
				PassagesModel passageMap = passagesModel.get(passageKey);
				Entry entry = passageMap.getEntry();
				if (entry != null) {
					entry.getId();
					List<SentenceModel> sentenceList = entry.getSentences();
					for (SentenceModel sentence : sentenceList) {
						Assert.assertNotNull(sentence.documentSection());
						Assert.assertTrue(sentence.begin() >= 0);
						Assert.assertNotNull(sentence.text());
						Assert.assertTrue(sentence.timestamp() == 0);
					}
				}
			}
		}
	}

	@Test
	public void getTestGetDocumentCategoresBuilder() {
		Builder builder = new GetDocumentCategoriesOptions.Builder(
				getProperty(Constants.CORPUS), Constants.TEST_DOCUMENT_ID);

		ServiceCall<CategoriesModel> sc = imlService
				.getDocumentCategories(builder.build());
		Response<CategoriesModel> response = sc.execute();
		CategoriesModel model = response.getResult();
		Assert.assertNotNull(model.highlightedTitle());
		String highlightedAbstract = model.highlightedAbstract();
		if (highlightedAbstract != null) {
			Assert.assertTrue(highlightedAbstract.length() > 0);
		}
		String highlightedBody = model.highlightedBody();
		if (highlightedBody != null) {
			Assert.assertTrue(highlightedBody.length() > 0);
		}
		String license = model.modelLicense();
		if (license != null) {
			Assert.assertTrue(license.length() > 0);
		}
		Map<String, AnnotationModel> annotationModel = model.annotations();
		if (annotationModel != null) {
			Set<String> keys = annotationModel.keySet();
			for (String key : keys) {
				AnnotationModel annotation = annotationModel.get(key);
				Assert.assertNotNull(annotation.preferredName());
				Assert.assertNotNull(annotation.ontology());
				Assert.assertNotNull(annotation.type());
				Assert.assertNotNull(annotation.section());
				Assert.assertTrue(annotation.begin() < annotation.end());
			}
		}
		Map<String, PassagesModel> passagesModel = model.passages();
		if (passagesModel != null) {
			Set<String> passageKeys = passagesModel.keySet();
			for (String passageKey : passageKeys) {
				PassagesModel passageMap = passagesModel.get(passageKey);
				Entry entry = passageMap.getEntry();
				if (entry != null) {
					entry.getId();
					List<SentenceModel> sentenceList = entry.getSentences();
					for (SentenceModel sentence : sentenceList) {
						Assert.assertNotNull(sentence.documentSection());
						Assert.assertTrue(sentence.begin() >= 0);
						Assert.assertNotNull(sentence.text());
						Assert.assertTrue(sentence.timestamp() == 0);
					}
				}
			}
		}
	}

	@Test
	public void getTestBuilderFromOptions() {
		GetDocumentCategoriesOptions options = new GetDocumentCategoriesOptions.Builder()
				.corpus(getProperty(Constants.CORPUS))
				.documentId(Constants.TEST_DOCUMENT_ID).build();

		Builder builder = options.newBuilder();
		Assert.assertNotNull(builder);
	}
}
