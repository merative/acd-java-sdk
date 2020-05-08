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

import java.util.List;
import java.util.Map;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Model for document metadata.
 */
public class MetadataModel extends GenericModel {

  protected Map<String, FieldOptions> fields;
  protected List<String> sectionFieldNames;
  protected List<String> attrSectionFieldNames;
  protected List<String> qualifierSectionFieldNames;
  protected List<String> meshSectionFieldNames;
  protected Map<String, String> fieldIndexMap;

  /**
   * Gets the fields.
   *
   * List of document fields in the corpus.
   *
   * @return the fields
   */
  public Map<String, FieldOptions> getFields() {
    return fields;
  }

  /**
   * Gets the sectionFieldNames.
   *
   * List of fields that where enriched.
   *
   * @return the sectionFieldNames
   */
  public List<String> getSectionFieldNames() {
    return sectionFieldNames;
  }

  /**
   * Gets the attrSectionFieldNames.
   *
   * List of fields enriched with attributes.
   *
   * @return the attrSectionFieldNames
   */
  public List<String> getAttrSectionFieldNames() {
    return attrSectionFieldNames;
  }

  /**
   * Gets the qualifierSectionFieldNames.
   *
   * List of fields enriched with attribute qualifiers.
   *
   * @return the qualifierSectionFieldNames
   */
  public List<String> getQualifierSectionFieldNames() {
    return qualifierSectionFieldNames;
  }

  /**
   * Gets the meshSectionFieldNames.
   *
   * List of fields with MeSH annotations.
   *
   * @return the meshSectionFieldNames
   */
  public List<String> getMeshSectionFieldNames() {
    return meshSectionFieldNames;
  }

  /**
   * Gets the fieldIndexMap.
   *
   * @return the fieldIndexMap
   */
  public Map<String, String> getFieldIndexMap() {
    return fieldIndexMap;
  }
}

