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

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import com.ibm.cloud.sdk.core.util.Validator;

/**
 * The getSimilarConcepts options.
 */
public class GetSimilarConceptsOptions extends GenericModel {

  private String corpus;
  private String nameOrId;
  private String ontology;
  private List<String> returnOntologies;
  private Long limit;

  /**
   * Builder.
   */
  public static class Builder {
    private String corpus;
    private String nameOrId;
    private String ontology;
    private List<String> returnOntologies;
    private Long limit;

    private Builder(GetSimilarConceptsOptions getSimilarConceptsOptions) {
      this.corpus = getSimilarConceptsOptions.corpus;
      this.nameOrId = getSimilarConceptsOptions.nameOrId;
      this.ontology = getSimilarConceptsOptions.ontology;
      this.returnOntologies = getSimilarConceptsOptions.returnOntologies;
      this.limit = getSimilarConceptsOptions.limit;
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
     * @param nameOrId the nameOrId
     */
    public Builder(String corpus, String nameOrId, List<String> returnOntologies) {
      this.corpus = corpus;
      this.nameOrId = nameOrId;
      this.returnOntologies = returnOntologies;
    }

    /**
     * Builds a GetSimilarConceptsOptions.
     *
     * @return the getSimilarConceptsOptions
     */
    public GetSimilarConceptsOptions build() {
      return new GetSimilarConceptsOptions(this);
    }

    /**
     * Adds an returnOntologies to returnOntologies.
     *
     * @param returnOntologies the new returnOntologies
     * @return the GetSimilarConceptsOptions builder
     */
    public Builder addReturnOntologies(String returnOntologies) {
      Validator.notNull(returnOntologies, "returnOntologies cannot be null");
      if (this.returnOntologies == null) {
        this.returnOntologies = new ArrayList<String>();
      }
      this.returnOntologies.add(returnOntologies);
      return this;
    }

    /**
     * Set the corpus.
     *
     * @param corpus the corpus
     * @return the GetSimilarConceptsOptions builder
     */
    public Builder corpus(String corpus) {
      this.corpus = corpus;
      return this;
    }

    /**
     * Set the nameOrId.
     *
     * @param nameOrId the nameOrId
     * @return the GetSimilarConceptsOptions builder
     */
    public Builder nameOrId(String nameOrId) {
      this.nameOrId = nameOrId;
      return this;
    }

    /**
     * Set the ontology.
     *
     * @param ontology the ontology
     * @return the GetSimilarConceptsOptions builder
     */
    public Builder ontology(String ontology) {
      this.ontology = ontology;
      return this;
    }

    /**
     * Set the returnOntologies.
     * Existing returnOntologies will be replaced.
     *
     * @param returnOntologies the returnOntologies
     * @return the GetSimilarConceptsOptions builder
     */
    public Builder returnOntologies(List<String> returnOntologies) {
      this.returnOntologies = returnOntologies;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the GetSimilarConceptsOptions builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }
  }

  private GetSimilarConceptsOptions(Builder builder) {
    Validator.notEmpty(builder.corpus, "corpus cannot be empty");
    Validator.notEmpty(builder.nameOrId, "nameOrId cannot be empty");
    corpus = builder.corpus;
    nameOrId = builder.nameOrId;
    ontology = builder.ontology;
    returnOntologies = builder.returnOntologies;
    limit = builder.limit;
  }

  /**
   * New builder.
   *
   * @return a GetSimilarConceptsOptions builder
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
   * Gets the nameOrId.
   *
   * Preferred name or concept ID.
   *
   * @return the nameOrId
   */
  public String nameOrId() {
    return nameOrId;
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
   * Gets the returnOntologies.
   *
   * Return similar concepts from any of these ontologies.
   *
   * @return the returnOntologies
   */
  public List<String> returnOntologies() {
    return returnOntologies;
  }

  /**
   * Gets the limit.
   *
   * Number of possible concepts to return. Default is 250.
   *
   * @return the limit
   */
  public Long limit() {
    return limit;
  }
}

