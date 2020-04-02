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

import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Typeahead.
 */
public class Typeahead extends GenericModel {

  private String ontology;
  private String query;
  private List<String> types;
  private Long limit;
  private Boolean noDuplicates;

  /**
   * Gets the ontology.
   *
   * @return the ontology
   */
  public String getOntology() {
    return ontology;
  }

  /**
   * Gets the query.
   *
   * @return the query
   */
  public String getQuery() {
    return query;
  }

  /**
   * Gets the types.
   *
   * @return the types
   */
  public List<String> getTypes() {
    return types;
  }

  /**
   * Gets the limit.
   *
   * @return the limit
   */
  public Long getLimit() {
    return limit;
  }

  /**
   * Gets the noDuplicates.
   *
   * @return the noDuplicates
   */
  public Boolean isNoDuplicates() {
    return noDuplicates;
  }

  /**
   * Sets the ontology.
   *
   * @param ontology the new ontology
   */
  public void setOntology(final String ontology) {
    this.ontology = ontology;
  }

  /**
   * Sets the query.
   *
   * @param query the new query
   */
  public void setQuery(final String query) {
    this.query = query;
  }

  /**
   * Sets the types.
   *
   * @param types the new types
   */
  public void setTypes(final List<String> types) {
    this.types = types;
  }

  /**
   * Sets the limit.
   *
   * @param limit the new limit
   */
  public void setLimit(final long limit) {
    this.limit = limit;
  }

  /**
   * Sets the noDuplicates.
   *
   * @param noDuplicates the new noDuplicates
   */
  public void setNoDuplicates(final Boolean noDuplicates) {
    this.noDuplicates = noDuplicates;
  }
}

