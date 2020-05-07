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
 * The getRelatedConcepts options.
 */
public class GetRelatedConceptsOptions extends GenericModel {

  /**
   * Select the relationship to retrieve.
   */
  public interface Relationship {
    /** children. */
    String CHILDREN = "children";
    /** parents. */
    String PARENTS = "parents";
    /** siblings. */
    String SIBLINGS = "siblings";
    /** allowedQualifier. */
    String ALLOWEDQUALIFIER = "allowedQualifier";
    /** qualifiedBy. */
    String QUALIFIEDBY = "qualifiedBy";
    /** broader. */
    String BROADER = "broader";
    /** alike. */
    String ALIKE = "alike";
    /** narrower. */
    String NARROWER = "narrower";
    /** other. */
    String OTHER = "other";
    /** relatedUnspecified. */
    String RELATEDUNSPECIFIED = "relatedUnspecified";
    /** related. */
    String RELATED = "related";
    /** synonym. */
    String SYNONYM = "synonym";
    /** notRelated. */
    String NOTRELATED = "notRelated";
    /** chd. */
    String CHD = "chd";
    /** par. */
    String PAR = "par";
    /** sib. */
    String SIB = "sib";
    /** aq. */
    String AQ = "aq";
    /** qb. */
    String QB = "qb";
    /** rb. */
    String RB = "rb";
    /** rl. */
    String RL = "rl";
    /** rn. */
    String RN = "rn";
    /** ro. */
    String RO = "ro";
    /** ru. */
    String RU = "ru";
    /** rq. */
    String RQ = "rq";
    /** sy. */
    String SY = "sy";
    /** xr. */
    String XR = "xr";
  }

  protected String corpus;
  protected String nameOrId;
  protected String relationship;
  protected String ontology;
  protected List<String> relationshipAttributes;
  protected List<String> sources;
  protected Boolean recursive;
  protected Boolean treeLayout;
  protected Long maxDepth;

  /**
   * Builder.
   */
  public static class Builder {
    private String corpus;
    private String nameOrId;
    private String relationship;
    private String ontology;
    private List<String> relationshipAttributes;
    private List<String> sources;
    private Boolean recursive;
    private Boolean treeLayout;
    private Long maxDepth;

    private Builder(GetRelatedConceptsOptions getRelatedConceptsOptions) {
      this.corpus = getRelatedConceptsOptions.corpus;
      this.nameOrId = getRelatedConceptsOptions.nameOrId;
      this.relationship = getRelatedConceptsOptions.relationship;
      this.ontology = getRelatedConceptsOptions.ontology;
      this.relationshipAttributes = getRelatedConceptsOptions.relationshipAttributes;
      this.sources = getRelatedConceptsOptions.sources;
      this.recursive = getRelatedConceptsOptions.recursive;
      this.treeLayout = getRelatedConceptsOptions.treeLayout;
      this.maxDepth = getRelatedConceptsOptions.maxDepth;
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
     * @param nameOrId the nameOrId
     * @param relationship the relationship
     */
    public Builder(String corpus, String nameOrId, String relationship) {
      this.corpus = corpus;
      this.nameOrId = nameOrId;
      this.relationship = relationship;
    }

    /**
     * Builds a GetRelatedConceptsOptions.
     *
     * @return the new GetRelatedConceptsOptions instance
     */
    public GetRelatedConceptsOptions build() {
      return new GetRelatedConceptsOptions(this);
    }

    /**
     * Adds an relationshipAttributes to relationshipAttributes.
     *
     * @param relationshipAttributes the new relationshipAttributes
     * @return the GetRelatedConceptsOptions builder
     */
    public Builder addRelationshipAttributes(String relationshipAttributes) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(relationshipAttributes,
        "relationshipAttributes cannot be null");
      if (this.relationshipAttributes == null) {
        this.relationshipAttributes = new ArrayList<String>();
      }
      this.relationshipAttributes.add(relationshipAttributes);
      return this;
    }

    /**
     * Adds an sources to sources.
     *
     * @param sources the new sources
     * @return the GetRelatedConceptsOptions builder
     */
    public Builder addSources(String sources) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(sources,
        "sources cannot be null");
      if (this.sources == null) {
        this.sources = new ArrayList<String>();
      }
      this.sources.add(sources);
      return this;
    }

    /**
     * Set the corpus.
     *
     * @param corpus the corpus
     * @return the GetRelatedConceptsOptions builder
     */
    public Builder corpus(String corpus) {
      this.corpus = corpus;
      return this;
    }

