/*
 * Copyright 2018, 2020 IBM Corp. All Rights Reserved.
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
import com.ibm.cloud.sdk.core.util.Validator;

/**
 * The addCorpusDocument options.
 */
public class AddCorpusDocumentOptions extends GenericModel {

  private String corpus;
  private Map<String, Object> document;
  private String acdUrl;
  private String apiKey;
  private String flowId;
  private String accessToken;
  private List<Object> otherAnnotators;

  /**
   * Builder.
   */
  public static class Builder {
    private String corpus;
    private Map<String, Object> document;
    private String acdUrl;
    private String apiKey;
    private String flowId;
    private String accessToken;
    private List<Object> otherAnnotators;

    private Builder(final AddCorpusDocumentOptions addCorpusDocumentOptions) {
      this.corpus = addCorpusDocumentOptions.corpus;
      this.document = addCorpusDocumentOptions.document;
      this.acdUrl = addCorpusDocumentOptions.acdUrl;
      this.apiKey = addCorpusDocumentOptions.apiKey;
      this.flowId = addCorpusDocumentOptions.flowId;
      this.accessToken = addCorpusDocumentOptions.accessToken;
      this.otherAnnotators = addCorpusDocumentOptions.otherAnnotators;
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
    public Builder(final String corpus) {
      this.corpus = corpus;
    }

    /**
     * Builds a AddCorpusDocumentOptions.
     *
     * @return the addCorpusDocumentOptions
     */
    public AddCorpusDocumentOptions build() {
      return new AddCorpusDocumentOptions(this);
    }

    /**
     * Adds an object representing custom Annotators to forward analytic
     *  output to for additional analysis.
     * Additional annotators must be able to consume and contribute to the
     *  forwarded analytic output model.
     *
     * @param otherAnnotators the new otherAnnotators
     * @return the AddCorpusDocumentOptions builder
     */
    public Builder addOtherAnnotators(final Object otherAnnotators) {
      Validator.notNull(otherAnnotators, "otherAnnotators cannot be null");
      if (this.otherAnnotators == null) {
        this.otherAnnotators = new ArrayList<Object>();
      }
      this.otherAnnotators.add(otherAnnotators);
      return this;
    }

    /**
     * Set the corpus.
     *
     * @param corpus the corpus
     * @return the AddCorpusDocumentOptions builder
     */
    public Builder corpus(final String corpus) {
      this.corpus = corpus;
      return this;
    }

    /**
     * Set the document.
     *
     * @param document the document
     * @return the AddCorpusDocumentOptions builder
     */
    public Builder document(final Map<String, Object> document) {
      this.document = document;
      return this;
    }

    /**
     * Set the acdUrl.
     *
     * @param acdUrl the URL to Annotation for Clinical Data instance
     * @return the AddCorpusDocumentOptions builder
     */
    public Builder acdUrl(final String acdUrl) {
      this.acdUrl = acdUrl;
      return this;
    }

    /**
     * Set the apiKey.
     *
     * @param apiKey the apiKey to access Annotator for Clinical Data
     * @return the AddCorpusDocumentOptions builder
     */
    public Builder apiKey(final String apiKey) {
      this.apiKey = apiKey;
      return this;
    }

    /**
     * Set the flowId.
     *
     * @param flowId the flowId for Annotation for Clinical Data
     * @return the AddCorpusDocumentOptions builder
     */
    public Builder flowId(final String flowId) {
      this.flowId = flowId;
      return this;
    }

    /**
     * Set the accessToken.
     *
     * @param accessToken the accessToken for Annotation for Clinical Data
     * @return the AddCorpusDocumentOptions builder
     */
    public Builder accessToken(final String accessToken) {
      this.accessToken = accessToken;
      return this;
    }

    /**
     * Set the otherAnnotators.
     * Existing otherAnnotators will be replaced.
     *
     * @param otherAnnotators Custom annotator URLs
     * @return the AddCorpusDocumentOptions builder
     */
    public Builder otherAnnotators(final List<Object> otherAnnotators) {
      this.otherAnnotators = otherAnnotators;
      return this;
    }
  }

  private AddCorpusDocumentOptions(final Builder builder) {
    Validator.notEmpty(builder.corpus, "corpus cannot be empty");
    corpus = builder.corpus;
    document = builder.document;
    acdUrl = builder.acdUrl;
    apiKey = builder.apiKey;
    flowId = builder.flowId;
    accessToken = builder.accessToken;
    otherAnnotators = builder.otherAnnotators;
  }

  /**
   * New builder.
   *
   * @return a AddCorpusDocumentOptions builder
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
   * Gets the document.
   *
   * JSON based document for enrichment.
   *
   * @return the document
   */
  public Map<String, Object> document() {
    return document;
  }

  /**
   * Gets the acdUrl.
   *
   * Annotator for Clincial Data url.
   *
   * @return the acdUrl
   */
  public String acdUrl() {
    return acdUrl;
  }

  /**
   * Gets the apiKey.
   *
   * Security key.
   *
   * @return the apiKey
   */
  public String apiKey() {
    return apiKey;
  }

  /**
   * Gets the flowId.
   *
   * Enrichment flow identifier.
   *
   * @return the flowId
   */
  public String flowId() {
    return flowId;
  }

  /**
   * Gets the accessToken.
   *
   * Cloud access token.
   *
   * @return the accessToken
   */
  public String accessToken() {
    return accessToken;
  }

  /**
   * Gets the otherAnnotators.
   *
   * URLs and API keys for custom annotators.
   *
   * @return the otherAnnotators
   */
  public List<Object> otherAnnotators() {
    return otherAnnotators;
  }
}

