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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Model for congntive asset annotations.
 */
public class AnnotationModel extends GenericModel {

  protected Long uniqueId;
  protected List<Long> stickyIds;
  protected String ontology;
  protected String section;
  protected String preferredName;
  protected String cui;
  protected String attributeId;
  protected List<String> qualifiers;
  protected String type;
  protected Boolean negated;
  protected Boolean hypothetical;
  protected String unit;
  protected String minValue;
  protected String maxValue;
  protected String operator;
  protected String nluSourceType;
  protected String nluRelation;
  protected String nluTargetType;
  protected String nluEntityIndex;
  protected String nluMentionIndex;
  protected String nluRelationId;
  protected String nluSide;
  protected Long begin;
  protected Long end;
  protected Float score;
  protected Long timestamp;
  protected Map<String, String> features;
  protected Long hits;

  /**
   * Builder.
   */
  public static class Builder {
    private Long uniqueId;
    private List<Long> stickyIds;
    private String ontology;
    private String section;
    private String preferredName;
    private String cui;
    private String attributeId;
    private List<String> qualifiers;
    private String type;
    private Boolean negated;
    private Boolean hypothetical;
    private String unit;
    private String minValue;
    private String maxValue;
    private String operator;
    private String nluSourceType;
    private String nluRelation;
    private String nluTargetType;
    private String nluEntityIndex;
    private String nluMentionIndex;
    private String nluRelationId;
    private String nluSide;
    private Long begin;
    private Long end;
    private Float score;
    private Long timestamp;
    private Map<String, String> features;
    private Long hits;

    private Builder(AnnotationModel annotationModel) {
      this.uniqueId = annotationModel.uniqueId;
      this.stickyIds = annotationModel.stickyIds;
      this.ontology = annotationModel.ontology;
      this.section = annotationModel.section;
      this.preferredName = annotationModel.preferredName;
      this.cui = annotationModel.cui;
      this.attributeId = annotationModel.attributeId;
      this.qualifiers = annotationModel.qualifiers;
      this.type = annotationModel.type;
      this.negated = annotationModel.negated;
      this.hypothetical = annotationModel.hypothetical;
      this.unit = annotationModel.unit;
      this.minValue = annotationModel.minValue;
      this.maxValue = annotationModel.maxValue;
      this.operator = annotationModel.operator;
      this.nluSourceType = annotationModel.nluSourceType;
      this.nluRelation = annotationModel.nluRelation;
      this.nluTargetType = annotationModel.nluTargetType;
      this.nluEntityIndex = annotationModel.nluEntityIndex;
      this.nluMentionIndex = annotationModel.nluMentionIndex;
      this.nluRelationId = annotationModel.nluRelationId;
      this.nluSide = annotationModel.nluSide;
      this.begin = annotationModel.begin;
      this.end = annotationModel.end;
      this.score = annotationModel.score;
      this.timestamp = annotationModel.timestamp;
      this.features = annotationModel.features;
      this.hits = annotationModel.hits;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a AnnotationModel.
     *
     * @return the new AnnotationModel instance
     */
    public AnnotationModel build() {
      return new AnnotationModel(this);
    }

    /**
     * Adds an stickyIds to stickyIds.
     *
     * @param stickyIds the new stickyIds
     * @return the AnnotationModel builder
     */
    public Builder addStickyIds(Long stickyIds) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(stickyIds,
        "stickyIds cannot be null");
      if (this.stickyIds == null) {
        this.stickyIds = new ArrayList<Long>();
      }
      this.stickyIds.add(stickyIds);
      return this;
    }

    /**
     * Adds an qualifiers to qualifiers.
     *
     * @param qualifiers the new qualifiers
     * @return the AnnotationModel builder
     */
    public Builder addQualifiers(String qualifiers) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(qualifiers,
        "qualifiers cannot be null");
      if (this.qualifiers == null) {
        this.qualifiers = new ArrayList<String>();
      }
      this.qualifiers.add(qualifiers);
      return this;
    }

