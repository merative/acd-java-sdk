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
 * The setCorpusSchema options.
 */
public class SetCorpusSchemaOptions extends GenericModel {

  protected List<Object> enrichmentTargets;
  protected List<Object> metadataFields;
  protected String corpusName;
  protected Map<String, Object> references;

  /**
   * Builder.
   */
  public static class Builder {
    private List<Object> enrichmentTargets;
    private List<Object> metadataFields;
    private String corpusName;
    private Map<String, Object> references;

    private Builder(SetCorpusSchemaOptions setCorpusSchemaOptions) {
      this.enrichmentTargets = setCorpusSchemaOptions.enrichmentTargets;
      this.metadataFields = setCorpusSchemaOptions.metadataFields;
      this.corpusName = setCorpusSchemaOptions.corpusName;
      this.references = setCorpusSchemaOptions.references;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a SetCorpusSchemaOptions.
     *
     * @return the new SetCorpusSchemaOptions instance
     */
    public SetCorpusSchemaOptions build() {
      return new SetCorpusSchemaOptions(this);
    }

    /**
     * Adds an enrichmentTargets to enrichmentTargets.
     *
     * @param enrichmentTargets the new enrichmentTargets
     * @return the SetCorpusSchemaOptions builder
     */
    public Builder addEnrichmentTargets(Object enrichmentTargets) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(enrichmentTargets,
        "enrichmentTargets cannot be null");
      if (this.enrichmentTargets == null) {
        this.enrichmentTargets = new ArrayList<Object>();
      }
      this.enrichmentTargets.add(enrichmentTargets);
      return this;
    }

    /**
     * Adds an metadataFields to metadataFields.
     *
     * @param metadataFields the new metadataFields
     * @return the SetCorpusSchemaOptions builder
     */
    public Builder addMetadataFields(Object metadataFields) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(metadataFields,
        "metadataFields cannot be null");
      if (this.metadataFields == null) {
        this.metadataFields = new ArrayList<Object>();
      }
      this.metadataFields.add(metadataFields);
      return this;
    }

    /**
     * Set the enrichmentTargets.
     * Existing enrichmentTargets will be replaced.
     *
     * @param enrichmentTargets the enrichmentTargets
     * @return the SetCorpusSchemaOptions builder
     */
    public Builder enrichmentTargets(List<Object> enrichmentTargets) {
      this.enrichmentTargets = enrichmentTargets;
      return this;
    }

    /**
     * Set the metadataFields.
     * Existing metadataFields will be replaced.
     *
     * @param metadataFields the metadataFields
     * @return the SetCorpusSchemaOptions builder
     */
    public Builder metadataFields(List<Object> metadataFields) {
      this.metadataFields = metadataFields;
      return this;
    }

    /**
     * Set the corpusName.
     *
     * @param corpusName the corpusName
     * @return the SetCorpusSchemaOptions builder
     */
    public Builder corpusName(String corpusName) {
      this.corpusName = corpusName;
      return this;
    }

    /**
     * Set the references.
     *
     * @param references the references
     * @return the SetCorpusSchemaOptions builder
     */
    public Builder references(Map<String, Object> references) {
      this.references = references;
      return this;
    }
  }

  protected SetCorpusSchemaOptions(Builder builder) {
    enrichmentTargets = builder.enrichmentTargets;
    metadataFields = builder.metadataFields;
    corpusName = builder.corpusName;
    references = builder.references;
  }

  /**
   * New builder.
   *
   * @return a SetCorpusSchemaOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the enrichmentTargets.
   *
   * Input and Output field names.
   *
   * @return the enrichmentTargets
   */
  public List<Object> enrichmentTargets() {
    return enrichmentTargets;
  }

  /**
   * Gets the metadataFields.
   *
   * Metadata field names.
   *
   * @return the metadataFields
   */
  public List<Object> metadataFields() {
    return metadataFields;
  }

  /**
   * Gets the corpusName.
   *
   * Corpus name.
   *
   * @return the corpusName
   */
  public String corpusName() {
    return corpusName;
  }

  /**
   * Gets the references.
   *
   * Reference indices.
   *
   * @return the references
   */
  public Map<String, Object> references() {
    return references;
  }
}

