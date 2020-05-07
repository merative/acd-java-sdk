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
 * Object representing a match entry.
 */
public class MatchEntry extends GenericModel {

  protected Boolean negated;
  protected Float score;
  protected List<SentenceModel> sentences;
  protected String id;

  /**
   * Gets the negated.
   *
   * Whether match is a negated span.
   *
   * @return the negated
   */
  public Boolean isNegated() {
    return negated;
  }

  /**
   * Gets the score.
   *
   * Relevancy score of the match.
   *
   * @return the score
   */
  public Float getScore() {
    return score;
  }

  /**
   * Gets the sentences.
   *
   * List of sentences within the matched text.
   *
   * @return the sentences
   */
  public List<SentenceModel> getSentences() {
    return sentences;
  }

  /**
   * Gets the id.
   *
   * Unique identifier of the match.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }
}