    /**
     * Set the nameOrId.
     *
     * @param nameOrId the nameOrId
     * @return the GetRelatedConceptsOptions builder
     */
    public Builder nameOrId(String nameOrId) {
      this.nameOrId = nameOrId;
      return this;
    }

    /**
     * Set the relationship.
     *
     * @param relationship the relationship
     * @return the GetRelatedConceptsOptions builder
     */
    public Builder relationship(String relationship) {
      this.relationship = relationship;
      return this;
    }

    /**
     * Set the ontology.
     *
     * @param ontology the ontology
     * @return the GetRelatedConceptsOptions builder
     */
    public Builder ontology(String ontology) {
      this.ontology = ontology;
      return this;
    }

    /**
     * Set the relationshipAttributes.
     * Existing relationshipAttributes will be replaced.
     *
     * @param relationshipAttributes the relationshipAttributes
     * @return the GetRelatedConceptsOptions builder
     */
    public Builder relationshipAttributes(List<String> relationshipAttributes) {
      this.relationshipAttributes = relationshipAttributes;
      return this;
    }

    /**
     * Set the sources.
     * Existing sources will be replaced.
     *
     * @param sources the sources
     * @return the GetRelatedConceptsOptions builder
     */
    public Builder sources(List<String> sources) {
      this.sources = sources;
      return this;
    }

    /**
     * Set the recursive.
     *
     * @param recursive the recursive
     * @return the GetRelatedConceptsOptions builder
     */
    public Builder recursive(Boolean recursive) {
      this.recursive = recursive;
      return this;
    }

    /**
     * Set the treeLayout.
     *
     * @param treeLayout the treeLayout
     * @return the GetRelatedConceptsOptions builder
     */
    public Builder treeLayout(Boolean treeLayout) {
      this.treeLayout = treeLayout;
      return this;
    }

    /**
     * Set the maxDepth.
     *
     * @param maxDepth the maxDepth
     * @return the GetRelatedConceptsOptions builder
     */
    public Builder maxDepth(long maxDepth) {
      this.maxDepth = maxDepth;
      return this;
    }
  }

  protected GetRelatedConceptsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.corpus,
      "corpus cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.nameOrId,
      "nameOrId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.relationship,
      "relationship cannot be null");
    corpus = builder.corpus;
    nameOrId = builder.nameOrId;
    relationship = builder.relationship;
    ontology = builder.ontology;
    relationshipAttributes = builder.relationshipAttributes;
    sources = builder.sources;
    recursive = builder.recursive;
    treeLayout = builder.treeLayout;
    maxDepth = builder.maxDepth;
  }

  /**
   * New builder.
   *
   * @return a GetRelatedConceptsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the corpus.
   *
   * Corpus name or null to show all ontology relationships.
   *
   * @return the corpus
   */
  public String corpus() {
    return corpus;
  }

  /**
   * Gets the nameOrId.
   *
   * Preferred name or concept ID.
   *
   * @return the nameOrId
   */
  public String nameOrId() {
    return nameOrId;
  }

  /**
   * Gets the relationship.
   *
   * Select the relationship to retrieve.
   *
   * @return the relationship
   */
  public String relationship() {
    return relationship;
  }

  /**
   * Gets the ontology.
   *
   * The ontology that defines the cui.
   *
   * @return the ontology
   */
  public String ontology() {
    return ontology;
  }

  /**
   * Gets the relationshipAttributes.
   *
   * Select UMLS relationship attributes.  If null, all relationship attributes are returned.
   *
   * @return the relationshipAttributes
   */
  public List<String> relationshipAttributes() {
    return relationshipAttributes;
  }

  /**
   * Gets the sources.
   *
   * Select source vocabularies.  If null, concepts for all source vocabularies are returned.
   *
   * @return the sources
   */
  public List<String> sources() {
    return sources;
  }

  /**
   * Gets the recursive.
   *
   * Recursively return parents, children, broader and narrower relations.  Default is false.
   *
   * @return the recursive
   */
  public Boolean recursive() {
    return recursive;
  }

  /**
   * Gets the treeLayout.
   *
   * Generate JSON output that is compatible with a d3 tree layout.  Default is true.
   *
   * @return the treeLayout
   */
  public Boolean treeLayout() {
    return treeLayout;
  }

  /**
   * Gets the maxDepth.
   *
   * Maximum depth.  Default is 3.
   *
   * @return the maxDepth
   */
  public Long maxDepth() {
    return maxDepth;
  }
}

