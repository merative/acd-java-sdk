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
 * Category.
 */
public class Category extends GenericModel {

  private String name;
  private List<String> types;
  private String category;
  private Boolean onlyNegatedConcepts;

  /**
   * Gets the name.
   *
   * @return the name
   */
  public String getName() {
    return name;
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
   * Gets the category.
   *
   * @return the category
   */
  public String getCategory() {
    return category;
  }

  /**
   * Gets the onlyNegatedConcepts.
   *
   * @return the onlyNegatedConcepts
   */
  public Boolean isOnlyNegatedConcepts() {
    return onlyNegatedConcepts;
  }

  /**
   * Sets the name.
   *
   * @param name the new name
   */
  public void setName(final String name) {
    this.name = name;
  }

  /**
   * Sets the types.
   *
   * @param types the new types
   */
  public void setTypes(final List<String> types) {
    this.types = types;
  }

  /**
   * Sets the category.
   *
   * @param category the new category
   */
  public void setCategory(final String category) {
    this.category = category;
  }

  /**
   * Sets the onlyNegatedConcepts.
   *
   * @param onlyNegatedConcepts the new onlyNegatedConcepts
   */
  public void setOnlyNegatedConcepts(final Boolean onlyNegatedConcepts) {
    this.onlyNegatedConcepts = onlyNegatedConcepts;
  }
}