    /**
     * Set the uniqueId.
     *
     * @param uniqueId the uniqueId
     * @return the AnnotationModel builder
     */
    public Builder uniqueId(long uniqueId) {
      this.uniqueId = uniqueId;
      return this;
    }

    /**
     * Set the stickyIds.
     * Existing stickyIds will be replaced.
     *
     * @param stickyIds the stickyIds
     * @return the AnnotationModel builder
     */
    public Builder stickyIds(List<Long> stickyIds) {
      this.stickyIds = stickyIds;
      return this;
    }

    /**
     * Set the ontology.
     *
     * @param ontology the ontology
     * @return the AnnotationModel builder
     */
    public Builder ontology(String ontology) {
      this.ontology = ontology;
      return this;
    }

    /**
     * Set the section.
     *
     * @param section the section
     * @return the AnnotationModel builder
     */
    public Builder section(String section) {
      this.section = section;
      return this;
    }

    /**
     * Set the preferredName.
     *
     * @param preferredName the preferredName
     * @return the AnnotationModel builder
     */
    public Builder preferredName(String preferredName) {
      this.preferredName = preferredName;
      return this;
    }

    /**
     * Set the cui.
     *
     * @param cui the cui
     * @return the AnnotationModel builder
     */
    public Builder cui(String cui) {
      this.cui = cui;
      return this;
    }

    /**
     * Set the attributeId.
     *
     * @param attributeId the attributeId
     * @return the AnnotationModel builder
     */
    public Builder attributeId(String attributeId) {
      this.attributeId = attributeId;
      return this;
    }

    /**
     * Set the qualifiers.
     * Existing qualifiers will be replaced.
     *
     * @param qualifiers the qualifiers
     * @return the AnnotationModel builder
     */
    public Builder qualifiers(List<String> qualifiers) {
      this.qualifiers = qualifiers;
      return this;
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the AnnotationModel builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Set the negated.
     *
     * @param negated the negated
     * @return the AnnotationModel builder
     */
    public Builder negated(Boolean negated) {
      this.negated = negated;
      return this;
    }

    /**
     * Set the hypothetical.
     *
     * @param hypothetical the hypothetical
     * @return the AnnotationModel builder
     */
    public Builder hypothetical(Boolean hypothetical) {
      this.hypothetical = hypothetical;
      return this;
    }

    /**
     * Set the unit.
     *
     * @param unit the unit
     * @return the AnnotationModel builder
     */
    public Builder unit(String unit) {
      this.unit = unit;
      return this;
    }

    /**
     * Set the minValue.
     *
     * @param minValue the minValue
     * @return the AnnotationModel builder
     */
    public Builder minValue(String minValue) {
      this.minValue = minValue;
      return this;
    }

    /**
     * Set the maxValue.
     *
     * @param maxValue the maxValue
     * @return the AnnotationModel builder
     */
    public Builder maxValue(String maxValue) {
      this.maxValue = maxValue;
      return this;
    }

    /**
     * Set the operator.
     *
     * @param operator the operator
     * @return the AnnotationModel builder
     */
    public Builder operator(String operator) {
      this.operator = operator;
      return this;
    }

    /**
     * Set the nluSourceType.
     *
     * @param nluSourceType the nluSourceType
     * @return the AnnotationModel builder
     */
    public Builder nluSourceType(String nluSourceType) {
      this.nluSourceType = nluSourceType;
      return this;
    }

    /**
     * Set the nluRelation.
     *
     * @param nluRelation the nluRelation
     * @return the AnnotationModel builder
     */
    public Builder nluRelation(String nluRelation) {
      this.nluRelation = nluRelation;
      return this;
    }

    /**
     * Set the nluTargetType.
     *
     * @param nluTargetType the nluTargetType
     * @return the AnnotationModel builder
     */
    public Builder nluTargetType(String nluTargetType) {
      this.nluTargetType = nluTargetType;
      return this;
    }

    /**
     * Set the nluEntityIndex.
     *
     * @param nluEntityIndex the nluEntityIndex
     * @return the AnnotationModel builder
     */
    public Builder nluEntityIndex(String nluEntityIndex) {
      this.nluEntityIndex = nluEntityIndex;
      return this;
    }

    /**
     * Set the nluMentionIndex.
     *
     * @param nluMentionIndex the nluMentionIndex
     * @return the AnnotationModel builder
     */
    public Builder nluMentionIndex(String nluMentionIndex) {
      this.nluMentionIndex = nluMentionIndex;
      return this;
    }

    /**
     * Set the nluRelationId.
     *
     * @param nluRelationId the nluRelationId
     * @return the AnnotationModel builder
     */
    public Builder nluRelationId(String nluRelationId) {
      this.nluRelationId = nluRelationId;
      return this;
    }

    /**
     * Set the nluSide.
     *
     * @param nluSide the nluSide
     * @return the AnnotationModel builder
     */
    public Builder nluSide(String nluSide) {
      this.nluSide = nluSide;
      return this;
    }

    /**
     * Set the begin.
     *
     * @param begin the begin
     * @return the AnnotationModel builder
     */
    public Builder begin(long begin) {
      this.begin = begin;
      return this;
    }

    /**
     * Set the end.
     *
     * @param end the end
     * @return the AnnotationModel builder
     */
    public Builder end(long end) {
      this.end = end;
      return this;
    }

    /**
     * Set the score.
     *
     * @param score the score
     * @return the AnnotationModel builder
     */
    public Builder score(Float score) {
      this.score = score;
      return this;
    }

    /**
     * Set the timestamp.
     *
     * @param timestamp the timestamp
     * @return the AnnotationModel builder
     */
    public Builder timestamp(long timestamp) {
      this.timestamp = timestamp;
      return this;
    }

    /**
     * Set the features.
     *
     * @param features the features
     * @return the AnnotationModel builder
     */
    public Builder features(Map<String, String> features) {
      this.features = features;
      return this;
    }

    /**
     * Set the hits.
     *
     * @param hits the hits
     * @return the AnnotationModel builder
     */
    public Builder hits(long hits) {
      this.hits = hits;
      return this;
    }
  }

