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
import com.ibm.watson.health.iml.v1.model.Category;
import com.ibm.watson.health.iml.v1.model.Entry;
import com.ibm.watson.health.iml.v1.model.EntryModel;
import com.ibm.watson.health.iml.v1.model.GetDocumentMultipleCategoriesOptions;
import com.ibm.watson.health.iml.v1.model.GetDocumentMultipleCategoriesOptions.Builder;
import com.ibm.watson.health.iml.v1.model.MultipleCategoriesModel;
import com.ibm.watson.health.iml.v1.model.Passage;
import com.ibm.watson.health.iml.v1.model.PassagesModel;
import com.ibm.watson.health.iml.v1.model.SentenceModel;
import com.ibm.watson.health.iml.v1.model.StringBuilder;
import com.ibm.watson.health.iml.v1.utils.ServiceUtilities;

public class TestGetDocumentsAnnotationsMultilpeCategories {
	private InsightsForMedicalLiteratureService imlService;

	public TestGetDocumentsAnnotationsMultilpeCategories() {
		try {
			imlService = ServiceUtilities.getServiceInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void getDocumentMultipleCatgoriesSingleCategory() {
		Category category = new Category();
		category.setName("disorders");
		category.setCategory("disorders");
		List<Category> categories = new ArrayList<Category>(1);
		categories.add(category);
		GetDocumentMultipleCategoriesOptions options = new GetDocumentMultipleCategoriesOptions.Builder()
				.corpus(getProperty(Constants.CORPUS)).documentId(Constants.TEST_DOCUMENT_ID)
				.categories(categories).build();

		ServiceCall<CategoriesModel> sc = imlService.getDocumentMultipleCategories(options);
		Response<CategoriesModel> response = sc.execute();
		CategoriesModel model = response.getResult();
		Assert.assertNotNull(model);
		String highlightedTitle = model.highlightedTitle();
		if (highlightedTitle != null) {
			Assert.assertTrue(highlightedTitle.toString().length() > 0);
		}
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
	public void getDocumentMultipleCatgoriesSingleCategoryCustomTags() {
		Category category = new Category();
		category.setName("disorders");
		category.setCategory("disorders");
		List<Category> categories = new ArrayList<Category>(1);
		categories.add(category);
		GetDocumentMultipleCategoriesOptions options = new GetDocumentMultipleCategoriesOptions.Builder()
				.corpus(getProperty(Constants.CORPUS)).documentId(Constants.TEST_DOCUMENT_ID)
				.highlightTagBegin("<u>").highlightTagEnd("</u>").categories(categories).build();

		ServiceCall<CategoriesModel> sc = imlService.getDocumentMultipleCategories(options);
		Response<CategoriesModel> response = sc.execute();
		CategoriesModel model = response.getResult();
		Assert.assertNotNull(model);
		String highlightedTitle = model.highlightedTitle();
		if (highlightedTitle != null) {
			Assert.assertTrue(highlightedTitle.toString().length() > 0);
		}
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
	public void getDocumentMultipleCatgoriesSingleCategorySpecificFields() {
		String fields = "highlightedTitle";
		Category category = new Category();
		category.setName("disorders");
		category.setCategory("disorders");
		List<Category> categories = new ArrayList<Category>(1);
		categories.add(category);
		GetDocumentMultipleCategoriesOptions options = new GetDocumentMultipleCategoriesOptions.Builder()
				.corpus(getProperty(Constants.CORPUS)).documentId(Constants.TEST_DOCUMENT_ID)
				.categories(categories).fields(fields).build();

		ServiceCall<CategoriesModel> sc = imlService.getDocumentMultipleCategories(options);
		Response<CategoriesModel> response = sc.execute();
		CategoriesModel model = response.getResult();
		Assert.assertNotNull(model);
		String highlightedTitle = model.highlightedTitle();
		if (highlightedTitle != null) {
			Assert.assertTrue(highlightedTitle.toString().length() > 0);
		}
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
	public void getDocumentMultipleCatgoriesSingleCategoryLimitedResults() {
		Category category = new Category();
		category.setName("disorders");
		category.setCategory("disorders");
		List<Category> categories = new ArrayList<Category>(1);
		categories.add(category);
		GetDocumentMultipleCategoriesOptions options = new GetDocumentMultipleCategoriesOptions.Builder()
				.corpus(getProperty(Constants.CORPUS)).documentId(Constants.TEST_DOCUMENT_ID)
				.categories(categories).limit(5).build();

		ServiceCall<CategoriesModel> sc = imlService.getDocumentMultipleCategories(options);
		Response<CategoriesModel> response = sc.execute();
		CategoriesModel model = response.getResult();
		Assert.assertNotNull(model);
		String highlightedTitle = model.highlightedTitle();
		if (highlightedTitle != null) {
			Assert.assertTrue(highlightedTitle.toString().length() > 0);
		}
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
	public void getDocumentMultipleCatgoriesSingleType() {
		Category category = new Category();
		category.setName("finding");
		List<String> types = new ArrayList<String>(1);
		types.add("Finding");
		category.setTypes(types);
		List<Category> categories = new ArrayList<Category>(1);
		categories.add(category);
		GetDocumentMultipleCategoriesOptions options = new GetDocumentMultipleCategoriesOptions.Builder()
				.corpus(getProperty(Constants.CORPUS)).documentId(Constants.TEST_DOCUMENT_ID)
				.categories(categories).build();

		ServiceCall<CategoriesModel> sc = imlService.getDocumentMultipleCategories(options);
		Response<CategoriesModel> response = sc.execute();
		CategoriesModel model = response.getResult();
		Assert.assertNotNull(model);
		String highlightedTitle = model.highlightedTitle();
		if (highlightedTitle != null) {
			Assert.assertTrue(highlightedTitle.toString().length() > 0);
		}
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
	public void getDocumentMultipleCatgoriesCategoryAndType() {
		List<Category> categories = new ArrayList<Category>(2);
		Category category = new Category();
		category.setName("finding");
		List<String> types = new ArrayList<String>(1);
		types.add("Finding");
		category.setTypes(types);
		categories.add(category);
		category = new Category();
		category.setName("disorders");
		category.setCategory("disorders");
		categories.add(category);
		GetDocumentMultipleCategoriesOptions options = new GetDocumentMultipleCategoriesOptions.Builder()
				.corpus(getProperty(Constants.CORPUS)).documentId(Constants.TEST_DOCUMENT_ID)
				.categories(categories).build();

		ServiceCall<CategoriesModel> sc = imlService.getDocumentMultipleCategories(options);
		Response<CategoriesModel> response = sc.execute();
		CategoriesModel model = response.getResult();
		Assert.assertNotNull(model);
		String highlightedTitle = model.highlightedTitle();
		if (highlightedTitle != null) {
			Assert.assertTrue(highlightedTitle.toString().length() > 0);
		}
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
}
