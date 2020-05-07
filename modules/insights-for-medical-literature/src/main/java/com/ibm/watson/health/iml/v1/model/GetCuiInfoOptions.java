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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The getCuiInfo options.
 */
public class GetCuiInfoOptions extends GenericModel {

  protected String corpus;
  protected String nameOrId;
  protected String ontology;
  protected String fields;
  protected Boolean treeLayout;

  /**
   * Builder.
   */
  public static class Builder {
    private String corpus;
    private String nameOrId;
    private String ontology;
    private String fields;
    private Boolean treeLayout;

    private Builder(GetCuiInfoOptions getCuiInfoOptions) {
      this.corpus = getCuiInfoOptions.corpus;
      this.nameOrId = getCuiInfoOptions.nameOrId;
      this.ontology = getCuiInfoOptions.ontology;
      this.fields = getCuiInfoOptions.fields;
      this.treeLayout = getCuiInfoOptions.treeLayout;
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
     */
    public Builder(String corpus, String nameOrId) {
      this.corpus = corpus;
      this.nameOrId = nameOrId;
    }

    /**
     * Builds a GetCuiInfoOptions.
     *
     * @return the new GetCuiInfoOptions instance
     */
    public GetCuiInfoOptions build() {
      return new GetCuiInfoOptions(this);
    }

    /**
     * Set the corpus.
     *
     * @param corpus the corpus
     * @return the GetCuiInfoOptions builder
     */
    public Builder corpus(String corpus) {
      this.corpus = corpus;
      return this;
    }

    /**
     * Set the nameOrId.
     *
     * @param nameOrId the nameOrId
     * @return the GetCuiInfoOptions builder
     */
    public Builder nameOrId(String nameOrId) {
      this.nameOrId = nameOrId;
      return this;
    }

    /**
     * Set the ontology.
     *
     * @param ontology the ontology
     * @return the GetCuiInfoOptions builder
     */
    public Builder ontology(String ontology) {
      this.ontology = ontology;
      return this;
    }

    /**
     * Set the fields.
     *
     * @param fields the fields
     * @return the GetCuiInfoOptions builder
     */
    public Builder fields(String fields) {
      this.fields = fields;
      return this;
    }

    /**
     * Set the treeLayout.
     *
     * @param treeLayout the treeLayout
     * @return the GetCuiInfoOptions builder
     */
    public Builder treeLayout(Boolean treeLayout) {
      this.treeLayout = treeLayout;
      return this;
    }
  }

  protected GetCuiInfoOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.corpus,
      "corpus cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.nameOrId,
      "nameOrId cannot be empty");
    corpus = builder.corpus;
    nameOrId = builder.nameOrId;
    ontology = builder.ontology;
    fields = builder.fields;
    treeLayout = builder.treeLayout;
  }

  /**
   * New builder.
   *
   * @return a GetCuiInfoOptions builder
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
   * Gets the fields.
   *
   * Comma separated list of fields to return: preferredName, semanticTypes, surfaceForms, typeahead, variants,
   * definition.  Defaults to all fields.
   *
   * @return the fields
   */
  public String fields() {
    return fields;
  }

  /**
   * Gets the treeLayout.
   *
   * Generate JSON output that is compatible with a d3 tree layout.  Default is false.
   *
   * @return the treeLayout
   */
  public Boolean treeLayout() {
    return treeLayout;
  }
}

