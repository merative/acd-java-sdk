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

import java.util.Map;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Model representing ontology categories.
 */
public class CategoriesModel extends GenericModel {

  protected String modelLicense;
  protected String highlightedTitle;
  protected String highlightedAbstract;
  protected String highlightedBody;
  protected Map<String, String> highlightedSections;
  protected Map<String, PassagesModel> passages;
  protected Map<String, AnnotationModel> annotations;

  /**
   * Builder.
   */
  public static class Builder {
    private String modelLicense;
    private String highlightedTitle;
    private String highlightedAbstract;
    private String highlightedBody;
    private Map<String, String> highlightedSections;
    private Map<String, PassagesModel> passages;
    private Map<String, AnnotationModel> annotations;

    private Builder(CategoriesModel categoriesModel) {
      this.modelLicense = categoriesModel.modelLicense;
      this.highlightedTitle = categoriesModel.highlightedTitle;
      this.highlightedAbstract = categoriesModel.highlightedAbstract;
      this.highlightedBody = categoriesModel.highlightedBody;
      this.highlightedSections = categoriesModel.highlightedSections;
      this.passages = categoriesModel.passages;
      this.annotations = categoriesModel.annotations;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a CategoriesModel.
     *
     * @return the new CategoriesModel instance
     */
    public CategoriesModel build() {
      return new CategoriesModel(this);
    }

    /**
     * Set the modelLicense.
     *
     * @param modelLicense the modelLicense
     * @return the CategoriesModel builder
     */
    public Builder modelLicense(String modelLicense) {
      this.modelLicense = modelLicense;
      return this;
    }

    /**
     * Set the highlightedTitle.
     *
     * @param highlightedTitle the highlightedTitle
     * @return the CategoriesModel builder
     */
    public Builder highlightedTitle(String highlightedTitle) {
      this.highlightedTitle = highlightedTitle;
      return this;
    }

    /**
     * Set the highlightedAbstract.
     *
     * @param highlightedAbstract the highlightedAbstract
     * @return the CategoriesModel builder
     */
    public Builder highlightedAbstract(String highlightedAbstract) {
      this.highlightedAbstract = highlightedAbstract;
      return this;
    }

    /**
     * Set the highlightedBody.
     *
     * @param highlightedBody the highlightedBody
     * @return the CategoriesModel builder
     */
    public Builder highlightedBody(String highlightedBody) {
      this.highlightedBody = highlightedBody;
      return this;
    }

    /**
     * Set the highlightedSections.
     *
     * @param highlightedSections the highlightedSections
     * @return the CategoriesModel builder
     */
    public Builder highlightedSections(Map<String, String> highlightedSections) {
      this.highlightedSections = highlightedSections;
      return this;
    }

    /**
     * Set the passages.
     *
     * @param passages the passages
     * @return the CategoriesModel builder
     */
    public Builder passages(Map<String, PassagesModel> passages) {
      this.passages = passages;
      return this;
    }

    /**
     * Set the annotations.
     *
     * @param annotations the annotations
     * @return the CategoriesModel builder
     */
    public Builder annotations(Map<String, AnnotationModel> annotations) {
      this.annotations = annotations;
      return this;
    }
  }

  protected CategoriesModel(Builder builder) {
    modelLicense = builder.modelLicense;
    highlightedTitle = builder.highlightedTitle;
    highlightedAbstract = builder.highlightedAbstract;
    highlightedBody = builder.highlightedBody;
    highlightedSections = builder.highlightedSections;
    passages = builder.passages;
    annotations = builder.annotations;
  }

  /**
   * New builder.
   *
   * @return a CategoriesModel builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the modelLicense.
   *
   * License for corpus.
   *
   * @return the modelLicense
   */
  public String modelLicense() {
    return modelLicense;
  }

  /**
   * Gets the highlightedTitle.
   *
   * @return the highlightedTitle
   */
  public String highlightedTitle() {
    return highlightedTitle;
  }

  /**
   * Gets the highlightedAbstract.
   *
   * @return the highlightedAbstract
   */
  public String highlightedAbstract() {
    return highlightedAbstract;
  }

  /**
   * Gets the highlightedBody.
   *
   * @return the highlightedBody
   */
  public String highlightedBody() {
    return highlightedBody;
  }

  /**
   * Gets the highlightedSections.
   *
   * Document sections with annotation tags.
   *
   * @return the highlightedSections
   */
  public Map<String, String> highlightedSections() {
    return highlightedSections;
  }

  /**
   * Gets the passages.
   *
   * Document passages with annotation tags.
   *
   * @return the passages
   */
  public Map<String, PassagesModel> passages() {
    return passages;
  }

  /**
   * Gets the annotations.
   *
   * List of document annotations.
   *
   * @return the annotations
   */
  public Map<String, AnnotationModel> annotations() {
    return annotations;
  }
}

