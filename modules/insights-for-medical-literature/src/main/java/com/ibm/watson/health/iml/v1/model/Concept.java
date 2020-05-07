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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Object reprensting an ontology artifact.
 */
public class Concept extends GenericModel {

  protected String ontology;
  protected String cui;
  protected String preferredName;
  protected String alternativeName;
  protected String semanticType;
  protected Long count;
  protected Long hitCount;
  protected Float score;
  protected Count parents;
  protected Count children;
  protected Count siblings;
  protected Count related;
  protected List<String> documentIds;
  protected String dataType;
  protected String unit;
  protected String operator;
  protected String minValue;
  protected String maxValue;
  protected String vocab;
  @SerializedName("properties")
  protected List<String> xProperties;

  /**
   * Gets the ontology.
   *
   * Ontology for artifact in search results.
   *
   * @return the ontology
   */
  public String getOntology() {
    return ontology;
  }

  /**
   * Gets the cui.
   *
   * Unique identifier for ontolgoy artifact in search results.
   *
   * @return the cui
   */
  public String getCui() {
    return cui;
  }

  /**
   * Gets the preferredName.
   *
   * Ontology defined semantic type for artifact in search results.
   *
   * @return the preferredName
   */
  public String getPreferredName() {
    return preferredName;
  }

  /**
   * Gets the alternativeName.
   *
   * Ontology defined normalized name for artifact in search results.
   *
   * @return the alternativeName
   */
  public String getAlternativeName() {
    return alternativeName;
  }

  /**
   * Gets the semanticType.
   *
   * Ontology defined alternative name for artifact in search results.
   *
   * @return the semanticType
   */
  public String getSemanticType() {
    return semanticType;
  }

  /**
   * Gets the count.
   *
   * Corpus frequency of artifact.
   *
   * @return the count
   */
  public Long getCount() {
    return count;
  }

  /**
   * Gets the hitCount.
   *
   * Corpus frequency of artifact.
   *
   * @return the hitCount
   */
  public Long getHitCount() {
    return hitCount;
  }

  /**
   * Gets the score.
   *
   * Relevancy score of artifact in search results.
   *
   * @return the score
   */
  public Float getScore() {
    return score;
  }

  /**
   * Gets the parents.
   *
   * Corpus frequency count.
   *
   * @return the parents
   */
  public Count getParents() {
    return parents;
  }

  /**
   * Gets the children.
   *
   * Corpus frequency count.
   *
   * @return the children
   */
  public Count getChildren() {
    return children;
  }

  /**
   * Gets the siblings.
   *
   * Corpus frequency count.
   *
   * @return the siblings
   */
  public Count getSiblings() {
    return siblings;
  }

  /**
   * Gets the related.
   *
   * Corpus frequency count.
   *
   * @return the related
   */
  public Count getRelated() {
    return related;
  }

  /**
   * Gets the documentIds.
   *
   * Document identifiers for artifacts in search results.
   *
   * @return the documentIds
   */
  public List<String> getDocumentIds() {
    return documentIds;
  }

  /**
   * Gets the dataType.
   *
   * attribute data type for artifact in search results.
   *
   * @return the dataType
   */
  public String getDataType() {
    return dataType;
  }

  /**
   * Gets the unit.
   *
   * Attribute value unit for artifact.
   *
   * @return the unit
   */
  public String getUnit() {
    return unit;
  }

  /**
   * Gets the operator.
   *
   * Attribute value operator for artifact.
   *
   * @return the operator
   */
  public String getOperator() {
    return operator;
  }

  /**
   * Gets the minValue.
   *
   * Minimum value for attribute artifact.
   *
   * @return the minValue
   */
  public String getMinValue() {
    return minValue;
  }

  /**
   * Gets the maxValue.
   *
   * Maximum value for attribute artifact.
   *
   * @return the maxValue
   */
  public String getMaxValue() {
    return maxValue;
  }

  /**
   * Gets the vocab.
   *
   * Source vocabulary of arttifact.
   *
   * @return the vocab
   */
  public String getVocab() {
    return vocab;
  }

  /**
   * Gets the xProperties.
   *
   * Artifact properties.
   *
   * @return the xProperties
   */
  public List<String> getXProperties() {
    return xProperties;
  }
}

