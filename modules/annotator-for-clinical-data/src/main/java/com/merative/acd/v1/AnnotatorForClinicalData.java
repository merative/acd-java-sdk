/* ***************************************************************** */
/*                                                                   */
/* (C) Copyright Merative US L.P. and others 2018, 2023              */
/*                                                                   */
/* SPDX-License-Identifier: Apache-2.0                               */
/*                                                                   */
/* ***************************************************************** */

package com.merative.acd.v1;

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
import com.merative.common.SdkCommon;
import com.merative.acd.v1.model.AcdCartridges;
import com.merative.acd.v1.model.AcdCartridgesList;
import com.merative.acd.v1.model.AcdFlow;
import com.merative.acd.v1.model.AcdProfile;
import com.merative.acd.v1.model.AnalyzeOptions;
import com.merative.acd.v1.model.AnalyzeWithFlowOptions;
import com.merative.acd.v1.model.AnnotatorFlow;
import com.merative.acd.v1.model.CartridgesGetIdOptions;
import com.merative.acd.v1.model.CartridgesGetOptions;
import com.merative.acd.v1.model.CartridgesPostMultipartOptions;
import com.merative.acd.v1.model.CartridgesPutMultipartOptions;
import com.merative.acd.v1.model.ContainerGroup;
import com.merative.acd.v1.model.CreateFlowsOptions;
import com.merative.acd.v1.model.CreateProfileOptions;
import com.merative.acd.v1.model.DeleteFlowsOptions;
import com.merative.acd.v1.model.DeleteProfileOptions;
import com.merative.acd.v1.model.DeleteUserSpecificArtifactsOptions;
import com.merative.acd.v1.model.DeployCartridgeResponse;
import com.merative.acd.v1.model.Flow;
import com.merative.acd.v1.model.GetAnnotatorsByIdOptions;
import com.merative.acd.v1.model.GetAnnotatorsOptions;
import com.merative.acd.v1.model.GetFlowsByIdOptions;
import com.merative.acd.v1.model.GetFlowsOptions;
import com.merative.acd.v1.model.GetHealthCheckStatusOptions;
import com.merative.acd.v1.model.GetProfileOptions;
import com.merative.acd.v1.model.GetProfilesOptions;
import com.merative.acd.v1.model.RequestContainer;
import com.merative.acd.v1.model.ServiceApiBean;
import com.merative.acd.v1.model.ServiceStatus;
import com.merative.acd.v1.model.UnstructuredContainer;
import com.merative.acd.v1.model.UpdateFlowsOptions;
import com.merative.acd.v1.model.UpdateProfileOptions;

import okhttp3.MultipartBody;

/**
 * Natural Language Processing (NLP) service featuring a set of medical domain annotators for use in detecting entities
 * and medical concepts from unstructured data. Multiple annotators may be invoked from a single request.
 *
 * @version v1
 */
public class AnnotatorForClinicalData extends BaseService {

  public static final String DEFAULT_SERVICE_NAME = "annotator_for_clinical_data_acd";

  public static final String DEFAULT_SERVICE_URL = "https://annotator-for-clinical-data-acd.com/services/clinical_data_annotator/api";

  public static final String RETURN_ANALYZED_TEXT = "return_analyzed_text";

  public static final String VERSION = "version";

