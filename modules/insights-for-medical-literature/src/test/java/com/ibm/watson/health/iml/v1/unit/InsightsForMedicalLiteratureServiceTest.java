/*
 * (C) Copyright IBM Corp. 2020.
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
package com.ibm.watson.health.iml.v1.unit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.fail;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.testng.PowerMockTestCase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.EnvironmentUtils;
import com.ibm.watson.health.iml.v1.InsightsForMedicalLiteratureService;
import com.ibm.watson.health.iml.v1.model.AddArtifactOptions;
import com.ibm.watson.health.iml.v1.model.AddCorpusDocumentOptions;
import com.ibm.watson.health.iml.v1.model.AnnotationModel;
import com.ibm.watson.health.iml.v1.model.AnnotationsModel;
import com.ibm.watson.health.iml.v1.model.AttributeEntry;
import com.ibm.watson.health.iml.v1.model.CategoriesModel;
import com.ibm.watson.health.iml.v1.model.CommonDataModel;
import com.ibm.watson.health.iml.v1.model.ConceptInfoModel;
import com.ibm.watson.health.iml.v1.model.ConceptListModel;
import com.ibm.watson.health.iml.v1.model.CorporaConfig;
import com.ibm.watson.health.iml.v1.model.CorpusInfoModel;
import com.ibm.watson.health.iml.v1.model.DeleteCorpusSchemaOptions;
import com.ibm.watson.health.iml.v1.model.DictonaryEntry;
import com.ibm.watson.health.iml.v1.model.EnableCorpusSearchTrackingOptions;
import com.ibm.watson.health.iml.v1.model.GetConceptsOptions;
import com.ibm.watson.health.iml.v1.model.GetCorporaConfigOptions;
import com.ibm.watson.health.iml.v1.model.GetCorpusConfigOptions;
import com.ibm.watson.health.iml.v1.model.GetCuiInfoOptions;
import com.ibm.watson.health.iml.v1.model.GetDocumentAnnotationsOptions;
import com.ibm.watson.health.iml.v1.model.GetDocumentCategoriesOptions;
import com.ibm.watson.health.iml.v1.model.GetDocumentInfoOptions;
import com.ibm.watson.health.iml.v1.model.GetDocumentInfoResponse;
import com.ibm.watson.health.iml.v1.model.GetDocumentMultipleCategoriesOptions;
import com.ibm.watson.health.iml.v1.model.GetDocumentsOptions;
import com.ibm.watson.health.iml.v1.model.GetFieldsOptions;
import com.ibm.watson.health.iml.v1.model.GetHealthCheckStatusOptions;
import com.ibm.watson.health.iml.v1.model.GetHitCountOptions;
import com.ibm.watson.health.iml.v1.model.GetRelatedConceptsOptions;
import com.ibm.watson.health.iml.v1.model.GetSearchMatchesOptions;
import com.ibm.watson.health.iml.v1.model.GetServiceStatusOptions;
import com.ibm.watson.health.iml.v1.model.GetSimilarConceptsOptions;
import com.ibm.watson.health.iml.v1.model.GetStatisticsOptions;
import com.ibm.watson.health.iml.v1.model.HitCount;
import com.ibm.watson.health.iml.v1.model.MetadataModel;
import com.ibm.watson.health.iml.v1.model.MonitorCorpusOptions;
import com.ibm.watson.health.iml.v1.model.PossibleValues;
import com.ibm.watson.health.iml.v1.model.RelatedConceptsModel;
import com.ibm.watson.health.iml.v1.model.ReturnsModel;
import com.ibm.watson.health.iml.v1.model.SearchMatchesModel;
import com.ibm.watson.health.iml.v1.model.SearchModel;
import com.ibm.watson.health.iml.v1.model.SearchOptions;
import com.ibm.watson.health.iml.v1.model.ServiceStatus;
import com.ibm.watson.health.iml.v1.model.SetCorpusConfigOptions;
import com.ibm.watson.health.iml.v1.model.SetCorpusSchemaOptions;
import com.ibm.watson.health.iml.v1.model.StatisticsModel;
import com.ibm.watson.health.iml.v1.model.StringBuilder;
import com.ibm.watson.health.iml.v1.model.TokenizeOptions;
import com.ibm.watson.health.iml.v1.model.TypeaheadOptions;
import com.ibm.watson.health.iml.v1.utils.TestUtilities;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;

/**
 * Unit test class for the InsightsForMedicalLiteratureService service.
 */
@PrepareForTest({ EnvironmentUtils.class })
@PowerMockIgnore("javax.net.ssl.*")
public class InsightsForMedicalLiteratureServiceTest extends PowerMockTestCase {

	final HashMap<String, InputStream> mockStreamMap = TestUtilities
			.createMockStreamMap();
	final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities
			.creatMockListFileWithMetadata();

	protected MockWebServer server;
	protected InsightsForMedicalLiteratureService testService;

	// Creates a mock set of environment variables that are returned by
	// EnvironmentUtils.getenv().
	private Map<String, String> getTestProcessEnvironment() {
		Map<String, String> env = new HashMap<>();
		env.put("TESTSERVICE_AUTH_TYPE", "noAuth");
		return env;
	}

	public void constructClientService() throws Throwable {
		PowerMockito.spy(EnvironmentUtils.class);
		PowerMockito.when(EnvironmentUtils.getenv())
				.thenReturn(getTestProcessEnvironment());
		final String serviceName = "testService";
		// set mock values for global params
		String version = "testString";

		testService = InsightsForMedicalLiteratureService.newInstance(version,
				serviceName);
		String url = server.url("/").toString();
		testService.setServiceUrl(url);
	}

	/**
	 * Negative Test - construct the service with a null authenticator.
	 */
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testConstructorWithNullAuthenticator() throws Throwable {
		final String serviceName = "testService";
		// set mock values for global params
		String version = "testString";

		new InsightsForMedicalLiteratureService(version, serviceName, null);
	}

	@Test
	public void testGetVersion() throws Throwable {
		constructClientService();
		assertEquals(testService.getVersion(), "testString");
	}

	@Test
	public void testGetDocumentsWOptions() throws Throwable {
		// Schedule some responses.
		String mockResponseBody = "{\"corpusName\": \"corpusName\", \"ontologies\": [\"ontologies\"], \"descriptiveName\": \"descriptiveName\", \"bvt\": false, \"elasticsearchIndex\": \"elasticsearchIndex\"}";
		String getDocumentsPath = "/v1/corpora/testString/documents";

		server.enqueue(
				new MockResponse().setHeader("Content-type", "application/json")
						.setResponseCode(200).setBody(mockResponseBody));

		constructClientService();

		// Construct an instance of the GetDocumentsOptions model
		GetDocumentsOptions getDocumentsOptionsModel = new GetDocumentsOptions.Builder()
				.corpus("testString").build();

		// Invoke operation with valid options model (positive test)
		Response<CorpusInfoModel> response = testService
				.getDocuments(getDocumentsOptionsModel).execute();
		assertNotNull(response);
		CorpusInfoModel responseObj = response.getResult();
		assertNotNull(responseObj);

		// Verify the contents of the request
		RecordedRequest request = server.takeRequest();
		assertNotNull(request);
		assertEquals(request.getMethod(), "GET");

		// Check query
		Map<String, String> query = TestUtilities.parseQueryString(request);
		assertNotNull(query);
		// Get query params
		assertEquals(query.get("version"), "testString");
		// Check request path
		String parsedPath = TestUtilities.parseReqPath(request);
		assertEquals(parsedPath, getDocumentsPath);
	}

	// Test the getDocuments operation with null options model parameter
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testGetDocumentsNoOptions() throws Throwable {
		// construct the service
		constructClientService();

		server.enqueue(new MockResponse());

		// Invoke operation with null options model (negative test)
		testService.getDocuments(null).execute();
	}

	@Test
	public void testAddCorpusDocumentWOptions() throws Throwable {
		// Schedule some responses.
		String mockResponseBody = "";
		String addCorpusDocumentPath = "/v1/corpora/testString/documents";

		server.enqueue(new MockResponse().setResponseCode(200)
				.setBody(mockResponseBody));

		constructClientService();

		// Construct an instance of the AddCorpusDocumentOptions model
		AddCorpusDocumentOptions addCorpusDocumentOptionsModel = new AddCorpusDocumentOptions.Builder()
				.corpus("testString")
				.document(new java.util.HashMap<String, Object>() {
					{
						put("foo", "testString");
					}
				}).acdUrl("testString").apiKey("testString")
				.flowId("testString").accessToken("testString")
				.otherAnnotators(
						new ArrayList<Object>(Arrays.asList("testString")))
				.build();

		// Invoke operation with valid options model (positive test)
		Response<Void> response = testService
				.addCorpusDocument(addCorpusDocumentOptionsModel).execute();
		assertNotNull(response);
		Void responseObj = response.getResult();
		// Response does not have a return type. Check that the result is null.
		assertNull(responseObj);

		// Verify the contents of the request
		RecordedRequest request = server.takeRequest();
		assertNotNull(request);
		assertEquals(request.getMethod(), "POST");

		// Check query
		Map<String, String> query = TestUtilities.parseQueryString(request);
		assertNotNull(query);
		// Get query params
		assertEquals(query.get("version"), "testString");
		// Check request path
		String parsedPath = TestUtilities.parseReqPath(request);
		assertEquals(parsedPath, addCorpusDocumentPath);
	}

	// Test the addCorpusDocument operation with null options model parameter
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testAddCorpusDocumentNoOptions() throws Throwable {
		// construct the service
		constructClientService();

		server.enqueue(new MockResponse());

		// Invoke operation with null options model (negative test)
		testService.addCorpusDocument(null).execute();
	}

	@Test
	public void testGetDocumentInfoWOptions() throws Throwable {
		// Schedule some responses.
		String mockResponseBody = "{}";
		String getDocumentInfoPath = "/v1/corpora/testString/documents/testString";

		server.enqueue(
				new MockResponse().setHeader("Content-type", "application/json")
						.setResponseCode(200).setBody(mockResponseBody));

		constructClientService();

		// Construct an instance of the GetDocumentInfoOptions model
		GetDocumentInfoOptions getDocumentInfoOptionsModel = new GetDocumentInfoOptions.Builder()
				.corpus("testString").documentId("testString").verbose(true)
				.build();

		// Invoke operation with valid options model (positive test)
		Response<GetDocumentInfoResponse> response = testService
				.getDocumentInfo(getDocumentInfoOptionsModel).execute();
		assertNotNull(response);
		GetDocumentInfoResponse responseObj = response.getResult();
		assertNotNull(responseObj);

		// Verify the contents of the request
		RecordedRequest request = server.takeRequest();
		assertNotNull(request);
		assertEquals(request.getMethod(), "GET");

		// Check query
		Map<String, String> query = TestUtilities.parseQueryString(request);
		assertNotNull(query);
		// Get query params
		assertEquals(query.get("version"), "testString");
		assertEquals(Boolean.valueOf(query.get("verbose")),
				Boolean.valueOf(true));
		// Check request path
		String parsedPath = TestUtilities.parseReqPath(request);
		assertEquals(parsedPath, getDocumentInfoPath);
	}

	// Test the getDocumentInfo operation with null options model parameter
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testGetDocumentInfoNoOptions() throws Throwable {
		// construct the service
		constructClientService();

		server.enqueue(new MockResponse());

		// Invoke operation with null options model (negative test)
		testService.getDocumentInfo(null).execute();
	}

	@Test
	public void testGetDocumentAnnotationsWOptions() throws Throwable {
		// Schedule some responses.
		String mockResponseBody = "";
		String getDocumentAnnotationsPath = "/v1/corpora/testString/documents/testString/annotations";

		server.enqueue(new MockResponse().setResponseCode(200)
				.setBody(mockResponseBody));

		constructClientService();

		// Construct an instance of the GetDocumentAnnotationsOptions model
		GetDocumentAnnotationsOptions getDocumentAnnotationsOptionsModel = new GetDocumentAnnotationsOptions.Builder()
				.corpus("testString").documentId("testString")
				.documentSection("testString")
				.cuis(new ArrayList<String>(Arrays.asList("testString")))
				.includeText(true).build();

		// Invoke operation with valid options model (positive test)
		Response<AnnotationsModel> response = testService
				.getDocumentAnnotations(getDocumentAnnotationsOptionsModel)
				.execute();
		assertNotNull(response);
		AnnotationsModel annotationModel = response.getResult();
		// Response does not have a return type. Check that the result is null.
		assertNull(annotationModel);

		// Verify the contents of the request
		RecordedRequest request = server.takeRequest();
		assertNotNull(request);
		assertEquals(request.getMethod(), "GET");

		// Check query
		Map<String, String> query = TestUtilities.parseQueryString(request);
		assertNotNull(query);
		// Get query params
		assertEquals(query.get("version"), "testString");
		assertEquals(query.get("document_section"), "testString");
		assertEquals(Arrays.asList(query.get("cuis")),
				new ArrayList<String>(Arrays.asList("testString")));
		assertEquals(Boolean.valueOf(query.get("include_text")),
				Boolean.valueOf(true));
		// Check request path
		String parsedPath = TestUtilities.parseReqPath(request);
		assertEquals(parsedPath, getDocumentAnnotationsPath);
	}

	// Test the getDocumentAnnotations operation with null options model
	// parameter
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testGetDocumentAnnotationsNoOptions() throws Throwable {
		// construct the service
		constructClientService();

		server.enqueue(new MockResponse());

		// Invoke operation with null options model (negative test)
		testService.getDocumentAnnotations(null).execute();
	}

	@Test
	public void testGetDocumentCategoriesWOptions() throws Throwable {
		// Schedule some responses.
		String mockResponseBody = "{\"modelLicense\": \"modelLicense\", \"highlightedTitle\": \"\", \"highlightedAbstract\": \"\", \"highlightedBody\": \"\", \"highlightedSections\": {\"mapKey\": \"\"}, \"passages\": {\"mapKey\": {\"mapKey\": {\"id\": \"id\", \"negated\": false, \"sentences\": [{\"documentSection\": \"documentSection\", \"text\": {}, \"begin\": 5, \"end\": 3, \"timestamp\": 9}]}}}, \"annotations\": {\"mapKey\": {\"uniqueId\": 8, \"stickyIds\": [9], \"ontology\": \"ontology\", \"section\": \"section\", \"preferredName\": \"preferredName\", \"cui\": \"cui\", \"attributeId\": \"attributeId\", \"qualifiers\": [\"qualifiers\"], \"type\": \"type\", \"negated\": false, \"hypothetical\": true, \"unit\": \"unit\", \"minValue\": \"minValue\", \"maxValue\": \"maxValue\", \"operator\": \"operator\", \"nluSourceType\": \"nluSourceType\", \"nluRelation\": \"nluRelation\", \"nluTargetType\": \"nluTargetType\", \"nluEntityIndex\": \"nluEntityIndex\", \"nluMentionIndex\": \"nluMentionIndex\", \"nluRelationId\": \"nluRelationId\", \"nluSide\": \"nluSide\", \"begin\": 5, \"end\": 3, \"score\": 5, \"timestamp\": 9, \"features\": {\"mapKey\": \"inner\"}, \"hits\": 4}}}";
		String getDocumentCategoriesPath = "/v1/corpora/testString/documents/testString/categories";

		server.enqueue(
				new MockResponse().setHeader("Content-type", "application/json")
						.setResponseCode(200).setBody(mockResponseBody));

		constructClientService();

		// Construct an instance of the GetDocumentCategoriesOptions model
		GetDocumentCategoriesOptions getDocumentCategoriesOptionsModel = new GetDocumentCategoriesOptions.Builder()
				.corpus("testString").documentId("testString")
				.highlightTagBegin("testString").highlightTagEnd("testString")
				.types(new ArrayList<String>(Arrays.asList("testString")))
				.category("disorders").onlyNegatedConcepts(true)
				.fields("testString").limit(Long.valueOf("26")).build();

		// Invoke operation with valid options model (positive test)
		Response<CategoriesModel> response = testService
				.getDocumentCategories(getDocumentCategoriesOptionsModel)
				.execute();
		assertNotNull(response);
		CategoriesModel responseObj = response.getResult();
		assertNotNull(responseObj);

		// Verify the contents of the request
		RecordedRequest request = server.takeRequest();
		assertNotNull(request);
		assertEquals(request.getMethod(), "GET");

		// Check query
		Map<String, String> query = TestUtilities.parseQueryString(request);
		assertNotNull(query);
		// Get query params
		assertEquals(query.get("version"), "testString");
		assertEquals(query.get("highlight_tag_begin"), "testString");
		assertEquals(query.get("highlight_tag_end"), "testString");
		assertEquals(Arrays.asList(query.get("types")),
				new ArrayList<String>(Arrays.asList("testString")));
		assertEquals(query.get("category"), "disorders");
		assertEquals(Boolean.valueOf(query.get("only_negated_concepts")),
				Boolean.valueOf(true));
		assertEquals(query.get("_fields"), "testString");
		assertEquals(Long.valueOf(query.get("_limit")), Long.valueOf("26"));
		// Check request path
		String parsedPath = TestUtilities.parseReqPath(request);
		assertEquals(parsedPath, getDocumentCategoriesPath);
	}

	// Test the getDocumentCategories operation with null options model
	// parameter
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testGetDocumentCategoriesNoOptions() throws Throwable {
		// construct the service
		constructClientService();

		server.enqueue(new MockResponse());

		// Invoke operation with null options model (negative test)
		testService.getDocumentCategories(null).execute();
	}

