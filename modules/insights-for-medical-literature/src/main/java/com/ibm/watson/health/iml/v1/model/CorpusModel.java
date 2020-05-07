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
 * Object representing a configured corpus.
 */
public class CorpusModel extends GenericModel {

  protected String corpusName;
  protected List<String> ontologies;
  protected String descriptiveName;
  protected Boolean bvt;
  protected String elasticsearchIndex;

  /**
   * Gets the corpusName.
   *
   * Name of the corpus.
   *
   * @return the corpusName
   */
  public String getCorpusName() {
    return corpusName;
  }

  /**
   * Gets the ontologies.
   *
   * Ontologies found in the corpus.
   *
   * @return the ontologies
   */
  public List<String> getOntologies() {
    return ontologies;
  }

  /**
   * Gets the descriptiveName.
   *
   * Descriptive name of the corpus.
   *
   * @return the descriptiveName
   */
  public String getDescriptiveName() {
    return descriptiveName;
  }

  /**
   * Gets the bvt.
   *
   * BVT status of the corpus.
   *
   * @return the bvt
   */
  public Boolean isBvt() {
    return bvt;
  }

  /**
   * Gets the elasticsearchIndex.
   *
   * Repository location of the corpus.
   *
   * @return the elasticsearchIndex
   */
  public String getElasticsearchIndex() {
    return elasticsearchIndex;
  }
}

