/*
 * Copyright 2018, 2020 IBM Corp. All Rights Reserved.
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
 * Object representing a passage.
 */
public class EntryModel extends GenericModel {

  private String id;
  private Boolean negated;
  private List<SentenceModel> sentences;

  /**
   * Gets the id.
   *
   * Unique identifier of passage.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the negated.
   *
   * Whether passage is a negated span.
   *
   * @return the negated
   */
  public Boolean isNegated() {
    return negated;
  }

  /**
   * Gets the sentences.
   *
   * List of sentences within passage.
   *
   * @return the sentences
   */
  public List<SentenceModel> getSentences() {
    return sentences;
  }

  /**
   * Sets the id.
   *
   * @param id the new id
   */
  public void setId(final String id) {
    this.id = id;
  }

  /**
   * Sets the negated.
   *
   * @param negated the new negated
   */
  public void setNegated(final Boolean negated) {
    this.negated = negated;
  }

  /**
   * Sets the sentences.
   *
   * @param sentences the new sentences
   */
  public void setSentences(final List<SentenceModel> sentences) {
    this.sentences = sentences;
  }
}

