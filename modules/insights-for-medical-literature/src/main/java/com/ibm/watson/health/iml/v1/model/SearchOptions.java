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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The search options.
 */
public class SearchOptions extends GenericModel {

  protected String corpus;
//  protected String body;
  protected Query query;
  protected ReturnsModel returns;
  protected Boolean verbose;

  /**
   * Builder.
   */
  public static class Builder {
    private String corpus;
//    private String body;
    private Query query;
    private ReturnsModel returns;
    private Boolean verbose;

    private Builder(SearchOptions searchOptions) {
      this.corpus = searchOptions.corpus;
//      this.body = searchOptions.body;
      this.query = searchOptions.query;
      this.returns = searchOptions.returns;
      this.verbose = searchOptions.verbose;
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
     * @param returns the body
     */
    public Builder(String corpus, ReturnsModel returns) {
      this.corpus = corpus;
      this.returns = returns;
    }

    /**
     * Builds a SearchOptions.
     *
     * @return the new SearchOptions instance
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
      return this;
    }

    /**
     * Set the query model.
     *
     * @param query the query model
     * @return the SearchOptions builder
     */
    public Builder query(Query query) {
      this.query = query;
      return this;
    }

    /**
     * Set the Returns Model.
     *
     * @param returns the returns model
     * @return the SearchOptions builder
     */
    public Builder returns(ReturnsModel returns) {
      this.returns = returns;
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
  }

  protected SearchOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.corpus,
      "corpus cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.returns,
      "returnns model cannot be null");
    corpus = builder.corpus;
    query = builder.query;
    returns = builder.returns;
    verbose = builder.verbose;
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
 * Gets the query criteria.
 *
 * @return the query
 */
  public Query query() {
	return query;
  }

  /**
   * Gets the returns model.
   *
   * @return the returns model.
   */
  public ReturnsModel returns() {
	return returns;
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
}

