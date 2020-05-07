/**
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
package com.ibm.watson.health.acd.v1.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.junit.Before;
import org.junit.Test;

import com.ibm.watson.health.acd.v1.AnnotatorForClinicalData;
import com.ibm.watson.health.acd.v1.WatsonServiceUnitTest;
import com.ibm.watson.health.acd.v1.model.AcdFlow;
import com.ibm.watson.health.acd.v1.model.AcdProfile;
import com.ibm.watson.health.acd.v1.model.Annotator;
import com.ibm.watson.health.acd.v1.model.Annotator.Name;
import com.ibm.watson.health.acd.v1.model.AttributeValueAnnotation;
import com.ibm.watson.health.acd.v1.model.Concept;
import com.ibm.watson.health.acd.v1.model.ContainerGroup;
import com.ibm.watson.health.acd.v1.model.Flow;
import com.ibm.watson.health.acd.v1.model.GetFlowOptions;
import com.ibm.watson.health.acd.v1.model.GetFlowsOptions;
import com.ibm.watson.health.acd.v1.model.GetProfileOptions;
import com.ibm.watson.health.acd.v1.model.GetProfilesOptions;
import com.ibm.watson.health.acd.v1.model.ListAnnotator;
import com.ibm.watson.health.acd.v1.model.ListAnnotatorsOptions;
import com.ibm.watson.health.acd.v1.model.ListStringWrapper;
import com.ibm.watson.health.acd.v1.model.SpellCorrectedText;
import com.ibm.watson.health.acd.v1.model.SpellingCorrection;
import com.ibm.watson.health.acd.v1.model.Suggestion;
import com.ibm.watson.health.acd.v1.util.FlowUtil;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;

/**
 * Java SDK Mock unit testing for calling ACD APIs.
 *
 */
public class JavaSDKACDUnitTest extends WatsonServiceUnitTest {

	protected static final String ANALYZE_PATH = "/v1/analyze";
	protected static final String ANNOTATORS_PATH = "/v1/annotators";
	protected static final String FLOWS_PATH = "/v1/flows";
	protected static final String PROFILES_PATH = "/v1/profiles";
	protected static final String RESOURCE = "src/test/resources/";
	protected static final String VERSION = "2018-06-20";
	protected static final String VERSION_QRY_PARAM = "?version=2018-06-20";
    protected static final String RETURN_ANALYZED_TEXT_QRY_PARM = "&return_analyzed_text=false";
    private static Properties props = null;

	private AnnotatorForClinicalData service;
	private MockWebServer server;


