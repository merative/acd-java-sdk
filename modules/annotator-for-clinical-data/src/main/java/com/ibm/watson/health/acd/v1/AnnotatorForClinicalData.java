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
package com.ibm.watson.health.acd.v1;

import java.util.Map;
import java.util.Map.Entry;

import com.google.gson.JsonObject;
import com.ibm.cloud.sdk.core.http.HttpConfigOptions;
import com.ibm.cloud.sdk.core.http.HttpHeaders;
import com.ibm.cloud.sdk.core.http.HttpMediaType;
import com.ibm.cloud.sdk.core.http.RequestBuilder;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.cloud.sdk.core.security.NoAuthAuthenticator;
import com.ibm.cloud.sdk.core.service.BaseService;
import com.ibm.cloud.sdk.core.util.GsonSingleton;
import com.ibm.cloud.sdk.core.util.ResponseConverterUtils;
import com.ibm.cloud.sdk.core.util.Validator;
import com.ibm.cloud.whcs.common.SdkCommon;
import com.ibm.watson.health.acd.v1.model.AcdFlow;
import com.ibm.watson.health.acd.v1.model.AcdProfile;
import com.ibm.watson.health.acd.v1.model.AnalyzeOptions;
import com.ibm.watson.health.acd.v1.model.AnalyzeWithFlowOptions;
import com.ibm.watson.health.acd.v1.model.Annotator;
import com.ibm.watson.health.acd.v1.model.AnnotatorFlow;
import com.ibm.watson.health.acd.v1.model.ContainerGroup;
import com.ibm.watson.health.acd.v1.model.Flow;
import com.ibm.watson.health.acd.v1.model.GetAnnotatorOptions;
import com.ibm.watson.health.acd.v1.model.GetFlowOptions;
import com.ibm.watson.health.acd.v1.model.GetFlowsOptions;
import com.ibm.watson.health.acd.v1.model.GetHealthCheckOptions;
import com.ibm.watson.health.acd.v1.model.GetProfileOptions;
import com.ibm.watson.health.acd.v1.model.GetProfilesOptions;
import com.ibm.watson.health.acd.v1.model.ListAnnotatorsOptions;
import com.ibm.watson.health.acd.v1.model.ListStringWrapper;
import com.ibm.watson.health.acd.v1.model.RequestContainer;
import com.ibm.watson.health.acd.v1.model.UnstructuredContainer;

/**
 * Natural Language Processing (NLP) service featuring a set of medical domain
 * annotators for use in deriving entities and medical concepts from
 * unstructured data. Multiple annotators may be invoked from a single request.
 *
 * @version v1
 */
public class AnnotatorForClinicalData extends BaseService {

    private static final String SERVICE_NAME = "annotator_for_clinical_data";
    private static final String RETURN_ANALYZED_TEXT = "return_analyzed_text";
    private static final String VERSION = "version";

    private static String versionDate = null;
    private static String url = null;

    /**
     * Public method to instantiate a new `AnnotatorForClinicalData`. See
     * AnnotatorForClinicalData.Builder public methods to construct an
     * AnnotatorForClinicalData object with ApimCredentials and HttpClientOptions
     *
     * @param versionDate       The version date (yyyy-MM-dd ) of the REST API to
     *                          use. Specifying this value will keep your API calls
     *                          from failing when the service introduces breaking
     *                          changes.
     * @param httpConfigOptions Customization of the HTTP Client If null = no HTTP
     *                          client customization
     * @param auth              Authenticator to use for accessing environment
     * @param url               The ACD endpoint URL
     */
    public AnnotatorForClinicalData(final String versionDate, final HttpConfigOptions httpConfigOptions,
            final Authenticator auth, final String url) {
        super(SERVICE_NAME, auth);
        Validator.isTrue((versionDate != null) && !versionDate.isEmpty(), "version cannot be null.");
        Validator.isTrue((url != null) && !url.isEmpty(), "url cannot be null.");
        Validator.notNull(httpConfigOptions, "options cannot be null");

        this.configureClient(httpConfigOptions);
        this.setServiceUrl(url);
        AnnotatorForClinicalData.versionDate = versionDate;
        AnnotatorForClinicalData.url = url;
    }