  protected AnnotationModel(Builder builder) {
    uniqueId = builder.uniqueId;
    stickyIds = builder.stickyIds;
    ontology = builder.ontology;
    section = builder.section;
    preferredName = builder.preferredName;
    cui = builder.cui;
    attributeId = builder.attributeId;
    qualifiers = builder.qualifiers;
    type = builder.type;
    negated = builder.negated;
    hypothetical = builder.hypothetical;
    unit = builder.unit;
    minValue = builder.minValue;
    maxValue = builder.maxValue;
    operator = builder.operator;
    nluSourceType = builder.nluSourceType;
    nluRelation = builder.nluRelation;
    nluTargetType = builder.nluTargetType;
    nluEntityIndex = builder.nluEntityIndex;
    nluMentionIndex = builder.nluMentionIndex;
    nluRelationId = builder.nluRelationId;
    nluSide = builder.nluSide;
    begin = builder.begin;
    end = builder.end;
    score = builder.score;
    timestamp = builder.timestamp;
    features = builder.features;
    hits = builder.hits;
  }

  /**
   * New builder.
   *
   * @return a AnnotationModel builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the uniqueId.
   *
   * Unique identifer of annotation.
   *
   * @return the uniqueId
   */
  public Long uniqueId() {
    return uniqueId;
  }

  /**
   * Gets the stickyIds.
   *
   * List of identifiers associated with annotation.
   *
   * @return the stickyIds
   */
  public List<Long> stickyIds() {
    return stickyIds;
  }

  /**
   * Gets the ontology.
   *
   * Source ontology of annotation.
   *
   * @return the ontology
   */
  public String ontology() {
    return ontology;
  }

  /**
   * Gets the section.
   *
   * Document section for annotation.
   *
   * @return the section
   */
  public String section() {
    return section;
  }

