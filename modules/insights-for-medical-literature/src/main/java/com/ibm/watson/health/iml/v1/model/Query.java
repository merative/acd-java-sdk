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
import java.util.Map;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Query.
 */
public class Query extends GenericModel {

  private String boolExpression;
  private List<QueryConcept> concepts;
  private Map<String, String> boolTerm;
  private Map<String, String> boolRegexp;
  private List<Map<String, String>> regexp;
  private Map<String, Range> dateRange;
  private Title title;
  private String cursorId;

  /**
   * Gets the bool.
   *
   * @return the bool
   */
  public String getBool() {
    return boolExpression;
  }

  /**
   * Gets the concepts.
   *
   * @return the concepts
   */
  public List<QueryConcept> getConcepts() {
    return concepts;
  }

  /**
   * Gets the boolTerm.
   *
   * @return the boolTerm
   */
  public Map<String, String> getBoolTerm() {
    return boolTerm;
  }

  /**
   * Gets the boolRegexp.
   *
   * @return the boolRegexp
   */
  public Map<String, String> getBoolRegexp() {
    return boolRegexp;
  }

  /**
   * Gets the regexp.
   *
   * @return the regexp
   */
  public List<Map<String, String>> getRegexp() {
    return regexp;
  }

  /**
   * Gets the dateRange.
   *
   * @return the dateRange
   */
  public Map<String, Range> getDateRange() {
    return dateRange;
  }

  /**
   * Gets the title.
   *
   * @return the title
   */
  public Title getTitle() {
    return title;
  }

  /**
   * Sets the bool.
   *
   * @param bool the new bool
   */
  public void setBool(final String bool) {
    this.boolExpression = bool;
  }

  /**
   * Sets the concepts.
   *
   * @param concepts the new concepts
   */
  public void setConcepts(final List<QueryConcept> concepts) {
    this.concepts = concepts;
  }

  /**
   * Sets the boolTerm.
   *
   * @param boolTerm the new boolTerm
   */
  public void setBoolTerm(final Map<String, String> boolTerm) {
    this.boolTerm = boolTerm;
  }

  /**
   * Sets the boolRegexp.
   *
   * @param boolRegexp the new boolRegexp
   */
  public void setBoolRegexp(final Map<String, String> boolRegexp) {
    this.boolRegexp = boolRegexp;
  }

  /**
   * Sets the regexp.
   *
   * @param regexp the new regexp
   */
  public void setRegexp(final List<Map<String, String>> regexp) {
    this.regexp = regexp;
  }

  /**
   * Sets the dateRange.
   *
   * @param dateRange the new dateRange
   */
  public void setDateRange(final Map<String, Range> dateRange) {
    this.dateRange = dateRange;
  }

  /**
   * Sets the title.
   *
   * @param title the new title
   */
  public void setTitle(final Title title) {
    this.title = title;
  }

  /**
   * Gets set of scroll IDs for processing large result sets.
   * @return scroll id
   */
	public String getCursorId() {
		return this.cursorId;
	}

	/**
	 * Sets the scroll IDs of large result sets.
	 * @param id scroll id for next batch
	 */
	public void setCursorId(String id) {
		this.cursorId = id;
	}
}

