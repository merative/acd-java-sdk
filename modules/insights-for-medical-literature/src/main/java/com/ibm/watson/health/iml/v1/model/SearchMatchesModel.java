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
 * SearchMatchesModel.
 */
public class SearchMatchesModel extends GenericModel {

  private String externalId;
  private String documentId;
  private String parentDocumentId;
  private String publicationName;
  private String publicationDate;
  private String publicationURL;
  private List<String> authors;
  private String title;
  private String medlineLicense;
  private String hrefPubMed;
  private String pdfUrl;
  private String referenceUrl;
  private String highlightedTitle;
  private String highlightedAbstract;
  private String highlightedBody;
  private Map<String, Map<String, Entry>> passages;
  private Map<String, AnnotationModel> annotations;

  /**
   * Gets the externalId.
   *
   * @return the externalId
   */
  public String getExternalId() {
    return externalId;
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
   * Gets the parentDocumentId.
   *
   * @return the parentDocumentId
   */
  public String getParentDocumentId() {
    return parentDocumentId;
  }

  /**
   * Gets the publicationName.
   *
   * @return the publicationName
   */
  public String getPublicationName() {
    return publicationName;
  }

  /**
   * Gets the publicationDate.
   *
   * @return the publicationDate
   */
  public String getPublicationDate() {
    return publicationDate;
  }

  /**
   * Gets the publicationURL.
   *
   * @return the publicationURL
   */
  public String getPublicationURL() {
    return publicationURL;
  }

  /**
   * Gets the authors.
   *
   * @return the authors
   */
  public List<String> getAuthors() {
    return authors;
  }

  /**
   * Gets the title.
   *
   * @return the title
   */
  public String getTitle() {
    return title;
  }

  /**
   * Gets the medlineLicense.
   *
   * @return the medlineLicense
   */
  public String getMedlineLicense() {
    return medlineLicense;
  }

  /**
   * Gets the hrefPubMed.
   *
   * @return the hrefPubMed
   */
  public String getHrefPubMed() {
    return hrefPubMed;
  }

  /**
   * Gets the pdfUrl.
   *
   * @return the pdfUrl
   */
  public String getPdfUrl() {
    return pdfUrl;
  }

  /**
   * Gets the referenceUrl.
   *
   * @return the referenceUrl
   */
  public String getReferenceUrl() {
    return referenceUrl;
  }

  /**
   * Gets the highlightedTitle.
   *
   * @return the highlightedTitle
   */
  public String getHighlightedTitle() {
    return highlightedTitle;
  }

  /**
   * Gets the highlightedAbstract.
   *
   * @return the highlightedAbstract
   */
  public String getHighlightedAbstract() {
    return highlightedAbstract;
  }

  /**
   * Gets the highlightedBody.
   *
   * @return the highlightedBody
   */
  public String getHighlightedBody() {
    return highlightedBody;
  }

  /**
   * Gets the passages.
   *
   * @return the passages
   */
  public Map<String, Map<String, Entry>> getPassages() {
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

