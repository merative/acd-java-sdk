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
 * The getHitCount options.
 */
public class GetHitCountOptions extends GenericModel {

  private String corpus;
  private String cui;
  private String ontology;

  /**
   * Builder.
   */
  public static class Builder {
    private String corpus;
    private String cui;
    private String ontology;

    private Builder(GetHitCountOptions getHitCountOptions) {
      corpus = getHitCountOptions.corpus;
      cui = getHitCountOptions.cui;
      ontology = getHitCountOptions.ontology;
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
     */
    public Builder(String corpus, String cui) {
      this.corpus = corpus;
      this.cui = cui;
    }

    /**
     * Builds a GetHitCountOptions.
     *
     * @return the getHitCountOptions
     */
    public GetHitCountOptions build() {
      return new GetHitCountOptions(this);
    }

    /**
     * Set the corpus.
     *
     * @param corpus the corpus
     * @return the GetHitCountOptions builder
     */
    public Builder corpus(String corpus) {
      this.corpus = corpus;
      return this;
    }

    /**
     * Set the cui.
     *
     * @param cui the cui
     * @return the GetHitCountOptions builder
     */
    public Builder cui(String cui) {
      this.cui = cui;
      return this;
    }

    /**
     * Set the ontology.
     *
     * @param ontology the ontology
     * @return the GetHitCountOptions builder
     */
    public Builder ontology(String ontology) {
      this.ontology = ontology;
      return this;
    }
  }

  private GetHitCountOptions(Builder builder) {
    Validator.notEmpty(builder.corpus, "corpus cannot be empty");
    Validator.notEmpty(builder.cui, "cui cannot be empty");
    corpus = builder.corpus;
    cui = builder.cui;
    ontology = builder.ontology;
  }

  /**
   * New builder.
   *
   * @return a GetHitCountOptions builder
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
   * Concept unique identifier.
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
}

