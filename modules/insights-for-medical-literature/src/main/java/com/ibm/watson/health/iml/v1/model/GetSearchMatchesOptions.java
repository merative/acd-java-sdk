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
 * The getSearchMatches options.
 */
public class GetSearchMatchesOptions extends GenericModel {

  protected String corpus;
  protected String documentId;
  protected Float minScore;
  protected List<String> cuis;
  protected List<String> text;
  protected List<String> types;
  protected List<String> attributes;
  protected List<String> values;
  protected List<String> nluRelations;
  protected Long limit;
  protected String searchTagBegin;
  protected String searchTagEnd;
  protected String relatedTagBegin;
  protected String relatedTagEnd;
  protected String fields;

  /**
   * Builder.
   */
  public static class Builder {
    private String corpus;
    private String documentId;
    private Float minScore;
    private List<String> cuis;
    private List<String> text;
    private List<String> types;
    private List<String> attributes;
    private List<String> values;
    private List<String> nluRelations;
    private Long limit;
    private String searchTagBegin;
    private String searchTagEnd;
    private String relatedTagBegin;
    private String relatedTagEnd;
    private String fields;

    private Builder(GetSearchMatchesOptions getSearchMatchesOptions) {
      this.corpus = getSearchMatchesOptions.corpus;
      this.documentId = getSearchMatchesOptions.documentId;
      this.minScore = getSearchMatchesOptions.minScore;
      this.cuis = getSearchMatchesOptions.cuis;
      this.text = getSearchMatchesOptions.text;
      this.types = getSearchMatchesOptions.types;
      this.attributes = getSearchMatchesOptions.attributes;
      this.values = getSearchMatchesOptions.values;
      this.nluRelations = getSearchMatchesOptions.nluRelations;
      this.limit = getSearchMatchesOptions.limit;
      this.searchTagBegin = getSearchMatchesOptions.searchTagBegin;
      this.searchTagEnd = getSearchMatchesOptions.searchTagEnd;
      this.relatedTagBegin = getSearchMatchesOptions.relatedTagBegin;
      this.relatedTagEnd = getSearchMatchesOptions.relatedTagEnd;
      this.fields = getSearchMatchesOptions.fields;
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
     * @param minScore the minScore
     */
    public Builder(String corpus, String documentId, Float minScore) {
      this.corpus = corpus;
      this.documentId = documentId;
      this.minScore = minScore;
    }

    /**
     * Builds a GetSearchMatchesOptions.
     *
     * @return the new GetSearchMatchesOptions instance
     */
    public GetSearchMatchesOptions build() {
      return new GetSearchMatchesOptions(this);
    }

    /**
     * Adds an cuis to cuis.
     *
     * @param cuis the new cuis
     * @return the GetSearchMatchesOptions builder
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
     * Adds an text to text.
     *
     * @param text the new text
     * @return the GetSearchMatchesOptions builder
     */
    public Builder addText(String text) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(text,
        "text cannot be null");
      if (this.text == null) {
        this.text = new ArrayList<String>();
      }
      this.text.add(text);
      return this;
    }

    /**
     * Adds an types to types.
     *
     * @param types the new types
     * @return the GetSearchMatchesOptions builder
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
     * Adds an attributes to attributes.
     *
     * @param attributes the new attributes
     * @return the GetSearchMatchesOptions builder
     */
    public Builder addAttributes(String attributes) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(attributes,
        "attributes cannot be null");
      if (this.attributes == null) {
        this.attributes = new ArrayList<String>();
      }
      this.attributes.add(attributes);
      return this;
    }

