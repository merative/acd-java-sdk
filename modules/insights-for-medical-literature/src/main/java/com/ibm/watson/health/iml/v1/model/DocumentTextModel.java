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
 * DocumentTextModel.
 */
public class DocumentTextModel extends GenericModel {

  private String title;
  private Map<String, List<String>> metadata;
  private Map<String, String> sections;

  /**
   * Gets the title.
   *
   * @return the title
   */
  public String getTitle() {
    return title;
  }

  /**
   * Gets the metadata.
   *
   * @return the metadata
   */
  public Map<String, List<String>> getMetadata() {
    return metadata;
  }

  /**
   * Gets the text sections.
   *
   * @return the text sections
   */
  public Map<String, String> getSections() {
    return sections;
  }
}