	@Test
	public void testGetDocumentMultipleCategoriesWOptions() throws Throwable {
		// Schedule some responses.
		String mockResponseBody = "{\"modelLicense\": \"modelLicense\", \"highlightedTitle\": \"\", \"highlightedAbstract\": \"\", \"highlightedBody\": \"\", \"highlightedSections\": {\"mapKey\": \"\"}, \"passages\": {\"mapKey\": {\"mapKey\": {\"id\": \"id\", \"negated\": false, \"sentences\": [{\"documentSection\": \"documentSection\", \"text\": {}, \"begin\": 5, \"end\": 3, \"timestamp\": 9}]}}}, \"annotations\": {\"mapKey\": {\"uniqueId\": 8, \"stickyIds\": [9], \"ontology\": \"ontology\", \"section\": \"section\", \"preferredName\": \"preferredName\", \"cui\": \"cui\", \"attributeId\": \"attributeId\", \"qualifiers\": [\"qualifiers\"], \"type\": \"type\", \"negated\": false, \"hypothetical\": true, \"unit\": \"unit\", \"minValue\": \"minValue\", \"maxValue\": \"maxValue\", \"operator\": \"operator\", \"nluSourceType\": \"nluSourceType\", \"nluRelation\": \"nluRelation\", \"nluTargetType\": \"nluTargetType\", \"nluEntityIndex\": \"nluEntityIndex\", \"nluMentionIndex\": \"nluMentionIndex\", \"nluRelationId\": \"nluRelationId\", \"nluSide\": \"nluSide\", \"begin\": 5, \"end\": 3, \"score\": 5, \"timestamp\": 9, \"features\": {\"mapKey\": \"inner\"}, \"hits\": 4}}}";
		String getDocumentMultipleCategoriesPath = "/v1/corpora/testString/documents/testString/categories";

		server.enqueue(
				new MockResponse().setHeader("Content-type", "application/json")
						.setResponseCode(200).setBody(mockResponseBody));

		constructClientService();

		// Construct an instance of the AnnotationModel model
		AnnotationModel annotationModelModel = new AnnotationModel.Builder()
				.uniqueId(Long.valueOf("26"))
				.stickyIds(
						new ArrayList<Long>(Arrays.asList(Long.valueOf("26"))))
				.ontology("testString").section("testString")
				.preferredName("testString").cui("testString")
				.attributeId("testString")
				.qualifiers(new ArrayList<String>(Arrays.asList("testString")))
				.type("testString").negated(true).hypothetical(true)
				.unit("testString").minValue("testString")
				.maxValue("testString").operator("testString")
				.nluSourceType("testString").nluRelation("testString")
				.nluTargetType("testString").nluEntityIndex("testString")
				.nluMentionIndex("testString").nluRelationId("testString")
				.nluSide("testString").begin(Long.valueOf("26"))
				.end(Long.valueOf("26")).score(Float.valueOf("36.0"))
				.timestamp(Long.valueOf("26"))
				.features(new java.util.HashMap<String, String>() {
					{
						put("foo", "testString");
					}
				}).hits(Long.valueOf("26")).build();

		// Construct an instance of the StringBuilder model
		StringBuilder stringBuilderModel = new StringBuilder();

		// Construct an instance of the GetDocumentMultipleCategoriesOptions
		// model
		GetDocumentMultipleCategoriesOptions getDocumentMultipleCategoriesOptionsModel = new GetDocumentMultipleCategoriesOptions.Builder()
				.corpus("testString").documentId("testString")
				.highlightTagBegin("testString").highlightTagEnd("testString")
				.fields("testString").limit(Long.valueOf("26")).build();

		// Invoke operation with valid options model (positive test)
		Response<CategoriesModel> response = testService
				.getDocumentMultipleCategories(
						getDocumentMultipleCategoriesOptionsModel)
				.execute();
		assertNotNull(response);
		CategoriesModel responseObj = response.getResult();
		assertNotNull(responseObj);

		// Verify the contents of the request
		RecordedRequest request = server.takeRequest();
		assertNotNull(request);
		assertEquals(request.getMethod(), "POST");

		// Check query
		Map<String, String> query = TestUtilities.parseQueryString(request);
		assertNotNull(query);
		// Get query params
		assertEquals(query.get("version"), "testString");
		assertEquals(query.get("highlight_tag_begin"), "testString");
		assertEquals(query.get("highlight_tag_end"), "testString");
		assertEquals(query.get("_fields"), "testString");
		assertEquals(Long.valueOf(query.get("_limit")), Long.valueOf("26"));
		// Check request path
		String parsedPath = TestUtilities.parseReqPath(request);
		assertEquals(parsedPath, getDocumentMultipleCategoriesPath);
	}

	// Test the getDocumentMultipleCategories operation with null options model
	// parameter
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testGetDocumentMultipleCategoriesNoOptions() throws Throwable {
		// construct the service
		constructClientService();

		server.enqueue(new MockResponse());

		// Invoke operation with null options model (negative test)
		testService.getDocumentMultipleCategories(null).execute();
	}

	@Test
	public void testGetSearchMatchesWOptions() throws Throwable {
		// Schedule some responses.
		String mockResponseBody = "{\"externalId\": \"externalId\", \"documentId\": \"documentId\", \"parentDocumentId\": \"parentDocumentId\", \"publicationName\": \"publicationName\", \"publicationDate\": \"publicationDate\", \"publicationURL\": \"publicationUrl\", \"authors\": [\"authors\"], \"title\": \"title\", \"medlineLicense\": \"medlineLicense\", \"hrefPubMed\": \"hrefPubMed\", \"hrefPmc\": \"hrefPmc\", \"hrefDoi\": \"hrefDoi\", \"pdfUrl\": \"pdfUrl\", \"referenceUrl\": \"referenceUrl\", \"highlightedTitle\": \"\", \"highlightedAbstract\": \"\", \"highlightedBody\": \"\", \"highlightedSections\": {\"mapKey\": \"\"}, \"passages\": {\"mapKey\": {\"mapKey\": {\"negated\": false, \"score\": 5, \"sentences\": [{\"documentSection\": \"documentSection\", \"text\": {}, \"begin\": 5, \"end\": 3, \"timestamp\": 9}], \"id\": \"id\"}}}, \"annotations\": {\"mapKey\": {\"uniqueId\": 8, \"stickyIds\": [9], \"ontology\": \"ontology\", \"section\": \"section\", \"preferredName\": \"preferredName\", \"cui\": \"cui\", \"attributeId\": \"attributeId\", \"qualifiers\": [\"qualifiers\"], \"type\": \"type\", \"negated\": false, \"hypothetical\": true, \"unit\": \"unit\", \"minValue\": \"minValue\", \"maxValue\": \"maxValue\", \"operator\": \"operator\", \"nluSourceType\": \"nluSourceType\", \"nluRelation\": \"nluRelation\", \"nluTargetType\": \"nluTargetType\", \"nluEntityIndex\": \"nluEntityIndex\", \"nluMentionIndex\": \"nluMentionIndex\", \"nluRelationId\": \"nluRelationId\", \"nluSide\": \"nluSide\", \"begin\": 5, \"end\": 3, \"score\": 5, \"timestamp\": 9, \"features\": {\"mapKey\": \"inner\"}, \"hits\": 4}}}";
		String getSearchMatchesPath = "/v1/corpora/testString/documents/testString/search_matches";

		server.enqueue(
				new MockResponse().setHeader("Content-type", "application/json")
						.setResponseCode(200).setBody(mockResponseBody));

		constructClientService();

		// Construct an instance of the GetSearchMatchesOptions model
		GetSearchMatchesOptions getSearchMatchesOptionsModel = new GetSearchMatchesOptions.Builder()
				.corpus("testString").documentId("testString")
				.minScore(Float.valueOf("36.0"))
				.cuis(new ArrayList<String>(Arrays.asList("testString")))
				.text(new ArrayList<String>(Arrays.asList("testString")))
				.types(new ArrayList<String>(Arrays.asList("testString")))
				.attributes(new ArrayList<String>(Arrays.asList("testString")))
				.values(new ArrayList<String>(Arrays.asList("testString")))
				.nluRelations(
						new ArrayList<String>(Arrays.asList("testString")))
				.limit(Long.valueOf("26")).searchTagBegin("testString")
				.searchTagEnd("testString").relatedTagBegin("testString")
				.relatedTagEnd("testString").fields("testString").build();

		// Invoke operation with valid options model (positive test)
		Response<SearchMatchesModel> response = testService
				.getSearchMatches(getSearchMatchesOptionsModel).execute();
		assertNotNull(response);
		SearchMatchesModel responseObj = response.getResult();
		assertNotNull(responseObj);

		// Verify the contents of the request
		RecordedRequest request = server.takeRequest();
		assertNotNull(request);
		assertEquals(request.getMethod(), "GET");

		// Check query
		Map<String, String> query = TestUtilities.parseQueryString(request);
		assertNotNull(query);
		// Get query params
		assertEquals(query.get("version"), "testString");
		assertEquals(Float.valueOf(query.get("min_score")),
				Float.valueOf("36.0"));
		assertEquals(Arrays.asList(query.get("cuis")),
				new ArrayList<String>(Arrays.asList("testString")));
		assertEquals(Arrays.asList(query.get("text")),
				new ArrayList<String>(Arrays.asList("testString")));
		assertEquals(Arrays.asList(query.get("types")),
				new ArrayList<String>(Arrays.asList("testString")));
		assertEquals(Arrays.asList(query.get("attributes")),
				new ArrayList<String>(Arrays.asList("testString")));
		assertEquals(Arrays.asList(query.get("values")),
				new ArrayList<String>(Arrays.asList("testString")));
		assertEquals(Arrays.asList(query.get("nlu_relations")),
				new ArrayList<String>(Arrays.asList("testString")));
		assertEquals(Long.valueOf(query.get("_limit")), Long.valueOf("26"));
		assertEquals(query.get("search_tag_begin"), "testString");
		assertEquals(query.get("search_tag_end"), "testString");
		assertEquals(query.get("related_tag_begin"), "testString");
		assertEquals(query.get("related_tag_end"), "testString");
		assertEquals(query.get("_fields"), "testString");
		// Check request path
		String parsedPath = TestUtilities.parseReqPath(request);
		assertEquals(parsedPath, getSearchMatchesPath);
	}

	// Test the getSearchMatches operation with null options model parameter
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testGetSearchMatchesNoOptions() throws Throwable {
		// construct the service
		constructClientService();

		server.enqueue(new MockResponse());

		// Invoke operation with null options model (negative test)
		testService.getSearchMatches(null).execute();
	}

	@Test
	public void testGetCorporaConfigWOptions() throws Throwable {
		// Schedule some responses.
		String mockResponseBody = "{\"corpora\": [{\"corpusName\": \"corpusName\", \"ontologies\": [\"ontologies\"], \"descriptiveName\": \"descriptiveName\", \"bvt\": false, \"elasticsearchIndex\": \"elasticsearchIndex\"}]}";
		String getCorporaConfigPath = "/v1/corpora";

		server.enqueue(
				new MockResponse().setHeader("Content-type", "application/json")
						.setResponseCode(200).setBody(mockResponseBody));

		constructClientService();

		// Construct an instance of the GetCorporaConfigOptions model
		GetCorporaConfigOptions getCorporaConfigOptionsModel = new GetCorporaConfigOptions.Builder()
				.verbose(true).build();

		// Invoke operation with valid options model (positive test)
		Response<CorporaConfig> response = testService
				.getCorporaConfig(getCorporaConfigOptionsModel).execute();
		assertNotNull(response);
		CorporaConfig responseObj = response.getResult();
		assertNotNull(responseObj);

		// Verify the contents of the request
		RecordedRequest request = server.takeRequest();
		assertNotNull(request);
		assertEquals(request.getMethod(), "GET");

		// Check query
		Map<String, String> query = TestUtilities.parseQueryString(request);
		assertNotNull(query);
		// Get query params
		assertEquals(query.get("version"), "testString");
		assertEquals(Boolean.valueOf(query.get("verbose")),
				Boolean.valueOf(true));
		// Check request path
		String parsedPath = TestUtilities.parseReqPath(request);
		assertEquals(parsedPath, getCorporaConfigPath);
	}

	@Test
	public void testSetCorpusSchemaWOptions() throws Throwable {
		// Schedule some responses.
		String mockResponseBody = "{\"corpora\": [{\"corpusName\": \"corpusName\", \"ontologies\": [\"ontologies\"], \"descriptiveName\": \"descriptiveName\", \"bvt\": false, \"elasticsearchIndex\": \"elasticsearchIndex\"}]}";
		String setCorpusSchemaPath = "/v1/corpora";

		server.enqueue(
				new MockResponse().setHeader("Content-type", "application/json")
						.setResponseCode(200).setBody(mockResponseBody));

		constructClientService();

		// Construct an instance of the SetCorpusSchemaOptions model
		SetCorpusSchemaOptions setCorpusSchemaOptionsModel = new SetCorpusSchemaOptions.Builder()
				.enrichmentTargets(
						new ArrayList<Object>(Arrays.asList("testString")))
				.metadataFields(
						new ArrayList<Object>(Arrays.asList("testString")))
				.corpusName("testString")
				.references(new java.util.HashMap<String, Object>() {
					{
						put("foo", "testString");
					}
				}).build();

		// Invoke operation with valid options model (positive test)
		Response<CorporaConfig> response = testService
				.setCorpusSchema(setCorpusSchemaOptionsModel).execute();
		assertNotNull(response);
		CorporaConfig responseObj = response.getResult();
		assertNotNull(responseObj);

		// Verify the contents of the request
		RecordedRequest request = server.takeRequest();
		assertNotNull(request);
		assertEquals(request.getMethod(), "POST");

		// Check query
		Map<String, String> query = TestUtilities.parseQueryString(request);
		assertNotNull(query);
		// Get query params
		assertEquals(query.get("version"), "testString");
		// Check request path
		String parsedPath = TestUtilities.parseReqPath(request);
		assertEquals(parsedPath, setCorpusSchemaPath);
	}

	@Test
	public void testDeleteCorpusSchemaWOptions() throws Throwable {
		// Schedule some responses.
		String mockResponseBody = "{\"corpora\": [{\"corpusName\": \"corpusName\", \"ontologies\": [\"ontologies\"], \"descriptiveName\": \"descriptiveName\", \"bvt\": false, \"elasticsearchIndex\": \"elasticsearchIndex\"}]}";
		String deleteCorpusSchemaPath = "/v1/corpora";

		server.enqueue(
				new MockResponse().setHeader("Content-type", "application/json")
						.setResponseCode(200).setBody(mockResponseBody));

		constructClientService();

		// Construct an instance of the DeleteCorpusSchemaOptions model
		DeleteCorpusSchemaOptions deleteCorpusSchemaOptionsModel = new DeleteCorpusSchemaOptions.Builder()
				.instance("testString").build();

		// Invoke operation with valid options model (positive test)
		Response<CorporaConfig> response = testService
				.deleteCorpusSchema(deleteCorpusSchemaOptionsModel).execute();
		assertNotNull(response);
		CorporaConfig responseObj = response.getResult();
		assertNotNull(responseObj);

		// Verify the contents of the request
		RecordedRequest request = server.takeRequest();
		assertNotNull(request);
		assertEquals(request.getMethod(), "DELETE");

		// Check query
		Map<String, String> query = TestUtilities.parseQueryString(request);
		assertNotNull(query);
		// Get query params
		assertEquals(query.get("version"), "testString");
		assertEquals(query.get("instance"), "testString");
		// Check request path
		String parsedPath = TestUtilities.parseReqPath(request);
		assertEquals(parsedPath, deleteCorpusSchemaPath);
	}

	// Test the deleteCorpusSchema operation with null options model parameter
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testDeleteCorpusSchemaNoOptions() throws Throwable {
		// construct the service
		constructClientService();

		server.enqueue(new MockResponse());

		// Invoke operation with null options model (negative test)
		testService.deleteCorpusSchema(null).execute();
	}

	@Test
	public void testSetCorpusConfigWOptions() throws Throwable {
		// Schedule some responses.
		String mockResponseBody = "{\"corpora\": [{\"corpusName\": \"corpusName\", \"ontologies\": [\"ontologies\"], \"descriptiveName\": \"descriptiveName\", \"bvt\": false, \"elasticsearchIndex\": \"elasticsearchIndex\"}]}";
		String setCorpusConfigPath = "/v1/corpora/configure";

		server.enqueue(
				new MockResponse().setHeader("Content-type", "application/json")
						.setResponseCode(200).setBody(mockResponseBody));

		constructClientService();

		// Construct an instance of the SetCorpusConfigOptions model
		SetCorpusConfigOptions setCorpusConfigOptionsModel = new SetCorpusConfigOptions.Builder()
				.userName("testString").password("testString")
				.corpusUri("testString").build();

		// Invoke operation with valid options model (positive test)
		Response<CorporaConfig> response = testService
				.setCorpusConfig(setCorpusConfigOptionsModel).execute();
		assertNotNull(response);
		CorporaConfig responseObj = response.getResult();
		assertNotNull(responseObj);

		// Verify the contents of the request
		RecordedRequest request = server.takeRequest();
		assertNotNull(request);
		assertEquals(request.getMethod(), "POST");

		// Check query
		Map<String, String> query = TestUtilities.parseQueryString(request);
		assertNotNull(query);
		// Get query params
		assertEquals(query.get("version"), "testString");
		// Check request path
		String parsedPath = TestUtilities.parseReqPath(request);
		assertEquals(parsedPath, setCorpusConfigPath);
	}

	@Test
	public void testMonitorCorpusWOptions() throws Throwable {
		// Schedule some responses.
		String mockResponseBody = "";
		String monitorCorpusPath = "/v1/corpora/monitor";

		server.enqueue(new MockResponse().setResponseCode(200)
				.setBody(mockResponseBody));

		constructClientService();

		// Construct an instance of the MonitorCorpusOptions model
		MonitorCorpusOptions monitorCorpusOptionsModel = new MonitorCorpusOptions.Builder()
				.apikey("testString").build();

		// Invoke operation with valid options model (positive test)
		Response<Void> response = testService
				.monitorCorpus(monitorCorpusOptionsModel).execute();
		assertNotNull(response);
		Void responseObj = response.getResult();
		// Response does not have a return type. Check that the result is null.
		assertNull(responseObj);

		// Verify the contents of the request
		RecordedRequest request = server.takeRequest();
		assertNotNull(request);
		assertEquals(request.getMethod(), "PUT");

		// Check query
		Map<String, String> query = TestUtilities.parseQueryString(request);
		assertNotNull(query);
		// Get query params
		assertEquals(query.get("version"), "testString");
		assertEquals(query.get("apikey"), "testString");
		// Check request path
		String parsedPath = TestUtilities.parseReqPath(request);
		assertEquals(parsedPath, monitorCorpusPath);
	}

	// Test the monitorCorpus operation with null options model parameter
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testMonitorCorpusNoOptions() throws Throwable {
		// construct the service
		constructClientService();

		server.enqueue(new MockResponse());

		// Invoke operation with null options model (negative test)
		testService.monitorCorpus(null).execute();
	}

	@Test
	public void testEnableCorpusSearchTrackingWOptions() throws Throwable {
		// Schedule some responses.
		String mockResponseBody = "";
		String enableCorpusSearchTrackingPath = "/v1/corpora/tracking";

		server.enqueue(new MockResponse().setResponseCode(200)
				.setBody(mockResponseBody));

		constructClientService();

		// Construct an instance of the EnableCorpusSearchTrackingOptions model
		EnableCorpusSearchTrackingOptions enableCorpusSearchTrackingOptionsModel = new EnableCorpusSearchTrackingOptions.Builder()
				.enableTracking(true).build();

		// Invoke operation with valid options model (positive test)
		Response<Void> response = testService.enableCorpusSearchTracking(
				enableCorpusSearchTrackingOptionsModel).execute();
		assertNotNull(response);
		Void responseObj = response.getResult();
		// Response does not have a return type. Check that the result is null.
		assertNull(responseObj);

		// Verify the contents of the request
		RecordedRequest request = server.takeRequest();
		assertNotNull(request);
		assertEquals(request.getMethod(), "PUT");

		// Check query
		Map<String, String> query = TestUtilities.parseQueryString(request);
		assertNotNull(query);
		// Get query params
		assertEquals(query.get("version"), "testString");
		assertEquals(Boolean.valueOf(query.get("enable_tracking")),
				Boolean.valueOf(true));
		// Check request path
		String parsedPath = TestUtilities.parseReqPath(request);
		assertEquals(parsedPath, enableCorpusSearchTrackingPath);
	}

