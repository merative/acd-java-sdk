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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Model representing ontology artifacts.
 */
public class DataModel extends GenericModel {

  protected List<ConceptModel> concepts;
  protected List<ConceptModel> attributeValues;
  protected List<RelationModel> relations;
  protected List<ConceptModel> mesh;
  protected List<ConceptModel> text;

  /**
   * Gets the concepts.
   *
   * List of ontolgy artifacts found in the document.
   *
   * @return the concepts
   */
  public List<ConceptModel> getConcepts() {
    return concepts;
  }

  /**
   * Gets the attributeValues.
   *
   * List of ontolgy attribute value artifacts found in the document.
   *
   * @return the attributeValues
   */
  public List<ConceptModel> getAttributeValues() {
    return attributeValues;
  }

  /**
   * Gets the relations.
   *
   * List of ontology relations found in the document.
   *
   * @return the relations
   */
  public List<RelationModel> getRelations() {
    return relations;
  }

  /**
   * Gets the mesh.
   *
   * @return the mesh
   */
  public List<ConceptModel> getMesh() {
    return mesh;
  }

  /**
   * Gets the text.
   *
   * @return the text
   */
  public List<ConceptModel> getText() {
    return text;
  }
}

