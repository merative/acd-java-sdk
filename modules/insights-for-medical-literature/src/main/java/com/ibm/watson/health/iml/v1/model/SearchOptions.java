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
 * The search options.
 */
public class SearchOptions extends GenericModel {

  private String corpus;
  private Boolean verbose;
  private Query query;
  private ReturnsModel returns;

  /**
   * Builder.
   */
  public static class Builder {
    private String corpus;
    private Boolean verbose;
    private Query query;
    private ReturnsModel returns;

    private Builder(SearchOptions searchOptions) {
      corpus = searchOptions.corpus;
      verbose = searchOptions.verbose;
      query = searchOptions.query;
      returns = searchOptions.returns;
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
     */
    public Builder(String corpus) {
      this.corpus = corpus;
      this.corpus = corpus;
      this.query = new Query();
      this.returns = new ReturnsModel();
    }

    /**
     * Builds a SearchOptions.
     *
     * @return the searchOptions
     */
    public SearchOptions build() {
      return new SearchOptions(this);
    }

    /**
     * Set the corpus.
     *
     * @param corpus the corpus
     * @return the SearchOptions builder
     */
    public Builder corpus(String corpus) {
      this.corpus = corpus;
      this.query = new Query();
      this.returns = new ReturnsModel();
      return this;
    }

    /**
     * Set the verbose.
     *
     * @param verbose the verbose
     * @return the SearchOptions builder
     */
    public Builder verbose(Boolean verbose) {
      this.verbose = verbose;
      return this;
    }

    /**
     * Set the query.
     *
     * @param query the query
     * @return the SearchOptions builder
     */
    public Builder query(Query query) {
      this.query = query;
      return this;
    }

    /**
     * Set the returns.
     *
     * @param returns the returns
     * @return the SearchOptions builder
     */
    public Builder returns(ReturnsModel returns) {
      this.returns = returns;
      return this;
    }
  }

  private SearchOptions(Builder builder) {
    Validator.notEmpty(builder.corpus, "corpus cannot be empty");
    corpus = builder.corpus;
    verbose = builder.verbose;
    query = builder.query;
    returns = builder.returns;
  }

  /**
   * New builder.
   *
   * @return a SearchOptions builder
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
   * Gets the verbose.
   *
   * Verbose output.
   *
   * @return the verbose
   */
  public Boolean verbose() {
    return verbose;
  }

  /**
   * Gets the query.
   *
   * @return the query
   */
  public Query query() {
    return query;
  }

  /**
   * Gets the returns.
   *
   * @return the returns
   */
  public ReturnsModel returns() {
    return returns;
  }
}