	@Test
	public void testGetCorpusConfigWOptions() throws Throwable {
		// Schedule some responses.
		String mockResponseBody = "{\"corpora\": [{\"corpusName\": \"corpusName\", \"ontologies\": [\"ontologies\"], \"descriptiveName\": \"descriptiveName\", \"bvt\": false, \"elasticsearchIndex\": \"elasticsearchIndex\"}]}";
		String getCorpusConfigPath = "/v1/corpora/testString";

		server.enqueue(
				new MockResponse().setHeader("Content-type", "application/json")
						.setResponseCode(200).setBody(mockResponseBody));

		constructClientService();

		// Construct an instance of the GetCorpusConfigOptions model
		GetCorpusConfigOptions getCorpusConfigOptionsModel = new GetCorpusConfigOptions.Builder()
				.corpus("testString").verbose(true).build();

		// Invoke operation with valid options model (positive test)
		Response<CorporaConfig> response = testService
				.getCorpusConfig(getCorpusConfigOptionsModel).execute();
		assertNotNull(response);
		CorporaConfig responseObj = response.getResult();
		assertNotNull(responseObj);

		// Verify the contents of the request
		RecordedRequest request = server.takeRequest();
		assertNotNull(request);
		assertEquals(request.getMethod(), "GET");

		// Check query
		Map<String, String> query = TestUtilities.parseQueryString(request);
		assertNotNull(query);
		// Get query params
		assertEquals(query.get("version"), "testString");
		assertEquals(Boolean.valueOf(query.get("verbose")),
				Boolean.valueOf(true));
		// Check request path
		String parsedPath = TestUtilities.parseReqPath(request);
		assertEquals(parsedPath, getCorpusConfigPath);
	}

	// Test the getCorpusConfig operation with null options model parameter
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testGetCorpusConfigNoOptions() throws Throwable {
		// construct the service
		constructClientService();

		server.enqueue(new MockResponse());

		// Invoke operation with null options model (negative test)
		testService.getCorpusConfig(null).execute();
	}

	@Test
	public void testGetStatisticsWOptions() throws Throwable {
		// Schedule some responses.
		String mockResponseBody = "{\"stats\": {\"mapKey\": {\"name\": \"name\", \"count\": 5, \"cumulative_usecs\": 15, \"minimum_usecs\": 12, \"maximum_usecs\": 12, \"cumulative_quantity\": 18, \"quantity_type\": \"quantityType\", \"minimum_quantity\": 15, \"maximum_quantity\": 15}}, \"corpus\": \"corpus\", \"host\": \"host\"}";
		String getStatisticsPath = "/v1/corpora/testString/statistics";

		server.enqueue(
				new MockResponse().setHeader("Content-type", "application/json")
						.setResponseCode(200).setBody(mockResponseBody));

		constructClientService();

		// Construct an instance of the GetStatisticsOptions model
		GetStatisticsOptions getStatisticsOptionsModel = new GetStatisticsOptions.Builder()
				.corpus("testString").build();

		// Invoke operation with valid options model (positive test)
		Response<StatisticsModel> response = testService
				.getStatistics(getStatisticsOptionsModel).execute();
		assertNotNull(response);
		StatisticsModel responseObj = response.getResult();
		assertNotNull(responseObj);

		// Verify the contents of the request
		RecordedRequest request = server.takeRequest();
		assertNotNull(request);
		assertEquals(request.getMethod(), "GET");

		// Check query
		Map<String, String> query = TestUtilities.parseQueryString(request);
		assertNotNull(query);
		// Get query params
		assertEquals(query.get("version"), "testString");
		// Check request path
		String parsedPath = TestUtilities.parseReqPath(request);
		assertEquals(parsedPath, getStatisticsPath);
	}

	// Test the getStatistics operation with null options model parameter
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testGetStatisticsNoOptions() throws Throwable {
		// construct the service
		constructClientService();

		server.enqueue(new MockResponse());

		// Invoke operation with null options model (negative test)
		testService.getStatistics(null).execute();
	}

	@Test
	public void testGetServiceStatusWOptions() throws Throwable {
		// Schedule some responses.
		String mockResponseBody = "{\"version\": \"version\", \"upTime\": \"upTime\", \"serviceState\": \"OK\", \"stateDetails\": \"stateDetails\", \"hostName\": \"hostName\", \"requestCount\": 12, \"maxMemoryMb\": 11, \"commitedMemoryMb\": 16, \"inUseMemoryMb\": 13, \"availableProcessors\": 19, \"concurrentRequests\": 18, \"maxConcurrentRequests\": 21, \"totalRejectedRequests\": 21, \"totalBlockedRequests\": 20}";
		String getServiceStatusPath = "/v1/status";

		server.enqueue(
				new MockResponse().setHeader("Content-type", "application/json")
						.setResponseCode(200).setBody(mockResponseBody));

		constructClientService();

		// Construct an instance of the GetServiceStatusOptions model
		GetServiceStatusOptions getServiceStatusOptionsModel = new GetServiceStatusOptions.Builder()
				.accept("application/json").format("json").livenessCheck("true")
				.build();

		// Invoke operation with valid options model (positive test)
		Response<ServiceStatus> response = testService
				.getServiceStatus(getServiceStatusOptionsModel).execute();
		assertNotNull(response);
		ServiceStatus responseObj = response.getResult();
		assertNotNull(responseObj);

		// Verify the contents of the request
		RecordedRequest request = server.takeRequest();
		assertNotNull(request);
		assertEquals(request.getMethod(), "GET");

		// Check query
		Map<String, String> query = TestUtilities.parseQueryString(request);
		assertNotNull(query);
		// Get query params
		assertEquals(query.get("format"), "json");
		assertEquals(query.get("liveness_check"), "true");
		// Check request path
		String parsedPath = TestUtilities.parseReqPath(request);
		assertEquals(parsedPath, getServiceStatusPath);
	}

	@Test
	public void testGetHealthCheckStatusWOptions() throws Throwable {
		// Schedule some responses.
		String mockResponseBody = "{\"version\": \"version\", \"upTime\": \"upTime\", \"serviceState\": \"OK\", \"stateDetails\": \"stateDetails\", \"hostName\": \"hostName\", \"requestCount\": 12, \"maxMemoryMb\": 11, \"commitedMemoryMb\": 16, \"inUseMemoryMb\": 13, \"availableProcessors\": 19, \"concurrentRequests\": 18, \"maxConcurrentRequests\": 21, \"totalRejectedRequests\": 21, \"totalBlockedRequests\": 20}";
		String getHealthCheckStatusPath = "/v1/status/health_check";

		server.enqueue(
				new MockResponse().setHeader("Content-type", "application/json")
						.setResponseCode(200).setBody(mockResponseBody));

		constructClientService();

		// Construct an instance of the GetHealthCheckStatusOptions model
		GetHealthCheckStatusOptions getHealthCheckStatusOptionsModel = new GetHealthCheckStatusOptions.Builder()
				.accept("application/json").format("json").build();

		// Invoke operation with valid options model (positive test)
		Response<ServiceStatus> response = testService
				.getHealthCheckStatus(getHealthCheckStatusOptionsModel)
				.execute();
		assertNotNull(response);
		ServiceStatus responseObj = response.getResult();
		assertNotNull(responseObj);

		// Verify the contents of the request
		RecordedRequest request = server.takeRequest();
		assertNotNull(request);
		assertEquals(request.getMethod(), "GET");

		// Check query
		Map<String, String> query = TestUtilities.parseQueryString(request);
		assertNotNull(query);
		// Get query params
		assertEquals(query.get("format"), "json");
		// Check request path
		String parsedPath = TestUtilities.parseReqPath(request);
		assertEquals(parsedPath, getHealthCheckStatusPath);
	}

