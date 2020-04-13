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
package com.ibm.watson.health.iml.v1;

import java.util.Map;
import java.util.Map.Entry;

import com.google.gson.JsonObject;
import com.ibm.cloud.sdk.core.http.HttpConfigOptions;
import com.ibm.cloud.sdk.core.http.RequestBuilder;
import com.ibm.cloud.sdk.core.http.ResponseConverter;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.cloud.sdk.core.security.NoAuthAuthenticator;
import com.ibm.cloud.sdk.core.service.BaseService;
import com.ibm.cloud.sdk.core.util.GsonSingleton;
import com.ibm.cloud.sdk.core.util.RequestUtils;
import com.ibm.cloud.sdk.core.util.ResponseConverterUtils;
import com.ibm.cloud.sdk.core.util.Validator;
import com.ibm.cloud.whcs.common.SdkCommon;
import com.ibm.watson.health.iml.v1.model.AddArtifactOptions;
import com.ibm.watson.health.iml.v1.model.AddCorpusDocumentOptions;
import com.ibm.watson.health.iml.v1.model.AnnotationsModel;
import com.ibm.watson.health.iml.v1.model.CategoriesModel;
import com.ibm.watson.health.iml.v1.model.ConceptInfoModel;
import com.ibm.watson.health.iml.v1.model.ConceptListModel;
import com.ibm.watson.health.iml.v1.model.CorporaConfigModel;
import com.ibm.watson.health.iml.v1.model.CorpusInfoModel;
import com.ibm.watson.health.iml.v1.model.DeleteCorpusSchemaOptions;
import com.ibm.watson.health.iml.v1.model.DocumentTextModel;
import com.ibm.watson.health.iml.v1.model.GetConceptsOptions;
import com.ibm.watson.health.iml.v1.model.GetCorporaConfigOptions;
import com.ibm.watson.health.iml.v1.model.GetCorpusConfigOptions;
import com.ibm.watson.health.iml.v1.model.GetCuiInfoOptions;
import com.ibm.watson.health.iml.v1.model.GetDocumentAnnotationsOptions;
import com.ibm.watson.health.iml.v1.model.GetDocumentCategoriesOptions;
import com.ibm.watson.health.iml.v1.model.GetDocumentInfoOptions;
import com.ibm.watson.health.iml.v1.model.GetDocumentMultipleCategoriesOptions;
import com.ibm.watson.health.iml.v1.model.GetDocumentsOptions;
import com.ibm.watson.health.iml.v1.model.GetFieldsOptions;
import com.ibm.watson.health.iml.v1.model.GetHealthCheckStatusOptions;
import com.ibm.watson.health.iml.v1.model.GetHitCountOptions;
import com.ibm.watson.health.iml.v1.model.GetRelatedConceptsOptions;
import com.ibm.watson.health.iml.v1.model.GetSearchMatchesOptions;
import com.ibm.watson.health.iml.v1.model.GetSimilarConceptsOptions;
import com.ibm.watson.health.iml.v1.model.HitCount;
import com.ibm.watson.health.iml.v1.model.MetadataModel;
import com.ibm.watson.health.iml.v1.model.MonitorCorpusOptions;
import com.ibm.watson.health.iml.v1.model.MultipleCategoriesModel;
import com.ibm.watson.health.iml.v1.model.RelatedConceptsModel;
import com.ibm.watson.health.iml.v1.model.SearchMatchesModel;
import com.ibm.watson.health.iml.v1.model.SearchModel;
import com.ibm.watson.health.iml.v1.model.SearchOptions;
import com.ibm.watson.health.iml.v1.model.ServiceStatus;
import com.ibm.watson.health.iml.v1.model.SetCorpusConfigOptions;
import com.ibm.watson.health.iml.v1.model.SetCorpusSchemaOptions;
import com.ibm.watson.health.iml.v1.model.TypeaheadOptions;
import com.ibm.watson.health.iml.v1.model.UmlsConceptInfoModel;

/**
 * Service for exploring medical corpora than have been annotated using
 * cognitive analytics.
 *
 * @version v1
 */
public class InsightsForMedicalLiteratureService extends BaseService {

  private static final String SERVICE_NAME = "insights_for_medical_literature_service";
  private static final String VERSION = "version";

  private String versionDate;

  /**
   * Instances a new InsightsForMedicalLiteratureService instance for IBM Cloud.
   *
   * @param versionDate The version date (yyyy-MM-dd) of the REST API to use.
   *                    Specifying this value will keep your API calls from
   *                    failing when the service introduces breaking changes.
   * @param apikey      The IBM Access Manager key for the IBM Cloud instance
   *                    being accessed.
   * @param url         The URL for the IBM Cloud instance being accessed.
   */
  public InsightsForMedicalLiteratureService(final String versionDate, final String url) {
    super(SERVICE_NAME, new NoAuthAuthenticator());
    HttpConfigOptions options = new HttpConfigOptions.Builder().disableSslVerification(true).build();
    this.configureClient(options);

    Validator.isTrue((versionDate != null) && !versionDate.isEmpty(), "version cannot be null.");
    Validator.isTrue((url != null) && !url.isEmpty(), "url cannot be null.");

    this.versionDate = versionDate;
    setServiceUrl(url);
  }

  /**
   * Instances a new InsightsForMedicalLiteratureService instance.
   *
   * @param versionDate The version date (yyyy-MM-dd) of the REST API to use.
   *                    Specifying this value will keep your API calls from
   *                    failing when the service introduces breaking changes.
   * @param apikey      The IBM Access Manager key for the IBM Cloud instance
   *                    being accessed.
   * @param url         The URL for the IBM Cloud instance being accessed.
   */
  public InsightsForMedicalLiteratureService(final String versionDate, final String apikey, final String url,
      HttpConfigOptions options) {
    super(SERVICE_NAME, new IamAuthenticator(apikey));

    Validator.isTrue((versionDate != null) && !versionDate.isEmpty(), "version cannot be null.");
    Validator.isTrue((url != null) && !url.isEmpty(), "url cannot be null.");
    Validator.notNull(options, "options cannot be null");

    this.configureClient(options);
    this.versionDate = versionDate;
    setServiceUrl(url);
  }