    public AnnotatorForClinicalData(final String versionDate, final HttpConfigOptions httpConfigOptions,
            final String apikey, final String url) {
        super(SERVICE_NAME, new IamAuthenticator(apikey));
        Validator.isTrue((versionDate != null) && !versionDate.isEmpty(), "version cannot be null.");
        Validator.isTrue((url != null) && !url.isEmpty(), "url cannot be null.");
        Validator.notNull(httpConfigOptions, "options cannot be null");

        this.configureClient(httpConfigOptions);
        this.setServiceUrl(url);
        AnnotatorForClinicalData.versionDate = versionDate;
        AnnotatorForClinicalData.url = url;
    }

    public AnnotatorForClinicalData(final String versionDate, final HttpConfigOptions httpConfigOptions,
            final String apikey, final String iamUrl, final String url) {
        super(SERVICE_NAME, new IamAuthenticator(apikey, iamUrl, null, null, false, null));
        Validator.isTrue((versionDate != null) && !versionDate.isEmpty(), "version cannot be null.");
        Validator.isTrue((url != null) && !url.isEmpty(), "url cannot be null.");
        Validator.notNull(httpConfigOptions, "options cannot be null");

        this.configureClient(httpConfigOptions);
        this.setServiceUrl(url);
        AnnotatorForClinicalData.versionDate = versionDate;
        AnnotatorForClinicalData.url = url;
    }

