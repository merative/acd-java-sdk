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
package com.ibm.watson.health.iml.v1.model;

import java.util.Map;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * ReturnsModel.
 */
public class ReturnsModel extends GenericModel {

  private Documents documents;
  private Concepts concepts;
  private Passages passages;
  private Attributes attributes;
  private Values values;
  private Ranges ranges;
  private Types types;
  private Typeahead typeahead;
  private Map<String, DateHistograms> dateHistograms;
  private Map<String, Aggregations> aggregations;

  /**
   * Returns model for a query.
   */
  public ReturnsModel() {

  }
  /**
   * Gets the documents.
   *
   * @return the documents
   */
  public Documents getDocuments() {
    return documents;
  }

  /**
   * Gets the concepts.
   *
   * @return the concepts
   */
  public Concepts getConcepts() {
    return concepts;
  }

  /**
   * Gets the passages.
   *
   * @return the passages
   */
  public Passages getPassages() {
    return passages;
  }

  /**
   * Gets the attributes.
   *
   * @return the attributes
   */
  public Attributes getAttributes() {
    return attributes;
  }

  /**
   * Gets the values.
   *
   * @return the values
   */
  public Values getValues() {
    return values;
  }

  /**
   * Gets the ranges.
   *
   * @return the ranges
   */
  public Ranges getRanges() {
    return ranges;
  }

  /**
   * Gets the types.
   *
   * @return the types
   */
  public Types getTypes() {
    return types;
  }

  /**
   * Gets the typeahead.
   *
   * @return the typeahead
   */
  public Typeahead getTypeahead() {
    return typeahead;
  }

  /**
   * Gets the dateHistograms.
   *
   * @return the dateHistograms
   */
  public Map<String, DateHistograms> getDateHistograms() {
    return dateHistograms;
  }

  /**
   * Gets the aggregations.
   *
   * @return the aggregations
   */
  public Map<String, Aggregations> getAggregations() {
    return aggregations;
  }

  /**
   * Sets the documents.
   *
   * @param documents the new documents
   */
  public void setDocuments(final Documents documents) {
    this.documents = documents;
  }

  /**
   * Sets the concepts.
   *
   * @param concepts the new concepts
   */
  public void setConcepts(final Concepts concepts) {
    this.concepts = concepts;
  }

  /**
   * Sets the passages.
   *
   * @param passages the new passages
   */
  public void setPassages(final Passages passages) {
    this.passages = passages;
  }

  /**
   * Sets the attributes.
   *
   * @param attributes the new attributes
   */
  public void setAttributes(final Attributes attributes) {
    this.attributes = attributes;
  }

  /**
   * Sets the values.
   *
   * @param values the new values
   */
  public void setValues(final Values values) {
    this.values = values;
  }

  /**
   * Sets the ranges.
   *
   * @param ranges the new ranges
   */
  public void setRanges(final Ranges ranges) {
    this.ranges = ranges;
  }

  /**
   * Sets the types.
   *
   * @param types the new types
   */
  public void setTypes(final Types types) {
    this.types = types;
  }

  /**
   * Sets the typeahead.
   *
   * @param typeahead the new typeahead
   */
  public void setTypeahead(final Typeahead typeahead) {
    this.typeahead = typeahead;
  }

  /**
   * Sets the dateHistograms.
   *
   * @param dateHistograms the new dateHistograms
   */
  public void setDateHistograms(final Map<String, DateHistograms> dateHistograms) {
    this.dateHistograms = dateHistograms;
  }

  /**
   * Sets the aggregations.
   *
   * @param aggregations the new aggregations
   */
  public void setAggregations(final Map<String, Aggregations> aggregations) {
    this.aggregations = aggregations;
  }
}

