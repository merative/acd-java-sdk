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
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.watson.health.iml.v1.InsightsForMedicalLiteratureService;
import com.ibm.watson.health.iml.v1.WatsonServiceTest;
import com.ibm.watson.health.iml.v1.common.Constants;
import com.ibm.watson.health.iml.v1.model.AnnotationModel;
import com.ibm.watson.health.iml.v1.model.CategoriesModel;
import com.ibm.watson.health.iml.v1.model.Category;
import com.ibm.watson.health.iml.v1.model.Entry;
import com.ibm.watson.health.iml.v1.model.GetDocumentMultipleCategoriesOptions;
import com.ibm.watson.health.iml.v1.model.GetDocumentMultipleCategoriesOptions.Builder;
import com.ibm.watson.health.iml.v1.model.MultipleCategoriesModel;
import com.ibm.watson.health.iml.v1.model.SentenceModel;

public class TestGetDocumentsAnnotationsMultilpeCategories extends WatsonServiceTest {
	private InsightsForMedicalLiteratureService imlService;

	public TestGetDocumentsAnnotationsMultilpeCategories() {
		super();
		try {
			this.setUp();
			imlService = this.getServiceInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void getDocumentMultipleCatgoriesSingleCategory() {
		Category category = new Category();
		category.setName("disorders");
		category.setCategory("disorders");
		GetDocumentMultipleCategoriesOptions options = new GetDocumentMultipleCategoriesOptions.Builder()
				.corpus(getProperty(Constants.CORPUS)).documentId(Constants.TEST_DOCUMENT_ID)
				.addCategories(category).build();

		ServiceCall<MultipleCategoriesModel> sc = imlService.getDocumentMultipleCategories(options);
		Response<MultipleCategoriesModel> response = sc.execute();
		MultipleCategoriesModel model = response.getResult();
		Assert.assertNotNull(model);
		Map<String, CategoriesModel> categoriesModelMap = model.getCategoryMap();
		Set<String> categoryKeys = categoriesModelMap.keySet();
		for (String key : categoryKeys) {
			CategoriesModel categories = categoriesModelMap.get(key);
			Map<String, Map<String, Entry>> passagesModel = categories.getPassages();
			if (passagesModel != null) {
				Set<String> passageKeys = passagesModel.keySet();
				for (String passageKey : passageKeys) {
					Map<String, Entry> passageMap = passagesModel.get(passageKey);
					Set<String> keys = passageMap.keySet();
					for (String mapKey : keys) {
						Entry entry = passageMap.get(mapKey);
						Assert.assertNotNull(entry.getId());
						List<SentenceModel> sentences = entry.getSentences();
						for (SentenceModel sentence : sentences) {
							Assert.assertTrue(sentence.getBegin() > -1);
							Assert.assertTrue(sentence.getEnd() > sentence.getBegin());
							Assert.assertNotNull(sentence.getText());
							Assert.assertNotNull(sentence.getDocumentSection());
							Assert.assertTrue(sentence.getTimestamp() == 0);
						}
					}
				}
			}
			Map<String, AnnotationModel> annotationModel = categories.getAnnotations();
			if (annotationModel != null) {
				Set<String> keys = annotationModel.keySet();
				for (String annokey : keys) {
					AnnotationModel annotation = annotationModel.get(annokey);
					Assert.assertNotNull(annotation.getPreferredName());
					Assert.assertNotNull(annotation.getOntology());
					Assert.assertNotNull(annotation.getType());
					Assert.assertNotNull(annotation.getSection());
					Assert.assertTrue(annotation.getBegin() < annotation.getEnd());
				}
			}
		}
		Map<String, AnnotationModel> annotationModel = model.getAnnotations();
		if (annotationModel != null) {
			Set<String> keys = annotationModel.keySet();
			for (String key : keys) {
				AnnotationModel annotation = annotationModel.get(key);
				Assert.assertNotNull(annotation.getPreferredName());
				Assert.assertNotNull(annotation.getOntology());
				Assert.assertNotNull(annotation.getType());
				Assert.assertNotNull(annotation.getSection());
				Assert.assertTrue(annotation.getBegin() < annotation.getEnd());
			}
		}
	}

	@Test
	public void getDocumentMultipleCatgoriesSingleCategoryCustomTags() {
		Category category = new Category();
		category.setName("disorders");
		category.setCategory("disorders");
		GetDocumentMultipleCategoriesOptions options = new GetDocumentMultipleCategoriesOptions.Builder()
				.corpus(getProperty(Constants.CORPUS)).documentId(Constants.TEST_DOCUMENT_ID)
				.highlightTagBegin("<u>").highlightTagEnd("</u>").addCategories(category).build();

		ServiceCall<MultipleCategoriesModel> sc = imlService.getDocumentMultipleCategories(options);
		Response<MultipleCategoriesModel> response = sc.execute();
		MultipleCategoriesModel model = response.getResult();
		Assert.assertNotNull(model);
		Map<String, CategoriesModel> categoriesModelMap = model.getCategoryMap();
		Set<String> categoryKeys = categoriesModelMap.keySet();
		for (String key : categoryKeys) {
			CategoriesModel categories = categoriesModelMap.get(key);
			Map<String, Map<String, Entry>> passagesModel = categories.getPassages();
			if (passagesModel != null) {
				Set<String> passageKeys = passagesModel.keySet();
				for (String passageKey : passageKeys) {
					Map<String, Entry> passageMap = passagesModel.get(passageKey);
					Set<String> keys = passageMap.keySet();
					for (String mapKey : keys) {
						Entry entry = passageMap.get(mapKey);
						Assert.assertNotNull(entry.getId());
						List<SentenceModel> sentences = entry.getSentences();
						for (SentenceModel sentence : sentences) {
							Assert.assertTrue(sentence.getBegin() > -1);
							Assert.assertTrue(sentence.getEnd() > sentence.getBegin());
							Assert.assertNotNull(sentence.getText());
							Assert.assertNotNull(sentence.getDocumentSection());
							Assert.assertTrue(sentence.getTimestamp() == 0);
						}
					}
				}
			}
		}
		Map<String, AnnotationModel> annotationModel = model.getAnnotations();
		if (annotationModel != null) {
			Set<String> keys = annotationModel.keySet();
			for (String key : keys) {
				AnnotationModel annotation = annotationModel.get(key);
				Assert.assertNotNull(annotation.getPreferredName());
				Assert.assertNotNull(annotation.getOntology());
				Assert.assertNotNull(annotation.getType());
				Assert.assertNotNull(annotation.getSection());
				Assert.assertTrue(annotation.getBegin() < annotation.getEnd());
			}
		}
	}

	@Test
	public void getDocumentMultipleCatgoriesSingleCategorySpecificFields() {
		String fields = "highlightedTitle";
		Category category = new Category();
		category.setName("disorders");
		category.setCategory("disorders");
		GetDocumentMultipleCategoriesOptions options = new GetDocumentMultipleCategoriesOptions.Builder()
				.corpus(getProperty(Constants.CORPUS)).documentId(Constants.TEST_DOCUMENT_ID)
				.addCategories(category).fields(fields).build();

		ServiceCall<MultipleCategoriesModel> sc = imlService.getDocumentMultipleCategories(options);
		Response<MultipleCategoriesModel> response = sc.execute();
		MultipleCategoriesModel model = response.getResult();
		Assert.assertNotNull(model);
		Map<String, CategoriesModel> categoriesModelMap = model.getCategoryMap();
		Set<String> categoryKeys = categoriesModelMap.keySet();
		for (String key : categoryKeys) {
			CategoriesModel categories = categoriesModelMap.get(key);
			Map<String, Map<String, Entry>> passagesModel = categories.getPassages();
			if (passagesModel != null) {
				Set<String> passageKeys = passagesModel.keySet();
				for (String passageKey : passageKeys) {
					Map<String, Entry> passageMap = passagesModel.get(passageKey);
					Set<String> keys = passageMap.keySet();
					for (String mapKey : keys) {
						Entry entry = passageMap.get(mapKey);
						Assert.assertNotNull(entry.getId());
						List<SentenceModel> sentences = entry.getSentences();
						for (SentenceModel sentence : sentences) {
							Assert.assertTrue(sentence.getBegin() > -1);
							Assert.assertTrue(sentence.getEnd() > sentence.getBegin());
							Assert.assertNotNull(sentence.getText());
							Assert.assertNotNull(sentence.getDocumentSection());
							Assert.assertTrue(sentence.getTimestamp() == 0);
						}
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
		GetDocumentMultipleCategoriesOptions options = new GetDocumentMultipleCategoriesOptions.Builder()
				.corpus(getProperty(Constants.CORPUS)).documentId(Constants.TEST_DOCUMENT_ID)
				.addCategories(category).limit(5).build();

		ServiceCall<MultipleCategoriesModel> sc = imlService.getDocumentMultipleCategories(options);
		Response<MultipleCategoriesModel> response = sc.execute();
		MultipleCategoriesModel model = response.getResult();
		Assert.assertNotNull(model);
		Map<String, CategoriesModel> categoriesModelMap = model.getCategoryMap();
		Set<String> categoryKeys = categoriesModelMap.keySet();
		for (String key : categoryKeys) {
			CategoriesModel categories = categoriesModelMap.get(key);
			Map<String, Map<String, Entry>> passagesModel = categories.getPassages();
			if (passagesModel != null) {
				Set<String> passageKeys = passagesModel.keySet();
				for (String passageKey : passageKeys) {
					Map<String, Entry> passageMap = passagesModel.get(passageKey);
					Set<String> keys = passageMap.keySet();
					for (String mapKey : keys) {
						Entry entry = passageMap.get(mapKey);
						Assert.assertNotNull(entry.getId());
						List<SentenceModel> sentences = entry.getSentences();
						for (SentenceModel sentence : sentences) {
							Assert.assertTrue(sentence.getBegin() > -1);
							Assert.assertTrue(sentence.getEnd() > sentence.getBegin());
							Assert.assertNotNull(sentence.getText());
							Assert.assertNotNull(sentence.getDocumentSection());
							Assert.assertTrue(sentence.getTimestamp() == 0);
						}
					}
				}
			}
			Map<String, AnnotationModel> annotationModel = categories.getAnnotations();
			if (annotationModel != null) {
				Set<String> keys = annotationModel.keySet();
				for (String annokey : keys) {
					AnnotationModel annotation = annotationModel.get(annokey);
					Assert.assertNotNull(annotation.getPreferredName());
					Assert.assertNotNull(annotation.getOntology());
					Assert.assertNotNull(annotation.getType());
					Assert.assertNotNull(annotation.getSection());
					Assert.assertTrue(annotation.getBegin() < annotation.getEnd());
				}
			}
		}
		Map<String, AnnotationModel> annotationModel = model.getAnnotations();
		if (annotationModel != null) {
			Set<String> keys = annotationModel.keySet();
			for (String key : keys) {
				AnnotationModel annotation = annotationModel.get(key);
				Assert.assertNotNull(annotation.getPreferredName());
				Assert.assertNotNull(annotation.getOntology());
				Assert.assertNotNull(annotation.getType());
				Assert.assertNotNull(annotation.getSection());
				Assert.assertTrue(annotation.getBegin() < annotation.getEnd());
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
		GetDocumentMultipleCategoriesOptions options = new GetDocumentMultipleCategoriesOptions.Builder()
				.corpus(getProperty(Constants.CORPUS)).documentId(Constants.TEST_DOCUMENT_ID)
				.addCategories(category).build();

		ServiceCall<MultipleCategoriesModel> sc = imlService.getDocumentMultipleCategories(options);
		Response<MultipleCategoriesModel> response = sc.execute();
		MultipleCategoriesModel model = response.getResult();
		Assert.assertNotNull(model);
		Map<String, CategoriesModel> categoriesModelMap = model.getCategoryMap();
		Set<String> categoryKeys = categoriesModelMap.keySet();
		for (String key : categoryKeys) {
			CategoriesModel categories = categoriesModelMap.get(key);
			Map<String, Map<String, Entry>> passagesModel = categories.getPassages();
			if (passagesModel != null) {
				Set<String> passageKeys = passagesModel.keySet();
				for (String passageKey : passageKeys) {
					Map<String, Entry> passageMap = passagesModel.get(passageKey);
					Set<String> keys = passageMap.keySet();
					for (String mapKey : keys) {
						Entry entry = passageMap.get(mapKey);
						Assert.assertNotNull(entry.getId());
						List<SentenceModel> sentences = entry.getSentences();
						for (SentenceModel sentence : sentences) {
							Assert.assertTrue(sentence.getBegin() > -1);
							Assert.assertTrue(sentence.getEnd() > sentence.getBegin());
							Assert.assertNotNull(sentence.getText());
							Assert.assertNotNull(sentence.getDocumentSection());
							Assert.assertTrue(sentence.getTimestamp() == 0);
						}
					}
				}
			}
		}
		Map<String, AnnotationModel> annotationModel = model.getAnnotations();
		if (annotationModel != null) {
			Set<String> keys = annotationModel.keySet();
			for (String key : keys) {
				AnnotationModel annotation = annotationModel.get(key);
				Assert.assertNotNull(annotation.getPreferredName());
				Assert.assertNotNull(annotation.getOntology());
				Assert.assertNotNull(annotation.getType());
				Assert.assertNotNull(annotation.getSection());
				Assert.assertTrue(annotation.getBegin() < annotation.getEnd());
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

		ServiceCall<MultipleCategoriesModel> sc = imlService.getDocumentMultipleCategories(options);
		Response<MultipleCategoriesModel> response = sc.execute();
		MultipleCategoriesModel model = response.getResult();
		Assert.assertNotNull(model);
		Map<String, CategoriesModel> categoriesModelMap = model.getCategoryMap();
		Set<String> categoryKeys = categoriesModelMap.keySet();
		for (String key : categoryKeys) {
			CategoriesModel categoriesModel = categoriesModelMap.get(key);
			Map<String, Map<String, Entry>> passagesModel = categoriesModel.getPassages();
			if (passagesModel != null) {
				Set<String> passageKeys = passagesModel.keySet();
				for (String passageKey : passageKeys) {
					Map<String, Entry> passageMap = passagesModel.get(passageKey);
					Set<String> keys = passageMap.keySet();
					for (String mapKey : keys) {
						Entry entry = passageMap.get(mapKey);
						Assert.assertNotNull(entry.getId());
						List<SentenceModel> sentences = entry.getSentences();
						for (SentenceModel sentence : sentences) {
							Assert.assertTrue(sentence.getBegin() > -1);
							Assert.assertTrue(sentence.getEnd() > sentence.getBegin());
							Assert.assertNotNull(sentence.getText());
							Assert.assertNotNull(sentence.getDocumentSection());
							Assert.assertTrue(sentence.getTimestamp() == 0);
						}
					}
				}
			}
		}
		Map<String, AnnotationModel> annotationModel = model.getAnnotations();
		if (annotationModel != null) {
			Set<String> keys = annotationModel.keySet();
			for (String key : keys) {
				AnnotationModel annotation = annotationModel.get(key);
				Assert.assertNotNull(annotation.getPreferredName());
				Assert.assertNotNull(annotation.getOntology());
				Assert.assertNotNull(annotation.getType());
				Assert.assertNotNull(annotation.getSection());
				Assert.assertTrue(annotation.getBegin() < annotation.getEnd());
			}
		}
	}

	@Test
	public void testGetBuilderFromOptions() {
		Category category = new Category();
		category.setName("disorders");
		category.setCategory("disorders");
		GetDocumentMultipleCategoriesOptions options = new GetDocumentMultipleCategoriesOptions.Builder()
				.corpus(getProperty(Constants.CORPUS)).documentId(Constants.TEST_DOCUMENT_ID)
				.addCategories(category).build();
		Builder builder = options.newBuilder();
		Assert.assertNotNull(builder);
	}
}
