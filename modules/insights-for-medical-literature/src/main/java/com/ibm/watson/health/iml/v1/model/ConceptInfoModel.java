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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Model representing ontology annotations.
 */
public class ConceptInfoModel extends GenericModel {

  protected String cui;
  protected String ontology;
  protected Object preferredName;
  protected List<String> semanticTypes;
  protected List<String> surfaceForms;
  protected String definition;
  protected Boolean hasParents;
  protected Boolean hasChildren;
  protected Boolean hasSiblings;

  /**
   * Gets the cui.
   *
   * Ontology provided unique identifier for artifact.
   *
   * @return the cui
   */
  public String getCui() {
    return cui;
  }

  /**
   * Gets the ontology.
   *
   * Source onology of artifact.
   *
   * @return the ontology
   */
  public String getOntology() {
    return ontology;
  }

  /**
   * Gets the preferredName.
   *
   * Ontology defined normalized name for artifact.
   *
   * @return the preferredName
   */
  public Object getPreferredName() {
    return preferredName;
  }

  /**
   * Gets the semanticTypes.
   *
   * Ontology defined semanic types for artifact.
   *
   * @return the semanticTypes
   */
  public List<String> getSemanticTypes() {
    return semanticTypes;
  }

  /**
   * Gets the surfaceForms.
   *
   * Ontology defined synonyms for artifact.
   *
   * @return the surfaceForms
   */
  public List<String> getSurfaceForms() {
    return surfaceForms;
  }

  /**
   * Gets the definition.
   *
   * Ontology provided definition for artifact.
   *
   * @return the definition
   */
  public String getDefinition() {
    return definition;
  }

  /**
   * Gets the hasParents.
   *
   * Whether the artifact has parent artifacts in the ontology.
   *
   * @return the hasParents
   */
  public Boolean isHasParents() {
    return hasParents;
  }

  /**
   * Gets the hasChildren.
   *
   * Whether the artifact has child artifacts in the ontology.
   *
   * @return the hasChildren
   */
  public Boolean isHasChildren() {
    return hasChildren;
  }

  /**
   * Gets the hasSiblings.
   *
   * Whether the artifact has sibling artifacts in the ontology.
   *
   * @return the hasSiblings
   */
  public Boolean isHasSiblings() {
    return hasSiblings;
  }
}

