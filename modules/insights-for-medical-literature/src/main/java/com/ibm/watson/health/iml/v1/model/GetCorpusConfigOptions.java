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
 * The getCorpusConfig options.
 */
public class GetCorpusConfigOptions extends GenericModel {

  private String corpus;
  private Boolean verbose;

  /**
   * Builder.
   */
  public static class Builder {
    private String corpus;
    private Boolean verbose;

    private Builder(GetCorpusConfigOptions getCorpusConfigOptions) {
      corpus = getCorpusConfigOptions.corpus;
      verbose = getCorpusConfigOptions.verbose;
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
    }

    /**
     * Builds a GetCorpusConfigOptions.
     *
     * @return the getCorpusConfigOptions
     */
    public GetCorpusConfigOptions build() {
      return new GetCorpusConfigOptions(this);
    }

    /**
     * Set the corpus.
     *
     * @param corpus the corpus
     * @return the GetCorpusConfigOptions builder
     */
    public Builder corpus(String corpus) {
      this.corpus = corpus;
      return this;
    }

    /**
     * Set the verbose.
     *
     * @param verbose the verbose
     * @return the GetCorpusConfigOptions builder
     */
    public Builder verbose(Boolean verbose) {
      this.verbose = verbose;
      return this;
    }
  }

  private GetCorpusConfigOptions(Builder builder) {
    Validator.notEmpty(builder.corpus, "corpus cannot be empty");
    corpus = builder.corpus;
    verbose = builder.verbose;
  }

  /**
   * New builder.
   *
   * @return a GetCorpusConfigOptions builder
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
   * Verbose output.  Default verbose = false.
   *
   * @return the verbose
   */
  public Boolean verbose() {
    return verbose;
  }
}

