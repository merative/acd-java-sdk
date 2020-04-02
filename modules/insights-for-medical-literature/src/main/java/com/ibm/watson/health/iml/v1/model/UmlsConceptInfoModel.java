/*
 * Copyright 2018, 2020 IBM Corp. All Rights Reserved.
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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * UmlsConceptInfoModel.
 */
public class UmlsConceptInfoModel extends GenericModel {

  private String cui;
  private String ontology;
  private Object preferredName;
  private List<String> semanticTypes;
  private List<String> surfaceForms;
  private List<String> typeahead;
  private List<String> variants;
  private String definition;

  /**
   * Gets the cui.
   *
   * @return the cui
   */
  public String getCui() {
    return cui;
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
   * Gets the preferredName.
   *
   * @return the preferredName
   */
  public Object getPreferredName() {
    return preferredName;
  }

  /**
   * Gets the semanticTypes.
   *
   * @return the semanticTypes
   */
  public List<String> getSemanticTypes() {
    return semanticTypes;
  }

  /**
   * Gets the surfaceForms.
   *
   * @return the surfaceForms
   */
  public List<String> getSurfaceForms() {
    return surfaceForms;
  }

  /**
   * Gets the typeahead.
   *
   * @return the typeahead
   */
  public List<String> getTypeahead() {
    return typeahead;
  }

  /**
   * Gets the variants.
   *
   * @return the variants
   */
  public List<String> getVariants() {
    return variants;
  }

  /**
   * Gets the definition.
   *
   * @return the definition
   */
  public String getDefinition() {
    return definition;
  }
}

