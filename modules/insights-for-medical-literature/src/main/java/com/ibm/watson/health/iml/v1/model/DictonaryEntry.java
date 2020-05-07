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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * DictonaryEntry.
 */
public class DictonaryEntry extends GenericModel {

  protected List<String> children;
  protected String cui;
  protected List<String> definition;
  protected List<String> parents;
  protected String preferredName;
  protected List<String> semtypes;
  protected List<String> siblings;
  protected List<String> surfaceForms;
  protected List<String> variants;
  protected String vocab;
  protected List<String> related;
  protected String source;
  @SerializedName("source_version")
  protected String sourceVersion;

  /**
   * Builder.
   */
  public static class Builder {
    private List<String> children;
    private String cui;
    private List<String> definition;
    private List<String> parents;
    private String preferredName;
    private List<String> semtypes;
    private List<String> siblings;
    private List<String> surfaceForms;
    private List<String> variants;
    private String vocab;
    private List<String> related;
    private String source;
    private String sourceVersion;

    private Builder(DictonaryEntry dictonaryEntry) {
      this.children = dictonaryEntry.children;
      this.cui = dictonaryEntry.cui;
      this.definition = dictonaryEntry.definition;
      this.parents = dictonaryEntry.parents;
      this.preferredName = dictonaryEntry.preferredName;
      this.semtypes = dictonaryEntry.semtypes;
      this.siblings = dictonaryEntry.siblings;
      this.surfaceForms = dictonaryEntry.surfaceForms;
      this.variants = dictonaryEntry.variants;
      this.vocab = dictonaryEntry.vocab;
      this.related = dictonaryEntry.related;
      this.source = dictonaryEntry.source;
      this.sourceVersion = dictonaryEntry.sourceVersion;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a DictonaryEntry.
     *
     * @return the new DictonaryEntry instance
     */
    public DictonaryEntry build() {
      return new DictonaryEntry(this);
    }

    /**
     * Adds an children to children.
     *
     * @param children the new children
     * @return the DictonaryEntry builder
     */
    public Builder addChildren(String children) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(children,
        "children cannot be null");
      if (this.children == null) {
        this.children = new ArrayList<String>();
      }
      this.children.add(children);
      return this;
    }

    /**
     * Adds an definition to definition.
     *
     * @param definition the new definition
     * @return the DictonaryEntry builder
     */
    public Builder addDefinition(String definition) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(definition,
        "definition cannot be null");
      if (this.definition == null) {
        this.definition = new ArrayList<String>();
      }
      this.definition.add(definition);
      return this;
    }

