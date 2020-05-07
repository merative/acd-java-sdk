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
 * The typeahead options.
 */
public class TypeaheadOptions extends GenericModel {

  public interface Ontologies {
    /** concepts. */
    String CONCEPTS = "concepts";
    /** mesh. */
    String MESH = "mesh";
  }

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
  protected String query;
  protected List<String> ontologies;
  protected List<String> types;
  protected String category;
  protected Boolean verbose;
  protected Long limit;
  protected Long maxHitCount;
  protected Boolean noDuplicates;

  /**
   * Builder.
   */
  public static class Builder {
    private String corpus;
    private String query;
    private List<String> ontologies;
    private List<String> types;
    private String category;
    private Boolean verbose;
    private Long limit;
    private Long maxHitCount;
    private Boolean noDuplicates;

    private Builder(TypeaheadOptions typeaheadOptions) {
      this.corpus = typeaheadOptions.corpus;
      this.query = typeaheadOptions.query;
      this.ontologies = typeaheadOptions.ontologies;
      this.types = typeaheadOptions.types;
      this.category = typeaheadOptions.category;
      this.verbose = typeaheadOptions.verbose;
      this.limit = typeaheadOptions.limit;
      this.maxHitCount = typeaheadOptions.maxHitCount;
      this.noDuplicates = typeaheadOptions.noDuplicates;
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
     * @param query the query
     */
    public Builder(String corpus, String query) {
      this.corpus = corpus;
      this.query = query;
    }

    /**
     * Builds a TypeaheadOptions.
     *
     * @return the new TypeaheadOptions instance
     */
    public TypeaheadOptions build() {
      return new TypeaheadOptions(this);
    }

    /**
     * Adds an ontologies to ontologies.
     *
     * @param ontologies the new ontologies
     * @return the TypeaheadOptions builder
     */
    public Builder addOntologies(String ontologies) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(ontologies,
        "ontologies cannot be null");
      if (this.ontologies == null) {
        this.ontologies = new ArrayList<String>();
      }
      this.ontologies.add(ontologies);
      return this;
    }

    /**
     * Adds an types to types.
     *
     * @param types the new types
     * @return the TypeaheadOptions builder
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
     * @return the TypeaheadOptions builder
     */
    public Builder corpus(String corpus) {
      this.corpus = corpus;
      return this;
    }

    /**
     * Set the query.
     *
     * @param query the query
     * @return the TypeaheadOptions builder
     */
    public Builder query(String query) {
      this.query = query;
      return this;
    }

    /**
     * Set the ontologies.
     * Existing ontologies will be replaced.
     *
     * @param ontologies the ontologies
     * @return the TypeaheadOptions builder
     */
    public Builder ontologies(List<String> ontologies) {
      this.ontologies = ontologies;
      return this;
    }

    /**
     * Set the types.
     * Existing types will be replaced.
     *
     * @param types the types
     * @return the TypeaheadOptions builder
     */
    public Builder types(List<String> types) {
      this.types = types;
      return this;
    }

    /**
     * Set the category.
     *
     * @param category the category
     * @return the TypeaheadOptions builder
     */
    public Builder category(String category) {
      this.category = category;
      return this;
    }

    /**
     * Set the verbose.
     *
     * @param verbose the verbose
     * @return the TypeaheadOptions builder
     */
    public Builder verbose(Boolean verbose) {
      this.verbose = verbose;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the TypeaheadOptions builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }

    /**
     * Set the maxHitCount.
     *
     * @param maxHitCount the maxHitCount
     * @return the TypeaheadOptions builder
     */
    public Builder maxHitCount(long maxHitCount) {
      this.maxHitCount = maxHitCount;
      return this;
    }

    /**
     * Set the noDuplicates.
     *
     * @param noDuplicates the noDuplicates
     * @return the TypeaheadOptions builder
     */
    public Builder noDuplicates(Boolean noDuplicates) {
      this.noDuplicates = noDuplicates;
      return this;
    }
  }

  protected TypeaheadOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.corpus,
      "corpus cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.query,
      "query cannot be null");
    corpus = builder.corpus;
    query = builder.query;
    ontologies = builder.ontologies;
    types = builder.types;
    category = builder.category;
    verbose = builder.verbose;
    limit = builder.limit;
    maxHitCount = builder.maxHitCount;
    noDuplicates = builder.noDuplicates;
  }

  /**
   * New builder.
   *
   * @return a TypeaheadOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the corpus.
   *
   * Comma-separated corpora names.
   *
   * @return the corpus
   */
  public String corpus() {
    return corpus;
  }

  /**
   * Gets the query.
   *
   * Query string.
   *
   * @return the query
   */
  public String query() {
    return query;
  }

  /**
   * Gets the ontologies.
   *
   * Include suggestions belonging to the selected ontology(ies).
   *
   * @return the ontologies
   */
  public List<String> ontologies() {
    return ontologies;
  }

  /**
   * Gets the types.
   *
   * Include or exclude suggestions belonging to one of these types.  Types can be found using
   * /v1/corpora/{corpus}/types method.  Defaults to all.
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
   * Gets the verbose.
   *
   * Verbose output.  Include hit counts and relationship counts for each concept.
   *
   * @return the verbose
   */
  public Boolean verbose() {
    return verbose;
  }

  /**
   * Gets the limit.
   *
   * Maximum number of suggestions to return.
   *
   * @return the limit
   */
  public Long limit() {
    return limit;
  }

  /**
   * Gets the maxHitCount.
   *
   * Maximum hit (document) count for suggested concepts. Default is 500000.  High hit count concepts tend to be very
   * broad (e.g, Disease) and result in longer search times.
   *
   * @return the maxHitCount
   */
  public Long maxHitCount() {
    return maxHitCount;
  }

  /**
   * Gets the noDuplicates.
   *
   * Remove duplicate concepts.
   *
   * @return the noDuplicates
   */
  public Boolean noDuplicates() {
    return noDuplicates;
  }
}