	@Test
	public void testSearchWOptions() throws Throwable {
		// Schedule some responses.
		String mockResponseBody = "{\"href\": \"href\", \"pageNumber\": 10, \"get_limit\": 8, \"totalDocumentCount\": 18, \"concepts\": [{\"ontology\": \"ontology\", \"cui\": \"cui\", \"preferredName\": \"preferredName\", \"alternativeName\": \"alternativeName\", \"semanticType\": \"semanticType\", \"count\": 5, \"hitCount\": 8, \"score\": 5, \"parents\": {\"count\": 5, \"hits\": 4}, \"children\": {\"count\": 5, \"hits\": 4}, \"siblings\": {\"count\": 5, \"hits\": 4}, \"related\": {\"count\": 5, \"hits\": 4}, \"documentIds\": [\"documentIds\"], \"dataType\": \"dataType\", \"unit\": \"unit\", \"operator\": \"operator\", \"minValue\": \"minValue\", \"maxValue\": \"maxValue\", \"vocab\": \"vocab\", \"properties\": [\"xProperties\"]}], \"types\": [\"types\"], \"attributes\": [{\"attributeId\": \"attributeId\", \"displayName\": \"displayName\", \"count\": 5}], \"values\": [{\"ontology\": \"ontology\", \"cui\": \"cui\", \"preferredName\": \"preferredName\", \"alternativeName\": \"alternativeName\", \"semanticType\": \"semanticType\", \"count\": 5, \"hitCount\": 8, \"score\": 5, \"parents\": {\"count\": 5, \"hits\": 4}, \"children\": {\"count\": 5, \"hits\": 4}, \"siblings\": {\"count\": 5, \"hits\": 4}, \"related\": {\"count\": 5, \"hits\": 4}, \"documentIds\": [\"documentIds\"], \"dataType\": \"dataType\", \"unit\": \"unit\", \"operator\": \"operator\", \"minValue\": \"minValue\", \"maxValue\": \"maxValue\", \"vocab\": \"vocab\", \"properties\": [\"xProperties\"]}], \"ranges\": {\"mapKey\": {\"operator\": \"operator\", \"min\": \"min\", \"max\": \"max\", \"count\": 5}}, \"typeahead\": [{\"ontology\": \"ontology\", \"cui\": \"cui\", \"preferredName\": \"preferredName\", \"alternativeName\": \"alternativeName\", \"semanticType\": \"semanticType\", \"count\": 5, \"hitCount\": 8, \"score\": 5, \"parents\": {\"count\": 5, \"hits\": 4}, \"children\": {\"count\": 5, \"hits\": 4}, \"siblings\": {\"count\": 5, \"hits\": 4}, \"related\": {\"count\": 5, \"hits\": 4}, \"documentIds\": [\"documentIds\"], \"dataType\": \"dataType\", \"unit\": \"unit\", \"operator\": \"operator\", \"minValue\": \"minValue\", \"maxValue\": \"maxValue\", \"vocab\": \"vocab\", \"properties\": [\"xProperties\"]}], \"aggregations\": {\"mapKey\": [{\"name\": \"name\", \"documentCount\": 13}]}, \"dateHistograms\": {\"mapKey\": [{\"date\": \"date\", \"hits\": 4}]}, \"qualifiers\": [{\"id\": \"id\", \"name\": \"name\"}], \"backend\": {\"messages\": [{\"messageType\": \"expanded_request\", \"url\": \"url\", \"request\": {\"mapKey\": \"anyValue\"}, \"headers\": [\"headers\"], \"status\": 6, \"response\": {\"mapKey\": \"anyValue\"}}]}, \"expandedQuery\": {\"mapKey\": \"anyValue\"}, \"parsedBoolExpression\": {\"boolExpression\": \"boolExpression\", \"boolOperands\": [{\"boolOperand\": \"boolOperand\"}]}, \"conceptsExist\": {\"mapKey\": 5}, \"cursorId\": \"cursorId\", \"vocabs\": [\"vocabs\"], \"annotations\": {\"mapKey\": {\"unstructured\": [{\"text\": \"text\", \"data\": {\"concepts\": [{\"uniqueId\": 8, \"stickyIds\": [9], \"section\": \"section\", \"type\": \"type\", \"begin\": 5, \"end\": 3, \"coveredText\": \"coveredText\", \"cui\": \"cui\", \"preferredName\": \"preferredName\", \"source\": \"source\", \"negated\": false, \"hypothetical\": true, \"timestamp\": 9, \"attributeId\": \"attributeId\", \"qualifiers\": [\"qualifiers\"], \"unit\": \"unit\", \"minValue\": \"minValue\", \"maxValue\": \"maxValue\", \"operator\": \"operator\", \"features\": {\"mapKey\": \"inner\"}, \"nluEntityIndex\": \"nluEntityIndex\", \"nluMentionIndex\": \"nluMentionIndex\", \"nluRelationId\": \"nluRelationId\", \"nluSide\": \"nluSide\", \"nluSourceType\": \"nluSourceType\", \"nluRelation\": \"nluRelation\", \"nluTargetType\": \"nluTargetType\", \"hits\": 4}], \"attributeValues\": [{\"uniqueId\": 8, \"stickyIds\": [9], \"section\": \"section\", \"type\": \"type\", \"begin\": 5, \"end\": 3, \"coveredText\": \"coveredText\", \"cui\": \"cui\", \"preferredName\": \"preferredName\", \"source\": \"source\", \"negated\": false, \"hypothetical\": true, \"timestamp\": 9, \"attributeId\": \"attributeId\", \"qualifiers\": [\"qualifiers\"], \"unit\": \"unit\", \"minValue\": \"minValue\", \"maxValue\": \"maxValue\", \"operator\": \"operator\", \"features\": {\"mapKey\": \"inner\"}, \"nluEntityIndex\": \"nluEntityIndex\", \"nluMentionIndex\": \"nluMentionIndex\", \"nluRelationId\": \"nluRelationId\", \"nluSide\": \"nluSide\", \"nluSourceType\": \"nluSourceType\", \"nluRelation\": \"nluRelation\", \"nluTargetType\": \"nluTargetType\", \"hits\": 4}], \"relations\": [{\"relationId\": \"relationId\", \"relation\": \"relation\", \"source\": {\"section\": \"section\", \"begin\": 5, \"end\": 3, \"coveredText\": \"coveredText\", \"source\": \"source\", \"type\": \"type\"}, \"target\": {\"section\": \"section\", \"begin\": 5, \"end\": 3, \"coveredText\": \"coveredText\", \"source\": \"source\", \"type\": \"type\"}}], \"mesh\": [{\"uniqueId\": 8, \"stickyIds\": [9], \"section\": \"section\", \"type\": \"type\", \"begin\": 5, \"end\": 3, \"coveredText\": \"coveredText\", \"cui\": \"cui\", \"preferredName\": \"preferredName\", \"source\": \"source\", \"negated\": false, \"hypothetical\": true, \"timestamp\": 9, \"attributeId\": \"attributeId\", \"qualifiers\": [\"qualifiers\"], \"unit\": \"unit\", \"minValue\": \"minValue\", \"maxValue\": \"maxValue\", \"operator\": \"operator\", \"features\": {\"mapKey\": \"inner\"}, \"nluEntityIndex\": \"nluEntityIndex\", \"nluMentionIndex\": \"nluMentionIndex\", \"nluRelationId\": \"nluRelationId\", \"nluSide\": \"nluSide\", \"nluSourceType\": \"nluSourceType\", \"nluRelation\": \"nluRelation\", \"nluTargetType\": \"nluTargetType\", \"hits\": 4}], \"text\": [{\"uniqueId\": 8, \"stickyIds\": [9], \"section\": \"section\", \"type\": \"type\", \"begin\": 5, \"end\": 3, \"coveredText\": \"coveredText\", \"cui\": \"cui\", \"preferredName\": \"preferredName\", \"source\": \"source\", \"negated\": false, \"hypothetical\": true, \"timestamp\": 9, \"attributeId\": \"attributeId\", \"qualifiers\": [\"qualifiers\"], \"unit\": \"unit\", \"minValue\": \"minValue\", \"maxValue\": \"maxValue\", \"operator\": \"operator\", \"features\": {\"mapKey\": \"inner\"}, \"nluEntityIndex\": \"nluEntityIndex\", \"nluMentionIndex\": \"nluMentionIndex\", \"nluRelationId\": \"nluRelationId\", \"nluSide\": \"nluSide\", \"nluSourceType\": \"nluSourceType\", \"nluRelation\": \"nluRelation\", \"nluTargetType\": \"nluTargetType\", \"hits\": 4}]}}]}}, \"metadata\": {\"corpus\": \"corpus\", \"corpusDescription\": \"corpusDescription\", \"fields\": {\"mapKey\": [\"inner\"]}}, \"documents\": [{\"documentId\": \"documentId\", \"title\": \"title\", \"metadata\": {\"mapKey\": [\"inner\"]}, \"sectionName\": \"sectionName\", \"sectionId\": \"sectionId\", \"corpus\": \"corpus\", \"links\": {\"hrefSearchMatches\": \"hrefSearchMatches\", \"hrefCategories\": \"hrefCategories\"}, \"passages\": {\"allPassages\": [{\"documentSection\": \"documentSection\", \"text\": {}, \"timestamp\": 9, \"preferredName\": \"preferredName\"}], \"searchTermToPassages\": {\"mapKey\": [{\"documentSection\": \"documentSection\", \"text\": {}, \"timestamp\": 9, \"preferredName\": \"preferredName\"}]}}, \"annotations\": {\"mapKey\": {\"uniqueId\": 8, \"stickyIds\": [9], \"ontology\": \"ontology\", \"section\": \"section\", \"preferredName\": \"preferredName\", \"cui\": \"cui\", \"attributeId\": \"attributeId\", \"qualifiers\": [\"qualifiers\"], \"type\": \"type\", \"negated\": false, \"hypothetical\": true, \"unit\": \"unit\", \"minValue\": \"minValue\", \"maxValue\": \"maxValue\", \"operator\": \"operator\", \"nluSourceType\": \"nluSourceType\", \"nluRelation\": \"nluRelation\", \"nluTargetType\": \"nluTargetType\", \"nluEntityIndex\": \"nluEntityIndex\", \"nluMentionIndex\": \"nluMentionIndex\", \"nluRelationId\": \"nluRelationId\", \"nluSide\": \"nluSide\", \"begin\": 5, \"end\": 3, \"score\": 5, \"timestamp\": 9, \"features\": {\"mapKey\": \"inner\"}, \"hits\": 4}}}], \"subQueries\": [{\"href\": \"href\", \"pageNumber\": 10, \"get_limit\": 8, \"totalDocumentCount\": 18, \"concepts\": [{\"ontology\": \"ontology\", \"cui\": \"cui\", \"preferredName\": \"preferredName\", \"alternativeName\": \"alternativeName\", \"semanticType\": \"semanticType\", \"count\": 5, \"hitCount\": 8, \"score\": 5, \"parents\": {\"count\": 5, \"hits\": 4}, \"children\": {\"count\": 5, \"hits\": 4}, \"siblings\": {\"count\": 5, \"hits\": 4}, \"related\": {\"count\": 5, \"hits\": 4}, \"documentIds\": [\"documentIds\"], \"dataType\": \"dataType\", \"unit\": \"unit\", \"operator\": \"operator\", \"minValue\": \"minValue\", \"maxValue\": \"maxValue\", \"vocab\": \"vocab\", \"properties\": [\"xProperties\"]}], \"types\": [\"types\"], \"attributes\": [{\"attributeId\": \"attributeId\", \"displayName\": \"displayName\", \"count\": 5}], \"values\": [{\"ontology\": \"ontology\", \"cui\": \"cui\", \"preferredName\": \"preferredName\", \"alternativeName\": \"alternativeName\", \"semanticType\": \"semanticType\", \"count\": 5, \"hitCount\": 8, \"score\": 5, \"parents\": {\"count\": 5, \"hits\": 4}, \"children\": {\"count\": 5, \"hits\": 4}, \"siblings\": {\"count\": 5, \"hits\": 4}, \"related\": {\"count\": 5, \"hits\": 4}, \"documentIds\": [\"documentIds\"], \"dataType\": \"dataType\", \"unit\": \"unit\", \"operator\": \"operator\", \"minValue\": \"minValue\", \"maxValue\": \"maxValue\", \"vocab\": \"vocab\", \"properties\": [\"xProperties\"]}], \"ranges\": {\"mapKey\": {\"operator\": \"operator\", \"min\": \"min\", \"max\": \"max\", \"count\": 5}}, \"typeahead\": [{\"ontology\": \"ontology\", \"cui\": \"cui\", \"preferredName\": \"preferredName\", \"alternativeName\": \"alternativeName\", \"semanticType\": \"semanticType\", \"count\": 5, \"hitCount\": 8, \"score\": 5, \"parents\": {\"count\": 5, \"hits\": 4}, \"children\": {\"count\": 5, \"hits\": 4}, \"siblings\": {\"count\": 5, \"hits\": 4}, \"related\": {\"count\": 5, \"hits\": 4}, \"documentIds\": [\"documentIds\"], \"dataType\": \"dataType\", \"unit\": \"unit\", \"operator\": \"operator\", \"minValue\": \"minValue\", \"maxValue\": \"maxValue\", \"vocab\": \"vocab\", \"properties\": [\"xProperties\"]}], \"aggregations\": {\"mapKey\": [{\"name\": \"name\", \"documentCount\": 13}]}, \"dateHistograms\": {\"mapKey\": [{\"date\": \"date\", \"hits\": 4}]}, \"qualifiers\": [{\"id\": \"id\", \"name\": \"name\"}], \"backend\": {\"messages\": [{\"messageType\": \"expanded_request\", \"url\": \"url\", \"request\": {\"mapKey\": \"anyValue\"}, \"headers\": [\"headers\"], \"status\": 6, \"response\": {\"mapKey\": \"anyValue\"}}]}, \"expandedQuery\": {\"mapKey\": \"anyValue\"}, \"parsedBoolExpression\": {\"boolExpression\": \"boolExpression\", \"boolOperands\": [{\"boolOperand\": \"boolOperand\"}]}, \"conceptsExist\": {\"mapKey\": 5}, \"cursorId\": \"cursorId\", \"vocabs\": [\"vocabs\"], \"annotations\": {\"mapKey\": {\"unstructured\": [{\"text\": \"text\", \"data\": {\"concepts\": [{\"uniqueId\": 8, \"stickyIds\": [9], \"section\": \"section\", \"type\": \"type\", \"begin\": 5, \"end\": 3, \"coveredText\": \"coveredText\", \"cui\": \"cui\", \"preferredName\": \"preferredName\", \"source\": \"source\", \"negated\": false, \"hypothetical\": true, \"timestamp\": 9, \"attributeId\": \"attributeId\", \"qualifiers\": [\"qualifiers\"], \"unit\": \"unit\", \"minValue\": \"minValue\", \"maxValue\": \"maxValue\", \"operator\": \"operator\", \"features\": {\"mapKey\": \"inner\"}, \"nluEntityIndex\": \"nluEntityIndex\", \"nluMentionIndex\": \"nluMentionIndex\", \"nluRelationId\": \"nluRelationId\", \"nluSide\": \"nluSide\", \"nluSourceType\": \"nluSourceType\", \"nluRelation\": \"nluRelation\", \"nluTargetType\": \"nluTargetType\", \"hits\": 4}], \"attributeValues\": [{\"uniqueId\": 8, \"stickyIds\": [9], \"section\": \"section\", \"type\": \"type\", \"begin\": 5, \"end\": 3, \"coveredText\": \"coveredText\", \"cui\": \"cui\", \"preferredName\": \"preferredName\", \"source\": \"source\", \"negated\": false, \"hypothetical\": true, \"timestamp\": 9, \"attributeId\": \"attributeId\", \"qualifiers\": [\"qualifiers\"], \"unit\": \"unit\", \"minValue\": \"minValue\", \"maxValue\": \"maxValue\", \"operator\": \"operator\", \"features\": {\"mapKey\": \"inner\"}, \"nluEntityIndex\": \"nluEntityIndex\", \"nluMentionIndex\": \"nluMentionIndex\", \"nluRelationId\": \"nluRelationId\", \"nluSide\": \"nluSide\", \"nluSourceType\": \"nluSourceType\", \"nluRelation\": \"nluRelation\", \"nluTargetType\": \"nluTargetType\", \"hits\": 4}], \"relations\": [{\"relationId\": \"relationId\", \"relation\": \"relation\", \"source\": {\"section\": \"section\", \"begin\": 5, \"end\": 3, \"coveredText\": \"coveredText\", \"source\": \"source\", \"type\": \"type\"}, \"target\": {\"section\": \"section\", \"begin\": 5, \"end\": 3, \"coveredText\": \"coveredText\", \"source\": \"source\", \"type\": \"type\"}}], \"mesh\": [{\"uniqueId\": 8, \"stickyIds\": [9], \"section\": \"section\", \"type\": \"type\", \"begin\": 5, \"end\": 3, \"coveredText\": \"coveredText\", \"cui\": \"cui\", \"preferredName\": \"preferredName\", \"source\": \"source\", \"negated\": false, \"hypothetical\": true, \"timestamp\": 9, \"attributeId\": \"attributeId\", \"qualifiers\": [\"qualifiers\"], \"unit\": \"unit\", \"minValue\": \"minValue\", \"maxValue\": \"maxValue\", \"operator\": \"operator\", \"features\": {\"mapKey\": \"inner\"}, \"nluEntityIndex\": \"nluEntityIndex\", \"nluMentionIndex\": \"nluMentionIndex\", \"nluRelationId\": \"nluRelationId\", \"nluSide\": \"nluSide\", \"nluSourceType\": \"nluSourceType\", \"nluRelation\": \"nluRelation\", \"nluTargetType\": \"nluTargetType\", \"hits\": 4}], \"text\": [{\"uniqueId\": 8, \"stickyIds\": [9], \"section\": \"section\", \"type\": \"type\", \"begin\": 5, \"end\": 3, \"coveredText\": \"coveredText\", \"cui\": \"cui\", \"preferredName\": \"preferredName\", \"source\": \"source\", \"negated\": false, \"hypothetical\": true, \"timestamp\": 9, \"attributeId\": \"attributeId\", \"qualifiers\": [\"qualifiers\"], \"unit\": \"unit\", \"minValue\": \"minValue\", \"maxValue\": \"maxValue\", \"operator\": \"operator\", \"features\": {\"mapKey\": \"inner\"}, \"nluEntityIndex\": \"nluEntityIndex\", \"nluMentionIndex\": \"nluMentionIndex\", \"nluRelationId\": \"nluRelationId\", \"nluSide\": \"nluSide\", \"nluSourceType\": \"nluSourceType\", \"nluRelation\": \"nluRelation\", \"nluTargetType\": \"nluTargetType\", \"hits\": 4}]}}]}}, \"metadata\": {\"corpus\": \"corpus\", \"corpusDescription\": \"corpusDescription\", \"fields\": {\"mapKey\": [\"inner\"]}}, \"documents\": [{\"documentId\": \"documentId\", \"title\": \"title\", \"metadata\": {\"mapKey\": [\"inner\"]}, \"sectionName\": \"sectionName\", \"sectionId\": \"sectionId\", \"corpus\": \"corpus\", \"links\": {\"hrefSearchMatches\": \"hrefSearchMatches\", \"hrefCategories\": \"hrefCategories\"}, \"passages\": {\"allPassages\": [{\"documentSection\": \"documentSection\", \"text\": {}, \"timestamp\": 9, \"preferredName\": \"preferredName\"}], \"searchTermToPassages\": {\"mapKey\": [{\"documentSection\": \"documentSection\", \"text\": {}, \"timestamp\": 9, \"preferredName\": \"preferredName\"}]}}, \"annotations\": {\"mapKey\": {\"uniqueId\": 8, \"stickyIds\": [9], \"ontology\": \"ontology\", \"section\": \"section\", \"preferredName\": \"preferredName\", \"cui\": \"cui\", \"attributeId\": \"attributeId\", \"qualifiers\": [\"qualifiers\"], \"type\": \"type\", \"negated\": false, \"hypothetical\": true, \"unit\": \"unit\", \"minValue\": \"minValue\", \"maxValue\": \"maxValue\", \"operator\": \"operator\", \"nluSourceType\": \"nluSourceType\", \"nluRelation\": \"nluRelation\", \"nluTargetType\": \"nluTargetType\", \"nluEntityIndex\": \"nluEntityIndex\", \"nluMentionIndex\": \"nluMentionIndex\", \"nluRelationId\": \"nluRelationId\", \"nluSide\": \"nluSide\", \"begin\": 5, \"end\": 3, \"score\": 5, \"timestamp\": 9, \"features\": {\"mapKey\": \"inner\"}, \"hits\": 4}}}], \"subQueries\": [{\"href\": \"href\", \"pageNumber\": 10, \"get_limit\": 8, \"totalDocumentCount\": 18, \"concepts\": [{\"ontology\": \"ontology\", \"cui\": \"cui\", \"preferredName\": \"preferredName\", \"alternativeName\": \"alternativeName\", \"semanticType\": \"semanticType\", \"count\": 5, \"hitCount\": 8, \"score\": 5, \"parents\": {\"count\": 5, \"hits\": 4}, \"children\": {\"count\": 5, \"hits\": 4}, \"siblings\": {\"count\": 5, \"hits\": 4}, \"related\": {\"count\": 5, \"hits\": 4}, \"documentIds\": [\"documentIds\"], \"dataType\": \"dataType\", \"unit\": \"unit\", \"operator\": \"operator\", \"minValue\": \"minValue\", \"maxValue\": \"maxValue\", \"vocab\": \"vocab\", \"properties\": [\"xProperties\"]}], \"types\": [\"types\"], \"attributes\": [{\"attributeId\": \"attributeId\", \"displayName\": \"displayName\", \"count\": 5}], \"values\": [{\"ontology\": \"ontology\", \"cui\": \"cui\", \"preferredName\": \"preferredName\", \"alternativeName\": \"alternativeName\", \"semanticType\": \"semanticType\", \"count\": 5, \"hitCount\": 8, \"score\": 5, \"parents\": {\"count\": 5, \"hits\": 4}, \"children\": {\"count\": 5, \"hits\": 4}, \"siblings\": {\"count\": 5, \"hits\": 4}, \"related\": {\"count\": 5, \"hits\": 4}, \"documentIds\": [\"documentIds\"], \"dataType\": \"dataType\", \"unit\": \"unit\", \"operator\": \"operator\", \"minValue\": \"minValue\", \"maxValue\": \"maxValue\", \"vocab\": \"vocab\", \"properties\": [\"xProperties\"]}], \"ranges\": {\"mapKey\": {\"operator\": \"operator\", \"min\": \"min\", \"max\": \"max\", \"count\": 5}}, \"typeahead\": [{\"ontology\": \"ontology\", \"cui\": \"cui\", \"preferredName\": \"preferredName\", \"alternativeName\": \"alternativeName\", \"semanticType\": \"semanticType\", \"count\": 5, \"hitCount\": 8, \"score\": 5, \"parents\": {\"count\": 5, \"hits\": 4}, \"children\": {\"count\": 5, \"hits\": 4}, \"siblings\": {\"count\": 5, \"hits\": 4}, \"related\": {\"count\": 5, \"hits\": 4}, \"documentIds\": [\"documentIds\"], \"dataType\": \"dataType\", \"unit\": \"unit\", \"operator\": \"operator\", \"minValue\": \"minValue\", \"maxValue\": \"maxValue\", \"vocab\": \"vocab\", \"properties\": [\"xProperties\"]}], \"aggregations\": {\"mapKey\": [{\"name\": \"name\", \"documentCount\": 13}]}, \"dateHistograms\": {\"mapKey\": [{\"date\": \"date\", \"hits\": 4}]}, \"qualifiers\": [{\"id\": \"id\", \"name\": \"name\"}], \"backend\": {\"messages\": [{\"messageType\": \"expanded_request\", \"url\": \"url\", \"request\": {\"mapKey\": \"anyValue\"}, \"headers\": [\"headers\"], \"status\": 6, \"response\": {\"mapKey\": \"anyValue\"}}]}, \"expandedQuery\": {\"mapKey\": \"anyValue\"}, \"parsedBoolExpression\": {\"boolExpression\": \"boolExpression\", \"boolOperands\": [{\"boolOperand\": \"boolOperand\"}]}, \"conceptsExist\": {\"mapKey\": 5}, \"cursorId\": \"cursorId\", \"vocabs\": [\"vocabs\"], \"annotations\": {\"mapKey\": {\"unstructured\": [{\"text\": \"text\", \"data\": {\"concepts\": [{\"uniqueId\": 8, \"stickyIds\": [9], \"section\": \"section\", \"type\": \"type\", \"begin\": 5, \"end\": 3, \"coveredText\": \"coveredText\", \"cui\": \"cui\", \"preferredName\": \"preferredName\", \"source\": \"source\", \"negated\": false, \"hypothetical\": true, \"timestamp\": 9, \"attributeId\": \"attributeId\", \"qualifiers\": [\"qualifiers\"], \"unit\": \"unit\", \"minValue\": \"minValue\", \"maxValue\": \"maxValue\", \"operator\": \"operator\", \"features\": {\"mapKey\": \"inner\"}, \"nluEntityIndex\": \"nluEntityIndex\", \"nluMentionIndex\": \"nluMentionIndex\", \"nluRelationId\": \"nluRelationId\", \"nluSide\": \"nluSide\", \"nluSourceType\": \"nluSourceType\", \"nluRelation\": \"nluRelation\", \"nluTargetType\": \"nluTargetType\", \"hits\": 4}], \"attributeValues\": [{\"uniqueId\": 8, \"stickyIds\": [9], \"section\": \"section\", \"type\": \"type\", \"begin\": 5, \"end\": 3, \"coveredText\": \"coveredText\", \"cui\": \"cui\", \"preferredName\": \"preferredName\", \"source\": \"source\", \"negated\": false, \"hypothetical\": true, \"timestamp\": 9, \"attributeId\": \"attributeId\", \"qualifiers\": [\"qualifiers\"], \"unit\": \"unit\", \"minValue\": \"minValue\", \"maxValue\": \"maxValue\", \"operator\": \"operator\", \"features\": {\"mapKey\": \"inner\"}, \"nluEntityIndex\": \"nluEntityIndex\", \"nluMentionIndex\": \"nluMentionIndex\", \"nluRelationId\": \"nluRelationId\", \"nluSide\": \"nluSide\", \"nluSourceType\": \"nluSourceType\", \"nluRelation\": \"nluRelation\", \"nluTargetType\": \"nluTargetType\", \"hits\": 4}], \"relations\": [{\"relationId\": \"relationId\", \"relation\": \"relation\", \"source\": {\"section\": \"section\", \"begin\": 5, \"end\": 3, \"coveredText\": \"coveredText\", \"source\": \"source\", \"type\": \"type\"}, \"target\": {\"section\": \"section\", \"begin\": 5, \"end\": 3, \"coveredText\": \"coveredText\", \"source\": \"source\", \"type\": \"type\"}}], \"mesh\": [{\"uniqueId\": 8, \"stickyIds\": [9], \"section\": \"section\", \"type\": \"type\", \"begin\": 5, \"end\": 3, \"coveredText\": \"coveredText\", \"cui\": \"cui\", \"preferredName\": \"preferredName\", \"source\": \"source\", \"negated\": false, \"hypothetical\": true, \"timestamp\": 9, \"attributeId\": \"attributeId\", \"qualifiers\": [\"qualifiers\"], \"unit\": \"unit\", \"minValue\": \"minValue\", \"maxValue\": \"maxValue\", \"operator\": \"operator\", \"features\": {\"mapKey\": \"inner\"}, \"nluEntityIndex\": \"nluEntityIndex\", \"nluMentionIndex\": \"nluMentionIndex\", \"nluRelationId\": \"nluRelationId\", \"nluSide\": \"nluSide\", \"nluSourceType\": \"nluSourceType\", \"nluRelation\": \"nluRelation\", \"nluTargetType\": \"nluTargetType\", \"hits\": 4}], \"text\": [{\"uniqueId\": 8, \"stickyIds\": [9], \"section\": \"section\", \"type\": \"type\", \"begin\": 5, \"end\": 3, \"coveredText\": \"coveredText\", \"cui\": \"cui\", \"preferredName\": \"preferredName\", \"source\": \"source\", \"negated\": false, \"hypothetical\": true, \"timestamp\": 9, \"attributeId\": \"attributeId\", \"qualifiers\": [\"qualifiers\"], \"unit\": \"unit\", \"minValue\": \"minValue\", \"maxValue\": \"maxValue\", \"operator\": \"operator\", \"features\": {\"mapKey\": \"inner\"}, \"nluEntityIndex\": \"nluEntityIndex\", \"nluMentionIndex\": \"nluMentionIndex\", \"nluRelationId\": \"nluRelationId\", \"nluSide\": \"nluSide\", \"nluSourceType\": \"nluSourceType\", \"nluRelation\": \"nluRelation\", \"nluTargetType\": \"nluTargetType\", \"hits\": 4}]}}]}}, \"metadata\": {\"corpus\": \"corpus\", \"corpusDescription\": \"corpusDescription\", \"fields\": {\"mapKey\": [\"inner\"]}}, \"documents\": [{\"documentId\": \"documentId\", \"title\": \"title\", \"metadata\": {\"mapKey\": [\"inner\"]}, \"sectionName\": \"sectionName\", \"sectionId\": \"sectionId\", \"corpus\": \"corpus\", \"links\": {\"hrefSearchMatches\": \"hrefSearchMatches\", \"hrefCategories\": \"hrefCategories\"}, \"passages\": {\"allPassages\": [{\"documentSection\": \"documentSection\", \"text\": {}, \"timestamp\": 9, \"preferredName\": \"preferredName\"}], \"searchTermToPassages\": {\"mapKey\": [{\"documentSection\": \"documentSection\", \"text\": {}, \"timestamp\": 9, \"preferredName\": \"preferredName\"}]}}, \"annotations\": {\"mapKey\": {\"uniqueId\": 8, \"stickyIds\": [9], \"ontology\": \"ontology\", \"section\": \"section\", \"preferredName\": \"preferredName\", \"cui\": \"cui\", \"attributeId\": \"attributeId\", \"qualifiers\": [\"qualifiers\"], \"type\": \"type\", \"negated\": false, \"hypothetical\": true, \"unit\": \"unit\", \"minValue\": \"minValue\", \"maxValue\": \"maxValue\", \"operator\": \"operator\", \"nluSourceType\": \"nluSourceType\", \"nluRelation\": \"nluRelation\", \"nluTargetType\": \"nluTargetType\", \"nluEntityIndex\": \"nluEntityIndex\", \"nluMentionIndex\": \"nluMentionIndex\", \"nluRelationId\": \"nluRelationId\", \"nluSide\": \"nluSide\", \"begin\": 5, \"end\": 3, \"score\": 5, \"timestamp\": 9, \"features\": {\"mapKey\": \"inner\"}, \"hits\": 4}}}], \"subQueries\": [{\"href\": \"href\", \"pageNumber\": 10, \"get_limit\": 8, \"totalDocumentCount\": 18, \"concepts\": [{\"ontology\": \"ontology\", \"cui\": \"cui\", \"preferredName\": \"preferredName\", \"alternativeName\": \"alternativeName\", \"semanticType\": \"semanticType\", \"count\": 5, \"hitCount\": 8, \"score\": 5, \"parents\": {\"count\": 5, \"hits\": 4}, \"children\": {\"count\": 5, \"hits\": 4}, \"siblings\": {\"count\": 5, \"hits\": 4}, \"related\": {\"count\": 5, \"hits\": 4}, \"documentIds\": [\"documentIds\"], \"dataType\": \"dataType\", \"unit\": \"unit\", \"operator\": \"operator\", \"minValue\": \"minValue\", \"maxValue\": \"maxValue\", \"vocab\": \"vocab\", \"properties\": [\"xProperties\"]}], \"types\": [\"types\"], \"attributes\": [{\"attributeId\": \"attributeId\", \"displayName\": \"displayName\", \"count\": 5}], \"values\": [{\"ontology\": \"ontology\", \"cui\": \"cui\", \"preferredName\": \"preferredName\", \"alternativeName\": \"alternativeName\", \"semanticType\": \"semanticType\", \"count\": 5, \"hitCount\": 8, \"score\": 5, \"parents\": {\"count\": 5, \"hits\": 4}, \"children\": {\"count\": 5, \"hits\": 4}, \"siblings\": {\"count\": 5, \"hits\": 4}, \"related\": {\"count\": 5, \"hits\": 4}, \"documentIds\": [\"documentIds\"], \"dataType\": \"dataType\", \"unit\": \"unit\", \"operator\": \"operator\", \"minValue\": \"minValue\", \"maxValue\": \"maxValue\", \"vocab\": \"vocab\", \"properties\": [\"xProperties\"]}], \"ranges\": {\"mapKey\": {\"operator\": \"operator\", \"min\": \"min\", \"max\": \"max\", \"count\": 5}}, \"typeahead\": [{\"ontology\": \"ontology\", \"cui\": \"cui\", \"preferredName\": \"preferredName\", \"alternativeName\": \"alternativeName\", \"semanticType\": \"semanticType\", \"count\": 5, \"hitCount\": 8, \"score\": 5, \"parents\": {\"count\": 5, \"hits\": 4}, \"children\": {\"count\": 5, \"hits\": 4}, \"siblings\": {\"count\": 5, \"hits\": 4}, \"related\": {\"count\": 5, \"hits\": 4}, \"documentIds\": [\"documentIds\"], \"dataType\": \"dataType\", \"unit\": \"unit\", \"operator\": \"operator\", \"minValue\": \"minValue\", \"maxValue\": \"maxValue\", \"vocab\": \"vocab\", \"properties\": [\"xProperties\"]}], \"aggregations\": {\"mapKey\": [{\"name\": \"name\", \"documentCount\": 13}]}, \"dateHistograms\": {\"mapKey\": [{\"date\": \"date\", \"hits\": 4}]}, \"qualifiers\": [{\"id\": \"id\", \"name\": \"name\"}], \"backend\": {\"messages\": [{\"messageType\": \"expanded_request\", \"url\": \"url\", \"request\": {\"mapKey\": \"anyValue\"}, \"headers\": [\"headers\"], \"status\": 6, \"response\": {\"mapKey\": \"anyValue\"}}]}, \"expandedQuery\": {\"mapKey\": \"anyValue\"}, \"parsedBoolExpression\": {\"boolExpression\": \"boolExpression\", \"boolOperands\": [{\"boolOperand\": \"boolOperand\"}]}, \"conceptsExist\": {\"mapKey\": 5}, \"cursorId\": \"cursorId\", \"vocabs\": [\"vocabs\"], \"annotations\": {\"mapKey\": {\"unstructured\": [{\"text\": \"text\", \"data\": {\"concepts\": [{\"uniqueId\": 8, \"stickyIds\": [9], \"section\": \"section\", \"type\": \"type\", \"begin\": 5, \"end\": 3, \"coveredText\": \"coveredText\", \"cui\": \"cui\", \"preferredName\": \"preferredName\", \"source\": \"source\", \"negated\": false, \"hypothetical\": true, \"timestamp\": 9, \"attributeId\": \"attributeId\", \"qualifiers\": [\"qualifiers\"], \"unit\": \"unit\", \"minValue\": \"minValue\", \"maxValue\": \"maxValue\", \"operator\": \"operator\", \"features\": {\"mapKey\": \"inner\"}, \"nluEntityIndex\": \"nluEntityIndex\", \"nluMentionIndex\": \"nluMentionIndex\", \"nluRelationId\": \"nluRelationId\", \"nluSide\": \"nluSide\", \"nluSourceType\": \"nluSourceType\", \"nluRelation\": \"nluRelation\", \"nluTargetType\": \"nluTargetType\", \"hits\": 4}], \"attributeValues\": [{\"uniqueId\": 8, \"stickyIds\": [9], \"section\": \"section\", \"type\": \"type\", \"begin\": 5, \"end\": 3, \"coveredText\": \"coveredText\", \"cui\": \"cui\", \"preferredName\": \"preferredName\", \"source\": \"source\", \"negated\": false, \"hypothetical\": true, \"timestamp\": 9, \"attributeId\": \"attributeId\", \"qualifiers\": [\"qualifiers\"], \"unit\": \"unit\", \"minValue\": \"minValue\", \"maxValue\": \"maxValue\", \"operator\": \"operator\", \"features\": {\"mapKey\": \"inner\"}, \"nluEntityIndex\": \"nluEntityIndex\", \"nluMentionIndex\": \"nluMentionIndex\", \"nluRelationId\": \"nluRelationId\", \"nluSide\": \"nluSide\", \"nluSourceType\": \"nluSourceType\", \"nluRelation\": \"nluRelation\", \"nluTargetType\": \"nluTargetType\", \"hits\": 4}], \"relations\": [{\"relationId\": \"relationId\", \"relation\": \"relation\", \"source\": {\"section\": \"section\", \"begin\": 5, \"end\": 3, \"coveredText\": \"coveredText\", \"source\": \"source\", \"type\": \"type\"}, \"target\": {\"section\": \"section\", \"begin\": 5, \"end\": 3, \"coveredText\": \"coveredText\", \"source\": \"source\", \"type\": \"type\"}}], \"mesh\": [{\"uniqueId\": 8, \"stickyIds\": [9], \"section\": \"section\", \"type\": \"type\", \"begin\": 5, \"end\": 3, \"coveredText\": \"coveredText\", \"cui\": \"cui\", \"preferredName\": \"preferredName\", \"source\": \"source\", \"negated\": false, \"hypothetical\": true, \"timestamp\": 9, \"attributeId\": \"attributeId\", \"qualifiers\": [\"qualifiers\"], \"unit\": \"unit\", \"minValue\": \"minValue\", \"maxValue\": \"maxValue\", \"operator\": \"operator\", \"features\": {\"mapKey\": \"inner\"}, \"nluEntityIndex\": \"nluEntityIndex\", \"nluMentionIndex\": \"nluMentionIndex\", \"nluRelationId\": \"nluRelationId\", \"nluSide\": \"nluSide\", \"nluSourceType\": \"nluSourceType\", \"nluRelation\": \"nluRelation\", \"nluTargetType\": \"nluTargetType\", \"hits\": 4}], \"text\": [{\"uniqueId\": 8, \"stickyIds\": [9], \"section\": \"section\", \"type\": \"type\", \"begin\": 5, \"end\": 3, \"coveredText\": \"coveredText\", \"cui\": \"cui\", \"preferredName\": \"preferredName\", \"source\": \"source\", \"negated\": false, \"hypothetical\": true, \"timestamp\": 9, \"attributeId\": \"attributeId\", \"qualifiers\": [\"qualifiers\"], \"unit\": \"unit\", \"minValue\": \"minValue\", \"maxValue\": \"maxValue\", \"operator\": \"operator\", \"features\": {\"mapKey\": \"inner\"}, \"nluEntityIndex\": \"nluEntityIndex\", \"nluMentionIndex\": \"nluMentionIndex\", \"nluRelationId\": \"nluRelationId\", \"nluSide\": \"nluSide\", \"nluSourceType\": \"nluSourceType\", \"nluRelation\": \"nluRelation\", \"nluTargetType\": \"nluTargetType\", \"hits\": 4}]}}]}}, \"metadata\": {\"corpus\": \"corpus\", \"corpusDescription\": \"corpusDescription\", \"fields\": {\"mapKey\": [\"inner\"]}}, \"documents\": [{\"documentId\": \"documentId\", \"title\": \"title\", \"metadata\": {\"mapKey\": [\"inner\"]}, \"sectionName\": \"sectionName\", \"sectionId\": \"sectionId\", \"corpus\": \"corpus\", \"links\": {\"hrefSearchMatches\": \"hrefSearchMatches\", \"hrefCategories\": \"hrefCategories\"}, \"passages\": {\"allPassages\": [{\"documentSection\": \"documentSection\", \"text\": {}, \"timestamp\": 9, \"preferredName\": \"preferredName\"}], \"searchTermToPassages\": {\"mapKey\": [{\"documentSection\": \"documentSection\", \"text\": {}, \"timestamp\": 9, \"preferredName\": \"preferredName\"}]}}, \"annotations\": {\"mapKey\": {\"uniqueId\": 8, \"stickyIds\": [9], \"ontology\": \"ontology\", \"section\": \"section\", \"preferredName\": \"preferredName\", \"cui\": \"cui\", \"attributeId\": \"attributeId\", \"qualifiers\": [\"qualifiers\"], \"type\": \"type\", \"negated\": false, \"hypothetical\": true, \"unit\": \"unit\", \"minValue\": \"minValue\", \"maxValue\": \"maxValue\", \"operator\": \"operator\", \"nluSourceType\": \"nluSourceType\", \"nluRelation\": \"nluRelation\", \"nluTargetType\": \"nluTargetType\", \"nluEntityIndex\": \"nluEntityIndex\", \"nluMentionIndex\": \"nluMentionIndex\", \"nluRelationId\": \"nluRelationId\", \"nluSide\": \"nluSide\", \"begin\": 5, \"end\": 3, \"score\": 5, \"timestamp\": 9, \"features\": {\"mapKey\": \"inner\"}, \"hits\": 4}}}], \"subQueries\": [{\"href\": \"href\", \"pageNumber\": 10, \"get_limit\": 8, \"totalDocumentCount\": 18, \"concepts\": [{\"ontology\": \"ontology\", \"cui\": \"cui\", \"preferredName\": \"preferredName\", \"alternativeName\": \"alternativeName\", \"semanticType\": \"semanticType\", \"count\": 5, \"hitCount\": 8, \"score\": 5, \"parents\": {\"count\": 5, \"hits\": 4}, \"children\": {\"count\": 5, \"hits\": 4}, \"siblings\": {\"count\": 5, \"hits\": 4}, \"related\": {\"count\": 5, \"hits\": 4}, \"documentIds\": [\"documentIds\"], \"dataType\": \"dataType\", \"unit\": \"unit\", \"operator\": \"operator\", \"minValue\": \"minValue\", \"maxValue\": \"maxValue\", \"vocab\": \"vocab\", \"properties\": [\"xProperties\"]}], \"types\": [\"types\"], \"attributes\": [{\"attributeId\": \"attributeId\", \"displayName\": \"displayName\", \"count\": 5}], \"values\": [{\"ontology\": \"ontology\", \"cui\": \"cui\", \"preferredName\": \"preferredName\", \"alternativeName\": \"alternativeName\", \"semanticType\": \"semanticType\", \"count\": 5, \"hitCount\": 8, \"score\": 5, \"parents\": {\"count\": 5, \"hits\": 4}, \"children\": {\"count\": 5, \"hits\": 4}, \"siblings\": {\"count\": 5, \"hits\": 4}, \"related\": {\"count\": 5, \"hits\": 4}, \"documentIds\": [\"documentIds\"], \"dataType\": \"dataType\", \"unit\": \"unit\", \"operator\": \"operator\", \"minValue\": \"minValue\", \"maxValue\": \"maxValue\", \"vocab\": \"vocab\", \"properties\": [\"xProperties\"]}], \"ranges\": {\"mapKey\": {\"operator\": \"operator\", \"min\": \"min\", \"max\": \"max\", \"count\": 5}}, \"typeahead\": [{\"ontology\": \"ontology\", \"cui\": \"cui\", \"preferredName\": \"preferredName\", \"alternativeName\": \"alternativeName\", \"semanticType\": \"semanticType\", \"count\": 5, \"hitCount\": 8, \"score\": 5, \"parents\": {\"count\": 5, \"hits\": 4}, \"children\": {\"count\": 5, \"hits\": 4}, \"siblings\": {\"count\": 5, \"hits\": 4}, \"related\": {\"count\": 5, \"hits\": 4}, \"documentIds\": [\"documentIds\"], \"dataType\": \"dataType\", \"unit\": \"unit\", \"operator\": \"operator\", \"minValue\": \"minValue\", \"maxValue\": \"maxValue\", \"vocab\": \"vocab\", \"properties\": [\"xProperties\"]}], \"aggregations\": {\"mapKey\": [{\"name\": \"name\", \"documentCount\": 13}]}, \"dateHistograms\": {\"mapKey\": [{\"date\": \"date\", \"hits\": 4}]}, \"qualifiers\": [{\"id\": \"id\", \"name\": \"name\"}], \"backend\": {\"messages\": [{\"messageType\": \"expanded_request\", \"url\": \"url\", \"request\": {\"mapKey\": \"anyValue\"}, \"headers\": [\"headers\"], \"status\": 6, \"response\": {\"mapKey\": \"anyValue\"}}]}, \"expandedQuery\": {\"mapKey\": \"anyValue\"}, \"parsedBoolExpression\": {\"boolExpression\": \"boolExpression\", \"boolOperands\": [{\"boolOperand\": \"boolOperand\"}]}, \"conceptsExist\": {\"mapKey\": 5}, \"cursorId\": \"cursorId\", \"vocabs\": [\"vocabs\"], \"annotations\": {\"mapKey\": {\"unstructured\": [{\"text\": \"text\", \"data\": {\"concepts\": [{\"uniqueId\": 8, \"stickyIds\": [9], \"section\": \"section\", \"type\": \"type\", \"begin\": 5, \"end\": 3, \"coveredText\": \"coveredText\", \"cui\": \"cui\", \"preferredName\": \"preferredName\", \"source\": \"source\", \"negated\": false, \"hypothetical\": true, \"timestamp\": 9, \"attributeId\": \"attributeId\", \"qualifiers\": [\"qualifiers\"], \"unit\": \"unit\", \"minValue\": \"minValue\", \"maxValue\": \"maxValue\", \"operator\": \"operator\", \"features\": {\"mapKey\": \"inner\"}, \"nluEntityIndex\": \"nluEntityIndex\", \"nluMentionIndex\": \"nluMentionIndex\", \"nluRelationId\": \"nluRelationId\", \"nluSide\": \"nluSide\", \"nluSourceType\": \"nluSourceType\", \"nluRelation\": \"nluRelation\", \"nluTargetType\": \"nluTargetType\", \"hits\": 4}], \"attributeValues\": [{\"uniqueId\": 8, \"stickyIds\": [9], \"section\": \"section\", \"type\": \"type\", \"begin\": 5, \"end\": 3, \"coveredText\": \"coveredText\", \"cui\": \"cui\", \"preferredName\": \"preferredName\", \"source\": \"source\", \"negated\": false, \"hypothetical\": true, \"timestamp\": 9, \"attributeId\": \"attributeId\", \"qualifiers\": [\"qualifiers\"], \"unit\": \"unit\", \"minValue\": \"minValue\", \"maxValue\": \"maxValue\", \"operator\": \"operator\", \"features\": {\"mapKey\": \"inner\"}, \"nluEntityIndex\": \"nluEntityIndex\", \"nluMentionIndex\": \"nluMentionIndex\", \"nluRelationId\": \"nluRelationId\", \"nluSide\": \"nluSide\", \"nluSourceType\": \"nluSourceType\", \"nluRelation\": \"nluRelation\", \"nluTargetType\": \"nluTargetType\", \"hits\": 4}], \"relations\": [{\"relationId\": \"relationId\", \"relation\": \"relation\", \"source\": {\"section\": \"section\", \"begin\": 5, \"end\": 3, \"coveredText\": \"coveredText\", \"source\": \"source\", \"type\": \"type\"}, \"target\": {\"section\": \"section\", \"begin\": 5, \"end\": 3, \"coveredText\": \"coveredText\", \"source\": \"source\", \"type\": \"type\"}}], \"mesh\": [{\"uniqueId\": 8, \"stickyIds\": [9], \"section\": \"section\", \"type\": \"type\", \"begin\": 5, \"end\": 3, \"coveredText\": \"coveredText\", \"cui\": \"cui\", \"preferredName\": \"preferredName\", \"source\": \"source\", \"negated\": false, \"hypothetical\": true, \"timestamp\": 9, \"attributeId\": \"attributeId\", \"qualifiers\": [\"qualifiers\"], \"unit\": \"unit\", \"minValue\": \"minValue\", \"maxValue\": \"maxValue\", \"operator\": \"operator\", \"features\": {\"mapKey\": \"inner\"}, \"nluEntityIndex\": \"nluEntityIndex\", \"nluMentionIndex\": \"nluMentionIndex\", \"nluRelationId\": \"nluRelationId\", \"nluSide\": \"nluSide\", \"nluSourceType\": \"nluSourceType\", \"nluRelation\": \"nluRelation\", \"nluTargetType\": \"nluTargetType\", \"hits\": 4}], \"text\": [{\"uniqueId\": 8, \"stickyIds\": [9], \"section\": \"section\", \"type\": \"type\", \"begin\": 5, \"end\": 3, \"coveredText\": \"coveredText\", \"cui\": \"cui\", \"preferredName\": \"preferredName\", \"source\": \"source\", \"negated\": false, \"hypothetical\": true, \"timestamp\": 9, \"attributeId\": \"attributeId\", \"qualifiers\": [\"qualifiers\"], \"unit\": \"unit\", \"minValue\": \"minValue\", \"maxValue\": \"maxValue\", \"operator\": \"operator\", \"features\": {\"mapKey\": \"inner\"}, \"nluEntityIndex\": \"nluEntityIndex\", \"nluMentionIndex\": \"nluMentionIndex\", \"nluRelationId\": \"nluRelationId\", \"nluSide\": \"nluSide\", \"nluSourceType\": \"nluSourceType\", \"nluRelation\": \"nluRelation\", \"nluTargetType\": \"nluTargetType\", \"hits\": 4}]}}]}}, \"metadata\": {\"corpus\": \"corpus\", \"corpusDescription\": \"corpusDescription\", \"fields\": {\"mapKey\": [\"inner\"]}}, \"documents\": [{\"documentId\": \"documentId\", \"title\": \"title\", \"metadata\": {\"mapKey\": [\"inner\"]}, \"sectionName\": \"sectionName\", \"sectionId\": \"sectionId\", \"corpus\": \"corpus\", \"links\": {\"hrefSearchMatches\": \"hrefSearchMatches\", \"hrefCategories\": \"hrefCategories\"}, \"passages\": {\"allPassages\": [{\"documentSection\": \"documentSection\", \"text\": {}, \"timestamp\": 9, \"preferredName\": \"preferredName\"}], \"searchTermToPassages\": {\"mapKey\": [{\"documentSection\": \"documentSection\", \"text\": {}, \"timestamp\": 9, \"preferredName\": \"preferredName\"}]}}, \"annotations\": {\"mapKey\": {\"uniqueId\": 8, \"stickyIds\": [9], \"ontology\": \"ontology\", \"section\": \"section\", \"preferredName\": \"preferredName\", \"cui\": \"cui\", \"attributeId\": \"attributeId\", \"qualifiers\": [\"qualifiers\"], \"type\": \"type\", \"negated\": false, \"hypothetical\": true, \"unit\": \"unit\", \"minValue\": \"minValue\", \"maxValue\": \"maxValue\", \"operator\": \"operator\", \"nluSourceType\": \"nluSourceType\", \"nluRelation\": \"nluRelation\", \"nluTargetType\": \"nluTargetType\", \"nluEntityIndex\": \"nluEntityIndex\", \"nluMentionIndex\": \"nluMentionIndex\", \"nluRelationId\": \"nluRelationId\", \"nluSide\": \"nluSide\", \"begin\": 5, \"end\": 3, \"score\": 5, \"timestamp\": 9, \"features\": {\"mapKey\": \"inner\"}, \"hits\": 4}}}], \"subQueries\": [{\"href\": \"href\", \"pageNumber\": 10, \"get_limit\": 8, \"totalDocumentCount\": 18, \"concepts\": [{\"ontology\": \"ontology\", \"cui\": \"cui\", \"preferredName\": \"preferredName\", \"alternativeName\": \"alternativeName\", \"semanticType\": \"semanticType\", \"count\": 5, \"hitCount\": 8, \"score\": 5, \"parents\": {\"count\": 5, \"hits\": 4}, \"children\": {\"count\": 5, \"hits\": 4}, \"siblings\": {\"count\": 5, \"hits\": 4}, \"related\": {\"count\": 5, \"hits\": 4}, \"documentIds\": [\"documentIds\"], \"dataType\": \"dataType\", \"unit\": \"unit\", \"operator\": \"operator\", \"minValue\": \"minValue\", \"maxValue\": \"maxValue\", \"vocab\": \"vocab\", \"properties\": [\"xProperties\"]}], \"types\": [\"types\"], \"attributes\": [{\"attributeId\": \"attributeId\", \"displayName\": \"displayName\", \"count\": 5}], \"values\": [{\"ontology\": \"ontology\", \"cui\": \"cui\", \"preferredName\": \"preferredName\", \"alternativeName\": \"alternativeName\", \"semanticType\": \"semanticType\", \"count\": 5, \"hitCount\": 8, \"score\": 5, \"parents\": {\"count\": 5, \"hits\": 4}, \"children\": {\"count\": 5, \"hits\": 4}, \"siblings\": {\"count\": 5, \"hits\": 4}, \"related\": {\"count\": 5, \"hits\": 4}, \"documentIds\": [\"documentIds\"], \"dataType\": \"dataType\", \"unit\": \"unit\", \"operator\": \"operator\", \"minValue\": \"minValue\", \"maxValue\": \"maxValue\", \"vocab\": \"vocab\", \"properties\": [\"xProperties\"]}], \"ranges\": {\"mapKey\": {\"operator\": \"operator\", \"min\": \"min\", \"max\": \"max\", \"count\": 5}}, \"typeahead\": [{\"ontology\": \"ontology\", \"cui\": \"cui\", \"preferredName\": \"preferredName\", \"alternativeName\": \"alternativeName\", \"semanticType\": \"semanticType\", \"count\": 5, \"hitCount\": 8, \"score\": 5, \"parents\": {\"count\": 5, \"hits\": 4}, \"children\": {\"count\": 5, \"hits\": 4}, \"siblings\": {\"count\": 5, \"hits\": 4}, \"related\": {\"count\": 5, \"hits\": 4}, \"documentIds\": [\"documentIds\"], \"dataType\": \"dataType\", \"unit\": \"unit\", \"operator\": \"operator\", \"minValue\": \"minValue\", \"maxValue\": \"maxValue\", \"vocab\": \"vocab\", \"properties\": [\"xProperties\"]}], \"aggregations\": {\"mapKey\": [{\"name\": \"name\", \"documentCount\": 13}]}, \"dateHistograms\": {\"mapKey\": [{\"date\": \"date\", \"hits\": 4}]}, \"qualifiers\": [{\"id\": \"id\", \"name\": \"name\"}], \"backend\": {\"messages\": [{\"messageType\": \"expanded_request\", \"url\": \"url\", \"request\": {\"mapKey\": \"anyValue\"}, \"headers\": [\"headers\"], \"status\": 6, \"response\": {\"mapKey\": \"anyValue\"}}]}, \"expandedQuery\": {\"mapKey\": \"anyValue\"}, \"parsedBoolExpression\": {\"boolExpression\": \"boolExpression\", \"boolOperands\": [{\"boolOperand\": \"boolOperand\"}]}, \"conceptsExist\": {\"mapKey\": 5}, \"cursorId\": \"cursorId\", \"vocabs\": [\"vocabs\"], \"annotations\": {\"mapKey\": {\"unstructured\": [{\"text\": \"text\", \"data\": {\"concepts\": [{\"uniqueId\": 8, \"stickyIds\": [9], \"section\": \"section\", \"type\": \"type\", \"begin\": 5, \"end\": 3, \"coveredText\": \"coveredText\", \"cui\": \"cui\", \"preferredName\": \"preferredName\", \"source\": \"source\", \"negated\": false, \"hypothetical\": true, \"timestamp\": 9, \"attributeId\": \"attributeId\", \"qualifiers\": [\"qualifiers\"], \"unit\": \"unit\", \"minValue\": \"minValue\", \"maxValue\": \"maxValue\", \"operator\": \"operator\", \"features\": {\"mapKey\": \"inner\"}, \"nluEntityIndex\": \"nluEntityIndex\", \"nluMentionIndex\": \"nluMentionIndex\", \"nluRelationId\": \"nluRelationId\", \"nluSide\": \"nluSide\", \"nluSourceType\": \"nluSourceType\", \"nluRelation\": \"nluRelation\", \"nluTargetType\": \"nluTargetType\", \"hits\": 4}], \"attributeValues\": [{\"uniqueId\": 8, \"stickyIds\": [9], \"section\": \"section\", \"type\": \"type\", \"begin\": 5, \"end\": 3, \"coveredText\": \"coveredText\", \"cui\": \"cui\", \"preferredName\": \"preferredName\", \"source\": \"source\", \"negated\": false, \"hypothetical\": true, \"timestamp\": 9, \"attributeId\": \"attributeId\", \"qualifiers\": [\"qualifiers\"], \"unit\": \"unit\", \"minValue\": \"minValue\", \"maxValue\": \"maxValue\", \"operator\": \"operator\", \"features\": {\"mapKey\": \"inner\"}, \"nluEntityIndex\": \"nluEntityIndex\", \"nluMentionIndex\": \"nluMentionIndex\", \"nluRelationId\": \"nluRelationId\", \"nluSide\": \"nluSide\", \"nluSourceType\": \"nluSourceType\", \"nluRelation\": \"nluRelation\", \"nluTargetType\": \"nluTargetType\", \"hits\": 4}], \"relations\": [{\"relationId\": \"relationId\", \"relation\": \"relation\"}], \"mesh\": [{\"uniqueId\": 8, \"stickyIds\": [9], \"section\": \"section\", \"type\": \"type\", \"begin\": 5, \"end\": 3, \"coveredText\": \"coveredText\", \"cui\": \"cui\", \"preferredName\": \"preferredName\", \"source\": \"source\", \"negated\": false, \"hypothetical\": true, \"timestamp\": 9, \"attributeId\": \"attributeId\", \"qualifiers\": [\"qualifiers\"], \"unit\": \"unit\", \"minValue\": \"minValue\", \"maxValue\": \"maxValue\", \"operator\": \"operator\", \"features\": {\"mapKey\": \"inner\"}, \"nluEntityIndex\": \"nluEntityIndex\", \"nluMentionIndex\": \"nluMentionIndex\", \"nluRelationId\": \"nluRelationId\", \"nluSide\": \"nluSide\", \"nluSourceType\": \"nluSourceType\", \"nluRelation\": \"nluRelation\", \"nluTargetType\": \"nluTargetType\", \"hits\": 4}], \"text\": [{\"uniqueId\": 8, \"stickyIds\": [9], \"section\": \"section\", \"type\": \"type\", \"begin\": 5, \"end\": 3, \"coveredText\": \"coveredText\", \"cui\": \"cui\", \"preferredName\": \"preferredName\", \"source\": \"source\", \"negated\": false, \"hypothetical\": true, \"timestamp\": 9, \"attributeId\": \"attributeId\", \"qualifiers\": [\"qualifiers\"], \"unit\": \"unit\", \"minValue\": \"minValue\", \"maxValue\": \"maxValue\", \"operator\": \"operator\", \"features\": {\"mapKey\": \"inner\"}, \"nluEntityIndex\": \"nluEntityIndex\", \"nluMentionIndex\": \"nluMentionIndex\", \"nluRelationId\": \"nluRelationId\", \"nluSide\": \"nluSide\", \"nluSourceType\": \"nluSourceType\", \"nluRelation\": \"nluRelation\", \"nluTargetType\": \"nluTargetType\", \"hits\": 4}]}}]}}, \"metadata\": {\"corpus\": \"corpus\", \"corpusDescription\": \"corpusDescription\", \"fields\": {\"mapKey\": [\"inner\"]}}, \"documents\": [{\"documentId\": \"documentId\", \"title\": \"title\", \"metadata\": {\"mapKey\": [\"inner\"]}, \"sectionName\": \"sectionName\", \"sectionId\": \"sectionId\", \"corpus\": \"corpus\", \"links\": {\"hrefSearchMatches\": \"hrefSearchMatches\", \"hrefCategories\": \"hrefCategories\"}, \"passages\": {\"allPassages\": [{\"documentSection\": \"documentSection\", \"text\": {}, \"timestamp\": 9, \"preferredName\": \"preferredName\"}], \"searchTermToPassages\": {\"mapKey\": [{\"documentSection\": \"documentSection\", \"text\": {}, \"timestamp\": 9, \"preferredName\": \"preferredName\"}]}}, \"annotations\": {\"mapKey\": {\"uniqueId\": 8, \"stickyIds\": [9], \"ontology\": \"ontology\", \"section\": \"section\", \"preferredName\": \"preferredName\", \"cui\": \"cui\", \"attributeId\": \"attributeId\", \"qualifiers\": [\"qualifiers\"], \"type\": \"type\", \"negated\": false, \"hypothetical\": true, \"unit\": \"unit\", \"minValue\": \"minValue\", \"maxValue\": \"maxValue\", \"operator\": \"operator\", \"nluSourceType\": \"nluSourceType\", \"nluRelation\": \"nluRelation\", \"nluTargetType\": \"nluTargetType\", \"nluEntityIndex\": \"nluEntityIndex\", \"nluMentionIndex\": \"nluMentionIndex\", \"nluRelationId\": \"nluRelationId\", \"nluSide\": \"nluSide\", \"begin\": 5, \"end\": 3, \"score\": 5, \"timestamp\": 9, \"features\": {\"mapKey\": \"inner\"}, \"hits\": 4}}}], \"subQueries\": [{\"href\": \"href\", \"pageNumber\": 10, \"get_limit\": 8, \"totalDocumentCount\": 18, \"concepts\": [{\"ontology\": \"ontology\", \"cui\": \"cui\", \"preferredName\": \"preferredName\", \"alternativeName\": \"alternativeName\", \"semanticType\": \"semanticType\", \"count\": 5, \"hitCount\": 8, \"score\": 5, \"parents\": {\"count\": 5, \"hits\": 4}, \"children\": {\"count\": 5, \"hits\": 4}, \"siblings\": {\"count\": 5, \"hits\": 4}, \"related\": {\"count\": 5, \"hits\": 4}, \"documentIds\": [\"documentIds\"], \"dataType\": \"dataType\", \"unit\": \"unit\", \"operator\": \"operator\", \"minValue\": \"minValue\", \"maxValue\": \"maxValue\", \"vocab\": \"vocab\", \"properties\": [\"xProperties\"]}], \"types\": [\"types\"], \"attributes\": [{\"attributeId\": \"attributeId\", \"displayName\": \"displayName\", \"count\": 5}], \"values\": [{\"ontology\": \"ontology\", \"cui\": \"cui\", \"preferredName\": \"preferredName\", \"alternativeName\": \"alternativeName\", \"semanticType\": \"semanticType\", \"count\": 5, \"hitCount\": 8, \"score\": 5, \"parents\": {\"count\": 5, \"hits\": 4}, \"children\": {\"count\": 5, \"hits\": 4}, \"siblings\": {\"count\": 5, \"hits\": 4}, \"related\": {\"count\": 5, \"hits\": 4}, \"documentIds\": [\"documentIds\"], \"dataType\": \"dataType\", \"unit\": \"unit\", \"operator\": \"operator\", \"minValue\": \"minValue\", \"maxValue\": \"maxValue\", \"vocab\": \"vocab\", \"properties\": [\"xProperties\"]}], \"ranges\": {\"mapKey\": {\"operator\": \"operator\", \"min\": \"min\", \"max\": \"max\", \"count\": 5}}, \"typeahead\": [{\"ontology\": \"ontology\", \"cui\": \"cui\", \"preferredName\": \"preferredName\", \"alternativeName\": \"alternativeName\", \"semanticType\": \"semanticType\", \"count\": 5, \"hitCount\": 8, \"score\": 5, \"parents\": {\"count\": 5, \"hits\": 4}, \"children\": {\"count\": 5, \"hits\": 4}, \"siblings\": {\"count\": 5, \"hits\": 4}, \"related\": {\"count\": 5, \"hits\": 4}, \"documentIds\": [\"documentIds\"], \"dataType\": \"dataType\", \"unit\": \"unit\", \"operator\": \"operator\", \"minValue\": \"minValue\", \"maxValue\": \"maxValue\", \"vocab\": \"vocab\", \"properties\": [\"xProperties\"]}], \"aggregations\": {\"mapKey\": [{\"name\": \"name\", \"documentCount\": 13}]}, \"dateHistograms\": {\"mapKey\": [{\"date\": \"date\", \"hits\": 4}]}, \"qualifiers\": [{\"id\": \"id\", \"name\": \"name\"}], \"backend\": {\"messages\": [{\"messageType\": \"expanded_request\", \"url\": \"url\", \"request\": {\"mapKey\": \"anyValue\"}, \"headers\": [\"headers\"], \"status\": 6, \"response\": {\"mapKey\": \"anyValue\"}}]}, \"expandedQuery\": {\"mapKey\": \"anyValue\"}, \"parsedBoolExpression\": {\"boolExpression\": \"boolExpression\", \"boolOperands\": [{\"boolOperand\": \"boolOperand\"}]}, \"conceptsExist\": {\"mapKey\": 5}, \"cursorId\": \"cursorId\", \"vocabs\": [\"vocabs\"], \"annotations\": {\"mapKey\": {\"unstructured\": [{\"text\": \"text\", \"data\": {\"concepts\": [], \"attributeValues\": [], \"relations\": [], \"mesh\": [], \"text\": []}}]}}, \"metadata\": {\"corpus\": \"corpus\", \"corpusDescription\": \"corpusDescription\", \"fields\": {\"mapKey\": [\"inner\"]}}, \"documents\": [{\"documentId\": \"documentId\", \"title\": \"title\", \"metadata\": {\"mapKey\": [\"inner\"]}, \"sectionName\": \"sectionName\", \"sectionId\": \"sectionId\", \"corpus\": \"corpus\", \"links\": {\"hrefSearchMatches\": \"hrefSearchMatches\", \"hrefCategories\": \"hrefCategories\"}, \"passages\": {\"allPassages\": [{\"documentSection\": \"documentSection\", \"timestamp\": 9, \"preferredName\": \"preferredName\"}], \"searchTermToPassages\": {\"mapKey\": [{\"documentSection\": \"documentSection\", \"timestamp\": 9, \"preferredName\": \"preferredName\"}]}}, \"annotations\": {\"mapKey\": {\"uniqueId\": 8, \"stickyIds\": [9], \"ontology\": \"ontology\", \"section\": \"section\", \"preferredName\": \"preferredName\", \"cui\": \"cui\", \"attributeId\": \"attributeId\", \"qualifiers\": [\"qualifiers\"], \"type\": \"type\", \"negated\": false, \"hypothetical\": true, \"unit\": \"unit\", \"minValue\": \"minValue\", \"maxValue\": \"maxValue\", \"operator\": \"operator\", \"nluSourceType\": \"nluSourceType\", \"nluRelation\": \"nluRelation\", \"nluTargetType\": \"nluTargetType\", \"nluEntityIndex\": \"nluEntityIndex\", \"nluMentionIndex\": \"nluMentionIndex\", \"nluRelationId\": \"nluRelationId\", \"nluSide\": \"nluSide\", \"begin\": 5, \"end\": 3, \"score\": 5, \"timestamp\": 9, \"features\": {\"mapKey\": \"inner\"}, \"hits\": 4}}}], \"subQueries\": [{\"href\": \"href\", \"pageNumber\": 10, \"get_limit\": 8, \"totalDocumentCount\": 18, \"concepts\": [{\"ontology\": \"ontology\", \"cui\": \"cui\", \"preferredName\": \"preferredName\", \"alternativeName\": \"alternativeName\", \"semanticType\": \"semanticType\", \"count\": 5, \"hitCount\": 8, \"score\": 5, \"parents\": {\"count\": 5, \"hits\": 4}, \"children\": {\"count\": 5, \"hits\": 4}, \"siblings\": {\"count\": 5, \"hits\": 4}, \"related\": {\"count\": 5, \"hits\": 4}, \"documentIds\": [\"documentIds\"], \"dataType\": \"dataType\", \"unit\": \"unit\", \"operator\": \"operator\", \"minValue\": \"minValue\", \"maxValue\": \"maxValue\", \"vocab\": \"vocab\", \"properties\": [\"xProperties\"]}], \"types\": [\"types\"], \"attributes\": [{\"attributeId\": \"attributeId\", \"displayName\": \"displayName\", \"count\": 5}], \"values\": [{\"ontology\": \"ontology\", \"cui\": \"cui\", \"preferredName\": \"preferredName\", \"alternativeName\": \"alternativeName\", \"semanticType\": \"semanticType\", \"count\": 5, \"hitCount\": 8, \"score\": 5, \"parents\": {\"count\": 5, \"hits\": 4}, \"children\": {\"count\": 5, \"hits\": 4}, \"siblings\": {\"count\": 5, \"hits\": 4}, \"related\": {\"count\": 5, \"hits\": 4}, \"documentIds\": [\"documentIds\"], \"dataType\": \"dataType\", \"unit\": \"unit\", \"operator\": \"operator\", \"minValue\": \"minValue\", \"maxValue\": \"maxValue\", \"vocab\": \"vocab\", \"properties\": [\"xProperties\"]}], \"ranges\": {\"mapKey\": {\"operator\": \"operator\", \"min\": \"min\", \"max\": \"max\", \"count\": 5}}, \"typeahead\": [{\"ontology\": \"ontology\", \"cui\": \"cui\", \"preferredName\": \"preferredName\", \"alternativeName\": \"alternativeName\", \"semanticType\": \"semanticType\", \"count\": 5, \"hitCount\": 8, \"score\": 5, \"parents\": {\"count\": 5, \"hits\": 4}, \"children\": {\"count\": 5, \"hits\": 4}, \"siblings\": {\"count\": 5, \"hits\": 4}, \"related\": {\"count\": 5, \"hits\": 4}, \"documentIds\": [\"documentIds\"], \"dataType\": \"dataType\", \"unit\": \"unit\", \"operator\": \"operator\", \"minValue\": \"minValue\", \"maxValue\": \"maxValue\", \"vocab\": \"vocab\", \"properties\": [\"xProperties\"]}], \"aggregations\": {\"mapKey\": [{\"name\": \"name\", \"documentCount\": 13}]}, \"dateHistograms\": {\"mapKey\": [{\"date\": \"date\", \"hits\": 4}]}, \"qualifiers\": [{\"id\": \"id\", \"name\": \"name\"}], \"backend\": {\"messages\": [{\"messageType\": \"expanded_request\", \"url\": \"url\", \"request\": {\"mapKey\": \"anyValue\"}, \"headers\": [\"headers\"], \"status\": 6, \"response\": {\"mapKey\": \"anyValue\"}}]}, \"expandedQuery\": {\"mapKey\": \"anyValue\"}, \"parsedBoolExpression\": {\"boolExpression\": \"boolExpression\", \"boolOperands\": [{\"boolOperand\": \"boolOperand\"}]}, \"conceptsExist\": {\"mapKey\": 5}, \"cursorId\": \"cursorId\", \"vocabs\": [\"vocabs\"], \"annotations\": {\"mapKey\": {\"unstructured\": [{\"text\": \"text\"}]}}, \"metadata\": {\"corpus\": \"corpus\", \"corpusDescription\": \"corpusDescription\", \"fields\": {\"mapKey\": [\"inner\"]}}, \"documents\": [{\"documentId\": \"documentId\", \"title\": \"title\", \"metadata\": {\"mapKey\": [\"inner\"]}, \"sectionName\": \"sectionName\", \"sectionId\": \"sectionId\", \"corpus\": \"corpus\", \"links\": {\"hrefSearchMatches\": \"hrefSearchMatches\", \"hrefCategories\": \"hrefCategories\"}, \"passages\": {\"allPassages\": [], \"searchTermToPassages\": {\"mapKey\": []}}, \"annotations\": {\"mapKey\": {\"uniqueId\": 8, \"stickyIds\": [9], \"ontology\": \"ontology\", \"section\": \"section\", \"preferredName\": \"preferredName\", \"cui\": \"cui\", \"attributeId\": \"attributeId\", \"qualifiers\": [\"qualifiers\"], \"type\": \"type\", \"negated\": false, \"hypothetical\": true, \"unit\": \"unit\", \"minValue\": \"minValue\", \"maxValue\": \"maxValue\", \"operator\": \"operator\", \"nluSourceType\": \"nluSourceType\", \"nluRelation\": \"nluRelation\", \"nluTargetType\": \"nluTargetType\", \"nluEntityIndex\": \"nluEntityIndex\", \"nluMentionIndex\": \"nluMentionIndex\", \"nluRelationId\": \"nluRelationId\", \"nluSide\": \"nluSide\", \"begin\": 5, \"end\": 3, \"score\": 5, \"timestamp\": 9, \"features\": {\"mapKey\": \"inner\"}, \"hits\": 4}}}], \"subQueries\": [{\"href\": \"href\", \"pageNumber\": 10, \"get_limit\": 8, \"totalDocumentCount\": 18, \"concepts\": [{\"ontology\": \"ontology\", \"cui\": \"cui\", \"preferredName\": \"preferredName\", \"alternativeName\": \"alternativeName\", \"semanticType\": \"semanticType\", \"count\": 5, \"hitCount\": 8, \"score\": 5, \"documentIds\": [\"documentIds\"], \"dataType\": \"dataType\", \"unit\": \"unit\", \"operator\": \"operator\", \"minValue\": \"minValue\", \"maxValue\": \"maxValue\", \"vocab\": \"vocab\", \"properties\": [\"xProperties\"]}], \"types\": [\"types\"], \"attributes\": [{\"attributeId\": \"attributeId\", \"displayName\": \"displayName\", \"count\": 5}], \"values\": [{\"ontology\": \"ontology\", \"cui\": \"cui\", \"preferredName\": \"preferredName\", \"alternativeName\": \"alternativeName\", \"semanticType\": \"semanticType\", \"count\": 5, \"hitCount\": 8, \"score\": 5, \"documentIds\": [\"documentIds\"], \"dataType\": \"dataType\", \"unit\": \"unit\", \"operator\": \"operator\", \"minValue\": \"minValue\", \"maxValue\": \"maxValue\", \"vocab\": \"vocab\", \"properties\": [\"xProperties\"]}], \"ranges\": {\"mapKey\": {\"operator\": \"operator\", \"min\": \"min\", \"max\": \"max\", \"count\": 5}}, \"typeahead\": [{\"ontology\": \"ontology\", \"cui\": \"cui\", \"preferredName\": \"preferredName\", \"alternativeName\": \"alternativeName\", \"semanticType\": \"semanticType\", \"count\": 5, \"hitCount\": 8, \"score\": 5, \"documentIds\": [\"documentIds\"], \"dataType\": \"dataType\", \"unit\": \"unit\", \"operator\": \"operator\", \"minValue\": \"minValue\", \"maxValue\": \"maxValue\", \"vocab\": \"vocab\", \"properties\": [\"xProperties\"]}], \"aggregations\": {\"mapKey\": [{\"name\": \"name\", \"documentCount\": 13}]}, \"dateHistograms\": {\"mapKey\": [{\"date\": \"date\", \"hits\": 4}]}, \"qualifiers\": [{\"id\": \"id\", \"name\": \"name\"}], \"backend\": {\"messages\": []}, \"expandedQuery\": {\"mapKey\": \"anyValue\"}, \"parsedBoolExpression\": {\"boolExpression\": \"boolExpression\", \"boolOperands\": []}, \"conceptsExist\": {\"mapKey\": 5}, \"cursorId\": \"cursorId\", \"vocabs\": [\"vocabs\"], \"annotations\": {\"mapKey\": {\"unstructured\": []}}, \"metadata\": {\"corpus\": \"corpus\", \"corpusDescription\": \"corpusDescription\", \"fields\": {\"mapKey\": [\"inner\"]}}, \"documents\": [{\"documentId\": \"documentId\", \"title\": \"title\", \"metadata\": {\"mapKey\": [\"inner\"]}, \"sectionName\": \"sectionName\", \"sectionId\": \"sectionId\", \"corpus\": \"corpus\", \"annotations\": {\"mapKey\": null}}], \"subQueries\": [{\"href\": \"href\", \"pageNumber\": 10, \"get_limit\": 8, \"totalDocumentCount\": 18, \"concepts\": [], \"types\": [\"types\"], \"attributes\": [], \"values\": [], \"ranges\": {\"mapKey\": null}, \"typeahead\": [], \"aggregations\": {\"mapKey\": []}, \"dateHistograms\": {\"mapKey\": []}, \"qualifiers\": [], \"expandedQuery\": {\"mapKey\": \"anyValue\"}, \"conceptsExist\": {\"mapKey\": 5}, \"cursorId\": \"cursorId\", \"vocabs\": [\"vocabs\"], \"annotations\": {\"mapKey\": null}, \"documents\": [], \"subQueries\": []}]}]}]}]}]}]}]}]}]}";
		String searchPath = "/v1/corpora/testString/search";

		server.enqueue(
				new MockResponse().setHeader("Content-type", "application/json")
						.setResponseCode(200).setBody(mockResponseBody));

		constructClientService();

		// Construct an instance of the SearchOptions model
		SearchOptions searchOptionsModel = new SearchOptions.Builder()
				.corpus("testString").returns(new ReturnsModel()).verbose(true).build();

		// Invoke operation with valid options model (positive test)
		Response<SearchModel> response = testService.search(searchOptionsModel)
				.execute();
		assertNotNull(response);
		SearchModel responseObj = response.getResult();
		assertNotNull(responseObj);

		// Verify the contents of the request
		RecordedRequest request = server.takeRequest();
		assertNotNull(request);
		assertEquals(request.getMethod(), "POST");

		// Check query
		Map<String, String> query = TestUtilities.parseQueryString(request);
		assertNotNull(query);
		// Get query params
		assertEquals(query.get("version"), "testString");
		assertEquals(Boolean.valueOf(query.get("verbose")),
				Boolean.valueOf(true));
		// Check request path
		String parsedPath = TestUtilities.parseReqPath(request);
		assertEquals(parsedPath, searchPath);
	}

