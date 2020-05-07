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
 * MetadataFields.
 */
public class MetadataFields extends GenericModel {

  protected String corpus;
  protected String corpusDescription;
  protected Map<String, List<String>> fields;

  /**
   * Gets the corpus.
   *
   * Corpus name.
   *
   * @return the corpus
   */
  public String getCorpus() {
    return corpus;
  }

  /**
   * Gets the corpusDescription.
   *
   * Corpus description.
   *
   * @return the corpusDescription
   */
  public String getCorpusDescription() {
    return corpusDescription;
  }

  /**
   * Gets the fields.
   *
   * Metadata fields.
   *
   * @return the fields
   */
  public Map<String, List<String>> getFields() {
    return fields;
  }
}

