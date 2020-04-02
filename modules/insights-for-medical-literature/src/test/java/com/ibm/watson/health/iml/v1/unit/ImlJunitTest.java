/*
 * Copyright 2018 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.ibm.watson.health.iml.v1.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.BadRequestException;
import com.ibm.cloud.sdk.core.service.exception.NotFoundException;
import com.ibm.watson.health.iml.v1.InsightsForMedicalLiteratureService;
import com.ibm.watson.health.iml.v1.WatsonServiceUnitTest;
import com.ibm.watson.health.iml.v1.model.AnnotationsModel;
import com.ibm.watson.health.iml.v1.model.CategoriesModel;
import com.ibm.watson.health.iml.v1.model.Category;
import com.ibm.watson.health.iml.v1.model.ConceptInfoModel;
import com.ibm.watson.health.iml.v1.model.ConceptListModel;
import com.ibm.watson.health.iml.v1.model.CorporaConfigModel;
import com.ibm.watson.health.iml.v1.model.CorpusInfoModel;
import com.ibm.watson.health.iml.v1.model.Documents;
import com.ibm.watson.health.iml.v1.model.GetConceptsOptions;
import com.ibm.watson.health.iml.v1.model.GetCorpusConfigOptions;
import com.ibm.watson.health.iml.v1.model.GetCuiInfoOptions;
import com.ibm.watson.health.iml.v1.model.GetDocumentAnnotationsOptions;
import com.ibm.watson.health.iml.v1.model.GetDocumentCategoriesOptions;
import com.ibm.watson.health.iml.v1.model.GetDocumentMultipleCategoriesOptions;
import com.ibm.watson.health.iml.v1.model.GetDocumentsOptions;
import com.ibm.watson.health.iml.v1.model.GetFieldsOptions;
import com.ibm.watson.health.iml.v1.model.GetSearchMatchesOptions;
import com.ibm.watson.health.iml.v1.model.MetadataModel;
import com.ibm.watson.health.iml.v1.model.MultipleCategoriesModel;
import com.ibm.watson.health.iml.v1.model.QueryConcept;
import com.ibm.watson.health.iml.v1.model.SearchMatchesModel;
import com.ibm.watson.health.iml.v1.model.SearchModel;
import com.ibm.watson.health.iml.v1.model.SearchOptions;
import com.ibm.watson.health.iml.v1.model.Typeahead;
import com.ibm.watson.health.iml.v1.model.TypeaheadOptions;
import com.ibm.watson.health.iml.v1.model.UmlsConceptInfoModel;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;

public class ImlJunitTest extends WatsonServiceUnitTest {
	protected static final String CORPORA_PATH = "/v1/corpora";

	protected static final String RESOURCE = "src/test/resources/";
	protected static final String VERSION = "2018-6-20";
	protected static final String VALID_CORPUS = "medline";
	protected static final String INVALID_CORPUS = "medline2005";

	private MockWebServer server;

	private InsightsForMedicalLiteratureService service;

	@Before
	public void setUp() throws Exception {
		server = new MockWebServer();
		server.start();

		service = new InsightsForMedicalLiteratureService(VERSION, StringUtils.chop(server.url("/").toString()));
		service.setServiceUrl(StringUtils.chop(server.url("/").toString()));
	}

	@After
	public void tearDown()  {
	}

	@Test
	public void testSDKMockIMLGetCorpusG() throws FileNotFoundException, InterruptedException {
		CorporaConfigModel mockResponse = loadFixture(RESOURCE + "testSDK_MockIML_GetCorpus_G.json",
				CorporaConfigModel.class);
		server.enqueue(jsonResponse(mockResponse));
		GetCorpusConfigOptions fOptions = new GetCorpusConfigOptions.Builder(VALID_CORPUS).build();
		final Response<CorporaConfigModel> mm = service.getCorpusConfig(fOptions).execute();
		RecordedRequest request = server.takeRequest();

		assertNotNull(mm);
	}

	@Test
	public void testSDKMockIMLGetCorpusE() throws FileNotFoundException, InterruptedException {
		String jsonInput = getStringFromInputStream(new FileInputStream(RESOURCE + "testSDK_MockIML_GetCorpus_E.json"));
		server.enqueue(new MockResponse().setBody(jsonInput).setResponseCode(400));
		Response<CorporaConfigModel> mm = null;

		try {
			GetCorpusConfigOptions fOptions = new GetCorpusConfigOptions.Builder(INVALID_CORPUS).build();
			mm = service.getCorpusConfig(fOptions).execute();
		} catch (BadRequestException bre) {
			assertEquals(400, bre.getStatusCode());
		}

		assertNull(mm);
	}

	@Test
	public void testSDKMockIMLGetFieldsG() throws FileNotFoundException, InterruptedException {
		MetadataModel mockResponse = loadFixture(RESOURCE + "testSDK_MockIML_GetFields_G.json", MetadataModel.class);
		server.enqueue(jsonResponse(mockResponse));
		GetFieldsOptions fOptions = new GetFieldsOptions.Builder(VALID_CORPUS).build();
		final Response<MetadataModel> mm = service.getFields(fOptions).execute();
		final RecordedRequest request = server.takeRequest();

		assertNotNull(mm);
	}

	@Test
	public void testSDKMockIMLGetFieldsE() throws FileNotFoundException, InterruptedException {
		String jsonInput = getStringFromInputStream(new FileInputStream(RESOURCE + "testSDK_MockIML_GetFields_E.json"));
		server.enqueue(new MockResponse().setBody(jsonInput).setResponseCode(400));
		Response<MetadataModel> mm = null;

		try {
			GetFieldsOptions fOptions = new GetFieldsOptions.Builder(INVALID_CORPUS).build();
			mm = service.getFields(fOptions).execute();
		} catch (BadRequestException bre) {
			assertEquals(400, bre.getStatusCode());
		}

		assertNull(mm);
	}

	@Test
	public void testSDKMockIMLGetConceptsG() throws FileNotFoundException, InterruptedException {
		ConceptListModel mockResponse = loadFixture(RESOURCE + "testSDK_MockIML_GetConcepts_G.json", ConceptListModel.class);
		server.enqueue(jsonResponse(mockResponse));
		GetConceptsOptions fOptions = new GetConceptsOptions.Builder(VALID_CORPUS).build();
		final Response<ConceptListModel> mm = service.getConcepts(fOptions).execute();
		final RecordedRequest request = server.takeRequest();

		assertNotNull(mm);
	}

	@Test
	public void testSDKMockIMLGetConceptsE() throws FileNotFoundException, InterruptedException {
		String jsonInput = getStringFromInputStream(new FileInputStream(RESOURCE + "testSDK_MockIML_GetConcepts_E.json"));
		server.enqueue(new MockResponse().setBody(jsonInput).setResponseCode(400));
		Response<ConceptListModel> mm = null;

		try {
			GetConceptsOptions fOptions = new GetConceptsOptions.Builder(INVALID_CORPUS).build();
			mm = service.getConcepts(fOptions).execute();
		} catch (BadRequestException bre) {
			assertEquals(400, bre.getStatusCode());
		}

		assertNull(mm);
	}

	@Test
	public void testSDKMockIMLGetCuiInfoG() throws FileNotFoundException, InterruptedException {
		UmlsConceptInfoModel mockResponse = loadFixture(RESOURCE + "testSDK_MockIML_GetCuiInfo_G.json", UmlsConceptInfoModel.class);
		server.enqueue(jsonResponse(mockResponse));

		GetCuiInfoOptions cuiOptions = new GetCuiInfoOptions.Builder(VALID_CORPUS, "C0243026").build();
		final Response<ConceptInfoModel> mm = service.getCuiInfo(cuiOptions).execute();
		final RecordedRequest request = server.takeRequest();

		assertNotNull(mm);
	}

	@Test
	public void testSDKMockIMLGetCuiInfoE() throws FileNotFoundException, InterruptedException {
		String jsonInput = getStringFromInputStream(new FileInputStream(RESOURCE + "testSDK_MockIML_GetCuiInfo_E.json"));
		server.enqueue(new MockResponse().setBody(jsonInput).setResponseCode(400));
		Response<ConceptInfoModel> mm = null;

		try {
			GetCuiInfoOptions fOptions = new GetCuiInfoOptions.Builder(VALID_CORPUS, "F").build();
			mm = service.getCuiInfo(fOptions).execute();
		} catch (BadRequestException bre) {
			assertEquals(400, bre.getStatusCode());
		}

		assertNull(mm);
	}

	@Test
	public void testSDKMockIMLGetDOcumentAnnotationsG() throws FileNotFoundException, InterruptedException {
		AnnotationsModel mockResponse = loadFixture(RESOURCE + "testSDK_MockIML_GetDocumentAnnotations_G.json", AnnotationsModel.class);
		server.enqueue(jsonResponse(mockResponse));

		GetDocumentAnnotationsOptions daOptions = new GetDocumentAnnotationsOptions.Builder(VALID_CORPUS, "7014026",
				"abstract").build();
		final Response<AnnotationsModel> mm = service.getDocumentAnnotations(daOptions).execute();
		final RecordedRequest request = server.takeRequest();

		assertNotNull(mm);
	}

	@Test
	public void testSDKMockIMLGetDocumentAnnotationsE() throws FileNotFoundException, InterruptedException {
		String jsonInput = getStringFromInputStream(new FileInputStream(RESOURCE + "testSDK_MockIML_GetDocumentAnnotations_E.json"));
		server.enqueue(new MockResponse().setBody(jsonInput).setResponseCode(404));
		Response<AnnotationsModel> mm = null;

		try {
			GetDocumentAnnotationsOptions daOptions = new GetDocumentAnnotationsOptions.Builder(VALID_CORPUS, "A",
					"abstract").build();
			mm = service.getDocumentAnnotations(daOptions).execute();
		} catch (NotFoundException bre) {
			assertEquals(404, bre.getStatusCode());
		}

		assertNull(mm);
	}

	@Test
	public void testSDKMockIMLGetDOcumentCategoriesG() throws FileNotFoundException, InterruptedException {
		CategoriesModel mockResponse = loadFixture(RESOURCE + "testSDK_MockIML_GetDocumentCategories_G.json", CategoriesModel.class);
		server.enqueue(jsonResponse(mockResponse));

		GetDocumentCategoriesOptions dcOptions = new GetDocumentCategoriesOptions.Builder(VALID_CORPUS, "7014026").highlightTagBegin("<b>").highlightTagEnd("</b>").build();
		final Response<CategoriesModel> mm = service.getDocumentCategories(dcOptions).execute();
		final RecordedRequest request = server.takeRequest();

		assertNotNull(mm);
	}

	@Test
	public void testSDKMockIMLGetDocumentCategoriesE() throws FileNotFoundException, InterruptedException {
		String jsonInput = getStringFromInputStream(new FileInputStream(RESOURCE + "testSDK_MockIML_GetDocumentCategories_E.json"));
		server.enqueue(new MockResponse().setBody(jsonInput).setResponseCode(400));
		Response<CategoriesModel> mm = null;

		try {
			GetDocumentCategoriesOptions dcOptions = new GetDocumentCategoriesOptions.Builder(VALID_CORPUS, "F").highlightTagBegin("<b>").highlightTagEnd("</b>").build();
			mm = service.getDocumentCategories(dcOptions).execute();
		} catch (BadRequestException bre) {
			assertEquals(400, bre.getStatusCode());
		}

		assertNull(mm);
	}

	@Test
	public void testSDKMockIMLGetDOcumentMultipleCategoriesG() throws FileNotFoundException, InterruptedException {
		CategoriesModel mockResponse = loadFixture(RESOURCE + "testSDK_MockIML_GetDocumentCategories_G.json", CategoriesModel.class);
		server.enqueue(jsonResponse(mockResponse));

		Category cat = new Category();
		cat.setCategory("disorders");
		cat.setName("disorders");
		List<Category> catList = new ArrayList<Category>(1);
		catList.add(cat);
		GetDocumentMultipleCategoriesOptions dmcOptions = new GetDocumentMultipleCategoriesOptions.Builder(VALID_CORPUS, "7014026").highlightTagBegin("<b>").highlightTagEnd("</b>").categories(catList).build();
		final Response<MultipleCategoriesModel> mm = service.getDocumentMultipleCategories(dmcOptions).execute();
		final RecordedRequest request = server.takeRequest();

		assertNotNull(mm);
	}

	@Test
	public void testSDKMockIMLGetDocumentMultipleCategoriesE() throws FileNotFoundException, InterruptedException {
		String jsonInput = getStringFromInputStream(new FileInputStream(RESOURCE + "testSDK_MockIML_GetDocumentCategories_E.json"));
		server.enqueue(new MockResponse().setBody(jsonInput).setResponseCode(400));
		Response<MultipleCategoriesModel> mm = null;

		try {
			Category cat = new Category();
			cat.setCategory("disorders");
			cat.setName("disorders");
			List<Category> catList = new ArrayList<Category>(1);
			catList.add(cat);
			GetDocumentMultipleCategoriesOptions dmcOptions = new GetDocumentMultipleCategoriesOptions.Builder(VALID_CORPUS, "F").highlightTagBegin("<b>").highlightTagEnd("</b>").categories(catList).build();
			mm = service.getDocumentMultipleCategories(dmcOptions).execute();
		} catch (BadRequestException bre) {
			assertEquals(400, bre.getStatusCode());
		}

		assertNull(mm);
	}

	@Test
	public void testSDKMockIMLGetSearchMatchesG() throws FileNotFoundException, InterruptedException {
		SearchMatchesModel mockResponse = loadFixture(RESOURCE + "testSDK_MockIML_GetSearchMatches_G.json", SearchMatchesModel.class);
		server.enqueue(jsonResponse(mockResponse));

		List<String> cuis = new ArrayList<String>(1);
		cuis.add("C0018787");
		String fields = "passages,annotations,highlightedTitle,highlightedAbstract";
		GetSearchMatchesOptions smOptions = new GetSearchMatchesOptions.Builder(VALID_CORPUS, "7014026", (float) 0.1)
				.cuis(cuis).searchTagBegin("<b>").searchTagEnd("</b>").relatedTagBegin("<u>").relatedTagEnd("</u>").
				fields(fields).build();
		final Response<SearchMatchesModel> mm = service.getSearchMatches(smOptions).execute();
		final RecordedRequest request = server.takeRequest();

		assertNotNull(mm);
	}

	@Test
	public void testSDKMockIMLGetSearchMatchesE() throws FileNotFoundException, InterruptedException {
		String jsonInput = getStringFromInputStream(new FileInputStream(RESOURCE + "testSDK_MockIML_GetSearchMatches_E.json"));
		server.enqueue(new MockResponse().setBody(jsonInput).setResponseCode(400));
		Response<SearchMatchesModel> mm = null;

		try {
			List<String> cuis = new ArrayList<String>(1);
			cuis.add("F");
			String fields = "passages,annotations,highlightedTitle,highlightedAbstract";
			GetSearchMatchesOptions smOptions = new GetSearchMatchesOptions.Builder(VALID_CORPUS, "7014026", (float) 0.1)
					.cuis(cuis).searchTagBegin("<b>").searchTagEnd("</b>").relatedTagBegin("<u>").relatedTagEnd("</u>").
					fields(fields).build();
			mm = service.getSearchMatches(smOptions).execute();
		} catch (BadRequestException bre) {
			assertEquals(400, bre.getStatusCode());
		}

		assertNull(mm);
	}

	@Test
	public void testSDKMockIMLGetDocumentsG() throws FileNotFoundException, InterruptedException {
		CorpusInfoModel mockResponse = loadFixture(RESOURCE + "testSDK_MockIML_GetDocuments_G.json", CorpusInfoModel.class);
		server.enqueue(jsonResponse(mockResponse));

		GetDocumentsOptions dOptions = new GetDocumentsOptions.Builder(VALID_CORPUS).build();
		final Response<CorpusInfoModel> mm = service.getDocuments(dOptions).execute();
		final RecordedRequest request = server.takeRequest();

		assertNotNull(mm);
	}

	@Test
	public void testSDKMockIMLGetDocumentsE() throws FileNotFoundException, InterruptedException {
		String jsonInput = getStringFromInputStream(new FileInputStream(RESOURCE + "testSDK_MockIML_GetDocuments_E.json"));
		server.enqueue(new MockResponse().setBody(jsonInput).setResponseCode(400));
		Response<CorpusInfoModel> mm = null;

		try {
			GetDocumentsOptions dOptions = new GetDocumentsOptions.Builder(INVALID_CORPUS).build();
			mm = service.getDocuments(dOptions).execute();
		} catch (BadRequestException bre) {
			assertEquals(400, bre.getStatusCode());
		}

		assertNull(mm);
	}

	@Test
	public void testSDKMockIMLGetTypeaheadG() throws FileNotFoundException, InterruptedException {
		ConceptListModel mockResponse = loadFixture(RESOURCE + "testSDK_MockIML_GetTypeahead_G.json", ConceptListModel.class);
		server.enqueue(jsonResponse(mockResponse));

		TypeaheadOptions taOptions = new TypeaheadOptions.Builder(VALID_CORPUS, "Sep").build();
		final Response<ConceptListModel> mm = service.typeahead(taOptions).execute();
		final RecordedRequest request = server.takeRequest();

		assertNotNull(mm);
	}

	@Test
	public void testSDKMockIMLGetTypeahedE() throws FileNotFoundException, InterruptedException {
		String jsonInput = getStringFromInputStream(new FileInputStream(RESOURCE + "testSDK_MockIML_GetTypeahead_E.json"));
		server.enqueue(new MockResponse().setBody(jsonInput).setResponseCode(400));
		Response<ConceptListModel> mm = null;

		try {
			TypeaheadOptions taOptions = new TypeaheadOptions.Builder(INVALID_CORPUS, "Sep").build();
			mm = service.typeahead(taOptions).execute();
		} catch (BadRequestException bre) {
			assertEquals(400, bre.getStatusCode());
		}

		assertNull(mm);
	}

	@Test
	public void testSDKMockIMLGetTypeaheadSearchG() throws FileNotFoundException, InterruptedException {
		SearchModel mockResponse = loadFixture(RESOURCE + "testSDK_MockIML_GetTypeaheadSearch_G.json", SearchModel.class);
		server.enqueue(jsonResponse(mockResponse));

		SearchOptions staOptions = new SearchOptions.Builder(VALID_CORPUS).build();
		Typeahead ta = new Typeahead();
		List<String> typeList = new ArrayList<String>(1);
		typeList.add("DiseaseOrSyndrome");
		ta.setLimit(20);
		ta.setOntology("UMLS");
		ta.setNoDuplicates(true);
		ta.setQuery("Sep");
		ta.setTypes(typeList);
		staOptions.returns().setTypeahead(ta);
		final Response<SearchModel> mm = service.search(staOptions).execute();
		final RecordedRequest request = server.takeRequest();

		assertNotNull(mm);
	}

	@Test
	public void testSDKMockIMLGetTypeahedSearchE() throws FileNotFoundException, InterruptedException {
		String jsonInput = getStringFromInputStream(new FileInputStream(RESOURCE + "testSDK_MockIML_GetTypeaheadSearch_E.json"));
		server.enqueue(new MockResponse().setBody(jsonInput).setResponseCode(400));
		Response<SearchModel> mm = null;

		try {
			SearchOptions staOptions = new SearchOptions.Builder(VALID_CORPUS).build();
			Typeahead ta = new Typeahead();
			List<String> typeList = new ArrayList<String>(1);
			typeList.add("DiseaseOrSyndrome");
			ta.setLimit(20);
			ta.setOntology("F");
			ta.setNoDuplicates(true);
			ta.setQuery("Sep");
			ta.setTypes(typeList);
			staOptions.returns().setTypeahead(ta);
			mm = service.search(staOptions).execute();
		} catch (BadRequestException bre) {
			assertEquals(400, bre.getStatusCode());
		}

		assertNull(mm);
	}

	@Test
	public void testSDKMockIMLGetDocumentSearchG() throws FileNotFoundException, InterruptedException {
		SearchModel mockResponse = loadFixture(RESOURCE + "testSDK_MockIML_GetDocumentSearch_G.json", SearchModel.class);
		server.enqueue(jsonResponse(mockResponse));

		SearchOptions csOptions = new SearchOptions.Builder(VALID_CORPUS).build();
		csOptions.query().setBool("\"Sepsis\"");
		List<QueryConcept> conceptList = new ArrayList<QueryConcept>(1);
		List<String> types = new ArrayList<String>(1);
		types.add("DiseaseOrSyndrome");
		QueryConcept qc = new QueryConcept();
		qc.setBool("Sepsis");
		qc.setId("C0243026");
		qc.setOntology("UMLS");
		qc.setRank("10");
		qc.setType("DiseaseOrSyndrome");
		qc.setIncludeRelated(null);
		conceptList.add(qc);
		csOptions.query().setConcepts(conceptList);
		Documents docs = new Documents();
		docs.setLimit(20);
		csOptions.returns().setDocuments(docs);
		final Response<SearchModel> mm = service.search(csOptions).execute();
		final RecordedRequest request = server.takeRequest();

		assertNotNull(mm);
	}

	@Test
	public void testSDKMockIMLGetDocumentSearchE() throws FileNotFoundException, InterruptedException {
		String jsonInput = getStringFromInputStream(new FileInputStream(RESOURCE + "testSDK_MockIML_GetDocumentSearch_E.json"));
		server.enqueue(new MockResponse().setBody(jsonInput).setResponseCode(400));
		Response<SearchModel> mm = null;

		try {
			SearchOptions csOptions = new SearchOptions.Builder(VALID_CORPUS).build();
			csOptions.query().setBool("\"Sepsis\"");
			List<QueryConcept> conceptList = new ArrayList<QueryConcept>(1);
			List<String> types = new ArrayList<String>(1);
			types.add("DiseaseOrSyndrome");
			QueryConcept qc = new QueryConcept();
			qc.setBool("Sepsis");
			qc.setId("C0243026");
			qc.setOntology("F");
			qc.setRank("10");
			qc.setType("DiseaseOrSyndrome");
			qc.setIncludeRelated(null);
			conceptList.add(qc);
			csOptions.query().setConcepts(conceptList);
			Documents docs = new Documents();
			docs.setLimit(20);
			csOptions.returns().setDocuments(docs);
			mm = service.search(csOptions).execute();
		} catch (BadRequestException bre) {
			assertEquals(400, bre.getStatusCode());
		}

		assertNull(mm);
	}
}
