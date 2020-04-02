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
 * AnnotationModel.
 */
public class AnnotationModel extends GenericModel {

  private String source;
  private String ontology;
  private String section;
  private String preferredName;
  private String cui;
  private String attributeId;
  private String type;
  private Boolean negated;
  private Boolean hypothetical;
  private String unit;
  private String minValue;
  private String maxValue;
  private String operator;
  private Long begin;
  private Long end;
  private Float score;
  private String coveredText;
  private Map<String, String> features;

  /**
   * Gets the ontology.
   *
   * @return the ontology
   */
  public String getOntology() {
    return ontology;
  }

  /**
   * Gets the ontology.
   *
   * @return the ontology
   */
  public String getSource() {
    return source;
  }

  /**
   * Gets the section.
   *
   * @return the section
   */
  public String getSection() {
    return section;
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
   * Gets the cui.
   *
   * @return the cui
   */
  public String getCui() {
    return cui;
  }

  /**
   * Gets the attributeId.
   *
   * @return the attributeId
   */
  public String getAttributeId() {
    return attributeId;
  }

  /**
   * Gets the type.
   *
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * Gets the negated.
   *
   * @return the negated
   */
  public Boolean isNegated() {
    return negated;
  }

  /**
   * Gets the hypothetical.
   *
   * @return the hypothetical
   */
  public Boolean isHypothetical() {
    return hypothetical;
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

  /**
   * Gets the operator.
   *
   * @return the operator
   */
  public String getOperator() {
    return operator;
  }

  /**
   * Gets the begin.
   *
   * @return the begin
   */
  public Long getBegin() {
    return begin;
  }

  /**
   * Gets the end.
   *
   * @return the end
   */
  public Long getEnd() {
    return end;
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
   * Gets the annotation text.
   *
   * @return covered text
   */
  public String getCoveredText() {
	  return coveredText;
  }

  /**
   * Gets the annotation features.
   *
   * @return features
   */
  public Map<String, String> getFeatures() {
	  return features;
  }
}