    /**
     * Adds an parents to parents.
     *
     * @param parents the new parents
     * @return the DictonaryEntry builder
     */
    public Builder addParents(String parents) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(parents,
        "parents cannot be null");
      if (this.parents == null) {
        this.parents = new ArrayList<String>();
      }
      this.parents.add(parents);
      return this;
    }

    /**
     * Adds an semtypes to semtypes.
     *
     * @param semtypes the new semtypes
     * @return the DictonaryEntry builder
     */
    public Builder addSemtypes(String semtypes) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(semtypes,
        "semtypes cannot be null");
      if (this.semtypes == null) {
        this.semtypes = new ArrayList<String>();
      }
      this.semtypes.add(semtypes);
      return this;
    }

    /**
     * Adds an siblings to siblings.
     *
     * @param siblings the new siblings
     * @return the DictonaryEntry builder
     */
    public Builder addSiblings(String siblings) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(siblings,
        "siblings cannot be null");
      if (this.siblings == null) {
        this.siblings = new ArrayList<String>();
      }
      this.siblings.add(siblings);
      return this;
    }

    /**
     * Adds an surfaceForms to surfaceForms.
     *
     * @param surfaceForms the new surfaceForms
     * @return the DictonaryEntry builder
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
     * Adds an variants to variants.
     *
     * @param variants the new variants
     * @return the DictonaryEntry builder
     */
    public Builder addVariants(String variants) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(variants,
        "variants cannot be null");
      if (this.variants == null) {
        this.variants = new ArrayList<String>();
      }
      this.variants.add(variants);
      return this;
    }

    /**
     * Adds an related to related.
     *
     * @param related the new related
     * @return the DictonaryEntry builder
     */
    public Builder addRelated(String related) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(related,
        "related cannot be null");
      if (this.related == null) {
        this.related = new ArrayList<String>();
      }
      this.related.add(related);
      return this;
    }

    /**
     * Set the children.
     * Existing children will be replaced.
     *
     * @param children the children
     * @return the DictonaryEntry builder
     */
    public Builder children(List<String> children) {
      this.children = children;
      return this;
    }

    /**
     * Set the cui.
     *
     * @param cui the cui
     * @return the DictonaryEntry builder
     */
    public Builder cui(String cui) {
      this.cui = cui;
      return this;
    }

    /**
     * Set the definition.
     * Existing definition will be replaced.
     *
     * @param definition the definition
     * @return the DictonaryEntry builder
     */
    public Builder definition(List<String> definition) {
      this.definition = definition;
      return this;
    }

    /**
     * Set the parents.
     * Existing parents will be replaced.
     *
     * @param parents the parents
     * @return the DictonaryEntry builder
     */
    public Builder parents(List<String> parents) {
      this.parents = parents;
      return this;
    }

    /**
     * Set the preferredName.
     *
     * @param preferredName the preferredName
     * @return the DictonaryEntry builder
     */
    public Builder preferredName(String preferredName) {
      this.preferredName = preferredName;
      return this;
    }

    /**
     * Set the semtypes.
     * Existing semtypes will be replaced.
     *
     * @param semtypes the semtypes
     * @return the DictonaryEntry builder
     */
    public Builder semtypes(List<String> semtypes) {
      this.semtypes = semtypes;
      return this;
    }

    /**
     * Set the siblings.
     * Existing siblings will be replaced.
     *
     * @param siblings the siblings
     * @return the DictonaryEntry builder
     */
    public Builder siblings(List<String> siblings) {
      this.siblings = siblings;
      return this;
    }

    /**
     * Set the surfaceForms.
     * Existing surfaceForms will be replaced.
     *
     * @param surfaceForms the surfaceForms
     * @return the DictonaryEntry builder
     */
    public Builder surfaceForms(List<String> surfaceForms) {
      this.surfaceForms = surfaceForms;
      return this;
    }

    /**
     * Set the variants.
     * Existing variants will be replaced.
     *
     * @param variants the variants
     * @return the DictonaryEntry builder
     */
    public Builder variants(List<String> variants) {
      this.variants = variants;
      return this;
    }

    /**
     * Set the vocab.
     *
     * @param vocab the vocab
     * @return the DictonaryEntry builder
     */
    public Builder vocab(String vocab) {
      this.vocab = vocab;
      return this;
    }

    /**
     * Set the related.
     * Existing related will be replaced.
     *
     * @param related the related
     * @return the DictonaryEntry builder
     */
    public Builder related(List<String> related) {
      this.related = related;
      return this;
    }

    /**
     * Set the source.
     *
     * @param source the source
     * @return the DictonaryEntry builder
     */
    public Builder source(String source) {
      this.source = source;
      return this;
    }

    /**
     * Set the sourceVersion.
     *
     * @param sourceVersion the sourceVersion
     * @return the DictonaryEntry builder
     */
    public Builder sourceVersion(String sourceVersion) {
      this.sourceVersion = sourceVersion;
      return this;
    }
  }

  protected DictonaryEntry(Builder builder) {
    children = builder.children;
    cui = builder.cui;
    definition = builder.definition;
    parents = builder.parents;
    preferredName = builder.preferredName;
    semtypes = builder.semtypes;
    siblings = builder.siblings;
    surfaceForms = builder.surfaceForms;
    variants = builder.variants;
    vocab = builder.vocab;
    related = builder.related;
    source = builder.source;
    sourceVersion = builder.sourceVersion;
  }

  /**
   * New builder.
   *
   * @return a DictonaryEntry builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the children.
   *
   * @return the children
   */
  public List<String> children() {
    return children;
  }

  /**
   * Gets the cui.
   *
   * @return the cui
   */
  public String cui() {
    return cui;
  }

  /**
   * Gets the definition.
   *
   * @return the definition
   */
  public List<String> definition() {
    return definition;
  }

  /**
   * Gets the parents.
   *
   * @return the parents
   */
  public List<String> parents() {
    return parents;
  }

  /**
   * Gets the preferredName.
   *
   * @return the preferredName
   */
  public String preferredName() {
    return preferredName;
  }

  /**
   * Gets the semtypes.
   *
   * @return the semtypes
   */
  public List<String> semtypes() {
    return semtypes;
  }

  /**
   * Gets the siblings.
   *
   * @return the siblings
   */
  public List<String> siblings() {
    return siblings;
  }

  /**
   * Gets the surfaceForms.
   *
   * @return the surfaceForms
   */
  public List<String> surfaceForms() {
    return surfaceForms;
  }

  /**
   * Gets the variants.
   *
   * @return the variants
   */
  public List<String> variants() {
    return variants;
  }

  /**
   * Gets the vocab.
   *
   * @return the vocab
   */
  public String vocab() {
    return vocab;
  }

  /**
   * Gets the related.
   *
   * @return the related
   */
  public List<String> related() {
    return related;
  }

  /**
   * Gets the source.
   *
   * @return the source
   */
  public String source() {
    return source;
  }

  /**
   * Gets the sourceVersion.
   *
   * @return the sourceVersion
   */
  public String sourceVersion() {
    return sourceVersion;
  }
}

