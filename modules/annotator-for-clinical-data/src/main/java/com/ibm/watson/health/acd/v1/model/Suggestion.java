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
package com.ibm.watson.health.acd.v1.model;

import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

public class Suggestion extends GenericModel {

  private Boolean appliedType;
  private Double confidenceType;
  private List<String> semtypesType;
  private String textType;

  /**
   * Gets the applied field.
   *
   * @return the applied field
   */
  public Boolean getApplied() {
    return appliedType;
  }

  /**
   * Gets the confidence field.
   *
   * @return the confidence field
   */
  public Double getConfidence() {
    return confidenceType;
  }

  /**
   * Gets the semtypes field.
   *
   * @return the semtypes field
   */
  public List<String> getSemtypes() {
    return semtypesType;
  }

  /**
   * Gets the text field.
   *
   * @return the text field
   */
  public String getText() {
    return textType;
  }

//  /**
//   * Sets the applied field.
//   *
//   * @param applied the new applied field
//   */
//  public void setApplied(final Boolean applied) {
//    this.put("applied", applied);
//  }
//
//  /**
//   * Sets the confidence field.
//   *
//   * @param confidence the new confidence field
//   */
//  public void setConfidence(final Double confidence) {
//    this.put("confidence", confidence);
//  }
//
//  /**
//   * Sets the semtypes field.
//   *
//   * @param semtypes the new semtypes field
//   */
//  public void setSemtypes(final List<String> semtypes) {
//    this.put("semtypes", semtypes);
//  }
//
//  /**
//   * Sets the text field.
//   *
//   * @param text the new text field
//   */
//  public void setText(final String text) {
//    this.put("text", text);
//  }


}
