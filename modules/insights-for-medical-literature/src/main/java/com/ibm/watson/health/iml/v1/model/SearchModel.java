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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * SearchModel.
 */
public class SearchModel extends GenericModel {

  private String href;
  private List<RankedDocConcept> queryConcepts;
  private Long pageNumber;
  @SerializedName("get_limit")
  private Long getLimit;
  private Long totalDocumentCount;
  private List<Concept> concepts;
  private List<String> types;
  private List<Attribute> attributes;
  private List<Concept> values;
  private Map<String, Range> ranges;
  private List<Concept> typeahead;
  private Map<String, List<AggregationModel>> aggregations;
  private Map<String, List<YearAndHits>> dateHistograms;
  private List<RankedDocument> documents;
  private String cursorId;

  /**
   * Gets the href.
   *
   * @return the href
   */
  public String getHref() {
    return href;
  }

  /**
   * Gets the queryConcepts.
   *
   * @return the queryConcepts
   */
  public List<RankedDocConcept> getQueryConcepts() {
    return queryConcepts;
  }

  /**
   * Gets the pageNumber.
   *
   * @return the pageNumber
   */
  public Long getPageNumber() {
    return pageNumber;
  }

  /**
   * Gets the getLimit.
   *
   * @return the getLimit
   */
  public Long getGetLimit() {
    return getLimit;
  }

  /**
   * Gets the totalDocumentCount.
   *
   * @return the totalDocumentCount
   */
  public Long getTotalDocumentCount() {
    return totalDocumentCount;
  }

  /**
   * Gets the concepts.
   *
   * @return the concepts
   */
  public List<Concept> getConcepts() {
    return concepts;
  }

  /**
   * Gets the types.
   *
   * @return the types
   */
  public List<String> getTypes() {
    return types;
  }

  /**
   * Gets the attributes.
   *
   * @return the attributes
   */
  public List<Attribute> getAttributes() {
    return attributes;
  }

  /**
   * Gets the values.
   *
   * @return the values
   */
  public List<Concept> getValues() {
    return values;
  }

  /**
   * Gets the ranges.
   *
   * @return the ranges
   */
  public Map<String, Range> getRanges() {
    return ranges;
  }

  /**
   * Gets the typeahead.
   *
   * @return the typeahead
   */
  public List<Concept> getTypeahead() {
    return typeahead;
  }

  /**
   * Gets the aggregations.
   *
   * @return the aggregations
   */
  public Map<String, List<AggregationModel>> getAggregations() {
    return aggregations;
  }

  /**
   * Gets the dateHistograms.
   *
   * @return the dateHistograms
   */
  public Map<String, List<YearAndHits>> getDateHistograms() {
    return dateHistograms;
  }

  /**
   * Gets the documents.
   *
   * @return the documents
   */
  public List<RankedDocument> getDocuments() {
    return documents;
  }

  /**
   * Gets set of scroll IDs for processing large result sets.
   * @return
   */
	public String getCursorId() {
		return this.cursorId;
	}

	/**
	 * Sets the scroll IDs of large result sets.
	 * @param map
	 */
	public void setCursorId(String id) {
		this.cursorId = id;
	}
}

