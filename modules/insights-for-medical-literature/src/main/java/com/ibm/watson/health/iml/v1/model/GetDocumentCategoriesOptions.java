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
 * The getDocumentCategories options.
 */
public class GetDocumentCategoriesOptions extends GenericModel {

  /**
   * Select concepts belonging to disorders, drugs or genes.
   */
  public interface Category {
    /** disorders. */
    String DISORDERS = "disorders";
    /** drugs. */
    String DRUGS = "drugs";
    /** genes. */
    String GENES = "genes";
  }

  protected String corpus;
  protected String documentId;
  protected String highlightTagBegin;
  protected String highlightTagEnd;
  protected List<String> types;
  protected String category;
  protected Boolean onlyNegatedConcepts;
  protected String fields;
  protected Long limit;

  /**
   * Builder.
   */
  public static class Builder {
    private String corpus;
    private String documentId;
    private String highlightTagBegin;
    private String highlightTagEnd;
    private List<String> types;
    private String category;
    private Boolean onlyNegatedConcepts = false;
    private String fields;
    private Long limit = 50L;

    private Builder(GetDocumentCategoriesOptions getDocumentCategoriesOptions) {
      this.corpus = getDocumentCategoriesOptions.corpus;
      this.documentId = getDocumentCategoriesOptions.documentId;
      this.highlightTagBegin = getDocumentCategoriesOptions.highlightTagBegin;
      this.highlightTagEnd = getDocumentCategoriesOptions.highlightTagEnd;
      this.types = getDocumentCategoriesOptions.types;
      this.category = getDocumentCategoriesOptions.category;
      if (getDocumentCategoriesOptions.onlyNegatedConcepts() != null) {
    	  this.onlyNegatedConcepts = getDocumentCategoriesOptions.onlyNegatedConcepts;
      }
      this.fields = getDocumentCategoriesOptions.fields;
      this.limit = getDocumentCategoriesOptions.limit;
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
     * Builds a GetDocumentCategoriesOptions.
     *
     * @return the new GetDocumentCategoriesOptions instance
     */
    public GetDocumentCategoriesOptions build() {
      return new GetDocumentCategoriesOptions(this);
    }

    /**
     * Adds an types to types.
     *
     * @param types the new types
     * @return the GetDocumentCategoriesOptions builder
     */
    public Builder addTypes(String types) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(types,
        "types cannot be null");
      if (this.types == null) {
        this.types = new ArrayList<String>();
      }
      this.types.add(types);
      return this;
    }

    /**
     * Set the corpus.
     *
     * @param corpus the corpus
     * @return the GetDocumentCategoriesOptions builder
     */
    public Builder corpus(String corpus) {
      this.corpus = corpus;
      return this;
    }

    /**
     * Set the documentId.
     *
     * @param documentId the documentId
     * @return the GetDocumentCategoriesOptions builder
     */
    public Builder documentId(String documentId) {
      this.documentId = documentId;
      return this;
    }

    /**
     * Set the highlightTagBegin.
     *
     * @param highlightTagBegin the highlightTagBegin
     * @return the GetDocumentCategoriesOptions builder
     */
    public Builder highlightTagBegin(String highlightTagBegin) {
      this.highlightTagBegin = highlightTagBegin;
      return this;
    }

    /**
     * Set the highlightTagEnd.
     *
     * @param highlightTagEnd the highlightTagEnd
     * @return the GetDocumentCategoriesOptions builder
     */
    public Builder highlightTagEnd(String highlightTagEnd) {
      this.highlightTagEnd = highlightTagEnd;
      return this;
    }

    /**
     * Set the types.
     * Existing types will be replaced.
     *
     * @param types the types
     * @return the GetDocumentCategoriesOptions builder
     */
    public Builder types(List<String> types) {
      this.types = types;
      return this;
    }

    /**
     * Set the category.
     *
     * @param category the category
     * @return the GetDocumentCategoriesOptions builder
     */
    public Builder category(String category) {
      this.category = category;
      return this;
    }

    /**
     * Set the onlyNegatedConcepts.
     *
     * @param onlyNegatedConcepts the onlyNegatedConcepts
     * @return the GetDocumentCategoriesOptions builder
     */
    public Builder onlyNegatedConcepts(Boolean onlyNegatedConcepts) {
      this.onlyNegatedConcepts = onlyNegatedConcepts;
      return this;
    }

    /**
     * Set the fields.
     *
     * @param fields the fields
     * @return the GetDocumentCategoriesOptions builder
     */
    public Builder fields(String fields) {
      this.fields = fields;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the GetDocumentCategoriesOptions builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }
  }

  protected GetDocumentCategoriesOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.corpus,
      "corpus cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.documentId,
      "documentId cannot be empty");
    corpus = builder.corpus;
    documentId = builder.documentId;
    highlightTagBegin = builder.highlightTagBegin;
    highlightTagEnd = builder.highlightTagEnd;
    types = builder.types;
    category = builder.category;
    onlyNegatedConcepts = builder.onlyNegatedConcepts;
    fields = builder.fields;
    limit = builder.limit;
  }

  /**
   * New builder.
   *
   * @return a GetDocumentCategoriesOptions builder
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
   * HTML tag used to highlight concepts found in the text.  Default is '&amp;ltb&amp;gt'.
   *
   * @return the highlightTagBegin
   */
  public String highlightTagBegin() {
    return highlightTagBegin;
  }

  /**
   * Gets the highlightTagEnd.
   *
   * HTML tag used to highlight concepts found in the text.  Default is '&amp;lt/b&amp;gt'.
   *
   * @return the highlightTagEnd
   */
  public String highlightTagEnd() {
    return highlightTagEnd;
  }

  /**
   * Gets the types.
   *
   * Select concepts belonging to these semantic types to return. Semantic types for the corpus can be found using the
   * /v1/corpora/{corpus}/types method.Defaults to 'all'.
   *
   * @return the types
   */
  public List<String> types() {
    return types;
  }

  /**
   * Gets the category.
   *
   * Select concepts belonging to disorders, drugs or genes.
   *
   * @return the category
   */
  public String category() {
    return category;
  }

  /**
   * Gets the onlyNegatedConcepts.
   *
   * Only return negated concepts?.
   *
   * @return the onlyNegatedConcepts
   */
  public Boolean onlyNegatedConcepts() {
    return onlyNegatedConcepts;
  }

  /**
   * Gets the fields.
   *
   * Comma separated list of fields to return:  passages, annotations, highlightedTitle, highlightedAbstract,
   * highlightedBody, highlightedSections.
   *
   * @return the fields
   */
  public String fields() {
    return fields;
  }

  /**
   * Gets the limit.
   *
   * Limit the number of passages per search concept (1 to 250).  Default is 50.
   *
   * @return the limit
   */
  public Long limit() {
    return limit;
  }
}

