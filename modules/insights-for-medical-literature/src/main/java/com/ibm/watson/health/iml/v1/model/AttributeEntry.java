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

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * AttributeEntry.
 */
public class AttributeEntry extends GenericModel {

  @SerializedName("attr_name")
  private String attrName;
  @SerializedName("data_type")
  private String dataType;
  @SerializedName("default_value")
  private String defaultValue;
  private String description;
  @SerializedName("display_name")
  private String displayName;
  @SerializedName("doc_id")
  private String docId;
  @SerializedName("field_values")
  private List<String> fieldValues;
  @SerializedName("maximum_value")
  private String maximumValue;
  @SerializedName("minimum_value")
  private String minimumValue;
  @SerializedName("multi_value")
  private Boolean multiValue;
  private String units;
  private String valueType;
  @SerializedName("possible_values")
  private List<PossibleValues> possibleValues;

  /**
   * Gets the attrName.
   *
   * @return the attrName
   */
  public String getAttrName() {
    return attrName;
  }

  /**
   * Gets the dataType.
   *
   * @return the dataType
   */
  public String getDataType() {
    return dataType;
  }

  /**
   * Gets the defaultValue.
   *
   * @return the defaultValue
   */
  public String getDefaultValue() {
    return defaultValue;
  }

  /**
   * Gets the description.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the displayName.
   *
   * @return the displayName
   */
  public String getDisplayName() {
    return displayName;
  }

  /**
   * Gets the docId.
   *
   * @return the docId
   */
  public String getDocId() {
    return docId;
  }

  /**
   * Gets the fieldValues.
   *
   * @return the fieldValues
   */
  public List<String> getFieldValues() {
    return fieldValues;
  }

  /**
   * Gets the maximumValue.
   *
   * @return the maximumValue
   */
  public String getMaximumValue() {
    return maximumValue;
  }

  /**
   * Gets the minimumValue.
   *
   * @return the minimumValue
   */
  public String getMinimumValue() {
    return minimumValue;
  }

  /**
   * Gets the multiValue.
   *
   * @return the multiValue
   */
  public Boolean isMultiValue() {
    return multiValue;
  }

  /**
   * Gets the units.
   *
   * @return the units
   */
  public String getUnits() {
    return units;
  }

  /**
   * Gets the valueType.
   *
   * @return the valueType
   */
  public String getValueType() {
    return valueType;
  }

  /**
   * Gets the possibleValues.
   *
   * @return the possibleValues
   */
  public List<PossibleValues> getPossibleValues() {
    return possibleValues;
  }

  /**
   * Sets the attrName.
   *
   * @param attrName the new attrName
   */
  public void setAttrName(final String attrName) {
    this.attrName = attrName;
  }

  /**
   * Sets the dataType.
   *
   * @param dataType the new dataType
   */
  public void setDataType(final String dataType) {
    this.dataType = dataType;
  }

  /**
   * Sets the defaultValue.
   *
   * @param defaultValue the new defaultValue
   */
  public void setDefaultValue(final String defaultValue) {
    this.defaultValue = defaultValue;
  }

  /**
   * Sets the description.
   *
   * @param description the new description
   */
  public void setDescription(final String description) {
    this.description = description;
  }

  /**
   * Sets the displayName.
   *
   * @param displayName the new displayName
   */
  public void setDisplayName(final String displayName) {
    this.displayName = displayName;
  }

  /**
   * Sets the docId.
   *
   * @param docId the new docId
   */
  public void setDocId(final String docId) {
    this.docId = docId;
  }

  /**
   * Sets the fieldValues.
   *
   * @param fieldValues the new fieldValues
   */
  public void setFieldValues(final List<String> fieldValues) {
    this.fieldValues = fieldValues;
  }

  /**
   * Sets the maximumValue.
   *
   * @param maximumValue the new maximumValue
   */
  public void setMaximumValue(final String maximumValue) {
    this.maximumValue = maximumValue;
  }

  /**
   * Sets the minimumValue.
   *
   * @param minimumValue the new minimumValue
   */
  public void setMinimumValue(final String minimumValue) {
    this.minimumValue = minimumValue;
  }

  /**
   * Sets the multiValue.
   *
   * @param multiValue the new multiValue
   */
  public void setMultiValue(final Boolean multiValue) {
    this.multiValue = multiValue;
  }

  /**
   * Sets the units.
   *
   * @param units the new units
   */
  public void setUnits(final String units) {
    this.units = units;
  }

  /**
   * Sets the valueType.
   *
   * @param valueType the new valueType
   */
  public void setValueType(final String valueType) {
    this.valueType = valueType;
  }

  /**
   * Sets the possibleValues.
   *
   * @param possibleValues the new possibleValues
   */
  public void setPossibleValues(final List<PossibleValues> possibleValues) {
    this.possibleValues = possibleValues;
  }
}

