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
package com.ibm.watson.health.iml.v1;

import com.google.gson.JsonObject;
import com.ibm.cloud.whcs.common.SdkCommon;
import com.ibm.cloud.sdk.core.http.RequestBuilder;
import com.ibm.cloud.sdk.core.http.ResponseConverter;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.ConfigBasedAuthenticatorFactory;
import com.ibm.cloud.sdk.core.service.BaseService;
import com.ibm.cloud.sdk.core.util.RequestUtils;
import com.ibm.cloud.sdk.core.util.ResponseConverterUtils;
import com.ibm.watson.health.iml.v1.model.AddArtifactOptions;
import com.ibm.watson.health.iml.v1.model.AddCorpusDocumentOptions;
import com.ibm.watson.health.iml.v1.model.AnnotationsModel;
import com.ibm.watson.health.iml.v1.model.CategoriesModel;
import com.ibm.watson.health.iml.v1.model.CommonDataModel;
import com.ibm.watson.health.iml.v1.model.ConceptInfoModel;
import com.ibm.watson.health.iml.v1.model.ConceptListModel;
import com.ibm.watson.health.iml.v1.model.CorporaConfig;
import com.ibm.watson.health.iml.v1.model.CorpusInfoModel;
import com.ibm.watson.health.iml.v1.model.CorpusModel;
import com.ibm.watson.health.iml.v1.model.DeleteCorpusSchemaOptions;
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
import com.ibm.watson.health.iml.v1.model.RelatedConceptsModel;
import com.ibm.watson.health.iml.v1.model.SearchMatchesModel;
import com.ibm.watson.health.iml.v1.model.SearchModel;
import com.ibm.watson.health.iml.v1.model.SearchOptions;
import com.ibm.watson.health.iml.v1.model.ServiceStatus;
import com.ibm.watson.health.iml.v1.model.SetCorpusConfigOptions;
import com.ibm.watson.health.iml.v1.model.SetCorpusSchemaOptions;
import com.ibm.watson.health.iml.v1.model.StatisticsModel;
import com.ibm.watson.health.iml.v1.model.TokenizeOptions;
import com.ibm.watson.health.iml.v1.model.TypeaheadOptions;

import java.util.Map;
import java.util.Map.Entry;

