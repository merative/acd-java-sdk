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
 * RankedDocument.
 */
public class RankedDocument extends GenericModel {

  private String title;
  private String documentId;
  private String corpus;
  private RankedDocLinks links;
  private List<Passage> passages;
  private Map<String, AnnotationModel> annotations;
  private Map<String, List<String>> metadata;

  /**
   * Gets the title.
   *
   * @return the title
   */
  public String getTitle() {
    return title;
  }

  /**
   * Gets the documentId.
   *
   * @return the documentId
   */
  public String getDocumentId() {
    return documentId;
  }

  /**
   * Gets the corpus.
   *
   * @return the corpus
   */
  public String getCorpus() {
    return corpus;
  }

  /**
   * Gets the links.
   *
   * @return the links
   */
  public RankedDocLinks getLinks() {
    return links;
  }

  /**
   * Gets additional metadata fields.
   *
   * @return the additional metadata fields
   */
  public Map<String, List<String>> getMetadata() {
	return metadata;
  }

  /**
   * Gets the passages.
   *
   * @return the passages
   */
  public List<Passage> getPassages() {
    return passages;
  }

  /**
   * Gets the annotations.
   *
   * @return the annotations
   */
  public Map<String, AnnotationModel> getAnnotations() {
    return annotations;
  }
}

