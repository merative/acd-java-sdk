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
 * Concept.
 */
public class Concept extends GenericModel {

  private String ontology;
  private String cui;
  private String preferredName;
  private String alternativeName;
  private String semanticType;
  private Long count;
  private Long hitCount;
  private Double idf;
  private Float score;
  private HitCount parents;
  private HitCount children;
  private HitCount siblings;
  private HitCount related;
  private List<String> documentIds;
  private String dataType;
  private String unit;
  private String operator;
  private String minValue;
  private String maxValue;

  /**
   * Gets the ontology.
   *
   * @return the ontology
   */
  public String getOntology() {
    return ontology;
  }

  /**
   * Gets the id.
   *
   * @return the id
   */
  public String getId() {
    return cui;
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
   * Gets the count.
   *
   * @return the count
   */
  public Long getCount() {
    return count;
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
   * Gets the idf.
   *
   * @return the idf
   */
  public Double getIdf() {
    return idf;
  }

  /**
   * Gets the score.
   *
   * @return the score
   */
  public Float getScore() {
    return score;
  }

  /**
   * Gets the parents.
   *
   * @return the parents
   */
  public HitCount getParents() {
    return parents;
  }

  /**
   * Gets the children.
   *
   * @return the children
   */
  public HitCount getChildren() {
    return children;
  }

  /**
   * Gets the siblings.
   *
   * @return the siblings
   */
  public HitCount getSiblings() {
    return siblings;
  }

  /**
   * Gets the related.
   *
   * @return the related
   */
  public HitCount getRelated() {
    return related;
  }

  /**
   * Gets the documentIds.
   *
   * @return the documentIds
   */
  public List<String> getDocumentIds() {
    return documentIds;
  }

  /**
   * Gets the dataType.
   *
   * @return the dataType
   */
  public String getDataType() {
    return dataType;
  }

  /**
   * Gets the unit.
   *
   * @return the unit
   */
  public String getUnit() {
    return unit;
  }

  /**
   * Gets the operator.
   *
   * @return the operator
   */
  public String getOperator() {
    return operator;
  }

  /**
   * Gets the minValue.
   *
   * @return the minValue
   */
  public String getMinValue() {
    return minValue;
  }

  /**
   * Gets the maxValue.
   *
   * @return the maxValue
   */
  public String getMaxValue() {
    return maxValue;
  }
}

