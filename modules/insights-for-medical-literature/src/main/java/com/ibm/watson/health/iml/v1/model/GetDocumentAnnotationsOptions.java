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
 * The getDocumentAnnotations options.
 */
public class GetDocumentAnnotationsOptions extends GenericModel {

  protected String corpus;
  protected String documentId;
  protected String documentSection;
  protected List<String> cuis;
  protected Boolean includeText;

  /**
   * Builder.
   */
  public static class Builder {
    private String corpus;
    private String documentId;
    private String documentSection;
    private List<String> cuis;
    private Boolean includeText;

    private Builder(GetDocumentAnnotationsOptions getDocumentAnnotationsOptions) {
      this.corpus = getDocumentAnnotationsOptions.corpus;
      this.documentId = getDocumentAnnotationsOptions.documentId;
      this.documentSection = getDocumentAnnotationsOptions.documentSection;
      this.cuis = getDocumentAnnotationsOptions.cuis;
      this.includeText = getDocumentAnnotationsOptions.includeText;
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
     * @param documentSection the documentSection
     */
    public Builder(String corpus, String documentId, String documentSection) {
      this.corpus = corpus;
      this.documentId = documentId;
      this.documentSection = documentSection;
    }

    /**
     * Builds a GetDocumentAnnotationsOptions.
     *
     * @return the new GetDocumentAnnotationsOptions instance
     */
    public GetDocumentAnnotationsOptions build() {
      return new GetDocumentAnnotationsOptions(this);
    }

    /**
     * Adds an cuis to cuis.
     *
     * @param cuis the new cuis
     * @return the GetDocumentAnnotationsOptions builder
     */
    public Builder addCuis(String cuis) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(cuis,
        "cuis cannot be null");
      if (this.cuis == null) {
        this.cuis = new ArrayList<String>();
      }
      this.cuis.add(cuis);
      return this;
    }

    /**
     * Set the corpus.
     *
     * @param corpus the corpus
     * @return the GetDocumentAnnotationsOptions builder
     */
    public Builder corpus(String corpus) {
      this.corpus = corpus;
      return this;
    }

    /**
     * Set the documentId.
     *
     * @param documentId the documentId
     * @return the GetDocumentAnnotationsOptions builder
     */
    public Builder documentId(String documentId) {
      this.documentId = documentId;
      return this;
    }

    /**
     * Set the documentSection.
     *
     * @param documentSection the documentSection
     * @return the GetDocumentAnnotationsOptions builder
     */
    public Builder documentSection(String documentSection) {
      this.documentSection = documentSection;
      return this;
    }

    /**
     * Set the cuis.
     * Existing cuis will be replaced.
     *
     * @param cuis the cuis
     * @return the GetDocumentAnnotationsOptions builder
     */
    public Builder cuis(List<String> cuis) {
      this.cuis = cuis;
      return this;
    }

    /**
     * Set the includeText.
     *
     * @param includeText the includeText
     * @return the GetDocumentAnnotationsOptions builder
     */
    public Builder includeText(Boolean includeText) {
      this.includeText = includeText;
      return this;
    }
  }

  protected GetDocumentAnnotationsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.corpus,
      "corpus cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.documentId,
      "documentId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.documentSection,
      "documentSection cannot be null");
    corpus = builder.corpus;
    documentId = builder.documentId;
    documentSection = builder.documentSection;
    cuis = builder.cuis;
    includeText = builder.includeText;
  }

  /**
   * New builder.
   *
   * @return a GetDocumentAnnotationsOptions builder
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
   * Gets the documentSection.
   *
   * Document section to annotate. (e.g., title, abstract, body...
   *
   * @return the documentSection
   */
  public String documentSection() {
    return documentSection;
  }

  /**
   * Gets the cuis.
   *
   * Concepts to show.  Defaults to all concepts.
   *
   * @return the cuis
   */
  public List<String> cuis() {
    return cuis;
  }

  /**
   * Gets the includeText.
   *
   * Include document text.
   *
   * @return the includeText
   */
  public Boolean includeText() {
    return includeText;
  }
}

