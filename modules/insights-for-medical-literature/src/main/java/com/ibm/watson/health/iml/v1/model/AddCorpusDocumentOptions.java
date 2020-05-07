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
import java.util.Map;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The addCorpusDocument options.
 */
public class AddCorpusDocumentOptions extends GenericModel {

  protected String corpus;
  protected Map<String, Object> document;
  protected String acdUrl;
  protected String apiKey;
  protected String flowId;
  protected String accessToken;
  protected List<Object> otherAnnotators;

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

    private Builder(AddCorpusDocumentOptions addCorpusDocumentOptions) {
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
    public Builder(String corpus) {
      this.corpus = corpus;
    }

    /**
     * Builds a AddCorpusDocumentOptions.
     *
     * @return the new AddCorpusDocumentOptions instance
     */
    public AddCorpusDocumentOptions build() {
      return new AddCorpusDocumentOptions(this);
    }

    /**
     * Adds an otherAnnotators to otherAnnotators.
     *
     * @param otherAnnotators the new otherAnnotators
     * @return the AddCorpusDocumentOptions builder
     */
    public Builder addOtherAnnotators(Object otherAnnotators) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(otherAnnotators,
        "otherAnnotators cannot be null");
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
    public Builder corpus(String corpus) {
      this.corpus = corpus;
      return this;
    }

    /**
     * Set the document.
     *
     * @param document the document
     * @return the AddCorpusDocumentOptions builder
     */
    public Builder document(Map<String, Object> document) {
      this.document = document;
      return this;
    }

    /**
     * Set the acdUrl.
     *
     * @param acdUrl the acdUrl
     * @return the AddCorpusDocumentOptions builder
     */
    public Builder acdUrl(String acdUrl) {
      this.acdUrl = acdUrl;
      return this;
    }

    /**
     * Set the apiKey.
     *
     * @param apiKey the apiKey
     * @return the AddCorpusDocumentOptions builder
     */
    public Builder apiKey(String apiKey) {
      this.apiKey = apiKey;
      return this;
    }

    /**
     * Set the flowId.
     *
     * @param flowId the flowId
     * @return the AddCorpusDocumentOptions builder
     */
    public Builder flowId(String flowId) {
      this.flowId = flowId;
      return this;
    }

    /**
     * Set the accessToken.
     *
     * @param accessToken the accessToken
     * @return the AddCorpusDocumentOptions builder
     */
    public Builder accessToken(String accessToken) {
      this.accessToken = accessToken;
      return this;
    }

    /**
     * Set the otherAnnotators.
     * Existing otherAnnotators will be replaced.
     *
     * @param otherAnnotators the otherAnnotators
     * @return the AddCorpusDocumentOptions builder
     */
    public Builder otherAnnotators(List<Object> otherAnnotators) {
      this.otherAnnotators = otherAnnotators;
      return this;
    }
  }

  protected AddCorpusDocumentOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.corpus,
      "corpus cannot be empty");
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
   * Annotator for clincial data url.
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

