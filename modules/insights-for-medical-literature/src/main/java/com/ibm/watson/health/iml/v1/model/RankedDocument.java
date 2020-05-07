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
 * Object representing a document search result.
 */
public class RankedDocument extends GenericModel {

  protected String documentId;
  protected String title;
  protected Map<String, List<String>> metadata;
  protected String sectionName;
  protected String sectionId;
  protected String corpus;
  protected RankedDocLinks links;
  protected PassagesModel passages;
  protected Map<String, AnnotationModel> annotations;

  /**
   * Gets the documentId.
   *
   * Document identifier.
   *
   * @return the documentId
   */
  public String getDocumentId() {
    return documentId;
  }

  /**
   * Gets the title.
   *
   * Document title.
   *
   * @return the title
   */
  public String getTitle() {
    return title;
  }

  /**
   * Gets the metadata.
   *
   * Additional document fields.
   *
   * @return the metadata
   */
  public Map<String, List<String>> getMetadata() {
    return metadata;
  }

  /**
   * Gets the sectionName.
   *
   * Document section.
   *
   * @return the sectionName
   */
  public String getSectionName() {
    return sectionName;
  }

  /**
   * Gets the sectionId.
   *
   * Document section identifier.
   *
   * @return the sectionId
   */
  public String getSectionId() {
    return sectionId;
  }

  /**
   * Gets the corpus.
   *
   * Document corpus.
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
   * Gets the passages.
   *
   * @return the passages
   */
  public PassagesModel getPassages() {
    return passages;
  }

  /**
   * Gets the annotations.
   *
   * Document annotations.
   *
   * @return the annotations
   */
  public Map<String, AnnotationModel> getAnnotations() {
    return annotations;
  }
}