/**
 * For more information see the &lt;a href='../../documentation' target='_blank'&gt;extended
 * documentation&lt;/a&gt;.&lt;p&gt;Try the &lt;a href='../../application'&gt;Insights for Medical Literature demo
 * application&lt;/a&gt;.&lt;h3&gt;Service Overview&lt;/h3&gt;The Insights for Medical Literature service provides APIs
 * that enable you to derive insights from a corpus of medical documents. For example, the &lt;a
 * href='https://www.nlm.nih.gov/bsd/pmresources.html' target='_blank'&gt;MEDLINE&amp;reg;&lt;/a&gt; corpus contains
 * more than 26 million references to medical journal articles.  An unstructured medical document corpus is ingested by
 * IBM, enriched with the Unified Medical Language System (&lt;a href='https://www.nlm.nih.gov/research/umls/'
 * target='_blank'&gt;UMLS&amp;reg;&lt;/a&gt;) and stored as structured data in an IBM managed database.  The UMLS
 * enrichment enables a concept based search, in addition to a conventional text search.  Other unique features include
 * concept matching, concept relationships, identifying co-occurring concepts and identifying disorders, drugs, genes
 * and other medical terms mentioned in a medical document.&lt;h3&gt;National Library of Medicine&amp;reg;
 * (NLM&amp;reg;) License&lt;/h3&gt;The MEDLINE corpus is imported from &lt;a
 * href='https://www.nlm.nih.gov/databases/journal.html' target='_blank'&gt;MEDLINE&amp;reg;/PubMed&amp;reg;&lt;/a&gt;,
 * a database of the U.S. National Library of Medicine. &lt;P&gt;&lt;P&gt;The MEDLINE corpus is periodically updated to
 * contain new and/or maintained records, and remove deleted records, at least once every thirty (30) days. The MEDLINE
 * corpus may be updated on a weekly basis.&lt;P&gt;&lt;P&gt;NLM represents that its data were formulated with a
 * reasonable standard of care.  Except for this representation, NLM makes no representation or warranties, expressed or
 * implied.  This includes, but is not limited to, any implied warranty of merchantability or fitness for a particular
 * purpose, with respect to the NLM data, and NLM specifically disclaims any such warranties and
 * representations.&lt;P&gt;&lt;P&gt;All complete or parts of U.S. National Library of Medicine (NLM) records that are
 * redistributed or retransmitted must be identified as being derived from NLM  data.&lt;h3&gt;API
 * Overview&lt;/h3&gt;The APIs are grouped into these categories:&lt;UL&gt;&lt;LI&gt;&lt;B&gt;Concepts&lt;/B&gt; :
 * Concept information&lt;/LI&gt;&lt;P&gt;Concept information includes a concept unique identifier (CUI), preferred
 * name, alternative name (other surface forms), semantic group (category), semantic types, counts (hits, parents,
 * children, siblings...) and, related concepts. &lt;LI&gt;&lt;B&gt;Corpora&lt;/B&gt; : Corpora
 * information&lt;/LI&gt;&lt;P&gt;You can retrieve a list of corpus names.  For each corpus a unique list of semantic
 * groups and semantic types is provided. &lt;LI&gt;&lt;B&gt;Documents&lt;/B&gt; : Document
 * information&lt;/LI&gt;&lt;P&gt;These APIs enable full text documents and document annotations to be retreived.
 * Concepts mentioned in a medical document may also be categorized by semantic groups and types.  The best matching
 * search concepts can also be identified in a medical document.&lt;LI&gt;&lt;B&gt;Search&lt;/B&gt; : Concept
 * search&lt;/LI&gt;&lt;P&gt;These APIs perform typeahead concept searches, ranked document searches, and cohesive and
 * co-occurring concept searches.  A search targets a single medical document corpus.&lt;LI&gt;&lt;B&gt;Status&lt;/B&gt;
 * : Check the status of this
 * service&lt;/LI&gt;&lt;/UL&gt;&lt;h3&gt;Terminology&lt;/h3&gt;&lt;UL&gt;&lt;LI&gt;&lt;B&gt;Concept Unique Identifier
 * (cui)&lt;/B&gt;&lt;/LI&gt;A UMLS CUI identifies a concept, and is specified as a path or query parameter to select a
 * specific concept.  A CUI always begins with an uppercase letter 'C' followed by seven decimal digits (e.g.,
 * C0446516).&lt;LI&gt;&lt;B&gt;Document Identifiter&lt;/B&gt;&lt;/LI&gt;A document ID uniquely identifies a document in
 * a corpus, and is specified as a path or query parameter to select a specific medical document.&lt;LI&gt;&lt;B&gt;Hit
 * count&lt;/B&gt;&lt;/LI&gt;A hit count specifies the number of times a specific concept is mentioned in a
 * corpus.&lt;LI&gt;&lt;B&gt;Preferred Name (pn)&lt;/B&gt;&lt;/LI&gt;A preferred name is the common name for a concept.
 * A concept may also have other surface forms or alternative names.&lt;LI&gt;&lt;B&gt;Semantic Group
 * (group)&lt;/B&gt;&lt;/LI&gt;A semantic group aggregates multiple semantic types, and is specified as a path or query
 * parameter to filter or select concepts belonging to the same semantic group (e.g., Disorders or
 * ChemicalsAndDrugs).&lt;LI&gt;&lt;B&gt;Semantic Type (type)&lt;/B&gt;&lt;/LI&gt;A semantic type is a camelcase string
 * derived from a UMLS semantic type (e.g., ClinicalDrug or DiseaseOrSyndrome). It is specified as a path or query
 * parameter to filter or select concepts belonging to the same category (semantic type).&lt;LI&gt;&lt;B&gt;Surface
 * form&lt;/B&gt;&lt;/LI&gt;A surface form is an alternative name for a concept.  The surface forms identify text spans
 * in a medical document, and the identified text spans are annotated with the matching CUI, preferred name and semantic
 * type.&lt;/UL&gt;&lt;h3&gt;Typical Document Search Flow&lt;/h3&gt;&lt;p&gt;1. &lt;b&gt;GET /v1/corpora&lt;/b&gt; - Get
 * list of all available corpus names&lt;p&gt;2. &lt;b&gt;GET /v1/corpora/corpus_name/search/typeahead&lt;/b&gt; - Use
 * typeahead to select search concepts&lt;p&gt;3. &lt;b&gt;GET
 * /v1/corpora/corpus_name/search/cooccurring_concepts&lt;/b&gt; - Find additional co-occurring search
 * concepts&lt;p&gt;4. &lt;b&gt;GET /v1/corpora/corpus_name/concepts/{cui}/matching_concepts&lt;/b&gt; - Find additional
 * matching search concepts&lt;p&gt;5. &lt;b&gt;GET /v1/corpora/corpus_name/concepts/{cui}/related_concepts&lt;/b&gt; -
 * Find additional related search concepts&lt;p&gt;6. &lt;b&gt;GET
 * /v1/corpora/corpus_name/search/ranked_documents&lt;/b&gt; - Search for ranked documents matching search
 * concepts&lt;p&gt;7. &lt;b&gt;GET /v1/corpora/corpus_name/documents/{document_id}/search_matches&lt;/b&gt; - Highlight
 * matching search concepts in a ranked documents&lt;p&gt;8. &lt;b&gt;GET
 * /v1/corpora/corpus_name/documents/{document_id}/categories&lt;/b&gt; - Highlight diseases, drugs and genes in a
 * ranked document.
 *
 * @version v1
 */
public class InsightsForMedicalLiteratureService extends BaseService {

  public static final String DEFAULT_SERVICE_NAME = "insights_for_medical_literature_service";

  public static final String DEFAULT_SERVICE_URL = "https://insights-for-medical-literature-service.cloud.ibm.com/services/medical_insights/api";

  private String version;

 /**
   * Class method which constructs an instance of the `InsightsForMedicalLiteratureService` client.
   * The default service name is used to configure the client instance.
   *
   * @param version The release date of the version of the API you want to use. Specify dates in YYYY-MM-DD format.
   * @return an instance of the `InsightsForMedicalLiteratureService` client using external configuration
   */
  public static InsightsForMedicalLiteratureService newInstance(String version) {
    return newInstance(version, DEFAULT_SERVICE_NAME);
  }

  /**
   * Class method which constructs an instance of the `InsightsForMedicalLiteratureService` client.
   * The specified service name is used to configure the client instance.
   *
   * @param version The release date of the version of the API you want to use. Specify dates in YYYY-MM-DD format.
   * @param serviceName the service name to be used when configuring the client instance
   * @return an instance of the `InsightsForMedicalLiteratureService` client using external configuration
   */
  public static InsightsForMedicalLiteratureService newInstance(String version, String serviceName) {
    Authenticator authenticator = ConfigBasedAuthenticatorFactory.getAuthenticator(serviceName);
    InsightsForMedicalLiteratureService service = new InsightsForMedicalLiteratureService(version, serviceName, authenticator);
    service.configureService(serviceName);
    return service;
  }

