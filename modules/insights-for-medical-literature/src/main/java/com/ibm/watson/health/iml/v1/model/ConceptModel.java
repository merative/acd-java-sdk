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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Model representing an ontology annotation.
 */
public class ConceptModel extends GenericModel {

  protected Long uniqueId;
  protected List<Long> stickyIds;
  protected String section;
  protected String type;
  protected Long begin;
  protected Long end;
  protected String coveredText;
  protected String cui;
  protected String preferredName;
  protected String source;
  protected Boolean negated;
  protected Boolean hypothetical;
  protected Long timestamp;
  protected String attributeId;
  protected List<String> qualifiers;
  protected String unit;
  protected String minValue;
  protected String maxValue;
  protected String operator;
  protected Map<String, String> features;
  protected String nluEntityIndex;
  protected String nluMentionIndex;
  protected String nluRelationId;
  protected String nluSide;
  protected String nluSourceType;
  protected String nluRelation;
  protected String nluTargetType;
  protected Long hits;

  /**
   * Gets the uniqueId.
   *
   * Service generated unique identifier of ontology artifact.
   *
   * @return the uniqueId
   */
  public Long getUniqueId() {
    return uniqueId;
  }

  /**
   * Gets the stickyIds.
   *
   * Identifiers associated with artifact unique identifier.
   *
   * @return the stickyIds
   */
  public List<Long> getStickyIds() {
    return stickyIds;
  }

  /**
   * Gets the section.
   *
   * Document section where artifact was found.
   *
   * @return the section
   */
  public String getSection() {
    return section;
  }

  /**
   * Gets the type.
   *
   * Ontology semantic type for artifact (if applicable).
   *
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * Gets the begin.
   *
   * Staring offset of artifact in document section.
   *
   * @return the begin
   */
  public Long getBegin() {
    return begin;
  }

  /**
   * Gets the end.
   *
   * Ending offset of artifact in document section.
   *
   * @return the end
   */
  public Long getEnd() {
    return end;
  }

  /**
   * Gets the coveredText.
   *
   * Actual document section text artifact represents.
   *
   * @return the coveredText
   */
  public String getCoveredText() {
    return coveredText;
  }

  /**
   * Gets the cui.
   *
   * Ontology defined unique identifier of artifact.
   *
   * @return the cui
   */
  public String getCui() {
    return cui;
  }

  /**
   * Gets the preferredName.
   *
   * Ontology defined normalized name of artifact.
   *
   * @return the preferredName
   */
  public String getPreferredName() {
    return preferredName;
  }

  /**
   * Gets the source.
   *
   * Ontology providing the artifact.
   *
   * @return the source
   */
  public String getSource() {
    return source;
  }

  /**
   * Gets the negated.
   *
   * Whether span represented by artifact is negated.
   *
   * @return the negated
   */
  public Boolean isNegated() {
    return negated;
  }

  /**
   * Gets the hypothetical.
   *
   * Whether span represented by artifact is hypothetical.
   *
   * @return the hypothetical
   */
  public Boolean isHypothetical() {
    return hypothetical;
  }

  /**
   * Gets the timestamp.
   *
   * Time based offset of artifact in a video transcript (if applicable).
   *
   * @return the timestamp
   */
  public Long getTimestamp() {
    return timestamp;
  }

  /**
   * Gets the attributeId.
   *
   * Identifier of attribute where artifact is defined (if applicable).
   *
   * @return the attributeId
   */
  public String getAttributeId() {
    return attributeId;
  }

  /**
   * Gets the qualifiers.
   *
   * List of qualifers defined for an attribute artifact.
   *
   * @return the qualifiers
   */
  public List<String> getQualifiers() {
    return qualifiers;
  }

  /**
   * Gets the unit.
   *
   * Unit of measure for attribute defined artifact (if applicable).
   *
   * @return the unit
   */
  public String getUnit() {
    return unit;
  }

  /**
   * Gets the minValue.
   *
   * Starting range value for attribute artifact (if applicable).
   *
   * @return the minValue
   */
  public String getMinValue() {
    return minValue;
  }

  /**
   * Gets the maxValue.
   *
   * Ending range value for attribute artifact (if applicable).
   *
   * @return the maxValue
   */
  public String getMaxValue() {
    return maxValue;
  }

  /**
   * Gets the operator.
   *
   * Mathmatical operator for attribute artifact (if applicable).
   *
   * @return the operator
   */
  public String getOperator() {
    return operator;
  }

  /**
   * Gets the features.
   *
   * List of additional artifact features.
   *
   * @return the features
   */
  public Map<String, String> getFeatures() {
    return features;
  }

  /**
   * Gets the nluEntityIndex.
   *
   * Model coreference chain to which artifact belongs.
   *
   * @return the nluEntityIndex
   */
  public String getNluEntityIndex() {
    return nluEntityIndex;
  }

  /**
   * Gets the nluMentionIndex.
   *
   * Artifact position in Model coreference chain.
   *
   * @return the nluMentionIndex
   */
  public String getNluMentionIndex() {
    return nluMentionIndex;
  }

  /**
   * Gets the nluRelationId.
   *
   * Relation unique identifier artifact is associated with.
   *
   * @return the nluRelationId
   */
  public String getNluRelationId() {
    return nluRelationId;
  }

  /**
   * Gets the nluSide.
   *
   * Whether artifact is a source or target of a relationship.
   *
   * @return the nluSide
   */
  public String getNluSide() {
    return nluSide;
  }

  /**
   * Gets the nluSourceType.
   *
   * Model type for artifact when the source of a relationship.
   *
   * @return the nluSourceType
   */
  public String getNluSourceType() {
    return nluSourceType;
  }

  /**
   * Gets the nluRelation.
   *
   * Name of the realtion an artifact is associated with.
   *
   * @return the nluRelation
   */
  public String getNluRelation() {
    return nluRelation;
  }

  /**
   * Gets the nluTargetType.
   *
   * Model type for artifact when the target of a relationship.
   *
   * @return the nluTargetType
   */
  public String getNluTargetType() {
    return nluTargetType;
  }

  /**
   * Gets the hits.
   *
   * Number of times artifact is mentioned in the corpus.
   *
   * @return the hits
   */
  public Long getHits() {
    return hits;
  }
}