  public static final String DEBUG = "debug";

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
   * @return a {@link ServiceCall} with a result of type {@link Map}&lt;String, {@link AcdProfile}&gt;
   */
  public ServiceCall<Map<String, AcdProfile>> getProfiles(GetProfilesOptions getProfilesOptions) {
	  String[] pathSegments = { "v1/profiles" };
	  RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
	  Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("annotator_for_clinical_data_acd", "v1", "getProfiles");
	  for (Entry<String, String> header : sdkHeaders.entrySet()) {
		  builder.header(header.getKey(), header.getValue());
	  }
	  builder.header("Accept", "application/json");
	  builder.query("version", this.version);
	  ResponseConverter<Map<String, AcdProfile>> responseConverter =
			  ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Map<String, AcdProfile>>() { }.getType());
	  return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get list of available persisted profiles.
   *
   * Returns a summary including ID and description of the available persisted profiles.
   *
   * @return a {@link ServiceCall} with a result of type {@link Map}&lt;String, {@link AcdProfile}&gt;
   */
  public ServiceCall<Map<String, AcdProfile>> getProfiles() {
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
   * field from the profile definition.
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
   * field from the profile definition.
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
   * @return a {@link ServiceCall} with a result of type {@link Map}&lt;String, {@link AcdFlow}&gt;
   */
  public ServiceCall<Map<String, AcdFlow>> getFlows(GetFlowsOptions getFlowsOptions) {
    String[] pathSegments = { "v1/flows" };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("annotator_for_clinical_data_acd", "v1", "getFlows");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", this.version);
    ResponseConverter<Map<String, AcdFlow>> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Map<String, AcdFlow>>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get list of available persisted flows.
   *
   * Returns a summary including ID and description of the available persisted flows.
   *
   * @return a {@link ServiceCall} with a result of type {@link Map}&lt;String, {@link AcdFlow}&gt;
   */
  public ServiceCall<Map<String, AcdFlow>> getFlows() {
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
   * the "name" field from the flow definition.
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
   * the "name" field from the flow definition.
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
   * Detect entities and relations from unstructured data.
   *
   * This API accepts a JSON request model featuring both the unstructured data to
   * be analyzed as well as the desired annotator flow.
   *
   * @param analyzeOptions the {@link AnalyzeOptions} containing the options for
   *                        the call
   * @return a {@link ServiceCall} with a result of type {@link ContainerGroup}
   */
  public ServiceCall<ContainerGroup> analyze(final AnalyzeOptions analyzeOptions) {
	  Validator.notNull(analyzeOptions, "analyzeOptions cannot be null");
	  String[] pathSegments = { "v1/analyze" };
	  RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
	  builder.query(VERSION, version);
	  builder.query(RETURN_ANALYZED_TEXT, String.valueOf(analyzeOptions.returnAnalyzedText()));
	  builder.query(DEBUG, String.valueOf(analyzeOptions.debug()));
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
   * Detect entities and relations from unstructured data using a persisted flow.
   *
   * This API accepts a flow identifier as well as a TEXT or a JSON request model
   * featuring the unstructured text to be analyzed. JSON request model with
   * unstructured text
   *
   * @param analyzeWithFlowOptions the {@link AnalyzeWithFlowOptions} containing
   *                               the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ContainerGroup}
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
      builder.query(DEBUG, String.valueOf(analyzeWithFlowOptions.debug()));
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
   * Method to analyze text with a provided annotator flow definition.
   *
   * @param text data to be analyzed
   * @param flow {@link Flow} analytics to apply to the text
   *
   * @return the {@link ContainerGroup} discovered cognitive entities
   */
  public ContainerGroup analyze(final String text, final Flow flow) {
	  AnnotatorFlow annotatorFlow = new AnnotatorFlow.Builder().flow(flow).build();
	  UnstructuredContainer unstructuredContainer = new UnstructuredContainer.Builder().text(text).build();
	  AnalyzeOptions options = new AnalyzeOptions.Builder().addUnstructured(unstructuredContainer)
			  .returnAnalyzedText(false).debug(false).addAnnotatorFlows(annotatorFlow).build();

	  return this.analyze(options).execute().getResult();
  }

  /**
   * Method to analyze text using a provided annotator flow definition.
   *
   * @param text data to be analyzed
   * @param flow {@link Flow} annotator flow definition
   *
   * @return the {@link Response} with a result of type {@link ContainerGroup}
   */
  public Response<ContainerGroup> analyzeInclResponseDetails(final String text, final Flow flow) {
      AnnotatorFlow annotatorFlow = new AnnotatorFlow.Builder().flow(flow).build();
      UnstructuredContainer unstructuredContainer = new UnstructuredContainer.Builder().text(text).build();
      AnalyzeOptions options = new AnalyzeOptions.Builder().addUnstructured(unstructuredContainer)
              .returnAnalyzedText(false).debug(false).addAnnotatorFlows(annotatorFlow).build();

      return this.analyze(options).execute();
  }

  /**
   * Method to analyze text using a provided annotator flow definition.
   *
   * @param text data to be analyzed
   * @param flow {@link Flow} annotator flow definition
   * @param returnAnalyzedText if true, analyzed text is included in response
   *
   * @return the {@link ContainerGroup}
   */
  public ContainerGroup analyze(final String text, final Flow flow, final boolean returnAnalyzedText) {
      AnnotatorFlow annotatorFlow = new AnnotatorFlow.Builder().flow(flow).build();
      UnstructuredContainer unstructuredContainer = new UnstructuredContainer.Builder().text(text).build();
      AnalyzeOptions options = new AnalyzeOptions.Builder().addUnstructured(unstructuredContainer)
              .returnAnalyzedText(returnAnalyzedText).debug(false).addAnnotatorFlows(annotatorFlow).build();

      return this.analyze(options).execute().getResult();
  }

  /**
   * Method to analyze text using a provided annotator flow definition.
   *
   * @param text data to be analyzed
   * @param flow {@link Flow} annotator flow definition
   * @param returnAnalyzedText if true, analyzed text is included in response
   *
   * @return the {@link Response} with a result of type {@link ContainerGroup}
   */
  public Response<ContainerGroup> analyzeInclResponseDetails(final String text, final Flow flow,
          final boolean returnAnalyzedText) {
      AnnotatorFlow annotatorFlow = new AnnotatorFlow.Builder().flow(flow).build();
      UnstructuredContainer unstructuredContainer = new UnstructuredContainer.Builder().text(text).build();
      AnalyzeOptions options = new AnalyzeOptions.Builder().addUnstructured(unstructuredContainer)
              .returnAnalyzedText(returnAnalyzedText).debug(false).addAnnotatorFlows(annotatorFlow).build();

      return this.analyze(options).execute();
  }

  /**
   * Method to analyze text using a provided annotator flow definition.
   *
   * @param text data to be analyzed
   * @param flow {@link Flow} annotator flow definition
   * @param returnAnalyzedText if true, analyzed text is included in response
   * @param debug analyze debug flag
   *
   * @return the {@link Response} with a result of type {@link ContainerGroup}
   */
  public Response<ContainerGroup> analyzeDebug(final String text, final Flow flow,
          final boolean returnAnalyzedText, final boolean debug) {
      AnnotatorFlow annotatorFlow = new AnnotatorFlow.Builder().flow(flow).build();
      UnstructuredContainer unstructuredContainer = new UnstructuredContainer.Builder().text(text).build();
      AnalyzeOptions options = new AnalyzeOptions.Builder().addUnstructured(unstructuredContainer)
              .returnAnalyzedText(returnAnalyzedText).debug(debug).addAnnotatorFlows(annotatorFlow).build();

      return this.analyze(options).execute();
  }

  /**
   * Method to analyze text with a persisted annotator flow.
   *
   * @param flowId identifier of persisted annotator flow to apply to the text
   * @param text data to be analyzed
   *
   * @return the {@link ContainerGroup}
   */
  public ContainerGroup analyzeWithFlow(final String flowId, final String text) {
      AnalyzeWithFlowOptions analyzeWithFlowOptions = new AnalyzeWithFlowOptions.Builder().flowId(flowId).text(text)
              .returnAnalyzedText(false).debug(false).build();

      return this.analyzeWithFlow(analyzeWithFlowOptions).execute().getResult();
  }

  /**
   * Method to analyze text with a persisted annotator flow.
   *
   * @param flowId identifier of persisted annotator flow to apply to the text
   * @param text data to be analyzed
   *
   * @return the {@link Response} with a result of type {@link ContainerGroup}
   */
  public Response<ContainerGroup> analyzeWithFlowInclResponseDetails(final String flowId, final String text) {
      AnalyzeWithFlowOptions analyzeWithFlowOptions = new AnalyzeWithFlowOptions.Builder().flowId(flowId).text(text)
              .returnAnalyzedText(false).debug(false).build();

      return this.analyzeWithFlow(analyzeWithFlowOptions).execute();
  }

  /**
   * Method to analyze text with a persisted annotator flow.
   *
   * @param flowId identifier of persisted annotator flow to apply to the text
   * @param text data to be analyzed
   * @param returnAnalyzedText if true, analyzed text is included in response
   *
   * @return the {@link ContainerGroup}
   */
  public ContainerGroup analyzeWithFlow(final String flowId, final String text, final boolean returnAnalyzedText) {
      AnalyzeWithFlowOptions analyzeWithFlowOptions = new AnalyzeWithFlowOptions.Builder().flowId(flowId).text(text)
              .returnAnalyzedText(returnAnalyzedText).debug(false).build();

      return this.analyzeWithFlow(analyzeWithFlowOptions).execute().getResult();
  }

  /**
   * Method to analyze text with a persisted annotator flow with analyze debug flag enabled.
   *
   * @param flowId identifier of persisted annotator flow to apply to the text
   * @param text data to be analyzed
   * @param returnAnalyzedText if true, analyzed text is included in response
   * @param debug turn on analyze debug flag
   *
   * @return the {@link ContainerGroup}
   */
  public ContainerGroup analyzeWithFlowDebug(final String flowId, final String text, final boolean returnAnalyzedText, final boolean debug) {
      AnalyzeWithFlowOptions analyzeWithFlowOptions = new AnalyzeWithFlowOptions.Builder().flowId(flowId).text(text)
              .returnAnalyzedText(returnAnalyzedText).debug(debug).build();

      return this.analyzeWithFlow(analyzeWithFlowOptions).execute().getResult();
  }

  /**
   * Method to analyze text with a persisted annotator flow.
   *
   * @param flowId identifier of persisted annotator flow to apply to the text
   * @param text data to be analyzed
   * @param returnAnalyzedText if true, analyzed text is included in response
   *
   * @return the {@link Response} with a result of type {@link ContainerGroup}
   */
  public Response<ContainerGroup> analyzeWithFlowInclResponseDetails(final String flowId, final String text,
          final boolean returnAnalyzedText) {
      AnalyzeWithFlowOptions analyzeWithFlowOptions = new AnalyzeWithFlowOptions.Builder().flowId(flowId).text(text)
              .returnAnalyzedText(returnAnalyzedText).debug(false).build();

      return this.analyzeWithFlow(analyzeWithFlowOptions).execute();
  }

  /**
   * Method to analyze text with a persisted annotator flow.
   *
   * @param flowId identifier of persisted annotator flow to apply to the text
   * @param unstructuredContainer {@link UnstructuredContainer} text to analyze and discovered cognitive entities
   *
   * @return the {@link ContainerGroup}
   */
  public ContainerGroup analyzeWithFlow(final String flowId, final UnstructuredContainer unstructuredContainer) {
      RequestContainer requestContainer = new RequestContainer.Builder().addUnstructured(unstructuredContainer)
              .build();

      AnalyzeWithFlowOptions analyzeWithFlowOptions = new AnalyzeWithFlowOptions.Builder().flowId(flowId)
              .returnAnalyzedText(false).debug(false).request(requestContainer).build();

      return this.analyzeWithFlow(analyzeWithFlowOptions).execute().getResult();
  }

  /**
   * Method to analyze text with a persisted annotator flow.
   *
   * @param flowId identifier of persisted annotator flow to apply to the text
   * @param unstructuredContainer {@link UnstructuredContainer} text to analyze and discovered cognitive entities
   * @param returnAnalyzedText if true, analyzed text is included in response
   *
   * @return the {@link ContainerGroup} discovered cognitive entities
   */
  public ContainerGroup analyzeWithFlow(final String flowId, final UnstructuredContainer unstructuredContainer,
          final boolean returnAnalyzedText) {
      RequestContainer requestContainer = new RequestContainer.Builder().addUnstructured(unstructuredContainer)
              .build();

      AnalyzeWithFlowOptions analyzeWithFlowOptions = new AnalyzeWithFlowOptions.Builder().flowId(flowId)
              .returnAnalyzedText(returnAnalyzedText).debug(false).request(requestContainer).build();

      return this.analyzeWithFlow(analyzeWithFlowOptions).execute().getResult();
  }

  /**
   * Method to analyze text with a persisted annotator flow.
   *
   * @param flowId identifier of persisted annotator flow to apply to the text
   * @param unstructuredContainer {@link UnstructuredContainer} text to analyze and discovered cognitive entities
   *
   * @return the {@link Response} with a result of type {@link ContainerGroup}
   */

  public Response<ContainerGroup> analyzeWithFlowInclResponseDetails(final String flowId,
          final UnstructuredContainer unstructuredContainer) {
      RequestContainer requestContainer = new RequestContainer.Builder().addUnstructured(unstructuredContainer)
              .build();

      AnalyzeWithFlowOptions analyzeWithFlowOptions = new AnalyzeWithFlowOptions.Builder().flowId(flowId)
              .returnAnalyzedText(false).debug(false).request(requestContainer).build();

      return this.analyzeWithFlow(analyzeWithFlowOptions).execute();
  }

  /**
   * Method to analyze text with a persisted annotator flow.
   *
   * @param flowId identifier of persisted annotator flow to apply to the text
   * @param unstructuredContainer {@link UnstructuredContainer} text to analyze and discovered cognitive entities
   * @param returnAnalyzedText if true, analyzed text is included in response
   *
   * @return the {@link Response} with a result of type {@link ContainerGroup}
   */
  public Response<ContainerGroup> analyzeWithFlowInclResponseDetails(final String flowId,
          final UnstructuredContainer unstructuredContainer, final boolean returnAnalyzedText) {
      RequestContainer requestContainer = new RequestContainer.Builder().addUnstructured(unstructuredContainer)
              .build();

      AnalyzeWithFlowOptions analyzeWithFlowOptions = new AnalyzeWithFlowOptions.Builder().flowId(flowId)
              .returnAnalyzedText(returnAnalyzedText).debug(false).request(requestContainer).build();

      return this.analyzeWithFlow(analyzeWithFlowOptions).execute();
  }

  /**
   * Method to analyze text with a persisted annotator flow with analyze debug flag enabled.
   *
   * @param flowId identifier of persisted annotator flow to apply to the text
   * @param unstructuredContainer {@link UnstructuredContainer} text to analyze and discovered cognitive entities
   * @param returnAnalyzedText if true, analyzed text is included in response
   * @param debug analyze debug flag enabled
   *
   * @return the {@link Response} with a result of type {@link ContainerGroup}
   */
  public Response<ContainerGroup> analyzeWithFlowDebug(final String flowId,
          final UnstructuredContainer unstructuredContainer, final boolean returnAnalyzedText, final boolean debug) {
      RequestContainer requestContainer = new RequestContainer.Builder().addUnstructured(unstructuredContainer)
              .build();

      AnalyzeWithFlowOptions analyzeWithFlowOptions = new AnalyzeWithFlowOptions.Builder().flowId(flowId)
              .returnAnalyzedText(returnAnalyzedText).debug(debug).request(requestContainer).build();

      return this.analyzeWithFlow(analyzeWithFlowOptions).execute();
  }

  /**
   * Get list of available annotators.
   *
   * Get list of available annotators that can be leveraged to detect information from unstructured data. One or more
   * annotators can be leveraged within a single request to the service.
   *
   * @param getAnnotatorsOptions the {@link GetAnnotatorsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Map}&lt;String, {@link ServiceApiBean}&gt;
   */
  public ServiceCall<Map<String, ServiceApiBean>> getAnnotators(GetAnnotatorsOptions getAnnotatorsOptions) {
	  String[] pathSegments = { "v1/annotators" };
	  RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
	  Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("annotator_for_clinical_data_acd", "v1", "getAnnotators");
	  for (Entry<String, String> header : sdkHeaders.entrySet()) {
		  builder.header(header.getKey(), header.getValue());
	  }
	  builder.query("version", this.version);
	  ResponseConverter<Map<String, ServiceApiBean>> responseConverter =
			  ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Map<String, ServiceApiBean>>() { }.getType());
	  return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get list of available annotators.
   *
   * Get list of available annotators that can be leveraged to detect information from unstructured data. One or more
   * annotators can be leveraged within a single request to the service.
   *
   * @return a {@link ServiceCall} with a result of type {@link Map}&lt;String, {@link ServiceApiBean}&gt;
   */
  public ServiceCall<Map<String, ServiceApiBean>> getAnnotators() {
    return getAnnotators(null);
  }

  /**
   * Get details of a specific annotator.
   *
   * Get details of an annotator that can be used to detect information from unstructured data.
   *
   * @param getAnnotatorsByIdOptions the {@link GetAnnotatorsByIdOptions} containing the options for the call
   * @return a {@link ServiceCall} with a {@link ServiceApiBean} result
   */
  public ServiceCall<ServiceApiBean> getAnnotatorsById(GetAnnotatorsByIdOptions getAnnotatorsByIdOptions) {
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
    ResponseConverter<ServiceApiBean> responseConverter = ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ServiceApiBean>() { }.getType());
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
    builder.query("version", this.version);
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
   * Get list of cartridge deployment statuses.
   *
   * Returns a summary including ID and status of the available deployments.
   *
   * @param cartridgesGetOptions the {@link CartridgesGetOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link AcdCartridgesList}
   */
  public ServiceCall<AcdCartridgesList> cartridgesGet(CartridgesGetOptions cartridgesGetOptions) {
    String[] pathSegments = { "v1/cartridges" };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("annotator_for_clinical_data_acd", "v1", "cartridgesGet");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", this.version);
    ResponseConverter<AcdCartridgesList> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<AcdCartridgesList>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get list of available deployment status.
   *
   * Returns a summary including ID and status of the available deployments.
   *
   * @return a {@link ServiceCall} with a result of type {@link AcdCartridgesList}
   */
  public ServiceCall<AcdCartridgesList> cartridgesGet() {
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
   * Update an existing a cartridge deployment.
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
   * Update an existing cartridge deployment.
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