  /**
   * Gets the preferredName.
   *
   * Ontology provide normalized name of annotation.
   *
   * @return the preferredName
   */
  public String preferredName() {
    return preferredName;
  }

  /**
   * Gets the cui.
   *
   * Ontology provided unique identifier of annotation.
   *
   * @return the cui
   */
  public String cui() {
    return cui;
  }

  /**
   * Gets the attributeId.
   *
   * Attribute identifier of annotation.
   *
   * @return the attributeId
   */
  public String attributeId() {
    return attributeId;
  }

  /**
   * Gets the qualifiers.
   *
   * Qualifier for attribute annotation.
   *
   * @return the qualifiers
   */
  public List<String> qualifiers() {
    return qualifiers;
  }

  /**
   * Gets the type.
   *
   * Ontology provided semantic type of annotation.
   *
   * @return the type
   */
  public String type() {
    return type;
  }

  /**
   * Gets the negated.
   *
   * Whether the annotation is a negated span.
   *
   * @return the negated
   */
  public Boolean negated() {
    return negated;
  }

  /**
   * Gets the hypothetical.
   *
   * Whether the annotation is a hypothetical span.
   *
   * @return the hypothetical
   */
  public Boolean hypothetical() {
    return hypothetical;
  }

  /**
   * Gets the unit.
   *
   * Unit of measure for attribute value annotation.
   *
   * @return the unit
   */
  public String unit() {
    return unit;
  }

  /**
   * Gets the minValue.
   *
   * Minumum value for attribute value annotation.
   *
   * @return the minValue
   */
  public String minValue() {
    return minValue;
  }

  /**
   * Gets the maxValue.
   *
   * Maximum value for attribute value annotation.
   *
   * @return the maxValue
   */
  public String maxValue() {
    return maxValue;
  }

  /**
   * Gets the operator.
   *
   * Mathematical operator for attribute value annotation.
   *
   * @return the operator
   */
  public String operator() {
    return operator;
  }

  /**
   * Gets the nluSourceType.
   *
   * Ontology type of source relation annotation.
   *
   * @return the nluSourceType
   */
  public String nluSourceType() {
    return nluSourceType;
  }

  /**
   * Gets the nluRelation.
   *
   * Relation name for annotation.
   *
   * @return the nluRelation
   */
  public String nluRelation() {
    return nluRelation;
  }

  /**
   * Gets the nluTargetType.
   *
   * Ontology type of target relation annotation.
   *
   * @return the nluTargetType
   */
  public String nluTargetType() {
    return nluTargetType;
  }

  /**
   * Gets the nluEntityIndex.
   *
   * @return the nluEntityIndex
   */
  public String nluEntityIndex() {
    return nluEntityIndex;
  }

  /**
   * Gets the nluMentionIndex.
   *
   * @return the nluMentionIndex
   */
  public String nluMentionIndex() {
    return nluMentionIndex;
  }

  /**
   * Gets the nluRelationId.
   *
   * @return the nluRelationId
   */
  public String nluRelationId() {
    return nluRelationId;
  }

  /**
   * Gets the nluSide.
   *
   * @return the nluSide
   */
  public String nluSide() {
    return nluSide;
  }

  /**
   * Gets the begin.
   *
   * Starting offset of annotation.
   *
   * @return the begin
   */
  public Long begin() {
    return begin;
  }

  /**
   * Gets the end.
   *
   * Ending offset of annotation.
   *
   * @return the end
   */
  public Long end() {
    return end;
  }

  /**
   * Gets the score.
   *
   * Relevancy score of annotation.
   *
   * @return the score
   */
  public Float score() {
    return score;
  }

  /**
   * Gets the timestamp.
   *
   * @return the timestamp
   */
  public Long timestamp() {
    return timestamp;
  }

  /**
   * Gets the features.
   *
   * @return the features
   */
  public Map<String, String> features() {
    return features;
  }

  /**
   * Gets the hits.
   *
   * Number of times artifact is mentioned in the corpus.
   *
   * @return the hits
   */
  public Long hits() {
    return hits;
  }
}

