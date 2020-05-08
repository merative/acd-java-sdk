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
package com.ibm.watson.health.acd.v1;

import java.util.Map;
import java.util.Map.Entry;

import com.google.gson.JsonObject;
import com.ibm.cloud.sdk.core.http.RequestBuilder;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.http.ResponseConverter;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.ConfigBasedAuthenticatorFactory;
import com.ibm.cloud.sdk.core.service.BaseService;
import com.ibm.cloud.sdk.core.util.GsonSingleton;
import com.ibm.cloud.sdk.core.util.RequestUtils;
import com.ibm.cloud.sdk.core.util.ResponseConverterUtils;
import com.ibm.cloud.sdk.core.util.Validator;
import com.ibm.cloud.whcs.common.SdkCommon;
import com.ibm.watson.health.acd.v1.model.AcdCartridges;
import com.ibm.watson.health.acd.v1.model.AcdFlow;
import com.ibm.watson.health.acd.v1.model.AcdProfile;
import com.ibm.watson.health.acd.v1.model.AnalyzeOptions;
import com.ibm.watson.health.acd.v1.model.AnalyzeWithFlowOptions;
import com.ibm.watson.health.acd.v1.model.Annotator;
import com.ibm.watson.health.acd.v1.model.AnnotatorFlow;
import com.ibm.watson.health.acd.v1.model.CartridgesGetIdOptions;
import com.ibm.watson.health.acd.v1.model.CartridgesGetOptions;
import com.ibm.watson.health.acd.v1.model.CartridgesPostMultipartOptions;
import com.ibm.watson.health.acd.v1.model.CartridgesPutMultipartOptions;
import com.ibm.watson.health.acd.v1.model.ContainerGroup;
import com.ibm.watson.health.acd.v1.model.CreateFlowsOptions;
import com.ibm.watson.health.acd.v1.model.CreateProfileOptions;
import com.ibm.watson.health.acd.v1.model.DeleteFlowsOptions;
import com.ibm.watson.health.acd.v1.model.DeleteProfileOptions;
import com.ibm.watson.health.acd.v1.model.DeleteUserSpecificArtifactsOptions;
import com.ibm.watson.health.acd.v1.model.DeployCartridgeOptions;
import com.ibm.watson.health.acd.v1.model.DeployCartridgeResponse;
import com.ibm.watson.health.acd.v1.model.Flow;
import com.ibm.watson.health.acd.v1.model.GetAnnotatorsByIdOptions;
import com.ibm.watson.health.acd.v1.model.GetAnnotatorsOptions;
import com.ibm.watson.health.acd.v1.model.GetFlowsByIdOptions;
import com.ibm.watson.health.acd.v1.model.GetFlowsOptions;
import com.ibm.watson.health.acd.v1.model.GetHealthCheckStatusOptions;
import com.ibm.watson.health.acd.v1.model.GetProfileOptions;
import com.ibm.watson.health.acd.v1.model.GetProfilesOptions;
import com.ibm.watson.health.acd.v1.model.ListStringWrapper;
import com.ibm.watson.health.acd.v1.model.RequestContainer;
import com.ibm.watson.health.acd.v1.model.RunPipelineOptions;
import com.ibm.watson.health.acd.v1.model.RunPipelineWithFlowOptions;
import com.ibm.watson.health.acd.v1.model.ServiceStatus;
import com.ibm.watson.health.acd.v1.model.UnstructuredContainer;
import com.ibm.watson.health.acd.v1.model.UpdateFlowsOptions;
import com.ibm.watson.health.acd.v1.model.UpdateProfileOptions;

import okhttp3.MultipartBody;

/**
 * Natural Language Processing (NLP) service featuring a set of medical domain annotators for use in detecting entities
 * and medical concepts from unstructured data. Multiple annotators may be invoked from a single request.
 *
 * @version v1
 */
public class AnnotatorForClinicalData extends BaseService {

  public static final String DEFAULT_SERVICE_NAME = "annotator_for_clinical_data_acd";

  public static final String DEFAULT_SERVICE_URL = "https://annotator-for-clinical-data-acd.cloud.ibm.com/services/clinical_data_annotator/api";

  public static final String RETURN_ANALYZED_TEXT = "return_analyzed_text";

  public static final String VERSION = "version";

  private String version;

 /**
   * Class method which constructs an instance of the `AnnotatorForClinicalDataAcd` client.
   * The default service name is used to configure the client instance.
   *
   * @param version The release date of the version of the API you want to use. Specify dates in YYYY-MM-DD format.
   * @return an instance of the `AnnotatorForClinicalDataAcd` client using external configuration
   */
  public static AnnotatorForClinicalData newInstance(String version) {
    return newInstance(version, DEFAULT_SERVICE_NAME);
  }

  /**
   * Class method which constructs an instance of the `AnnotatorForClinicalDataAcd` client.
   * The specified service name is used to configure the client instance.
   *
   * @param version The release date of the version of the API you want to use. Specify dates in YYYY-MM-DD format.
   * @param serviceName the service name to be used when configuring the client instance
   * @return an instance of the `AnnotatorForClinicalDataAcd` client using external configuration
   */
  public static AnnotatorForClinicalData newInstance(String version, String serviceName) {
    Authenticator authenticator = ConfigBasedAuthenticatorFactory.getAuthenticator(serviceName);
    AnnotatorForClinicalData service = new AnnotatorForClinicalData(version, serviceName, authenticator);
    service.configureService(serviceName);
    return service;
  }

  /**
   * Constructs an instance of the `AnnotatorForClinicalDataAcd` client.
   * The specified service name and authenticator are used to configure the client instance.
   *
   * @param version The release date of the version of the API you want to use. Specify dates in YYYY-MM-DD format.
   * @param serviceName the service name to be used when configuring the client instance
   * @param authenticator the {@link Authenticator} instance to be configured for this client
   */
  public AnnotatorForClinicalData(String version, String serviceName, Authenticator authenticator) {
    super(serviceName, authenticator);
    setServiceUrl(DEFAULT_SERVICE_URL);
    setVersion(version);
  }

  /**
   * Gets the version.
   *
   * The release date of the version of the API you want to use. Specify dates in YYYY-MM-DD format.
   *
   * @return the version
   */
  public String getVersion() {
    return this.version;
  }

