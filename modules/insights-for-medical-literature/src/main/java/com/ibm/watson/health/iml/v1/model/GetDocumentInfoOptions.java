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
 * The getDocumentInfo options.
 */
public class GetDocumentInfoOptions extends GenericModel {

  private String corpus;
  private String documentId;
  private String fields;
  private boolean verbose;

  /**
   * Builder.
   */
  public static class Builder {
    private String corpus;
    private String documentId;
    private String fields;
    private boolean verbose = true;

    private Builder(GetDocumentInfoOptions getDocumentInfoOptions) {
      corpus = getDocumentInfoOptions.corpus;
      documentId = getDocumentInfoOptions.documentId;
      fields = getDocumentInfoOptions.fields;
      verbose = getDocumentInfoOptions.verbose;
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
     * @return the getDocumentInfoOptions
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
     * Set the fields.
     *
     * @param fields the fields
     * @return the GetDocumentInfoOptions builder
     */
    public Builder fields(String fields) {
      this.fields = fields;
      return this;
    }

    /**
     * Set the fields.
     *
     * @param fields the fields
     * @return the GetDocumentInfoOptions builder
     */
    public Builder verbose(boolean flag) {
      this.verbose = flag;
      return this;
    }
  }

  private GetDocumentInfoOptions(Builder builder) {
    Validator.notEmpty(builder.corpus, "corpus cannot be empty");
    Validator.notEmpty(builder.documentId, "documentId cannot be empty");
    corpus = builder.corpus;
    documentId = builder.documentId;
    fields = builder.fields;
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
   * Gets the fields.
   *
   * Comma separated list of fields to return:  externalId, parentDocumentId,
   *  title, abstract, body, pdfUrl,
   * referenceUrl, metadata.
   *
   * @return the fields
   */
  public String fields() {
    return fields;
  }

  /**
   * Gets the verbose setting (default true).
   *
   * True or False to indicate whether verbose mode is enabled.
   * Verbose mode returns all text sections.
   *
   * @return the fields
   */
  public boolean verbose() {
    return verbose;
  }
}