	// Test the search operation with null options model parameter
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testSearchNoOptions() throws Throwable {
		// construct the service
		constructClientService();

		server.enqueue(new MockResponse());

		// Invoke operation with null options model (negative test)
		testService.search(null).execute();
	}

	@Test
	public void testGetFieldsWOptions() throws Throwable {
		// Schedule some responses.
		String mockResponseBody = "{\"fields\": {\"mapKey\": {\"supports\": [\"supports\"]}}, \"sectionFieldNames\": [\"sectionFieldNames\"], \"attrSectionFieldNames\": [\"attrSectionFieldNames\"], \"qualifierSectionFieldNames\": [\"qualifierSectionFieldNames\"], \"meshSectionFieldNames\": [\"meshSectionFieldNames\"], \"fieldIndexMap\": {\"mapKey\": \"inner\"}}";
		String getFieldsPath = "/v1/corpora/testString/search/metadata";

		server.enqueue(
				new MockResponse().setHeader("Content-type", "application/json")
						.setResponseCode(200).setBody(mockResponseBody));

		constructClientService();

		// Construct an instance of the GetFieldsOptions model
		GetFieldsOptions getFieldsOptionsModel = new GetFieldsOptions.Builder()
				.corpus("testString").build();

		// Invoke operation with valid options model (positive test)
		Response<MetadataModel> response = testService
				.getFields(getFieldsOptionsModel).execute();
		assertNotNull(response);
		MetadataModel responseObj = response.getResult();
		assertNotNull(responseObj);

		// Verify the contents of the request
		RecordedRequest request = server.takeRequest();
		assertNotNull(request);
		assertEquals(request.getMethod(), "GET");

		// Check query
		Map<String, String> query = TestUtilities.parseQueryString(request);
		assertNotNull(query);
		// Get query params
		assertEquals(query.get("version"), "testString");
		// Check request path
		String parsedPath = TestUtilities.parseReqPath(request);
		assertEquals(parsedPath, getFieldsPath);
	}

