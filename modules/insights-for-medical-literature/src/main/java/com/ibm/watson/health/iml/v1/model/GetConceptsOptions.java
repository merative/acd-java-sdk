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
 * The getConcepts options.
 */
public class GetConceptsOptions extends GenericModel {

  protected String corpus;
  protected List<String> cuis;
  protected List<String> preferredNames;
  protected List<String> surfaceForms;
  protected List<String> attributes;
  protected Boolean verbose;
  protected String sort;
  protected Long limit;

  /**
   * Builder.
   */
  public static class Builder {
    private String corpus;
    private List<String> cuis;
    private List<String> preferredNames;
    private List<String> surfaceForms;
    private List<String> attributes;
    private Boolean verbose;
    private String sort;
    private Long limit;

    private Builder(GetConceptsOptions getConceptsOptions) {
      this.corpus = getConceptsOptions.corpus;
      this.cuis = getConceptsOptions.cuis;
      this.preferredNames = getConceptsOptions.preferredNames;
      this.surfaceForms = getConceptsOptions.surfaceForms;
      this.attributes = getConceptsOptions.attributes;
      this.verbose = getConceptsOptions.verbose;
      this.sort = getConceptsOptions.sort;
      this.limit = getConceptsOptions.limit;
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
     * Builds a GetConceptsOptions.
     *
     * @return the new GetConceptsOptions instance
     */
    public GetConceptsOptions build() {
      return new GetConceptsOptions(this);
    }

    /**
     * Adds an cuis to cuis.
     *
     * @param cuis the new cuis
     * @return the GetConceptsOptions builder
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
     * Adds an preferredNames to preferredNames.
     *
     * @param preferredNames the new preferredNames
     * @return the GetConceptsOptions builder
     */
    public Builder addPreferredNames(String preferredNames) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(preferredNames,
        "preferredNames cannot be null");
      if (this.preferredNames == null) {
        this.preferredNames = new ArrayList<String>();
      }
      this.preferredNames.add(preferredNames);
      return this;
    }

    /**
     * Adds an surfaceForms to surfaceForms.
     *
     * @param surfaceForms the new surfaceForms
     * @return the GetConceptsOptions builder
     */
    public Builder addSurfaceForms(String surfaceForms) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(surfaceForms,
        "surfaceForms cannot be null");
      if (this.surfaceForms == null) {
        this.surfaceForms = new ArrayList<String>();
      }
      this.surfaceForms.add(surfaceForms);
      return this;
    }

    /**
     * Adds an attributes to attributes.
     *
     * @param attributes the new attributes
     * @return the GetConceptsOptions builder
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
     * Set the corpus.
     *
     * @param corpus the corpus
     * @return the GetConceptsOptions builder
     */
    public Builder corpus(String corpus) {
      this.corpus = corpus;
      return this;
    }

    /**
     * Set the cuis.
     * Existing cuis will be replaced.
     *
     * @param cuis the cuis
     * @return the GetConceptsOptions builder
     */
    public Builder cuis(List<String> cuis) {
      this.cuis = cuis;
      return this;
    }

    /**
     * Set the preferredNames.
     * Existing preferredNames will be replaced.
     *
     * @param preferredNames the preferredNames
     * @return the GetConceptsOptions builder
     */
    public Builder preferredNames(List<String> preferredNames) {
      this.preferredNames = preferredNames;
      return this;
    }

    /**
     * Set the surfaceForms.
     * Existing surfaceForms will be replaced.
     *
     * @param surfaceForms the surfaceForms
     * @return the GetConceptsOptions builder
     */
    public Builder surfaceForms(List<String> surfaceForms) {
      this.surfaceForms = surfaceForms;
      return this;
    }

    /**
     * Set the attributes.
     * Existing attributes will be replaced.
     *
     * @param attributes the attributes
     * @return the GetConceptsOptions builder
     */
    public Builder attributes(List<String> attributes) {
      this.attributes = attributes;
      return this;
    }

    /**
     * Set the verbose.
     *
     * @param verbose the verbose
     * @return the GetConceptsOptions builder
     */
    public Builder verbose(Boolean verbose) {
      this.verbose = verbose;
      return this;
    }

    /**
     * Set the sort.
     *
     * @param sort the sort
     * @return the GetConceptsOptions builder
     */
    public Builder sort(String sort) {
      this.sort = sort;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the GetConceptsOptions builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }
  }

  protected GetConceptsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.corpus,
      "corpus cannot be empty");
    corpus = builder.corpus;
    cuis = builder.cuis;
    preferredNames = builder.preferredNames;
    surfaceForms = builder.surfaceForms;
    attributes = builder.attributes;
    verbose = builder.verbose;
    sort = builder.sort;
    limit = builder.limit;
  }

  /**
   * New builder.
   *
   * @return a GetConceptsOptions builder
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
   * Gets the cuis.
   *
   * Select concepts with the specified CUIs. Each cui is assumed to be from UMLS unless an ontology is explicitly
   * specified using the syntax [ontology:]cui, e.g., 'concepts:C0018787'.
   *
   * @return the cuis
   */
  public List<String> cuis() {
    return cuis;
  }

  /**
   * Gets the preferredNames.
   *
   * Select concepts with the specified preferred names. Each preferred name is assumed to be from UMLS unless an
   * ontology is explicitly specified using the syntax [ontology:::]preferred_name, e.g., 'concepts:::HEART'.
   *
   * @return the preferredNames
   */
  public List<String> preferredNames() {
    return preferredNames;
  }

  /**
   * Gets the surfaceForms.
   *
   * Select all concepts having these surface forms. The match is case insensitive. Each surface form is matched against
   * UMLS unless an ontology is explicitly specified using the syntax [ontology:::]surface_form, e.g., 'concepts:::heart
   * attack'.
   *
   * @return the surfaceForms
   */
  public List<String> surfaceForms() {
    return surfaceForms;
  }

  /**
   * Gets the attributes.
   *
   * Select all concepts having these attributes. The match is case insensitive.
   *
   * @return the attributes
   */
  public List<String> attributes() {
    return attributes;
  }

  /**
   * Gets the verbose.
   *
   * Verbose output.  Default is false.
   *
   * @return the verbose
   */
  public Boolean verbose() {
    return verbose;
  }

  /**
   * Gets the sort.
   *
   * Sort by hitCount (in document count).  Set to ascending order (_sort=+hitCount) or descending order
   * (_sort=-hitCount).
   *
   * @return the sort
   */
  public String sort() {
    return sort;
  }

  /**
   * Gets the limit.
   *
   * Number of possible concepts to return. Default is 250.
   *
   * @return the limit
   */
  public Long limit() {
    return limit;
  }
}

