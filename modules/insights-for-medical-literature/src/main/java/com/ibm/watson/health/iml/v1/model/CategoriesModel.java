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

import java.util.Map;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * CategoriesModel.
 */
public class CategoriesModel extends GenericModel {

  private String license;
  private String highlightedTitle;
  private String highlightedAbstract;
  private String highlightedBody;
  private Map<String, Map<String, Entry>> passages;
  private Map<String, AnnotationModel> annotations;

  /**
   * Gets the license.
   *
   * @return the license
   */
  public String getLicense() {
    return license;
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