	// Test the getFields operation with null options model parameter
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testGetFieldsNoOptions() throws Throwable {
		// construct the service
		constructClientService();

		server.enqueue(new MockResponse());

		// Invoke operation with null options model (negative test)
		testService.getFields(null).execute();
	}

	@Test
	public void testTypeaheadWOptions() throws Throwable {
		// Schedule some responses.
		String mockResponseBody = "{\"concepts\": [{\"cui\": \"cui\", \"ontology\": \"ontology\", \"preferredName\": \"preferredName\", \"alternativeName\": \"alternativeName\", \"semanticType\": \"semanticType\", \"rank\": 4, \"hitCount\": 8, \"score\": 5, \"surfaceForms\": [\"surfaceForms\"]}]}";
		String typeaheadPath = "/v1/corpora/testString/search/typeahead";

		server.enqueue(
				new MockResponse().setHeader("Content-type", "application/json")
						.setResponseCode(200).setBody(mockResponseBody));

		constructClientService();

		// Construct an instance of the TypeaheadOptions model
		TypeaheadOptions typeaheadOptionsModel = new TypeaheadOptions.Builder()
				.corpus("testString").query("testString")
				.ontologies(new ArrayList<String>(Arrays.asList("concepts")))
				.types(new ArrayList<String>(Arrays.asList("testString")))
				.category("disorders").verbose(true).limit(Long.valueOf("26"))
				.maxHitCount(Long.valueOf("26")).noDuplicates(true).build();

		// Invoke operation with valid options model (positive test)
		Response<ConceptListModel> response = testService
				.typeahead(typeaheadOptionsModel).execute();
		assertNotNull(response);
		ConceptListModel responseObj = response.getResult();
		assertNotNull(responseObj);

		// Verify the contents of the request
		RecordedRequest request = server.takeRequest();
		assertNotNull(request);
		assertEquals(request.getMethod(), "GET");

		// Check query
		Map<String, String> query = TestUtilities.parseQueryString(request);
		assertNotNull(query);
		// Get query params
		assertEquals(query.get("version"), "testString");
		assertEquals(query.get("query"), "testString");
		assertEquals(Arrays.asList(query.get("ontologies")),
				new ArrayList<String>(Arrays.asList("concepts")));
		assertEquals(Arrays.asList(query.get("types")),
				new ArrayList<String>(Arrays.asList("testString")));
		assertEquals(query.get("category"), "disorders");
		assertEquals(Boolean.valueOf(query.get("verbose")),
				Boolean.valueOf(true));
		assertEquals(Long.valueOf(query.get("_limit")), Long.valueOf("26"));
		assertEquals(Long.valueOf(query.get("max_hit_count")),
				Long.valueOf("26"));
		assertEquals(Boolean.valueOf(query.get("no_duplicates")),
				Boolean.valueOf(true));
		// Check request path
		String parsedPath = TestUtilities.parseReqPath(request);
		assertEquals(parsedPath, typeaheadPath);
	}

