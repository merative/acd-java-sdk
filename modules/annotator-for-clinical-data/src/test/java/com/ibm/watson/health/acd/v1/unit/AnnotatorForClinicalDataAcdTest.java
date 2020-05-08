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
package com.ibm.watson.health.acd.v1.unit;

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
import com.ibm.watson.health.acd.v1.AnnotatorForClinicalData;
import com.ibm.watson.health.acd.v1.model.AcdCartridges;
import com.ibm.watson.health.acd.v1.model.AcdFlow;
import com.ibm.watson.health.acd.v1.model.AcdProfile;
import com.ibm.watson.health.acd.v1.model.AnalyticFlowBeanInput;
import com.ibm.watson.health.acd.v1.model.Annotator;
import com.ibm.watson.health.acd.v1.model.AnnotatorFlow;
import com.ibm.watson.health.acd.v1.model.CartridgesGetIdOptions;
import com.ibm.watson.health.acd.v1.model.CartridgesGetOptions;
import com.ibm.watson.health.acd.v1.model.CartridgesPostMultipartOptions;
import com.ibm.watson.health.acd.v1.model.CartridgesPutMultipartOptions;
import com.ibm.watson.health.acd.v1.model.ConfigurationEntity;
import com.ibm.watson.health.acd.v1.model.ContainerAnnotation;
import com.ibm.watson.health.acd.v1.model.CreateFlowsOptions;
import com.ibm.watson.health.acd.v1.model.CreateProfileOptions;
import com.ibm.watson.health.acd.v1.model.DeleteFlowsOptions;
import com.ibm.watson.health.acd.v1.model.DeleteProfileOptions;
import com.ibm.watson.health.acd.v1.model.DeleteUserSpecificArtifactsOptions;
import com.ibm.watson.health.acd.v1.model.DeployCartridgeOptions;
import com.ibm.watson.health.acd.v1.model.DeployCartridgeResponse;
import com.ibm.watson.health.acd.v1.model.Entity;
import com.ibm.watson.health.acd.v1.model.Flow;
import com.ibm.watson.health.acd.v1.model.FlowEntry;
import com.ibm.watson.health.acd.v1.model.GetAnnotatorsByIdOptions;
import com.ibm.watson.health.acd.v1.model.GetAnnotatorsOptions;
import com.ibm.watson.health.acd.v1.model.GetFlowsByIdOptions;
import com.ibm.watson.health.acd.v1.model.GetFlowsOptions;
import com.ibm.watson.health.acd.v1.model.GetHealthCheckStatusOptions;
import com.ibm.watson.health.acd.v1.model.GetProfileOptions;
import com.ibm.watson.health.acd.v1.model.GetProfilesOptions;
import com.ibm.watson.health.acd.v1.model.ListStringWrapper;
import com.ibm.watson.health.acd.v1.model.RunPipelineOptions;
import com.ibm.watson.health.acd.v1.model.RunPipelineWithFlowOptions;
import com.ibm.watson.health.acd.v1.model.ServiceStatus;
import com.ibm.watson.health.acd.v1.model.UnstructuredContainer;
import com.ibm.watson.health.acd.v1.model.UpdateFlowsOptions;
import com.ibm.watson.health.acd.v1.model.UpdateProfileOptions;
import com.ibm.watson.health.acd.v1.utils.TestUtilities;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;

/**
 * Unit test class for the AnnotatorForClinicalDataAcd service.
 */
@PrepareForTest({ EnvironmentUtils.class })
@PowerMockIgnore("javax.net.ssl.*")
public class AnnotatorForClinicalDataAcdTest extends PowerMockTestCase {

  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  protected MockWebServer server;
  protected AnnotatorForClinicalData testService;

  // Creates a mock set of environment variables that are returned by EnvironmentUtils.getenv().
  private Map<String, String> getTestProcessEnvironment() {
    Map<String, String> env = new HashMap<>();
    env.put("TESTSERVICE_AUTH_TYPE", "noAuth");
    return env;
  }

  public void constructClientService() throws Throwable {
    PowerMockito.spy(EnvironmentUtils.class);
    PowerMockito.when(EnvironmentUtils.getenv()).thenReturn(getTestProcessEnvironment());
    final String serviceName = "testService";
    // set mock values for global params
	String version = "testString";

    testService = AnnotatorForClinicalData.newInstance(version, serviceName);
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

    new AnnotatorForClinicalData(version, serviceName, null);
  }