	public static Properties loadProperties(InputStream stream) {
		props = new Properties();
		try {
			props.load(stream);
		} catch (IOException e) {
			System.out.println("could not load properties");
		}
		return props;
	}
	/*
	 * (non-Javadoc)
	 * @see com.ibm.watson.developer_cloud.WatsonServiceTest#setUp()
	 */
	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
		server = this.getServer();
		InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties");
		if (input == null) {
			input = Thread.currentThread().getContextClassLoader().getResourceAsStream(".config.properties");
		}
		props = loadProperties(input);
		service = new AnnotatorForClinicalData(VERSION, props.getProperty("URL"));
		service.setServiceUrl(getMockWebServerUrl());
	}

	/**
	 * TEST: Get an annotator definition using mock response.
	 * Build a mock GET /annotators/{id} response with HTTP 200 - Get
	 * the mock 'concept detection' annotator definition - Assert annotator description is correct
	 *
	 * @throws FileNotFoundException
	 * @throws InterruptedException
	 */
	@Test
	public void testSDKMockACDGetAnnotatorG() throws FileNotFoundException, InterruptedException {
		Annotator mockResponse = loadFixture(RESOURCE + "testSDK_MockACD_GetAnnotator_G.json", Annotator.class);

		server.enqueue(jsonResponse(mockResponse));
		final Annotator annotator = service.getAnnotator(Name.CONCEPT_DETECTION);
		final RecordedRequest request = server.takeRequest();

		assertEquals(ANNOTATORS_PATH + "/" + Name.CONCEPT_DETECTION + VERSION_QRY_PARAM, request.getPath());
		assertEquals(GET, request.getMethod());
		assertEquals(mockResponse, annotator);
	}

	/**
	 * TEST: Get an invalid annotator definition using mock response - Build a mock GET /annotators/{id} response with HTTP 404
	 * and expected exception as body content - Get the definition of the 'Invalid' annotator - Assert response is exception and
	 * verify its accuracy/usefulness.
	 *
	 * @throws FileNotFoundException
	 * @throws InterruptedException
	 */
	@Test
	public void testSDKMockACDGetAnnotatorE() throws FileNotFoundException, InterruptedException {
		String jsonString = getStringFromInputStream(
				new FileInputStream(RESOURCE + "testSDK_MockACD_GetAnnotator_E.json"));
		Annotator annotator = null;

		server.enqueue(new MockResponse().setBody(jsonString).setResponseCode(404));

		try {
			annotator = service.getAnnotator("Invalid");
		} catch (Exception e) {
			assertEquals("Expect not found exception.", "Annotator ID: Invalid was not found in the list.",
					e.getMessage());
		} finally {
			assertNull(annotator);
			RecordedRequest request = server.takeRequest();
			assertEquals(ANNOTATORS_PATH + "/Invalid" + VERSION_QRY_PARAM, request.getPath());
			assertEquals(GET, request.getMethod());
		}
	}

	/**
	 * TEST: Get list of annotator definitions using mock response - Get the list of annotators - Assert response is not null
	 * and includes at least 21 annotators.
	 *
	 * @throws FileNotFoundException
	 * @throws InterruptedException
	 */
	@Test
	public void testSDKMockACDGetAnnotatorsListG() throws FileNotFoundException, InterruptedException {
		ListAnnotator mockResponse = loadFixture(RESOURCE + "testSDK_MockACD_GetAnnotatorsList_G.json",
				ListAnnotator.class);
		ListAnnotatorsOptions listAnnotatorsOptions = new ListAnnotatorsOptions.Builder().build();

		server.enqueue(jsonResponse(mockResponse));
		String annotators = service.listAnnotators(listAnnotatorsOptions).execute().getResult();
		final RecordedRequest request = server.takeRequest();

		assertEquals(ANNOTATORS_PATH + VERSION_QRY_PARAM, request.getPath());
		assertEquals(GET, request.getMethod());
		assertNotNull(annotators);
		assertEquals("Expect annotators list is empty", "{}", annotators.toString());
	}

	/**
	 * TEST: Get list of flow definitions using mock response which includes at least the 2 predefined flows.
	 *
	 * @throws FileNotFoundException
	 * @throws InterruptedException
	 */
	@Test
	public void testSDKMockACDGetFlowsG() throws FileNotFoundException, InterruptedException {
		// TODO - figure out how to correctly load the list of flows (List<AcdFlow> objects)
		ListStringWrapper mockResponse = loadFixture(RESOURCE + "testSDK_MockACD_GetFlows_G.json",
				ListStringWrapper.class);
		System.out.println("mock: " + mockResponse);
		GetFlowsOptions getFlowsOptions = new GetFlowsOptions.Builder().build();

		server.enqueue(jsonResponse(mockResponse));
		String flows = service.getFlows(getFlowsOptions).execute().getResult();
		final RecordedRequest request = server.takeRequest();

		assertEquals(FLOWS_PATH + VERSION_QRY_PARAM, request.getPath());
		assertEquals(GET, request.getMethod());
		assertNotNull(flows);
		System.out.println("flows: " + flows);
		assertEquals("Expect flows list is empty", "{}", flows.toString());
		// assertTrue("Expect general cancer flow", flows.contains("general_cancer_v1.0_flow"));
		// assertTrue("Expect general medical flow", flows.contains("general_medical_v1.0_flow"));
	}

	/**
	 * TEST: Get a flow definition using mock response - Build a mock GET /flows/{id} response with HTTP 200 - Get the
	 * definition of the 'general_medical_v1.0_flow' flow - Assert response is not null and flow name is correct.
	 *
	 * @throws FileNotFoundException
	 * @throws InterruptedException
	 */
	@Test
	public void testSDKMockACDGetFlowG() throws FileNotFoundException, InterruptedException {
		AcdFlow mockResponse = loadFixture(RESOURCE + "testSDK_MockACD_GetFlow_G.json", AcdFlow.class);
		GetFlowOptions getFlowOptions = new GetFlowOptions.Builder("general_medical_v1.0_flow").build();

		server.enqueue(jsonResponse(mockResponse));
		AcdFlow flow = service.getFlow(getFlowOptions).execute().getResult();
		final RecordedRequest request = server.takeRequest();

		assertEquals(FLOWS_PATH + "/general_medical_v1.0_flow" + VERSION_QRY_PARAM, request.getPath());
		assertEquals(GET, request.getMethod());
		assertNotNull(flow);
		System.out.println("flow: " + flow);
		assertEquals("General Medical V1.0 Flow", flow.getName());
	}

	/**
	 * TEST: Get an invalid flow definition using mock response - Build a mock GET /flows/{id} response with HTTP 404 and
	 * expected exception as body content - Get the definition of the 'Invalid' flow - Assert response is exception and verify
	 * its accuracy/usefulness.
	 *
	 * @throws FileNotFoundException
	 * @throws InterruptedException
	 */
	@Test
	public void testSDKMockACDGetFlowE() throws FileNotFoundException, InterruptedException {
		String jsonString = getStringFromInputStream(new FileInputStream(RESOURCE + "testSDK_MockACD_GetFlow_E.json"));
		GetFlowOptions getFlowOptions = new GetFlowOptions.Builder("Invalid").build();
		AcdFlow flow = null;

		server.enqueue(new MockResponse().setBody(jsonString).setResponseCode(404));

		try {
			flow = service.getFlow(getFlowOptions).execute().getResult();
		} catch (Exception e) {
			assertEquals("Expect not found exception.", "Flow ID: Invalid was not found in the list.", e.getMessage());
		} finally {
			assertNull(flow);
			RecordedRequest request = server.takeRequest();
			assertEquals(FLOWS_PATH + "/Invalid" + VERSION_QRY_PARAM, request.getPath());
			assertEquals(GET, request.getMethod());
		}
	}

	/**
	 * TEST: Get list of profile definitions using mock response -
	 * Get the list of profiles - Assert response is not null and
	 * includes at least the 2 predefined profiles.
	 *
	 * @throws FileNotFoundException
	 * @throws InterruptedException
	 */
	@Test
	public void testSDKMockACDGetProfilesG() throws FileNotFoundException, InterruptedException {
		// TODO - figure out how to correctly load the list of profiles (List<AcdProfilew> objects)
		AcdProfile mockResponse = loadFixture(RESOURCE + "testSDK_MockACD_GetProfiles_G.json", AcdProfile.class);
		System.out.println("mockGetProfiles: " + mockResponse);
		GetProfilesOptions getProfilesOptions = new GetProfilesOptions.Builder().build();

		server.enqueue(jsonResponse(mockResponse));
		String profiles = service.getProfiles(getProfilesOptions).execute().getResult();
		final RecordedRequest request = server.takeRequest();

		assertEquals(PROFILES_PATH + VERSION_QRY_PARAM, request.getPath());
		assertEquals(GET, request.getMethod());
		assertNotNull(profiles);
		System.out.println("profiles: " + profiles);
		assertEquals("Expect flows list is empty", "{}", profiles.toString());
		// assertTrue("Expect general cancer profile", profiles.contains("general_cancer_v1.0"));
		// assertTrue("Expect general medical profile", profiles.contains("general_medical_v1.0"));

	}

	/**
	 * TEST: Get a profile definition using mock response - Get the definition of the 'general_medical_v1.0' profile - Assert
	 * response is not null and profile name is correct.
	 *
	 * @throws FileNotFoundException
	 * @throws InterruptedException
	 */
	@Test
	public void testSDKMockACDGetProfileG() throws FileNotFoundException, InterruptedException {
		AcdProfile mockResponse = loadFixture(RESOURCE + "testSDK_MockACD_GetProfile_G.json", AcdProfile.class);
		System.out.println("mockGetProfile: " + mockResponse);
		GetProfileOptions getProfileOptions = new GetProfileOptions.Builder("general_medical_v1.0").build();

		server.enqueue(jsonResponse(mockResponse));
		AcdProfile profile = service.getProfile(getProfileOptions).execute().getResult();
		final RecordedRequest request = server.takeRequest();

		assertEquals(PROFILES_PATH + "/general_medical_v1.0" + VERSION_QRY_PARAM, request.getPath());
		assertEquals(GET, request.getMethod());
		assertNotNull(profile);
		assertEquals("General Medical V1.0 Profile", profile.getName());
	}

	/**
	 * TEST: Get an invalid profile definition using mock response - Build a mock GET /profiles/{id} response with HTTP 404 and
	 * expected exception as body content - Get the definition of the 'Invalid' profile - Assert response is exception and
	 * verify its accuracy/usefulness.
	 *
	 * @throws FileNotFoundException
	 * @throws InterruptedException
	 */
	@Test
	public void testSDKMockACDGetProfileE() throws FileNotFoundException, InterruptedException {
		String jsonString = getStringFromInputStream(
				new FileInputStream(RESOURCE + "testSDK_MockACD_GetProfile_E.json"));
		GetProfileOptions getProfileOptions = new GetProfileOptions.Builder("Invalid").build();
		AcdProfile profile = null;

		server.enqueue(new MockResponse().setBody(jsonString).setResponseCode(404));

		try {
			profile = service.getProfile(getProfileOptions).execute().getResult();
		} catch (Exception e) {
			assertEquals("Expect not found exception.", "Profile ID: Invalid was not found in the list.",
					e.getMessage());
		} finally {
			assertNull(profile);
			RecordedRequest request = server.takeRequest();
			assertEquals(PROFILES_PATH + "/Invalid" + VERSION_QRY_PARAM, request.getPath());
			assertEquals(GET, request.getMethod());
		}
	}

	/**
	 * TEST: Get annotations using 'analyze' with flow definition using mock response - Build a mock POST /analyze response with
	 * HTTP 200 - Build a new Flow with the 'concept_detection' and 'symptom_disease' annotators - Call 'analyze' with some text
	 * and the new Flow - Assert response is not null and has concepts and symptom_disease_ind annotations.
	 *
	 * @throws FileNotFoundException
	 * @throws InterruptedException
	 */
	@Test
	public void testSDKMockACDAnalyzeFlowParamDynamicFlowG()
			throws InterruptedException, FileNotFoundException {

		ContainerGroup analyzeMockResponse = loadFixture(RESOURCE + "testSDK_MockACD_Analyze_FlowParam_DynamicFlow_G.json", ContainerGroup.class);

		List<String> annotators = new ArrayList<String>(Arrays.asList(Name.CONCEPT_DETECTION, Name.SYMPTOM_DISEASE));
		Flow flow = new FlowUtil.Builder().annotators(annotators).async(true).build();
		assertEquals("Expect 2 annotators in the flow", Integer.toString(flow.elements().size()), "2");

		server.enqueue(jsonResponse(analyzeMockResponse));
		final ContainerGroup response = service.analyze(
				"Patient has lung cancer, but did not smoke. She may consider chemotherapy as part of a treatment plan.",
				flow);
		final RecordedRequest request = server.takeRequest();

		assertEquals(ANALYZE_PATH + VERSION_QRY_PARAM + RETURN_ANALYZED_TEXT_QRY_PARM, request.getPath());
		assertEquals(POST, request.getMethod());
		assertNotNull(response);
		assertEquals(analyzeMockResponse, response);
	}

	/**
	 * TEST: Get annotations using 'analyze_with_flow' with persisted flow using mock response - Build a mock POST /analyze/{id}
	 * response with HTTP 200 - Call 'analyze_with_flow' using 'general_medical_v1.0_flow' - Assert response is not null and has
	 * concepts and attributes.
	 *
	 * @throws FileNotFoundException
	 * @throws InterruptedException
	 */
	@Test
	public void testSDKMockACDAnalyzeFlowParamPersistedFlowG()
			throws FileNotFoundException, InterruptedException {
		ContainerGroup analyzeMockResponse = loadFixture(
				RESOURCE + "testSDK_MockACD_Analyze_FlowParam_PersistedFlow_G.json", ContainerGroup.class);

		server.enqueue(jsonResponse(analyzeMockResponse));
		ContainerGroup response = service.analyzeWithFlow("general_medical_v1.0_flow", "Patient has heart disease.");
		final RecordedRequest request = server.takeRequest();

		assertEquals(ANALYZE_PATH + "/general_medical_v1.0_flow" + VERSION_QRY_PARAM + RETURN_ANALYZED_TEXT_QRY_PARM, request.getPath());
		assertEquals(POST, request.getMethod());
		assertNotNull(response);
		assertNotNull(response.getAttributeValues());
		assertNotNull(response.getConcepts());
		AttributeValueAnnotation attrAnno = response.getAttributeValues(0);
		assertEquals("heart disease", attrAnno.getCoveredText());
	}

	/**
	 * TEST: Get annotations using 'analyze' with invalid flow definition using mock response - Build a mock POST /analyze
	 * response with HTTP 400 and expected exception as body content - Build a new Flow with concept_detection and the 'Invalid'
	 * annotator in the flow - Call 'analyze' with some text and the new Flow - Assert response is exception and verify its
	 * accuracy/usefulness.
	 *
	 * @throws FileNotFoundException
	 * @throws InterruptedException
	 */
	@Test
	public void testSDKMockACDAnalyzeFlowParamInvalidFlowE()
			throws FileNotFoundException, InterruptedException {
		String jsonString = getStringFromInputStream(
				new FileInputStream(RESOURCE + "testSDK_MockACD_Analyze_FlowParam_InvalidFlow_E.json"));
		List<String> annotators = new ArrayList<String>(Arrays.asList(Name.CONCEPT_DETECTION, "Invalid"));
		Flow flow = new FlowUtil.Builder().annotators(annotators).async(true).build();
		ContainerGroup response = null;

		server.enqueue(new MockResponse().setBody(jsonString).setResponseCode(400));

		try {
			response = service.analyze("Patient has diabetes", flow);
		} catch (Exception e) {
			assertEquals("Expect not found exception.", "Bad Request", e.getMessage());
		} finally {
			assertNull(response);
			RecordedRequest request = server.takeRequest();
			assertEquals(ANALYZE_PATH + VERSION_QRY_PARAM + RETURN_ANALYZED_TEXT_QRY_PARM, request.getPath());
			assertEquals(POST, request.getMethod());
		}
	}


	@Test
	public void testSDKMockACDAnalyzeSectionsPersistedFlowG()
			throws FileNotFoundException, InterruptedException {

		List<String> annotators = new ArrayList<String>(Arrays.asList(Name.SECTION, Name.CONCEPT_DETECTION,
				Name.SYMPTOM_DISEASE));
		Flow flow = new FlowUtil.Builder().annotators(annotators).async(true).build();
		assertEquals("Expect 3 annotators in the flow", Integer.toString(flow.elements().size()), "3");

		String sFixture = "sections" + File.separator + "testSDK_MockACD_Analyze_Sections_PersistedFlow_G.json";
		ContainerGroup analyzeMockResponse = loadFixture(RESOURCE + sFixture, ContainerGroup.class);
		server.enqueue(jsonResponse(analyzeMockResponse));

		String sTxt = "DX: Patient has lung cancer, but did not smoke. \n HISTORY:"
				+ " She may consider chemotherapy as part of a treatment plan.";
		ContainerGroup response = service.analyze(sTxt, flow);
		final RecordedRequest request = server.takeRequest();

		assertEquals(ANALYZE_PATH + VERSION_QRY_PARAM + RETURN_ANALYZED_TEXT_QRY_PARM, request.getPath());
		assertNotNull(" Section  " + response.getSectionAnnotations());
		assertNotNull(response.getSectionAnnotations(0).getTrigger().getSectionNormalizedName());
		assertEquals("DX", response.getSectionAnnotations(0).getTrigger().getCoveredText());

	}


	@Test
	public void testSDKMockACDAnalyzeSectionsAttributeDetectionACIG()
			throws FileNotFoundException, InterruptedException {

		List<String> annotators = new ArrayList<String>(Arrays.asList(Name.SECTION, Name.CONCEPT_DETECTION,
				Name.SYMPTOM_DISEASE, Name.ATTRIBUTE_DETECTION));
		Flow flow = new FlowUtil.Builder().annotators(annotators).async(true).build();
		assertEquals("Expect 4 annotators in the flow", Integer.toString(flow.elements().size()), "4");

		String sFixture = "sections" + File.separator + "testSDK_MockACD_Analyze_Sections_AttributeDetection_ACI_G.json";
		ContainerGroup analyzeMockResponse = loadFixture(RESOURCE + sFixture, ContainerGroup.class);
		server.enqueue(jsonResponse(analyzeMockResponse));

		String sTxt = "HISTORY: He had a heart attack on Dec 23, 2011.";
		ContainerGroup response = service.analyze(sTxt, flow);
		final RecordedRequest request = server.takeRequest();

		assertEquals(ANALYZE_PATH + VERSION_QRY_PARAM + RETURN_ANALYZED_TEXT_QRY_PARM, request.getPath());
		assertNotNull(response.getSectionAnnotations());
		assertNotNull(response.getSectionAnnotations(0).getTrigger().getSectionNormalizedName());
		assertEquals("HISTORY", response.getSectionAnnotations(0).getTrigger().getCoveredText());

	}


	@Test
	public void testSDKMockACDAnalyzeSectionsAttributeDetectionDerivedG()
			throws FileNotFoundException, InterruptedException {

		List<String> annotators = new ArrayList<String>(Arrays.asList(Name.SECTION, Name.CONCEPT_DETECTION,
				Name.SYMPTOM_DISEASE, Name.ATTRIBUTE_DETECTION));
		Flow flow = new FlowUtil.Builder().annotators(annotators).async(true).build();
		assertEquals("Expect 4 annotators in the flow", Integer.toString(flow.elements().size()), "4");

		String sFixture = "sections" + File.separator + "testSDK_MockACD_Analyze_Sections_AttributeDetection_Derived_G.json";
		ContainerGroup analyzeMockResponse = loadFixture(RESOURCE + sFixture, ContainerGroup.class);
		server.enqueue(jsonResponse(analyzeMockResponse));

		String sTxt = "DX: Patient has lung cancer, but did not smoke. \n "
				+ "HISTORY: She may consider chemotherapy as part of a treatment plan.";
		ContainerGroup response = service.analyze(sTxt, flow);
		final RecordedRequest request = server.takeRequest();

		assertEquals(ANALYZE_PATH + VERSION_QRY_PARAM + RETURN_ANALYZED_TEXT_QRY_PARM, request.getPath());
		assertEquals("DX", response.getAttributeValues(2).getSectionNormalizedName());
		assertEquals("DX", response.getAttributeValues(2).getSectionSurfaceForm());
		assertEquals("height 74 inches", response.getAttributeValues(2).getCoveredText());

	}

	@Test
	public void testSDKMockACDAnalyzeSectionsNLUG() throws FileNotFoundException, InterruptedException {

		List<String> annotators = new ArrayList<String>(Arrays.asList(Name.SECTION, Name.NLU));
		Flow flow = new FlowUtil.Builder().annotators(annotators).async(true).build();
		assertEquals("Expect 2 annotators in the flow", Integer.toString(flow.elements().size()), "2");

		String sFixture = "sections" + File.separator + "testSDK_MockACD_Analyze_Sections_NLU_G.json";
		ContainerGroup analyzeMockResponse = loadFixture(RESOURCE + sFixture, ContainerGroup.class);
		server.enqueue(jsonResponse(analyzeMockResponse));

		String sTxt = "HISTORY OF PRESENT ILLNESS: A 5-month-old boy brought by his parents because of 2 days"
				+ " of cough. Mother took him when cough started 2 days go to Clinic where they told the mother"
				+ " he has viral infection and gave him Tylenol, but yesterday at night cough got worse and he "
				+ "also started having fever. Mother did not measure it.";
		ContainerGroup response = service.analyze(sTxt, flow);
		final RecordedRequest request = server.takeRequest();

		assertEquals(ANALYZE_PATH + VERSION_QRY_PARAM + RETURN_ANALYZED_TEXT_QRY_PARM, request.getPath());

		// Test NluEntities
		assertEquals(new Long(19), response.getNluEntity(0).getBegin());
		assertEquals(new Long(26), response.getNluEntity(0).getEnd());
		assertEquals("ILLNESS", response.getNluEntity(0).getCoveredText());
		assertEquals("HealthCondition", response.getNluEntity(0).getType());
		assertEquals("default_nlu_configuration", response.getNluEntity(0).getSource());
		assertEquals("history of present illness", response.getNluEntity(0).getSectionNormalizedName());
		assertEquals("HISTORY OF PRESENT ILLNESS", response.getNluEntity(0).getSectionSurfaceForm());
		assertEquals(new Double(0.828337), response.getNluEntity(0).getRelevance());

		// Test Relations
		assertEquals("parentOf", response.getRelation(1).getType());
		assertEquals(new Double(0.342823), response.getRelation(1).getScore());
		assertEquals("default_nlu_configuration", response.getRelation(1).getSource());
		assertEquals(new Long(4), response.getRelation(1).getNodes().get(0).getEntity().getUid());
		assertEquals(new Long(5), response.getRelation(1).getNodes().get(1).getEntity().getUid());

	}

	/**
	 *  Test the proper handling of relationship annotations from the relation annotator.
	 */
	@Test
	public void testSDKMockACDAnalyzeRelationsG() throws FileNotFoundException, InterruptedException {

		List<String> annotators = new ArrayList<String>(Arrays.asList(Name.CONCEPT_DETECTION, Name.RELATION));
		Flow flow = new FlowUtil.Builder().annotators(annotators).async(true).build();
		assertEquals("Expect 2 annotators in the flow", Integer.toString(flow.elements().size()), "2");

		String sFixture = "relations" + File.separator + "testSDK_MockACD_Analyze_Relations_G.json";
		ContainerGroup analyzeMockResponse = loadFixture(RESOURCE + sFixture, ContainerGroup.class);
		server.enqueue(jsonResponse(analyzeMockResponse));

		String sTxt = "HISTORY OF PRESENT ILLNESS: A 5-month-old boy brought by his parents because of 2 days"
				+ " of cough. Mother took him when cough started 2 days go to Clinic where they told the "
				+ "mother he has viral infection and gave him Tylenol, but yesterday at night cough got "
				+ "worse and he also started having fever. Mother did not measure it.";
		ContainerGroup response = service.analyze(sTxt, flow);
		final RecordedRequest request = server.takeRequest();

		assertEquals(ANALYZE_PATH + VERSION_QRY_PARAM + RETURN_ANALYZED_TEXT_QRY_PARM, request.getPath());

		// Test Relations
		assertEquals("may_be_treated_by", response.getRelation(0).getType());
		assertEquals("umls", response.getRelation(0).getSource());
		assertEquals(new Long(2), response.getRelation(0).getNodes().get(0).getEntity().getUid());
		assertEquals(new Long(3), response.getRelation(0).getNodes().get(1).getEntity().getUid());

	}

	enum MOCKCODES { ICD9, ICD10, SNOMED_CONCEPT_ID, NCI_CODE, MESH_ID, RX_NORM_ID, VOCABS, LOINC, CPT };

	/**
	 * Test special medical codes are accessible from the Concept.
	 * @throws FileNotFoundException
	 * @throws InterruptedException
	 */
	@Test
	public void testSDKMockACDAnalyzeMedCodesConceptsG() throws FileNotFoundException, InterruptedException {

		List<String> annotators = new ArrayList<String>(Arrays.asList(Name.CONCEPT_DETECTION,
				Name.SYMPTOM_DISEASE, Name.ATTRIBUTE_DETECTION));
		Flow flow = new FlowUtil.Builder().annotators(annotators).async(true).build();
		assertEquals("Expect 3 annotators in the flow", Integer.toString(flow.elements().size()), "3");


		String sFolder = "medcodes";
		String sFixture = sFolder + File.separator + "testSDK_MockACD_Analyze_MedCodes_Concepts_G.json";
		ContainerGroup analyzeMockResponse = loadFixture(RESOURCE + sFixture, ContainerGroup.class);
		server.enqueue(jsonResponse(analyzeMockResponse));

		String sTxt = "breast carcinoma treated with Docetaxel";
		ContainerGroup response = service.analyze(sTxt, flow);
		final RecordedRequest request = server.takeRequest();

		assertEquals(ANALYZE_PATH + VERSION_QRY_PARAM + RETURN_ANALYZED_TEXT_QRY_PARM, request.getPath());

		// []
		Concept aConcept = response.getConcepts(1);
		aConcept.setIcd9Code(MOCKCODES.ICD9.toString());
		aConcept.setIcd10Code(MOCKCODES.ICD10.toString());
		aConcept.setSnomedConceptId(MOCKCODES.SNOMED_CONCEPT_ID.toString());
		aConcept.setNciCode(MOCKCODES.NCI_CODE.toString());
		aConcept.setMeshId(MOCKCODES.MESH_ID.toString());
		aConcept.setRxNormId(MOCKCODES.RX_NORM_ID.toString());
		aConcept.setVocabs(MOCKCODES.VOCABS.toString());
		aConcept.setLoincId(MOCKCODES.LOINC.toString());
		aConcept.setCptCode(MOCKCODES.CPT.toString());

		assertEquals(MOCKCODES.ICD9.toString(), aConcept.getIcd9Code());
		assertEquals(MOCKCODES.ICD10.toString(), aConcept.getIcd10Code());
		assertEquals(MOCKCODES.SNOMED_CONCEPT_ID.toString(), aConcept.getSnomedConceptId());
		assertEquals(MOCKCODES.NCI_CODE.toString(), aConcept.getNciCode());
		assertEquals(MOCKCODES.MESH_ID.toString(), aConcept.getMeshId());
		assertEquals(MOCKCODES.RX_NORM_ID.toString(), aConcept.getRxNormId());
		assertEquals(MOCKCODES.VOCABS.toString(), aConcept.getVocabs());
		assertEquals(MOCKCODES.LOINC.toString(), aConcept.getLoincId());
		assertEquals(MOCKCODES.CPT.toString(), aConcept.getCptCode());

		// []
		assertEquals("C50.929,C50.919", response.getConcepts(0).getIcd10Code());
		assertEquals("254838004", response.getConcepts(0).getSnomedConceptId());
		assertEquals("C4872", response.getConcepts(0).getNciCode());
		assertEquals("M000637099", response.getConcepts(0).getMeshId());
		assertEquals("72962", response.getConcepts(4).getRxNormId());
		assertEquals("CHV,NCI,SNOMEDCT_US,COSTAR,NCI_NCI-GLOSS", response.getConcepts(0).getVocabs());
		assertEquals("44950,44955,1014622,1007583", response.getConcepts(5).getCptCode());
	}


	/**
	 * Test special medical codes are accessible from the Concept.
	 * @throws FileNotFoundException
	 * @throws InterruptedException
	 */
	@Test
	public void testSDKMockACDAnalyzeMedCodesAttributesG() throws FileNotFoundException, InterruptedException {

		List<String> annotators = new ArrayList<String>(Arrays.asList(Name.CONCEPT_DETECTION, Name.PROCEDURE, Name.ATTRIBUTE_DETECTION));
		Flow flow = new FlowUtil.Builder().annotators(annotators).async(true).build();
		assertEquals("Expect 3 annotators in the flow", Integer.toString(flow.elements().size()), "3");


		String sFolder = "medcodes";
		String sFixture = sFolder + File.separator + "testSDK_MockACD_Analyze_MedCodes_Attributes_G.json";
		ContainerGroup analyzeMockResponse = loadFixture(RESOURCE + sFixture, ContainerGroup.class);
		server.enqueue(jsonResponse(analyzeMockResponse));

		String sTxt = "appendectomy";
		ContainerGroup response = service.analyze(sTxt, flow);
		final RecordedRequest request = server.takeRequest();


		// []
		assertEquals(ANALYZE_PATH + VERSION_QRY_PARAM + RETURN_ANALYZED_TEXT_QRY_PARM, request.getPath());

		// []
		AttributeValueAnnotation av = response.getAttributeValues(1);
		av.setIcd9Code(MOCKCODES.ICD9.toString());
		av.setIcd10Code(MOCKCODES.ICD10.toString());
		av.setSnomedConceptId(MOCKCODES.SNOMED_CONCEPT_ID.toString());
		av.setNciCode(MOCKCODES.NCI_CODE.toString());
		av.setMeshId(MOCKCODES.MESH_ID.toString());
		av.setRxNormId(MOCKCODES.RX_NORM_ID.toString());
		av.setVocabs(MOCKCODES.VOCABS.toString());
		av.setLoincId(MOCKCODES.LOINC.toString());
		av.setCptCode(MOCKCODES.CPT.toString());

		assertEquals(MOCKCODES.ICD9.toString(), av.getIcd9Code());
		assertEquals(MOCKCODES.ICD10.toString(), av.getIcd10Code());
		assertEquals(MOCKCODES.SNOMED_CONCEPT_ID.toString(), av.getSnomedConceptId());
		assertEquals(MOCKCODES.NCI_CODE.toString(), av.getNciCode());
		assertEquals(MOCKCODES.MESH_ID.toString(), av.getMeshId());
		assertEquals(MOCKCODES.RX_NORM_ID.toString(), av.getRxNormId());
		assertEquals(MOCKCODES.VOCABS.toString(), av.getVocabs());
		assertEquals(MOCKCODES.LOINC.toString(), av.getLoincId());
		assertEquals(MOCKCODES.CPT.toString(), av.getCptCode());

		// []
		assertEquals("80146002", response.getAttributeValues(0).getSnomedConceptId());
		assertEquals("C51687", response.getAttributeValues(0).getNciCode());
		assertEquals("M0001608", response.getAttributeValues(0).getMeshId());
		assertEquals("44950,44955,1014622,1007583", response.getAttributeValues(0).getCptCode());

		// Includes a test of disambiguationData
		assertEquals("NO_DECISION", response.getAttributeValues(0).getDisambiguationData().getValidity());
	}

	/**
	 * Test call to the spell check service.
	 */
	@Test
	public void testSdkMockAcdAnalyzeSpellCheckG() throws FileNotFoundException, InterruptedException {
		List<String> annotators = new ArrayList<String>(Arrays.asList(Name.SPELL_CHECKER));
		Flow flow = new FlowUtil.Builder().annotators(annotators).async(true).build();
		assertEquals("Expect 1 annotators in the flow", Integer.toString(flow.elements().size()), "1");

		String sFolder = "spellCheck";
		String sFixture = sFolder + File.separator + "testSDK_MockACD_Analyze_SpellCheck_G.json";
		ContainerGroup analyzeMockResponse = loadFixture(RESOURCE + sFixture, ContainerGroup.class);
		server.enqueue(jsonResponse(analyzeMockResponse));

		String sTxt = "The patient has breast cancre";
		ContainerGroup response = service.analyze(sTxt, flow);
		final RecordedRequest request = server.takeRequest();

		assertEquals(ANALYZE_PATH + VERSION_QRY_PARAM + RETURN_ANALYZED_TEXT_QRY_PARM, request.getPath());

		/////// Test spellCorrectedText ///////
		SpellCorrectedText spellCorrectedText = response.getSpellCorrectedText(0);
		assertEquals(spellCorrectedText.getCorrectedText(), "Patients with stage II breast cancer");
		assertEquals(spellCorrectedText.getDebugText(), ">>>Patientts->Patients(0.96) <<< with stage II >>>breast cancre->breast cancer(0.97)<<<");

		///////  Test spellingCorrections section ///////
		assertEquals(response.getSpellingCorrections().size(), 2);
		List<SpellingCorrection> spellingCorrections = response.getSpellingCorrections();
		SpellingCorrection patientCorrection = spellingCorrections.get(0);
		assertEquals((Long) patientCorrection.getBegin(), (Long) 0L);
		assertEquals((Long) patientCorrection.getEnd(), (Long) 9L);
		assertEquals(patientCorrection.getCoveredText(), "Patientts");

		List<Suggestion> suggestions = patientCorrection.getSuggestions();
		assertEquals(suggestions.size(), 4);
		Suggestion firstSuggestion = suggestions.get(0);
		assertEquals(firstSuggestion.getApplied(), true);
		assertEquals((Double) firstSuggestion.getConfidence(), (Double) 0.96);
		assertEquals(firstSuggestion.getText(), "Patients");
		List<String> semtypes = firstSuggestion.getSemtypes();
		assertEquals(semtypes.get(0), "umls.PatientOrDisabledGroup");

		//Get the correction via the indexed version of the method
		SpellingCorrection breastCancerCorrection = response.getSpellingCorrections(1);
		assertEquals((Long) breastCancerCorrection.getBegin(), (Long) 24L);
		assertEquals((Long) breastCancerCorrection.getEnd(), (Long) 37L);
		assertEquals(breastCancerCorrection.getCoveredText(), "breast cancre");
		suggestions = breastCancerCorrection.getSuggestions();
		assertEquals(suggestions.size(), 1);
	}

}
