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
 * AttributeEntry.
 */
public class AttributeEntry extends GenericModel {

  @SerializedName("attr_name")
  protected String attrName;
  @SerializedName("data_type")
  protected String dataType;
  @SerializedName("default_value")
  protected String defaultValue;
  protected String description;
  @SerializedName("display_name")
  protected String displayName;
  @SerializedName("doc_id")
  protected String docId;
  @SerializedName("field_values")
  protected List<String> fieldValues;
  @SerializedName("maximum_value")
  protected String maximumValue;
  @SerializedName("minimum_value")
  protected String minimumValue;
  @SerializedName("multi_value")
  protected Boolean multiValue;
  protected String units;
  protected String valueType;
  @SerializedName("possible_values")
  protected List<PossibleValues> possibleValues;

  /**
   * Builder.
   */
  public static class Builder {
    private String attrName;
    private String dataType;
    private String defaultValue;
    private String description;
    private String displayName;
    private String docId;
    private List<String> fieldValues;
    private String maximumValue;
    private String minimumValue;
    private Boolean multiValue;
    private String units;
    private String valueType;
    private List<PossibleValues> possibleValues;

    private Builder(AttributeEntry attributeEntry) {
      this.attrName = attributeEntry.attrName;
      this.dataType = attributeEntry.dataType;
      this.defaultValue = attributeEntry.defaultValue;
      this.description = attributeEntry.description;
      this.displayName = attributeEntry.displayName;
      this.docId = attributeEntry.docId;
      this.fieldValues = attributeEntry.fieldValues;
      this.maximumValue = attributeEntry.maximumValue;
      this.minimumValue = attributeEntry.minimumValue;
      this.multiValue = attributeEntry.multiValue;
      this.units = attributeEntry.units;
      this.valueType = attributeEntry.valueType;
      this.possibleValues = attributeEntry.possibleValues;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a AttributeEntry.
     *
     * @return the new AttributeEntry instance
     */
    public AttributeEntry build() {
      return new AttributeEntry(this);
    }

    /**
     * Adds an fieldValues to fieldValues.
     *
     * @param fieldValues the new fieldValues
     * @return the AttributeEntry builder
     */
    public Builder addFieldValues(String fieldValues) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(fieldValues,
        "fieldValues cannot be null");
      if (this.fieldValues == null) {
        this.fieldValues = new ArrayList<String>();
      }
      this.fieldValues.add(fieldValues);
      return this;
    }

    /**
     * Adds an possibleValues to possibleValues.
     *
     * @param possibleValues the new possibleValues
     * @return the AttributeEntry builder
     */
    public Builder addPossibleValues(PossibleValues possibleValues) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(possibleValues,
        "possibleValues cannot be null");
      if (this.possibleValues == null) {
        this.possibleValues = new ArrayList<PossibleValues>();
      }
      this.possibleValues.add(possibleValues);
      return this;
    }

    /**
     * Set the attrName.
     *
     * @param attrName the attrName
     * @return the AttributeEntry builder
     */
    public Builder attrName(String attrName) {
      this.attrName = attrName;
      return this;
    }

    /**
     * Set the dataType.
     *
     * @param dataType the dataType
     * @return the AttributeEntry builder
     */
    public Builder dataType(String dataType) {
      this.dataType = dataType;
      return this;
    }

