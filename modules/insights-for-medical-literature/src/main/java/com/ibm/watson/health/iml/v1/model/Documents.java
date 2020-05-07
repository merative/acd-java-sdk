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
 * Documents.
 */
public class Documents extends GenericModel {

  private Long limit;
  private Long offset;
  private List<String> metadata;
  private SortEntry[] sort;

  public Documents() {

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
   * Gets the offset.
   *
   * @return the offset
   */
  public Long getOffset() {
    return offset;
  }

  /**
   * Get the specified metadata options.
   *
   * @return the metadata list
   */
  public List<String> getMetadata() {
	  return metadata;
  }

  /**
   * Get the sort directive.
   * @return the sort directive
   */
  public SortEntry[] getSort() {
	  return sort;
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
   * Sets the offset.
   *
   * @param offset the new offset
   */
  public void setOffset(final long offset) {
    this.offset = offset;
  }

  /**
   * Set the names of the metadata field to be returned.
   *
   * @param metadata field list
   */
  public void setMetadata(List<String> metadata) {
	  this.metadata = metadata;
  }

  /**
   * Set the sort directive(s).
   * @param sortEntries sort directives
   */
  public void setSort(SortEntry[] sortEntries) {
	  sort = sortEntries;
  }
}

