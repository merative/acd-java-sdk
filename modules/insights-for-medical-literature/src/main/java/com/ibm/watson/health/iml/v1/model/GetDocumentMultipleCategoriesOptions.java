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

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import com.ibm.cloud.sdk.core.util.Validator;

/**
 * The getDocumentMultipleCategories options.
 */
public class GetDocumentMultipleCategoriesOptions extends GenericModel {

  private String corpus;
  private String documentId;
  private String highlightTagBegin;
  private String highlightTagEnd;
  private String fields;
  private List<Category> categories;
  private Long limit;

  /**
   * Builder.
   */
  public static class Builder {
    private String corpus;
    private String documentId;
    private String highlightTagBegin;
    private String highlightTagEnd;
    private String fields;
    private List<Category> categories;
    private Long limit;

    private Builder(
    		GetDocumentMultipleCategoriesOptions
    		getDocumentMultipleCategoriesOptions) {
      corpus = getDocumentMultipleCategoriesOptions.corpus;
      documentId = getDocumentMultipleCategoriesOptions.documentId;
      highlightTagBegin =
    		  getDocumentMultipleCategoriesOptions.highlightTagBegin;
      highlightTagEnd = getDocumentMultipleCategoriesOptions.highlightTagEnd;
      fields = getDocumentMultipleCategoriesOptions.fields;
      categories = getDocumentMultipleCategoriesOptions.categories;
      limit = getDocumentMultipleCategoriesOptions.limit;
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
     * Builds a GetDocumentMultipleCategoriesOptions.
     *
     * @return the getDocumentMultipleCategoriesOptions
     */
    public GetDocumentMultipleCategoriesOptions build() {
      return new GetDocumentMultipleCategoriesOptions(this);
    }

    /**
     * Adds an categories to categories.
     *
     * @param categories the new categories
     * @return the GetDocumentMultipleCategoriesOptions builder
     */
    public Builder addCategories(Category categories) {
      Validator.notNull(categories, "categories cannot be null");
      if (this.categories == null) {
        this.categories = new ArrayList<Category>();
      }
      this.categories.add(categories);
      return this;
    }

    /**
     * Set the corpus.
     *
     * @param corpus the corpus
     * @return the GetDocumentMultipleCategoriesOptions builder
     */
    public Builder corpus(String corpus) {
      this.corpus = corpus;
      return this;
    }

    /**
     * Set the documentId.
     *
     * @param documentId the documentId
     * @return the GetDocumentMultipleCategoriesOptions builder
     */
    public Builder documentId(String documentId) {
      this.documentId = documentId;
      return this;
    }

    /**
     * Set the highlightTagBegin.
     *
     * @param highlightTagBegin the highlightTagBegin
     * @return the GetDocumentMultipleCategoriesOptions builder
     */
    public Builder highlightTagBegin(String highlightTagBegin) {
      this.highlightTagBegin = highlightTagBegin;
      return this;
    }

    /**
     * Set the highlightTagEnd.
     *
     * @param highlightTagEnd the highlightTagEnd
     * @return the GetDocumentMultipleCategoriesOptions builder
     */
    public Builder highlightTagEnd(String highlightTagEnd) {
      this.highlightTagEnd = highlightTagEnd;
      return this;
    }

    /**
     * Set the fields.
     *
     * @param fields the fields
     * @return the GetDocumentMultipleCategoriesOptions builder
     */
    public Builder fields(String fields) {
      this.fields = fields;
      return this;
    }

    /**
     * Set the categories.
     * Existing categories will be replaced.
     *
     * @param categories the categories
     * @return the GetDocumentMultipleCategoriesOptions builder
     */
    public Builder categories(List<Category> categories) {
      this.categories = categories;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the GetDocumentMultipleCategoriesOptions builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }
  }

  private GetDocumentMultipleCategoriesOptions(Builder builder) {
    Validator.notEmpty(builder.corpus, "corpus cannot be empty");
    Validator.notEmpty(builder.documentId, "documentId cannot be empty");
    corpus = builder.corpus;
    documentId = builder.documentId;
    highlightTagBegin = builder.highlightTagBegin;
    highlightTagEnd = builder.highlightTagEnd;
    fields = builder.fields;
    categories = builder.categories;
    limit = builder.limit;
  }

  /**
   * New builder.
   *
   * @return a GetDocumentMultipleCategoriesOptions builder
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
   * Gets the highlightTagBegin.
   *
   * HTML tag used to highlight concepts found in the text.
   * Default is '&ltb&gt'.
   *
   * @return the highlightTagBegin
   */
  public String highlightTagBegin() {
    return highlightTagBegin;
  }

  /**
   * Gets the highlightTagEnd.
   *
   * HTML tag used to highlight concepts found in the text.
   * Default is '&lt/b&gt'.
   *
   * @return the highlightTagEnd
   */
  public String highlightTagEnd() {
    return highlightTagEnd;
  }

  /**
   * Gets the fields.
   *
   * Comma separated list of fields to return:
   *   passages, annotations, highlightedTitle, highlightedAbstract,
   * highlightedBody.
   *
   * @return the fields
   */
  public String fields() {
    return fields;
  }

  /**
   * Gets the categories.
   *
   * @return the categories
   */
  public List<Category> categories() {
    return categories;
  }

  /**
   * Gets the limit.
   *
   * Limit the number of passages per search concept (1 to 250).
   * Default is 50.
   *
   * @return the limit
   */
  public Long limit() {
    return limit;
  }
}

