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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Object representingn boolean concept search criteria.
 */
public class BooleanConcepts extends GenericModel {

  private String bool;
  private List<Concept> concepts;

  /**
   * Gets the bool.
   *
   * Boolean search condition.
   *
   * @return the bool
   */
  public String getBool() {
    return bool;
  }

  /**
   * Gets the concepts.
   *
   * Ontology artifacts supporing boolean search condition.
   *
   * @return the concepts
   */
  public List<Concept> getConcepts() {
    return concepts;
  }
}