  /**
   * Sets the version.
   *
   * @param version the new version
   */
  public void setVersion(final String version) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(version, "version cannot be empty.");
    this.version = version;
  }

  /**
   * Get list of available persisted profiles.
   *
   * Returns a summary including ID and description of the available persisted profiles.
   *
   * @param getProfilesOptions the {@link GetProfilesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ListStringWrapper}
   */
  public ServiceCall<ListStringWrapper> getProfiles(GetProfilesOptions getProfilesOptions) {
    String[] pathSegments = { "v1/profiles" };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("annotator_for_clinical_data_acd", "v1", "getProfiles");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getProfilesOptions != null) {
      builder.query("version", this.version);
    }
    ResponseConverter<ListStringWrapper> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ListStringWrapper>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get list of available persisted profiles.
   *
   * Returns a summary including ID and description of the available persisted profiles.
   *
   * @return a {@link ServiceCall} with a result of type {@link ListStringWrapper}
   */
  public ServiceCall<ListStringWrapper> getProfiles() {
    return getProfiles(null);
  }

  /**
   * Persist a new profile.
   *
   * This API persists a new profile.  A profile is identified by an ID.  This ID can optionally be specified as part of
   * the request body when invoking &lt;b&gt;POST /v1/analyze&lt;/b&gt; API.  A profile contains annotator configuration
   * information that will be applied to the annotators specified in the annotator flow.&lt;p&gt;If a caller would
   * choose to have the ID of the new profile generated on their behalf, then in the request body the "id" field of the
   * profile definition should be an empty string ("").  The auto-generated ID would be a normalized form of the "name"
   * field from the profile definition.&lt;p&gt;&lt;b&gt;Sample Profile #1&lt;/b&gt;&lt;br&gt;A profile definition that
   * configures the 'concept_detection' annotator to use the UMLS umls.latest library.&lt;br&gt;&lt;pre&gt;{&lt;br&gt;
   * "id": "acd_profile_cd_umls_latest",&lt;br&gt;  "name": "Profile for the latest Concept Detection UMLS
   * Library",&lt;br&gt;  "description": "Provides configurations for running Concept Detection with the latest UMLS
   * library",&lt;br&gt;  "annotators": [&lt;br&gt;    {&lt;br&gt;      "name": "concept_detection",&lt;br&gt;
   * "parameters": {&lt;br&gt;         "libraries": ["umls.latest"]&lt;br&gt;       }&lt;br&gt;    }&lt;br&gt;
   * ]&lt;br&gt;}&lt;/pre&gt;&lt;p&gt;&lt;b&gt;Sample Profile #2&lt;/b&gt;&lt;br&gt;A profile definition that configures
   * the 'concept_detection' annotator to exclude any annotations where the semantic type does not equal
   * 'neop'.&lt;br&gt;&lt;pre&gt;{&lt;br&gt;  "id": "acd_profile_cd_neop_only",&lt;br&gt;  "name": "Profile for Concept
   * Detection neop Semantic Type",&lt;br&gt;  "description": "Concept Detection configuration fitler to exclude
   * annotations where semantic type does not equal 'neop'.",&lt;br&gt;  "annotators": [&lt;br&gt;    {&lt;br&gt;
   * "name": "concept_detection",&lt;br&gt;       "configurations": [&lt;br&gt;         {&lt;br&gt;           "filter":
   * {&lt;br&gt;             "target": "unstructured.data.concepts",&lt;br&gt;             "condition": {&lt;br&gt;
   *           "type": "match",&lt;br&gt;                "field": "semanticType",&lt;br&gt;                "values":
   * [&lt;br&gt;                   "neop"&lt;br&gt;                 ],&lt;br&gt;                "not": false,&lt;br&gt;
   *               "caseInsensitive": false,&lt;br&gt;                "operator": "equals"&lt;br&gt;
   * }&lt;br&gt;            }&lt;br&gt;         }&lt;br&gt;       ]&lt;br&gt;    }&lt;br&gt;  ]&lt;br&gt;}&lt;/pre&gt;.
   *
   * @param createProfileOptions the {@link CreateProfileOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> createProfile(CreateProfileOptions createProfileOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createProfileOptions,
      "createProfileOptions cannot be null");
    String[] pathSegments = { "v1/profiles" };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("annotator_for_clinical_data_acd", "v1", "createProfile");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.query("version", this.version);
    final JsonObject contentJson = new JsonObject();
    if (createProfileOptions.id() != null) {
      contentJson.addProperty("id", createProfileOptions.id());
    }
    if (createProfileOptions.name() != null) {
      contentJson.addProperty("name", createProfileOptions.name());
    }
    if (createProfileOptions.description() != null) {
      contentJson.addProperty("description", createProfileOptions.description());
    }
    if (createProfileOptions.publishedDate() != null) {
      contentJson.addProperty("publishedDate", createProfileOptions.publishedDate());
    }
    if (createProfileOptions.publish() != null) {
      contentJson.addProperty("publish", createProfileOptions.publish());
    }
    if (createProfileOptions.version() != null) {
      contentJson.addProperty("version", createProfileOptions.version());
    }
    if (createProfileOptions.cartridgeId() != null) {
      contentJson.addProperty("cartridgeId", createProfileOptions.cartridgeId());
    }
    if (createProfileOptions.annotators() != null) {
      contentJson.add("annotators", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createProfileOptions.annotators()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Persist a new profile.
   *
   * This API persists a new profile.  A profile is identified by an ID.  This ID can optionally be specified as part of
   * the request body when invoking &lt;b&gt;POST /v1/analyze&lt;/b&gt; API.  A profile contains annotator configuration
   * information that will be applied to the annotators specified in the annotator flow.&lt;p&gt;If a caller would
   * choose to have the ID of the new profile generated on their behalf, then in the request body the "id" field of the
   * profile definition should be an empty string ("").  The auto-generated ID would be a normalized form of the "name"
   * field from the profile definition.&lt;p&gt;&lt;b&gt;Sample Profile #1&lt;/b&gt;&lt;br&gt;A profile definition that
   * configures the 'concept_detection' annotator to use the UMLS umls.latest library.&lt;br&gt;&lt;pre&gt;{&lt;br&gt;
   * "id": "acd_profile_cd_umls_latest",&lt;br&gt;  "name": "Profile for the latest Concept Detection UMLS
   * Library",&lt;br&gt;  "description": "Provides configurations for running Concept Detection with the latest UMLS
   * library",&lt;br&gt;  "annotators": [&lt;br&gt;    {&lt;br&gt;      "name": "concept_detection",&lt;br&gt;
   * "parameters": {&lt;br&gt;         "libraries": ["umls.latest"]&lt;br&gt;       }&lt;br&gt;    }&lt;br&gt;
   * ]&lt;br&gt;}&lt;/pre&gt;&lt;p&gt;&lt;b&gt;Sample Profile #2&lt;/b&gt;&lt;br&gt;A profile definition that configures
   * the 'concept_detection' annotator to exclude any annotations where the semantic type does not equal
   * 'neop'.&lt;br&gt;&lt;pre&gt;{&lt;br&gt;  "id": "acd_profile_cd_neop_only",&lt;br&gt;  "name": "Profile for Concept
   * Detection neop Semantic Type",&lt;br&gt;  "description": "Concept Detection configuration fitler to exclude
   * annotations where semantic type does not equal 'neop'.",&lt;br&gt;  "annotators": [&lt;br&gt;    {&lt;br&gt;
   * "name": "concept_detection",&lt;br&gt;       "configurations": [&lt;br&gt;         {&lt;br&gt;           "filter":
   * {&lt;br&gt;             "target": "unstructured.data.concepts",&lt;br&gt;             "condition": {&lt;br&gt;
   *           "type": "match",&lt;br&gt;                "field": "semanticType",&lt;br&gt;                "values":
   * [&lt;br&gt;                   "neop"&lt;br&gt;                 ],&lt;br&gt;                "not": false,&lt;br&gt;
   *               "caseInsensitive": false,&lt;br&gt;                "operator": "equals"&lt;br&gt;
   * }&lt;br&gt;            }&lt;br&gt;         }&lt;br&gt;       ]&lt;br&gt;    }&lt;br&gt;  ]&lt;br&gt;}&lt;/pre&gt;.
   *
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> createProfile() {
    return createProfile(null);
  }

  /**
   * Get details of a specific profile.
   *
   * Using the specified profile ID, retrieves the profile definition.
   *
   * @param getProfileOptions the {@link GetProfileOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link AcdProfile}
   */
  public ServiceCall<AcdProfile> getProfile(GetProfileOptions getProfileOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getProfileOptions,
      "getProfileOptions cannot be null");
    String[] pathSegments = { "v1/profiles" };
    String[] pathParameters = { getProfileOptions.id() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("annotator_for_clinical_data_acd", "v1", "getProfile");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", this.version);
    ResponseConverter<AcdProfile> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<AcdProfile>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update a persisted profile definition.
   *
   * Using the specified Profile ID, updates the profile definition.  This is a complete replacement of the existing
   * profile definition using the JSON object provided in the request body.
   *
   * @param updateProfileOptions the {@link UpdateProfileOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> updateProfile(UpdateProfileOptions updateProfileOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(updateProfileOptions,
      "updateProfileOptions cannot be null");
    String[] pathSegments = { "v1/profiles" };
    String[] pathParameters = { updateProfileOptions.id() };
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("annotator_for_clinical_data_acd", "v1", "updateProfile");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.query("version", this.version);
    final JsonObject contentJson = new JsonObject();
    if (updateProfileOptions.newId() != null) {
      contentJson.addProperty("id", updateProfileOptions.newId());
    }
    if (updateProfileOptions.newName() != null) {
      contentJson.addProperty("name", updateProfileOptions.newName());
    }
    if (updateProfileOptions.newDescription() != null) {
      contentJson.addProperty("description", updateProfileOptions.newDescription());
    }
    if (updateProfileOptions.newPublishedDate() != null) {
      contentJson.addProperty("publishedDate", updateProfileOptions.newPublishedDate());
    }
    if (updateProfileOptions.newPublish() != null) {
      contentJson.addProperty("publish", updateProfileOptions.newPublish());
    }
    if (updateProfileOptions.newVersion() != null) {
      contentJson.addProperty("version", updateProfileOptions.newVersion());
    }
    if (updateProfileOptions.newCartridgeId() != null) {
      contentJson.addProperty("cartridgeId", updateProfileOptions.newCartridgeId());
    }
    if (updateProfileOptions.newAnnotators() != null) {
      contentJson.add("annotators", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(updateProfileOptions.newAnnotators()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete a persisted profile.
   *
   * Using the specified profile ID, deletes the profile from the list of persisted profiles.
   *
   * @param deleteProfileOptions the {@link DeleteProfileOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteProfile(DeleteProfileOptions deleteProfileOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteProfileOptions,
      "deleteProfileOptions cannot be null");
    String[] pathSegments = { "v1/profiles" };
    String[] pathParameters = { deleteProfileOptions.id() };
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("annotator_for_clinical_data_acd", "v1", "deleteProfile");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.query("version", this.version);
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get list of available persisted flows.
   *
   * Returns a summary including ID and description of the available persisted flows.
   *
   * @param getFlowsOptions the {@link GetFlowsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ListStringWrapper}
   */
  public ServiceCall<ListStringWrapper> getFlows(GetFlowsOptions getFlowsOptions) {
    String[] pathSegments = { "v1/flows" };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("annotator_for_clinical_data_acd", "v1", "getFlows");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getFlowsOptions != null) {
      builder.query("version", this.version);
    }
    ResponseConverter<ListStringWrapper> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ListStringWrapper>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get list of available persisted flows.
   *
   * Returns a summary including ID and description of the available persisted flows.
   *
   * @return a {@link ServiceCall} with a result of type {@link ListStringWrapper}
   */
  public ServiceCall<ListStringWrapper> getFlows() {
    return getFlows(null);
  }

  /**
   * Persist a new flow definition.
   *
   * This API persists a new flow.  A flow is identified by an ID.  This ID can optionally be specified as part of the
   * request body when invoking &lt;b&gt;POST /v1/analyze&lt;/b&gt; API.  A flow definition contains a list one or more
   * annotators, and optionally can include annotator configuration, a flow ID, and/or flow sequence.&lt;p&gt;If a
   * caller would choose to have the ID of the new flow generated on their behalf, then in the request body the "id"
   * field of the flow definition should be an empty string ("").  The auto-generated ID would be a normalized form of
   * the "name" field from the flow definition.&lt;p&gt;&lt;p&gt;&lt;b&gt;Sample Flow #1&lt;/b&gt;&lt;br&gt;A flow
   * definition that includes two annotators.&lt;br&gt;&lt;pre&gt;{&lt;br&gt;  "id": "flow_simple",&lt;br&gt;  "name":
   * "flow simple",&lt;br&gt;  "description": "A simple flow with two annotators",&lt;br&gt;  "annotatorFlows":
   * [&lt;br&gt;      {&lt;br&gt;       "flow": {&lt;br&gt;          "elements": [&lt;br&gt;             {&lt;br&gt;
   *           "annotator": {&lt;br&gt;                   "name": "concept_detection"&lt;br&gt;
   * }&lt;br&gt;             },&lt;br&gt;             {&lt;br&gt;               "annotator": {&lt;br&gt;
   *   "name": "symptom_disease"&lt;br&gt;                }&lt;br&gt;             }&lt;br&gt;           ],&lt;br&gt;
   *   "async": false&lt;br&gt;        }&lt;br&gt;      }&lt;br&gt;   ]&lt;br&gt;}&lt;/pre&gt;&lt;p&gt;&lt;b&gt;Sample
   * Flow #2&lt;/b&gt;&lt;br&gt;A flow definition that includes the 'concept_detection' annotator and configuration
   * details for the 'concept_detection' annotator.&lt;br&gt;&lt;pre&gt;{&lt;br&gt;  "id":
   * "flow_concept_detection_exclude_non_neop",&lt;br&gt;  "name": "flow concept detection exclude non neop",&lt;br&gt;
   * "description": "A flow excluding detected concepts that do not have 'neop' semantic type",&lt;br&gt;
   * "annotatorFlows": [&lt;br&gt;      {&lt;br&gt;       "flow": {&lt;br&gt;          "elements": [&lt;br&gt;
   *   {&lt;br&gt;               "annotator": {&lt;br&gt;                   "name": "concept_detection",&lt;br&gt;
   *             "configurations": [&lt;br&gt;                      {&lt;br&gt;                        "filter":
   * {&lt;br&gt;                           "target": "unstructured.data.concepts",&lt;br&gt;
   * "condition": {&lt;br&gt;                              "type": "match",&lt;br&gt;
   * "field": "semanticType",&lt;br&gt;                              "values": [&lt;br&gt;
   *   "neop"&lt;br&gt;                                ],&lt;br&gt;                              "not": false,&lt;br&gt;
   *                              "caseInsensitive": false,&lt;br&gt;                              "operator":
   * "equals"&lt;br&gt;                            }&lt;br&gt;                         }&lt;br&gt;
   * }&lt;br&gt;                    ]&lt;br&gt;                 }&lt;br&gt;              }&lt;br&gt;
   * ],&lt;br&gt;       "async": false&lt;br&gt;        }&lt;br&gt;      }&lt;br&gt;   ]&lt;br&gt;}&lt;/pre&gt;.
   *
   * @param createFlowsOptions the {@link CreateFlowsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> createFlows(CreateFlowsOptions createFlowsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createFlowsOptions,
      "createFlowsOptions cannot be null");
    String[] pathSegments = { "v1/flows" };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("annotator_for_clinical_data_acd", "v1", "createFlows");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.query("version", this.version);
    final JsonObject contentJson = new JsonObject();
    if (createFlowsOptions.id() != null) {
      contentJson.addProperty("id", createFlowsOptions.id());
    }
    if (createFlowsOptions.name() != null) {
      contentJson.addProperty("name", createFlowsOptions.name());
    }
    if (createFlowsOptions.description() != null) {
      contentJson.addProperty("description", createFlowsOptions.description());
    }
    if (createFlowsOptions.publishedDate() != null) {
      contentJson.addProperty("publishedDate", createFlowsOptions.publishedDate());
    }
    if (createFlowsOptions.publish() != null) {
      contentJson.addProperty("publish", createFlowsOptions.publish());
    }
    if (createFlowsOptions.version() != null) {
      contentJson.addProperty("version", createFlowsOptions.version());
    }
    if (createFlowsOptions.cartridgeId() != null) {
      contentJson.addProperty("cartridgeId", createFlowsOptions.cartridgeId());
    }
    if (createFlowsOptions.annotatorFlows() != null) {
      contentJson.add("annotatorFlows", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createFlowsOptions.annotatorFlows()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Persist a new flow definition.
   *
   * This API persists a new flow.  A flow is identified by an ID.  This ID can optionally be specified as part of the
   * request body when invoking &lt;b&gt;POST /v1/analyze&lt;/b&gt; API.  A flow definition contains a list one or more
   * annotators, and optionally can include annotator configuration, a flow ID, and/or flow sequence.&lt;p&gt;If a
   * caller would choose to have the ID of the new flow generated on their behalf, then in the request body the "id"
   * field of the flow definition should be an empty string ("").  The auto-generated ID would be a normalized form of
   * the "name" field from the flow definition.&lt;p&gt;&lt;p&gt;&lt;b&gt;Sample Flow #1&lt;/b&gt;&lt;br&gt;A flow
   * definition that includes two annotators.&lt;br&gt;&lt;pre&gt;{&lt;br&gt;  "id": "flow_simple",&lt;br&gt;  "name":
   * "flow simple",&lt;br&gt;  "description": "A simple flow with two annotators",&lt;br&gt;  "annotatorFlows":
   * [&lt;br&gt;      {&lt;br&gt;       "flow": {&lt;br&gt;          "elements": [&lt;br&gt;             {&lt;br&gt;
   *           "annotator": {&lt;br&gt;                   "name": "concept_detection"&lt;br&gt;
   * }&lt;br&gt;             },&lt;br&gt;             {&lt;br&gt;               "annotator": {&lt;br&gt;
   *   "name": "symptom_disease"&lt;br&gt;                }&lt;br&gt;             }&lt;br&gt;           ],&lt;br&gt;
   *   "async": false&lt;br&gt;        }&lt;br&gt;      }&lt;br&gt;   ]&lt;br&gt;}&lt;/pre&gt;&lt;p&gt;&lt;b&gt;Sample
   * Flow #2&lt;/b&gt;&lt;br&gt;A flow definition that includes the 'concept_detection' annotator and configuration
   * details for the 'concept_detection' annotator.&lt;br&gt;&lt;pre&gt;{&lt;br&gt;  "id":
   * "flow_concept_detection_exclude_non_neop",&lt;br&gt;  "name": "flow concept detection exclude non neop",&lt;br&gt;
   * "description": "A flow excluding detected concepts that do not have 'neop' semantic type",&lt;br&gt;
   * "annotatorFlows": [&lt;br&gt;      {&lt;br&gt;       "flow": {&lt;br&gt;          "elements": [&lt;br&gt;
   *   {&lt;br&gt;               "annotator": {&lt;br&gt;                   "name": "concept_detection",&lt;br&gt;
   *             "configurations": [&lt;br&gt;                      {&lt;br&gt;                        "filter":
   * {&lt;br&gt;                           "target": "unstructured.data.concepts",&lt;br&gt;
   * "condition": {&lt;br&gt;                              "type": "match",&lt;br&gt;
   * "field": "semanticType",&lt;br&gt;                              "values": [&lt;br&gt;
   *   "neop"&lt;br&gt;                                ],&lt;br&gt;                              "not": false,&lt;br&gt;
   *                              "caseInsensitive": false,&lt;br&gt;                              "operator":
   * "equals"&lt;br&gt;                            }&lt;br&gt;                         }&lt;br&gt;
   * }&lt;br&gt;                    ]&lt;br&gt;                 }&lt;br&gt;              }&lt;br&gt;
   * ],&lt;br&gt;       "async": false&lt;br&gt;        }&lt;br&gt;      }&lt;br&gt;   ]&lt;br&gt;}&lt;/pre&gt;.
   *
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> createFlows() {
    return createFlows(null);
  }

  /**
   * Get details of a specific flow.
   *
   * Using the specified Flow ID, retrieves the flow definition.
   *
   * @param getFlowsByIdOptions the {@link GetFlowsByIdOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link AcdFlow}
   */
  public ServiceCall<AcdFlow> getFlowsById(GetFlowsByIdOptions getFlowsByIdOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getFlowsByIdOptions,
      "getFlowsByIdOptions cannot be null");
    String[] pathSegments = { "v1/flows" };
    String[] pathParameters = { getFlowsByIdOptions.id() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("annotator_for_clinical_data_acd", "v1", "getFlowsById");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", this.version);
    ResponseConverter<AcdFlow> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<AcdFlow>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update a persisted flow definition.
   *
   * Using the specified Flow ID, updates the persisted flow definition.  This is a complete replacement of the existing
   * flow definition using the JSON object provided in the request body.
   *
   * @param updateFlowsOptions the {@link UpdateFlowsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> updateFlows(UpdateFlowsOptions updateFlowsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(updateFlowsOptions,
      "updateFlowsOptions cannot be null");
    String[] pathSegments = { "v1/flows" };
    String[] pathParameters = { updateFlowsOptions.id() };
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("annotator_for_clinical_data_acd", "v1", "updateFlows");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.query("version", this.version);
    final JsonObject contentJson = new JsonObject();
    if (updateFlowsOptions.newId() != null) {
      contentJson.addProperty("id", updateFlowsOptions.newId());
    }
    if (updateFlowsOptions.newName() != null) {
      contentJson.addProperty("name", updateFlowsOptions.newName());
    }
    if (updateFlowsOptions.newDescription() != null) {
      contentJson.addProperty("description", updateFlowsOptions.newDescription());
    }
    if (updateFlowsOptions.newPublishedDate() != null) {
      contentJson.addProperty("publishedDate", updateFlowsOptions.newPublishedDate());
    }
    if (updateFlowsOptions.newPublish() != null) {
      contentJson.addProperty("publish", updateFlowsOptions.newPublish());
    }
    if (updateFlowsOptions.newVersion() != null) {
      contentJson.addProperty("version", updateFlowsOptions.newVersion());
    }
    if (updateFlowsOptions.newCartridgeId() != null) {
      contentJson.addProperty("cartridgeId", updateFlowsOptions.newCartridgeId());
    }
    if (updateFlowsOptions.newAnnotatorFlows() != null) {
      contentJson.add("annotatorFlows", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(updateFlowsOptions.newAnnotatorFlows()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete a persisted flow.
   *
   * Using the specified Flow ID, deletes the flow from the list of persisted flows.
   *
   * @param deleteFlowsOptions the {@link DeleteFlowsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteFlows(DeleteFlowsOptions deleteFlowsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteFlowsOptions,
      "deleteFlowsOptions cannot be null");
    String[] pathSegments = { "v1/flows" };
    String[] pathParameters = { deleteFlowsOptions.id() };
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("annotator_for_clinical_data_acd", "v1", "deleteFlows");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.query("version", this.version);
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Detect entities &amp; relations from unstructured data.
   *
   * &lt;p&gt;This API accepts a JSON request model featuring both the unstructured data to be analyzed as well as the
   * desired annotator flow.&lt;p/&gt;&lt;p&gt;&lt;b&gt;Annotator Chaining&lt;/b&gt;&lt;br/&gt;Sample request invoking
   * both the concept_detection and symptom_disease annotators asynchronously. This sample request references
   * configurations via a profile id. Profiles define configurations that can be referenced within a request. Profile is
   * optional. A default profile is used if no profile id is available in the annotator flow. The default profile
   * contains the parameters for the concept detection and the attribute detection. An empty profile can be used if
   * absolutely no parameters are attached to any annotators. See &lt;a href=".."
   * target="_blank"&gt;documentation&lt;/a&gt; for more information. &lt;/p&gt;&lt;pre&gt;{&lt;br/&gt;
   * "annotatorFlows": [&lt;br/&gt;    {&lt;br/&gt;      "profile" : "default_profile_v1.0", &lt;br/&gt;      "flow":
   * {&lt;br/&gt;        "elements": [&lt;br/&gt;          {&lt;br/&gt;            "annotator": {&lt;br/&gt;
   *  "name": "concept_detection"&lt;br/&gt;            }&lt;br/&gt;          },&lt;br/&gt;          {&lt;br/&gt;
   *     "annotator": {&lt;br/&gt;              "name": "symptom_disease"&lt;br/&gt;             }&lt;br/&gt;
   * }&lt;br/&gt;        ],&lt;br/&gt;        "async": false&lt;br/&gt;      }&lt;br/&gt;    }&lt;br/&gt;  ],&lt;br/&gt;
   *  "unstructured": [&lt;br/&gt;    {&lt;br/&gt;      "text": "Patient has lung cancer, but did not smoke. She may
   * consider chemotherapy as part of a treatment plan."&lt;br/&gt;    }&lt;br/&gt;
   * ]&lt;br/&gt;}&lt;br/&gt;&lt;/pre&gt;&lt;p&gt;&lt;b&gt;Annotation Filtering&lt;/b&gt;&lt;br/&gt;Sample request
   * invoking concept_detection with a filter defined to exclude any annotations detected from concept_detection where
   * the semanticType field does not equal "neop".&lt;/p&gt;&lt;pre&gt;{&lt;br/&gt;  "annotatorFlows": [&lt;br/&gt;
   * {&lt;br/&gt;      "flow": {&lt;br/&gt;        "elements": [&lt;br/&gt;          {&lt;br/&gt;
   * "annotator": {&lt;br/&gt;              "name": "concept_detection",&lt;br/&gt;              "configurations":
   * [&lt;br/&gt;                {&lt;br/&gt;                  "filter": {&lt;br/&gt;                     "target":
   * "unstructured.data.concepts",&lt;br/&gt;                     "condition": {&lt;br/&gt;
   * "type": "match",&lt;br/&gt;                        "field": "semanticType",&lt;br/&gt;
   * "values": [&lt;br/&gt;                           "neop"&lt;br/&gt;                         ],&lt;br/&gt;
   *             "not": false,&lt;br/&gt;                        "caseInsensitive": false,&lt;br/&gt;
   *     "operator": "equals"&lt;br/&gt;                     }&lt;br/&gt;                  }&lt;br/&gt;
   * }&lt;br/&gt;              ]&lt;br/&gt;            }&lt;br/&gt;          }&lt;br/&gt;        ],&lt;br/&gt;
   * "async": false&lt;br/&gt;      }&lt;br/&gt;    }&lt;br/&gt;  ],&lt;br/&gt;  "unstructured": [&lt;br/&gt;
   * {&lt;br/&gt;      "text": "Patient has lung cancer, but did not smoke. She may consider chemotherapy as part of a
   * treatment plan."&lt;br/&gt;    }&lt;br/&gt;  ]&lt;br/&gt;}&lt;br/&gt;&lt;/pre&gt;&lt;p&gt;&lt;b&gt;Annotators that
   * support annotation filtering:&lt;/b&gt; allergy, bathing_assistance, cancer, concept_detection,
   * dressing_assistance, eating_assistance, ejection_fraction, lab_value, medication, named_entities, procedure,
   * seeing_assistance, smoking, symptom_disease, toileting_assistance,
   * walking_assistance.&lt;/p&gt;&lt;hr/&gt;&lt;p&gt;&lt;b&gt;Annotation Augmentation&lt;/b&gt;&lt;br/&gt;Sample
   * request invoking the cancer annotator and providing a whitelist entry for a new custom surface form:
   * "lungcancer".&lt;/p&gt;&lt;pre&gt;{&lt;br/&gt; "annotatorFlows": [&lt;br/&gt;    {&lt;br/&gt;     "flow":
   * {&lt;br/&gt;       "elements": [&lt;br/&gt;          {&lt;br/&gt;           "annotator": {&lt;br/&gt;
   * "name": "cancer",&lt;br/&gt;             "configurations": [&lt;br/&gt;                {&lt;br/&gt;
   * "whitelist": {&lt;br/&gt;                   "name": "cancer",&lt;br/&gt;                   "entries": [&lt;br/&gt;
   *                     {&lt;br/&gt;                  "surfaceForms": [&lt;br/&gt;
   * "lungcancer"&lt;br/&gt;                ],&lt;br/&gt;               "features": {&lt;br/&gt;
   * "normalizedName": "lung cancer",&lt;br/&gt;                   "hccCode": "9",&lt;br/&gt;
   * "icd10Code": "C34.9",&lt;br/&gt;                   "ccsCode": "19",&lt;br/&gt;                   "icd9Code":
   * "162.9",&lt;br/&gt;                   "conceptId": "93880001"&lt;br/&gt;                }&lt;br/&gt;
   *       }&lt;br/&gt;                    ]&lt;br/&gt;                  }&lt;br/&gt;                }&lt;br/&gt;
   *       ]&lt;br/&gt;            }&lt;br/&gt;          }&lt;br/&gt;        ],&lt;br/&gt;       "async":
   * false&lt;br/&gt;      }&lt;br/&gt;    }&lt;br/&gt;  ],&lt;br/&gt; "unstructured": [&lt;br/&gt;    {&lt;br/&gt;
   * "text": "The patient was diagnosed with lungcancer, on Dec 23, 2011."&lt;br/&gt;    }&lt;br/&gt;
   * ]&lt;br/&gt;}&lt;br/&gt;&lt;/pre&gt;&lt;b&gt;Annotators that support annotation augmentation:&lt;/b&gt; allergy,
   * bathing_assistance, cancer, dressing_assistance, eating_assistance, ejection_fraction, lab_value, medication,
   * named_entities, procedure, seeing_assistance, smoking, symptom_disease, toileting_assistance,
   * walking_assistance.&lt;br/&gt;.
   *
   * @param runPipelineOptions the {@link RunPipelineOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> runPipeline(RunPipelineOptions runPipelineOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(runPipelineOptions,
      "runPipelineOptions cannot be null");
    String[] pathSegments = { "v1/analyze" };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("annotator_for_clinical_data_acd", "v1", "runPipeline");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.query("version", this.version);
    if (runPipelineOptions.debugTextRestore() != null) {
      builder.query("debug_text_restore", String.valueOf(runPipelineOptions.debugTextRestore()));
    }
    if (runPipelineOptions.returnAnalyzedText() != null) {
      builder.query("return_analyzed_text", String.valueOf(runPipelineOptions.returnAnalyzedText()));
    }
    final JsonObject contentJson = new JsonObject();
    if (runPipelineOptions.unstructured() != null) {
      contentJson.add("unstructured", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(runPipelineOptions.unstructured()));
    }
    if (runPipelineOptions.annotatorFlows() != null) {
      contentJson.add("annotatorFlows", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(runPipelineOptions.annotatorFlows()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Detect entities & relations from unstructured data.
   *
   * &lt;p&gt;This API accepts a JSON request model featuring both the unstructured data to be analyzed as well as the
   * desired annotator flow.&lt;p/&gt;&lt;p&gt;&lt;b&gt;Annotator Chaining&lt;/b&gt;&lt;br/&gt;Sample request invoking
   * both the concept_detection and symptom_disease annotators asynchronously. This sample request references
   * configurations via a profile id. Profiles define configurations that can be referenced within a request. Profile is
   * optional. A default profile is used if no profile id is available in the annotator flow. The default profile
   * contains the parameters for the concept detection and the attribute detection. An empty profile can be used if
   * absolutely no parameters are attached to any annotators. See &lt;a href=".."
   * target="_blank"&gt;documentation&lt;/a&gt; for more information. &lt;/p&gt;&lt;pre&gt;{&lt;br/&gt;
   * "annotatorFlows": [&lt;br/&gt;    {&lt;br/&gt;      "profile" : "default_profile_v1.0", &lt;br/&gt;      "flow":
   * {&lt;br/&gt;        "elements": [&lt;br/&gt;          {&lt;br/&gt;            "annotator": {&lt;br/&gt;
   *  "name": "concept_detection"&lt;br/&gt;            }&lt;br/&gt;          },&lt;br/&gt;          {&lt;br/&gt;
   *     "annotator": {&lt;br/&gt;              "name": "symptom_disease"&lt;br/&gt;             }&lt;br/&gt;
   * }&lt;br/&gt;        ],&lt;br/&gt;        "async": false&lt;br/&gt;      }&lt;br/&gt;    }&lt;br/&gt;  ],&lt;br/&gt;
   *  "unstructured": [&lt;br/&gt;    {&lt;br/&gt;      "text": "Patient has lung cancer, but did not smoke. She may
   * consider chemotherapy as part of a treatment plan."&lt;br/&gt;    }&lt;br/&gt;
   * ]&lt;br/&gt;}&lt;br/&gt;&lt;/pre&gt;&lt;p&gt;&lt;b&gt;Annotation Filtering&lt;/b&gt;&lt;br/&gt;Sample request
   * invoking concept_detection with a filter defined to exclude any annotations detected from concept_detection where
   * the semanticType field does not equal "neop".&lt;/p&gt;&lt;pre&gt;{&lt;br/&gt;  "annotatorFlows": [&lt;br/&gt;
   * {&lt;br/&gt;      "flow": {&lt;br/&gt;        "elements": [&lt;br/&gt;          {&lt;br/&gt;
   * "annotator": {&lt;br/&gt;              "name": "concept_detection",&lt;br/&gt;              "configurations":
   * [&lt;br/&gt;                {&lt;br/&gt;                  "filter": {&lt;br/&gt;                     "target":
   * "unstructured.data.concepts",&lt;br/&gt;                     "condition": {&lt;br/&gt;
   * "type": "match",&lt;br/&gt;                        "field": "semanticType",&lt;br/&gt;
   * "values": [&lt;br/&gt;                           "neop"&lt;br/&gt;                         ],&lt;br/&gt;
   *             "not": false,&lt;br/&gt;                        "caseInsensitive": false,&lt;br/&gt;
   *     "operator": "equals"&lt;br/&gt;                     }&lt;br/&gt;                  }&lt;br/&gt;
   * }&lt;br/&gt;              ]&lt;br/&gt;            }&lt;br/&gt;          }&lt;br/&gt;        ],&lt;br/&gt;
   * "async": false&lt;br/&gt;      }&lt;br/&gt;    }&lt;br/&gt;  ],&lt;br/&gt;  "unstructured": [&lt;br/&gt;
   * {&lt;br/&gt;      "text": "Patient has lung cancer, but did not smoke. She may consider chemotherapy as part of a
   * treatment plan."&lt;br/&gt;    }&lt;br/&gt;  ]&lt;br/&gt;}&lt;br/&gt;&lt;/pre&gt;&lt;p&gt;&lt;b&gt;Annotators that
   * support annotation filtering:&lt;/b&gt; allergy, bathing_assistance, cancer, concept_detection,
   * dressing_assistance, eating_assistance, ejection_fraction, lab_value, medication, named_entities, procedure,
   * seeing_assistance, smoking, symptom_disease, toileting_assistance,
   * walking_assistance.&lt;/p&gt;&lt;hr/&gt;&lt;p&gt;&lt;b&gt;Annotation Augmentation&lt;/b&gt;&lt;br/&gt;Sample
   * request invoking the cancer annotator and providing a whitelist entry for a new custom surface form:
   * "lungcancer".&lt;/p&gt;&lt;pre&gt;{&lt;br/&gt; "annotatorFlows": [&lt;br/&gt;    {&lt;br/&gt;     "flow":
   * {&lt;br/&gt;       "elements": [&lt;br/&gt;          {&lt;br/&gt;           "annotator": {&lt;br/&gt;
   * "name": "cancer",&lt;br/&gt;             "configurations": [&lt;br/&gt;                {&lt;br/&gt;
   * "whitelist": {&lt;br/&gt;                   "name": "cancer",&lt;br/&gt;                   "entries": [&lt;br/&gt;
   *                     {&lt;br/&gt;                  "surfaceForms": [&lt;br/&gt;
   * "lungcancer"&lt;br/&gt;                ],&lt;br/&gt;               "features": {&lt;br/&gt;
   * "normalizedName": "lung cancer",&lt;br/&gt;                   "hccCode": "9",&lt;br/&gt;
   * "icd10Code": "C34.9",&lt;br/&gt;                   "ccsCode": "19",&lt;br/&gt;                   "icd9Code":
   * "162.9",&lt;br/&gt;                   "conceptId": "93880001"&lt;br/&gt;                }&lt;br/&gt;
   *       }&lt;br/&gt;                    ]&lt;br/&gt;                  }&lt;br/&gt;                }&lt;br/&gt;
   *       ]&lt;br/&gt;            }&lt;br/&gt;          }&lt;br/&gt;        ],&lt;br/&gt;       "async":
   * false&lt;br/&gt;      }&lt;br/&gt;    }&lt;br/&gt;  ],&lt;br/&gt; "unstructured": [&lt;br/&gt;    {&lt;br/&gt;
   * "text": "The patient was diagnosed with lungcancer, on Dec 23, 2011."&lt;br/&gt;    }&lt;br/&gt;
   * ]&lt;br/&gt;}&lt;br/&gt;&lt;/pre&gt;&lt;b&gt;Annotators that support annotation augmentation:&lt;/b&gt; allergy,
   * bathing_assistance, cancer, dressing_assistance, eating_assistance, ejection_fraction, lab_value, medication,
   * named_entities, procedure, seeing_assistance, smoking, symptom_disease, toileting_assistance,
   * walking_assistance.&lt;br/&gt;.
   *
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> runPipeline() {
    return runPipeline(null);
  }

  /**
   * analyze with a pre-specified flow.
   *
   * &lt;p&gt;This API accepts a flow identifier as well as a &lt;emph&gt;TEXT&lt;/emph&gt; or a
   * &lt;emph&gt;JSON&lt;/emph&gt; request model featuring the unstructured text to be analyzed.
   * &lt;p/&gt;&lt;p&gt;&lt;b&gt;JSON request model with unstructured text &lt;/b&gt;&lt;/p&gt;&lt;pre&gt;{&lt;br/&gt;
   * "unstructured": [&lt;br/&gt;    {&lt;br/&gt;      "text": "Patient has lung cancer, but did not smoke. She may
   * consider chemotherapy as part of a treatment plan."&lt;br/&gt;    }&lt;br/&gt;
   * ]&lt;br/&gt;}&lt;br/&gt;&lt;/pre&gt;&lt;p&gt;&lt;b&gt;JSON request model with existing annotations
   * &lt;/b&gt;&lt;br/&gt;&lt;/p&gt;&lt;pre&gt;{&lt;br&gt; "unstructured": [&lt;br&gt;    {&lt;br&gt;      "text":
   * "Patient will not start on cisplatin 80mg on 1/1/2018. Patient is also diabetic.",&lt;br&gt;      "data":
   * {&lt;br&gt;        "concepts": [&lt;br&gt;          {&lt;br&gt;            "cui": "C0030705",&lt;br&gt;
   * "preferredName": "Patients",&lt;br&gt;            "semanticType": "podg",&lt;br&gt;            "source":
   * "umls",&lt;br&gt;            "sourceVersion": "2017AA",&lt;br&gt;            "type":
   * "umls.PatientOrDisabledGroup",&lt;br&gt;            "begin": 0,&lt;br&gt;            "end": 7,&lt;br&gt;
   * "coveredText": "Patient"&lt;br&gt;          }&lt;br&gt; ]&lt;br&gt;      }  &lt;br&gt;    } &lt;br&gt;
   * ]&lt;br&gt;}&lt;br&gt;&lt;/pre&gt;.
   *
   * @param runPipelineWithFlowOptions the {@link RunPipelineWithFlowOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> runPipelineWithFlow(RunPipelineWithFlowOptions runPipelineWithFlowOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(runPipelineWithFlowOptions,
      "runPipelineWithFlowOptions cannot be null");
    String[] pathSegments = { "v1/analyze" };
    String[] pathParameters = { runPipelineWithFlowOptions.flowId() };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("annotator_for_clinical_data_acd", "v1", "runPipelineWithFlow");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    if (runPipelineWithFlowOptions.contentType() != null) {
      builder.header("Content-Type", runPipelineWithFlowOptions.contentType());
    }
    builder.query("version", this.version);
    builder.query("return_analyzed_text", String.valueOf(runPipelineWithFlowOptions.returnAnalyzedText()));
    if (runPipelineWithFlowOptions.debugTextRestore() != null) {
      builder.query("debug_text_restore", String.valueOf(runPipelineWithFlowOptions.debugTextRestore()));
    }
    builder.bodyContent(runPipelineWithFlowOptions.contentType(), runPipelineWithFlowOptions.analyticFlowBeanInput(),
      null, runPipelineWithFlowOptions.body());
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

     /**
     * Derive entities and relations from unstructured data.
     *
     * This API accepts a JSON request model featuring both the unstructured data to
     * be analyzed as well as the desired annotator flow.
     *
     * Annotator Chaining Sample request invoking both the concept_detection and
     * symptom_disease annotators asynchronously. { "annotatorFlows": [ { "flow": {
     * "elements": [ { "annotator": { "name": "concept_detection" } }, {
     * "annotator": { "name": "symptom_disease" } } ], "async": true } } ],
     * "unstructured\": [ { "text": "Patient has lung cancer, but did not smoke. She
     * may consider chemotherapy as part of a treatment plan." } ] }
     *
     * Annotation Filtering Sample request invoking concept_detection with a filter
     * defined to exclude any annotations derived from concept_detection where the
     * semanticType field does not equal "neop".
     *
     * { "annotatorFlows": {"flow": {"elements": [{"annotator": {"name":
     * "concept_detection", "configurations": [ {"filter": {"target":
     * "unstructured.data.concepts","condition": { "type": "match", "field":
     * "semanticType", "values": ["neop"], "not": false, "caseInsensitive": false,
     * "operator": "equals" } }}]}}], "async": false }}], unstructured": [{"text":
     * "Patient has lung cancer, but did not smoke. She may consider chemotherapy as
     * part of a treatment plan."} ]}Annotators that support annotation filtering:
     * allergy, bathing_assistance, cancer, concept_detection, dressing_assistance,
     * eating_assistance, ejection_fraction, lab_value, medication, named_entities,
     * procedure, seeing_assistance, smoking, symptom_disease, toileting_assistance,
     * walking_assistance. Annotation Augmentation Sample request invoking the
     * cancer annotator and providing a whitelist entry for a new custom surface
     * form: "lungcancer". {"annotatorFlows": [{"flow": {"elements": [ {
     * "annotator": {"name": "cancer", "configurations": [{"whitelist": {"name":
     * "cancer","entries": [ {"surfaceForms": ["lungcancer"],"features":
     * {"normalizedName": "lung cancer", "hccCode": "9", "icd10Code": "C34.9",
     * "ccsCode": "19", "icd9Code": "162.9", "conceptId": "93880001" } }]}}]}}],
     * "async": false}}], "unstructured": [{"text": "The patient was diagnosed with
     * lungcancer, on Dec 23, 2011." }]}
     *
     * Annotators that support annotation augmentation: allergy, bathing_assistance,
     * cancer, dressing_assistance, eating_assistance, ejection_fraction, lab_value,
     * medication, named_entities, procedure, seeing_assistance, smoking,
     * symptom_disease, toileting_assistance, walking_assistance. .
     *
     * @param analyzeOptions the {@link AnalyzeOptions} containing the options for
     *                       the call
     * @return the service call
     */
    public ServiceCall<ContainerGroup> analyze(final AnalyzeOptions analyzeOptions) {
      Validator.notNull(analyzeOptions, "analyzeOptions cannot be null");
      String[] pathSegments = { "v1/analyze" };
      RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
      builder.query(VERSION, version);
      builder.query(RETURN_ANALYZED_TEXT, String.valueOf(analyzeOptions.returnAnalyzedText()));
      Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders(DEFAULT_SERVICE_NAME, "v1", "analyze");
      for (Entry<String, String> header : sdkHeaders.entrySet()) {
          builder.header(header.getKey(), header.getValue());
      }
      if (analyzeOptions != null) {
          final JsonObject contentJson = new JsonObject();
          if (analyzeOptions.unstructured() != null) {
              contentJson.add("unstructured", GsonSingleton.getGson().toJsonTree(analyzeOptions.unstructured()));
          }
          if (analyzeOptions.annotatorFlows() != null) {
              contentJson.add("annotatorFlows", GsonSingleton.getGson().toJsonTree(analyzeOptions.annotatorFlows()));
          }
          builder.bodyJson(contentJson);
      }
      return createServiceCall(builder.build(), ResponseConverterUtils.getObject(ContainerGroup.class));
  }

  /**
   * analyze with a persisted flow.
   *
   * This API accepts a flow identifier as well as a TEXT or a JSON request model
   * featuring the unstructured text to be analyzed. JSON request model with
   * unstructured text
   *
   * { "unstructured": [ {"text": "Patient has lung cancer, but did not smoke. She
   * may consider chemotherapy as part of a treatment plan." } ]} JSON request
   * model with existing annotations {"unstructured": [{"text": "Patient will not
   * start on cisplatin 80mg on 1/1/2018. Patient is also diabetic.", "data":
   * {"concepts": [{"cui": "C0030705", "preferredName": "Patients",
   * "semanticType": "podg", "source": "umls", "sourceVersion": "2017AA", "type":
   * "umls.PatientOrDisabledGroup", "begin": 0, "end": 7, "coveredText":
   * "Patient"}]}}]} .
   *
   * @param analyzeWithFlowOptions the {@link AnalyzeWithFlowOptions} containing
   *                               the options for the call
   * @return the service call
   */
  public ServiceCall<ContainerGroup> analyzeWithFlow(final AnalyzeWithFlowOptions analyzeWithFlowOptions) {
      Validator.notNull(analyzeWithFlowOptions, "analyzeWithFlowOptions cannot be null");
      String[] pathSegments = { "v1/analyze" };
      String[] pathParameters = { analyzeWithFlowOptions.flowId() };
      RequestBuilder builder = RequestBuilder
              .post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
      Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders(DEFAULT_SERVICE_NAME, "v1", "analyzeWithFlow");
      for (Entry<String, String> header : sdkHeaders.entrySet()) {
          builder.header(header.getKey(), header.getValue());
      }
      builder.query(VERSION, version);
      builder.query(RETURN_ANALYZED_TEXT, String.valueOf(analyzeWithFlowOptions.returnAnalyzedText()));
      builder.header("content-type", analyzeWithFlowOptions.contentType());

      if (analyzeWithFlowOptions.contentType()
              .equalsIgnoreCase(AnalyzeWithFlowOptions.ContentType.APPLICATION_JSON)) {
          builder.bodyJson(GsonSingleton.getGson().toJsonTree(analyzeWithFlowOptions.request()).getAsJsonObject());
      } else {
          builder.bodyContent(analyzeWithFlowOptions.body(), analyzeWithFlowOptions.contentType());
      }
      return createServiceCall(builder.build(), ResponseConverterUtils.getObject(ContainerGroup.class));
  }

      /**
     * Method to analyze text with a manually defined annotator flow.
     *
     * @param text data to be analyzed
     * @param flow {@link Flow} analytics to apply to the text
     *
     * @return the {@link ContainerGroup} discovered cogntive artifacts
     */

    public ContainerGroup analyze(final String text, final Flow flow) {
      AnnotatorFlow annotatorFlow = new AnnotatorFlow.Builder().flow(flow).build();
      UnstructuredContainer unstructuredContainer = new UnstructuredContainer.Builder().text(text).build();
      AnalyzeOptions options = new AnalyzeOptions.Builder().addUnstructured(unstructuredContainer)
              .returnAnalyzedText(false).addAnnotatorFlows(annotatorFlow).build();

      return this.analyze(options).execute().getResult();
  }

  /**
   * Method to analyze text with a manually defined annotator flow.
   *
   * @param text data to be analyzed
   * @param flow {@link Flow} analytics to apply to the text
   *
   * @return the response with {@link ContainerGroup}
   */

  public Response<ContainerGroup> analyzeInclResponseDetails(final String text, final Flow flow) {
      AnnotatorFlow annotatorFlow = new AnnotatorFlow.Builder().flow(flow).build();
      UnstructuredContainer unstructuredContainer = new UnstructuredContainer.Builder().text(text).build();
      AnalyzeOptions options = new AnalyzeOptions.Builder().addUnstructured(unstructuredContainer)
              .returnAnalyzedText(false).addAnnotatorFlows(annotatorFlow).build();

      return this.analyze(options).execute();
  }

  /**
   * Method to analyze text with a manually defined annotator flow.
   *
   * @param text data to be analyzed
   * @param flow analytics to appply to the text {@link Flow}
   * @param returnAnalyzedText where to return the submitted data
   *
   * @return the {@link ContainerGroup}
   */

  public ContainerGroup analyze(final String text, final Flow flow, final boolean returnAnalyzedText) {
      AnnotatorFlow annotatorFlow = new AnnotatorFlow.Builder().flow(flow).build();
      UnstructuredContainer unstructuredContainer = new UnstructuredContainer.Builder().text(text).build();
      AnalyzeOptions options = new AnalyzeOptions.Builder().addUnstructured(unstructuredContainer)
              .returnAnalyzedText(returnAnalyzedText).addAnnotatorFlows(annotatorFlow).build();

      return this.analyze(options).execute().getResult();
  }

  /**
   * Method to analyze text with a manually defined annotator flow.
   *
   * @param text data to be analyzed
   * @param flow  analytics to appply to the text {@link Flow}
   * @param returnAnalyzedText where to return the submitted data
   *
   * @return the resopnse with result representing {@link ContainerGroup}
   */

  public Response<ContainerGroup> analyzeInclResponseDetails(final String text, final Flow flow,
          final boolean returnAnalyzedText) {
      AnnotatorFlow annotatorFlow = new AnnotatorFlow.Builder().flow(flow).build();
      UnstructuredContainer unstructuredContainer = new UnstructuredContainer.Builder().text(text).build();
      AnalyzeOptions options = new AnalyzeOptions.Builder().addUnstructured(unstructuredContainer)
              .returnAnalyzedText(returnAnalyzedText).addAnnotatorFlows(annotatorFlow).build();

      return this.analyze(options).execute();
  }

  /**
   * Method to analyze text with an existing annotator flow.
   *
   * @param flowId identifier of existing analytic flow to apply to the text
   * @param text data to be analyzed
   *
   * @return the {@link ContainerGroup}
   */

  public ContainerGroup analyzeWithFlow(final String flowId, final String text) {
      AnalyzeWithFlowOptions analyzeWithFlowOptions = new AnalyzeWithFlowOptions.Builder().flowId(flowId).text(text)
              .returnAnalyzedText(false).build();

      return this.analyzeWithFlow(analyzeWithFlowOptions).execute().getResult();
  }

  /**
   * Method to analyze text with an existing annotator flow.
   *
   * @param flowId identifier of existing analytic flow to apply to the text
   * @param text data to be analyzed
   *
   * @return the resopnse with result representing {@link ContainerGroup}
   */

  public Response<ContainerGroup> analyzeWithFlowInclResponseDetails(final String flowId, final String text) {
      AnalyzeWithFlowOptions analyzeWithFlowOptions = new AnalyzeWithFlowOptions.Builder().flowId(flowId).text(text)
              .returnAnalyzedText(false).build();

      return this.analyzeWithFlow(analyzeWithFlowOptions).execute();
  }

  /**
   * Method to analyze text with an existing annotator flow.
   *
   * @param flowId identifier of existing analytic flow to apply to the text
   * @param text data to be analyzed
   * @param returnAnalyzedText where to return the submitted data
   *
   * @return the resopnse with result representing {@link ContainerGroup}
   */

  public ContainerGroup analyzeWithFlow(final String flowId, final String text, final boolean returnAnalyzedText) {
      AnalyzeWithFlowOptions analyzeWithFlowOptions = new AnalyzeWithFlowOptions.Builder().flowId(flowId).text(text)
              .returnAnalyzedText(returnAnalyzedText).build();

      return this.analyzeWithFlow(analyzeWithFlowOptions).execute().getResult();
  }

  /**
   * Method to analyze text with an existing annotator flow.
   *
   * @param flowId identifier of existing analytic flow to apply to the text
   * @param text data to be analyzed
   * @param returnAnalyzedText where to return the submitted data
   *
   * @return the resopnse with result representing {@link ContainerGroup}
   */

  public Response<ContainerGroup> analyzeWithFlowInclResponseDetails(final String flowId, final String text,
          final boolean returnAnalyzedText) {
      AnalyzeWithFlowOptions analyzeWithFlowOptions = new AnalyzeWithFlowOptions.Builder().flowId(flowId).text(text)
              .returnAnalyzedText(returnAnalyzedText).build();

      return this.analyzeWithFlow(analyzeWithFlowOptions).execute();
  }

  /**
   * Method to analyze text with an existing annotator flow.
   *
   * @param flowId identifier of existing analytic flow to apply to the text
   * @param unstructuredContainer {@link UnstructuredContainer} discovered cogntive artifacts
   *
   * @return the {@link ContainerGroup}
   */

  public ContainerGroup analyzeWithFlow(final String flowId, final UnstructuredContainer unstructuredContainer) {
      RequestContainer requestContainer = new RequestContainer.Builder().addUnstructured(unstructuredContainer)
              .build();

      AnalyzeWithFlowOptions analyzeWithFlowOptions = new AnalyzeWithFlowOptions.Builder().flowId(flowId)
              .returnAnalyzedText(false).request(requestContainer).build();

      return this.analyzeWithFlow(analyzeWithFlowOptions).execute().getResult();
  }

  /**
   * Method to analyze text with an existing annotator flow.
   *
   * @param flowId identifier of existing analytic flow to apply to the text
   * @param unstructuredContainer {@link UnstructuredContainer} discovered cogntive artifacts
   *
   * @return the resopnse with result representing {@link ContainerGroup}
   */

  public Response<ContainerGroup> analyzeWithFlowInclResponseDetails(final String flowId,
          final UnstructuredContainer unstructuredContainer) {
      RequestContainer requestContainer = new RequestContainer.Builder().addUnstructured(unstructuredContainer)
              .build();

      AnalyzeWithFlowOptions analyzeWithFlowOptions = new AnalyzeWithFlowOptions.Builder().flowId(flowId)
              .returnAnalyzedText(false).request(requestContainer).build();

      return this.analyzeWithFlow(analyzeWithFlowOptions).execute();
  }

  /**
   * Method to analyze text with an existing annotator flow.
   *
   * @param flowId identifier of existing analytic flow to apply to the text
   * @param unstructuredContainer {@link UnstructuredContainer}
   * @param returnAnalyzedText where to return the submitted data
   *
   * @return the {@link ContainerGroup} discovered cogntive artifacts
   */

  public ContainerGroup analyzeWithFlow(final String flowId, final UnstructuredContainer unstructuredContainer,
          final boolean returnAnalyzedText) {
      RequestContainer requestContainer = new RequestContainer.Builder().addUnstructured(unstructuredContainer)
              .build();

      AnalyzeWithFlowOptions analyzeWithFlowOptions = new AnalyzeWithFlowOptions.Builder().flowId(flowId)
              .returnAnalyzedText(returnAnalyzedText).request(requestContainer).build();

      return this.analyzeWithFlow(analyzeWithFlowOptions).execute().getResult();
  }

  /**
   * Method to analyze text with an existing annotator flow.
   *
   * @param flowId identifier of existing analytic flow to apply to the text
   * @param unstructuredContainer {@link UnstructuredContainer}
   * @param returnAnalyzedText where to return the submitted data
   *
   * @return the resopnse with result representing {@link ContainerGroup}
   */

  public Response<ContainerGroup> analyzeWithFlowInclResponseDetails(final String flowId,
          final UnstructuredContainer unstructuredContainer, final boolean returnAnalyzedText) {
      RequestContainer requestContainer = new RequestContainer.Builder().addUnstructured(unstructuredContainer)
              .build();

      AnalyzeWithFlowOptions analyzeWithFlowOptions = new AnalyzeWithFlowOptions.Builder().flowId(flowId)
              .returnAnalyzedText(returnAnalyzedText).request(requestContainer).build();

      return this.analyzeWithFlow(analyzeWithFlowOptions).execute();
  }

  /**
   * Get list of available annotators.
   *
   * Get list of available annotators that can be leveraged to detect information from unstructured data. One or more
   * annnotators can be leveraged within a single request to the service.
   *
   * @param getAnnotatorsOptions the {@link GetAnnotatorsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<ListStringWrapper> getAnnotators(GetAnnotatorsOptions getAnnotatorsOptions) {
    String[] pathSegments = { "v1/annotators" };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("annotator_for_clinical_data_acd", "v1", "getAnnotators");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    if (getAnnotatorsOptions != null) {
      builder.query("version", this.version);
    }
    ResponseConverter<ListStringWrapper> responseConverter =
    		ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ListStringWrapper>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get list of available annotators.
   *
   * Get list of available annotators that can be leveraged to detect information from unstructured data. One or more
   * annnotators can be leveraged within a single request to the service.
   *
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<ListStringWrapper> getAnnotators() {
    return getAnnotators(null);
  }

  /**
   * Get details of a specific annotator.
   *
   * Get details of an annotator that can be used to detect information from unstructured data.
   *
   * @param getAnnotatorsByIdOptions the {@link GetAnnotatorsByIdOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Annotator> getAnnotatorsById(GetAnnotatorsByIdOptions getAnnotatorsByIdOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getAnnotatorsByIdOptions,
      "getAnnotatorsByIdOptions cannot be null");
    String[] pathSegments = { "v1/annotators" };
    String[] pathParameters = { getAnnotatorsByIdOptions.id() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("annotator_for_clinical_data_acd", "v1", "getAnnotatorsById");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.query("version", this.version);
    ResponseConverter<Annotator> responseConverter = ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Annotator>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete tenant specific artifacts.
   *
   * Delete tenant specific artifacts.
   *
   * @param deleteUserSpecificArtifactsOptions the {@link DeleteUserSpecificArtifactsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteUserSpecificArtifacts(DeleteUserSpecificArtifactsOptions deleteUserSpecificArtifactsOptions) {
    String[] pathSegments = { "v1/user_data" };
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("annotator_for_clinical_data_acd", "v1", "deleteUserSpecificArtifacts");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    if (deleteUserSpecificArtifactsOptions != null) {
      builder.query("version", this.version);
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete tenant specific artifacts.
   *
   * Delete tenant specific artifacts.
   *
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteUserSpecificArtifacts() {
    return deleteUserSpecificArtifacts(null);
  }

  /**
   * Get list of available deployment status.
   *
   * Returns a summary including ID and status of the available deployments.
   *
   * @param cartridgesGetOptions the {@link CartridgesGetOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ListStringWrapper}
   */
  public ServiceCall<ListStringWrapper> cartridgesGet(CartridgesGetOptions cartridgesGetOptions) {
    String[] pathSegments = { "v1/cartridges" };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("annotator_for_clinical_data_acd", "v1", "cartridgesGet");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (cartridgesGetOptions != null) {
      builder.query("version", this.version);
    }
    ResponseConverter<ListStringWrapper> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ListStringWrapper>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get list of available deployment status.
   *
   * Returns a summary including ID and status of the available deployments.
   *
   * @return a {@link ServiceCall} with a result of type {@link ListStringWrapper}
   */
  public ServiceCall<ListStringWrapper> cartridgesGet() {
    return cartridgesGet(null);
  }

  /**
   * Create a cartridge deployment.
   *
   * Create a cartridge deployment from a cartridge archive file.
   *
   * @param cartridgesPostMultipartOptions the {@link CartridgesPostMultipartOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link DeployCartridgeResponse}
   */
  public ServiceCall<DeployCartridgeResponse> cartridgesPostMultipart(CartridgesPostMultipartOptions cartridgesPostMultipartOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(cartridgesPostMultipartOptions,
      "cartridgesPostMultipartOptions cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.isTrue((cartridgesPostMultipartOptions.archiveFile() != null), "At least one of  or archiveFile must be supplied.");
    String[] pathSegments = { "v1/cartridges" };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("annotator_for_clinical_data_acd", "v1", "cartridgesPostMultipart");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", this.version);
    MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
    multipartBuilder.setType(MultipartBody.FORM);
    if (cartridgesPostMultipartOptions.archiveFile() != null) {
      okhttp3.RequestBody archiveFileBody = RequestUtils.inputStreamBody(cartridgesPostMultipartOptions.archiveFile(), cartridgesPostMultipartOptions.archiveFileContentType());
      multipartBuilder.addFormDataPart("archive_file", "filename", archiveFileBody);
    }
    builder.body(multipartBuilder.build());
    ResponseConverter<DeployCartridgeResponse> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<DeployCartridgeResponse>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create a cartridge deployment.
   *
   * Create a cartridge deployment from a cartridge archive file.
   *
   * @return a {@link ServiceCall} with a result of type {@link DeployCartridgeResponse}
   */
  public ServiceCall<DeployCartridgeResponse> cartridgesPostMultipart() {
    return cartridgesPostMultipart(null);
  }

  /**
   * Create a cartridge deployment.
   *
   * Update a cartridge deployment from a cartridge archive file.
   *
   * @param cartridgesPutMultipartOptions the {@link CartridgesPutMultipartOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link DeployCartridgeResponse}
   */
  public ServiceCall<DeployCartridgeResponse> cartridgesPutMultipart(CartridgesPutMultipartOptions cartridgesPutMultipartOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(cartridgesPutMultipartOptions,
      "cartridgesPutMultipartOptions cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.isTrue((cartridgesPutMultipartOptions.archiveFile() != null), "At least one of  or archiveFile must be supplied.");
    String[] pathSegments = { "v1/cartridges" };
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("annotator_for_clinical_data_acd", "v1", "cartridgesPutMultipart");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", this.version);
    MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
    multipartBuilder.setType(MultipartBody.FORM);
    if (cartridgesPutMultipartOptions.archiveFile() != null) {
      okhttp3.RequestBody archiveFileBody = RequestUtils.inputStreamBody(cartridgesPutMultipartOptions.archiveFile(), cartridgesPutMultipartOptions.archiveFileContentType());
      multipartBuilder.addFormDataPart("archive_file", "filename", archiveFileBody);
    }
    builder.body(multipartBuilder.build());
    ResponseConverter<DeployCartridgeResponse> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<DeployCartridgeResponse>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create a cartridge deployment.
   *
   * Update a cartridge deployment from a cartridge archive file.
   *
   * @return a {@link ServiceCall} with a result of type {@link DeployCartridgeResponse}
   */
  public ServiceCall<DeployCartridgeResponse> cartridgesPutMultipart() {
    return cartridgesPutMultipart(null);
  }

  /**
   * Get details of a specific deployment.
   *
   * Using the specified Catridge ID, retrieves the deployment status.
   *
   * @param cartridgesGetIdOptions the {@link CartridgesGetIdOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link AcdCartridges}
   */
  public ServiceCall<AcdCartridges> cartridgesGetId(CartridgesGetIdOptions cartridgesGetIdOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(cartridgesGetIdOptions,
      "cartridgesGetIdOptions cannot be null");
    String[] pathSegments = { "v1/cartridges" };
    String[] pathParameters = { cartridgesGetIdOptions.id() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("annotator_for_clinical_data_acd", "v1", "cartridgesGetId");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", this.version);
    ResponseConverter<AcdCartridges> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<AcdCartridges>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Deploy a cartridge.
   *
   * Deploy a cartridge from a cartridge archive file.
   *
   * @param deployCartridgeOptions the {@link DeployCartridgeOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link DeployCartridgeResponse}
   */
  public ServiceCall<DeployCartridgeResponse> deployCartridge(DeployCartridgeOptions deployCartridgeOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deployCartridgeOptions,
      "deployCartridgeOptions cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.isTrue((deployCartridgeOptions.archiveFile() != null), "At least one of  or archiveFile must be supplied.");
    String[] pathSegments = { "v1/deploy" };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("annotator_for_clinical_data_acd", "v1", "deployCartridge");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", this.version);
    if (deployCartridgeOptions.update() != null) {
      builder.query("update", String.valueOf(deployCartridgeOptions.update()));
    }
    MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
    multipartBuilder.setType(MultipartBody.FORM);
    if (deployCartridgeOptions.archiveFile() != null) {
      okhttp3.RequestBody archiveFileBody = RequestUtils.inputStreamBody(deployCartridgeOptions.archiveFile(), deployCartridgeOptions.archiveFileContentType());
      multipartBuilder.addFormDataPart("archive_file", "filename", archiveFileBody);
    }
    builder.body(multipartBuilder.build());
    ResponseConverter<DeployCartridgeResponse> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<DeployCartridgeResponse>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Deploy a cartridge.
   *
   * Deploy a cartridge from a cartridge archive file.
   *
   * @return a {@link ServiceCall} with a result of type {@link DeployCartridgeResponse}
   */
  public ServiceCall<DeployCartridgeResponse> deployCartridge() {
    return deployCartridge(null);
  }

  /**
   * Determine if service is running correctly.
   *
   * This resource differs from /status in that it will will always return a 500 error if the service state is not OK.
   * This makes it simpler for service front ends (such as Datapower) to detect a failed service.
   *
   * @param getHealthCheckStatusOptions the {@link GetHealthCheckStatusOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ServiceStatus}
   */
  public ServiceCall<ServiceStatus> getHealthCheckStatus(GetHealthCheckStatusOptions getHealthCheckStatusOptions) {
    String[] pathSegments = { "v1/status/health_check" };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("annotator_for_clinical_data_acd", "v1", "getHealthCheckStatus");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    if (getHealthCheckStatusOptions != null) {
      if (getHealthCheckStatusOptions.accept() != null) {
        builder.header("Accept", getHealthCheckStatusOptions.accept());
      }
      if (getHealthCheckStatusOptions.format() != null) {
        builder.query("format", getHealthCheckStatusOptions.format());
      }
    }
    ResponseConverter<ServiceStatus> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ServiceStatus>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Determine if service is running correctly.
   *
   * This resource differs from /status in that it will will always return a 500 error if the service state is not OK.
   * This makes it simpler for service front ends (such as Datapower) to detect a failed service.
   *
   * @return a {@link ServiceCall} with a result of type {@link ServiceStatus}
   */
  public ServiceCall<ServiceStatus> getHealthCheckStatus() {
    return getHealthCheckStatus(null);
  }

}