  /**
   * Instances a new InsightsForMedicalLiteratureService instance.
   *
   * @param versionDate The version date (yyyy-MM-dd) of the REST API to use.
   *                    Specifying this value will keep your API calls from
   *                    failing when the service introduces breaking changes.
   * @param apikey      The IBM Access Manager key for the IBM Cloud instance
   *                    being accessed.
   * @param url         The URL for the IBM Cloud instance being accessed.
   */
  public InsightsForMedicalLiteratureService(final String versionDate, final String apikey, final String iamUrl,
      final String url, final HttpConfigOptions options) {
    super(SERVICE_NAME, new IamAuthenticator(apikey, iamUrl, null, null, false, null));

    Validator.isTrue((versionDate != null) && !versionDate.isEmpty(), "version cannot be null.");
    Validator.isTrue((url != null) && !url.isEmpty(), "url cannot be null.");
    Validator.notNull(options, "options cannot be null");

    this.configureClient(options);
    this.versionDate = versionDate;
    setServiceUrl(url);
  }

  /**
   * Retrieves a list of metadata fields defined in the corpus.
   *
   * The response returns a list of metadata field names that can be used by the
   * POST search API.
   *
   * @param getFieldsOptions the {@link GetFieldsOptions} containing the options
   *                         for the call
   * @return a {@link ServiceCall} with a response type of {@link MetadataModel}
   */
  public ServiceCall<MetadataModel> getFields(final GetFieldsOptions getFieldsOptions) {
    Validator.notNull(getFieldsOptions, "getFieldsOptions cannot be null");
    String[] pathSegments = { "v1/corpora", "search/metadata" };
    String[] pathParameters = { getFieldsOptions.corpus() };

    RequestBuilder builder = RequestBuilder
        .get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders(SERVICE_NAME, "v1", "getFields");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.query(VERSION, versionDate);
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(MetadataModel.class));
  }

  /**
   * Search for concepts, documents, and authors.
   *
   * Method allows the caller to search for literature results,
   *
   * @param searchOptions the {@link SearchOptions} containing the options for the
   *                      call
   * @return a {@link ServiceCall} with a response type of {@link SearchModel}
   */
  public ServiceCall<SearchModel> search(final SearchOptions searchOptions) {
    Validator.notNull(searchOptions, "searchOptions cannot be null");
    String[] pathSegments = { "v1/corpora", "search" };
    String[] pathParameters = { searchOptions.corpus() };
    RequestBuilder builder = RequestBuilder
        .post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders(SERVICE_NAME, "v1", "search");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.query(VERSION, versionDate);
    if (searchOptions.verbose() != null) {
      builder.query("verbose", String.valueOf(searchOptions.verbose()));
    }
    final JsonObject contentJson = new JsonObject();
    if (searchOptions.query() != null) {
      contentJson.add("query", GsonSingleton.getGson().toJsonTree(searchOptions.query()));
    }
    if (searchOptions.returns() != null) {
      contentJson.add("returns", GsonSingleton.getGson().toJsonTree(searchOptions.returns()));
    }
    builder.bodyJson(contentJson);
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(SearchModel.class));
  }

  /**
   * Find concepts matching the specified query string.
   *
   * Searches concepts mentioned in the corpus looking for matches on the query
   * string field. The comparison is not case sensitive. The main use of this
   * method is to build query boxes that offer auto-complete, to allow users to
   * select valid concepts.
   *
   * @param typeaheadOptions the {@link TypeaheadOptions} containing the options
   *                         for the call
   * @return a {@link ServiceCall} with a response type of
   *         {@link ConceptListModel}
   */
  public ServiceCall<ConceptListModel> typeahead(final TypeaheadOptions typeaheadOptions) {
    Validator.notNull(typeaheadOptions, "typeaheadOptions cannot be null");
    String[] pathSegments = { "v1/corpora", "search/typeahead" };
    String[] pathParameters = { typeaheadOptions.corpus() };
    RequestBuilder builder = RequestBuilder
        .get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders(SERVICE_NAME, "v1", "typeahead");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.query(VERSION, versionDate);
    builder.query("query", typeaheadOptions.query());
    if (typeaheadOptions.ontologies() != null) {
      builder.query("ontologies", RequestUtils.join(typeaheadOptions.ontologies(), ","));
    }
    if (typeaheadOptions.types() != null) {
      builder.query("types", RequestUtils.join(typeaheadOptions.types(), ","));
    }
    if (typeaheadOptions.category() != null) {
      builder.query("category", typeaheadOptions.category());
    }
    if (typeaheadOptions.verbose() != null) {
      builder.query("verbose", String.valueOf(typeaheadOptions.verbose()));
    }
    if (typeaheadOptions.limit() != null) {
      builder.query("_limit", String.valueOf(typeaheadOptions.limit()));
    }
    if (typeaheadOptions.maxHitCount() != null) {
      builder.query("max_hit_count", String.valueOf(typeaheadOptions.maxHitCount()));
    }
    if (typeaheadOptions.noDuplicates() != null) {
      builder.query("no_duplicates", String.valueOf(typeaheadOptions.noDuplicates()));
    }
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(ConceptListModel.class));
  }

  /**
   * Retrieves information for concepts mentioned in this corpus.
   *
   * The response returns concepts mentioned in this corpus. The returned concepts
   * may be selected by CUI, preferred name, surface forms and attribute name. All
   * selected concepts are returned.
   *
   * @param getConceptsOptions the {@link GetConceptsOptions} containing the
   *                           options for the call
   * @return a {@link ServiceCall} with a response type of
   *         {@link ConceptListModel}
   */
  public ServiceCall<ConceptListModel> getConcepts(final GetConceptsOptions getConceptsOptions) {
    Validator.notNull(getConceptsOptions, "getConceptsOptions cannot be null");
    String[] pathSegments = { "v1/corpora", "concepts" };
    String[] pathParameters = { getConceptsOptions.corpus() };
    RequestBuilder builder = RequestBuilder
        .get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders(SERVICE_NAME, "v1", "getConcepts");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.query(VERSION, versionDate);
    if (getConceptsOptions.cuis() != null) {
      builder.query("cuis", getConceptsOptions.cuis().toArray());
    }
    if (getConceptsOptions.preferredNames() != null) {
      builder.query("preferred_names", getConceptsOptions.preferredNames().toArray());
    }
    if (getConceptsOptions.surfaceForms() != null) {
      builder.query("surface_forms", getConceptsOptions.surfaceForms().toArray());
    }
    if (getConceptsOptions.attributes() != null) {
      builder.query("attributes", getConceptsOptions.attributes().toArray());
    }
    if (getConceptsOptions.verbose() != null) {
      builder.query("verbose", String.valueOf(getConceptsOptions.verbose()));
    }
    if (getConceptsOptions.sort() != null) {
      builder.query("_sort", getConceptsOptions.sort());
    }
    if (getConceptsOptions.limit() != null) {
      builder.query("_limit", String.valueOf(getConceptsOptions.limit()));
    }
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(ConceptListModel.class));
  }

  /**
   * Add cartridge artifact.
   *
   * This method is only supported for custom plan instances that make use of
   * custom analytics. Each custom analytic artifact should be persisted in the
   * service prior to adding content.
   *
   * @param addArtifactOptions the {@link AddArtifactOptions} containing the
   *                           options for the call
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<Void> addArtifact(final AddArtifactOptions addArtifactOptions) {
    Validator.notNull(addArtifactOptions, "addArtifactOptions cannot be null");
    String[] pathSegments = { "v1/corpora", "concepts/definitions" };
    String[] pathParameters = { addArtifactOptions.corpus() };
    RequestBuilder builder = RequestBuilder
        .post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders(SERVICE_NAME, "v1", "addArtifact");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.query(VERSION, versionDate);

    final JsonObject contentJson = new JsonObject();
    if (addArtifactOptions.dictionaryEntry() != null) {
      contentJson.add("dictionaryEntry", GsonSingleton.getGson().toJsonTree(addArtifactOptions.dictionaryEntry()));
    }
    if (addArtifactOptions.attributeEntry() != null) {
      contentJson.add("attributeEntry", GsonSingleton.getGson().toJsonTree(addArtifactOptions.attributeEntry()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieve information for a concept.
   *
   * The following fields may be retrieved: Preferred name Semantic types Surface
   * forms - Ontology Dictionary names for this concept Variants - Onotogy
   * Metathesaurus names for this concept Typeahead - Names included in the
   * typeahead for this concept Definition - Concept definition (if available) The
   * default is to return all fields. Individual fields may be selected using the
   * '_fields' query parameter.
   *
   * @param getCuiInfoOptions the {@link GetCuiInfoOptions} containing the options
   *                          for the call
   * @return a {@link ServiceCall} with a response type of
   *         {@link UmlsConceptInfoModel}
   */
  public ServiceCall<ConceptInfoModel> getCuiInfo(final GetCuiInfoOptions getCuiInfoOptions) {
    Validator.notNull(getCuiInfoOptions, "getCuiInfoOptions cannot be null");
    String[] pathSegments = { "v1/corpora", "concepts" };
    String[] pathParameters = { getCuiInfoOptions.corpus(), getCuiInfoOptions.cui() };
    RequestBuilder builder = RequestBuilder
        .get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders(SERVICE_NAME, "v1", "getCuiInfo");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.query(VERSION, versionDate);
    if (getCuiInfoOptions.ontology() != null) {
      builder.query("ontology", getCuiInfoOptions.ontology());
    }
    if (getCuiInfoOptions.fields() != null) {
      builder.query("_fields", getCuiInfoOptions.fields());
    }
    if (getCuiInfoOptions.treeLayout() != null) {
      builder.query("tree_layout", String.valueOf(getCuiInfoOptions.treeLayout()));
    }
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(ConceptInfoModel.class));
  }

  /**
   * Retrieves a count of the number of times a concept is mentioned in the
   * corpus.
   *
   * The response returns the number of times a concept is mentioned (hit count)
   * in the corpus.
   *
   * @param getHitCountOptions the {@link GetHitCountOptions} containing the
   *                           options for the call
   * @return a {@link ServiceCall} with a response type of {@link HitCount}
   */
  public ServiceCall<HitCount> getHitCount(final GetHitCountOptions getHitCountOptions) {
    Validator.notNull(getHitCountOptions, "getHitCountOptions cannot be null");
    String[] pathSegments = { "v1/corpora", "concepts", "hit_count" };
    String[] pathParameters = { getHitCountOptions.corpus(), getHitCountOptions.cui() };
    RequestBuilder builder = RequestBuilder
        .get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders(SERVICE_NAME, "v1", "getHitCount");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.query(VERSION, versionDate);
    if (getHitCountOptions.ontology() != null) {
      builder.query("ontology", getHitCountOptions.ontology());
    }
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(HitCount.class));
  }

  /**
   * Retrieve concepts related to a concept.
   *
   * Returns a list of related concepts mentioned in the specified corpus. The
   * following relationships are supported: children parents siblings synonyms
   * qualified by broader narrower other related
   *
   * @param getRelatedConceptsOptions the {@link GetRelatedConceptsOptions}
   *                                  containing the options for the call
   * @return a {@link ServiceCall} with a response type of
   *         {@link RelatedConceptsModel}
   */
  public ServiceCall<RelatedConceptsModel> getRelatedConcepts(
      final GetRelatedConceptsOptions getRelatedConceptsOptions) {
    Validator.notNull(getRelatedConceptsOptions, "getRelatedConceptsOptions cannot be null");
    String[] pathSegments = { "v1/corpora", "concepts", "related_concepts" };
    String[] pathParameters = { getRelatedConceptsOptions.corpus(), getRelatedConceptsOptions.cui() };
    RequestBuilder builder = RequestBuilder
        .get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders(SERVICE_NAME, "v1", "getRelatedConcepts");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.query(VERSION, versionDate);
    if (getRelatedConceptsOptions.ontology() != null) {
      builder.query("ontology", getRelatedConceptsOptions.ontology());
    }
    builder.query("relationship", getRelatedConceptsOptions.relationship());
    if (getRelatedConceptsOptions.recursive() != null) {
      builder.query("recursive", String.valueOf(getRelatedConceptsOptions.recursive()));
    }
    if (getRelatedConceptsOptions.treeLayout() != null) {
      builder.query("tree_layout", String.valueOf(getRelatedConceptsOptions.treeLayout()));
    }
    if (getRelatedConceptsOptions.maxDepth() != null) {
      builder.query("max_depth", String.valueOf(getRelatedConceptsOptions.maxDepth()));
    }
    if (getRelatedConceptsOptions.maxHitCount() != null) {
      builder.query("max_hit_count", String.valueOf(getRelatedConceptsOptions.maxHitCount()));
    }
    if (getRelatedConceptsOptions.verbose() != null) {
      builder.query("verbose", String.valueOf(getRelatedConceptsOptions.verbose()));
    }
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(RelatedConceptsModel.class));
  }

  /**
   * Find similar concepts.
   *
   * The response returns a list of similar concepts. All ontologies defined in
   * the corpora are searched. Similarity is determined by checking for
   * overlapping surface forms. The results are sorted in descending order by hit
   * count.
   *
   * @param getSimilarConceptsOptions the {@link GetSimilarConceptsOptions}
   *                                  containing the options for the call
   * @return a {@link ServiceCall} with a response type of
   *         {@link ConceptListModel}
   */
  public ServiceCall<ConceptListModel> getSimilarConcepts(final GetSimilarConceptsOptions getSimilarConceptsOptions) {
    Validator.notNull(getSimilarConceptsOptions, "getSimilarConceptsOptions cannot be null");
    String[] pathSegments = { "v1/corpora", "concepts", "similar_concepts" };
    String[] pathParameters = { getSimilarConceptsOptions.corpus(), getSimilarConceptsOptions.nameOrId() };
    RequestBuilder builder = RequestBuilder
        .get(RequestBuilder.constructHttpUrl(this.getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders(SERVICE_NAME, "v1", "getSimilarConcepts");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.query("version", versionDate);

    if (getSimilarConceptsOptions.ontology() != null) {
      builder.query("ontology", getSimilarConceptsOptions.ontology());
    }
    if (getSimilarConceptsOptions.returnOntologies() != null) {
      builder.query("return_ontologies", getSimilarConceptsOptions.returnOntologies().toArray());
    }
    if (getSimilarConceptsOptions.limit() != null) {
      builder.query("_limit", String.valueOf(getSimilarConceptsOptions.limit()));
    }
    ResponseConverter<ConceptListModel> responseConverter = ResponseConverterUtils
        .getValue(new com.google.gson.reflect.TypeToken<ConceptListModel>() {
        }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieves the configuration of a specific corpus.
   *
   * The response returns the corpus detailed configuration parameters.
   *
   * @param getCorporaConfigOptions the {@link GetCorporaConfigOptions} containing
   *                                the options for the call
   * @return a {@link ServiceCall} with a response type of
   *         {@link CorporaConfigModel}
   */
  public ServiceCall<CorporaConfigModel> getCorporaConfig(final GetCorporaConfigOptions getCorporaConfigOptions) {
    String[] pathSegments = { "v1/corpora" };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders(SERVICE_NAME, "v1", "getCorporaConfig");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.query(VERSION, versionDate);
    if (getCorporaConfigOptions != null) {
      if (getCorporaConfigOptions.verbose() != null) {
        builder.query("verbose", String.valueOf(getCorporaConfigOptions.verbose()));
      }
    }
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(CorporaConfigModel.class));
  }

  /**
   * Retrieves the available corpus names and configuration.
   *
   * The response returns an array of available corpus names and optionally
   * includes detailed configuration parameters.
   *
   * @return a {@link ServiceCall} with a response type of
   *         {@link CorporaConfigModel}
   */
  public ServiceCall<CorporaConfigModel> getCorporaConfig() {
    return getCorporaConfig(null);
  }

  /**
   * Define service repository.
   *
   * This method is only supported for custom plan instances. The method stores
   * the configuration of how content should be analyzed for a corpus. The method
   * takes connectivity information for IBM Cloud Database for Elastic, the name
   * of the corpus, analyzed and non-analyzed fields, and references to
   * pre-populated custom analytic artifact stores.
   *
   * The response returns whether the instance schema was properly created. This
   * API should be used for defining a custom corpus schema. Example POST body:{
   * userName : 'string', password : 'string' repositoryUri : 'uri' corpusName :
   * 'string' \"enrichmentTargets\" : [ { \"contentField\": 'string',
   * \"enrichmentField : 'string' } ], \"metadataFields\" : [ { \"fieldName\":
   * 'string', \"usageType : 'string' } ], \"referenceIndices\" : {
   * \"dictionaryIndex\" : \"my_umls\", \"attributeIndex\" : \"my_attributes\",
   * \"meshIndex\" : \"my_mesh\", } }
   *
   * @param setCorpusSchemaOptions the {@link SetCorpusSchemaOptions} containing
   *                               the options for the call
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<CorporaConfigModel> setCorpusSchema(final SetCorpusSchemaOptions setCorpusSchemaOptions) {
    Validator.notNull(setCorpusSchemaOptions, "setCorpusSchemaOptions cannot be null");
    String[] pathSegments = { "v1/corpora" };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    builder.query(VERSION, versionDate);
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders(SERVICE_NAME, "v1", "setCorpusSchema");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    final JsonObject contentJson = new JsonObject();
    if (setCorpusSchemaOptions.userName() != null) {
      contentJson.addProperty("userName", setCorpusSchemaOptions.userName());
    }
    if (setCorpusSchemaOptions.password() != null) {
      contentJson.addProperty("password", setCorpusSchemaOptions.password());
    }
    if (setCorpusSchemaOptions.corpusURI() != null) {
      contentJson.addProperty("corpusURI", setCorpusSchemaOptions.corpusURI());
    }
    if (setCorpusSchemaOptions.enrichmentTargets() != null) {
      contentJson.add("enrichmentTargets",
          GsonSingleton.getGson().toJsonTree(setCorpusSchemaOptions.enrichmentTargets()));
    }
    if (setCorpusSchemaOptions.metadataFields() != null) {
      contentJson.add("metadataFields", GsonSingleton.getGson().toJsonTree(setCorpusSchemaOptions.metadataFields()));
    }
    if (setCorpusSchemaOptions.corpusName() != null) {
      contentJson.addProperty("corpusName", setCorpusSchemaOptions.corpusName());
    }
    if (setCorpusSchemaOptions.references() != null) {
      contentJson.add("references", GsonSingleton.getGson().toJsonTree(setCorpusSchemaOptions.references()));
    }
    builder.bodyJson(contentJson);

    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(CorporaConfigModel.class));
  }

  /**
   * Delete a corpus.
   *
   * This method is only supported for custom plan instances.
   *
   * The response returns whether the instance schema was properly deleted.
   *
   * @param deleteCorpusSchemaOptions the {@link DeleteCorpusSchemaOptions}
   *                                  containing the options for the call
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<CorporaConfigModel> deleteCorpusSchema(final DeleteCorpusSchemaOptions deleteCorpusSchemaOptions) {
    Validator.notNull(deleteCorpusSchemaOptions, "deleteCorpusSchemaOptions cannot be null");
    String[] pathSegments = { "v1/corpora" };
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    builder.query(VERSION, versionDate);
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders(SERVICE_NAME, "v1", "deleteSchema");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.query("instance", deleteCorpusSchemaOptions.instance());

    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(CorporaConfigModel.class));
  }

  /**
   * Define service repository.
   *
   * This method is only supported for custom plan instances. The method takes
   * connection information for IBM Cloud Database for Elastic instances that will
   * host custom corpora.
   *
   * The response returns whether the service successfully connected to the
   * specified repository This API should be used for providing a custom enriched
   * corpus. Example POST body:{ userName : 'string', password : 'string'
   * repositoryUri : 'uri' }
   *
   * @param setCorpusConfigOptions the {@link SetCorpusConfigOptions} containing
   *                               the options for the call
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<CorporaConfigModel> setCorpusConfig(final SetCorpusConfigOptions setCorpusConfigOptions) {
    Validator.notNull(setCorpusConfigOptions, "setCorpusConfigOptions cannot be null");
    String[] pathSegments = { "v1/corpora/configure" };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    builder.query(VERSION, versionDate);
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders(SERVICE_NAME, "v1", "setCorpusConfig");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    final JsonObject contentJson = new JsonObject();
    if (setCorpusConfigOptions.userName() != null) {
      contentJson.addProperty("userName", setCorpusConfigOptions.userName());
    }
    if (setCorpusConfigOptions.password() != null) {
      contentJson.addProperty("password", setCorpusConfigOptions.password());
    }
    if (setCorpusConfigOptions.corpusURI() != null) {
      contentJson.addProperty("corpusURI", setCorpusConfigOptions.corpusURI());
    }
    builder.bodyJson(contentJson);

    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(CorporaConfigModel.class));
  }

  /**
   * Enable monitoring for a custom instance.
   *
   * This API is meant to be used for IBM Cloud automated monitoring of custom
   * plan instances. A service api-key with read only role can be submitted to
   * enable monitoring.
   *
   * @param monitorCorpusOptions the {@link MonitorCorpusOptions} containing the
   *                             options for the call
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<Void> monitorCorpus(final MonitorCorpusOptions monitorCorpusOptions) {
    Validator.notNull(monitorCorpusOptions, "monitorCorpusOptions cannot be null");
    String[] pathSegments = { "v1/corpora/monitor" };
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    builder.query(VERSION, versionDate);
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders(SERVICE_NAME, "v1", "monitorCorpus");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.query("apikey", monitorCorpusOptions.apikey());
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieves the corpus configuration.
   *
   * The response returns the corpus configuration.
   *
   * @param getCorpusConfigOptions the {@link GetCorpusConfigOptions} containing
   *                               the options for the call
   * @return a {@link ServiceCall} with a response type of
   *         {@link CorporaConfigModel}
   */
  public ServiceCall<CorporaConfigModel> getCorpusConfig(final GetCorpusConfigOptions getCorpusConfigOptions) {
    Validator.notNull(getCorpusConfigOptions, "getCorpusConfigOptions cannot be null");
    String[] pathSegments = { "v1/corpora" };
    String[] pathParameters = { getCorpusConfigOptions.corpus() };
    RequestBuilder builder = RequestBuilder
        .get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders(SERVICE_NAME, "v1", "getCorpusConfig");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.query(VERSION, versionDate);
    if (getCorpusConfigOptions.verbose() != null) {
      builder.query("verbose", String.valueOf(getCorpusConfigOptions.verbose()));
    }
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(CorporaConfigModel.class));
  }

  /**
   * Determine if service is running correctly.
   *
   * This method will always return 500 error if the service state is not OK. This
   * makes it simpler for service front ends to detect a failed service.
   *
   * @param getHealthCheckStatusOptions the {@link GetHealthCheckStatusOptions}
   *                                    containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link ServiceStatus}
   */
  public ServiceCall<ServiceStatus> getHealthCheckStatus(
      final GetHealthCheckStatusOptions getHealthCheckStatusOptions) {
    String[] pathSegments = { "v1/status/health_check" };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders(SERVICE_NAME, "v1", "getHealthCheckStatus");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.query(VERSION, versionDate);
    if (getHealthCheckStatusOptions != null) {
      if (getHealthCheckStatusOptions.accept() != null) {
        builder.header("Accept", getHealthCheckStatusOptions.accept());
      }
      if (getHealthCheckStatusOptions.format() != null) {
        builder.query("format", getHealthCheckStatusOptions.format());
      }
    }
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(ServiceStatus.class));
  }

  /**
   * Determine if service is running correctly.
   *
   * This method will always return 500 error if the service state is not OK. This
   * makes it simpler for service front ends to detect a failed service.
   *
   * @param getHealthCheckStatusOptions the {@link GetHealthCheckStatusOptions}
   *                                    containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link ServiceStatus}
   */
  public ServiceCall<ServiceStatus> getHealthCheckStatus() {
    return getHealthCheckStatus(null);
  }

  /**
   * Retrieves annotations for a document.
   *
   * The response returns a list of all the annotations contained in the document.
   *
   * @param getDocumentAnnotationsOptions the
   *                                      {@link GetDocumentAnnotationsOptions}
   *                                      containing the options for the call
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<AnnotationsModel> getDocumentAnnotations(
      final GetDocumentAnnotationsOptions getDocumentAnnotationsOptions) {
    Validator.notNull(getDocumentAnnotationsOptions, "getDocumentAnnotationsOptions cannot be null");
    String[] pathSegments = { "v1/corpora", "documents", "annotations" };
    String[] pathParameters = { getDocumentAnnotationsOptions.corpus(), getDocumentAnnotationsOptions.documentId() };
    RequestBuilder builder = RequestBuilder
        .get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    builder.query(VERSION, versionDate);
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders(SERVICE_NAME, "v1", "getDocumentAnnotations");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.query("document_section", getDocumentAnnotationsOptions.documentSection());
    if (getDocumentAnnotationsOptions.cuis() != null) {
      builder.query("cuis", RequestUtils.join(getDocumentAnnotationsOptions.cuis(), ","));
    }
    if (getDocumentAnnotationsOptions.includeText() != null) {
      builder.query("include_text", String.valueOf(getDocumentAnnotationsOptions.includeText()));
    }
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(AnnotationsModel.class));
  }

  /**
   * Categorizes concepts in a document.
   *
   * The response returns a categorized list of text passages in a document. The
   * sentences are grouped by concept with the matching concepts highlighted
   * (tagged).
   *
   * @param getDocumentCategoriesOptions the {@link GetDocumentCategoriesOptions}
   *                                     containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link CategoriesModel}
   */
  public ServiceCall<CategoriesModel> getDocumentCategories(
      final GetDocumentCategoriesOptions getDocumentCategoriesOptions) {
    Validator.notNull(getDocumentCategoriesOptions, "getDocumentCategoriesOptions cannot be null");
    String[] pathSegments = { "v1/corpora", "documents", "categories" };
    String[] pathParameters = { getDocumentCategoriesOptions.corpus(), getDocumentCategoriesOptions.documentId() };
    RequestBuilder builder = RequestBuilder
        .get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    builder.query(VERSION, versionDate);
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders(SERVICE_NAME, "v1", "getDocumentCategories");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    if (getDocumentCategoriesOptions.highlightTagBegin() != null) {
      builder.query("highlight_tag_begin", getDocumentCategoriesOptions.highlightTagBegin());
    }
    if (getDocumentCategoriesOptions.highlightTagEnd() != null) {
      builder.query("highlight_tag_end", getDocumentCategoriesOptions.highlightTagEnd());
    }
    if (getDocumentCategoriesOptions.types() != null) {
      builder.query("types", RequestUtils.join(getDocumentCategoriesOptions.types(), ","));
    }
    if (getDocumentCategoriesOptions.category() != null) {
      builder.query("category", getDocumentCategoriesOptions.category());
    }
    if (getDocumentCategoriesOptions.onlyNegatedConcepts() != null) {
      builder.query("only_negated_concepts", String.valueOf(getDocumentCategoriesOptions.onlyNegatedConcepts()));
    }
    if (getDocumentCategoriesOptions.fields() != null) {
      builder.query("_fields", getDocumentCategoriesOptions.fields());
    }
    if (getDocumentCategoriesOptions.limit() != null) {
      builder.query("_limit", String.valueOf(getDocumentCategoriesOptions.limit()));
    }
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(CategoriesModel.class));
  }

  /**
   * Retrieves the external ID, title, abstract and text for a document.
   *
   * The response may return the following fields: external ID (e.g., PubMed ID)
   * title abstract bodypdfUrlreferenceUrl other metadata Note, some documents may
   * not have an abstract, or only the abstract may be available without the body
   * text.
   *
   * NOTE: Enable verbose mode to get abstract and body
   *
   * @param getDocumentInfoOptions the {@link GetDocumentInfoOptions} containing
   *                               the options for the call
   * @return a {@link ServiceCall} with a response type of
   *         {@link DocumentTextModel}
   */
  public ServiceCall<DocumentTextModel> getDocumentInfo(final GetDocumentInfoOptions getDocumentInfoOptions) {
    Validator.notNull(getDocumentInfoOptions, "getDocumentInfoOptions cannot be null");
    String[] pathSegments = { "v1/corpora", "documents" };
    String[] pathParameters = { getDocumentInfoOptions.corpus(), getDocumentInfoOptions.documentId() };
    RequestBuilder builder = RequestBuilder
        .get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders(SERVICE_NAME, "v1", "getDocumentInfo");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.query(VERSION, versionDate);
    builder.query("verbose", getDocumentInfoOptions.verbose());
    if (getDocumentInfoOptions.fields() != null) {
      builder.query("_fields", getDocumentInfoOptions.fields());
    }
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(DocumentTextModel.class));
  }

  /**
   * Categorizes concepts in a document.
   *
   * The response returns multiple categorized lists of text passages in a
   * document. The sentences are grouped by concept with the matching concepts
   * highlighted.
   * <P>
   * This API should be used to batch multiple categories in a single request to
   * improve performance. Example POST body:{ categories: [ { name : 'disorders',
   * category : 'disorders' }, { name : 'drugs', category : 'drugs' }, { name :
   * 'genes', category : 'genes' }, { name : 'negated', category : 'negated' }, {
   * name : 'finding',' types : ['Finding'] }, ] }
   *
   * @param getDocumentMultipleCategoriesOptions the
   *                                             {@link GetDocumentMultipleCategoriesOptions}
   *                                             containing the options for the
   *                                             call
   * @return a {@link ServiceCall} with a response type of {@link CategoriesModel}
   */
  public ServiceCall<MultipleCategoriesModel> getDocumentMultipleCategories(
      final GetDocumentMultipleCategoriesOptions getDocumentMultipleCategoriesOptions) {
    Validator.notNull(getDocumentMultipleCategoriesOptions, "getDocumentMultipleCategoriesOptions cannot be null");
    String[] pathSegments = { "v1/corpora", "documents", "categories" };
    String[] pathParameters = { getDocumentMultipleCategoriesOptions.corpus(),
        getDocumentMultipleCategoriesOptions.documentId() };
    RequestBuilder builder = RequestBuilder
        .post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    builder.query(VERSION, versionDate);
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders(SERVICE_NAME, "v1", "getDocumentMultipleCategories");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    if (getDocumentMultipleCategoriesOptions.highlightTagBegin() != null) {
      builder.query("highlight_tag_begin", getDocumentMultipleCategoriesOptions.highlightTagBegin());
    }
    if (getDocumentMultipleCategoriesOptions.highlightTagEnd() != null) {
      builder.query("highlight_tag_end", getDocumentMultipleCategoriesOptions.highlightTagEnd());
    }
    if (getDocumentMultipleCategoriesOptions.fields() != null) {
      builder.query("_fields", getDocumentMultipleCategoriesOptions.fields());
    }
    if (getDocumentMultipleCategoriesOptions.limit() != null) {
      builder.query("_limit", String.valueOf(getDocumentMultipleCategoriesOptions.limit()));
    }
    final JsonObject contentJson = new JsonObject();
    if (getDocumentMultipleCategoriesOptions.categories() != null) {
      contentJson.add("categories",
          GsonSingleton.getGson().toJsonTree(getDocumentMultipleCategoriesOptions.categories()));
    }
    builder.bodyJson(contentJson);
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(MultipleCategoriesModel.class));
  }

  /**
   * Retrieves information about the documents in this corpus.
   *
   * The response returns the following information: number of documents in the
   * corpus corpus provider.
   *
   * @param getDocumentsOptions the {@link GetDocumentsOptions} containing the
   *                            options for the call
   * @return a {@link ServiceCall} with a response type of {@link CorpusInfoModel}
   */
  public ServiceCall<CorpusInfoModel> getDocuments(final GetDocumentsOptions getDocumentsOptions) {
    Validator.notNull(getDocumentsOptions, "getDocumentsOptions cannot be null");
    String[] pathSegments = { "v1/corpora", "documents" };
    String[] pathParameters = { getDocumentsOptions.corpus() };
    RequestBuilder builder = RequestBuilder
        .get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders(SERVICE_NAME, "v1", "getDocuments");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.query(VERSION, versionDate);
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(CorpusInfoModel.class));
  }

  /**
   * Define enrichment document.
   *
   * This method is only supported for custom plan instances. The method is used
   * to add content that will be analyzed to a corpus.
   *
   * The response returns whether the document was properly added to the corpus.
   * This API should be used for adding a document to a custom corpus. Example
   * POST body:{ \"acdUrl\" : \"acdApiKeyl\" : \"flowId\" : \"document\" : {
   * \"doc_id\" : \"field[n]\" : \"value\" } \"otherAnnotators\" : [
   * \"{\"annotatorUrl \"annotatorApiKey \"containerName \"}] }
   *
   * @param addCorpusDocumentOptions the {@link AddCorpusDocumentOptions}
   *                                 containing the options for the call
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<Void> addCorpusDocument(final AddCorpusDocumentOptions addCorpusDocumentOptions) {
    Validator.notNull(addCorpusDocumentOptions, "addCorpusDocumentOptions cannot be null");
    String[] pathSegments = { "v1/corpora", "documents" };
    String[] pathParameters = { addCorpusDocumentOptions.corpus() };
    RequestBuilder builder = RequestBuilder
        .post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    builder.query(VERSION, versionDate);
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders(SERVICE_NAME, "v1", "addCorpusDocument");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    final JsonObject contentJson = new JsonObject();
    if (addCorpusDocumentOptions.document() != null) {
      contentJson.add("document", GsonSingleton.getGson().toJsonTree(addCorpusDocumentOptions.document()));
    }
    if (addCorpusDocumentOptions.acdUrl() != null) {
      contentJson.addProperty("acdUrl", addCorpusDocumentOptions.acdUrl());
    }
    if (addCorpusDocumentOptions.apiKey() != null) {
      contentJson.addProperty("apiKey", addCorpusDocumentOptions.apiKey());
    }
    if (addCorpusDocumentOptions.flowId() != null) {
      contentJson.addProperty("flowId", addCorpusDocumentOptions.flowId());
    }
    if (addCorpusDocumentOptions.accessToken() != null) {
      contentJson.addProperty("accessToken", addCorpusDocumentOptions.accessToken());
    }
    if (addCorpusDocumentOptions.otherAnnotators() != null) {
      contentJson.add("otherAnnotators",
          GsonSingleton.getGson().toJsonTree(addCorpusDocumentOptions.otherAnnotators()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Finds concepts in a document matching a set of search concepts.
   *
   * Returns matching concepts and text passages. The sentences containing each
   * concept are returned with the concept highlighted. Extended annotations
   * provide additional details for each discrete search match detected in the
   * document. An iml-annotation-id attribute is added to each highlight tag which
   * allows an application to easily show the annotation details when hovering
   * over a text span. The iml-annotation-id may also be used to color code the
   * text spans. The ibm_annotation-id is used as a key for the returned
   * annotations. For example, a search match on the concept \"Breast Carcinoma\"
   * will have a class name \"iml-breast-carcinoma\" inserted in the highlight
   * tag, and the returned annotations['umls-breast_carcinoma-hypothetical'] JSON
   * field will contain the detailed annotation data: { \"cui\": \"C0678222\"
   * \"hypothetical\": true \"preferredName\": \"Breast Carcinoma\"
   * \"semanticType\": \"umls.NeoplasticProcess\" \"source\": \"umls\" \"type\":
   * \"umls.NeoplasticProcess\" }
   *
   * @param getSearchMatchesOptions the {@link GetSearchMatchesOptions} containing
   *                                the options for the call
   * @return a {@link ServiceCall} with a response type of
   *         {@link SearchMatchesModel}
   */
  public ServiceCall<SearchMatchesModel> getSearchMatches(final GetSearchMatchesOptions getSearchMatchesOptions) {
    Validator.notNull(getSearchMatchesOptions, "getSearchMatchesOptions cannot be null");
    String[] pathSegments = { "v1/corpora", "documents", "search_matches" };
    String[] pathParameters = { getSearchMatchesOptions.corpus(), getSearchMatchesOptions.documentId() };
    RequestBuilder builder = RequestBuilder
        .get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    builder.query(VERSION, versionDate);
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders(SERVICE_NAME, "v1", "getSearchMatches");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    if (getSearchMatchesOptions.cuis() != null) {
      builder.query("cuis", getSearchMatchesOptions.cuis().toArray());
    }
    if (getSearchMatchesOptions.text() != null) {
      builder.query("text", getSearchMatchesOptions.text().toArray());
    }
    if (getSearchMatchesOptions.types() != null) {
      builder.query("types", getSearchMatchesOptions.types().toArray());
    }
    if (getSearchMatchesOptions.attributes() != null) {
      builder.query("attributes", getSearchMatchesOptions.attributes().toArray());
    }
    if (getSearchMatchesOptions.values() != null) {
      builder.query("values", getSearchMatchesOptions.values().toArray());
    }
    if (getSearchMatchesOptions.limit() != null) {
      builder.query("_limit", String.valueOf(getSearchMatchesOptions.limit()));
    }
    if (getSearchMatchesOptions.searchTagBegin() != null) {
      builder.query("search_tag_begin", getSearchMatchesOptions.searchTagBegin());
    }
    if (getSearchMatchesOptions.searchTagEnd() != null) {
      builder.query("search_tag_end", getSearchMatchesOptions.searchTagEnd());
    }
    if (getSearchMatchesOptions.relatedTagBegin() != null) {
      builder.query("related_tag_begin", getSearchMatchesOptions.relatedTagBegin());
    }
    if (getSearchMatchesOptions.relatedTagEnd() != null) {
      builder.query("related_tag_end", getSearchMatchesOptions.relatedTagEnd());
    }
    builder.query("min_score", String.valueOf(getSearchMatchesOptions.minScore()));
    if (getSearchMatchesOptions.fields() != null) {
      builder.query("_fields", getSearchMatchesOptions.fields());
    }
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(SearchMatchesModel.class));
  }

  /**
   * Object for constructing a service instance.
   *
   */
  public static final class Builder {

    private String versionDate = null;
    private String url = null;
    private String iamUrl = null;
    private String apikey = null;
    private HttpConfigOptions httpOptions = null;

    /**
     * Constructor.
     */
    public Builder() {
    }

    /**
     * Builder versionDate method to configure the IML REST APIs version of the
     * client.
     *
     * @param val the version date string as YYYY-MM-DD
     *
     * @return builder object with the version date
     */
    public Builder versionDate(final String val) {
      versionDate = val;
      return this;
    }

    /**
     * Builder url method to configure the URL of the IBM Access Manager.
     *
     * @param val the URL for Identry and Access Manager instance
     *
     * @return builder object with the IAM url
     */
    public Builder iamUrl(final String val) {
      iamUrl = val;
      return this;
    }

    /**
     * Builder url method to configure the URL of the client.
     *
     * @param val the URL to the service instance
     *
     * @return builder object with the service url
     */
    public Builder url(final String val) {
      url = val;
      return this;
    }

    /**
     * Builder http configuration options for establishing a connection.
     *
     * @param options the http config options
     *
     * @return builder object with the options
     */
    public Builder httpConfigOptions(final HttpConfigOptions options) {
      httpOptions = options;
      return this;
    }

    /**
     * Builder apikey method to set the authentication key.
     *
     * @param val the apikey for the instance
     *
     * @return buidler object with the apikey
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
    public InsightsForMedicalLiteratureService build() {
      if (apikey == null) {
        return new InsightsForMedicalLiteratureService(versionDate, url);
      } else {
        if (iamUrl == null) {
          return new InsightsForMedicalLiteratureService(versionDate, apikey, url, httpOptions);
        } else {
          return new InsightsForMedicalLiteratureService(versionDate, apikey, iamUrl, url, httpOptions);
        }
      }
    }
  }
}