  /**
   * Constructs an instance of the `InsightsForMedicalLiteratureService` client.
   * The specified service name and authenticator are used to configure the client instance.
   *
   * @param version The release date of the version of the API you want to use. Specify dates in YYYY-MM-DD format.
   * @param serviceName the service name to be used when configuring the client instance
   * @param authenticator the {@link Authenticator} instance to be configured for this client
   */
  public InsightsForMedicalLiteratureService(String version, String serviceName, Authenticator authenticator) {
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
   * Retrieves information about the documents in this corpus.
   *
   * The response returns the following information: &lt;ul&gt;&lt;li&gt;number of documents in the
   * corpus&lt;/li&gt;&lt;li&gt;corpus provider&lt;/li&gt;&lt;/ul&gt;.
   *
   * @param getDocumentsOptions the {@link GetDocumentsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link CorpusModel}
   */
  public ServiceCall<CorpusInfoModel> getDocuments(GetDocumentsOptions getDocumentsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getDocumentsOptions,
      "getDocumentsOptions cannot be null");
    String[] pathSegments = { "v1/corpora", "documents" };
    String[] pathParameters = { getDocumentsOptions.corpus() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("insights_for_medical_literature_service", "v1", "getDocuments");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", this.version);
    ResponseConverter<CorpusInfoModel> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<CorpusInfoModel>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Define enrichment document.
   *
   * The response returns whether the document was properly added to the corpus.  &lt;P&gt;This API should be used for
   * adding a document to a custom corpus.&lt;P&gt;Example POST body:&lt;pre&gt;{
   *   "acdUrl" :
   *   "acdApiKeyl" :
   *   "flowId" :
   *   "document" : {
   *    "doc_id" :
   *    "field[n]" : "value"
   *   }
   *   "otherAnnotators" : [   "{    "annotatorUrl    "annotatorApiKey    "containerName   "}  ]
   * }
   * &lt;/pre&gt;.
   *
   * @param addCorpusDocumentOptions the {@link AddCorpusDocumentOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> addCorpusDocument(AddCorpusDocumentOptions addCorpusDocumentOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(addCorpusDocumentOptions,
      "addCorpusDocumentOptions cannot be null");
    String[] pathSegments = { "v1/corpora", "documents" };
    String[] pathParameters = { addCorpusDocumentOptions.corpus() };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("insights_for_medical_literature_service", "v1", "addCorpusDocument");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.query("version", this.version);
    final JsonObject contentJson = new JsonObject();
    if (addCorpusDocumentOptions.document() != null) {
      contentJson.add("document", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(addCorpusDocumentOptions.document()));
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
      contentJson.add("otherAnnotators", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(addCorpusDocumentOptions.otherAnnotators()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieves the external ID, title, abstract and text for a document.
   *
   * The response may return the following fields:&lt;ul&gt;&lt;li&gt;external ID (e.g., PubMed
   * ID)&lt;/li&gt;&lt;li&gt;title&lt;/li&gt;&lt;li&gt;abstract&lt;/li&gt;&lt;li&gt;body&lt;/li&gt;&lt;li&gt;pdfUrl&lt;/li&gt;&lt;li&gt;referenceUrl&lt;/li&gt;&lt;li&gt;other
   * metadata&lt;/li&gt;&lt;/ul&gt;Note, some documents may not have an abstract, or only the abstract may be available
   * without the body text.
   *
   * @param getDocumentInfoOptions the {@link GetDocumentInfoOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link GetDocumentInfoResponse}
   */
  public ServiceCall<GetDocumentInfoResponse> getDocumentInfo(GetDocumentInfoOptions getDocumentInfoOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getDocumentInfoOptions,
      "getDocumentInfoOptions cannot be null");
    String[] pathSegments = { "v1/corpora", "documents" };
    String[] pathParameters = { getDocumentInfoOptions.corpus(), getDocumentInfoOptions.documentId() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("insights_for_medical_literature_service", "v1", "getDocumentInfo");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", this.version);
    if (getDocumentInfoOptions.verbose() != null) {
      builder.query("verbose", String.valueOf(getDocumentInfoOptions.verbose()));
    }
    ResponseConverter<GetDocumentInfoResponse> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<GetDocumentInfoResponse>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieves annotations for a document.
   *
   * The response returns a list of all the annotations contained in the document.
   *
   * @param getDocumentAnnotationsOptions the {@link GetDocumentAnnotationsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<AnnotationsModel> getDocumentAnnotations(GetDocumentAnnotationsOptions getDocumentAnnotationsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getDocumentAnnotationsOptions,
      "getDocumentAnnotationsOptions cannot be null");
    String[] pathSegments = { "v1/corpora", "documents", "annotations" };
    String[] pathParameters = { getDocumentAnnotationsOptions.corpus(), getDocumentAnnotationsOptions.documentId() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("insights_for_medical_literature_service", "v1", "getDocumentAnnotations");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.query("version", this.version);
    builder.query("document_section", getDocumentAnnotationsOptions.documentSection());
    if (getDocumentAnnotationsOptions.cuis() != null) {
      builder.query("cuis", RequestUtils.join(getDocumentAnnotationsOptions.cuis(), ","));
    }
    if (getDocumentAnnotationsOptions.includeText() != null) {
      builder.query("include_text", String.valueOf(getDocumentAnnotationsOptions.includeText()));
    }
    ResponseConverter<AnnotationsModel> responseConverter = ResponseConverterUtils
    		.getValue(new com.google.gson.reflect.TypeToken<AnnotationsModel>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Categorizes concepts in a document.
   *
   * The response returns a categorized list of text passages in a document.  The sentences are grouped by concept with
   * the matching concepts highlighted.
   *
   * @param getDocumentCategoriesOptions the {@link GetDocumentCategoriesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link CategoriesModel}
   */
  public ServiceCall<CategoriesModel> getDocumentCategories(GetDocumentCategoriesOptions getDocumentCategoriesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getDocumentCategoriesOptions,
      "getDocumentCategoriesOptions cannot be null");
    String[] pathSegments = { "v1/corpora", "documents", "categories" };
    String[] pathParameters = { getDocumentCategoriesOptions.corpus(), getDocumentCategoriesOptions.documentId() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("insights_for_medical_literature_service", "v1", "getDocumentCategories");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", this.version);
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
    ResponseConverter<CategoriesModel> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<CategoriesModel>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Categorizes concepts in a document.
   *
   * The response returns multiple categorized lists of text passages in a document.  The sentences are grouped by
   * concept with the matching concepts highlighted.&lt;P&gt;This API should be used to batch multiple categories in a
   * single request to improve performance.&lt;P&gt;Example POST body:&lt;pre&gt;{
   *  categories: [
   *   {
   *    name : 'disorders',
   *    category : 'disorders'
   *   },
   *   {
   *    name : 'drugs',
   *    category : 'drugs'
   *   },
   *   {
   *    name : 'genes',
   *    category : 'genes'
   *   },
   *   {
   *    name : 'negated',
   *    category : 'negated'
   *   },
   *   {
   *    name : 'finding','
   *    types : ['Finding']
   *   },
   *  ]
   * }
   * &lt;/pre&gt;.
   *
   * @param getDocumentMultipleCategoriesOptions the {@link GetDocumentMultipleCategoriesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link CategoriesModel}
   */
  public ServiceCall<CategoriesModel> getDocumentMultipleCategories(GetDocumentMultipleCategoriesOptions getDocumentMultipleCategoriesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getDocumentMultipleCategoriesOptions,
      "getDocumentMultipleCategoriesOptions cannot be null");
    String[] pathSegments = { "v1/corpora", "documents", "categories" };
    String[] pathParameters = { getDocumentMultipleCategoriesOptions.corpus(), getDocumentMultipleCategoriesOptions.documentId() };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("insights_for_medical_literature_service", "v1", "getDocumentMultipleCategories");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", this.version);
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
      contentJson.add("categories", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(getDocumentMultipleCategoriesOptions.categories()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<CategoriesModel> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<CategoriesModel>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Finds concepts in a document matching a set of search concepts.
   *
   * Returns matching concepts and text passages. The sentences containing each concept are returned with the concept
   * highlighted. &lt;p&gt;Extended annotations provide additional details for  each discrete search match detected in
   * the document.  An iml-annotation-id attribute is added to each highlight tag which allows an application to easily
   * show the annotation details when hovering over a text span.  The iml-annotation-id may also be used to color code
   * the text spans.  The ibm_annotation-id is used as a key for the returned annotations. &lt;p&gt;For example, a
   * search match on the concept "Breast Carcinoma" will have a class name "iml-breast-carcinoma" inserted in the
   * highlight tag, and the returned annotations['umls-breast_carcinoma-hypothetical'] JSON field will contain the
   * detailed annotation data: &lt;pre&gt;{
   *  "cui": "C0678222"
   *  "hypothetical": true
   *  "preferredName": "Breast Carcinoma"
   *  "semanticType": "umls.NeoplasticProcess"
   *  "source": "umls"
   *  "type": "umls.NeoplasticProcess"
   * }
   * &lt;/pre&gt;.
   *
   * @param getSearchMatchesOptions the {@link GetSearchMatchesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link SearchMatchesModel}
   */
  public ServiceCall<SearchMatchesModel> getSearchMatches(GetSearchMatchesOptions getSearchMatchesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getSearchMatchesOptions,
      "getSearchMatchesOptions cannot be null");
    String[] pathSegments = { "v1/corpora", "documents", "search_matches" };
    String[] pathParameters = { getSearchMatchesOptions.corpus(), getSearchMatchesOptions.documentId() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("insights_for_medical_literature_service", "v1", "getSearchMatches");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", this.version);
    builder.query("min_score", String.valueOf(getSearchMatchesOptions.minScore()));
    if (getSearchMatchesOptions.cuis() != null) {
      builder.query("cuis", getSearchMatchesOptions.cuis());
    }
    if (getSearchMatchesOptions.text() != null) {
      builder.query("text", getSearchMatchesOptions.text());
    }
    if (getSearchMatchesOptions.types() != null) {
      builder.query("types", getSearchMatchesOptions.types());
    }
    if (getSearchMatchesOptions.attributes() != null) {
      builder.query("attributes", getSearchMatchesOptions.attributes());
    }
    if (getSearchMatchesOptions.values() != null) {
      builder.query("values", getSearchMatchesOptions.values());
    }
    if (getSearchMatchesOptions.nluRelations() != null) {
      builder.query("nlu_relations", getSearchMatchesOptions.nluRelations());
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
    if (getSearchMatchesOptions.fields() != null) {
      builder.query("_fields", getSearchMatchesOptions.fields());
    }
    ResponseConverter<SearchMatchesModel> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<SearchMatchesModel>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieves the available corpus names and configuration.
   *
   * The response returns an array of available corpus names and optionally includes detailed configuation parameters.
   *
   * @param getCorporaConfigOptions the {@link GetCorporaConfigOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link CorporaConfig}
   */
  public ServiceCall<CorporaConfig> getCorporaConfig(GetCorporaConfigOptions getCorporaConfigOptions) {
    String[] pathSegments = { "v1/corpora" };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("insights_for_medical_literature_service", "v1", "getCorporaConfig");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getCorporaConfigOptions != null) {
      builder.query("version", this.version);
      if (getCorporaConfigOptions.verbose() != null) {
        builder.query("verbose", String.valueOf(getCorporaConfigOptions.verbose()));
      }
    }
    ResponseConverter<CorporaConfig> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<CorporaConfig>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieves the available corpus names and configuration.
   *
   * The response returns an array of available corpus names and optionally includes detailed configuation parameters.
   *
   * @return a {@link ServiceCall} with a result of type {@link CorporaConfig}
   */
  public ServiceCall<CorporaConfig> getCorporaConfig() {
    return getCorporaConfig(null);
  }

  /**
   * Define service repository data model.
   *
   * The response returns whether the instance schema was properly created.  &lt;P&gt;This API should be used for
   * defining a custom corpus schema.&lt;P&gt;Example POST body:&lt;pre&gt;{
   *    corpusName : 'string'
   *   "enrichmentTargets" : [
   *    {
   *     "contentField": 'string',
   *     "enrichmentField : 'string'
   *    }
   *   ],
   *   "metadataFields" : [
   *    {
   *     "fieldName": 'string',
   *     "fieldType : 'string'
   *    }
   *   ],
   *   "referenceIndices" : {
   *    "dictionaryIndex" : "my_umls",
   *    "attributeIndex" : "my_attributes",
   *    "meshIndex" : "my_mesh",
   *   }
   * }
   * &lt;/pre&gt;.
   *
   * @param setCorpusSchemaOptions the {@link SetCorpusSchemaOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link CorporaConfig}
   */
  public ServiceCall<CorporaConfig> setCorpusSchema(SetCorpusSchemaOptions setCorpusSchemaOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(setCorpusSchemaOptions,
      "setCorpusSchemaOptions cannot be null");
    String[] pathSegments = { "v1/corpora" };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("insights_for_medical_literature_service", "v1", "setCorpusSchema");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", this.version);
    final JsonObject contentJson = new JsonObject();
    if (setCorpusSchemaOptions.enrichmentTargets() != null) {
      contentJson.add("enrichmentTargets", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(setCorpusSchemaOptions.enrichmentTargets()));
    }
    if (setCorpusSchemaOptions.metadataFields() != null) {
      contentJson.add("metadataFields", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(setCorpusSchemaOptions.metadataFields()));
    }
    if (setCorpusSchemaOptions.corpusName() != null) {
      contentJson.addProperty("corpusName", setCorpusSchemaOptions.corpusName());
    }
    if (setCorpusSchemaOptions.references() != null) {
      contentJson.add("references", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(setCorpusSchemaOptions.references()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<CorporaConfig> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<CorporaConfig>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Define service repository data model.
   *
   * The response returns whether the instance schema was properly created.  &lt;P&gt;This API should be used for
   * defining a custom corpus schema.&lt;P&gt;Example POST body:&lt;pre&gt;{
   *    corpusName : 'string'
   *   "enrichmentTargets" : [
   *    {
   *     "contentField": 'string',
   *     "enrichmentField : 'string'
   *    }
   *   ],
   *   "metadataFields" : [
   *    {
   *     "fieldName": 'string',
   *     "fieldType : 'string'
   *    }
   *   ],
   *   "referenceIndices" : {
   *    "dictionaryIndex" : "my_umls",
   *    "attributeIndex" : "my_attributes",
   *    "meshIndex" : "my_mesh",
   *   }
   * }
   * &lt;/pre&gt;.
   *
   * @return a {@link ServiceCall} with a result of type {@link CorporaConfig}
   */
  public ServiceCall<CorporaConfig> setCorpusSchema() {
    return setCorpusSchema(null);
  }

  /**
   * Delete a corpus.
   *
   * The response returns whether the instance schema was properly deleted.
   *
   * @param deleteCorpusSchemaOptions the {@link DeleteCorpusSchemaOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link CorporaConfig}
   */
  public ServiceCall<CorporaConfig> deleteCorpusSchema(DeleteCorpusSchemaOptions deleteCorpusSchemaOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteCorpusSchemaOptions,
      "deleteCorpusSchemaOptions cannot be null");
    String[] pathSegments = { "v1/corpora" };
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("insights_for_medical_literature_service", "v1", "deleteCorpusSchema");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", this.version);
    builder.query("instance", deleteCorpusSchemaOptions.instance());
    ResponseConverter<CorporaConfig> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<CorporaConfig>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Define service repository.
   *
   * The response returns whether the service successfully connected to the specified repository.  &lt;P&gt;This API
   * should be used for providing a custom enriched corpus.&lt;P&gt;Example POST body:&lt;pre&gt;{
   *    userName : 'string',
   *    password : 'string'
   *    repositoryUri : 'uri'
   * }
   * &lt;/pre&gt;.
   *
   * @param setCorpusConfigOptions the {@link SetCorpusConfigOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link CorporaConfig}
   */
  public ServiceCall<CorporaConfig> setCorpusConfig(SetCorpusConfigOptions setCorpusConfigOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(setCorpusConfigOptions,
      "setCorpusConfigOptions cannot be null");
    String[] pathSegments = { "v1/corpora/configure" };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("insights_for_medical_literature_service", "v1", "setCorpusConfig");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", this.version);
    final JsonObject contentJson = new JsonObject();
    if (setCorpusConfigOptions.userName() != null) {
      contentJson.addProperty("userName", setCorpusConfigOptions.userName());
    }
    if (setCorpusConfigOptions.password() != null) {
      contentJson.addProperty("password", setCorpusConfigOptions.password());
    }
    if (setCorpusConfigOptions.corpusUri() != null) {
      contentJson.addProperty("corpusURI", setCorpusConfigOptions.corpusUri());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<CorporaConfig> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<CorporaConfig>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Define service repository.
   *
   * The response returns whether the service successfully connected to the specified repository.  &lt;P&gt;This API
   * should be used for providing a custom enriched corpus.&lt;P&gt;Example POST body:&lt;pre&gt;{
   *    userName : 'string',
   *    password : 'string'
   *    repositoryUri : 'uri'
   * }
   * &lt;/pre&gt;.
   *
   * @return a {@link ServiceCall} with a result of type {@link CorporaConfig}
   */
  public ServiceCall<CorporaConfig> setCorpusConfig() {
    return setCorpusConfig(null);
  }

  /**
   * Enable monitoring for a custom instance.
   *
   * This API is meant to be used for IBM Cloud automated monitoring of custom plan instances.  A service api-key with
   * read only role can be submitted to enable monitoring.
   *
   * @param monitorCorpusOptions the {@link MonitorCorpusOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> monitorCorpus(MonitorCorpusOptions monitorCorpusOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(monitorCorpusOptions,
      "monitorCorpusOptions cannot be null");
    String[] pathSegments = { "v1/corpora/monitor" };
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("insights_for_medical_literature_service", "v1", "monitorCorpus");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.query("version", this.version);
    builder.query("apikey", monitorCorpusOptions.apikey());
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Toggle Search Activity Tracking.
   *
   * The response returns whether the tracking was enabled or disabled.
   *
   * @param enableCorpusSearchTrackingOptions the {@link EnableCorpusSearchTrackingOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> enableCorpusSearchTracking(EnableCorpusSearchTrackingOptions enableCorpusSearchTrackingOptions) {
    String[] pathSegments = { "v1/corpora/tracking" };
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("insights_for_medical_literature_service", "v1", "enableCorpusSearchTracking");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    if (enableCorpusSearchTrackingOptions != null) {
      builder.query("version", this.version);
      if (enableCorpusSearchTrackingOptions.enableTracking() != null) {
        builder.query("enable_tracking", String.valueOf(enableCorpusSearchTrackingOptions.enableTracking()));
      }
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Toggle Search Activity Tracking.
   *
   * The response returns whether the tracking was enabled or disabled.
   *
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> enableCorpusSearchTracking() {
    return enableCorpusSearchTracking(null);
  }

  /**
   * Retrieves the corpus configuration.
   *
   * The response returns the corpus configuration.
   *
   * @param getCorpusConfigOptions the {@link GetCorpusConfigOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link CorporaConfig}
   */
  public ServiceCall<CorporaConfig> getCorpusConfig(GetCorpusConfigOptions getCorpusConfigOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getCorpusConfigOptions,
      "getCorpusConfigOptions cannot be null");
    String[] pathSegments = { "v1/corpora" };
    String[] pathParameters = { getCorpusConfigOptions.corpus() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("insights_for_medical_literature_service", "v1", "getCorpusConfig");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", this.version);
    if (getCorpusConfigOptions.verbose() != null) {
      builder.query("verbose", String.valueOf(getCorpusConfigOptions.verbose()));
    }
    ResponseConverter<CorporaConfig> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<CorporaConfig>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieves statistics for a corpus.
   *
   * The response returns internal statistics for the corpus.
   *
   * @param getStatisticsOptions the {@link GetStatisticsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link StatisticsModel}
   */
  public ServiceCall<StatisticsModel> getStatistics(GetStatisticsOptions getStatisticsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getStatisticsOptions,
      "getStatisticsOptions cannot be null");
    String[] pathSegments = { "v1/corpora", "statistics" };
    String[] pathParameters = { getStatisticsOptions.corpus() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("insights_for_medical_literature_service", "v1", "getStatistics");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", this.version);
    ResponseConverter<StatisticsModel> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<StatisticsModel>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get status of service.
   *
   * @param getServiceStatusOptions the {@link GetServiceStatusOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ServiceStatus}
   */
  public ServiceCall<ServiceStatus> getServiceStatus(GetServiceStatusOptions getServiceStatusOptions) {
    String[] pathSegments = { "v1/status" };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("insights_for_medical_literature_service", "v1", "getServiceStatus");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    if (getServiceStatusOptions != null) {
      if (getServiceStatusOptions.accept() != null) {
        builder.header("Accept", getServiceStatusOptions.accept());
      }
      if (getServiceStatusOptions.format() != null) {
        builder.query("format", getServiceStatusOptions.format());
      }
      if (getServiceStatusOptions.livenessCheck() != null) {
        builder.query("liveness_check", getServiceStatusOptions.livenessCheck());
      }
    }
    ResponseConverter<ServiceStatus> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ServiceStatus>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get status of service.
   *
   * @return a {@link ServiceCall} with a result of type {@link ServiceStatus}
   */
  public ServiceCall<ServiceStatus> getServiceStatus() {
    return getServiceStatus(null);
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
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("insights_for_medical_literature_service", "v1", "getHealthCheckStatus");
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

  /**
   * Search for concepts, documents, and authors.
   *
   * Features include:&lt;ul&gt;&lt;li&gt;Concept search&lt;/li&gt;&lt;li&gt;Keyword
   * search&lt;/li&gt;&lt;li&gt;Attributes search&lt;/li&gt;&lt;li&gt;Attributes typeahead&lt;/li&gt;&lt;li&gt;Regular
   * expressions&lt;/li&gt;&lt;li&gt;Find passages&lt;/li&gt;&lt;li&gt;Selecting authors&lt;/li&gt;&lt;li&gt;Selecting
   * providers&lt;/li&gt;&lt;li&gt;Date ranges: publish
   * date&lt;/li&gt;&lt;li&gt;Pagination&lt;/li&gt;&lt;li&gt;Aggregation: authors, concepts, and
   * documents&lt;/li&gt;&lt;li&gt;Document date histogram&lt;/li&gt;&lt;/ul&gt;.
   *
   * @param searchOptions the {@link SearchOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link SearchModel}
   */
  public ServiceCall<SearchModel> search(SearchOptions searchOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(searchOptions,
      "searchOptions cannot be null");
    String[] pathSegments = { "v1/corpora", "search" };
    String[] pathParameters = { searchOptions.corpus() };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("insights_for_medical_literature_service", "v1", "search");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", this.version);
    if (searchOptions.verbose() != null) {
      builder.query("verbose", String.valueOf(searchOptions.verbose()));
    }
    final JsonObject contentJson = new JsonObject();
    if (searchOptions.query() != null) {
    	contentJson.add("query", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(searchOptions.query()));
    }
    contentJson.add("returns", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(searchOptions.returns()));
//    builder.bodyContent(com.ibm.cloud.sdk.core.util.GsonSingleton.getGsonWithoutPrettyPrinting().toJson(contentJson), "application/json");
    builder.bodyContent(com.ibm.cloud.sdk.core.util.GsonSingleton.getGsonWithoutPrettyPrinting().toJson(contentJson), "application/json");
    ResponseConverter<SearchModel> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<SearchModel>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieves a list of metadata fields defined in the corpus.
   *
   * The response returns a list of metadata field names that can be used by the POST search API.
   *
   * @param getFieldsOptions the {@link GetFieldsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link MetadataModel}
   */
  public ServiceCall<MetadataModel> getFields(GetFieldsOptions getFieldsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getFieldsOptions,
      "getFieldsOptions cannot be null");
    String[] pathSegments = { "v1/corpora", "search/metadata" };
    String[] pathParameters = { getFieldsOptions.corpus() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("insights_for_medical_literature_service", "v1", "getFields");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", this.version);
    ResponseConverter<MetadataModel> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<MetadataModel>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Find concepts matching the specified query string.
   *
   * Searches concepts mentioned in the corpus looking for matches on the query string field. The comparison is not case
   * sensitive. The main use of this method is to build query boxes that offer auto-complete, to allow users to select
   * valid concepts.
   *
   * @param typeaheadOptions the {@link TypeaheadOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ConceptListModel}
   */
  public ServiceCall<ConceptListModel> typeahead(TypeaheadOptions typeaheadOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(typeaheadOptions,
      "typeaheadOptions cannot be null");
    String[] pathSegments = { "v1/corpora", "search/typeahead" };
    String[] pathParameters = { typeaheadOptions.corpus() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("insights_for_medical_literature_service", "v1", "typeahead");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", this.version);
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
    ResponseConverter<ConceptListModel> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ConceptListModel>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieves information for concepts mentioned in this corpus.
   *
   * The response returns concepts mentioned in this corpus.  The returned concepts may be selected by CUI, preferred
   * name, suface forms and attribute name.  All selected concepts are returned.
   *
   * @param getConceptsOptions the {@link GetConceptsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ConceptListModel}
   */
  public ServiceCall<ConceptListModel> getConcepts(GetConceptsOptions getConceptsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getConceptsOptions,
      "getConceptsOptions cannot be null");
    String[] pathSegments = { "v1/corpora", "concepts" };
    String[] pathParameters = { getConceptsOptions.corpus() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("insights_for_medical_literature_service", "v1", "getConcepts");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", this.version);
    if (getConceptsOptions.cuis() != null) {
      builder.query("cuis", RequestUtils.join(getConceptsOptions.cuis(), ","));
    }
    if (getConceptsOptions.preferredNames() != null) {
      builder.query("preferred_names", RequestUtils.join(getConceptsOptions.preferredNames(), ","));
    }
    if (getConceptsOptions.surfaceForms() != null) {
      builder.query("surface_forms", RequestUtils.join(getConceptsOptions.surfaceForms(), ","));
    }
    if (getConceptsOptions.attributes() != null) {
      builder.query("attributes", RequestUtils.join(getConceptsOptions.attributes(), ","));
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
    ResponseConverter<ConceptListModel> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ConceptListModel>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Add cartridge artifact.
   *
   * @param addArtifactOptions the {@link AddArtifactOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> addArtifact(AddArtifactOptions addArtifactOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(addArtifactOptions,
      "addArtifactOptions cannot be null");
    String[] pathSegments = { "v1/corpora", "concepts/definitions" };
    String[] pathParameters = { addArtifactOptions.corpus() };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("insights_for_medical_literature_service", "v1", "addArtifact");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.query("version", this.version);
    final JsonObject contentJson = new JsonObject();
    if (addArtifactOptions.dictionaryEntry() != null) {
      contentJson.add("dictionaryEntry", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(addArtifactOptions.dictionaryEntry()));
    }
    if (addArtifactOptions.attributeEntry() != null) {
      contentJson.add("attributeEntry", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(addArtifactOptions.attributeEntry()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieve information for a concept.
   *
   * The followning fields may be retrieved: &lt;ul&gt;&lt;li&gt;Preferred name&lt;/li&gt;&lt;li&gt;Semantic
   * types&lt;/li&gt;&lt;li&gt;Surface forms - Ontology Dictionary names for this concept&lt;/li&gt;&lt;li&gt;Definition
   * - Concept definition (if available)&lt;/li&gt;&lt;li&gt;Related Concepts info&lt;/li&gt;&lt;/ul&gt;&lt;P&gt;The
   * default is to return all fields.  Individual fields may be selected using the '_fields' query parameter.
   *
   * @param getCuiInfoOptions the {@link GetCuiInfoOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ConceptInfoModel}
   */
  public ServiceCall<ConceptInfoModel> getCuiInfo(GetCuiInfoOptions getCuiInfoOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getCuiInfoOptions,
      "getCuiInfoOptions cannot be null");
    String[] pathSegments = { "v1/corpora", "concepts" };
    String[] pathParameters = { getCuiInfoOptions.corpus(), getCuiInfoOptions.nameOrId() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("insights_for_medical_literature_service", "v1", "getCuiInfo");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", this.version);
    if (getCuiInfoOptions.ontology() != null) {
      builder.query("ontology", getCuiInfoOptions.ontology());
    }
    if (getCuiInfoOptions.fields() != null) {
      builder.query("_fields", getCuiInfoOptions.fields());
    }
    if (getCuiInfoOptions.treeLayout() != null) {
      builder.query("tree_layout", String.valueOf(getCuiInfoOptions.treeLayout()));
    }
    ResponseConverter<ConceptInfoModel> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ConceptInfoModel>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieves a count of the number of times a concept is mentioned in the corpus.
   *
   * The response returns the number of times a concept is mentioned (hit count) in the corpus.
   *
   * @param getHitCountOptions the {@link GetHitCountOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link HitCount}
   */
  public ServiceCall<HitCount> getHitCount(GetHitCountOptions getHitCountOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getHitCountOptions,
      "getHitCountOptions cannot be null");
    String[] pathSegments = { "v1/corpora", "concepts", "hit_count" };
    String[] pathParameters = { getHitCountOptions.corpus(), getHitCountOptions.nameOrId() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("insights_for_medical_literature_service", "v1", "getHitCount");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", this.version);
    if (getHitCountOptions.ontology() != null) {
      builder.query("ontology", getHitCountOptions.ontology());
    }
    ResponseConverter<HitCount> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<HitCount>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieve concepts related to a concept.
   *
   * Returns a list of related concepts mentioned in the specified corpus. The following relationships are suppored:
   * &lt;ul&gt;&lt;li&gt;&lt;b&gt;children&lt;/b&gt; child concepts&lt;/li&gt;&lt;li&gt;&lt;b&gt;parents&lt;/b&gt;
   * parent concepts&lt;/li&gt;&lt;li&gt;&lt;b&gt;siblings&lt;/b&gt; sibling
   * concepts&lt;/li&gt;&lt;li&gt;&lt;b&gt;synonyms&lt;/b&gt; synonym concepts&lt;/li&gt;&lt;li&gt;&lt;b&gt;qualified
   * by&lt;/b&gt; qualified by concepts&lt;/li&gt;&lt;li&gt;&lt;b&gt;broader&lt;/b&gt; broader
   * concepts&lt;/li&gt;&lt;li&gt;&lt;b&gt;narrower&lt;/b&gt; narrower
   * concepts&lt;/li&gt;&lt;li&gt;&lt;b&gt;other&lt;/b&gt; other than synonyms, narrower or
   * broader&lt;/li&gt;&lt;li&gt;&lt;b&gt;related&lt;/b&gt; related and posibly synonymous
   * concepts&lt;/li&gt;&lt;/ul&gt;&lt;p&gt;If the corpus path parameter can be set to 'umls' to look up relationship in
   * the entire UMLS dictionary.  Otherwise, an actual corpus name may be specified to limit the output to only those
   * concepts mentioned in a specific corpus.
   *
   * @param getRelatedConceptsOptions the {@link GetRelatedConceptsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link RelatedConceptsModel}
   */
  public ServiceCall<RelatedConceptsModel> getRelatedConcepts(GetRelatedConceptsOptions getRelatedConceptsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getRelatedConceptsOptions,
      "getRelatedConceptsOptions cannot be null");
    String[] pathSegments = { "v1/corpora", "concepts", "related_concepts" };
    String[] pathParameters = { getRelatedConceptsOptions.corpus(), getRelatedConceptsOptions.nameOrId() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("insights_for_medical_literature_service", "v1", "getRelatedConcepts");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("relationship", getRelatedConceptsOptions.relationship());
    builder.query("version", this.version);
    if (getRelatedConceptsOptions.ontology() != null) {
      builder.query("ontology", getRelatedConceptsOptions.ontology());
    }
    if (getRelatedConceptsOptions.relationshipAttributes() != null) {
      builder.query("relationship_attributes", RequestUtils.join(getRelatedConceptsOptions.relationshipAttributes(), ","));
    }
    if (getRelatedConceptsOptions.sources() != null) {
      builder.query("sources", RequestUtils.join(getRelatedConceptsOptions.sources(), ","));
    }
    if (getRelatedConceptsOptions.recursive() != null) {
      builder.query("recursive", String.valueOf(getRelatedConceptsOptions.recursive()));
    }
    if (getRelatedConceptsOptions.treeLayout() != null) {
      builder.query("tree_layout", String.valueOf(getRelatedConceptsOptions.treeLayout()));
    }
    if (getRelatedConceptsOptions.maxDepth() != null) {
      builder.query("max_depth", String.valueOf(getRelatedConceptsOptions.maxDepth()));
    }
    ResponseConverter<RelatedConceptsModel> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<RelatedConceptsModel>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Find similar concepts.
   *
   * The response returns a list of similar concepts.   All ontologies defined in the corpora are searched.  Similarity
   * is determined by checking for overlapping surface forms.  The results are sorted in descending order by hit count.
   *
   * @param getSimilarConceptsOptions the {@link GetSimilarConceptsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ConceptListModel}
   */
  public ServiceCall<ConceptListModel> getSimilarConcepts(GetSimilarConceptsOptions getSimilarConceptsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getSimilarConceptsOptions,
      "getSimilarConceptsOptions cannot be null");
    String[] pathSegments = { "v1/corpora", "concepts", "similar_concepts" };
    String[] pathParameters = { getSimilarConceptsOptions.corpus(), getSimilarConceptsOptions.nameOrId() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("insights_for_medical_literature_service", "v1", "getSimilarConcepts");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", this.version);
    builder.query("return_ontologies", getSimilarConceptsOptions.returnOntologies());
    if (getSimilarConceptsOptions.ontology() != null) {
      builder.query("ontology", getSimilarConceptsOptions.ontology());
    }
    if (getSimilarConceptsOptions.limit() != null) {
      builder.query("_limit", String.valueOf(getSimilarConceptsOptions.limit()));
    }
    ResponseConverter<ConceptListModel> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ConceptListModel>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Tokenize the input text into concepts.
   *
   * The response returns a list of tokenized concepts for the specified ontologies.
   *
   * @param tokenizeOptions the {@link TokenizeOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link CommonDataModel}
   */
  public ServiceCall<CommonDataModel> tokenize(TokenizeOptions tokenizeOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(tokenizeOptions,
      "tokenizeOptions cannot be null");
    String[] pathSegments = { "v1/corpora", "debug/analyze" };
    String[] pathParameters = { tokenizeOptions.corpus(), tokenizeOptions.flow() };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("insights_for_medical_literature_service", "v1", "tokenize");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", this.version);
    if (tokenizeOptions.ontologies() != null) {
      builder.query("ontologies", RequestUtils.join(tokenizeOptions.ontologies(), ","));
    }
    if (tokenizeOptions.maxWords() != null) {
      builder.query("max_words", String.valueOf(tokenizeOptions.maxWords()));
    }
    builder.bodyContent(com.ibm.cloud.sdk.core.util.GsonSingleton.getGsonWithoutPrettyPrinting().toJson(tokenizeOptions.body()), "application/json");
    ResponseConverter<CommonDataModel> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<CommonDataModel>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

}
