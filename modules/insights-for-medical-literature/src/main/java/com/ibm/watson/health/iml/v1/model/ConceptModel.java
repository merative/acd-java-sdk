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
import java.util.Map;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * ConceptModel.
 */
public class ConceptModel extends GenericModel {

  private String cui;
  private String ontology;
  private Map<String, Long> corpora;
  private String preferredName;
  private String alternativeName;
  private String semanticType;
  private Long rank;
  private Long hitCount;
  private UmlsRelationshipCountsModel parents;
  private UmlsRelationshipCountsModel children;
  private UmlsRelationshipCountsModel siblings;
  private UmlsRelationshipCountsModel related;
  private List<String> surfaceForms;

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
   * Gets the corpora.
   *
   * @return the corpora
   */
  public Map<String, Long> getCorpora() {
    return corpora;
  }

  /**
   * Gets the preferredName.
   *
   * @return the preferredName
   */
  public String getPreferredName() {
    return preferredName;
  }

  /**
   * Gets the alternativeName.
   *
   * @return the alternativeName
   */
  public String getAlternativeName() {
    return alternativeName;
  }

  /**
   * Gets the type.
   *
   * @return the type
   */
  public String getType() {
    return semanticType;
  }

  /**
   * Gets the rank.
   *
   * @return the rank
   */
  public Long getRank() {
    return rank;
  }

  /**
   * Gets the hitCount.
   *
   * @return the hitCount
   */
  public Long getHitCount() {
    return hitCount;
  }

  /**
   * Gets the parents.
   *
   * @return the parents
   */
  public UmlsRelationshipCountsModel getParents() {
    return parents;
  }

  /**
   * Gets the children.
   *
   * @return the children
   */
  public UmlsRelationshipCountsModel getChildren() {
    return children;
  }

  /**
   * Gets the siblings.
   *
   * @return the siblings
   */
  public UmlsRelationshipCountsModel getSiblings() {
    return siblings;
  }

  /**
   * Gets the related.
   *
   * @return the related
   */
  public UmlsRelationshipCountsModel getRelated() {
    return related;
  }

  /**
   * Gets the surfaceForms.
   *
   * @return the surfaceForms
   */
  public List<String> getSurfaceForms() {
    return surfaceForms;
  }
}

