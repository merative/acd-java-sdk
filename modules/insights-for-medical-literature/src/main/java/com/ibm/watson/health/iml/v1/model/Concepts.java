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
 * Concepts.
 */
public class Concepts extends GenericModel {

  private String ontology;
  private Long limit;
  private String scope;
  private List<String> types;
  private String mode;

  public Concepts() {

  }
  /**
   * Gets the ontology.
   *
   * @return the ontology
   */
  public String getOntology() {
    return ontology;
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
   * Gets the scope.
   *
   * @return the scope
   */
  public String getScope() {
    return scope;
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
   * Gets the mode.
   *
   * @return the mode
   */
  public String getMode() {
    return mode;
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
   * Sets the limit.
   *
   * @param limit the new limit
   */
  public void setLimit(final long limit) {
    this.limit = limit;
  }

  /**
   * Sets the scope.
   *
   * @param scope the new scope
   */
  public void setScope(final String scope) {
    this.scope = scope;
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
   * Sets the mode.
   *
   * @param mode the new mode
   */
  public void setMode(final String mode) {
    this.mode = mode;
  }
}

