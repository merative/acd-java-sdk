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
 * Object representing an ontology relation.
 */
public class RelationModel extends GenericModel {

  protected String relationId;
  protected String relation;
  protected TextSpan source;
  protected TextSpan target;

  /**
   * Gets the relationId.
   *
   * Relation unique identifier artifact is associated with.
   *
   * @return the relationId
   */
  public String getRelationId() {
    return relationId;
  }

  /**
   * Gets the relation.
   *
   * Name of the realtion an artifact is associated with.
   *
   * @return the relation
   */
  public String getRelation() {
    return relation;
  }

  /**
   * Gets the source.
   *
   * Objeft representing a document text span.
   *
   * @return the source
   */
  public TextSpan getSource() {
    return source;
  }

  /**
   * Gets the target.
   *
   * Objeft representing a document text span.
   *
   * @return the target
   */
  public TextSpan getTarget() {
    return target;
  }
}