  @Test
  public void testGetVersion() throws Throwable {
    constructClientService();
    assertEquals(testService.getVersion(), "testString");
  }

  @Test
  public void testGetProfilesWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"data\": [\"data\"]}";
    String getProfilesPath = "/v1/profiles";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetProfilesOptions model
    GetProfilesOptions getProfilesOptionsModel = new GetProfilesOptions.Builder().build();

    // Invoke operation with valid options model (positive test)
    Response<ListStringWrapper> response = testService.getProfiles(getProfilesOptionsModel).execute();
    assertNotNull(response);
    ListStringWrapper responseObj = response.getResult();
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
    assertEquals(parsedPath, getProfilesPath);
  }

  @Test
  public void testCreateProfileWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String createProfilePath = "/v1/profiles";

    server.enqueue(new MockResponse()
    .setResponseCode(201)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ConfigurationEntity model
    ConfigurationEntity configurationEntityModel = new ConfigurationEntity.Builder()
    .type("testString")
    .uid(Long.valueOf("26"))
    .mergeid(Long.valueOf("26"))
    .build();

    // Construct an instance of the Annotator model
    Annotator annotatorModel = new Annotator.Builder()
    .name("testString")
    .parameters(new java.util.HashMap<String,List<String>>(){{put("foo", new ArrayList<String>(Arrays.asList("testString"))); }})
    .configurations(new ArrayList<ConfigurationEntity>(Arrays.asList(configurationEntityModel)))
    .build();

    // Construct an instance of the CreateProfileOptions model
    CreateProfileOptions createProfileOptionsModel = new CreateProfileOptions.Builder()
    .id("testString")
    .name("testString")
    .description("testString")
    .publishedDate("testString")
    .publish(true)
    .version("testString")
    .cartridgeId("testString")
    .annotators(new ArrayList<Annotator>(Arrays.asList(annotatorModel)))
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = testService.createProfile(createProfileOptionsModel).execute();
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
    assertEquals(parsedPath, createProfilePath);
  }

  @Test
  public void testGetProfileWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"name\": \"name\", \"description\": \"description\", \"publishedDate\": \"publishedDate\", \"publish\": false, \"version\": \"version\", \"cartridgeId\": \"cartridgeId\", \"annotators\": [{\"name\": \"name\", \"parameters\": {\"mapKey\": [\"inner\"]}, \"configurations\": [{\"id\": \"id\", \"type\": \"type\", \"uid\": 3, \"mergeid\": 7}]}]}";
    String getProfilePath = "/v1/profiles/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetProfileOptions model
    GetProfileOptions getProfileOptionsModel = new GetProfileOptions.Builder()
    .id("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<AcdProfile> response = testService.getProfile(getProfileOptionsModel).execute();
    assertNotNull(response);
    AcdProfile responseObj = response.getResult();
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
    assertEquals(parsedPath, getProfilePath);
  }

  // Test the getProfile operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetProfileNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.getProfile(null).execute();
  }

  @Test
  public void testUpdateProfileWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String updateProfilePath = "/v1/profiles/testString";

    server.enqueue(new MockResponse()
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ConfigurationEntity model
    ConfigurationEntity configurationEntityModel = new ConfigurationEntity.Builder()
    .id("testString")
    .type("testString")
    .uid(Long.valueOf("26"))
    .mergeid(Long.valueOf("26"))
    .build();

    // Construct an instance of the Annotator model
    Annotator annotatorModel = new Annotator.Builder()
    .name("testString")
    .parameters(new java.util.HashMap<String,List<String>>(){{put("foo", new ArrayList<String>(Arrays.asList("testString"))); }})
    .configurations(new ArrayList<ConfigurationEntity>(Arrays.asList(configurationEntityModel)))
    .build();

    // Construct an instance of the UpdateProfileOptions model
    UpdateProfileOptions updateProfileOptionsModel = new UpdateProfileOptions.Builder()
    .id("testString")
    .newId("testString")
    .newName("testString")
    .newDescription("testString")
    .newPublishedDate("testString")
    .newPublish(true)
    .newVersion("testString")
    .newCartridgeId("testString")
    .newAnnotators(new ArrayList<Annotator>(Arrays.asList(annotatorModel)))
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = testService.updateProfile(updateProfileOptionsModel).execute();
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
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateProfilePath);
  }

  // Test the updateProfile operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateProfileNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.updateProfile(null).execute();
  }

  @Test
  public void testDeleteProfileWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String deleteProfilePath = "/v1/profiles/testString";

    server.enqueue(new MockResponse()
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteProfileOptions model
    DeleteProfileOptions deleteProfileOptionsModel = new DeleteProfileOptions.Builder()
    .id("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = testService.deleteProfile(deleteProfileOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("version"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteProfilePath);
  }

  // Test the deleteProfile operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteProfileNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.deleteProfile(null).execute();
  }

  @Test
  public void testGetFlowsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"data\": [\"data\"]}";
    String getFlowsPath = "/v1/flows";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetFlowsOptions model
    GetFlowsOptions getFlowsOptionsModel = new GetFlowsOptions.Builder().build();

    // Invoke operation with valid options model (positive test)
    Response<ListStringWrapper> response = testService.getFlows(getFlowsOptionsModel).execute();
    assertNotNull(response);
    ListStringWrapper responseObj = response.getResult();
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
    assertEquals(parsedPath, getFlowsPath);
  }

  @Test
  public void testCreateFlowsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String createFlowsPath = "/v1/flows";

    server.enqueue(new MockResponse()
    .setResponseCode(201)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the FlowEntry model
    FlowEntry flowEntryModel = new FlowEntry.Builder().build();

    // Construct an instance of the ConfigurationEntity model
    ConfigurationEntity configurationEntityModel = new ConfigurationEntity.Builder()
    .id("testString")
    .type("testString")
    .uid(Long.valueOf("26"))
    .mergeid(Long.valueOf("26"))
    .build();

    // Construct an instance of the Flow model
    Flow flowModel = new Flow.Builder()
    .elements(new ArrayList<FlowEntry>(Arrays.asList(flowEntryModel)))
    .async(true)
    .build();

    // Construct an instance of the AnnotatorFlow model
    AnnotatorFlow annotatorFlowModel = new AnnotatorFlow.Builder()
    .profile("testString")
    .flow(flowModel)
//    .id("testString")
//    .type("testString")
//    .data(new java.util.HashMap<String,List<Entity>>(){{put("foo", new ArrayList<Entity>(Arrays.asList(entityModel))); }})
//    .metadata(new java.util.HashMap<String,Object>(){{put("foo", "testString"); }})
//    .globalConfigurations(new ArrayList<ConfigurationEntity>(Arrays.asList(configurationEntityModel)))
//    .uid(Long.valueOf("26"))
    .build();

    // Construct an instance of the CreateFlowsOptions model
    CreateFlowsOptions createFlowsOptionsModel = new CreateFlowsOptions.Builder()
    .id("testString")
    .name("testString")
    .description("testString")
    .publishedDate("testString")
    .publish(true)
    .version("testString")
    .cartridgeId("testString")
    .annotatorFlows(new ArrayList<AnnotatorFlow>(Arrays.asList(annotatorFlowModel)))
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = testService.createFlows(createFlowsOptionsModel).execute();
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
    assertEquals(parsedPath, createFlowsPath);
  }

  @Test
  public void testGetFlowsByIdWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"name\": \"name\", \"description\": \"description\", \"publishedDate\": \"publishedDate\", \"publish\": false, \"version\": \"version\", \"cartridgeId\": \"cartridgeId\", \"annotatorFlows\": [{\"profile\": \"profile\", \"flow\": {\"elements\": [{}], \"async\": false}, \"id\": \"id\", \"type\": \"type\", \"data\": {\"mapKey\": [{\"id\": \"id\", \"type\": \"type\", \"uid\": 3, \"mergeid\": 7}]}, \"metadata\": {\"mapKey\": \"anyValue\"}, \"globalConfigurations\": [{\"id\": \"id\", \"type\": \"type\", \"uid\": 3, \"mergeid\": 7}], \"uid\": 3}]}";
    String getFlowsByIdPath = "/v1/flows/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetFlowsByIdOptions model
    GetFlowsByIdOptions getFlowsByIdOptionsModel = new GetFlowsByIdOptions.Builder()
    .id("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<AcdFlow> response = testService.getFlowsById(getFlowsByIdOptionsModel).execute();
    assertNotNull(response);
    AcdFlow responseObj = response.getResult();
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
    assertEquals(parsedPath, getFlowsByIdPath);
  }

  // Test the getFlowsById operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetFlowsByIdNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.getFlowsById(null).execute();
  }

  @Test
  public void testUpdateFlowsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String updateFlowsPath = "/v1/flows/testString";

    server.enqueue(new MockResponse()
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the FlowEntry model
    FlowEntry flowEntryModel = new FlowEntry.Builder().build();

    // Construct an instance of the ConfigurationEntity model
    ConfigurationEntity configurationEntityModel = new ConfigurationEntity.Builder()
    .id("testString")
    .type("testString")
    .uid(Long.valueOf("26"))
    .mergeid(Long.valueOf("26"))
    .build();

    // Construct an instance of the Flow model
    Flow flowModel = new Flow.Builder()
    .elements(new ArrayList<FlowEntry>(Arrays.asList(flowEntryModel)))
    .async(true)
    .build();

    // Construct an instance of the AnnotatorFlow model
    AnnotatorFlow annotatorFlowModel = new AnnotatorFlow.Builder()
    .profile("testString")
    .flow(flowModel)
//    .id("testString")
//    .type("testString")
//    .data(new java.util.HashMap<String,List<Entity>>(){{put("foo", new ArrayList<Entity>(Arrays.asList(entityModel))); }})
//    .metadata(new java.util.HashMap<String,Object>(){{put("foo", "testString"); }})
//    .globalConfigurations(new ArrayList<ConfigurationEntity>(Arrays.asList(configurationEntityModel)))
//    .uid(Long.valueOf("26"))
    .build();

    // Construct an instance of the UpdateFlowsOptions model
    UpdateFlowsOptions updateFlowsOptionsModel = new UpdateFlowsOptions.Builder()
    .id("testString")
    .newId("testString")
    .newName("testString")
    .newDescription("testString")
    .newPublishedDate("testString")
    .newPublish(true)
    .newVersion("testString")
    .newCartridgeId("testString")
    .newAnnotatorFlows(new ArrayList<AnnotatorFlow>(Arrays.asList(annotatorFlowModel)))
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = testService.updateFlows(updateFlowsOptionsModel).execute();
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
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateFlowsPath);
  }

  // Test the updateFlows operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateFlowsNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.updateFlows(null).execute();
  }

  @Test
  public void testDeleteFlowsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String deleteFlowsPath = "/v1/flows/testString";

    server.enqueue(new MockResponse()
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteFlowsOptions model
    DeleteFlowsOptions deleteFlowsOptionsModel = new DeleteFlowsOptions.Builder()
    .id("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = testService.deleteFlows(deleteFlowsOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("version"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteFlowsPath);
  }

  // Test the deleteFlows operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteFlowsNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.deleteFlows(null).execute();
  }

  @Test
  public void testRunPipelineWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String runPipelinePath = "/v1/analyze";

    server.enqueue(new MockResponse()
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the FlowEntry model
    FlowEntry flowEntryModel = new FlowEntry.Builder().build();

    // Construct an instance of the ConfigurationEntity model
    ConfigurationEntity configurationEntityModel = new ConfigurationEntity.Builder()
    .id("testString")
    .type("testString")
    .uid(Long.valueOf("26"))
    .mergeid(Long.valueOf("26"))
    .build();

    // Construct an instance of the Flow model
    Flow flowModel = new Flow.Builder()
    .elements(new ArrayList<FlowEntry>(Arrays.asList(flowEntryModel)))
    .async(true)
    .build();

    // Construct an instance of the AnnotatorFlow model
    AnnotatorFlow annotatorFlowModel = new AnnotatorFlow.Builder()
    .profile("testString")
    .flow(flowModel)
//    .id("testString")
//    .type("testString")
//    .data(new java.util.HashMap<String,List<Entity>>(){{put("foo", new ArrayList<Entity>(Arrays.asList(entityModel))); }})
//    .metadata(new java.util.HashMap<String,Object>(){{put("foo", "testString"); }})
//    .globalConfigurations(new ArrayList<ConfigurationEntity>(Arrays.asList(configurationEntityModel)))
//    .uid(Long.valueOf("26"))
    .build();

    // Construct an instance of the UnstructuredContainer model
    UnstructuredContainer unstructuredContainerModel = new UnstructuredContainer.Builder()
    .text("testString")
    .id("testString")
    .type("testString")
    .data(new ContainerAnnotation())
    .metadata(new java.util.HashMap<String,Map>(){{put("foo", new HashMap()); }})
    .uid(Long.valueOf("26"))
    .build();

    // Construct an instance of the RunPipelineOptions model
    RunPipelineOptions runPipelineOptionsModel = new RunPipelineOptions.Builder()
    .unstructured(new ArrayList<UnstructuredContainer>(Arrays.asList(unstructuredContainerModel)))
    .annotatorFlows(new ArrayList<AnnotatorFlow>(Arrays.asList(annotatorFlowModel)))
    .debugTextRestore(true)
    .returnAnalyzedText(true)
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = testService.runPipeline(runPipelineOptionsModel).execute();
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
    assertEquals(Boolean.valueOf(query.get("debug_text_restore")), Boolean.valueOf(true));
    assertEquals(Boolean.valueOf(query.get("return_analyzed_text")), Boolean.valueOf(true));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, runPipelinePath);
  }

  @Test
  public void testRunPipelineWithFlowWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String runPipelineWithFlowPath = "/v1/analyze/testString";

    server.enqueue(new MockResponse()
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the FlowEntry model
    FlowEntry flowEntryModel = new FlowEntry.Builder().build();

    // Construct an instance of the ConfigurationEntity model
    ConfigurationEntity configurationEntityModel = new ConfigurationEntity.Builder()
    .id("testString")
    .type("testString")
    .uid(Long.valueOf("26"))
    .mergeid(Long.valueOf("26"))
    .build();

    // Construct an instance of the Flow model
    Flow flowModel = new Flow.Builder()
    .elements(new ArrayList<FlowEntry>(Arrays.asList(flowEntryModel)))
    .async(true)
    .build();

    // Construct an instance of the AnnotatorFlow model
    AnnotatorFlow annotatorFlowModel = new AnnotatorFlow.Builder()
    .profile("testString")
    .flow(flowModel)
//    .id("testString")
//    .type("testString")
//    .data(new java.util.HashMap<String,List<Entity>>(){{put("foo", new ArrayList<Entity>(Arrays.asList(entityModel))); }})
//    .metadata(new java.util.HashMap<String,Object>(){{put("foo", "testString"); }})
//    .globalConfigurations(new ArrayList<ConfigurationEntity>(Arrays.asList(configurationEntityModel)))
//    .uid(Long.valueOf("26"))
    .build();

    // Construct an instance of the UnstructuredContainer model
    UnstructuredContainer unstructuredContainerModel = new UnstructuredContainer.Builder()
    .text("testString")
    .id("testString")
    .type("testString")
    .data(new ContainerAnnotation())
    .metadata(new java.util.HashMap<String,Map>(){{put("foo", new HashMap()); }})
    .uid(Long.valueOf("26"))
    .build();

    // Construct an instance of the AnalyticFlowBeanInput model
    AnalyticFlowBeanInput analyticFlowBeanInputModel = new AnalyticFlowBeanInput.Builder()
    .unstructured(new ArrayList<UnstructuredContainer>(Arrays.asList(unstructuredContainerModel)))
    .annotatorFlows(new ArrayList<AnnotatorFlow>(Arrays.asList(annotatorFlowModel)))
    .build();

    // Construct an instance of the RunPipelineWithFlowOptions model
    RunPipelineWithFlowOptions runPipelineWithFlowOptionsModel = new RunPipelineWithFlowOptions.Builder()
    .flowId("testString")
    .returnAnalyzedText(true)
    .analyticFlowBeanInput(analyticFlowBeanInputModel)
    .debugTextRestore(true)
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = testService.runPipelineWithFlow(runPipelineWithFlowOptionsModel).execute();
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
    assertEquals(Boolean.valueOf(query.get("return_analyzed_text")), Boolean.valueOf(true));
    assertEquals(Boolean.valueOf(query.get("debug_text_restore")), Boolean.valueOf(true));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, runPipelineWithFlowPath);
  }

  // Test the runPipelineWithFlow operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testRunPipelineWithFlowNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.runPipelineWithFlow(null).execute();
  }

  @Test
  public void testGetAnnotatorsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String getAnnotatorsPath = "/v1/annotators";

    server.enqueue(new MockResponse()
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetAnnotatorsOptions model
    GetAnnotatorsOptions getAnnotatorsOptionsModel = new GetAnnotatorsOptions();

    // Invoke operation with valid options model (positive test)
    Response<ListStringWrapper> response = testService.getAnnotators(getAnnotatorsOptionsModel).execute();
    assertNotNull(response);
    ListStringWrapper responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

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
    assertEquals(parsedPath, getAnnotatorsPath);
  }

  @Test
  public void testGetAnnotatorsByIdWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String getAnnotatorsByIdPath = "/v1/annotators/testString";

    server.enqueue(new MockResponse()
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetAnnotatorsByIdOptions model
    GetAnnotatorsByIdOptions getAnnotatorsByIdOptionsModel = new GetAnnotatorsByIdOptions.Builder()
    .id("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Annotator> response = testService.getAnnotatorsById(getAnnotatorsByIdOptionsModel).execute();
    assertNotNull(response);
    Annotator responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

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
    assertEquals(parsedPath, getAnnotatorsByIdPath);
  }

  // Test the getAnnotatorsById operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetAnnotatorsByIdNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.getAnnotatorsById(null).execute();
  }

  @Test
  public void testDeleteUserSpecificArtifactsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String deleteUserSpecificArtifactsPath = "/v1/user_data";

    server.enqueue(new MockResponse()
    .setResponseCode(204)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteUserSpecificArtifactsOptions model
    DeleteUserSpecificArtifactsOptions deleteUserSpecificArtifactsOptionsModel = new DeleteUserSpecificArtifactsOptions();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = testService.deleteUserSpecificArtifacts(deleteUserSpecificArtifactsOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("version"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteUserSpecificArtifactsPath);
  }

  @Test
  public void testCartridgesGetWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"data\": [\"data\"]}";
    String cartridgesGetPath = "/v1/cartridges";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the CartridgesGetOptions model
    CartridgesGetOptions cartridgesGetOptionsModel = new CartridgesGetOptions();

    // Invoke operation with valid options model (positive test)
    Response<ListStringWrapper> response = testService.cartridgesGet(cartridgesGetOptionsModel).execute();
    assertNotNull(response);
    ListStringWrapper responseObj = response.getResult();
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
    assertEquals(parsedPath, cartridgesGetPath);
  }

  @Test
  public void testCartridgesPostMultipartWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"code\": 4, \"artifactResponse\": [{\"code\": 4, \"message\": \"message\", \"level\": \"ERROR\", \"description\": \"description\", \"moreInfo\": \"moreInfo\", \"correlationId\": \"correlationId\", \"artifact\": \"artifact\", \"href\": \"href\"}]}";
    String cartridgesPostMultipartPath = "/v1/cartridges";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the CartridgesPostMultipartOptions model
    CartridgesPostMultipartOptions cartridgesPostMultipartOptionsModel = new CartridgesPostMultipartOptions.Builder()
    .archiveFile(TestUtilities.createMockStream("This is a mock file."))
    .archiveFileContentType("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<DeployCartridgeResponse> response = testService.cartridgesPostMultipart(cartridgesPostMultipartOptionsModel).execute();
    assertNotNull(response);
    DeployCartridgeResponse responseObj = response.getResult();
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
    assertEquals(parsedPath, cartridgesPostMultipartPath);
  }

  @Test
  public void testCartridgesPutMultipartWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"code\": 4, \"artifactResponse\": [{\"code\": 4, \"message\": \"message\", \"level\": \"ERROR\", \"description\": \"description\", \"moreInfo\": \"moreInfo\", \"correlationId\": \"correlationId\", \"artifact\": \"artifact\", \"href\": \"href\"}]}";
    String cartridgesPutMultipartPath = "/v1/cartridges";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the CartridgesPutMultipartOptions model
    CartridgesPutMultipartOptions cartridgesPutMultipartOptionsModel = new CartridgesPutMultipartOptions.Builder()
    .archiveFile(TestUtilities.createMockStream("This is a mock file."))
    .archiveFileContentType("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<DeployCartridgeResponse> response = testService.cartridgesPutMultipart(cartridgesPutMultipartOptionsModel).execute();
    assertNotNull(response);
    DeployCartridgeResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("version"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, cartridgesPutMultipartPath);
  }

  @Test
  public void testCartridgesGetIdWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"name\": \"name\", \"status\": \"status\", \"statusCode\": 10, \"statusLocation\": \"statusLocation\", \"startTime\": \"startTime\", \"endTime\": \"endTime\", \"duration\": \"duration\", \"correlationId\": \"correlationId\", \"artifactResponseCode\": 20, \"artifactResponse\": [{\"code\": 4, \"message\": \"message\", \"level\": \"ERROR\", \"description\": \"description\", \"moreInfo\": \"moreInfo\", \"correlationId\": \"correlationId\", \"artifact\": \"artifact\", \"href\": \"href\"}]}";
    String cartridgesGetIdPath = "/v1/cartridges/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the CartridgesGetIdOptions model
    CartridgesGetIdOptions cartridgesGetIdOptionsModel = new CartridgesGetIdOptions.Builder()
    .id("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<AcdCartridges> response = testService.cartridgesGetId(cartridgesGetIdOptionsModel).execute();
    assertNotNull(response);
    AcdCartridges responseObj = response.getResult();
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
    assertEquals(parsedPath, cartridgesGetIdPath);
  }

  // Test the cartridgesGetId operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCartridgesGetIdNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.cartridgesGetId(null).execute();
  }

  @Test
  public void testDeployCartridgeWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"code\": 4, \"artifactResponse\": [{\"code\": 4, \"message\": \"message\", \"level\": \"ERROR\", \"description\": \"description\", \"moreInfo\": \"moreInfo\", \"correlationId\": \"correlationId\", \"artifact\": \"artifact\", \"href\": \"href\"}]}";
    String deployCartridgePath = "/v1/deploy";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeployCartridgeOptions model
    DeployCartridgeOptions deployCartridgeOptionsModel = new DeployCartridgeOptions.Builder()
    .archiveFile(TestUtilities.createMockStream("This is a mock file."))
    .archiveFileContentType("testString")
    .update(true)
    .build();

    // Invoke operation with valid options model (positive test)
    Response<DeployCartridgeResponse> response = testService.deployCartridge(deployCartridgeOptionsModel).execute();
    assertNotNull(response);
    DeployCartridgeResponse responseObj = response.getResult();
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
    assertEquals(Boolean.valueOf(query.get("update")), Boolean.valueOf(true));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deployCartridgePath);
  }

  @Test
  public void testGetHealthCheckStatusWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"version\": \"version\", \"upTime\": \"upTime\", \"serviceState\": \"OK\", \"stateDetails\": \"stateDetails\", \"hostName\": \"hostName\", \"requestCount\": 12, \"maxMemoryMb\": 11, \"commitedMemoryMb\": 16, \"inUseMemoryMb\": 13, \"availableProcessors\": 19, \"concurrentRequests\": 18, \"maxConcurrentRequests\": 21, \"totalRejectedRequests\": 21, \"totalBlockedRequests\": 20}";
    String getHealthCheckStatusPath = "/v1/status/health_check";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetHealthCheckStatusOptions model
    GetHealthCheckStatusOptions getHealthCheckStatusOptionsModel = new GetHealthCheckStatusOptions.Builder()
    .accept("application/json")
    .format("json")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ServiceStatus> response = testService.getHealthCheckStatus(getHealthCheckStatusOptionsModel).execute();
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

  /** Initialize the server */
  @BeforeMethod
  public void setUpMockServer() {
    try {
        server = new MockWebServer();
        // register handler
        server.start();
        }
    catch (IOException err) {
        fail("Failed to instantiate mock web server");
    }
  }

  @AfterMethod
  public void tearDownMockServer() throws IOException {
    server.shutdown();
    testService = null;
  }
}