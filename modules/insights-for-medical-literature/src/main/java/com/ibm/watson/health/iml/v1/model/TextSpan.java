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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Objeft representing a document text span.
 */
public class TextSpan extends GenericModel {

  protected String section;
  protected Long begin;
  protected Long end;
  protected String coveredText;
  protected String source;
  protected String type;

  /**
   * Gets the section.
   *
   * Document section where artifact was found.
   *
   * @return the section
   */
  public String getSection() {
    return section;
  }

  /**
   * Gets the begin.
   *
   * Start of text span.
   *
   * @return the begin
   */
  public Long getBegin() {
    return begin;
  }

  /**
   * Gets the end.
   *
   * End of text span.
   *
   * @return the end
   */
  public Long getEnd() {
    return end;
  }

  /**
   * Gets the coveredText.
   *
   * Covered text span.
   *
   * @return the coveredText
   */
  public String getCoveredText() {
    return coveredText;
  }

  /**
   * Gets the source.
   *
   * Documemnt provider.
   *
   * @return the source
   */
  public String getSource() {
    return source;
  }

  /**
   * Gets the type.
   *
   * Text span type.
   *
   * @return the type
   */
  public String getType() {
    return type;
  }
}

