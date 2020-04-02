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
import java.util.Map;

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import com.ibm.cloud.sdk.core.util.Validator;

/**
 * The setCorpusSchema options.
 */
public class SetCorpusSchemaOptions extends GenericModel {

  private String userName;
  private String password;
  private String corpusURI;
  private List<EnrichmentTarget> enrichmentTargets;
  private List<MetadataField> metadataFields;
  private String corpusName;
  private Map<String, String> references;

  /**
   * Builder.
   */
  public static class Builder {
    private String userName;
    private String password;
    private String corpusURI;
    private List<EnrichmentTarget> enrichmentTargets;
    private List<MetadataField> metadataFields;
    private String corpusName;
    private Map<String, String> references;

    private Builder(SetCorpusSchemaOptions setCorpusSchemaOptions) {
      this.userName = setCorpusSchemaOptions.userName;
      this.password = setCorpusSchemaOptions.password;
      this.corpusURI = setCorpusSchemaOptions.corpusURI;
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
     * @return the setCorpusSchemaOptions
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
    public Builder addEnrichmentTargets(
    		List<EnrichmentTarget> enrichmentTargets) {
      Validator.notNull(enrichmentTargets, "enrichmentTargets cannot be null");
      if (this.enrichmentTargets == null) {
        this.enrichmentTargets = new ArrayList<EnrichmentTarget>();
      }
      this.enrichmentTargets.addAll(enrichmentTargets);
      return this;
    }

    /**
     * Adds an metadataFields to metadataFields.
     *
     * @param metadataFields the new metadataFields
     * @return the SetCorpusSchemaOptions builder
     */
    public Builder addMetadataFields(List<MetadataField> metadataFields) {
      Validator.notNull(metadataFields, "metadataFields cannot be null");
      if (this.metadataFields == null) {
        this.metadataFields = new ArrayList<MetadataField>();
      }
      this.metadataFields.addAll(metadataFields);
      return this;
    }

    /**
     * Set the userName.
     *
     * @param userName the userName
     * @return the SetCorpusSchemaOptions builder
     */
    public Builder userName(String userName) {
      this.userName = userName;
      return this;
    }

    /**
     * Set the password.
     *
     * @param password the password
     * @return the SetCorpusSchemaOptions builder
     */
    public Builder password(String password) {
      this.password = password;
      return this;
    }

    /**
     * Set the corpusURI.
     *
     * @param corpusURI the corpusURI
     * @return the SetCorpusSchemaOptions builder
     */
    public Builder corpusURI(String corpusURI) {
      this.corpusURI = corpusURI;
      return this;
    }

    /**
     * Set the enrichmentTargets.
     * Existing enrichmentTargets will be replaced.
     *
     * @param enrichmentTargets the enrichmentTargets
     * @return the SetCorpusSchemaOptions builder
     */
    public Builder enrichmentTargets(List<EnrichmentTarget> enrichmentTargets) {
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
    public Builder metadataFields(List<MetadataField> metadataFields) {
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
    public Builder references(Map<String, String> references) {
      this.references = references;
      return this;
    }
  }

  private SetCorpusSchemaOptions(Builder builder) {
    userName = builder.userName;
    password = builder.password;
    corpusURI = builder.corpusURI;
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
   * Gets the userName.
   *
   * Repository connection userid.
   *
   * @return the userName
   */
  public String userName() {
    return userName;
  }

  /**
   * Gets the password.
   *
   * Repository connection password.
   *
   * @return the password
   */
  public String password() {
    return password;
  }

  /**
   * Gets the corpusURI.
   *
   * Repository connection URI.
   *
   * @return the corpusURI
   */
  public String corpusURI() {
    return corpusURI;
  }

  /**
   * Gets the enrichmentTargets.
   *
   * Input and Output field names.
   *
   * @return the enrichmentTargets
   */
  public List<EnrichmentTarget> enrichmentTargets() {
    return enrichmentTargets;
  }

  /**
   * Gets the metadataFields.
   *
   * Metadata field names.
   *
   * @return the metadataFields
   */
  public List<MetadataField> metadataFields() {
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
  public Map<String, String> references() {
    return references;
  }
}