	// Test the typeahead operation with null options model parameter
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testTypeaheadNoOptions() throws Throwable {
		// construct the service
		constructClientService();

		server.enqueue(new MockResponse());

		// Invoke operation with null options model (negative test)
		testService.typeahead(null).execute();
	}

	@Test
	public void testGetConceptsWOptions() throws Throwable {
		// Schedule some responses.
		String mockResponseBody = "{\"concepts\": [{\"cui\": \"cui\", \"ontology\": \"ontology\", \"preferredName\": \"preferredName\", \"alternativeName\": \"alternativeName\", \"semanticType\": \"semanticType\", \"rank\": 4, \"hitCount\": 8, \"score\": 5, \"surfaceForms\": [\"surfaceForms\"]}]}";
		String getConceptsPath = "/v1/corpora/testString/concepts";

		server.enqueue(
				new MockResponse().setHeader("Content-type", "application/json")
						.setResponseCode(200).setBody(mockResponseBody));

		constructClientService();

		// Construct an instance of the GetConceptsOptions model
		GetConceptsOptions getConceptsOptionsModel = new GetConceptsOptions.Builder()
				.corpus("testString")
				.cuis(new ArrayList<String>(Arrays.asList("testString")))
				.preferredNames(
						new ArrayList<String>(Arrays.asList("testString")))
				.surfaceForms(
						new ArrayList<String>(Arrays.asList("testString")))
				.attributes(new ArrayList<String>(Arrays.asList("testString")))
				.verbose(true).sort("hitCount").limit(Long.valueOf("26"))
				.build();

		// Invoke operation with valid options model (positive test)
		Response<ConceptListModel> response = testService
				.getConcepts(getConceptsOptionsModel).execute();
		assertNotNull(response);
		ConceptListModel responseObj = response.getResult();
		assertNotNull(responseObj);

		// Verify the contents of the request
		RecordedRequest request = server.takeRequest();
		assertNotNull(request);
		assertEquals(request.getMethod(), "GET");

		// Check query
		Map<String, String> query = TestUtilities.parseQueryString(request);
		assertNotNull(query);
		// Get query params
		assertEquals(query.get("version"), "testString");
		assertEquals(Arrays.asList(query.get("cuis")),
				new ArrayList<String>(Arrays.asList("testString")));
		assertEquals(Arrays.asList(query.get("preferred_names")),
				new ArrayList<String>(Arrays.asList("testString")));
		assertEquals(Arrays.asList(query.get("surface_forms")),
				new ArrayList<String>(Arrays.asList("testString")));
		assertEquals(Arrays.asList(query.get("attributes")),
				new ArrayList<String>(Arrays.asList("testString")));
		assertEquals(Boolean.valueOf(query.get("verbose")),
				Boolean.valueOf(true));
		assertEquals(query.get("_sort"), "hitCount");
		assertEquals(Long.valueOf(query.get("_limit")), Long.valueOf("26"));
		// Check request path
		String parsedPath = TestUtilities.parseReqPath(request);
		assertEquals(parsedPath, getConceptsPath);
	}

	// Test the getConcepts operation with null options model parameter
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testGetConceptsNoOptions() throws Throwable {
		// construct the service
		constructClientService();

		server.enqueue(new MockResponse());

		// Invoke operation with null options model (negative test)
		testService.getConcepts(null).execute();
	}

	@Test
	public void testAddArtifactWOptions() throws Throwable {
		// Schedule some responses.
		String mockResponseBody = "";
		String addArtifactPath = "/v1/corpora/testString/concepts/definitions";

		server.enqueue(new MockResponse().setResponseCode(200)
				.setBody(mockResponseBody));

		constructClientService();

		// Construct an instance of the PossbileValues model
		PossibleValues possbileValuesModel = new PossibleValues.Builder()
				.displayValue("testString").value("testString").build();

		// Construct an instance of the AttributeEntry model
		AttributeEntry attributeEntryModel = new AttributeEntry.Builder()
				.attrName("testString").dataType("testString")
				.defaultValue("testString").description("testString")
				.displayName("testString").docId("testString")
				.fieldValues(new ArrayList<String>(Arrays.asList("testString")))
				.maximumValue("testString").minimumValue("testString")
				.multiValue(true).units("testString").valueType("testString")
				.possibleValues(new ArrayList<PossibleValues>(
						Arrays.asList(possbileValuesModel)))
				.build();

		// Construct an instance of the DictonaryEntry model
		DictonaryEntry dictonaryEntryModel = new DictonaryEntry.Builder()
				.children(new ArrayList<String>(Arrays.asList("testString")))
				.cui("testString")
				.definition(new ArrayList<String>(Arrays.asList("testString")))
				.parents(new ArrayList<String>(Arrays.asList("testString")))
				.preferredName("testString")
				.semtypes(new ArrayList<String>(Arrays.asList("testString")))
				.siblings(new ArrayList<String>(Arrays.asList("testString")))
				.surfaceForms(
						new ArrayList<String>(Arrays.asList("testString")))
				.variants(new ArrayList<String>(Arrays.asList("testString")))
				.vocab("testString")
				.related(new ArrayList<String>(Arrays.asList("testString")))
				.source("testString").sourceVersion("testString").build();

		// Construct an instance of the AddArtifactOptions model
		AddArtifactOptions addArtifactOptionsModel = new AddArtifactOptions.Builder()
				.corpus("testString").dictionaryEntry(dictonaryEntryModel)
				.attributeEntry(attributeEntryModel).build();

		// Invoke operation with valid options model (positive test)
		Response<Void> response = testService
				.addArtifact(addArtifactOptionsModel).execute();
		assertNotNull(response);
		Void responseObj = response.getResult();
		// Response does not have a return type. Check that the result is null.
		assertNull(responseObj);

		// Verify the contents of the request
		RecordedRequest request = server.takeRequest();
		assertNotNull(request);
		assertEquals(request.getMethod(), "POST");

		// Check query
		Map<String, String> query = TestUtilities.parseQueryString(request);
		assertNotNull(query);
		// Get query params
		assertEquals(query.get("version"), "testString");
		// Check request path
		String parsedPath = TestUtilities.parseReqPath(request);
		assertEquals(parsedPath, addArtifactPath);
	}

