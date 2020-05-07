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
//import com.ibm.cloud.sdk.core.service.model.BoolConcept;

/**
 * Passages.
 */
public class Passages extends GenericModel {

  private List<QueryConcept> conceptsToHighlight = null;
  private String searchTagBegin;
  private String searchTagEnd;
  private String relatedTagBegin;
  private String relatedTagEnd;
  private Long limit;
  private Float minScore;

  public Passages() {

  }

  /**
   * Gets the conceptsToHighlight.
   *
   * @return the searchTagBegin
   */
  public List<QueryConcept> getConceptsToHightlight() {
    return conceptsToHighlight;
  }

  /**
   * Gets the searchTagBegin.
   *
   * @return the searchTagBegin
   */
  public String getSearchTagBegin() {
    return searchTagBegin;
  }

  /**
   * Gets the searchTagEnd.
   *
   * @return the searchTagEnd
   */
  public String getSearchTagEnd() {
    return searchTagEnd;
  }

  /**
   * Gets the relatedTagBegin.
   *
   * @return the relatedTagBegin
   */
  public String getRelatedTagBegin() {
    return relatedTagBegin;
  }

  /**
   * Gets the relatedTagEnd.
   *
   * @return the relatedTagEnd
   */
  public String getRelatedTagEnd() {
    return relatedTagEnd;
  }

  /**
   * Gets the limit.
   *
   * @return the limit
   */
  public Long getLimit() {
    return limit;
  }

  /**
   * Gets the minScore.
   *
   * @return the minScore
   */
  public Float getMinScore() {
    return minScore;
  }

  /**
   * Sets the concepts to highlight.
   *
   * @param concepts the search criteria
   */
  public void setConceptsToHighlight(List<QueryConcept> concepts) {
    this.conceptsToHighlight = concepts;
  }

  /**
   * Sets the searchTagBegin.
   *
   * @param searchTagBegin the new searchTagBegin
   */
  public void setSearchTagBegin(final String searchTagBegin) {
    this.searchTagBegin = searchTagBegin;
  }

  /**
   * Sets the searchTagEnd.
   *
   * @param searchTagEnd the new searchTagEnd
   */
  public void setSearchTagEnd(final String searchTagEnd) {
    this.searchTagEnd = searchTagEnd;
  }

  /**
   * Sets the relatedTagBegin.
   *
   * @param relatedTagBegin the new relatedTagBegin
   */
  public void setRelatedTagBegin(final String relatedTagBegin) {
    this.relatedTagBegin = relatedTagBegin;
  }

  /**
   * Sets the relatedTagEnd.
   *
   * @param relatedTagEnd the new relatedTagEnd
   */
  public void setRelatedTagEnd(final String relatedTagEnd) {
    this.relatedTagEnd = relatedTagEnd;
  }

  /**
   * Sets the limit.
   *
   * @param limit the new limit
   */
  public void setLimit(final long limit) {
    this.limit = limit;
  }

  /**
   * Sets the minScore.
   *
   * @param minScore the new minScore
   */
  public void setMinScore(final Float minScore) {
    this.minScore = minScore;
  }
}