    /**
     * Instantiates a new `AnnotatorForClinicalData`.
     *
     * @param versionDate The version date (yyyy-MM-dd ) of the REST API to use.
     *                    Specifying this value will keep your API calls from
     *                    failing when the service introduces breaking changes.
     * @param url         The ACD endpoint URL
     */
    public AnnotatorForClinicalData(final String versionDate, final String url) {
        super(SERVICE_NAME, new NoAuthAuthenticator());
        Validator.isTrue((versionDate != null) && !versionDate.isEmpty(), "version cannot be null.");
        Validator.isTrue((url != null) && !url.isEmpty(), "url cannot be null.");
        this.setServiceUrl(url);
        AnnotatorForClinicalData.versionDate = versionDate;
        AnnotatorForClinicalData.url = url;
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
        builder.query(VERSION, versionDate);
        builder.query(RETURN_ANALYZED_TEXT, String.valueOf(analyzeOptions.returnAnalyzedText()));
        Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders(SERVICE_NAME, "v1", "analyze");
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
        Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders(SERVICE_NAME, "v1", "analyzeWithFlow");
        for (Entry<String, String> header : sdkHeaders.entrySet()) {
            builder.header(header.getKey(), header.getValue());
        }
        builder.query(VERSION, versionDate);
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
     * Get details of a specific annotator.
     *
     * Get details of an annotator that can be used to derive information from
     * unstructured data.
     *
     * @param getAnnotatorOptions the {@link GetAnnotatorOptions} containing the
     *                            options for the call
     * @return the {@link Annotator} with the response
     */
    public ServiceCall<Annotator> getAnnotator(final GetAnnotatorOptions getAnnotatorOptions) {
        Validator.notNull(getAnnotatorOptions, "getAnnotatorOptions cannot be null");
        String[] pathSegments = { "v1/annotators" };
        String[] pathParameters = { getAnnotatorOptions.id() };
        RequestBuilder builder = RequestBuilder
                .get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
        builder.query(VERSION, versionDate);
        Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders(SERVICE_NAME, "v1", "getAnnotator");
        for (Entry<String, String> header : sdkHeaders.entrySet()) {
            builder.header(header.getKey(), header.getValue());
        }
        return createServiceCall(builder.build(), ResponseConverterUtils.getObject(Annotator.class));
    }

    /**
     * Get list of available annotators.
     *
     * Get list of available annotators that can be leveraged to derive information
     * from unstructured data. One or more annnotators can be leveraged within a
     * single request to the service.
     *
     * @param listAnnotatorsOptions the {@link ListAnnotatorsOptions} containing the
     *                              options for the call
     * @return the service call
     */
    public ServiceCall<String> listAnnotators(final ListAnnotatorsOptions listAnnotatorsOptions) {
        String[] pathSegments = { "v1/annotators" };
        RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
        builder.query(VERSION, versionDate);
        Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders(SERVICE_NAME, "v1", "listAnnotators");
        for (Entry<String, String> header : sdkHeaders.entrySet()) {
            builder.header(header.getKey(), header.getValue());
        }
        if (listAnnotatorsOptions != null) {
        }
        return createServiceCall(builder.build(), ResponseConverterUtils.getString());
    }

    /**
     * Get details of a specific flow.
     *
     * Using the specified Flow ID, retrieves the flow definition.
     *
     * @param getFlowOptions the {@link GetFlowOptions} containing the options for
     *                       the call
     * @return the {@link AcdFlow} with the response
     */
    public ServiceCall<AcdFlow> getFlow(final GetFlowOptions getFlowOptions) {
        Validator.notNull(getFlowOptions, "getFlowOptions cannot be null");
        String[] pathSegments = { "v1/flows" };
        String[] pathParameters = { getFlowOptions.id() };
        RequestBuilder builder = RequestBuilder
                .get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
        builder.query(VERSION, versionDate);
        Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders(SERVICE_NAME, "v1", "getFlow");
        for (Entry<String, String> header : sdkHeaders.entrySet()) {
            builder.header(header.getKey(), header.getValue());
        }
        return createServiceCall(builder.build(), ResponseConverterUtils.getObject(AcdFlow.class));
    }

    /**
     * Get list of available persisted flows.
     *
     * Returns a summary including ID and description of the available persisted
     * flows.
     *
     * @param getFlowsOptions the {@link GetFlowsOptions} containing the options for
     *                        the call
     * @return the {@link ListStringWrapper} with the response
     */
    public ServiceCall<String> getFlows(final GetFlowsOptions getFlowsOptions) {
        String[] pathSegments = { "v1/flows" };
        RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
        builder.query(VERSION, versionDate);
        Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders(SERVICE_NAME, "v1", "getflowOptions");
        for (Entry<String, String> header : sdkHeaders.entrySet()) {
            builder.header(header.getKey(), header.getValue());
        }
        if (getFlowsOptions != null) {
        }
        return createServiceCall(builder.build(), ResponseConverterUtils.getString());
    }

    /**
     * Get details of a specific profile.
     *
     * Using the specified profile ID, retrieves the profile definition.
     *
     * @param getProfileOptions the {@link GetProfileOptions} containing the options
     *                          for the call
     * @return the {@link AcdProfile} with the response
     */
    public ServiceCall<AcdProfile> getProfile(final GetProfileOptions getProfileOptions) {
        Validator.notNull(getProfileOptions, "getProfileOptions cannot be null");
        String[] pathSegments = { "v1/profiles" };
        String[] pathParameters = { getProfileOptions.id() };
        RequestBuilder builder = RequestBuilder
                .get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
        builder.query(VERSION, versionDate);
        Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders(SERVICE_NAME, "v1", "getProfile");
        for (Entry<String, String> header : sdkHeaders.entrySet()) {
            builder.header(header.getKey(), header.getValue());
        }
        return createServiceCall(builder.build(), ResponseConverterUtils.getObject(AcdProfile.class));
    }

    /**
     * Get list of available persisted profiles.
     *
     * Returns a summary including ID and description of the available persisted
     * profiles.
     *
     * @param getProfilesOptions the {@link GetProfilesOptions} containing the
     *                           options for the call
     * @return the {@link ListStringWrapper} with the response
     */
    public ServiceCall<String> getProfiles(final GetProfilesOptions getProfilesOptions) {
        String[] pathSegments = { "v1/profiles" };
        RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
        builder.query(VERSION, versionDate);
        Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders(SERVICE_NAME, "v1", "getProfiles");
        for (Entry<String, String> header : sdkHeaders.entrySet()) {
            builder.header(header.getKey(), header.getValue());
        }
        if (getProfilesOptions != null) {
        }
        return createServiceCall(builder.build(), ResponseConverterUtils.getString());
    }

    /**
     * Get health check of ACD instance.
     *
     * Returns OK (HTTP 200) if service running ok; else 500
     *
     * @param getHealthCheckOptions the {@link GetHealthCheckOptions} containing the options for the call
     * @return the {@link ListStringWrapper} with the response
     */
    public ServiceCall<String> getHealthCheck(final GetHealthCheckOptions getHealthCheckOptions) {
        String[] pathSegments = { "v1/status/health_check" };
        RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
        builder.query(VERSION, versionDate);
        Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders(SERVICE_NAME, "v1", "getHealthCheck");
        for (Entry<String, String> header : sdkHeaders.entrySet()) {
            builder.header(header.getKey(), header.getValue());
        }
        // Override the default 'Accept: application/json' for this API
        builder.header(HttpHeaders.ACCEPT, HttpMediaType.WILDCARD);

        if (getHealthCheckOptions != null) {
        }
        return createServiceCall(builder.build(), ResponseConverterUtils.getString());
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
     * Method to get an annotator description.
     *
     * @param annotator name of an existing annotator
     *
     * @return the {@link Annotator} annotator description
     */

    public Annotator getAnnotator(final String annotator) {
        GetAnnotatorOptions getAnnotatorOptions = new GetAnnotatorOptions.Builder().id(annotator).build();

        return this.getAnnotator(getAnnotatorOptions).execute().getResult();
    }

    /**
     * Method to get an annotator description.
     *
     * @param annotator  name of an existing annotator
     *
     * @return the response with result representing {@link Annotator}
     */

    public Response<Annotator> getAnnotatorInclResponseDetails(final String annotator) {
        GetAnnotatorOptions getAnnotatorOptions = new GetAnnotatorOptions.Builder().id(annotator).build();

        return this.getAnnotator(getAnnotatorOptions).execute();
    }

    /**
     * Method to get a list of existing annotators.
     *
     * @return the list of existing annotators
     */
    public String listAnnotators() {
        ListAnnotatorsOptions listAnnotatorsOptions = new ListAnnotatorsOptions.Builder().build();

        return this.listAnnotators(listAnnotatorsOptions).execute().getResult();
    }

    /**
     * Method to get a list of existing annotators.
     *
     * @return the reponse with result listing existing annotators
     */
    public Response<String> listAnnotatorsInclResponseDetails() {
        ListAnnotatorsOptions listAnnotatorsOptions = new ListAnnotatorsOptions.Builder().build();

        return this.listAnnotators(listAnnotatorsOptions).execute();
    }

    /**
     * Method to get an existing flow definition.
     *
     * @param id identifier of existing analytic flow that can be applied to text
     *
     * @return the {@link AcdFlow} flow definition
     */
    public AcdFlow getFlow(final String id) {
        GetFlowOptions getFlowOptions = new GetFlowOptions.Builder().id(id).build();

        return this.getFlow(getFlowOptions).execute().getResult();
    }

    /**
     * Method to get an existing flow definition.
     *
     * @param id identifier of existing analytic flow that can be applied to text
     *
     * @return the resposne with result representing {@link AcdFlow}
     */
    public Response<AcdFlow> getFlowInclResponseDetails(final String id) {
        GetFlowOptions getFlowOptions = new GetFlowOptions.Builder().id(id).build();

        return this.getFlow(getFlowOptions).execute();
    }

    /**
     * Method to get list of existing flows.
     *
     * @return list of existing flows
     */
    public String getFlows() {
        GetFlowsOptions getFlowsOptions = new GetFlowsOptions.Builder().build();

        return this.getFlows(getFlowsOptions).execute().getResult();
    }

    /**
     * Method to get list of existing flows.
     *
     * @return reponse with result containing list of existing flows
     */
    public Response<String> getFlowsInclResponseDetails() {
        GetFlowsOptions getFlowsOptions = new GetFlowsOptions.Builder().build();

        return this.getFlows(getFlowsOptions).execute();
    }

    /**
     * Method to get an existing profile definition.
     *
     * @param id identifier of existing analytic profile with one or flows
     *
     * @return the {@link AcdProfile} profile definition
     */
    public AcdProfile getProfile(final String id) {
        GetProfileOptions getProfileOptions = new GetProfileOptions.Builder().id(id).build();

        return this.getProfile(getProfileOptions).execute().getResult();
    }

    /**
     * Method to get an existing profile defintion.
     *
     * @param id identifier of existing analytic profile with one or flows
     *
     * @return the response with resuilt representing {@link AcdProfile}
     */
    public Response<AcdProfile> getProfileInclResponseDetails(final String id) {
        GetProfileOptions getProfileOptions = new GetProfileOptions.Builder().id(id).build();

        return this.getProfile(getProfileOptions).execute();
    }

    /**
     * Method to get a list of existing profiles.
     *
     * @return list of existing profiles
     */
    public String getProfiles() {
        GetProfilesOptions getProfilesOptions = new GetProfilesOptions.Builder().build();

        return this.getProfiles(getProfilesOptions).execute().getResult();
    }

    /**
     * Method to get a list of existing profiles.
     *
     * @return the response with result containing list of existing profiles
     */
    public Response<String> getProfilesInclResponseDetails() {
        GetProfilesOptions getProfilesOptions = new GetProfilesOptions.Builder().build();

        return this.getProfiles(getProfilesOptions).execute();
    }

    /**
     * Method to get the current service state.
     *
     * @return the service state
     */
    public String getHealthCheck() {
        GetHealthCheckOptions getHealthCheckOptions = new GetHealthCheckOptions.Builder().build();

        return this.getHealthCheck(getHealthCheckOptions).execute().getResult();
    }

    /**
     * Method to get teh current service state.
     *
     * @return resposne with result containing the service state
     */
    public Response<String> getHealthCheckInclResponseDetails() {
        GetHealthCheckOptions getHealthCheckOptions = new GetHealthCheckOptions.Builder().build();

        return this.getHealthCheck(getHealthCheckOptions).execute();
    }

    /**
     * Check for Watson Service credentials.
     *
     * @param parm url param
     * @return credential or date string
     */
    private static String checkVersionDateParm(final String parm) {
        return (parm.equals("username") ? versionDate : parm);
    }

    /**
     * Check for Watson Service credential.
     *
     * @param parm url param
     * @return credential or url
     */
    private static String checkUrlParm(final String parm) {
        return (parm.equals("password") ? url : parm);
    }

    /**
     * Builder.
     */
    public static final class Builder {

        private String versionDate = null;
        private HttpConfigOptions httpConfigOptions;
        private String iamUrl = null;
        private String url = null;
        private String apikey = null;

        /**
         * Constructor.
         */
        public Builder() {
        }

        /**
         * Builder versionDate method to configure the ACD REST APIs version of the
         * client.
         *
         * @param val version date string as YYYY-MM-DD
         * @return builder object with the version date
         */
        public Builder versionDate(final String val) {
            versionDate = val;
            return this;
        }

        /**
         * Builder http config options method to configure HTTP settings of the client.
         *
         * @param options HTTP client configuration
         * @return builder object with the http config options
         */
        public Builder httpConfigOptions(final HttpConfigOptions options) {
            httpConfigOptions = options;
            return this;
        }

        /**
         * Builder url method to configure the URL of the IBM Identity and Access Manager.
         *
         * @param val URL for the Indentity and Access Manager instance
         * @return builder object with the IAM url
         */
        public Builder iamUrl(final String val) {
            iamUrl = val;
            return this;
        }

        /**
         * Builder url method to configure the URL of the client.
         *
         * @param val URL for the service instance
         * @return builder object with the service instance url
         */
        public Builder url(final String val) {
            url = val;
            return this;
        }

        /**
         * Builder apikey method to configure the authentication for IAM.
         *
         * @param val the apikey for the service instance
         * @return builder object with the apikey
         */
        public Builder apikey(final String val) {
            apikey = val;
            return this;
        }

        /**
         * Builder build method to create the client based on configuration settings.
         *
         * @return service instance
         */
        public AnnotatorForClinicalData build() {
            if (apikey == null) {
                return new AnnotatorForClinicalData(versionDate, url);
            } else {
                if (iamUrl == null) {
                    return new AnnotatorForClinicalData(versionDate, httpConfigOptions, apikey, url);
                } else {
                    return new AnnotatorForClinicalData(versionDate, httpConfigOptions, apikey, iamUrl, url);
                }
            }
        }

    }

}