	// Test the addArtifact operation with null options model parameter
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testAddArtifactNoOptions() throws Throwable {
		// construct the service
		constructClientService();

		server.enqueue(new MockResponse());

		// Invoke operation with null options model (negative test)
		testService.addArtifact(null).execute();
	}

	@Test
	public void testGetCuiInfoWOptions() throws Throwable {
		// Schedule some responses.
		String mockResponseBody = "{\"cui\": \"cui\", \"ontology\": \"ontology\", \"preferredName\": \"preferredName\", \"semanticTypes\": [\"semanticTypes\"], \"surfaceForms\": [\"surfaceForms\"], \"definition\": \"definition\", \"hasParents\": true, \"hasChildren\": false, \"hasSiblings\": false}";
		String getCuiInfoPath = "/v1/corpora/testString/concepts/testString";

		server.enqueue(
				new MockResponse().setHeader("Content-type", "application/json")
						.setResponseCode(200).setBody(mockResponseBody));

		constructClientService();

		// Construct an instance of the GetCuiInfoOptions model
		GetCuiInfoOptions getCuiInfoOptionsModel = new GetCuiInfoOptions.Builder()
				.corpus("testString").nameOrId("testString")
				.ontology("testString").fields("testString").treeLayout(true)
				.build();

		// Invoke operation with valid options model (positive test)
		Response<ConceptInfoModel> response = testService
				.getCuiInfo(getCuiInfoOptionsModel).execute();
		assertNotNull(response);
		ConceptInfoModel responseObj = response.getResult();
		assertNotNull(responseObj);

		// Verify the contents of the request
		RecordedRequest request = server.takeRequest();
		assertNotNull(request);
		assertEquals(request.getMethod(), "GET");

		// Check query
		Map<String, String> query = TestUtilities.parseQueryString(request);
		assertNotNull(query);
		// Get query params
		assertEquals(query.get("version"), "testString");
		assertEquals(query.get("ontology"), "testString");
		assertEquals(query.get("_fields"), "testString");
		assertEquals(Boolean.valueOf(query.get("tree_layout")),
				Boolean.valueOf(true));
		// Check request path
		String parsedPath = TestUtilities.parseReqPath(request);
		assertEquals(parsedPath, getCuiInfoPath);
	}

	// Test the getCuiInfo operation with null options model parameter
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testGetCuiInfoNoOptions() throws Throwable {
		// construct the service
		constructClientService();

		server.enqueue(new MockResponse());

		// Invoke operation with null options model (negative test)
		testService.getCuiInfo(null).execute();
	}

	@Test
	public void testGetHitCountWOptions() throws Throwable {
		// Schedule some responses.
		String mockResponseBody = "{\"hitCount\": 8}";
		String getHitCountPath = "/v1/corpora/testString/concepts/testString/hit_count";

		server.enqueue(
				new MockResponse().setHeader("Content-type", "application/json")
						.setResponseCode(200).setBody(mockResponseBody));

		constructClientService();

		// Construct an instance of the GetHitCountOptions model
		GetHitCountOptions getHitCountOptionsModel = new GetHitCountOptions.Builder()
				.corpus("testString").nameOrId("testString")
				.ontology("testString").build();

		// Invoke operation with valid options model (positive test)
		Response<HitCount> response = testService
				.getHitCount(getHitCountOptionsModel).execute();
		assertNotNull(response);
		HitCount responseObj = response.getResult();
		assertNotNull(responseObj);

		// Verify the contents of the request
		RecordedRequest request = server.takeRequest();
		assertNotNull(request);
		assertEquals(request.getMethod(), "GET");

		// Check query
		Map<String, String> query = TestUtilities.parseQueryString(request);
		assertNotNull(query);
		// Get query params
		assertEquals(query.get("version"), "testString");
		assertEquals(query.get("ontology"), "testString");
		// Check request path
		String parsedPath = TestUtilities.parseReqPath(request);
		assertEquals(parsedPath, getHitCountPath);
	}

	// Test the getHitCount operation with null options model parameter
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testGetHitCountNoOptions() throws Throwable {
		// construct the service
		constructClientService();

		server.enqueue(new MockResponse());

		// Invoke operation with null options model (negative test)
		testService.getHitCount(null).execute();
	}

	@Test
	public void testGetRelatedConceptsWOptions() throws Throwable {
		// Schedule some responses.
		String mockResponseBody = "{\"concepts\": [{\"cui\": \"cui\", \"ontology\": \"ontology\", \"preferredName\": \"preferredName\", \"alternativeName\": \"alternativeName\", \"semanticType\": \"semanticType\", \"rank\": 4, \"hitCount\": 8, \"score\": 5, \"surfaceForms\": [\"surfaceForms\"], \"nextConcepts\": [{\"cui\": \"cui\", \"ontology\": \"ontology\", \"preferredName\": \"preferredName\", \"alternativeName\": \"alternativeName\", \"semanticType\": \"semanticType\", \"rank\": 4, \"hitCount\": 8, \"score\": 5, \"surfaceForms\": [\"surfaceForms\"], \"nextConcepts\": [{\"cui\": \"cui\", \"ontology\": \"ontology\", \"preferredName\": \"preferredName\", \"alternativeName\": \"alternativeName\", \"semanticType\": \"semanticType\", \"rank\": 4, \"hitCount\": 8, \"score\": 5, \"surfaceForms\": [\"surfaceForms\"], \"nextConcepts\": [{\"cui\": \"cui\", \"ontology\": \"ontology\", \"preferredName\": \"preferredName\", \"alternativeName\": \"alternativeName\", \"semanticType\": \"semanticType\", \"rank\": 4, \"hitCount\": 8, \"score\": 5, \"surfaceForms\": [\"surfaceForms\"], \"nextConcepts\": [{\"cui\": \"cui\", \"ontology\": \"ontology\", \"preferredName\": \"preferredName\", \"alternativeName\": \"alternativeName\", \"semanticType\": \"semanticType\", \"rank\": 4, \"hitCount\": 8, \"score\": 5, \"surfaceForms\": [\"surfaceForms\"], \"nextConcepts\": [{\"cui\": \"cui\", \"ontology\": \"ontology\", \"preferredName\": \"preferredName\", \"alternativeName\": \"alternativeName\", \"semanticType\": \"semanticType\", \"rank\": 4, \"hitCount\": 8, \"score\": 5, \"surfaceForms\": [\"surfaceForms\"], \"nextConcepts\": [{\"cui\": \"cui\", \"ontology\": \"ontology\", \"preferredName\": \"preferredName\", \"alternativeName\": \"alternativeName\", \"semanticType\": \"semanticType\", \"rank\": 4, \"hitCount\": 8, \"score\": 5, \"surfaceForms\": [\"surfaceForms\"], \"nextConcepts\": [{\"cui\": \"cui\", \"ontology\": \"ontology\", \"preferredName\": \"preferredName\", \"alternativeName\": \"alternativeName\", \"semanticType\": \"semanticType\", \"rank\": 4, \"hitCount\": 8, \"score\": 5, \"surfaceForms\": [\"surfaceForms\"], \"nextConcepts\": [{\"cui\": \"cui\", \"ontology\": \"ontology\", \"preferredName\": \"preferredName\", \"alternativeName\": \"alternativeName\", \"semanticType\": \"semanticType\", \"rank\": 4, \"hitCount\": 8, \"score\": 5, \"surfaceForms\": [\"surfaceForms\"], \"nextConcepts\": []}]}]}]}]}]}]}]}]}]}";
		String getRelatedConceptsPath = "/v1/corpora/testString/concepts/testString/related_concepts";

		server.enqueue(
				new MockResponse().setHeader("Content-type", "application/json")
						.setResponseCode(200).setBody(mockResponseBody));

		constructClientService();

		// Construct an instance of the GetRelatedConceptsOptions model
		GetRelatedConceptsOptions getRelatedConceptsOptionsModel = new GetRelatedConceptsOptions.Builder()
				.corpus("testString").nameOrId("testString")
				.relationship("children").ontology("testString")
				.relationshipAttributes(
						new ArrayList<String>(Arrays.asList("testString")))
				.sources(new ArrayList<String>(Arrays.asList("testString")))
				.recursive(true).treeLayout(true).maxDepth(Long.valueOf("26"))
				.build();

		// Invoke operation with valid options model (positive test)
		Response<RelatedConceptsModel> response = testService
				.getRelatedConcepts(getRelatedConceptsOptionsModel).execute();
		assertNotNull(response);
		RelatedConceptsModel responseObj = response.getResult();
		assertNotNull(responseObj);

		// Verify the contents of the request
		RecordedRequest request = server.takeRequest();
		assertNotNull(request);
		assertEquals(request.getMethod(), "GET");

		// Check query
		Map<String, String> query = TestUtilities.parseQueryString(request);
		assertNotNull(query);
		// Get query params
		assertEquals(query.get("relationship"), "children");
		assertEquals(query.get("version"), "testString");
		assertEquals(query.get("ontology"), "testString");
		assertEquals(Arrays.asList(query.get("relationship_attributes")),
				new ArrayList<String>(Arrays.asList("testString")));
		assertEquals(Arrays.asList(query.get("sources")),
				new ArrayList<String>(Arrays.asList("testString")));
		assertEquals(Boolean.valueOf(query.get("recursive")),
				Boolean.valueOf(true));
		assertEquals(Boolean.valueOf(query.get("tree_layout")),
				Boolean.valueOf(true));
		assertEquals(Long.valueOf(query.get("max_depth")), Long.valueOf("26"));
		// Check request path
		String parsedPath = TestUtilities.parseReqPath(request);
		assertEquals(parsedPath, getRelatedConceptsPath);
	}

	// Test the getRelatedConcepts operation with null options model parameter
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testGetRelatedConceptsNoOptions() throws Throwable {
		// construct the service
		constructClientService();

		server.enqueue(new MockResponse());

		// Invoke operation with null options model (negative test)
		testService.getRelatedConcepts(null).execute();
	}

	@Test
	public void testGetSimilarConceptsWOptions() throws Throwable {
		// Schedule some responses.
		String mockResponseBody = "{\"concepts\": [{\"cui\": \"cui\", \"ontology\": \"ontology\", \"preferredName\": \"preferredName\", \"alternativeName\": \"alternativeName\", \"semanticType\": \"semanticType\", \"rank\": 4, \"hitCount\": 8, \"score\": 5, \"surfaceForms\": [\"surfaceForms\"]}]}";
		String getSimilarConceptsPath = "/v1/corpora/testString/concepts/testString/similar_concepts";

		server.enqueue(
				new MockResponse().setHeader("Content-type", "application/json")
						.setResponseCode(200).setBody(mockResponseBody));

		constructClientService();

		// Construct an instance of the GetSimilarConceptsOptions model
		GetSimilarConceptsOptions getSimilarConceptsOptionsModel = new GetSimilarConceptsOptions.Builder()
				.corpus("testString").nameOrId("testString")
				.returnOntologies(
						new ArrayList<String>(Arrays.asList("testString")))
				.ontology("testString").limit(Long.valueOf("26")).build();

		// Invoke operation with valid options model (positive test)
		Response<ConceptListModel> response = testService
				.getSimilarConcepts(getSimilarConceptsOptionsModel).execute();
		assertNotNull(response);
		ConceptListModel responseObj = response.getResult();
		assertNotNull(responseObj);

		// Verify the contents of the request
		RecordedRequest request = server.takeRequest();
		assertNotNull(request);
		assertEquals(request.getMethod(), "GET");

		// Check query
		Map<String, String> query = TestUtilities.parseQueryString(request);
		assertNotNull(query);
		// Get query params
		assertEquals(query.get("version"), "testString");
		assertEquals(Arrays.asList(query.get("return_ontologies")),
				new ArrayList<String>(Arrays.asList("testString")));
		assertEquals(query.get("ontology"), "testString");
		assertEquals(Long.valueOf(query.get("_limit")), Long.valueOf("26"));
		// Check request path
		String parsedPath = TestUtilities.parseReqPath(request);
		assertEquals(parsedPath, getSimilarConceptsPath);
	}

	// Test the getSimilarConcepts operation with null options model parameter
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testGetSimilarConceptsNoOptions() throws Throwable {
		// construct the service
		constructClientService();

		server.enqueue(new MockResponse());

		// Invoke operation with null options model (negative test)
		testService.getSimilarConcepts(null).execute();
	}

	@Test
	public void testTokenizeWOptions() throws Throwable {
		// Schedule some responses.
		String mockResponseBody = "{\"unstructured\": [{\"text\": \"text\", \"data\": {\"concepts\": [{\"uniqueId\": 8, \"stickyIds\": [9], \"section\": \"section\", \"type\": \"type\", \"begin\": 5, \"end\": 3, \"coveredText\": \"coveredText\", \"cui\": \"cui\", \"preferredName\": \"preferredName\", \"source\": \"source\", \"negated\": false, \"hypothetical\": true, \"timestamp\": 9, \"attributeId\": \"attributeId\", \"qualifiers\": [\"qualifiers\"], \"unit\": \"unit\", \"minValue\": \"minValue\", \"maxValue\": \"maxValue\", \"operator\": \"operator\", \"features\": {\"mapKey\": \"inner\"}, \"nluEntityIndex\": \"nluEntityIndex\", \"nluMentionIndex\": \"nluMentionIndex\", \"nluRelationId\": \"nluRelationId\", \"nluSide\": \"nluSide\", \"nluSourceType\": \"nluSourceType\", \"nluRelation\": \"nluRelation\", \"nluTargetType\": \"nluTargetType\", \"hits\": 4}], \"attributeValues\": [{\"uniqueId\": 8, \"stickyIds\": [9], \"section\": \"section\", \"type\": \"type\", \"begin\": 5, \"end\": 3, \"coveredText\": \"coveredText\", \"cui\": \"cui\", \"preferredName\": \"preferredName\", \"source\": \"source\", \"negated\": false, \"hypothetical\": true, \"timestamp\": 9, \"attributeId\": \"attributeId\", \"qualifiers\": [\"qualifiers\"], \"unit\": \"unit\", \"minValue\": \"minValue\", \"maxValue\": \"maxValue\", \"operator\": \"operator\", \"features\": {\"mapKey\": \"inner\"}, \"nluEntityIndex\": \"nluEntityIndex\", \"nluMentionIndex\": \"nluMentionIndex\", \"nluRelationId\": \"nluRelationId\", \"nluSide\": \"nluSide\", \"nluSourceType\": \"nluSourceType\", \"nluRelation\": \"nluRelation\", \"nluTargetType\": \"nluTargetType\", \"hits\": 4}], \"relations\": [{\"relationId\": \"relationId\", \"relation\": \"relation\", \"source\": {\"section\": \"section\", \"begin\": 5, \"end\": 3, \"coveredText\": \"coveredText\", \"source\": \"source\", \"type\": \"type\"}, \"target\": {\"section\": \"section\", \"begin\": 5, \"end\": 3, \"coveredText\": \"coveredText\", \"source\": \"source\", \"type\": \"type\"}}], \"mesh\": [{\"uniqueId\": 8, \"stickyIds\": [9], \"section\": \"section\", \"type\": \"type\", \"begin\": 5, \"end\": 3, \"coveredText\": \"coveredText\", \"cui\": \"cui\", \"preferredName\": \"preferredName\", \"source\": \"source\", \"negated\": false, \"hypothetical\": true, \"timestamp\": 9, \"attributeId\": \"attributeId\", \"qualifiers\": [\"qualifiers\"], \"unit\": \"unit\", \"minValue\": \"minValue\", \"maxValue\": \"maxValue\", \"operator\": \"operator\", \"features\": {\"mapKey\": \"inner\"}, \"nluEntityIndex\": \"nluEntityIndex\", \"nluMentionIndex\": \"nluMentionIndex\", \"nluRelationId\": \"nluRelationId\", \"nluSide\": \"nluSide\", \"nluSourceType\": \"nluSourceType\", \"nluRelation\": \"nluRelation\", \"nluTargetType\": \"nluTargetType\", \"hits\": 4}], \"text\": [{\"uniqueId\": 8, \"stickyIds\": [9], \"section\": \"section\", \"type\": \"type\", \"begin\": 5, \"end\": 3, \"coveredText\": \"coveredText\", \"cui\": \"cui\", \"preferredName\": \"preferredName\", \"source\": \"source\", \"negated\": false, \"hypothetical\": true, \"timestamp\": 9, \"attributeId\": \"attributeId\", \"qualifiers\": [\"qualifiers\"], \"unit\": \"unit\", \"minValue\": \"minValue\", \"maxValue\": \"maxValue\", \"operator\": \"operator\", \"features\": {\"mapKey\": \"inner\"}, \"nluEntityIndex\": \"nluEntityIndex\", \"nluMentionIndex\": \"nluMentionIndex\", \"nluRelationId\": \"nluRelationId\", \"nluSide\": \"nluSide\", \"nluSourceType\": \"nluSourceType\", \"nluRelation\": \"nluRelation\", \"nluTargetType\": \"nluTargetType\", \"hits\": 4}]}}]}";
		String tokenizePath = "/v1/corpora/testString/debug/analyze/testString";

		server.enqueue(
				new MockResponse().setHeader("Content-type", "application/json")
						.setResponseCode(200).setBody(mockResponseBody));

		constructClientService();

		// Construct an instance of the TokenizeOptions model
		TokenizeOptions tokenizeOptionsModel = new TokenizeOptions.Builder()
				.corpus("testString").flow("testString").body("testString")
				.ontologies(new ArrayList<String>(Arrays.asList("mesh")))
				.maxWords(Long.valueOf("26")).build();

		// Invoke operation with valid options model (positive test)
		Response<CommonDataModel> response = testService
				.tokenize(tokenizeOptionsModel).execute();
		assertNotNull(response);
		CommonDataModel responseObj = response.getResult();
		assertNotNull(responseObj);

		// Verify the contents of the request
		RecordedRequest request = server.takeRequest();
		assertNotNull(request);
		assertEquals(request.getMethod(), "POST");

		// Check query
		Map<String, String> query = TestUtilities.parseQueryString(request);
		assertNotNull(query);
		// Get query params
		assertEquals(query.get("version"), "testString");
		assertEquals(Arrays.asList(query.get("ontologies")),
				new ArrayList<String>(Arrays.asList("mesh")));
		assertEquals(Long.valueOf(query.get("max_words")), Long.valueOf("26"));
		// Check request path
		String parsedPath = TestUtilities.parseReqPath(request);
		assertEquals(parsedPath, tokenizePath);
	}

	// Test the tokenize operation with null options model parameter
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testTokenizeNoOptions() throws Throwable {
		// construct the service
		constructClientService();

		server.enqueue(new MockResponse());

		// Invoke operation with null options model (negative test)
		testService.tokenize(null).execute();
	}

	/** Initialize the server */
	@BeforeMethod
	public void setUpMockServer() {
		try {
			server = new MockWebServer();
			// register handler
			server.start();
		} catch (IOException err) {
			fail("Failed to instantiate mock web server");
		}
	}

	@AfterMethod
	public void tearDownMockServer() throws IOException {
		server.shutdown();
		testService = null;
	}
}