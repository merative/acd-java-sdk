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
 * The getDocumentInfo options.
 */
public class GetDocumentInfoOptions extends GenericModel {

  protected String corpus;
  protected String documentId;
  protected Boolean verbose;

  /**
   * Builder.
   */
  public static class Builder {
    private String corpus;
    private String documentId;
    private Boolean verbose;

    private Builder(GetDocumentInfoOptions getDocumentInfoOptions) {
      this.corpus = getDocumentInfoOptions.corpus;
      this.documentId = getDocumentInfoOptions.documentId;
      this.verbose = getDocumentInfoOptions.verbose;
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
     * @param documentId the documentId
     */
    public Builder(String corpus, String documentId) {
      this.corpus = corpus;
      this.documentId = documentId;
    }

    /**
     * Builds a GetDocumentInfoOptions.
     *
     * @return the new GetDocumentInfoOptions instance
     */
    public GetDocumentInfoOptions build() {
      return new GetDocumentInfoOptions(this);
    }

    /**
     * Set the corpus.
     *
     * @param corpus the corpus
     * @return the GetDocumentInfoOptions builder
     */
    public Builder corpus(String corpus) {
      this.corpus = corpus;
      return this;
    }

    /**
     * Set the documentId.
     *
     * @param documentId the documentId
     * @return the GetDocumentInfoOptions builder
     */
    public Builder documentId(String documentId) {
      this.documentId = documentId;
      return this;
    }

    /**
     * Set the verbose.
     *
     * @param verbose the verbose
     * @return the GetDocumentInfoOptions builder
     */
    public Builder verbose(Boolean verbose) {
      this.verbose = verbose;
      return this;
    }
  }

  protected GetDocumentInfoOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.corpus,
      "corpus cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.documentId,
      "documentId cannot be empty");
    corpus = builder.corpus;
    documentId = builder.documentId;
    verbose = builder.verbose;
  }

  /**
   * New builder.
   *
   * @return a GetDocumentInfoOptions builder
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
   * Gets the documentId.
   *
   * Document ID.
   *
   * @return the documentId
   */
  public String documentId() {
    return documentId;
  }

  /**
   * Gets the verbose.
   *
   * Verbose output. If true, text for all document sections is returned.
   *
   * @return the verbose
   */
  public Boolean verbose() {
    return verbose;
  }
}

