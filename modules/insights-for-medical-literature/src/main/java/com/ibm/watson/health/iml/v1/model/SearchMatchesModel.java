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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Object representing a corpus search match.
 */
public class SearchMatchesModel extends GenericModel {

  protected String externalId;
  protected String documentId;
  protected String parentDocumentId;
  protected String publicationName;
  protected String publicationDate;
  @SerializedName("publicationURL")
  protected String publicationUrl;
  protected List<String> authors;
  protected String title;
  protected String medlineLicense;
  protected String hrefPubMed;
  protected String hrefPmc;
  protected String hrefDoi;
  protected String pdfUrl;
  protected String referenceUrl;
  protected String highlightedTitle;
  protected String highlightedAbstract;
  protected String highlightedBody;
  protected Map<String, String> highlightedSections;
  protected Map<String, PassagesModel> passages;
  protected Map<String, AnnotationModel> annotations;

  /**
   * Gets the externalId.
   *
   * Unique identifier for matched document in corpus.
   *
   * @return the externalId
   */
  public String getExternalId() {
    return externalId;
  }

  /**
   * Gets the documentId.
   *
   * Unique identifier for matched document in corpus.
   *
   * @return the documentId
   */
  public String getDocumentId() {
    return documentId;
  }

  /**
   * Gets the parentDocumentId.
   *
   * Unique identifier for matched document parent in corpus.
   *
   * @return the parentDocumentId
   */
  public String getParentDocumentId() {
    return parentDocumentId;
  }

  /**
   * Gets the publicationName.
   *
   * Publication name for matched document in corpus.
   *
   * @return the publicationName
   */
  public String getPublicationName() {
    return publicationName;
  }

  /**
   * Gets the publicationDate.
   *
   * Publication date for matched document in corpus.
   *
   * @return the publicationDate
   */
  public String getPublicationDate() {
    return publicationDate;
  }

  /**
   * Gets the publicationUrl.
   *
   * Publication URL for matched document in corpus.
   *
   * @return the publicationUrl
   */
  public String getPublicationUrl() {
    return publicationUrl;
  }

  /**
   * Gets the authors.
   *
   * Authors of matched document in corpus.
   *
   * @return the authors
   */
  public List<String> getAuthors() {
    return authors;
  }

  /**
   * Gets the title.
   *
   * Title of matched document in corpus.
   *
   * @return the title
   */
  public String getTitle() {
    return title;
  }

  /**
   * Gets the medlineLicense.
   *
   * Usage license for matched document in corpus.
   *
   * @return the medlineLicense
   */
  public String getMedlineLicense() {
    return medlineLicense;
  }

  /**
   * Gets the hrefPubMed.
   *
   * Pubmed link for matched document in corpus.
   *
   * @return the hrefPubMed
   */
  public String getHrefPubMed() {
    return hrefPubMed;
  }

  /**
   * Gets the hrefPmc.
   *
   * @return the hrefPmc
   */
  public String getHrefPmc() {
    return hrefPmc;
  }

  /**
   * Gets the hrefDoi.
   *
   * @return the hrefDoi
   */
  public String getHrefDoi() {
    return hrefDoi;
  }

  /**
   * Gets the pdfUrl.
   *
   * Link to PDF for matched document in corpus.
   *
   * @return the pdfUrl
   */
  public String getPdfUrl() {
    return pdfUrl;
  }

  /**
   * Gets the referenceUrl.
   *
   * Link to sourc origin for matched document in corpus.
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
   * Gets the highlightedSections.
   *
   * Matched document sections with annotation tags.
   *
   * @return the highlightedSections
   */
  public Map<String, String> getHighlightedSections() {
    return highlightedSections;
  }

  /**
   * Gets the passages.
   *
   * Matched document passages with annotation tags.
   *
   * @return the passages
   */
  public Map<String, PassagesModel> getPassages() {
    return passages;
  }

  /**
   * Gets the annotations.
   *
   * Matched document annotations.
   *
   * @return the annotations
   */
  public Map<String, AnnotationModel> getAnnotations() {
    return annotations;
  }
}