    /**
     * Adds an values to values.
     *
     * @param values the new values
     * @return the GetSearchMatchesOptions builder
     */
    public Builder addValues(String values) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(values,
        "values cannot be null");
      if (this.values == null) {
        this.values = new ArrayList<String>();
      }
      this.values.add(values);
      return this;
    }

    /**
     * Adds an nluRelations to nluRelations.
     *
     * @param nluRelations the new nluRelations
     * @return the GetSearchMatchesOptions builder
     */
    public Builder addNluRelations(String nluRelations) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(nluRelations,
        "nluRelations cannot be null");
      if (this.nluRelations == null) {
        this.nluRelations = new ArrayList<String>();
      }
      this.nluRelations.add(nluRelations);
      return this;
    }

    /**
     * Set the corpus.
     *
     * @param corpus the corpus
     * @return the GetSearchMatchesOptions builder
     */
    public Builder corpus(String corpus) {
      this.corpus = corpus;
      return this;
    }

    /**
     * Set the documentId.
     *
     * @param documentId the documentId
     * @return the GetSearchMatchesOptions builder
     */
    public Builder documentId(String documentId) {
      this.documentId = documentId;
      return this;
    }

    /**
     * Set the minScore.
     *
     * @param minScore the minScore
     * @return the GetSearchMatchesOptions builder
     */
    public Builder minScore(Float minScore) {
      this.minScore = minScore;
      return this;
    }

    /**
     * Set the cuis.
     * Existing cuis will be replaced.
     *
     * @param cuis the cuis
     * @return the GetSearchMatchesOptions builder
     */
    public Builder cuis(List<String> cuis) {
      this.cuis = cuis;
      return this;
    }

    /**
     * Set the text.
     * Existing text will be replaced.
     *
     * @param text the text
     * @return the GetSearchMatchesOptions builder
     */
    public Builder text(List<String> text) {
      this.text = text;
      return this;
    }

    /**
     * Set the types.
     * Existing types will be replaced.
     *
     * @param types the types
     * @return the GetSearchMatchesOptions builder
     */
    public Builder types(List<String> types) {
      this.types = types;
      return this;
    }

    /**
     * Set the attributes.
     * Existing attributes will be replaced.
     *
     * @param attributes the attributes
     * @return the GetSearchMatchesOptions builder
     */
    public Builder attributes(List<String> attributes) {
      this.attributes = attributes;
      return this;
    }

    /**
     * Set the values.
     * Existing values will be replaced.
     *
     * @param values the values
     * @return the GetSearchMatchesOptions builder
     */
    public Builder values(List<String> values) {
      this.values = values;
      return this;
    }

    /**
     * Set the nluRelations.
     * Existing nluRelations will be replaced.
     *
     * @param nluRelations the nluRelations
     * @return the GetSearchMatchesOptions builder
     */
    public Builder nluRelations(List<String> nluRelations) {
      this.nluRelations = nluRelations;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the GetSearchMatchesOptions builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }

    /**
     * Set the searchTagBegin.
     *
     * @param searchTagBegin the searchTagBegin
     * @return the GetSearchMatchesOptions builder
     */
    public Builder searchTagBegin(String searchTagBegin) {
      this.searchTagBegin = searchTagBegin;
      return this;
    }

    /**
     * Set the searchTagEnd.
     *
     * @param searchTagEnd the searchTagEnd
     * @return the GetSearchMatchesOptions builder
     */
    public Builder searchTagEnd(String searchTagEnd) {
      this.searchTagEnd = searchTagEnd;
      return this;
    }

    /**
     * Set the relatedTagBegin.
     *
     * @param relatedTagBegin the relatedTagBegin
     * @return the GetSearchMatchesOptions builder
     */
    public Builder relatedTagBegin(String relatedTagBegin) {
      this.relatedTagBegin = relatedTagBegin;
      return this;
    }

    /**
     * Set the relatedTagEnd.
     *
     * @param relatedTagEnd the relatedTagEnd
     * @return the GetSearchMatchesOptions builder
     */
    public Builder relatedTagEnd(String relatedTagEnd) {
      this.relatedTagEnd = relatedTagEnd;
      return this;
    }

    /**
     * Set the fields.
     *
     * @param fields the fields
     * @return the GetSearchMatchesOptions builder
     */
    public Builder fields(String fields) {
      this.fields = fields;
      return this;
    }
  }

  protected GetSearchMatchesOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.corpus,
      "corpus cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.documentId,
      "documentId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.minScore,
      "minScore cannot be null");
    corpus = builder.corpus;
    documentId = builder.documentId;
    minScore = builder.minScore;
    cuis = builder.cuis;
    text = builder.text;
    types = builder.types;
    attributes = builder.attributes;
    values = builder.values;
    nluRelations = builder.nluRelations;
    limit = builder.limit;
    searchTagBegin = builder.searchTagBegin;
    searchTagEnd = builder.searchTagEnd;
    relatedTagBegin = builder.relatedTagBegin;
    relatedTagEnd = builder.relatedTagEnd;
    fields = builder.fields;
  }

  /**
   * New builder.
   *
   * @return a GetSearchMatchesOptions builder
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
   * Document ID (e.g, 7014026).
   *
   * @return the documentId
   */
  public String documentId() {
    return documentId;
  }

  /**
   * Gets the minScore.
   *
   * Minimum score .0 to 1.0.
   *
   * @return the minScore
   */
  public Float minScore() {
    return minScore;
  }

  /**
   * Gets the cuis.
   *
   * cui[,rank,[type]] - Example: "C0030567,10". The rank is an optional value from 0 to 10 (defalut is 10). Special
   * rank values: 0=omit, 10=require. Related concepts can also be included by appending, '-PAR' (parents), '-CHD'
   * (children), or '-SIB' (siblings) to the CUI (eg., to include all children of C0030567: 'C0030567-CHD')).  The type
   * may explicitly select a semanic type for a concept.  If no type is specified, a default type is selected.
   *
   * @return the cuis
   */
  public List<String> cuis() {
    return cuis;
  }

  /**
   * Gets the text.
   *
   * Case insensitive text searches.
   *
   * @return the text
   */
  public List<String> text() {
    return text;
  }

  /**
   * Gets the types.
   *
   * Highlight all text spans matching these semantic types.  Semantic types for the corpus can be found using the
   * /v1/corpora/{corpus}/types method.
   *
   * @return the types
   */
  public List<String> types() {
    return types;
  }

  /**
   * Gets the attributes.
   *
   * Highlight all text spans matching these attributes.  An attribute may also specify a range value (e.g.,
   * age:years:65-100) or  a string value (e.g., gender:female).  The attribute may be qualified with one or more
   * qualifiers (e.g., Treated,Severe&gt;&gt;diabetes)  An attribute may target a specific CUI.  (e.g.,
   * C0003864::disease).
   *
   * @return the attributes
   */
  public List<String> attributes() {
    return attributes;
  }

  /**
   * Gets the values.
   *
   * Highlight all text spans matching these values.  e.g., age:years:within:65-100 or gender:female  a string value
   * (e.g., gender:female).
   *
   * @return the values
   */
  public List<String> values() {
    return values;
  }

  /**
   * Gets the nluRelations.
   *
   * Highlight all text spans matching these NLU relations.  e.g., druggroup,treat,indication.
   *
   * @return the nluRelations
   */
  public List<String> nluRelations() {
    return nluRelations;
  }

  /**
   * Gets the limit.
   *
   * Limit the number of matching passages per search concept/search term (1 to 250).  Default is 50.
   *
   * @return the limit
   */
  public Long limit() {
    return limit;
  }

  /**
   * Gets the searchTagBegin.
   *
   * HTML tag used to highlight search concepts found in the text.  Default is '&amp;ltb&amp;gt'.
   *
   * @return the searchTagBegin
   */
  public String searchTagBegin() {
    return searchTagBegin;
  }

  /**
   * Gets the searchTagEnd.
   *
   * HTML tag used to highlight search concepts found in the text.  Default is '&amp;lt/b&amp;gt'.
   *
   * @return the searchTagEnd
   */
  public String searchTagEnd() {
    return searchTagEnd;
  }

  /**
   * Gets the relatedTagBegin.
   *
   * HTML tag used to highlight related concepts found in the text.
   *
   * @return the relatedTagBegin
   */
  public String relatedTagBegin() {
    return relatedTagBegin;
  }

  /**
   * Gets the relatedTagEnd.
   *
   * HTML tag used to highlight related concepts found in the text.
   *
   * @return the relatedTagEnd
   */
  public String relatedTagEnd() {
    return relatedTagEnd;
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
}

