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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The tokenize options.
 */
public class TokenizeOptions extends GenericModel {

  public interface Ontologies {
    /** mesh. */
    String MESH = "mesh";
    /** concepts. */
    String CONCEPTS = "concepts";
  }

  protected String corpus;
  protected String flow;
  protected String body;
  protected List<String> ontologies;
  protected Long maxWords;

  /**
   * Builder.
   */
  public static class Builder {
    private String corpus;
    private String flow;
    private String body;
    private List<String> ontologies;
    private Long maxWords;

    private Builder(TokenizeOptions tokenizeOptions) {
      this.corpus = tokenizeOptions.corpus;
      this.flow = tokenizeOptions.flow;
      this.body = tokenizeOptions.body;
      this.ontologies = tokenizeOptions.ontologies;
      this.maxWords = tokenizeOptions.maxWords;
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
     * @param flow the flow
     * @param body the body
     */
    public Builder(String corpus, String flow, String body) {
      this.corpus = corpus;
      this.flow = flow;
      this.body = body;
    }

    /**
     * Builds a TokenizeOptions.
     *
     * @return the new TokenizeOptions instance
     */
    public TokenizeOptions build() {
      return new TokenizeOptions(this);
    }

    /**
     * Adds an ontologies to ontologies.
     *
     * @param ontologies the new ontologies
     * @return the TokenizeOptions builder
     */
    public Builder addOntologies(String ontologies) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(ontologies,
        "ontologies cannot be null");
      if (this.ontologies == null) {
        this.ontologies = new ArrayList<String>();
      }
      this.ontologies.add(ontologies);
      return this;
    }

    /**
     * Set the corpus.
     *
     * @param corpus the corpus
     * @return the TokenizeOptions builder
     */
    public Builder corpus(String corpus) {
      this.corpus = corpus;
      return this;
    }

    /**
     * Set the flow.
     *
     * @param flow the flow
     * @return the TokenizeOptions builder
     */
    public Builder flow(String flow) {
      this.flow = flow;
      return this;
    }

    /**
     * Set the body.
     *
     * @param body the body
     * @return the TokenizeOptions builder
     */
    public Builder body(String body) {
      this.body = body;
      return this;
    }

    /**
     * Set the ontologies.
     * Existing ontologies will be replaced.
     *
     * @param ontologies the ontologies
     * @return the TokenizeOptions builder
     */
    public Builder ontologies(List<String> ontologies) {
      this.ontologies = ontologies;
      return this;
    }

    /**
     * Set the maxWords.
     *
     * @param maxWords the maxWords
     * @return the TokenizeOptions builder
     */
    public Builder maxWords(long maxWords) {
      this.maxWords = maxWords;
      return this;
    }
  }

  protected TokenizeOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.corpus,
      "corpus cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.flow,
      "flow cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.body,
      "body cannot be null");
    corpus = builder.corpus;
    flow = builder.flow;
    body = builder.body;
    ontologies = builder.ontologies;
    maxWords = builder.maxWords;
  }

  /**
   * New builder.
   *
   * @return a TokenizeOptions builder
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
   * Gets the flow.
   *
   * Flow name (not used).
   *
   * @return the flow
   */
  public String flow() {
    return flow;
  }

  /**
   * Gets the body.
   *
   * Text.
   *
   * @return the body
   */
  public String body() {
    return body;
  }

  /**
   * Gets the ontologies.
   *
   * Detect artifacts in the selected ontology(ies).
   *
   * @return the ontologies
   */
  public List<String> ontologies() {
    return ontologies;
  }

  /**
   * Gets the maxWords.
   *
   * Maximum number of words per detected surface form. Default is 4.
   *
   * @return the maxWords
   */
  public Long maxWords() {
    return maxWords;
  }
}

