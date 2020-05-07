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
package com.ibm.watson.health.iml.v1.model;

import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Model for search criteria.
 */
public class SearchModel extends GenericModel {

  protected String href;
  protected Long pageNumber;
  @SerializedName("get_limit")
  protected Long getLimit;
  protected Long totalDocumentCount;
  protected List<Concept> concepts;
  protected List<String> types;
  protected List<Attribute> attributes;
  protected List<Concept> values;
  protected Map<String, RangeModel> ranges;
  protected List<Concept> typeahead;
  protected Map<String, List<AggregationModel>> aggregations;
  protected Map<String, List<HistogramData>> dateHistograms;
  protected List<Qualifer> qualifiers;
  protected Backend backend;
  protected Map<String, Object> expandedQuery;
  protected BooleanOperands parsedBoolExpression;
  protected Map<String, Long> conceptsExist;
  protected String cursorId;
  protected List<String> vocabs;
  protected Map<String, CommonDataModel> annotations;
  protected MetadataFields metadata;
  protected List<RankedDocument> documents;
  protected List<SearchModel> subQueries;

  /**
   * Gets the href.
   *
   * Link.
   *
   * @return the href
   */
  public String getHref() {
    return href;
  }

  /**
   * Gets the pageNumber.
   *
   * Page number.
   *
   * @return the pageNumber
   */
  public Long getPageNumber() {
    return pageNumber;
  }

  /**
   * Gets the getLimit.
   *
   * Search result limit.
   *
   * @return the getLimit
   */
  public Long getGetLimit() {
    return getLimit;
  }

  /**
   * Gets the totalDocumentCount.
   *
   * Total number of search matches in the corpus.
   *
   * @return the totalDocumentCount
   */
  public Long getTotalDocumentCount() {
    return totalDocumentCount;
  }

  /**
   * Gets the concepts.
   *
   * Ontology artifact results from search.
   *
   * @return the concepts
   */
  public List<Concept> getConcepts() {
    return concepts;
  }

  /**
   * Gets the types.
   *
   * Ontology semantic types.
   *
   * @return the types
   */
  public List<String> getTypes() {
    return types;
  }

  /**
   * Gets the attributes.
   *
   * Attribute artifact results from search.
   *
   * @return the attributes
   */
  public List<Attribute> getAttributes() {
    return attributes;
  }

  /**
   * Gets the values.
   *
   * Attribute artifact value results from search.
   *
   * @return the values
   */
  public List<Concept> getValues() {
    return values;
  }

  /**
   * Gets the ranges.
   *
   * Attribute value range results from search.
   *
   * @return the ranges
   */
  public Map<String, RangeModel> getRanges() {
    return ranges;
  }

  /**
   * Gets the typeahead.
   *
   * Type-ahead suggestion results in search.
   *
   * @return the typeahead
   */
  public List<Concept> getTypeahead() {
    return typeahead;
  }

  /**
   * Gets the aggregations.
   *
   * Aggregate result targets in search.
   *
   * @return the aggregations
   */
  public Map<String, List<AggregationModel>> getAggregations() {
    return aggregations;
  }

  /**
   * Gets the dateHistograms.
   *
   * Date range of results from search.
   *
   * @return the dateHistograms
   */
  public Map<String, List<HistogramData>> getDateHistograms() {
    return dateHistograms;
  }

  /**
   * Gets the qualifiers.
   *
   * Attribute qualifier results from search.
   *
   * @return the qualifiers
   */
  public List<Qualifer> getQualifiers() {
    return qualifiers;
  }

  /**
   * Gets the backend.
   *
   * Object representing repository response.
   *
   * @return the backend
   */
  public Backend getBackend() {
    return backend;
  }

  /**
   * Gets the expandedQuery.
   *
   * Search expression that includes all levels of criteria expression.
   *
   * @return the expandedQuery
   */
  public Map<String, Object> getExpandedQuery() {
    return expandedQuery;
  }

  /**
   * Gets the parsedBoolExpression.
   *
   * Object representingn boolean operands search criteria.
   *
   * @return the parsedBoolExpression
   */
  public BooleanOperands getParsedBoolExpression() {
    return parsedBoolExpression;
  }

  /**
   * Gets the conceptsExist.
   *
   * Whether ontolgoy artifacts were provided in search conditions.
   *
   * @return the conceptsExist
   */
  public Map<String, Long> getConceptsExist() {
    return conceptsExist;
  }

  /**
   * Gets the cursorId.
   *
   * @return the cursorId
   */
  public String getCursorId() {
    return cursorId;
  }

  /**
   * Gets the vocabs.
   *
   * @return the vocabs
   */
  public List<String> getVocabs() {
    return vocabs;
  }

  /**
   * Gets the annotations.
   *
   * Annotations returned for the document.
   *
   * @return the annotations
   */
  public Map<String, CommonDataModel> getAnnotations() {
    return annotations;
  }

  /**
   * Gets the metadata.
   *
   * @return the metadata
   */
  public MetadataFields getMetadata() {
    return metadata;
  }

  /**
   * Gets the documents.
   *
   * Documents returned from search.
   *
   * @return the documents
   */
  public List<RankedDocument> getDocuments() {
    return documents;
  }

  /**
   * Gets the subQueries.
   *
   * @return the subQueries
   */
  public List<SearchModel> getSubQueries() {
    return subQueries;
  }
}