    /**
     * Set the defaultValue.
     *
     * @param defaultValue the defaultValue
     * @return the AttributeEntry builder
     */
    public Builder defaultValue(String defaultValue) {
      this.defaultValue = defaultValue;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the AttributeEntry builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the displayName.
     *
     * @param displayName the displayName
     * @return the AttributeEntry builder
     */
    public Builder displayName(String displayName) {
      this.displayName = displayName;
      return this;
    }

    /**
     * Set the docId.
     *
     * @param docId the docId
     * @return the AttributeEntry builder
     */
    public Builder docId(String docId) {
      this.docId = docId;
      return this;
    }

    /**
     * Set the fieldValues.
     * Existing fieldValues will be replaced.
     *
     * @param fieldValues the fieldValues
     * @return the AttributeEntry builder
     */
    public Builder fieldValues(List<String> fieldValues) {
      this.fieldValues = fieldValues;
      return this;
    }

    /**
     * Set the maximumValue.
     *
     * @param maximumValue the maximumValue
     * @return the AttributeEntry builder
     */
    public Builder maximumValue(String maximumValue) {
      this.maximumValue = maximumValue;
      return this;
    }

    /**
     * Set the minimumValue.
     *
     * @param minimumValue the minimumValue
     * @return the AttributeEntry builder
     */
    public Builder minimumValue(String minimumValue) {
      this.minimumValue = minimumValue;
      return this;
    }

    /**
     * Set the multiValue.
     *
     * @param multiValue the multiValue
     * @return the AttributeEntry builder
     */
    public Builder multiValue(Boolean multiValue) {
      this.multiValue = multiValue;
      return this;
    }

    /**
     * Set the units.
     *
     * @param units the units
     * @return the AttributeEntry builder
     */
    public Builder units(String units) {
      this.units = units;
      return this;
    }

    /**
     * Set the valueType.
     *
     * @param valueType the valueType
     * @return the AttributeEntry builder
     */
    public Builder valueType(String valueType) {
      this.valueType = valueType;
      return this;
    }

    /**
     * Set the possibleValues.
     * Existing possibleValues will be replaced.
     *
     * @param possibleValues the possibleValues
     * @return the AttributeEntry builder
     */
    public Builder possibleValues(List<PossibleValues> possibleValues) {
      this.possibleValues = possibleValues;
      return this;
    }
  }

  protected AttributeEntry(Builder builder) {
    attrName = builder.attrName;
    dataType = builder.dataType;
    defaultValue = builder.defaultValue;
    description = builder.description;
    displayName = builder.displayName;
    docId = builder.docId;
    fieldValues = builder.fieldValues;
    maximumValue = builder.maximumValue;
    minimumValue = builder.minimumValue;
    multiValue = builder.multiValue;
    units = builder.units;
    valueType = builder.valueType;
    possibleValues = builder.possibleValues;
  }

  /**
   * New builder.
   *
   * @return a AttributeEntry builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the attrName.
   *
   * @return the attrName
   */
  public String attrName() {
    return attrName;
  }

  /**
   * Gets the dataType.
   *
   * @return the dataType
   */
  public String dataType() {
    return dataType;
  }

  /**
   * Gets the defaultValue.
   *
   * @return the defaultValue
   */
  public String defaultValue() {
    return defaultValue;
  }

  /**
   * Gets the description.
   *
   * @return the description
   */
  public String description() {
    return description;
  }

  /**
   * Gets the displayName.
   *
   * @return the displayName
   */
  public String displayName() {
    return displayName;
  }

  /**
   * Gets the docId.
   *
   * @return the docId
   */
  public String docId() {
    return docId;
  }

  /**
   * Gets the fieldValues.
   *
   * @return the fieldValues
   */
  public List<String> fieldValues() {
    return fieldValues;
  }

  /**
   * Gets the maximumValue.
   *
   * @return the maximumValue
   */
  public String maximumValue() {
    return maximumValue;
  }

  /**
   * Gets the minimumValue.
   *
   * @return the minimumValue
   */
  public String minimumValue() {
    return minimumValue;
  }

  /**
   * Gets the multiValue.
   *
   * @return the multiValue
   */
  public Boolean multiValue() {
    return multiValue;
  }

  /**
   * Gets the units.
   *
   * @return the units
   */
  public String units() {
    return units;
  }

  /**
   * Gets the valueType.
   *
   * @return the valueType
   */
  public String valueType() {
    return valueType;
  }

  /**
   * Gets the possibleValues.
   *
   * @return the possibleValues
   */
  public List<PossibleValues> possibleValues() {
    return possibleValues;
  }
}

