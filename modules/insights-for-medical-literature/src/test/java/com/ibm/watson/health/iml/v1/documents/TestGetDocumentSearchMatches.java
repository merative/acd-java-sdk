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
import com.ibm.watson.health.iml.v1.model.Entry;
import com.ibm.watson.health.iml.v1.model.GetSearchMatchesOptions;
import com.ibm.watson.health.iml.v1.model.GetSearchMatchesOptions.Builder;
import com.ibm.watson.health.iml.v1.model.MatchEntry;
import com.ibm.watson.health.iml.v1.model.Passage;
import com.ibm.watson.health.iml.v1.model.Passages;
import com.ibm.watson.health.iml.v1.model.PassagesModel;
import com.ibm.watson.health.iml.v1.model.SearchMatchesModel;
import com.ibm.watson.health.iml.v1.model.SentenceModel;
import com.ibm.watson.health.iml.v1.utils.ServiceUtilities;

/**
 *
 * Class for testing
 * /v1/corpoora/{corpus}/documents/{document_id}/search_matches.
 *
 */
public class TestGetDocumentSearchMatches {
	private InsightsForMedicalLiteratureService imlService;

	public TestGetDocumentSearchMatches() {
		try {
			imlService = ServiceUtilities.getServiceInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void getDocumentSearchMatches() {
		GetSearchMatchesOptions options = new GetSearchMatchesOptions.Builder()
				.corpus(getProperty(Constants.CORPUS))
				.documentId(Constants.TEST_DOCUMENT_ID).minScore((float) 0.5)
				.build();

		ServiceCall<SearchMatchesModel> sc = imlService
				.getSearchMatches(options);
		Response<SearchMatchesModel> response = sc.execute();
		SearchMatchesModel matchesModel = response.getResult();
		Assert.assertEquals(matchesModel.getDocumentId(),
				Constants.TEST_DOCUMENT_ID);
		Assert.assertEquals(matchesModel.getExternalId(),
				Constants.TEST_DOCUMENT_ID);
		Assert.assertNotNull(matchesModel.getAuthors());
		Assert.assertNotNull(matchesModel.getPublicationName());
		Assert.assertNotNull(matchesModel.getPublicationDate());
		Assert.assertNotNull(matchesModel.getMedlineLicense());
		Assert.assertNotNull(matchesModel.getHrefPubMed());
		Assert.assertNotNull(matchesModel.getPassages());
		Assert.assertTrue(matchesModel.getAnnotations().isEmpty());
	}

	@Test
	public void getDocumentSearchMatchesForCui() {
		GetSearchMatchesOptions options = new GetSearchMatchesOptions.Builder()
				.corpus(getProperty(Constants.CORPUS))
				.documentId(Constants.TEST_DOCUMENT_ID).minScore((float) 0.5)
				.addCuis("C0017262").build();

		ServiceCall<SearchMatchesModel> sc = imlService
				.getSearchMatches(options);
		Response<SearchMatchesModel> response = sc.execute();
		SearchMatchesModel matchesModel = response.getResult();
		Assert.assertEquals(matchesModel.getDocumentId(),
				Constants.TEST_DOCUMENT_ID);
		Assert.assertEquals(matchesModel.getExternalId(),
				Constants.TEST_DOCUMENT_ID);
		Assert.assertNotNull(matchesModel.getAuthors());
		Assert.assertNotNull(matchesModel.getPublicationName());
		Assert.assertNotNull(matchesModel.getPublicationDate());
		Assert.assertNotNull(matchesModel.getMedlineLicense());
		Assert.assertNotNull(matchesModel.getHrefPubMed());
		Assert.assertNotNull(matchesModel.getHighlightedTitle());
		Assert.assertNotNull(matchesModel.getHighlightedAbstract());
		Assert.assertNotNull(matchesModel.getTitle());
		Map<String, AnnotationModel> annotationModel = matchesModel
				.getAnnotations();
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
		Map<String, PassagesModel> passagesModel = matchesModel.getPassages();
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
	public void getDocumentSearchMatchesForMultipleCuis() {
		List<String> cuis = new ArrayList<String>(2);
		cuis.add("C0017262");
		cuis.add("C0243026");
		GetSearchMatchesOptions options = new GetSearchMatchesOptions.Builder()
				.corpus(getProperty(Constants.CORPUS))
				.documentId(Constants.TEST_DOCUMENT_ID).minScore((float) 0.5)
				.cuis(cuis).build();

		ServiceCall<SearchMatchesModel> sc = imlService
				.getSearchMatches(options);
		Response<SearchMatchesModel> response = sc.execute();
		SearchMatchesModel matchesModel = response.getResult();
		Assert.assertEquals(matchesModel.getDocumentId(),
				Constants.TEST_DOCUMENT_ID);
		Assert.assertEquals(matchesModel.getExternalId(),
				Constants.TEST_DOCUMENT_ID);
		Assert.assertNotNull(matchesModel.getAuthors());
		Assert.assertNotNull(matchesModel.getPublicationName());
		Assert.assertNotNull(matchesModel.getPublicationDate());
		Assert.assertNotNull(matchesModel.getMedlineLicense());
		Assert.assertNotNull(matchesModel.getHrefPubMed());
		Assert.assertNotNull(matchesModel.getHighlightedTitle());
		Assert.assertNotNull(matchesModel.getHighlightedAbstract());
		Assert.assertNotNull(matchesModel.getTitle());
		Map<String, AnnotationModel> annotationModel = matchesModel
				.getAnnotations();
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
		Map<String, PassagesModel> passagesModel = matchesModel.getPassages();
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
	public void getDocumentSearchMatchesForCuiCustomSearchTags() {
		GetSearchMatchesOptions options = new GetSearchMatchesOptions.Builder()
				.corpus(getProperty(Constants.CORPUS))
				.documentId(Constants.TEST_DOCUMENT_ID).minScore((float) 0.5)
				.addCuis("C0017262").searchTagBegin("<u>").searchTagEnd("</u>")
				.build();

		ServiceCall<SearchMatchesModel> sc = imlService
				.getSearchMatches(options);
		Response<SearchMatchesModel> response = sc.execute();
		SearchMatchesModel matchesModel = response.getResult();
		Assert.assertEquals(matchesModel.getDocumentId(),
				Constants.TEST_DOCUMENT_ID);
		Assert.assertEquals(matchesModel.getExternalId(),
				Constants.TEST_DOCUMENT_ID);
		Assert.assertNotNull(matchesModel.getAuthors());
		Assert.assertNotNull(matchesModel.getPublicationName());
		Assert.assertNotNull(matchesModel.getPublicationDate());
		Assert.assertNotNull(matchesModel.getMedlineLicense());
		Assert.assertNotNull(matchesModel.getHrefPubMed());
		Assert.assertNotNull(matchesModel.getHighlightedTitle());
		Assert.assertNotNull(matchesModel.getHighlightedAbstract());
		Assert.assertNotNull(matchesModel.getTitle());
		Map<String, AnnotationModel> annotationModel = matchesModel
				.getAnnotations();
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
		Map<String, PassagesModel> passagesModel = matchesModel.getPassages();
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
	public void getDocumentSearchMatchesForCustomRelatedTag() {
		GetSearchMatchesOptions options = new GetSearchMatchesOptions.Builder()
				.corpus(getProperty(Constants.CORPUS))
				.documentId(Constants.TEST_DOCUMENT_ID).minScore((float) 0.5)
				.addCuis("C0017262").searchTagBegin("<i>").searchTagEnd("</i>")
				.build();

		ServiceCall<SearchMatchesModel> sc = imlService
				.getSearchMatches(options);
		Response<SearchMatchesModel> response = sc.execute();
		SearchMatchesModel matchesModel = response.getResult();
		Assert.assertEquals(matchesModel.getDocumentId(),
				Constants.TEST_DOCUMENT_ID);
		Assert.assertEquals(matchesModel.getExternalId(),
				Constants.TEST_DOCUMENT_ID);
		Assert.assertNotNull(matchesModel.getAuthors());
		Assert.assertNotNull(matchesModel.getPublicationName());
		Assert.assertNotNull(matchesModel.getPublicationDate());
		Assert.assertNotNull(matchesModel.getMedlineLicense());
		Assert.assertNotNull(matchesModel.getHrefPubMed());
		Assert.assertNotNull(matchesModel.getHighlightedTitle());
		Assert.assertNotNull(matchesModel.getHighlightedAbstract());
		Assert.assertNotNull(matchesModel.getTitle());
		Map<String, AnnotationModel> annotationModel = matchesModel
				.getAnnotations();
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
		Map<String, PassagesModel> passagesModel = matchesModel.getPassages();
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
	public void getDocumentSearchMatchesLimitedResults() {
		GetSearchMatchesOptions options = new GetSearchMatchesOptions.Builder()
				.corpus(getProperty(Constants.CORPUS))
				.documentId(Constants.TEST_DOCUMENT_ID).minScore((float) 0.5)
				.addCuis("C0017262").limit(5).build();

		ServiceCall<SearchMatchesModel> sc = imlService
				.getSearchMatches(options);
		Response<SearchMatchesModel> response = sc.execute();
		SearchMatchesModel matchesModel = response.getResult();
		Assert.assertEquals(matchesModel.getDocumentId(),
				Constants.TEST_DOCUMENT_ID);
		Assert.assertEquals(matchesModel.getExternalId(),
				Constants.TEST_DOCUMENT_ID);
		Assert.assertNotNull(matchesModel.getAuthors());
		Assert.assertNotNull(matchesModel.getPublicationName());
		Assert.assertNotNull(matchesModel.getPublicationDate());
		Assert.assertNotNull(matchesModel.getMedlineLicense());
		Assert.assertNotNull(matchesModel.getHrefPubMed());
		Assert.assertNotNull(matchesModel.getHighlightedTitle());
		Assert.assertNotNull(matchesModel.getHighlightedAbstract());
		Assert.assertNotNull(matchesModel.getTitle());
		Map<String, AnnotationModel> annotationModel = matchesModel
				.getAnnotations();
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
		Map<String, PassagesModel> passagesModel = matchesModel.getPassages();
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
	public void getDocumentSearchMatchesSpecificFields() {
		GetSearchMatchesOptions options = new GetSearchMatchesOptions.Builder()
				.corpus(getProperty(Constants.CORPUS))
				.documentId(Constants.TEST_DOCUMENT_ID).minScore((float) 0.5)
				.addCuis("C0017262").fields("highlightedAbstract").build();

		ServiceCall<SearchMatchesModel> sc = imlService
				.getSearchMatches(options);
		Response<SearchMatchesModel> response = sc.execute();
		SearchMatchesModel matchesModel = response.getResult();
		Assert.assertEquals(matchesModel.getDocumentId(),
				Constants.TEST_DOCUMENT_ID);
		Assert.assertEquals(matchesModel.getExternalId(),
				Constants.TEST_DOCUMENT_ID);
		Assert.assertNotNull(matchesModel.getAuthors());
		Assert.assertNotNull(matchesModel.getPublicationName());
		Assert.assertNotNull(matchesModel.getPublicationDate());
		Assert.assertNotNull(matchesModel.getMedlineLicense());
		Assert.assertNotNull(matchesModel.getHrefPubMed());
		Assert.assertNull(matchesModel.getHighlightedTitle());
		Assert.assertNotNull(matchesModel.getHighlightedAbstract());
		Assert.assertNotNull(matchesModel.getTitle());
		Map<String, PassagesModel> passagesModel = matchesModel.getPassages();
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

	// @Test
	// public void getDocumentSearchMatchesForMultipleCui(){
	// List<String> cuis = new ArrayList<String>(2);
	// cuis.add("C0017262");
	// cuis.add("C0007028");
	// GetSearchMatchesOptions options = new
	// GetSearchMatchesOptions.Builder().corpus(getProperty(Constants.CORPUS))
	// .documentId(Constants.TEST_DOCUMENT_ID).minScore((float) 0.5)
	// .cuis(cuis).build();
	//
	// ServiceCall<SearchMatchesModel> sc =
	// imlService.getSearchMatches(options);
	// Response<SearchMatchesModel> response = sc.execute();
	// SearchMatchesModel matchesModel = response.getResult();
	// Assert.assertEquals(matchesModel.getDocumentId(),
	// Constants.TEST_DOCUMENT_ID);
	// Assert.assertEquals(matchesModel.getExternalId(),
	// Constants.TEST_DOCUMENT_ID);
	// Assert.assertNotNull(matchesModel.getAuthors());
	// Assert.assertNotNull(matchesModel.getPublicationName());
	// Assert.assertNotNull(matchesModel.getPublicationDate());
	// Assert.assertNotNull(matchesModel.getMedlineLicense());
	// Assert.assertNotNull(matchesModel.getHrefPubMed());
	// Assert.assertNotNull(matchesModel.getHighlightedTitle());
	// Assert.assertNotNull(matchesModel.getHighlightedAbstract());
	// Assert.assertNotNull(matchesModel.getTitle());
	// Map<String, AnnotationModel> annotationModel =
	// matchesModel.getAnnotations();
	// if (annotationModel != null){
	// Set<String> keys = annotationModel.keySet();
	// for (String key : keys){
	// AnnotationModel annotation = annotationModel.get(key);
	// Assert.assertNotNull(annotation.getPreferredName());
	// Assert.assertNotNull(annotation.getOntology());
	// Assert.assertNotNull(annotation.getType());
	// Assert.assertNotNull(annotation.getSection());
	// Assert.assertTrue(annotation.getBegin() < annotation.getEnd());
	// }
	// }
	// Map<String, Map<String, Entry>> passagesModel =
	// matchesModel.getPassages();
	// if (passagesModel != null){
	// Set<String> passageKeys = passagesModel.keySet();
	// for (String passageKey : passageKeys){
	// Map<String, Entry> passageMap = passagesModel.get(passageKey);
	// Set<String> keys = passageMap.keySet();
	// for (String key : keys){
	// Entry entry = passageMap.get(key);
	// List<SentenceModel> sentences = entry.getSentences();
	// for (SentenceModel sentence : sentences){
	// Assert.assertTrue(sentence.getBegin() > -1);
	// Assert.assertTrue(sentence.getEnd() > sentence.getBegin());
	// Assert.assertNotNull(sentence.getText());
	// Assert.assertNotNull(sentence.getDocumentSection());
	// Assert.assertTrue(sentence.getTimestamp() == 0);
	// }
	// }
	// }
	// }
	// }

	@Test
	public void getDocumentSearchMatchesForText() {
		GetSearchMatchesOptions options = new GetSearchMatchesOptions.Builder()
				.corpus(getProperty(Constants.CORPUS))
				.documentId(Constants.TEST_DOCUMENT_ID).minScore((float) 0.5)
				.addText("Phylogeny").build();

		ServiceCall<SearchMatchesModel> sc = imlService
				.getSearchMatches(options);
		Response<SearchMatchesModel> response = sc.execute();
		SearchMatchesModel matchesModel = response.getResult();
		Assert.assertEquals(matchesModel.getDocumentId(),
				Constants.TEST_DOCUMENT_ID);
		Assert.assertEquals(matchesModel.getExternalId(),
				Constants.TEST_DOCUMENT_ID);
		Assert.assertNotNull(matchesModel.getAuthors());
		Assert.assertNotNull(matchesModel.getPublicationName());
		Assert.assertNotNull(matchesModel.getPublicationDate());
		Assert.assertNotNull(matchesModel.getMedlineLicense());
		Assert.assertNotNull(matchesModel.getHrefPubMed());
		Assert.assertNotNull(matchesModel.getHighlightedTitle());
		Assert.assertNotNull(matchesModel.getTitle());
		Map<String, AnnotationModel> annotationModel = matchesModel
				.getAnnotations();
		if (annotationModel != null) {
			Set<String> keys = annotationModel.keySet();
			for (String key : keys) {
				AnnotationModel annotation = annotationModel.get(key);
				Assert.assertNotNull(annotation.preferredName());
				Assert.assertNotNull(annotation.ontology());
				Assert.assertNotNull(annotation.section());
				Assert.assertTrue(annotation.begin() < annotation.end());
			}
		}
		Map<String, PassagesModel> passagesModel = matchesModel.getPassages();
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
	public void getDocumentSearchMatchesForMultipleText() {
		List<String> phrases = new ArrayList<String>(2);
		phrases.add("Phylogeny");
		phrases.add("carbonic");
		GetSearchMatchesOptions options = new GetSearchMatchesOptions.Builder()
				.corpus(getProperty(Constants.CORPUS))
				.documentId(Constants.TEST_DOCUMENT_ID).minScore((float) 0.5)
				.text(phrases).build();

		ServiceCall<SearchMatchesModel> sc = imlService
				.getSearchMatches(options);
		Response<SearchMatchesModel> response = sc.execute();
		SearchMatchesModel matchesModel = response.getResult();
		Assert.assertEquals(matchesModel.getDocumentId(),
				Constants.TEST_DOCUMENT_ID);
		Assert.assertEquals(matchesModel.getExternalId(),
				Constants.TEST_DOCUMENT_ID);
		Assert.assertNotNull(matchesModel.getAuthors());
		Assert.assertNotNull(matchesModel.getPublicationName());
		Assert.assertNotNull(matchesModel.getPublicationDate());
		Assert.assertNotNull(matchesModel.getMedlineLicense());
		Assert.assertNotNull(matchesModel.getHrefPubMed());
		Assert.assertNotNull(matchesModel.getHighlightedTitle());
		Assert.assertNotNull(matchesModel.getTitle());
		Map<String, AnnotationModel> annotationModel = matchesModel
				.getAnnotations();
		if (annotationModel != null) {
			Set<String> keys = annotationModel.keySet();
			for (String key : keys) {
				AnnotationModel annotation = annotationModel.get(key);
				Assert.assertNotNull(annotation.preferredName());
				Assert.assertNotNull(annotation.ontology());
				Assert.assertNotNull(annotation.section());
				Assert.assertTrue(annotation.begin() < annotation.end());
			}
		}
		Map<String, PassagesModel> passagesModel = matchesModel.getPassages();
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
	public void getDocumentSearchMatchesForType() {
		GetSearchMatchesOptions options = new GetSearchMatchesOptions.Builder()
				.corpus(getProperty(Constants.CORPUS))
				.documentId(Constants.TEST_DOCUMENT_ID).minScore((float) 0.5)
				.addTypes("GeneticFunction").build();

		ServiceCall<SearchMatchesModel> sc = imlService
				.getSearchMatches(options);
		Response<SearchMatchesModel> response = sc.execute();
		SearchMatchesModel matchesModel = response.getResult();
		Assert.assertEquals(matchesModel.getDocumentId(),
				Constants.TEST_DOCUMENT_ID);
		Assert.assertEquals(matchesModel.getExternalId(),
				Constants.TEST_DOCUMENT_ID);
		Assert.assertNotNull(matchesModel.getAuthors());
		Assert.assertNotNull(matchesModel.getPublicationName());
		Assert.assertNotNull(matchesModel.getPublicationDate());
		Assert.assertNotNull(matchesModel.getMedlineLicense());
		Assert.assertNotNull(matchesModel.getHrefPubMed());
		Assert.assertNotNull(matchesModel.getHighlightedTitle());
		Assert.assertNotNull(matchesModel.getHighlightedAbstract());
		Assert.assertNotNull(matchesModel.getTitle());
		Map<String, AnnotationModel> annotationModel = matchesModel
				.getAnnotations();
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
		Map<String, PassagesModel> passagesModel = matchesModel.getPassages();
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
	public void getDocumentSearchMatchesForMultipleTypes() {
		List<String> types = new ArrayList<String>(2);
		types.add("GeneticFunction");
		types.add("AminoAcidPeptideOrProtein");
		GetSearchMatchesOptions options = new GetSearchMatchesOptions.Builder()
				.corpus(getProperty(Constants.CORPUS))
				.documentId(Constants.TEST_DOCUMENT_ID).minScore((float) 0.5)
				.types(types).build();

		ServiceCall<SearchMatchesModel> sc = imlService
				.getSearchMatches(options);
		Response<SearchMatchesModel> response = sc.execute();
		SearchMatchesModel matchesModel = response.getResult();
		Assert.assertEquals(matchesModel.getDocumentId(),
				Constants.TEST_DOCUMENT_ID);
		Assert.assertEquals(matchesModel.getExternalId(),
				Constants.TEST_DOCUMENT_ID);
		Assert.assertNotNull(matchesModel.getAuthors());
		Assert.assertNotNull(matchesModel.getPublicationName());
		Assert.assertNotNull(matchesModel.getPublicationDate());
		Assert.assertNotNull(matchesModel.getMedlineLicense());
		Assert.assertNotNull(matchesModel.getHrefPubMed());
		Assert.assertNotNull(matchesModel.getTitle());
		Map<String, AnnotationModel> annotationModel = matchesModel
				.getAnnotations();
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
		Map<String, PassagesModel> passagesModel = matchesModel.getPassages();
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
	public void getDocumentSearchMatchesForAttribute() {
		GetSearchMatchesOptions options = new GetSearchMatchesOptions.Builder()
				.corpus(getProperty(Constants.CORPUS))
				.documentId(Constants.TEST_DOCUMENT_ID).minScore((float) 0.5)
				.addAttributes("body_region").build();

		ServiceCall<SearchMatchesModel> sc = imlService
				.getSearchMatches(options);
		Response<SearchMatchesModel> response = sc.execute();
		SearchMatchesModel matchesModel = response.getResult();
		Assert.assertEquals(matchesModel.getDocumentId(),
				Constants.TEST_DOCUMENT_ID);
		Assert.assertEquals(matchesModel.getExternalId(),
				Constants.TEST_DOCUMENT_ID);
		Assert.assertNotNull(matchesModel.getAuthors());
		Assert.assertNotNull(matchesModel.getPublicationName());
		Assert.assertNotNull(matchesModel.getPublicationDate());
		Assert.assertNotNull(matchesModel.getMedlineLicense());
		Assert.assertNotNull(matchesModel.getHrefPubMed());
		Assert.assertNotNull(matchesModel.getTitle());
		Map<String, AnnotationModel> annotationModel = matchesModel
				.getAnnotations();
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
		Map<String, PassagesModel> passagesModel = matchesModel.getPassages();
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
	public void getDocumentSearchMatchesForMultipleAttributes() {
		List<String> attributes = new ArrayList<String>(2);
		attributes.add("body_region");
		attributes.add("procedure");
		GetSearchMatchesOptions options = new GetSearchMatchesOptions.Builder()
				.corpus(getProperty(Constants.CORPUS))
				.documentId(Constants.TEST_DOCUMENT_ID).minScore((float) 0.5)
				.attributes(attributes).build();

		ServiceCall<SearchMatchesModel> sc = imlService
				.getSearchMatches(options);
		Response<SearchMatchesModel> response = sc.execute();
		SearchMatchesModel matchesModel = response.getResult();
		Assert.assertEquals(matchesModel.getDocumentId(),
				Constants.TEST_DOCUMENT_ID);
		Assert.assertEquals(matchesModel.getExternalId(),
				Constants.TEST_DOCUMENT_ID);
		Assert.assertNotNull(matchesModel.getAuthors());
		Assert.assertNotNull(matchesModel.getPublicationName());
		Assert.assertNotNull(matchesModel.getPublicationDate());
		Assert.assertNotNull(matchesModel.getMedlineLicense());
		Assert.assertNotNull(matchesModel.getHrefPubMed());
		Assert.assertNotNull(matchesModel.getTitle());
		Map<String, AnnotationModel> annotationModel = matchesModel
				.getAnnotations();
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
		Map<String, PassagesModel> passagesModel = matchesModel.getPassages();
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
	public void getDocumentSearchMatchesForAttributeValue() {
		GetSearchMatchesOptions options = new GetSearchMatchesOptions.Builder()
				.corpus(getProperty(Constants.CORPUS))
				.documentId(Constants.TEST_DOCUMENT_ID).minScore((float) 0.5)
				.addValues("age_group:child").build();

		ServiceCall<SearchMatchesModel> sc = imlService
				.getSearchMatches(options);
		Response<SearchMatchesModel> response = sc.execute();
		SearchMatchesModel matchesModel = response.getResult();
		Assert.assertEquals(matchesModel.getDocumentId(),
				Constants.TEST_DOCUMENT_ID);
		Assert.assertEquals(matchesModel.getExternalId(),
				Constants.TEST_DOCUMENT_ID);
		Assert.assertNotNull(matchesModel.getAuthors());
		Assert.assertNotNull(matchesModel.getPublicationName());
		Assert.assertNotNull(matchesModel.getPublicationDate());
		Assert.assertNotNull(matchesModel.getMedlineLicense());
		Assert.assertNotNull(matchesModel.getHrefPubMed());
		Assert.assertNotNull(matchesModel.getTitle());
	}

	@Test
	public void getDocumentSearchMatchesForMultipleAttributeValues() {
		List<String> values = new ArrayList<String>(2);
		values.add("age_group:child");
		values.add("smoking_status:former");
		GetSearchMatchesOptions options = new GetSearchMatchesOptions.Builder()
				.corpus(getProperty(Constants.CORPUS))
				.documentId(Constants.TEST_DOCUMENT_ID).minScore((float) 0.5)
				.values(values).build();

		ServiceCall<SearchMatchesModel> sc = imlService
				.getSearchMatches(options);
		Response<SearchMatchesModel> response = sc.execute();
		SearchMatchesModel matchesModel = response.getResult();
		Assert.assertEquals(matchesModel.getDocumentId(),
				Constants.TEST_DOCUMENT_ID);
		Assert.assertEquals(matchesModel.getExternalId(),
				Constants.TEST_DOCUMENT_ID);
		Assert.assertNotNull(matchesModel.getAuthors());
		Assert.assertNotNull(matchesModel.getPublicationName());
		Assert.assertNotNull(matchesModel.getPublicationDate());
		Assert.assertNotNull(matchesModel.getMedlineLicense());
		Assert.assertNotNull(matchesModel.getHrefPubMed());
		Assert.assertNotNull(matchesModel.getTitle());
	}

	@Test
	public void getBuilderFromOptions() {
		GetSearchMatchesOptions options = new GetSearchMatchesOptions.Builder()
				.corpus(getProperty(Constants.CORPUS))
				.documentId(Constants.TEST_DOCUMENT_ID).minScore((float) 0.5)
				.build();
		Builder builder = options.newBuilder();
		Assert.assertNotNull(builder);
	}
}
