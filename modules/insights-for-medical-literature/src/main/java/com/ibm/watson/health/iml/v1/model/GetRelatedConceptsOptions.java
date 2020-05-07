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

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import com.ibm.cloud.sdk.core.util.Validator;

/**
 * The getRelatedConcepts options.
 */
public class GetRelatedConceptsOptions extends GenericModel {

  private String corpus;
  private String cui;
  private String ontology;
  private String relationship;
  private Boolean recursive;
  private Boolean treeLayout;
  private Long maxDepth;
  private Long maxHitCount;
  private Boolean verbose;

  /**
   * Builder.
   */
  public static class Builder {
    private String corpus;
    private String cui;
    private String ontology;
    private String relationship;
    private Boolean recursive;
    private Boolean treeLayout;
    private Long maxDepth;
    private Long maxHitCount;
    private Boolean verbose;

    private Builder(GetRelatedConceptsOptions getRelatedConceptsOptions) {
      corpus = getRelatedConceptsOptions.corpus;
      cui = getRelatedConceptsOptions.cui;
      ontology = getRelatedConceptsOptions.ontology;
      relationship = getRelatedConceptsOptions.relationship;
      recursive = getRelatedConceptsOptions.recursive;
      treeLayout = getRelatedConceptsOptions.treeLayout;
      maxDepth = getRelatedConceptsOptions.maxDepth;
      maxHitCount = getRelatedConceptsOptions.maxHitCount;
      verbose = getRelatedConceptsOptions.verbose;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param corpus the corpus
     * @param cui the cui
     * @param relationship the relationship
     */
    public Builder(String corpus, String cui, String relationship) {
      this.corpus = corpus;
      this.cui = cui;
      this.relationship = relationship;
    }

    /**
     * Builds a GetRelatedConceptsOptions.
     *
     * @return the getRelatedConceptsOptions
     */
    public GetRelatedConceptsOptions build() {
      return new GetRelatedConceptsOptions(this);
    }

    /**
     * Set the corpus.
     *
     * @param corpus the corpus
     * @return the GetRelatedConceptsOptions builder
     */
    public Builder corpus(String corpus) {
      this.corpus = corpus;
      return this;
    }

    /**
     * Set the cui.
     *
     * @param cui the cui
     * @return the GetRelatedConceptsOptions builder
     */
    public Builder cui(String cui) {
      this.cui = cui;
      return this;
    }

    /**
     * Set the ontology.
     *
     * @param ontology the ontology
     * @return the GetRelatedConceptsOptions builder
     */
    public Builder ontology(String ontology) {
      this.ontology = ontology;
      return this;
    }

    /**
     * Set the relationship.
     *
     * @param relationship the relationship
     * @return the GetRelatedConceptsOptions builder
     */
    public Builder relationship(String relationship) {
      this.relationship = relationship;
      return this;
    }

    /**
     * Set the recursive.
     *
     * @param recursive the recursive
     * @return the GetRelatedConceptsOptions builder
     */
    public Builder recursive(Boolean recursive) {
      this.recursive = recursive;
      return this;
    }

    /**
     * Set the treeLayout.
     *
     * @param treeLayout the treeLayout
     * @return the GetRelatedConceptsOptions builder
     */
    public Builder treeLayout(Boolean treeLayout) {
      this.treeLayout = treeLayout;
      return this;
    }

    /**
     * Set the maxDepth.
     *
     * @param maxDepth the maxDepth
     * @return the GetRelatedConceptsOptions builder
     */
    public Builder maxDepth(long maxDepth) {
      this.maxDepth = maxDepth;
      return this;
    }

    /**
     * Set the maxHitCount.
     *
     * @param maxHitCount the maxHitCount
     * @return the GetRelatedConceptsOptions builder
     */
    public Builder maxHitCount(long maxHitCount) {
      this.maxHitCount = maxHitCount;
      return this;
    }

    /**
     * Set the verbose.
     *
     * @param verbose the verbose
     * @return the GetRelatedConceptsOptions builder
     */
    public Builder verbose(Boolean verbose) {
      this.verbose = verbose;
      return this;
    }
  }

  private GetRelatedConceptsOptions(Builder builder) {
    Validator.notEmpty(builder.corpus, "corpus cannot be empty");
    Validator.notEmpty(builder.cui, "cui cannot be empty");
    Validator.notNull(builder.relationship, "relationship cannot be null");
    corpus = builder.corpus;
    cui = builder.cui;
    ontology = builder.ontology;
    relationship = builder.relationship;
    recursive = builder.recursive;
    treeLayout = builder.treeLayout;
    maxDepth = builder.maxDepth;
    maxHitCount = builder.maxHitCount;
    verbose = builder.verbose;
  }

  /**
   * New builder.
   *
   * @return a GetRelatedConceptsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the corpus.
   *
   * Corpus name.
   *
   * @return the corpus
   */
  public String corpus() {
    return corpus;
  }

  /**
   * Gets the cui.
   *
   * Concept Unique Identifier.
   *
   * @return the cui
   */
  public String cui() {
    return cui;
  }

  /**
   * Gets the ontology.
   *
   * The ontology that defines the cui.
   *
   * @return the ontology
   */
  public String ontology() {
    return ontology;
  }

  /**
   * Gets the relationship.
   *
   * Select the relationship to retrieve.
   *
   * @return the relationship
   */
  public String relationship() {
    return relationship;
  }

  /**
   * Gets the recursive.
   *
   * Recursively return parents, children, borader and narrower relations.  Default is false.
   *
   * @return the recursive
   */
  public Boolean recursive() {
    return recursive;
  }

  /**
   * Gets the treeLayout.
   *
   * Generate JSON output that is compatible with a d3 tree layout.  Default is false.
   *
   * @return the treeLayout
   */
  public Boolean treeLayout() {
    return treeLayout;
  }

  /**
   * Gets the maxDepth.
   *
   * Maximum depth.  Default is 10.
   *
   * @return the maxDepth
   */
  public Long maxDepth() {
    return maxDepth;
  }

  /**
   * Gets the maxHitCount.
   *
   * Maximum hit ((document)) count of returned concepts. Default is 500000.  High hit count concepts tend to be very
   * broad (e.g, Disease) and result in longer search times.
   *
   * @return the maxHitCount
   */
  public Long maxHitCount() {
    return maxHitCount;
  }

  /**
   * Gets the verbose.
   *
   * Verbose output. Default is false.
   *
   * @return the verbose
   */
  public Boolean verbose() {
    return verbose;
  }
}

